package org.opencb.opencga.app.cli.main.parent;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.beust.jcommander.ParametersDelegate;
import org.opencb.opencga.core.api.ParamConstants;

import static org.opencb.opencga.app.cli.GeneralCliOptions.CommonCommandOptions;
/*
 * WARNING: AUTOGENERATED CODE
 *
 * This code was generated by a tool.
 * Autogenerated on: 2021-10-11
 *
 * Manual changes to this file may cause unexpected behavior in your application.
 * Manual changes to this file will be overwritten if the code is regenerated.
 */

/**
 * This class contains methods for the Files command line. OpenCGA version: 2.2.0-SNAPSHOT PATH: /{apiVersion}/files
 */
@Parameters(commandNames = {"jobs"}, commandDescription = "Jobs commands")
public class ParentJobsCommandOptions {

    public JCommander jCommander;
    public CommonCommandOptions commonCommandOptions;
    public TopCommandOptions topCommandOptions;
    public LogCommandOptions logCommandOptions;

    public ParentJobsCommandOptions(CommonCommandOptions commonCommandOptions, JCommander jCommander) {
        this.jCommander = jCommander;
        this.commonCommandOptions = commonCommandOptions;
        topCommandOptions = new TopCommandOptions();
        logCommandOptions = new LogCommandOptions();
    }

    @Parameters(commandNames = {"top"}, commandDescription = "Provide a view of jobs activity in real time.")
    public class TopCommandOptions {
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;

        @Parameter(names = {"--limit"}, description = "Number of rows", arity = 1)
        public int limit = 10;
        @Parameter(names = {"-d", "--delay"}, description = "Delay between iterations in seconds", arity = 1)
        public int delay = 2;

        @Parameter(names = {"--plain"}, description = "Plain representation, without dependencies.", arity = 0)
        public boolean plain;

        @Parameter(names = {"--columns"}, description = "Output columns to print." +
                " [ID, TOOL_ID, STATUS, EVENTS, STUDY, SUBMISSION, PRIORITY, RUNNING_TIME, START, END, INPUT, OUTPUT, OUTPUT_DIRECTORY]")
        public String columns;

        @Parameter(names = {"--iterations"}, description = "Exit after N iterations", arity = 1)
        public Integer iterations;

        @Parameter(names = {"-n", "--jobs"}, description = "Number of jobs to print", arity = 1)
        public Integer jobsLimit;

        @Parameter(names = {"--tool-id"}, description = ParamConstants.JOB_TOOL_ID_DESCRIPTION, arity = 1)
        public String toolId;

        @Parameter(names = {"--user-id"}, description = ParamConstants.JOB_USER_DESCRIPTION, arity = 1)
        public String userId;

        @Parameter(names = {"--priority"}, description = ParamConstants.JOB_PRIORITY_DESCRIPTION, arity = 1)
        public String priority;

        @Parameter(names = {"--internal-status"}, description = ParamConstants.JOB_STATUS_DESCRIPTION, arity = 1)
        public String internalStatus;

        @Parameter(names = {"--study", "-s"}, description = "Study [[user@]project:]study where study and project can be either the ID or" +
                " UUID", required = false, arity = 1)
        public String study;
    }

    @Parameters(commandNames = {"log"}, commandDescription = "Upload a physical local file to catalog.")
    public class LogCommandOptions {

        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;

        @Parameter(names = {"--job"}, description = ParamConstants.JOB_ID_DESCRIPTION + " or 'running' to print all running jobs.")
        public String job = "running";

        @Parameter(names = {"--type"}, description = "Log file to be shown (stdout or stderr)")
        public String type = "stderr";

        @Parameter(names = {"-f", "--follow"}, description = "Output appended data as the file grows", arity = 0)
        public boolean follow;

        @Parameter(names = {"-n", "--tail"}, description = "Output the last lines NUM lines.", arity = 1)
        public Integer tailLines;

        @Parameter(names = {"-d", "--delay"}, description = "Delay between iterations in seconds", arity = 1)
        public int delay = 2;

        @Parameter(names = {"--study", "-s"}, description = "Study [[user@]project:]study where study and project can be either the ID or" +
                " UUID", required = false, arity = 1)
        public String study;
    }
}