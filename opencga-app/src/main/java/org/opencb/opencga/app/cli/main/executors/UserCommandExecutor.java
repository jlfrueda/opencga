/*
* Copyright 2015-2021 OpenCB
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

package org.opencb.opencga.app.cli.main.executors;

import org.opencb.opencga.app.cli.main.executors.OpencgaCommandExecutor;
import org.opencb.opencga.app.cli.main.*;
import org.opencb.opencga.core.response.RestResponse;
import org.opencb.commons.datastore.core.ObjectMap;
import org.opencb.opencga.app.cli.main.options.UserCommandOptions;
import org.opencb.opencga.catalog.utils.ParamUtils.AddRemoveAction;
import org.opencb.opencga.client.exceptions.ClientException;
import org.opencb.opencga.core.models.project.Project;
import org.opencb.opencga.core.models.user.AuthenticationResponse;
import org.opencb.opencga.core.models.user.ConfigUpdateParams;
import org.opencb.opencga.core.models.user.FilterUpdateParams;
import org.opencb.opencga.core.models.user.PasswordChangeParams;
import org.opencb.opencga.core.models.user.User;
import org.opencb.opencga.core.models.user.UserCreateParams;
import org.opencb.opencga.core.models.user.UserFilter;
import org.opencb.opencga.core.models.user.UserUpdateParams;


/*
* WARNING: AUTOGENERATED CODE
*
* This code was generated by a tool.
* Autogenerated on: 2021-09-02 11:54:59
*
* Manual changes to this file may cause unexpected behavior in your application.
* Manual changes to this file will be overwritten if the code is regenerated.
*/

public class UserCommandExecutor extends ParentUserCommandExecutor {

    private UserCommandOptions userCommandOptions;

    public UserCommandExecutor(UserCommandOptions userCommandOptions) {
        super(userCommandOptions.commonCommandOptions, getParsedSubCommand(userCommandOptions.jCommander).startsWith("log"),
                userCommandOptions);
        this.userCommandOptions = userCommandOptions;
    }

    @Override
    public void execute() throws Exception {
        logger.debug("Executing Users command line");
        
        String subCommandString = getParsedSubCommand(userCommandOptions.jCommander);
        RestResponse queryResponse = null;
        switch (subCommandString) {
            case "create":
                queryResponse = create();
                break;
            case "login":
                queryResponse = login();
                break;
            case "password":
                queryResponse = password();
                break;
            case "info":
                queryResponse = info();
                break;
            case "configs":
                queryResponse = configs();
                break;
            case "update-configs":
                queryResponse = updateConfigs();
                break;
            case "filters":
                queryResponse = filters();
                break;
            case "update-filters":
                queryResponse = updateFilters();
                break;
            case "update-filter":
                queryResponse = updateFilter();
                break;
            case "projects":
                queryResponse = projects();
                break;
            case "update":
                queryResponse = update();
                break;
            default:
                logger.error("Subcommand not valid");
                 break;
        }
    
        createOutput(queryResponse);
    
    }
    

    private RestResponse<User> create() throws ClientException {
        logger.debug("Executing create in User command line");

        UserCommandOptions.CreateCommandOptions commandOptions = userCommandOptions.createCommandOptions;
        UserCreateParams userCreateParams = new UserCreateParams()
                .setId(commandOptions.id)
                .setName(commandOptions.name)
                .setEmail(commandOptions.email)
                .setPassword(commandOptions.password)
                .setOrganization(commandOptions.organization);

        return openCGAClient.getUserClient().create(userCreateParams);
    }
    
    protected RestResponse<AuthenticationResponse> login() throws Exception {
        return super.login();
    }
    
    private RestResponse<User> password() throws ClientException {
        logger.debug("Executing password in User command line");

        UserCommandOptions.PasswordCommandOptions commandOptions = userCommandOptions.passwordCommandOptions;
        PasswordChangeParams passwordChangeParams = new PasswordChangeParams()
                .setUser(commandOptions.user)
                .setPassword(commandOptions.password)
                .setNewPassword(commandOptions.newPassword);

        return openCGAClient.getUserClient().password(passwordChangeParams);
    }
    
    private RestResponse<User> info() throws ClientException {
        logger.debug("Executing info in User command line");

        UserCommandOptions.InfoCommandOptions commandOptions = userCommandOptions.infoCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("include", commandOptions.include);
        queryParams.putIfNotEmpty("exclude", commandOptions.exclude);

        return openCGAClient.getUserClient().info(commandOptions.users, queryParams);
    }
    
    private RestResponse<ObjectMap> configs() throws ClientException {
        logger.debug("Executing configs in User command line");

        UserCommandOptions.ConfigsCommandOptions commandOptions = userCommandOptions.configsCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("name", commandOptions.name);

        return openCGAClient.getUserClient().configs(commandOptions.user, queryParams);
    }
    
    private RestResponse<ObjectMap> updateConfigs() throws ClientException {
        logger.debug("Executing updateConfigs in User command line");

        UserCommandOptions.UpdateConfigsCommandOptions commandOptions = userCommandOptions.updateConfigsCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotNull("action", commandOptions.action);

        ConfigUpdateParams configUpdateParams = new ConfigUpdateParams()
                .setId(commandOptions.id);

        return openCGAClient.getUserClient().updateConfigs(commandOptions.user, configUpdateParams, queryParams);
    }
    
    private RestResponse<UserFilter> filters() throws ClientException {
        logger.debug("Executing filters in User command line");

        UserCommandOptions.FiltersCommandOptions commandOptions = userCommandOptions.filtersCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("id", commandOptions.id);

        return openCGAClient.getUserClient().filters(commandOptions.user, queryParams);
    }
    
    private RestResponse<UserFilter> updateFilters() throws ClientException {
        logger.debug("Executing updateFilters in User command line");

        UserCommandOptions.UpdateFiltersCommandOptions commandOptions = userCommandOptions.updateFiltersCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotNull("action", commandOptions.action);

        UserFilter userFilter = new UserFilter()
                .setId(commandOptions.id)
                .setDescription(commandOptions.description);

        return openCGAClient.getUserClient().updateFilters(commandOptions.user, userFilter, queryParams);
    }
    
    private RestResponse<UserFilter> updateFilter() throws ClientException {
        logger.debug("Executing updateFilter in User command line");

        UserCommandOptions.UpdateFilterCommandOptions commandOptions = userCommandOptions.updateFilterCommandOptions;
        FilterUpdateParams filterUpdateParams = new FilterUpdateParams()
                .setDescription(commandOptions.description);

        return openCGAClient.getUserClient().updateFilter(commandOptions.user,commandOptions.filterId, filterUpdateParams);
    }
    
    private RestResponse<Project> projects() throws ClientException {
        logger.debug("Executing projects in User command line");

        UserCommandOptions.ProjectsCommandOptions commandOptions = userCommandOptions.projectsCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("include", commandOptions.include);
        queryParams.putIfNotEmpty("exclude", commandOptions.exclude);

        return openCGAClient.getUserClient().projects(commandOptions.user, queryParams);
    }
    
    private RestResponse<User> update() throws ClientException {
        logger.debug("Executing update in User command line");

        UserCommandOptions.UpdateCommandOptions commandOptions = userCommandOptions.updateCommandOptions;
        UserUpdateParams userUpdateParams = new UserUpdateParams()
                .setName(commandOptions.name)
                .setEmail(commandOptions.email)
                .setOrganization(commandOptions.organization);

        return openCGAClient.getUserClient().update(commandOptions.user, userUpdateParams);
    }
    
}
