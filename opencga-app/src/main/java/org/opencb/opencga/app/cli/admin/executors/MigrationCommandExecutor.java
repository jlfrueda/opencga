package org.opencb.opencga.app.cli.admin.executors;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.apache.commons.lang3.tuple.Pair;
import org.bson.Document;
import org.opencb.biodata.models.clinical.interpretation.Software;
import org.opencb.commons.datastore.core.ObjectMap;
import org.opencb.commons.datastore.core.Query;
import org.opencb.commons.datastore.core.QueryOptions;
import org.opencb.commons.datastore.mongodb.MongoDBCollection;
import org.opencb.commons.datastore.mongodb.MongoDBConfiguration;
import org.opencb.commons.utils.CryptoUtils;
import org.opencb.opencga.app.cli.admin.executors.migration.AnnotationSetMigration;
import org.opencb.opencga.app.cli.admin.executors.migration.NewVariantMetadataMigration;
import org.opencb.opencga.app.cli.admin.executors.migration.storage.NewProjectMetadataMigration;
import org.opencb.opencga.app.cli.admin.executors.migration.storage.NewStudyMetadata;
import org.opencb.opencga.app.cli.admin.executors.migration.v2_0_0.VariantStorage200MigrationTool;
import org.opencb.opencga.app.cli.admin.options.MigrationCommandOptions;
import org.opencb.opencga.app.cli.main.io.Table;
import org.opencb.opencga.catalog.db.api.DBIterator;
import org.opencb.opencga.catalog.db.api.FileDBAdaptor;
import org.opencb.opencga.catalog.db.api.StudyDBAdaptor;
import org.opencb.opencga.catalog.db.mongodb.MongoDBAdaptorFactory;
import org.opencb.opencga.catalog.db.mongodb.MongoDBUtils;
import org.opencb.opencga.catalog.exceptions.CatalogAuthenticationException;
import org.opencb.opencga.catalog.exceptions.CatalogDBException;
import org.opencb.opencga.catalog.exceptions.CatalogException;
import org.opencb.opencga.catalog.managers.CatalogManager;
import org.opencb.opencga.catalog.managers.FamilyManager;
import org.opencb.opencga.catalog.migration.Migration;
import org.opencb.opencga.catalog.migration.MigrationManager;
import org.opencb.opencga.catalog.migration.MigrationRun;
import org.opencb.opencga.catalog.utils.UuidUtils;
import org.opencb.opencga.core.api.ParamConstants;
import org.opencb.opencga.core.common.JacksonUtils;
import org.opencb.opencga.core.common.TimeUtils;
import org.opencb.opencga.core.models.common.CustomStatus;
import org.opencb.opencga.core.models.common.Enums;
import org.opencb.opencga.core.models.family.Family;
import org.opencb.opencga.core.models.file.FileExperiment;
import org.opencb.opencga.core.models.file.FileInternal;
import org.opencb.opencga.core.models.job.Job;
import org.opencb.opencga.core.models.project.Project;
import org.opencb.opencga.core.models.study.Study;
import org.opencb.opencga.core.models.study.StudyUpdateParams;
import org.opencb.opencga.core.models.study.VariableSet;
import org.opencb.opencga.core.models.study.configuration.ClinicalAnalysisStudyConfiguration;
import org.opencb.opencga.core.models.study.configuration.StudyConfiguration;
import org.opencb.opencga.core.response.OpenCGAResult;
import org.opencb.opencga.core.tools.migration.v2_0_0.VariantStorage200MigrationToolParams;

import java.io.*;
import java.nio.file.Paths;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.opencb.opencga.core.api.ParamConstants.*;

/**
 * Created on 08/09/17.
 *
 * @author Jacobo Coll &lt;jacobo167@gmail.com&gt;
 */
public class MigrationCommandExecutor extends AdminCommandExecutor {

    private final MigrationCommandOptions migrationCommandOptions;
    private OpencgaVersion opencgaVersion;

    public MigrationCommandExecutor(MigrationCommandOptions migrationCommandOptions) {
        super(migrationCommandOptions.getCommonOptions());
        this.migrationCommandOptions = migrationCommandOptions;
    }

    @Override
    public void execute() throws Exception {
        logger.debug("Executing migration command line");

        String subCommandString = migrationCommandOptions.getSubCommand();
        switch (subCommandString) {
            case "search":
                search();
                break;
//            case "latest":
            case "v1.3.0":
                v1_3_0();
                break;
            case "v1.4.0":
                v1_4_0();
                break;
            case "v2.0.0":
                v2_0_0();
                break;
            case "v2.0.1":
                v2_0_1();
                break;
            case "v2.0.3":
                v2_0_3();
                break;
            case "v2.1.0":
                v2_1_0();
                break;
            default:
                logger.error("Subcommand '{}' not valid", subCommandString);
                break;
        }
    }

    private void search() throws CatalogException {
        MigrationCommandOptions.SearchCommandOptions options = migrationCommandOptions.getSearchCommandOptions();
        setCatalogDatabaseCredentials(options, options.commonOptions);

        try (CatalogManager catalogManager = new CatalogManager(configuration)) {
            String token = catalogManager.getUserManager().loginAsAdmin(options.commonOptions.adminPassword).getToken();

            List<Pair<Migration, MigrationRun>> rows = catalogManager.getMigrationManager()
                    .getMigrationRuns(options.version, options.domain, options.status, token);

            Table<Pair<Migration, MigrationRun>> table = new Table<Pair<Migration, MigrationRun>>(Table.PrinterType.JANSI)
                    .addColumn("ID", p -> p.getKey().id(), 50)
                    .addColumn("Description", p -> p.getKey().description(), 50)
                    .addColumnEnum("Domain", p -> p.getKey().domain())
                    .addColumn("Version", p -> p.getKey().version())
                    .addColumnEnum("Language", p -> p.getKey().language())
                    .addColumn("Manual", p -> Boolean.toString(p.getKey().manual()))
                    .addColumnNumber("Patch", p -> p.getKey().patch())
                    .addColumn("Status", MigrationCommandExecutor::getMigrationStatus)
                    .addColumnNumber("RunPatch", p -> p.getValue().getPatch())
                    .addColumn("ExecutionTime", p -> p.getValue().getStart() + " " + TimeUtils.durationToString(ChronoUnit.MILLIS.between(
                            p.getValue().getStart().toInstant(),
                            p.getValue().getEnd().toInstant())))
                    .addColumn("Exception", p -> p.getValue().getException());

            table.printTable(rows);
        }
    }

    public static String getMigrationStatus(Pair<Migration, MigrationRun> p) {
        if (p.getValue() == null) {
            return "PENDING";
        } else {
            return p.getValue().getStatus().name();
        }
    }

    private void v1_3_0() throws Exception {
        logger.info("MIGRATING v1.3.0");
        MigrationCommandOptions.MigrateV1_3_0CommandOptions options = migrationCommandOptions.getMigrateV130CommandOptions();

        if (options.files != null && !options.files.isEmpty()) {
            // Just migrate files. Do not even connect to Catalog!
            NewVariantMetadataMigration migration = new NewVariantMetadataMigration(storageConfiguration, null, options);
            for (String file : options.files) {
                migration.migrateVariantFileMetadataFile(Paths.get(file));
            }
        } else {
            setCatalogDatabaseCredentials(options, options.commonOptions);

            try (CatalogManager catalogManager = new CatalogManager(configuration)) {
                String sessionId = catalogManager.getUserManager().loginAsAdmin(options.commonOptions.adminPassword).getToken();

                // Catalog
                String basePath = appHome + "/misc/migration/v1.3.0/";

                String authentication = "";
                if (StringUtils.isNotEmpty(configuration.getCatalog().getDatabase().getUser())
                        && StringUtils.isNotEmpty(configuration.getCatalog().getDatabase().getPassword())) {
                    authentication = "-u " + configuration.getCatalog().getDatabase().getUser() + " -p "
                            + configuration.getCatalog().getDatabase().getPassword() + " --authenticationDatabase "
                            + configuration.getCatalog().getDatabase().getOptions().getOrDefault("authenticationDatabase", "admin") + " ";
                }

                String catalogCli = "mongo " + authentication + configuration.getCatalog().getDatabase().getHosts().get(0) + "/"
                        + catalogManager.getCatalogDatabase() + " opencga_catalog_v1.2.x_to_1.3.0.js";

                logger.info("Migrating Catalog. Running {} from {}", catalogCli, basePath);
                ProcessBuilder processBuilder = new ProcessBuilder(catalogCli.split(" "));
                processBuilder.directory(new File(basePath));
                Process p = processBuilder.start();

                BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String line;
                while ((line = input.readLine()) != null) {
                    logger.info(line);
                }
                input.close();

                p.waitFor();
                if (p.exitValue() != 0) {
                    throw new IllegalStateException("Error migrating catalog database!");
                }

                // Storage

                new NewVariantMetadataMigration(storageConfiguration, catalogManager, options).migrate(sessionId);
            }
        }
    }

    private void v1_4_0() throws Exception {
        MigrationCommandOptions.MigrateV1_4_0CommandOptions options = migrationCommandOptions.getMigrateV140CommandOptions();

        boolean skipAnnotations = false;
        boolean skipCatalogJS = false;
        boolean skipStorage = false;
        switch (options.what) {
            case CATALOG:
                skipStorage = true;
                break;
            case STORAGE:
                skipAnnotations = true;
                skipCatalogJS = true;
                break;
            case ANNOTATIONS:
                skipCatalogJS = true;
                skipStorage = true;
                break;
            case CATALOG_NO_ANNOTATIONS:
                skipAnnotations = true;
                skipStorage = true;
                break;
            case ALL:
            default:
                break;
        }

        setCatalogDatabaseCredentials(options, options.commonOptions);

        try (CatalogManager catalogManager = new CatalogManager(configuration)) {
            // We get a non-expiring token
            String token = catalogManager.getUserManager().loginAsAdmin(options.commonOptions.adminPassword).getToken();
            String nonExpiringToken = catalogManager.getUserManager().getAdminNonExpiringToken(token);

            // Catalog
            if (!skipCatalogJS) {
                logger.info("Starting Catalog migration for 1.4.0");
                runMigration(catalogManager, appHome + "/misc/migration/v1.4.0/", "opencga_catalog_v1.3.x_to_1.4.0.js");
            }

            if (!skipAnnotations) {
                logger.info("Starting annotation migration for 1.4.0");

                // Migrate annotationSets
                new AnnotationSetMigration(catalogManager).migrate();

                logger.info("Finished annotation migration");
            }

            if (!skipStorage) {
                new NewProjectMetadataMigration(storageConfiguration, catalogManager, options).migrate(nonExpiringToken);
                new NewStudyMetadata(storageConfiguration, catalogManager).migrate(nonExpiringToken);
            }

        }
    }


    private void v2_0_0() throws Exception {
        MigrationCommandOptions.MigrateV2_0_0CommandOptions options = migrationCommandOptions.getMigrateV200CommandOptions();

        setCatalogDatabaseCredentials(options, options.commonOptions);


        final boolean skipRc1;
        final boolean skipRc2;
        final boolean skipFinalRelease;
        final boolean variantStorage;
        switch (options.what) {
            case VARIANT_STORAGE:
                skipRc1 = true;
                skipRc2 = true;
                skipFinalRelease = true;
                variantStorage = true;
                break;
            case RC1:
                skipRc1 = false;
                skipRc2 = true;
                skipFinalRelease = true;
                variantStorage = false;
                break;
            case RC2:
                skipRc1 = true;
                skipRc2 = false;
                skipFinalRelease = true;
                variantStorage = false;
                break;
            case STABLE:
                skipRc1 = true;
                skipRc2 = true;
                skipFinalRelease = false;
                variantStorage = false;
                break;
            case ALL:
                skipRc1 = false;
                skipRc2 = false;
                skipFinalRelease = false;
                variantStorage = true;
                break;
            default:
                throw new IllegalArgumentException("Unknown param " + options.what);
        }

        // Check administrator password
        MongoDBAdaptorFactory factory = new MongoDBAdaptorFactory(configuration);
        MongoDBCollection metaCollection = factory.getMongoDBCollectionMap().get(MongoDBAdaptorFactory.METADATA_COLLECTION);

        if (!skipRc1) {
            if (StringUtils.isEmpty(options.jobFolder)) {
                logger.error("Missing mandatory --job-directory parameter.");
                return;
            }

            String cypheredPassword = CryptoUtils.sha1(options.commonOptions.adminPassword);
            Document document = new Document("admin.password", cypheredPassword);
            if (metaCollection.count(document).getNumMatches() == 0) {
                throw CatalogAuthenticationException.incorrectUserOrPassword();
            }

            try (CatalogManager catalogManager = new CatalogManager(configuration)) {
                // 1. Catalog Javascript migration
                logger.info("Starting Catalog migration for 2.0.0 RC1");
                runMigration(catalogManager, appHome + "/misc/migration/v2.0.0-rc1/", "opencga_catalog_v1.4.2_to_v2.0.0-rc1.js");

                String token = catalogManager.getUserManager().loginAsAdmin(options.commonOptions.adminPassword).getToken();
                token = catalogManager.getUserManager().getAdminNonExpiringToken(token);

                // Create default project and study for administrator #1491
                catalogManager.getProjectManager().create(ADMIN_PROJECT, ADMIN_PROJECT, "Default project", "", "", "", null, token);
                catalogManager.getStudyManager().create(ADMIN_PROJECT, ADMIN_STUDY, ADMIN_STUDY, ADMIN_STUDY, "Default study",
                        null, null, null, Collections.emptyMap(), null, token);

                // Create default JOBS folder for analysis
                MongoDBAdaptorFactory dbAdaptorFactory = new MongoDBAdaptorFactory(configuration);
                QueryOptions queryOptions = new QueryOptions(QueryOptions.INCLUDE, Arrays.asList(StudyDBAdaptor.QueryParams.UID.key(),
                        StudyDBAdaptor.QueryParams.FQN.key(), StudyDBAdaptor.QueryParams.URI.key(), StudyDBAdaptor.QueryParams.RELEASE.key()));
                DBIterator<Study> iterator = dbAdaptorFactory.getCatalogStudyDBAdaptor().iterator(new Query(), queryOptions);

                Query fileQuery = new Query(FileDBAdaptor.QueryParams.PATH.key(), "JOBS/");
                while (iterator.hasNext()) {
                    Study study = iterator.next();
                    fileQuery.append(FileDBAdaptor.QueryParams.STUDY_UID.key(), study.getUid());
                    if (dbAdaptorFactory.getCatalogFileDBAdaptor().count(fileQuery).getNumMatches() == 0) {
                        logger.info("Creating JOBS/ folder for study {}", study.getFqn());

                        // JOBS folder does not exist
                        org.opencb.opencga.core.models.file.File file = new org.opencb.opencga.core.models.file.File("JOBS",
                                org.opencb.opencga.core.models.file.File.Type.DIRECTORY, org.opencb.opencga.core.models.file.File.Format.UNKNOWN,
                                org.opencb.opencga.core.models.file.File.Bioformat.UNKNOWN,
                                Paths.get(options.jobFolder).normalize().toAbsolutePath().resolve("JOBS").toUri(),
                                "JOBS/", null, TimeUtils.getTime(), TimeUtils.getTime(), "Default jobs folder",
                                false, 0, new Software(), new FileExperiment(), Collections.emptyList(), Collections.emptyList(), "",
                                study.getRelease(), Collections.emptyList(), null, Collections.emptyMap(), new CustomStatus(),
                                FileInternal.initialize(), Collections.emptyMap());
                        file.setUuid(UuidUtils.generateOpenCgaUuid(UuidUtils.Entity.FILE));
                        file.setTags(Collections.emptyList());
                        file.setId(file.getPath().replace("/", ":"));

                        dbAdaptorFactory.getCatalogFileDBAdaptor().insert(study.getUid(), file, null, null, null, QueryOptions.empty());

                        // Create physical folder
                        catalogManager.getIoManagerFactory().get(file.getUri()).createDirectory(file.getUri(), true);
                    } else {
                        logger.info("JOBS/ folder already present for study {}", study.getFqn());
                    }
                }
            }
        }
        if (!skipRc2) {
            try (CatalogManager catalogManager = new CatalogManager(configuration)) {
                String adminToken = catalogManager.getUserManager().loginAsAdmin(options.commonOptions.adminPassword).getToken();
                adminToken = catalogManager.getUserManager().getAdminNonExpiringToken(adminToken);

                logger.info("Starting Catalog migration for 2.0.0 RC2");
                runMigration(catalogManager, appHome + "/misc/migration/v2.0.0-rc2/", "opencga_catalog_v2.0.0-rc1_to_v2.0.0-rc2.js");

                // Add automatically roles to all the family members
                QueryOptions familyUpdateOptions = new QueryOptions(ParamConstants.FAMILY_UPDATE_ROLES_PARAM, true);
                for (Project project : catalogManager.getProjectManager().get(new Query(), new QueryOptions(), adminToken).getResults()) {
                    if (project.getStudies() != null) {
                        for (Study study : project.getStudies()) {
                            logger.info("Updating family roles from study {}", study.getFqn());
                            catalogManager.getFamilyManager().update(study.getFqn(), new Query(), null, familyUpdateOptions, adminToken);
                        }
                    }
                }
            }
        }
        if (!skipFinalRelease) {
            try (CatalogManager catalogManager = new CatalogManager(configuration)) {
                String adminToken = catalogManager.getUserManager().loginAsAdmin(options.commonOptions.adminPassword).getToken();
                adminToken = catalogManager.getUserManager().getAdminNonExpiringToken(adminToken);

                if (!needsMigration(metaCollection, 20000, 5)) {
                    logger.info("DB already migrated to STABLE version. Nothing to migrate");
                    return;
                }

                logger.info("Starting Catalog migration for stable 2.0.0");
                runMigration(catalogManager, appHome + "/misc/migration/v2.0.0/", "opencga_catalog_v2.0.0-rc2_to_v2.0.0.js");

                if (!needsMigration(metaCollection, 20000, 5)) {
                    logger.info("DB already migrated to STABLE version. Nothing to migrate");
                    return;
                }

                fetchUpdateVersionVariables(metaCollection);

                if (needsUpdate(1)) {
                    StudyUpdateParams updateParams = new StudyUpdateParams()
                            .setConfiguration(new StudyConfiguration(ClinicalAnalysisStudyConfiguration.defaultConfiguration(), null));

                    // Create default study configuration
                    for (Project project : catalogManager.getProjectManager().get(new Query(), new QueryOptions(), adminToken).getResults()) {
                        String token = catalogManager.getUserManager().getNonExpiringToken(project.getFqn().split("@")[0], adminToken);
                        if (project.getStudies() != null) {
                            for (Study study : project.getStudies()) {
                                if (study.getInternal() == null || study.getInternal().getConfiguration() == null) {
                                    logger.info("Updating study configuration from study '{}'", study.getFqn());
                                    catalogManager.getStudyManager().update(study.getFqn(), updateParams, QueryOptions.empty(), token);
                                }
                            }
                        }
                    }
                    updateLastUpdate(metaCollection, 1);
                }

                if (needsUpdate(2)) {
                    VariableSet variableSet;
                    try {
                        InputStream inputStream = this.getClass().getClassLoader()
                                .getResource("variablesets/sample-variant-stats-variableset.json").openStream();
                        variableSet = JacksonUtils.getDefaultNonNullObjectMapper().readValue(inputStream, VariableSet.class);
                    } catch (IOException e) {
                        logger.error("Could not read Variable set 'variablesets/sample-variant-stats-variableset.json'", e);
                        return;
                    }

                    // Create default opencga_sample_variant_stats variable set
                    for (Project project : catalogManager.getProjectManager().get(new Query(), new QueryOptions(), adminToken).getResults()) {
                        String token = catalogManager.getUserManager().getNonExpiringToken(project.getFqn().split("@")[0], adminToken);
                        if (project.getStudies() != null) {
                            for (Study study : project.getStudies()) {
                                QueryOptions studyOptions = new QueryOptions(QueryOptions.INCLUDE, StudyDBAdaptor.QueryParams.VARIABLE_SET_ID.key());
                                List<VariableSet> variableSets = factory.getCatalogStudyDBAdaptor().get(study.getUid(), studyOptions).first().getVariableSets();

                                boolean variableSetExists = false;
                                for (VariableSet vs : variableSets) {
                                    if ("opencga_sample_variant_stats".equals(vs.getId())) {
                                        variableSetExists = true;
                                        break;
                                    }
                                }
                                if (!variableSetExists) {
                                    logger.info("Creating sample variant stats Variable set for study '{}'", study.getFqn());
                                    catalogManager.getStudyManager().createVariableSet(study.getFqn(), variableSet, token);
                                }
                            }
                        }
                    }

                    updateLastUpdate(metaCollection, 2);
                }

            }
        }
        if (variantStorage) {
            logger.info("Migrate variant storage");
            try (CatalogManager catalogManager = new CatalogManager(configuration)) {
                String adminToken = catalogManager.getUserManager().loginAsAdmin(options.commonOptions.adminPassword).getToken();
                List<Project> projects = catalogManager.getProjectManager()
                        .get(new Query(), new QueryOptions(QueryOptions.INCLUDE, "id,fqn"), adminToken).getResults();
                String theProject = options.commonOptions.commonOptions.params.get(ParamConstants.PROJECT_PARAM);
                for (Project project : projects) {
                    if (project.getFqn().startsWith(ParamConstants.OPENCGA_USER_ID)) {
                        // Skip opencga projects.
                        continue;
                    }
                    if (StringUtils.isNotEmpty(theProject) && !theProject.equals(project.getFqn())) {
                        // project from -Dproject=XXXX is not this project. Skip!
                        continue;
                    }
                    logger.info("Migrate project {}", project.getFqn());
                    VariantStorage200MigrationToolParams toolParams = new VariantStorage200MigrationToolParams()
                            .setRemoveSpanDeletions(true)
                            .setProject(project.getFqn());
                    toolParams.updateParams(new ObjectMap(options.commonOptions.commonOptions.params));
                    Job job = catalogManager.getJobManager()
                            .submit(ADMIN_STUDY_FQN, VariantStorage200MigrationTool.ID, Enums.Priority.HIGH, toolParams.toParams(), adminToken)
                            .first();
                    logger.info("Submitted job " + job.getId());
                }
            }
        }
    }


    private void v2_0_1() throws Exception {
        MigrationCommandOptions.MigrateV2_0_1CommandOptions options = migrationCommandOptions.getMigrateV201CommandOptions();
        setCatalogDatabaseCredentials(options, options.commonOptions);

        try (CatalogManager catalogManager = new CatalogManager(configuration)) {
            // Check admin password
            catalogManager.getUserManager().loginAsAdmin(options.commonOptions.adminPassword);

            // 1. Catalog Javascript migration
            logger.info("Starting Catalog migration for 2.0.1");
            runMigration(catalogManager, appHome + "/misc/migration/v2.0.1/", "opencga_catalog_v2.0.0_to_v2.0.1.js");
        }
    }

    private void v2_0_3() throws CatalogException {
        MigrationCommandOptions.MigrateV2_0_3CommandOptions options = migrationCommandOptions.getMigrateV203CommandOptions();
        setCatalogDatabaseCredentials(options, options.commonOptions);

        MongoDBAdaptorFactory factory = new MongoDBAdaptorFactory(configuration);
        MongoDBCollection metaCollection = factory.getMongoDBCollectionMap().get(MongoDBAdaptorFactory.METADATA_COLLECTION);

        OpencgaVersion opencgaVersion = null;
        try (CatalogManager catalogManager = new CatalogManager(configuration)) {
            // Check admin password
            String adminToken = catalogManager.getUserManager().loginAsAdmin(options.commonOptions.adminPassword).getToken();
            adminToken = catalogManager.getUserManager().getAdminNonExpiringToken(adminToken);

            if (!needsMigration(metaCollection, 20003, 1)) {
                logger.info("DB already migrated to v2.0.3. Nothing to migrate");
                return;
            }
            opencgaVersion = new OpencgaVersion(20003, 1, this.opencgaVersion.getLastJavaUpdate(), this.opencgaVersion.getLastJsUpdate());

            logger.info("Starting Catalog migration for 2.0.3");
            if (needsUpdate(1)) {
                StopWatch stopWatch = new StopWatch();
                // Add automatically roles to all the family members
                QueryOptions familyUpdateOptions = new QueryOptions(ParamConstants.FAMILY_UPDATE_ROLES_PARAM, true);
                QueryOptions queryOptions = new QueryOptions(FamilyManager.INCLUDE_FAMILY_IDS)
                        .append(QueryOptions.LIMIT, 1000);
                for (Project project : catalogManager.getProjectManager().get(new Query(), new QueryOptions(), adminToken).getResults()) {
                    if (project.getStudies() != null) {
                        for (Study study : project.getStudies()) {
                            stopWatch.start();

                            int skip = 0;
                            boolean more = true;
                            do {
                                queryOptions.put(QueryOptions.SKIP, skip);

                                OpenCGAResult<Family> search = catalogManager.getFamilyManager().search(study.getFqn(), new Query(),
                                        queryOptions, adminToken);
                                if (search.getNumResults() < 1000) {
                                    more = false;
                                }
                                skip += search.getNumResults();

                                for (Family family : search.getResults()) {
                                    try {
                                        catalogManager.getFamilyManager().update(study.getFqn(), family.getId(), null, familyUpdateOptions,
                                                adminToken);
                                        logger.info("Updated roles from family '{}' - '{}'", study.getFqn(), family.getId());
                                    } catch (CatalogException e) {
                                        continue;
                                    }
                                }

                                logger.info("Updated {} families in study '{}' in {} seconds", skip, study.getFqn(),
                                        stopWatch.getTime(TimeUnit.SECONDS));
                            } while(more);

                            stopWatch.stop();
                            stopWatch.reset();
                        }
                    }
                }

                opencgaVersion.incrementLastJavaUpdate();
            }
        } catch (CatalogException e) {
            logger.error("Error migration to v2.0.3: {}", e.getMessage(), e);
        } finally {
            if (opencgaVersion != null) {
                updateOpencgaVersion(metaCollection, opencgaVersion);
            }
        }
    }

    private void v2_1_0() throws CatalogException {
        MigrationCommandOptions.MigrateV2_1_0CommandOptions options = migrationCommandOptions.getMigrateV210CommandOptions();
        setCatalogDatabaseCredentials(options, options.commonOptions);

        try (CatalogManager catalogManager = new CatalogManager(configuration)) {
            String token = catalogManager.getUserManager().loginAsAdmin(adminPassword).getToken();
            MigrationManager migrationManager = catalogManager.getMigrationManager();
            migrationManager.runMigration("2.1.0", appHome, token);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }


    private boolean needsMigration(MongoDBCollection metaCollection, int version, int release) {
        fetchUpdateVersionVariables(metaCollection);
        logger.info("Current version: {}", this.opencgaVersion.getVersion());
        logger.info("Current release: {}", this.opencgaVersion.getRelease());
        logger.info("Expected version: {}", version);
        logger.info("Expected release: {}", release);
        boolean needsMigration = this.opencgaVersion.getVersion() < version
                || (this.opencgaVersion.getVersion() == version && this.opencgaVersion.getRelease() <= release);
        if (needsMigration && this.opencgaVersion.getVersion() < version) {
            // Reset counters
            this.opencgaVersion.setLastJavaUpdate(0);
            this.opencgaVersion.setLastJsUpdate(0);
        }
        return needsMigration;
    }

    private void fetchUpdateVersionVariables(MongoDBCollection metaCollection) {
        // Obtain the latest changes made to the DB
        Document metaDocument = metaCollection.find(new Document(), QueryOptions.empty()).first();
        Object fullVersion = metaDocument.get("_fullVersion");
        int version = 20000;
        int release = 4;
        int lastUpdate = 0;
        int lastJsUpdate = 0;
        if (fullVersion != null) {
            version = ((Number) ((Document) fullVersion).get("version")).intValue();
            release = ((Number) ((Document) fullVersion).get("release")).intValue();
            lastUpdate = ((Number) ((Document) fullVersion).get("lastJavaUpdate")).intValue();
            lastJsUpdate = ((Number) ((Document) fullVersion).get("lastJsUpdate")).intValue();
        }

        this.opencgaVersion = new OpencgaVersion(version, release, lastUpdate, lastJsUpdate);
    }

    private boolean needsUpdate(int update) {
        return this.opencgaVersion.getLastJavaUpdate() < update;
    }

    @Deprecated
    private void updateLastUpdate(MongoDBCollection metaCollection, int update) {
        metaCollection.update(new Document(), new Document("$set", new Document("_fullVersion.lastJavaUpdate", update)),
                QueryOptions.empty());
    }

    private void updateOpencgaVersion(MongoDBCollection metaCollection, OpencgaVersion opencgaVersion) throws CatalogDBException {
        logger.info("Updating migration metadata with: {}", opencgaVersion.toString());
        Document versionDoc = MongoDBUtils.getMongoDBDocument(opencgaVersion, "OpencgaVersion");
        metaCollection.update(new Document(), new Document("$set", new Document("_fullVersion", versionDoc)), QueryOptions.empty());
    }

    private void runMigration(CatalogManager catalogManager, String scriptFolder, String scriptFileName)
            throws IOException, InterruptedException, CatalogException {
        String authentication = "";
        if (StringUtils.isNotEmpty(configuration.getCatalog().getDatabase().getUser())
                && StringUtils.isNotEmpty(configuration.getCatalog().getDatabase().getPassword())) {
            authentication = "-u " + configuration.getCatalog().getDatabase().getUser() + " -p "
                    + configuration.getCatalog().getDatabase().getPassword() + " --authenticationDatabase "
                    + configuration.getCatalog().getDatabase().getOptions().getOrDefault("authenticationDatabase", "admin") + " ";
        }
        if (configuration.getCatalog().getDatabase().getOptions() != null
                && configuration.getCatalog().getDatabase().getOptions().containsKey(MongoDBConfiguration.SSL_ENABLED)
                && Boolean.parseBoolean(configuration.getCatalog().getDatabase().getOptions().get(MongoDBConfiguration.SSL_ENABLED))) {
            authentication += "--ssl ";
        }
        if (configuration.getCatalog().getDatabase().getOptions() != null
                && configuration.getCatalog().getDatabase().getOptions().containsKey(MongoDBConfiguration.SSL_INVALID_CERTIFICATES_ALLOWED)
                && Boolean.parseBoolean(configuration.getCatalog().getDatabase().getOptions()
                .get(MongoDBConfiguration.SSL_INVALID_CERTIFICATES_ALLOWED))) {
            authentication += "--sslAllowInvalidCertificates ";
        }
        if (configuration.getCatalog().getDatabase().getOptions() != null
                && configuration.getCatalog().getDatabase().getOptions().containsKey(MongoDBConfiguration.SSL_INVALID_HOSTNAME_ALLOWED)
                && Boolean.parseBoolean(configuration.getCatalog().getDatabase().getOptions()
                .get(MongoDBConfiguration.SSL_INVALID_HOSTNAME_ALLOWED))) {
            authentication += "--sslAllowInvalidHostnames ";
        }

        String catalogCli = "mongo " + authentication
                + StringUtils.join(configuration.getCatalog().getDatabase().getHosts(), ",") + "/"
                + catalogManager.getCatalogDatabase() + " " + scriptFileName;

        logger.info("Migrating Catalog. Running {} from {}", catalogCli, scriptFolder);
        ProcessBuilder processBuilder = new ProcessBuilder(catalogCli.split(" "));
        processBuilder.directory(new File(scriptFolder));
        Process p = processBuilder.start();

        BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while ((line = input.readLine()) != null) {
            logger.info(line);
        }
        p.waitFor();
        input.close();

        if (p.exitValue() == 0) {
            logger.info("Finished Javascript catalog migration");
        } else {
            throw new CatalogException("Error with Javascript catalog migrating!");
        }
    }

    public static class OpencgaVersion {
        private int version;
        private int release;
        private int lastJavaUpdate;
        private int lastJsUpdate;

        public OpencgaVersion() {
        }

        public OpencgaVersion(int version, int release, int lastJavaUpdate, int lastJsUpdate) {
            this.version = version;
            this.release = release;
            this.lastJavaUpdate = lastJavaUpdate;
            this.lastJsUpdate = lastJsUpdate;
        }

        public OpencgaVersion(OpencgaVersion opencgaVersion) {
            this(opencgaVersion.getVersion(), opencgaVersion.getRelease(), opencgaVersion.getLastJavaUpdate(),
                    opencgaVersion.getLastJsUpdate());
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("OpencgaVersion{");
            sb.append("version=").append(version);
            sb.append(", release=").append(release);
            sb.append(", lastJavaUpdate=").append(lastJavaUpdate);
            sb.append(", lastJsUpdate=").append(lastJsUpdate);
            sb.append('}');
            return sb.toString();
        }

        public int getVersion() {
            return version;
        }

        public int getRelease() {
            return release;
        }

        public int getLastJavaUpdate() {
            return lastJavaUpdate;
        }

        public OpencgaVersion setLastJavaUpdate(int lastJavaUpdate) {
            this.lastJavaUpdate = lastJavaUpdate;
            return this;
        }

        public void incrementLastJavaUpdate() {
            this.lastJavaUpdate++;
        }

        public int getLastJsUpdate() {
            return lastJsUpdate;
        }

        public OpencgaVersion setLastJsUpdate(int lastJsUpdate) {
            this.lastJsUpdate = lastJsUpdate;
            return this;
        }
    }

}
