/*
* Copyright 2015-2023 OpenCB
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
import org.opencb.opencga.client.rest.*;
import org.opencb.opencga.core.models.common.TsvAnnotationParams;
import org.opencb.opencga.core.models.individual.Individual;
import org.opencb.opencga.core.models.individual.IndividualAclEntryList;
import org.opencb.opencga.core.models.individual.IndividualAclUpdateParams;
import org.opencb.opencga.core.models.individual.IndividualCreateParams;
import org.opencb.opencga.core.models.individual.IndividualUpdateParams;
import org.opencb.opencga.core.models.job.Job;
import org.opencb.opencga.core.response.RestResponse;


/*
* WARNING: AUTOGENERATED CODE
*
* This code was generated by a tool.
* Autogenerated on: 2023-03-21
*
* Manual changes to this file may cause unexpected behavior in your application.
* Manual changes to this file will be overwritten if the code is regenerated.
*/


/**
 * This class contains methods for the Individual webservices.
 *    Client version: 2.8.0-SNAPSHOT
 *    PATH: individuals
 */
public class IndividualClient extends AbstractParentClient {

    public IndividualClient(String token, ClientConfiguration configuration) {
        super(token, configuration);
    }

    /**
     * Update the set of permissions granted for the member.
     * @param members Comma separated list of user or group ids.
     * @param action Action to be performed [ADD, SET, REMOVE or RESET].
     * @param data JSON containing the parameters to update the permissions. If propagate flag is set to true, it will propagate the
     *     permissions defined to the samples that are associated to the matching individuals.
     * @param params Map containing any of the following optional parameters.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     *       propagate: Propagate individual permissions to related samples.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<IndividualAclEntryList> updateAcl(String members, String action, IndividualAclUpdateParams data, ObjectMap params)
            throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.putIfNotNull("action", action);
        params.put("body", data);
        return execute("individuals", null, "acl", members, "update", params, POST, IndividualAclEntryList.class);
    }

    /**
     * Fetch catalog individual stats.
     * @param params Map containing any of the following optional parameters.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     *       hasFather: Has father.
     *       hasMother: Has mother.
     *       sex: Sex.
     *       karyotypicSex: Karyotypic sex.
     *       ethnicity: Ethnicity.
     *       population: Population.
     *       creationYear: Creation year.
     *       creationMonth: Creation month (JANUARY, FEBRUARY...).
     *       creationDay: Creation day.
     *       creationDayOfWeek: Creation day of week (MONDAY, TUESDAY...).
     *       status: Status.
     *       lifeStatus: Life status.
     *       phenotypes: Phenotypes.
     *       numSamples: Number of samples.
     *       parentalConsanguinity: Parental consanguinity.
     *       release: Release.
     *       version: Version.
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
        return execute("individuals", null, null, null, "aggregationStats", params, GET, FacetField.class);
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
        return execute("individuals", null, "annotationSets", null, "load", params, POST, Job.class);
    }

    /**
     * Create individual.
     * @param data JSON containing individual information.
     * @param params Map containing any of the following optional parameters.
     *       include: Fields included in the response, whole JSON path must be provided.
     *       exclude: Fields excluded in the response, whole JSON path must be provided.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     *       samples: Comma separated list of sample ids to be associated to the created individual.
     *       includeResult: Flag indicating to include the created or updated document result in the response.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Individual> create(IndividualCreateParams data, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.put("body", data);
        return execute("individuals", null, null, null, "create", params, POST, Individual.class);
    }

    /**
     * Individual distinct method.
     * @param field Comma separated list of fields for which to obtain the distinct values.
     * @param params Map containing any of the following optional parameters.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     *       id: Comma separated list individual IDs up to a maximum of 100.
     *       uuid: Comma separated list individual UUIDs up to a maximum of 100.
     *       name: Comma separated list individual names up to a maximum of 100.
     *       familyIds: Comma separated list of family ids the individuals may belong to.
     *       father: Father ID, name or UUID.
     *       mother: Mother ID, name or UUID.
     *       samples: Sample ID, name or UUID.
     *       sex: Individual sex.
     *       ethnicity: Individual ethnicity.
     *       dateOfBirth: Individual date of birth.
     *       disorders: Comma separated list of disorder ids or names.
     *       phenotypes: Comma separated list of phenotype ids or names.
     *       populationName: Population name.
     *       populationSubpopulation: Subpopulation name.
     *       karyotypicSex: Individual karyotypic sex.
     *       lifeStatus: Individual life status.
     *       internalStatus: Filter by internal status.
     *       status: Filter by status.
     *       deleted: Boolean to retrieve deleted entries.
     *       creationDate: Creation date. Format: yyyyMMddHHmmss. Examples: >2018, 2017-2018, <201805.
     *       modificationDate: Modification date. Format: yyyyMMddHHmmss. Examples: >2018, 2017-2018, <201805.
     *       annotation: Annotation filters. Example: age>30;gender=FEMALE. For more information, please visit
     *            http://docs.opencb.org/display/opencga/AnnotationSets+1.4.0.
     *       acl: Filter entries for which a user has the provided permissions. Format: acl={user}:{permissions}. Example:
     *            acl=john:WRITE,WRITE_ANNOTATIONS will return all entries for which user john has both WRITE and WRITE_ANNOTATIONS
     *            permissions. Only study owners or administrators can query by this field. .
     *       release: Release when it was created.
     *       snapshot: Snapshot value (Latest version of the entry in the specified release).
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Object> distinct(String field, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.putIfNotNull("field", field);
        return execute("individuals", null, null, null, "distinct", params, GET, Object.class);
    }

    /**
     * Search for individuals.
     * @param params Map containing any of the following optional parameters.
     *       include: Fields included in the response, whole JSON path must be provided.
     *       exclude: Fields excluded in the response, whole JSON path must be provided.
     *       limit: Number of results to be returned.
     *       skip: Number of results to skip.
     *       count: Get the total number of results matching the query. Deactivated by default.
     *       flattenAnnotations: Flatten the annotations?.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     *       id: Comma separated list individual IDs up to a maximum of 100.
     *       uuid: Comma separated list individual UUIDs up to a maximum of 100.
     *       name: Comma separated list individual names up to a maximum of 100.
     *       father: Father ID, name or UUID.
     *       mother: Mother ID, name or UUID.
     *       samples: Sample ID, name or UUID.
     *       familyIds: Comma separated list of family ids the individuals may belong to.
     *       sex: Individual sex.
     *       dateOfBirth: Individual date of birth.
     *       ethnicity: Individual ethnicity.
     *       disorders: Comma separated list of disorder ids or names.
     *       phenotypes: Comma separated list of phenotype ids or names.
     *       populationName: Population name.
     *       populationSubpopulation: Subpopulation name.
     *       karyotypicSex: Individual karyotypic sex.
     *       lifeStatus: Individual life status.
     *       internalStatus: Filter by internal status.
     *       status: Filter by status.
     *       deleted: Boolean to retrieve deleted entries.
     *       creationDate: Creation date. Format: yyyyMMddHHmmss. Examples: >2018, 2017-2018, <201805.
     *       modificationDate: Modification date. Format: yyyyMMddHHmmss. Examples: >2018, 2017-2018, <201805.
     *       annotation: Annotation filters. Example: age>30;gender=FEMALE. For more information, please visit
     *            http://docs.opencb.org/display/opencga/AnnotationSets+1.4.0.
     *       acl: Filter entries for which a user has the provided permissions. Format: acl={user}:{permissions}. Example:
     *            acl=john:WRITE,WRITE_ANNOTATIONS will return all entries for which user john has both WRITE and WRITE_ANNOTATIONS
     *            permissions. Only study owners or administrators can query by this field. .
     *       release: Release when it was created.
     *       snapshot: Snapshot value (Latest version of the entry in the specified release).
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Individual> search(ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        return execute("individuals", null, null, null, "search", params, GET, Individual.class);
    }

    /**
     * Return the acl of the individual. If member is provided, it will only return the acl for the member.
     * @param individuals Comma separated list of individual IDs, names or UUIDs up to a maximum of 100.
     * @param params Map containing any of the following optional parameters.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     *       member: User or group id.
     *       silent: Boolean to retrieve all possible entries that are queried for, false to raise an exception whenever one of the entries
     *            looked for cannot be shown for whichever reason.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<IndividualAclEntryList> acl(String individuals, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        return execute("individuals", individuals, null, null, "acl", params, GET, IndividualAclEntryList.class);
    }

    /**
     * Delete existing individuals.
     * @param individuals Comma separated list of individual ids.
     * @param params Map containing any of the following optional parameters.
     *       force: Force the deletion of individuals that already belong to families.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Individual> delete(String individuals, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        return execute("individuals", individuals, null, null, "delete", params, DELETE, Individual.class);
    }

    /**
     * Get individual information.
     * @param individuals Comma separated list of individual IDs, names or UUIDs up to a maximum of 100.
     * @param params Map containing any of the following optional parameters.
     *       include: Fields included in the response, whole JSON path must be provided.
     *       exclude: Fields excluded in the response, whole JSON path must be provided.
     *       flattenAnnotations: Flatten the annotations?.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     *       version: Comma separated list of individual versions. 'all' to get all the individual versions. Not supported if multiple
     *            individual ids are provided.
     *       deleted: Boolean to retrieve deleted individuals.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Individual> info(String individuals, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        return execute("individuals", individuals, null, null, "info", params, GET, Individual.class);
    }

    /**
     * Update some individual attributes.
     * @param individuals Comma separated list of individual ids.
     * @param data body.
     * @param params Map containing any of the following optional parameters.
     *       include: Fields included in the response, whole JSON path must be provided.
     *       exclude: Fields excluded in the response, whole JSON path must be provided.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     *       samplesAction: Action to be performed if the array of samples is being updated.
     *       phenotypesAction: Action to be performed if the array of phenotypes is being updated [SET, ADD, REMOVE].
     *       disordersAction: Action to be performed if the array of disorders is being updated [SET, ADD, REMOVE].
     *       annotationSetsAction: Action to be performed if the array of annotationSets is being updated.
     *       includeResult: Flag indicating to include the created or updated document result in the response.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Individual> update(String individuals, IndividualUpdateParams data, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.put("body", data);
        return execute("individuals", individuals, null, null, "update", params, POST, Individual.class);
    }

    /**
     * Update annotations from an annotationSet.
     * @param individual Individual ID, name or UUID.
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
    public RestResponse<Individual> updateAnnotationSetsAnnotations(String individual, String annotationSet, ObjectMap data, ObjectMap
        params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.put("body", data);
        return execute("individuals", individual, "annotationSets", annotationSet, "annotations/update", params, POST, Individual.class);
    }

    /**
     * Get individual relatives.
     * @param individual Individual ID, name or UUID.
     * @param params Map containing any of the following optional parameters.
     *       include: Fields included in the response, whole JSON path must be provided.
     *       exclude: Fields excluded in the response, whole JSON path must be provided.
     *       flattenAnnotations: Flatten the annotations?.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     *       degree: Pedigree degree.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Individual> relatives(String individual, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        return execute("individuals", individual, null, null, "relatives", params, GET, Individual.class);
    }
}
