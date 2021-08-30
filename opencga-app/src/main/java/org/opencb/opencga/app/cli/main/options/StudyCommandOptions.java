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
 * This class contains methods for the Study command line.
 *    Command line version: 2.1.0
 *    PATH: studies
 */
@Parameters(commandNames = {"studies"}, commandDescription = "Study commands")
public class StudyCommandOptions {

        public JCommander jCommander;
        public CommonCommandOptions commonCommandOptions;

        public UpdateAclCommandOptions updateAclCommandOptions;
        public CreateCommandOptions createCommandOptions;
        public SearchCommandOptions searchCommandOptions;
        public AclCommandOptions aclCommandOptions;
        public AggregationStatsCommandOptions aggregationStatsCommandOptions;
        public InfoCommandOptions infoCommandOptions;
        public SearchAuditCommandOptions searchAuditCommandOptions;
        public GroupsCommandOptions groupsCommandOptions;
        public UpdateGroupsCommandOptions updateGroupsCommandOptions;
        public UpdateUsersCommandOptions updateUsersCommandOptions;
        public PermissionRulesCommandOptions permissionRulesCommandOptions;
        public UpdatePermissionRulesCommandOptions updatePermissionRulesCommandOptions;
        public RunTemplatesCommandOptions runTemplatesCommandOptions;
        public UploadTemplatesCommandOptions uploadTemplatesCommandOptions;
        public DeleteTemplatesCommandOptions deleteTemplatesCommandOptions;
        public UpdateCommandOptions updateCommandOptions;
        public VariableSetsCommandOptions variableSetsCommandOptions;
        public UpdateVariableSetsCommandOptions updateVariableSetsCommandOptions;
        public UpdateVariablesCommandOptions updateVariablesCommandOptions;


    public StudyCommandOptions(CommonCommandOptions commonCommandOptions, JCommander jCommander) {
    
        this.jCommander = jCommander;
        this.commonCommandOptions = commonCommandOptions;
        this.updateAclCommandOptions = new UpdateAclCommandOptions();
        this.createCommandOptions = new CreateCommandOptions();
        this.searchCommandOptions = new SearchCommandOptions();
        this.aclCommandOptions = new AclCommandOptions();
        this.aggregationStatsCommandOptions = new AggregationStatsCommandOptions();
        this.infoCommandOptions = new InfoCommandOptions();
        this.searchAuditCommandOptions = new SearchAuditCommandOptions();
        this.groupsCommandOptions = new GroupsCommandOptions();
        this.updateGroupsCommandOptions = new UpdateGroupsCommandOptions();
        this.updateUsersCommandOptions = new UpdateUsersCommandOptions();
        this.permissionRulesCommandOptions = new PermissionRulesCommandOptions();
        this.updatePermissionRulesCommandOptions = new UpdatePermissionRulesCommandOptions();
        this.runTemplatesCommandOptions = new RunTemplatesCommandOptions();
        this.uploadTemplatesCommandOptions = new UploadTemplatesCommandOptions();
        this.deleteTemplatesCommandOptions = new DeleteTemplatesCommandOptions();
        this.updateCommandOptions = new UpdateCommandOptions();
        this.variableSetsCommandOptions = new VariableSetsCommandOptions();
        this.updateVariableSetsCommandOptions = new UpdateVariableSetsCommandOptions();
        this.updateVariablesCommandOptions = new UpdateVariablesCommandOptions();
    
    }
    
    
    @Parameters(commandNames = {"update-acl"}, commandDescription = "Update the set of permissions granted for the member.")
    public class UpdateAclCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--members"}, description = "Comma separated list of user or group ids", required = true, arity = 1)
        public String members; 
    
        @Parameter(names = {"--action"}, description = "Action to be performed [ADD, SET, REMOVE or RESET].", required = true, arity = 1)
        public String action; 
    
        @Parameter(names = {"--study"}, description = "The body web service study parameter", required = false, arity = 1)
        public String study; 
    
        @Parameter(names = {"--template"}, description = "The body web service template parameter", required = false, arity = 1)
        public String template; 
    
  }
  
  
    @Parameters(commandNames = {"create"}, commandDescription = "Create a new study.")
    public class CreateCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--project"}, description = "Project [user@]project where project can be either the ID or the alias",
                              required = false, arity = 1)
        public String project; 
    
        @Parameter(names = {"--id"}, description = "The body web service id parameter", required = false, arity = 1)
        public String id; 
    
        @Parameter(names = {"--name"}, description = "The body web service name parameter", required = false, arity = 1)
        public String name; 
    
        @Parameter(names = {"--alias"}, description = "The body web service alias parameter", required = false, arity = 1)
        public String alias; 
    
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
  
  
    @Parameters(commandNames = {"search"}, commandDescription = "Search studies.")
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
    
        @Parameter(names = {"--project"}, description = "Project [user@]project where project can be either the ID or the alias",
                              required = true, arity = 1)
        public String project; 
    
        @Parameter(names = {"--name"}, description = "Study name", required = false, arity = 1)
        public String name; 
    
        @Parameter(names = {"--id"}, description = "Study ID", required = false, arity = 1)
        public String id; 
    
        @Parameter(names = {"--alias"}, description = "Study alias", required = false, arity = 1)
        public String alias; 
    
        @Parameter(names = {"--fqn"}, description = "Study full qualified name", required = false, arity = 1)
        public String fqn; 
    
        @Parameter(names = {"--creation-date"}, description = "Creation date. Format: yyyyMMddHHmmss. Examples: >2018, 2017-2018, "
                              + "<201805", required = false, arity = 1)
        public String creationDate; 
    
        @Parameter(names = {"--modification-date"}, description = "Modification date. Format: yyyyMMddHHmmss. Examples: >2018, "
                              + "2017-2018, <201805", required = false, arity = 1)
        public String modificationDate; 
    
        @Parameter(names = {"--internal-status"}, description = "Filter by internal status", required = false, arity = 1)
        public String internalStatus; 
    
        @Parameter(names = {"--status"}, description = "Filter by status", required = false, arity = 1)
        public String status; 
    
        @Parameter(names = {"--attributes"}, description = "Attributes", required = false, arity = 1)
        public String attributes; 
    
        @Parameter(names = {"--release"}, description = "Release value", required = false, arity = 1)
        public String release; 
    
  }
  
  
    @Parameters(commandNames = {"acl"}, commandDescription = "Return the acl of the study. If member is provided, it will only return the "
                              + "acl for the member.")
    public class AclCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--studies"}, description = "Comma separated list of Studies [[user@]project:]study where study and project "
                              + "can be either the ID or UUID up to a maximum of 100", required = true, arity = 1)
        public String studies; 
    
        @Parameter(names = {"--member"}, description = "User or group id", required = false, arity = 1)
        public String member; 
    
        @Parameter(names = {"--silent"}, description = "Boolean to retrieve all possible entries that are queried for, false to raise an "
                              + "exception whenever one of the entries looked for cannot be shown for whichever reason",
                              required = false, arity = 1)
        public boolean silent; 
    
  }
  
  
    @Parameters(commandNames = {"aggregation-stats"}, commandDescription = "Fetch catalog study stats.")
    public class AggregationStatsCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--studies"}, description = "Comma separated list of studies [[user@]project:]study up to a maximum of 100",
                              required = true, arity = 1)
        public String studies; 
    
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
  
  
    @Parameters(commandNames = {"info"}, commandDescription = "Fetch study information.")
    public class InfoCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--include"}, description = "Fields included in the response, whole JSON path must be provided",
                              required = false, arity = 1)
        public String include; 
    
        @Parameter(names = {"--exclude"}, description = "Fields excluded in the response, whole JSON path must be provided",
                              required = false, arity = 1)
        public String exclude; 
    
        @Parameter(names = {"--studies"}, description = "Comma separated list of Studies [[user@]project:]study where study and project "
                              + "can be either the ID or UUID up to a maximum of 100", required = true, arity = 1)
        public String studies; 
    
  }
  
  
    @Parameters(commandNames = {"search-audit"}, commandDescription = "Search audit collection.")
    public class SearchAuditCommandOptions {
    
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
    
        @Parameter(names = {"--study"}, description = "Study ID", required = true, arity = 1)
        public String study; 
    
        @Parameter(names = {"--operation-id"}, description = "Audit operation UUID", required = false, arity = 1)
        public String operationId; 
    
        @Parameter(names = {"--user-id"}, description = "User ID", required = false, arity = 1)
        public String userId; 
    
        @Parameter(names = {"--action"}, description = "Action performed by the user", required = false, arity = 1)
        public String action; 
    
        @Parameter(names = {"--resource"}, description = "Resource involved", required = false, arity = 1)
        public String resource; 
    
        @Parameter(names = {"--resource-id"}, description = "Resource ID", required = false, arity = 1)
        public String resourceId; 
    
        @Parameter(names = {"--resource-uuid"}, description = "resource UUID", required = false, arity = 1)
        public String resourceUuid; 
    
        @Parameter(names = {"--status"}, description = "Filter by status", required = false, arity = 1)
        public String status; 
    
        @Parameter(names = {"--date"}, description = "Date. Format: yyyyMMddHHmmss. Examples: >2018, 2017-2018, <201805",
                              required = false, arity = 1)
        public String date; 
    
  }
  
  
    @Parameters(commandNames = {"groups"}, commandDescription = "Return the groups present in the study. For owners and administrators "
                              + "only.")
    public class GroupsCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--study"}, description = "Study [[user@]project:]study where study and project can be either the ID or UUID",
                              required = true, arity = 1)
        public String study; 
    
        @Parameter(names = {"--id"}, description = "Group id. If provided, it will only fetch information for the provided group.",
                              required = false, arity = 1)
        public String id; 
    
        @Parameter(names = {"--silent"}, description = "Boolean to retrieve all possible entries that are queried for, false to raise an "
                              + "exception whenever one of the entries looked for cannot be shown for whichever reason",
                              required = false, arity = 1)
        public boolean silent; 
    
  }
  
  
    @Parameters(commandNames = {"update-groups"}, commandDescription = "Add or remove a group.")
    public class UpdateGroupsCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--study"}, description = "Study [[user@]project:]study where study and project can be either the ID or UUID",
                              required = false, arity = 1)
        public String study; 
    
        @Parameter(names = {"--action"}, description = "Action to be performed: ADD or REMOVE a group", required = false, arity = 1)
        public String action; 
    
        @Parameter(names = {"--id"}, description = "The body web service id parameter", required = false, arity = 1)
        public String id; 
    
  }
  
  
    @Parameters(commandNames = {"update-users"}, commandDescription = "Add, set or remove users from an existing group.")
    public class UpdateUsersCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--study"}, description = "Study [[user@]project:]study where study and project can be either the ID or UUID",
                              required = false, arity = 1)
        public String study; 
    
        @Parameter(names = {"--group"}, description = "Group name", required = false, arity = 1)
        public String group; 
    
        @Parameter(names = {"--action"}, description = "Action to be performed: ADD, SET or REMOVE users to/from a group",
                              required = false, arity = 1)
        public String action; 
    
  }
  
  
    @Parameters(commandNames = {"permission-rules"}, commandDescription = "Fetch permission rules.")
    public class PermissionRulesCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--study"}, description = "Study [[user@]project:]study where study and project can be either the ID or UUID",
                              required = true, arity = 1)
        public String study; 
    
        @Parameter(names = {"--entity"}, description = "Entity where the permission rules should be applied to", required = true, arity = 1)
        public String entity; 
    
  }
  
  
    @Parameters(commandNames = {"update-permission-rules"}, commandDescription = "Add or remove a permission rule.")
    public class UpdatePermissionRulesCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--study"}, description = "Study [[user@]project:]study where study and project can be either the ID or UUID",
                              required = false, arity = 1)
        public String study; 
    
        @Parameter(names = {"--entity"}, description = "Entity where the permission rules should be applied to", required = true, arity = 1)
        public String entity; 
    
        @Parameter(names = {"--action"}, description = "Action to be performed: ADD to add a new permission rule; REMOVE to remove all "
                              + "permissions assigned by an existing permission rule (even if it overlaps any manual permission); REVERT "
                              + "to remove all permissions assigned by an existing permission rule (keep manual overlaps); NONE to "
                              + "remove an existing permission rule without removing any permissions that could have been assigned "
                              + "already by the permission rule.", required = false, arity = 1)
        public String action; 
    
        @Parameter(names = {"--id"}, description = "The body web service id parameter", required = false, arity = 1)
        public String id; 
    
  }
  
  
    @Parameters(commandNames = {"run-templates"}, commandDescription = "Execute template.")
    public class RunTemplatesCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--study"}, description = "Study [[user@]project:]study where study and project can be either the ID or UUID",
                              required = false, arity = 1)
        public String study; 
    
        @Parameter(names = {"--job-id"}, description = "Job ID. It must be a unique string within the study. An ID will be autogenerated "
                              + "automatically if not provided.", required = false, arity = 1)
        public String jobId; 
    
        @Parameter(names = {"--job-depends-on"}, description = "Comma separated list of existing job IDs the job will depend on.",
                              required = false, arity = 1)
        public String jobDependsOn; 
    
        @Parameter(names = {"--job-description"}, description = "Job description", required = false, arity = 1)
        public String jobDescription; 
    
        @Parameter(names = {"--job-tags"}, description = "Job tags", required = false, arity = 1)
        public String jobTags; 
    
        @Parameter(names = {"--id"}, description = "The body web service id parameter", required = false, arity = 1)
        public String id; 
    
        @Parameter(names = {"--overwrite"}, description = "The body web service overwrite parameter", required = false, arity = 1)
        public boolean overwrite; 
    
        @Parameter(names = {"--resume"}, description = "The body web service resume parameter", required = false, arity = 1)
        public boolean resume; 
    
  }
  
  
    @Parameters(commandNames = {"upload-templates"}, commandDescription = "Resource to upload a zipped template.")
    public class UploadTemplatesCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--study"}, description = "Study [[user@]project:]study where study and project can be either the ID or UUID",
                              required = false, arity = 1)
        public String study; 
    
  }
  
  
    @Parameters(commandNames = {"delete-templates"}, commandDescription = "Delete template.")
    public class DeleteTemplatesCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--study"}, description = "Study [[user@]project:]study where study and project can be either the ID or UUID",
                              required = false, arity = 1)
        public String study; 
    
        @Parameter(names = {"--template-id"}, description = "Template id", required = false, arity = 1)
        public String templateId; 
    
  }
  
  
    @Parameters(commandNames = {"update"}, commandDescription = "Update some study attributes.")
    public class UpdateCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--study"}, description = "Study [[user@]project:]study where study and project can be either the ID or UUID",
                              required = true, arity = 1)
        public String study; 
    
        @Parameter(names = {"--name"}, description = "The body web service name parameter", required = false, arity = 1)
        public String name; 
    
        @Parameter(names = {"--alias"}, description = "The body web service alias parameter", required = false, arity = 1)
        public String alias; 
    
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
  
  
    @Parameters(commandNames = {"variable-sets"}, commandDescription = "Fetch variableSets from a study.")
    public class VariableSetsCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--study"}, description = "Study [[user@]project:]study where study and project can be either the ID or UUID",
                              required = true, arity = 1)
        public String study; 
    
        @Parameter(names = {"--id"}, description = "Id of the variableSet to be retrieved. If no id is passed, it will show all the "
                              + "variableSets of the study", required = false, arity = 1)
        public String id; 
    
  }
  
  
    @Parameters(commandNames = {"update-variable-sets"}, commandDescription = "Add or remove a variableSet.")
    public class UpdateVariableSetsCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--study"}, description = "Study [[user@]project:]study where study and project can be either the ID or UUID",
                              required = false, arity = 1)
        public String study; 
    
        @Parameter(names = {"--action"}, description = "Action to be performed: ADD or REMOVE a variableSet", required = false, arity = 1)
        public String action; 
    
        @Parameter(names = {"--id"}, description = "The body web service id parameter", required = false, arity = 1)
        public String id; 
    
        @Parameter(names = {"--name"}, description = "The body web service name parameter", required = false, arity = 1)
        public String name; 
    
        @Parameter(names = {"--description"}, description = "The body web service description parameter", required = false, arity = 1)
        public String description; 
    
  }
  
  
    @Parameters(commandNames = {"update-variables"}, commandDescription = "Add or remove variables to a VariableSet.")
    public class UpdateVariablesCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--study"}, description = "Study [[user@]project:]study where study and project can be either the ID or UUID",
                              required = false, arity = 1)
        public String study; 
    
        @Parameter(names = {"--variable-set"}, description = "VariableSet id of the VariableSet to be updated", required = false, arity = 1)
        public String variableSet; 
    
        @Parameter(names = {"--action"}, description = "Action to be performed: ADD or REMOVE a variable", required = false, arity = 1)
        public String action; 
    
        @Parameter(names = {"--id"}, description = "The body web service id parameter", required = false, arity = 1)
        public String id; 
    
        @Parameter(names = {"--name"}, description = "The body web service name parameter", required = false, arity = 1)
        public String name; 
    
        @Parameter(names = {"--category"}, description = "The body web service category parameter", required = false, arity = 1)
        public String category; 
    
        @Parameter(names = {"--default-value"}, description = "The body web service defaultValue parameter", required = false, arity = 1)
        public Object defaultValue; 
    
        @Parameter(names = {"--required"}, description = "The body web service required parameter", required = false, arity = 1)
        public boolean required; 
    
        @Parameter(names = {"--multi-value"}, description = "The body web service multiValue parameter", required = false, arity = 1)
        public boolean multiValue; 
    
        @Parameter(names = {"--rank"}, description = "The body web service rank parameter", required = false, arity = 1)
        public Long rank; 
    
        @Parameter(names = {"--depends-on"}, description = "The body web service dependsOn parameter", required = false, arity = 1)
        public String dependsOn; 
    
        @Parameter(names = {"--description"}, description = "The body web service description parameter", required = false, arity = 1)
        public String description; 
    
        @Parameter(names = {"--attributes"}, description = "The body web service attributes parameter", required = false, arity = 1)
        public Map attributes; 
    
  }
  
  
}
