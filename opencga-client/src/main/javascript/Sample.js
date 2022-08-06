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
 * Autogenerated on: 2022-08-06 18:56:58
 * 
 * Manual changes to this file may cause unexpected behavior in your application.
 * Manual changes to this file will be overwritten if the code is regenerated. 
 *
**/

import OpenCGAParentClass from "./../opencga-parent-class.js";


/**
 * This class contains the methods for the "Sample" resource
 */

export default class Sample extends OpenCGAParentClass {

    constructor(config) {
        super(config);
    }

    /** Update the set of permissions granted for the member
    * @param {String} members - Comma separated list of user or group ids.
    * @param {Object} data - JSON containing the parameters to update the permissions. If propagate flag is set to true, it will propagate
    *     the permissions defined to the individuals that are associated to the matching samples.
    * @param {"SET ADD REMOVE RESET"} action = "ADD" - Action to be performed [ADD, SET, REMOVE or RESET]. The default value is ADD.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    updateAcl(members, action, data, params) {
        return this._post("samples", null, "acl", members, "update", data, {action, ...params});
    }

    /** Fetch catalog sample stats
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @param {String} [params.source] - Source.
    * @param {String} [params.creationYear] - Creation year.
    * @param {String} [params.creationMonth] - Creation month (JANUARY, FEBRUARY...).
    * @param {String} [params.creationDay] - Creation day.
    * @param {String} [params.creationDayOfWeek] - Creation day of week (MONDAY, TUESDAY...).
    * @param {String} [params.status] - Status.
    * @param {String} [params.type] - Type.
    * @param {String} [params.phenotypes] - Phenotypes.
    * @param {String} [params.release] - Release.
    * @param {String} [params.version] - Version.
    * @param {Boolean} [params.somatic] - Somatic.
    * @param {String} [params.annotation] - Annotation filters. Example: age>30;gender=FEMALE. For more information, please visit
    *     http://docs.opencb.org/display/opencga/AnnotationSets+1.4.0.
    * @param {Boolean} [params.default = "false"] - Calculate default stats. The default value is false.
    * @param {String} [params.field] - List of fields separated by semicolons, e.g.: studies;type. For nested fields use >>, e.g.:
    *     studies>>biotype;type;numSamples[0..10]:1.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    aggregationStats(params) {
        return this._get("samples", null, null, null, "aggregationStats", params);
    }

    /** Load annotation sets from a TSV file
    * @param {Object} [data] - JSON containing the 'content' of the TSV file if this has not yet been registered into OpenCGA.
    * @param {String} variableSetId - Variable set ID or name.
    * @param {String} path - Path where the TSV file is located in OpenCGA or where it should be located.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @param {Boolean} [params.parents] - Flag indicating whether to create parent directories if they don't exist (only when TSV file was
    *     not previously associated).
    * @param {String} [params.annotationSetId] - Annotation set id. If not provided, variableSetId will be used.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    loadAnnotationSets(variableSetId, path, data, params) {
        return this._post("samples", null, "annotationSets", null, "load", data, {variableSetId, path, ...params});
    }

    /** Create sample
    * @param {Object} data - JSON containing sample information.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.include] - Fields included in the response, whole JSON path must be provided.
    * @param {String} [params.exclude] - Fields excluded in the response, whole JSON path must be provided.
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @param {Boolean} [params.includeResult = "false"] - Flag indicating to include the created or updated document result in the response.
    *     The default value is false.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    create(data, params) {
        return this._post("samples", null, null, null, "create", data, params);
    }

    /** Sample distinct method
    * @param {String} field - Field for which to obtain the distinct values.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @param {String} [params.id] - Comma separated list sample IDs up to a maximum of 100.
    * @param {String} [params.uuid] - Comma separated list sample UUIDs up to a maximum of 100.
    * @param {Boolean} [params.somatic] - Somatic sample.
    * @param {String} [params.individualId] - Individual ID or UUID.
    * @param {String} [params.fileIds] - Comma separated list of file IDs, paths or UUIDs.
    * @param {String} [params.cohortIds] - Comma separated list of cohort IDs.
    * @param {String} [params.creationDate] - Creation date. Format: yyyyMMddHHmmss. Examples: >2018, 2017-2018, <201805.
    * @param {String} [params.modificationDate] - Modification date. Format: yyyyMMddHHmmss. Examples: >2018, 2017-2018, <201805.
    * @param {String} [params.internalStatus] - Filter by internal status.
    * @param {String} [params.status] - Filter by status.
    * @param {String} [params.processingProduct] - Processing product.
    * @param {String} [params.processingPreparationMethod] - Processing preparation method.
    * @param {String} [params.processingExtractionMethod] - Processing extraction method.
    * @param {String} [params.processingLabSampleId] - Processing lab sample id.
    * @param {String} [params.collectionFrom] - Collection from.
    * @param {String} [params.collectionType] - Collection type.
    * @param {String} [params.collectionMethod] - Collection method.
    * @param {String} [params.phenotypes] - Comma separated list of phenotype ids or names.
    * @param {String} [params.annotation] - Annotation filters. Example: age>30;gender=FEMALE. For more information, please visit
    *     http://docs.opencb.org/display/opencga/AnnotationSets+1.4.0.
    * @param {String} [params.acl] - Filter entries for which a user has the provided permissions. Format: acl={user}:{permissions}.
    *     Example: acl=john:WRITE,WRITE_ANNOTATIONS will return all entries for which user john has both WRITE and WRITE_ANNOTATIONS
    *     permissions. Only study owners or administrators can query by this field. .
    * @param {"NOT_INDEXED INDEXED INVALID_PERMISSIONS INVALID_METADATA INVALID"} [params.internalRgaStatus] - Index status of the sample
    *     for the Recessive Gene Analysis.
    * @param {String} [params.release] - Release when it was created.
    * @param {Number} [params.snapshot] - Snapshot value (Latest version of the entry in the specified release).
    * @param {Boolean} [params.deleted = "false"] - Boolean to retrieve deleted entries. The default value is false.
    * @param {String} [params.statsId] - Sample variant stats Id. If this field is not provided and the user filters by other stats fields,
    *     it will automatically be set to ALL.
    * @param {String} [params.statsVariantCount] - Sample variant stats VariantCount.
    * @param {String} [params.statsChromosomeCount] - Sample variant stats ChromosomeCount.
    * @param {String} [params.statsTypeCount] - Sample variant stats TypeCount.
    * @param {String} [params.statsGenotypeCount] - Sample variant stats GenotypeCount.
    * @param {String} [params.statsTiTvRatio] - Sample variant stats TiTvRatio.
    * @param {String} [params.statsQualityAvg] - Sample variant stats QualityAvg.
    * @param {String} [params.statsQualityStdDev] - Sample variant stats QualityStdDev.
    * @param {String} [params.statsHeterozygosityRate] - Sample variant stats HeterozygosityRate.
    * @param {String} [params.statsDepthCount] - Sample variant stats DepthCount.
    * @param {String} [params.statsBiotypeCount] - Sample variant stats BiotypeCount.
    * @param {String} [params.statsClinicalSignificanceCount] - Sample variant stats ClinicalSignificanceCount.
    * @param {String} [params.statsConsequenceTypeCount] - Sample variant stats ConsequenceTypeCount.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    distinct(field, params) {
        return this._get("samples", null, null, null, "distinct", {field, ...params});
    }

    /** Load samples from a ped file [EXPERIMENTAL]
    * @param {String} file - file.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @param {String} [params.variableSet] - variableSet.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    load(file, params) {
        return this._get("samples", null, null, null, "load", {file, ...params});
    }

    /** Sample search method
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.include] - Fields included in the response, whole JSON path must be provided.
    * @param {String} [params.exclude] - Fields excluded in the response, whole JSON path must be provided.
    * @param {Number} [params.limit] - Number of results to be returned.
    * @param {Number} [params.skip] - Number of results to skip.
    * @param {Boolean} [params.count = "false"] - Get the total number of results matching the query. Deactivated by default. The default
    *     value is false.
    * @param {Boolean} [params.includeIndividual = "false"] - Include Individual object as an attribute. The default value is false.
    * @param {Boolean} [params.flattenAnnotations = "false"] - Flatten the annotations?. The default value is false.
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @param {String} [params.id] - Comma separated list sample IDs up to a maximum of 100.
    * @param {String} [params.uuid] - Comma separated list sample UUIDs up to a maximum of 100.
    * @param {Boolean} [params.somatic] - Somatic sample.
    * @param {String} [params.individualId] - Individual ID or UUID.
    * @param {String} [params.fileIds] - Comma separated list of file IDs, paths or UUIDs.
    * @param {String} [params.cohortIds] - Comma separated list of cohort IDs.
    * @param {String} [params.creationDate] - Creation date. Format: yyyyMMddHHmmss. Examples: >2018, 2017-2018, <201805.
    * @param {String} [params.modificationDate] - Modification date. Format: yyyyMMddHHmmss. Examples: >2018, 2017-2018, <201805.
    * @param {String} [params.internalStatus] - Filter by internal status.
    * @param {String} [params.status] - Filter by status.
    * @param {String} [params.processingProduct] - Processing product.
    * @param {String} [params.processingPreparationMethod] - Processing preparation method.
    * @param {String} [params.processingExtractionMethod] - Processing extraction method.
    * @param {String} [params.processingLabSampleId] - Processing lab sample id.
    * @param {String} [params.collectionFrom] - Collection from.
    * @param {String} [params.collectionType] - Collection type.
    * @param {String} [params.collectionMethod] - Collection method.
    * @param {String} [params.phenotypes] - Comma separated list of phenotype ids or names.
    * @param {String} [params.annotation] - Annotation filters. Example: age>30;gender=FEMALE. For more information, please visit
    *     http://docs.opencb.org/display/opencga/AnnotationSets+1.4.0.
    * @param {String} [params.acl] - Filter entries for which a user has the provided permissions. Format: acl={user}:{permissions}.
    *     Example: acl=john:WRITE,WRITE_ANNOTATIONS will return all entries for which user john has both WRITE and WRITE_ANNOTATIONS
    *     permissions. Only study owners or administrators can query by this field. .
    * @param {"NOT_INDEXED INDEXED INVALID_PERMISSIONS INVALID_METADATA INVALID"} [params.internalRgaStatus] - Index status of the sample
    *     for the Recessive Gene Analysis.
    * @param {String} [params.release] - Release when it was created.
    * @param {Number} [params.snapshot] - Snapshot value (Latest version of the entry in the specified release).
    * @param {Boolean} [params.deleted = "false"] - Boolean to retrieve deleted entries. The default value is false.
    * @param {String} [params.statsId] - Sample variant stats Id. If this field is not provided and the user filters by other stats fields,
    *     it will automatically be set to ALL.
    * @param {String} [params.statsVariantCount] - Sample variant stats VariantCount.
    * @param {String} [params.statsChromosomeCount] - Sample variant stats ChromosomeCount.
    * @param {String} [params.statsTypeCount] - Sample variant stats TypeCount.
    * @param {String} [params.statsGenotypeCount] - Sample variant stats GenotypeCount.
    * @param {String} [params.statsTiTvRatio] - Sample variant stats TiTvRatio.
    * @param {String} [params.statsQualityAvg] - Sample variant stats QualityAvg.
    * @param {String} [params.statsQualityStdDev] - Sample variant stats QualityStdDev.
    * @param {String} [params.statsHeterozygosityRate] - Sample variant stats HeterozygosityRate.
    * @param {String} [params.statsDepthCount] - Sample variant stats DepthCount.
    * @param {String} [params.statsBiotypeCount] - Sample variant stats BiotypeCount.
    * @param {String} [params.statsClinicalSignificanceCount] - Sample variant stats ClinicalSignificanceCount.
    * @param {String} [params.statsConsequenceTypeCount] - Sample variant stats ConsequenceTypeCount.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    search(params) {
        return this._get("samples", null, null, null, "search", params);
    }

    /** Returns the acl of the samples. If member is provided, it will only return the acl for the member.
    * @param {String} samples - Comma separated list sample IDs or UUIDs up to a maximum of 100.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @param {String} [params.member] - User or group id.
    * @param {Boolean} [params.silent = "false"] - Boolean to retrieve all possible entries that are queried for, false to raise an
    *     exception whenever one of the entries looked for cannot be shown for whichever reason. The default value is false.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    acl(samples, params) {
        return this._get("samples", samples, null, null, "acl", params);
    }

    /** Delete samples
    * @param {String} samples - Comma separated list sample IDs or UUIDs up to a maximum of 100.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {Boolean} [params.force = "false"] - Force the deletion of samples even if they are associated to files, individuals or
    *     cohorts. The default value is false.
    * @param {String} [params.emptyFilesAction = "NONE"] - Action to be performed over files that were associated only to the sample to be
    *     deleted. Possible actions are NONE, TRASH, DELETE. The default value is NONE.
    * @param {Boolean} [params.deleteEmptyCohorts = "false"] - Boolean indicating if the cohorts associated only to the sample to be deleted
    *     should be also deleted. The default value is false.
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    delete(samples, params) {
        return this._delete("samples", samples, null, null, "delete", params);
    }

    /** Get sample information
    * @param {String} samples - Comma separated list sample IDs or UUIDs up to a maximum of 100.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.include] - Fields included in the response, whole JSON path must be provided.
    * @param {String} [params.exclude] - Fields excluded in the response, whole JSON path must be provided.
    * @param {Boolean} [params.includeIndividual = "false"] - Include Individual object as an attribute. The default value is false.
    * @param {Boolean} [params.flattenAnnotations = "false"] - Flatten the annotations?. The default value is false.
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @param {String} [params.version] - Comma separated list of sample versions. 'all' to get all the sample versions. Not supported if
    *     multiple sample ids are provided.
    * @param {Boolean} [params.deleted = "false"] - Boolean to retrieve deleted entries. The default value is false.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    info(samples, params) {
        return this._get("samples", samples, null, null, "info", params);
    }

    /** Update some sample attributes
    * @param {String} samples - Comma separated list sample IDs or UUIDs up to a maximum of 100.
    * @param {Object} [data] - body.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.include] - Fields included in the response, whole JSON path must be provided.
    * @param {String} [params.exclude] - Fields excluded in the response, whole JSON path must be provided.
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @param {"ADD SET REMOVE"} [params.annotationSetsAction = "ADD"] - Action to be performed if the array of annotationSets is being
    *     updated. The default value is ADD.
    * @param {"ADD SET REMOVE"} [params.phenotypesAction = "ADD"] - Action to be performed if the array of phenotypes is being updated [SET,
    *     ADD, REMOVE]. The default value is ADD.
    * @param {Boolean} [params.includeResult = "false"] - Flag indicating to include the created or updated document result in the response.
    *     The default value is false.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    update(samples, data, params) {
        return this._post("samples", samples, null, null, "update", data, params);
    }

    /** Update annotations from an annotationSet
    * @param {String} sample - Sample ID.
    * @param {String} annotationSet - AnnotationSet ID to be updated.
    * @param {Object} [data] - Json containing the map of annotations when the action is ADD, SET or REPLACE, a json with only the key
    *     'remove' containing the comma separated variables to be removed as a value when the action is REMOVE or a json with only the key
    *     'reset' containing the comma separated variables that will be set to the default value when the action is RESET.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @param {"ADD SET REMOVE RESET REPLACE"} [params.action = "ADD"] - Action to be performed: ADD to add new annotations; REPLACE to
    *     replace the value of an already existing annotation; SET to set the new list of annotations removing any possible old annotations;
    *     REMOVE to remove some annotations; RESET to set some annotations to the default value configured in the corresponding variables of the
    *     VariableSet if any. The default value is ADD.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    updateAnnotationSetsAnnotations(sample, annotationSet, data, params) {
        return this._post("samples", sample, "annotationSets", annotationSet, "annotations/update", data, params);
    }

}