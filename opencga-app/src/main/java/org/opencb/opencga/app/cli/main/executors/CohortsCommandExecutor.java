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

import org.opencb.opencga.app.cli.main.options.CohortsCommandOptions;

import java.util.Map;
import org.opencb.commons.datastore.core.FacetField;
import org.opencb.opencga.catalog.utils.ParamUtils.AclAction;
import org.opencb.opencga.catalog.utils.ParamUtils.BasicUpdateAction;
import org.opencb.opencga.catalog.utils.ParamUtils.CompleteUpdateAction;
import org.opencb.opencga.core.models.AclEntryList;
import org.opencb.opencga.core.models.cohort.Cohort;
import org.opencb.opencga.core.models.cohort.CohortAclUpdateParams;
import org.opencb.opencga.core.models.cohort.CohortCreateParams;
import org.opencb.opencga.core.models.cohort.CohortGenerateParams;
import org.opencb.opencga.core.models.cohort.CohortUpdateParams;
import org.opencb.opencga.core.models.common.Enums.CohortType;
import org.opencb.opencga.core.models.common.Enums;
import org.opencb.opencga.core.models.common.StatusParams;
import org.opencb.opencga.core.models.common.TsvAnnotationParams;
import org.opencb.opencga.core.models.job.Job;


/*
* WARNING: AUTOGENERATED CODE
*
* This code was generated by a tool.
* Autogenerated on: 2022-08-11
*
* Manual changes to this file may cause unexpected behavior in your application.
* Manual changes to this file will be overwritten if the code is regenerated.
*/


/**
 * This class contains methods for the Cohorts command line.
 *    OpenCGA version: 2.4.3-SNAPSHOT
 *    PATH: /{apiVersion}/cohorts
 */
public class CohortsCommandExecutor extends OpencgaCommandExecutor {

    private CohortsCommandOptions cohortsCommandOptions;

    public CohortsCommandExecutor(CohortsCommandOptions cohortsCommandOptions) throws CatalogAuthenticationException {
        super(cohortsCommandOptions.commonCommandOptions);
        this.cohortsCommandOptions = cohortsCommandOptions;
    }

    @Override
    public void execute() throws Exception {

        logger.debug("Executing Cohorts command line");

        String subCommandString = getParsedSubCommand(cohortsCommandOptions.jCommander);

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
            case "generate":
                queryResponse = generate();
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

        logger.debug("Executing updateAcl in Cohorts command line");

        CohortsCommandOptions.UpdateAclCommandOptions commandOptions = cohortsCommandOptions.updateAclCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }


        CohortAclUpdateParams cohortAclUpdateParams= null;
        if (commandOptions.jsonDataModel) {
            cohortAclUpdateParams = new CohortAclUpdateParams();
            RestResponse<AclEntryList> res = new RestResponse<>();
            res.setType(QueryType.VOID);
            PrintUtils.println(getObjectAsJSON(cohortAclUpdateParams));
            return res;
        } else if (commandOptions.jsonFile != null) {
            cohortAclUpdateParams = JacksonUtils.getDefaultObjectMapper()
                    .readValue(new java.io.File(commandOptions.jsonFile), CohortAclUpdateParams.class);
        } else {
            ObjectMap beanParams = new ObjectMap();
            putNestedIfNotEmpty(beanParams, "permissions",commandOptions.permissions, true);
             putNestedIfNotEmpty(beanParams, "cohort",commandOptions.cohort, true);
 
            cohortAclUpdateParams = JacksonUtils.getDefaultObjectMapper().copy()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true)
                    .readValue(beanParams.toJson(), CohortAclUpdateParams.class);
        }
        return openCGAClient.getCohortClient().updateAcl(commandOptions.members, commandOptions.action, cohortAclUpdateParams, queryParams);
    }

    private RestResponse<FacetField> aggregationStats() throws Exception {

        logger.debug("Executing aggregationStats in Cohorts command line");

        CohortsCommandOptions.AggregationStatsCommandOptions commandOptions = cohortsCommandOptions.aggregationStatsCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("type", commandOptions.type);
        queryParams.putIfNotEmpty("creationYear", commandOptions.creationYear);
        queryParams.putIfNotEmpty("creationMonth", commandOptions.creationMonth);
        queryParams.putIfNotEmpty("creationDay", commandOptions.creationDay);
        queryParams.putIfNotEmpty("creationDayOfWeek", commandOptions.creationDayOfWeek);
        queryParams.putIfNotEmpty("numSamples", commandOptions.numSamples);
        queryParams.putIfNotEmpty("status", commandOptions.status);
        queryParams.putIfNotEmpty("release", commandOptions.release);
        queryParams.putIfNotEmpty("annotation", commandOptions.annotation);
        queryParams.putIfNotNull("default_values", commandOptions.default_values);
        queryParams.putIfNotEmpty("field", commandOptions.field);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getCohortClient().aggregationStats(queryParams);
    }

    private RestResponse<Job> loadAnnotationSets() throws Exception {

        logger.debug("Executing loadAnnotationSets in Cohorts command line");

        CohortsCommandOptions.LoadAnnotationSetsCommandOptions commandOptions = cohortsCommandOptions.loadAnnotationSetsCommandOptions;

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
        return openCGAClient.getCohortClient().loadAnnotationSets(commandOptions.variableSetId, commandOptions.path, tsvAnnotationParams, queryParams);
    }

    private RestResponse<Cohort> create() throws Exception {

        logger.debug("Executing create in Cohorts command line");

        CohortsCommandOptions.CreateCommandOptions commandOptions = cohortsCommandOptions.createCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("include", commandOptions.include);
        queryParams.putIfNotEmpty("exclude", commandOptions.exclude);
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("variableSet", commandOptions.variableSet);
        queryParams.putIfNotEmpty("variable", commandOptions.variable);
        queryParams.putIfNotNull("includeResult", commandOptions.includeResult);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }


        CohortCreateParams cohortCreateParams= null;
        if (commandOptions.jsonDataModel) {
            cohortCreateParams = new CohortCreateParams();
            RestResponse<Cohort> res = new RestResponse<>();
            res.setType(QueryType.VOID);
            PrintUtils.println(getObjectAsJSON(cohortCreateParams));
            return res;
        } else if (commandOptions.jsonFile != null) {
            cohortCreateParams = JacksonUtils.getDefaultObjectMapper()
                    .readValue(new java.io.File(commandOptions.jsonFile), CohortCreateParams.class);
        } else {
            ObjectMap beanParams = new ObjectMap();
            putNestedIfNotEmpty(beanParams, "id",commandOptions.id, true);
             putNestedIfNotEmpty(beanParams, "name",commandOptions.name, true);
             putNestedIfNotNull(beanParams, "type",commandOptions.type, true);
             putNestedIfNotEmpty(beanParams, "description",commandOptions.description, true);
             putNestedIfNotEmpty(beanParams, "creationDate",commandOptions.creationDate, true);
             putNestedIfNotEmpty(beanParams, "modificationDate",commandOptions.modificationDate, true);
             putNestedIfNotEmpty(beanParams, "status.id",commandOptions.statusId, true);
             putNestedIfNotEmpty(beanParams, "status.name",commandOptions.statusName, true);
             putNestedIfNotEmpty(beanParams, "status.description",commandOptions.statusDescription, true);
 
            cohortCreateParams = JacksonUtils.getDefaultObjectMapper().copy()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true)
                    .readValue(beanParams.toJson(), CohortCreateParams.class);
        }
        return openCGAClient.getCohortClient().create(cohortCreateParams, queryParams);
    }

    private RestResponse<Object> distinct() throws Exception {

        logger.debug("Executing distinct in Cohorts command line");

        CohortsCommandOptions.DistinctCommandOptions commandOptions = cohortsCommandOptions.distinctCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("id", commandOptions.id);
        queryParams.putIfNotEmpty("name", commandOptions.name);
        queryParams.putIfNotEmpty("uuid", commandOptions.uuid);
        queryParams.putIfNotNull("type", commandOptions.type);
        queryParams.putIfNotEmpty("creationDate", commandOptions.creationDate);
        queryParams.putIfNotEmpty("modificationDate", commandOptions.modificationDate);
        queryParams.putIfNotNull("deleted", commandOptions.deleted);
        queryParams.putIfNotEmpty("status", commandOptions.status);
        queryParams.putIfNotEmpty("internalStatus", commandOptions.internalStatus);
        queryParams.putIfNotEmpty("annotation", commandOptions.annotation);
        queryParams.putIfNotEmpty("acl", commandOptions.acl);
        queryParams.putIfNotEmpty("samples", commandOptions.samples);
        queryParams.putIfNotEmpty("numSamples", commandOptions.numSamples);
        queryParams.putIfNotEmpty("release", commandOptions.release);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getCohortClient().distinct(commandOptions.field, queryParams);
    }

    private RestResponse<Cohort> generate() throws Exception {

        logger.debug("Executing generate in Cohorts command line");

        CohortsCommandOptions.GenerateCommandOptions commandOptions = cohortsCommandOptions.generateCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("include", commandOptions.include);
        queryParams.putIfNotEmpty("exclude", commandOptions.exclude);
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("id", commandOptions.id);
        queryParams.putIfNotNull("somatic", commandOptions.somatic);
        queryParams.putIfNotEmpty("individualId", commandOptions.individualId);
        queryParams.putIfNotEmpty("fileIds", commandOptions.fileIds);
        queryParams.putIfNotEmpty("creationDate", commandOptions.creationDate);
        queryParams.putIfNotEmpty("modificationDate", commandOptions.modificationDate);
        queryParams.putIfNotEmpty("internalStatus", commandOptions.internalStatus);
        queryParams.putIfNotEmpty("status", commandOptions.status);
        queryParams.putIfNotEmpty("phenotypes", commandOptions.phenotypes);
        queryParams.putIfNotEmpty("annotation", commandOptions.annotation);
        queryParams.putIfNotEmpty("acl", commandOptions.acl);
        queryParams.putIfNotEmpty("release", commandOptions.release);
        queryParams.putIfNotNull("snapshot", commandOptions.snapshot);
        queryParams.putIfNotNull("includeResult", commandOptions.includeResult);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }


        CohortGenerateParams cohortGenerateParams= null;
        if (commandOptions.jsonDataModel) {
            cohortGenerateParams = new CohortGenerateParams();
            RestResponse<Cohort> res = new RestResponse<>();
            res.setType(QueryType.VOID);
            PrintUtils.println(getObjectAsJSON(cohortGenerateParams));
            return res;
        } else if (commandOptions.jsonFile != null) {
            cohortGenerateParams = JacksonUtils.getDefaultObjectMapper()
                    .readValue(new java.io.File(commandOptions.jsonFile), CohortGenerateParams.class);
        } else {
            ObjectMap beanParams = new ObjectMap();
            putNestedIfNotEmpty(beanParams, "id",commandOptions.bodyId, true);
             putNestedIfNotEmpty(beanParams, "name",commandOptions.bodyName, true);
             putNestedIfNotNull(beanParams, "type",commandOptions.bodyType, true);
             putNestedIfNotEmpty(beanParams, "description",commandOptions.bodyDescription, true);
             putNestedIfNotEmpty(beanParams, "creationDate",commandOptions.bodyCreationDate, true);
             putNestedIfNotEmpty(beanParams, "modificationDate",commandOptions.bodyModificationDate, true);
             putNestedIfNotEmpty(beanParams, "status.id",commandOptions.statusId, true);
             putNestedIfNotEmpty(beanParams, "status.name",commandOptions.statusName, true);
             putNestedIfNotEmpty(beanParams, "status.description",commandOptions.statusDescription, true);
 
            cohortGenerateParams = JacksonUtils.getDefaultObjectMapper().copy()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true)
                    .readValue(beanParams.toJson(), CohortGenerateParams.class);
        }
        return openCGAClient.getCohortClient().generate(cohortGenerateParams, queryParams);
    }

    private RestResponse<Cohort> search() throws Exception {

        logger.debug("Executing search in Cohorts command line");

        CohortsCommandOptions.SearchCommandOptions commandOptions = cohortsCommandOptions.searchCommandOptions;

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
        queryParams.putIfNotNull("type", commandOptions.type);
        queryParams.putIfNotEmpty("creationDate", commandOptions.creationDate);
        queryParams.putIfNotEmpty("modificationDate", commandOptions.modificationDate);
        queryParams.putIfNotNull("deleted", commandOptions.deleted);
        queryParams.putIfNotEmpty("status", commandOptions.status);
        queryParams.putIfNotEmpty("internalStatus", commandOptions.internalStatus);
        queryParams.putIfNotEmpty("annotation", commandOptions.annotation);
        queryParams.putIfNotEmpty("acl", commandOptions.acl);
        queryParams.putIfNotEmpty("samples", commandOptions.samples);
        queryParams.putIfNotEmpty("numSamples", commandOptions.numSamples);
        queryParams.putIfNotEmpty("release", commandOptions.release);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getCohortClient().search(queryParams);
    }

    private RestResponse<AclEntryList> acl() throws Exception {

        logger.debug("Executing acl in Cohorts command line");

        CohortsCommandOptions.AclCommandOptions commandOptions = cohortsCommandOptions.aclCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("member", commandOptions.member);
        queryParams.putIfNotNull("silent", commandOptions.silent);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getCohortClient().acl(commandOptions.cohorts, queryParams);
    }

    private RestResponse<Cohort> delete() throws Exception {

        logger.debug("Executing delete in Cohorts command line");

        CohortsCommandOptions.DeleteCommandOptions commandOptions = cohortsCommandOptions.deleteCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getCohortClient().delete(commandOptions.cohorts, queryParams);
    }

    private RestResponse<Cohort> info() throws Exception {

        logger.debug("Executing info in Cohorts command line");

        CohortsCommandOptions.InfoCommandOptions commandOptions = cohortsCommandOptions.infoCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("include", commandOptions.include);
        queryParams.putIfNotEmpty("exclude", commandOptions.exclude);
        queryParams.putIfNotNull("flattenAnnotations", commandOptions.flattenAnnotations);
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotNull("deleted", commandOptions.deleted);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getCohortClient().info(commandOptions.cohorts, queryParams);
    }

    private RestResponse<Cohort> update() throws Exception {

        logger.debug("Executing update in Cohorts command line");

        CohortsCommandOptions.UpdateCommandOptions commandOptions = cohortsCommandOptions.updateCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("include", commandOptions.include);
        queryParams.putIfNotEmpty("exclude", commandOptions.exclude);
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotNull("includeResult", commandOptions.includeResult);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }


        CohortUpdateParams cohortUpdateParams= null;
        if (commandOptions.jsonDataModel) {
            cohortUpdateParams = new CohortUpdateParams();
            RestResponse<Cohort> res = new RestResponse<>();
            res.setType(QueryType.VOID);
            PrintUtils.println(getObjectAsJSON(cohortUpdateParams));
            return res;
        } else if (commandOptions.jsonFile != null) {
            cohortUpdateParams = JacksonUtils.getDefaultObjectMapper()
                    .readValue(new java.io.File(commandOptions.jsonFile), CohortUpdateParams.class);
        } else {
            ObjectMap beanParams = new ObjectMap();
            putNestedIfNotEmpty(beanParams, "id",commandOptions.id, true);
             putNestedIfNotEmpty(beanParams, "name",commandOptions.name, true);
             putNestedIfNotNull(beanParams, "type",commandOptions.type, true);
             putNestedIfNotEmpty(beanParams, "description",commandOptions.description, true);
             putNestedIfNotEmpty(beanParams, "creationDate",commandOptions.creationDate, true);
             putNestedIfNotEmpty(beanParams, "modificationDate",commandOptions.modificationDate, true);
             putNestedIfNotEmpty(beanParams, "status.id",commandOptions.statusId, true);
             putNestedIfNotEmpty(beanParams, "status.name",commandOptions.statusName, true);
             putNestedIfNotEmpty(beanParams, "status.description",commandOptions.statusDescription, true);
 
            cohortUpdateParams = JacksonUtils.getDefaultObjectMapper().copy()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true)
                    .readValue(beanParams.toJson(), CohortUpdateParams.class);
        }
        return openCGAClient.getCohortClient().update(commandOptions.cohorts, cohortUpdateParams, queryParams);
    }

    private RestResponse<Cohort> updateAnnotationSetsAnnotations() throws Exception {

        logger.debug("Executing updateAnnotationSetsAnnotations in Cohorts command line");

        CohortsCommandOptions.UpdateAnnotationSetsAnnotationsCommandOptions commandOptions = cohortsCommandOptions.updateAnnotationSetsAnnotationsCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotNull("action", commandOptions.action);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }


        ObjectMap objectMap= null;
        if (commandOptions.jsonDataModel) {
            objectMap = new ObjectMap();
            RestResponse<Cohort> res = new RestResponse<>();
            res.setType(QueryType.VOID);
            PrintUtils.println(getObjectAsJSON(objectMap));
            return res;
        } else if (commandOptions.jsonFile != null) {
            objectMap = JacksonUtils.getDefaultObjectMapper()
                    .readValue(new java.io.File(commandOptions.jsonFile), ObjectMap.class);
        }
        return openCGAClient.getCohortClient().updateAnnotationSetsAnnotations(commandOptions.cohort, commandOptions.annotationSet, objectMap, queryParams);
    }
}