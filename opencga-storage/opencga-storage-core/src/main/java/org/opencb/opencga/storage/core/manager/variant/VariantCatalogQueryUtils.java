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

package org.opencb.opencga.storage.core.manager.variant;

import org.apache.commons.lang3.StringUtils;
import org.opencb.commons.datastore.core.Query;
import org.opencb.commons.datastore.core.QueryOptions;
import org.opencb.commons.datastore.core.QueryParam;
import org.opencb.opencga.catalog.db.api.*;
import org.opencb.opencga.catalog.exceptions.CatalogException;
import org.opencb.opencga.catalog.managers.CatalogManager;
import org.opencb.opencga.core.models.Project;
import org.opencb.opencga.core.models.Sample;
import org.opencb.opencga.core.models.Study;
import org.opencb.opencga.storage.core.manager.CatalogUtils;
import org.opencb.opencga.storage.core.variant.adaptors.VariantQueryException;
import org.opencb.opencga.storage.core.variant.adaptors.VariantQueryParam;
import org.opencb.opencga.storage.core.variant.adaptors.VariantQueryUtils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.opencb.opencga.storage.core.variant.adaptors.VariantQueryUtils.*;

/**
 * Created on 28/02/17.
 *
 * @author Jacobo Coll &lt;jacobo167@gmail.com&gt;
 */
public class VariantCatalogQueryUtils extends CatalogUtils {

    public static final String SAMPLE_FILTER_DESC =
            "Selects some samples using metadata information from Catalog. e.g. age>20;phenotype=hpo:123,hpo:456;name=smith";
    public static final QueryParam SAMPLE_FILTER = QueryParam.create("sampleFilter", SAMPLE_FILTER_DESC, QueryParam.Type.TEXT_ARRAY);
    public static final String PROJECT_DESC = "Project [user@]project where project can be either the id or the alias.";
    public static final QueryParam PROJECT = QueryParam.create("project", PROJECT_DESC, QueryParam.Type.TEXT_ARRAY);
    private final StudyTransformFilter studyTransformFilter;
    private final FileTransformFilter fileTransformFilter;
    private final SampleTransformFilter sampleTransformFilter;
    private final CohortTransformFilter cohortTransformFilter;
    //    public static final QueryParam SAMPLE_FILTER_GENOTYPE = QueryParam.create("sampleFilterGenotype", "", QueryParam.Type.TEXT_ARRAY);

    public VariantCatalogQueryUtils(CatalogManager catalogManager) {
        super(catalogManager);

        studyTransformFilter = new StudyTransformFilter();
        fileTransformFilter = new FileTransformFilter();
        sampleTransformFilter = new SampleTransformFilter();
        cohortTransformFilter = new CohortTransformFilter();
    }

    public static VariantQueryException wrongReleaseException(VariantQueryParam param, String value, int release) {
        return new VariantQueryException("Unable to have '" + value + "' within '" + param.key() + "' filter. "
                + "Not part of release " + release);
    }

    /**
     * Transforms a high level Query to a query fully understandable by storage.
     * @param query     High level query. Will be modified by the method.
     * @param sessionId User's session id
     * @return          Modified input query (same instance)
     * @throws CatalogException if there is any catalog error
     */
    public Query parseQuery(Query query, String sessionId) throws CatalogException {
        if (query == null) {
            // Nothing to do!
            return null;
        }
        Set<Long> studies = getStudies(query, sessionId);
        long defaultStudyId = getDefaultStudyId(query, sessionId, studies);
        String defaultStudyStr = defaultStudyId > 0 ? String.valueOf(defaultStudyId) : null;
        Integer release = getReleaseFilter(query, sessionId);

        studyTransformFilter.processFilter(query, VariantQueryParam.STUDIES, release, sessionId, defaultStudyStr);
        studyTransformFilter.processFilter(query, VariantQueryParam.RETURNED_STUDIES, release, sessionId, defaultStudyStr);
        sampleTransformFilter.processFilter(query, VariantQueryParam.SAMPLES, release, sessionId, defaultStudyStr);
        sampleTransformFilter.processFilter(query, VariantQueryParam.RETURNED_SAMPLES, release, sessionId, defaultStudyStr);
        //TODO: Parse genotype filter
        //sampleTransformFilter.processFilter(query, VariantQueryParam.GENOTYPE, release, sessionId, defaultStudyStr);
        fileTransformFilter.processFilter(query, VariantQueryParam.FILES, release, sessionId, defaultStudyStr);
        fileTransformFilter.processFilter(query, VariantQueryParam.RETURNED_FILES, release, sessionId, defaultStudyStr);
        cohortTransformFilter.processFilter(query, VariantQueryParam.COHORTS, release, sessionId, defaultStudyStr);
        cohortTransformFilter.processFilter(query, VariantQueryParam.STATS_MAF, release, sessionId, defaultStudyStr);
        cohortTransformFilter.processFilter(query, VariantQueryParam.STATS_MGF, release, sessionId, defaultStudyStr);
        cohortTransformFilter.processFilter(query, VariantQueryParam.MISSING_ALLELES, release, sessionId, defaultStudyStr);
        cohortTransformFilter.processFilter(query, VariantQueryParam.MISSING_GENOTYPES, release, sessionId, defaultStudyStr);


        if (isValidParam(query, SAMPLE_FILTER)) {
            String sampleAnnotation = query.getString(SAMPLE_FILTER.key());
            Query sampleQuery = parseSampleAnnotationQuery(sampleAnnotation, SampleDBAdaptor.QueryParams::getParam);
            sampleQuery.append(SampleDBAdaptor.QueryParams.STUDY_ID.key(), defaultStudyId);
            QueryOptions options = new QueryOptions(QueryOptions.INCLUDE, SampleDBAdaptor.QueryParams.ID);
            List<Long> sampleIds = catalogManager.getSampleManager().get(defaultStudyId, sampleQuery, options, sessionId).getResult()
                    .stream()
                    .map(Sample::getId)
                    .collect(Collectors.toList());

            if (sampleIds.isEmpty()) {
                throw new VariantQueryException("Could not found samples with this annotation: " + sampleAnnotation);
            }

            String genotype = query.getString("sampleAnnotationGenotype");
//            String genotype = query.getString(VariantDBAdaptor.VariantQueryParams.GENOTYPE.key());
            if (StringUtils.isNotBlank(genotype)) {
                StringBuilder sb = new StringBuilder();
                for (Long sampleId : sampleIds) {
                    sb.append(sampleId).append(IS)
                            .append(genotype)
                            .append(AND); // TODO: Should this be an AND (;) or an OR (,)?
                }
                query.append(VariantQueryParam.GENOTYPE.key(), sb.toString());
                if (!isValidParam(query, VariantQueryParam.RETURNED_SAMPLES)) {
                    query.append(VariantQueryParam.RETURNED_SAMPLES.key(), sampleIds);
                }
            } else {
                query.append(VariantQueryParam.SAMPLES.key(), sampleIds);
            }
        }

        return query;
    }

    public long getDefaultStudyId(Query query, String sessionId, Set<Long> studies) throws CatalogException {
        final long defaultStudyId;
        if (studies.size() == 1) {
            defaultStudyId = studies.iterator().next();
        } else if (studies.isEmpty()) {
            if (isValidParam(query, PROJECT)) {
                studies = catalogManager.getStudyManager()
                        .get(
                                query.getString(PROJECT.key()),
                                new Query(),
                                new QueryOptions(QueryOptions.INCLUDE, StudyDBAdaptor.QueryParams.ID),
                                sessionId)
                        .getResult()
                        .stream()
                        .map(Study::getId)
                        .collect(Collectors.toSet());
                if (studies.size() == 1) {
                    defaultStudyId = studies.iterator().next();
                } else {
                    defaultStudyId = -1;
                }
            } else {
                String userId = catalogManager.getUserManager().getUserId(sessionId);
                defaultStudyId = catalogManager.getStudyManager().getId(userId, null);
            }
        } else {
            defaultStudyId = -1;
        }
        return defaultStudyId;
    }

    public Integer getReleaseFilter(Query query, String sessionId) throws CatalogException {
        Integer release;
        if (isValidParam(query, VariantQueryParam.RELEASE)) {
            release = query.getInt(VariantQueryParam.RELEASE.key(), -1);
            if (release <= 0) {
                throw VariantQueryException.malformedParam(VariantQueryParam.RELEASE, query.getString(VariantQueryParam.RELEASE.key()));
            }
            Project project = getProjectFromQuery(query, sessionId,
                    new QueryOptions(QueryOptions.INCLUDE, ProjectDBAdaptor.QueryParams.CURRENT_RELEASE.key()));
            int currentRelease = project.getCurrentRelease();
            if (release > currentRelease) {
                throw VariantQueryException.malformedParam(VariantQueryParam.RELEASE, query.getString(VariantQueryParam.RELEASE.key()));
            } else if (release == currentRelease) {
                // Using latest release. We don't need to filter by release!
                release = null;
            } // else, filter by release

        } else {
            release = null;
        }
        return release;
    }

    public abstract class TransformFilter {
        protected final QueryOptions OPTIONS = new QueryOptions(QueryOptions.INCLUDE, FileDBAdaptor.QueryParams.RELEASE.key());

        /**
         * Splits the value from the query (if any) and translates the IDs to numerical Ids.
         * If a release value is given, checks that every element is part of that release.
         * @param query        Query with the data
         * @param param        Param to modify
         * @param release      Release filter, if any
         * @param sessionId    SessionId
         * @param defaultStudy Default study
         * @throws CatalogException if there is any catalog error
         */
        protected void processFilter(Query query, VariantQueryParam param, Integer release, String sessionId, String defaultStudy)
                throws CatalogException {
            if (VariantQueryUtils.isValidParam(query, param)) {
                String valuesStr = query.getString(param.key());
                // Do not try to transform ALL or NONE values
                if (isNoneOrAll(valuesStr)) {
                    return;
                }
                VariantQueryUtils.QueryOperation queryOperation = VariantQueryUtils.checkOperator(valuesStr);
                if (queryOperation == null) {
                    queryOperation = VariantQueryUtils.QueryOperation.OR;
                }
                List<String> values = VariantQueryUtils.splitValue(valuesStr, queryOperation);
                StringBuilder sb = new StringBuilder();
                for (String value : values) {
                    if (sb.length() > 0) {
                        sb.append(queryOperation.separator());
                    }
                    if (isNegated(value)) {
                        sb.append(NOT);
                        value = removeNegation(value);
                    }
                    String[] strings = VariantQueryUtils.splitOperator(value);
                    boolean withComparisionOperator = strings[0] != null;
                    if (withComparisionOperator) {
                        value = strings[0];
                        withComparisionOperator = true;
                    }

                    Long id;
                    if (StringUtils.isNumeric(value)) {
                        id = Long.parseLong(value);
                        sb.append(value);
                    } else {
                        id = toId(defaultStudy, value, sessionId);
                        sb.append(id);
                    }
                    if (!releaseMatches(id, release, sessionId)) {
                        throw wrongReleaseException(param, value, release);
                    }

                    if (withComparisionOperator) {
                        sb.append(strings[1]);
                        sb.append(strings[2]);
                    }
                }
                query.put(param.key(), sb.toString());
            }
        }

        protected abstract boolean releaseMatches(Long id, Integer release, String sessionId) throws CatalogException;

        protected abstract Long toId(String defaultStudyStr, String value, String sessionId) throws CatalogException;
    }


    public class StudyTransformFilter extends TransformFilter {
        @Override
        protected Long toId(String defaultStudyStr, String value, String sessionId) throws CatalogException {
            return catalogManager.getStudyManager().getId(catalogManager.getUserManager().getUserId(sessionId), value);
        }

        @Override
        protected boolean releaseMatches(Long id, Integer release, String sessionId) throws CatalogException {
            if (release == null) {
                return true;
            }

            return catalogManager.getStudyManager().get(id.toString(), OPTIONS, sessionId).first().getRelease() <= release;
        }
    }

    public class FileTransformFilter extends TransformFilter {
        @Override
        protected Long toId(String defaultStudyStr, String value, String sessionId) throws CatalogException {
            return catalogManager.getFileManager().getId(value, defaultStudyStr, sessionId).getResourceId();
        }

        @Override
        protected boolean releaseMatches(Long id, Integer release, String sessionId) throws CatalogException {
            if (release == null) {
                return true;
            }

            return catalogManager.getFileManager().get(id, OPTIONS, sessionId).first().getRelease() <= release;
//            return catalogManager.getFileManager().count(defaultStudyStr,
//                    new Query(FileDBAdaptor.QueryParams.ID.key(), id)
//                            .append(FileDBAdaptor.QueryParams.RELEASE.key(), release), sessionId).getNumTotalResults() == 1;
        }
    }

    public class SampleTransformFilter extends TransformFilter {

        @Override
        protected Long toId(String defaultStudyStr, String value, String sessionId) throws CatalogException {
            return catalogManager.getSampleManager().getId(value, defaultStudyStr, sessionId).getResourceId();
        }

        @Override
        protected boolean releaseMatches(Long id, Integer release, String sessionId) throws CatalogException {
            if (release == null) {
                return true;
            }
            return catalogManager.getSampleManager().get(id, OPTIONS, sessionId).first().getRelease() <= release;
        }
    }

    public class CohortTransformFilter extends TransformFilter {
        @Override
        protected Long toId(String defaultStudyStr, String value, String sessionId) throws CatalogException {
            return catalogManager.getCohortManager().getId(value, defaultStudyStr, sessionId).getResourceId();
        }

        @Override
        protected boolean releaseMatches(Long id, Integer release, String sessionId) throws CatalogException {
            if (release == null) {
                return true;
            }

            Long studyId = catalogManager.getCohortManager().getStudyId(id);
            return catalogManager.getCohortManager().get(studyId, new Query(CohortDBAdaptor.QueryParams.ID.key(), id), OPTIONS, sessionId)
                    .first().getRelease() <= release;
        }
    }

}
