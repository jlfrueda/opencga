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
 * Autogenerated on: 2023-01-05 15:08:34
 * 
 * Manual changes to this file may cause unexpected behavior in your application.
 * Manual changes to this file will be overwritten if the code is regenerated. 
 *
**/

import OpenCGAParentClass from "./../opencga-parent-class.js";


/**
 * This class contains the methods for the "Family" resource
 */

export default class Family extends OpenCGAParentClass {

    constructor(config) {
        super(config);
    }

    /** Update the set of permissions granted for the member
    * @param {String} members - Comma separated list of user or group ids.
    * @param {Object} data - JSON containing the parameters to add ACLs.
    * @param {"SET ADD REMOVE RESET"} action = "ADD" - Action to be performed [ADD, SET, REMOVE or RESET]. The default value is ADD.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @param {"NO YES YES_AND_VARIANT_VIEW"} [params.propagate = "NO"] - Propagate family permissions to related individuals and samples.
    *     The default value is NO.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    updateAcl(members, action, data, params) {
        return this._post("families", null, "acl", members, "update", data, {action, ...params});
    }

    /** Fetch catalog family stats
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @param {String} [params.creationYear] - Creation year.
    * @param {String} [params.creationMonth] - Creation month (JANUARY, FEBRUARY...).
    * @param {String} [params.creationDay] - Creation day.
    * @param {String} [params.creationDayOfWeek] - Creation day of week (MONDAY, TUESDAY...).
    * @param {String} [params.status] - Status.
    * @param {String} [params.phenotypes] - Phenotypes.
    * @param {String} [params.release] - Release.
    * @param {String} [params.version] - Version.
    * @param {String} [params.numMembers] - Number of members.
    * @param {String} [params.expectedSize] - Expected size.
    * @param {String} [params.annotation] - Annotation filters. Example: age>30;gender=FEMALE. For more information, please visit
    *     http://docs.opencb.org/display/opencga/AnnotationSets+1.4.0.
    * @param {Boolean} [params.default = "false"] - Calculate default stats. The default value is false.
    * @param {String} [params.field] - List of fields separated by semicolons, e.g.: studies;type. For nested fields use >>, e.g.:
    *     studies>>biotype;type;numSamples[0..10]:1.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    aggregationStats(params) {
        return this._get("families", null, null, null, "aggregationStats", params);
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
        return this._post("families", null, "annotationSets", null, "load", data, {variableSetId, path, ...params});
    }

    /** Create family and the individual objects if they do not exist
    * @param {Object} data - JSON containing family information.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.include] - Fields included in the response, whole JSON path must be provided.
    * @param {String} [params.exclude] - Fields excluded in the response, whole JSON path must be provided.
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @param {String} [params.members] - Comma separated list of member ids to be associated to the created family.
    * @param {Boolean} [params.includeResult = "false"] - Flag indicating to include the created or updated document result in the response.
    *     The default value is false.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    create(data, params) {
        return this._post("families", null, null, null, "create", data, params);
    }

    /** Family distinct method
    * @param {String} field - Comma separated list of fields for which to obtain the distinct values.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @param {String} [params.id] - Comma separated list family IDs up to a maximum of 100.
    * @param {String} [params.name] - Comma separated list family names up to a maximum of 100.
    * @param {String} [params.uuid] - Comma separated list family UUIDs up to a maximum of 100.
    * @param {String} [params.members] - Comma separated list of family members.
    * @param {Number} [params.expectedSize] - Expected size of the family (number of members).
    * @param {String} [params.samples] - Comma separated list of member's samples.
    * @param {String} [params.phenotypes] - Comma separated list of phenotype ids or names.
    * @param {String} [params.disorders] - Comma separated list of disorder ids or names.
    * @param {String} [params.creationDate] - Creation date. Format: yyyyMMddHHmmss. Examples: >2018, 2017-2018, <201805.
    * @param {String} [params.modificationDate] - Modification date. Format: yyyyMMddHHmmss. Examples: >2018, 2017-2018, <201805.
    * @param {Boolean} [params.deleted = "false"] - Boolean to retrieve deleted entries. The default value is false.
    * @param {String} [params.internalStatus] - Filter by internal status.
    * @param {String} [params.status] - Filter by status.
    * @param {String} [params.annotation] - Annotation filters. Example: age>30;gender=FEMALE. For more information, please visit
    *     http://docs.opencb.org/display/opencga/AnnotationSets+1.4.0.
    * @param {String} [params.acl] - Filter entries for which a user has the provided permissions. Format: acl={user}:{permissions}.
    *     Example: acl=john:WRITE,WRITE_ANNOTATIONS will return all entries for which user john has both WRITE and WRITE_ANNOTATIONS
    *     permissions. Only study owners or administrators can query by this field. .
    * @param {String} [params.release] - Release when it was created.
    * @param {Number} [params.snapshot] - Snapshot value (Latest version of the entry in the specified release).
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    distinct(field, params) {
        return this._get("families", null, null, null, "distinct", {field, ...params});
    }

    /** Search families
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.include] - Fields included in the response, whole JSON path must be provided.
    * @param {String} [params.exclude] - Fields excluded in the response, whole JSON path must be provided.
    * @param {Number} [params.limit] - Number of results to be returned.
    * @param {Number} [params.skip] - Number of results to skip.
    * @param {Boolean} [params.count = "false"] - Get the total number of results matching the query. Deactivated by default. The default
    *     value is false.
    * @param {Boolean} [params.flattenAnnotations = "false"] - Flatten the annotations?. The default value is false.
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @param {String} [params.id] - Comma separated list family IDs up to a maximum of 100.
    * @param {String} [params.name] - Comma separated list family names up to a maximum of 100.
    * @param {String} [params.uuid] - Comma separated list family UUIDs up to a maximum of 100.
    * @param {String} [params.members] - Comma separated list of family members.
    * @param {Number} [params.expectedSize] - Expected size of the family (number of members).
    * @param {String} [params.samples] - Comma separated list of member's samples.
    * @param {String} [params.phenotypes] - Comma separated list of phenotype ids or names.
    * @param {String} [params.disorders] - Comma separated list of disorder ids or names.
    * @param {String} [params.creationDate] - Creation date. Format: yyyyMMddHHmmss. Examples: >2018, 2017-2018, <201805.
    * @param {String} [params.modificationDate] - Modification date. Format: yyyyMMddHHmmss. Examples: >2018, 2017-2018, <201805.
    * @param {Boolean} [params.deleted = "false"] - Boolean to retrieve deleted entries. The default value is false.
    * @param {String} [params.internalStatus] - Filter by internal status.
    * @param {String} [params.status] - Filter by status.
    * @param {String} [params.annotation] - Annotation filters. Example: age>30;gender=FEMALE. For more information, please visit
    *     http://docs.opencb.org/display/opencga/AnnotationSets+1.4.0.
    * @param {String} [params.acl] - Filter entries for which a user has the provided permissions. Format: acl={user}:{permissions}.
    *     Example: acl=john:WRITE,WRITE_ANNOTATIONS will return all entries for which user john has both WRITE and WRITE_ANNOTATIONS
    *     permissions. Only study owners or administrators can query by this field. .
    * @param {String} [params.release] - Release when it was created.
    * @param {Number} [params.snapshot] - Snapshot value (Latest version of the entry in the specified release).
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    search(params) {
        return this._get("families", null, null, null, "search", params);
    }

    /** Returns the acl of the families. If member is provided, it will only return the acl for the member.
    * @param {String} families - Comma separated list of family IDs or names up to a maximum of 100.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @param {String} [params.member] - User or group id.
    * @param {Boolean} [params.silent = "false"] - Boolean to retrieve all possible entries that are queried for, false to raise an
    *     exception whenever one of the entries looked for cannot be shown for whichever reason. The default value is false.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    acl(families, params) {
        return this._get("families", families, null, null, "acl", params);
    }

    /** Delete existing families
    * @param {String} families - Comma separated list of family ids.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    delete(families, params) {
        return this._delete("families", families, null, null, "delete", params);
    }

    /** Get family information
    * @param {String} families - Comma separated list of family IDs or names up to a maximum of 100.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.include] - Fields included in the response, whole JSON path must be provided.
    * @param {String} [params.exclude] - Fields excluded in the response, whole JSON path must be provided.
    * @param {Boolean} [params.flattenAnnotations = "false"] - Flatten the annotations?. The default value is false.
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @param {String} [params.version] - Comma separated list of family versions. 'all' to get all the family versions. Not supported if
    *     multiple family ids are provided.
    * @param {Boolean} [params.deleted = "false"] - Boolean to retrieve deleted families. The default value is false.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    info(families, params) {
        return this._get("families", families, null, null, "info", params);
    }

    /** Update some family attributes
    * @param {String} families - Comma separated list of family ids.
    * @param {Object} [data] - body.
    * @param {Object} [params] - The Object containing the following optional parameters:
    * @param {String} [params.include] - Fields included in the response, whole JSON path must be provided.
    * @param {String} [params.exclude] - Fields excluded in the response, whole JSON path must be provided.
    * @param {String} [params.study] - Study [[user@]project:]study where study and project can be either the ID or UUID.
    * @param {Boolean} [params.updateRoles = "false"] - Update the member roles within the family. The default value is false.
    * @param {"ADD SET REMOVE"} [params.annotationSetsAction = "ADD"] - Action to be performed if the array of annotationSets is being
    *     updated. The default value is ADD.
    * @param {Boolean} [params.includeResult = "false"] - Flag indicating to include the created or updated document result in the response.
    *     The default value is false.
    * @returns {Promise} Promise object in the form of RestResponse instance.
    */
    update(families, data, params) {
        return this._post("families", families, null, null, "update", data, params);
    }

    /** Update annotations from an annotationSet
    * @param {String} family - Family id.
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
    updateAnnotationSetsAnnotations(family, annotationSet, data, params) {
        return this._post("families", family, "annotationSets", annotationSet, "annotations/update", data, params);
    }

}