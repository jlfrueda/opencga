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

package org.opencb.opencga.app.cli.main;

import com.beust.jcommander.JCommander;
import org.opencb.commons.utils.CommandLineUtils;
import org.opencb.opencga.app.cli.CliOptionsParser;
import org.opencb.opencga.app.cli.GeneralCliOptions;
import org.opencb.opencga.app.cli.admin.AdminCliOptionsParser;
import org.opencb.opencga.core.common.GitRepositoryState;

import java.util.*;

import org.opencb.opencga.app.cli.main.options.*;


/*
* WARNING: AUTOGENERATED CODE
*
* This code was generated by a tool.
* Autogenerated on: 2021-09-02 11:54:59
*
* Manual changes to this file may cause unexpected behavior in your application.
* Manual changes to this file will be overwritten if the code is regenerated.
*/

public class OpencgaCliOptionsParser extends CliOptionsParser {

    private final GeneralCliOptions.CommonCommandOptions commonCommandOptions;
    private final UserCommandOptions userCommandOptions;
    private final ProjectCommandOptions projectCommandOptions;
    private final StudyCommandOptions studyCommandOptions;
    private final FileCommandOptions fileCommandOptions;
    private final JobCommandOptions jobCommandOptions;
    private final SampleCommandOptions sampleCommandOptions;
    private final IndividualCommandOptions individualCommandOptions;
    private final FamilyCommandOptions familyCommandOptions;
    private final CohortCommandOptions cohortCommandOptions;
    private final DiseasePanelCommandOptions diseasePanelCommandOptions;
    private final AlignmentCommandOptions alignmentCommandOptions;
    private final VariantCommandOptions variantCommandOptions;
    private final ClinicalAnalysisCommandOptions clinicalAnalysisCommandOptions;
    private final VariantOperationCommandOptions variantOperationCommandOptions;
    private final MetaCommandOptions metaCommandOptions;

    enum OutputFormat {IDS, ID_CSV, NAME_ID_MAP, ID_LIST, RAW, PRETTY_JSON, PLAIN_JSON}

    public OpencgaCliOptionsParser() {

        jCommander.setExpandAtSign(false);
        commonCommandOptions = new GeneralCliOptions.CommonCommandOptions();

        userCommandOptions = new UserCommandOptions(commonCommandOptions, jCommander);
        jCommander.addCommand("users", userCommandOptions);
        JCommander userSubCommands = jCommander.getCommands().get("users");
        userSubCommands.addCommand("create", userCommandOptions.createCommandOptions);
        userSubCommands.addCommand("login", userCommandOptions.loginCommandOptions);
        userSubCommands.addCommand("password", userCommandOptions.passwordCommandOptions);
        userSubCommands.addCommand("info", userCommandOptions.infoCommandOptions);
        userSubCommands.addCommand("configs", userCommandOptions.configsCommandOptions);
        userSubCommands.addCommand("update-configs", userCommandOptions.updateConfigsCommandOptions);
        userSubCommands.addCommand("filters", userCommandOptions.filtersCommandOptions);
        userSubCommands.addCommand("update-filters", userCommandOptions.updateFiltersCommandOptions);
        userSubCommands.addCommand("update-filter", userCommandOptions.updateFilterCommandOptions);
        userSubCommands.addCommand("projects", userCommandOptions.projectsCommandOptions);
        userSubCommands.addCommand("update", userCommandOptions.updateCommandOptions);

        projectCommandOptions = new ProjectCommandOptions(commonCommandOptions, jCommander);
        jCommander.addCommand("projects", projectCommandOptions);
        JCommander projectSubCommands = jCommander.getCommands().get("projects");
        projectSubCommands.addCommand("create", projectCommandOptions.createCommandOptions);
        projectSubCommands.addCommand("search", projectCommandOptions.searchCommandOptions);
        projectSubCommands.addCommand("aggregation-stats", projectCommandOptions.aggregationStatsCommandOptions);
        projectSubCommands.addCommand("info", projectCommandOptions.infoCommandOptions);
        projectSubCommands.addCommand("inc-release", projectCommandOptions.incReleaseCommandOptions);
        projectSubCommands.addCommand("studies", projectCommandOptions.studiesCommandOptions);
        projectSubCommands.addCommand("update", projectCommandOptions.updateCommandOptions);

        studyCommandOptions = new StudyCommandOptions(commonCommandOptions, jCommander);
        jCommander.addCommand("studies", studyCommandOptions);
        JCommander studySubCommands = jCommander.getCommands().get("studies");
        studySubCommands.addCommand("update-acl", studyCommandOptions.updateAclCommandOptions);
        studySubCommands.addCommand("create", studyCommandOptions.createCommandOptions);
        studySubCommands.addCommand("search", studyCommandOptions.searchCommandOptions);
        studySubCommands.addCommand("acl", studyCommandOptions.aclCommandOptions);
        studySubCommands.addCommand("aggregation-stats", studyCommandOptions.aggregationStatsCommandOptions);
        studySubCommands.addCommand("info", studyCommandOptions.infoCommandOptions);
        studySubCommands.addCommand("search-audit", studyCommandOptions.searchAuditCommandOptions);
        studySubCommands.addCommand("groups", studyCommandOptions.groupsCommandOptions);
        studySubCommands.addCommand("update-groups", studyCommandOptions.updateGroupsCommandOptions);
        studySubCommands.addCommand("update-users", studyCommandOptions.updateUsersCommandOptions);
        studySubCommands.addCommand("permission-rules", studyCommandOptions.permissionRulesCommandOptions);
        studySubCommands.addCommand("update-permission-rules", studyCommandOptions.updatePermissionRulesCommandOptions);
        studySubCommands.addCommand("run-templates", studyCommandOptions.runTemplatesCommandOptions);
        studySubCommands.addCommand("upload-templates", studyCommandOptions.uploadTemplatesCommandOptions);
        studySubCommands.addCommand("delete-templates", studyCommandOptions.deleteTemplatesCommandOptions);
        studySubCommands.addCommand("update", studyCommandOptions.updateCommandOptions);
        studySubCommands.addCommand("variable-sets", studyCommandOptions.variableSetsCommandOptions);
        studySubCommands.addCommand("update-variable-sets", studyCommandOptions.updateVariableSetsCommandOptions);
        studySubCommands.addCommand("update-variables", studyCommandOptions.updateVariablesCommandOptions);

        fileCommandOptions = new FileCommandOptions(commonCommandOptions, jCommander);
        jCommander.addCommand("files", fileCommandOptions);
        JCommander fileSubCommands = jCommander.getCommands().get("files");
        fileSubCommands.addCommand("update-acl", fileCommandOptions.updateAclCommandOptions);
        fileSubCommands.addCommand("aggregation-stats", fileCommandOptions.aggregationStatsCommandOptions);
        fileSubCommands.addCommand("load-annotation-sets", fileCommandOptions.loadAnnotationSetsCommandOptions);
        fileSubCommands.addCommand("bioformats", fileCommandOptions.bioformatsCommandOptions);
        fileSubCommands.addCommand("create", fileCommandOptions.createCommandOptions);
        fileSubCommands.addCommand("distinct", fileCommandOptions.distinctCommandOptions);
        fileSubCommands.addCommand("fetch", fileCommandOptions.fetchCommandOptions);
        fileSubCommands.addCommand("formats", fileCommandOptions.formatsCommandOptions);
        fileSubCommands.addCommand("link", fileCommandOptions.linkCommandOptions);
        fileSubCommands.addCommand("run-link", fileCommandOptions.runLinkCommandOptions);
        fileSubCommands.addCommand("run-postlink", fileCommandOptions.runPostlinkCommandOptions);
        fileSubCommands.addCommand("search", fileCommandOptions.searchCommandOptions);
        fileSubCommands.addCommand("acl", fileCommandOptions.aclCommandOptions);
        fileSubCommands.addCommand("delete", fileCommandOptions.deleteCommandOptions);
        fileSubCommands.addCommand("info", fileCommandOptions.infoCommandOptions);
        fileSubCommands.addCommand("unlink", fileCommandOptions.unlinkCommandOptions);
        fileSubCommands.addCommand("update", fileCommandOptions.updateCommandOptions);
        fileSubCommands.addCommand("update-annotations", fileCommandOptions.updateAnnotationsCommandOptions);
        fileSubCommands.addCommand("download", fileCommandOptions.downloadCommandOptions);
        fileSubCommands.addCommand("grep", fileCommandOptions.grepCommandOptions);
        fileSubCommands.addCommand("head", fileCommandOptions.headCommandOptions);
        fileSubCommands.addCommand("image", fileCommandOptions.imageCommandOptions);
        fileSubCommands.addCommand("refresh", fileCommandOptions.refreshCommandOptions);
        fileSubCommands.addCommand("tail", fileCommandOptions.tailCommandOptions);
        fileSubCommands.addCommand("list", fileCommandOptions.listCommandOptions);
        fileSubCommands.addCommand("tree", fileCommandOptions.treeCommandOptions);

        jobCommandOptions = new JobCommandOptions(commonCommandOptions, jCommander);
        jCommander.addCommand("jobs", jobCommandOptions);
        JCommander jobSubCommands = jCommander.getCommands().get("jobs");
        jobSubCommands.addCommand("update-acl", jobCommandOptions.updateAclCommandOptions);
        jobSubCommands.addCommand("aggregation-stats", jobCommandOptions.aggregationStatsCommandOptions);
        jobSubCommands.addCommand("create", jobCommandOptions.createCommandOptions);
        jobSubCommands.addCommand("distinct", jobCommandOptions.distinctCommandOptions);
        jobSubCommands.addCommand("retry", jobCommandOptions.retryCommandOptions);
        jobSubCommands.addCommand("search", jobCommandOptions.searchCommandOptions);
        jobSubCommands.addCommand("top", jobCommandOptions.topCommandOptions);
        jobSubCommands.addCommand("acl", jobCommandOptions.aclCommandOptions);
        jobSubCommands.addCommand("delete", jobCommandOptions.deleteCommandOptions);
        jobSubCommands.addCommand("info", jobCommandOptions.infoCommandOptions);
        jobSubCommands.addCommand("update", jobCommandOptions.updateCommandOptions);
        jobSubCommands.addCommand("head-log", jobCommandOptions.headLogCommandOptions);
        jobSubCommands.addCommand("tail-log", jobCommandOptions.tailLogCommandOptions);

        sampleCommandOptions = new SampleCommandOptions(commonCommandOptions, jCommander);
        jCommander.addCommand("samples", sampleCommandOptions);
        JCommander sampleSubCommands = jCommander.getCommands().get("samples");
        sampleSubCommands.addCommand("update-acl", sampleCommandOptions.updateAclCommandOptions);
        sampleSubCommands.addCommand("aggregation-stats", sampleCommandOptions.aggregationStatsCommandOptions);
        sampleSubCommands.addCommand("load-annotation-sets", sampleCommandOptions.loadAnnotationSetsCommandOptions);
        sampleSubCommands.addCommand("create", sampleCommandOptions.createCommandOptions);
        sampleSubCommands.addCommand("distinct", sampleCommandOptions.distinctCommandOptions);
        sampleSubCommands.addCommand("load", sampleCommandOptions.loadCommandOptions);
        sampleSubCommands.addCommand("search", sampleCommandOptions.searchCommandOptions);
        sampleSubCommands.addCommand("acl", sampleCommandOptions.aclCommandOptions);
        sampleSubCommands.addCommand("delete", sampleCommandOptions.deleteCommandOptions);
        sampleSubCommands.addCommand("info", sampleCommandOptions.infoCommandOptions);
        sampleSubCommands.addCommand("update", sampleCommandOptions.updateCommandOptions);
        sampleSubCommands.addCommand("update-annotations", sampleCommandOptions.updateAnnotationsCommandOptions);

        individualCommandOptions = new IndividualCommandOptions(commonCommandOptions, jCommander);
        jCommander.addCommand("individuals", individualCommandOptions);
        JCommander individualSubCommands = jCommander.getCommands().get("individuals");
        individualSubCommands.addCommand("update-acl", individualCommandOptions.updateAclCommandOptions);
        individualSubCommands.addCommand("aggregation-stats", individualCommandOptions.aggregationStatsCommandOptions);
        individualSubCommands.addCommand("load-annotation-sets", individualCommandOptions.loadAnnotationSetsCommandOptions);
        individualSubCommands.addCommand("create", individualCommandOptions.createCommandOptions);
        individualSubCommands.addCommand("distinct", individualCommandOptions.distinctCommandOptions);
        individualSubCommands.addCommand("search", individualCommandOptions.searchCommandOptions);
        individualSubCommands.addCommand("acl", individualCommandOptions.aclCommandOptions);
        individualSubCommands.addCommand("delete", individualCommandOptions.deleteCommandOptions);
        individualSubCommands.addCommand("info", individualCommandOptions.infoCommandOptions);
        individualSubCommands.addCommand("update", individualCommandOptions.updateCommandOptions);
        individualSubCommands.addCommand("update-annotations", individualCommandOptions.updateAnnotationsCommandOptions);
        individualSubCommands.addCommand("relatives", individualCommandOptions.relativesCommandOptions);

        familyCommandOptions = new FamilyCommandOptions(commonCommandOptions, jCommander);
        jCommander.addCommand("families", familyCommandOptions);
        JCommander familySubCommands = jCommander.getCommands().get("families");
        familySubCommands.addCommand("update-acl", familyCommandOptions.updateAclCommandOptions);
        familySubCommands.addCommand("aggregation-stats", familyCommandOptions.aggregationStatsCommandOptions);
        familySubCommands.addCommand("load-annotation-sets", familyCommandOptions.loadAnnotationSetsCommandOptions);
        familySubCommands.addCommand("create", familyCommandOptions.createCommandOptions);
        familySubCommands.addCommand("distinct", familyCommandOptions.distinctCommandOptions);
        familySubCommands.addCommand("search", familyCommandOptions.searchCommandOptions);
        familySubCommands.addCommand("acl", familyCommandOptions.aclCommandOptions);
        familySubCommands.addCommand("delete", familyCommandOptions.deleteCommandOptions);
        familySubCommands.addCommand("info", familyCommandOptions.infoCommandOptions);
        familySubCommands.addCommand("update", familyCommandOptions.updateCommandOptions);
        familySubCommands.addCommand("update-annotations", familyCommandOptions.updateAnnotationsCommandOptions);

        cohortCommandOptions = new CohortCommandOptions(commonCommandOptions, jCommander);
        jCommander.addCommand("cohorts", cohortCommandOptions);
        JCommander cohortSubCommands = jCommander.getCommands().get("cohorts");
        cohortSubCommands.addCommand("update-acl", cohortCommandOptions.updateAclCommandOptions);
        cohortSubCommands.addCommand("aggregation-stats", cohortCommandOptions.aggregationStatsCommandOptions);
        cohortSubCommands.addCommand("load-annotation-sets", cohortCommandOptions.loadAnnotationSetsCommandOptions);
        cohortSubCommands.addCommand("create", cohortCommandOptions.createCommandOptions);
        cohortSubCommands.addCommand("distinct", cohortCommandOptions.distinctCommandOptions);
        cohortSubCommands.addCommand("generate", cohortCommandOptions.generateCommandOptions);
        cohortSubCommands.addCommand("search", cohortCommandOptions.searchCommandOptions);
        cohortSubCommands.addCommand("acl", cohortCommandOptions.aclCommandOptions);
        cohortSubCommands.addCommand("delete", cohortCommandOptions.deleteCommandOptions);
        cohortSubCommands.addCommand("info", cohortCommandOptions.infoCommandOptions);
        cohortSubCommands.addCommand("update", cohortCommandOptions.updateCommandOptions);
        cohortSubCommands.addCommand("update-annotations", cohortCommandOptions.updateAnnotationsCommandOptions);

        diseasePanelCommandOptions = new DiseasePanelCommandOptions(commonCommandOptions, jCommander);
        jCommander.addCommand("panels", diseasePanelCommandOptions);
        JCommander diseasePanelSubCommands = jCommander.getCommands().get("panels");
        diseasePanelSubCommands.addCommand("update-acl", diseasePanelCommandOptions.updateAclCommandOptions);
        diseasePanelSubCommands.addCommand("create", diseasePanelCommandOptions.createCommandOptions);
        diseasePanelSubCommands.addCommand("distinct", diseasePanelCommandOptions.distinctCommandOptions);
        diseasePanelSubCommands.addCommand("search", diseasePanelCommandOptions.searchCommandOptions);
        diseasePanelSubCommands.addCommand("acl", diseasePanelCommandOptions.aclCommandOptions);
        diseasePanelSubCommands.addCommand("delete", diseasePanelCommandOptions.deleteCommandOptions);
        diseasePanelSubCommands.addCommand("info", diseasePanelCommandOptions.infoCommandOptions);
        diseasePanelSubCommands.addCommand("update", diseasePanelCommandOptions.updateCommandOptions);

        alignmentCommandOptions = new AlignmentCommandOptions(commonCommandOptions, jCommander);
        jCommander.addCommand("alignments", alignmentCommandOptions);
        JCommander alignmentSubCommands = jCommander.getCommands().get("alignments");
        alignmentSubCommands.addCommand("run-bwa", alignmentCommandOptions.runBwaCommandOptions);
        alignmentSubCommands.addCommand("run-coverage-index", alignmentCommandOptions.runCoverageIndexCommandOptions);
        alignmentSubCommands.addCommand("run-qc-gene-coverage-stats", alignmentCommandOptions.runQcGeneCoverageStatsCommandOptions);
        alignmentSubCommands.addCommand("query-coverage", alignmentCommandOptions.queryCoverageCommandOptions);
        alignmentSubCommands.addCommand("ratio-coverage", alignmentCommandOptions.ratioCoverageCommandOptions);
        alignmentSubCommands.addCommand("stats-coverage", alignmentCommandOptions.statsCoverageCommandOptions);
        alignmentSubCommands.addCommand("run-deeptools", alignmentCommandOptions.runDeeptoolsCommandOptions);
        alignmentSubCommands.addCommand("run-fastqc", alignmentCommandOptions.runFastqcCommandOptions);
        alignmentSubCommands.addCommand("run-index", alignmentCommandOptions.runIndexCommandOptions);
        alignmentSubCommands.addCommand("run-picard", alignmentCommandOptions.runPicardCommandOptions);
        alignmentSubCommands.addCommand("run-qc", alignmentCommandOptions.runQcCommandOptions);
        alignmentSubCommands.addCommand("query", alignmentCommandOptions.queryCommandOptions);
        alignmentSubCommands.addCommand("run-samtools", alignmentCommandOptions.runSamtoolsCommandOptions);

        variantCommandOptions = new VariantCommandOptions(commonCommandOptions, jCommander);
        jCommander.addCommand("variant", variantCommandOptions);
        JCommander variantSubCommands = jCommander.getCommands().get("variant");
        variantSubCommands.addCommand("aggregation-stats", variantCommandOptions.aggregationStatsCommandOptions);
        variantSubCommands.addCommand("metadata-annotation", variantCommandOptions.metadataAnnotationCommandOptions);
        variantSubCommands.addCommand("query-annotation", variantCommandOptions.queryAnnotationCommandOptions);
        variantSubCommands.addCommand("run-circos", variantCommandOptions.runCircosCommandOptions);
        variantSubCommands.addCommand("delete-cohort-stats", variantCommandOptions.deleteCohortStatsCommandOptions);
        variantSubCommands.addCommand("info-cohort-stats", variantCommandOptions.infoCohortStatsCommandOptions);
        variantSubCommands.addCommand("run-cohort-stats", variantCommandOptions.runCohortStatsCommandOptions);
        variantSubCommands.addCommand("run-export", variantCommandOptions.runExportCommandOptions);
        variantSubCommands.addCommand("genotypes-family", variantCommandOptions.genotypesFamilyCommandOptions);
        variantSubCommands.addCommand("run-family-qc", variantCommandOptions.runFamilyQcCommandOptions);
        variantSubCommands.addCommand("delete-file", variantCommandOptions.deleteFileCommandOptions);
        variantSubCommands.addCommand("run-gatk", variantCommandOptions.runGatkCommandOptions);
        variantSubCommands.addCommand("run-genome-plot", variantCommandOptions.runGenomePlotCommandOptions);
        variantSubCommands.addCommand("run-gwas", variantCommandOptions.runGwasCommandOptions);
        variantSubCommands.addCommand("run-index", variantCommandOptions.runIndexCommandOptions);
        variantSubCommands.addCommand("run-individual-qc", variantCommandOptions.runIndividualQcCommandOptions);
        variantSubCommands.addCommand("run-inferred-sex", variantCommandOptions.runInferredSexCommandOptions);
        variantSubCommands.addCommand("query-knockout-gene", variantCommandOptions.queryKnockoutGeneCommandOptions);
        variantSubCommands.addCommand("query-knockout-individual", variantCommandOptions.queryKnockoutIndividualCommandOptions);
        variantSubCommands.addCommand("run-knockout", variantCommandOptions.runKnockoutCommandOptions);
        variantSubCommands.addCommand("run-mendelian-error", variantCommandOptions.runMendelianErrorCommandOptions);
        variantSubCommands.addCommand("metadata", variantCommandOptions.metadataCommandOptions);
        variantSubCommands.addCommand("query-mutational-signature", variantCommandOptions.queryMutationalSignatureCommandOptions);
        variantSubCommands.addCommand("run-mutational-signature", variantCommandOptions.runMutationalSignatureCommandOptions);
        variantSubCommands.addCommand("run-plink", variantCommandOptions.runPlinkCommandOptions);
        variantSubCommands.addCommand("query", variantCommandOptions.queryCommandOptions);
        variantSubCommands.addCommand("run-relatedness", variantCommandOptions.runRelatednessCommandOptions);
        variantSubCommands.addCommand("run-rvtests", variantCommandOptions.runRvtestsCommandOptions);
        variantSubCommands.addCommand("aggregation-stats-sample", variantCommandOptions.aggregationStatsSampleCommandOptions);
        variantSubCommands.addCommand("run-sample-eligibility", variantCommandOptions.runSampleEligibilityCommandOptions);
        variantSubCommands.addCommand("run-sample-qc", variantCommandOptions.runSampleQcCommandOptions);
        variantSubCommands.addCommand("query-sample", variantCommandOptions.querySampleCommandOptions);
        variantSubCommands.addCommand("run-sample", variantCommandOptions.runSampleCommandOptions);
        variantSubCommands.addCommand("query-sample-stats", variantCommandOptions.querySampleStatsCommandOptions);
        variantSubCommands.addCommand("run-sample-stats", variantCommandOptions.runSampleStatsCommandOptions);
        variantSubCommands.addCommand("run-stats-export", variantCommandOptions.runStatsExportCommandOptions);
        variantSubCommands.addCommand("run-stats", variantCommandOptions.runStatsCommandOptions);

        clinicalAnalysisCommandOptions = new ClinicalAnalysisCommandOptions(commonCommandOptions, jCommander);
        jCommander.addCommand("clinical", clinicalAnalysisCommandOptions);
        JCommander clinicalAnalysisSubCommands = jCommander.getCommands().get("clinical");
        clinicalAnalysisSubCommands.addCommand("update-acl", clinicalAnalysisCommandOptions.updateAclCommandOptions);
        clinicalAnalysisSubCommands.addCommand("update-clinical-configuration", clinicalAnalysisCommandOptions.updateClinicalConfigurationCommandOptions);
        clinicalAnalysisSubCommands.addCommand("create", clinicalAnalysisCommandOptions.createCommandOptions);
        clinicalAnalysisSubCommands.addCommand("distinct", clinicalAnalysisCommandOptions.distinctCommandOptions);
        clinicalAnalysisSubCommands.addCommand("distinct-interpretation", clinicalAnalysisCommandOptions.distinctInterpretationCommandOptions);
        clinicalAnalysisSubCommands.addCommand("search-interpretation", clinicalAnalysisCommandOptions.searchInterpretationCommandOptions);
        clinicalAnalysisSubCommands.addCommand("info-interpretation", clinicalAnalysisCommandOptions.infoInterpretationCommandOptions);
        clinicalAnalysisSubCommands.addCommand("run-interpreter-cancer-tiering", clinicalAnalysisCommandOptions.runInterpreterCancerTieringCommandOptions);
        clinicalAnalysisSubCommands.addCommand("run-interpreter-team", clinicalAnalysisCommandOptions.runInterpreterTeamCommandOptions);
        clinicalAnalysisSubCommands.addCommand("run-interpreter-tiering", clinicalAnalysisCommandOptions.runInterpreterTieringCommandOptions);
        clinicalAnalysisSubCommands.addCommand("run-interpreter-zetta", clinicalAnalysisCommandOptions.runInterpreterZettaCommandOptions);
        clinicalAnalysisSubCommands.addCommand("aggregation-stats-rga", clinicalAnalysisCommandOptions.aggregationStatsRgaCommandOptions);
        clinicalAnalysisSubCommands.addCommand("query-rga-gene", clinicalAnalysisCommandOptions.queryRgaGeneCommandOptions);
        clinicalAnalysisSubCommands.addCommand("summary-rga-gene", clinicalAnalysisCommandOptions.summaryRgaGeneCommandOptions);
        clinicalAnalysisSubCommands.addCommand("run-rga-index", clinicalAnalysisCommandOptions.runRgaIndexCommandOptions);
        clinicalAnalysisSubCommands.addCommand("query-rga-individual", clinicalAnalysisCommandOptions.queryRgaIndividualCommandOptions);
        clinicalAnalysisSubCommands.addCommand("summary-rga-individual", clinicalAnalysisCommandOptions.summaryRgaIndividualCommandOptions);
        clinicalAnalysisSubCommands.addCommand("query-rga-variant", clinicalAnalysisCommandOptions.queryRgaVariantCommandOptions);
        clinicalAnalysisSubCommands.addCommand("summary-rga-variant", clinicalAnalysisCommandOptions.summaryRgaVariantCommandOptions);
        clinicalAnalysisSubCommands.addCommand("search", clinicalAnalysisCommandOptions.searchCommandOptions);
        clinicalAnalysisSubCommands.addCommand("actionable-variant", clinicalAnalysisCommandOptions.actionableVariantCommandOptions);
        clinicalAnalysisSubCommands.addCommand("query-variant", clinicalAnalysisCommandOptions.queryVariantCommandOptions);
        clinicalAnalysisSubCommands.addCommand("acl", clinicalAnalysisCommandOptions.aclCommandOptions);
        clinicalAnalysisSubCommands.addCommand("delete", clinicalAnalysisCommandOptions.deleteCommandOptions);
        clinicalAnalysisSubCommands.addCommand("update", clinicalAnalysisCommandOptions.updateCommandOptions);
        clinicalAnalysisSubCommands.addCommand("info", clinicalAnalysisCommandOptions.infoCommandOptions);
        clinicalAnalysisSubCommands.addCommand("create-interpretation", clinicalAnalysisCommandOptions.createInterpretationCommandOptions);
        clinicalAnalysisSubCommands.addCommand("clear-interpretation", clinicalAnalysisCommandOptions.clearInterpretationCommandOptions);
        clinicalAnalysisSubCommands.addCommand("delete-interpretation", clinicalAnalysisCommandOptions.deleteInterpretationCommandOptions);
        clinicalAnalysisSubCommands.addCommand("merge-interpretation", clinicalAnalysisCommandOptions.mergeInterpretationCommandOptions);
        clinicalAnalysisSubCommands.addCommand("revert-interpretation", clinicalAnalysisCommandOptions.revertInterpretationCommandOptions);
        clinicalAnalysisSubCommands.addCommand("update-interpretation", clinicalAnalysisCommandOptions.updateInterpretationCommandOptions);

        variantOperationCommandOptions = new VariantOperationCommandOptions(commonCommandOptions, jCommander);
        jCommander.addCommand("operations", variantOperationCommandOptions);
        JCommander variantOperationSubCommands = jCommander.getCommands().get("operations");
        variantOperationSubCommands.addCommand("configure-cellbase", variantOperationCommandOptions.configureCellbaseCommandOptions);
        variantOperationSubCommands.addCommand("aggregate-variant", variantOperationCommandOptions.aggregateVariantCommandOptions);
        variantOperationSubCommands.addCommand("delete-variant-annotation", variantOperationCommandOptions.deleteVariantAnnotationCommandOptions);
        variantOperationSubCommands.addCommand("index-variant-annotation", variantOperationCommandOptions.indexVariantAnnotationCommandOptions);
        variantOperationSubCommands.addCommand("save-variant-annotation", variantOperationCommandOptions.saveVariantAnnotationCommandOptions);
        variantOperationSubCommands.addCommand("configure-variant", variantOperationCommandOptions.configureVariantCommandOptions);
        variantOperationSubCommands.addCommand("aggregate-variant-family", variantOperationCommandOptions.aggregateVariantFamilyCommandOptions);
        variantOperationSubCommands.addCommand("index-variant-family", variantOperationCommandOptions.indexVariantFamilyCommandOptions);
        variantOperationSubCommands.addCommand("launcher-variant-index", variantOperationCommandOptions.launcherVariantIndexCommandOptions);
        variantOperationSubCommands.addCommand("run-variant-julie", variantOperationCommandOptions.runVariantJulieCommandOptions);
        variantOperationSubCommands.addCommand("repair-variant-metadata", variantOperationCommandOptions.repairVariantMetadataCommandOptions);
        variantOperationSubCommands.addCommand("synchronize-variant-metadata", variantOperationCommandOptions.synchronizeVariantMetadataCommandOptions);
        variantOperationSubCommands.addCommand("index-variant-sample", variantOperationCommandOptions.indexVariantSampleCommandOptions);
        variantOperationSubCommands.addCommand("configure-sample-index", variantOperationCommandOptions.configureSampleIndexCommandOptions);
        variantOperationSubCommands.addCommand("delete-variant-score", variantOperationCommandOptions.deleteVariantScoreCommandOptions);
        variantOperationSubCommands.addCommand("index-variant-score", variantOperationCommandOptions.indexVariantScoreCommandOptions);
        variantOperationSubCommands.addCommand("secondary-index-variant", variantOperationCommandOptions.secondaryIndexVariantCommandOptions);
        variantOperationSubCommands.addCommand("delete-variant-secondary-index", variantOperationCommandOptions.deleteVariantSecondaryIndexCommandOptions);
        variantOperationSubCommands.addCommand("index-variant-stats", variantOperationCommandOptions.indexVariantStatsCommandOptions);

        metaCommandOptions = new MetaCommandOptions(commonCommandOptions, jCommander);
        jCommander.addCommand("meta", metaCommandOptions);
        JCommander metaSubCommands = jCommander.getCommands().get("meta");
        metaSubCommands.addCommand("about", metaCommandOptions.aboutCommandOptions);
        metaSubCommands.addCommand("api", metaCommandOptions.apiCommandOptions);
        metaSubCommands.addCommand("fail", metaCommandOptions.failCommandOptions);
        metaSubCommands.addCommand("ping", metaCommandOptions.pingCommandOptions);
        metaSubCommands.addCommand("status", metaCommandOptions.statusCommandOptions);
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
        Set<String> analysisCommands = new HashSet<>(Arrays.asList("alignments","variant","clinical"));
        Set<String> operationsCommands = new HashSet<>(Collections.singletonList("operations"));

        System.err.println("Catalog commands:");
        for (String command : jCommander.getCommands().keySet()) {
            if (!analysisCommands.contains(command) && !operationsCommands.contains(command)) {
                System.err.printf("%14s  %s\n", command, jCommander.getCommandDescription(command));
            }
        }

        System.err.println("");
        System.err.println("Analysis commands:");
        for (String command : jCommander.getCommands().keySet()) {
            if (analysisCommands.contains(command)) {
                System.err.printf("%14s  %s\n", command, jCommander.getCommandDescription(command));
            }
        }

        System.err.println("");
        System.err.println("Operation commands:");
        for (String command : jCommander.getCommands().keySet()) {
            if (operationsCommands.contains(command)) {
                System.err.printf("%14s  %s\n", command, jCommander.getCommandDescription(command));
            }
        }
    }

    public GeneralCliOptions.CommonCommandOptions getCommonCommandOptions() {
        return commonCommandOptions;
    }
    
    public UserCommandOptions getUserCommandOptions() {
        return userCommandOptions;
    }
    
    public ProjectCommandOptions getProjectCommandOptions() {
        return projectCommandOptions;
    }
    
    public StudyCommandOptions getStudyCommandOptions() {
        return studyCommandOptions;
    }
    
    public FileCommandOptions getFileCommandOptions() {
        return fileCommandOptions;
    }
    
    public JobCommandOptions getJobCommandOptions() {
        return jobCommandOptions;
    }
    
    public SampleCommandOptions getSampleCommandOptions() {
        return sampleCommandOptions;
    }
    
    public IndividualCommandOptions getIndividualCommandOptions() {
        return individualCommandOptions;
    }
    
    public FamilyCommandOptions getFamilyCommandOptions() {
        return familyCommandOptions;
    }
    
    public CohortCommandOptions getCohortCommandOptions() {
        return cohortCommandOptions;
    }
    
    public DiseasePanelCommandOptions getDiseasePanelCommandOptions() {
        return diseasePanelCommandOptions;
    }
    
    public AlignmentCommandOptions getAlignmentCommandOptions() {
        return alignmentCommandOptions;
    }
    
    public VariantCommandOptions getVariantCommandOptions() {
        return variantCommandOptions;
    }
    
    public ClinicalAnalysisCommandOptions getClinicalAnalysisCommandOptions() {
        return clinicalAnalysisCommandOptions;
    }
    
    public VariantOperationCommandOptions getVariantOperationCommandOptions() {
        return variantOperationCommandOptions;
    }
    
    public MetaCommandOptions getMetaCommandOptions() {
        return metaCommandOptions;
    }
}
