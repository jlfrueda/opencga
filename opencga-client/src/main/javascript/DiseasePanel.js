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
 * Autogenerated on: 2022-09-09 16:52:15
 * 
 * Manual changes to this file may cause unexpected behavior in your application.
 * Manual changes to this file will be overwritten if the code is regenerated. 
 *
**/

import OpenCGAParentClass from "./../opencga-parent-class.js";


/**
 * This class contains the methods for the "DiseasePanel" resource
 */

export default class DiseasePanel extends OpenCGAParentClass {

    constructor(config) {
        super(config);
    }

    /** Update the set of permissions granted for the member
    * @param {String} members - Comma separated list of user or group ids.
    * @param {Object} data - JSON containing the parameters to update the permissions.
    * @param {"SET ADD REMOVE RESET"} action = "ADD" - Action to be performed [ADD, SET, REMOVE or RESET]. The default value is ADD.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    updateAcl(members, action, data, params) {
        return this._post("panels", null, "acl", members, "update", data, {action, ...params});
    }

    /** Create a panel
    * @param {Object} [data] - Panel parameters.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.include] - Fields included in the response, whole JSON path must be provided.
    * @param {String} [params.exclude] - Fields excluded in the response, whole JSON path must be provided.
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @param {Boolean} [params.includeResult = "false"] - Flag indicating to include the created or updated document result in the response.
    *     The default value is false.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    create(data, params) {
        return this._post("panels", null, null, null, "create", data, params);
    }

    /** Panel distinct method
    * @param {String} field - Field for which to obtain the distinct values.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @param {String} [params.id] - Comma separated list of panel IDs  up to a maximum of 100.
    * @param {String} [params.uuid] - Comma separated list of panel UUIDs  up to a maximum of 100.
    * @param {String} [params.name] - Comma separated list of panel names  up to a maximum of 100.
    * @param {String} [params.internalStatus] - Filter by internal status.
    * @param {String} [params.disorders] - Comma separated list of disorder ids or names.
    * @param {String} [params.variants] - Comma separated list of variant ids.
    * @param {String} [params.genes] - Comma separated list of gene ids.
    * @param {String} [params.source] - Comma separated list of source ids or names.
    * @param {String} [params.regions] - Comma separated list of regions.
    * @param {String} [params.categories] - Comma separated list of category names.
    * @param {String} [params.tags] - Panel tags.
    * @param {Boolean} [params.deleted = "false"] - Boolean to retrieve deleted entries. The default value is false.
    * @param {String} [params.status] - Filter by status.
    * @param {String} [params.creationDate] - Creation date. Format: yyyyMMddHHmmss. Examples: >2018, 2017-2018, <201805.
    * @param {String} [params.modificationDate] - Modification date. Format: yyyyMMddHHmmss. Examples: >2018, 2017-2018, <201805.
    * @param {String} [params.acl] - Filter entries for which a user has the provided permissions. Format: acl={user}:{permissions}.
    *     Example: acl=john:WRITE,WRITE_ANNOTATIONS will return all entries for which user john has both WRITE and WRITE_ANNOTATIONS
    *     permissions. Only study owners or administrators can query by this field. .
    * @param {String} [params.release] - Release when it was created.
    * @param {Number} [params.snapshot] - Snapshot value (Latest version of the entry in the specified release).
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    distinct(field, params) {
        return this._get("panels", null, null, null, "distinct", {field, ...params});
    }

    /** Import panels
    * @param {Object} [data] - Panel parameters.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @param {String} [params.jobId] - Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not
    *     provided.
    * @param {String} [params.jobDependsOn] - Comma separated list of existing job IDs the job will depend on.
    * @param {String} [params.jobDescription] - Job description.
    * @param {String} [params.jobTags] - Job tags.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    importPanels(data, params) {
        return this._post("panels", null, null, null, "import", data, params);
    }

    /** Panel search
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.include] - Fields included in the response, whole JSON path must be provided.
    * @param {String} [params.exclude] - Fields excluded in the response, whole JSON path must be provided.
    * @param {Number} [params.limit] - Number of results to be returned.
    * @param {Number} [params.skip] - Number of results to skip.
    * @param {Boolean} [params.count = "false"] - Get the total number of results matching the query. Deactivated by default. The default
    *     value is false.
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @param {String} [params.id] - Comma separated list of panel IDs  up to a maximum of 100.
    * @param {String} [params.uuid] - Comma separated list of panel UUIDs  up to a maximum of 100.
    * @param {String} [params.name] - Comma separated list of panel names  up to a maximum of 100.
    * @param {String} [params.internalStatus] - Filter by internal status.
    * @param {String} [params.disorders] - Comma separated list of disorder ids or names.
    * @param {String} [params.variants] - Comma separated list of variant ids.
    * @param {String} [params.genes] - Comma separated list of gene ids.
    * @param {String} [params.source] - Comma separated list of source ids or names.
    * @param {String} [params.regions] - Comma separated list of regions.
    * @param {String} [params.categories] - Comma separated list of category names.
    * @param {String} [params.tags] - Panel tags.
    * @param {Boolean} [params.deleted = "false"] - Boolean to retrieve deleted entries. The default value is false.
    * @param {String} [params.status] - Filter by status.
    * @param {String} [params.creationDate] - Creation date. Format: yyyyMMddHHmmss. Examples: >2018, 2017-2018, <201805.
    * @param {String} [params.modificationDate] - Modification date. Format: yyyyMMddHHmmss. Examples: >2018, 2017-2018, <201805.
    * @param {String} [params.acl] - Filter entries for which a user has the provided permissions. Format: acl={user}:{permissions}.
    *     Example: acl=john:WRITE,WRITE_ANNOTATIONS will return all entries for which user john has both WRITE and WRITE_ANNOTATIONS
    *     permissions. Only study owners or administrators can query by this field. .
    * @param {String} [params.release] - Release when it was created.
    * @param {Number} [params.snapshot] - Snapshot value (Latest version of the entry in the specified release).
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    search(params) {
        return this._get("panels", null, null, null, "search", params);
    }

    /** Returns the acl of the panels. If member is provided, it will only return the acl for the member.
    * @param {String} panels - Comma separated list of panel IDs up to a maximum of 100.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @param {String} [params.member] - User or group id.
    * @param {Boolean} [params.silent = "false"] - Boolean to retrieve all possible entries that are queried for, false to raise an
    *     exception whenever one of the entries looked for cannot be shown for whichever reason. The default value is false.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    acl(panels, params) {
        return this._get("panels", panels, null, null, "acl", params);
    }

    /** Delete existing panels
    * @param {String} panels - Comma separated list of panel ids.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    delete(panels, params) {
        return this._delete("panels", panels, null, null, "delete", params);
    }

    /** Panel info
    * @param {String} panels - Comma separated list of panel IDs up to a maximum of 100.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.include] - Fields included in the response, whole JSON path must be provided.
    * @param {String} [params.exclude] - Fields excluded in the response, whole JSON path must be provided.
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @param {String} [params.version] - Comma separated list of panel versions. 'all' to get all the panel versions. Not supported if
    *     multiple panel ids are provided.
    * @param {Boolean} [params.deleted = "false"] - Boolean to retrieve deleted panels. The default value is false.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    info(panels, params) {
        return this._get("panels", panels, null, null, "info", params);
    }

    /** Update panel attributes
    * @param {String} panels - Comma separated list of panel ids.
    * @param {Object} [data] - Panel parameters.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.include] - Fields included in the response, whole JSON path must be provided.
    * @param {String} [params.exclude] - Fields excluded in the response, whole JSON path must be provided.
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @param {Boolean} [params.includeResult = "false"] - Flag indicating to include the created or updated document result in the response.
    *     The default value is false.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    update(panels, data, params) {
        return this._post("panels", panels, null, null, "update", data, params);
    }

}