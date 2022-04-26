package org.opencb.opencga.app.cli.main.options;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.beust.jcommander.DynamicParameter;
import com.beust.jcommander.ParametersDelegate;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import static org.opencb.opencga.app.cli.GeneralCliOptions.*;


/*
* WARNING: AUTOGENERATED CODE
*
* This code was generated by a tool.
* Autogenerated on: 2022-04-26
*
* Manual changes to this file may cause unexpected behavior in your application.
* Manual changes to this file will be overwritten if the code is regenerated.
*/


/**
 * This class contains methods for the Meta command line.
 *    OpenCGA version: 2.3.0-SNAPSHOT
 *    PATH: /{apiVersion}/meta
 */
@Parameters(commandNames = {"meta"}, commandDescription = "Meta commands")
public class MetaCommandOptions {

        public JCommander jCommander;
        public CommonCommandOptions commonCommandOptions;

        public ApiCommandOptions apiCommandOptions;


    public MetaCommandOptions(CommonCommandOptions commonCommandOptions, JCommander jCommander) {
    
        this.jCommander = jCommander;
        this.commonCommandOptions = commonCommandOptions;
        this.apiCommandOptions = new ApiCommandOptions();
    
    }
    
    @Parameters(commandNames = {"api"}, commandDescription ="API")
    public class ApiCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--category"}, description = "List of categories to get API from", required = false, arity = 1)
        public String category; 
    
  }
}