package org.opencb.opencga.app.cli.main.executors;

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
* Autogenerated on: 2022-06-21
*
* Manual changes to this file may cause unexpected behavior in your application.
* Manual changes to this file will be overwritten if the code is regenerated.
*/


/**
 * This class contains methods for the Individuals command line.
 *    OpenCGA version: 2.4.0-SNAPSHOT
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

    private RestResponse<ObjectMap> updateAcl() throws Exception {

        logger.debug("Executing updateAcl in Individuals command line");

        IndividualsCommandOptions.UpdateAclCommandOptions commandOptions = individualsCommandOptions.updateAclCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotNull("propagate", commandOptions.propagate);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }


        IndividualAclUpdateParams individualAclUpdateParams = new IndividualAclUpdateParams();
        if (commandOptions.jsonDataModel) {
            RestResponse<ObjectMap> res = new RestResponse<>();
            res.setType(QueryType.VOID);
            PrintUtils.println(getObjectAsJSON(individualAclUpdateParams));
            return res;
        } else if (commandOptions.jsonFile != null) {
            individualAclUpdateParams = JacksonUtils.getDefaultObjectMapper()
                    .readValue(new java.io.File(commandOptions.jsonFile), IndividualAclUpdateParams.class);
        } else {
            individualAclUpdateParams.setPermissions(commandOptions.permissions);
            individualAclUpdateParams.setIndividual(commandOptions.individual);
            individualAclUpdateParams.setSample(commandOptions.sample);

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


        TsvAnnotationParams tsvAnnotationParams = new TsvAnnotationParams();
        if (commandOptions.jsonDataModel) {
            RestResponse<Job> res = new RestResponse<>();
            res.setType(QueryType.VOID);
            PrintUtils.println(getObjectAsJSON(tsvAnnotationParams));
            return res;
        } else if (commandOptions.jsonFile != null) {
            tsvAnnotationParams = JacksonUtils.getDefaultObjectMapper()
                    .readValue(new java.io.File(commandOptions.jsonFile), TsvAnnotationParams.class);
        } else {
            tsvAnnotationParams.setContent(commandOptions.content);

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


        IndividualCreateParams individualCreateParams = new IndividualCreateParams();
        if (commandOptions.jsonDataModel) {
            RestResponse<Individual> res = new RestResponse<>();
            res.setType(QueryType.VOID);
            PrintUtils.println(getObjectAsJSON(individualCreateParams));
            return res;
        } else if (commandOptions.jsonFile != null) {
            individualCreateParams = JacksonUtils.getDefaultObjectMapper()
                    .readValue(new java.io.File(commandOptions.jsonFile), IndividualCreateParams.class);
        } else {
            // Generate beans for nested objects
            IndividualReferenceParam bodyFatherParam = new IndividualReferenceParam();
            bodyFatherParam.setId(commandOptions.fatherId);
            bodyFatherParam.setUuid(commandOptions.fatherUuid);

            IndividualReferenceParam bodyMotherParam = new IndividualReferenceParam();
            bodyMotherParam.setId(commandOptions.motherId);
            bodyMotherParam.setUuid(commandOptions.motherUuid);

            Location bodyLocationParam = new Location();
            bodyLocationParam.setAddress(commandOptions.locationAddress);
            bodyLocationParam.setPostalCode(commandOptions.locationPostalCode);
            bodyLocationParam.setCity(commandOptions.locationCity);
            bodyLocationParam.setState(commandOptions.locationState);
            bodyLocationParam.setCountry(commandOptions.locationCountry);

            SexOntologyTermAnnotation bodySexParam = new SexOntologyTermAnnotation();
            bodySexParam.setId(commandOptions.sexId);
            bodySexParam.setName(commandOptions.sexName);
            bodySexParam.setDescription(commandOptions.sexDescription);
            bodySexParam.setSource(commandOptions.sexSource);
            bodySexParam.setUrl(commandOptions.sexUrl);
            bodySexParam.setAttributes(new HashMap<>(commandOptions.sexAttributes));

            OntologyTermAnnotation bodyEthnicityParam = new OntologyTermAnnotation();
            bodyEthnicityParam.setId(commandOptions.ethnicityId);
            bodyEthnicityParam.setName(commandOptions.ethnicityName);
            bodyEthnicityParam.setDescription(commandOptions.ethnicityDescription);
            bodyEthnicityParam.setSource(commandOptions.ethnicitySource);
            bodyEthnicityParam.setUrl(commandOptions.ethnicityUrl);
            bodyEthnicityParam.setAttributes(new HashMap<>(commandOptions.ethnicityAttributes));

            IndividualPopulation bodyPopulationParam = new IndividualPopulation();
            bodyPopulationParam.setName(commandOptions.populationName);
            bodyPopulationParam.setSubpopulation(commandOptions.populationSubpopulation);
            bodyPopulationParam.setDescription(commandOptions.populationDescription);

            StatusParams bodyStatusParam = new StatusParams();
            bodyStatusParam.setId(commandOptions.statusId);
            bodyStatusParam.setName(commandOptions.statusName);
            bodyStatusParam.setDescription(commandOptions.statusDescription);

            //Set main body params
            individualCreateParams.setId(commandOptions.bodyId);
            individualCreateParams.setName(commandOptions.bodyName);
            individualCreateParams.setFather(bodyFatherParam);
            individualCreateParams.setMother(bodyMotherParam);
            individualCreateParams.setCreationDate(commandOptions.bodyCreationDate);
            individualCreateParams.setModificationDate(commandOptions.bodyModificationDate);
            individualCreateParams.setLocation(bodyLocationParam);
            //individualCreateParams.setSamples(commandOptions.bodySamples); // Unsupported param. FIXME 
            individualCreateParams.setSex(bodySexParam);
            individualCreateParams.setEthnicity(bodyEthnicityParam);
            individualCreateParams.setPopulation(bodyPopulationParam);
            individualCreateParams.setDateOfBirth(commandOptions.bodyDateOfBirth);
            individualCreateParams.setKaryotypicSex(commandOptions.bodyKaryotypicSex == null ? null : IndividualProperty.KaryotypicSex.valueOf(commandOptions.bodyKaryotypicSex));
            individualCreateParams.setLifeStatus(commandOptions.bodyLifeStatus == null ? null : IndividualProperty.LifeStatus.valueOf(commandOptions.bodyLifeStatus));
            //individualCreateParams.setAnnotationSets(commandOptions.bodyAnnotationSets); // Unsupported param. FIXME 
            //individualCreateParams.setPhenotypes(commandOptions.bodyPhenotypes); // Unsupported param. FIXME 
            //individualCreateParams.setDisorders(commandOptions.bodyDisorders); // Unsupported param. FIXME 
            individualCreateParams.setStatus(bodyStatusParam);
            individualCreateParams.setAttributes(new HashMap<>(commandOptions.bodyAttributes));

            if (commandOptions.bodyParentalConsanguinity != null) {
                individualCreateParams.setParentalConsanguinity(commandOptions.bodyParentalConsanguinity);
            }
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

    private RestResponse<ObjectMap> acl() throws Exception {

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


        IndividualUpdateParams individualUpdateParams = new IndividualUpdateParams();
        if (commandOptions.jsonDataModel) {
            RestResponse<Individual> res = new RestResponse<>();
            res.setType(QueryType.VOID);
            PrintUtils.println(getObjectAsJSON(individualUpdateParams));
            return res;
        } else if (commandOptions.jsonFile != null) {
            individualUpdateParams = JacksonUtils.getDefaultObjectMapper()
                    .readValue(new java.io.File(commandOptions.jsonFile), IndividualUpdateParams.class);
        } else {
            // Generate beans for nested objects
            IndividualReferenceParam fatherParam = new IndividualReferenceParam();
            fatherParam.setId(commandOptions.fatherId);
            fatherParam.setUuid(commandOptions.fatherUuid);

            IndividualReferenceParam motherParam = new IndividualReferenceParam();
            motherParam.setId(commandOptions.motherId);
            motherParam.setUuid(commandOptions.motherUuid);

            Location locationParam = new Location();
            locationParam.setAddress(commandOptions.locationAddress);
            locationParam.setPostalCode(commandOptions.locationPostalCode);
            locationParam.setCity(commandOptions.locationCity);
            locationParam.setState(commandOptions.locationState);
            locationParam.setCountry(commandOptions.locationCountry);

            SexOntologyTermAnnotation sexParam = new SexOntologyTermAnnotation();
            sexParam.setId(commandOptions.sexId);
            sexParam.setName(commandOptions.sexName);
            sexParam.setDescription(commandOptions.sexDescription);
            sexParam.setSource(commandOptions.sexSource);
            sexParam.setUrl(commandOptions.sexUrl);
            sexParam.setAttributes(new HashMap<>(commandOptions.sexAttributes));

            OntologyTermAnnotation ethnicityParam = new OntologyTermAnnotation();
            ethnicityParam.setId(commandOptions.ethnicityId);
            ethnicityParam.setName(commandOptions.ethnicityName);
            ethnicityParam.setDescription(commandOptions.ethnicityDescription);
            ethnicityParam.setSource(commandOptions.ethnicitySource);
            ethnicityParam.setUrl(commandOptions.ethnicityUrl);
            ethnicityParam.setAttributes(new HashMap<>(commandOptions.ethnicityAttributes));

            IndividualPopulation populationParam = new IndividualPopulation();
            populationParam.setName(commandOptions.populationName);
            populationParam.setSubpopulation(commandOptions.populationSubpopulation);
            populationParam.setDescription(commandOptions.populationDescription);

            StatusParams statusParam = new StatusParams();
            statusParam.setId(commandOptions.statusId);
            statusParam.setName(commandOptions.statusName);
            statusParam.setDescription(commandOptions.statusDescription);

            IndividualQualityControl qualityControlParam = new IndividualQualityControl();
            //qualityControlParam.setInferredSexReports(commandOptions.qualityControlInferredSexReports);  // Unsupported param. FIXME
            //qualityControlParam.setSampleRelatednessReport(commandOptions.qualityControlSampleRelatednessReport);  // Unsupported param. FIXME
            //qualityControlParam.setMendelianErrorReports(commandOptions.qualityControlMendelianErrorReports);  // Unsupported param. FIXME
            qualityControlParam.setFiles(splitWithTrim(commandOptions.qualityControlFiles));
            //qualityControlParam.setComments(commandOptions.qualityControlComments);  // Unsupported param. FIXME

            //Set main body params
            individualUpdateParams.setId(commandOptions.id);
            individualUpdateParams.setName(commandOptions.name);
            individualUpdateParams.setFather(fatherParam);
            individualUpdateParams.setMother(motherParam);
            individualUpdateParams.setCreationDate(commandOptions.creationDate);
            individualUpdateParams.setModificationDate(commandOptions.modificationDate);
            individualUpdateParams.setLocation(locationParam);
            individualUpdateParams.setSex(sexParam);
            individualUpdateParams.setEthnicity(ethnicityParam);
            individualUpdateParams.setPopulation(populationParam);
            individualUpdateParams.setDateOfBirth(commandOptions.dateOfBirth);
            individualUpdateParams.setKaryotypicSex(commandOptions.karyotypicSex == null ? null : IndividualProperty.KaryotypicSex.valueOf(commandOptions.karyotypicSex));
            individualUpdateParams.setLifeStatus(commandOptions.lifeStatus == null ? null : IndividualProperty.LifeStatus.valueOf(commandOptions.lifeStatus));
            //individualUpdateParams.setSamples(commandOptions.samples); // Unsupported param. FIXME 
            //individualUpdateParams.setAnnotationSets(commandOptions.annotationSets); // Unsupported param. FIXME 
            //individualUpdateParams.setPhenotypes(commandOptions.phenotypes); // Unsupported param. FIXME 
            //individualUpdateParams.setDisorders(commandOptions.disorders); // Unsupported param. FIXME 
            individualUpdateParams.setStatus(statusParam);
            individualUpdateParams.setQualityControl(qualityControlParam);
            individualUpdateParams.setAttributes(new HashMap<>(commandOptions.attributes));

            if (commandOptions.parentalConsanguinity != null) {
                individualUpdateParams.setParentalConsanguinity(commandOptions.parentalConsanguinity);
            }
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


        ObjectMap objectMap = new ObjectMap();
        if (commandOptions.jsonDataModel) {
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