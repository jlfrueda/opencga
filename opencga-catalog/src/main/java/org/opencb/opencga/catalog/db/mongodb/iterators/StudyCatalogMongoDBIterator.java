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

import org.bson.Document;
import org.opencb.commons.datastore.core.QueryOptions;
import org.opencb.commons.datastore.mongodb.GenericDocumentComplexConverter;
import org.opencb.commons.datastore.mongodb.MongoDBIterator;
import org.opencb.opencga.catalog.utils.ParamUtils;

import java.util.function.Function;

/**
 * Created by pfurio on 31/07/17.
 */
public class StudyCatalogMongoDBIterator<E> extends CatalogMongoDBIterator<E> {

    private Function<Document, Boolean> studyFilter;
    private Document previousDocument;
    private QueryOptions options;

    public StudyCatalogMongoDBIterator(MongoDBIterator<Document> mongoCursor, QueryOptions options) {
        this(mongoCursor, options, null, null);
    }

    public StudyCatalogMongoDBIterator(MongoDBIterator<Document> mongoCursor, QueryOptions options,
                                       GenericDocumentComplexConverter<E> converter) {
        this(mongoCursor, options, converter, null);
    }

    public StudyCatalogMongoDBIterator(MongoDBIterator<Document> mongoCursor, QueryOptions options,
                                       Function<Document, Boolean> studyFilter) {
        this(mongoCursor, options, null, studyFilter);
    }

    public StudyCatalogMongoDBIterator(MongoDBIterator<Document> mongoCursor, QueryOptions options,
                                       GenericDocumentComplexConverter<E> converter, Function<Document, Boolean> studyFilter) {
        super(mongoCursor, null, converter, null);
        this.mongoCursor = mongoCursor;
        this.converter = converter;
        this.studyFilter = studyFilter;
        this.options = ParamUtils.defaultObject(options, QueryOptions::new);

        getNextStudy();
    }

    private void getNextStudy() {
        if (this.mongoCursor.hasNext()) {
            this.previousDocument = this.mongoCursor.next();

            if (this.studyFilter != null) {
                while (this.previousDocument != null && !this.studyFilter.apply(this.previousDocument)) {
                       if (this.mongoCursor.hasNext()) {
                           this.previousDocument = this.mongoCursor.next();
                       } else {
                           this.previousDocument = null;
                       }
                }
            }

            addAclInformation(previousDocument, options);
        } else {
            this.previousDocument = null;
        }
    }

    @Override
    public boolean hasNext() {
        return this.previousDocument != null;
    }

    @Override
    public E next() {
        Document next = this.previousDocument;
        getNextStudy();

        if (converter != null) {
            return converter.convertToDataModelType(next);
        } else {
            return (E) next;
        }
    }

    @Override
    public void close() {
        mongoCursor.close();
    }


}
