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

import org.apache.commons.collections4.CollectionUtils;
import org.opencb.opencga.server.generator.config.CategoryConfig;
import org.opencb.opencga.server.generator.config.CommandLineConfiguration;
import org.opencb.opencga.server.generator.models.RestApi;
import org.opencb.opencga.server.generator.models.RestCategory;
import org.opencb.opencga.server.generator.models.RestEndpoint;
import org.opencb.opencga.server.generator.writers.ParentClientRestApiWriter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ParserCliRestApiWriter extends ParentClientRestApiWriter {

    public ParserCliRestApiWriter(RestApi restApi, CommandLineConfiguration config) {
        super(restApi, config);
    }

    @Override
    protected String getClassImports(String key) {
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sb.append("/*\n");
        sb.append("* Copyright 2015-").append(sdf.format(new Date())).append(" OpenCB\n");
        sb.append("*\n");
        sb.append("* Licensed under the Apache License, Version 2.0 (the \"License\");\n");
        sb.append("* you may not use this file except in compliance with the License.\n");
        sb.append("* You may obtain a copy of the License at\n");
        sb.append("*\n");
        sb.append("*     http://www.apache.org/licenses/LICENSE-2.0\n");
        sb.append("*\n");
        sb.append("* Unless required by applicable law or agreed to in writing, software\n");
        sb.append("* distributed under the License is distributed on an \"AS IS\" BASIS,\n");
        sb.append("* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n");
        sb.append("* See the License for the specific language governing permissions and\n");
        sb.append("* limitations under the License.\n");
        sb.append("*/\n");
        sb.append("\n");
        sb.append("package ").append(config.getOptions().getParserPackage()).append(";\n");
        sb.append("\n");

        sb.append("import com.beust.jcommander.JCommander;\n");
        sb.append("import org.opencb.opencga.app.cli.GeneralCliOptions;\n");
        sb.append("import org.opencb.opencga.app.cli.main.options.*;\n");
        sb.append("import org.opencb.opencga.app.cli.main.parent.ParentCliOptionsParser;\n");
        sb.append("\n");
        sb.append("\n");
        sb.append("/*\n");
        sb.append("* WARNING: AUTOGENERATED CODE\n");
        sb.append("*\n");
        sb.append("* This code was generated by a tool.\n");
        sb.append("*\n");
        sb.append("* Manual changes to this file may cause unexpected behavior in your application.\n");
        sb.append("* Manual changes to this file will be overwritten if the code is regenerated.\n");
        sb.append("*/\n");
        sb.append("\n");


        return sb.toString();
    }

    @Override
    protected String getClassHeader(String key) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("public class OpencgaCliOptionsParser extends ParentCliOptionsParser {\n");
        sb.append("\n");
        for (RestCategory restCategory : availableCategories.values()) {
            sb.append("    private final " + getAsClassName(restCategory.getName()) + "CommandOptions " + getAsVariableName(restCategory.getName()) +
                    "CommandOptions;\n");
        }
        sb.append("\n");
        sb.append("    enum OutputFormat {IDS, ID_CSV, NAME_ID_MAP, ID_LIST, RAW, PRETTY_JSON, PLAIN_JSON}\n");
        sb.append("\n");
        sb.append("    public OpencgaCliOptionsParser() {\n");
        sb.append("\n");
        sb.append("        jCommander.setExpandAtSign(false);\n");

        for (RestCategory restCategory : availableCategories.values()) {
            CategoryConfig config = availableCategoryConfigs.get(getIdCategory(restCategory));
            sb.append("\n");
            sb.append("        " + getAsVariableName(restCategory.getName()) + "CommandOptions = new " + getAsClassName(restCategory.getName())
                    + "CommandOptions(commonCommandOptions, jCommander);\n");
            sb.append("        jCommander.addCommand(\"" + getCategoryCommandName(restCategory, config)
                    + "\", " + getAsVariableName(restCategory.getName()) + "CommandOptions);\n");
            sb.append("        JCommander " + getAsVariableName(restCategory.getName()) + "SubCommands = jCommander.getCommands().get(\""
                    + getCategoryCommandName(restCategory, config) + "\");\n");

            for (RestEndpoint restEndpoint : restCategory.getEndpoints()) {
                String commandName = getCommandName(restCategory, restEndpoint);
//                if ((!"POST".equals(restEndpoint.getMethod()) || restEndpoint.hasPrimitiveBodyParams(config, commandName)) && restEndpoint.hasParameters()) {
                //  if ("POST".equals(restEndpoint.getMethod()) || restEndpoint.hasParameters()) {
                if (config.isAvailableCommand(commandName)) {
                    sb.append("        " + getAsVariableName(restCategory.getName()) + "SubCommands.addCommand(\"" + reverseCommandName(commandName) + "\", "
                            + getAsVariableName(restCategory.getName()) + "CommandOptions." + getAsCamelCase(commandName) +
                            "CommandOptions);\n");
                }
                //   }
            }

            if (CollectionUtils.isNotEmpty(config.getAddedMethods())) {
                for (String methodName : config.getAddedMethods()) {
                    sb.append("        " + getAsVariableName(restCategory.getName()) + "SubCommands.addCommand(\"" + methodName + "\", "
                            + getAsVariableName(restCategory.getName()) + "CommandOptions." + getAsCamelCase(methodName) +
                            "CommandOptions);\n");
                }
            }
        }
        sb.append("    }\n");
        return sb.toString();
    }

    public void write() {
        StringBuffer sb = new StringBuffer();
        sb.append(getClassImports(""));
        sb.append(getClassHeader(""));
        sb.append(getClassMethods(""));
        sb.append("}");

        File file = new File(getClassFileName(""));
        try {
            writeToFile(file, sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected String getClassMethods(String key) {
        StringBuilder sb = new StringBuilder();
        for (RestCategory restCategory : availableCategories.values()) {
            sb.append("    \n");
            sb.append("    public " + getAsClassName(restCategory.getName()) + "CommandOptions get" + getAsClassName(restCategory.getName())
                    + "CommandOptions() {\n");
            sb.append("        return " + getAsVariableName(restCategory.getName()) + "CommandOptions;\n");
            sb.append("    }\n");
            sb.append("    \n");
        }
        return sb.toString();
    }

    @Override
    protected String getClassFileName(String key) {
        return config.getOptions().getOutputDir() + "/OpencgaCliOptionsParser.java";
    }
}
