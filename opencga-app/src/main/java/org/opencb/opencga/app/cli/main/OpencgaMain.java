/*
 * Copyright 2015-2017 OpenCB
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

package org.opencb.opencga.app.cli.main;

import org.apache.commons.lang3.ArrayUtils;
import org.opencb.opencga.app.cli.GeneralCliOptions;
import org.opencb.opencga.app.cli.main.processors.CliProcessor;
import org.opencb.opencga.app.cli.session.CliSessionManager;
import org.opencb.opencga.catalog.exceptions.CatalogAuthenticationException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by imedina on 27/05/16.
 */
public class OpencgaMain {

    public static void main(String[] args) {
        args = checkDebugMode(args);
        CommandLineUtils.printDebug(Arrays.toString(args));
        try {
            if (ArrayUtils.contains(args, "--shell")) {
                initShell(args);
            } else {
                CliProcessor processor = new CliProcessor();
                processor.execute(args);
            }
        } catch (Exception e) {
            CommandLineUtils.printError("Failed to initialize OpenCGA CLI", e);
        }
    }

    private static String[] checkDebugMode(String[] args) {
        CliSessionManager.getInstance().setDebug(ArrayUtils.contains(args, "--debug"));
        if (CliSessionManager.getInstance().isDebug()) {
            List<String> list = new ArrayList<>(Arrays.asList(args));
            list.remove("--debug");
            args = list.toArray(new String[list.size()]);
        }
        return args;
    }

    public static void initShell(String[] args) {
        try {
            GeneralCliOptions.CommonCommandOptions options = new GeneralCliOptions.CommonCommandOptions();
            if (ArrayUtils.contains(args, "--host")) {
                List<String> list = new ArrayList<>(Arrays.asList(args));
                options.host = args[list.indexOf("--host") + 1];
                list.remove("--host");
                list.remove(options.host);
                args = list.toArray(new String[list.size()]);
            }
            OpencgaCliShellExecutor shell = new OpencgaCliShellExecutor(options);
            CliSessionManager.setShell(shell);
            CliSessionManager.getInstance().init(args, shell);
            CliSessionManager.getInstance().loadSessionStudies(shell);
            CommandLineUtils.printDebug("Shell created ");
            shell.execute();
        } catch (CatalogAuthenticationException e) {
            CommandLineUtils.printError("Failed to initialize shell", e);
        } catch (Exception e) {
            CommandLineUtils.printError("Failed to execute shell", e);
        }
    }


}