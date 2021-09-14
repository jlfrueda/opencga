package org.opencb.opencga.app.cli.main.executors;

import org.opencb.opencga.app.cli.main.executors.OpencgaCommandExecutor;
import org.opencb.opencga.app.cli.main.*;
import org.opencb.opencga.core.response.RestResponse;
import org.opencb.opencga.client.exceptions.ClientException;
import org.opencb.commons.datastore.core.ObjectMap;

import org.opencb.opencga.app.cli.main.options.StudiesCommandOptions;

import org.opencb.opencga.core.models.study.StudyAclUpdateParams;
import org.opencb.opencga.core.models.study.CustomGroup;
import org.opencb.opencga.catalog.utils.ParamUtils.BasicUpdateAction;
import org.opencb.opencga.core.models.job.Job;
import org.opencb.commons.datastore.core.FacetField;
import org.opencb.opencga.core.models.study.VariableSet;
import org.opencb.opencga.core.models.audit.AuditRecord;
import org.opencb.opencga.core.models.study.GroupCreateParams;
import org.opencb.opencga.core.models.study.Study;
import org.opencb.opencga.core.models.study.GroupUpdateParams;
import org.opencb.opencga.catalog.utils.ParamUtils.AclAction;
import org.opencb.opencga.core.models.study.VariableSetCreateParams;
import org.opencb.opencga.core.models.study.Variable;
import org.opencb.opencga.core.models.study.PermissionRule;
import org.opencb.opencga.core.models.study.StudyCreateParams;
import java.util.Map;
import org.opencb.opencga.core.models.study.StudyUpdateParams;
import org.opencb.opencga.core.models.audit.AuditRecord.Status.Result;
import org.opencb.opencga.catalog.utils.ParamUtils.AddRemoveAction;
import org.opencb.opencga.core.models.study.Group;
import org.opencb.opencga.core.models.study.TemplateParams;
import org.opencb.opencga.core.models.common.Enums.Resource;
import org.opencb.opencga.core.models.common.Enums.Entity;
import org.opencb.opencga.core.models.common.Enums.PermissionRuleAction;


/*
* WARNING: AUTOGENERATED CODE
*
* This code was generated by a tool.
* Autogenerated on: 2021-09-14 21:24:33+0200
*
* Manual changes to this file may cause unexpected behavior in your application.
* Manual changes to this file will be overwritten if the code is regenerated.
*/


/**
 * This class contains methods for the Studies command line.
 *    Command line version: 3.0
 *    PATH: /{apiVersion}/studies
 */
public class StudiesCommandExecutor extends OpencgaCommandExecutor {

    private StudiesCommandOptions studiesCommandOptions;

    public StudiesCommandExecutor(StudiesCommandOptions studiesCommandOptions) {
        super(studiesCommandOptions.commonCommandOptions);
        this.studiesCommandOptions = studiesCommandOptions;
    }

    @Override
    public void execute() throws Exception {

        logger.debug("Executing Studies command line");

        String subCommandString = getParsedSubCommand(studiesCommandOptions.jCommander);

        RestResponse queryResponse = null;

        switch (subCommandString) {
            case "update-acl":
                queryResponse = updateAcl();
                break;
            case "create":
                queryResponse = create();
                break;
            case "search":
                queryResponse = search();
                break;
            case "acl":
                queryResponse = acl();
                break;
            case "aggregationStats":
                queryResponse = aggregationStats();
                break;
            case "info":
                queryResponse = info();
                break;
            case "search-audit":
                queryResponse = searchAudit();
                break;
            case "groups":
                queryResponse = groups();
                break;
            case "update-groups":
                queryResponse = updateGroups();
                break;
            case "permissionRules":
                queryResponse = permissionRules();
                break;
            case "update-permissionRules":
                queryResponse = updatePermissionRules();
                break;
            case "run-templates":
                queryResponse = runTemplates();
                break;
            case "update":
                queryResponse = update();
                break;
            case "variableSets":
                queryResponse = variableSets();
                break;
            case "update-variableSets":
                queryResponse = updateVariableSets();
                break;
            case "update-variables":
                queryResponse = updateVariables();
                break;
            default:
                logger.error("Subcommand not valid");
                break;
        }

        createOutput(queryResponse);

    }

    private RestResponse<ObjectMap> updateAcl() throws Exception {

        logger.debug("Executing updateAcl in Studies command line");

        StudiesCommandOptions.UpdateAclCommandOptions commandOptions = studiesCommandOptions.updateAclCommandOptions;
        StudyAclUpdateParams studyAclUpdateParams = new StudyAclUpdateParams()
            .setStudy(commandOptions.study)
            .setTemplate(commandOptions.template);
        return openCGAClient.getStudyClient().updateAcl(commandOptions.members, commandOptions.action, studyAclUpdateParams);
    }

    private RestResponse<Study> create() throws Exception {

        logger.debug("Executing create in Studies command line");

        StudiesCommandOptions.CreateCommandOptions commandOptions = studiesCommandOptions.createCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("project", commandOptions.project);

        StudyCreateParams studyCreateParams = new StudyCreateParams()
            .setId(commandOptions.id)
            .setName(commandOptions.name)
            .setAlias(commandOptions.alias)
            .setDescription(commandOptions.description)
            .setCreationDate(commandOptions.creationDate)
            .setModificationDate(commandOptions.modificationDate);
        return openCGAClient.getStudyClient().create(studyCreateParams, queryParams);
    }

    private RestResponse<Study> search() throws Exception {

        logger.debug("Executing search in Studies command line");

        StudiesCommandOptions.SearchCommandOptions commandOptions = studiesCommandOptions.searchCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("include", commandOptions.include);
        queryParams.putIfNotEmpty("exclude", commandOptions.exclude);
        queryParams.putIfNotNull("limit", commandOptions.limit);
        queryParams.putIfNotNull("skip", commandOptions.skip);
        queryParams.putIfNotNull("count", commandOptions.count);
        queryParams.putIfNotEmpty("name", commandOptions.name);
        queryParams.putIfNotEmpty("id", commandOptions.id);
        queryParams.putIfNotEmpty("alias", commandOptions.alias);
        queryParams.putIfNotEmpty("fqn", commandOptions.fqn);
        queryParams.putIfNotEmpty("creationDate", commandOptions.creationDate);
        queryParams.putIfNotEmpty("modificationDate", commandOptions.modificationDate);
        queryParams.putIfNotEmpty("internalStatus", commandOptions.internalStatus);
        queryParams.putIfNotEmpty("status", commandOptions.status);
        queryParams.putIfNotEmpty("attributes", commandOptions.attributes);
        queryParams.putIfNotEmpty("release", commandOptions.release);

        return openCGAClient.getStudyClient().search(commandOptions.project, queryParams);
    }

    private RestResponse<ObjectMap> acl() throws Exception {

        logger.debug("Executing acl in Studies command line");

        StudiesCommandOptions.AclCommandOptions commandOptions = studiesCommandOptions.aclCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("member", commandOptions.member);
        queryParams.putIfNotNull("silent", commandOptions.silent);

        return openCGAClient.getStudyClient().acl(commandOptions.studies, queryParams);
    }

    private RestResponse<FacetField> aggregationStats() throws Exception {

        logger.debug("Executing aggregationStats in Studies command line");

        StudiesCommandOptions.AggregationStatsCommandOptions commandOptions = studiesCommandOptions.aggregationStatsCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotNull("default_values", commandOptions.default_values);
        queryParams.putIfNotEmpty("fileFields", commandOptions.fileFields);
        queryParams.putIfNotEmpty("individualFields", commandOptions.individualFields);
        queryParams.putIfNotEmpty("familyFields", commandOptions.familyFields);
        queryParams.putIfNotEmpty("sampleFields", commandOptions.sampleFields);
        queryParams.putIfNotEmpty("cohortFields", commandOptions.cohortFields);
        queryParams.putIfNotEmpty("jobFields", commandOptions.jobFields);

        return openCGAClient.getStudyClient().aggregationStats(commandOptions.studies, queryParams);
    }

    private RestResponse<Study> info() throws Exception {

        logger.debug("Executing info in Studies command line");

        StudiesCommandOptions.InfoCommandOptions commandOptions = studiesCommandOptions.infoCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("include", commandOptions.include);
        queryParams.putIfNotEmpty("exclude", commandOptions.exclude);

        return openCGAClient.getStudyClient().info(commandOptions.studies, queryParams);
    }

    private RestResponse<AuditRecord> searchAudit() throws Exception {

        logger.debug("Executing searchAudit in Studies command line");

        StudiesCommandOptions.SearchAuditCommandOptions commandOptions = studiesCommandOptions.searchAuditCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("include", commandOptions.include);
        queryParams.putIfNotEmpty("exclude", commandOptions.exclude);
        queryParams.putIfNotNull("limit", commandOptions.limit);
        queryParams.putIfNotNull("skip", commandOptions.skip);
        queryParams.putIfNotNull("count", commandOptions.count);
        queryParams.putIfNotEmpty("operationId", commandOptions.operationId);
        queryParams.putIfNotEmpty("userId", commandOptions.userId);
        queryParams.putIfNotEmpty("action", commandOptions.action);
        queryParams.putIfNotNull("resource", commandOptions.resource);
        queryParams.putIfNotEmpty("resourceId", commandOptions.resourceId);
        queryParams.putIfNotEmpty("resourceUuid", commandOptions.resourceUuid);
        queryParams.putIfNotNull("status", commandOptions.status);
        queryParams.putIfNotEmpty("date", commandOptions.date);

        return openCGAClient.getStudyClient().searchAudit(commandOptions.study, queryParams);
    }

    private RestResponse<CustomGroup> groups() throws Exception {

        logger.debug("Executing groups in Studies command line");

        StudiesCommandOptions.GroupsCommandOptions commandOptions = studiesCommandOptions.groupsCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("id", commandOptions.id);
        queryParams.putIfNotNull("silent", commandOptions.silent);

        return openCGAClient.getStudyClient().groups(commandOptions.study, queryParams);
    }

    private RestResponse<Group> updateGroups() throws Exception {

        logger.debug("Executing updateGroups in Studies command line");

        StudiesCommandOptions.UpdateGroupsCommandOptions commandOptions = studiesCommandOptions.updateGroupsCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotNull("action", commandOptions.action);

        GroupCreateParams groupCreateParams = new GroupCreateParams()
            .setId(commandOptions.id);
        return openCGAClient.getStudyClient().updateGroups(commandOptions.study, groupCreateParams, queryParams);
    }

    private RestResponse<PermissionRule> permissionRules() throws Exception {

        logger.debug("Executing permissionRules in Studies command line");

        StudiesCommandOptions.PermissionRulesCommandOptions commandOptions = studiesCommandOptions.permissionRulesCommandOptions;
        return openCGAClient.getStudyClient().permissionRules(commandOptions.study, commandOptions.entity);
    }

    private RestResponse<PermissionRule> updatePermissionRules() throws Exception {

        logger.debug("Executing updatePermissionRules in Studies command line");

        StudiesCommandOptions.UpdatePermissionRulesCommandOptions commandOptions = studiesCommandOptions.updatePermissionRulesCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotNull("action", commandOptions.action);

        PermissionRule permissionRule = new PermissionRule()
            .setId(commandOptions.id);
        return openCGAClient.getStudyClient().updatePermissionRules(commandOptions.study, commandOptions.entity, permissionRule, queryParams);
    }

    private RestResponse<Job> runTemplates() throws Exception {

        logger.debug("Executing runTemplates in Studies command line");

        StudiesCommandOptions.RunTemplatesCommandOptions commandOptions = studiesCommandOptions.runTemplatesCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("jobId", commandOptions.jobId);
        queryParams.putIfNotEmpty("jobDependsOn", commandOptions.jobDependsOn);
        queryParams.putIfNotEmpty("jobDescription", commandOptions.jobDescription);
        queryParams.putIfNotEmpty("jobTags", commandOptions.jobTags);

        TemplateParams templateParams = new TemplateParams()
            .setId(commandOptions.id)
            .setOverwrite(commandOptions.overwrite)
            .setResume(commandOptions.resume);
        return openCGAClient.getStudyClient().runTemplates(commandOptions.study, templateParams, queryParams);
    }

    private RestResponse<Study> update() throws Exception {

        logger.debug("Executing update in Studies command line");

        StudiesCommandOptions.UpdateCommandOptions commandOptions = studiesCommandOptions.updateCommandOptions;
        StudyUpdateParams studyUpdateParams = new StudyUpdateParams()
            .setName(commandOptions.name)
            .setAlias(commandOptions.alias)
            .setDescription(commandOptions.description)
            .setCreationDate(commandOptions.creationDate)
            .setModificationDate(commandOptions.modificationDate);
        return openCGAClient.getStudyClient().update(commandOptions.study, studyUpdateParams);
    }

    private RestResponse<VariableSet> variableSets() throws Exception {

        logger.debug("Executing variableSets in Studies command line");

        StudiesCommandOptions.VariableSetsCommandOptions commandOptions = studiesCommandOptions.variableSetsCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("id", commandOptions.id);

        return openCGAClient.getStudyClient().variableSets(commandOptions.study, queryParams);
    }

    private RestResponse<VariableSet> updateVariableSets() throws Exception {

        logger.debug("Executing updateVariableSets in Studies command line");

        StudiesCommandOptions.UpdateVariableSetsCommandOptions commandOptions = studiesCommandOptions.updateVariableSetsCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotNull("action", commandOptions.action);

        VariableSetCreateParams variableSetCreateParams = new VariableSetCreateParams()
            .setId(commandOptions.id)
            .setName(commandOptions.name)
            .setDescription(commandOptions.description);
        return openCGAClient.getStudyClient().updateVariableSets(commandOptions.study, variableSetCreateParams, queryParams);
    }

    private RestResponse<VariableSet> updateVariables() throws Exception {

        logger.debug("Executing updateVariables in Studies command line");

        StudiesCommandOptions.UpdateVariablesCommandOptions commandOptions = studiesCommandOptions.updateVariablesCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotNull("action", commandOptions.action);

        Variable variable = new Variable()
            .setId(commandOptions.id)
            .setName(commandOptions.name)
            .setCategory(commandOptions.category)
            .setDefaultValue(commandOptions.defaultValue)
            .setRequired(commandOptions.required)
            .setMultiValue(commandOptions.multiValue)
            .setRank(commandOptions.rank)
            .setDependsOn(commandOptions.dependsOn)
            .setDescription(commandOptions.description);
        return openCGAClient.getStudyClient().updateVariables(commandOptions.study, commandOptions.variableSet, variable, queryParams);
    }
}