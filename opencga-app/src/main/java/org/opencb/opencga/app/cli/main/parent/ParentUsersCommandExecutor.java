/*
 * Copyright 2015-2017 OpenCB
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
package org.opencb.opencga.app.cli.main.parent;

import org.apache.commons.lang3.StringUtils;
import org.opencb.commons.datastore.core.Event;
import org.opencb.opencga.app.cli.main.executors.UsersCommandExecutor;
import org.opencb.opencga.app.cli.main.options.UsersCommandOptions;
import org.opencb.opencga.app.cli.main.utils.CommandLineUtils;
import org.opencb.opencga.core.models.user.AuthenticationResponse;
import org.opencb.opencga.core.response.QueryType;
import org.opencb.opencga.core.response.RestResponse;

import java.io.IOException;

import static org.opencb.commons.utils.PrintUtils.getKeyValueAsFormattedString;
import static org.opencb.commons.utils.PrintUtils.println;

public class ParentUsersCommandExecutor {

    public static final String LOGIN_OK = "You have been logged in correctly: ";
    public static final String LOGIN_FAIL = "Incorrect username or password.";
    public static final String LOGIN_ERROR = "Not available login service now. Please contact the system administrator.";
    public static final String LOGOUT = "You've been logged out.";
    private final UsersCommandOptions usersCommandOptions;
    UsersCommandExecutor executor;

    public ParentUsersCommandExecutor(UsersCommandExecutor executor) {
        this.executor = executor;
        this.usersCommandOptions = executor.usersCommandOptions;
    }

    public RestResponse<AuthenticationResponse> login() throws Exception {
        executor.getLogger().debug("Login");
        RestResponse<AuthenticationResponse> res = new RestResponse<>();
        try {
            String user = usersCommandOptions.loginCommandOptions.user;
            String password = usersCommandOptions.loginCommandOptions.password;

            if (StringUtils.isNotEmpty(user) && StringUtils.isNotEmpty(password)) {
                AuthenticationResponse response = null;
                try {
                    response = executor.getOpenCGAClient().login(user, password);
                } catch (Exception e) {
                    Event event = new Event();
                    event.setMessage(e.getMessage());
                    event.setType(Event.Type.ERROR);
                    res.setType(QueryType.VOID);
                    res.getEvents().add(event);
                    return res;
                }
                executor.getLogger().debug("Login token ::: " + executor.getSessionManager().getSession().getToken());
                res = executor.saveSession(user, response);
                println(getKeyValueAsFormattedString(LOGIN_OK, user));
            } else {
                String sessionId = usersCommandOptions.commonCommandOptions.token;
                String errorMsg = "Missing password. ";
                if (StringUtils.isNotEmpty(sessionId)) {
                    errorMsg += "Active token detected ";
                }
                CommandLineUtils.error(errorMsg);
            }
        } catch (Exception e) {
            CommandLineUtils.error(LOGIN_ERROR, e);
            e.printStackTrace();
            Event event = new Event();
            event.setMessage(LOGIN_ERROR + e.getMessage());
            res.setType(QueryType.VOID);
            event.setType(Event.Type.ERROR);
            res.getEvents().add(event);

        }
        return res;
    }


    public RestResponse<AuthenticationResponse> logout() throws IOException {
        executor.getLogger().debug("Logout");
        RestResponse<AuthenticationResponse> res = new RestResponse();
        try {
            executor.getSessionManager().logoutSessionFile();
            executor.getOpenCGAClient().logout();
            Event event = new Event();
            event.setMessage(LOGOUT);
            event.setType(Event.Type.INFO);
            res.getEvents().add(event);
            res.setType(QueryType.VOID);
        } catch (Exception e) {
            CommandLineUtils.error("Logout fail", e);
        }
        return res;
    }
}
