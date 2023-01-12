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

import org.opencb.opencga.app.cli.main.options.IndividualsCommandOptions;

import java.util.Map;
import org.opencb.biodata.models.clinical.qc.SampleRelatednessReport;
import org.opencb.biodata.models.core.OntologyTermAnnotation;
import org.opencb.biodata.models.core.SexOntologyTermAnnotation;
import org.opencb.biodata.models.pedigree.IndividualProperty;
import org.opencb.commons.datastore.core.FacetField;
import org.opencb.opencga.catalog.utils.ParamUtils.AclAction;
import org.opencb.opencga.catalog.utils.ParamUtils.BasicUpdateAction;
import org.opencb.opencga.catalog.utils.ParamUtils.CompleteUpdateAction;
import org.opencb.opencga.core.models.common.StatusParams;
import org.opencb.opencga.core.models.common.TsvAnnotationParams;
import org.opencb.opencga.core.models.individual.Individual;
import org.opencb.opencga.core.models.individual.IndividualAclEntryList;
import org.opencb.opencga.core.models.individual.IndividualAclUpdateParams;
import org.opencb.opencga.core.models.individual.IndividualCreateParams;
import org.opencb.opencga.core.models.individual.IndividualPopulation;
import org.opencb.opencga.core.models.individual.IndividualQualityControl;
import org.opencb.opencga.core.models.individual.IndividualReferenceParam;
import org.opencb.opencga.core.models.individual.IndividualUpdateParams;
import org.opencb.opencga.core.models.individual.Location;
import org.opencb.opencga.core.models.job.Job;


/*
* WARNING: AUTOGENERATED CODE
*
* This code was generated by a tool.
*
* Manual changes to this file may cause unexpected behavior in your application.
* Manual changes to this file will be overwritten if the code is regenerated.
*  
*/
/**
 * This class contains methods for the Individuals command line.
 *    PATH: /{apiVersion}/individuals
 */
public class IndividualsCommandExecutor extends OpencgaCommandExecutor {

    private IndividualsCommandOptions individualsCommandOptions;

    public IndividualsCommandExecutor(IndividualsCommandOptions individualsCommandOptions) throws CatalogAuthenticationException {
        super(individualsCommandOptions.commonCommandOptions);
        this.individualsCommandOptions = individualsCommandOptions;
    }

    @Override
    public void execute() throws Exception {

        logger.debug("Executing Individuals command line");

        String subCommandString = getParsedSubCommand(individualsCommandOptions.jCommander);

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
            case "relatives":
                queryResponse = relatives();
                break;
            default:
                logger.error("Subcommand not valid");
                break;
        }

        createOutput(queryResponse);

    }

    private RestResponse<IndividualAclEntryList> updateAcl() throws Exception {

        logger.debug("Executing updateAcl in Individuals command line");

        IndividualsCommandOptions.UpdateAclCommandOptions commandOptions = individualsCommandOptions.updateAclCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotNull("propagate", commandOptions.propagate);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }


        IndividualAclUpdateParams individualAclUpdateParams= null;
        if (commandOptions.jsonDataModel) {
            individualAclUpdateParams = new IndividualAclUpdateParams();
            RestResponse<IndividualAclEntryList> res = new RestResponse<>();
            res.setType(QueryType.VOID);
            PrintUtils.println(getObjectAsJSON(individualAclUpdateParams));
            return res;
        } else if (commandOptions.jsonFile != null) {
            individualAclUpdateParams = JacksonUtils.getDefaultObjectMapper()
                    .readValue(new java.io.File(commandOptions.jsonFile), IndividualAclUpdateParams.class);
        } else {
            ObjectMap beanParams = new ObjectMap();
            putNestedIfNotEmpty(beanParams, "permissions",commandOptions.permissions, true);
             putNestedIfNotEmpty(beanParams, "individual",commandOptions.individual, true);
             putNestedIfNotEmpty(beanParams, "sample",commandOptions.sample, true);
 
            individualAclUpdateParams = JacksonUtils.getDefaultObjectMapper().copy()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true)
                    .readValue(beanParams.toJson(), IndividualAclUpdateParams.class);
        }
        return openCGAClient.getIndividualClient().updateAcl(commandOptions.members, commandOptions.action, individualAclUpdateParams, queryParams);
    }

    private RestResponse<FacetField> aggregationStats() throws Exception {

        logger.debug("Executing aggregationStats in Individuals command line");

        IndividualsCommandOptions.AggregationStatsCommandOptions commandOptions = individualsCommandOptions.aggregationStatsCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotNull("hasFather", commandOptions.hasFather);
        queryParams.putIfNotNull("hasMother", commandOptions.hasMother);
        queryParams.putIfNotEmpty("sex", commandOptions.sex);
        queryParams.putIfNotEmpty("karyotypicSex", commandOptions.karyotypicSex);
        queryParams.putIfNotEmpty("ethnicity", commandOptions.ethnicity);
        queryParams.putIfNotEmpty("population", commandOptions.population);
        queryParams.putIfNotEmpty("creationYear", commandOptions.creationYear);
        queryParams.putIfNotEmpty("creationMonth", commandOptions.creationMonth);
        queryParams.putIfNotEmpty("creationDay", commandOptions.creationDay);
        queryParams.putIfNotEmpty("creationDayOfWeek", commandOptions.creationDayOfWeek);
        queryParams.putIfNotEmpty("status", commandOptions.status);
        queryParams.putIfNotEmpty("lifeStatus", commandOptions.lifeStatus);
        queryParams.putIfNotEmpty("phenotypes", commandOptions.phenotypes);
        queryParams.putIfNotEmpty("numSamples", commandOptions.numSamples);
        queryParams.putIfNotNull("parentalConsanguinity", commandOptions.parentalConsanguinity);
        queryParams.putIfNotEmpty("release", commandOptions.release);
        queryParams.putIfNotEmpty("version", commandOptions.version);
        queryParams.putIfNotEmpty("annotation", commandOptions.annotation);
        queryParams.putIfNotNull("default_values", commandOptions.default_values);
        queryParams.putIfNotEmpty("field", commandOptions.field);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getIndividualClient().aggregationStats(queryParams);
    }

    private RestResponse<Job> loadAnnotationSets() throws Exception {

        logger.debug("Executing loadAnnotationSets in Individuals command line");

        IndividualsCommandOptions.LoadAnnotationSetsCommandOptions commandOptions = individualsCommandOptions.loadAnnotationSetsCommandOptions;

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
        return openCGAClient.getIndividualClient().loadAnnotationSets(commandOptions.variableSetId, commandOptions.path, tsvAnnotationParams, queryParams);
    }

    private RestResponse<Individual> create() throws Exception {

        logger.debug("Executing create in Individuals command line");

        IndividualsCommandOptions.CreateCommandOptions commandOptions = individualsCommandOptions.createCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("include", commandOptions.include);
        queryParams.putIfNotEmpty("exclude", commandOptions.exclude);
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("samples", commandOptions.samples);
        queryParams.putIfNotNull("includeResult", commandOptions.includeResult);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }


        IndividualCreateParams individualCreateParams= null;
        if (commandOptions.jsonDataModel) {
            individualCreateParams = new IndividualCreateParams();
            RestResponse<Individual> res = new RestResponse<>();
            res.setType(QueryType.VOID);
            PrintUtils.println(getObjectAsJSON(individualCreateParams));
            return res;
        } else if (commandOptions.jsonFile != null) {
            individualCreateParams = JacksonUtils.getDefaultObjectMapper()
                    .readValue(new java.io.File(commandOptions.jsonFile), IndividualCreateParams.class);
        } else {
            ObjectMap beanParams = new ObjectMap();
            putNestedIfNotEmpty(beanParams, "id",commandOptions.id, true);
             putNestedIfNotEmpty(beanParams, "name",commandOptions.name, true);
             putNestedIfNotEmpty(beanParams, "father.id",commandOptions.fatherId, true);
             putNestedIfNotEmpty(beanParams, "father.uuid",commandOptions.fatherUuid, true);
             putNestedIfNotEmpty(beanParams, "mother.id",commandOptions.motherId, true);
             putNestedIfNotEmpty(beanParams, "mother.uuid",commandOptions.motherUuid, true);
             putNestedIfNotEmpty(beanParams, "creationDate",commandOptions.creationDate, true);
             putNestedIfNotEmpty(beanParams, "modificationDate",commandOptions.modificationDate, true);
             putNestedIfNotEmpty(beanParams, "location.address",commandOptions.locationAddress, true);
             putNestedIfNotEmpty(beanParams, "location.postalCode",commandOptions.locationPostalCode, true);
             putNestedIfNotEmpty(beanParams, "location.city",commandOptions.locationCity, true);
             putNestedIfNotEmpty(beanParams, "location.state",commandOptions.locationState, true);
             putNestedIfNotEmpty(beanParams, "location.country",commandOptions.locationCountry, true);
             putNestedIfNotEmpty(beanParams, "sex.id",commandOptions.sexId, true);
             putNestedIfNotEmpty(beanParams, "sex.name",commandOptions.sexName, true);
             putNestedIfNotEmpty(beanParams, "sex.description",commandOptions.sexDescription, true);
             putNestedIfNotEmpty(beanParams, "sex.source",commandOptions.sexSource, true);
             putNestedIfNotEmpty(beanParams, "sex.url",commandOptions.sexUrl, true);
             putNestedIfNotNull(beanParams, "sex.attributes",commandOptions.sexAttributes, true);
             putNestedIfNotEmpty(beanParams, "ethnicity.id",commandOptions.ethnicityId, true);
             putNestedIfNotEmpty(beanParams, "ethnicity.name",commandOptions.ethnicityName, true);
             putNestedIfNotEmpty(beanParams, "ethnicity.description",commandOptions.ethnicityDescription, true);
             putNestedIfNotEmpty(beanParams, "ethnicity.source",commandOptions.ethnicitySource, true);
             putNestedIfNotEmpty(beanParams, "ethnicity.url",commandOptions.ethnicityUrl, true);
             putNestedIfNotNull(beanParams, "ethnicity.attributes",commandOptions.ethnicityAttributes, true);
             putNestedIfNotNull(beanParams, "parentalConsanguinity",commandOptions.parentalConsanguinity, true);
             putNestedIfNotEmpty(beanParams, "population.name",commandOptions.populationName, true);
             putNestedIfNotEmpty(beanParams, "population.subpopulation",commandOptions.populationSubpopulation, true);
             putNestedIfNotEmpty(beanParams, "population.description",commandOptions.populationDescription, true);
             putNestedIfNotEmpty(beanParams, "dateOfBirth",commandOptions.dateOfBirth, true);
             putNestedIfNotNull(beanParams, "karyotypicSex",commandOptions.karyotypicSex, true);
             putNestedIfNotNull(beanParams, "lifeStatus",commandOptions.lifeStatus, true);
             putNestedIfNotEmpty(beanParams, "status.id",commandOptions.statusId, true);
             putNestedIfNotEmpty(beanParams, "status.name",commandOptions.statusName, true);
             putNestedIfNotEmpty(beanParams, "status.description",commandOptions.statusDescription, true);
             putNestedIfNotNull(beanParams, "attributes",commandOptions.attributes, true);
 
            individualCreateParams = JacksonUtils.getDefaultObjectMapper().copy()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true)
                    .readValue(beanParams.toJson(), IndividualCreateParams.class);
        }
        return openCGAClient.getIndividualClient().create(individualCreateParams, queryParams);
    }

    private RestResponse<Object> distinct() throws Exception {

        logger.debug("Executing distinct in Individuals command line");

        IndividualsCommandOptions.DistinctCommandOptions commandOptions = individualsCommandOptions.distinctCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("id", commandOptions.id);
        queryParams.putIfNotEmpty("uuid", commandOptions.uuid);
        queryParams.putIfNotEmpty("name", commandOptions.name);
        queryParams.putIfNotEmpty("familyIds", commandOptions.familyIds);
        queryParams.putIfNotEmpty("father", commandOptions.father);
        queryParams.putIfNotEmpty("mother", commandOptions.mother);
        queryParams.putIfNotEmpty("samples", commandOptions.samples);
        queryParams.putIfNotEmpty("sex", commandOptions.sex);
        queryParams.putIfNotEmpty("ethnicity", commandOptions.ethnicity);
        queryParams.putIfNotEmpty("dateOfBirth", commandOptions.dateOfBirth);
        queryParams.putIfNotEmpty("disorders", commandOptions.disorders);
        queryParams.putIfNotEmpty("phenotypes", commandOptions.phenotypes);
        queryParams.putIfNotEmpty("populationName", commandOptions.populationName);
        queryParams.putIfNotEmpty("populationSubpopulation", commandOptions.populationSubpopulation);
        queryParams.putIfNotEmpty("karyotypicSex", commandOptions.karyotypicSex);
        queryParams.putIfNotEmpty("lifeStatus", commandOptions.lifeStatus);
        queryParams.putIfNotEmpty("internalStatus", commandOptions.internalStatus);
        queryParams.putIfNotEmpty("status", commandOptions.status);
        queryParams.putIfNotNull("deleted", commandOptions.deleted);
        queryParams.putIfNotEmpty("creationDate", commandOptions.creationDate);
        queryParams.putIfNotEmpty("modificationDate", commandOptions.modificationDate);
        queryParams.putIfNotEmpty("annotation", commandOptions.annotation);
        queryParams.putIfNotEmpty("acl", commandOptions.acl);
        queryParams.putIfNotEmpty("release", commandOptions.release);
        queryParams.putIfNotNull("snapshot", commandOptions.snapshot);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getIndividualClient().distinct(commandOptions.field, queryParams);
    }

    private RestResponse<Individual> search() throws Exception {

        logger.debug("Executing search in Individuals command line");

        IndividualsCommandOptions.SearchCommandOptions commandOptions = individualsCommandOptions.searchCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("include", commandOptions.include);
        queryParams.putIfNotEmpty("exclude", commandOptions.exclude);
        queryParams.putIfNotNull("limit", commandOptions.limit);
        queryParams.putIfNotNull("skip", commandOptions.skip);
        queryParams.putIfNotNull("count", commandOptions.count);
        queryParams.putIfNotNull("flattenAnnotations", commandOptions.flattenAnnotations);
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("id", commandOptions.id);
        queryParams.putIfNotEmpty("uuid", commandOptions.uuid);
        queryParams.putIfNotEmpty("name", commandOptions.name);
        queryParams.putIfNotEmpty("father", commandOptions.father);
        queryParams.putIfNotEmpty("mother", commandOptions.mother);
        queryParams.putIfNotEmpty("samples", commandOptions.samples);
        queryParams.putIfNotEmpty("familyIds", commandOptions.familyIds);
        queryParams.putIfNotEmpty("sex", commandOptions.sex);
        queryParams.putIfNotEmpty("dateOfBirth", commandOptions.dateOfBirth);
        queryParams.putIfNotEmpty("ethnicity", commandOptions.ethnicity);
        queryParams.putIfNotEmpty("disorders", commandOptions.disorders);
        queryParams.putIfNotEmpty("phenotypes", commandOptions.phenotypes);
        queryParams.putIfNotEmpty("populationName", commandOptions.populationName);
        queryParams.putIfNotEmpty("populationSubpopulation", commandOptions.populationSubpopulation);
        queryParams.putIfNotEmpty("karyotypicSex", commandOptions.karyotypicSex);
        queryParams.putIfNotEmpty("lifeStatus", commandOptions.lifeStatus);
        queryParams.putIfNotEmpty("internalStatus", commandOptions.internalStatus);
        queryParams.putIfNotEmpty("status", commandOptions.status);
        queryParams.putIfNotNull("deleted", commandOptions.deleted);
        queryParams.putIfNotEmpty("creationDate", commandOptions.creationDate);
        queryParams.putIfNotEmpty("modificationDate", commandOptions.modificationDate);
        queryParams.putIfNotEmpty("annotation", commandOptions.annotation);
        queryParams.putIfNotEmpty("acl", commandOptions.acl);
        queryParams.putIfNotEmpty("release", commandOptions.release);
        queryParams.putIfNotNull("snapshot", commandOptions.snapshot);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getIndividualClient().search(queryParams);
    }

    private RestResponse<IndividualAclEntryList> acl() throws Exception {

        logger.debug("Executing acl in Individuals command line");

        IndividualsCommandOptions.AclCommandOptions commandOptions = individualsCommandOptions.aclCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("member", commandOptions.member);
        queryParams.putIfNotNull("silent", commandOptions.silent);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getIndividualClient().acl(commandOptions.individuals, queryParams);
    }

    private RestResponse<Individual> delete() throws Exception {

        logger.debug("Executing delete in Individuals command line");

        IndividualsCommandOptions.DeleteCommandOptions commandOptions = individualsCommandOptions.deleteCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotNull("force", commandOptions.force);
        queryParams.putIfNotEmpty("study", commandOptions.study);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getIndividualClient().delete(commandOptions.individuals, queryParams);
    }

    private RestResponse<Individual> info() throws Exception {

        logger.debug("Executing info in Individuals command line");

        IndividualsCommandOptions.InfoCommandOptions commandOptions = individualsCommandOptions.infoCommandOptions;

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

        return openCGAClient.getIndividualClient().info(commandOptions.individuals, queryParams);
    }

    private RestResponse<Individual> update() throws Exception {

        logger.debug("Executing update in Individuals command line");

        IndividualsCommandOptions.UpdateCommandOptions commandOptions = individualsCommandOptions.updateCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("include", commandOptions.include);
        queryParams.putIfNotEmpty("exclude", commandOptions.exclude);
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotNull("includeResult", commandOptions.includeResult);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }


        IndividualUpdateParams individualUpdateParams= null;
        if (commandOptions.jsonDataModel) {
            individualUpdateParams = new IndividualUpdateParams();
            RestResponse<Individual> res = new RestResponse<>();
            res.setType(QueryType.VOID);
            PrintUtils.println(getObjectAsJSON(individualUpdateParams));
            return res;
        } else if (commandOptions.jsonFile != null) {
            individualUpdateParams = JacksonUtils.getDefaultObjectMapper()
                    .readValue(new java.io.File(commandOptions.jsonFile), IndividualUpdateParams.class);
        } else {
            ObjectMap beanParams = new ObjectMap();
            putNestedIfNotEmpty(beanParams, "id",commandOptions.id, true);
             putNestedIfNotEmpty(beanParams, "name",commandOptions.name, true);
             putNestedIfNotEmpty(beanParams, "father.id",commandOptions.fatherId, true);
             putNestedIfNotEmpty(beanParams, "father.uuid",commandOptions.fatherUuid, true);
             putNestedIfNotEmpty(beanParams, "mother.id",commandOptions.motherId, true);
             putNestedIfNotEmpty(beanParams, "mother.uuid",commandOptions.motherUuid, true);
             putNestedIfNotEmpty(beanParams, "creationDate",commandOptions.creationDate, true);
             putNestedIfNotEmpty(beanParams, "modificationDate",commandOptions.modificationDate, true);
             putNestedIfNotNull(beanParams, "parentalConsanguinity",commandOptions.parentalConsanguinity, true);
             putNestedIfNotEmpty(beanParams, "location.address",commandOptions.locationAddress, true);
             putNestedIfNotEmpty(beanParams, "location.postalCode",commandOptions.locationPostalCode, true);
             putNestedIfNotEmpty(beanParams, "location.city",commandOptions.locationCity, true);
             putNestedIfNotEmpty(beanParams, "location.state",commandOptions.locationState, true);
             putNestedIfNotEmpty(beanParams, "location.country",commandOptions.locationCountry, true);
             putNestedIfNotEmpty(beanParams, "sex.id",commandOptions.sexId, true);
             putNestedIfNotEmpty(beanParams, "sex.name",commandOptions.sexName, true);
             putNestedIfNotEmpty(beanParams, "sex.description",commandOptions.sexDescription, true);
             putNestedIfNotEmpty(beanParams, "sex.source",commandOptions.sexSource, true);
             putNestedIfNotEmpty(beanParams, "sex.url",commandOptions.sexUrl, true);
             putNestedIfNotNull(beanParams, "sex.attributes",commandOptions.sexAttributes, true);
             putNestedIfNotEmpty(beanParams, "ethnicity.id",commandOptions.ethnicityId, true);
             putNestedIfNotEmpty(beanParams, "ethnicity.name",commandOptions.ethnicityName, true);
             putNestedIfNotEmpty(beanParams, "ethnicity.description",commandOptions.ethnicityDescription, true);
             putNestedIfNotEmpty(beanParams, "ethnicity.source",commandOptions.ethnicitySource, true);
             putNestedIfNotEmpty(beanParams, "ethnicity.url",commandOptions.ethnicityUrl, true);
             putNestedIfNotNull(beanParams, "ethnicity.attributes",commandOptions.ethnicityAttributes, true);
             putNestedIfNotEmpty(beanParams, "population.name",commandOptions.populationName, true);
             putNestedIfNotEmpty(beanParams, "population.subpopulation",commandOptions.populationSubpopulation, true);
             putNestedIfNotEmpty(beanParams, "population.description",commandOptions.populationDescription, true);
             putNestedIfNotEmpty(beanParams, "dateOfBirth",commandOptions.dateOfBirth, true);
             putNestedIfNotNull(beanParams, "karyotypicSex",commandOptions.karyotypicSex, true);
             putNestedIfNotNull(beanParams, "lifeStatus",commandOptions.lifeStatus, true);
             putNestedIfNotEmpty(beanParams, "status.id",commandOptions.statusId, true);
             putNestedIfNotEmpty(beanParams, "status.name",commandOptions.statusName, true);
             putNestedIfNotEmpty(beanParams, "status.description",commandOptions.statusDescription, true);
             putNestedIfNotNull(beanParams, "qualityControl.files",commandOptions.qualityControlFiles, true);
             putNestedIfNotNull(beanParams, "attributes",commandOptions.attributes, true);
 
            individualUpdateParams = JacksonUtils.getDefaultObjectMapper().copy()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true)
                    .readValue(beanParams.toJson(), IndividualUpdateParams.class);
        }
        return openCGAClient.getIndividualClient().update(commandOptions.individuals, individualUpdateParams, queryParams);
    }

    private RestResponse<Individual> updateAnnotationSetsAnnotations() throws Exception {

        logger.debug("Executing updateAnnotationSetsAnnotations in Individuals command line");

        IndividualsCommandOptions.UpdateAnnotationSetsAnnotationsCommandOptions commandOptions = individualsCommandOptions.updateAnnotationSetsAnnotationsCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotNull("action", commandOptions.action);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }


        ObjectMap objectMap= null;
        if (commandOptions.jsonDataModel) {
            objectMap = new ObjectMap();
            RestResponse<Individual> res = new RestResponse<>();
            res.setType(QueryType.VOID);
            PrintUtils.println(getObjectAsJSON(objectMap));
            return res;
        } else if (commandOptions.jsonFile != null) {
            objectMap = JacksonUtils.getDefaultObjectMapper()
                    .readValue(new java.io.File(commandOptions.jsonFile), ObjectMap.class);
        }
        return openCGAClient.getIndividualClient().updateAnnotationSetsAnnotations(commandOptions.individual, commandOptions.annotationSet, objectMap, queryParams);
    }

    private RestResponse<Individual> relatives() throws Exception {

        logger.debug("Executing relatives in Individuals command line");

        IndividualsCommandOptions.RelativesCommandOptions commandOptions = individualsCommandOptions.relativesCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("include", commandOptions.include);
        queryParams.putIfNotEmpty("exclude", commandOptions.exclude);
        queryParams.putIfNotNull("flattenAnnotations", commandOptions.flattenAnnotations);
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotNull("degree", commandOptions.degree);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getIndividualClient().relatives(commandOptions.individual, queryParams);
    }
}