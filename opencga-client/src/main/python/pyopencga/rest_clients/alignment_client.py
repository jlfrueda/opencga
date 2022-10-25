"""
WARNING: AUTOGENERATED CODE

    This code was generated by a tool.
    Autogenerated on: 2022-09-29 11:52:54
    
    Manual changes to this file may cause unexpected behavior in your application.
    Manual changes to this file will be overwritten if the code is regenerated.
"""

from pyopencga.rest_clients._parent_rest_clients import _ParentRestClient


class Alignment(_ParentRestClient):
    """
    This class contains methods for the 'Analysis - Alignment' webservices
    Client version: 2.4.6-SNAPSHOT [9398b71434a77b1fefbbef5ccac42d25eb6f2070]
    PATH: /{apiVersion}/analysis/alignment
    """

    def __init__(self, configuration, token=None, login_handler=None, *args, **kwargs):
        super(Alignment, self).__init__(configuration, token, login_handler, *args, **kwargs)

    def run_bwa(self, data=None, **options):
        """
        BWA is a software package for mapping low-divergent sequences against
            a large reference genome.
        PATH: /{apiVersion}/analysis/alignment/bwa/run

        :param dict data: BWA parameters. (REQUIRED)
        :param str study: study.
        :param str job_id: Job ID. It must be a unique string within the
            study. An ID will be autogenerated automatically if not provided.
        :param str job_depends_on: Comma separated list of existing job IDs
            the job will depend on.
        :param str job_description: Job description.
        :param str job_tags: Job tags.
        """

        return self._post(category='analysis', resource='run', subcategory='alignment/bwa', data=data, **options)

    def run_coverage_index(self, data=None, **options):
        """
        Compute coverage for a list of alignment files.
        PATH: /{apiVersion}/analysis/alignment/coverage/index/run

        :param dict data: Coverage computation parameters. (REQUIRED)
        :param str study: study.
        :param str job_id: Job ID. It must be a unique string within the
            study. An ID will be autogenerated automatically if not provided.
        :param str job_depends_on: Comma separated list of existing job IDs
            the job will depend on.
        :param str job_description: Job description.
        :param str job_tags: Job tags.
        """

        return self._post(category='analysis', resource='run', subcategory='alignment/coverage/index', data=data, **options)

    def coverage_qc_gene_coverage_stats_run(self, data=None, **options):
        """
        Compute gene coverage stats for a given alignment file and a list of
            genes.
        PATH: /{apiVersion}/analysis/alignment/coverage/qc/geneCoverageStats/run

        :param dict data: Gene coverage stats parameters for a given BAM file
            and a list of genes. (REQUIRED)
        :param str study: study.
        :param str job_id: Job ID. It must be a unique string within the
            study. An ID will be autogenerated automatically if not provided.
        :param str job_depends_on: Comma separated list of existing job IDs
            the job will depend on.
        :param str job_description: Job description.
        :param str job_tags: Job tags.
        """

        return self._post(category='analysis', resource='run', subcategory='alignment/coverage/qc/geneCoverageStats', data=data, **options)

    def query_coverage(self, file, **options):
        """
        Query the coverage of an alignment file for regions or genes.
        PATH: /{apiVersion}/analysis/alignment/coverage/query

        :param str file: File ID. (REQUIRED)
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param str region: Comma separated list of regions 'chr:start-end,
            e.g.: 2,3:63500-65000.
        :param str gene: Comma separated list of genes, e.g.: BCRA2,TP53.
        :param int offset: Offset to extend the region, gene or exon at up and
            downstream.
        :param bool only_exons: Only exons are taking into account when genes
            are specified.
        :param str range: Range of coverage values to be reported. Minimum and
            maximum values are separated by '-', e.g.: 20-40 (for coverage
            values greater or equal to 20 and less or equal to 40). A single
            value means to report coverage values less or equal to that value.
        :param int window_size: Window size for the region coverage (if a
            coverage range is provided, window size must be 1).
        :param bool split_results: Split results into regions (or gene/exon
            regions).
        """

        options['file'] = file
        return self._get(category='analysis', resource='query', subcategory='alignment/coverage', **options)

    def ratio_coverage(self, file1, file2, **options):
        """
        Compute coverage ratio from file #1 vs file #2, (e.g. somatic vs
            germline).
        PATH: /{apiVersion}/analysis/alignment/coverage/ratio

        :param str file2: Input file #2 (e.g. germline file). (REQUIRED)
        :param str file1: Input file #1 (e.g. somatic file). (REQUIRED)
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param bool skip_log2: Do not apply Log2 to normalise the coverage
            ratio.
        :param str region: Comma separated list of regions 'chr:start-end,
            e.g.: 2,3:63500-65000.
        :param str gene: Comma separated list of genes, e.g.: BCRA2,TP53.
        :param int offset: Offset to extend the region, gene or exon at up and
            downstream.
        :param bool only_exons: Only exons are taking into account when genes
            are specified.
        :param int window_size: Window size for the region coverage (if a
            coverage range is provided, window size must be 1).
        :param bool split_results: Split results into regions (or gene/exon
            regions).
        """

        options['file1'] = file1
        options['file2'] = file2
        return self._get(category='analysis', resource='ratio', subcategory='alignment/coverage', **options)

    def stats_coverage(self, file, gene, **options):
        """
        Compute coverage stats per transcript for a list of genes.
        PATH: /{apiVersion}/analysis/alignment/coverage/stats

        :param str gene: Comma separated list of genes, e.g.: BCRA2,TP53.
            (REQUIRED)
        :param str file: File ID. (REQUIRED)
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param int threshold: Only regions whose coverage depth is under this
            threshold will be reported.
        """

        options['file'] = file
        options['gene'] = gene
        return self._get(category='analysis', resource='stats', subcategory='alignment/coverage', **options)

    def run_deeptools(self, data=None, **options):
        """
        Deeptools is a suite of python tools particularly developed for the
            efficient analysis of high-throughput sequencing data, such as
            ChIP-seq, RNA-seq or MNase-seq.
        PATH: /{apiVersion}/analysis/alignment/deeptools/run

        :param dict data: Deeptools parameters. Supported Deeptools commands:
            bamCoverage, bamCompare. (REQUIRED)
        :param str study: study.
        :param str job_id: Job ID. It must be a unique string within the
            study. An ID will be autogenerated automatically if not provided.
        :param str job_depends_on: Comma separated list of existing job IDs
            the job will depend on.
        :param str job_description: Job description.
        :param str job_tags: Job tags.
        """

        return self._post(category='analysis', resource='run', subcategory='alignment/deeptools', data=data, **options)

    def run_fastqc(self, data=None, **options):
        """
        A high throughput sequence QC analysis tool.
        PATH: /{apiVersion}/analysis/alignment/fastqc/run

        :param dict data: FastQC parameters. (REQUIRED)
        :param str study: study.
        :param str job_id: Job ID. It must be a unique string within the
            study. An ID will be autogenerated automatically if not provided.
        :param str job_depends_on: Comma separated list of existing job IDs
            the job will depend on.
        :param str job_description: Job description.
        :param str job_tags: Job tags.
        """

        return self._post(category='analysis', resource='run', subcategory='alignment/fastqc', data=data, **options)

    def run_index(self, data=None, **options):
        """
        Index alignment file.
        PATH: /{apiVersion}/analysis/alignment/index/run

        :param dict data: Alignment index params. (REQUIRED)
        :param str study: study.
        :param str job_id: Job ID. It must be a unique string within the
            study. An ID will be autogenerated automatically if not provided.
        :param str job_depends_on: Comma separated list of existing job IDs
            the job will depend on.
        :param str job_description: Job description.
        :param str job_tags: Job tags.
        """

        return self._post(category='analysis', resource='run', subcategory='alignment/index', data=data, **options)

    def run_picard(self, data=None, **options):
        """
        Picard is a set of command line tools (in Java) for manipulating
            high-throughput sequencing (HTS) data and formats such as
            SAM/BAM/CRAM and VCF. Supported Picard commands: CollectHsMetrics,
            CollectWgsMetrics, BedToIntervalList.
        PATH: /{apiVersion}/analysis/alignment/picard/run

        :param dict data: Picard parameters. Supported Picard commands:
            CollectHsMetrics, CollectWgsMetrics, BedToIntervalList. (REQUIRED)
        :param str study: study.
        :param str job_id: Job ID. It must be a unique string within the
            study. An ID will be autogenerated automatically if not provided.
        :param str job_depends_on: Comma separated list of existing job IDs
            the job will depend on.
        :param str job_description: Job description.
        :param str job_tags: Job tags.
        """

        return self._post(category='analysis', resource='run', subcategory='alignment/picard', data=data, **options)

    def run_qc(self, data=None, **options):
        """
        Compute quality control (QC) metrics for a given alignment file
            (including samtools stats, samtools flag stats, FastQC and HS
            metrics).
        PATH: /{apiVersion}/analysis/alignment/qc/run

        :param dict data: Alignment quality control (QC) parameters. It
            computes: stats, flag stats, fastqc and hybrid-selection metrics.
            The BAM file is mandatory ever but the BED fileand the dictionary
            files are only mandatory for computing hybrid-selection (HS)
            metrics. In order to skip some metrics, use the following keywords
            (separated by commas): stats, flagstats, fastqc and hsmetrics.
            (REQUIRED)
        :param str study: study.
        :param str job_id: Job ID. It must be a unique string within the
            study. An ID will be autogenerated automatically if not provided.
        :param str job_depends_on: Comma separated list of existing job IDs
            the job will depend on.
        :param str job_description: Job description.
        :param str job_tags: Job tags.
        """

        return self._post(category='analysis', resource='run', subcategory='alignment/qc', data=data, **options)

    def query(self, file, **options):
        """
        Search over indexed alignments.
        PATH: /{apiVersion}/analysis/alignment/query

        :param str file: File ID. (REQUIRED)
        :param int limit: Number of results to be returned.
        :param int skip: Number of results to skip.
        :param bool count: Get the total number of results matching the query.
            Deactivated by default.
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param str region: Comma separated list of regions 'chr:start-end,
            e.g.: 2,3:63500-65000.
        :param str gene: Comma separated list of genes, e.g.: BCRA2,TP53.
        :param int offset: Offset to extend the region, gene or exon at up and
            downstream.
        :param bool only_exons: Only exons are taking into account when genes
            are specified.
        :param int min_mapping_quality: Minimum mapping quality.
        :param int max_num_mismatches: Maximum number of mismatches.
        :param int max_num_hits: Maximum number of hits.
        :param bool properly_paired: Return only properly paired alignments.
        :param int max_insert_size: Maximum insert size.
        :param bool skip_unmapped: Skip unmapped alignments.
        :param bool skip_duplicated: Skip duplicated alignments.
        :param bool region_contained: Return alignments contained within
            boundaries of region.
        :param bool force_m_d_field: Force SAM MD optional field to be set
            with the alignments.
        :param bool bin_qualities: Compress the nucleotide qualities by using
            8 quality levels.
        :param bool split_results: Split results into regions (or gene/exon
            regions).
        """

        options['file'] = file
        return self._get(category='analysis', resource='query', subcategory='alignment', **options)

    def run_samtools(self, data=None, **options):
        """
        Samtools is a program for interacting with high-throughput sequencing
            data in SAM, BAM and CRAM formats. Supported Samtools commands:
            sort, index, view, stats, flagstat, dict, faidx, depth,
            plot-bamstats.
        PATH: /{apiVersion}/analysis/alignment/samtools/run

        :param dict data: Samtools parameters. Supported Samtools commands:
            sort, index, view, stats, flagstat, dict, faidx, depth,
            plot-bamstats. (REQUIRED)
        :param str study: study.
        :param str job_id: Job ID. It must be a unique string within the
            study. An ID will be autogenerated automatically if not provided.
        :param str job_depends_on: Comma separated list of existing job IDs
            the job will depend on.
        :param str job_description: Job description.
        :param str job_tags: Job tags.
        """

        return self._post(category='analysis', resource='run', subcategory='alignment/samtools', data=data, **options)

