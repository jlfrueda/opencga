/*
 * Copyright 2015-2020 OpenCB
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.opencb.opencga.server.json.writers.cli;

import org.opencb.opencga.server.json.beans.Category;
import org.opencb.opencga.server.json.beans.Endpoint;
import org.opencb.opencga.server.json.beans.Parameter;
import org.opencb.opencga.server.json.beans.RestApi;
import org.opencb.opencga.server.json.config.CategoryConfig;
import org.opencb.opencga.server.json.config.CommandLineConfiguration;
import org.opencb.opencga.server.json.config.Shortcut;
import org.opencb.opencga.server.json.writers.ParentClientRestApiWriter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class OptionsCliRestApiWriter extends ParentClientRestApiWriter {

    public OptionsCliRestApiWriter(RestApi restApi, CommandLineConfiguration config) {
        super(restApi, config);
    }

    @Override
    protected String getClassImports(String key) {
        StringBuilder sb = new StringBuilder();
        Category category = availableCategories.get(key);
        CategoryConfig categoryConfig = availableCategoryConfigs.get(key);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sb.append("package ").append(config.getOptions().getOptionsPackage()).append(";\n\n");
        sb.append("import com.beust.jcommander.JCommander;\n");
        sb.append("import com.beust.jcommander.Parameter;\n");
        sb.append("import com.beust.jcommander.Parameters;\n");
        sb.append("import com.beust.jcommander.ParametersDelegate;\n\n");
        sb.append("import java.util.List;\n\n");
        if (categoryConfig.isOptionExtended()) {
            sb.append("import org.opencb.opencga.app.cli.main.parent."
                    + getExtendedClass(getAsClassName(category.getName()), categoryConfig) + ";\n\n");
        }
        sb.append("import static org.opencb.opencga.app.cli.GeneralCliOptions.*;\n");
        sb.append("\n");
        sb.append("\n");
        sb.append("/*\n");
        sb.append("* WARNING: AUTOGENERATED CODE\n");
        sb.append("*\n");
        sb.append("* This code was generated by a tool.\n");
        sb.append("* Autogenerated on: ").append(sdf.format(new Date())).append("\n");
        sb.append("*\n");
        sb.append("* Manual changes to this file may cause unexpected behavior in your application.\n");
        sb.append("* Manual changes to this file will be overwritten if the code is regenerated.\n");
        sb.append("*/\n");
        sb.append("\n");
        sb.append("\n");
        sb.append("/**\n");
        sb.append(" * This class contains methods for the ").append(category.getName()).append(" command line.\n");
        sb.append(" *    OpenCGA version: ").append(restApi.getVersion()).append("\n");
        sb.append(" *    PATH: ").append(category.getPath()).append("\n");
        sb.append(" */\n");
        return sb.toString();
    }

    private String getExtendedClass(String name, CategoryConfig config) {
        String res = "OpencgaCommandExecutor";
        if (config.isExecutorExtended()) {
            res = "Parent" + name + "CommandOptions";
        }
        return res;
    }

    @Override
    protected String getClassHeader(String key) {
        Category category = availableCategories.get(key);
        CategoryConfig config = availableCategoryConfigs.get(key);
        StringBuilder sb = new StringBuilder();
        sb.append("@Parameters(commandNames = {\"" + getCategoryCommandName(category, config) + "\"}, commandDescription = \""
                + category.getName() + " commands\")\n");
        if (config.isOptionExtended()) {
            sb.append("public class " + getAsClassName(category.getName()) + "CommandOptions extends "
                    + getExtendedClass(getAsClassName(category.getName()), config) + " {\n\n");
        } else {
            sb.append("public class " + getAsClassName(category.getName()) + "CommandOptions {\n");
        }
        sb.append("\n");
        if (!config.isOptionExtended()) {
            sb.append("        public JCommander jCommander;\n");
            sb.append("        public CommonCommandOptions commonCommandOptions;\n");
            sb.append("\n");
        }
        for (Endpoint endpoint : category.getEndpoints()) {
            //If it is post, it must have parameters in the body,
            // therefore it must be different from post or have some primitive value in the body so that we can generate the method
            String commandName = getMethodName(category, endpoint).replaceAll("_", "-");
            if ((!"POST".equals(endpoint.getMethod()) || endpoint.hasPrimitiveBodyParams(config, commandName)) && endpoint.hasParameters()) {
                if (config.isAvailableCommand(commandName)) {
                    sb.append("        public " + getAsClassName(getAsCamelCase(getMethodName(category, endpoint))) + "CommandOptions "
                            + getAsVariableName(getAsCamelCase(getMethodName(category, endpoint))) + "CommandOptions;\n");
                }
            }
        }

        sb.append("\n");
        sb.append("\n");
        sb.append("    public " + getAsClassName(category.getName()) + "CommandOptions(CommonCommandOptions commonCommandOptions, " +
                "JCommander jCommander) {\n");
        sb.append("    \n");
        if (config.isOptionExtended()) {
            sb.append("        super(commonCommandOptions,jCommander);\n");
        } else {
            sb.append("        this.jCommander = jCommander;\n");
            sb.append("        this.commonCommandOptions = commonCommandOptions;\n");
        }
        for (Endpoint endpoint : category.getEndpoints()) {
            //If it is post, it must have parameters in the body,
            // therefore it must be different from post or have some primitive value in the body so that we can generate the method
            String commandName = getMethodName(category, endpoint).replaceAll("_", "-");
            if ((!"POST".equals(endpoint.getMethod()) || endpoint.hasPrimitiveBodyParams(config, commandName)) && endpoint.hasParameters()) {
                if (config.isAvailableCommand(commandName)) {

                    sb.append("        this." + getAsVariableName(getAsCamelCase(getMethodName(category, endpoint))) + "CommandOptions = " +
                            "new "
                            + getAsClassName(getAsCamelCase(getMethodName(category, endpoint))) + "CommandOptions();\n");
                }
            }
        }
        sb.append("    \n");
        sb.append("    }\n");
        sb.append("    \n");
        return sb.toString();
    }

    @Override
    protected String getClassMethods(String key) {
        Category category = availableCategories.get(key);
        CategoryConfig config = availableCategoryConfigs.get(key);
        StringBuilder sb = new StringBuilder();
        for (Endpoint endpoint : category.getEndpoints()) {
            //If it is post, it must have parameters in the body,
            // therefore it must be different from post or have some primitive value in the body so that we can generate the method
            String commandName = getMethodName(category, endpoint).replaceAll("_", "-");
            if ((!"POST".equals(endpoint.getMethod()) || endpoint.hasPrimitiveBodyParams(config, commandName)) && endpoint.hasParameters()) {
                if (config.isAvailableCommand(commandName) && !config.isExtendedOptionCommand(commandName)) {
                    sb.append("    @Parameters(commandNames = {\"" + reverseCommandName(commandName) + "\"}, commandDescription =\"" +
                            endpoint.getDescription().replaceAll("\"", "'") + "\")\n");
                    sb.append("    public class " + getAsClassName(getAsCamelCase(getMethodName(category, endpoint))) + "CommandOptions " +
                            "{\n");
                    sb.append("    \n");
                    sb.append("        @ParametersDelegate\n");
                    sb.append("        public CommonCommandOptions commonOptions = commonCommandOptions;\n");
                    sb.append("    \n");
                    Set<String> variable_names = new HashSet<>();
                    for (Parameter parameter : endpoint.getParameters()) {

                        if (config.isAvailableSubCommand(parameter.getName(), commandName)) {
                            if (!"body".equals(normaliceNames(parameter.getName()))) {
                                if (parameter.isAvailableType() && !variable_names.contains(normaliceNames(getAsCamelCase(parameter.getName())))) {
                                    sb.append("        @Parameter(names = {" + getShortCuts(parameter, config) + "}, description = " +
                                            "\"" + parameter.getDescription().replaceAll("\"", "'") + "\", required = " + parameter.isRequired() + ", arity = 1)\n");
                                    sb.append("        public " + getValidValue(parameter.getType()) + " " + getVariableName(parameter) + ";" +
                                            " " +
                                            "\n");
                                    sb.append("    \n");
                                    variable_names.add(normaliceNames(getAsCamelCase(parameter.getName())));
                                }
                            } else {
                                if (parameter.getData() != null)
                                    for (Parameter bodyParameter : parameter.getData()) {

                                        if (config.isAvailableSubCommand(bodyParameter.getName(), commandName) && bodyParameter.isAvailableType() && !variable_names.contains(normaliceNames(getAsCamelCase(parameter.getName())))) {

                                            sb.append("        @Parameter(names = {" + getShortCuts(bodyParameter, config) + "}, " +
                                                    "description"
                                                    + " = \"" + bodyParameter.getDescription().replaceAll("\"", "'") + "\", required = "
                                                    + (bodyParameter.isRequired() || isMandatory(commandName,
                                                    getVariableName(bodyParameter))) + ", arity = 1)\n");

                                            sb.append("        public " + getValidValue(bodyParameter.getType()) + " "
                                                    + getVariableName(bodyParameter) + ";\n");
                                            sb.append("    \n");
                                            variable_names.add(normaliceNames(getAsCamelCase(bodyParameter.getName())));
                                        }
                                    }
                            }
                        }
                    }
                    sb.append("  }\n");
                }
            }
        }
        return sb.toString();
    }

    private String reverseCommandName(String commandName) {
        if (commandName.contains("-")) {
            String[] phrase = commandName.split("-");
            if (phrase.length == 2) {
                commandName = phrase[1] + "-" + phrase[0];
            }
        }
        return commandName;
    }

    private String getVariableName(Parameter parameter) {
        String res = "";
        if (parameter.isInnerParam()) {
            res = normaliceNames(getAsCamelCase(parameter.getParentParamName() + " " + parameter.getName()));
        } else {
            res = normaliceNames(getAsCamelCase(parameter.getName()));
        }
        return res;
    }

    private boolean isMandatory(String commandName, String normaliseNames) {
        return "create".equals(commandName) && "id".equals(normaliseNames);
    }

    private String normaliceNames(String name) {
        name = getAsCamelCase(name, "\\.");
        if (invalidNames.containsKey(name)) {
            name = invalidNames.get(name);
        }
        return name;
    }

    private String getShortCuts(Parameter parameter, CategoryConfig config) {
        if (parameter.isInnerParam()) {
            return "\"--" + getKebabCase(parameter.getParentParamName()) + "-" + getKebabCase(parameter.getName()) + "\""
                    + getStringShortcuts(getKebabCase(parameter.getParentParamName()) + "-" + getKebabCase(parameter.getName()), config);
        } else {
            return "\"--" + getKebabCase(parameter.getName()) + "\"" + getStringShortcuts(parameter.getName(), config);
        }
    }

    public String getStringShortcuts(String parameter, CategoryConfig categoryConfig) {
        String res = "";
        Set<String> scut = new HashSet<>();

        //Generic shortcuts
        if (config.getApiConfig().getShortcuts() != null) {
            for (Shortcut sc : config.getApiConfig().getShortcuts()) {
                if (parameter.equals(sc.getName()) && !scut.contains(sc.getShortcut())) {
                    scut.add(sc.getShortcut());
                    String dash = "-";
                    if (sc.getShortcut().length() > 1) {
                        dash = "--";
                    }
                    res += ", \"" + dash + "" + sc.getShortcut() + "\"";
                }
            }
        }

        //category shortcuts
        if (categoryConfig.getShortcuts() != null) {
            for (Shortcut sc : categoryConfig.getShortcuts()) {
                if (parameter.equals(sc.getName()) && !scut.contains(sc.getShortcut())) {
                    scut.add(sc.getShortcut());
                    String dash = "-";
                    if (sc.getShortcut().length() > 1) {
                        dash = "--";
                    }
                    res += ", \"" + dash + "" + sc.getShortcut() + "\"";
                }
            }
        }
        return res;
    }

    @Override
    protected String getClassFileName(String key) {
        Category category = availableCategories.get(key);
        return config.getOptions().getOptionsOutputDir() + "/" + getAsClassName(category.getName()) + "CommandOptions.java";
    }
}
