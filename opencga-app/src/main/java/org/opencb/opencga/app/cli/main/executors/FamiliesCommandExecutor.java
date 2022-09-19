package org.opencb.opencga.app.cli.main.executors;

import com.fasterxml.jackson.databind.DeserializationFeature;
import org.opencb.opencga.app.cli.main.executors.OpencgaCommandExecutor;
import org.opencb.opencga.app.cli.main.*;
import org.opencb.opencga.core.response.RestResponse;
import org.opencb.opencga.client.exceptions.ClientException;
import org.opencb.commons.datastore.core.ObjectMap;

import org.opencb.opencga.catalog.exceptions.CatalogAuthenticationException;
import org.opencb.opencga.core.common.JacksonUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.HashMap;
import org.opencb.opencga.core.response.QueryType;
import org.opencb.commons.utils.PrintUtils;

import org.opencb.opencga.app.cli.main.options.FamiliesCommandOptions;

import java.util.Map;
import org.opencb.commons.datastore.core.FacetField;
import org.opencb.opencga.catalog.utils.ParamUtils.AclAction;
import org.opencb.opencga.catalog.utils.ParamUtils.BasicUpdateAction;
import org.opencb.opencga.catalog.utils.ParamUtils.CompleteUpdateAction;
import org.opencb.opencga.core.models.AclEntryList;
import org.opencb.opencga.core.models.common.StatusParams;
import org.opencb.opencga.core.models.common.TsvAnnotationParams;
import org.opencb.opencga.core.models.family.Family;
import org.opencb.opencga.core.models.family.FamilyAclParams.Propagate;
import org.opencb.opencga.core.models.family.FamilyAclUpdateParams;
import org.opencb.opencga.core.models.family.FamilyCreateParams;
import org.opencb.opencga.core.models.family.FamilyQualityControl;
import org.opencb.opencga.core.models.family.FamilyUpdateParams;
import org.opencb.opencga.core.models.job.Job;


/*
* WARNING: AUTOGENERATED CODE
*
* This code was generated by a tool.
* Autogenerated on: 2022-09-19
*
* Manual changes to this file may cause unexpected behavior in your application.
* Manual changes to this file will be overwritten if the code is regenerated.
*/


/**
 * This class contains methods for the Families command line.
 *    OpenCGA version: 2.4.4-SNAPSHOT
 *    PATH: /{apiVersion}/families
 */
public class FamiliesCommandExecutor extends OpencgaCommandExecutor {

    private FamiliesCommandOptions familiesCommandOptions;

    public FamiliesCommandExecutor(FamiliesCommandOptions familiesCommandOptions) throws CatalogAuthenticationException {
        super(familiesCommandOptions.commonCommandOptions);
        this.familiesCommandOptions = familiesCommandOptions;
    }

    @Override
    public void execute() throws Exception {

        logger.debug("Executing Families command line");

        String subCommandString = getParsedSubCommand(familiesCommandOptions.jCommander);

        RestResponse queryResponse = null;

        switch (subCommandString) {
            case "acl-update":
                queryResponse = updateAcl();
                break;
            case "aggregationstats":
                queryResponse = aggregationStats();
                break;
            case "annotation-sets-load":
                queryResponse = loadAnnotationSets();
                break;
            case "create":
                queryResponse = create();
                break;
            case "distinct":
                queryResponse = distinct();
                break;
            case "search":
                queryResponse = search();
                break;
            case "acl":
                queryResponse = acl();
                break;
            case "delete":
                queryResponse = delete();
                break;
            case "info":
                queryResponse = info();
                break;
            case "update":
                queryResponse = update();
                break;
            case "annotation-sets-annotations-update":
                queryResponse = updateAnnotationSetsAnnotations();
                break;
            default:
                logger.error("Subcommand not valid");
                break;
        }

        createOutput(queryResponse);

    }

    private RestResponse<AclEntryList> updateAcl() throws Exception {

        logger.debug("Executing updateAcl in Families command line");

        FamiliesCommandOptions.UpdateAclCommandOptions commandOptions = familiesCommandOptions.updateAclCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotNull("propagate", commandOptions.propagate);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }


        FamilyAclUpdateParams familyAclUpdateParams= null;
        if (commandOptions.jsonDataModel) {
            familyAclUpdateParams = new FamilyAclUpdateParams();
            RestResponse<AclEntryList> res = new RestResponse<>();
            res.setType(QueryType.VOID);
            PrintUtils.println(getObjectAsJSON(familyAclUpdateParams));
            return res;
        } else if (commandOptions.jsonFile != null) {
            familyAclUpdateParams = JacksonUtils.getDefaultObjectMapper()
                    .readValue(new java.io.File(commandOptions.jsonFile), FamilyAclUpdateParams.class);
        } else {
            ObjectMap beanParams = new ObjectMap();
            putNestedIfNotEmpty(beanParams, "permissions",commandOptions.permissions, true);
             putNestedIfNotEmpty(beanParams, "family",commandOptions.family, true);
             putNestedIfNotEmpty(beanParams, "individual",commandOptions.individual, true);
             putNestedIfNotEmpty(beanParams, "sample",commandOptions.sample, true);
 
            familyAclUpdateParams = JacksonUtils.getDefaultObjectMapper().copy()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true)
                    .readValue(beanParams.toJson(), FamilyAclUpdateParams.class);
        }
        return openCGAClient.getFamilyClient().updateAcl(commandOptions.members, commandOptions.action, familyAclUpdateParams, queryParams);
    }

    private RestResponse<FacetField> aggregationStats() throws Exception {

        logger.debug("Executing aggregationStats in Families command line");

        FamiliesCommandOptions.AggregationStatsCommandOptions commandOptions = familiesCommandOptions.aggregationStatsCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("creationYear", commandOptions.creationYear);
        queryParams.putIfNotEmpty("creationMonth", commandOptions.creationMonth);
        queryParams.putIfNotEmpty("creationDay", commandOptions.creationDay);
        queryParams.putIfNotEmpty("creationDayOfWeek", commandOptions.creationDayOfWeek);
        queryParams.putIfNotEmpty("status", commandOptions.status);
        queryParams.putIfNotEmpty("phenotypes", commandOptions.phenotypes);
        queryParams.putIfNotEmpty("release", commandOptions.release);
        queryParams.putIfNotEmpty("version", commandOptions.version);
        queryParams.putIfNotEmpty("numMembers", commandOptions.numMembers);
        queryParams.putIfNotEmpty("expectedSize", commandOptions.expectedSize);
        queryParams.putIfNotEmpty("annotation", commandOptions.annotation);
        queryParams.putIfNotNull("default_values", commandOptions.default_values);
        queryParams.putIfNotEmpty("field", commandOptions.field);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getFamilyClient().aggregationStats(queryParams);
    }

    private RestResponse<Job> loadAnnotationSets() throws Exception {

        logger.debug("Executing loadAnnotationSets in Families command line");

        FamiliesCommandOptions.LoadAnnotationSetsCommandOptions commandOptions = familiesCommandOptions.loadAnnotationSetsCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotNull("parents", commandOptions.parents);
        queryParams.putIfNotEmpty("annotationSetId", commandOptions.annotationSetId);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }


        TsvAnnotationParams tsvAnnotationParams= null;
        if (commandOptions.jsonDataModel) {
            tsvAnnotationParams = new TsvAnnotationParams();
            RestResponse<Job> res = new RestResponse<>();
            res.setType(QueryType.VOID);
            PrintUtils.println(getObjectAsJSON(tsvAnnotationParams));
            return res;
        } else if (commandOptions.jsonFile != null) {
            tsvAnnotationParams = JacksonUtils.getDefaultObjectMapper()
                    .readValue(new java.io.File(commandOptions.jsonFile), TsvAnnotationParams.class);
        } else {
            ObjectMap beanParams = new ObjectMap();
            putNestedIfNotEmpty(beanParams, "content",commandOptions.content, true);
 
            tsvAnnotationParams = JacksonUtils.getDefaultObjectMapper().copy()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true)
                    .readValue(beanParams.toJson(), TsvAnnotationParams.class);
        }
        return openCGAClient.getFamilyClient().loadAnnotationSets(commandOptions.variableSetId, commandOptions.path, tsvAnnotationParams, queryParams);
    }

    private RestResponse<Family> create() throws Exception {

        logger.debug("Executing create in Families command line");

        FamiliesCommandOptions.CreateCommandOptions commandOptions = familiesCommandOptions.createCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("include", commandOptions.include);
        queryParams.putIfNotEmpty("exclude", commandOptions.exclude);
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("members", commandOptions.members);
        queryParams.putIfNotNull("includeResult", commandOptions.includeResult);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }


        FamilyCreateParams familyCreateParams= null;
        if (commandOptions.jsonDataModel) {
            familyCreateParams = new FamilyCreateParams();
            RestResponse<Family> res = new RestResponse<>();
            res.setType(QueryType.VOID);
            PrintUtils.println(getObjectAsJSON(familyCreateParams));
            return res;
        } else if (commandOptions.jsonFile != null) {
            familyCreateParams = JacksonUtils.getDefaultObjectMapper()
                    .readValue(new java.io.File(commandOptions.jsonFile), FamilyCreateParams.class);
        } else {
            ObjectMap beanParams = new ObjectMap();
            putNestedIfNotEmpty(beanParams, "id",commandOptions.bodyId, true);
             putNestedIfNotEmpty(beanParams, "name",commandOptions.bodyName, true);
             putNestedIfNotEmpty(beanParams, "description",commandOptions.bodyDescription, true);
             putNestedIfNotEmpty(beanParams, "creationDate",commandOptions.bodyCreationDate, true);
             putNestedIfNotEmpty(beanParams, "modificationDate",commandOptions.bodyModificationDate, true);
             putNestedIfNotNull(beanParams, "expectedSize",commandOptions.bodyExpectedSize, true);
             putNestedIfNotEmpty(beanParams, "status.id",commandOptions.statusId, true);
             putNestedIfNotEmpty(beanParams, "status.name",commandOptions.statusName, true);
             putNestedIfNotEmpty(beanParams, "status.description",commandOptions.statusDescription, true);
 
            familyCreateParams = JacksonUtils.getDefaultObjectMapper().copy()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true)
                    .readValue(beanParams.toJson(), FamilyCreateParams.class);
        }
        return openCGAClient.getFamilyClient().create(familyCreateParams, queryParams);
    }

    private RestResponse<Object> distinct() throws Exception {

        logger.debug("Executing distinct in Families command line");

        FamiliesCommandOptions.DistinctCommandOptions commandOptions = familiesCommandOptions.distinctCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("id", commandOptions.id);
        queryParams.putIfNotEmpty("name", commandOptions.name);
        queryParams.putIfNotEmpty("uuid", commandOptions.uuid);
        queryParams.putIfNotEmpty("members", commandOptions.members);
        queryParams.putIfNotNull("expectedSize", commandOptions.expectedSize);
        queryParams.putIfNotEmpty("samples", commandOptions.samples);
        queryParams.putIfNotEmpty("phenotypes", commandOptions.phenotypes);
        queryParams.putIfNotEmpty("disorders", commandOptions.disorders);
        queryParams.putIfNotEmpty("creationDate", commandOptions.creationDate);
        queryParams.putIfNotEmpty("modificationDate", commandOptions.modificationDate);
        queryParams.putIfNotNull("deleted", commandOptions.deleted);
        queryParams.putIfNotEmpty("internalStatus", commandOptions.internalStatus);
        queryParams.putIfNotEmpty("status", commandOptions.status);
        queryParams.putIfNotEmpty("annotation", commandOptions.annotation);
        queryParams.putIfNotEmpty("acl", commandOptions.acl);
        queryParams.putIfNotEmpty("release", commandOptions.release);
        queryParams.putIfNotNull("snapshot", commandOptions.snapshot);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getFamilyClient().distinct(commandOptions.field, queryParams);
    }

    private RestResponse<Family> search() throws Exception {

        logger.debug("Executing search in Families command line");

        FamiliesCommandOptions.SearchCommandOptions commandOptions = familiesCommandOptions.searchCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("include", commandOptions.include);
        queryParams.putIfNotEmpty("exclude", commandOptions.exclude);
        queryParams.putIfNotNull("limit", commandOptions.limit);
        queryParams.putIfNotNull("skip", commandOptions.skip);
        queryParams.putIfNotNull("count", commandOptions.count);
        queryParams.putIfNotNull("flattenAnnotations", commandOptions.flattenAnnotations);
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("id", commandOptions.id);
        queryParams.putIfNotEmpty("name", commandOptions.name);
        queryParams.putIfNotEmpty("uuid", commandOptions.uuid);
        queryParams.putIfNotEmpty("members", commandOptions.members);
        queryParams.putIfNotNull("expectedSize", commandOptions.expectedSize);
        queryParams.putIfNotEmpty("samples", commandOptions.samples);
        queryParams.putIfNotEmpty("phenotypes", commandOptions.phenotypes);
        queryParams.putIfNotEmpty("disorders", commandOptions.disorders);
        queryParams.putIfNotEmpty("creationDate", commandOptions.creationDate);
        queryParams.putIfNotEmpty("modificationDate", commandOptions.modificationDate);
        queryParams.putIfNotNull("deleted", commandOptions.deleted);
        queryParams.putIfNotEmpty("internalStatus", commandOptions.internalStatus);
        queryParams.putIfNotEmpty("status", commandOptions.status);
        queryParams.putIfNotEmpty("annotation", commandOptions.annotation);
        queryParams.putIfNotEmpty("acl", commandOptions.acl);
        queryParams.putIfNotEmpty("release", commandOptions.release);
        queryParams.putIfNotNull("snapshot", commandOptions.snapshot);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getFamilyClient().search(queryParams);
    }

    private RestResponse<AclEntryList> acl() throws Exception {

        logger.debug("Executing acl in Families command line");

        FamiliesCommandOptions.AclCommandOptions commandOptions = familiesCommandOptions.aclCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("member", commandOptions.member);
        queryParams.putIfNotNull("silent", commandOptions.silent);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getFamilyClient().acl(commandOptions.families, queryParams);
    }

    private RestResponse<Family> delete() throws Exception {

        logger.debug("Executing delete in Families command line");

        FamiliesCommandOptions.DeleteCommandOptions commandOptions = familiesCommandOptions.deleteCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getFamilyClient().delete(commandOptions.families, queryParams);
    }

    private RestResponse<Family> info() throws Exception {

        logger.debug("Executing info in Families command line");

        FamiliesCommandOptions.InfoCommandOptions commandOptions = familiesCommandOptions.infoCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("include", commandOptions.include);
        queryParams.putIfNotEmpty("exclude", commandOptions.exclude);
        queryParams.putIfNotNull("flattenAnnotations", commandOptions.flattenAnnotations);
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("version", commandOptions.version);
        queryParams.putIfNotNull("deleted", commandOptions.deleted);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getFamilyClient().info(commandOptions.families, queryParams);
    }

    private RestResponse<Family> update() throws Exception {

        logger.debug("Executing update in Families command line");

        FamiliesCommandOptions.UpdateCommandOptions commandOptions = familiesCommandOptions.updateCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("include", commandOptions.include);
        queryParams.putIfNotEmpty("exclude", commandOptions.exclude);
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotNull("updateRoles", commandOptions.updateRoles);
        queryParams.putIfNotNull("includeResult", commandOptions.includeResult);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }


        FamilyUpdateParams familyUpdateParams= null;
        if (commandOptions.jsonDataModel) {
            familyUpdateParams = new FamilyUpdateParams();
            RestResponse<Family> res = new RestResponse<>();
            res.setType(QueryType.VOID);
            PrintUtils.println(getObjectAsJSON(familyUpdateParams));
            return res;
        } else if (commandOptions.jsonFile != null) {
            familyUpdateParams = JacksonUtils.getDefaultObjectMapper()
                    .readValue(new java.io.File(commandOptions.jsonFile), FamilyUpdateParams.class);
        } else {
            ObjectMap beanParams = new ObjectMap();
            putNestedIfNotEmpty(beanParams, "id",commandOptions.id, true);
             putNestedIfNotEmpty(beanParams, "name",commandOptions.name, true);
             putNestedIfNotEmpty(beanParams, "description",commandOptions.description, true);
             putNestedIfNotEmpty(beanParams, "creationDate",commandOptions.creationDate, true);
             putNestedIfNotEmpty(beanParams, "modificationDate",commandOptions.modificationDate, true);
             putNestedIfNotNull(beanParams, "expectedSize",commandOptions.expectedSize, true);
             putNestedIfNotNull(beanParams, "qualityControl.files",commandOptions.qualityControlFiles, true);
             putNestedIfNotEmpty(beanParams, "status.id",commandOptions.statusId, true);
             putNestedIfNotEmpty(beanParams, "status.name",commandOptions.statusName, true);
             putNestedIfNotEmpty(beanParams, "status.description",commandOptions.statusDescription, true);
 
            familyUpdateParams = JacksonUtils.getDefaultObjectMapper().copy()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true)
                    .readValue(beanParams.toJson(), FamilyUpdateParams.class);
        }
        return openCGAClient.getFamilyClient().update(commandOptions.families, familyUpdateParams, queryParams);
    }

    private RestResponse<Family> updateAnnotationSetsAnnotations() throws Exception {

        logger.debug("Executing updateAnnotationSetsAnnotations in Families command line");

        FamiliesCommandOptions.UpdateAnnotationSetsAnnotationsCommandOptions commandOptions = familiesCommandOptions.updateAnnotationSetsAnnotationsCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotNull("action", commandOptions.action);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }


        ObjectMap objectMap= null;
        if (commandOptions.jsonDataModel) {
            objectMap = new ObjectMap();
            RestResponse<Family> res = new RestResponse<>();
            res.setType(QueryType.VOID);
            PrintUtils.println(getObjectAsJSON(objectMap));
            return res;
        } else if (commandOptions.jsonFile != null) {
            objectMap = JacksonUtils.getDefaultObjectMapper()
                    .readValue(new java.io.File(commandOptions.jsonFile), ObjectMap.class);
        }
        return openCGAClient.getFamilyClient().updateAnnotationSetsAnnotations(commandOptions.family, commandOptions.annotationSet, objectMap, queryParams);
    }
}