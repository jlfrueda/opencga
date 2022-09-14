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
* Autogenerated on: 2022-09-14
*
* Manual changes to this file may cause unexpected behavior in your application.
* Manual changes to this file will be overwritten if the code is regenerated.
*/


/**
 * This class contains methods for the Projects command line.
 *    OpenCGA version: 2.4.4-SNAPSHOT
 *    PATH: /{apiVersion}/projects
 */
@Parameters(commandNames = {"projects"}, commandDescription = "Projects commands")
public class ProjectsCommandOptions {

        public JCommander jCommander;
        public CommonCommandOptions commonCommandOptions;

        public CreateCommandOptions createCommandOptions;
        public SearchCommandOptions searchCommandOptions;
        public AggregationStatsCommandOptions aggregationStatsCommandOptions;
        public InfoCommandOptions infoCommandOptions;
        public IncReleaseCommandOptions incReleaseCommandOptions;
        public StudiesCommandOptions studiesCommandOptions;
        public UpdateCommandOptions updateCommandOptions;


    public ProjectsCommandOptions(CommonCommandOptions commonCommandOptions, JCommander jCommander) {
    
        this.jCommander = jCommander;
        this.commonCommandOptions = commonCommandOptions;
        this.createCommandOptions = new CreateCommandOptions();
        this.searchCommandOptions = new SearchCommandOptions();
        this.aggregationStatsCommandOptions = new AggregationStatsCommandOptions();
        this.infoCommandOptions = new InfoCommandOptions();
        this.incReleaseCommandOptions = new IncReleaseCommandOptions();
        this.studiesCommandOptions = new StudiesCommandOptions();
        this.updateCommandOptions = new UpdateCommandOptions();
    
    }
    
    @Parameters(commandNames = {"create"}, commandDescription ="Create a new project")
    public class CreateCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--json-file"}, description = "File with the body data in JSON format. Note, that using this parameter will ignore all the other parameters.", required = false, arity = 1)
        public String jsonFile;
    
        @Parameter(names = {"--json-data-model"}, description = "Show example of file structure for body data.", help = true, arity = 0)
        public Boolean jsonDataModel = false;
    
        @Parameter(names = {"--include", "-I"}, description = "Fields included in the response, whole JSON path must be provided", required = false, arity = 1)
        public String include; 
    
        @Parameter(names = {"--exclude", "-E"}, description = "Fields excluded in the response, whole JSON path must be provided", required = false, arity = 1)
        public String exclude; 
    
        @Parameter(names = {"--include-result"}, description = "Flag indicating to include the created or updated document result in the response", required = false, arity = 1)
        public Boolean includeResult; 
    
        @Parameter(names = {"--id"}, description = "The body web service id parameter", required = true, arity = 1)
        public String id;
    
        @Parameter(names = {"--name", "-n"}, description = "The body web service name parameter", required = false, arity = 1)
        public String name;
    
        @Parameter(names = {"--description"}, description = "The body web service description parameter", required = false, arity = 1)
        public String description;
    
        @Parameter(names = {"--creation-date", "--cd"}, description = "The body web service creationDate parameter", required = false, arity = 1)
        public String creationDate;
    
        @Parameter(names = {"--modification-date", "--md"}, description = "The body web service modificationDate parameter", required = false, arity = 1)
        public String modificationDate;
    
        @Parameter(names = {"--organism-scientific-name"}, description = "The body web service scientificName parameter", required = false, arity = 1)
        public String organismScientificName;
    
        @Parameter(names = {"--organism-common-name"}, description = "The body web service commonName parameter", required = false, arity = 1)
        public String organismCommonName;
    
        @Parameter(names = {"--organism-assembly"}, description = "The body web service assembly parameter", required = false, arity = 1)
        public String organismAssembly;
    
        @Parameter(names = {"--cellbase-url"}, description = "The body web service url parameter", required = false, arity = 1)
        public String cellbaseUrl;
    
        @Parameter(names = {"--cellbase-version"}, description = "The body web service version parameter", required = false, arity = 1)
        public String cellbaseVersion;
    
        @Parameter(names = {"--cellbase-preferred"}, description = "The body web service preferred parameter", required = false, arity = 1)
        public String cellbasePreferred;
    
    }

    @Parameters(commandNames = {"search"}, commandDescription ="Search projects")
    public class SearchCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--include", "-I"}, description = "Fields included in the response, whole JSON path must be provided", required = false, arity = 1)
        public String include; 
    
        @Parameter(names = {"--exclude", "-E"}, description = "Fields excluded in the response, whole JSON path must be provided", required = false, arity = 1)
        public String exclude; 
    
        @Parameter(names = {"--limit"}, description = "Number of results to be returned", required = false, arity = 1)
        public Integer limit; 
    
        @Parameter(names = {"--skip"}, description = "Number of results to skip", required = false, arity = 1)
        public Integer skip; 
    
        @Parameter(names = {"--owner"}, description = "Owner of the project", required = false, arity = 1)
        public String owner; 
    
        @Parameter(names = {"--id"}, description = "Project [user@]project where project can be either the ID or the alias", required = false, arity = 1)
        public String id; 
    
        @Parameter(names = {"--name", "-n"}, description = "Project name", required = false, arity = 1)
        public String name; 
    
        @Parameter(names = {"--fqn"}, description = "Project fqn", required = false, arity = 1)
        public String fqn; 
    
        @Parameter(names = {"--organization"}, description = "Project organization", required = false, arity = 1)
        public String organization; 
    
        @Parameter(names = {"--description"}, description = "Project description", required = false, arity = 1)
        public String description; 
    
        @Parameter(names = {"--study", "-s"}, description = "Study id", required = false, arity = 1)
        public String study; 
    
        @Parameter(names = {"--creation-date", "--cd"}, description = "Creation date. Format: yyyyMMddHHmmss. Examples: >2018, 2017-2018, <201805", required = false, arity = 1)
        public String creationDate; 
    
        @Parameter(names = {"--modification-date", "--md"}, description = "Modification date. Format: yyyyMMddHHmmss. Examples: >2018, 2017-2018, <201805", required = false, arity = 1)
        public String modificationDate; 
    
        @Parameter(names = {"--internal-status"}, description = "Filter by internal status", required = false, arity = 1)
        public String internalStatus; 
    
        @Parameter(names = {"--attributes"}, description = "Attributes", required = false, arity = 1)
        public String attributes; 
    
    }

    @Parameters(commandNames = {"aggregationstats"}, commandDescription ="Fetch catalog project stats")
    public class AggregationStatsCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--projects"}, description = "Comma separated list of projects [user@]project up to a maximum of 100", required = true, arity = 1)
        public String projects; 
    
        @Parameter(names = {"--default"}, description = "Calculate default stats", required = false, arity = 1)
        public Boolean default_values; 
    
        @Parameter(names = {"--file-fields"}, description = "List of file fields separated by semicolons, e.g.: studies;type. For nested fields use >>, e.g.: studies>>biotype;type", required = false, arity = 1)
        public String fileFields; 
    
        @Parameter(names = {"--individual-fields"}, description = "List of individual fields separated by semicolons, e.g.: studies;type. For nested fields use >>, e.g.: studies>>biotype;type", required = false, arity = 1)
        public String individualFields; 
    
        @Parameter(names = {"--family-fields"}, description = "List of family fields separated by semicolons, e.g.: studies;type. For nested fields use >>, e.g.: studies>>biotype;type", required = false, arity = 1)
        public String familyFields; 
    
        @Parameter(names = {"--sample-fields"}, description = "List of sample fields separated by semicolons, e.g.: studies;type. For nested fields use >>, e.g.: studies>>biotype;type", required = false, arity = 1)
        public String sampleFields; 
    
        @Parameter(names = {"--cohort-fields"}, description = "List of cohort fields separated by semicolons, e.g.: studies;type. For nested fields use >>, e.g.: studies>>biotype;type", required = false, arity = 1)
        public String cohortFields; 
    
        @Parameter(names = {"--job-fields"}, description = "List of job fields separated by semicolons, e.g.: studies;type. For nested fields use >>, e.g.: studies>>biotype;type", required = false, arity = 1)
        public String jobFields; 
    
    }

    @Parameters(commandNames = {"info"}, commandDescription ="Fetch project information")
    public class InfoCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--include", "-I"}, description = "Fields included in the response, whole JSON path must be provided", required = false, arity = 1)
        public String include; 
    
        @Parameter(names = {"--exclude", "-E"}, description = "Fields excluded in the response, whole JSON path must be provided", required = false, arity = 1)
        public String exclude; 
    
        @Parameter(names = {"--projects"}, description = "Comma separated list of projects [user@]project up to a maximum of 100", required = true, arity = 1)
        public String projects; 
    
    }

    @Parameters(commandNames = {"increlease"}, commandDescription ="Increment current release number in the project")
    public class IncReleaseCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--json-file"}, description = "File with the body data in JSON format. Note, that using this parameter will ignore all the other parameters.", required = false, arity = 1)
        public String jsonFile;
    
        @Parameter(names = {"--json-data-model"}, description = "Show example of file structure for body data.", help = true, arity = 0)
        public Boolean jsonDataModel = false;
    
        @Parameter(names = {"--project", "-p"}, description = "Project [user@]project where project can be either the ID or the alias", required = true, arity = 1)
        public String project; 
    
    }

    @Parameters(commandNames = {"studies"}, commandDescription ="Fetch all the studies contained in the project")
    public class StudiesCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--include", "-I"}, description = "Fields included in the response, whole JSON path must be provided", required = false, arity = 1)
        public String include; 
    
        @Parameter(names = {"--exclude", "-E"}, description = "Fields excluded in the response, whole JSON path must be provided", required = false, arity = 1)
        public String exclude; 
    
        @Parameter(names = {"--limit"}, description = "Number of results to be returned", required = false, arity = 1)
        public Integer limit; 
    
        @Parameter(names = {"--skip"}, description = "Number of results to skip", required = false, arity = 1)
        public Integer skip; 
    
        @Parameter(names = {"--project", "-p"}, description = "Project [user@]project where project can be either the ID or the alias", required = true, arity = 1)
        public String project; 
    
    }

    @Parameters(commandNames = {"update"}, commandDescription ="Update some project attributes")
    public class UpdateCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--json-file"}, description = "File with the body data in JSON format. Note, that using this parameter will ignore all the other parameters.", required = false, arity = 1)
        public String jsonFile;
    
        @Parameter(names = {"--json-data-model"}, description = "Show example of file structure for body data.", help = true, arity = 0)
        public Boolean jsonDataModel = false;
    
        @Parameter(names = {"--include", "-I"}, description = "Fields included in the response, whole JSON path must be provided", required = false, arity = 1)
        public String include; 
    
        @Parameter(names = {"--exclude", "-E"}, description = "Fields excluded in the response, whole JSON path must be provided", required = false, arity = 1)
        public String exclude; 
    
        @Parameter(names = {"--project", "-p"}, description = "Project [user@]project where project can be either the ID or the alias", required = true, arity = 1)
        public String project; 
    
        @Parameter(names = {"--include-result"}, description = "Flag indicating to include the created or updated document result in the response", required = false, arity = 1)
        public Boolean includeResult; 
    
        @Parameter(names = {"--name", "-n"}, description = "The body web service name parameter", required = false, arity = 1)
        public String name;
    
        @Parameter(names = {"--description"}, description = "The body web service description parameter", required = false, arity = 1)
        public String description;
    
        @Parameter(names = {"--creation-date", "--cd"}, description = "The body web service creationDate parameter", required = false, arity = 1)
        public String creationDate;
    
        @Parameter(names = {"--modification-date", "--md"}, description = "The body web service modificationDate parameter", required = false, arity = 1)
        public String modificationDate;
    
        @Parameter(names = {"--organism-scientific-name"}, description = "The body web service scientificName parameter", required = false, arity = 1)
        public String organismScientificName;
    
        @Parameter(names = {"--organism-common-name"}, description = "The body web service commonName parameter", required = false, arity = 1)
        public String organismCommonName;
    
        @Parameter(names = {"--organism-assembly"}, description = "The body web service assembly parameter", required = false, arity = 1)
        public String organismAssembly;
    
    }

}