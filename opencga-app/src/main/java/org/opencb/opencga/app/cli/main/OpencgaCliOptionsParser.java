/*
* Copyright 2015-2021-09-23 OpenCB
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
import org.opencb.commons.utils.CommandLineUtils;
import org.opencb.opencga.app.cli.CliOptionsParser;
import org.opencb.opencga.app.cli.GeneralCliOptions;
import org.opencb.opencga.app.cli.admin.AdminCliOptionsParser;
import org.opencb.opencga.app.cli.main.options.*;
import org.opencb.opencga.core.common.GitRepositoryState;

import java.util.*;


/*
* WARNING: AUTOGENERATED CODE
*
* This code was generated by a tool.
* Autogenerated on: 2021-09-23
*
* Manual changes to this file may cause unexpected behavior in your application.
* Manual changes to this file will be overwritten if the code is regenerated.
*    Command line version: 2.1.0-rc2-SNAPSHOT
*    Command line commit: 5f5ac3fb4ccd0dd34d830d147dd704f19b078cb0
*/


public class OpencgaCliOptionsParser extends CliOptionsParser {

    private final GeneralCliOptions.CommonCommandOptions commonCommandOptions;
    private final AnalysisVariantCommandOptions analysisVariantCommandOptions;
    private final ProjectsCommandOptions projectsCommandOptions;
    private final DiseasePanelsCommandOptions diseasePanelsCommandOptions;
    private final AnalysisClinicalCommandOptions analysisClinicalCommandOptions;
    private final JobsCommandOptions jobsCommandOptions;
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
        commonCommandOptions = new GeneralCliOptions.CommonCommandOptions();

        analysisVariantCommandOptions = new AnalysisVariantCommandOptions(commonCommandOptions, jCommander);
        jCommander.addCommand("variant", analysisVariantCommandOptions);
        JCommander analysisVariantSubCommands = jCommander.getCommands().get("variant");
        analysisVariantSubCommands.addCommand("aggregationStats", analysisVariantCommandOptions.aggregationStatsCommandOptions);
        analysisVariantSubCommands.addCommand("metadata-annotation", analysisVariantCommandOptions.metadataAnnotationCommandOptions);
        analysisVariantSubCommands.addCommand("query-annotation", analysisVariantCommandOptions.queryAnnotationCommandOptions);
        analysisVariantSubCommands.addCommand("run-circos", analysisVariantCommandOptions.runCircosCommandOptions);
        analysisVariantSubCommands.addCommand("delete-cohort-stats", analysisVariantCommandOptions.deleteCohortStatsCommandOptions);
        analysisVariantSubCommands.addCommand("info-cohort-stats", analysisVariantCommandOptions.infoCohortStatsCommandOptions);
        analysisVariantSubCommands.addCommand("run-cohort-stats", analysisVariantCommandOptions.runCohortStatsCommandOptions);
        analysisVariantSubCommands.addCommand("run-export", analysisVariantCommandOptions.runExportCommandOptions);
        analysisVariantSubCommands.addCommand("genotypes-family", analysisVariantCommandOptions.genotypesFamilyCommandOptions);
        analysisVariantSubCommands.addCommand("run-family-qc", analysisVariantCommandOptions.runFamilyQcCommandOptions);
        analysisVariantSubCommands.addCommand("delete-file", analysisVariantCommandOptions.deleteFileCommandOptions);
        analysisVariantSubCommands.addCommand("run-gatk", analysisVariantCommandOptions.runGatkCommandOptions);
        analysisVariantSubCommands.addCommand("run-genomePlot", analysisVariantCommandOptions.runGenomePlotCommandOptions);
        analysisVariantSubCommands.addCommand("run-gwas", analysisVariantCommandOptions.runGwasCommandOptions);
        analysisVariantSubCommands.addCommand("run-index", analysisVariantCommandOptions.runIndexCommandOptions);
        analysisVariantSubCommands.addCommand("run-individual-qc", analysisVariantCommandOptions.runIndividualQcCommandOptions);
        analysisVariantSubCommands.addCommand("run-inferredSex", analysisVariantCommandOptions.runInferredSexCommandOptions);
        analysisVariantSubCommands.addCommand("query-knockout-gene", analysisVariantCommandOptions.queryKnockoutGeneCommandOptions);
        analysisVariantSubCommands.addCommand("query-knockout-individual", analysisVariantCommandOptions.queryKnockoutIndividualCommandOptions);
        analysisVariantSubCommands.addCommand("run-knockout", analysisVariantCommandOptions.runKnockoutCommandOptions);
        analysisVariantSubCommands.addCommand("run-mendelianError", analysisVariantCommandOptions.runMendelianErrorCommandOptions);
        analysisVariantSubCommands.addCommand("metadata", analysisVariantCommandOptions.metadataCommandOptions);
        analysisVariantSubCommands.addCommand("query-mutationalSignature", analysisVariantCommandOptions.queryMutationalSignatureCommandOptions);
        analysisVariantSubCommands.addCommand("run-mutationalSignature", analysisVariantCommandOptions.runMutationalSignatureCommandOptions);
        analysisVariantSubCommands.addCommand("run-plink", analysisVariantCommandOptions.runPlinkCommandOptions);
        analysisVariantSubCommands.addCommand("query", analysisVariantCommandOptions.queryCommandOptions);
        analysisVariantSubCommands.addCommand("run-relatedness", analysisVariantCommandOptions.runRelatednessCommandOptions);
        analysisVariantSubCommands.addCommand("run-rvtests", analysisVariantCommandOptions.runRvtestsCommandOptions);
        analysisVariantSubCommands.addCommand("aggregationStats-sample", analysisVariantCommandOptions.aggregationStatsSampleCommandOptions);
        analysisVariantSubCommands.addCommand("run-sample-eligibility", analysisVariantCommandOptions.runSampleEligibilityCommandOptions);
        analysisVariantSubCommands.addCommand("run-sample-qc", analysisVariantCommandOptions.runSampleQcCommandOptions);
        analysisVariantSubCommands.addCommand("query-sample", analysisVariantCommandOptions.querySampleCommandOptions);
        analysisVariantSubCommands.addCommand("run-sample", analysisVariantCommandOptions.runSampleCommandOptions);
        analysisVariantSubCommands.addCommand("query-sample-stats", analysisVariantCommandOptions.querySampleStatsCommandOptions);
        analysisVariantSubCommands.addCommand("run-sample-stats", analysisVariantCommandOptions.runSampleStatsCommandOptions);
        analysisVariantSubCommands.addCommand("run-stats-export", analysisVariantCommandOptions.runStatsExportCommandOptions);
        analysisVariantSubCommands.addCommand("run-stats", analysisVariantCommandOptions.runStatsCommandOptions);

        projectsCommandOptions = new ProjectsCommandOptions(commonCommandOptions, jCommander);
        jCommander.addCommand("projects", projectsCommandOptions);
        JCommander projectsSubCommands = jCommander.getCommands().get("projects");
        projectsSubCommands.addCommand("create", projectsCommandOptions.createCommandOptions);
        projectsSubCommands.addCommand("search", projectsCommandOptions.searchCommandOptions);
        projectsSubCommands.addCommand("aggregationStats", projectsCommandOptions.aggregationStatsCommandOptions);
        projectsSubCommands.addCommand("info", projectsCommandOptions.infoCommandOptions);
        projectsSubCommands.addCommand("studies", projectsCommandOptions.studiesCommandOptions);
        projectsSubCommands.addCommand("update", projectsCommandOptions.updateCommandOptions);

        diseasePanelsCommandOptions = new DiseasePanelsCommandOptions(commonCommandOptions, jCommander);
        jCommander.addCommand("panels", diseasePanelsCommandOptions);
        JCommander diseasePanelsSubCommands = jCommander.getCommands().get("panels");
        diseasePanelsSubCommands.addCommand("update-acl", diseasePanelsCommandOptions.updateAclCommandOptions);
        diseasePanelsSubCommands.addCommand("create", diseasePanelsCommandOptions.createCommandOptions);
        diseasePanelsSubCommands.addCommand("distinct", diseasePanelsCommandOptions.distinctCommandOptions);
        diseasePanelsSubCommands.addCommand("search", diseasePanelsCommandOptions.searchCommandOptions);
        diseasePanelsSubCommands.addCommand("acl", diseasePanelsCommandOptions.aclCommandOptions);
        diseasePanelsSubCommands.addCommand("delete", diseasePanelsCommandOptions.deleteCommandOptions);
        diseasePanelsSubCommands.addCommand("info", diseasePanelsCommandOptions.infoCommandOptions);
        diseasePanelsSubCommands.addCommand("update", diseasePanelsCommandOptions.updateCommandOptions);

        analysisClinicalCommandOptions = new AnalysisClinicalCommandOptions(commonCommandOptions, jCommander);
        jCommander.addCommand("clinical", analysisClinicalCommandOptions);
        JCommander analysisClinicalSubCommands = jCommander.getCommands().get("clinical");
        analysisClinicalSubCommands.addCommand("update-acl", analysisClinicalCommandOptions.updateAclCommandOptions);
        analysisClinicalSubCommands.addCommand("create", analysisClinicalCommandOptions.createCommandOptions);
        analysisClinicalSubCommands.addCommand("distinct", analysisClinicalCommandOptions.distinctCommandOptions);
        analysisClinicalSubCommands.addCommand("distinct-interpretation", analysisClinicalCommandOptions.distinctInterpretationCommandOptions);
        analysisClinicalSubCommands.addCommand("search-interpretation", analysisClinicalCommandOptions.searchInterpretationCommandOptions);
        analysisClinicalSubCommands.addCommand("info-interpretation", analysisClinicalCommandOptions.infoInterpretationCommandOptions);
        analysisClinicalSubCommands.addCommand("run-interpreter-cancerTiering", analysisClinicalCommandOptions.runInterpreterCancerTieringCommandOptions);
        analysisClinicalSubCommands.addCommand("run-interpreter-team", analysisClinicalCommandOptions.runInterpreterTeamCommandOptions);
        analysisClinicalSubCommands.addCommand("run-interpreter-tiering", analysisClinicalCommandOptions.runInterpreterTieringCommandOptions);
        analysisClinicalSubCommands.addCommand("run-interpreter-zetta", analysisClinicalCommandOptions.runInterpreterZettaCommandOptions);
        analysisClinicalSubCommands.addCommand("aggregationStats-rga", analysisClinicalCommandOptions.aggregationStatsRgaCommandOptions);
        analysisClinicalSubCommands.addCommand("query-rga-gene", analysisClinicalCommandOptions.queryRgaGeneCommandOptions);
        analysisClinicalSubCommands.addCommand("summary-rga-gene", analysisClinicalCommandOptions.summaryRgaGeneCommandOptions);
        analysisClinicalSubCommands.addCommand("run-rga-index", analysisClinicalCommandOptions.runRgaIndexCommandOptions);
        analysisClinicalSubCommands.addCommand("query-rga-individual", analysisClinicalCommandOptions.queryRgaIndividualCommandOptions);
        analysisClinicalSubCommands.addCommand("summary-rga-individual", analysisClinicalCommandOptions.summaryRgaIndividualCommandOptions);
        analysisClinicalSubCommands.addCommand("query-rga-variant", analysisClinicalCommandOptions.queryRgaVariantCommandOptions);
        analysisClinicalSubCommands.addCommand("summary-rga-variant", analysisClinicalCommandOptions.summaryRgaVariantCommandOptions);
        analysisClinicalSubCommands.addCommand("search", analysisClinicalCommandOptions.searchCommandOptions);
        analysisClinicalSubCommands.addCommand("actionable-variant", analysisClinicalCommandOptions.actionableVariantCommandOptions);
        analysisClinicalSubCommands.addCommand("query-variant", analysisClinicalCommandOptions.queryVariantCommandOptions);
        analysisClinicalSubCommands.addCommand("acl", analysisClinicalCommandOptions.aclCommandOptions);
        analysisClinicalSubCommands.addCommand("delete", analysisClinicalCommandOptions.deleteCommandOptions);
        analysisClinicalSubCommands.addCommand("update", analysisClinicalCommandOptions.updateCommandOptions);
        analysisClinicalSubCommands.addCommand("info", analysisClinicalCommandOptions.infoCommandOptions);
        analysisClinicalSubCommands.addCommand("create-interpretation", analysisClinicalCommandOptions.createInterpretationCommandOptions);
        analysisClinicalSubCommands.addCommand("delete-interpretation", analysisClinicalCommandOptions.deleteInterpretationCommandOptions);
        analysisClinicalSubCommands.addCommand("update-interpretation", analysisClinicalCommandOptions.updateInterpretationCommandOptions);

        jobsCommandOptions = new JobsCommandOptions(commonCommandOptions, jCommander);
        jCommander.addCommand("jobs", jobsCommandOptions);
        JCommander jobsSubCommands = jCommander.getCommands().get("jobs");
        jobsSubCommands.addCommand("update-acl", jobsCommandOptions.updateAclCommandOptions);
        jobsSubCommands.addCommand("aggregationStats", jobsCommandOptions.aggregationStatsCommandOptions);
        jobsSubCommands.addCommand("create", jobsCommandOptions.createCommandOptions);
        jobsSubCommands.addCommand("distinct", jobsCommandOptions.distinctCommandOptions);
        jobsSubCommands.addCommand("retry", jobsCommandOptions.retryCommandOptions);
        jobsSubCommands.addCommand("search", jobsCommandOptions.searchCommandOptions);
        jobsSubCommands.addCommand("top", jobsCommandOptions.topCommandOptions);
        jobsSubCommands.addCommand("acl", jobsCommandOptions.aclCommandOptions);
        jobsSubCommands.addCommand("delete", jobsCommandOptions.deleteCommandOptions);
        jobsSubCommands.addCommand("info", jobsCommandOptions.infoCommandOptions);
        jobsSubCommands.addCommand("update", jobsCommandOptions.updateCommandOptions);
        jobsSubCommands.addCommand("head-log", jobsCommandOptions.headLogCommandOptions);
        jobsSubCommands.addCommand("tail-log", jobsCommandOptions.tailLogCommandOptions);

        individualsCommandOptions = new IndividualsCommandOptions(commonCommandOptions, jCommander);
        jCommander.addCommand("individuals", individualsCommandOptions);
        JCommander individualsSubCommands = jCommander.getCommands().get("individuals");
        individualsSubCommands.addCommand("update-acl", individualsCommandOptions.updateAclCommandOptions);
        individualsSubCommands.addCommand("aggregationStats", individualsCommandOptions.aggregationStatsCommandOptions);
        individualsSubCommands.addCommand("load-annotationSets", individualsCommandOptions.loadAnnotationSetsCommandOptions);
        individualsSubCommands.addCommand("create", individualsCommandOptions.createCommandOptions);
        individualsSubCommands.addCommand("distinct", individualsCommandOptions.distinctCommandOptions);
        individualsSubCommands.addCommand("search", individualsCommandOptions.searchCommandOptions);
        individualsSubCommands.addCommand("acl", individualsCommandOptions.aclCommandOptions);
        individualsSubCommands.addCommand("delete", individualsCommandOptions.deleteCommandOptions);
        individualsSubCommands.addCommand("info", individualsCommandOptions.infoCommandOptions);
        individualsSubCommands.addCommand("update", individualsCommandOptions.updateCommandOptions);
        individualsSubCommands.addCommand("relatives", individualsCommandOptions.relativesCommandOptions);

        familiesCommandOptions = new FamiliesCommandOptions(commonCommandOptions, jCommander);
        jCommander.addCommand("families", familiesCommandOptions);
        JCommander familiesSubCommands = jCommander.getCommands().get("families");
        familiesSubCommands.addCommand("update-acl", familiesCommandOptions.updateAclCommandOptions);
        familiesSubCommands.addCommand("aggregationStats", familiesCommandOptions.aggregationStatsCommandOptions);
        familiesSubCommands.addCommand("load-annotationSets", familiesCommandOptions.loadAnnotationSetsCommandOptions);
        familiesSubCommands.addCommand("create", familiesCommandOptions.createCommandOptions);
        familiesSubCommands.addCommand("distinct", familiesCommandOptions.distinctCommandOptions);
        familiesSubCommands.addCommand("search", familiesCommandOptions.searchCommandOptions);
        familiesSubCommands.addCommand("acl", familiesCommandOptions.aclCommandOptions);
        familiesSubCommands.addCommand("delete", familiesCommandOptions.deleteCommandOptions);
        familiesSubCommands.addCommand("info", familiesCommandOptions.infoCommandOptions);
        familiesSubCommands.addCommand("update", familiesCommandOptions.updateCommandOptions);

        usersCommandOptions = new UsersCommandOptions(commonCommandOptions, jCommander);
        jCommander.addCommand("users", usersCommandOptions);

        JCommander usersSubCommands = jCommander.getCommands().get("users");
        usersSubCommands.addCommand("create", usersCommandOptions.createCommandOptions);
        usersSubCommands.addCommand("login", usersCommandOptions.loginCommandOptions);
        usersSubCommands.addCommand("password", usersCommandOptions.passwordCommandOptions);
        usersSubCommands.addCommand("info", usersCommandOptions.infoCommandOptions);
        usersSubCommands.addCommand("configs", usersCommandOptions.configsCommandOptions);
        usersSubCommands.addCommand("update-configs", usersCommandOptions.updateConfigsCommandOptions);
        usersSubCommands.addCommand("filters", usersCommandOptions.filtersCommandOptions);
        usersSubCommands.addCommand("projects", usersCommandOptions.projectsCommandOptions);
        usersSubCommands.addCommand("update", usersCommandOptions.updateCommandOptions);

        samplesCommandOptions = new SamplesCommandOptions(commonCommandOptions, jCommander);
        jCommander.addCommand("samples", samplesCommandOptions);
        JCommander samplesSubCommands = jCommander.getCommands().get("samples");
        samplesSubCommands.addCommand("update-acl", samplesCommandOptions.updateAclCommandOptions);
        samplesSubCommands.addCommand("aggregationStats", samplesCommandOptions.aggregationStatsCommandOptions);
        samplesSubCommands.addCommand("load-annotationSets", samplesCommandOptions.loadAnnotationSetsCommandOptions);
        samplesSubCommands.addCommand("create", samplesCommandOptions.createCommandOptions);
        samplesSubCommands.addCommand("distinct", samplesCommandOptions.distinctCommandOptions);
        samplesSubCommands.addCommand("load", samplesCommandOptions.loadCommandOptions);
        samplesSubCommands.addCommand("search", samplesCommandOptions.searchCommandOptions);
        samplesSubCommands.addCommand("acl", samplesCommandOptions.aclCommandOptions);
        samplesSubCommands.addCommand("delete", samplesCommandOptions.deleteCommandOptions);
        samplesSubCommands.addCommand("info", samplesCommandOptions.infoCommandOptions);
        samplesSubCommands.addCommand("update", samplesCommandOptions.updateCommandOptions);

        analysisAlignmentCommandOptions = new AnalysisAlignmentCommandOptions(commonCommandOptions, jCommander);
        jCommander.addCommand("alignments", analysisAlignmentCommandOptions);
        JCommander analysisAlignmentSubCommands = jCommander.getCommands().get("alignments");
        analysisAlignmentSubCommands.addCommand("run-bwa", analysisAlignmentCommandOptions.runBwaCommandOptions);
        analysisAlignmentSubCommands.addCommand("run-coverage-index", analysisAlignmentCommandOptions.runCoverageIndexCommandOptions);
        analysisAlignmentSubCommands.addCommand("run-qc-geneCoverageStats", analysisAlignmentCommandOptions.runQcGeneCoverageStatsCommandOptions);
        analysisAlignmentSubCommands.addCommand("query-coverage", analysisAlignmentCommandOptions.queryCoverageCommandOptions);
        analysisAlignmentSubCommands.addCommand("ratio-coverage", analysisAlignmentCommandOptions.ratioCoverageCommandOptions);
        analysisAlignmentSubCommands.addCommand("stats-coverage", analysisAlignmentCommandOptions.statsCoverageCommandOptions);
        analysisAlignmentSubCommands.addCommand("run-deeptools", analysisAlignmentCommandOptions.runDeeptoolsCommandOptions);
        analysisAlignmentSubCommands.addCommand("run-fastqc", analysisAlignmentCommandOptions.runFastqcCommandOptions);
        analysisAlignmentSubCommands.addCommand("run-index", analysisAlignmentCommandOptions.runIndexCommandOptions);
        analysisAlignmentSubCommands.addCommand("run-picard", analysisAlignmentCommandOptions.runPicardCommandOptions);
        analysisAlignmentSubCommands.addCommand("run-qc", analysisAlignmentCommandOptions.runQcCommandOptions);
        analysisAlignmentSubCommands.addCommand("query", analysisAlignmentCommandOptions.queryCommandOptions);
        analysisAlignmentSubCommands.addCommand("run-samtools", analysisAlignmentCommandOptions.runSamtoolsCommandOptions);

        metaCommandOptions = new MetaCommandOptions(commonCommandOptions, jCommander);
        jCommander.addCommand("meta", metaCommandOptions);
        JCommander metaSubCommands = jCommander.getCommands().get("meta");
        metaSubCommands.addCommand("about", metaCommandOptions.aboutCommandOptions);
        metaSubCommands.addCommand("api", metaCommandOptions.apiCommandOptions);
        metaSubCommands.addCommand("fail", metaCommandOptions.failCommandOptions);
        metaSubCommands.addCommand("ping", metaCommandOptions.pingCommandOptions);
        metaSubCommands.addCommand("status", metaCommandOptions.statusCommandOptions);

        studiesCommandOptions = new StudiesCommandOptions(commonCommandOptions, jCommander);
        jCommander.addCommand("studies", studiesCommandOptions);
        JCommander studiesSubCommands = jCommander.getCommands().get("studies");
        studiesSubCommands.addCommand("update-acl", studiesCommandOptions.updateAclCommandOptions);
        studiesSubCommands.addCommand("create", studiesCommandOptions.createCommandOptions);
        studiesSubCommands.addCommand("search", studiesCommandOptions.searchCommandOptions);
        studiesSubCommands.addCommand("acl", studiesCommandOptions.aclCommandOptions);
        studiesSubCommands.addCommand("aggregationStats", studiesCommandOptions.aggregationStatsCommandOptions);
        studiesSubCommands.addCommand("info", studiesCommandOptions.infoCommandOptions);
        studiesSubCommands.addCommand("search-audit", studiesCommandOptions.searchAuditCommandOptions);
        studiesSubCommands.addCommand("groups", studiesCommandOptions.groupsCommandOptions);
        studiesSubCommands.addCommand("update-groups", studiesCommandOptions.updateGroupsCommandOptions);
        studiesSubCommands.addCommand("permissionRules", studiesCommandOptions.permissionRulesCommandOptions);
        studiesSubCommands.addCommand("update-permissionRules", studiesCommandOptions.updatePermissionRulesCommandOptions);
        studiesSubCommands.addCommand("run-templates", studiesCommandOptions.runTemplatesCommandOptions);
        studiesSubCommands.addCommand("update", studiesCommandOptions.updateCommandOptions);
        studiesSubCommands.addCommand("variableSets", studiesCommandOptions.variableSetsCommandOptions);
        studiesSubCommands.addCommand("update-variableSets", studiesCommandOptions.updateVariableSetsCommandOptions);
        studiesSubCommands.addCommand("update-variables", studiesCommandOptions.updateVariablesCommandOptions);

        filesCommandOptions = new FilesCommandOptions(commonCommandOptions, jCommander);
        jCommander.addCommand("files", filesCommandOptions);
        JCommander filesSubCommands = jCommander.getCommands().get("files");
        filesSubCommands.addCommand("update-acl", filesCommandOptions.updateAclCommandOptions);
        filesSubCommands.addCommand("aggregationStats", filesCommandOptions.aggregationStatsCommandOptions);
        filesSubCommands.addCommand("load-annotationSets", filesCommandOptions.loadAnnotationSetsCommandOptions);
        filesSubCommands.addCommand("bioformats", filesCommandOptions.bioformatsCommandOptions);
        filesSubCommands.addCommand("create", filesCommandOptions.createCommandOptions);
        filesSubCommands.addCommand("distinct", filesCommandOptions.distinctCommandOptions);
        filesSubCommands.addCommand("fetch", filesCommandOptions.fetchCommandOptions);
        filesSubCommands.addCommand("formats", filesCommandOptions.formatsCommandOptions);
        filesSubCommands.addCommand("link", filesCommandOptions.linkCommandOptions);
        filesSubCommands.addCommand("run-link", filesCommandOptions.runLinkCommandOptions);
        filesSubCommands.addCommand("search", filesCommandOptions.searchCommandOptions);
        filesSubCommands.addCommand("acl", filesCommandOptions.aclCommandOptions);
        filesSubCommands.addCommand("delete", filesCommandOptions.deleteCommandOptions);
        filesSubCommands.addCommand("info", filesCommandOptions.infoCommandOptions);
        filesSubCommands.addCommand("unlink", filesCommandOptions.unlinkCommandOptions);
        filesSubCommands.addCommand("update", filesCommandOptions.updateCommandOptions);
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
        operationsVariantStorageSubCommands.addCommand("configure-cellbase", operationsVariantStorageCommandOptions.configureCellbaseCommandOptions);
        operationsVariantStorageSubCommands.addCommand("aggregate-variant", operationsVariantStorageCommandOptions.aggregateVariantCommandOptions);
        operationsVariantStorageSubCommands.addCommand("delete-variant-annotation", operationsVariantStorageCommandOptions.deleteVariantAnnotationCommandOptions);
        operationsVariantStorageSubCommands.addCommand("index-variant-annotation", operationsVariantStorageCommandOptions.indexVariantAnnotationCommandOptions);
        operationsVariantStorageSubCommands.addCommand("save-variant-annotation", operationsVariantStorageCommandOptions.saveVariantAnnotationCommandOptions);
        operationsVariantStorageSubCommands.addCommand("aggregate-variant-family", operationsVariantStorageCommandOptions.aggregateVariantFamilyCommandOptions);
        operationsVariantStorageSubCommands.addCommand("index-variant-family", operationsVariantStorageCommandOptions.indexVariantFamilyCommandOptions);
        operationsVariantStorageSubCommands.addCommand("launcher-variant-index", operationsVariantStorageCommandOptions.launcherVariantIndexCommandOptions);
        operationsVariantStorageSubCommands.addCommand("run-variant-julie", operationsVariantStorageCommandOptions.runVariantJulieCommandOptions);
        operationsVariantStorageSubCommands.addCommand("repair-variant-metadata", operationsVariantStorageCommandOptions.repairVariantMetadataCommandOptions);
        operationsVariantStorageSubCommands.addCommand("synchronize-variant-metadata", operationsVariantStorageCommandOptions.synchronizeVariantMetadataCommandOptions);
        operationsVariantStorageSubCommands.addCommand("index-variant-sample", operationsVariantStorageCommandOptions.indexVariantSampleCommandOptions);
        operationsVariantStorageSubCommands.addCommand("delete-variant-score", operationsVariantStorageCommandOptions.deleteVariantScoreCommandOptions);
        operationsVariantStorageSubCommands.addCommand("index-variant-score", operationsVariantStorageCommandOptions.indexVariantScoreCommandOptions);
        operationsVariantStorageSubCommands.addCommand("secondaryIndex-variant", operationsVariantStorageCommandOptions.secondaryIndexVariantCommandOptions);
        operationsVariantStorageSubCommands.addCommand("delete-variant-secondaryIndex", operationsVariantStorageCommandOptions.deleteVariantSecondaryIndexCommandOptions);
        operationsVariantStorageSubCommands.addCommand("index-variant-stats", operationsVariantStorageCommandOptions.indexVariantStatsCommandOptions);

        cohortsCommandOptions = new CohortsCommandOptions(commonCommandOptions, jCommander);
        jCommander.addCommand("cohorts", cohortsCommandOptions);
        JCommander cohortsSubCommands = jCommander.getCommands().get("cohorts");
        cohortsSubCommands.addCommand("update-acl", cohortsCommandOptions.updateAclCommandOptions);
        cohortsSubCommands.addCommand("aggregationStats", cohortsCommandOptions.aggregationStatsCommandOptions);
        cohortsSubCommands.addCommand("load-annotationSets", cohortsCommandOptions.loadAnnotationSetsCommandOptions);
        cohortsSubCommands.addCommand("create", cohortsCommandOptions.createCommandOptions);
        cohortsSubCommands.addCommand("distinct", cohortsCommandOptions.distinctCommandOptions);
        cohortsSubCommands.addCommand("generate", cohortsCommandOptions.generateCommandOptions);
        cohortsSubCommands.addCommand("search", cohortsCommandOptions.searchCommandOptions);
        cohortsSubCommands.addCommand("acl", cohortsCommandOptions.aclCommandOptions);
        cohortsSubCommands.addCommand("delete", cohortsCommandOptions.deleteCommandOptions);
        cohortsSubCommands.addCommand("info", cohortsCommandOptions.infoCommandOptions);
        cohortsSubCommands.addCommand("update", cohortsCommandOptions.updateCommandOptions);
    }

    @Override
    public boolean isHelp() {
        String parsedCommand = jCommander.getParsedCommand();
        if (parsedCommand != null) {
            JCommander jCommander2 = jCommander.getCommands().get(parsedCommand);
            List<Object> objects = jCommander2.getObjects();
            if (!objects.isEmpty() && objects.get(0) instanceof AdminCliOptionsParser.AdminCommonCommandOptions) {
                return ((AdminCliOptionsParser.AdminCommonCommandOptions) objects.get(0)).commonOptions.help;
            }
        }
        return commonCommandOptions.help;
    }

    @Override
    public void printUsage() {
        String parsedCommand = getCommand();
        if (parsedCommand.isEmpty()) {
            System.err.println("");
            System.err.println("Program:     OpenCGA (OpenCB)");
            System.err.println("Version:     " + GitRepositoryState.get().getBuildVersion());
            System.err.println("Git commit:  " + GitRepositoryState.get().getCommitId());
            System.err.println("Description: Big Data platform for processing and analysing NGS data");
            System.err.println("");
            System.err.println("Usage:       opencga.sh [-h|--help] [--version] <command> [options]");
            System.err.println("");
            printMainUsage();
            System.err.println("");
        } else {
            String parsedSubCommand = getSubCommand();
            if (parsedSubCommand.isEmpty()) {
                System.err.println("");
                System.err.println("Usage:   opencga.sh " + parsedCommand + " <subcommand> [options]");
                System.err.println("");
                System.err.println("Subcommands:");
                printCommands(jCommander.getCommands().get(parsedCommand));
                System.err.println("");
            } else {
                System.err.println("");
                System.err.println("Usage:   opencga.sh " + parsedCommand + " " + parsedSubCommand + " [options]");
                System.err.println("");
                System.err.println("Options:");
                CommandLineUtils.printCommandUsage(jCommander.getCommands().get(parsedCommand).getCommands().get(parsedSubCommand));
                System.err.println("");
            }
        }
    }

    @Override
    protected void printMainUsage() {
        Set<String> analysisCommands = new HashSet<>(Arrays.asList("alignments", "variant", "clinical"));
        Set<String> operationsCommands = new HashSet<>(Collections.singletonList("operations"));

        System.err.println("Catalog commands:");
        for (String command : jCommander.getCommands().keySet()) {
            if (!analysisCommands.contains(command) && !operationsCommands.contains(command)) {
                System.err.printf("%30s  %s\n", command, jCommander.getCommandDescription(command));
            }
        }

        System.err.println("");
        System.err.println("Analysis commands:");
        for (String command : jCommander.getCommands().keySet()) {
            if (analysisCommands.contains(command)) {
                System.err.printf("%30s  %s\n", command, jCommander.getCommandDescription(command));
            }
        }

        System.err.println("");
        System.err.println("Operation commands:");
        for (String command : jCommander.getCommands().keySet()) {
            if (operationsCommands.contains(command)) {
                System.err.printf("%30s  %s\n", command, jCommander.getCommandDescription(command));
            }
        }
    }

    public GeneralCliOptions.CommonCommandOptions getCommonCommandOptions() {
        return commonCommandOptions;
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