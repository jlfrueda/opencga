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

import org.opencb.opencga.app.cli.main.options.AdminCommandOptions;

import java.util.Map;
import org.opencb.opencga.core.models.admin.GroupSyncParams;
import org.opencb.opencga.core.models.admin.InstallationParams;
import org.opencb.opencga.core.models.admin.JWTParams;
import org.opencb.opencga.core.models.admin.UserCreateParams;
import org.opencb.opencga.core.models.admin.UserImportParams;
import org.opencb.opencga.core.models.common.Enums.Resource;
import org.opencb.opencga.core.models.sample.Sample;
import org.opencb.opencga.core.models.study.Group;
import org.opencb.opencga.core.models.user.Account;
import org.opencb.opencga.core.models.user.User;


/*
* WARNING: AUTOGENERATED CODE
*
* This code was generated by a tool.
* Autogenerated on: 2022-09-14
*
* Manual changes to this file may cause unexpected behavior in your application.
* Manual changes to this file will be overwritten if the code is regenerated.
*/


/**
 * This class contains methods for the Admin command line.
 *    OpenCGA version: 2.4.4-SNAPSHOT
 *    PATH: /{apiVersion}/admin
 */
public class AdminCommandExecutor extends OpencgaCommandExecutor {

    private AdminCommandOptions adminCommandOptions;

    public AdminCommandExecutor(AdminCommandOptions adminCommandOptions) throws CatalogAuthenticationException {
        super(adminCommandOptions.commonCommandOptions);
        this.adminCommandOptions = adminCommandOptions;
    }

    @Override
    public void execute() throws Exception {

        logger.debug("Executing Admin command line");

        String subCommandString = getParsedSubCommand(adminCommandOptions.jCommander);

        RestResponse queryResponse = null;

        switch (subCommandString) {
            case "audit-group-by":
                queryResponse = groupByAudit();
                break;
            case "catalog-index-stats":
                queryResponse = indexStatsCatalog();
                break;
            case "catalog-install":
                queryResponse = installCatalog();
                break;
            case "catalog-jwt":
                queryResponse = jwtCatalog();
                break;
            case "users-create":
                queryResponse = createUsers();
                break;
            case "users-import":
                queryResponse = importUsers();
                break;
            case "users-search":
                queryResponse = searchUsers();
                break;
            case "users-sync":
                queryResponse = syncUsers();
                break;
            default:
                logger.error("Subcommand not valid");
                break;
        }

        createOutput(queryResponse);

    }

    private RestResponse<ObjectMap> groupByAudit() throws Exception {

        logger.debug("Executing groupByAudit in Admin command line");

        AdminCommandOptions.GroupByAuditCommandOptions commandOptions = adminCommandOptions.groupByAuditCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotNull("count", commandOptions.count);
        queryParams.putIfNotNull("limit", commandOptions.limit);
        queryParams.putIfNotEmpty("action", commandOptions.action);
        queryParams.putIfNotEmpty("before", commandOptions.before);
        queryParams.putIfNotEmpty("after", commandOptions.after);
        queryParams.putIfNotEmpty("date", commandOptions.date);

        return openCGAClient.getAdminClient().groupByAudit(commandOptions.fields, commandOptions.entity, queryParams);
    }

    private RestResponse<Boolean> indexStatsCatalog() throws Exception {

        logger.debug("Executing indexStatsCatalog in Admin command line");

        AdminCommandOptions.IndexStatsCatalogCommandOptions commandOptions = adminCommandOptions.indexStatsCatalogCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("collection", commandOptions.collection);

        return openCGAClient.getAdminClient().indexStatsCatalog(queryParams);
    }

    private RestResponse<ObjectMap> installCatalog() throws Exception {

        logger.debug("Executing installCatalog in Admin command line");

        AdminCommandOptions.InstallCatalogCommandOptions commandOptions = adminCommandOptions.installCatalogCommandOptions;

        InstallationParams installationParams= null;
        if (commandOptions.jsonDataModel) {
            installationParams = new InstallationParams();
            RestResponse<ObjectMap> res = new RestResponse<>();
            res.setType(QueryType.VOID);
            PrintUtils.println(getObjectAsJSON(installationParams));
            return res;
        } else if (commandOptions.jsonFile != null) {
            installationParams = JacksonUtils.getDefaultObjectMapper()
                    .readValue(new java.io.File(commandOptions.jsonFile), InstallationParams.class);
        } else {
            ObjectMap beanParams = new ObjectMap();
            putNestedIfNotEmpty(beanParams, "secretKey",commandOptions.secretKey, true);
             putNestedIfNotEmpty(beanParams, "password",commandOptions.password, true);
             putNestedIfNotEmpty(beanParams, "email",commandOptions.email, true);
             putNestedIfNotEmpty(beanParams, "organization",commandOptions.organization, true);
 
            installationParams = JacksonUtils.getDefaultObjectMapper().copy()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true)
                    .readValue(beanParams.toJson(), InstallationParams.class);
        }
        return openCGAClient.getAdminClient().installCatalog(installationParams);
    }

    private RestResponse<ObjectMap> jwtCatalog() throws Exception {

        logger.debug("Executing jwtCatalog in Admin command line");

        AdminCommandOptions.JwtCatalogCommandOptions commandOptions = adminCommandOptions.jwtCatalogCommandOptions;

        JWTParams jWTParams= null;
        if (commandOptions.jsonDataModel) {
            jWTParams = new JWTParams();
            RestResponse<ObjectMap> res = new RestResponse<>();
            res.setType(QueryType.VOID);
            PrintUtils.println(getObjectAsJSON(jWTParams));
            return res;
        } else if (commandOptions.jsonFile != null) {
            jWTParams = JacksonUtils.getDefaultObjectMapper()
                    .readValue(new java.io.File(commandOptions.jsonFile), JWTParams.class);
        } else {
            ObjectMap beanParams = new ObjectMap();
            putNestedIfNotEmpty(beanParams, "secretKey",commandOptions.secretKey, true);
 
            jWTParams = JacksonUtils.getDefaultObjectMapper().copy()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true)
                    .readValue(beanParams.toJson(), JWTParams.class);
        }
        return openCGAClient.getAdminClient().jwtCatalog(jWTParams);
    }

    private RestResponse<User> createUsers() throws Exception {

        logger.debug("Executing createUsers in Admin command line");

        AdminCommandOptions.CreateUsersCommandOptions commandOptions = adminCommandOptions.createUsersCommandOptions;

        UserCreateParams userCreateParams= null;
        if (commandOptions.jsonDataModel) {
            userCreateParams = new UserCreateParams();
            RestResponse<User> res = new RestResponse<>();
            res.setType(QueryType.VOID);
            PrintUtils.println(getObjectAsJSON(userCreateParams));
            return res;
        } else if (commandOptions.jsonFile != null) {
            userCreateParams = JacksonUtils.getDefaultObjectMapper()
                    .readValue(new java.io.File(commandOptions.jsonFile), UserCreateParams.class);
        } else {
            ObjectMap beanParams = new ObjectMap();
            putNestedIfNotEmpty(beanParams, "id",commandOptions.id, true);
             putNestedIfNotEmpty(beanParams, "name",commandOptions.name, true);
             putNestedIfNotEmpty(beanParams, "email",commandOptions.email, true);
             putNestedIfNotEmpty(beanParams, "password",commandOptions.password, true);
             putNestedIfNotEmpty(beanParams, "organization",commandOptions.organization, true);
             putNestedIfNotNull(beanParams, "type",commandOptions.type, true);
 
            userCreateParams = JacksonUtils.getDefaultObjectMapper().copy()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true)
                    .readValue(beanParams.toJson(), UserCreateParams.class);
        }
        return openCGAClient.getAdminClient().createUsers(userCreateParams);
    }

    private RestResponse<User> importUsers() throws Exception {

        logger.debug("Executing importUsers in Admin command line");

        AdminCommandOptions.ImportUsersCommandOptions commandOptions = adminCommandOptions.importUsersCommandOptions;

        UserImportParams userImportParams= null;
        if (commandOptions.jsonDataModel) {
            userImportParams = new UserImportParams();
            RestResponse<User> res = new RestResponse<>();
            res.setType(QueryType.VOID);
            PrintUtils.println(getObjectAsJSON(userImportParams));
            return res;
        } else if (commandOptions.jsonFile != null) {
            userImportParams = JacksonUtils.getDefaultObjectMapper()
                    .readValue(new java.io.File(commandOptions.jsonFile), UserImportParams.class);
        } else {
            ObjectMap beanParams = new ObjectMap();
            putNestedIfNotEmpty(beanParams, "authenticationOriginId",commandOptions.authenticationOriginId, true);
             putNestedIfNotNull(beanParams, "id",commandOptions.id, true);
             putNestedIfNotNull(beanParams, "resourceType",commandOptions.resourceType, true);
             putNestedIfNotEmpty(beanParams, "study",commandOptions.study, true);
             putNestedIfNotEmpty(beanParams, "studyGroup",commandOptions.studyGroup, true);
 
            userImportParams = JacksonUtils.getDefaultObjectMapper().copy()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true)
                    .readValue(beanParams.toJson(), UserImportParams.class);
        }
        return openCGAClient.getAdminClient().importUsers(userImportParams);
    }

    private RestResponse<Sample> searchUsers() throws Exception {

        logger.debug("Executing searchUsers in Admin command line");

        AdminCommandOptions.SearchUsersCommandOptions commandOptions = adminCommandOptions.searchUsersCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("include", commandOptions.include);
        queryParams.putIfNotEmpty("exclude", commandOptions.exclude);
        queryParams.putIfNotNull("limit", commandOptions.limit);
        queryParams.putIfNotNull("skip", commandOptions.skip);
        queryParams.putIfNotNull("count", commandOptions.count);
        queryParams.putIfNotEmpty("user", commandOptions.user);
        queryParams.putIfNotEmpty("account", commandOptions.account);
        queryParams.putIfNotEmpty("authenticationId", commandOptions.authenticationId);

        return openCGAClient.getAdminClient().searchUsers(queryParams);
    }

    private RestResponse<Group> syncUsers() throws Exception {

        logger.debug("Executing syncUsers in Admin command line");

        AdminCommandOptions.SyncUsersCommandOptions commandOptions = adminCommandOptions.syncUsersCommandOptions;

        GroupSyncParams groupSyncParams= null;
        if (commandOptions.jsonDataModel) {
            groupSyncParams = new GroupSyncParams();
            RestResponse<Group> res = new RestResponse<>();
            res.setType(QueryType.VOID);
            PrintUtils.println(getObjectAsJSON(groupSyncParams));
            return res;
        } else if (commandOptions.jsonFile != null) {
            groupSyncParams = JacksonUtils.getDefaultObjectMapper()
                    .readValue(new java.io.File(commandOptions.jsonFile), GroupSyncParams.class);
        } else {
            ObjectMap beanParams = new ObjectMap();
            putNestedIfNotEmpty(beanParams, "authenticationOriginId",commandOptions.authenticationOriginId, true);
             putNestedIfNotEmpty(beanParams, "from",commandOptions.from, true);
             putNestedIfNotEmpty(beanParams, "to",commandOptions.to, true);
             putNestedIfNotEmpty(beanParams, "study",commandOptions.study, true);
             putNestedIfNotNull(beanParams, "syncAll",commandOptions.syncAll, true);
             putNestedIfNotNull(beanParams, "type",commandOptions.type, true);
             putNestedIfNotNull(beanParams, "force",commandOptions.force, true);
 
            groupSyncParams = JacksonUtils.getDefaultObjectMapper().copy()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true)
                    .readValue(beanParams.toJson(), GroupSyncParams.class);
        }
        return openCGAClient.getAdminClient().syncUsers(groupSyncParams);
    }
}