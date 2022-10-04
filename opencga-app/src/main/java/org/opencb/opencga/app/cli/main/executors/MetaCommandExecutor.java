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

import org.opencb.opencga.app.cli.main.options.MetaCommandOptions;

import java.util.List;
import java.util.Map;


/*
* WARNING: AUTOGENERATED CODE
*
* This code was generated by a tool.
*
* Manual changes to this file may cause unexpected behavior in your application.
* Manual changes to this file will be overwritten if the code is regenerated.
*  
*/
/**
 * This class contains methods for the Meta command line.
 *    PATH: /{apiVersion}/meta
 */
public class MetaCommandExecutor extends OpencgaCommandExecutor {

    private MetaCommandOptions metaCommandOptions;

    public MetaCommandExecutor(MetaCommandOptions metaCommandOptions) throws CatalogAuthenticationException {
        super(metaCommandOptions.commonCommandOptions);
        this.metaCommandOptions = metaCommandOptions;
    }

    @Override
    public void execute() throws Exception {

        logger.debug("Executing Meta command line");

        String subCommandString = getParsedSubCommand(metaCommandOptions.jCommander);

        RestResponse queryResponse = null;

        switch (subCommandString) {
            case "about":
                queryResponse = about();
                break;
            case "api":
                queryResponse = api();
                break;
            case "fail":
                queryResponse = fail();
                break;
            case "model":
                queryResponse = model();
                break;
            case "ping":
                queryResponse = ping();
                break;
            case "status":
                queryResponse = status();
                break;
            default:
                logger.error("Subcommand not valid");
                break;
        }

        createOutput(queryResponse);

    }

    private RestResponse<ObjectMap> about() throws Exception {

        logger.debug("Executing about in Meta command line");

        MetaCommandOptions.AboutCommandOptions commandOptions = metaCommandOptions.aboutCommandOptions;
        return openCGAClient.getMetaClient().about();
    }

    private RestResponse<List> api() throws Exception {

        logger.debug("Executing api in Meta command line");

        MetaCommandOptions.ApiCommandOptions commandOptions = metaCommandOptions.apiCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("category", commandOptions.category);

        return openCGAClient.getMetaClient().api(queryParams);
    }

    private RestResponse<ObjectMap> fail() throws Exception {

        logger.debug("Executing fail in Meta command line");

        MetaCommandOptions.FailCommandOptions commandOptions = metaCommandOptions.failCommandOptions;
        return openCGAClient.getMetaClient().fail();
    }

    private RestResponse<String> model() throws Exception {

        logger.debug("Executing model in Meta command line");

        MetaCommandOptions.ModelCommandOptions commandOptions = metaCommandOptions.modelCommandOptions;
        return openCGAClient.getMetaClient().model();
    }

    private RestResponse<String> ping() throws Exception {

        logger.debug("Executing ping in Meta command line");

        MetaCommandOptions.PingCommandOptions commandOptions = metaCommandOptions.pingCommandOptions;
        return openCGAClient.getMetaClient().ping();
    }

    private RestResponse<ObjectMap> status() throws Exception {

        logger.debug("Executing status in Meta command line");

        MetaCommandOptions.StatusCommandOptions commandOptions = metaCommandOptions.statusCommandOptions;
        return openCGAClient.getMetaClient().status();
    }
}