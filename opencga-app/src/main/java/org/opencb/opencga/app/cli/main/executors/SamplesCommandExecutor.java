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

import org.opencb.opencga.app.cli.main.options.SamplesCommandOptions;

import java.util.Map;
import org.opencb.biodata.models.core.OntologyTermAnnotation;
import org.opencb.commons.datastore.core.FacetField;
import org.opencb.opencga.catalog.utils.ParamUtils.AclAction;
import org.opencb.opencga.catalog.utils.ParamUtils.BasicUpdateAction;
import org.opencb.opencga.catalog.utils.ParamUtils.CompleteUpdateAction;
import org.opencb.opencga.core.models.common.ExternalSource;
import org.opencb.opencga.core.models.common.RgaIndex.Status;
import org.opencb.opencga.core.models.common.StatusParams;
import org.opencb.opencga.core.models.common.TsvAnnotationParams;
import org.opencb.opencga.core.models.job.Job;
import org.opencb.opencga.core.models.sample.Sample;
import org.opencb.opencga.core.models.sample.SampleAclUpdateParams;
import org.opencb.opencga.core.models.sample.SampleCollection;
import org.opencb.opencga.core.models.sample.SampleCreateParams;
import org.opencb.opencga.core.models.sample.SampleProcessing;
import org.opencb.opencga.core.models.sample.SampleQualityControl;
import org.opencb.opencga.core.models.sample.SampleUpdateParams;
import org.opencb.opencga.core.models.sample.SampleVariantQualityControlMetrics;


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
 * This class contains methods for the Samples command line.
<<<<<<< HEAD
 *    OpenCGA version: 2.3.1-SNAPSHOT
=======
 *    OpenCGA version: 2.2.4-SNAPSHOT
>>>>>>> release-2.2.x
 *    PATH: /{apiVersion}/samples
 */
public class SamplesCommandExecutor extends OpencgaCommandExecutor {

    private SamplesCommandOptions samplesCommandOptions;

    public SamplesCommandExecutor(SamplesCommandOptions samplesCommandOptions) throws CatalogAuthenticationException {
        super(samplesCommandOptions.commonCommandOptions);
        this.samplesCommandOptions = samplesCommandOptions;
    }

    @Override
    public void execute() throws Exception {

        logger.debug("Executing Samples command line");

        String subCommandString = getParsedSubCommand(samplesCommandOptions.jCommander);

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
            case "load":
                queryResponse = load();
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

    private RestResponse<ObjectMap> updateAcl() throws Exception {

        logger.debug("Executing updateAcl in Samples command line");

        SamplesCommandOptions.UpdateAclCommandOptions commandOptions = samplesCommandOptions.updateAclCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }


        SampleAclUpdateParams sampleAclUpdateParams= null;
        if (commandOptions.jsonDataModel) {
            sampleAclUpdateParams = new SampleAclUpdateParams();
            RestResponse<ObjectMap> res = new RestResponse<>();
            res.setType(QueryType.VOID);
            PrintUtils.println(getObjectAsJSON(sampleAclUpdateParams));
            return res;
        } else if (commandOptions.jsonFile != null) {
            sampleAclUpdateParams = JacksonUtils.getDefaultObjectMapper()
                    .readValue(new java.io.File(commandOptions.jsonFile), SampleAclUpdateParams.class);
        } else {
<<<<<<< HEAD
            sampleAclUpdateParams.setPermissions(commandOptions.permissions);
            sampleAclUpdateParams.setSample(commandOptions.sample);
            sampleAclUpdateParams.setIndividual(commandOptions.individual);
            sampleAclUpdateParams.setFamily(commandOptions.family);
            sampleAclUpdateParams.setFile(commandOptions.file);
            sampleAclUpdateParams.setCohort(commandOptions.cohort);

=======
            ObjectMap beanParams = new ObjectMap();
            putNestedIfNotEmpty(beanParams, "sample",commandOptions.sample, true);
             putNestedIfNotEmpty(beanParams, "individual",commandOptions.individual, true);
             putNestedIfNotEmpty(beanParams, "family",commandOptions.family, true);
             putNestedIfNotEmpty(beanParams, "file",commandOptions.file, true);
             putNestedIfNotEmpty(beanParams, "cohort",commandOptions.cohort, true);
             putNestedIfNotEmpty(beanParams, "permissions",commandOptions.permissions, true);
 
            sampleAclUpdateParams = JacksonUtils.getDefaultObjectMapper()
                    .readValue(beanParams.toJson(), SampleAclUpdateParams.class);
>>>>>>> release-2.2.x
        }
        return openCGAClient.getSampleClient().updateAcl(commandOptions.members, commandOptions.action, sampleAclUpdateParams, queryParams);
    }

    private RestResponse<FacetField> aggregationStats() throws Exception {

        logger.debug("Executing aggregationStats in Samples command line");

        SamplesCommandOptions.AggregationStatsCommandOptions commandOptions = samplesCommandOptions.aggregationStatsCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("source", commandOptions.source);
        queryParams.putIfNotEmpty("creationYear", commandOptions.creationYear);
        queryParams.putIfNotEmpty("creationMonth", commandOptions.creationMonth);
        queryParams.putIfNotEmpty("creationDay", commandOptions.creationDay);
        queryParams.putIfNotEmpty("creationDayOfWeek", commandOptions.creationDayOfWeek);
        queryParams.putIfNotEmpty("status", commandOptions.status);
        queryParams.putIfNotEmpty("type", commandOptions.type);
        queryParams.putIfNotEmpty("phenotypes", commandOptions.phenotypes);
        queryParams.putIfNotEmpty("release", commandOptions.release);
        queryParams.putIfNotEmpty("version", commandOptions.version);
        queryParams.putIfNotNull("somatic", commandOptions.somatic);
        queryParams.putIfNotEmpty("annotation", commandOptions.annotation);
        queryParams.putIfNotNull("default_values", commandOptions.default_values);
        queryParams.putIfNotEmpty("field", commandOptions.field);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getSampleClient().aggregationStats(queryParams);
    }

    private RestResponse<Job> loadAnnotationSets() throws Exception {

        logger.debug("Executing loadAnnotationSets in Samples command line");

        SamplesCommandOptions.LoadAnnotationSetsCommandOptions commandOptions = samplesCommandOptions.loadAnnotationSetsCommandOptions;

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
<<<<<<< HEAD
            tsvAnnotationParams.setContent(commandOptions.content);

=======
            ObjectMap beanParams = new ObjectMap();
            putNestedIfNotEmpty(beanParams, "content",commandOptions.content, true);
 
            tsvAnnotationParams = JacksonUtils.getDefaultObjectMapper()
                    .readValue(beanParams.toJson(), TsvAnnotationParams.class);
>>>>>>> release-2.2.x
        }
        return openCGAClient.getSampleClient().loadAnnotationSets(commandOptions.variableSetId, commandOptions.path, tsvAnnotationParams, queryParams);
    }

    private RestResponse<Sample> create() throws Exception {

        logger.debug("Executing create in Samples command line");

        SamplesCommandOptions.CreateCommandOptions commandOptions = samplesCommandOptions.createCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("include", commandOptions.include);
        queryParams.putIfNotEmpty("exclude", commandOptions.exclude);
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotNull("includeResult", commandOptions.includeResult);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }


<<<<<<< HEAD
        SampleCreateParams sampleCreateParams = new SampleCreateParams();
=======
        SampleCreateParams sampleCreateParams= null;
>>>>>>> release-2.2.x
        if (commandOptions.jsonDataModel) {
            sampleCreateParams = new SampleCreateParams();
            RestResponse<Sample> res = new RestResponse<>();
            res.setType(QueryType.VOID);
            PrintUtils.println(getObjectAsJSON(sampleCreateParams));
            return res;
        } else if (commandOptions.jsonFile != null) {
            sampleCreateParams = JacksonUtils.getDefaultObjectMapper()
                    .readValue(new java.io.File(commandOptions.jsonFile), SampleCreateParams.class);
        } else {
<<<<<<< HEAD
            // Generate beans for nested objects
            ExternalSource sourceParam = new ExternalSource();
            sourceParam.setId(commandOptions.sourceId);
            sourceParam.setName(commandOptions.sourceName);
            sourceParam.setDescription(commandOptions.sourceDescription);
            sourceParam.setSource(commandOptions.sourceSource);
            sourceParam.setUrl(commandOptions.sourceUrl);

            SampleProcessing processingParam = new SampleProcessing();
            //processingParam.setProduct(commandOptions.processingProduct);  // Unsupported param. FIXME
            processingParam.setPreparationMethod(commandOptions.processingPreparationMethod);
            processingParam.setExtractionMethod(commandOptions.processingExtractionMethod);
            processingParam.setLabSampleId(commandOptions.processingLabSampleId);
            processingParam.setQuantity(commandOptions.processingQuantity);
            processingParam.setDate(commandOptions.processingDate);
            processingParam.setAttributes(new HashMap<>(commandOptions.processingAttributes));

            SampleCollection collectionParam = new SampleCollection();
            //collectionParam.setFrom(commandOptions.collectionFrom);  // Unsupported param. FIXME
            collectionParam.setType(commandOptions.collectionType);
            collectionParam.setQuantity(commandOptions.collectionQuantity);
            collectionParam.setMethod(commandOptions.collectionMethod);
            collectionParam.setDate(commandOptions.collectionDate);
            collectionParam.setAttributes(new HashMap<>(commandOptions.collectionAttributes));

            StatusParams statusParam = new StatusParams();
            statusParam.setId(commandOptions.statusId);
            statusParam.setName(commandOptions.statusName);
            statusParam.setDescription(commandOptions.statusDescription);

            //Set main body params
            sampleCreateParams.setId(commandOptions.id);
            sampleCreateParams.setDescription(commandOptions.description);
            sampleCreateParams.setCreationDate(commandOptions.creationDate);
            sampleCreateParams.setModificationDate(commandOptions.modificationDate);
            sampleCreateParams.setIndividualId(commandOptions.individualId);
            sampleCreateParams.setSource(sourceParam);
            sampleCreateParams.setProcessing(processingParam);
            sampleCreateParams.setCollection(collectionParam);
            //sampleCreateParams.setPhenotypes(commandOptions.phenotypes); // Unsupported param. FIXME 
            sampleCreateParams.setStatus(statusParam);
            //sampleCreateParams.setAnnotationSets(commandOptions.annotationSets); // Unsupported param. FIXME 
            sampleCreateParams.setAttributes(new HashMap<>(commandOptions.attributes));

            if (commandOptions.somatic != null) {
                sampleCreateParams.setSomatic(commandOptions.somatic);
            }
=======
            ObjectMap beanParams = new ObjectMap();
            putNestedIfNotEmpty(beanParams, "id",commandOptions.id, true);
             putNestedIfNotEmpty(beanParams, "description",commandOptions.description, true);
             putNestedIfNotEmpty(beanParams, "creationDate",commandOptions.creationDate, true);
             putNestedIfNotEmpty(beanParams, "modificationDate",commandOptions.modificationDate, true);
             putNestedIfNotEmpty(beanParams, "individualId",commandOptions.individualId, true);
             putNestedIfNotEmpty(beanParams, "source.id",commandOptions.sourceId, true);
             putNestedIfNotEmpty(beanParams, "source.name",commandOptions.sourceName, true);
             putNestedIfNotEmpty(beanParams, "source.description",commandOptions.sourceDescription, true);
             putNestedIfNotEmpty(beanParams, "source.source",commandOptions.sourceSource, true);
             putNestedIfNotEmpty(beanParams, "source.url",commandOptions.sourceUrl, true);
             putNestedIfNotEmpty(beanParams, "processing.preparationMethod",commandOptions.processingPreparationMethod, true);
             putNestedIfNotEmpty(beanParams, "processing.extractionMethod",commandOptions.processingExtractionMethod, true);
             putNestedIfNotEmpty(beanParams, "processing.labSampleId",commandOptions.processingLabSampleId, true);
             putNestedIfNotEmpty(beanParams, "processing.quantity",commandOptions.processingQuantity, true);
             putNestedIfNotEmpty(beanParams, "processing.date",commandOptions.processingDate, true);
             putNestedIfNotEmpty(beanParams, "collection.type",commandOptions.collectionType, true);
             putNestedIfNotEmpty(beanParams, "collection.quantity",commandOptions.collectionQuantity, true);
             putNestedIfNotEmpty(beanParams, "collection.method",commandOptions.collectionMethod, true);
             putNestedIfNotEmpty(beanParams, "collection.date",commandOptions.collectionDate, true);
             putNestedIfNotNull(beanParams, "somatic",commandOptions.somatic, true);
             putNestedIfNotEmpty(beanParams, "status.id",commandOptions.statusId, true);
             putNestedIfNotEmpty(beanParams, "status.name",commandOptions.statusName, true);
             putNestedIfNotEmpty(beanParams, "status.description",commandOptions.statusDescription, true);
 
            sampleCreateParams = JacksonUtils.getDefaultObjectMapper()
                    .readValue(beanParams.toJson(), SampleCreateParams.class);
>>>>>>> release-2.2.x
        }
        return openCGAClient.getSampleClient().create(sampleCreateParams, queryParams);
    }

    private RestResponse<Object> distinct() throws Exception {

        logger.debug("Executing distinct in Samples command line");

        SamplesCommandOptions.DistinctCommandOptions commandOptions = samplesCommandOptions.distinctCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("id", commandOptions.id);
        queryParams.putIfNotEmpty("uuid", commandOptions.uuid);
        queryParams.putIfNotNull("somatic", commandOptions.somatic);
        queryParams.putIfNotEmpty("individualId", commandOptions.individualId);
        queryParams.putIfNotEmpty("fileIds", commandOptions.fileIds);
        queryParams.putIfNotEmpty("cohortIds", commandOptions.cohortIds);
        queryParams.putIfNotEmpty("creationDate", commandOptions.creationDate);
        queryParams.putIfNotEmpty("modificationDate", commandOptions.modificationDate);
        queryParams.putIfNotEmpty("internalStatus", commandOptions.internalStatus);
        queryParams.putIfNotEmpty("status", commandOptions.status);
        queryParams.putIfNotEmpty("processingProduct", commandOptions.processingProduct);
        queryParams.putIfNotEmpty("processingPreparationMethod", commandOptions.processingPreparationMethod);
        queryParams.putIfNotEmpty("processingExtractionMethod", commandOptions.processingExtractionMethod);
        queryParams.putIfNotEmpty("processingLabSampleId", commandOptions.processingLabSampleId);
        queryParams.putIfNotEmpty("collectionFrom", commandOptions.collectionFrom);
        queryParams.putIfNotEmpty("collectionType", commandOptions.collectionType);
        queryParams.putIfNotEmpty("collectionMethod", commandOptions.collectionMethod);
        queryParams.putIfNotEmpty("phenotypes", commandOptions.phenotypes);
        queryParams.putIfNotEmpty("annotation", commandOptions.annotation);
        queryParams.putIfNotEmpty("acl", commandOptions.acl);
        queryParams.putIfNotNull("internalRgaStatus", commandOptions.internalRgaStatus);
        queryParams.putIfNotEmpty("release", commandOptions.release);
        queryParams.putIfNotNull("snapshot", commandOptions.snapshot);
        queryParams.putIfNotNull("deleted", commandOptions.deleted);
        queryParams.putIfNotEmpty("statsId", commandOptions.statsId);
        queryParams.putIfNotEmpty("statsVariantCount", commandOptions.statsVariantCount);
        queryParams.putIfNotEmpty("statsChromosomeCount", commandOptions.statsChromosomeCount);
        queryParams.putIfNotEmpty("statsTypeCount", commandOptions.statsTypeCount);
        queryParams.putIfNotEmpty("statsGenotypeCount", commandOptions.statsGenotypeCount);
        queryParams.putIfNotEmpty("statsTiTvRatio", commandOptions.statsTiTvRatio);
        queryParams.putIfNotEmpty("statsQualityAvg", commandOptions.statsQualityAvg);
        queryParams.putIfNotEmpty("statsQualityStdDev", commandOptions.statsQualityStdDev);
        queryParams.putIfNotEmpty("statsHeterozygosityRate", commandOptions.statsHeterozygosityRate);
        queryParams.putIfNotEmpty("statsDepthCount", commandOptions.statsDepthCount);
        queryParams.putIfNotEmpty("statsBiotypeCount", commandOptions.statsBiotypeCount);
        queryParams.putIfNotEmpty("statsClinicalSignificanceCount", commandOptions.statsClinicalSignificanceCount);
        queryParams.putIfNotEmpty("statsConsequenceTypeCount", commandOptions.statsConsequenceTypeCount);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getSampleClient().distinct(commandOptions.field, queryParams);
    }

    private RestResponse<Sample> load() throws Exception {

        logger.debug("Executing load in Samples command line");

        SamplesCommandOptions.LoadCommandOptions commandOptions = samplesCommandOptions.loadCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("variableSet", commandOptions.variableSet);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getSampleClient().load(commandOptions.file, queryParams);
    }

    private RestResponse<Sample> search() throws Exception {

        logger.debug("Executing search in Samples command line");

        SamplesCommandOptions.SearchCommandOptions commandOptions = samplesCommandOptions.searchCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("include", commandOptions.include);
        queryParams.putIfNotEmpty("exclude", commandOptions.exclude);
        queryParams.putIfNotNull("limit", commandOptions.limit);
        queryParams.putIfNotNull("skip", commandOptions.skip);
        queryParams.putIfNotNull("count", commandOptions.count);
        queryParams.putIfNotNull("includeIndividual", commandOptions.includeIndividual);
        queryParams.putIfNotNull("flattenAnnotations", commandOptions.flattenAnnotations);
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("id", commandOptions.id);
        queryParams.putIfNotEmpty("uuid", commandOptions.uuid);
        queryParams.putIfNotNull("somatic", commandOptions.somatic);
        queryParams.putIfNotEmpty("individualId", commandOptions.individualId);
        queryParams.putIfNotEmpty("fileIds", commandOptions.fileIds);
        queryParams.putIfNotEmpty("cohortIds", commandOptions.cohortIds);
        queryParams.putIfNotEmpty("creationDate", commandOptions.creationDate);
        queryParams.putIfNotEmpty("modificationDate", commandOptions.modificationDate);
        queryParams.putIfNotEmpty("internalStatus", commandOptions.internalStatus);
        queryParams.putIfNotEmpty("status", commandOptions.status);
        queryParams.putIfNotEmpty("processingProduct", commandOptions.processingProduct);
        queryParams.putIfNotEmpty("processingPreparationMethod", commandOptions.processingPreparationMethod);
        queryParams.putIfNotEmpty("processingExtractionMethod", commandOptions.processingExtractionMethod);
        queryParams.putIfNotEmpty("processingLabSampleId", commandOptions.processingLabSampleId);
        queryParams.putIfNotEmpty("collectionFrom", commandOptions.collectionFrom);
        queryParams.putIfNotEmpty("collectionType", commandOptions.collectionType);
        queryParams.putIfNotEmpty("collectionMethod", commandOptions.collectionMethod);
        queryParams.putIfNotEmpty("phenotypes", commandOptions.phenotypes);
        queryParams.putIfNotEmpty("annotation", commandOptions.annotation);
        queryParams.putIfNotEmpty("acl", commandOptions.acl);
        queryParams.putIfNotNull("internalRgaStatus", commandOptions.internalRgaStatus);
        queryParams.putIfNotEmpty("release", commandOptions.release);
        queryParams.putIfNotNull("snapshot", commandOptions.snapshot);
        queryParams.putIfNotNull("deleted", commandOptions.deleted);
        queryParams.putIfNotEmpty("statsId", commandOptions.statsId);
        queryParams.putIfNotEmpty("statsVariantCount", commandOptions.statsVariantCount);
        queryParams.putIfNotEmpty("statsChromosomeCount", commandOptions.statsChromosomeCount);
        queryParams.putIfNotEmpty("statsTypeCount", commandOptions.statsTypeCount);
        queryParams.putIfNotEmpty("statsGenotypeCount", commandOptions.statsGenotypeCount);
        queryParams.putIfNotEmpty("statsTiTvRatio", commandOptions.statsTiTvRatio);
        queryParams.putIfNotEmpty("statsQualityAvg", commandOptions.statsQualityAvg);
        queryParams.putIfNotEmpty("statsQualityStdDev", commandOptions.statsQualityStdDev);
        queryParams.putIfNotEmpty("statsHeterozygosityRate", commandOptions.statsHeterozygosityRate);
        queryParams.putIfNotEmpty("statsDepthCount", commandOptions.statsDepthCount);
        queryParams.putIfNotEmpty("statsBiotypeCount", commandOptions.statsBiotypeCount);
        queryParams.putIfNotEmpty("statsClinicalSignificanceCount", commandOptions.statsClinicalSignificanceCount);
        queryParams.putIfNotEmpty("statsConsequenceTypeCount", commandOptions.statsConsequenceTypeCount);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getSampleClient().search(queryParams);
    }

    private RestResponse<ObjectMap> acl() throws Exception {

        logger.debug("Executing acl in Samples command line");

        SamplesCommandOptions.AclCommandOptions commandOptions = samplesCommandOptions.aclCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("member", commandOptions.member);
        queryParams.putIfNotNull("silent", commandOptions.silent);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getSampleClient().acl(commandOptions.samples, queryParams);
    }

    private RestResponse<Sample> delete() throws Exception {

        logger.debug("Executing delete in Samples command line");

        SamplesCommandOptions.DeleteCommandOptions commandOptions = samplesCommandOptions.deleteCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotNull("force", commandOptions.force);
        queryParams.putIfNotEmpty("emptyFilesAction", commandOptions.emptyFilesAction);
        queryParams.putIfNotNull("deleteEmptyCohorts", commandOptions.deleteEmptyCohorts);
        queryParams.putIfNotEmpty("study", commandOptions.study);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getSampleClient().delete(commandOptions.samples, queryParams);
    }

    private RestResponse<Sample> info() throws Exception {

        logger.debug("Executing info in Samples command line");

        SamplesCommandOptions.InfoCommandOptions commandOptions = samplesCommandOptions.infoCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("include", commandOptions.include);
        queryParams.putIfNotEmpty("exclude", commandOptions.exclude);
        queryParams.putIfNotNull("includeIndividual", commandOptions.includeIndividual);
        queryParams.putIfNotNull("flattenAnnotations", commandOptions.flattenAnnotations);
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("version", commandOptions.version);
        queryParams.putIfNotNull("deleted", commandOptions.deleted);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getSampleClient().info(commandOptions.samples, queryParams);
    }

    private RestResponse<Sample> update() throws Exception {

        logger.debug("Executing update in Samples command line");

        SamplesCommandOptions.UpdateCommandOptions commandOptions = samplesCommandOptions.updateCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("include", commandOptions.include);
        queryParams.putIfNotEmpty("exclude", commandOptions.exclude);
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotNull("includeResult", commandOptions.includeResult);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }


<<<<<<< HEAD
        SampleUpdateParams sampleUpdateParams = new SampleUpdateParams();
=======
        SampleUpdateParams sampleUpdateParams= null;
>>>>>>> release-2.2.x
        if (commandOptions.jsonDataModel) {
            sampleUpdateParams = new SampleUpdateParams();
            RestResponse<Sample> res = new RestResponse<>();
            res.setType(QueryType.VOID);
            PrintUtils.println(getObjectAsJSON(sampleUpdateParams));
            return res;
        } else if (commandOptions.jsonFile != null) {
            sampleUpdateParams = JacksonUtils.getDefaultObjectMapper()
                    .readValue(new java.io.File(commandOptions.jsonFile), SampleUpdateParams.class);
        } else {
<<<<<<< HEAD
            // Generate beans for nested objects
            ExternalSource sourceParam = new ExternalSource();
            sourceParam.setId(commandOptions.sourceId);
            sourceParam.setName(commandOptions.sourceName);
            sourceParam.setDescription(commandOptions.sourceDescription);
            sourceParam.setSource(commandOptions.sourceSource);
            sourceParam.setUrl(commandOptions.sourceUrl);

            SampleProcessing processingParam = new SampleProcessing();
            //processingParam.setProduct(commandOptions.processingProduct);  // Unsupported param. FIXME
            processingParam.setPreparationMethod(commandOptions.processingPreparationMethod);
            processingParam.setExtractionMethod(commandOptions.processingExtractionMethod);
            processingParam.setLabSampleId(commandOptions.processingLabSampleId);
            processingParam.setQuantity(commandOptions.processingQuantity);
            processingParam.setDate(commandOptions.processingDate);
            processingParam.setAttributes(new HashMap<>(commandOptions.processingAttributes));

            SampleCollection collectionParam = new SampleCollection();
            //collectionParam.setFrom(commandOptions.collectionFrom);  // Unsupported param. FIXME
            collectionParam.setType(commandOptions.collectionType);
            collectionParam.setQuantity(commandOptions.collectionQuantity);
            collectionParam.setMethod(commandOptions.collectionMethod);
            collectionParam.setDate(commandOptions.collectionDate);
            collectionParam.setAttributes(new HashMap<>(commandOptions.collectionAttributes));

            SampleQualityControl qualityControlParam = new SampleQualityControl();
            qualityControlParam.setFiles(splitWithTrim(commandOptions.qualityControlFiles));
            //qualityControlParam.setComments(commandOptions.qualityControlComments);  // Unsupported param. FIXME
            //qualityControlParam.setVariant(commandOptions.qualityControlVariant);  // Unsupported param. FIXME

            StatusParams statusParam = new StatusParams();
            statusParam.setId(commandOptions.statusId);
            statusParam.setName(commandOptions.statusName);
            statusParam.setDescription(commandOptions.statusDescription);

            //Set main body params
            sampleUpdateParams.setId(commandOptions.id);
            sampleUpdateParams.setDescription(commandOptions.description);
            sampleUpdateParams.setCreationDate(commandOptions.creationDate);
            sampleUpdateParams.setModificationDate(commandOptions.modificationDate);
            sampleUpdateParams.setIndividualId(commandOptions.individualId);
            sampleUpdateParams.setSource(sourceParam);
            sampleUpdateParams.setProcessing(processingParam);
            sampleUpdateParams.setCollection(collectionParam);
            sampleUpdateParams.setQualityControl(qualityControlParam);
            //sampleUpdateParams.setPhenotypes(commandOptions.phenotypes); // Unsupported param. FIXME 
            //sampleUpdateParams.setAnnotationSets(commandOptions.annotationSets); // Unsupported param. FIXME 
            sampleUpdateParams.setAttributes(new HashMap<>(commandOptions.attributes));
            sampleUpdateParams.setStatus(statusParam);

            if (commandOptions.somatic != null) {
                sampleUpdateParams.setSomatic(commandOptions.somatic);
            }
=======
            ObjectMap beanParams = new ObjectMap();
            putNestedIfNotEmpty(beanParams, "id",commandOptions.id, true);
             putNestedIfNotEmpty(beanParams, "description",commandOptions.description, true);
             putNestedIfNotEmpty(beanParams, "creationDate",commandOptions.creationDate, true);
             putNestedIfNotEmpty(beanParams, "modificationDate",commandOptions.modificationDate, true);
             putNestedIfNotEmpty(beanParams, "individualId",commandOptions.individualId, true);
             putNestedIfNotEmpty(beanParams, "source.id",commandOptions.sourceId, true);
             putNestedIfNotEmpty(beanParams, "source.name",commandOptions.sourceName, true);
             putNestedIfNotEmpty(beanParams, "source.description",commandOptions.sourceDescription, true);
             putNestedIfNotEmpty(beanParams, "source.source",commandOptions.sourceSource, true);
             putNestedIfNotEmpty(beanParams, "source.url",commandOptions.sourceUrl, true);
             putNestedIfNotEmpty(beanParams, "processing.preparationMethod",commandOptions.processingPreparationMethod, true);
             putNestedIfNotEmpty(beanParams, "processing.extractionMethod",commandOptions.processingExtractionMethod, true);
             putNestedIfNotEmpty(beanParams, "processing.labSampleId",commandOptions.processingLabSampleId, true);
             putNestedIfNotEmpty(beanParams, "processing.quantity",commandOptions.processingQuantity, true);
             putNestedIfNotEmpty(beanParams, "processing.date",commandOptions.processingDate, true);
             putNestedIfNotEmpty(beanParams, "collection.type",commandOptions.collectionType, true);
             putNestedIfNotEmpty(beanParams, "collection.quantity",commandOptions.collectionQuantity, true);
             putNestedIfNotEmpty(beanParams, "collection.method",commandOptions.collectionMethod, true);
             putNestedIfNotEmpty(beanParams, "collection.date",commandOptions.collectionDate, true);
             putNestedIfNotNull(beanParams, "somatic",commandOptions.somatic, true);
             putNestedIfNotEmpty(beanParams, "status.id",commandOptions.statusId, true);
             putNestedIfNotEmpty(beanParams, "status.name",commandOptions.statusName, true);
             putNestedIfNotEmpty(beanParams, "status.description",commandOptions.statusDescription, true);
 
            sampleUpdateParams = JacksonUtils.getDefaultObjectMapper()
                    .readValue(beanParams.toJson(), SampleUpdateParams.class);
>>>>>>> release-2.2.x
        }
        return openCGAClient.getSampleClient().update(commandOptions.samples, sampleUpdateParams, queryParams);
    }

    private RestResponse<Sample> updateAnnotationSetsAnnotations() throws Exception {

        logger.debug("Executing updateAnnotationSetsAnnotations in Samples command line");

        SamplesCommandOptions.UpdateAnnotationSetsAnnotationsCommandOptions commandOptions = samplesCommandOptions.updateAnnotationSetsAnnotationsCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotNull("action", commandOptions.action);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }


        ObjectMap objectMap= null;
        if (commandOptions.jsonDataModel) {
            objectMap = new ObjectMap();
            RestResponse<Sample> res = new RestResponse<>();
            res.setType(QueryType.VOID);
            PrintUtils.println(getObjectAsJSON(objectMap));
            return res;
        } else if (commandOptions.jsonFile != null) {
            objectMap = JacksonUtils.getDefaultObjectMapper()
                    .readValue(new java.io.File(commandOptions.jsonFile), ObjectMap.class);
        }
        return openCGAClient.getSampleClient().updateAnnotationSetsAnnotations(commandOptions.sample, commandOptions.annotationSet, objectMap, queryParams);
    }
}