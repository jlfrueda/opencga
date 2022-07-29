package org.opencb.opencga.app.cli.main.options;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.beust.jcommander.DynamicParameter;
import com.beust.jcommander.ParametersDelegate;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.opencb.opencga.app.cli.main.parent.ParentStudiesCommandOptions;

import static org.opencb.opencga.app.cli.GeneralCliOptions.*;


/*
* WARNING: AUTOGENERATED CODE
*
* This code was generated by a tool.
* Autogenerated on: 2022-07-29
*
* Manual changes to this file may cause unexpected behavior in your application.
* Manual changes to this file will be overwritten if the code is regenerated.
*/


/**
 * This class contains methods for the Studies command line.
 *    OpenCGA version: 2.4.2-SNAPSHOT
 *    PATH: /{apiVersion}/studies
 */
@Parameters(commandNames = {"studies"}, commandDescription = "Studies commands")
public class StudiesCommandOptions extends ParentStudiesCommandOptions {


        public UpdateAclCommandOptions updateAclCommandOptions;
        public CreateCommandOptions createCommandOptions;
        public SearchCommandOptions searchCommandOptions;
        public AclCommandOptions aclCommandOptions;
        public AggregationStatsCommandOptions aggregationStatsCommandOptions;
        public InfoCommandOptions infoCommandOptions;
        public SearchAuditCommandOptions searchAuditCommandOptions;
        public GroupsCommandOptions groupsCommandOptions;
        public UpdateGroupsCommandOptions updateGroupsCommandOptions;
        public UpdateGroupsUsersCommandOptions updateGroupsUsersCommandOptions;
        public PermissionRulesCommandOptions permissionRulesCommandOptions;
        public UpdatePermissionRulesCommandOptions updatePermissionRulesCommandOptions;
        public RunTemplatesCommandOptions runTemplatesCommandOptions;
        public UploadTemplatesCommandOptions uploadTemplatesCommandOptions;
        public DeleteTemplatesCommandOptions deleteTemplatesCommandOptions;
        public UpdateCommandOptions updateCommandOptions;
        public VariableSetsCommandOptions variableSetsCommandOptions;
        public UpdateVariableSetsCommandOptions updateVariableSetsCommandOptions;
        public UpdateVariableSetsVariablesCommandOptions updateVariableSetsVariablesCommandOptions;


    public StudiesCommandOptions(CommonCommandOptions commonCommandOptions, JCommander jCommander) {
    
        super(commonCommandOptions,jCommander);
        this.updateAclCommandOptions = new UpdateAclCommandOptions();
        this.createCommandOptions = new CreateCommandOptions();
        this.searchCommandOptions = new SearchCommandOptions();
        this.aclCommandOptions = new AclCommandOptions();
        this.aggregationStatsCommandOptions = new AggregationStatsCommandOptions();
        this.infoCommandOptions = new InfoCommandOptions();
        this.searchAuditCommandOptions = new SearchAuditCommandOptions();
        this.groupsCommandOptions = new GroupsCommandOptions();
        this.updateGroupsCommandOptions = new UpdateGroupsCommandOptions();
        this.updateGroupsUsersCommandOptions = new UpdateGroupsUsersCommandOptions();
        this.permissionRulesCommandOptions = new PermissionRulesCommandOptions();
        this.updatePermissionRulesCommandOptions = new UpdatePermissionRulesCommandOptions();
        this.runTemplatesCommandOptions = new RunTemplatesCommandOptions();
        this.uploadTemplatesCommandOptions = new UploadTemplatesCommandOptions();
        this.deleteTemplatesCommandOptions = new DeleteTemplatesCommandOptions();
        this.updateCommandOptions = new UpdateCommandOptions();
        this.variableSetsCommandOptions = new VariableSetsCommandOptions();
        this.updateVariableSetsCommandOptions = new UpdateVariableSetsCommandOptions();
        this.updateVariableSetsVariablesCommandOptions = new UpdateVariableSetsVariablesCommandOptions();
    
    }
    
    @Parameters(commandNames = {"acl-update"}, commandDescription ="Update the set of permissions granted for the member")
    public class UpdateAclCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--json-file"}, description = "File with the body data in JSON format. Note, that using this parameter will ignore all the other parameters.", required = false, arity = 1)
        public String jsonFile;
    
        @Parameter(names = {"--json-data-model"}, description = "Show example of file structure for body data.", help = true, arity = 0)
        public Boolean jsonDataModel = false;
    
        @Parameter(names = {"--members"}, description = "Comma separated list of user or group ids", required = true, arity = 1)
        public String members; 
    
        @Parameter(names = {"--action"}, description = "Action to be performed [ADD, SET, REMOVE or RESET].", required = true, arity = 1)
        public String action; 
    
        @Parameter(names = {"--study", "-s"}, description = "The body web service study parameter", required = false, arity = 1)
        public String study;
    
        @Parameter(names = {"--template"}, description = "The body web service template parameter", required = false, arity = 1)
        public String template;
    
        @Parameter(names = {"--permissions"}, description = "The body web service permissions parameter", required = false, arity = 1)
        public String permissions;
    
    }

    @Parameters(commandNames = {"create"}, commandDescription ="Create a new study")
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
    
        @Parameter(names = {"--project", "-p"}, description = "Project [user@]project where project can be either the ID or the alias", required = false, arity = 1)
        public String project; 
    
        @Parameter(names = {"--include-result"}, description = "Flag indicating to include the created or updated document result in the response", required = false, arity = 1)
        public Boolean includeResult; 
    
        @Parameter(names = {"--id"}, description = "The body web service id parameter", required = true, arity = 1)
        public String id;
    
        @Parameter(names = {"--name", "-n"}, description = "The body web service name parameter", required = false, arity = 1)
        public String name;
    
        @Parameter(names = {"--alias"}, description = "The body web service alias parameter", required = false, arity = 1)
        public String alias;
    
        @Parameter(names = {"--type-id"}, description = "Object ID is a mandatory parameter when creating a new one, this ID cannot be changed at the moment.", required = false, arity = 1)
        public String typeId;
    
        @Parameter(names = {"--type-description"}, description = "Users may provide a description for the entry.", required = false, arity = 1)
        public String typeDescription;
    
        @Parameter(names = {"--description"}, description = "The body web service description parameter", required = false, arity = 1)
        public String description;
    
        @Parameter(names = {"--creation-date", "--cd"}, description = "The body web service creationDate parameter", required = false, arity = 1)
        public String creationDate;
    
        @Parameter(names = {"--modification-date", "--md"}, description = "The body web service modificationDate parameter", required = false, arity = 1)
        public String modificationDate;
    
        @Parameter(names = {"--status-id"}, description = "The body web service id parameter", required = false, arity = 1)
        public String statusId;
    
        @Parameter(names = {"--status-name"}, description = "The body web service name parameter", required = false, arity = 1)
        public String statusName;
    
        @Parameter(names = {"--status-description"}, description = "The body web service description parameter", required = false, arity = 1)
        public String statusDescription;
    
        @DynamicParameter(names = {"--attributes"}, description = "The body web service attributes parameter. Use: --attributes key=value", required = false)
        public java.util.Map<java.lang.String,java.lang.Object> attributes = new HashMap<>(); //Dynamic parameters must be initialized;
    
    }

    @Parameters(commandNames = {"search"}, commandDescription ="Search studies")
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
    
        @Parameter(names = {"--count"}, description = "Get the total number of results matching the query. Deactivated by default.", required = false, arity = 1)
        public Boolean count; 
    
        @Parameter(names = {"--project", "-p"}, description = "Project [user@]project where project can be either the ID or the alias", required = true, arity = 1)
        public String project; 
    
        @Parameter(names = {"--name", "-n"}, description = "Study name", required = false, arity = 1)
        public String name; 
    
        @Parameter(names = {"--id"}, description = "Study ID", required = false, arity = 1)
        public String id; 
    
        @Parameter(names = {"--alias"}, description = "Study alias", required = false, arity = 1)
        public String alias; 
    
        @Parameter(names = {"--fqn"}, description = "Study full qualified name", required = false, arity = 1)
        public String fqn; 
    
        @Parameter(names = {"--creation-date", "--cd"}, description = "Creation date. Format: yyyyMMddHHmmss. Examples: >2018, 2017-2018, <201805", required = false, arity = 1)
        public String creationDate; 
    
        @Parameter(names = {"--modification-date", "--md"}, description = "Modification date. Format: yyyyMMddHHmmss. Examples: >2018, 2017-2018, <201805", required = false, arity = 1)
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

    @Parameters(commandNames = {"acl"}, commandDescription ="Return the acl of the study. If member is provided, it will only return the acl for the member.")
    public class AclCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--studies"}, description = "Comma separated list of Studies [[user@]project:]study where study and project can be either the ID or UUID up to a maximum of 100", required = true, arity = 1)
        public String studies; 
    
        @Parameter(names = {"--member"}, description = "User or group id", required = false, arity = 1)
        public String member; 
    
        @Parameter(names = {"--silent"}, description = "Boolean to retrieve all possible entries that are queried for, false to raise an exception whenever one of the entries looked for cannot be shown for whichever reason", required = false, arity = 1)
        public Boolean silent; 
    
    }

    @Parameters(commandNames = {"aggregationstats"}, commandDescription ="Fetch catalog study stats")
    public class AggregationStatsCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--studies"}, description = "Comma separated list of studies [[user@]project:]study up to a maximum of 100", required = true, arity = 1)
        public String studies; 
    
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

    @Parameters(commandNames = {"info"}, commandDescription ="Fetch study information")
    public class InfoCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--include", "-I"}, description = "Fields included in the response, whole JSON path must be provided", required = false, arity = 1)
        public String include; 
    
        @Parameter(names = {"--exclude", "-E"}, description = "Fields excluded in the response, whole JSON path must be provided", required = false, arity = 1)
        public String exclude; 
    
        @Parameter(names = {"--studies"}, description = "Comma separated list of Studies [[user@]project:]study where study and project can be either the ID or UUID up to a maximum of 100", required = true, arity = 1)
        public String studies; 
    
    }

    @Parameters(commandNames = {"audit-search"}, commandDescription ="Search audit collection")
    public class SearchAuditCommandOptions {
    
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
    
        @Parameter(names = {"--count"}, description = "Get the total number of results matching the query. Deactivated by default.", required = false, arity = 1)
        public Boolean count; 
    
        @Parameter(names = {"--study", "-s"}, description = "Study ID", required = true, arity = 1)
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
    
        @Parameter(names = {"--date"}, description = "Date. Format: yyyyMMddHHmmss. Examples: >2018, 2017-2018, <201805", required = false, arity = 1)
        public String date; 
    
    }

    @Parameters(commandNames = {"groups"}, commandDescription ="Return the groups present in the study. For owners and administrators only.")
    public class GroupsCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--study", "-s"}, description = "Study [[user@]project:]study where study and project can be either the ID or UUID", required = true, arity = 1)
        public String study; 
    
        @Parameter(names = {"--id"}, description = "Group id. If provided, it will only fetch information for the provided group.", required = false, arity = 1)
        public String id; 
    
        @Parameter(names = {"--silent"}, description = "Boolean to retrieve all possible entries that are queried for, false to raise an exception whenever one of the entries looked for cannot be shown for whichever reason", required = false, arity = 1)
        public Boolean silent; 
    
    }

    @Parameters(commandNames = {"groups-update"}, commandDescription ="Add or remove a group")
    public class UpdateGroupsCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--json-file"}, description = "File with the body data in JSON format. Note, that using this parameter will ignore all the other parameters.", required = false, arity = 1)
        public String jsonFile;
    
        @Parameter(names = {"--json-data-model"}, description = "Show example of file structure for body data.", help = true, arity = 0)
        public Boolean jsonDataModel = false;
    
        @Parameter(names = {"--study", "-s"}, description = "Study [[user@]project:]study where study and project can be either the ID or UUID", required = true, arity = 1)
        public String study; 
    
        @Parameter(names = {"--action"}, description = "Action to be performed: ADD or REMOVE a group", required = false, arity = 1)
        public String action; 
    
        @Parameter(names = {"--id"}, description = "The body web service id parameter", required = false, arity = 1)
        public String id;
    
        @Parameter(names = {"--users"}, description = "The body web service users parameter", required = false, arity = 1)
        public String users;
    
    }

    @Parameters(commandNames = {"groups-users-update"}, commandDescription ="Add, set or remove users from an existing group")
    public class UpdateGroupsUsersCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--json-file"}, description = "File with the body data in JSON format. Note, that using this parameter will ignore all the other parameters.", required = false, arity = 1)
        public String jsonFile;
    
        @Parameter(names = {"--json-data-model"}, description = "Show example of file structure for body data.", help = true, arity = 0)
        public Boolean jsonDataModel = false;
    
        @Parameter(names = {"--study", "-s"}, description = "Study [[user@]project:]study where study and project can be either the ID or UUID", required = true, arity = 1)
        public String study; 
    
        @Parameter(names = {"--group"}, description = "Group name", required = true, arity = 1)
        public String group; 
    
        @Parameter(names = {"--action"}, description = "Action to be performed: ADD, SET or REMOVE users to/from a group", required = false, arity = 1)
        public String action; 
    
        @Parameter(names = {"--users"}, description = "The body web service users parameter", required = false, arity = 1)
        public String users;
    
    }

    @Parameters(commandNames = {"permissionrules"}, commandDescription ="Fetch permission rules")
    public class PermissionRulesCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--study", "-s"}, description = "Study [[user@]project:]study where study and project can be either the ID or UUID", required = true, arity = 1)
        public String study; 
    
        @Parameter(names = {"--entity"}, description = "Entity where the permission rules should be applied to", required = true, arity = 1)
        public String entity; 
    
    }

    @Parameters(commandNames = {"permission-rules-update"}, commandDescription ="Add or remove a permission rule")
    public class UpdatePermissionRulesCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--json-file"}, description = "File with the body data in JSON format. Note, that using this parameter will ignore all the other parameters.", required = false, arity = 1)
        public String jsonFile;
    
        @Parameter(names = {"--json-data-model"}, description = "Show example of file structure for body data.", help = true, arity = 0)
        public Boolean jsonDataModel = false;
    
        @Parameter(names = {"--study", "-s"}, description = "Study [[user@]project:]study where study and project can be either the ID or UUID", required = true, arity = 1)
        public String study; 
    
        @Parameter(names = {"--entity"}, description = "Entity where the permission rules should be applied to", required = true, arity = 1)
        public String entity; 
    
        @Parameter(names = {"--action"}, description = "Action to be performed: ADD to add a new permission rule; REMOVE to remove all permissions assigned by an existing permission rule (even if it overlaps any manual permission); REVERT to remove all permissions assigned by an existing permission rule (keep manual overlaps); NONE to remove an existing permission rule without removing any permissions that could have been assigned already by the permission rule.", required = false, arity = 1)
        public String action; 
    
        @Parameter(names = {"--id"}, description = "Object ID is a mandatory parameter when creating a new one, this ID cannot be changed at the moment.", required = false, arity = 1)
        public String id;
    
        @DynamicParameter(names = {"--query"}, description = "PermissionRule query.. Use: --query key=value", required = false)
        public Map<String, Object> query = new HashMap<>(); //Dynamic parameters must be initialized;
    
        @Parameter(names = {"--members"}, description = "List of members of the permission rule.", required = false, arity = 1)
        public String members;
    
        @Parameter(names = {"--permissions"}, description = "List of permissions of the permission rule.", required = false, arity = 1)
        public String permissions;
    
    }

    @Parameters(commandNames = {"templates-delete"}, commandDescription ="Delete template")
    public class DeleteTemplatesCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--study", "-s"}, description = "Study [[user@]project:]study where study and project can be either the ID or UUID", required = false, arity = 1)
        public String study; 
    
        @Parameter(names = {"--template-id"}, description = "Template id", required = true, arity = 1)
        public String templateId; 
    
    }

    @Parameters(commandNames = {"update"}, commandDescription ="Update some study attributes")
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
    
        @Parameter(names = {"--study", "-s"}, description = "Study [[user@]project:]study where study and project can be either the ID or UUID", required = true, arity = 1)
        public String study; 
    
        @Parameter(names = {"--include-result"}, description = "Flag indicating to include the created or updated document result in the response", required = false, arity = 1)
        public Boolean includeResult; 
    
        @Parameter(names = {"--name", "-n"}, description = "The body web service name parameter", required = false, arity = 1)
        public String name;
    
        @Parameter(names = {"--alias"}, description = "The body web service alias parameter", required = false, arity = 1)
        public String alias;
    
        @Parameter(names = {"--type-id"}, description = "Object ID is a mandatory parameter when creating a new one, this ID cannot be changed at the moment.", required = false, arity = 1)
        public String typeId;
    
        @Parameter(names = {"--type-description"}, description = "Users may provide a description for the entry.", required = false, arity = 1)
        public String typeDescription;
    
        @Parameter(names = {"--description"}, description = "The body web service description parameter", required = false, arity = 1)
        public String description;
    
        @Parameter(names = {"--creation-date", "--cd"}, description = "The body web service creationDate parameter", required = false, arity = 1)
        public String creationDate;
    
        @Parameter(names = {"--modification-date", "--md"}, description = "The body web service modificationDate parameter", required = false, arity = 1)
        public String modificationDate;
    
        @DynamicParameter(names = {"--attributes"}, description = "The body web service attributes parameter. Use: --attributes key=value", required = false)
        public java.util.Map<java.lang.String,java.lang.Object> attributes = new HashMap<>(); //Dynamic parameters must be initialized;
    
        @Parameter(names = {"--status-id"}, description = "The body web service id parameter", required = false, arity = 1)
        public String statusId;
    
        @Parameter(names = {"--status-name"}, description = "The body web service name parameter", required = false, arity = 1)
        public String statusName;
    
        @Parameter(names = {"--status-description"}, description = "The body web service description parameter", required = false, arity = 1)
        public String statusDescription;
    
    }

    @Parameters(commandNames = {"variablesets"}, commandDescription ="Fetch variableSets from a study")
    public class VariableSetsCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--study", "-s"}, description = "Study [[user@]project:]study where study and project can be either the ID or UUID", required = true, arity = 1)
        public String study; 
    
        @Parameter(names = {"--id"}, description = "Id of the variableSet to be retrieved. If no id is passed, it will show all the variableSets of the study", required = false, arity = 1)
        public String id; 
    
    }

    @Parameters(commandNames = {"variable-sets-update"}, commandDescription ="Add or remove a variableSet")
    public class UpdateVariableSetsCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--json-file"}, description = "File with the body data in JSON format. Note, that using this parameter will ignore all the other parameters.", required = false, arity = 1)
        public String jsonFile;
    
        @Parameter(names = {"--json-data-model"}, description = "Show example of file structure for body data.", help = true, arity = 0)
        public Boolean jsonDataModel = false;
    
        @Parameter(names = {"--study", "-s"}, description = "Study [[user@]project:]study where study and project can be either the ID or UUID", required = true, arity = 1)
        public String study; 
    
        @Parameter(names = {"--action"}, description = "Action to be performed: ADD, REMOVE or FORCE_REMOVE a variableSet", required = false, arity = 1)
        public String action; 
    
        @Parameter(names = {"--id"}, description = "The body web service id parameter", required = false, arity = 1)
        public String id;
    
        @Parameter(names = {"--name", "-n"}, description = "The body web service name parameter", required = false, arity = 1)
        public String name;
    
        @Parameter(names = {"--unique"}, description = "The body web service unique parameter", required = false, arity = 1)
        public Boolean unique;
    
        @Parameter(names = {"--confidential"}, description = "The body web service confidential parameter", required = false, arity = 1)
        public Boolean confidential;
    
        @Parameter(names = {"--description"}, description = "The body web service description parameter", required = false, arity = 1)
        public String description;
    
    }

    @Parameters(commandNames = {"variable-sets-variables-update"}, commandDescription ="Add or remove variables to a VariableSet")
    public class UpdateVariableSetsVariablesCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--json-file"}, description = "File with the body data in JSON format. Note, that using this parameter will ignore all the other parameters.", required = false, arity = 1)
        public String jsonFile;
    
        @Parameter(names = {"--json-data-model"}, description = "Show example of file structure for body data.", help = true, arity = 0)
        public Boolean jsonDataModel = false;
    
        @Parameter(names = {"--study", "-s"}, description = "Study [[user@]project:]study where study and project can be either the ID or UUID", required = true, arity = 1)
        public String study; 
    
        @Parameter(names = {"--variable-set"}, description = "VariableSet id of the VariableSet to be updated", required = true, arity = 1)
        public String variableSet; 
    
        @Parameter(names = {"--action"}, description = "Action to be performed: ADD or REMOVE a variable", required = false, arity = 1)
        public String action; 
    
        @Parameter(names = {"--body_id"}, description = "The body web service id parameter", required = false, arity = 1)
        public String bodyId;
    
        @Parameter(names = {"--body_name"}, description = "The body web service name parameter", required = false, arity = 1)
        public String bodyName;
    
        @Parameter(names = {"--body_category"}, description = "The body web service category parameter", required = false, arity = 1)
        public String bodyCategory;
    
        @Parameter(names = {"--body_type"}, description = "Enum param allowed values: BOOLEAN, CATEGORICAL, INTEGER, DOUBLE, TEXT, STRING, OBJECT, MAP_BOOLEAN, MAP_INTEGER, MAP_DOUBLE, MAP_STRING", required = false, arity = 1)
        public String bodyType;
    
        @Parameter(names = {"--body_required"}, description = "The body web service required parameter", required = false, arity = 1)
        public Boolean bodyRequired;
    
        @Parameter(names = {"--body_multi-value"}, description = "The body web service multiValue parameter", required = false, arity = 1)
        public Boolean bodyMultiValue;
    
        @Parameter(names = {"--body_allowed-values"}, description = "The body web service allowedValues parameter", required = false, arity = 1)
        public String bodyAllowedValues;
    
        @Parameter(names = {"--body_allowed-keys"}, description = "The body web service allowedKeys parameter", required = false, arity = 1)
        public String bodyAllowedKeys;
    
        @Parameter(names = {"--body_rank"}, description = "The body web service rank parameter", required = false, arity = 1)
        public Long bodyRank;
    
        @Parameter(names = {"--body_depends-on"}, description = "The body web service dependsOn parameter", required = false, arity = 1)
        public String bodyDependsOn;
    
        @Parameter(names = {"--body_description"}, description = "The body web service description parameter", required = false, arity = 1)
        public String bodyDescription;
    
        @DynamicParameter(names = {"--body_attributes"}, description = "The body web service attributes parameter. Use: --body_attributes key=value", required = false)
        public java.util.Map<java.lang.String,java.lang.Object> bodyAttributes = new HashMap<>(); //Dynamic parameters must be initialized;
    
    }

}