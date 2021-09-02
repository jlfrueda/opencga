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

import com.beust.jcommander.Parameters;
import com.beust.jcommander.ParametersDelegate;
import static org.opencb.opencga.app.cli.GeneralCliOptions.*;
import java.util.Map;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.JCommander;


/*
* WARNING: AUTOGENERATED CODE
*
* This code was generated by a tool.
* Autogenerated on: 2021-09-02 11:54:58
*
* Manual changes to this file may cause unexpected behavior in your application.
* Manual changes to this file will be overwritten if the code is regenerated.
*/


/**
 * This class contains methods for the Family command line.
 *    Command line version: 2.1.0
 *    PATH: families
 */

@Parameters(commandNames = {"families"}, commandDescription = "Family commands")
public class FamilyCommandOptions {

        public JCommander jCommander;
        public CommonCommandOptions commonCommandOptions;

        public UpdateAclCommandOptions updateAclCommandOptions;
        public AggregationStatsCommandOptions aggregationStatsCommandOptions;
        public LoadAnnotationSetsCommandOptions loadAnnotationSetsCommandOptions;
        public CreateCommandOptions createCommandOptions;
        public DistinctCommandOptions distinctCommandOptions;
        public SearchCommandOptions searchCommandOptions;
        public AclCommandOptions aclCommandOptions;
        public DeleteCommandOptions deleteCommandOptions;
        public InfoCommandOptions infoCommandOptions;
        public UpdateCommandOptions updateCommandOptions;
        public UpdateAnnotationsCommandOptions updateAnnotationsCommandOptions;


    public FamilyCommandOptions(CommonCommandOptions commonCommandOptions, JCommander jCommander) {
    
        this.jCommander = jCommander;
        this.commonCommandOptions = commonCommandOptions;
        this.updateAclCommandOptions = new UpdateAclCommandOptions();
        this.aggregationStatsCommandOptions = new AggregationStatsCommandOptions();
        this.loadAnnotationSetsCommandOptions = new LoadAnnotationSetsCommandOptions();
        this.createCommandOptions = new CreateCommandOptions();
        this.distinctCommandOptions = new DistinctCommandOptions();
        this.searchCommandOptions = new SearchCommandOptions();
        this.aclCommandOptions = new AclCommandOptions();
        this.deleteCommandOptions = new DeleteCommandOptions();
        this.infoCommandOptions = new InfoCommandOptions();
        this.updateCommandOptions = new UpdateCommandOptions();
        this.updateAnnotationsCommandOptions = new UpdateAnnotationsCommandOptions();
    
    }
    
    
    @Parameters(commandNames = {"update-acl"}, commandDescription = "Update the set of permissions granted for the member.")
    public class UpdateAclCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"-s","--study"}, description = "Study [[user@]project:]study where study and project can be either the ID or "
                              + "UUID", required = false, arity = 1)
        public String study; 
    
        @Parameter(names = {"--members"}, description = "Comma separated list of user or group ids", required = true, arity = 1)
        public String members; 
    
        @Parameter(names = {"--action"}, description = "Action to be performed [ADD, SET, REMOVE or RESET].", required = true, arity = 1)
        public String action; 
    
        @Parameter(names = {"--propagate"}, description = "Propagate family permissions to related individuals and samples",
                              required = false, arity = 1)
        public String propagate; 
    
        @Parameter(names = {"--family"}, description = "The body web service family parameter", required = false, arity = 1)
        public String family; 
    
        @Parameter(names = {"--individual"}, description = "The body web service individual parameter", required = false, arity = 1)
        public String individual; 
    
        @Parameter(names = {"--sample"}, description = "The body web service sample parameter", required = false, arity = 1)
        public String sample; 
    
  }
  
  
    @Parameters(commandNames = {"aggregation-stats"}, commandDescription = "Fetch catalog family stats.")
    public class AggregationStatsCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"-s","--study"}, description = "Study [[user@]project:]study where study and project can be either the ID or "
                              + "UUID", required = false, arity = 1)
        public String study; 
    
        @Parameter(names = {"--creation-year"}, description = "Creation year", required = false, arity = 1)
        public String creationYear; 
    
        @Parameter(names = {"--creation-month"}, description = "Creation month (JANUARY, FEBRUARY...)", required = false, arity = 1)
        public String creationMonth; 
    
        @Parameter(names = {"--creation-day"}, description = "Creation day", required = false, arity = 1)
        public String creationDay; 
    
        @Parameter(names = {"--creation-day-of-week"}, description = "Creation day of week (MONDAY, TUESDAY...)",
                              required = false, arity = 1)
        public String creationDayOfWeek; 
    
        @Parameter(names = {"--status"}, description = "Status", required = false, arity = 1)
        public String status; 
    
        @Parameter(names = {"--phenotypes"}, description = "Phenotypes", required = false, arity = 1)
        public String phenotypes; 
    
        @Parameter(names = {"--release"}, description = "Release", required = false, arity = 1)
        public String release; 
    
        @Parameter(names = {"--version"}, description = "Version", required = false, arity = 1)
        public String version; 
    
        @Parameter(names = {"--num-members"}, description = "Number of members", required = false, arity = 1)
        public String numMembers; 
    
        @Parameter(names = {"--expected-size"}, description = "Expected size", required = false, arity = 1)
        public String expectedSize; 
    
        @Parameter(names = {"--annotation"}, description = "Annotation filters. Example: age>30;gender=FEMALE. For more information, "
                              + "please visit http://docs.opencb.org/display/opencga/AnnotationSets+1.4.0", required = false, arity = 1)
        public String annotation; 
    
        @Parameter(names = {"--default"}, description = "Calculate default stats", required = false, arity = 1)
        public boolean defaultParam; 
    
        @Parameter(names = {"--field"}, description = "List of fields separated by semicolons, e.g.: studies;type. For nested fields use "
                              + ">>, e.g.: studies>>biotype;type;numSamples[0..10]:1", required = false, arity = 1)
        public String field; 
    
  }
  
  
    @Parameters(commandNames = {"load-annotation-sets"}, commandDescription = "Load annotation sets from a TSV file.")
    public class LoadAnnotationSetsCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"-s","--study"}, description = "Study [[user@]project:]study where study and project can be either the ID or "
                              + "UUID", required = false, arity = 1)
        public String study; 
    
        @Parameter(names = {"--variable-set-id"}, description = "Variable set ID or name", required = true, arity = 1)
        public String variableSetId; 
    
        @Parameter(names = {"--path"}, description = "Path where the TSV file is located in OpenCGA or where it should be located.",
                              required = true, arity = 1)
        public String path; 
    
        @Parameter(names = {"--parents"}, description = "Flag indicating whether to create parent directories if they don't exist (only "
                              + "when TSV file was not previously associated).", required = false, arity = 1)
        public boolean parents; 
    
        @Parameter(names = {"--annotation-set-id"}, description = "Annotation set id. If not provided, variableSetId will be used.",
                              required = false, arity = 1)
        public String annotationSetId; 
    
        @Parameter(names = {"--content"}, description = "The body web service content parameter", required = false, arity = 1)
        public String content; 
    
  }
  
  
    @Parameters(commandNames = {"create"}, commandDescription = "Create family and the individual objects if they do not exist.")
    public class CreateCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"-s","--study"}, description = "Study [[user@]project:]study where study and project can be either the ID or "
                              + "UUID", required = false, arity = 1)
        public String study; 
    
        @Parameter(names = {"--members"}, description = "Comma separated list of member ids to be associated to the created family",
                              required = false, arity = 1)
        public String members; 
    
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
  
  
    @Parameters(commandNames = {"distinct"}, commandDescription = "Family distinct method.")
    public class DistinctCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"-s","--study"}, description = "Study [[user@]project:]study where study and project can be either the id or "
                              + "alias.", required = false, arity = 1)
        public String study; 
    
        @Parameter(names = {"--name"}, description = "Family name", required = false, arity = 1)
        public String name; 
    
        @Parameter(names = {"--parental-consanguinity"}, description = "Parental consanguinity", required = false, arity = 1)
        public boolean parentalConsanguinity; 
    
        @Parameter(names = {"--members"}, description = "Comma separated list of individual ids or names", required = false, arity = 1)
        public String members; 
    
        @Parameter(names = {"--samples"}, description = "Comma separated list sample IDs or UUIDs up to a maximum of 100",
                              required = false, arity = 1)
        public String samples; 
    
        @Parameter(names = {"--phenotypes"}, description = "Comma separated list of phenotype ids or names", required = false, arity = 1)
        public String phenotypes; 
    
        @Parameter(names = {"--disorders"}, description = "Comma separated list of disorder ids or names", required = false, arity = 1)
        public String disorders; 
    
        @Parameter(names = {"--creation-date"}, description = "Creation date. Format: yyyyMMddHHmmss. Examples: >2018, 2017-2018, "
                              + "<201805", required = false, arity = 1)
        public String creationDate; 
    
        @Parameter(names = {"--modification-date"}, description = "Modification date. Format: yyyyMMddHHmmss. Examples: >2018, "
                              + "2017-2018, <201805", required = false, arity = 1)
        public String modificationDate; 
    
        @Parameter(names = {"--deleted"}, description = "Boolean to retrieve deleted families", required = false, arity = 1)
        public boolean deleted; 
    
        @Parameter(names = {"--annotationset-name"}, description = "DEPRECATED: Use annotation queryParam this way: "
                              + "annotationSet[=|==|!|!=]{annotationSetName}", required = false, arity = 1)
        public String annotationsetName; 
    
        @Parameter(names = {"--variable-set"}, description = "DEPRECATED: Use annotation queryParam this way: "
                              + "variableSet[=|==|!|!=]{variableSetId}", required = false, arity = 1)
        public String variableSet; 
    
        @Parameter(names = {"--internal-status"}, description = "Filter by internal status", required = false, arity = 1)
        public String internalStatus; 
    
        @Parameter(names = {"--status"}, description = "Filter by status", required = false, arity = 1)
        public String status; 
    
        @Parameter(names = {"--annotation"}, description = "Annotation filters. Example: age>30;gender=FEMALE. For more information, "
                              + "please visit http://docs.opencb.org/display/opencga/AnnotationSets+1.4.0", required = false, arity = 1)
        public String annotation; 
    
        @Parameter(names = {"--acl"}, description = "Filter entries for which a user has the provided permissions. Format: "
                              + "acl={user}:{permissions}. Example: acl=john:WRITE,WRITE_ANNOTATIONS will return all entries for which "
                              + "user john has both WRITE and WRITE_ANNOTATIONS permissions. Only study owners or administrators can "
                              + "query by this field. ", required = false, arity = 1)
        public String acl; 
    
        @Parameter(names = {"--release"}, description = "Release value (Current release from the moment the families were first created)",
                              required = false, arity = 1)
        public String release; 
    
        @Parameter(names = {"--snapshot"}, description = "Snapshot value (Latest version of families in the specified release)",
                              required = false, arity = 1)
        public int snapshot; 
    
        @Parameter(names = {"--field"}, description = "Field for which to obtain the distinct values", required = true, arity = 1)
        public String field; 
    
  }
  
  
    @Parameters(commandNames = {"search"}, commandDescription = "Search families.")
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
    
        @Parameter(names = {"--count"}, description = "Get the total number of results matching the query. Deactivated by default.",
                              required = false, arity = 1)
        public boolean count; 
    
        @Parameter(names = {"--flatten-annotations"}, description = "Flatten the annotations?", required = false, arity = 1)
        public boolean flattenAnnotations; 
    
        @Parameter(names = {"-s","--study"}, description = "Study [[user@]project:]study where study and project can be either the id or "
                              + "alias.", required = false, arity = 1)
        public String study; 
    
        @Parameter(names = {"--name"}, description = "Family name", required = false, arity = 1)
        public String name; 
    
        @Parameter(names = {"--parental-consanguinity"}, description = "Parental consanguinity", required = false, arity = 1)
        public boolean parentalConsanguinity; 
    
        @Parameter(names = {"--members"}, description = "Comma separated list of individual ids or names", required = false, arity = 1)
        public String members; 
    
        @Parameter(names = {"--samples"}, description = "Comma separated list sample IDs or UUIDs up to a maximum of 100",
                              required = false, arity = 1)
        public String samples; 
    
        @Parameter(names = {"--phenotypes"}, description = "Comma separated list of phenotype ids or names", required = false, arity = 1)
        public String phenotypes; 
    
        @Parameter(names = {"--disorders"}, description = "Comma separated list of disorder ids or names", required = false, arity = 1)
        public String disorders; 
    
        @Parameter(names = {"--creation-date"}, description = "Creation date. Format: yyyyMMddHHmmss. Examples: >2018, 2017-2018, "
                              + "<201805", required = false, arity = 1)
        public String creationDate; 
    
        @Parameter(names = {"--modification-date"}, description = "Modification date. Format: yyyyMMddHHmmss. Examples: >2018, "
                              + "2017-2018, <201805", required = false, arity = 1)
        public String modificationDate; 
    
        @Parameter(names = {"--deleted"}, description = "Boolean to retrieve deleted families", required = false, arity = 1)
        public boolean deleted; 
    
        @Parameter(names = {"--annotationset-name"}, description = "DEPRECATED: Use annotation queryParam this way: "
                              + "annotationSet[=|==|!|!=]{annotationSetName}", required = false, arity = 1)
        public String annotationsetName; 
    
        @Parameter(names = {"--variable-set"}, description = "DEPRECATED: Use annotation queryParam this way: "
                              + "variableSet[=|==|!|!=]{variableSetId}", required = false, arity = 1)
        public String variableSet; 
    
        @Parameter(names = {"--internal-status"}, description = "Filter by internal status", required = false, arity = 1)
        public String internalStatus; 
    
        @Parameter(names = {"--status"}, description = "Filter by status", required = false, arity = 1)
        public String status; 
    
        @Parameter(names = {"--annotation"}, description = "Annotation filters. Example: age>30;gender=FEMALE. For more information, "
                              + "please visit http://docs.opencb.org/display/opencga/AnnotationSets+1.4.0", required = false, arity = 1)
        public String annotation; 
    
        @Parameter(names = {"--acl"}, description = "Filter entries for which a user has the provided permissions. Format: "
                              + "acl={user}:{permissions}. Example: acl=john:WRITE,WRITE_ANNOTATIONS will return all entries for which "
                              + "user john has both WRITE and WRITE_ANNOTATIONS permissions. Only study owners or administrators can "
                              + "query by this field. ", required = false, arity = 1)
        public String acl; 
    
        @Parameter(names = {"--release"}, description = "Release value (Current release from the moment the families were first created)",
                              required = false, arity = 1)
        public String release; 
    
        @Parameter(names = {"--snapshot"}, description = "Snapshot value (Latest version of families in the specified release)",
                              required = false, arity = 1)
        public int snapshot; 
    
  }
  
  
    @Parameters(commandNames = {"acl"}, commandDescription = "Returns the acl of the families. If member is provided, it will only return "
                              + "the acl for the member.")
    public class AclCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--families"}, description = "Comma separated list of family IDs or names up to a maximum of 100",
                              required = true, arity = 1)
        public String families; 
    
        @Parameter(names = {"-s","--study"}, description = "Study [[user@]project:]study where study and project can be either the ID or "
                              + "UUID", required = false, arity = 1)
        public String study; 
    
        @Parameter(names = {"--member"}, description = "User or group id", required = false, arity = 1)
        public String member; 
    
        @Parameter(names = {"--silent"}, description = "Boolean to retrieve all possible entries that are queried for, false to raise an "
                              + "exception whenever one of the entries looked for cannot be shown for whichever reason",
                              required = false, arity = 1)
        public boolean silent; 
    
  }
  
  
    @Parameters(commandNames = {"delete"}, commandDescription = "Delete existing families.")
    public class DeleteCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"-s","--study"}, description = "Study [[user@]project:]study where study and project can be either the ID or "
                              + "UUID", required = false, arity = 1)
        public String study; 
    
        @Parameter(names = {"--families"}, description = "Comma separated list of family ids", required = false, arity = 1)
        public String families; 
    
  }
  
  
    @Parameters(commandNames = {"info"}, commandDescription = "Get family information.")
    public class InfoCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--include"}, description = "Fields included in the response, whole JSON path must be provided",
                              required = false, arity = 1)
        public String include; 
    
        @Parameter(names = {"--exclude"}, description = "Fields excluded in the response, whole JSON path must be provided",
                              required = false, arity = 1)
        public String exclude; 
    
        @Parameter(names = {"--flatten-annotations"}, description = "Flatten the annotations?", required = false, arity = 1)
        public boolean flattenAnnotations; 
    
        @Parameter(names = {"--families"}, description = "Comma separated list of family IDs or names up to a maximum of 100",
                              required = true, arity = 1)
        public String families; 
    
        @Parameter(names = {"-s","--study"}, description = "Study [[user@]project:]study where study and project can be either the ID or "
                              + "UUID", required = false, arity = 1)
        public String study; 
    
        @Parameter(names = {"--version"}, description = "Comma separated list of family versions. 'all' to get all the family versions. "
                              + "Not supported if multiple family ids are provided", required = false, arity = 1)
        public String version; 
    
        @Parameter(names = {"--deleted"}, description = "Boolean to retrieve deleted families", required = false, arity = 1)
        public boolean deleted; 
    
  }
  
  
    @Parameters(commandNames = {"update"}, commandDescription = "Update some family attributes.")
    public class UpdateCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--families"}, description = "Comma separated list of family ids", required = true, arity = 1)
        public String families; 
    
        @Parameter(names = {"-s","--study"}, description = "Study [[user@]project:]study where study and project can be either the ID or "
                              + "UUID", required = false, arity = 1)
        public String study; 
    
        @Parameter(names = {"--inc-version"}, description = "Create a new version of family", required = false, arity = 1)
        public boolean incVersion; 
    
        @Parameter(names = {"--update-roles"}, description = "Update the member roles within the family", required = false, arity = 1)
        public boolean updateRoles; 
    
        @Parameter(names = {"--annotation-sets-action"}, description = "Action to be performed if the array of annotationSets is being "
                              + "updated.", required = false, arity = 1)
        public String annotationSetsAction; 
    
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
  
  
    @Parameters(commandNames = {"update-annotations"}, commandDescription = "Update annotations from an annotationSet.")
    public class UpdateAnnotationsCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--family"}, description = "Family id", required = true, arity = 1)
        public String family; 
    
        @Parameter(names = {"-s","--study"}, description = "Study [[user@]project:]study where study and project can be either the ID or "
                              + "UUID", required = false, arity = 1)
        public String study; 
    
        @Parameter(names = {"--annotation-set"}, description = "AnnotationSet ID to be updated.", required = false, arity = 1)
        public String annotationSet; 
    
        @Parameter(names = {"--action"}, description = "Action to be performed: ADD to add new annotations; REPLACE to replace the value "
                              + "of an already existing annotation; SET to set the new list of annotations removing any possible old "
                              + "annotations; REMOVE to remove some annotations; RESET to set some annotations to the default value "
                              + "configured in the corresponding variables of the VariableSet if any.", required = false, arity = 1)
        public String action; 
    
        @Parameter(names = {"--inc-version"}, description = "Create a new version of family", required = false, arity = 1)
        public boolean incVersion; 
    
  }
  
  
}
