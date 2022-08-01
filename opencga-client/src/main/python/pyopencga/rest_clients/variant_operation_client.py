"""
WARNING: AUTOGENERATED CODE

    This code was generated by a tool.
    Autogenerated on: 2022-08-01 16:35:36
    
    Manual changes to this file may cause unexpected behavior in your application.
    Manual changes to this file will be overwritten if the code is regenerated.
"""

from pyopencga.rest_clients._parent_rest_clients import _ParentRestClient


class VariantOperation(_ParentRestClient):
    """
    This class contains methods for the 'Operations - Variant Storage' webservices
    Client version: 2.4.2-SNAPSHOT [1107fd8d544e2788500aa3075ff4476e798d1251]
    PATH: /{apiVersion}/operation
    """

    def __init__(self, configuration, token=None, login_handler=None, *args, **kwargs):
        super(VariantOperation, self).__init__(configuration, token, login_handler, *args, **kwargs)

    def configure_cellbase(self, data=None, **options):
        """
        Update Cellbase configuration.
        PATH: /{apiVersion}/operation/cellbase/configure

        :param str project: Project [user@]project where project can be either
            the ID or the alias.
        :param bool annotation_update: Create and load variant annotations
            into the database.
        :param str annotation_save_id: Save a copy of the current variant
            annotation at the database.
        :param dict data: New cellbase configuration.
        """

        return self._post(category='operation', resource='configure', subcategory='cellbase', data=data, **options)

    def aggregate_variant(self, data=None, **options):
        """
        Find variants where not all the samples are present, and fill the
            empty values, excluding HOM-REF (0/0) values.
        PATH: /{apiVersion}/operation/variant/aggregate

        :param str job_id: Job ID. It must be a unique string within the
            study. An ID will be autogenerated automatically if not provided.
        :param str job_description: Job description.
        :param str job_depends_on: Comma separated list of existing job IDs
            the job will depend on.
        :param str job_tags: Job tags.
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param dict data: Variant aggregate params.
        """

        return self._post(category='operation', resource='aggregate', subcategory='variant', data=data, **options)

    def delete_variant_annotation(self, **options):
        """
        Deletes a saved copy of variant annotation.
        PATH: /{apiVersion}/operation/variant/annotation/delete

        :param str job_id: Job ID. It must be a unique string within the
            study. An ID will be autogenerated automatically if not provided.
        :param str job_description: Job description.
        :param str job_depends_on: Comma separated list of existing job IDs
            the job will depend on.
        :param str job_tags: Job tags.
        :param str project: Project [user@]project where project can be either
            the ID or the alias.
        :param str annotation_id: Annotation identifier.
        """

        return self._delete(category='operation', resource='delete', subcategory='variant/annotation', **options)

    def index_variant_annotation(self, data=None, **options):
        """
        Create and load variant annotations into the database.
        PATH: /{apiVersion}/operation/variant/annotation/index

        :param str job_id: Job ID. It must be a unique string within the
            study. An ID will be autogenerated automatically if not provided.
        :param str job_description: Job description.
        :param str job_depends_on: Comma separated list of existing job IDs
            the job will depend on.
        :param str job_tags: Job tags.
        :param str project: Project [user@]project where project can be either
            the ID or the alias.
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param dict data: Variant annotation index params.
        """

        return self._post(category='operation', resource='index', subcategory='variant/annotation', data=data, **options)

    def save_variant_annotation(self, data=None, **options):
        """
        Save a copy of the current variant annotation at the database.
        PATH: /{apiVersion}/operation/variant/annotation/save

        :param str job_id: Job ID. It must be a unique string within the
            study. An ID will be autogenerated automatically if not provided.
        :param str job_description: Job description.
        :param str job_depends_on: Comma separated list of existing job IDs
            the job will depend on.
        :param str job_tags: Job tags.
        :param str project: Project [user@]project where project can be either
            the ID or the alias.
        :param dict data: Variant annotation save params.
        """

        return self._post(category='operation', resource='save', subcategory='variant/annotation', data=data, **options)

    def configure_variant(self, data=None, **options):
        """
        Update Variant Storage Engine configuration. Can be updated at Project
            or Study level.
        PATH: /{apiVersion}/operation/variant/configure

        :param str project: Project [user@]project where project can be either
            the ID or the alias.
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param dict data: Configuration params to update.
        """

        return self._post(category='operation', resource='configure', subcategory='variant', data=data, **options)

    def delete_variant(self, data=None, **options):
        """
        Remove variant files from the variant storage.
        PATH: /{apiVersion}/operation/variant/delete

        :param str job_id: Job ID. It must be a unique string within the
            study. An ID will be autogenerated automatically if not provided.
        :param str job_description: Job description.
        :param str job_depends_on: Comma separated list of existing job IDs
            the job will depend on.
        :param str job_tags: Job tags.
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param dict data: Variant delete file params.
        """

        return self._post(category='operation', resource='delete', subcategory='variant', data=data, **options)

    def aggregate_variant_family(self, data=None, **options):
        """
        Find variants where not all the samples are present, and fill the
            empty values.
        PATH: /{apiVersion}/operation/variant/family/aggregate

        :param str job_id: Job ID. It must be a unique string within the
            study. An ID will be autogenerated automatically if not provided.
        :param str job_description: Job description.
        :param str job_depends_on: Comma separated list of existing job IDs
            the job will depend on.
        :param str job_tags: Job tags.
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param dict data: Variant aggregate family params.
        """

        return self._post(category='operation', resource='aggregate', subcategory='variant/family', data=data, **options)

    def index_variant_family(self, data=None, **options):
        """
        DEPRECATED: integrated in index (DEPRECATED Build the family index).
        PATH: /{apiVersion}/operation/variant/family/index

        :param str job_id: Job ID. It must be a unique string within the
            study. An ID will be autogenerated automatically if not provided.
        :param str job_description: Job description.
        :param str job_depends_on: Comma separated list of existing job IDs
            the job will depend on.
        :param str job_tags: Job tags.
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param dict data: Variant family index params.
        """

        return self._post(category='operation', resource='index', subcategory='variant/family', data=data, **options)

    def index_variant(self, data=None, **options):
        """
        Index variant files into the variant storage.
        PATH: /{apiVersion}/operation/variant/index

        :param str job_id: Job ID. It must be a unique string within the
            study. An ID will be autogenerated automatically if not provided.
        :param str job_description: Job description.
        :param str job_depends_on: Comma separated list of existing job IDs
            the job will depend on.
        :param str job_tags: Job tags.
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param dict data: Variant index params.
        """

        return self._post(category='operation', resource='index', subcategory='variant', data=data, **options)

    def launcher_variant_index(self, data=None, **options):
        """
        Detect non-indexed VCF files in the study, and submit a job for
            indexing them.
        PATH: /{apiVersion}/operation/variant/index/launcher

        :param str job_id: Job ID. It must be a unique string within the
            study. An ID will be autogenerated automatically if not provided.
        :param str job_description: Job description.
        :param str job_depends_on: Comma separated list of existing job IDs
            the job will depend on.
        :param str job_tags: Job tags.
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param dict data: .
        """

        return self._post(category='operation', resource='launcher', subcategory='variant/index', data=data, **options)

    def run_variant_julie(self, data=None, **options):
        """
        Transform VariantStats into PopulationFrequency values and updates the
            VariantAnnotation.
        PATH: /{apiVersion}/operation/variant/julie/run

        :param dict data: Julie tool params. Specify list of cohorts from
            multiple studies with {study}:{cohort}. (REQUIRED)
        :param str job_id: Job ID. It must be a unique string within the
            study. An ID will be autogenerated automatically if not provided.
        :param str job_description: Job description.
        :param str job_depends_on: Comma separated list of existing job IDs
            the job will depend on.
        :param str job_tags: Job tags.
        :param str project: project.
        """

        return self._post(category='operation', resource='run', subcategory='variant/julie', data=data, **options)

    def repair_variant_metadata(self, data=None, **options):
        """
        Execute some repairs on Variant Storage Metadata. Advanced users only.
        PATH: /{apiVersion}/operation/variant/metadata/repair

        :param str job_id: Job ID. It must be a unique string within the
            study. An ID will be autogenerated automatically if not provided.
        :param str job_description: Job description.
        :param str job_depends_on: Comma separated list of existing job IDs
            the job will depend on.
        :param str job_tags: Job tags.
        :param dict data: Variant storage metadata repair params.
        """

        return self._post(category='operation', resource='repair', subcategory='variant/metadata', data=data, **options)

    def synchronize_variant_metadata(self, data=None, **options):
        """
        Synchronize catalog with variant storage metadata.
        PATH: /{apiVersion}/operation/variant/metadata/synchronize

        :param str job_id: Job ID. It must be a unique string within the
            study. An ID will be autogenerated automatically if not provided.
        :param str job_description: Job description.
        :param str job_depends_on: Comma separated list of existing job IDs
            the job will depend on.
        :param str job_tags: Job tags.
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param dict data: Variant storage metadata synchronize params.
        """

        return self._post(category='operation', resource='synchronize', subcategory='variant/metadata', data=data, **options)

    def prune_variant(self, data=None, **options):
        """
        Prune orphan variants from studies in a project.
        PATH: /{apiVersion}/operation/variant/prune

        :param str job_id: Job ID. It must be a unique string within the
            study. An ID will be autogenerated automatically if not provided.
        :param str job_description: Job description.
        :param str job_depends_on: Comma separated list of existing job IDs
            the job will depend on.
        :param str job_tags: Job tags.
        :param dict data: Variant prune params. Use dry-run to just generate a
            report with the orphan variants.
        """

        return self._post(category='operation', resource='prune', subcategory='variant', data=data, **options)

    def delete_variant_sample(self, data=None, **options):
        """
        Remove variant samples from the variant storage.
        PATH: /{apiVersion}/operation/variant/sample/delete

        :param str job_id: Job ID. It must be a unique string within the
            study. An ID will be autogenerated automatically if not provided.
        :param str job_description: Job description.
        :param str job_depends_on: Comma separated list of existing job IDs
            the job will depend on.
        :param str job_tags: Job tags.
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param dict data: Variant delete sample params.
        """

        return self._post(category='operation', resource='delete', subcategory='variant/sample', data=data, **options)

    def index_variant_sample(self, data=None, **options):
        """
        DEPRECATED You should use the new sample index method instead.
        PATH: /{apiVersion}/operation/variant/sample/index

        :param str job_id: Job ID. It must be a unique string within the
            study. An ID will be autogenerated automatically if not provided.
        :param str job_description: Job description.
        :param str job_depends_on: Comma separated list of existing job IDs
            the job will depend on.
        :param str job_tags: Job tags.
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param dict data: Variant sample index params.
        """

        return self._post(category='operation', resource='index', subcategory='variant/sample', data=data, **options)

    def variant_sample_index_configure(self, data=None, **options):
        """
        DEPRECATED You should use the new sample index configure method.
        PATH: /{apiVersion}/operation/variant/sample/index/configure

        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param bool skip_rebuild: Skip sample index re-build.
        :param dict data: New SampleIndexConfiguration.
        """

        return self._post(category='operation', resource='configure', subcategory='variant/sample/index', data=data, **options)

    def delete_variant_score(self, **options):
        """
        Remove a variant score in the database.
        PATH: /{apiVersion}/operation/variant/score/delete

        :param str job_id: Job ID. It must be a unique string within the
            study. An ID will be autogenerated automatically if not provided.
        :param str job_description: Job description.
        :param str job_depends_on: Comma separated list of existing job IDs
            the job will depend on.
        :param str job_tags: Job tags.
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param str name: Unique name of the score within the study.
        :param bool resume: Resume a previously failed remove.
        :param bool force: Force remove of partially indexed scores.
        """

        return self._delete(category='operation', resource='delete', subcategory='variant/score', **options)

    def index_variant_score(self, data=None, **options):
        """
        Index a variant score in the database.
        PATH: /{apiVersion}/operation/variant/score/index

        :param str job_id: Job ID. It must be a unique string within the
            study. An ID will be autogenerated automatically if not provided.
        :param str job_description: Job description.
        :param str job_depends_on: Comma separated list of existing job IDs
            the job will depend on.
        :param str job_tags: Job tags.
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param dict data: Variant score index params. scoreName: Unique name
            of the score within the study. cohort1: Cohort used to compute the
            score. Use the cohort 'ALL' if all samples from the study where
            used to compute the score. cohort2: Second cohort used to compute
            the score, typically to compare against the first cohort. If only
            one cohort was used to compute the score, leave empty.
            inputColumns: Indicate which columns to load from the input file.
            Provide the column position (starting in 0) for the column with the
            score with 'SCORE=n'. Optionally, the PValue column with
            'PVALUE=n'. The, to indicate the variant associated with the score,
            provide either the columns ['CHROM', 'POS', 'REF', 'ALT'], or the
            column 'VAR' containing a variant representation with format
            'chr:start:ref:alt'. e.g.
            'CHROM=0,POS=1,REF=3,ALT=4,SCORE=5,PVALUE=6' or
            'VAR=0,SCORE=1,PVALUE=2'. resume: Resume a previously failed
            indexation.
        """

        return self._post(category='operation', resource='index', subcategory='variant/score', data=data, **options)

    def variant_secondary_annotation_index(self, data=None, **options):
        """
        Creates a secondary index using a search engine. If samples are
            provided, sample data will be added to the secondary index. (New!).
        PATH: /{apiVersion}/operation/variant/secondary/annotation/index

        :param str job_id: Job ID. It must be a unique string within the
            study. An ID will be autogenerated automatically if not provided.
        :param str job_description: Job description.
        :param str job_depends_on: Comma separated list of existing job IDs
            the job will depend on.
        :param str job_tags: Job tags.
        :param str project: Project [user@]project where project can be either
            the ID or the alias.
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param dict data: Variant secondary index params.
        """

        return self._post(category='operation', resource='index', subcategory='variant/secondary/annotation', data=data, **options)

    def variant_secondary_sample_index(self, data=None, **options):
        """
        Build and annotate the sample index. (New!) .
        PATH: /{apiVersion}/operation/variant/secondary/sample/index

        :param str job_id: Job ID. It must be a unique string within the
            study. An ID will be autogenerated automatically if not provided.
        :param str job_description: Job description.
        :param str job_depends_on: Comma separated list of existing job IDs
            the job will depend on.
        :param str job_tags: Job tags.
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param dict data: Variant sample index params.
        """

        return self._post(category='operation', resource='index', subcategory='variant/secondary/sample', data=data, **options)

    def configure_variant_secondary_sample_index(self, data=None, **options):
        """
        Update SampleIndex configuration (New!).
        PATH: /{apiVersion}/operation/variant/secondary/sample/index/configure

        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param bool skip_rebuild: Skip sample index re-build.
        :param dict data: New SampleIndexConfiguration.
        """

        return self._post(category='operation', resource='configure', subcategory='variant/secondary/sample/index', data=data, **options)

    def secondary_index_variant(self, data=None, **options):
        """
        DEPRECATED you should use the new annotation index method instead.
        PATH: /{apiVersion}/operation/variant/secondaryIndex

        :param str job_id: Job ID. It must be a unique string within the
            study. An ID will be autogenerated automatically if not provided.
        :param str job_description: Job description.
        :param str job_depends_on: Comma separated list of existing job IDs
            the job will depend on.
        :param str job_tags: Job tags.
        :param str project: Project [user@]project where project can be either
            the ID or the alias.
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param dict data: Variant secondary index params.
        """

        return self._post(category='operation', resource='secondaryIndex', subcategory='variant', data=data, **options)

    def delete_variant_secondary_index(self, **options):
        """
        Remove a secondary index from the search engine for a specific set of
            samples.
        PATH: /{apiVersion}/operation/variant/secondaryIndex/delete

        :param str job_id: Job ID. It must be a unique string within the
            study. An ID will be autogenerated automatically if not provided.
        :param str job_description: Job description.
        :param str job_depends_on: Comma separated list of existing job IDs
            the job will depend on.
        :param str job_tags: Job tags.
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param str samples: Samples to remove. Needs to provide all the
            samples in the secondary index.
        """

        return self._delete(category='operation', resource='delete', subcategory='variant/secondaryIndex', **options)

    def delete_variant_stats(self, data=None, **options):
        """
        Deletes the VariantStats of a cohort/s from the database.
        PATH: /{apiVersion}/operation/variant/stats/delete

        :param dict data: Variant stats delete params. (REQUIRED)
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param str job_id: Job ID. It must be a unique string within the
            study. An ID will be autogenerated automatically if not provided.
        :param str job_description: Job description.
        :param str job_depends_on: Comma separated list of existing job IDs
            the job will depend on.
        :param str job_tags: Job tags.
        """

        return self._post(category='operation', resource='delete', subcategory='variant/stats', data=data, **options)

    def index_variant_stats(self, data=None, **options):
        """
        Compute variant stats for any cohort and any set of variants and index
            the result in the variant storage database.
        PATH: /{apiVersion}/operation/variant/stats/index

        :param dict data: Variant stats params. (REQUIRED)
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param str job_id: Job ID. It must be a unique string within the
            study. An ID will be autogenerated automatically if not provided.
        :param str job_description: Job description.
        :param str job_depends_on: Comma separated list of existing job IDs
            the job will depend on.
        :param str job_tags: Job tags.
        """

        return self._post(category='operation', resource='index', subcategory='variant/stats', data=data, **options)

    def delete_variant_study(self, data=None, **options):
        """
        Remove whole study from the variant storage.
        PATH: /{apiVersion}/operation/variant/study/delete

        :param str job_id: Job ID. It must be a unique string within the
            study. An ID will be autogenerated automatically if not provided.
        :param str job_description: Job description.
        :param str job_depends_on: Comma separated list of existing job IDs
            the job will depend on.
        :param str job_tags: Job tags.
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param dict data: Variant delete study params.
        """

        return self._post(category='operation', resource='delete', subcategory='variant/study', data=data, **options)

