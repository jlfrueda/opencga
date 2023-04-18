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

package org.opencb.opencga.server.generator.writers.cli;

import org.apache.commons.lang3.StringUtils;
import org.opencb.opencga.server.generator.config.CategoryConfig;
import org.opencb.opencga.server.generator.config.CommandLineConfiguration;
import org.opencb.opencga.server.generator.config.Shortcut;
import org.opencb.opencga.server.generator.models.RestApi;
import org.opencb.opencga.server.generator.models.RestCategory;
import org.opencb.opencga.server.generator.models.RestEndpoint;
import org.opencb.opencga.server.generator.models.RestParameter;
import org.opencb.opencga.server.generator.writers.ParentClientRestApiWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

public class OptionsCliRestApiWriter extends ParentClientRestApiWriter {

    protected static Logger logger = LoggerFactory.getLogger(OptionsCliRestApiWriter.class);

    public OptionsCliRestApiWriter(RestApi restApi, CommandLineConfiguration config) {
        super(restApi, config);
    }

    @Override
    protected String getClassImports(String key) {
        StringBuilder sb = new StringBuilder();
        RestCategory restCategory = availableCategories.get(key);
        CategoryConfig categoryConfig = availableCategoryConfigs.get(key);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sb.append("package ").append(config.getOptions().getOptionsPackage()).append(";\n\n");
        sb.append("import com.beust.jcommander.JCommander;\n");
        sb.append("import com.beust.jcommander.Parameter;\n");
        sb.append("import com.beust.jcommander.Parameters;\n");
        sb.append("import com.beust.jcommander.DynamicParameter;\n");
        sb.append("import com.beust.jcommander.ParametersDelegate;\n\n");
        sb.append("import java.util.HashMap;\n");
        sb.append("import java.util.Map;\n");
        sb.append("import java.util.List;\n\n");
        if (categoryConfig.isOptionExtended() && StringUtils.isEmpty(categoryConfig.getOptionExtendedClassName())) {
            sb.append("import org.opencb.opencga.app.cli.main.custom."
                    + getExtendedClass(getAsClassName(restCategory.getName()), categoryConfig) + ";\n\n");
        }
        sb.append("import static org.opencb.opencga.app.cli.GeneralCliOptions.*;\n");
        sb.append("\n");
        sb.append("\n");
        sb.append("/*\n");
        sb.append("* WARNING: AUTOGENERATED CODE\n");
        sb.append("*\n");
        sb.append("* This code was generated by a tool.\n");
        sb.append("*\n");
        sb.append("* Manual changes to this file may cause unexpected behavior in your application.\n");
        sb.append("* Manual changes to this file will be overwritten if the code is regenerated.\n");
        sb.append("*  \n");
        sb.append("*/\n");
        sb.append("\n");
        sb.append("/**\n");
        sb.append(" * This class contains methods for the ").append(restCategory.getName()).append(" command line.\n");
        sb.append(" *    PATH: ").append(restCategory.getPath()).append("\n");
        sb.append(" */\n");
        return sb.toString();
    }

    private String getExtendedClass(String name, CategoryConfig config) {
        String res = "OpencgaCommandExecutor";
        if (config.isOptionExtended()) {
            if (StringUtils.isNotEmpty(config.getOptionExtendedClassName())) {
                res = config.getOptionExtendedClassName();
            } else {
                res = "Custom" + name + "CommandOptions";
            }
        }
        return res;
    }

    @Override
    protected String getClassHeader(String key) {
        RestCategory restCategory = availableCategories.get(key);
        CategoryConfig config = availableCategoryConfigs.get(key);
        StringBuilder sb = new StringBuilder();
        sb.append("@Parameters(commandNames = {\"" + getCategoryCommandName(restCategory, config) + "\"}, commandDescription = \""
                + restCategory.getName() + " commands\")\n");
        if (config.isOptionExtended()) {
            sb.append("public class " + getAsClassName(restCategory.getName()) + "CommandOptions extends "
                    + getExtendedClass(getAsClassName(restCategory.getName()), config) + " {\n\n");
        } else {
            sb.append("public class " + getAsClassName(restCategory.getName()) + "CommandOptions {\n");
        }
        sb.append("\n");
        if (!config.isOptionExtended()) {
            sb.append("        public JCommander jCommander;\n");
            sb.append("        public CommonCommandOptions commonCommandOptions;\n");
            sb.append("\n");
        }
        for (RestEndpoint restEndpoint : restCategory.getEndpoints()) {
            String commandName = getCommandName(restCategory, restEndpoint);
            //    if ("POST".equals(restEndpoint.getMethod()) || restEndpoint.hasParameters()) {
            if (config.isAvailableCommand(commandName)) {
                sb.append("        public " + getAsClassName(getAsCamelCase(getMethodName(restCategory, restEndpoint))) + "CommandOptions "
                        + getAsVariableName(getAsCamelCase(getMethodName(restCategory, restEndpoint))) + "CommandOptions;\n");
            }
            //   }
        }

        sb.append("\n");
        sb.append("\n");
        sb.append("    public " + getAsClassName(restCategory.getName()) + "CommandOptions(CommonCommandOptions commonCommandOptions, " +
                "JCommander jCommander) {\n");
        sb.append("    \n");
        if (config.isOptionExtended()) {
            sb.append("        super(commonCommandOptions,jCommander);\n");
        } else {
            sb.append("        this.jCommander = jCommander;\n");
            sb.append("        this.commonCommandOptions = commonCommandOptions;\n");
        }
        for (RestEndpoint restEndpoint : restCategory.getEndpoints()) {
            String commandName = getCommandName(restCategory, restEndpoint);
            //  if ("POST".equals(restEndpoint.getMethod()) || restEndpoint.hasParameters()) {
            if (config.isAvailableCommand(commandName)) {
                sb.append("        this." + getAsVariableName(getAsCamelCase(getMethodName(restCategory, restEndpoint))) + "CommandOptions = " +
                        "new "
                        + getAsClassName(getAsCamelCase(getMethodName(restCategory, restEndpoint))) + "CommandOptions();\n");
            }
            //    }
        }
        sb.append("    \n");
        sb.append("    }\n");
        sb.append("    \n");
        return sb.toString();
    }

    @Override
    protected String getClassMethods(String key) {
        RestCategory restCategory = availableCategories.get(key);
        CategoryConfig config = availableCategoryConfigs.get(key);
        StringBuilder sb = new StringBuilder();
        for (RestEndpoint restEndpoint : restCategory.getEndpoints()) {
            String commandName = getCommandName(restCategory, restEndpoint);
            // if ("POST".equals(restEndpoint.getMethod()) || restEndpoint.hasParameters()) {
            if (config.isAvailableCommand(commandName) && !config.isExtendedOptionCommand(commandName)) {
                sb.append("    @Parameters(commandNames = {\"" + reverseCommandName(commandName) + "\"}, commandDescription =\"" +
                        restEndpoint.getDescription().replaceAll("\"", "'") + "\")\n");
                sb.append("    public class " + getAsClassName(getAsCamelCase(getMethodName(restCategory, restEndpoint))) + "CommandOptions " +
                        "{\n");
                sb.append("    \n");
                sb.append("        @ParametersDelegate\n");
                sb.append("        public CommonCommandOptions commonOptions = commonCommandOptions;\n");
                sb.append("    \n");
                if (restEndpoint.getMethod().equals("POST")) {
                    sb.append("        @Parameter(names = {\"--json-file\"}, description = \"File with the body data in JSON format. Note, that using this parameter will ignore all the other parameters.\", required = false, arity = 1)\n");
                    sb.append("        public String jsonFile;\n");
                    sb.append("    \n");
                    sb.append("        @Parameter(names = {\"--json-data-model\"}, description = \"Show example of file structure for body data.\", help = true, arity = 0)\n");
                    sb.append("        public Boolean jsonDataModel = false;\n");
                    sb.append("    \n");
                }

                Set<String> variable_names = new HashSet<>();
                for (RestParameter restParameter : restEndpoint.getParameters()) {
                    if (config.isAvailableSubCommand(restParameter.getName(), commandName)) {
                        if (!"body".equals(normalizeNames(restParameter.getName()))) {
                            if (restParameter.isAvailableType() && !variable_names.contains(normalizeNames(getAsCamelCase(restParameter.getName())))) {
                                sb.append("        @Parameter(names = {" + getShortCuts(restParameter, config) + "}, description = " +
                                        "\"" + restParameter.getDescription().replaceAll("\"", "'") + "\", required = " + restParameter.isRequired() + ", " + getArity(restParameter) + ")\n");
                                sb.append("        public " + getValidValue(restParameter) + " " + getVariableName(restParameter) + getDefaultValue(restParameter) + ";" +
                                        " " +
                                        "\n");
                                sb.append("    \n");
                                variable_names.add(normalizeNames(getAsCamelCase(restParameter.getName())));
                            }
                        } else {
                            if (restParameter.getData() != null) {
                                for (RestParameter bodyRestParameter : restParameter.getData()) {
                                    if (config.isAvailableSubCommand(bodyRestParameter.getName(), commandName) && bodyRestParameter.isAvailableType() && !variable_names.contains(normalizeNames(getAsCamelCase(restParameter.getName())))) {
                                        sb.append("        @Parameter(names = {" + getShortCuts(bodyRestParameter, config) + "}, " +
                                                "description"
                                                + " = \"" + bodyRestParameter.getDescription().replaceAll("\"", "'") + "\", required = "
                                                + (bodyRestParameter.isRequired() || isMandatory(commandName,
                                                getVariableName(bodyRestParameter))) + ", " + getArity(bodyRestParameter) + ")\n");

                                        sb.append("        public " + getValidValue(bodyRestParameter) + " "
                                                + getVariableName(bodyRestParameter) + getDefaultValue(bodyRestParameter) + ";\n");
                                        sb.append("    \n");
                                        variable_names.add(normalizeNames(getAsCamelCase(bodyRestParameter.getName())));
                                    } else if (bodyRestParameter.getType().equals("enum")) {

                                        sb.append("        @Parameter(names = {" + getShortCuts(bodyRestParameter, config) + "}, " +
                                                "description"
                                                + " = \"" + bodyRestParameter.getDescription().replaceAll("\"", "'") + "\", required = "
                                                + (bodyRestParameter.isRequired() || isMandatory(commandName,
                                                getVariableName(bodyRestParameter))) + ", " + getArity(bodyRestParameter) + ")\n");

                                        sb.append("        public " + getValidValue(bodyRestParameter) + " "
                                                + getVariableName(bodyRestParameter) + getDefaultValue(bodyRestParameter) + ";\n");
                                        sb.append("    \n");
                                    } else if (isValidMap(bodyRestParameter)) {
                                        String names = getShortCuts(bodyRestParameter, config);
                                        sb.append("        @DynamicParameter(names = {" + names + "}, " +
                                                "description"
                                                + " = \"" + bodyRestParameter.getDescription().replaceAll("\"", "'") + ". Use: " + names.split(", ")[0].replace("\"", "") + " key=value\", required = "
                                                + (bodyRestParameter.isRequired() || isMandatory(commandName,
                                                getVariableName(bodyRestParameter))) + ")\n");

                                        sb.append("        public " + getValidValue(bodyRestParameter) + " "
                                                + getVariableName(bodyRestParameter) + " = new HashMap<>(); //Dynamic parameters must be initialized;\n");
                                        sb.append("    \n");
                                    } else {
                                        logger.warn("Skipping parameter '{}' value '{}' at command '{} {}'",
                                                bodyRestParameter.getName(), getValidValue(bodyRestParameter),
                                                getCategoryCommandName(restCategory, config), reverseCommandName(commandName));
                                    }
                                }
                            }
                        }
                    }
                }
                sb.append("    }\n\n");
            }
            //  }
        }
        return sb.toString();
    }

    private String getArity(RestParameter bodyRestParameter) {
        String res = "arity = 1";
        if (getValidValue(bodyRestParameter).equals("boolean")) {
            res = "help = true, arity = 0";
        }
        return res;
    }

    private String getDefaultValue(RestParameter bodyRestParameter) {
        String res = "";
        if (!StringUtils.isEmpty(bodyRestParameter.getDefaultValue())) {
            if ("String".equals(getValidValue(bodyRestParameter))) {
                res += " = \"" + bodyRestParameter.getDefaultValue() + "\"";
            } else {
                res += " = " + bodyRestParameter.getDefaultValue();
            }
        }
        if (getValidValue(bodyRestParameter).equals("boolean")) {
            res = " = false";
        }


        return res;
    }


    private String getVariableName(RestParameter restParameter) {
        String res = "";
        if (restParameter.isInnerParam()) {
            res = normalizeNames(getAsCamelCase(restParameter.getParentName() + " " + restParameter.getName()));
        } else {
            res = normalizeNames(getAsCamelCase(restParameter.getName()));
        }
        return res;
    }

    private boolean isMandatory(String commandName, String normaliseNames) {
        return "create".equals(commandName) && "id".equals(normaliseNames);
    }

    private String normalizeNames(String name) {
        name = getAsCamelCase(name, "\\.");
        if (invalidNames.containsKey(name)) {
            name = invalidNames.get(name);
        }
        return name;
    }

    private String getShortCuts(RestParameter restParameter, CategoryConfig config) {
        if (restParameter.isInnerParam()) {
            return "\"--" + getKebabCase(restParameter.getParentName()) + "-" + getKebabCase(restParameter.getName()) + "\""
                    + getStringShortcuts(getKebabCase(restParameter.getParentName()) + "-" + getKebabCase(restParameter.getName()), config);
        } else {
            return "\"--" + getKebabCase(restParameter.getName()) + "\"" + getStringShortcuts(restParameter.getName(), config);
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

        // category shortcuts
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
        RestCategory restCategory = availableCategories.get(key);
        return config.getOptions().getOptionsOutputDir() + "/" + getAsClassName(restCategory.getName()) + "CommandOptions.java";
    }
}
