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
* Autogenerated on: 2022-09-23
*
* Manual changes to this file may cause unexpected behavior in your application.
* Manual changes to this file will be overwritten if the code is regenerated.
*/


/**
 * This class contains methods for the Analysis - Alignment command line.
 *    OpenCGA version: 2.4.5-SNAPSHOT
 *    PATH: /{apiVersion}/analysis/alignment
 */
@Parameters(commandNames = {"alignments"}, commandDescription = "Analysis - Alignment commands")
public class AnalysisAlignmentCommandOptions {

        public JCommander jCommander;
        public CommonCommandOptions commonCommandOptions;

        public RunBwaCommandOptions runBwaCommandOptions;
        public RunCoverageIndexCommandOptions runCoverageIndexCommandOptions;
        public CoverageQcGeneCoverageStatsRunCommandOptions coverageQcGeneCoverageStatsRunCommandOptions;
        public QueryCoverageCommandOptions queryCoverageCommandOptions;
        public RatioCoverageCommandOptions ratioCoverageCommandOptions;
        public StatsCoverageCommandOptions statsCoverageCommandOptions;
        public RunDeeptoolsCommandOptions runDeeptoolsCommandOptions;
        public RunFastqcCommandOptions runFastqcCommandOptions;
        public RunIndexCommandOptions runIndexCommandOptions;
        public RunPicardCommandOptions runPicardCommandOptions;
        public RunQcCommandOptions runQcCommandOptions;
        public QueryCommandOptions queryCommandOptions;
        public RunSamtoolsCommandOptions runSamtoolsCommandOptions;


    public AnalysisAlignmentCommandOptions(CommonCommandOptions commonCommandOptions, JCommander jCommander) {
    
        this.jCommander = jCommander;
        this.commonCommandOptions = commonCommandOptions;
        this.runBwaCommandOptions = new RunBwaCommandOptions();
        this.runCoverageIndexCommandOptions = new RunCoverageIndexCommandOptions();
        this.coverageQcGeneCoverageStatsRunCommandOptions = new CoverageQcGeneCoverageStatsRunCommandOptions();
        this.queryCoverageCommandOptions = new QueryCoverageCommandOptions();
        this.ratioCoverageCommandOptions = new RatioCoverageCommandOptions();
        this.statsCoverageCommandOptions = new StatsCoverageCommandOptions();
        this.runDeeptoolsCommandOptions = new RunDeeptoolsCommandOptions();
        this.runFastqcCommandOptions = new RunFastqcCommandOptions();
        this.runIndexCommandOptions = new RunIndexCommandOptions();
        this.runPicardCommandOptions = new RunPicardCommandOptions();
        this.runQcCommandOptions = new RunQcCommandOptions();
        this.queryCommandOptions = new QueryCommandOptions();
        this.runSamtoolsCommandOptions = new RunSamtoolsCommandOptions();
    
    }
    
    @Parameters(commandNames = {"bwa-run"}, commandDescription ="BWA is a software package for mapping low-divergent sequences against a large reference genome.")
    public class RunBwaCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--json-file"}, description = "File with the body data in JSON format. Note, that using this parameter will ignore all the other parameters.", required = false, arity = 1)
        public String jsonFile;
    
        @Parameter(names = {"--json-data-model"}, description = "Show example of file structure for body data.", help = true, arity = 0)
        public Boolean jsonDataModel = false;
    
        @Parameter(names = {"--study", "-s"}, description = "study", required = false, arity = 1)
        public String study; 
    
        @Parameter(names = {"--job-id"}, description = "Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not provided.", required = false, arity = 1)
        public String jobId; 
    
        @Parameter(names = {"--job-depends-on"}, description = "Comma separated list of existing job IDs the job will depend on.", required = false, arity = 1)
        public String jobDependsOn; 
    
        @Parameter(names = {"--job-description"}, description = "Job description", required = false, arity = 1)
        public String jobDescription; 
    
        @Parameter(names = {"--job-tags"}, description = "Job tags", required = false, arity = 1)
        public String jobTags; 
    
        @Parameter(names = {"--command"}, description = "The body web service command parameter", required = false, arity = 1)
        public String command;
    
        @Parameter(names = {"--fasta-file"}, description = "The body web service fastaFile parameter", required = false, arity = 1)
        public String fastaFile;
    
        @Parameter(names = {"--fastq1file"}, description = "The body web service fastq1File parameter", required = false, arity = 1)
        public String fastq1File;
    
        @Parameter(names = {"--fastq2file"}, description = "The body web service fastq2File parameter", required = false, arity = 1)
        public String fastq2File;
    
        @Parameter(names = {"--outdir"}, description = "The body web service outdir parameter", required = false, arity = 1)
        public String outdir;
    
    }

    @Parameters(commandNames = {"coverage-index-run"}, commandDescription ="Compute coverage for a list of alignment files")
    public class RunCoverageIndexCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--json-file"}, description = "File with the body data in JSON format. Note, that using this parameter will ignore all the other parameters.", required = false, arity = 1)
        public String jsonFile;
    
        @Parameter(names = {"--json-data-model"}, description = "Show example of file structure for body data.", help = true, arity = 0)
        public Boolean jsonDataModel = false;
    
        @Parameter(names = {"--study", "-s"}, description = "study", required = false, arity = 1)
        public String study; 
    
        @Parameter(names = {"--job-id"}, description = "Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not provided.", required = false, arity = 1)
        public String jobId; 
    
        @Parameter(names = {"--job-depends-on"}, description = "Comma separated list of existing job IDs the job will depend on.", required = false, arity = 1)
        public String jobDependsOn; 
    
        @Parameter(names = {"--job-description"}, description = "Job description", required = false, arity = 1)
        public String jobDescription; 
    
        @Parameter(names = {"--job-tags"}, description = "Job tags", required = false, arity = 1)
        public String jobTags; 
    
        @Parameter(names = {"--file"}, description = "The body web service file parameter", required = false, arity = 1)
        public String file;
    
        @Parameter(names = {"--window-size"}, description = "The body web service windowSize parameter", required = false, arity = 1)
        public Integer windowSize;
    
        @Parameter(names = {"--overwrite"}, description = "The body web service overwrite parameter", required = false, arity = 1)
        public Boolean overwrite;
    
    }

    @Parameters(commandNames = {"coverage-qc-genecoveragestats-run"}, commandDescription ="Compute gene coverage stats for a given alignment file and a list of genes")
    public class CoverageQcGeneCoverageStatsRunCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--json-file"}, description = "File with the body data in JSON format. Note, that using this parameter will ignore all the other parameters.", required = false, arity = 1)
        public String jsonFile;
    
        @Parameter(names = {"--json-data-model"}, description = "Show example of file structure for body data.", help = true, arity = 0)
        public Boolean jsonDataModel = false;
    
        @Parameter(names = {"--study", "-s"}, description = "study", required = false, arity = 1)
        public String study; 
    
        @Parameter(names = {"--job-id"}, description = "Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not provided.", required = false, arity = 1)
        public String jobId; 
    
        @Parameter(names = {"--job-depends-on"}, description = "Comma separated list of existing job IDs the job will depend on.", required = false, arity = 1)
        public String jobDependsOn; 
    
        @Parameter(names = {"--job-description"}, description = "Job description", required = false, arity = 1)
        public String jobDescription; 
    
        @Parameter(names = {"--job-tags"}, description = "Job tags", required = false, arity = 1)
        public String jobTags; 
    
        @Parameter(names = {"--bam-file"}, description = "The body web service bamFile parameter", required = false, arity = 1)
        public String bamFile;
    
        @Parameter(names = {"--genes"}, description = "The body web service genes parameter", required = false, arity = 1)
        public String genes;
    
        @Parameter(names = {"--outdir"}, description = "The body web service outdir parameter", required = false, arity = 1)
        public String outdir;
    
    }

    @Parameters(commandNames = {"coverage-query"}, commandDescription ="Query the coverage of an alignment file for regions or genes")
    public class QueryCoverageCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--file"}, description = "File ID", required = true, arity = 1)
        public String file; 
    
        @Parameter(names = {"--study", "-s"}, description = "Study [[user@]project:]study where study and project can be either the ID or UUID", required = false, arity = 1)
        public String study; 
    
        @Parameter(names = {"--region"}, description = "Comma separated list of regions 'chr:start-end, e.g.: 2,3:63500-65000", required = false, arity = 1)
        public String region; 
    
        @Parameter(names = {"--gene"}, description = "Comma separated list of genes, e.g.: BCRA2,TP53", required = false, arity = 1)
        public String gene; 
    
        @Parameter(names = {"--offset"}, description = "Offset to extend the region, gene or exon at up and downstream", required = false, arity = 1)
        public Integer offset; 
    
        @Parameter(names = {"--only-exons"}, description = "Only exons are taking into account when genes are specified", required = false, arity = 1)
        public Boolean onlyExons; 
    
        @Parameter(names = {"--range"}, description = "Range of coverage values to be reported. Minimum and maximum values are separated by '-', e.g.: 20-40 (for coverage values greater or equal to 20 and less or equal to 40). A single value means to report coverage values less or equal to that value", required = false, arity = 1)
        public String range; 
    
        @Parameter(names = {"--window-size"}, description = "Window size for the region coverage (if a coverage range is provided, window size must be 1)", required = false, arity = 1)
        public Integer windowSize; 
    
        @Parameter(names = {"--split-results"}, description = "Split results into regions (or gene/exon regions)", required = false, arity = 1)
        public Boolean splitResults; 
    
    }

    @Parameters(commandNames = {"coverage-ratio"}, commandDescription ="Compute coverage ratio from file #1 vs file #2, (e.g. somatic vs germline)")
    public class RatioCoverageCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--file1"}, description = "Input file #1 (e.g. somatic file)", required = true, arity = 1)
        public String file1; 
    
        @Parameter(names = {"--file2"}, description = "Input file #2 (e.g. germline file)", required = true, arity = 1)
        public String file2; 
    
        @Parameter(names = {"--study", "-s"}, description = "Study [[user@]project:]study where study and project can be either the ID or UUID", required = false, arity = 1)
        public String study; 
    
        @Parameter(names = {"--skip-log2"}, description = "Do not apply Log2 to normalise the coverage ratio", required = false, arity = 1)
        public Boolean skipLog2; 
    
        @Parameter(names = {"--region"}, description = "Comma separated list of regions 'chr:start-end, e.g.: 2,3:63500-65000", required = false, arity = 1)
        public String region; 
    
        @Parameter(names = {"--gene"}, description = "Comma separated list of genes, e.g.: BCRA2,TP53", required = false, arity = 1)
        public String gene; 
    
        @Parameter(names = {"--offset"}, description = "Offset to extend the region, gene or exon at up and downstream", required = false, arity = 1)
        public Integer offset; 
    
        @Parameter(names = {"--only-exons"}, description = "Only exons are taking into account when genes are specified", required = false, arity = 1)
        public Boolean onlyExons; 
    
        @Parameter(names = {"--window-size"}, description = "Window size for the region coverage (if a coverage range is provided, window size must be 1)", required = false, arity = 1)
        public Integer windowSize; 
    
        @Parameter(names = {"--split-results"}, description = "Split results into regions (or gene/exon regions)", required = false, arity = 1)
        public Boolean splitResults; 
    
    }

    @Parameters(commandNames = {"coverage-stats"}, commandDescription ="Compute coverage stats per transcript for a list of genes.")
    public class StatsCoverageCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--file"}, description = "File ID", required = true, arity = 1)
        public String file; 
    
        @Parameter(names = {"--gene"}, description = "Comma separated list of genes, e.g.: BCRA2,TP53", required = true, arity = 1)
        public String gene; 
    
        @Parameter(names = {"--study", "-s"}, description = "Study [[user@]project:]study where study and project can be either the ID or UUID", required = false, arity = 1)
        public String study; 
    
        @Parameter(names = {"--threshold"}, description = "Only regions whose coverage depth is under this threshold will be reported.", required = false, arity = 1)
        public Integer threshold; 
    
    }

    @Parameters(commandNames = {"deeptools-run"}, commandDescription ="Deeptools is a suite of python tools particularly developed for the efficient analysis of high-throughput sequencing data, such as ChIP-seq, RNA-seq or MNase-seq.")
    public class RunDeeptoolsCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--json-file"}, description = "File with the body data in JSON format. Note, that using this parameter will ignore all the other parameters.", required = false, arity = 1)
        public String jsonFile;
    
        @Parameter(names = {"--json-data-model"}, description = "Show example of file structure for body data.", help = true, arity = 0)
        public Boolean jsonDataModel = false;
    
        @Parameter(names = {"--study", "-s"}, description = "study", required = false, arity = 1)
        public String study; 
    
        @Parameter(names = {"--job-id"}, description = "Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not provided.", required = false, arity = 1)
        public String jobId; 
    
        @Parameter(names = {"--job-depends-on"}, description = "Comma separated list of existing job IDs the job will depend on.", required = false, arity = 1)
        public String jobDependsOn; 
    
        @Parameter(names = {"--job-description"}, description = "Job description", required = false, arity = 1)
        public String jobDescription; 
    
        @Parameter(names = {"--job-tags"}, description = "Job tags", required = false, arity = 1)
        public String jobTags; 
    
        @Parameter(names = {"--command"}, description = "The body web service command parameter", required = false, arity = 1)
        public String command;
    
        @Parameter(names = {"--outdir"}, description = "The body web service outdir parameter", required = false, arity = 1)
        public String outdir;
    
    }

    @Parameters(commandNames = {"fastqc-run"}, commandDescription ="A high throughput sequence QC analysis tool")
    public class RunFastqcCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--json-file"}, description = "File with the body data in JSON format. Note, that using this parameter will ignore all the other parameters.", required = false, arity = 1)
        public String jsonFile;
    
        @Parameter(names = {"--json-data-model"}, description = "Show example of file structure for body data.", help = true, arity = 0)
        public Boolean jsonDataModel = false;
    
        @Parameter(names = {"--study", "-s"}, description = "study", required = false, arity = 1)
        public String study; 
    
        @Parameter(names = {"--job-id"}, description = "Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not provided.", required = false, arity = 1)
        public String jobId; 
    
        @Parameter(names = {"--job-depends-on"}, description = "Comma separated list of existing job IDs the job will depend on.", required = false, arity = 1)
        public String jobDependsOn; 
    
        @Parameter(names = {"--job-description"}, description = "Job description", required = false, arity = 1)
        public String jobDescription; 
    
        @Parameter(names = {"--job-tags"}, description = "Job tags", required = false, arity = 1)
        public String jobTags; 
    
        @Parameter(names = {"--input-file"}, description = "The body web service inputFile parameter", required = false, arity = 1)
        public String inputFile;
    
        @Parameter(names = {"--outdir"}, description = "The body web service outdir parameter", required = false, arity = 1)
        public String outdir;
    
    }

    @Parameters(commandNames = {"index-run"}, commandDescription ="Index alignment file")
    public class RunIndexCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--json-file"}, description = "File with the body data in JSON format. Note, that using this parameter will ignore all the other parameters.", required = false, arity = 1)
        public String jsonFile;
    
        @Parameter(names = {"--json-data-model"}, description = "Show example of file structure for body data.", help = true, arity = 0)
        public Boolean jsonDataModel = false;
    
        @Parameter(names = {"--study", "-s"}, description = "study", required = false, arity = 1)
        public String study; 
    
        @Parameter(names = {"--job-id"}, description = "Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not provided.", required = false, arity = 1)
        public String jobId; 
    
        @Parameter(names = {"--job-depends-on"}, description = "Comma separated list of existing job IDs the job will depend on.", required = false, arity = 1)
        public String jobDependsOn; 
    
        @Parameter(names = {"--job-description"}, description = "Job description", required = false, arity = 1)
        public String jobDescription; 
    
        @Parameter(names = {"--job-tags"}, description = "Job tags", required = false, arity = 1)
        public String jobTags; 
    
        @Parameter(names = {"--file"}, description = "The body web service file parameter", required = false, arity = 1)
        public String file;
    
        @Parameter(names = {"--overwrite"}, description = "The body web service overwrite parameter", required = false, arity = 1)
        public Boolean overwrite;
    
    }

    @Parameters(commandNames = {"picard-run"}, commandDescription ="Picard is a set of command line tools (in Java) for manipulating high-throughput sequencing (HTS) data and formats such as SAM/BAM/CRAM and VCF. Supported Picard commands: CollectHsMetrics, CollectWgsMetrics, BedToIntervalList")
    public class RunPicardCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--json-file"}, description = "File with the body data in JSON format. Note, that using this parameter will ignore all the other parameters.", required = false, arity = 1)
        public String jsonFile;
    
        @Parameter(names = {"--json-data-model"}, description = "Show example of file structure for body data.", help = true, arity = 0)
        public Boolean jsonDataModel = false;
    
        @Parameter(names = {"--study", "-s"}, description = "study", required = false, arity = 1)
        public String study; 
    
        @Parameter(names = {"--job-id"}, description = "Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not provided.", required = false, arity = 1)
        public String jobId; 
    
        @Parameter(names = {"--job-depends-on"}, description = "Comma separated list of existing job IDs the job will depend on.", required = false, arity = 1)
        public String jobDependsOn; 
    
        @Parameter(names = {"--job-description"}, description = "Job description", required = false, arity = 1)
        public String jobDescription; 
    
        @Parameter(names = {"--job-tags"}, description = "Job tags", required = false, arity = 1)
        public String jobTags; 
    
        @Parameter(names = {"--command"}, description = "The body web service command parameter", required = false, arity = 1)
        public String command;
    
        @Parameter(names = {"--outdir"}, description = "The body web service outdir parameter", required = false, arity = 1)
        public String outdir;
    
    }

    @Parameters(commandNames = {"qc-run"}, commandDescription ="Compute quality control (QC) metrics for a given alignment file (including samtools stats, samtools flag stats, FastQC and HS metrics)")
    public class RunQcCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--json-file"}, description = "File with the body data in JSON format. Note, that using this parameter will ignore all the other parameters.", required = false, arity = 1)
        public String jsonFile;
    
        @Parameter(names = {"--json-data-model"}, description = "Show example of file structure for body data.", help = true, arity = 0)
        public Boolean jsonDataModel = false;
    
        @Parameter(names = {"--study", "-s"}, description = "study", required = false, arity = 1)
        public String study; 
    
        @Parameter(names = {"--job-id"}, description = "Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not provided.", required = false, arity = 1)
        public String jobId; 
    
        @Parameter(names = {"--job-depends-on"}, description = "Comma separated list of existing job IDs the job will depend on.", required = false, arity = 1)
        public String jobDependsOn; 
    
        @Parameter(names = {"--job-description"}, description = "Job description", required = false, arity = 1)
        public String jobDescription; 
    
        @Parameter(names = {"--job-tags"}, description = "Job tags", required = false, arity = 1)
        public String jobTags; 
    
        @Parameter(names = {"--bam-file"}, description = "The body web service bamFile parameter", required = false, arity = 1)
        public String bamFile;
    
        @Parameter(names = {"--bed-file"}, description = "The body web service bedFile parameter", required = false, arity = 1)
        public String bedFile;
    
        @Parameter(names = {"--dict-file"}, description = "The body web service dictFile parameter", required = false, arity = 1)
        public String dictFile;
    
        @Parameter(names = {"--skip"}, description = "The body web service skip parameter", required = false, arity = 1)
        public String skip;
    
        @Parameter(names = {"--overwrite"}, description = "The body web service overwrite parameter", required = false, arity = 1)
        public Boolean overwrite;
    
        @Parameter(names = {"--outdir"}, description = "The body web service outdir parameter", required = false, arity = 1)
        public String outdir;
    
    }

    @Parameters(commandNames = {"query"}, commandDescription ="Search over indexed alignments")
    public class QueryCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--limit"}, description = "Number of results to be returned", required = false, arity = 1)
        public Integer limit; 
    
        @Parameter(names = {"--skip"}, description = "Number of results to skip", required = false, arity = 1)
        public Integer skip; 
    
        @Parameter(names = {"--count"}, description = "Get the total number of results matching the query. Deactivated by default.", required = false, arity = 1)
        public Boolean count = false; 
    
        @Parameter(names = {"--file"}, description = "File ID", required = true, arity = 1)
        public String file; 
    
        @Parameter(names = {"--study", "-s"}, description = "Study [[user@]project:]study where study and project can be either the ID or UUID", required = false, arity = 1)
        public String study; 
    
        @Parameter(names = {"--region"}, description = "Comma separated list of regions 'chr:start-end, e.g.: 2,3:63500-65000", required = false, arity = 1)
        public String region; 
    
        @Parameter(names = {"--gene"}, description = "Comma separated list of genes, e.g.: BCRA2,TP53", required = false, arity = 1)
        public String gene; 
    
        @Parameter(names = {"--offset"}, description = "Offset to extend the region, gene or exon at up and downstream", required = false, arity = 1)
        public Integer offset; 
    
        @Parameter(names = {"--only-exons"}, description = "Only exons are taking into account when genes are specified", required = false, arity = 1)
        public Boolean onlyExons; 
    
        @Parameter(names = {"--min-mapping-quality"}, description = "Minimum mapping quality", required = false, arity = 1)
        public Integer minMappingQuality; 
    
        @Parameter(names = {"--max-num-mismatches"}, description = "Maximum number of mismatches", required = false, arity = 1)
        public Integer maxNumMismatches; 
    
        @Parameter(names = {"--max-num-hits"}, description = "Maximum number of hits", required = false, arity = 1)
        public Integer maxNumHits; 
    
        @Parameter(names = {"--properly-paired"}, description = "Return only properly paired alignments", required = false, arity = 1)
        public Boolean properlyPaired; 
    
        @Parameter(names = {"--max-insert-size"}, description = "Maximum insert size", required = false, arity = 1)
        public Integer maxInsertSize; 
    
        @Parameter(names = {"--skip-unmapped"}, description = "Skip unmapped alignments", required = false, arity = 1)
        public Boolean skipUnmapped; 
    
        @Parameter(names = {"--skip-duplicated"}, description = "Skip duplicated alignments", required = false, arity = 1)
        public Boolean skipDuplicated; 
    
        @Parameter(names = {"--region-contained"}, description = "Return alignments contained within boundaries of region", required = false, arity = 1)
        public Boolean regionContained; 
    
        @Parameter(names = {"--force-md-field"}, description = "Force SAM MD optional field to be set with the alignments", required = false, arity = 1)
        public Boolean forceMDField; 
    
        @Parameter(names = {"--bin-qualities"}, description = "Compress the nucleotide qualities by using 8 quality levels", required = false, arity = 1)
        public Boolean binQualities; 
    
        @Parameter(names = {"--split-results"}, description = "Split results into regions (or gene/exon regions)", required = false, arity = 1)
        public Boolean splitResults; 
    
    }

    @Parameters(commandNames = {"samtools-run"}, commandDescription ="Samtools is a program for interacting with high-throughput sequencing data in SAM, BAM and CRAM formats. Supported Samtools commands: sort, index, view, stats, flagstat, dict, faidx, depth, plot-bamstats")
    public class RunSamtoolsCommandOptions {
    
        @ParametersDelegate
        public CommonCommandOptions commonOptions = commonCommandOptions;
    
        @Parameter(names = {"--json-file"}, description = "File with the body data in JSON format. Note, that using this parameter will ignore all the other parameters.", required = false, arity = 1)
        public String jsonFile;
    
        @Parameter(names = {"--json-data-model"}, description = "Show example of file structure for body data.", help = true, arity = 0)
        public Boolean jsonDataModel = false;
    
        @Parameter(names = {"--study", "-s"}, description = "study", required = false, arity = 1)
        public String study; 
    
        @Parameter(names = {"--job-id"}, description = "Job ID. It must be a unique string within the study. An ID will be autogenerated automatically if not provided.", required = false, arity = 1)
        public String jobId; 
    
        @Parameter(names = {"--job-depends-on"}, description = "Comma separated list of existing job IDs the job will depend on.", required = false, arity = 1)
        public String jobDependsOn; 
    
        @Parameter(names = {"--job-description"}, description = "Job description", required = false, arity = 1)
        public String jobDescription; 
    
        @Parameter(names = {"--job-tags"}, description = "Job tags", required = false, arity = 1)
        public String jobTags; 
    
        @Parameter(names = {"--command"}, description = "The body web service command parameter", required = false, arity = 1)
        public String command;
    
        @Parameter(names = {"--input-file"}, description = "The body web service inputFile parameter", required = false, arity = 1)
        public String inputFile;
    
        @Parameter(names = {"--outdir"}, description = "The body web service outdir parameter", required = false, arity = 1)
        public String outdir;
    
    }

}