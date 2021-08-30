/*
* Copyright 2015-2021 OpenCB
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

package org.opencb.opencga.app.cli.main.options;

import com.beust.jcommander.JCommander;
import java.util.Map;
import com.beust.jcommander.Parameters;
import static org.opencb.opencga.app.cli.GeneralCliOptions.*;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParametersDelegate;


/*
* WARNING: AUTOGENERATED CODE
*
* This code was generated by a tool.
* Autogenerated on: 2021-08-27 13:07:31
*
* Manual changes to this file may cause unexpected behavior in your application.
* Manual changes to this file will be overwritten if the code is regenerated.
*/


/**
 * This class contains methods for the Project command line.
 *    Command line version: 2.1.0
 *    PATH: projects
 */
@Parameters(commandNames = {"projects"}, commandDescription = "Project commands")
public class ProjectCommandOptions {

        public JCommander jCommander;
        public CommonCommandOptions commonCommandOptions;

        public CreateCommandOptions createCommandOptions;
        public SearchCommandOptions searchCommandOptions;
        public AggregationStatsCommandOptions aggregationStatsCommandOptions;
        public InfoCommandOptions infoCommandOptions;
        public IncReleaseCommandOptions incReleaseCommandOptions;
        public StudiesCommandOptions studiesCommandOptions;
        public UpdateCommandOptions updateCommandOptions;


    public ProjectCommandOptions(CommonCommandOptions commonCommandOptions, JCommander jCommander) {
    
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
    
    
    @Parameters(commandNames = {"create"}, commandDescription = "Create a new project.")
    public class CreateCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--id"}, description = "The body web service id parameter", required = false, arity = 1)
        public String id; 
    
        @Parameter(names = {"--name"}, description = "The body web service name parameter", required = false, arity = 1)
        public String name; 
    
        @Parameter(names = {"--description"}, description = "The body web service description parameter", required = false, arity = 1)
        public String description; 
    
        @Parameter(names = {"--creation-date"}, description = "The body web service creationDate parameter", required = false, arity = 1)
        public String creationDate; 
    
        @Parameter(names = {"--modification-date"}, description = "The body web service modificationDate parameter",
                              required = false, arity = 1)
        public String modificationDate; 
    
        @Parameter(names = {"--attributes"}, description = "The body web service attributes parameter", required = false, arity = 1)
        public Map attributes; 
    
  }
  
  
    @Parameters(commandNames = {"search"}, commandDescription = "Search projects.")
    public class SearchCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--include"}, description = "Fields included in the response, whole JSON path must be provided",
                              required = false, arity = 1)
        public String include; 
    
        @Parameter(names = {"--exclude"}, description = "Fields excluded in the response, whole JSON path must be provided",
                              required = false, arity = 1)
        public String exclude; 
    
        @Parameter(names = {"--limit"}, description = "Number of results to be returned", required = false, arity = 1)
        public int limit; 
    
        @Parameter(names = {"--skip"}, description = "Number of results to skip", required = false, arity = 1)
        public int skip; 
    
        @Parameter(names = {"--owner"}, description = "Owner of the project", required = false, arity = 1)
        public String owner; 
    
        @Parameter(names = {"--id"}, description = "Project [user@]project where project can be either the ID or the alias",
                              required = false, arity = 1)
        public String id; 
    
        @Parameter(names = {"--name"}, description = "Project name", required = false, arity = 1)
        public String name; 
    
        @Parameter(names = {"--fqn"}, description = "Project fqn", required = false, arity = 1)
        public String fqn; 
    
        @Parameter(names = {"--organization"}, description = "Project organization", required = false, arity = 1)
        public String organization; 
    
        @Parameter(names = {"--description"}, description = "Project description", required = false, arity = 1)
        public String description; 
    
        @Parameter(names = {"--study"}, description = "Study id", required = false, arity = 1)
        public String study; 
    
        @Parameter(names = {"--creation-date"}, description = "Creation date. Format: yyyyMMddHHmmss. Examples: >2018, 2017-2018, "
                              + "<201805", required = false, arity = 1)
        public String creationDate; 
    
        @Parameter(names = {"--modification-date"}, description = "Modification date. Format: yyyyMMddHHmmss. Examples: >2018, "
                              + "2017-2018, <201805", required = false, arity = 1)
        public String modificationDate; 
    
        @Parameter(names = {"--internal-status"}, description = "Filter by internal status", required = false, arity = 1)
        public String internalStatus; 
    
        @Parameter(names = {"--attributes"}, description = "Attributes", required = false, arity = 1)
        public String attributes; 
    
  }
  
  
    @Parameters(commandNames = {"aggregation-stats"}, commandDescription = "Fetch catalog project stats.")
    public class AggregationStatsCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--projects"}, description = "Comma separated list of projects [user@]project up to a maximum of 100",
                              required = true, arity = 1)
        public String projects; 
    
        @Parameter(names = {"--default"}, description = "Calculate default stats", required = false, arity = 1)
        public boolean defaultParam; 
    
        @Parameter(names = {"--file-fields"}, description = "List of file fields separated by semicolons, e.g.: studies;type. For nested "
                              + "fields use >>, e.g.: studies>>biotype;type", required = false, arity = 1)
        public String fileFields; 
    
        @Parameter(names = {"--individual-fields"}, description = "List of individual fields separated by semicolons, e.g.: "
                              + "studies;type. For nested fields use >>, e.g.: studies>>biotype;type", required = false, arity = 1)
        public String individualFields; 
    
        @Parameter(names = {"--family-fields"}, description = "List of family fields separated by semicolons, e.g.: studies;type. For "
                              + "nested fields use >>, e.g.: studies>>biotype;type", required = false, arity = 1)
        public String familyFields; 
    
        @Parameter(names = {"--sample-fields"}, description = "List of sample fields separated by semicolons, e.g.: studies;type. For "
                              + "nested fields use >>, e.g.: studies>>biotype;type", required = false, arity = 1)
        public String sampleFields; 
    
        @Parameter(names = {"--cohort-fields"}, description = "List of cohort fields separated by semicolons, e.g.: studies;type. For "
                              + "nested fields use >>, e.g.: studies>>biotype;type", required = false, arity = 1)
        public String cohortFields; 
    
        @Parameter(names = {"--job-fields"}, description = "List of job fields separated by semicolons, e.g.: studies;type. For nested "
                              + "fields use >>, e.g.: studies>>biotype;type", required = false, arity = 1)
        public String jobFields; 
    
  }
  
  
    @Parameters(commandNames = {"info"}, commandDescription = "Fetch project information.")
    public class InfoCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--include"}, description = "Fields included in the response, whole JSON path must be provided",
                              required = false, arity = 1)
        public String include; 
    
        @Parameter(names = {"--exclude"}, description = "Fields excluded in the response, whole JSON path must be provided",
                              required = false, arity = 1)
        public String exclude; 
    
        @Parameter(names = {"--projects"}, description = "Comma separated list of projects [user@]project up to a maximum of 100",
                              required = true, arity = 1)
        public String projects; 
    
  }
  
  
    @Parameters(commandNames = {"inc-release"}, commandDescription = "Increment current release number in the project.")
    public class IncReleaseCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--project"}, description = "Project [user@]project where project can be either the ID or the alias",
                              required = true, arity = 1)
        public String project; 
    
  }
  
  
    @Parameters(commandNames = {"studies"}, commandDescription = "Fetch all the studies contained in the project.")
    public class StudiesCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--include"}, description = "Fields included in the response, whole JSON path must be provided",
                              required = false, arity = 1)
        public String include; 
    
        @Parameter(names = {"--exclude"}, description = "Fields excluded in the response, whole JSON path must be provided",
                              required = false, arity = 1)
        public String exclude; 
    
        @Parameter(names = {"--limit"}, description = "Number of results to be returned", required = false, arity = 1)
        public int limit; 
    
        @Parameter(names = {"--skip"}, description = "Number of results to skip", required = false, arity = 1)
        public int skip; 
    
        @Parameter(names = {"--project"}, description = "Project [user@]project where project can be either the ID or the alias",
                              required = true, arity = 1)
        public String project; 
    
  }
  
  
    @Parameters(commandNames = {"update"}, commandDescription = "Update some project attributes.")
    public class UpdateCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--project"}, description = "Project [user@]project where project can be either the ID or the alias",
                              required = true, arity = 1)
        public String project; 
    
        @Parameter(names = {"--name"}, description = "The body web service name parameter", required = false, arity = 1)
        public String name; 
    
        @Parameter(names = {"--description"}, description = "The body web service description parameter", required = false, arity = 1)
        public String description; 
    
        @Parameter(names = {"--creation-date"}, description = "The body web service creationDate parameter", required = false, arity = 1)
        public String creationDate; 
    
        @Parameter(names = {"--modification-date"}, description = "The body web service modificationDate parameter",
                              required = false, arity = 1)
        public String modificationDate; 
    
        @Parameter(names = {"--attributes"}, description = "The body web service attributes parameter", required = false, arity = 1)
        public Map attributes; 
    
  }
  
  
}
