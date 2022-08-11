package org.opencb.opencga.app.cli.main.executors;

import com.fasterxml.jackson.databind.DeserializationFeature;
import org.opencb.opencga.app.cli.main.executors.OpencgaCommandExecutor;
import org.opencb.opencga.app.cli.main.*;
import org.opencb.opencga.core.response.RestResponse;
import org.opencb.opencga.client.exceptions.ClientException;
import org.opencb.commons.datastore.core.ObjectMap;

import org.opencb.opencga.catalog.exceptions.CatalogAuthenticationException;
import org.opencb.opencga.core.common.JacksonUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.HashMap;
import org.opencb.opencga.core.response.QueryType;
import org.opencb.commons.utils.PrintUtils;

import org.opencb.opencga.app.cli.main.options.ProjectsCommandOptions;

import java.lang.Object;
import org.opencb.commons.datastore.core.FacetField;
import org.opencb.opencga.core.config.storage.CellBaseConfiguration;
import org.opencb.opencga.core.models.project.Project;
import org.opencb.opencga.core.models.project.ProjectCreateParams;
import org.opencb.opencga.core.models.project.ProjectOrganism;
import org.opencb.opencga.core.models.project.ProjectUpdateParams;
import org.opencb.opencga.core.models.study.Study;


/*
* WARNING: AUTOGENERATED CODE
*
* This code was generated by a tool.
* Autogenerated on: 2022-08-11
*
* Manual changes to this file may cause unexpected behavior in your application.
* Manual changes to this file will be overwritten if the code is regenerated.
*/


/**
 * This class contains methods for the Projects command line.
 *    OpenCGA version: 2.4.3-SNAPSHOT
 *    PATH: /{apiVersion}/projects
 */
public class ProjectsCommandExecutor extends OpencgaCommandExecutor {

    private ProjectsCommandOptions projectsCommandOptions;

    public ProjectsCommandExecutor(ProjectsCommandOptions projectsCommandOptions) throws CatalogAuthenticationException {
        super(projectsCommandOptions.commonCommandOptions);
        this.projectsCommandOptions = projectsCommandOptions;
    }

    @Override
    public void execute() throws Exception {

        logger.debug("Executing Projects command line");

        String subCommandString = getParsedSubCommand(projectsCommandOptions.jCommander);

        RestResponse queryResponse = null;

        switch (subCommandString) {
            case "create":
                queryResponse = create();
                break;
            case "search":
                queryResponse = search();
                break;
            case "aggregationstats":
                queryResponse = aggregationStats();
                break;
            case "info":
                queryResponse = info();
                break;
            case "increlease":
                queryResponse = incRelease();
                break;
            case "studies":
                queryResponse = studies();
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

    private RestResponse<Project> create() throws Exception {

        logger.debug("Executing create in Projects command line");

        ProjectsCommandOptions.CreateCommandOptions commandOptions = projectsCommandOptions.createCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("include", commandOptions.include);
        queryParams.putIfNotEmpty("exclude", commandOptions.exclude);
        queryParams.putIfNotNull("includeResult", commandOptions.includeResult);


        ProjectCreateParams projectCreateParams= null;
        if (commandOptions.jsonDataModel) {
            projectCreateParams = new ProjectCreateParams();
            RestResponse<Project> res = new RestResponse<>();
            res.setType(QueryType.VOID);
            PrintUtils.println(getObjectAsJSON(projectCreateParams));
            return res;
        } else if (commandOptions.jsonFile != null) {
            projectCreateParams = JacksonUtils.getDefaultObjectMapper()
                    .readValue(new java.io.File(commandOptions.jsonFile), ProjectCreateParams.class);
        } else {
            ObjectMap beanParams = new ObjectMap();
            putNestedIfNotEmpty(beanParams, "id",commandOptions.id, true);
             putNestedIfNotEmpty(beanParams, "name",commandOptions.name, true);
             putNestedIfNotEmpty(beanParams, "description",commandOptions.description, true);
             putNestedIfNotEmpty(beanParams, "creationDate",commandOptions.creationDate, true);
             putNestedIfNotEmpty(beanParams, "modificationDate",commandOptions.modificationDate, true);
             putNestedIfNotEmpty(beanParams, "organism.scientificName",commandOptions.organismScientificName, true);
             putNestedIfNotEmpty(beanParams, "organism.commonName",commandOptions.organismCommonName, true);
             putNestedIfNotEmpty(beanParams, "organism.assembly",commandOptions.organismAssembly, true);
             putNestedIfNotEmpty(beanParams, "cellbase.url",commandOptions.cellbaseUrl, true);
             putNestedIfNotEmpty(beanParams, "cellbase.version",commandOptions.cellbaseVersion, true);
             putNestedIfNotEmpty(beanParams, "cellbase.preferred",commandOptions.cellbasePreferred, true);
 
            projectCreateParams = JacksonUtils.getDefaultObjectMapper().copy()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true)
                    .readValue(beanParams.toJson(), ProjectCreateParams.class);
        }
        return openCGAClient.getProjectClient().create(projectCreateParams, queryParams);
    }

    private RestResponse<Project> search() throws Exception {

        logger.debug("Executing search in Projects command line");

        ProjectsCommandOptions.SearchCommandOptions commandOptions = projectsCommandOptions.searchCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("include", commandOptions.include);
        queryParams.putIfNotEmpty("exclude", commandOptions.exclude);
        queryParams.putIfNotNull("limit", commandOptions.limit);
        queryParams.putIfNotNull("skip", commandOptions.skip);
        queryParams.putIfNotEmpty("owner", commandOptions.owner);
        queryParams.putIfNotEmpty("id", commandOptions.id);
        queryParams.putIfNotEmpty("name", commandOptions.name);
        queryParams.putIfNotEmpty("fqn", commandOptions.fqn);
        queryParams.putIfNotEmpty("organization", commandOptions.organization);
        queryParams.putIfNotEmpty("description", commandOptions.description);
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("creationDate", commandOptions.creationDate);
        queryParams.putIfNotEmpty("modificationDate", commandOptions.modificationDate);
        queryParams.putIfNotEmpty("internalStatus", commandOptions.internalStatus);
        queryParams.putIfNotEmpty("attributes", commandOptions.attributes);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getProjectClient().search(queryParams);
    }

    private RestResponse<FacetField> aggregationStats() throws Exception {

        logger.debug("Executing aggregationStats in Projects command line");

        ProjectsCommandOptions.AggregationStatsCommandOptions commandOptions = projectsCommandOptions.aggregationStatsCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotNull("default_values", commandOptions.default_values);
        queryParams.putIfNotEmpty("fileFields", commandOptions.fileFields);
        queryParams.putIfNotEmpty("individualFields", commandOptions.individualFields);
        queryParams.putIfNotEmpty("familyFields", commandOptions.familyFields);
        queryParams.putIfNotEmpty("sampleFields", commandOptions.sampleFields);
        queryParams.putIfNotEmpty("cohortFields", commandOptions.cohortFields);
        queryParams.putIfNotEmpty("jobFields", commandOptions.jobFields);

        return openCGAClient.getProjectClient().aggregationStats(commandOptions.projects, queryParams);
    }

    private RestResponse<Project> info() throws Exception {

        logger.debug("Executing info in Projects command line");

        ProjectsCommandOptions.InfoCommandOptions commandOptions = projectsCommandOptions.infoCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("include", commandOptions.include);
        queryParams.putIfNotEmpty("exclude", commandOptions.exclude);

        return openCGAClient.getProjectClient().info(commandOptions.projects, queryParams);
    }

    private RestResponse<Integer> incRelease() throws Exception {

        logger.debug("Executing incRelease in Projects command line");

        ProjectsCommandOptions.IncReleaseCommandOptions commandOptions = projectsCommandOptions.incReleaseCommandOptions;
        return openCGAClient.getProjectClient().incRelease(commandOptions.project);
    }

    private RestResponse<Study> studies() throws Exception {

        logger.debug("Executing studies in Projects command line");

        ProjectsCommandOptions.StudiesCommandOptions commandOptions = projectsCommandOptions.studiesCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("include", commandOptions.include);
        queryParams.putIfNotEmpty("exclude", commandOptions.exclude);
        queryParams.putIfNotNull("limit", commandOptions.limit);
        queryParams.putIfNotNull("skip", commandOptions.skip);

        return openCGAClient.getProjectClient().studies(commandOptions.project, queryParams);
    }

    private RestResponse<Project> update() throws Exception {

        logger.debug("Executing update in Projects command line");

        ProjectsCommandOptions.UpdateCommandOptions commandOptions = projectsCommandOptions.updateCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("include", commandOptions.include);
        queryParams.putIfNotEmpty("exclude", commandOptions.exclude);
        queryParams.putIfNotNull("includeResult", commandOptions.includeResult);


        ProjectUpdateParams projectUpdateParams= null;
        if (commandOptions.jsonDataModel) {
            projectUpdateParams = new ProjectUpdateParams();
            RestResponse<Project> res = new RestResponse<>();
            res.setType(QueryType.VOID);
            PrintUtils.println(getObjectAsJSON(projectUpdateParams));
            return res;
        } else if (commandOptions.jsonFile != null) {
            projectUpdateParams = JacksonUtils.getDefaultObjectMapper()
                    .readValue(new java.io.File(commandOptions.jsonFile), ProjectUpdateParams.class);
        } else {
            ObjectMap beanParams = new ObjectMap();
            putNestedIfNotEmpty(beanParams, "name",commandOptions.name, true);
             putNestedIfNotEmpty(beanParams, "description",commandOptions.description, true);
             putNestedIfNotEmpty(beanParams, "creationDate",commandOptions.creationDate, true);
             putNestedIfNotEmpty(beanParams, "modificationDate",commandOptions.modificationDate, true);
             putNestedIfNotEmpty(beanParams, "organism.scientificName",commandOptions.organismScientificName, true);
             putNestedIfNotEmpty(beanParams, "organism.commonName",commandOptions.organismCommonName, true);
             putNestedIfNotEmpty(beanParams, "organism.assembly",commandOptions.organismAssembly, true);
 
            projectUpdateParams = JacksonUtils.getDefaultObjectMapper().copy()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true)
                    .readValue(beanParams.toJson(), ProjectUpdateParams.class);
        }
        return openCGAClient.getProjectClient().update(commandOptions.project, projectUpdateParams, queryParams);
    }
}