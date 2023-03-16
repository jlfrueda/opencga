import argparse
import sys
import re
import os

from rest_client_generator import RestClientGenerator

class RClientGenerator(RestClientGenerator):

    def __init__(self, server_url, output_dir):
        super().__init__(server_url, output_dir)

        self.categories = {
            'Users': 'User',
            'Projects': 'Project',
            'Studies': 'Study',
            'Files': 'File',
            'Jobs': 'Job',
            'Samples': 'Sample',
            'Individuals': 'Individual',
            'Families': 'Family',
            'Cohorts': 'Cohort',
            'Disease Panels': 'Panel',
            'Analysis - Alignment': 'Alignment',
            'Analysis - Variant': 'Variant',
            'Analysis - Clinical': 'Clinical',
            'Operations - Variant Storage': 'Operation',
            'Meta': 'Meta',
            'Cva': 'Cva',
            'GA4GH': 'GA4GH',
            'Admin': 'Admin'
        }

        # We need to remove the AllGenerics file if it already exists before appending to it
        allgenerics_file = os.path.join(self.output_dir, get_file_name_allgenerics())
        if os.path.exists(allgenerics_file):
            os.remove(allgenerics_file)

    def get_imports(self):
        text = '\n# ' + self.get_autogenerated_message()[0] + '\n#'
        text += '\n#    '.join(self.get_autogenerated_message()[1:]) + '\n'
        text += '\n'
        return text

    def get_class_definition(self, category):
        class_path_params = []
        for endpoints in category["endpoints"]:
            if "parameters" in endpoints:
                for param in endpoints["parameters"]:
                    if param["param"] == "path":
                        class_path_params.append(param["name"])
        path_params = set(class_path_params)

        # Print class description
        text = []
        text.append('# ' + '#' * 78)
        text.append("#' {}Client methods".format(self.categories[self.get_category_name(category)]))
        text.append("#' @include AllClasses.R")
        text.append("#' @include AllGenerics.R")
        text.append("#' @include commons.R\n")
        text.append("#' @description This function implements the OpenCGA calls for managing {}.\n".format(self.get_category_name(category)))
        text.append("#' The following table summarises the available *actions* for this client:\n#'")
        text.append("#' | endpointName | Endpoint WS | parameters accepted |")
        text.append("#' | -- | :-- | --: |")
        class_path_params = []
        for myEndpoint in category["endpoints"]:
            endpoint_params = []
            if "parameters" in myEndpoint:
                for param in myEndpoint["parameters"]:
                    endpoint_params.append(param['name'] + ('[*]' if param['required'] else ''))
                    if param["param"] == "path":
                        class_path_params.append(param["name"])
            text.append("#' | {} | {} | {} |".format(self.get_method_name(myEndpoint, category),
                                                       myEndpoint['path'],
                                                       ", ".join(endpoint_params)))
        path_params = set(class_path_params)
        text.append("#'\n#' @md")
        text.append("#' @seealso \\url{http://docs.opencb.org/display/opencga/Using+OpenCGA} and the RESTful API documentation")
        text.append("#' \\url{http://bioinfo.hpc.cam.ac.uk/opencga-prod/webservices/}")
        text.append("#' [*]: Required parameter")
        text.append("#' @export\n")

        # Print method
        text.append('setMethod("{}Client", "OpencgaR", function(OpencgaR, {}endpointName, params=NULL, ...) {{'.format(
            self.categories[self.get_category_name(category)].lower(),
            ', '.join(path_params) + ', ' if len(path_params) > 0 else ''))
        # text.append('{}category <- "{}"'.format(' ' * 4, self.get_category_path(category)))
        text.append('{}switch(endpointName,'.format(' ' * 4))

        # Create AllGenerics
        allgenerics_file = os.path.join(self.output_dir, get_file_name_allgenerics())
        allgenerics = open(allgenerics_file, 'a')
        text_allgenerics = []
        text_allgenerics.append('# ' + '#' * 78)
        text_allgenerics.append('## {}Client'.format(self.categories[self.get_category_name(category)]))
        text_allgenerics.append('setGeneric("{}Client", function(OpencgaR, {}endpointName, params=NULL, ...)'.format(
            self.categories[self.get_category_name(category)].lower(),
            ', '.join(path_params) + ', ' if len(path_params) > 0 else ''))
        text_allgenerics.append('{}standardGeneric("{}Client"))'.format(
            ' ' * 4, self.categories[self.get_category_name(category)].lower()))
        allgenerics.write('\n'.join(text_allgenerics) + '\n\n')
        allgenerics.close()

        print(path_params)

        return '\n'.join(text)

    def get_class_end(self):
        return ' ' * 4 + ")\n" + \
               "})"

    def get_method_definition(self, category, endpoint):

        print("Processing " + self.get_endpoint_path(endpoint))

        # Getting parameters description
        comments_text = "\n{}#' @section Endpoint {}:".format(' ' * 8, endpoint['path'])
        comments_text += "\n{}#' {}".format(' ' * 8, self.get_endpoint_description(endpoint))
        params_descriptions = []
        for param in self.parameters:
            desc = self.get_parameter_description(param)
            if self.parameters[param]['allowedValues']:
                desc += ' Allowed values: {}'.format(
                    self.get_parameter_allowed_values(param).split(','))
            params_descriptions.append("{}#' @param {} {}".format(' ' * 8, param, desc))
        params_descriptions = '\n'.join(params_descriptions)

        # Get query params
        if len(self.get_mandatory_query_params(endpoint)) > 0:
            query_params = 'c({})'.format(','.join('"{0}"'.format(w) for w in self.get_mandatory_query_params(endpoint)))
        else:
            query_params = 'NULL'

        # Method text
        text = ['{}'.format(comments_text)]
        text.append(params_descriptions)
        # append_text(text, '{}{}=fetchOpenCGA(object=OpencgaR, category=category, categoryId={}, subcategory={}, '
        #                   'subcategoryId={}, action="{}", params=params, httpMethod="{}", as.queryParam={}, ...),'.format(
        append_text(text, '{}{}=fetchOpenCGA(object=OpencgaR, category={}, categoryId={}, subcategory={}, '
                          'subcategoryId={}, action="{}", params=params, httpMethod="{}", as.queryParam={}, ...),'.format(
                   ' ' * 8,
                   self.get_method_name(endpoint, category),
                   '"{0}"'.format(self.get_endpoint_category()),
                   self.get_endpoint_id1() if self.get_endpoint_id1() else 'NULL',
                   '"{0}"'.format(self.get_endpoint_subcategory()) if self.get_endpoint_subcategory() else 'NULL',
                   self.get_endpoint_id2() if self.get_endpoint_id2() else 'NULL',
                   self.get_endpoint_action() if self.get_endpoint_action() else 'NULL',
                   self.get_endpoint_method(endpoint),
                   query_params), sep=8)


        # text.append('{}"""'.format(' ' * 8))
        # # text.append(self.format_line('{}{}'.format(' ' * 8, self.get_endpoint_description(endpoint))))
        # text.append('{}PATH: {}'.format(' ' * 8, endpoint['path']))
        # if params_descriptions:
        #     text.append('')
        #     text.append(params_descriptions)
        # text.append('{}"""'.format(' ' * 8))
        # text.append('')
        # if method_body:
        #     text += method_body
        # text.append('{}return self.{}({})'.format(' ' * 8, '_' + endpoint['method'].lower(), call_args))
        # text.append('')
        return '\n'.join(text)

    def get_file_name(self, category):
        return self.categories[self.get_category_name(category)] + "-methods.R"

    def get_method_name(self, endpoint, category):
        method_name = super().get_method_name(endpoint, category)
        # Convert to cammel case
        method_name = method_name.replace('_', ' ').title().replace(' ', '')
        return method_name[0].lower() + method_name[1:]

    def get_method_parameters(self, endpoint):
        parameters = []
        parameters.extend(self.get_path_params(endpoint))
        parameters.extend(self.get_mandatory_query_params(endpoint))

        if 'data' in self.parameters:
            parameters.append('data')

        if self.has_optional_params(endpoint):
            parameters.append('params')

        return parameters

    def get_parameter_description(self, parameter):
        if parameter != 'params':
            return super().get_parameter_description(parameter)
        else:
            return 'Map containing any additional optional parameters.'


def get_file_name_allgenerics():
    return "AllGenerics.R"


def append_text(array, string, sep):
    _append_text(array, string, sep, False)


def append_comment_text(array, string, sep):
    _append_text(array, string, sep, True)


def _append_text(array, string, sep, comment):
    if len(string) <= 120:
        array.append(string)
    else:
        my_string = string
        throw_string = None

        if 'throws' in my_string:
            pos = my_string.find('throws')
            throw_string = my_string[pos:]
            my_string = my_string[:pos - 1]

        while len(my_string) > 120:
            max = 0
            for it in re.finditer(' ', my_string):
                pos = it.start()
                if len(string[:pos]) < 120:
                    max = pos
            array.append(my_string[:max])
            text = ' ' * sep
            if comment:
                text += '*'
            text += ' ' * sep + my_string[max + 1:]
            my_string = text

        if throw_string:
            if len(my_string + ' ' + throw_string) <= 120:
                array.append(my_string + ' ' + throw_string)
            else:
                array.append(my_string)
                array.append(' ' * sep * 3 + throw_string)
        else:
            array.append(my_string)



def _setup_argparse():
    desc = 'This script creates automatically all RestClient files'
    parser = argparse.ArgumentParser(description=desc, formatter_class=argparse.ArgumentDefaultsHelpFormatter)

    parser.add_argument('server_url', help='server URL')
    parser.add_argument('output_dir', help='output directory')
    args = parser.parse_args()
    return args

def main():
    # Getting arg parameters
    args = _setup_argparse()

    client_generator = RClientGenerator(args.server_url, args.output_dir)
    client_generator.create_rest_clients()


if __name__ == '__main__':
    sys.exit(main())
