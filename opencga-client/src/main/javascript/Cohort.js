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
 * Autogenerated on: 2022-07-29 12:32:26
 * 
 * Manual changes to this file may cause unexpected behavior in your application.
 * Manual changes to this file will be overwritten if the code is regenerated. 
 *
**/

import OpenCGAParentClass from "./../opencga-parent-class.js";


/**
 * This class contains the methods for the "Cohort" resource
 */

export default class Cohort extends OpenCGAParentClass {

    constructor(config) {
        super(config);
    }

    /** Update the set of permissions granted for the member
    * @param {String} members - Comma separated list of user or group ids.
    * @param {Object} data - JSON containing the parameters to add ACLs.
    * @param {"SET ADD REMOVE RESET"} action = "ADD" - Action to be performed [ADD, SET, REMOVE or RESET]. The default value is ADD.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    updateAcl(members, action, data, params) {
        return this._post("cohorts", null, "acl", members, "update", data, {action, ...params});
    }

    /** Fetch catalog cohort stats
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @param {String} [params.type] - Type.
    * @param {String} [params.creationYear] - Creation year.
    * @param {String} [params.creationMonth] - Creation month (JANUARY, FEBRUARY...).
    * @param {String} [params.creationDay] - Creation day.
    * @param {String} [params.creationDayOfWeek] - Creation day of week (MONDAY, TUESDAY...).
    * @param {String} [params.numSamples] - Number of samples.
    * @param {String} [params.status] - Status.
    * @param {String} [params.release] - Release.
    * @param {String} [params.annotation] - Annotation filters. Example: age>30;gender=FEMALE. For more information, please visit
    *     http://docs.opencb.org/display/opencga/AnnotationSets+1.4.0.
    * @param {Boolean} [params.default = "false"] - Calculate default stats. The default value is false.
    * @param {String} [params.field] - List of fields separated by semicolons, e.g.: studies;type. For nested fields use >>, e.g.:
    *     studies>>biotype;type;numSamples[0..10]:1.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    aggregationStats(params) {
        return this._get("cohorts", null, null, null, "aggregationStats", params);
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
        return this._post("cohorts", null, "annotationSets", null, "load", data, {variableSetId, path, ...params});
    }

    /** Create a cohort
    * @param {Object} data - JSON containing cohort information.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.include] - Fields included in the response, whole JSON path must be provided.
    * @param {String} [params.exclude] - Fields excluded in the response, whole JSON path must be provided.
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @param {String} [params.variableSet] - Deprecated: Use /generate web service and filter by annotation.
    * @param {String} [params.variable] - Deprecated: Use /generate web service and filter by annotation.
    * @param {Boolean} [params.includeResult = "false"] - Flag indicating to include the created or updated document result in the response.
    *     The default value is false.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    create(data, params) {
        return this._post("cohorts", null, null, null, "create", data, params);
    }

    /** Cohort distinct method
    * @param {String} field - Field for which to obtain the distinct values.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @param {String} [params.id] - Comma separated list of cohort IDs up to a maximum of 100.
    * @param {String} [params.name] - Comma separated list of cohort names up to a maximum of 100.
    * @param {String} [params.uuid] - Comma separated list of cohort IDs up to a maximum of 100.
    * @param {"CASE_CONTROL CASE_SET CONTROL_SET PAIRED PAIRED_TUMOR AGGREGATE TIME_SERIES FAMILY TRIO COLLECTION"} [params.type] - Cohort
    *     type.
    * @param {String} [params.creationDate] - creationDate.
    * @param {String} [params.modificationDate] - modificationDate.
    * @param {Boolean} [params.deleted] - deleted.
    * @param {String} [params.status] - status.
    * @param {String} [params.internalStatus] - internalStatus.
    * @param {String} [params.annotation] - Cohort annotation.
    * @param {String} [params.acl] - acl.
    * @param {String} [params.samples] - Cohort sample IDs.
    * @param {String} [params.numSamples] - Number of samples.
    * @param {String} [params.release] - release.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    distinct(field, params) {
        return this._get("cohorts", null, null, null, "distinct", {field, ...params});
    }

    /** Create a cohort based on a sample query
    * @param {Object} data - JSON containing cohort information.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.include] - Fields included in the response, whole JSON path must be provided.
    * @param {String} [params.exclude] - Fields excluded in the response, whole JSON path must be provided.
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @param {String} [params.id] - Comma separated list sample IDs or UUIDs up to a maximum of 100.
    * @param {Boolean} [params.somatic] - Somatic sample.
    * @param {String} [params.individualId] - Individual ID or UUID.
    * @param {String} [params.fileIds] - Comma separated list of file IDs, paths or UUIDs.
    * @param {String} [params.creationDate] - Creation date. Format: yyyyMMddHHmmss. Examples: >2018, 2017-2018, <201805.
    * @param {String} [params.modificationDate] - Modification date. Format: yyyyMMddHHmmss. Examples: >2018, 2017-2018, <201805.
    * @param {String} [params.internalStatus] - Filter by internal status.
    * @param {String} [params.status] - Filter by status.
    * @param {String} [params.phenotypes] - Comma separated list of phenotype ids or names.
    * @param {String} [params.annotation] - Annotation filters. Example: age>30;gender=FEMALE. For more information, please visit
    *     http://docs.opencb.org/display/opencga/AnnotationSets+1.4.0.
    * @param {String} [params.acl] - Filter entries for which a user has the provided permissions. Format: acl={user}:{permissions}.
    *     Example: acl=john:WRITE,WRITE_ANNOTATIONS will return all entries for which user john has both WRITE and WRITE_ANNOTATIONS
    *     permissions. Only study owners or administrators can query by this field. .
    * @param {String} [params.release] - Release when it was created.
    * @param {Number} [params.snapshot] - Snapshot value (Latest version of the entry in the specified release).
    * @param {Boolean} [params.includeResult = "false"] - Flag indicating to include the created or updated document result in the response.
    *     The default value is false.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    generate(data, params) {
        return this._post("cohorts", null, null, null, "generate", data, params);
    }

    /** Search cohorts
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.include] - Fields included in the response, whole JSON path must be provided.
    * @param {String} [params.exclude] - Fields excluded in the response, whole JSON path must be provided.
    * @param {Number} [params.limit] - Number of results to be returned.
    * @param {Number} [params.skip] - Number of results to skip.
    * @param {Boolean} [params.count = "false"] - Get the total number of results matching the query. Deactivated by default. The default
    *     value is false.
    * @param {Boolean} [params.flattenAnnotations = "false"] - Flatten the annotations?. The default value is false.
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @param {String} [params.id] - Comma separated list of cohort IDs up to a maximum of 100.
    * @param {String} [params.name] - Comma separated list of cohort names up to a maximum of 100.
    * @param {String} [params.uuid] - Comma separated list of cohort IDs up to a maximum of 100.
    * @param {"CASE_CONTROL CASE_SET CONTROL_SET PAIRED PAIRED_TUMOR AGGREGATE TIME_SERIES FAMILY TRIO COLLECTION"} [params.type] - Cohort
    *     type.
    * @param {String} [params.creationDate] - creationDate.
    * @param {String} [params.modificationDate] - modificationDate.
    * @param {Boolean} [params.deleted] - deleted.
    * @param {String} [params.status] - status.
    * @param {String} [params.internalStatus] - internalStatus.
    * @param {String} [params.annotation] - Cohort annotation.
    * @param {String} [params.acl] - acl.
    * @param {String} [params.samples] - Cohort sample IDs.
    * @param {String} [params.numSamples] - Number of samples.
    * @param {String} [params.release] - release.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    search(params) {
        return this._get("cohorts", null, null, null, "search", params);
    }

    /** Return the acl of the cohort. If member is provided, it will only return the acl for the member.
    * @param {String} cohorts - Comma separated list of cohort IDs or UUIDs up to a maximum of 100.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @param {String} [params.member] - User or group id.
    * @param {Boolean} [params.silent = "false"] - Boolean to retrieve all possible entries that are queried for, false to raise an
    *     exception whenever one of the entries looked for cannot be shown for whichever reason. The default value is false.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    acl(cohorts, params) {
        return this._get("cohorts", cohorts, null, null, "acl", params);
    }

    /** Delete cohorts
    * @param {String} cohorts - Comma separated list of cohort ids.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    delete(cohorts, params) {
        return this._delete("cohorts", cohorts, null, null, "delete", params);
    }

    /** Get cohort information
    * @param {String} cohorts - Comma separated list of cohort IDs or UUIDs up to a maximum of 100.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.include] - Fields included in the response, whole JSON path must be provided.
    * @param {String} [params.exclude] - Fields excluded in the response, whole JSON path must be provided.
    * @param {Boolean} [params.flattenAnnotations = "false"] - Flatten the annotations?. The default value is false.
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @param {Boolean} [params.deleted = "false"] - Boolean to retrieve deleted cohorts. The default value is false.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    info(cohorts, params) {
        return this._get("cohorts", cohorts, null, null, "info", params);
    }

    /** Update some cohort attributes
    * @param {String} cohorts - Comma separated list of cohort ids.
    * @param {Object} [data] - body.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.include] - Fields included in the response, whole JSON path must be provided.
    * @param {String} [params.exclude] - Fields excluded in the response, whole JSON path must be provided.
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @param {"ADD SET REMOVE"} [params.samplesAction = "ADD"] - Action to be performed if the array of samples is being updated. The
    *     default value is ADD.
    * @param {"ADD SET REMOVE"} [params.annotationSetsAction = "ADD"] - Action to be performed if the array of annotationSets is being
    *     updated. The default value is ADD.
    * @param {Boolean} [params.includeResult = "false"] - Flag indicating to include the created or updated document result in the response.
    *     The default value is false.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    update(cohorts, data, params) {
        return this._post("cohorts", cohorts, null, null, "update", data, params);
    }

    /** Update annotations from an annotationSet
    * @param {String} cohort - Cohort ID.
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
    updateAnnotationSetsAnnotations(cohort, annotationSet, data, params) {
        return this._post("cohorts", cohort, "annotationSets", annotationSet, "annotations/update", data, params);
    }

}