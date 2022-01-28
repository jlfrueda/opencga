package org.opencb.opencga.app.cli.main.executors;

import org.opencb.opencga.app.cli.main.executors.OpencgaCommandExecutor;
import org.opencb.opencga.app.cli.main.*;
import org.opencb.opencga.core.response.RestResponse;
import org.opencb.opencga.client.exceptions.ClientException;
import org.opencb.commons.datastore.core.ObjectMap;

import org.opencb.opencga.catalog.exceptions.CatalogAuthenticationException;

import java.util.List;

import org.opencb.opencga.app.cli.main.options.MetaCommandOptions;

import java.util.Map;
import java.util.List;


/*
* WARNING: AUTOGENERATED CODE
*
* This code was generated by a tool.
* Autogenerated on: 2022-01-28
*
* Manual changes to this file may cause unexpected behavior in your application.
* Manual changes to this file will be overwritten if the code is regenerated.
*/


/**
 * This class contains methods for the Meta command line.
 *    OpenCGA version: 2.2.0-SNAPSHOT
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
            case "api":
                queryResponse = api();
                break;
            default:
                logger.error("Subcommand not valid");
                break;
        }

        createOutput(queryResponse);

    }

    private RestResponse<List> api() throws Exception {

        logger.debug("Executing api in Meta command line");

        MetaCommandOptions.ApiCommandOptions commandOptions = metaCommandOptions.apiCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("category", commandOptions.category);

        return openCGAClient.getMetaClient().api(queryParams);
    }
}