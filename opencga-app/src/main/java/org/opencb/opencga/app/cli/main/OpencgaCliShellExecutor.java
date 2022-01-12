package org.opencb.opencga.app.cli.main;

import org.jline.reader.*;
import org.jline.reader.impl.DefaultHighlighter;
import org.jline.reader.impl.history.DefaultHistory;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.opencb.commons.utils.Color;
import org.opencb.commons.utils.PrintUtils;
import org.opencb.opencga.app.cli.session.CliSessionManager;
import org.opencb.opencga.catalog.exceptions.CatalogAuthenticationException;

import java.io.IOException;


public class OpencgaCliShellExecutor {

    private LineReader lineReader = null;
    private Terminal terminal = null;

    public OpencgaCliShellExecutor() throws CatalogAuthenticationException {

    }

    private LineReader getTerminal() {
        LineReader reader = null;
        try {
            if (terminal == null) {
                terminal = TerminalBuilder.builder()
                        .system(true).nativeSignals(true)
                        .build();

                System.out.print(PrintUtils.eraseScreen());
                printShellHeaderMessage();
            }
            History defaultHistory = new DefaultHistory();

            // Register a shutdown-hook per JLine documentation to save history
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                try {
                    defaultHistory.save();
                } catch (IOException e) {
                    CommandLineUtils.printError("Failed to save terminal history", e);
                }
            }));
            reader = LineReaderBuilder.builder()
                    .terminal(terminal)
                    .highlighter(new DefaultHighlighter())
                    .history(defaultHistory).completer(new OpenCgaCompleterImpl())
                    .build();
        } catch (Exception e) {
            CommandLineUtils.printError("Failed to create terminal ", e);
        }

        return reader;
    }

    //    @Override
    public void execute() throws Exception {
        try {
            if (lineReader == null) {
                lineReader = getTerminal();
            }
            String PROMPT = "";
            CliSessionManager.setDefaultCurrentStudy();
            while (true) {
                // Read and sanitize the input
                String line;
                PROMPT = CliSessionManager.getPrompt();
                try {
                    line = lineReader.readLine(PROMPT);
                } catch (UserInterruptException e) {
                    PrintUtils.printWarn("If you want to close OpenCGA. Type \"exit\"");
                    continue;
                } catch (EndOfFileException e) {
                    break;
                }
                if (line == null) {
                    continue;
                }
                line = line.trim();
                if (!line.equals("")) {
                    OpencgaCliProcessor.execute(line.split(" "));
                }
                // Construct the Command and args to pass to that command

            }
            terminal.writer().flush();
        } catch (Exception e) {
            CommandLineUtils.printError("OpenCGA execution error ", e);
        }
    }

    private void printShellHeaderMessage() {

        PrintUtils.println("     ███████                                    █████████    █████████    █████████  ", Color.GREEN);
        PrintUtils.println("   ███░░░░░███                                 ███░░░░░███  ███░░░░░███  ███░░░░░███ ", Color.GREEN);
        PrintUtils.println("  ███     ░░███ ████████   ██████  ████████   ███     ░░░  ███     ░░░  ░███    ░███ ", Color.GREEN);
        PrintUtils.println("  ███      ░███░░███░░███ ███░░███░░███░░███ ░███         ░███          ░███████████ ", Color.GREEN);
        PrintUtils.println("  ███      ░███ ░███ ░███░███████  ░███ ░███ ░███         ░███    █████ ░███░░░░░███ ", Color.GREEN);
        PrintUtils.println("  ░███     ███  ░███ ░███░███░░░   ░███ ░███ ░░███     ███░░███  ░░███  ░███    ░███ ", Color.GREEN);
        PrintUtils.println("  ░░░███████░   ░███████ ░░██████  ████ █████ ░░█████████  ░░█████████  █████   █████", Color.GREEN);
        PrintUtils.println("    ░░░░░░░     ░███░░░   ░░░░░░  ░░░░ ░░░░░   ░░░░░░░░░    ░░░░░░░░░  ░░░░░   ░░░░░ ", Color.GREEN);
        PrintUtils.println("                ░███                                                                 ", Color.GREEN);
        PrintUtils.println("                █████                                                                ", Color.GREEN);
        PrintUtils.println("               ░░░░░                                                                 ", Color.GREEN);

        System.out.println();
        System.out.println(CommandLineUtils.getVersionString());
        System.out.println();
        PrintUtils.println("\nTo close the application type \"exit\"", Color.BLUE);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        CommandLineUtils.printDebugMessage("Opencga is running in DEBUG mode");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }

}
