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

import org.opencb.commons.datastore.core.ObjectMap;
import org.opencb.opencga.app.cli.session.SessionManager;
import org.opencb.opencga.catalog.utils.ParamUtils;
import org.opencb.opencga.client.rest.OpenCGAClient;
import org.opencb.opencga.core.models.file.File;
import org.opencb.opencga.core.response.RestResponse;
import org.slf4j.Logger;

public class ParentFilesCommandExecutor {

    private ObjectMap map;
    private Logger logger;
    private OpenCGAClient openCGAClient;
    private SessionManager session;

    public ParentFilesCommandExecutor(ObjectMap map, Logger logger, OpenCGAClient openCGAClient, SessionManager session) {
        this.map = map;
        this.logger = logger;
        this.openCGAClient = openCGAClient;
        this.session = session;
    }

    public RestResponse<File> upload() throws Exception {


//        ObjectMap params = new ObjectMap()
        map.append("fileFormat", ParamUtils.defaultString(String.valueOf(map.get("fileFormat")), File.Format.UNKNOWN.toString()))
                .append("bioformat", ParamUtils.defaultString(String.valueOf(map.get("bioformat")), File.Bioformat.UNKNOWN.toString()));
//        //If the DEPRECATED parameter fileFormat has set we only override it if the new parameter format is also set
//        params.append("fileFormat", ParamUtils.defaultString(commandOptions.format, params.getString("fileFormat")));
//
//        params.putIfNotEmpty("study", commandOptions.study);
//        params.putIfNotEmpty("relativeFilePath", commandOptions.catalogPath);
//        params.putIfNotEmpty("relativeFilePath", commandOptions.path);
//        params.putIfNotEmpty("description", commandOptions.description);
//        params.putIfNotEmpty("fileName", commandOptions.fileName);
//        params.putIfNotEmpty("fileName", commandOptions.name);
//        params.putIfNotEmpty("file", commandOptions.inputFile);
        map.put("uploadServlet", Boolean.FALSE);

        return openCGAClient.getFileClient().upload(map);
    }

}
