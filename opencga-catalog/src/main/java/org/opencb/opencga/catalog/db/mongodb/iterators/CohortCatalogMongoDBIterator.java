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

package org.opencb.opencga.catalog.db.mongodb.iterators;

import com.mongodb.client.ClientSession;
import org.bson.Document;
import org.opencb.commons.datastore.core.Query;
import org.opencb.commons.datastore.core.QueryOptions;
import org.opencb.commons.datastore.mongodb.MongoDBIterator;
import org.opencb.opencga.catalog.db.api.CohortDBAdaptor;
import org.opencb.opencga.catalog.db.api.SampleDBAdaptor;
import org.opencb.opencga.catalog.db.mongodb.SampleMongoDBAdaptor;
import org.opencb.opencga.catalog.db.mongodb.converters.AnnotableConverter;
import org.opencb.opencga.catalog.exceptions.CatalogAuthorizationException;
import org.opencb.opencga.catalog.exceptions.CatalogDBException;
import org.opencb.opencga.catalog.exceptions.CatalogParameterException;
import org.opencb.opencga.catalog.managers.SampleManager;
import org.opencb.opencga.core.api.ParamConstants;
import org.opencb.opencga.core.models.common.Annotable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.function.UnaryOperator;

import static org.opencb.opencga.catalog.db.mongodb.MongoDBAdaptor.NATIVE_QUERY;

public class CohortCatalogMongoDBIterator<E> extends AnnotableCatalogMongoDBIterator<E> {

    private long studyUid;
    private String user;

    private SampleMongoDBAdaptor sampleDBAdaptor;
    private QueryOptions sampleQueryOptions;

    private Queue<Document> cohortListBuffer;

    private Logger logger;

    private static final int BUFFER_SIZE = 100;

    public CohortCatalogMongoDBIterator(MongoDBIterator<Document> mongoCursor, ClientSession clientSession,
                                        AnnotableConverter<? extends Annotable> converter, UnaryOperator<Document> filter,
                                        SampleMongoDBAdaptor sampleMongoDBAdaptor, QueryOptions options) {
        this(mongoCursor, clientSession, converter, filter, sampleMongoDBAdaptor, 0, null, options);
    }

    public CohortCatalogMongoDBIterator(MongoDBIterator<Document> mongoCursor, ClientSession clientSession,
                                        AnnotableConverter<? extends Annotable> converter, UnaryOperator<Document> filter,
                                        SampleMongoDBAdaptor sampleMongoDBAdaptor, long studyUid, String user, QueryOptions options) {
        super(mongoCursor, clientSession, converter, filter, options);

        this.user = user;
        this.studyUid = studyUid;

        this.sampleDBAdaptor = sampleMongoDBAdaptor;
        this.sampleQueryOptions = createSampleQueryOptions();

        this.cohortListBuffer = new LinkedList<>();
        this.logger = LoggerFactory.getLogger(CohortCatalogMongoDBIterator.class);
    }

    @Override
    public E next() {
        Document next = cohortListBuffer.remove();

        if (filter != null) {
            next = filter.apply(next);
        }

        addAclInformation(next, options);

        if (converter != null) {
            return (E) converter.convertToDataModelType(next, options);
        } else {
            return (E) next;
        }
    }

    @Override
    public boolean hasNext() {
        if (cohortListBuffer.isEmpty()) {
            fetchNextBatch();
        }
        return !cohortListBuffer.isEmpty();
    }

    private void fetchNextBatch() {
        Set<Long> sampleSet = new HashSet<>();

        // Get next BUFFER_SIZE documents
        int counter = 0;
        // If a cohort has more than 100 samples, we will set this to true so only sample ids are fetched
        boolean fetchSampleIdsOnly = false;
        while (mongoCursor.hasNext() && counter < BUFFER_SIZE) {
            Document cohortDocument = mongoCursor.next();

            if (user != null && studyUid <= 0) {
                studyUid = ((Number) cohortDocument.get(PRIVATE_STUDY_UID)).longValue();
            }

            cohortListBuffer.add(cohortDocument);
            counter++;

            // Extract all the samples
            Object samples = cohortDocument.get(CohortDBAdaptor.QueryParams.SAMPLES.key());
            if (samples != null && !options.getBoolean(NATIVE_QUERY)) {
                List<Document> sampleList = (List<Document>) samples;
                if (!sampleList.isEmpty()) {
                    if (sampleList.size() > 100) {
                        fetchSampleIdsOnly = true;
                    }
                    sampleList.forEach(sample -> sampleSet.add(((Number) sample.get(SampleDBAdaptor.QueryParams.UID.key())).longValue()));
                }
            }
        }

        if (!sampleSet.isEmpty()) {
            // Obtain all those samples
            Query query = new Query(SampleDBAdaptor.QueryParams.UID.key(), new ArrayList<>(sampleSet));
            List<Document> sampleList;

            QueryOptions sampleOptions = fetchSampleIdsOnly
                    ? new QueryOptions(SampleManager.INCLUDE_SAMPLE_IDS).append(NATIVE_QUERY, true)
                    : new QueryOptions(sampleQueryOptions);

            try {
                if (user != null) {
                    query.put(SampleDBAdaptor.QueryParams.STUDY_UID.key(), studyUid);
                    sampleList = sampleDBAdaptor.nativeGet(clientSession, studyUid, query, sampleOptions, user).getResults();
                } else {
                    sampleList = sampleDBAdaptor.nativeGet(clientSession, query, sampleOptions).getResults();
                }
            } catch (CatalogDBException | CatalogAuthorizationException | CatalogParameterException e) {
                logger.warn("Could not obtain the samples associated to the cohorts: {}", e.getMessage(), e);
                return;
            }

            // Map each sample uid - version to the sample entry
            Map<Long, Document> sampleMap = new HashMap<>(sampleList.size());
            sampleList.forEach(sample ->
                    sampleMap.put(((Number) sample.get(SampleDBAdaptor.QueryParams.UID.key())).longValue(), sample)
            );

            // Add the samples obtained to the corresponding cohorts
            cohortListBuffer.forEach(cohortDocument -> {
                List<Document> tmpSampleList = new ArrayList<>();
                List<Document> samples = (List<Document>) cohortDocument.get(CohortDBAdaptor.QueryParams.SAMPLES.key());

                samples.forEach(sample -> {
                    long uid = ((Number) sample.get(SampleDBAdaptor.QueryParams.UID.key())).longValue();

                    // If the samples has been returned... (it might have not been fetched due to permissions issues)
                    if (sampleMap.containsKey(uid)) {
                        tmpSampleList.add(sampleMap.get(uid));
                    }
                });

                cohortDocument.put(CohortDBAdaptor.QueryParams.SAMPLES.key(), tmpSampleList);
            });
        }
    }

    private QueryOptions createSampleQueryOptions() {
        QueryOptions queryOptions = new QueryOptions(NATIVE_QUERY, true);

        if (options.containsKey(QueryOptions.INCLUDE)) {
            List<String> currentIncludeList = options.getAsStringList(QueryOptions.INCLUDE);
            List<String> includeList = new ArrayList<>();
            for (String include : currentIncludeList) {
                if (include.startsWith(CohortDBAdaptor.QueryParams.SAMPLES.key() + ".")) {
                    includeList.add(include.replace(CohortDBAdaptor.QueryParams.SAMPLES.key() + ".", ""));
                }
            }
            if (!includeList.isEmpty()) {
                // If we only have include uid or version, there is no need for an additional query so we will set current options to
                // native query
                boolean includeAdditionalFields = includeList.stream().anyMatch(
                        field -> !field.equals(SampleDBAdaptor.QueryParams.VERSION.key())
                                && !field.equals(SampleDBAdaptor.QueryParams.UID.key())
                );
                if (includeAdditionalFields) {
                    includeList.add(SampleDBAdaptor.QueryParams.VERSION.key());
                    includeList.add(SampleDBAdaptor.QueryParams.UID.key());
                    queryOptions.put(QueryOptions.INCLUDE, includeList);
                } else {
                    // User wants to include fields already retrieved
                    options.put(NATIVE_QUERY, true);
                }
            }
        }
        if (options.containsKey(QueryOptions.EXCLUDE)) {
            List<String> currentExcludeList = options.getAsStringList(QueryOptions.EXCLUDE);
            List<String> excludeList = new ArrayList<>();
            for (String exclude : currentExcludeList) {
                if (exclude.startsWith(CohortDBAdaptor.QueryParams.SAMPLES.key() + ".")) {
                    String replace = exclude.replace(CohortDBAdaptor.QueryParams.SAMPLES.key() + ".", "");
                    if (!SampleDBAdaptor.QueryParams.UID.key().equals(replace)
                            && !SampleDBAdaptor.QueryParams.VERSION.key().equals(replace)) {
                        excludeList.add(replace);
                    }
                }
            }
            if (!excludeList.isEmpty()) {
                queryOptions.put(QueryOptions.EXCLUDE, excludeList);
            } else {
                queryOptions.remove(QueryOptions.EXCLUDE);
            }
        }
        if (options.containsKey(ParamConstants.FLATTEN_ANNOTATIONS)) {
            queryOptions.put(ParamConstants.FLATTEN_ANNOTATIONS, options.getBoolean(ParamConstants.FLATTEN_ANNOTATIONS));
        }

        return queryOptions;
    }

}
