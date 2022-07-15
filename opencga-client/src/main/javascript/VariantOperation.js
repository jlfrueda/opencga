/**
 * Copyright 2015-2020 OpenCB
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * WARNING: AUTOGENERATED CODE
 * 
 * This code was generated by a tool.
 * Autogenerated on: 2022-07-14 18:18:18
 * 
 * Manual changes to this file may cause unexpected behavior in your application.
 * Manual changes to this file will be overwritten if the code is regenerated. 
 *
**/

import OpenCGAParentClass from "./../opencga-parent-class.js";


/**
 * This class contains the methods for the "VariantOperation" resource
 */

export default class VariantOperation extends OpenCGAParentClass {

    constructor(config) {
        super(config);
    }

    /** Update Cellbase configuration
    * @param {Object} [data] - New cellbase configuration.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.project] - Project [user@]project where project can be either the ID or the alias.
    * @param {Boolean} [params.annotationUpdate] - Create and load variant annotations into the database.
    * @param {String} [params.annotationSaveId] - Save a copy of the current variant annotation at the database.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    configureCellbase(data, params) {
        return this._post("operation", null, "cellbase", null, "configure", data, params);
    }

    /** Find variants where not all the samples are present, and fill the empty values, excluding HOM-REF (0/0) values.
    * @param {Object} [data] - Variant aggregate params.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.jobId] - Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not
    *     provided.
    * @param {String} [params.jobDescription] - Job description.
    * @param {String} [params.jobDependsOn] - Comma separated list of existing job IDs the job will depend on.
    * @param {String} [params.jobTags] - Job tags.
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    aggregateVariant(data, params) {
        return this._post("operation", null, "variant", null, "aggregate", data, params);
    }

    /** Deletes a saved copy of variant annotation
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.jobId] - Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not
    *     provided.
    * @param {String} [params.jobDescription] - Job description.
    * @param {String} [params.jobDependsOn] - Comma separated list of existing job IDs the job will depend on.
    * @param {String} [params.jobTags] - Job tags.
    * @param {String} [params.project] - Project [user@]project where project can be either the ID or the alias.
    * @param {String} [params.annotationId] - Annotation identifier.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    deleteVariantAnnotation(params) {
        return this._delete("operation", null, "variant/annotation", null, "delete", params);
    }

    /** Create and load variant annotations into the database
    * @param {Object} [data] - Variant annotation index params.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.jobId] - Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not
    *     provided.
    * @param {String} [params.jobDescription] - Job description.
    * @param {String} [params.jobDependsOn] - Comma separated list of existing job IDs the job will depend on.
    * @param {String} [params.jobTags] - Job tags.
    * @param {String} [params.project] - Project [user@]project where project can be either the ID or the alias.
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    indexVariantAnnotation(data, params) {
        return this._post("operation", null, "variant/annotation", null, "index", data, params);
    }

    /** Save a copy of the current variant annotation at the database
    * @param {Object} [data] - Variant annotation save params.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.jobId] - Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not
    *     provided.
    * @param {String} [params.jobDescription] - Job description.
    * @param {String} [params.jobDependsOn] - Comma separated list of existing job IDs the job will depend on.
    * @param {String} [params.jobTags] - Job tags.
    * @param {String} [params.project] - Project [user@]project where project can be either the ID or the alias.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    saveVariantAnnotation(data, params) {
        return this._post("operation", null, "variant/annotation", null, "save", data, params);
    }

    /** Update Variant Storage Engine configuration. Can be updated at Project or Study level
    * @param {Object} [data] - Configuration params to update.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.project] - Project [user@]project where project can be either the ID or the alias.
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    configureVariant(data, params) {
        return this._post("operation", null, "variant", null, "configure", data, params);
    }

    /** Remove variant files from the variant storage
    * @param {Object} [data] - Variant delete file params.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.jobId] - Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not
    *     provided.
    * @param {String} [params.jobDescription] - Job description.
    * @param {String} [params.jobDependsOn] - Comma separated list of existing job IDs the job will depend on.
    * @param {String} [params.jobTags] - Job tags.
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    deleteVariant(data, params) {
        return this._post("operation", null, "variant", null, "delete", data, params);
    }

    /** Find variants where not all the samples are present, and fill the empty values.
    * @param {Object} [data] - Variant aggregate family params.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.jobId] - Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not
    *     provided.
    * @param {String} [params.jobDescription] - Job description.
    * @param {String} [params.jobDependsOn] - Comma separated list of existing job IDs the job will depend on.
    * @param {String} [params.jobTags] - Job tags.
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    aggregateVariantFamily(data, params) {
        return this._post("operation", null, "variant/family", null, "aggregate", data, params);
    }

    /** DEPRECATED: integrated in index (DEPRECATED Build the family index)
    * @param {Object} [data] - Variant family index params.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.jobId] - Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not
    *     provided.
    * @param {String} [params.jobDescription] - Job description.
    * @param {String} [params.jobDependsOn] - Comma separated list of existing job IDs the job will depend on.
    * @param {String} [params.jobTags] - Job tags.
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    indexVariantFamily(data, params) {
        return this._post("operation", null, "variant/family", null, "index", data, params);
    }

    /** Index variant files into the variant storage
    * @param {Object} [data] - Variant index params.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.jobId] - Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not
    *     provided.
    * @param {String} [params.jobDescription] - Job description.
    * @param {String} [params.jobDependsOn] - Comma separated list of existing job IDs the job will depend on.
    * @param {String} [params.jobTags] - Job tags.
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    indexVariant(data, params) {
        return this._post("operation", null, "variant", null, "index", data, params);
    }

    /** Detect non-indexed VCF files in the study, and submit a job for indexing them.
    * @param {Object} [data] - .
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.jobId] - Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not
    *     provided.
    * @param {String} [params.jobDescription] - Job description.
    * @param {String} [params.jobDependsOn] - Comma separated list of existing job IDs the job will depend on.
    * @param {String} [params.jobTags] - Job tags.
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    launcherVariantIndex(data, params) {
        return this._post("operation", null, "variant/index", null, "launcher", data, params);
    }

    /** Transform VariantStats into PopulationFrequency values and updates the VariantAnnotation.
    * @param {Object} data - Julie tool params. Specify list of cohorts from multiple studies with {study}:{cohort}.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.jobId] - Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not
    *     provided.
    * @param {String} [params.jobDescription] - Job description.
    * @param {String} [params.jobDependsOn] - Comma separated list of existing job IDs the job will depend on.
    * @param {String} [params.jobTags] - Job tags.
    * @param {String} [params.project] - project.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    runVariantJulie(data, params) {
        return this._post("operation", null, "variant/julie", null, "run", data, params);
    }

    /** Execute some repairs on Variant Storage Metadata. Advanced users only.
    * @param {Object} [data] - Variant storage metadata repair params.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.jobId] - Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not
    *     provided.
    * @param {String} [params.jobDescription] - Job description.
    * @param {String} [params.jobDependsOn] - Comma separated list of existing job IDs the job will depend on.
    * @param {String} [params.jobTags] - Job tags.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    repairVariantMetadata(data, params) {
        return this._post("operation", null, "variant/metadata", null, "repair", data, params);
    }

    /** Synchronize catalog with variant storage metadata
    * @param {Object} [data] - Variant storage metadata synchronize params.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.jobId] - Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not
    *     provided.
    * @param {String} [params.jobDescription] - Job description.
    * @param {String} [params.jobDependsOn] - Comma separated list of existing job IDs the job will depend on.
    * @param {String} [params.jobTags] - Job tags.
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    synchronizeVariantMetadata(data, params) {
        return this._post("operation", null, "variant/metadata", null, "synchronize", data, params);
    }

    /** Prune orphan variants from studies in a project.
    * @param {Object} [data] - Variant prune params. Use dry-run to just generate a report with the orphan variants.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.jobId] - Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not
    *     provided.
    * @param {String} [params.jobDescription] - Job description.
    * @param {String} [params.jobDependsOn] - Comma separated list of existing job IDs the job will depend on.
    * @param {String} [params.jobTags] - Job tags.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    pruneVariant(data, params) {
        return this._post("operation", null, "variant", null, "prune", data, params);
    }

    /** Remove variant samples from the variant storage
    * @param {Object} [data] - Variant delete sample params.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.jobId] - Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not
    *     provided.
    * @param {String} [params.jobDescription] - Job description.
    * @param {String} [params.jobDependsOn] - Comma separated list of existing job IDs the job will depend on.
    * @param {String} [params.jobTags] - Job tags.
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    deleteVariantSample(data, params) {
        return this._post("operation", null, "variant/sample", null, "delete", data, params);
    }

    /** DEPRECATED You should use the new sample index method instead.
    * @param {Object} [data] - Variant sample index params.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.jobId] - Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not
    *     provided.
    * @param {String} [params.jobDescription] - Job description.
    * @param {String} [params.jobDependsOn] - Comma separated list of existing job IDs the job will depend on.
    * @param {String} [params.jobTags] - Job tags.
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    indexVariantSample(data, params) {
        return this._post("operation", null, "variant/sample", null, "index", data, params);
    }

    /** DEPRECATED You should use the new sample index configure method.
    * @param {Object} [data] - New SampleIndexConfiguration.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @param {Boolean} [params.skipRebuild] - Skip sample index re-build.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    variantSampleIndexConfigure(data, params) {
        return this._post("operation", null, "variant/sample/index", null, "configure", data, params);
    }

    /** Remove a variant score in the database
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.jobId] - Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not
    *     provided.
    * @param {String} [params.jobDescription] - Job description.
    * @param {String} [params.jobDependsOn] - Comma separated list of existing job IDs the job will depend on.
    * @param {String} [params.jobTags] - Job tags.
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @param {String} [params.name] - Unique name of the score within the study.
    * @param {Boolean} [params.resume] - Resume a previously failed remove.
    * @param {Boolean} [params.force] - Force remove of partially indexed scores.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    deleteVariantScore(params) {
        return this._delete("operation", null, "variant/score", null, "delete", params);
    }

    /** Index a variant score in the database.
    * @param {Object} [data] - Variant score index params. scoreName: Unique name of the score within the study. cohort1: Cohort used to
    *     compute the score. Use the cohort 'ALL' if all samples from the study where used to compute the score. cohort2: Second cohort used to
    *     compute the score, typically to compare against the first cohort. If only one cohort was used to compute the score, leave empty.
    *     inputColumns: Indicate which columns to load from the input file. Provide the column position (starting in 0) for the column with the
    *     score with 'SCORE=n'. Optionally, the PValue column with 'PVALUE=n'. The, to indicate the variant associated with the score, provide
    *     either the columns ['CHROM', 'POS', 'REF', 'ALT'], or the column 'VAR' containing a variant representation with format
    *     'chr:start:ref:alt'. e.g. 'CHROM=0,POS=1,REF=3,ALT=4,SCORE=5,PVALUE=6' or 'VAR=0,SCORE=1,PVALUE=2'. resume: Resume a previously failed
    *     indexation.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.jobId] - Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not
    *     provided.
    * @param {String} [params.jobDescription] - Job description.
    * @param {String} [params.jobDependsOn] - Comma separated list of existing job IDs the job will depend on.
    * @param {String} [params.jobTags] - Job tags.
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    indexVariantScore(data, params) {
        return this._post("operation", null, "variant/score", null, "index", data, params);
    }

    /** Creates a secondary index using a search engine. If samples are provided, sample data will be added to the secondary index. (New!)
    * @param {Object} [data] - Variant secondary index params.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.jobId] - Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not
    *     provided.
    * @param {String} [params.jobDescription] - Job description.
    * @param {String} [params.jobDependsOn] - Comma separated list of existing job IDs the job will depend on.
    * @param {String} [params.jobTags] - Job tags.
    * @param {String} [params.project] - Project [user@]project where project can be either the ID or the alias.
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    variantSecondaryAnnotationIndex(data, params) {
        return this._post("operation", null, "variant/secondary/annotation", null, "index", data, params);
    }

    /** Build and annotate the sample index. (New!)
    * @param {Object} [data] - Variant sample index params.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.jobId] - Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not
    *     provided.
    * @param {String} [params.jobDescription] - Job description.
    * @param {String} [params.jobDependsOn] - Comma separated list of existing job IDs the job will depend on.
    * @param {String} [params.jobTags] - Job tags.
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    variantSecondarySampleIndex(data, params) {
        return this._post("operation", null, "variant/secondary/sample", null, "index", data, params);
    }

    /** Update SampleIndex configuration (New!)
    * @param {Object} [data] - New SampleIndexConfiguration.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @param {Boolean} [params.skipRebuild] - Skip sample index re-build.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    configureVariantSecondarySampleIndex(data, params) {
        return this._post("operation", null, "variant/secondary/sample/index", null, "configure", data, params);
    }

    /** DEPRECATED you should use the new annotation index method instead.
    * @param {Object} [data] - Variant secondary index params.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.jobId] - Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not
    *     provided.
    * @param {String} [params.jobDescription] - Job description.
    * @param {String} [params.jobDependsOn] - Comma separated list of existing job IDs the job will depend on.
    * @param {String} [params.jobTags] - Job tags.
    * @param {String} [params.project] - Project [user@]project where project can be either the ID or the alias.
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    secondaryIndexVariant(data, params) {
        return this._post("operation", null, "variant", null, "secondaryIndex", data, params);
    }

    /** Remove a secondary index from the search engine for a specific set of samples.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.jobId] - Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not
    *     provided.
    * @param {String} [params.jobDescription] - Job description.
    * @param {String} [params.jobDependsOn] - Comma separated list of existing job IDs the job will depend on.
    * @param {String} [params.jobTags] - Job tags.
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @param {String} [params.samples] - Samples to remove. Needs to provide all the samples in the secondary index.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    deleteVariantSecondaryIndex(params) {
        return this._delete("operation", null, "variant/secondaryIndex", null, "delete", params);
    }

    /** Deletes the VariantStats of a cohort/s from the database
    * @param {Object} data - Variant stats delete params.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @param {String} [params.jobId] - Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not
    *     provided.
    * @param {String} [params.jobDescription] - Job description.
    * @param {String} [params.jobDependsOn] - Comma separated list of existing job IDs the job will depend on.
    * @param {String} [params.jobTags] - Job tags.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    deleteVariantStats(data, params) {
        return this._post("operation", null, "variant/stats", null, "delete", data, params);
    }

    /** Compute variant stats for any cohort and any set of variants and index the result in the variant storage database.
    * @param {Object} data - Variant stats params.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @param {String} [params.jobId] - Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not
    *     provided.
    * @param {String} [params.jobDescription] - Job description.
    * @param {String} [params.jobDependsOn] - Comma separated list of existing job IDs the job will depend on.
    * @param {String} [params.jobTags] - Job tags.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    indexVariantStats(data, params) {
        return this._post("operation", null, "variant/stats", null, "index", data, params);
    }

    /** Remove whole study from the variant storage
    * @param {Object} [data] - Variant delete study params.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.jobId] - Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not
    *     provided.
    * @param {String} [params.jobDescription] - Job description.
    * @param {String} [params.jobDependsOn] - Comma separated list of existing job IDs the job will depend on.
    * @param {String} [params.jobTags] - Job tags.
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    deleteVariantStudy(data, params) {
        return this._post("operation", null, "variant/study", null, "delete", data, params);
    }

}