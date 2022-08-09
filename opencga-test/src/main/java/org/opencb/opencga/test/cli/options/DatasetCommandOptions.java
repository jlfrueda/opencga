package org.opencb.opencga.test.cli.options;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.beust.jcommander.ParametersDelegate;

import java.util.List;

@Parameters(commandNames = {"dataset"}, commandDescription = "Execute related dataset commands")
public class DatasetCommandOptions {

    @ParametersDelegate
    public static CommonCommandOptions commonCommandOptions = new CommonCommandOptions();

    @Parameter(names = "--conf", description = "Config file (configuration.yml).", required = true)
    public static String configFile = "configuration.yml";

    @Parameter(names = "--simulate", description = "Prints the command line step by step.")
    public static boolean simulate = false;

    @Parameter(names = "--output", description = "Output directory.")
    public static String output;

    @Parameter(names = "--run", description = "Execute all the commands to generate the VCF files.")
    public static boolean run = false;

    @Parameter(names = "--mutate", description = "Execute all the commands to generate the VCF files.")
    public static boolean mutate = false;

    @Parameter(names = "--resume", description = "Execute all the commands to generate the VCF files. Beginning for the last executed")
    public static boolean resume = false;

    @Parameter(names = "--envs", description = "Execute the commands only for these environments")
    public static List<String> envs;
}
