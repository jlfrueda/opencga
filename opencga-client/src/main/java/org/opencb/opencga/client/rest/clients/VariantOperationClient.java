/*
* Copyright 2015-2022 OpenCB
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

package org.opencb.opencga.client.rest.clients;

import org.opencb.commons.datastore.core.ObjectMap;
import org.opencb.opencga.client.config.ClientConfiguration;
import org.opencb.opencga.client.exceptions.ClientException;
import org.opencb.opencga.client.rest.AbstractParentClient;
import org.opencb.opencga.core.config.storage.CellBaseConfiguration;
import org.opencb.opencga.core.config.storage.SampleIndexConfiguration;
import org.opencb.opencga.core.models.job.Job;
import org.opencb.opencga.core.models.operations.variant.JulieParams;
import org.opencb.opencga.core.models.operations.variant.VariantAggregateFamilyParams;
import org.opencb.opencga.core.models.operations.variant.VariantAggregateParams;
import org.opencb.opencga.core.models.operations.variant.VariantAnnotationIndexParams;
import org.opencb.opencga.core.models.operations.variant.VariantAnnotationSaveParams;
import org.opencb.opencga.core.models.operations.variant.VariantFamilyIndexParams;
import org.opencb.opencga.core.models.operations.variant.VariantSampleIndexParams;
import org.opencb.opencga.core.models.operations.variant.VariantScoreIndexParams;
import org.opencb.opencga.core.models.operations.variant.VariantSecondaryIndexParams;
import org.opencb.opencga.core.models.operations.variant.VariantStatsDeleteParams;
import org.opencb.opencga.core.models.operations.variant.VariantStatsIndexParams;
import org.opencb.opencga.core.models.operations.variant.VariantStorageMetadataRepairToolParams;
import org.opencb.opencga.core.models.variant.VariantConfigureParams;
import org.opencb.opencga.core.models.variant.VariantFileDeleteParams;
import org.opencb.opencga.core.models.variant.VariantFileIndexJobLauncherParams;
import org.opencb.opencga.core.models.variant.VariantIndexParams;
import org.opencb.opencga.core.models.variant.VariantSampleDeleteParams;
import org.opencb.opencga.core.models.variant.VariantStorageMetadataSynchronizeParams;
import org.opencb.opencga.core.models.variant.VariantStudyDeleteParams;
import org.opencb.opencga.core.response.RestResponse;


/*
* WARNING: AUTOGENERATED CODE
*
* This code was generated by a tool.
* Autogenerated on: 2022-05-17 10:42:16
*
* Manual changes to this file may cause unexpected behavior in your application.
* Manual changes to this file will be overwritten if the code is regenerated.
*/


/**
 * This class contains methods for the VariantOperation webservices.
 *    Client version: 2.3.0-SNAPSHOT [c37899f2d43a9e86997fbf482c011506fd0b0381]
 *    PATH: operation
 */
public class VariantOperationClient extends AbstractParentClient {

    public VariantOperationClient(String token, ClientConfiguration configuration) {
        super(token, configuration);
    }

    /**
     * Update Cellbase configuration.
     * @param data New cellbase configuration.
     * @param params Map containing any of the following optional parameters.
     *       project: Project [user@]project where project can be either the ID or the alias.
     *       annotationUpdate: Create and load variant annotations into the database.
     *       annotationSaveId: Save a copy of the current variant annotation at the database.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Job> configureCellbase(CellBaseConfiguration data, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.put("body", data);
        return execute("operation", null, "cellbase", null, "configure", params, POST, Job.class);
    }

    /**
     * Find variants where not all the samples are present, and fill the empty values, excluding HOM-REF (0/0) values.
     * @param data Variant aggregate params.
     * @param params Map containing any of the following optional parameters.
     *       jobId: Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not provided.
     *       jobDescription: Job description.
     *       jobDependsOn: Comma separated list of existing job IDs the job will depend on.
     *       jobTags: Job tags.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Job> aggregateVariant(VariantAggregateParams data, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.put("body", data);
        return execute("operation", null, "variant", null, "aggregate", params, POST, Job.class);
    }

    /**
     * Deletes a saved copy of variant annotation.
     * @param params Map containing any of the following optional parameters.
     *       jobId: Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not provided.
     *       jobDescription: Job description.
     *       jobDependsOn: Comma separated list of existing job IDs the job will depend on.
     *       jobTags: Job tags.
     *       project: Project [user@]project where project can be either the ID or the alias.
     *       annotationId: Annotation identifier.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Job> deleteVariantAnnotation(ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        return execute("operation", null, "variant/annotation", null, "delete", params, DELETE, Job.class);
    }

    /**
     * Create and load variant annotations into the database.
     * @param data Variant annotation index params.
     * @param params Map containing any of the following optional parameters.
     *       jobId: Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not provided.
     *       jobDescription: Job description.
     *       jobDependsOn: Comma separated list of existing job IDs the job will depend on.
     *       jobTags: Job tags.
     *       project: Project [user@]project where project can be either the ID or the alias.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Job> indexVariantAnnotation(VariantAnnotationIndexParams data, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.put("body", data);
        return execute("operation", null, "variant/annotation", null, "index", params, POST, Job.class);
    }

    /**
     * Save a copy of the current variant annotation at the database.
     * @param data Variant annotation save params.
     * @param params Map containing any of the following optional parameters.
     *       jobId: Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not provided.
     *       jobDescription: Job description.
     *       jobDependsOn: Comma separated list of existing job IDs the job will depend on.
     *       jobTags: Job tags.
     *       project: Project [user@]project where project can be either the ID or the alias.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Job> saveVariantAnnotation(VariantAnnotationSaveParams data, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.put("body", data);
        return execute("operation", null, "variant/annotation", null, "save", params, POST, Job.class);
    }

    /**
     * Update Variant Storage Engine configuration. Can be updated at Project or Study level.
     * @param data Configuration params to update.
     * @param params Map containing any of the following optional parameters.
     *       project: Project [user@]project where project can be either the ID or the alias.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<ObjectMap> configureVariant(VariantConfigureParams data, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.put("body", data);
        return execute("operation", null, "variant", null, "configure", params, POST, ObjectMap.class);
    }

    /**
     * Remove variant files from the variant storage.
     * @param data Variant delete file params.
     * @param params Map containing any of the following optional parameters.
     *       jobId: Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not provided.
     *       jobDescription: Job description.
     *       jobDependsOn: Comma separated list of existing job IDs the job will depend on.
     *       jobTags: Job tags.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Job> deleteVariant(VariantFileDeleteParams data, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.put("body", data);
        return execute("operation", null, "variant", null, "delete", params, POST, Job.class);
    }

    /**
     * Find variants where not all the samples are present, and fill the empty values.
     * @param data Variant aggregate family params.
     * @param params Map containing any of the following optional parameters.
     *       jobId: Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not provided.
     *       jobDescription: Job description.
     *       jobDependsOn: Comma separated list of existing job IDs the job will depend on.
     *       jobTags: Job tags.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Job> aggregateVariantFamily(VariantAggregateFamilyParams data, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.put("body", data);
        return execute("operation", null, "variant/family", null, "aggregate", params, POST, Job.class);
    }

    /**
     * DEPRECATED: integrated in index (DEPRECATED Build the family index).
     * @param data Variant family index params.
     * @param params Map containing any of the following optional parameters.
     *       jobId: Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not provided.
     *       jobDescription: Job description.
     *       jobDependsOn: Comma separated list of existing job IDs the job will depend on.
     *       jobTags: Job tags.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Job> indexVariantFamily(VariantFamilyIndexParams data, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.put("body", data);
        return execute("operation", null, "variant/family", null, "index", params, POST, Job.class);
    }

    /**
     * Index variant files into the variant storage.
     * @param data Variant index params.
     * @param params Map containing any of the following optional parameters.
     *       jobId: Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not provided.
     *       jobDescription: Job description.
     *       jobDependsOn: Comma separated list of existing job IDs the job will depend on.
     *       jobTags: Job tags.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Job> indexVariant(VariantIndexParams data, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.put("body", data);
        return execute("operation", null, "variant", null, "index", params, POST, Job.class);
    }

    /**
     * Detect non-indexed VCF files in the study, and submit a job for indexing them.
     * @param data .
     * @param params Map containing any of the following optional parameters.
     *       jobId: Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not provided.
     *       jobDescription: Job description.
     *       jobDependsOn: Comma separated list of existing job IDs the job will depend on.
     *       jobTags: Job tags.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Job> launcherVariantIndex(VariantFileIndexJobLauncherParams data, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.put("body", data);
        return execute("operation", null, "variant/index", null, "launcher", params, POST, Job.class);
    }

    /**
     * Transform VariantStats into PopulationFrequency values and updates the VariantAnnotation.
     * @param data Julie tool params. Specify list of cohorts from multiple studies with {study}:{cohort}.
     * @param params Map containing any of the following optional parameters.
     *       jobId: Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not provided.
     *       jobDescription: Job description.
     *       jobDependsOn: Comma separated list of existing job IDs the job will depend on.
     *       jobTags: Job tags.
     *       project: project.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Job> runVariantJulie(JulieParams data, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.put("body", data);
        return execute("operation", null, "variant/julie", null, "run", params, POST, Job.class);
    }

    /**
     * Execute some repairs on Variant Storage Metadata. Advanced users only.
     * @param data Variant storage metadata repair params.
     * @param params Map containing any of the following optional parameters.
     *       jobId: Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not provided.
     *       jobDescription: Job description.
     *       jobDependsOn: Comma separated list of existing job IDs the job will depend on.
     *       jobTags: Job tags.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Job> repairVariantMetadata(VariantStorageMetadataRepairToolParams data, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.put("body", data);
        return execute("operation", null, "variant/metadata", null, "repair", params, POST, Job.class);
    }

    /**
     * Synchronize catalog with variant storage metadata.
     * @param data Variant storage metadata synchronize params.
     * @param params Map containing any of the following optional parameters.
     *       jobId: Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not provided.
     *       jobDescription: Job description.
     *       jobDependsOn: Comma separated list of existing job IDs the job will depend on.
     *       jobTags: Job tags.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Job> synchronizeVariantMetadata(VariantStorageMetadataSynchronizeParams data, ObjectMap params)
            throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.put("body", data);
        return execute("operation", null, "variant/metadata", null, "synchronize", params, POST, Job.class);
    }

    /**
     * Remove variant samples from the variant storage.
     * @param data Variant delete sample params.
     * @param params Map containing any of the following optional parameters.
     *       jobId: Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not provided.
     *       jobDescription: Job description.
     *       jobDependsOn: Comma separated list of existing job IDs the job will depend on.
     *       jobTags: Job tags.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Job> deleteVariantSample(VariantSampleDeleteParams data, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.put("body", data);
        return execute("operation", null, "variant/sample", null, "delete", params, POST, Job.class);
    }

    /**
     * DEPRECATED You should use the new sample index method instead.
     * @param data Variant sample index params.
     * @param params Map containing any of the following optional parameters.
     *       jobId: Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not provided.
     *       jobDescription: Job description.
     *       jobDependsOn: Comma separated list of existing job IDs the job will depend on.
     *       jobTags: Job tags.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Job> indexVariantSample(VariantSampleIndexParams data, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.put("body", data);
        return execute("operation", null, "variant/sample", null, "index", params, POST, Job.class);
    }

    /**
     * DEPRECATED You should use the new sample index configure method.
     * @param data New SampleIndexConfiguration.
     * @param params Map containing any of the following optional parameters.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     *       skipRebuild: Skip sample index re-build.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Job> variantSampleIndexConfigure(SampleIndexConfiguration data, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.put("body", data);
        return execute("operation", null, "variant/sample/index", null, "configure", params, POST, Job.class);
    }

    /**
     * Remove a variant score in the database.
     * @param params Map containing any of the following optional parameters.
     *       jobId: Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not provided.
     *       jobDescription: Job description.
     *       jobDependsOn: Comma separated list of existing job IDs the job will depend on.
     *       jobTags: Job tags.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     *       name: Unique name of the score within the study.
     *       resume: Resume a previously failed remove.
     *       force: Force remove of partially indexed scores.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Job> deleteVariantScore(ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        return execute("operation", null, "variant/score", null, "delete", params, DELETE, Job.class);
    }

    /**
     * Index a variant score in the database.
     * @param data Variant score index params. scoreName: Unique name of the score within the study. cohort1: Cohort used to compute the
     *     score. Use the cohort 'ALL' if all samples from the study where used to compute the score. cohort2: Second cohort used to
     *     compute the score, typically to compare against the first cohort. If only one cohort was used to compute the score, leave empty.
     *     inputColumns: Indicate which columns to load from the input file. Provide the column position (starting in 0) for the column
     *     with the score with 'SCORE=n'. Optionally, the PValue column with 'PVALUE=n'. The, to indicate the variant associated with the
     *     score, provide either the columns ['CHROM', 'POS', 'REF', 'ALT'], or the column 'VAR' containing a variant representation with
     *     format 'chr:start:ref:alt'. e.g. 'CHROM=0,POS=1,REF=3,ALT=4,SCORE=5,PVALUE=6' or 'VAR=0,SCORE=1,PVALUE=2'. resume: Resume a
     *     previously failed indexation.
     * @param params Map containing any of the following optional parameters.
     *       jobId: Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not provided.
     *       jobDescription: Job description.
     *       jobDependsOn: Comma separated list of existing job IDs the job will depend on.
     *       jobTags: Job tags.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Job> indexVariantScore(VariantScoreIndexParams data, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.put("body", data);
        return execute("operation", null, "variant/score", null, "index", params, POST, Job.class);
    }

    /**
     * Creates a secondary index using a search engine. If samples are provided, sample data will be added to the secondary index. (New!).
     * @param data Variant secondary index params.
     * @param params Map containing any of the following optional parameters.
     *       jobId: Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not provided.
     *       jobDescription: Job description.
     *       jobDependsOn: Comma separated list of existing job IDs the job will depend on.
     *       jobTags: Job tags.
     *       project: Project [user@]project where project can be either the ID or the alias.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Job> variantSecondaryAnnotationIndex(VariantSecondaryIndexParams data, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.put("body", data);
        return execute("operation", null, "variant/secondary/annotation", null, "index", params, POST, Job.class);
    }

    /**
     * Build and annotate the sample index. (New!) .
     * @param data Variant sample index params.
     * @param params Map containing any of the following optional parameters.
     *       jobId: Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not provided.
     *       jobDescription: Job description.
     *       jobDependsOn: Comma separated list of existing job IDs the job will depend on.
     *       jobTags: Job tags.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Job> variantSecondarySampleIndex(VariantSampleIndexParams data, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.put("body", data);
        return execute("operation", null, "variant/secondary/sample", null, "index", params, POST, Job.class);
    }

    /**
     * Update SampleIndex configuration (New!).
     * @param data New SampleIndexConfiguration.
     * @param params Map containing any of the following optional parameters.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     *       skipRebuild: Skip sample index re-build.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Job> configureVariantSecondarySampleIndex(SampleIndexConfiguration data, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.put("body", data);
        return execute("operation", null, "variant/secondary/sample/index", null, "configure", params, POST, Job.class);
    }

    /**
     * DEPRECATED you should use the new annotation index method instead.
     * @param data Variant secondary index params.
     * @param params Map containing any of the following optional parameters.
     *       jobId: Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not provided.
     *       jobDescription: Job description.
     *       jobDependsOn: Comma separated list of existing job IDs the job will depend on.
     *       jobTags: Job tags.
     *       project: Project [user@]project where project can be either the ID or the alias.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Job> secondaryIndexVariant(VariantSecondaryIndexParams data, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.put("body", data);
        return execute("operation", null, "variant", null, "secondaryIndex", params, POST, Job.class);
    }

    /**
     * Remove a secondary index from the search engine for a specific set of samples.
     * @param params Map containing any of the following optional parameters.
     *       jobId: Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not provided.
     *       jobDescription: Job description.
     *       jobDependsOn: Comma separated list of existing job IDs the job will depend on.
     *       jobTags: Job tags.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     *       samples: Samples to remove. Needs to provide all the samples in the secondary index.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Job> deleteVariantSecondaryIndex(ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        return execute("operation", null, "variant/secondaryIndex", null, "delete", params, DELETE, Job.class);
    }

    /**
     * Deletes the VariantStats of a cohort/s from the database.
     * @param data Variant stats delete params.
     * @param params Map containing any of the following optional parameters.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     *       jobId: Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not provided.
     *       jobDescription: Job description.
     *       jobDependsOn: Comma separated list of existing job IDs the job will depend on.
     *       jobTags: Job tags.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Job> deleteVariantStats(VariantStatsDeleteParams data, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.put("body", data);
        return execute("operation", null, "variant/stats", null, "delete", params, POST, Job.class);
    }

    /**
     * Compute variant stats for any cohort and any set of variants and index the result in the variant storage database.
     * @param data Variant stats params.
     * @param params Map containing any of the following optional parameters.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     *       jobId: Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not provided.
     *       jobDescription: Job description.
     *       jobDependsOn: Comma separated list of existing job IDs the job will depend on.
     *       jobTags: Job tags.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Job> indexVariantStats(VariantStatsIndexParams data, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.put("body", data);
        return execute("operation", null, "variant/stats", null, "index", params, POST, Job.class);
    }

    /**
     * Remove whole study from the variant storage.
     * @param data Variant delete study params.
     * @param params Map containing any of the following optional parameters.
     *       jobId: Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not provided.
     *       jobDescription: Job description.
     *       jobDependsOn: Comma separated list of existing job IDs the job will depend on.
     *       jobTags: Job tags.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Job> deleteVariantStudy(VariantStudyDeleteParams data, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.put("body", data);
        return execute("operation", null, "variant/study", null, "delete", params, POST, Job.class);
    }
}
