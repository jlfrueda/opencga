package org.opencb.opencga.app.cli.main.executors;

import org.opencb.opencga.app.cli.session.CliSessionManager;
import org.opencb.opencga.app.cli.main.executors.OpencgaCommandExecutor;
import org.opencb.opencga.app.cli.main.*;
import org.opencb.opencga.core.response.RestResponse;
import org.opencb.opencga.client.exceptions.ClientException;
import org.opencb.commons.datastore.core.ObjectMap;

import org.opencb.opencga.app.cli.main.CommandLineUtils;

import org.opencb.opencga.catalog.exceptions.CatalogAuthenticationException;

import java.util.List;

import org.opencb.opencga.app.cli.main.options.AnalysisAlignmentCommandOptions;

import org.opencb.opencga.core.models.job.Job;
import org.opencb.opencga.core.models.alignment.PicardWrapperParams;
import org.opencb.opencga.core.models.alignment.SamtoolsWrapperParams;
import org.opencb.biodata.models.alignment.RegionCoverage;
import org.opencb.opencga.core.models.alignment.CoverageIndexParams;
import org.opencb.opencga.core.models.alignment.DeeptoolsWrapperParams;
import org.opencb.opencga.core.models.alignment.FastqcWrapperParams;
import org.opencb.opencga.core.models.alignment.AlignmentGeneCoverageStatsParams;
import org.opencb.biodata.models.alignment.GeneCoverageStats;
import org.opencb.opencga.core.models.alignment.BwaWrapperParams;
import org.opencb.opencga.core.models.alignment.AlignmentQcParams;
import org.opencb.opencga.core.models.alignment.AlignmentIndexParams;
import org.ga4gh.models.ReadAlignment;


/*
* WARNING: AUTOGENERATED CODE
*
* This code was generated by a tool.
* Autogenerated on: 2021-12-09
*
* Manual changes to this file may cause unexpected behavior in your application.
* Manual changes to this file will be overwritten if the code is regenerated.
*/


/**
 * This class contains methods for the Analysis - Alignment command line.
 *    OpenCGA version: 2.2.0-SNAPSHOT
 *    PATH: /{apiVersion}/analysis/alignment
 */
public class AnalysisAlignmentCommandExecutor extends OpencgaCommandExecutor {

    private AnalysisAlignmentCommandOptions analysisAlignmentCommandOptions;

    public AnalysisAlignmentCommandExecutor(AnalysisAlignmentCommandOptions analysisAlignmentCommandOptions) throws CatalogAuthenticationException {
        super(analysisAlignmentCommandOptions.commonCommandOptions);
        this.analysisAlignmentCommandOptions = analysisAlignmentCommandOptions;
    }

    @Override
    public void execute() throws Exception {

        logger.debug("Executing Analysis - Alignment command line");

        String subCommandString = getParsedSubCommand(analysisAlignmentCommandOptions.jCommander);

        RestResponse queryResponse = null;

        switch (subCommandString) {
            case "run-bwa":
                queryResponse = runBwa();
                break;
            case "run-coverage-index":
                queryResponse = runCoverageIndex();
                break;
            case "run-qc-geneCoverageStats":
                queryResponse = runQcGeneCoverageStats();
                break;
            case "query-coverage":
                queryResponse = queryCoverage();
                break;
            case "ratio-coverage":
                queryResponse = ratioCoverage();
                break;
            case "stats-coverage":
                queryResponse = statsCoverage();
                break;
            case "run-deeptools":
                queryResponse = runDeeptools();
                break;
            case "run-fastqc":
                queryResponse = runFastqc();
                break;
            case "run-index":
                queryResponse = runIndex();
                break;
            case "run-picard":
                queryResponse = runPicard();
                break;
            case "run-qc":
                queryResponse = runQc();
                break;
            case "query":
                queryResponse = query();
                break;
            case "run-samtools":
                queryResponse = runSamtools();
                break;
            default:
                logger.error("Subcommand not valid");
                break;
        }

        createOutput(queryResponse);

    }

    private RestResponse<Job> runBwa() throws Exception {

        logger.debug("Executing runBwa in Analysis - Alignment command line");

        AnalysisAlignmentCommandOptions.RunBwaCommandOptions commandOptions = analysisAlignmentCommandOptions.runBwaCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("jobId", commandOptions.jobId);
        queryParams.putIfNotEmpty("jobDependsOn", commandOptions.jobDependsOn);
        queryParams.putIfNotEmpty("jobDescription", commandOptions.jobDescription);
        queryParams.putIfNotEmpty("jobTags", commandOptions.jobTags);
        if(queryParams.get("study")==null && CliSessionManager.isShell()){
                queryParams.putIfNotEmpty("study", CliSessionManager.getCurrentStudy());
        }


        BwaWrapperParams bwaWrapperParams = (BwaWrapperParams) new BwaWrapperParams()
            .setCommand(commandOptions.command)
            .setFastaFile(commandOptions.fastaFile)
            .setFastq1File(commandOptions.fastq1File)
            .setFastq2File(commandOptions.fastq2File)
            .setOutdir(commandOptions.outdir);
        return openCGAClient.getAlignmentClient().runBwa(bwaWrapperParams, queryParams);
    }

    private RestResponse<Job> runCoverageIndex() throws Exception {

        logger.debug("Executing runCoverageIndex in Analysis - Alignment command line");

        AnalysisAlignmentCommandOptions.RunCoverageIndexCommandOptions commandOptions = analysisAlignmentCommandOptions.runCoverageIndexCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("jobId", commandOptions.jobId);
        queryParams.putIfNotEmpty("jobDependsOn", commandOptions.jobDependsOn);
        queryParams.putIfNotEmpty("jobDescription", commandOptions.jobDescription);
        queryParams.putIfNotEmpty("jobTags", commandOptions.jobTags);
        if(queryParams.get("study")==null && CliSessionManager.isShell()){
                queryParams.putIfNotEmpty("study", CliSessionManager.getCurrentStudy());
        }


        CoverageIndexParams coverageIndexParams = (CoverageIndexParams) new CoverageIndexParams()
            .setFile(commandOptions.file)
            .setWindowSize(commandOptions.windowSize)
            .setOverwrite(commandOptions.overwrite);
        return openCGAClient.getAlignmentClient().runCoverageIndex(coverageIndexParams, queryParams);
    }

    private RestResponse<Job> runQcGeneCoverageStats() throws Exception {

        logger.debug("Executing runQcGeneCoverageStats in Analysis - Alignment command line");

        AnalysisAlignmentCommandOptions.RunQcGeneCoverageStatsCommandOptions commandOptions = analysisAlignmentCommandOptions.runQcGeneCoverageStatsCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("jobId", commandOptions.jobId);
        queryParams.putIfNotEmpty("jobDependsOn", commandOptions.jobDependsOn);
        queryParams.putIfNotEmpty("jobDescription", commandOptions.jobDescription);
        queryParams.putIfNotEmpty("jobTags", commandOptions.jobTags);
        if(queryParams.get("study")==null && CliSessionManager.isShell()){
                queryParams.putIfNotEmpty("study", CliSessionManager.getCurrentStudy());
        }


        AlignmentGeneCoverageStatsParams alignmentGeneCoverageStatsParams = (AlignmentGeneCoverageStatsParams) new AlignmentGeneCoverageStatsParams()
            .setBamFile(commandOptions.bamFile)
            .setGenes(CommandLineUtils.getListValues(commandOptions.genes))
            .setOutdir(commandOptions.outdir);
        return openCGAClient.getAlignmentClient().runQcGeneCoverageStats(alignmentGeneCoverageStatsParams, queryParams);
    }

    private RestResponse<RegionCoverage> queryCoverage() throws Exception {

        logger.debug("Executing queryCoverage in Analysis - Alignment command line");

        AnalysisAlignmentCommandOptions.QueryCoverageCommandOptions commandOptions = analysisAlignmentCommandOptions.queryCoverageCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("region", commandOptions.region);
        queryParams.putIfNotEmpty("gene", commandOptions.gene);
        queryParams.putIfNotNull("offset", commandOptions.offset);
        queryParams.putIfNotNull("onlyExons", commandOptions.onlyExons);
        queryParams.putIfNotEmpty("range", commandOptions.range);
        queryParams.putIfNotNull("windowSize", commandOptions.windowSize);
        queryParams.putIfNotNull("splitResults", commandOptions.splitResults);
        if(queryParams.get("study")==null && CliSessionManager.isShell()){
                queryParams.putIfNotEmpty("study", CliSessionManager.getCurrentStudy());
        }

        return openCGAClient.getAlignmentClient().queryCoverage(commandOptions.file, queryParams);
    }

    private RestResponse<RegionCoverage> ratioCoverage() throws Exception {

        logger.debug("Executing ratioCoverage in Analysis - Alignment command line");

        AnalysisAlignmentCommandOptions.RatioCoverageCommandOptions commandOptions = analysisAlignmentCommandOptions.ratioCoverageCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotNull("skipLog2", commandOptions.skipLog2);
        queryParams.putIfNotEmpty("region", commandOptions.region);
        queryParams.putIfNotEmpty("gene", commandOptions.gene);
        queryParams.putIfNotNull("offset", commandOptions.offset);
        queryParams.putIfNotNull("onlyExons", commandOptions.onlyExons);
        queryParams.putIfNotNull("windowSize", commandOptions.windowSize);
        queryParams.putIfNotNull("splitResults", commandOptions.splitResults);
        if(queryParams.get("study")==null && CliSessionManager.isShell()){
                queryParams.putIfNotEmpty("study", CliSessionManager.getCurrentStudy());
        }

        return openCGAClient.getAlignmentClient().ratioCoverage(commandOptions.file1, commandOptions.file2, queryParams);
    }

    private RestResponse<GeneCoverageStats> statsCoverage() throws Exception {

        logger.debug("Executing statsCoverage in Analysis - Alignment command line");

        AnalysisAlignmentCommandOptions.StatsCoverageCommandOptions commandOptions = analysisAlignmentCommandOptions.statsCoverageCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotNull("threshold", commandOptions.threshold);
        if(queryParams.get("study")==null && CliSessionManager.isShell()){
                queryParams.putIfNotEmpty("study", CliSessionManager.getCurrentStudy());
        }

        return openCGAClient.getAlignmentClient().statsCoverage(commandOptions.file, commandOptions.gene, queryParams);
    }

    private RestResponse<Job> runDeeptools() throws Exception {

        logger.debug("Executing runDeeptools in Analysis - Alignment command line");

        AnalysisAlignmentCommandOptions.RunDeeptoolsCommandOptions commandOptions = analysisAlignmentCommandOptions.runDeeptoolsCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("jobId", commandOptions.jobId);
        queryParams.putIfNotEmpty("jobDependsOn", commandOptions.jobDependsOn);
        queryParams.putIfNotEmpty("jobDescription", commandOptions.jobDescription);
        queryParams.putIfNotEmpty("jobTags", commandOptions.jobTags);
        if(queryParams.get("study")==null && CliSessionManager.isShell()){
                queryParams.putIfNotEmpty("study", CliSessionManager.getCurrentStudy());
        }


        DeeptoolsWrapperParams deeptoolsWrapperParams = (DeeptoolsWrapperParams) new DeeptoolsWrapperParams()
            .setCommand(commandOptions.command)
            .setOutdir(commandOptions.outdir);
        return openCGAClient.getAlignmentClient().runDeeptools(deeptoolsWrapperParams, queryParams);
    }

    private RestResponse<Job> runFastqc() throws Exception {

        logger.debug("Executing runFastqc in Analysis - Alignment command line");

        AnalysisAlignmentCommandOptions.RunFastqcCommandOptions commandOptions = analysisAlignmentCommandOptions.runFastqcCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("jobId", commandOptions.jobId);
        queryParams.putIfNotEmpty("jobDependsOn", commandOptions.jobDependsOn);
        queryParams.putIfNotEmpty("jobDescription", commandOptions.jobDescription);
        queryParams.putIfNotEmpty("jobTags", commandOptions.jobTags);
        if(queryParams.get("study")==null && CliSessionManager.isShell()){
                queryParams.putIfNotEmpty("study", CliSessionManager.getCurrentStudy());
        }


        FastqcWrapperParams fastqcWrapperParams = (FastqcWrapperParams) new FastqcWrapperParams()
            .setInputFile(commandOptions.inputFile)
            .setOutdir(commandOptions.outdir);
        return openCGAClient.getAlignmentClient().runFastqc(fastqcWrapperParams, queryParams);
    }

    private RestResponse<Job> runIndex() throws Exception {

        logger.debug("Executing runIndex in Analysis - Alignment command line");

        AnalysisAlignmentCommandOptions.RunIndexCommandOptions commandOptions = analysisAlignmentCommandOptions.runIndexCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("jobId", commandOptions.jobId);
        queryParams.putIfNotEmpty("jobDependsOn", commandOptions.jobDependsOn);
        queryParams.putIfNotEmpty("jobDescription", commandOptions.jobDescription);
        queryParams.putIfNotEmpty("jobTags", commandOptions.jobTags);
        if(queryParams.get("study")==null && CliSessionManager.isShell()){
                queryParams.putIfNotEmpty("study", CliSessionManager.getCurrentStudy());
        }


        AlignmentIndexParams alignmentIndexParams = (AlignmentIndexParams) new AlignmentIndexParams()
            .setFile(commandOptions.file)
            .setOverwrite(commandOptions.overwrite);
        return openCGAClient.getAlignmentClient().runIndex(alignmentIndexParams, queryParams);
    }

    private RestResponse<Job> runPicard() throws Exception {

        logger.debug("Executing runPicard in Analysis - Alignment command line");

        AnalysisAlignmentCommandOptions.RunPicardCommandOptions commandOptions = analysisAlignmentCommandOptions.runPicardCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("jobId", commandOptions.jobId);
        queryParams.putIfNotEmpty("jobDependsOn", commandOptions.jobDependsOn);
        queryParams.putIfNotEmpty("jobDescription", commandOptions.jobDescription);
        queryParams.putIfNotEmpty("jobTags", commandOptions.jobTags);
        if(queryParams.get("study")==null && CliSessionManager.isShell()){
                queryParams.putIfNotEmpty("study", CliSessionManager.getCurrentStudy());
        }


        PicardWrapperParams picardWrapperParams = (PicardWrapperParams) new PicardWrapperParams()
            .setCommand(commandOptions.command)
            .setOutdir(commandOptions.outdir);
        return openCGAClient.getAlignmentClient().runPicard(picardWrapperParams, queryParams);
    }

    private RestResponse<Job> runQc() throws Exception {

        logger.debug("Executing runQc in Analysis - Alignment command line");

        AnalysisAlignmentCommandOptions.RunQcCommandOptions commandOptions = analysisAlignmentCommandOptions.runQcCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("jobId", commandOptions.jobId);
        queryParams.putIfNotEmpty("jobDependsOn", commandOptions.jobDependsOn);
        queryParams.putIfNotEmpty("jobDescription", commandOptions.jobDescription);
        queryParams.putIfNotEmpty("jobTags", commandOptions.jobTags);
        if(queryParams.get("study")==null && CliSessionManager.isShell()){
                queryParams.putIfNotEmpty("study", CliSessionManager.getCurrentStudy());
        }


        AlignmentQcParams alignmentQcParams = (AlignmentQcParams) new AlignmentQcParams()
            .setBamFile(commandOptions.bamFile)
            .setBedFile(commandOptions.bedFile)
            .setDictFile(commandOptions.dictFile)
            .setSkip(commandOptions.skip)
            .setOverwrite(commandOptions.overwrite)
            .setOutdir(commandOptions.outdir);
        return openCGAClient.getAlignmentClient().runQc(alignmentQcParams, queryParams);
    }

    private RestResponse<ReadAlignment> query() throws Exception {

        logger.debug("Executing query in Analysis - Alignment command line");

        AnalysisAlignmentCommandOptions.QueryCommandOptions commandOptions = analysisAlignmentCommandOptions.queryCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotNull("limit", commandOptions.limit);
        queryParams.putIfNotNull("skip", commandOptions.skip);
        queryParams.putIfNotNull("count", commandOptions.count);
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("region", commandOptions.region);
        queryParams.putIfNotEmpty("gene", commandOptions.gene);
        queryParams.putIfNotNull("offset", commandOptions.offset);
        queryParams.putIfNotNull("onlyExons", commandOptions.onlyExons);
        queryParams.putIfNotNull("minMappingQuality", commandOptions.minMappingQuality);
        queryParams.putIfNotNull("maxNumMismatches", commandOptions.maxNumMismatches);
        queryParams.putIfNotNull("maxNumHits", commandOptions.maxNumHits);
        queryParams.putIfNotNull("properlyPaired", commandOptions.properlyPaired);
        queryParams.putIfNotNull("maxInsertSize", commandOptions.maxInsertSize);
        queryParams.putIfNotNull("skipUnmapped", commandOptions.skipUnmapped);
        queryParams.putIfNotNull("skipDuplicated", commandOptions.skipDuplicated);
        queryParams.putIfNotNull("regionContained", commandOptions.regionContained);
        queryParams.putIfNotNull("forceMDField", commandOptions.forceMDField);
        queryParams.putIfNotNull("binQualities", commandOptions.binQualities);
        queryParams.putIfNotNull("splitResults", commandOptions.splitResults);
        if(queryParams.get("study")==null && CliSessionManager.isShell()){
                queryParams.putIfNotEmpty("study", CliSessionManager.getCurrentStudy());
        }

        return openCGAClient.getAlignmentClient().query(commandOptions.file, queryParams);
    }

    private RestResponse<Job> runSamtools() throws Exception {

        logger.debug("Executing runSamtools in Analysis - Alignment command line");

        AnalysisAlignmentCommandOptions.RunSamtoolsCommandOptions commandOptions = analysisAlignmentCommandOptions.runSamtoolsCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("jobId", commandOptions.jobId);
        queryParams.putIfNotEmpty("jobDependsOn", commandOptions.jobDependsOn);
        queryParams.putIfNotEmpty("jobDescription", commandOptions.jobDescription);
        queryParams.putIfNotEmpty("jobTags", commandOptions.jobTags);
        if(queryParams.get("study")==null && CliSessionManager.isShell()){
                queryParams.putIfNotEmpty("study", CliSessionManager.getCurrentStudy());
        }


        SamtoolsWrapperParams samtoolsWrapperParams = (SamtoolsWrapperParams) new SamtoolsWrapperParams()
            .setCommand(commandOptions.command)
            .setInputFile(commandOptions.inputFile)
            .setOutdir(commandOptions.outdir);
        return openCGAClient.getAlignmentClient().runSamtools(samtoolsWrapperParams, queryParams);
    }
}