#!/usr/bin/env python3
import argparse
import os
import re
# importing date class from datetime module
from datetime import date

import sys

currentdir = os.path.dirname(os.path.realpath(__file__))
parentdir = os.path.dirname(currentdir)
print(parentdir)
sys.path.insert(0, parentdir)

import rest_client_generator


class OptionCliGenerator(rest_client_generator.RestClientGenerator):

    def __init__(self, output_dir):
        super().__init__(output_dir)

        self.java_types = set()
        self.type_imports = {
            'ObjectMap': 'org.opencb.commons.datastore.core.ObjectMap;',
            'Map': 'java.util.Map;'

        }
        self.ignore_types = [
            'Integer', 'String', 'boolean', 'int', 'Boolean'
        ]
        self.importables = set()
        self.param_types = {
            'String': 'String',
            'Map': 'Map',
            'string': 'String',
            'object': 'Object',
            'Object': 'Object',
            'integer': 'int',
            'int': 'int',
            'map': 'ObjectMap',
            'boolean': 'boolean',
            'enum': 'String',
            'long': 'Long',
            'Long': 'Long',
            'ObjectMap': 'ObjectMap',
            'java.lang.String': 'String',
            'java.lang.Boolean': 'boolean',
            'java.lang.Integer': 'int',
            'java.lang.Long': 'int',
            'java.lang.Short': 'int',
            'java.lang.Double': 'int',
            'java.lang.Float': 'int'
        }
        self.output_dir = self.options_output_dir

    def get_imports(self):
        headers = []
        headers.append('/*')
        headers.append('* Copyright 2015-{} OpenCB'.format(date.today().year))
        headers.append('*')
        headers.append('* Licensed under the Apache License, Version 2.0 (the "License");')
        headers.append('* you may not use this file except in compliance with the License.')
        headers.append('* You may obtain a copy of the License at')
        headers.append('*')
        headers.append('*     http://www.apache.org/licenses/LICENSE-2.0')
        headers.append('*')
        headers.append('* Unless required by applicable law or agreed to in writing, software')
        headers.append('* distributed under the License is distributed on an "AS IS" BASIS,')
        headers.append('* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.')
        headers.append('* See the License for the specific language governing permissions and')
        headers.append('* limitations under the License.')
        headers.append('*/')
        headers.append('')
        headers.append('package ' + self.options_package + ';')
        headers.append('')

        imports = set()
        imports.add('com.beust.jcommander.JCommander;')
        imports.add('com.beust.jcommander.Parameter;')
        imports.add('com.beust.jcommander.Parameters;')
        imports.add('com.beust.jcommander.ParametersDelegate;')
        imports.add('static org.opencb.opencga.app.cli.GeneralCliOptions.*;')

        for importable in self.importables:
            if importable in self.type_imports.keys():
                imports.add(self.type_imports[importable])

        autogenerated_message = []
        autogenerated_message.append('/*')
        for text in self.get_autogenerated_message():
            if text == '':
                autogenerated_message.append('*')
            else:
                autogenerated_message.append('* ' + text)
        autogenerated_message.append('*/')

        return '\n'.join(headers) + '\n' + '\n'.join(['import ' + i for i in imports]) + '\n\n\n' + '\n'.join(autogenerated_message)

    def get_class_definition(self, category):
        self.java_types = set()
        class_attributes = {}
        for endpoint in category["endpoints"]:
            class_attributes[endpoint["path"]] = self.get_method_name(endpoint, category)

        text = []
        text.append('')
        text.append('')
        text.append('/**')
        text.append(' * This class contains methods for the {} command line.'.format(
            self.categories[self.get_category_name(category)]))
        text.append(' *{}Command line version: {}'.format(' ' * 4, self.version))
        text.append(' *{}PATH: {}'.format(' ' * 4, self.get_category_path(category)))
        text.append(' */')
        text.append('')
        text.append(
            '@Parameters(commandNames = {{"{}"}}, commandDescription = "{} commands")'.format(self.get_category_name(
                category).lower(), self.categories[self.get_category_name(category)]))
        text.append(
            'public class {}CommandOptions {{'.format(self.categories[self.get_category_name(category)]))
        text.append('')
        text.append('{}public JCommander jCommander;'.format((' ' * 8)))
        text.append('{}public CommonCommandOptions commonCommandOptions;'.format((' ' * 8)))
        text.append('')
        for attribute in class_attributes.values():
            if self.check_not_ignored_command(category["name"], attribute.lower()):
                append_text(text,
                            '{}public {}CommandOptions {}CommandOptions;'.format((' ' * 8), self.get_as_class_name(attribute), attribute),
                            8)
        text.append('')
        text.append('')
        text.append(
            '{}public {}CommandOptions(CommonCommandOptions commonCommandOptions, JCommander jCommander) {{'.format(
                ' ' * 4, self.categories[self.get_category_name(category)]))
        text.append('{}'.format(' ' * 4))
        text.append('{}this.jCommander = jCommander;'.format(' ' * 8))

        text.append('{}this.commonCommandOptions = commonCommandOptions;'.format(' ' * 8))

        for attribute in class_attributes.values():
            if self.check_not_ignored_command(category["name"], attribute.lower()):
                append_text(text, '{}this.{}CommandOptions = new {}CommandOptions();'.format((' ' * 8), attribute,
                                                                                             self.get_as_class_name(attribute)), 8)

        text.append('{}'.format(' ' * 4))
        text.append('{}}}'.format(' ' * 4))
        text.append('{}'.format(' ' * 4))
        text.append('{}'.format(' ' * 4))
        return '\n'.join(text)

    def get_class_end(self):
        return '}\n'

    def get_method_definition(self, category, endpoint):
        method_name = self.get_method_name(endpoint, category).lower()
        if self.check_not_ignored_command(category["name"], method_name):
            parameters = self.get_method_parameters(endpoint)
            text = []
            command_name = self.to_kebab_case(self.get_method_name(endpoint, category))
            self.append_command(text, command_name,
                                self.get_endpoint_description(endpoint))
            append_text(text, '{}public class {}CommandOptions {{'.format((' ' * 4), self.get_as_class_name(self.get_method_name(endpoint,
                                                                                                                                 category))),
                        5)
            text.append('{}'.format(' ' * 4))
            text.append('{}@ParametersDelegate'.format(' ' * 8))
            text.append('{}public CommonCommandOptions commonOptions = commonCommandOptions;'.format(' ' * 8))
            text.append('{}'.format(' ' * 4))
            addedParameters = set()
            for parameter in parameters:
                name = self.normalize_names(parameter["name"])
                if parameter["name"] not in self.excluded_parameters:
                    if name not in addedParameters:
                        addedParameters.add(name)
                        if name == 'body':
                            if "data" in parameter.keys():
                                data = parameter["data"]
                                for item in data:
                                    name = self.normalize_names(item["name"])
                                    if item["name"] not in self.excluded_parameters:
                                        if name not in addedParameters:
                                            addedParameters.add(name)
                                            if name == "password" and command_name == "login":
                                                text.append(
                                                    (' ' * 8) + '@Parameter(names = {"-p", "--password"}, description = "User password", ' \
                                                                'required = true, password = true, hidden = true, arity = 1)\n' + (
                                                            ' ' * 8) + 'public String password;\n')
                                            elif str(item['type']) in self.param_types.keys():
                                                self.get_parameter_option(item, text, name, category["name"] + "#" + method_name)
                        else:
                            if parameter["name"] not in self.excluded_parameters:
                                self.get_parameter_option(parameter, text, name, category["name"] + "#" + method_name)

            text.append('{}}}'.format(' ' * 2))
            text.append('{}'.format(' ' * 2))
            text.append('{}'.format(' ' * 2))
            return '\n'.join(text)
        else:
            return '\n//excluded ' + method_name + '\n'

    def get_parameter_option(self, parameter, text, name, category):

        if self.check_ignore_subcommand(category, name):
            description = parameter["description"]
            required = parameter["required"]
            type_param = self.param_types[str(parameter['type'])]
            self.append_parameter(text, self.to_kebab_case(parameter["name"].replace('.', '-')), description,
                                  str(required).lower())
            append_text(text, '{}public {} {}; '.format((' ' * 8), type_param, name, parameter["name"]), 8)
            text.append('{}'.format(' ' * 4))
            self.importables.add(type_param)
        else:
            text.append('// Exclusion ' + name)

    def to_kebab_case(self, name):
        name = re.sub('(.)([A-Z][a-z]+)', r'\1-\2', name)
        name = re.sub('__([A-Z])', r'-\1', name)
        name = re.sub('([a-z0-9])([A-Z])', r'\1-\2', name)
        return name.lower()

    def get_file_name(self, category):
        return self.categories[self.get_category_name(category)] + "CommandOptions.java"

    def get_method_name(self, endpoint, category):
        method_name = super().get_method_name(endpoint, category)
        # Convert to cammel case
        method_name = method_name.replace('_', ' ').title().replace(' ', '')
        return method_name[0].lower() + method_name[1:]

    def get_parameter_description(self, parameter):
        return "."

    def get_method_parameters(self, endpoint):
        return endpoint["parameters"]

    def get_parameter_type(self, parameter):

        return parameter["type"]

    def append_command(self, array, name, description):
        if '"' in description:
            description = description.replace('"', '\\"')
        res = (' ' * 4) + '@Parameters(commandNames = {"' + name + '"}, commandDescription = "' + description + '")'
        if len(res) <= 140:
            array.append(res)
        else:
            res = (' ' * 4) + '@Parameters(commandNames = {"' + name + '"}, commandDescription = "'
            aux = (' ' * 4) + '@Parameter(commandNames = {"' + name + '"}, commandDescription = "'
            for word in description.split(' '):
                aux += word + ' '
                if len(aux) > 137:
                    array.append(res + '"')
                    res = (' ' * 30) + '+ "' + word + ' '
                    aux = res
                else:
                    res += word + ' '
            array.append(res[:-1] + '")')

    def check_shortcuts(self, name):
        if name in self.shortcuts:
            name = '"-' + self.shortcuts[name] + '","--' + name + '"'
        else:
            name = '"--' + name + '"'
        return name

    def append_parameter(self, array, name, description, required):
        if '"' in description:
            description = description.replace('"', '\\"')
        name = self.check_shortcuts(name);
        res = (
                      ' ' * 8) + '@Parameter(names = {' + name + '}, description = "' + description + '", required = ' + required + \
              ', arity = 1)'
        if len(res) <= 140:
            array.append(res)
        else:
            res = (' ' * 8) + '@Parameter(names = {' + name + '}, description = "'
            aux = (' ' * 8) + '@Parameter(names = {' + name + '}, description = "'
            for word in description.split(' '):
                aux += word + ' '
                if len(aux) > 137:
                    array.append(res + '"')
                    res = (' ' * 30) + '+ "' + word + ' '
                    aux = res
                else:
                    res += word + ' '

            if len(res + '", required = ' + required + ', arity = 1)') > 140:
                array.append(res[:-1] + '",')
                array.append((' ' * 30) + 'required = ' + required + ', arity = 1)')
            else:
                array.append(res[:-1] + '", required = ' + required + ', arity = 1)')

    def get_valid_parameter_type(self, my_type, my_import):
        if my_type.endswith(';'):
            my_type = my_type[:-1]

        if '$' in my_type:
            my_type = my_type.replace('$', '.')
        if '$' in my_import:
            my_import = my_import.replace('$', '.')

        if my_type == '' or my_type == 'Map':
            my_type = 'ObjectMap'
        else:
            self.type_imports[my_type] = my_import
        self.java_types.add(my_type)

        return my_type

    def normalize_names(self, name):
        res = name
        if name == "default":
            res = "defaultParam"
        if '_' in name:
            res = ''.join(word.title() for word in name.split('_'))
        if '.' in name:
            res = ''.join(word.title() for word in name.split('.'))
        res = res[0].lower() + res[1:]
        return res

    def get_as_class_name(self, attribute):
        return attribute[0].upper() + attribute[1:]

    def check_ignore_subcommand(self, param, method_name):
        res = True
        if param in self.exclude_command_params.keys() and method_name in self.exclude_command_params[param]:
            res = False
        return res


def remove_redundant_imports(imports):
    to_remove = []
    for i in range(len(imports) - 1):
        for j in range(i + 1, len(imports)):
            if imports[i][:-1] + "." in imports[j][:-1]:
                to_remove.append(imports[j])
            elif imports[j][:-1] + "." in imports[i][:-1]:
                to_remove.append(imports[i])

    for my_import in to_remove:
        imports.remove(my_import)

    return imports


def append_text(array, string, sep):
    _append_text(array, string, sep, sep, False)


def append_comment_text(array, string, sep, sep2=None):
    _append_text(array, string, sep, sep if sep2 is None else sep2, True)


def _append_text(array, string, sep, sep2, comment):
    if len(string) <= 140:
        array.append(string)
    else:
        res = ''
        for word in string.split(' '):
            res += word + ' '
            if len(res) > 140:
                array.append(res + '"+')
                res = (' ' * 30) + ' "'
        array.append(res)


def _setup_argparse():
    desc = 'This script creates automatically all RestClients files'
    parser = argparse.ArgumentParser(description=desc)

    parser.add_argument('output_dir', help='output directory')
    args = parser.parse_args()
    return args


def main():
    # Getting arg parameters
    args = _setup_argparse()
    client_generator = OptionCliGenerator(args.output_dir)
    # client_generator = JavaClientGenerator(args.server_url, args.output_dir)
    client_generator.create_rest_clients()


if __name__ == '__main__':
    sys.exit(main())
