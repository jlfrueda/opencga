import os
import re
from abc import ABC, abstractmethod
from datetime import datetime

import requests
import sys
import yaml


class RestClientGenerator(ABC):

    def __init__(self, output_dir):

        self.server_url = None
        self.options_output_dir = None
        self.output_dir = output_dir
        self.executors_output_dir = None
        self.parameters = {}
        self.category = None
        self.subcategory = None
        self.action = None
        self.id1 = None
        self.id2 = None
        self.json_response = None
        self.shortcuts = {}
        self.extended_classes = []
        self.command_names = {}
        self.endpoints = {
            'users/{user}/filters/{filterId}/update': {'method_name': 'update_filter'},
            'ga4gh/reads/{study}/{file}': {'method_name': 'fetch_reads'},
            'analysis/clinical/{clinicalAnalysis}/interpretation/{interpretationId}/merge': {'method_name': 'merge_interpretation'},
            'analysis/clinical/{clinicalAnalysis}/interpretation/{interpretationId}/update': {'method_name': 'update_interpretation'},
            'analysis/clinical/{clinicalAnalysis}/interpretation/{interpretations}/delete': {'method_name': 'delete_interpretation'}
        }
        self.extended_methods = []
        self.analysis_commands = []
        self.operations_commands = []
        self.categories = {}
        self.exclude_commands = {}
        self.exclude_command_params = {}
        self.read_yaml()
        self.json_resource = requests.get(self.server_url + '/webservices/rest/v2/meta/api').json()['responses'][0]['results'][0]

        '''
        TODO Remove in json when variable is not private 
        '''
        self.excluded_parameters = [
            'DESCRIPTION', 'CELLBASE_VERSION', 'FILE', 'CELLBASE_HOST', 'DEFAULT_FILE_POSITION_SIZE_BITS', 'RESUME', 'INPUT_COLUMNS',
            'COHORT2', 'COHORT1', 'SCORE_NAME', 'STATS_SKIP_VALUE', 'FLAGSTATS_SKIP_VALUE', 'FASTQC_METRICS_SKIP_VALUE',
            'HS_METRICS_SKIP_VALUE'
        ]

    def read_yaml(self):
        yaml_file = open("config.yaml", 'r')
        yaml_content = yaml.load(yaml_file, Loader=yaml.FullLoader)
        options = yaml_content["options"]
        if "ignore_types" in options.keys():
            self.ignore_types = options["ignore_types"]
        if "parser_package" in options.keys():
            self.parser_package = options["parser_package"]
        if "server_url" in options.keys():
            self.server_url = options["server_url"]
        self.version = requests.get(
            self.server_url + '/webservices/rest/v2/meta/about'
        ).json()['responses'][0]['results'][0]['Version'].split('-')[0]

        if "cli_output_dir" in options.keys():
            self.output_dir = options["cli_output_dir"]
        if "options_output_dir" in options.keys():
            self.options_output_dir = options["options_output_dir"]
        if "executors_output_dir" in options.keys():
            self.executors_output_dir = options["executors_output_dir"]
        if "executors_package" in options.keys():
            self.executors_package = options["executors_package"]
        if "options_package" in options.keys():
            self.options_package = options["options_package"]
        if "api" in yaml_content.keys():
            for categories in yaml_content["api"].items():
                category, data = categories
                if "command_name" in data.keys():
                    self.command_names[category] = data["command_name"]
                else:
                    self.command_names[category] = category.lower()
                if "shortcuts" in data.keys():
                    self.shortcuts = data["shortcuts"]
                if "extended" in data.keys() and data["extended"] == True:
                    self.extended_classes.append(data["key"])
                if not data["ignore"]:
                    self.categories[category] = data["key"]
                if "analysis" in data.keys() and data["analysis"]:
                    if "command_name" in data.keys():
                        self.analysis_commands.append('"' + data["command_name"].lower() + '"')
                    else:
                        self.analysis_commands.append('"' + category.lower() + '"')

                if "operations" in data.keys() and data["operations"]:
                    if "command_name" in data.keys():
                        self.operations_commands.append('"' + data["command_name"].lower() + '"')
                    else:
                        self.operations_commands.append('"' + category.lower() + '"')

                if "commands" in data.keys():
                    command_exclusions = []
                    subcommand_exclusions = []
                    for commands in data["commands"].items():
                        command, command_data = commands
                        if "extended" in command_data.keys() and command_data["extended"]:
                            self.extended_methods.append(command)
                        if "ignore" in command_data.keys() and command_data["ignore"]:
                            command_exclusions.append(command)
                        if "subcommands" in command_data.keys():
                            for subcommands in command_data["subcommands"].items():
                                subcommand, subcommand_data = subcommands
                                if subcommand_data["ignore"]:
                                    subcommand_exclusions.append(subcommand)
                            if len(subcommand_exclusions) > 0:
                                self.exclude_command_params[category + "#" + command] = subcommand_exclusions
                    if len(command_exclusions) > 0:
                        self.exclude_commands[category] = command_exclusions
        print(self.categories)

    @staticmethod
    def get_autogenerated_message():
        date_ = datetime.now().strftime("%Y-%m-%d %H:%M:%S")
        return [
            'WARNING: AUTOGENERATED CODE',
            '',
            'This code was generated by a tool.',
            'Autogenerated on: ' + date_,
            '',
            'Manual changes to this file may cause unexpected behavior in your application.',
            'Manual changes to this file will be overwritten if the code is regenerated.'
        ]

    def get_as_variable_name(self, attribute):
        return attribute[0].lower() + attribute[1:]

    def check_not_ignored_command(self, param, method_name):
        res = True
        if param in self.exclude_commands.keys() and method_name in self.exclude_commands[param]:
            res = False
        return res

    @staticmethod
    def get_category_name(category):
        return category['name']

    @staticmethod
    def get_category_path(category):
        return category['path'].replace('/{apiVersion}/', '')

    @staticmethod
    def get_endpoint_path(endpoint):
        return endpoint['path'].replace('/{apiVersion}/', '')

    @staticmethod
    def get_endpoint_description(endpoint):
        return endpoint['description'] if endpoint['description'].endswith(".") else endpoint['description'] + "."

    @staticmethod
    def get_endpoint_response(endpoint):
        return endpoint['response']

    @staticmethod
    def get_endpoint_response_class(endpoint):
        return endpoint['responseClass']

    @staticmethod
    def get_endpoint_method(endpoint):
        return endpoint['method']

    def get_path_params(self, endpoint):
        return re.findall(r'{(.*?)}', self.get_endpoint_path(endpoint))

    def get_mandatory_query_params(self, endpoint):
        path_params = self.get_path_params(endpoint)
        params = []
        for parameter in endpoint['parameters']:
            if parameter['required'] and parameter['name'] not in path_params and parameter['name'] != 'body':
                params.append(parameter['name'])
        return params

    @staticmethod
    def has_optional_params(endpoint):
        return any([parameter['required'] is False for parameter in endpoint['parameters']])

    def is_required(self, parameter):
        return self.parameters[parameter]['required']

    def is_path_param(self, parameter):
        return self.parameters[parameter]['param'] == 'path'

    def get_parameter_type(self, parameter):
        return self.parameters[parameter]['type']

    def get_parameter_type_class(self, parameter):
        return self.parameters[parameter]['typeClass']

    @staticmethod
    def get_optional_parameters(endpoint):
        params = []
        for parameter in endpoint['parameters']:
            if parameter['required'] is False and parameter['name'] != 'body':
                params.append(parameter['name'])
        return params

    def get_parameter_description(self, parameter):
        return self.parameters[parameter]['description'] if self.parameters[parameter]['description'].endswith(".") \
            else self.parameters[parameter]['description'] + "."

    def get_parameter_allowed_values(self, parameter):
        return self.parameters[parameter]['allowedValues']

    def get_endpoint_category(self):
        return self.category

    def get_endpoint_subcategory(self):
        return self.subcategory

    def get_endpoint_action(self):
        return self.action

    def get_endpoint_id1(self):
        return self.id1

    def get_endpoint_id2(self):
        return self.id2

    @staticmethod
    def any_arg(items):
        return any([True if '{' in item and '}' in item else False for item in items])

    @staticmethod
    def all_arg(items):
        return all([True if '{' in item and '}' in item else False for item in items])

    def get_method_name(self, endpoint, category):
        if self.get_endpoint_path(endpoint) in self.endpoints:
            return self.endpoints[self.get_endpoint_path(endpoint)]['method_name']

        method_name = None
        subpath = self.get_endpoint_path(endpoint).replace(self.get_category_path(category) + '/', '')
        items = subpath.split('/')
        if len(items) == 1:
            method_name = items[0]
        elif len(items) == 2:
            # e.g. /{apiVersion}/ga4gh/reads/search
            if not self.any_arg(items):
                method_name = '_'.join(items[::-1])
            # e.g. /{apiVersion}/users/{user}/info
            elif self.any_arg([items[0]]) and not self.any_arg([items[1]]):
                method_name = items[1]
        elif len(items) == 3:
            # e.g. /{apiVersion}/analysis/variant/cohort/stats/run
            if not self.any_arg(items):
                method_name = '_'.join([items[2], items[0], items[1]])
            # e.g. /{apiVersion}/users/{user}/configs/filters
            elif self.any_arg([items[0]]) and not self.any_arg([items[1:]]):
                method_name = '_'.join([items[2], items[1]])
            # e.g. /{apiVersion}/studies/acl/{members}/update
            elif self.any_arg([items[1]]) and not self.any_arg([items[0], items[2]]):
                method_name = '_'.join([items[2], items[0]])
        elif len(items) == 4:
            # e.g. /{apiVersion}/operation/variant/sample/genotype/index
            if not self.any_arg(items):
                method_name = '_'.join([items[3], items[1], items[2]])
            # /{apiVersion}/analysis/clinical/{clinicalAnalysis}/interpretation/{interpretationId}/merge
            elif self.all_arg([items[0], items[2]]) and not self.any_arg([items[1], items[3]]):
                method_name = '_'.join([items[3], items[1]])
        elif len(items) == 5:
            # e.g. /{apiVersion}/files/{file}/annotationSets/{annotationSet}/annotations/update
            if self.all_arg([items[0], items[2]]) and not self.any_arg([items[1], items[3], items[4]]):
                method_name = '_'.join([items[4], items[3]])
        if not method_name:
            raise NotImplementedError('Case not implemented for PATH: "{}"'.format(self.get_endpoint_path(endpoint)))
        return re.sub(r'(?<!^)(?=[A-Z])', '_', method_name).lower()

    @abstractmethod
    def get_imports(self):
        pass

    @abstractmethod
    def get_class_definition(self, category):
        pass

    @abstractmethod
    def get_class_end(self):
        pass

    @abstractmethod
    def get_method_definition(self, category, endpoint):
        pass

    @abstractmethod
    def get_file_name(self, category):
        pass

    def create_rest_clients(self):

        cats = list(self.categories.keys())
        for category in self.json_resource:
            if category["name"] in cats:
                text = []
                text.append(self.get_class_definition(category))

                for endpoint in category['endpoints']:
                    # We update the dictionary of parameters of the endpoint
                    self.parameters = {}
                    if self.get_endpoint_path(endpoint) != 'files/upload':
                        for parameter in endpoint['parameters']:
                            self.parameters[parameter['name'] if parameter['name'] != 'body' else 'data'] = parameter

                    # We extract the resources of the endpoint
                    self.parse_resources(category, endpoint)

                    text.append(self.get_method_definition(category, endpoint))

                text.append(self.get_class_end())
                # Now, we put in the first position the imports.
                text.insert(0, self.get_imports())

                # Choose the file name to be created
                file_name = self.get_file_name(category)
                self.LOG('Creating ' + os.path.join(self.output_dir, file_name) + '...')
                with open(os.path.join(self.output_dir, file_name), 'w') as fhand:
                    fhand.write('\n'.join(text))

    def LOG(self, log):
        sys.stderr.write(str(log) + '\n')

    def parse_resources(self, category, endpoint):
        if endpoint['path'] == '/{apiVersion}/ga4gh/reads/{study}/{file}':
            self.category = 'ga4gh/reads'
            self.id1 = 'study'
            self.id2 = 'file'
            self.subcategory = ''
            self.action = ''
        else:
            subpath = endpoint['path'].replace('/{apiVersion}/', '')
            resources = re.findall('([a-zA-Z0-9\/]+)(\/\{[a-zA-Z0-9]+\})?(\/[a-zA-Z0-9]+)?(\/\{[a-zA-Z0-9]+\})?(\/[a-zA-Z0-9\/]+)', subpath)
            if resources:
                [self.category, self.id1, self.subcategory, self.id2, self.action] = resources if type(resources[0]) != tuple else list(
                    resources[0])

            if self.id1.startswith("/"):
                self.id1 = self.id1[2:-1]
            if self.id2.startswith("/"):
                self.id2 = self.id2[2:-1]
            if self.subcategory.startswith("/"):
                self.subcategory = self.subcategory[1:]
            if self.action.startswith("/"):
                self.action = self.action[1:]

            if self.subcategory == '' and self.id1 == '' and '/' in self.category:
                self.subcategory = self.category.split('/', 1)[1]
                self.category = self.category.split('/', 1)[0]

            if self.subcategory == '' and self.id2 == '' and self.id1 != '' and '/' in self.category:
                # Move to subcategory and id2
                self.id2 = self.id1
                self.id1 = ''
                self.subcategory = self.category.split('/', 1)[1]
                self.category = self.category.split('/', 1)[0]
