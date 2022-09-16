package org.opencb.opencga.app.cli.main.options;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.beust.jcommander.DynamicParameter;
import com.beust.jcommander.ParametersDelegate;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import static org.opencb.opencga.app.cli.GeneralCliOptions.*;


/*
* WARNING: AUTOGENERATED CODE
*
* This code was generated by a tool.
* Autogenerated on: 2022-09-16
*
* Manual changes to this file may cause unexpected behavior in your application.
* Manual changes to this file will be overwritten if the code is regenerated.
*/


/**
 * This class contains methods for the Admin command line.
 *    OpenCGA version: 2.4.4-SNAPSHOT
 *    PATH: /{apiVersion}/admin
 */
@Parameters(commandNames = {"admin"}, commandDescription = "Admin commands")
public class AdminCommandOptions {

        public JCommander jCommander;
        public CommonCommandOptions commonCommandOptions;

        public GroupByAuditCommandOptions groupByAuditCommandOptions;
        public IndexStatsCatalogCommandOptions indexStatsCatalogCommandOptions;
        public InstallCatalogCommandOptions installCatalogCommandOptions;
        public JwtCatalogCommandOptions jwtCatalogCommandOptions;
        public CreateUsersCommandOptions createUsersCommandOptions;
        public ImportUsersCommandOptions importUsersCommandOptions;
        public SearchUsersCommandOptions searchUsersCommandOptions;
        public SyncUsersCommandOptions syncUsersCommandOptions;


    public AdminCommandOptions(CommonCommandOptions commonCommandOptions, JCommander jCommander) {
    
        this.jCommander = jCommander;
        this.commonCommandOptions = commonCommandOptions;
        this.groupByAuditCommandOptions = new GroupByAuditCommandOptions();
        this.indexStatsCatalogCommandOptions = new IndexStatsCatalogCommandOptions();
        this.installCatalogCommandOptions = new InstallCatalogCommandOptions();
        this.jwtCatalogCommandOptions = new JwtCatalogCommandOptions();
        this.createUsersCommandOptions = new CreateUsersCommandOptions();
        this.importUsersCommandOptions = new ImportUsersCommandOptions();
        this.searchUsersCommandOptions = new SearchUsersCommandOptions();
        this.syncUsersCommandOptions = new SyncUsersCommandOptions();
    
    }
    
    @Parameters(commandNames = {"audit-group-by"}, commandDescription ="Group by operation")
    public class GroupByAuditCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--count"}, description = "Count the number of elements matching the group", required = false, help = true, arity = 0)
        public boolean count = false; 
    
        @Parameter(names = {"--limit"}, description = "Maximum number of documents (groups) to be returned", required = false, arity = 1)
        public Integer limit = 50; 
    
        @Parameter(names = {"--fields"}, description = "Comma separated list of fields by which to group by.", required = true, arity = 1)
        public String fields; 
    
        @Parameter(names = {"--entity"}, description = "Entity to be grouped by.", required = true, arity = 1)
        public String entity; 
    
        @Parameter(names = {"--action"}, description = "Action performed", required = false, arity = 1)
        public String action; 
    
        @Parameter(names = {"--before"}, description = "Object before update", required = false, arity = 1)
        public String before; 
    
        @Parameter(names = {"--after"}, description = "Object after update", required = false, arity = 1)
        public String after; 
    
        @Parameter(names = {"--date"}, description = "Date <,<=,>,>=(Format: yyyyMMddHHmmss) and yyyyMMddHHmmss-yyyyMMddHHmmss", required = false, arity = 1)
        public String date; 
    
    }

    @Parameters(commandNames = {"catalog-index-stats"}, commandDescription ="Sync Catalog into the Solr")
    public class IndexStatsCatalogCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--json-file"}, description = "File with the body data in JSON format. Note, that using this parameter will ignore all the other parameters.", required = false, arity = 1)
        public String jsonFile;
    
        @Parameter(names = {"--json-data-model"}, description = "Show example of file structure for body data.", help = true, arity = 0)
        public Boolean jsonDataModel = false;
    
        @Parameter(names = {"--collection"}, description = "Collection to be indexed (file, sample, individual, family, cohort and/or job). If not provided, all of them will be indexed.", required = false, arity = 1)
        public String collection; 
    
    }

    @Parameters(commandNames = {"catalog-install"}, commandDescription ="Install OpenCGA database")
    public class InstallCatalogCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--json-file"}, description = "File with the body data in JSON format. Note, that using this parameter will ignore all the other parameters.", required = false, arity = 1)
        public String jsonFile;
    
        @Parameter(names = {"--json-data-model"}, description = "Show example of file structure for body data.", help = true, arity = 0)
        public Boolean jsonDataModel = false;
    
        @Parameter(names = {"--secret-key"}, description = "The body web service secretKey parameter", required = false, arity = 1)
        public String secretKey;
    
        @Parameter(names = {"--password"}, description = "The body web service password parameter", required = false, arity = 1)
        public String password;
    
        @Parameter(names = {"--email"}, description = "The body web service email parameter", required = false, arity = 1)
        public String email;
    
        @Parameter(names = {"--organization"}, description = "The body web service organization parameter", required = false, arity = 1)
        public String organization;
    
    }

    @Parameters(commandNames = {"catalog-jwt"}, commandDescription ="Change JWT secret key")
    public class JwtCatalogCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--json-file"}, description = "File with the body data in JSON format. Note, that using this parameter will ignore all the other parameters.", required = false, arity = 1)
        public String jsonFile;
    
        @Parameter(names = {"--json-data-model"}, description = "Show example of file structure for body data.", help = true, arity = 0)
        public Boolean jsonDataModel = false;
    
        @Parameter(names = {"--secret-key"}, description = "The body web service secretKey parameter", required = false, arity = 1)
        public String secretKey;
    
    }

    @Parameters(commandNames = {"users-create"}, commandDescription ="Create a new user")
    public class CreateUsersCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--json-file"}, description = "File with the body data in JSON format. Note, that using this parameter will ignore all the other parameters.", required = false, arity = 1)
        public String jsonFile;
    
        @Parameter(names = {"--json-data-model"}, description = "Show example of file structure for body data.", help = true, arity = 0)
        public Boolean jsonDataModel = false;
    
        @Parameter(names = {"--id"}, description = "The body web service id parameter", required = false, arity = 1)
        public String id;
    
        @Parameter(names = {"--name", "-n"}, description = "The body web service name parameter", required = false, arity = 1)
        public String name;
    
        @Parameter(names = {"--email"}, description = "The body web service email parameter", required = false, arity = 1)
        public String email;
    
        @Parameter(names = {"--password"}, description = "The body web service password parameter", required = false, arity = 1)
        public String password;
    
        @Parameter(names = {"--organization"}, description = "The body web service organization parameter", required = false, arity = 1)
        public String organization;
    
        @Parameter(names = {"--type"}, description = "Enum param allowed values: GUEST, FULL, ADMINISTRATOR", required = false, arity = 1)
        public String type;
    
    }

    @Parameters(commandNames = {"users-import"}, commandDescription ="Import users or a group of users from LDAP or AAD")
    public class ImportUsersCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--json-file"}, description = "File with the body data in JSON format. Note, that using this parameter will ignore all the other parameters.", required = false, arity = 1)
        public String jsonFile;
    
        @Parameter(names = {"--json-data-model"}, description = "Show example of file structure for body data.", help = true, arity = 0)
        public Boolean jsonDataModel = false;
    
        @Parameter(names = {"--authentication-origin-id"}, description = "The body web service authenticationOriginId parameter", required = false, arity = 1)
        public String authenticationOriginId;
    
        @Parameter(names = {"--id"}, description = "The body web service id parameter", required = false, arity = 1)
        public String id;
    
        @Parameter(names = {"--resource-type"}, description = "The body web service resourceType parameter", required = false, arity = 1)
        public String resourceType;
    
        @Parameter(names = {"--study", "-s"}, description = "The body web service study parameter", required = false, arity = 1)
        public String study;
    
        @Parameter(names = {"--study-group"}, description = "The body web service studyGroup parameter", required = false, arity = 1)
        public String studyGroup;
    
    }

    @Parameters(commandNames = {"users-search"}, commandDescription ="User search method")
    public class SearchUsersCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--include", "-I"}, description = "Fields included in the response, whole JSON path must be provided", required = false, arity = 1)
        public String include; 
    
        @Parameter(names = {"--exclude", "-E"}, description = "Fields excluded in the response, whole JSON path must be provided", required = false, arity = 1)
        public String exclude; 
    
        @Parameter(names = {"--limit"}, description = "Number of results to be returned", required = false, arity = 1)
        public Integer limit; 
    
        @Parameter(names = {"--skip"}, description = "Number of results to skip", required = false, arity = 1)
        public Integer skip; 
    
        @Parameter(names = {"--count"}, description = "Get the total number of results matching the query. Deactivated by default.", required = false, help = true, arity = 0)
        public boolean count = false; 
    
        @Parameter(names = {"--user", "-u"}, description = "User ID", required = false, arity = 1)
        public String user; 
    
        @Parameter(names = {"--account"}, description = "Account type [GUEST, FULL, ADMINISTRATOR]", required = false, arity = 1)
        public String account; 
    
        @Parameter(names = {"--authentication-id"}, description = "Authentication origin ID", required = false, arity = 1)
        public String authenticationId; 
    
    }

    @Parameters(commandNames = {"users-sync"}, commandDescription ="Synchronise a group of users from an authentication origin with a group in a study from catalog")
    public class SyncUsersCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--json-file"}, description = "File with the body data in JSON format. Note, that using this parameter will ignore all the other parameters.", required = false, arity = 1)
        public String jsonFile;
    
        @Parameter(names = {"--json-data-model"}, description = "Show example of file structure for body data.", help = true, arity = 0)
        public Boolean jsonDataModel = false;
    
        @Parameter(names = {"--authentication-origin-id"}, description = "The body web service authenticationOriginId parameter", required = false, arity = 1)
        public String authenticationOriginId;
    
        @Parameter(names = {"--from"}, description = "The body web service from parameter", required = false, arity = 1)
        public String from;
    
        @Parameter(names = {"--to"}, description = "The body web service to parameter", required = false, arity = 1)
        public String to;
    
        @Parameter(names = {"--study", "-s"}, description = "The body web service study parameter", required = false, arity = 1)
        public String study;
    
        @Parameter(names = {"--sync-all"}, description = "The body web service syncAll parameter", required = false, help = true, arity = 0)
        public boolean syncAll = false;
    
        @Parameter(names = {"--type"}, description = "Enum param allowed values: GUEST, FULL, ADMINISTRATOR", required = false, arity = 1)
        public String type;
    
        @Parameter(names = {"--force"}, description = "The body web service force parameter", required = false, help = true, arity = 0)
        public boolean force = false;
    
    }

}