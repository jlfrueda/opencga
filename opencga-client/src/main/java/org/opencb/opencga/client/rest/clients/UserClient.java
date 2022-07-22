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

import org.opencb.commons.datastore.core.ObjectMap;
import org.opencb.opencga.client.config.ClientConfiguration;
import org.opencb.opencga.client.exceptions.ClientException;
import org.opencb.opencga.client.rest.AbstractParentClient;
import org.opencb.opencga.core.models.project.Project;
import org.opencb.opencga.core.models.user.AuthenticationResponse;
import org.opencb.opencga.core.models.user.ConfigUpdateParams;
import org.opencb.opencga.core.models.user.FilterUpdateParams;
import org.opencb.opencga.core.models.user.LoginParams;
import org.opencb.opencga.core.models.user.PasswordChangeParams;
import org.opencb.opencga.core.models.user.User;
import org.opencb.opencga.core.models.user.UserCreateParams;
import org.opencb.opencga.core.models.user.UserFilter;
import org.opencb.opencga.core.models.user.UserUpdateParams;
import org.opencb.opencga.core.response.RestResponse;


/*
* WARNING: AUTOGENERATED CODE
*
* This code was generated by a tool.
* Autogenerated on: 2022-07-23 01:54:28
*
* Manual changes to this file may cause unexpected behavior in your application.
* Manual changes to this file will be overwritten if the code is regenerated.
*/


/**
 * This class contains methods for the User webservices.
 *    Client version: 2.3.2-SNAPSHOT [8e3606fb5be50e996f38cba5d3108bb31a7e1534]
 *    PATH: users
 */
public class UserClient extends AbstractParentClient {

    public UserClient(String token, ClientConfiguration configuration) {
        super(token, configuration);
    }

    /**
     * Create a new user.
     * @param data JSON containing the parameters.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<User> create(UserCreateParams data) throws ClientException {
        ObjectMap params = new ObjectMap();
        params.put("body", data);
        return execute("users", null, null, null, "create", params, POST, User.class);
    }

    /**
     * Get identified and gain access to the system.
     * @param data JSON containing the authentication parameters.
     * @param params Map containing any of the following optional parameters.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<AuthenticationResponse> login(LoginParams data, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.put("body", data);
        return execute("users", null, null, null, "login", params, POST, AuthenticationResponse.class);
    }

    /**
     * Change the password of a user.
     * @param data JSON containing the change of password parameters.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<User> password(PasswordChangeParams data) throws ClientException {
        ObjectMap params = new ObjectMap();
        params.put("body", data);
        return execute("users", null, null, null, "password", params, POST, User.class);
    }

    /**
     * Return the user information including its projects and studies.
     * @param users Comma separated list of user IDs.
     * @param params Map containing any of the following optional parameters.
     *       include: Fields included in the response, whole JSON path must be provided.
     *       exclude: Fields excluded in the response, whole JSON path must be provided.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<User> info(String users, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        return execute("users", users, null, null, "info", params, GET, User.class);
    }

    /**
     * Fetch a user configuration.
     * @param user User ID.
     * @param params Map containing any of the following optional parameters.
     *       name: Unique name (typically the name of the application).
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<ObjectMap> configs(String user, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        return execute("users", user, null, null, "configs", params, GET, ObjectMap.class);
    }

    /**
     * Add or remove a custom user configuration.
     * @param user User ID.
     * @param data JSON containing anything useful for the application such as user or default preferences. When removing, only the id will
     *     be necessary.
     * @param params Map containing any of the following optional parameters.
     *       action: Action to be performed: ADD or REMOVE a group.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<ObjectMap> updateConfigs(String user, ConfigUpdateParams data, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.put("body", data);
        return execute("users", user, "configs", null, "update", params, POST, ObjectMap.class);
    }

    /**
     * Fetch user filters.
     * @param user User ID.
     * @param params Map containing any of the following optional parameters.
     *       id: Filter id. If provided, it will only fetch the specified filter.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<UserFilter> filters(String user, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        return execute("users", user, null, null, "filters", params, GET, UserFilter.class);
    }

    /**
     * Add or remove a custom user filter.
     * @param user User ID.
     * @param data Filter parameters. When removing, only the 'name' of the filter will be necessary.
     * @param params Map containing any of the following optional parameters.
     *       action: Action to be performed: ADD or REMOVE a group.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<UserFilter> updateFilters(String user, UserFilter data, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.put("body", data);
        return execute("users", user, "filters", null, "update", params, POST, UserFilter.class);
    }

    /**
     * Update a custom filter.
     * @param user User ID.
     * @param filterId Filter id.
     * @param data Filter parameters.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<UserFilter> updateFilter(String user, String filterId, FilterUpdateParams data) throws ClientException {
        ObjectMap params = new ObjectMap();
        params.put("body", data);
        return execute("users", user, "filters", filterId, "update", params, POST, UserFilter.class);
    }

    /**
     * Reset password.
     * @param user User ID.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<User> resetPassword(String user) throws ClientException {
        ObjectMap params = new ObjectMap();
        return execute("users", user, "password", null, "reset", params, GET, User.class);
    }

    /**
     * Retrieve the projects of the user.
     * @param user User ID.
     * @param params Map containing any of the following optional parameters.
     *       include: Fields included in the response, whole JSON path must be provided.
     *       exclude: Fields excluded in the response, whole JSON path must be provided.
     *       limit: Number of results to be returned.
     *       skip: Number of results to skip.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<Project> projects(String user, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        return execute("users", user, null, null, "projects", params, GET, Project.class);
    }

    /**
     * Update some user attributes.
     * @param user User ID.
     * @param data JSON containing the params to be updated.
     * @param params Map containing any of the following optional parameters.
     *       include: Fields included in the response, whole JSON path must be provided.
     *       exclude: Fields excluded in the response, whole JSON path must be provided.
     *       includeResult: Flag indicating to include the created or updated document result in the response.
     * @return a RestResponse object.
     * @throws ClientException ClientException if there is any server error.
     */
    public RestResponse<User> update(String user, UserUpdateParams data, ObjectMap params) throws ClientException {
        params = params != null ? params : new ObjectMap();
        params.put("body", data);
        return execute("users", user, null, null, "update", params, POST, User.class);
    }
}
