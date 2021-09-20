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

package org.opencb.opencga.server.json.beans;

import org.opencb.opencga.core.common.GitRepositoryState;

import java.util.List;

public class RestApi {

    private List<Category> categories;
    private String commit;
    private String version;

    public RestApi() {
        commit = GitRepositoryState.get().getCommitId();
        version = GitRepositoryState.get().getBuildVersion();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RestApi{");
        sb.append("categories=").append(categories);
        sb.append(", commit='").append(commit).append('\'');
        sb.append(", version='").append(version).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getCommit() {
        return commit;
    }

    public RestApi setCommit(String commit) {
        this.commit = commit;
        return this;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public RestApi setCategories(List<Category> categories) {
        this.categories = categories;
        return this;
    }

    public String getVersion() {
        return version;
    }

    public RestApi setVersion(String version) {
        this.version = version;
        return this;
    }
}
