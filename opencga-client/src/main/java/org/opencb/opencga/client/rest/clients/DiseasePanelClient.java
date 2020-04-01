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

import org.opencb.commons.datastore.core.ObjectMap;
import org.opencb.opencga.client.config.ClientConfiguration;
import org.opencb.opencga.client.exceptions.ClientException;
import org.opencb.opencga.client.rest.AbstractParentClient;
import org.opencb.opencga.core.models.panel.Panel;
import org.opencb.opencga.core.models.panel.PanelAclUpdateParams;
import org.opencb.opencga.core.models.panel.PanelCreateParams;
import org.opencb.opencga.core.models.panel.PanelUpdateParams;
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
 * This class contains methods for the DiseasePanel webservices.
 *    Client version: 2.0.0
 *    PATH: panels
 */
public class DiseasePanelClient extends AbstractParentClient {

    public DiseasePanelClient(String token, ClientConfiguration configuration) {
        super(token, configuration);
    }

    /**
     * Update the set of permissions granted for the member.
     * @param members Comma separated list of user or group ids.
     * @param data JSON containing the parameters to update the permissions.
     * @param params Map containing any of the following optional parameters.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<ObjectMap> updateAcl(String members, PanelAclUpdateParams data, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.put("body", data);
        return execute("panels", members, null, null, "update", params, POST, ObjectMap.class);
    }

    /**
     * Create a panel.
     * @param data Panel parameters.
     * @param params Map containing any of the following optional parameters.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     *       import: Comma separated list of installation panel ids to be imported. To import them all at once, write the special word
     *            'ALL_GLOBAL_PANELS'.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Panel> create(PanelCreateParams data, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.put("body", data);
        return execute("panels", null, null, null, "create", params, POST, Panel.class);
    }

    /**
     * Panel search.
     * @param params Map containing any of the following optional parameters.
     *       include: Fields included in the response, whole JSON path must be provided.
     *       exclude: Fields excluded in the response, whole JSON path must be provided.
     *       limit: Number of results to be returned.
     *       skip: Number of results to skip.
     *       count: Get the total number of results matching the query. Deactivated by default.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     *       name: Panel name.
     *       phenotypes: Panel phenotypes.
     *       variants: Panel variants.
     *       genes: Panel genes.
     *       regions: Panel regions.
     *       categories: Panel categories.
     *       tags: Panel tags.
     *       description: Panel description.
     *       author: Panel author.
     *       deleted: Boolean to retrieve deleted panels.
     *       creationDate: Creation date. Format: yyyyMMddHHmmss. Examples: >2018, 2017-2018, <201805.
     *       modificationDate: Modification date. Format: yyyyMMddHHmmss. Examples: >2018, 2017-2018, <201805.
     *       acl: Filter entries for which a user has the provided permissions. Format: acl={user}:{permissions}. Example:
     *            acl=john:WRITE,WRITE_ANNOTATIONS will return all entries for which user john has both WRITE and WRITE_ANNOTATIONS
     *            permissions. Only study owners or administrators can query by this field. .
     *       global: Boolean indicating which panels are queried (installation or study specific panels).
     *       release: Release value (Current release from the moment the samples were first created).
     *       snapshot: Snapshot value (Latest version of samples in the specified release).
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Panel> search(ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        return execute("panels", null, null, null, "search", params, GET, Panel.class);
    }

    /**
     * Returns the acl of the panels. If member is provided, it will only return the acl for the member.
     * @param panels Comma separated list of panel ids up to a maximum of 100.
     * @param params Map containing any of the following optional parameters.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     *       member: User or group id.
     *       silent: Boolean to retrieve all possible entries that are queried for, false to raise an exception whenever one of the entries
     *            looked for cannot be shown for whichever reason.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<ObjectMap> acl(String panels, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        return execute("panels", panels, null, null, "acl", params, GET, ObjectMap.class);
    }

    /**
     * Delete existing panels.
     * @param panels Comma separated list of panel ids.
     * @param params Map containing any of the following optional parameters.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     *       panels: Comma separated list of panel ids.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Panel> delete(String panels, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        return execute("panels", panels, null, null, "delete", params, DELETE, Panel.class);
    }

    /**
     * Panel info.
     * @param panels Comma separated list of panel ids up to a maximum of 100.
     * @param params Map containing any of the following optional parameters.
     *       include: Fields included in the response, whole JSON path must be provided.
     *       exclude: Fields excluded in the response, whole JSON path must be provided.
     *       panels: Comma separated list of panel ids up to a maximum of 100.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     *       version: Panel  version.
     *       deleted: Boolean to retrieve deleted panels.
     *       global: Boolean indicating which panels are queried (installation or study specific panels).
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Panel> info(String panels, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        return execute("panels", panels, null, null, "info", params, GET, Panel.class);
    }

    /**
     * Update panel attributes.
     * @param panels Comma separated list of panel ids.
     * @param data Panel parameters.
     * @param params Map containing any of the following optional parameters.
     *       study: Study [[user@]project:]study where study and project can be either the ID or UUID.
     *       panels: Comma separated list of panel ids.
     *       incVersion: Create a new version of panel.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Panel> update(String panels, PanelUpdateParams data, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.put("body", data);
        return execute("panels", panels, null, null, "update", params, POST, Panel.class);
    }
}