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
 * Autogenerated on: 2022-07-01 13:00:18
 * 
 * Manual changes to this file may cause unexpected behavior in your application.
 * Manual changes to this file will be overwritten if the code is regenerated. 
 *
**/

import OpenCGAParentClass from "./../opencga-parent-class.js";


/**
 * This class contains the methods for the "Job" resource
 */

export default class Job extends OpenCGAParentClass {

    constructor(config) {
        super(config);
    }

    /** Update the set of permissions granted for the member
    * @param {String} members - Comma separated list of user or group ids.
    * @param {Object} data - JSON containing the parameters to add ACLs.
    * @param {String} action = "ADD" - Action to be performed [ADD, SET, REMOVE or RESET]. The default value is ADD.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    updateAcl(members, action, data) {
        return this._post("jobs", null, "acl", members, "update", data, action);
    }

    /** Fetch catalog job stats
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @param {String} [params.toolId] - Tool id.
    * @param {String} [params.toolScope] - Tool scope.
    * @param {String} [params.toolType] - Tool type.
    * @param {String} [params.toolResource] - Tool resource.
    * @param {String} [params.userId] - User id.
    * @param {String} [params.priority] - Priority.
    * @param {String} [params.tags] - Tags.
    * @param {String} [params.executorId] - Executor id.
    * @param {String} [params.executorFramework] - Executor framework.
    * @param {String} [params.creationYear] - Creation year.
    * @param {String} [params.creationMonth] - Creation month (JANUARY, FEBRUARY...).
    * @param {String} [params.creationDay] - Creation day.
    * @param {String} [params.creationDayOfWeek] - Creation day of week (MONDAY, TUESDAY...).
    * @param {String} [params.status] - Status.
    * @param {String} [params.release] - Release.
    * @param {Boolean} [params.default = "false"] - Calculate default stats. The default value is false.
    * @param {String} [params.field] - List of fields separated by semicolons, e.g.: studies;type. For nested fields use >>, e.g.:
    *     studies>>biotype;type;numSamples[0..10]:1.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    aggregationStats(params) {
        return this._get("jobs", null, null, null, "aggregationStats", params);
    }

    /** Register an executed job with POST method
    * @param {Object} data - job.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    create(data, params) {
        return this._post("jobs", null, null, null, "create", data, params);
    }

    /** Job distinct method
    * @param {String} field - Field for which to obtain the distinct values.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @param {Boolean} [params.otherStudies = "false"] - Flag indicating the entries being queried can belong to any related study, not just
    *     the primary one. The default value is false.
    * @param {String} [params.id] - Comma separated list of job IDs up to a maximum of 100.
    * @param {String} [params.uuid] - Comma separated list of job UUIDs up to a maximum of 100.
    * @param {String} [params.toolId] - Tool ID executed by the job.
    * @param {String} [params.toolType] - Tool type executed by the job [OPERATION, ANALYSIS].
    * @param {String} [params.userId] - User that created the job.
    * @param {String} [params.priority] - Priority of the job.
    * @param {String} [params.status] - Filter by status.
    * @param {String} [params.internalStatus] - Filter by internal status.
    * @param {String} [params.creationDate] - Creation date. Format: yyyyMMddHHmmss. Examples: >2018, 2017-2018, <201805.
    * @param {String} [params.modificationDate] - Modification date. Format: yyyyMMddHHmmss. Examples: >2018, 2017-2018, <201805.
    * @param {Boolean} [params.visited] - Visited status of job.
    * @param {String} [params.tags] - Job tags.
    * @param {String} [params.input] - Comma separated list of file IDs used as input.
    * @param {String} [params.output] - Comma separated list of file IDs used as output.
    * @param {String} [params.acl] - Filter entries for which a user has the provided permissions. Format: acl={user}:{permissions}.
    *     Example: acl=john:WRITE,WRITE_ANNOTATIONS will return all entries for which user john has both WRITE and WRITE_ANNOTATIONS
    *     permissions. Only study owners or administrators can query by this field. .
    * @param {String} [params.release] - Release when it was created.
    * @param {Boolean} [params.deleted = "false"] - Boolean to retrieve deleted entries. The default value is false.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    distinct(field, params) {
        return this._get("jobs", null, null, null, "distinct", {field, ...params});
    }

    /** Relaunch a failed job
    * @param {Object} data - job.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.jobId] - Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not
    *     provided.
    * @param {String} [params.jobDescription] - Job description.
    * @param {String} [params.jobDependsOn] - Comma separated list of existing job IDs the job will depend on.
    * @param {String} [params.jobTags] - Job tags.
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    retry(data, params) {
        return this._post("jobs", null, null, null, "retry", data, params);
    }

    /** Job search method
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.include] - Fields included in the response, whole JSON path must be provided.
    * @param {String} [params.exclude] - Fields excluded in the response, whole JSON path must be provided.
    * @param {Number} [params.limit] - Number of results to be returned.
    * @param {Number} [params.skip] - Number of results to skip.
    * @param {Boolean} [params.count = "false"] - Get the total number of results matching the query. Deactivated by default. The default
    *     value is false.
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @param {Boolean} [params.otherStudies = "false"] - Flag indicating the entries being queried can belong to any related study, not just
    *     the primary one. The default value is false.
    * @param {String} [params.id] - Comma separated list of job IDs up to a maximum of 100.
    * @param {String} [params.uuid] - Comma separated list of job UUIDs up to a maximum of 100.
    * @param {String} [params.toolId] - Tool ID executed by the job.
    * @param {String} [params.toolType] - Tool type executed by the job [OPERATION, ANALYSIS].
    * @param {String} [params.userId] - User that created the job.
    * @param {String} [params.priority] - Priority of the job.
    * @param {String} [params.status] - Filter by status.
    * @param {String} [params.internalStatus] - Filter by internal status.
    * @param {String} [params.creationDate] - Creation date. Format: yyyyMMddHHmmss. Examples: >2018, 2017-2018, <201805.
    * @param {String} [params.modificationDate] - Modification date. Format: yyyyMMddHHmmss. Examples: >2018, 2017-2018, <201805.
    * @param {Boolean} [params.visited] - Visited status of job.
    * @param {String} [params.tags] - Job tags.
    * @param {String} [params.input] - Comma separated list of file IDs used as input.
    * @param {String} [params.output] - Comma separated list of file IDs used as output.
    * @param {String} [params.acl] - Filter entries for which a user has the provided permissions. Format: acl={user}:{permissions}.
    *     Example: acl=john:WRITE,WRITE_ANNOTATIONS will return all entries for which user john has both WRITE and WRITE_ANNOTATIONS
    *     permissions. Only study owners or administrators can query by this field. .
    * @param {String} [params.release] - Release when it was created.
    * @param {Boolean} [params.deleted = "false"] - Boolean to retrieve deleted entries. The default value is false.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    search(params) {
        return this._get("jobs", null, null, null, "search", params);
    }

    /** Provide a summary of the running jobs
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {Number} [params.limit = "20"] - Maximum number of jobs to be returned. The default value is 20.
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @param {String} [params.internalStatus] - Filter by internal status.
    * @param {String} [params.priority] - Priority of the job.
    * @param {String} [params.userId] - User that created the job.
    * @param {String} [params.toolId] - Tool ID executed by the job.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    top(params) {
        return this._get("jobs", null, null, null, "top", params);
    }

    /** Return the acl of the job. If member is provided, it will only return the acl for the member.
    * @param {String} jobs - Comma separated list of job IDs or UUIDs up to a maximum of 100.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.member] - User or group id.
    * @param {Boolean} [params.silent = "false"] - Boolean to retrieve all possible entries that are queried for, false to raise an
    *     exception whenever one of the entries looked for cannot be shown for whichever reason. The default value is false.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    acl(jobs, params) {
        return this._get("jobs", jobs, null, null, "acl", params);
    }

    /** Delete existing jobs
    * @param {String} jobs - Comma separated list of job ids.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    delete(jobs, params) {
        return this._delete("jobs", jobs, null, null, "delete", params);
    }

    /** Get job information
    * @param {String} jobs - Comma separated list of job IDs or UUIDs up to a maximum of 100.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.include] - Fields included in the response, whole JSON path must be provided.
    * @param {String} [params.exclude] - Fields excluded in the response, whole JSON path must be provided.
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @param {Boolean} [params.deleted = "false"] - Boolean to retrieve deleted jobs. The default value is false.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    info(jobs, params) {
        return this._get("jobs", jobs, null, null, "info", params);
    }

    /** Update some job attributes
    * @param {String} jobs - Comma separated list of job IDs or UUIDs up to a maximum of 100.
    * @param {Object} [data] - body.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.include] - Fields included in the response, whole JSON path must be provided.
    * @param {String} [params.exclude] - Fields excluded in the response, whole JSON path must be provided.
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @param {Boolean} [params.includeResult = "false"] - Flag indicating to include the created or updated document result in the response.
    *     The default value is false.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    update(jobs, data, params) {
        return this._post("jobs", jobs, null, null, "update", data, params);
    }

    /** Show the first lines of a log file (up to a limit)
    * @param {String} job - Job ID or UUID.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @param {Number} [params.offset] - Starting byte from which the file will be read.
    * @param {Number} [params.lines = "20"] - Maximum number of lines to be returned up to a maximum of 1000. The default value is 20.
    * @param {String} [params.type] - Log file to be shown (stdout or stderr).
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    headLog(job, params) {
        return this._get("jobs", job, "log", null, "head", params);
    }

    /** Show the last lines of a log file (up to a limit)
    * @param {String} job - Job ID or UUID.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @param {Number} [params.lines = "20"] - Maximum number of lines to be returned up to a maximum of 1000. The default value is 20.
    * @param {String} [params.type] - Log file to be shown (stdout or stderr).
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    tailLog(job, params) {
        return this._get("jobs", job, "log", null, "tail", params);
    }

}