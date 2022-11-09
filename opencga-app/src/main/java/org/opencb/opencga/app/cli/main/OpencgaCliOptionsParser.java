/*
* Copyright 2015-2022-11-09 OpenCB
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

package org.opencb.opencga.app.cli.main;

import com.beust.jcommander.JCommander;
import org.opencb.opencga.app.cli.GeneralCliOptions;
import org.opencb.opencga.app.cli.main.options.*;
import org.opencb.opencga.app.cli.main.parent.ParentCliOptionsParser;


/*
* WARNING: AUTOGENERATED CODE
*
* This code was generated by a tool.
*
* Manual changes to this file may cause unexpected behavior in your application.
* Manual changes to this file will be overwritten if the code is regenerated.
*/


public class OpencgaCliOptionsParser extends ParentCliOptionsParser {

    private final AnalysisVariantCommandOptions analysisVariantCommandOptions;
    private final ProjectsCommandOptions projectsCommandOptions;
    private final DiseasePanelsCommandOptions diseasePanelsCommandOptions;
    private final AnalysisClinicalCommandOptions analysisClinicalCommandOptions;
    private final JobsCommandOptions jobsCommandOptions;
    private final AdminCommandOptions adminCommandOptions;
    private final IndividualsCommandOptions individualsCommandOptions;
    private final FamiliesCommandOptions familiesCommandOptions;
    private final UsersCommandOptions usersCommandOptions;
    private final SamplesCommandOptions samplesCommandOptions;
    private final AnalysisAlignmentCommandOptions analysisAlignmentCommandOptions;
    private final MetaCommandOptions metaCommandOptions;
    private final StudiesCommandOptions studiesCommandOptions;
    private final FilesCommandOptions filesCommandOptions;
    private final OperationsVariantStorageCommandOptions operationsVariantStorageCommandOptions;
    private final CohortsCommandOptions cohortsCommandOptions;

    enum OutputFormat {IDS, ID_CSV, NAME_ID_MAP, ID_LIST, RAW, PRETTY_JSON, PLAIN_JSON}

    public OpencgaCliOptionsParser() {

        jCommander.setExpandAtSign(false);

        analysisVariantCommandOptions = new AnalysisVariantCommandOptions(commonCommandOptions, jCommander);
        jCommander.addCommand("variant", analysisVariantCommandOptions);
        JCommander analysisVariantSubCommands = jCommander.getCommands().get("variant");
        analysisVariantSubCommands.addCommand("aggregationstats", analysisVariantCommandOptions.aggregationStatsCommandOptions);
        analysisVariantSubCommands.addCommand("annotation-metadata", analysisVariantCommandOptions.metadataAnnotationCommandOptions);
        analysisVariantSubCommands.addCommand("annotation-query", analysisVariantCommandOptions.queryAnnotationCommandOptions);
        analysisVariantSubCommands.addCommand("circos-run", analysisVariantCommandOptions.runCircosCommandOptions);
        analysisVariantSubCommands.addCommand("cohort-stats-delete", analysisVariantCommandOptions.deleteCohortStatsCommandOptions);
        analysisVariantSubCommands.addCommand("cohort-stats-info", analysisVariantCommandOptions.infoCohortStatsCommandOptions);
        analysisVariantSubCommands.addCommand("cohort-stats-run", analysisVariantCommandOptions.runCohortStatsCommandOptions);
        analysisVariantSubCommands.addCommand("exomiser-run", analysisVariantCommandOptions.runExomiserCommandOptions);
        analysisVariantSubCommands.addCommand("export-run", analysisVariantCommandOptions.runExportCommandOptions);
        analysisVariantSubCommands.addCommand("family-genotypes", analysisVariantCommandOptions.genotypesFamilyCommandOptions);
        analysisVariantSubCommands.addCommand("family-qc-run", analysisVariantCommandOptions.runFamilyQcCommandOptions);
        analysisVariantSubCommands.addCommand("file-delete", analysisVariantCommandOptions.deleteFileCommandOptions);
        analysisVariantSubCommands.addCommand("gatk-run", analysisVariantCommandOptions.runGatkCommandOptions);
        analysisVariantSubCommands.addCommand("genome-plot-run", analysisVariantCommandOptions.runGenomePlotCommandOptions);
        analysisVariantSubCommands.addCommand("gwas-run", analysisVariantCommandOptions.runGwasCommandOptions);
        analysisVariantSubCommands.addCommand("index-run", analysisVariantCommandOptions.runIndexCommandOptions);
        analysisVariantSubCommands.addCommand("individual-qc-run", analysisVariantCommandOptions.runIndividualQcCommandOptions);
        analysisVariantSubCommands.addCommand("inferred-sex-run", analysisVariantCommandOptions.runInferredSexCommandOptions);
        analysisVariantSubCommands.addCommand("knockout-gene-query", analysisVariantCommandOptions.queryKnockoutGeneCommandOptions);
        analysisVariantSubCommands.addCommand("knockout-individual-query", analysisVariantCommandOptions.queryKnockoutIndividualCommandOptions);
        analysisVariantSubCommands.addCommand("knockout-run", analysisVariantCommandOptions.runKnockoutCommandOptions);
        analysisVariantSubCommands.addCommand("mendelian-error-run", analysisVariantCommandOptions.runMendelianErrorCommandOptions);
        analysisVariantSubCommands.addCommand("metadata", analysisVariantCommandOptions.metadataCommandOptions);
        analysisVariantSubCommands.addCommand("mutational-signature-query", analysisVariantCommandOptions.queryMutationalSignatureCommandOptions);
        analysisVariantSubCommands.addCommand("mutational-signature-run", analysisVariantCommandOptions.runMutationalSignatureCommandOptions);
        analysisVariantSubCommands.addCommand("plink-run", analysisVariantCommandOptions.runPlinkCommandOptions);
        analysisVariantSubCommands.addCommand("query", analysisVariantCommandOptions.queryCommandOptions);
        analysisVariantSubCommands.addCommand("relatedness-run", analysisVariantCommandOptions.runRelatednessCommandOptions);
        analysisVariantSubCommands.addCommand("rvtests-run", analysisVariantCommandOptions.runRvtestsCommandOptions);
        analysisVariantSubCommands.addCommand("sample-aggregation-stats", analysisVariantCommandOptions.aggregationStatsSampleCommandOptions);
        analysisVariantSubCommands.addCommand("sample-eligibility-run", analysisVariantCommandOptions.runSampleEligibilityCommandOptions);
        analysisVariantSubCommands.addCommand("sample-qc-run", analysisVariantCommandOptions.runSampleQcCommandOptions);
        analysisVariantSubCommands.addCommand("sample-query", analysisVariantCommandOptions.querySampleCommandOptions);
        analysisVariantSubCommands.addCommand("sample-run", analysisVariantCommandOptions.runSampleCommandOptions);
        analysisVariantSubCommands.addCommand("sample-stats-query", analysisVariantCommandOptions.querySampleStatsCommandOptions);
        analysisVariantSubCommands.addCommand("sample-stats-run", analysisVariantCommandOptions.runSampleStatsCommandOptions);
        analysisVariantSubCommands.addCommand("stats-export-run", analysisVariantCommandOptions.runStatsExportCommandOptions);
        analysisVariantSubCommands.addCommand("stats-run", analysisVariantCommandOptions.runStatsCommandOptions);

        projectsCommandOptions = new ProjectsCommandOptions(commonCommandOptions, jCommander);
        jCommander.addCommand("projects", projectsCommandOptions);
        JCommander projectsSubCommands = jCommander.getCommands().get("projects");
        projectsSubCommands.addCommand("create", projectsCommandOptions.createCommandOptions);
        projectsSubCommands.addCommand("search", projectsCommandOptions.searchCommandOptions);
        projectsSubCommands.addCommand("aggregationstats", projectsCommandOptions.aggregationStatsCommandOptions);
        projectsSubCommands.addCommand("info", projectsCommandOptions.infoCommandOptions);
        projectsSubCommands.addCommand("increlease", projectsCommandOptions.incReleaseCommandOptions);
        projectsSubCommands.addCommand("studies", projectsCommandOptions.studiesCommandOptions);
        projectsSubCommands.addCommand("update", projectsCommandOptions.updateCommandOptions);

        diseasePanelsCommandOptions = new DiseasePanelsCommandOptions(commonCommandOptions, jCommander);
        jCommander.addCommand("panels", diseasePanelsCommandOptions);
        JCommander diseasePanelsSubCommands = jCommander.getCommands().get("panels");
        diseasePanelsSubCommands.addCommand("acl-update", diseasePanelsCommandOptions.updateAclCommandOptions);
        diseasePanelsSubCommands.addCommand("create", diseasePanelsCommandOptions.createCommandOptions);
        diseasePanelsSubCommands.addCommand("distinct", diseasePanelsCommandOptions.distinctCommandOptions);
        diseasePanelsSubCommands.addCommand("import", diseasePanelsCommandOptions.importCommandOptions);
        diseasePanelsSubCommands.addCommand("search", diseasePanelsCommandOptions.searchCommandOptions);
        diseasePanelsSubCommands.addCommand("acl", diseasePanelsCommandOptions.aclCommandOptions);
        diseasePanelsSubCommands.addCommand("delete", diseasePanelsCommandOptions.deleteCommandOptions);
        diseasePanelsSubCommands.addCommand("info", diseasePanelsCommandOptions.infoCommandOptions);
        diseasePanelsSubCommands.addCommand("update", diseasePanelsCommandOptions.updateCommandOptions);

        analysisClinicalCommandOptions = new AnalysisClinicalCommandOptions(commonCommandOptions, jCommander);
        jCommander.addCommand("clinical", analysisClinicalCommandOptions);
        JCommander analysisClinicalSubCommands = jCommander.getCommands().get("clinical");
        analysisClinicalSubCommands.addCommand("acl-update", analysisClinicalCommandOptions.updateAclCommandOptions);
        analysisClinicalSubCommands.addCommand("clinical-configuration-update", analysisClinicalCommandOptions.updateClinicalConfigurationCommandOptions);
        analysisClinicalSubCommands.addCommand("create", analysisClinicalCommandOptions.createCommandOptions);
        analysisClinicalSubCommands.addCommand("distinct", analysisClinicalCommandOptions.distinctCommandOptions);
        analysisClinicalSubCommands.addCommand("interpretation-distinct", analysisClinicalCommandOptions.distinctInterpretationCommandOptions);
        analysisClinicalSubCommands.addCommand("interpretation-search", analysisClinicalCommandOptions.searchInterpretationCommandOptions);
        analysisClinicalSubCommands.addCommand("interpretation-info", analysisClinicalCommandOptions.infoInterpretationCommandOptions);
        analysisClinicalSubCommands.addCommand("interpreter-cancer-tiering-run", analysisClinicalCommandOptions.runInterpreterCancerTieringCommandOptions);
        analysisClinicalSubCommands.addCommand("interpreter-exomiser-run", analysisClinicalCommandOptions.runInterpreterExomiserCommandOptions);
        analysisClinicalSubCommands.addCommand("interpreter-team-run", analysisClinicalCommandOptions.runInterpreterTeamCommandOptions);
        analysisClinicalSubCommands.addCommand("interpreter-tiering-run", analysisClinicalCommandOptions.runInterpreterTieringCommandOptions);
        analysisClinicalSubCommands.addCommand("interpreter-zetta-run", analysisClinicalCommandOptions.runInterpreterZettaCommandOptions);
        analysisClinicalSubCommands.addCommand("rga-aggregation-stats", analysisClinicalCommandOptions.aggregationStatsRgaCommandOptions);
        analysisClinicalSubCommands.addCommand("rga-gene-query", analysisClinicalCommandOptions.queryRgaGeneCommandOptions);
        analysisClinicalSubCommands.addCommand("rga-gene-summary", analysisClinicalCommandOptions.summaryRgaGeneCommandOptions);
        analysisClinicalSubCommands.addCommand("rga-index-run", analysisClinicalCommandOptions.runRgaIndexCommandOptions);
        analysisClinicalSubCommands.addCommand("rga-individual-query", analysisClinicalCommandOptions.queryRgaIndividualCommandOptions);
        analysisClinicalSubCommands.addCommand("rga-individual-summary", analysisClinicalCommandOptions.summaryRgaIndividualCommandOptions);
        analysisClinicalSubCommands.addCommand("rga-variant-query", analysisClinicalCommandOptions.queryRgaVariantCommandOptions);
        analysisClinicalSubCommands.addCommand("rga-variant-summary", analysisClinicalCommandOptions.summaryRgaVariantCommandOptions);
        analysisClinicalSubCommands.addCommand("search", analysisClinicalCommandOptions.searchCommandOptions);
        analysisClinicalSubCommands.addCommand("variant-query", analysisClinicalCommandOptions.queryVariantCommandOptions);
        analysisClinicalSubCommands.addCommand("acl", analysisClinicalCommandOptions.aclCommandOptions);
        analysisClinicalSubCommands.addCommand("delete", analysisClinicalCommandOptions.deleteCommandOptions);
        analysisClinicalSubCommands.addCommand("update", analysisClinicalCommandOptions.updateCommandOptions);
        analysisClinicalSubCommands.addCommand("info", analysisClinicalCommandOptions.infoCommandOptions);
        analysisClinicalSubCommands.addCommand("interpretation-create", analysisClinicalCommandOptions.createInterpretationCommandOptions);
        analysisClinicalSubCommands.addCommand("interpretation-clear", analysisClinicalCommandOptions.clearInterpretationCommandOptions);
        analysisClinicalSubCommands.addCommand("interpretation-delete", analysisClinicalCommandOptions.deleteInterpretationCommandOptions);
        analysisClinicalSubCommands.addCommand("interpretation-revert", analysisClinicalCommandOptions.revertInterpretationCommandOptions);
        analysisClinicalSubCommands.addCommand("interpretation-update", analysisClinicalCommandOptions.updateInterpretationCommandOptions);

        jobsCommandOptions = new JobsCommandOptions(commonCommandOptions, jCommander);
        jCommander.addCommand("jobs", jobsCommandOptions);
        JCommander jobsSubCommands = jCommander.getCommands().get("jobs");
        jobsSubCommands.addCommand("acl-update", jobsCommandOptions.updateAclCommandOptions);
        jobsSubCommands.addCommand("aggregationstats", jobsCommandOptions.aggregationStatsCommandOptions);
        jobsSubCommands.addCommand("create", jobsCommandOptions.createCommandOptions);
        jobsSubCommands.addCommand("distinct", jobsCommandOptions.distinctCommandOptions);
        jobsSubCommands.addCommand("retry", jobsCommandOptions.retryCommandOptions);
        jobsSubCommands.addCommand("search", jobsCommandOptions.searchCommandOptions);
        jobsSubCommands.addCommand("top", jobsCommandOptions.topCommandOptions);
        jobsSubCommands.addCommand("acl", jobsCommandOptions.aclCommandOptions);
        jobsSubCommands.addCommand("delete", jobsCommandOptions.deleteCommandOptions);
        jobsSubCommands.addCommand("info", jobsCommandOptions.infoCommandOptions);
        jobsSubCommands.addCommand("update", jobsCommandOptions.updateCommandOptions);
        jobsSubCommands.addCommand("log-head", jobsCommandOptions.headLogCommandOptions);
        jobsSubCommands.addCommand("log-tail", jobsCommandOptions.tailLogCommandOptions);
        jobsSubCommands.addCommand("log", jobsCommandOptions.logCommandOptions);

        adminCommandOptions = new AdminCommandOptions(commonCommandOptions, jCommander);
        jCommander.addCommand("admin", adminCommandOptions);
        JCommander adminSubCommands = jCommander.getCommands().get("admin");
        adminSubCommands.addCommand("audit-group-by", adminCommandOptions.groupByAuditCommandOptions);
        adminSubCommands.addCommand("catalog-index-stats", adminCommandOptions.indexStatsCatalogCommandOptions);
        adminSubCommands.addCommand("catalog-install", adminCommandOptions.installCatalogCommandOptions);
        adminSubCommands.addCommand("catalog-jwt", adminCommandOptions.jwtCatalogCommandOptions);
        adminSubCommands.addCommand("users-create", adminCommandOptions.createUsersCommandOptions);
        adminSubCommands.addCommand("users-import", adminCommandOptions.importUsersCommandOptions);
        adminSubCommands.addCommand("users-search", adminCommandOptions.searchUsersCommandOptions);
        adminSubCommands.addCommand("users-sync", adminCommandOptions.syncUsersCommandOptions);

        individualsCommandOptions = new IndividualsCommandOptions(commonCommandOptions, jCommander);
        jCommander.addCommand("individuals", individualsCommandOptions);
        JCommander individualsSubCommands = jCommander.getCommands().get("individuals");
        individualsSubCommands.addCommand("acl-update", individualsCommandOptions.updateAclCommandOptions);
        individualsSubCommands.addCommand("aggregationstats", individualsCommandOptions.aggregationStatsCommandOptions);
        individualsSubCommands.addCommand("annotation-sets-load", individualsCommandOptions.loadAnnotationSetsCommandOptions);
        individualsSubCommands.addCommand("create", individualsCommandOptions.createCommandOptions);
        individualsSubCommands.addCommand("distinct", individualsCommandOptions.distinctCommandOptions);
        individualsSubCommands.addCommand("search", individualsCommandOptions.searchCommandOptions);
        individualsSubCommands.addCommand("acl", individualsCommandOptions.aclCommandOptions);
        individualsSubCommands.addCommand("delete", individualsCommandOptions.deleteCommandOptions);
        individualsSubCommands.addCommand("info", individualsCommandOptions.infoCommandOptions);
        individualsSubCommands.addCommand("update", individualsCommandOptions.updateCommandOptions);
        individualsSubCommands.addCommand("annotation-sets-annotations-update", individualsCommandOptions.updateAnnotationSetsAnnotationsCommandOptions);
        individualsSubCommands.addCommand("relatives", individualsCommandOptions.relativesCommandOptions);

        familiesCommandOptions = new FamiliesCommandOptions(commonCommandOptions, jCommander);
        jCommander.addCommand("families", familiesCommandOptions);
        JCommander familiesSubCommands = jCommander.getCommands().get("families");
        familiesSubCommands.addCommand("acl-update", familiesCommandOptions.updateAclCommandOptions);
        familiesSubCommands.addCommand("aggregationstats", familiesCommandOptions.aggregationStatsCommandOptions);
        familiesSubCommands.addCommand("annotation-sets-load", familiesCommandOptions.loadAnnotationSetsCommandOptions);
        familiesSubCommands.addCommand("create", familiesCommandOptions.createCommandOptions);
        familiesSubCommands.addCommand("distinct", familiesCommandOptions.distinctCommandOptions);
        familiesSubCommands.addCommand("search", familiesCommandOptions.searchCommandOptions);
        familiesSubCommands.addCommand("acl", familiesCommandOptions.aclCommandOptions);
        familiesSubCommands.addCommand("delete", familiesCommandOptions.deleteCommandOptions);
        familiesSubCommands.addCommand("info", familiesCommandOptions.infoCommandOptions);
        familiesSubCommands.addCommand("update", familiesCommandOptions.updateCommandOptions);
        familiesSubCommands.addCommand("annotation-sets-annotations-update", familiesCommandOptions.updateAnnotationSetsAnnotationsCommandOptions);

        usersCommandOptions = new UsersCommandOptions(commonCommandOptions, jCommander);
        jCommander.addCommand("users", usersCommandOptions);
        JCommander usersSubCommands = jCommander.getCommands().get("users");
        usersSubCommands.addCommand("create", usersCommandOptions.createCommandOptions);
        usersSubCommands.addCommand("login", usersCommandOptions.loginCommandOptions);
        usersSubCommands.addCommand("password", usersCommandOptions.passwordCommandOptions);
        usersSubCommands.addCommand("info", usersCommandOptions.infoCommandOptions);
        usersSubCommands.addCommand("configs", usersCommandOptions.configsCommandOptions);
        usersSubCommands.addCommand("configs-update", usersCommandOptions.updateConfigsCommandOptions);
        usersSubCommands.addCommand("filters", usersCommandOptions.filtersCommandOptions);
        usersSubCommands.addCommand("password-reset", usersCommandOptions.resetPasswordCommandOptions);
        usersSubCommands.addCommand("projects", usersCommandOptions.projectsCommandOptions);
        usersSubCommands.addCommand("update", usersCommandOptions.updateCommandOptions);
        usersSubCommands.addCommand("logout", usersCommandOptions.logoutCommandOptions);

        samplesCommandOptions = new SamplesCommandOptions(commonCommandOptions, jCommander);
        jCommander.addCommand("samples", samplesCommandOptions);
        JCommander samplesSubCommands = jCommander.getCommands().get("samples");
        samplesSubCommands.addCommand("acl-update", samplesCommandOptions.updateAclCommandOptions);
        samplesSubCommands.addCommand("aggregationstats", samplesCommandOptions.aggregationStatsCommandOptions);
        samplesSubCommands.addCommand("annotation-sets-load", samplesCommandOptions.loadAnnotationSetsCommandOptions);
        samplesSubCommands.addCommand("create", samplesCommandOptions.createCommandOptions);
        samplesSubCommands.addCommand("distinct", samplesCommandOptions.distinctCommandOptions);
        samplesSubCommands.addCommand("load", samplesCommandOptions.loadCommandOptions);
        samplesSubCommands.addCommand("search", samplesCommandOptions.searchCommandOptions);
        samplesSubCommands.addCommand("acl", samplesCommandOptions.aclCommandOptions);
        samplesSubCommands.addCommand("delete", samplesCommandOptions.deleteCommandOptions);
        samplesSubCommands.addCommand("info", samplesCommandOptions.infoCommandOptions);
        samplesSubCommands.addCommand("update", samplesCommandOptions.updateCommandOptions);
        samplesSubCommands.addCommand("annotation-sets-annotations-update", samplesCommandOptions.updateAnnotationSetsAnnotationsCommandOptions);

        analysisAlignmentCommandOptions = new AnalysisAlignmentCommandOptions(commonCommandOptions, jCommander);
        jCommander.addCommand("alignments", analysisAlignmentCommandOptions);
        JCommander analysisAlignmentSubCommands = jCommander.getCommands().get("alignments");
        analysisAlignmentSubCommands.addCommand("bwa-run", analysisAlignmentCommandOptions.runBwaCommandOptions);
        analysisAlignmentSubCommands.addCommand("coverage-index-run", analysisAlignmentCommandOptions.runCoverageIndexCommandOptions);
        analysisAlignmentSubCommands.addCommand("coverage-qc-genecoveragestats-run", analysisAlignmentCommandOptions.coverageQcGeneCoverageStatsRunCommandOptions);
        analysisAlignmentSubCommands.addCommand("coverage-query", analysisAlignmentCommandOptions.queryCoverageCommandOptions);
        analysisAlignmentSubCommands.addCommand("coverage-ratio", analysisAlignmentCommandOptions.ratioCoverageCommandOptions);
        analysisAlignmentSubCommands.addCommand("coverage-stats", analysisAlignmentCommandOptions.statsCoverageCommandOptions);
        analysisAlignmentSubCommands.addCommand("deeptools-run", analysisAlignmentCommandOptions.runDeeptoolsCommandOptions);
        analysisAlignmentSubCommands.addCommand("fastqc-run", analysisAlignmentCommandOptions.runFastqcCommandOptions);
        analysisAlignmentSubCommands.addCommand("index-run", analysisAlignmentCommandOptions.runIndexCommandOptions);
        analysisAlignmentSubCommands.addCommand("picard-run", analysisAlignmentCommandOptions.runPicardCommandOptions);
        analysisAlignmentSubCommands.addCommand("qc-run", analysisAlignmentCommandOptions.runQcCommandOptions);
        analysisAlignmentSubCommands.addCommand("query", analysisAlignmentCommandOptions.queryCommandOptions);
        analysisAlignmentSubCommands.addCommand("samtools-run", analysisAlignmentCommandOptions.runSamtoolsCommandOptions);

        metaCommandOptions = new MetaCommandOptions(commonCommandOptions, jCommander);
        jCommander.addCommand("meta", metaCommandOptions);
        JCommander metaSubCommands = jCommander.getCommands().get("meta");
        metaSubCommands.addCommand("about", metaCommandOptions.aboutCommandOptions);
        metaSubCommands.addCommand("api", metaCommandOptions.apiCommandOptions);
        metaSubCommands.addCommand("fail", metaCommandOptions.failCommandOptions);
        metaSubCommands.addCommand("model", metaCommandOptions.modelCommandOptions);
        metaSubCommands.addCommand("ping", metaCommandOptions.pingCommandOptions);
        metaSubCommands.addCommand("status", metaCommandOptions.statusCommandOptions);

        studiesCommandOptions = new StudiesCommandOptions(commonCommandOptions, jCommander);
        jCommander.addCommand("studies", studiesCommandOptions);
        JCommander studiesSubCommands = jCommander.getCommands().get("studies");
        studiesSubCommands.addCommand("acl-update", studiesCommandOptions.updateAclCommandOptions);
        studiesSubCommands.addCommand("create", studiesCommandOptions.createCommandOptions);
        studiesSubCommands.addCommand("search", studiesCommandOptions.searchCommandOptions);
        studiesSubCommands.addCommand("acl", studiesCommandOptions.aclCommandOptions);
        studiesSubCommands.addCommand("aggregationstats", studiesCommandOptions.aggregationStatsCommandOptions);
        studiesSubCommands.addCommand("info", studiesCommandOptions.infoCommandOptions);
        studiesSubCommands.addCommand("audit-search", studiesCommandOptions.searchAuditCommandOptions);
        studiesSubCommands.addCommand("groups", studiesCommandOptions.groupsCommandOptions);
        studiesSubCommands.addCommand("groups-update", studiesCommandOptions.updateGroupsCommandOptions);
        studiesSubCommands.addCommand("groups-users-update", studiesCommandOptions.updateGroupsUsersCommandOptions);
        studiesSubCommands.addCommand("permissionrules", studiesCommandOptions.permissionRulesCommandOptions);
        studiesSubCommands.addCommand("permission-rules-update", studiesCommandOptions.updatePermissionRulesCommandOptions);
        studiesSubCommands.addCommand("templates-run", studiesCommandOptions.runTemplatesCommandOptions);
        studiesSubCommands.addCommand("templates-upload", studiesCommandOptions.uploadTemplatesCommandOptions);
        studiesSubCommands.addCommand("templates-delete", studiesCommandOptions.deleteTemplatesCommandOptions);
        studiesSubCommands.addCommand("update", studiesCommandOptions.updateCommandOptions);
        studiesSubCommands.addCommand("variablesets", studiesCommandOptions.variableSetsCommandOptions);
        studiesSubCommands.addCommand("variable-sets-update", studiesCommandOptions.updateVariableSetsCommandOptions);
        studiesSubCommands.addCommand("variable-sets-variables-update", studiesCommandOptions.updateVariableSetsVariablesCommandOptions);

        filesCommandOptions = new FilesCommandOptions(commonCommandOptions, jCommander);
        jCommander.addCommand("files", filesCommandOptions);
        JCommander filesSubCommands = jCommander.getCommands().get("files");
        filesSubCommands.addCommand("acl-update", filesCommandOptions.updateAclCommandOptions);
        filesSubCommands.addCommand("aggregationstats", filesCommandOptions.aggregationStatsCommandOptions);
        filesSubCommands.addCommand("annotation-sets-load", filesCommandOptions.loadAnnotationSetsCommandOptions);
        filesSubCommands.addCommand("bioformats", filesCommandOptions.bioformatsCommandOptions);
        filesSubCommands.addCommand("create", filesCommandOptions.createCommandOptions);
        filesSubCommands.addCommand("distinct", filesCommandOptions.distinctCommandOptions);
        filesSubCommands.addCommand("fetch", filesCommandOptions.fetchCommandOptions);
        filesSubCommands.addCommand("formats", filesCommandOptions.formatsCommandOptions);
        filesSubCommands.addCommand("link", filesCommandOptions.linkCommandOptions);
        filesSubCommands.addCommand("link-run", filesCommandOptions.runLinkCommandOptions);
        filesSubCommands.addCommand("postlink-run", filesCommandOptions.runPostlinkCommandOptions);
        filesSubCommands.addCommand("search", filesCommandOptions.searchCommandOptions);
        filesSubCommands.addCommand("upload", filesCommandOptions.uploadCommandOptions);
        filesSubCommands.addCommand("acl", filesCommandOptions.aclCommandOptions);
        filesSubCommands.addCommand("delete", filesCommandOptions.deleteCommandOptions);
        filesSubCommands.addCommand("info", filesCommandOptions.infoCommandOptions);
        filesSubCommands.addCommand("unlink", filesCommandOptions.unlinkCommandOptions);
        filesSubCommands.addCommand("update", filesCommandOptions.updateCommandOptions);
        filesSubCommands.addCommand("annotation-sets-annotations-update", filesCommandOptions.updateAnnotationSetsAnnotationsCommandOptions);
        filesSubCommands.addCommand("download", filesCommandOptions.downloadCommandOptions);
        filesSubCommands.addCommand("grep", filesCommandOptions.grepCommandOptions);
        filesSubCommands.addCommand("head", filesCommandOptions.headCommandOptions);
        filesSubCommands.addCommand("image", filesCommandOptions.imageCommandOptions);
        filesSubCommands.addCommand("refresh", filesCommandOptions.refreshCommandOptions);
        filesSubCommands.addCommand("tail", filesCommandOptions.tailCommandOptions);
        filesSubCommands.addCommand("list", filesCommandOptions.listCommandOptions);
        filesSubCommands.addCommand("tree", filesCommandOptions.treeCommandOptions);

        operationsVariantStorageCommandOptions = new OperationsVariantStorageCommandOptions(commonCommandOptions, jCommander);
        jCommander.addCommand("operations", operationsVariantStorageCommandOptions);
        JCommander operationsVariantStorageSubCommands = jCommander.getCommands().get("operations");
        operationsVariantStorageSubCommands.addCommand("cellbase-configure", operationsVariantStorageCommandOptions.configureCellbaseCommandOptions);
        operationsVariantStorageSubCommands.addCommand("variant-aggregate", operationsVariantStorageCommandOptions.aggregateVariantCommandOptions);
        operationsVariantStorageSubCommands.addCommand("variant-annotation-delete", operationsVariantStorageCommandOptions.deleteVariantAnnotationCommandOptions);
        operationsVariantStorageSubCommands.addCommand("variant-annotation-index", operationsVariantStorageCommandOptions.indexVariantAnnotationCommandOptions);
        operationsVariantStorageSubCommands.addCommand("variant-annotation-save", operationsVariantStorageCommandOptions.saveVariantAnnotationCommandOptions);
        operationsVariantStorageSubCommands.addCommand("variant-configure", operationsVariantStorageCommandOptions.configureVariantCommandOptions);
        operationsVariantStorageSubCommands.addCommand("variant-delete", operationsVariantStorageCommandOptions.deleteVariantCommandOptions);
        operationsVariantStorageSubCommands.addCommand("variant-family-aggregate", operationsVariantStorageCommandOptions.aggregateVariantFamilyCommandOptions);
        operationsVariantStorageSubCommands.addCommand("variant-family-index", operationsVariantStorageCommandOptions.indexVariantFamilyCommandOptions);
        operationsVariantStorageSubCommands.addCommand("variant-index", operationsVariantStorageCommandOptions.indexVariantCommandOptions);
        operationsVariantStorageSubCommands.addCommand("variant-index-launcher", operationsVariantStorageCommandOptions.launcherVariantIndexCommandOptions);
        operationsVariantStorageSubCommands.addCommand("variant-julie-run", operationsVariantStorageCommandOptions.runVariantJulieCommandOptions);
        operationsVariantStorageSubCommands.addCommand("variant-metadata-repair", operationsVariantStorageCommandOptions.repairVariantMetadataCommandOptions);
        operationsVariantStorageSubCommands.addCommand("variant-metadata-synchronize", operationsVariantStorageCommandOptions.synchronizeVariantMetadataCommandOptions);
        operationsVariantStorageSubCommands.addCommand("variant-prune", operationsVariantStorageCommandOptions.pruneVariantCommandOptions);
        operationsVariantStorageSubCommands.addCommand("variant-sample-delete", operationsVariantStorageCommandOptions.deleteVariantSampleCommandOptions);
        operationsVariantStorageSubCommands.addCommand("variant-sample-index", operationsVariantStorageCommandOptions.indexVariantSampleCommandOptions);
        operationsVariantStorageSubCommands.addCommand("variant-sample-index-configure", operationsVariantStorageCommandOptions.variantSampleIndexConfigureCommandOptions);
        operationsVariantStorageSubCommands.addCommand("variant-score-delete", operationsVariantStorageCommandOptions.deleteVariantScoreCommandOptions);
        operationsVariantStorageSubCommands.addCommand("variant-score-index", operationsVariantStorageCommandOptions.indexVariantScoreCommandOptions);
        operationsVariantStorageSubCommands.addCommand("variant-secondary-annotation-index", operationsVariantStorageCommandOptions.variantSecondaryAnnotationIndexCommandOptions);
        operationsVariantStorageSubCommands.addCommand("variant-secondary-sample-index", operationsVariantStorageCommandOptions.variantSecondarySampleIndexCommandOptions);
        operationsVariantStorageSubCommands.addCommand("configure-variant-secondary-sample-index", operationsVariantStorageCommandOptions.configureVariantSecondarySampleIndexCommandOptions);
        operationsVariantStorageSubCommands.addCommand("variant-secondary-index", operationsVariantStorageCommandOptions.secondaryIndexVariantCommandOptions);
        operationsVariantStorageSubCommands.addCommand("variant-secondary-index-delete", operationsVariantStorageCommandOptions.deleteVariantSecondaryIndexCommandOptions);
        operationsVariantStorageSubCommands.addCommand("variant-stats-delete", operationsVariantStorageCommandOptions.deleteVariantStatsCommandOptions);
        operationsVariantStorageSubCommands.addCommand("variant-stats-index", operationsVariantStorageCommandOptions.indexVariantStatsCommandOptions);
        operationsVariantStorageSubCommands.addCommand("variant-study-delete", operationsVariantStorageCommandOptions.deleteVariantStudyCommandOptions);

        cohortsCommandOptions = new CohortsCommandOptions(commonCommandOptions, jCommander);
        jCommander.addCommand("cohorts", cohortsCommandOptions);
        JCommander cohortsSubCommands = jCommander.getCommands().get("cohorts");
        cohortsSubCommands.addCommand("acl-update", cohortsCommandOptions.updateAclCommandOptions);
        cohortsSubCommands.addCommand("aggregationstats", cohortsCommandOptions.aggregationStatsCommandOptions);
        cohortsSubCommands.addCommand("annotation-sets-load", cohortsCommandOptions.loadAnnotationSetsCommandOptions);
        cohortsSubCommands.addCommand("create", cohortsCommandOptions.createCommandOptions);
        cohortsSubCommands.addCommand("distinct", cohortsCommandOptions.distinctCommandOptions);
        cohortsSubCommands.addCommand("generate", cohortsCommandOptions.generateCommandOptions);
        cohortsSubCommands.addCommand("search", cohortsCommandOptions.searchCommandOptions);
        cohortsSubCommands.addCommand("acl", cohortsCommandOptions.aclCommandOptions);
        cohortsSubCommands.addCommand("delete", cohortsCommandOptions.deleteCommandOptions);
        cohortsSubCommands.addCommand("info", cohortsCommandOptions.infoCommandOptions);
        cohortsSubCommands.addCommand("update", cohortsCommandOptions.updateCommandOptions);
        cohortsSubCommands.addCommand("annotation-sets-annotations-update", cohortsCommandOptions.updateAnnotationSetsAnnotationsCommandOptions);
    }
    
    public AnalysisVariantCommandOptions getAnalysisVariantCommandOptions() {
        return analysisVariantCommandOptions;
    }
    
    
    public ProjectsCommandOptions getProjectsCommandOptions() {
        return projectsCommandOptions;
    }
    
    
    public DiseasePanelsCommandOptions getDiseasePanelsCommandOptions() {
        return diseasePanelsCommandOptions;
    }
    
    
    public AnalysisClinicalCommandOptions getAnalysisClinicalCommandOptions() {
        return analysisClinicalCommandOptions;
    }
    
    
    public JobsCommandOptions getJobsCommandOptions() {
        return jobsCommandOptions;
    }
    
    
    public AdminCommandOptions getAdminCommandOptions() {
        return adminCommandOptions;
    }
    
    
    public IndividualsCommandOptions getIndividualsCommandOptions() {
        return individualsCommandOptions;
    }
    
    
    public FamiliesCommandOptions getFamiliesCommandOptions() {
        return familiesCommandOptions;
    }
    
    
    public UsersCommandOptions getUsersCommandOptions() {
        return usersCommandOptions;
    }
    
    
    public SamplesCommandOptions getSamplesCommandOptions() {
        return samplesCommandOptions;
    }
    
    
    public AnalysisAlignmentCommandOptions getAnalysisAlignmentCommandOptions() {
        return analysisAlignmentCommandOptions;
    }
    
    
    public MetaCommandOptions getMetaCommandOptions() {
        return metaCommandOptions;
    }
    
    
    public StudiesCommandOptions getStudiesCommandOptions() {
        return studiesCommandOptions;
    }
    
    
    public FilesCommandOptions getFilesCommandOptions() {
        return filesCommandOptions;
    }
    
    
    public OperationsVariantStorageCommandOptions getOperationsVariantStorageCommandOptions() {
        return operationsVariantStorageCommandOptions;
    }
    
    
    public CohortsCommandOptions getCohortsCommandOptions() {
        return cohortsCommandOptions;
    }
    
}