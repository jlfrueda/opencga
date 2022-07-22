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
<<<<<<< HEAD
* Autogenerated on: 2022-06-21
=======
* Autogenerated on: 2022-07-13
>>>>>>> release-2.2.x
*
* Manual changes to this file may cause unexpected behavior in your application.
* Manual changes to this file will be overwritten if the code is regenerated.
*/


/**
 * This class contains methods for the Families command line.
<<<<<<< HEAD
 *    OpenCGA version: 2.3.1-SNAPSHOT
=======
 *    OpenCGA version: 2.2.4-SNAPSHOT
>>>>>>> release-2.2.x
 *    PATH: /{apiVersion}/families
 */
@Parameters(commandNames = {"families"}, commandDescription = "Families commands")
public class FamiliesCommandOptions {

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
        public UpdateAnnotationSetsAnnotationsCommandOptions updateAnnotationSetsAnnotationsCommandOptions;


    public FamiliesCommandOptions(CommonCommandOptions commonCommandOptions, JCommander jCommander) {
    
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
        this.updateAnnotationSetsAnnotationsCommandOptions = new UpdateAnnotationSetsAnnotationsCommandOptions();
    
    }
    
    @Parameters(commandNames = {"acl-update"}, commandDescription ="Update the set of permissions granted for the member")
    public class UpdateAclCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--json-file"}, description = "File with the body data in JSON format. Note, that using this parameter will ignore all the other parameters.", required = false, arity = 1)
        public String jsonFile;
    
        @Parameter(names = {"--json-data-model"}, description = "Show example of file structure for body data.", help = true, arity = 0)
        public Boolean jsonDataModel = false;
    
        @Parameter(names = {"--study", "-s"}, description = "Study [[user@]project:]study where study and project can be either the ID or UUID", required = false, arity = 1)
        public String study; 
    
        @Parameter(names = {"--members"}, description = "Comma separated list of user or group ids", required = true, arity = 1)
        public String members; 
    
        @Parameter(names = {"--action"}, description = "Action to be performed [ADD, SET, REMOVE or RESET].", required = true, arity = 1)
        public String action; 
    
        @Parameter(names = {"--propagate"}, description = "Propagate family permissions to related individuals and samples", required = false, arity = 1)
        public String propagate; 
    
        @Parameter(names = {"--permissions"}, description = "The body web service permissions parameter", required = true, arity = 1)
        public String permissions;
    
        @Parameter(names = {"--family"}, description = "The body web service family parameter", required = false, arity = 1)
        public String family;
    
        @Parameter(names = {"--individual"}, description = "The body web service individual parameter", required = false, arity = 1)
        public String individual;
    
        @Parameter(names = {"--sample"}, description = "The body web service sample parameter", required = false, arity = 1)
        public String sample;
    
    }

    @Parameters(commandNames = {"aggregationstats"}, commandDescription ="Fetch catalog family stats")
    public class AggregationStatsCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--study", "-s"}, description = "Study [[user@]project:]study where study and project can be either the ID or UUID", required = false, arity = 1)
        public String study; 
    
        @Parameter(names = {"--creation-year"}, description = "Creation year", required = false, arity = 1)
        public String creationYear; 
    
        @Parameter(names = {"--creation-month"}, description = "Creation month (JANUARY, FEBRUARY...)", required = false, arity = 1)
        public String creationMonth; 
    
        @Parameter(names = {"--creation-day"}, description = "Creation day", required = false, arity = 1)
        public String creationDay; 
    
        @Parameter(names = {"--creation-day-of-week"}, description = "Creation day of week (MONDAY, TUESDAY...)", required = false, arity = 1)
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
    
        @Parameter(names = {"--annotation"}, description = "Annotation filters. Example: age>30;gender=FEMALE. For more information, please visit http://docs.opencb.org/display/opencga/AnnotationSets+1.4.0", required = false, arity = 1)
        public String annotation; 
    
        @Parameter(names = {"--default"}, description = "Calculate default stats", required = false, arity = 1)
        public Boolean default_values; 
    
        @Parameter(names = {"--field"}, description = "List of fields separated by semicolons, e.g.: studies;type. For nested fields use >>, e.g.: studies>>biotype;type;numSamples[0..10]:1", required = false, arity = 1)
        public String field; 
    
    }

    @Parameters(commandNames = {"annotation-sets-load"}, commandDescription ="Load annotation sets from a TSV file")
    public class LoadAnnotationSetsCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--json-file"}, description = "File with the body data in JSON format. Note, that using this parameter will ignore all the other parameters.", required = false, arity = 1)
        public String jsonFile;
    
        @Parameter(names = {"--json-data-model"}, description = "Show example of file structure for body data.", help = true, arity = 0)
        public Boolean jsonDataModel = false;
    
        @Parameter(names = {"--study", "-s"}, description = "Study [[user@]project:]study where study and project can be either the ID or UUID", required = false, arity = 1)
        public String study; 
    
        @Parameter(names = {"--variable-set-id"}, description = "Variable set ID or name", required = true, arity = 1)
        public String variableSetId; 
    
        @Parameter(names = {"--path"}, description = "Path where the TSV file is located in OpenCGA or where it should be located.", required = true, arity = 1)
        public String path; 
    
        @Parameter(names = {"--parents"}, description = "Flag indicating whether to create parent directories if they don't exist (only when TSV file was not previously associated).", required = false, arity = 1)
        public Boolean parents; 
    
        @Parameter(names = {"--annotation-set-id"}, description = "Annotation set id. If not provided, variableSetId will be used.", required = false, arity = 1)
        public String annotationSetId; 
    
        @Parameter(names = {"--content"}, description = "The body web service content parameter", required = false, arity = 1)
        public String content;
    
    }

    @Parameters(commandNames = {"create"}, commandDescription ="Create family and the individual objects if they do not exist")
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
    
        @Parameter(names = {"--study", "-s"}, description = "Study [[user@]project:]study where study and project can be either the ID or UUID", required = false, arity = 1)
        public String study; 
    
        @Parameter(names = {"--members"}, description = "Comma separated list of member ids to be associated to the created family", required = false, arity = 1)
        public String members; 
    
        @Parameter(names = {"--include-result"}, description = "Flag indicating to include the created or updated document result in the response", required = false, arity = 1)
        public Boolean includeResult; 
    
        @Parameter(names = {"--body_id"}, description = "The body web service id parameter", required = false, arity = 1)
        public String bodyId;
    
        @Parameter(names = {"--body_name"}, description = "The body web service name parameter", required = false, arity = 1)
        public String bodyName;
    
        @Parameter(names = {"--body_description"}, description = "The body web service description parameter", required = false, arity = 1)
        public String bodyDescription;
    
        @Parameter(names = {"--body_creation-date"}, description = "The body web service creationDate parameter", required = false, arity = 1)
        public String bodyCreationDate;
    
        @Parameter(names = {"--body_modification-date"}, description = "The body web service modificationDate parameter", required = false, arity = 1)
        public String bodyModificationDate;
    
        @Parameter(names = {"--body_expected-size"}, description = "The body web service expectedSize parameter", required = false, arity = 1)
        public Integer bodyExpectedSize;
    
        @Parameter(names = {"--status-id"}, description = "The body web service id parameter", required = false, arity = 1)
        public String statusId;
    
        @Parameter(names = {"--status-name"}, description = "The body web service name parameter", required = false, arity = 1)
        public String statusName;
    
        @Parameter(names = {"--status-description"}, description = "The body web service description parameter", required = false, arity = 1)
        public String statusDescription;
    
        @DynamicParameter(names = {"--body_attributes"}, description = "The body web service attributes parameter. Use: --body_attributes key=value", required = false)
        public java.util.Map<java.lang.String,java.lang.Object> bodyAttributes = new HashMap<>(); //Dynamic parameters must be initialized;
    
    }

    @Parameters(commandNames = {"distinct"}, commandDescription ="Family distinct method")
    public class DistinctCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--study", "-s"}, description = "Study [[user@]project:]study where study and project can be either the ID or UUID", required = false, arity = 1)
        public String study; 
    
        @Parameter(names = {"--id"}, description = "Comma separated list family IDs up to a maximum of 100", required = false, arity = 1)
        public String id; 
    
        @Parameter(names = {"--name", "-n"}, description = "Comma separated list family names up to a maximum of 100", required = false, arity = 1)
        public String name; 
    
        @Parameter(names = {"--uuid"}, description = "Comma separated list family UUIDs up to a maximum of 100", required = false, arity = 1)
        public String uuid; 
    
        @Parameter(names = {"--members"}, description = "Comma separated list of family members", required = false, arity = 1)
        public String members; 
    
        @Parameter(names = {"--expected-size"}, description = "Expected size of the family (number of members)", required = false, arity = 1)
        public Integer expectedSize; 
    
        @Parameter(names = {"--samples"}, description = "Comma separated list of member's samples", required = false, arity = 1)
        public String samples; 
    
        @Parameter(names = {"--phenotypes"}, description = "Comma separated list of phenotype ids or names", required = false, arity = 1)
        public String phenotypes; 
    
        @Parameter(names = {"--disorders"}, description = "Comma separated list of disorder ids or names", required = false, arity = 1)
        public String disorders; 
    
        @Parameter(names = {"--creation-date", "--cd"}, description = "Creation date. Format: yyyyMMddHHmmss. Examples: >2018, 2017-2018, <201805", required = false, arity = 1)
        public String creationDate; 
    
        @Parameter(names = {"--modification-date", "--md"}, description = "Modification date. Format: yyyyMMddHHmmss. Examples: >2018, 2017-2018, <201805", required = false, arity = 1)
        public String modificationDate; 
    
        @Parameter(names = {"--deleted"}, description = "Boolean to retrieve deleted entries", required = false, arity = 1)
        public Boolean deleted; 
    
        @Parameter(names = {"--internal-status"}, description = "Filter by internal status", required = false, arity = 1)
        public String internalStatus; 
    
        @Parameter(names = {"--status"}, description = "Filter by status", required = false, arity = 1)
        public String status; 
    
        @Parameter(names = {"--annotation"}, description = "Annotation filters. Example: age>30;gender=FEMALE. For more information, please visit http://docs.opencb.org/display/opencga/AnnotationSets+1.4.0", required = false, arity = 1)
        public String annotation; 
    
        @Parameter(names = {"--acl"}, description = "Filter entries for which a user has the provided permissions. Format: acl={user}:{permissions}. Example: acl=john:WRITE,WRITE_ANNOTATIONS will return all entries for which user john has both WRITE and WRITE_ANNOTATIONS permissions. Only study owners or administrators can query by this field. ", required = false, arity = 1)
        public String acl; 
    
        @Parameter(names = {"--release"}, description = "Release when it was created", required = false, arity = 1)
        public String release; 
    
        @Parameter(names = {"--snapshot"}, description = "Snapshot value (Latest version of the entry in the specified release)", required = false, arity = 1)
        public Integer snapshot; 
    
        @Parameter(names = {"--field"}, description = "Field for which to obtain the distinct values", required = true, arity = 1)
        public String field; 
    
    }

    @Parameters(commandNames = {"search"}, commandDescription ="Search families")
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
    
        @Parameter(names = {"--flatten-annotations"}, description = "Flatten the annotations?", required = false, arity = 1)
        public Boolean flattenAnnotations; 
    
        @Parameter(names = {"--study", "-s"}, description = "Study [[user@]project:]study where study and project can be either the ID or UUID", required = false, arity = 1)
        public String study; 
    
        @Parameter(names = {"--id"}, description = "Comma separated list family IDs up to a maximum of 100", required = false, arity = 1)
        public String id; 
    
        @Parameter(names = {"--name", "-n"}, description = "Comma separated list family names up to a maximum of 100", required = false, arity = 1)
        public String name; 
    
        @Parameter(names = {"--uuid"}, description = "Comma separated list family UUIDs up to a maximum of 100", required = false, arity = 1)
        public String uuid; 
    
        @Parameter(names = {"--members"}, description = "Comma separated list of family members", required = false, arity = 1)
        public String members; 
    
        @Parameter(names = {"--expected-size"}, description = "Expected size of the family (number of members)", required = false, arity = 1)
        public Integer expectedSize; 
    
        @Parameter(names = {"--samples"}, description = "Comma separated list of member's samples", required = false, arity = 1)
        public String samples; 
    
        @Parameter(names = {"--phenotypes"}, description = "Comma separated list of phenotype ids or names", required = false, arity = 1)
        public String phenotypes; 
    
        @Parameter(names = {"--disorders"}, description = "Comma separated list of disorder ids or names", required = false, arity = 1)
        public String disorders; 
    
        @Parameter(names = {"--creation-date", "--cd"}, description = "Creation date. Format: yyyyMMddHHmmss. Examples: >2018, 2017-2018, <201805", required = false, arity = 1)
        public String creationDate; 
    
        @Parameter(names = {"--modification-date", "--md"}, description = "Modification date. Format: yyyyMMddHHmmss. Examples: >2018, 2017-2018, <201805", required = false, arity = 1)
        public String modificationDate; 
    
        @Parameter(names = {"--deleted"}, description = "Boolean to retrieve deleted entries", required = false, arity = 1)
        public Boolean deleted; 
    
        @Parameter(names = {"--internal-status"}, description = "Filter by internal status", required = false, arity = 1)
        public String internalStatus; 
    
        @Parameter(names = {"--status"}, description = "Filter by status", required = false, arity = 1)
        public String status; 
    
        @Parameter(names = {"--annotation"}, description = "Annotation filters. Example: age>30;gender=FEMALE. For more information, please visit http://docs.opencb.org/display/opencga/AnnotationSets+1.4.0", required = false, arity = 1)
        public String annotation; 
    
        @Parameter(names = {"--acl"}, description = "Filter entries for which a user has the provided permissions. Format: acl={user}:{permissions}. Example: acl=john:WRITE,WRITE_ANNOTATIONS will return all entries for which user john has both WRITE and WRITE_ANNOTATIONS permissions. Only study owners or administrators can query by this field. ", required = false, arity = 1)
        public String acl; 
    
        @Parameter(names = {"--release"}, description = "Release when it was created", required = false, arity = 1)
        public String release; 
    
        @Parameter(names = {"--snapshot"}, description = "Snapshot value (Latest version of the entry in the specified release)", required = false, arity = 1)
        public Integer snapshot; 
    
    }

    @Parameters(commandNames = {"acl"}, commandDescription ="Returns the acl of the families. If member is provided, it will only return the acl for the member.")
    public class AclCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--families"}, description = "Comma separated list of family IDs or names up to a maximum of 100", required = true, arity = 1)
        public String families; 
    
        @Parameter(names = {"--study", "-s"}, description = "Study [[user@]project:]study where study and project can be either the ID or UUID", required = false, arity = 1)
        public String study; 
    
        @Parameter(names = {"--member"}, description = "User or group id", required = false, arity = 1)
        public String member; 
    
        @Parameter(names = {"--silent"}, description = "Boolean to retrieve all possible entries that are queried for, false to raise an exception whenever one of the entries looked for cannot be shown for whichever reason", required = false, arity = 1)
        public Boolean silent; 
    
    }

    @Parameters(commandNames = {"delete"}, commandDescription ="Delete existing families")
    public class DeleteCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--study", "-s"}, description = "Study [[user@]project:]study where study and project can be either the ID or UUID", required = false, arity = 1)
        public String study; 
    
        @Parameter(names = {"--families"}, description = "Comma separated list of family ids", required = true, arity = 1)
        public String families; 
    
    }

    @Parameters(commandNames = {"info"}, commandDescription ="Get family information")
    public class InfoCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--include", "-I"}, description = "Fields included in the response, whole JSON path must be provided", required = false, arity = 1)
        public String include; 
    
        @Parameter(names = {"--exclude", "-E"}, description = "Fields excluded in the response, whole JSON path must be provided", required = false, arity = 1)
        public String exclude; 
    
        @Parameter(names = {"--flatten-annotations"}, description = "Flatten the annotations?", required = false, arity = 1)
        public Boolean flattenAnnotations; 
    
        @Parameter(names = {"--families"}, description = "Comma separated list of family IDs or names up to a maximum of 100", required = true, arity = 1)
        public String families; 
    
        @Parameter(names = {"--study", "-s"}, description = "Study [[user@]project:]study where study and project can be either the ID or UUID", required = false, arity = 1)
        public String study; 
    
        @Parameter(names = {"--version"}, description = "Comma separated list of family versions. 'all' to get all the family versions. Not supported if multiple family ids are provided", required = false, arity = 1)
        public String version; 
    
        @Parameter(names = {"--deleted"}, description = "Boolean to retrieve deleted families", required = false, arity = 1)
        public Boolean deleted; 
    
    }

    @Parameters(commandNames = {"update"}, commandDescription ="Update some family attributes")
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
    
        @Parameter(names = {"--families"}, description = "Comma separated list of family ids", required = true, arity = 1)
        public String families; 
    
        @Parameter(names = {"--study", "-s"}, description = "Study [[user@]project:]study where study and project can be either the ID or UUID", required = false, arity = 1)
        public String study; 
    
        @Parameter(names = {"--update-roles"}, description = "Update the member roles within the family", required = false, arity = 1)
        public Boolean updateRoles; 
    
        @Parameter(names = {"--include-result"}, description = "Flag indicating to include the created or updated document result in the response", required = false, arity = 1)
        public Boolean includeResult; 
    
        @Parameter(names = {"--id"}, description = "The body web service id parameter", required = false, arity = 1)
        public String id;
    
        @Parameter(names = {"--name", "-n"}, description = "The body web service name parameter", required = false, arity = 1)
        public String name;
    
        @Parameter(names = {"--description"}, description = "The body web service description parameter", required = false, arity = 1)
        public String description;
    
        @Parameter(names = {"--creation-date", "--cd"}, description = "The body web service creationDate parameter", required = false, arity = 1)
        public String creationDate;
    
        @Parameter(names = {"--modification-date", "--md"}, description = "The body web service modificationDate parameter", required = false, arity = 1)
        public String modificationDate;
    
        @Parameter(names = {"--expected-size"}, description = "The body web service expectedSize parameter", required = false, arity = 1)
        public Integer expectedSize;
    
        @Parameter(names = {"--quality-control-files"}, description = "File IDs related to the quality control.", required = false, arity = 1)
        public String qualityControlFiles;
    
        @Parameter(names = {"--status-id"}, description = "The body web service id parameter", required = false, arity = 1)
        public String statusId;
    
        @Parameter(names = {"--status-name"}, description = "The body web service name parameter", required = false, arity = 1)
        public String statusName;
    
        @Parameter(names = {"--status-description"}, description = "The body web service description parameter", required = false, arity = 1)
        public String statusDescription;
    
        @DynamicParameter(names = {"--attributes"}, description = "The body web service attributes parameter. Use: --attributes key=value", required = false)
        public java.util.Map<java.lang.String,java.lang.Object> attributes = new HashMap<>(); //Dynamic parameters must be initialized;
    
    }

    @Parameters(commandNames = {"annotation-sets-annotations-update"}, commandDescription ="Update annotations from an annotationSet")
    public class UpdateAnnotationSetsAnnotationsCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--json-file"}, description = "File with the body data in JSON format. Note, that using this parameter will ignore all the other parameters.", required = false, arity = 1)
        public String jsonFile;
    
        @Parameter(names = {"--json-data-model"}, description = "Show example of file structure for body data.", help = true, arity = 0)
        public Boolean jsonDataModel = false;
    
        @Parameter(names = {"--family"}, description = "Family id", required = true, arity = 1)
        public String family; 
    
        @Parameter(names = {"--study", "-s"}, description = "Study [[user@]project:]study where study and project can be either the ID or UUID", required = false, arity = 1)
        public String study; 
    
        @Parameter(names = {"--annotation-set"}, description = "AnnotationSet ID to be updated.", required = true, arity = 1)
        public String annotationSet; 
    
        @Parameter(names = {"--action"}, description = "Action to be performed: ADD to add new annotations; REPLACE to replace the value of an already existing annotation; SET to set the new list of annotations removing any possible old annotations; REMOVE to remove some annotations; RESET to set some annotations to the default value configured in the corresponding variables of the VariableSet if any.", required = false, arity = 1)
        public String action; 
    
    }

}