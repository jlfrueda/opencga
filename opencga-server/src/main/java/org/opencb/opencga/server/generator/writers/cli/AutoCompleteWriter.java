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

public class AutoCompleteWriter extends ParentClientRestApiWriter {

    public AutoCompleteWriter(RestApi restApi, CommandLineConfiguration config) {
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

        sb.append("import org.jline.reader.Candidate;\n");
        sb.append("import org.jline.reader.Completer;\n");
        sb.append("import org.jline.reader.LineReader;\n");
        sb.append("import org.jline.reader.ParsedLine;\n");
        sb.append("import org.apache.commons.lang3.StringUtils;\n");

        sb.append("import java.util.List;\n");
        sb.append("import java.util.Map;\n");
        sb.append("import java.util.HashMap;\n");

        sb.append("import static java.util.Arrays.asList;\n");
        sb.append("import static java.util.stream.Collectors.toList;\n");

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
        sb.append("*    Command line version: ").append(restApi.getVersion()).append("\n");
        sb.append("*    Command line commit: ").append(restApi.getCommit()).append("\n");
        sb.append("*/\n");

        return sb.toString();
    }

    @Override
    protected String getClassHeader(String key) {

        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("public abstract class OpenCgaCompleter implements Completer {\n");
        sb.append("\n");
        sb.append("    protected List<Candidate> commands = asList(\"login\",\"logout\",\"help\",\"use\",");
        for (RestCategory restCategory : availableCategories.values()) {
            CategoryConfig config = availableCategoryConfigs.get(getIdCategory(restCategory));
            sb.append("\"" + getCategoryCommandName(restCategory, config) + "\",");
        }
        sb.delete(sb.lastIndexOf(","), sb.length());
        sb.append(")\n            .stream()\n            .map(Candidate::new)\n            .collect(toList());\n\n");

        for (RestCategory restCategory : availableCategories.values()) {
            CategoryConfig config = availableCategoryConfigs.get(getIdCategory(restCategory));
            sb.append("    private List<Candidate> " + getCategoryCommandName(restCategory, config) + "List = asList( ");
            for (RestEndpoint restEndpoint : restCategory.getEndpoints()) {
                String commandName = getCommandName(restCategory, restEndpoint);
                if (config.isAvailableCommand(commandName)) {
                    sb.append("\"" + reverseCommandName(commandName) + "\",");

                }

            }
            sb.delete(sb.lastIndexOf(","), sb.length());
            sb.append(")\n            .stream()\n            .map(Candidate::new)\n            .collect(toList());\n\n");
        }

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

        sb.append("    @Override\n");
        sb.append("    public void complete(LineReader lineReader, ParsedLine parsedLine, List<Candidate> candidates) {\n");
        sb.append("        String command = parsedLine.line().trim();\n");
        sb.append("        if (StringUtils.isEmpty(command)) {\n");
        sb.append("            candidates.addAll(commands);\n");
        sb.append("            return;\n");
        sb.append("        }\n");
        sb.append("        Map<String, List<Candidate>> mapCandidates=new HashMap();\n");
        for (RestCategory restCategory : availableCategories.values()) {
            CategoryConfig config = availableCategoryConfigs.get(getIdCategory(restCategory));
            sb.append("        mapCandidates.put( \"" + getCategoryCommandName(restCategory, config) + "\", "
                    + getCategoryCommandName(restCategory, config) + "List);\n");
        }
        sb.append("         candidates.addAll(checkCandidates(mapCandidates,command)); \n");
        sb.append("     }\n");

        sb.append("    public abstract List<Candidate> checkCandidates(Map<String, List<Candidate>> candidatesMap,String line);");
        sb.append("    \n");

        return sb.toString();
    }

    @Override
    protected String getClassFileName(String key) {
        return config.getOptions().getOutputDir() + "/OpenCgaCompleter.java";
    }
}
