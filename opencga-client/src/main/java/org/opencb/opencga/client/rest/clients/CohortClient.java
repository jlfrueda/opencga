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

import java.lang.Object;
import org.opencb.commons.datastore.core.FacetField;
import org.opencb.commons.datastore.core.ObjectMap;
import org.opencb.opencga.client.config.ClientConfiguration;
import org.opencb.opencga.client.exceptions.ClientException;
import org.opencb.opencga.client.rest.AbstractParentClient;
import org.opencb.opencga.core.models.cohort.Cohort;
import org.opencb.opencga.core.models.cohort.CohortAclUpdateParams;
import org.opencb.opencga.core.models.cohort.CohortCreateParams;
import org.opencb.opencga.core.models.cohort.CohortGenerateParams;
import org.opencb.opencga.core.models.cohort.CohortUpdateParams;
import org.opencb.opencga.core.models.common.TsvAnnotationParams;
import org.opencb.opencga.core.models.job.Job;
import org.opencb.opencga.core.response.RestResponse;


/*
* WARNING: AUTOGENERATED CODE
*
* This code was generated by a tool.
* Autogenerated on: 2022-07-27 17:05:57
*
* Manual changes to this file may cause unexpected behavior in your application.
* Manual changes to this file will be overwritten if the code is regenerated.
*/


/**
 * This class contains methods for the Cohort webservices.
 *    Client version: 2.4.2-SNAPSHOT [a043b28a22afda65469113951b5662d8d2f20b71]
 *    PATH: cohorts
 */
public class CohortClient extends AbstractParentClient {

    public CohortClient(String token, ClientConfiguration configuration) {
        super(token, configuration);
    }

    /**
     * Update the set of permissions granted for the member.
     * @param members Comma separated list of user or group ids.
     * @param action Action to be performed [ADD, SET, REMOVE or RESET].
     * @param data JSON containing the parameters to add ACLs.
     * @param params Map containing any of the following optional parameters.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<ObjectMap> updateAcl(String members, String action, CohortAclUpdateParams data, ObjectMap params)
            throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.putIfNotNull("action", action);
        params.put("body", data);
        return execute("cohorts", null, "acl", members, "update", params, POST, ObjectMap.class);
    }

    /**
     * Fetch catalog cohort stats.
     * @param params Map containing any of the following optional parameters.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     *       type: Type.
     *       creationYear: Creation year.
     *       creationMonth: Creation month (JANUARY, FEBRUARY...).
     *       creationDay: Creation day.
     *       creationDayOfWeek: Creation day of week (MONDAY, TUESDAY...).
     *       numSamples: Number of samples.
     *       status: Status.
     *       release: Release.
     *       annotation: Annotation filters. Example: age>30;gender=FEMALE. For more information, please visit
     *            http://docs.opencb.org/display/opencga/AnnotationSets+1.4.0.
     *       default: Calculate default stats.
     *       field: List of fields separated by semicolons, e.g.: studies;type. For nested fields use >>, e.g.:
     *            studies>>biotype;type;numSamples[0..10]:1.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<FacetField> aggregationStats(ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        return execute("cohorts", null, null, null, "aggregationStats", params, GET, FacetField.class);
    }

    /**
     * Load annotation sets from a TSV file.
     * @param variableSetId Variable set ID or name.
     * @param path Path where the TSV file is located in OpenCGA or where it should be located.
     * @param data JSON containing the 'content' of the TSV file if this has not yet been registered into OpenCGA.
     * @param params Map containing any of the following optional parameters.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     *       parents: Flag indicating whether to create parent directories if they don't exist (only when TSV file was not previously
     *            associated).
     *       annotationSetId: Annotation set id. If not provided, variableSetId will be used.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Job> loadAnnotationSets(String variableSetId, String path, TsvAnnotationParams data, ObjectMap params)
            throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.putIfNotNull("variableSetId", variableSetId);
        params.putIfNotNull("path", path);
        params.put("body", data);
        return execute("cohorts", null, "annotationSets", null, "load", params, POST, Job.class);
    }

    /**
     * Create a cohort.
     * @param data JSON containing cohort information.
     * @param params Map containing any of the following optional parameters.
     *       include: Fields included in the response, whole JSON path must be provided.
     *       exclude: Fields excluded in the response, whole JSON path must be provided.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     *       variableSet: Deprecated: Use /generate web service and filter by annotation.
     *       variable: Deprecated: Use /generate web service and filter by annotation.
     *       includeResult: Flag indicating to include the created or updated document result in the response.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Cohort> create(CohortCreateParams data, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.put("body", data);
        return execute("cohorts", null, null, null, "create", params, POST, Cohort.class);
    }

    /**
     * Cohort distinct method.
     * @param field Field for which to obtain the distinct values.
     * @param params Map containing any of the following optional parameters.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     *       id: Comma separated list of cohort IDs up to a maximum of 100.
     *       name: Comma separated list of cohort names up to a maximum of 100.
     *       uuid: Comma separated list of cohort IDs up to a maximum of 100.
     *       type: Cohort type.
     *       creationDate: creationDate.
     *       modificationDate: modificationDate.
     *       deleted: deleted.
     *       status: status.
     *       internalStatus: internalStatus.
     *       annotation: Cohort annotation.
     *       acl: acl.
     *       samples: Cohort sample IDs.
     *       numSamples: Number of samples.
     *       release: release.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Object> distinct(String field, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.putIfNotNull("field", field);
        return execute("cohorts", null, null, null, "distinct", params, GET, Object.class);
    }

    /**
     * Create a cohort based on a sample query.
     * @param data JSON containing cohort information.
     * @param params Map containing any of the following optional parameters.
     *       include: Fields included in the response, whole JSON path must be provided.
     *       exclude: Fields excluded in the response, whole JSON path must be provided.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     *       id: Comma separated list sample IDs or UUIDs up to a maximum of 100.
     *       somatic: Somatic sample.
     *       individualId: Individual ID or UUID.
     *       fileIds: Comma separated list of file IDs, paths or UUIDs.
     *       creationDate: Creation date. Format: yyyyMMddHHmmss. Examples: >2018, 2017-2018, <201805.
     *       modificationDate: Modification date. Format: yyyyMMddHHmmss. Examples: >2018, 2017-2018, <201805.
     *       internalStatus: Filter by internal status.
     *       status: Filter by status.
     *       phenotypes: Comma separated list of phenotype ids or names.
     *       annotation: Annotation filters. Example: age>30;gender=FEMALE. For more information, please visit
     *            http://docs.opencb.org/display/opencga/AnnotationSets+1.4.0.
     *       acl: Filter entries for which a user has the provided permissions. Format: acl={user}:{permissions}. Example:
     *            acl=john:WRITE,WRITE_ANNOTATIONS will return all entries for which user john has both WRITE and WRITE_ANNOTATIONS
     *            permissions. Only study owners or administrators can query by this field. .
     *       release: Release when it was created.
     *       snapshot: Snapshot value (Latest version of the entry in the specified release).
     *       includeResult: Flag indicating to include the created or updated document result in the response.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Cohort> generate(CohortGenerateParams data, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.put("body", data);
        return execute("cohorts", null, null, null, "generate", params, POST, Cohort.class);
    }

    /**
     * Search cohorts.
     * @param params Map containing any of the following optional parameters.
     *       include: Fields included in the response, whole JSON path must be provided.
     *       exclude: Fields excluded in the response, whole JSON path must be provided.
     *       limit: Number of results to be returned.
     *       skip: Number of results to skip.
     *       count: Get the total number of results matching the query. Deactivated by default.
     *       flattenAnnotations: Flatten the annotations?.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     *       id: Comma separated list of cohort IDs up to a maximum of 100.
     *       name: Comma separated list of cohort names up to a maximum of 100.
     *       uuid: Comma separated list of cohort IDs up to a maximum of 100.
     *       type: Cohort type.
     *       creationDate: creationDate.
     *       modificationDate: modificationDate.
     *       deleted: deleted.
     *       status: status.
     *       internalStatus: internalStatus.
     *       annotation: Cohort annotation.
     *       acl: acl.
     *       samples: Cohort sample IDs.
     *       numSamples: Number of samples.
     *       release: release.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Cohort> search(ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        return execute("cohorts", null, null, null, "search", params, GET, Cohort.class);
    }

    /**
     * Return the acl of the cohort. If member is provided, it will only return the acl for the member.
     * @param cohorts Comma separated list of cohort IDs or UUIDs up to a maximum of 100.
     * @param params Map containing any of the following optional parameters.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     *       member: User or group id.
     *       silent: Boolean to retrieve all possible entries that are queried for, false to raise an exception whenever one of the entries
     *            looked for cannot be shown for whichever reason.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<ObjectMap> acl(String cohorts, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        return execute("cohorts", cohorts, null, null, "acl", params, GET, ObjectMap.class);
    }

    /**
     * Delete cohorts.
     * @param cohorts Comma separated list of cohort ids.
     * @param params Map containing any of the following optional parameters.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Cohort> delete(String cohorts, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        return execute("cohorts", cohorts, null, null, "delete", params, DELETE, Cohort.class);
    }

    /**
     * Get cohort information.
     * @param cohorts Comma separated list of cohort IDs or UUIDs up to a maximum of 100.
     * @param params Map containing any of the following optional parameters.
     *       include: Fields included in the response, whole JSON path must be provided.
     *       exclude: Fields excluded in the response, whole JSON path must be provided.
     *       flattenAnnotations: Flatten the annotations?.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     *       deleted: Boolean to retrieve deleted cohorts.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Cohort> info(String cohorts, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        return execute("cohorts", cohorts, null, null, "info", params, GET, Cohort.class);
    }

    /**
     * Update some cohort attributes.
     * @param cohorts Comma separated list of cohort ids.
     * @param data body.
     * @param params Map containing any of the following optional parameters.
     *       include: Fields included in the response, whole JSON path must be provided.
     *       exclude: Fields excluded in the response, whole JSON path must be provided.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     *       samplesAction: Action to be performed if the array of samples is being updated.
     *       annotationSetsAction: Action to be performed if the array of annotationSets is being updated.
     *       includeResult: Flag indicating to include the created or updated document result in the response.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Cohort> update(String cohorts, CohortUpdateParams data, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.put("body", data);
        return execute("cohorts", cohorts, null, null, "update", params, POST, Cohort.class);
    }

    /**
     * Update annotations from an annotationSet.
     * @param cohort Cohort ID.
     * @param annotationSet AnnotationSet ID to be updated.
     * @param data Json containing the map of annotations when the action is ADD, SET or REPLACE, a json with only the key 'remove'
     *     containing the comma separated variables to be removed as a value when the action is REMOVE or a json with only the key 'reset'
     *     containing the comma separated variables that will be set to the default value when the action is RESET.
     * @param params Map containing any of the following optional parameters.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     *       action: Action to be performed: ADD to add new annotations; REPLACE to replace the value of an already existing annotation;
     *            SET to set the new list of annotations removing any possible old annotations; REMOVE to remove some annotations; RESET to
     *            set some annotations to the default value configured in the corresponding variables of the VariableSet if any.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Cohort> updateAnnotationSetsAnnotations(String cohort, String annotationSet, ObjectMap data, ObjectMap params)
            throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.put("body", data);
        return execute("cohorts", cohort, "annotationSets", annotationSet, "annotations/update", params, POST, Cohort.class);
    }
}
