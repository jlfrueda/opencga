/*
 * Copyright 2015-2020 OpenCB
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
import org.opencb.opencga.core.models.common.TsvAnnotationParams;
import org.opencb.opencga.core.models.individual.Individual;
import org.opencb.opencga.core.models.individual.IndividualAclUpdateParams;
import org.opencb.opencga.core.models.individual.IndividualCreateParams;
import org.opencb.opencga.core.models.individual.IndividualUpdateParams;
import org.opencb.opencga.core.models.job.Job;
import org.opencb.opencga.core.response.RestResponse;


/*
* WARNING: AUTOGENERATED CODE
*
* This code was generated by a tool.
* Autogenerated on: 2020-03-24 10:22:13
*
* Manual changes to this file may cause unexpected behavior in your application.
* Manual changes to this file will be overwritten if the code is regenerated.
*/


/**
 * This class contains methods for the Individual webservices.
 *    Client version: 2.0.0
 *    PATH: individuals
 */
public class IndividualClient extends AbstractParentClient {

    public IndividualClient(String token, ClientConfiguration configuration) {
        super(token, configuration);
    }

    /**
     * Update the set of permissions granted for the member.
     * @param members Comma separated list of user or group ids.
     * @param data JSON containing the parameters to update the permissions. If propagate flag is set to true, it will propagate the
     *     permissions defined to the samples that are associated to the matching individuals.
     * @param params Map containing any of the following optional parameters.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<ObjectMap> updateAcl(String members, IndividualAclUpdateParams data, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.put("body", data);
        return execute("individuals", members, null, null, "update", params, POST, ObjectMap.class);
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
     *       affectationStatus: Affectation status.
     *       phenotypes: Phenotypes.
     *       numSamples: Number of samples.
     *       parentalConsanguinity: Parental consanguinity.
     *       release: Release.
     *       version: Version.
     *       annotation: Annotation, e.g: key1=value(,key2=value).
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
     * @param variableSetId Variable set id or name.
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
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     *       samples: Comma separated list of sample ids to be associated to the created individual.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Individual> create(IndividualCreateParams data, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.put("body", data);
        return execute("individuals", null, null, null, "create", params, POST, Individual.class);
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
     *       study: Study [[user@]project:]study where study and project can be either the id or alias.
     *       name: name.
     *       father: father.
     *       mother: mother.
     *       samples: Comma separated list sample IDs or UUIDs up to a maximum of 100.
     *       sex: sex.
     *       ethnicity: ethnicity.
     *       disorders: Comma separated list of disorder ids or names.
     *       population.name: Population name.
     *       population.subpopulation: Subpopulation name.
     *       population.description: Population description.
     *       phenotypes: Comma separated list of phenotype ids or names.
     *       karyotypicSex: Karyotypic sex.
     *       lifeStatus: Life status.
     *       affectationStatus: Affectation status.
     *       deleted: Boolean to retrieve deleted individuals.
     *       creationDate: Creation date. Format: yyyyMMddHHmmss. Examples: >2018, 2017-2018, <201805.
     *       modificationDate: Modification date. Format: yyyyMMddHHmmss. Examples: >2018, 2017-2018, <201805.
     *       annotationsetName: DEPRECATED: Use annotation queryParam this way: annotationSet[=|==|!|!=]{annotationSetName}.
     *       variableSet: DEPRECATED: Use annotation queryParam this way: variableSet[=|==|!|!=]{variableSetId}.
     *       annotation: Annotation, e.g: key1=value(,key2=value).
     *       acl: Filter entries for which a user has the provided permissions. Format: acl={user}:{permissions}. Example:
     *            acl=john:WRITE,WRITE_ANNOTATIONS will return all entries for which user john has both WRITE and WRITE_ANNOTATIONS
     *            permissions. Only study owners or administrators can query by this field. .
     *       release: Release value (Current release from the moment the individuals were first created).
     *       snapshot: Snapshot value (Latest version of individuals in the specified release).
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Individual> search(ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        return execute("individuals", null, null, null, "search", params, GET, Individual.class);
    }

    /**
     * Return the acl of the individual. If member is provided, it will only return the acl for the member.
     * @param individuals Comma separated list of individual names or ids up to a maximum of 100.
     * @param params Map containing any of the following optional parameters.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     *       member: User or group id.
     *       silent: Boolean to retrieve all possible entries that are queried for, false to raise an exception whenever one of the entries
     *            looked for cannot be shown for whichever reason.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<ObjectMap> acl(String individuals, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        return execute("individuals", individuals, null, null, "acl", params, GET, ObjectMap.class);
    }

    /**
     * Delete existing individuals.
     * @param individuals Comma separated list of individual ids.
     * @param params Map containing any of the following optional parameters.
     *       force: Force the deletion of individuals that already belong to families.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     *       individuals: Comma separated list of individual ids.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Individual> delete(String individuals, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        return execute("individuals", individuals, null, null, "delete", params, DELETE, Individual.class);
    }

    /**
     * Get individual information.
     * @param individuals Comma separated list of individual names or ids up to a maximum of 100.
     * @param params Map containing any of the following optional parameters.
     *       include: Fields included in the response, whole JSON path must be provided.
     *       exclude: Fields excluded in the response, whole JSON path must be provided.
     *       flattenAnnotations: Flatten the annotations?.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     *       version: Individual version.
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
     * @param data params.
     * @param params Map containing any of the following optional parameters.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     *       samplesAction: Action to be performed if the array of samples is being updated.
     *       annotationSetsAction: Action to be performed if the array of annotationSets is being updated.
     *       incVersion: Create a new version of individual.
     *       updateSampleVersion: Update all the sample references from the individual to point to their latest versions.
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
     * @param individual Individual ID or UUID.
     * @param annotationSet AnnotationSet id to be updated.
     * @param data Json containing the map of annotations when the action is ADD, SET or REPLACE, a json with only the key 'remove'
     *     containing the comma separated variables to be removed as a value when the action is REMOVE or a json with only the key 'reset'
     *     containing the comma separated variables that will be set to the default value when the action is RESET.
     * @param params Map containing any of the following optional parameters.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     *       annotationSet: AnnotationSet id to be updated.
     *       action: Action to be performed: ADD to add new annotations; REPLACE to replace the value of an already existing annotation;
     *            SET to set the new list of annotations removing any possible old annotations; REMOVE to remove some annotations; RESET to
     *            set some annotations to the default value configured in the corresponding variables of the VariableSet if any.
     *       incVersion: Create a new version of individual.
     *       updateSampleVersion: Update all the sample references from the individual to point to their latest versions.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Individual> updateAnnotations(String individual, String annotationSet, ObjectMap data, ObjectMap params)
            throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.put("body", data);
        return execute("individuals", individual, "annotationSets", annotationSet, "annotations/update", params, POST, Individual.class);
    }

    /**
     * Get individual relatives.
     * @param individual Individual ID or UUID.
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
