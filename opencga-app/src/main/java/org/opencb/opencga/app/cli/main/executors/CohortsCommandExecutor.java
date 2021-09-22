package org.opencb.opencga.app.cli.main.executors;

import org.opencb.opencga.app.cli.main.executors.OpencgaCommandExecutor;
import org.opencb.opencga.app.cli.main.*;
import org.opencb.opencga.core.response.RestResponse;
import org.opencb.opencga.client.exceptions.ClientException;
import org.opencb.commons.datastore.core.ObjectMap;

import org.opencb.opencga.app.cli.main.options.CohortsCommandOptions;

import org.opencb.opencga.core.models.job.Job;
import org.opencb.opencga.catalog.utils.ParamUtils.BasicUpdateAction;
import org.opencb.commons.datastore.core.FacetField;
import org.opencb.opencga.core.models.cohort.Cohort;
import org.opencb.opencga.core.models.cohort.CohortCreateParams;
import org.opencb.opencga.core.models.cohort.CohortAclUpdateParams;
import org.opencb.opencga.core.models.common.TsvAnnotationParams;
import org.opencb.opencga.core.models.cohort.CohortUpdateParams;
import org.opencb.opencga.catalog.utils.ParamUtils.AclAction;
import org.opencb.opencga.core.models.cohort.CohortGenerateParams;
import java.util.Map;
import org.opencb.opencga.catalog.utils.ParamUtils.CompleteUpdateAction;
import org.opencb.opencga.core.models.common.Enums.CohortType;


/*
* WARNING: AUTOGENERATED CODE
*
* This code was generated by a tool.
* Autogenerated on: 2021-09-21
*
* Manual changes to this file may cause unexpected behavior in your application.
* Manual changes to this file will be overwritten if the code is regenerated.
*/


/**
 * This class contains methods for the Cohorts command line.
 *    OpenCGA version: 2.1.0-rc2-SNAPSHOT
 *    PATH: /{apiVersion}/cohorts
 */
public class CohortsCommandExecutor extends OpencgaCommandExecutor {

    private CohortsCommandOptions cohortsCommandOptions;

    public CohortsCommandExecutor(CohortsCommandOptions cohortsCommandOptions) {
        super(cohortsCommandOptions.commonCommandOptions);
        this.cohortsCommandOptions = cohortsCommandOptions;
    }

    @Override
    public void execute() throws Exception {

        logger.debug("Executing Cohorts command line");

        String subCommandString = getParsedSubCommand(cohortsCommandOptions.jCommander);

        RestResponse queryResponse = null;

        switch (subCommandString) {
            case "update-acl":
                queryResponse = updateAcl();
                break;
            case "aggregationStats":
                queryResponse = aggregationStats();
                break;
            case "load-annotationSets":
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
            default:
                logger.error("Subcommand not valid");
                break;
        }

        createOutput(queryResponse);

    }

    private RestResponse<ObjectMap> updateAcl() throws Exception {

        logger.debug("Executing updateAcl in Cohorts command line");

        CohortsCommandOptions.UpdateAclCommandOptions commandOptions = cohortsCommandOptions.updateAclCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);

        CohortAclUpdateParams cohortAclUpdateParams = new CohortAclUpdateParams()
            .setCohort(commandOptions.cohort);
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

        return openCGAClient.getCohortClient().aggregationStats(queryParams);
    }

    private RestResponse<Job> loadAnnotationSets() throws Exception {

        logger.debug("Executing loadAnnotationSets in Cohorts command line");

        CohortsCommandOptions.LoadAnnotationSetsCommandOptions commandOptions = cohortsCommandOptions.loadAnnotationSetsCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotNull("parents", commandOptions.parents);
        queryParams.putIfNotEmpty("annotationSetId", commandOptions.annotationSetId);

        TsvAnnotationParams tsvAnnotationParams = new TsvAnnotationParams()
            .setContent(commandOptions.content);
        return openCGAClient.getCohortClient().loadAnnotationSets(commandOptions.variableSetId, commandOptions.path, tsvAnnotationParams, queryParams);
    }

    private RestResponse<Cohort> create() throws Exception {

        logger.debug("Executing create in Cohorts command line");

        CohortsCommandOptions.CreateCommandOptions commandOptions = cohortsCommandOptions.createCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("variableSet", commandOptions.variableSet);
        queryParams.putIfNotEmpty("variable", commandOptions.variable);

        CohortCreateParams cohortCreateParams = new CohortCreateParams()
            .setId(commandOptions.id)
            .setDescription(commandOptions.description)
            .setCreationDate(commandOptions.creationDate)
            .setModificationDate(commandOptions.modificationDate);
        return openCGAClient.getCohortClient().create(cohortCreateParams, queryParams);
    }

    private RestResponse<ObjectMap> distinct() throws Exception {

        logger.debug("Executing distinct in Cohorts command line");

        CohortsCommandOptions.DistinctCommandOptions commandOptions = cohortsCommandOptions.distinctCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotNull("type", commandOptions.type);
        queryParams.putIfNotEmpty("creationDate", commandOptions.creationDate);
        queryParams.putIfNotEmpty("modificationDate", commandOptions.modificationDate);
        queryParams.putIfNotNull("deleted", commandOptions.deleted);
        queryParams.putIfNotEmpty("internalStatus", commandOptions.internalStatus);
        queryParams.putIfNotEmpty("status", commandOptions.status);
        queryParams.putIfNotEmpty("annotation", commandOptions.annotation);
        queryParams.putIfNotEmpty("acl", commandOptions.acl);
        queryParams.putIfNotEmpty("samples", commandOptions.samples);
        queryParams.putIfNotEmpty("numSamples", commandOptions.numSamples);
        queryParams.putIfNotEmpty("release", commandOptions.release);

        return openCGAClient.getCohortClient().distinct(commandOptions.field, queryParams);
    }

    private RestResponse<Cohort> generate() throws Exception {

        logger.debug("Executing generate in Cohorts command line");

        CohortsCommandOptions.GenerateCommandOptions commandOptions = cohortsCommandOptions.generateCommandOptions;

        ObjectMap queryParams = new ObjectMap();
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

        CohortGenerateParams cohortGenerateParams = new CohortGenerateParams()
            .setId(commandOptions.bodyId)
            .setDescription(commandOptions.description)
            .setCreationDate(commandOptions.bodyCreationDate)
            .setModificationDate(commandOptions.bodyModificationDate);
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
        queryParams.putIfNotEmpty("name", commandOptions.name);
        queryParams.putIfNotNull("type", commandOptions.type);
        queryParams.putIfNotEmpty("creationDate", commandOptions.creationDate);
        queryParams.putIfNotEmpty("modificationDate", commandOptions.modificationDate);
        queryParams.putIfNotNull("deleted", commandOptions.deleted);
        queryParams.putIfNotEmpty("internalStatus", commandOptions.internalStatus);
        queryParams.putIfNotEmpty("status", commandOptions.status);
        queryParams.putIfNotEmpty("annotation", commandOptions.annotation);
        queryParams.putIfNotEmpty("acl", commandOptions.acl);
        queryParams.putIfNotEmpty("samples", commandOptions.samples);
        queryParams.putIfNotEmpty("numSamples", commandOptions.numSamples);
        queryParams.putIfNotEmpty("release", commandOptions.release);

        return openCGAClient.getCohortClient().search(queryParams);
    }

    private RestResponse<ObjectMap> acl() throws Exception {

        logger.debug("Executing acl in Cohorts command line");

        CohortsCommandOptions.AclCommandOptions commandOptions = cohortsCommandOptions.aclCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("member", commandOptions.member);
        queryParams.putIfNotNull("silent", commandOptions.silent);

        return openCGAClient.getCohortClient().acl(commandOptions.cohorts, queryParams);
    }

    private RestResponse<Cohort> delete() throws Exception {

        logger.debug("Executing delete in Cohorts command line");

        CohortsCommandOptions.DeleteCommandOptions commandOptions = cohortsCommandOptions.deleteCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);

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

        return openCGAClient.getCohortClient().info(commandOptions.cohorts, queryParams);
    }

    private RestResponse<Cohort> update() throws Exception {

        logger.debug("Executing update in Cohorts command line");

        CohortsCommandOptions.UpdateCommandOptions commandOptions = cohortsCommandOptions.updateCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotNull("samplesAction", commandOptions.samplesAction);
        queryParams.putIfNotNull("annotationSetsAction", commandOptions.annotationSetsAction);

        CohortUpdateParams cohortUpdateParams = new CohortUpdateParams()
            .setId(commandOptions.id)
            .setDescription(commandOptions.description)
            .setCreationDate(commandOptions.creationDate)
            .setModificationDate(commandOptions.modificationDate);
        return openCGAClient.getCohortClient().update(commandOptions.cohorts, cohortUpdateParams, queryParams);
    }
}