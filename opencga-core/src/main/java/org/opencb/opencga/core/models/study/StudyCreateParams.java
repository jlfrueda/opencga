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

package org.opencb.opencga.core.models.study;

import org.opencb.opencga.core.models.common.AdditionalInfo;
import org.opencb.opencga.core.models.common.StatusParams;
import org.opencb.opencga.core.models.common.ExternalSource;

import java.util.List;
import java.util.Map;

public class StudyCreateParams {

    private String id;
    private String name;
    private String alias;
    private StudyType type;
    private List<ExternalSource> sources;
    private String description;
    private String creationDate;
    private String modificationDate;
    private StudyNotification notification;
    private StatusParams status;
    private List<AdditionalInfo> additionalInfo;
    private Map<String, Object> attributes;

    public StudyCreateParams() {
    }

    public StudyCreateParams(String id, String name, String alias, StudyType type, List<ExternalSource> sources, String description,
                             String creationDate, String modificationDate, StudyNotification notification, Map<String, Object> attributes,
                             List<AdditionalInfo> additionalInfo, StatusParams status) {
        this.id = id;
        this.name = name;
        this.alias = alias;
        this.type = type;
        this.sources = sources;
        this.description = description;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
        this.notification = notification;
        this.attributes = attributes;
        this.additionalInfo = additionalInfo;
        this.status = status;
    }

    public static StudyCreateParams of(Study study) {
        return new StudyCreateParams(
                study.getId(),
                study.getName(),
                study.getAlias(),
                study.getType(),
                study.getSources(),
                study.getDescription(),
                study.getCreationDate(),
                study.getModificationDate(),
                study.getNotification(),
                study.getAttributes(),
                study.getAdditionalInfo(),
                StatusParams.of(study.getStatus()));
    }

    public Study toStudy() {
        return new Study(id, name, alias, creationDate, modificationDate, description, type, sources, notification, 0, null, null, null,
                null, null, null, null, null, null, null, null, null, 0, status != null ? status.toStatus() : null, null,
                additionalInfo, attributes);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StudyCreateParams{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", alias='").append(alias).append('\'');
        sb.append(", type=").append(type);
        sb.append(", sources=").append(sources);
        sb.append(", description='").append(description).append('\'');
        sb.append(", creationDate='").append(creationDate).append('\'');
        sb.append(", modificationDate='").append(modificationDate).append('\'');
        sb.append(", notification=").append(notification);
        sb.append(", status=").append(status);
        sb.append(", additionalInfo=").append(additionalInfo);
        sb.append(", attributes=").append(attributes);
        sb.append('}');
        return sb.toString();
    }

    public String getId() {
        return id;
    }

    public StudyCreateParams setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public StudyCreateParams setName(String name) {
        this.name = name;
        return this;
    }

    public String getAlias() {
        return alias;
    }

    public StudyCreateParams setAlias(String alias) {
        this.alias = alias;
        return this;
    }

    public StudyType getType() {
        return type;
    }

    public StudyCreateParams setType(StudyType type) {
        this.type = type;
        return this;
    }

    public List<ExternalSource> getSources() {
        return sources;
    }

    public StudyCreateParams setSources(List<ExternalSource> sources) {
        this.sources = sources;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public StudyCreateParams setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public StudyCreateParams setCreationDate(String creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public String getModificationDate() {
        return modificationDate;
    }

    public StudyCreateParams setModificationDate(String modificationDate) {
        this.modificationDate = modificationDate;
        return this;
    }

    public StudyNotification getNotification() {
        return notification;
    }

    public StudyCreateParams setNotification(StudyNotification notification) {
        this.notification = notification;
        return this;
    }

    public StatusParams getStatus() {
        return status;
    }

    public StudyCreateParams setStatus(StatusParams status) {
        this.status = status;
        return this;
    }

    public List<AdditionalInfo> getAdditionalInfo() {
        return additionalInfo;
    }

    public StudyCreateParams setAdditionalInfo(List<AdditionalInfo> additionalInfo) {
        this.additionalInfo = additionalInfo;
        return this;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public StudyCreateParams setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
        return this;
    }
}
