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
import java.lang.Object;
import org.opencb.commons.datastore.core.FacetField;
import org.opencb.commons.datastore.core.ObjectMap;
import org.opencb.opencga.app.cli.main.options.FamilyCommandOptions;
import org.opencb.opencga.catalog.utils.ParamUtils.AclAction;
import org.opencb.opencga.catalog.utils.ParamUtils.BasicUpdateAction;
import org.opencb.opencga.catalog.utils.ParamUtils.CompleteUpdateAction;
import org.opencb.opencga.client.exceptions.ClientException;
import org.opencb.opencga.core.models.common.TsvAnnotationParams;
import org.opencb.opencga.core.models.family.Family;
import org.opencb.opencga.core.models.family.FamilyAclParams.Propagate;
import org.opencb.opencga.core.models.family.FamilyAclUpdateParams;
import org.opencb.opencga.core.models.family.FamilyCreateParams;
import org.opencb.opencga.core.models.family.FamilyUpdateParams;
import org.opencb.opencga.core.models.job.Job;


/*
* WARNING: AUTOGENERATED CODE
*
* This code was generated by a tool.
* Autogenerated on: 2021-09-02 11:54:59
*
* Manual changes to this file may cause unexpected behavior in your application.
* Manual changes to this file will be overwritten if the code is regenerated.
*/

public class FamilyCommandExecutor extends OpencgaCommandExecutor {

    private FamilyCommandOptions familyCommandOptions;

    public FamilyCommandExecutor(FamilyCommandOptions familyCommandOptions) {
        super(familyCommandOptions.commonCommandOptions);
        this.familyCommandOptions = familyCommandOptions;
    }

    @Override
    public void execute() throws Exception {
        logger.debug("Executing Families command line");
        
        String subCommandString = getParsedSubCommand(familyCommandOptions.jCommander);
        RestResponse queryResponse = null;
        switch (subCommandString) {
            case "update-acl":
                queryResponse = updateAcl();
                break;
            case "aggregation-stats":
                queryResponse = aggregationStats();
                break;
            case "load-annotation-sets":
                queryResponse = loadAnnotationSets();
                break;
            case "create":
                queryResponse = create();
                break;
            case "distinct":
                queryResponse = distinct();
                break;
            case "search":
                queryResponse = search();
                break;
            case "acl":
                queryResponse = acl();
                break;
            case "delete":
                queryResponse = delete();
                break;
            case "info":
                queryResponse = info();
                break;
            case "update":
                queryResponse = update();
                break;
            case "update-annotations":
                queryResponse = updateAnnotations();
                break;
            default:
                logger.error("Subcommand not valid");
                 break;
        }
    
        createOutput(queryResponse);
    
    }
    

    private RestResponse<ObjectMap> updateAcl() throws ClientException {
        logger.debug("Executing updateAcl in Family command line");

        FamilyCommandOptions.UpdateAclCommandOptions commandOptions = familyCommandOptions.updateAclCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotNull("propagate", commandOptions.propagate);

        FamilyAclUpdateParams familyAclUpdateParams = new FamilyAclUpdateParams()
                .setFamily(commandOptions.family)
                .setIndividual(commandOptions.individual)
                .setSample(commandOptions.sample);

        return openCGAClient.getFamilyClient().updateAcl(commandOptions.members,commandOptions.action, familyAclUpdateParams, queryParams);
    }
    
    private RestResponse<FacetField> aggregationStats() throws ClientException {
        logger.debug("Executing aggregationStats in Family command line");

        FamilyCommandOptions.AggregationStatsCommandOptions commandOptions = familyCommandOptions.aggregationStatsCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("creationYear", commandOptions.creationYear);
        queryParams.putIfNotEmpty("creationMonth", commandOptions.creationMonth);
        queryParams.putIfNotEmpty("creationDay", commandOptions.creationDay);
        queryParams.putIfNotEmpty("creationDayOfWeek", commandOptions.creationDayOfWeek);
        queryParams.putIfNotEmpty("status", commandOptions.status);
        queryParams.putIfNotEmpty("phenotypes", commandOptions.phenotypes);
        queryParams.putIfNotEmpty("release", commandOptions.release);
        queryParams.putIfNotEmpty("version", commandOptions.version);
        queryParams.putIfNotEmpty("numMembers", commandOptions.numMembers);
        queryParams.putIfNotEmpty("expectedSize", commandOptions.expectedSize);
        queryParams.putIfNotEmpty("annotation", commandOptions.annotation);
        queryParams.putIfNotNull("defaultParam", commandOptions.defaultParam);
        queryParams.putIfNotEmpty("field", commandOptions.field);

        return openCGAClient.getFamilyClient().aggregationStats(queryParams);
    }
    
    private RestResponse<Job> loadAnnotationSets() throws ClientException {
        logger.debug("Executing loadAnnotationSets in Family command line");

        FamilyCommandOptions.LoadAnnotationSetsCommandOptions commandOptions = familyCommandOptions.loadAnnotationSetsCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotNull("parents", commandOptions.parents);
        queryParams.putIfNotEmpty("annotationSetId", commandOptions.annotationSetId);

        TsvAnnotationParams tsvAnnotationParams = new TsvAnnotationParams()
                .setContent(commandOptions.content);

        return openCGAClient.getFamilyClient().loadAnnotationSets(commandOptions.variableSetId,commandOptions.path, tsvAnnotationParams, queryParams);
    }
    
    private RestResponse<Family> create() throws ClientException {
        logger.debug("Executing create in Family command line");

        FamilyCommandOptions.CreateCommandOptions commandOptions = familyCommandOptions.createCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("members", commandOptions.members);

        FamilyCreateParams familyCreateParams = new FamilyCreateParams()
                .setId(commandOptions.id)
                .setName(commandOptions.name)
                .setDescription(commandOptions.description)
                .setCreationDate(commandOptions.creationDate)
                .setModificationDate(commandOptions.modificationDate);

        return openCGAClient.getFamilyClient().create(familyCreateParams, queryParams);
    }
    
    private RestResponse<ObjectMap> distinct() throws ClientException {
        logger.debug("Executing distinct in Family command line");

        FamilyCommandOptions.DistinctCommandOptions commandOptions = familyCommandOptions.distinctCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("name", commandOptions.name);
        queryParams.putIfNotNull("parentalConsanguinity", commandOptions.parentalConsanguinity);
        queryParams.putIfNotEmpty("members", commandOptions.members);
        queryParams.putIfNotEmpty("samples", commandOptions.samples);
        queryParams.putIfNotEmpty("phenotypes", commandOptions.phenotypes);
        queryParams.putIfNotEmpty("disorders", commandOptions.disorders);
        queryParams.putIfNotEmpty("creationDate", commandOptions.creationDate);
        queryParams.putIfNotEmpty("modificationDate", commandOptions.modificationDate);
        queryParams.putIfNotNull("deleted", commandOptions.deleted);
        queryParams.putIfNotEmpty("annotationsetName", commandOptions.annotationsetName);
        queryParams.putIfNotEmpty("variableSet", commandOptions.variableSet);
        queryParams.putIfNotEmpty("internalStatus", commandOptions.internalStatus);
        queryParams.putIfNotEmpty("status", commandOptions.status);
        queryParams.putIfNotEmpty("annotation", commandOptions.annotation);
        queryParams.putIfNotEmpty("acl", commandOptions.acl);
        queryParams.putIfNotEmpty("release", commandOptions.release);
        queryParams.putIfNotNull("snapshot", commandOptions.snapshot);

        return openCGAClient.getFamilyClient().distinct(commandOptions.field, queryParams);
    }
    
    private RestResponse<Family> search() throws ClientException {
        logger.debug("Executing search in Family command line");

        FamilyCommandOptions.SearchCommandOptions commandOptions = familyCommandOptions.searchCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("include", commandOptions.include);
        queryParams.putIfNotEmpty("exclude", commandOptions.exclude);
        queryParams.putIfNotNull("count", commandOptions.count);
        queryParams.putIfNotNull("flattenAnnotations", commandOptions.flattenAnnotations);
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("name", commandOptions.name);
        queryParams.putIfNotNull("parentalConsanguinity", commandOptions.parentalConsanguinity);
        queryParams.putIfNotEmpty("members", commandOptions.members);
        queryParams.putIfNotEmpty("samples", commandOptions.samples);
        queryParams.putIfNotEmpty("phenotypes", commandOptions.phenotypes);
        queryParams.putIfNotEmpty("disorders", commandOptions.disorders);
        queryParams.putIfNotEmpty("creationDate", commandOptions.creationDate);
        queryParams.putIfNotEmpty("modificationDate", commandOptions.modificationDate);
        queryParams.putIfNotNull("deleted", commandOptions.deleted);
        queryParams.putIfNotEmpty("annotationsetName", commandOptions.annotationsetName);
        queryParams.putIfNotEmpty("variableSet", commandOptions.variableSet);
        queryParams.putIfNotEmpty("internalStatus", commandOptions.internalStatus);
        queryParams.putIfNotEmpty("status", commandOptions.status);
        queryParams.putIfNotEmpty("annotation", commandOptions.annotation);
        queryParams.putIfNotEmpty("acl", commandOptions.acl);
        queryParams.putIfNotEmpty("release", commandOptions.release);
        queryParams.putIfNotNull("snapshot", commandOptions.snapshot);

        return openCGAClient.getFamilyClient().search(queryParams);
    }
    
    private RestResponse<ObjectMap> acl() throws ClientException {
        logger.debug("Executing acl in Family command line");

        FamilyCommandOptions.AclCommandOptions commandOptions = familyCommandOptions.aclCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("member", commandOptions.member);
        queryParams.putIfNotNull("silent", commandOptions.silent);

        return openCGAClient.getFamilyClient().acl(commandOptions.families, queryParams);
    }
    
    private RestResponse<Family> delete() throws ClientException {
        logger.debug("Executing delete in Family command line");

        FamilyCommandOptions.DeleteCommandOptions commandOptions = familyCommandOptions.deleteCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);

        return openCGAClient.getFamilyClient().delete(commandOptions.families, queryParams);
    }
    
    private RestResponse<Family> info() throws ClientException {
        logger.debug("Executing info in Family command line");

        FamilyCommandOptions.InfoCommandOptions commandOptions = familyCommandOptions.infoCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("include", commandOptions.include);
        queryParams.putIfNotEmpty("exclude", commandOptions.exclude);
        queryParams.putIfNotNull("flattenAnnotations", commandOptions.flattenAnnotations);
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("version", commandOptions.version);
        queryParams.putIfNotNull("deleted", commandOptions.deleted);

        return openCGAClient.getFamilyClient().info(commandOptions.families, queryParams);
    }
    
    private RestResponse<Family> update() throws ClientException {
        logger.debug("Executing update in Family command line");

        FamilyCommandOptions.UpdateCommandOptions commandOptions = familyCommandOptions.updateCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotNull("incVersion", commandOptions.incVersion);
        queryParams.putIfNotNull("updateRoles", commandOptions.updateRoles);
        queryParams.putIfNotNull("annotationSetsAction", commandOptions.annotationSetsAction);

        FamilyUpdateParams familyUpdateParams = new FamilyUpdateParams()
                .setId(commandOptions.id)
                .setName(commandOptions.name)
                .setDescription(commandOptions.description)
                .setCreationDate(commandOptions.creationDate)
                .setModificationDate(commandOptions.modificationDate);

        return openCGAClient.getFamilyClient().update(commandOptions.families, familyUpdateParams, queryParams);
    }
    
    private RestResponse<Family> updateAnnotations() throws ClientException {
        logger.debug("Executing updateAnnotations in Family command line");

        FamilyCommandOptions.UpdateAnnotationsCommandOptions commandOptions = familyCommandOptions.updateAnnotationsCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotNull("action", commandOptions.action);
        queryParams.putIfNotNull("incVersion", commandOptions.incVersion);

        ObjectMap map = new ObjectMap();

        return openCGAClient.getFamilyClient().updateAnnotations(commandOptions.family,commandOptions.annotationSet, map, queryParams);
    }
    
}
