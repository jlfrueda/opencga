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

import org.opencb.commons.datastore.core.FacetField;
import org.opencb.commons.datastore.core.ObjectMap;
import org.opencb.opencga.client.config.ClientConfiguration;
import org.opencb.opencga.client.exceptions.ClientException;
import org.opencb.opencga.client.rest.AbstractParentClient;
import org.opencb.opencga.core.models.audit.AuditRecord;
import org.opencb.opencga.core.models.job.Job;
import org.opencb.opencga.core.models.study.CustomGroup;
import org.opencb.opencga.core.models.study.Group;
import org.opencb.opencga.core.models.study.GroupCreateParams;
import org.opencb.opencga.core.models.study.GroupUpdateParams;
import org.opencb.opencga.core.models.study.PermissionRule;
import org.opencb.opencga.core.models.study.Study;
import org.opencb.opencga.core.models.study.StudyAclUpdateParams;
import org.opencb.opencga.core.models.study.StudyCreateParams;
import org.opencb.opencga.core.models.study.StudyUpdateParams;
import org.opencb.opencga.core.models.study.TemplateParams;
import org.opencb.opencga.core.models.study.Variable;
import org.opencb.opencga.core.models.study.VariableSet;
import org.opencb.opencga.core.models.study.VariableSetCreateParams;
import org.opencb.opencga.core.response.RestResponse;


/*
* WARNING: AUTOGENERATED CODE
*
* This code was generated by a tool.
* Autogenerated on: 2022-07-21 17:34:32
*
* Manual changes to this file may cause unexpected behavior in your application.
* Manual changes to this file will be overwritten if the code is regenerated.
*/


/**
 * This class contains methods for the Study webservices.
 *    Client version: 2.5.0-SNAPSHOT [c5fb03e91d896a03274501a5eea3a08f70f367e1]
 *    PATH: studies
 */
public class StudyClient extends AbstractParentClient {

    public StudyClient(String token, ClientConfiguration configuration) {
        super(token, configuration);
    }

    /**
     * Update the set of permissions granted for the member.
     * @param members Comma separated list of user or group ids.
     * @param action Action to be performed [ADD, SET, REMOVE or RESET].
     * @param data JSON containing the parameters to modify ACLs. 'template' could be either 'admin', 'analyst' or 'view_only'.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<ObjectMap> updateAcl(String members, String action, StudyAclUpdateParams data) throws ClientException {
        ObjectMap params = new ObjectMap();
        params.putIfNotNull("action", action);
        params.put("body", data);
        return execute("studies", null, "acl", members, "update", params, POST, ObjectMap.class);
    }

    /**
     * Create a new study.
     * @param data study.
     * @param params Map containing any of the following optional parameters.
     *       include: Fields included in the response, whole JSON path must be provided.
     *       exclude: Fields excluded in the response, whole JSON path must be provided.
     *       project: Project [user@]project where project can be either the ID or the alias.
     *       includeResult: Flag indicating to include the created or updated document result in the response.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Study> create(StudyCreateParams data, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.put("body", data);
        return execute("studies", null, null, null, "create", params, POST, Study.class);
    }

    /**
     * Search studies.
     * @param project Project [user@]project where project can be either the ID or the alias.
     * @param params Map containing any of the following optional parameters.
     *       include: Fields included in the response, whole JSON path must be provided.
     *       exclude: Fields excluded in the response, whole JSON path must be provided.
     *       limit: Number of results to be returned.
     *       skip: Number of results to skip.
     *       count: Get the total number of results matching the query. Deactivated by default.
     *       name: Study name.
     *       id: Study ID.
     *       alias: Study alias.
     *       fqn: Study full qualified name.
     *       creationDate: Creation date. Format: yyyyMMddHHmmss. Examples: >2018, 2017-2018, <201805.
     *       modificationDate: Modification date. Format: yyyyMMddHHmmss. Examples: >2018, 2017-2018, <201805.
     *       internalStatus: Filter by internal status.
     *       status: Filter by status.
     *       attributes: Attributes.
     *       release: Release value.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Study> search(String project, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.putIfNotNull("project", project);
        return execute("studies", null, null, null, "search", params, GET, Study.class);
    }

    /**
     * Return the acl of the study. If member is provided, it will only return the acl for the member.
     * @param studies Comma separated list of Studies [[user@]project:]study where study and project can be either the ID or UUID up to a
     *     maximum of 100.
     * @param params Map containing any of the following optional parameters.
     *       member: User or group id.
     *       silent: Boolean to retrieve all possible entries that are queried for, false to raise an exception whenever one of the entries
     *            looked for cannot be shown for whichever reason.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<ObjectMap> acl(String studies, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        return execute("studies", studies, null, null, "acl", params, GET, ObjectMap.class);
    }

    /**
     * Fetch catalog study stats.
     * @param studies Comma separated list of studies [[user@]project:]study up to a maximum of 100.
     * @param params Map containing any of the following optional parameters.
     *       default: Calculate default stats.
     *       fileFields: List of file fields separated by semicolons, e.g.: studies;type. For nested fields use >>, e.g.:
     *            studies>>biotype;type.
     *       individualFields: List of individual fields separated by semicolons, e.g.: studies;type. For nested fields use >>, e.g.:
     *            studies>>biotype;type.
     *       familyFields: List of family fields separated by semicolons, e.g.: studies;type. For nested fields use >>, e.g.:
     *            studies>>biotype;type.
     *       sampleFields: List of sample fields separated by semicolons, e.g.: studies;type. For nested fields use >>, e.g.:
     *            studies>>biotype;type.
     *       cohortFields: List of cohort fields separated by semicolons, e.g.: studies;type. For nested fields use >>, e.g.:
     *            studies>>biotype;type.
     *       jobFields: List of job fields separated by semicolons, e.g.: studies;type. For nested fields use >>, e.g.:
     *            studies>>biotype;type.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<FacetField> aggregationStats(String studies, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        return execute("studies", studies, null, null, "aggregationStats", params, GET, FacetField.class);
    }

    /**
     * Fetch study information.
     * @param studies Comma separated list of Studies [[user@]project:]study where study and project can be either the ID or UUID up to a
     *     maximum of 100.
     * @param params Map containing any of the following optional parameters.
     *       include: Fields included in the response, whole JSON path must be provided.
     *       exclude: Fields excluded in the response, whole JSON path must be provided.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Study> info(String studies, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        return execute("studies", studies, null, null, "info", params, GET, Study.class);
    }

    /**
     * Search audit collection.
     * @param study Study ID.
     * @param params Map containing any of the following optional parameters.
     *       include: Fields included in the response, whole JSON path must be provided.
     *       exclude: Fields excluded in the response, whole JSON path must be provided.
     *       limit: Number of results to be returned.
     *       skip: Number of results to skip.
     *       count: Get the total number of results matching the query. Deactivated by default.
     *       operationId: Audit operation UUID.
     *       userId: User ID.
     *       action: Action performed by the user.
     *       resource: Resource involved.
     *       resourceId: Resource ID.
     *       resourceUuid: resource UUID.
     *       status: Filter by status.
     *       date: Date. Format: yyyyMMddHHmmss. Examples: >2018, 2017-2018, <201805.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<AuditRecord> searchAudit(String study, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        return execute("studies", study, "audit", null, "search", params, GET, AuditRecord.class);
    }

    /**
     * Return the groups present in the study. For owners and administrators only.
     * @param study Study [[user@]project:]study where study and project can be either the ID or UUID.
     * @param params Map containing any of the following optional parameters.
     *       id: Group id. If provided, it will only fetch information for the provided group.
     *       silent: Boolean to retrieve all possible entries that are queried for, false to raise an exception whenever one of the entries
     *            looked for cannot be shown for whichever reason.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<CustomGroup> groups(String study, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        return execute("studies", study, null, null, "groups", params, GET, CustomGroup.class);
    }

    /**
     * Add or remove a group.
     * @param study Study [[user@]project:]study where study and project can be either the ID or UUID.
     * @param data JSON containing the parameters.
     * @param params Map containing any of the following optional parameters.
     *       action: Action to be performed: ADD or REMOVE a group.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Group> updateGroups(String study, GroupCreateParams data, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.put("body", data);
        return execute("studies", study, "groups", null, "update", params, POST, Group.class);
    }

    /**
     * Add, set or remove users from an existing group.
     * @param study Study [[user@]project:]study where study and project can be either the ID or UUID.
     * @param group Group name.
     * @param data JSON containing the parameters.
     * @param params Map containing any of the following optional parameters.
     *       action: Action to be performed: ADD, SET or REMOVE users to/from a group.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Group> updateGroupsUsers(String study, String group, GroupUpdateParams data, ObjectMap params)
            throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.put("body", data);
        return execute("studies", study, "groups", group, "users/update", params, POST, Group.class);
    }

    /**
     * Fetch permission rules.
     * @param study Study [[user@]project:]study where study and project can be either the ID or UUID.
     * @param entity Entity where the permission rules should be applied to.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<PermissionRule> permissionRules(String study, String entity) throws ClientException {
        ObjectMap params = new ObjectMap();
        params.putIfNotNull("entity", entity);
        return execute("studies", study, null, null, "permissionRules", params, GET, PermissionRule.class);
    }

    /**
     * Add or remove a permission rule.
     * @param study Study [[user@]project:]study where study and project can be either the ID or UUID.
     * @param entity Entity where the permission rules should be applied to.
     * @param data JSON containing the permission rule to be created or removed.
     * @param params Map containing any of the following optional parameters.
     *       action: Action to be performed: ADD to add a new permission rule; REMOVE to remove all permissions assigned by an existing
     *            permission rule (even if it overlaps any manual permission); REVERT to remove all permissions assigned by an existing
     *            permission rule (keep manual overlaps); NONE to remove an existing permission rule without removing any permissions that
     *            could have been assigned already by the permission rule.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<PermissionRule> updatePermissionRules(String study, String entity, PermissionRule data, ObjectMap params)
            throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.putIfNotNull("entity", entity);
        params.put("body", data);
        return execute("studies", study, "permissionRules", null, "update", params, POST, PermissionRule.class);
    }

    /**
     * Execute template.
     * @param study Study [[user@]project:]study where study and project can be either the ID or UUID.
     * @param data Template loader parameters.
     * @param params Map containing any of the following optional parameters.
     *       jobId: Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not provided.
     *       jobDependsOn: Comma separated list of existing job IDs the job will depend on.
     *       jobDescription: Job description.
     *       jobTags: Job tags.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Job> runTemplates(String study, TemplateParams data, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.put("body", data);
        return execute("studies", study, "templates", null, "run", params, POST, Job.class);
    }

    /**
     * Resource to upload a zipped template.
     * @param study Study [[user@]project:]study where study and project can be either the ID or UUID.
     * @param params Map containing any of the following optional parameters.
     *       file: File to upload.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<String> uploadTemplates(String study, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        return execute("studies", study, "templates", null, "upload", params, POST, String.class);
    }

    /**
     * Delete template.
     * @param study Study [[user@]project:]study where study and project can be either the ID or UUID.
     * @param templateId Template id.
     * @param params Map containing any of the following optional parameters.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Boolean> deleteTemplates(String study, String templateId, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.putIfNotNull("study", study);
        return execute("studies", study, "templates", templateId, "delete", params, DELETE, Boolean.class);
    }

    /**
     * Update some study attributes.
     * @param study Study [[user@]project:]study where study and project can be either the ID or UUID.
     * @param data JSON containing the params to be updated.
     * @param params Map containing any of the following optional parameters.
     *       include: Fields included in the response, whole JSON path must be provided.
     *       exclude: Fields excluded in the response, whole JSON path must be provided.
     *       includeResult: Flag indicating to include the created or updated document result in the response.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Study> update(String study, StudyUpdateParams data, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.put("body", data);
        return execute("studies", study, null, null, "update", params, POST, Study.class);
    }

    /**
     * Fetch variableSets from a study.
     * @param study Study [[user@]project:]study where study and project can be either the ID or UUID.
     * @param params Map containing any of the following optional parameters.
     *       id: Id of the variableSet to be retrieved. If no id is passed, it will show all the variableSets of the study.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<VariableSet> variableSets(String study, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        return execute("studies", study, null, null, "variableSets", params, GET, VariableSet.class);
    }

    /**
     * Add or remove a variableSet.
     * @param study Study [[user@]project:]study where study and project can be either the ID or UUID.
     * @param data JSON containing the VariableSet to be created or removed.
     * @param params Map containing any of the following optional parameters.
     *       action: Action to be performed: ADD, REMOVE or FORCE_REMOVE a variableSet.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<VariableSet> updateVariableSets(String study, VariableSetCreateParams data, ObjectMap params)
            throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.put("body", data);
        return execute("studies", study, "variableSets", null, "update", params, POST, VariableSet.class);
    }

    /**
     * Add or remove variables to a VariableSet.
     * @param study Study [[user@]project:]study where study and project can be either the ID or UUID.
     * @param variableSet VariableSet id of the VariableSet to be updated.
     * @param data JSON containing the variable to be added or removed. For removing, only the variable id will be needed.
     * @param params Map containing any of the following optional parameters.
     *       action: Action to be performed: ADD or REMOVE a variable.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<VariableSet> updateVariableSetsVariables(String study, String variableSet, Variable data, ObjectMap params)
            throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.put("body", data);
        return execute("studies", study, "variableSets", variableSet, "variables/update", params, POST, VariableSet.class);
    }
}
