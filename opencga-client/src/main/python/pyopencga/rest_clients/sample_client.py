"""
WARNING: AUTOGENERATED CODE

    This code was generated by a tool.
    Autogenerated on: 2022-09-02 18:08:19
    
    Manual changes to this file may cause unexpected behavior in your application.
    Manual changes to this file will be overwritten if the code is regenerated.
"""

from pyopencga.rest_clients._parent_rest_clients import _ParentRestClient


class Sample(_ParentRestClient):
    """
    This class contains methods for the 'Samples' webservices
    Client version: 2.4.4-SNAPSHOT [5e889d65ad7faa95a123f8969bb4b44552b6a039]
    PATH: /{apiVersion}/samples
    """

    def __init__(self, configuration, token=None, login_handler=None, *args, **kwargs):
        super(Sample, self).__init__(configuration, token, login_handler, *args, **kwargs)

    def update_acl(self, members, action, data=None, **options):
        """
        Update the set of permissions granted for the member.
        PATH: /{apiVersion}/samples/acl/{members}/update

        :param dict data: JSON containing the parameters to update the
            permissions. If propagate flag is set to true, it will propagate
            the permissions defined to the individuals that are associated to
            the matching samples. (REQUIRED)
        :param str action: Action to be performed [ADD, SET, REMOVE or RESET].
            Allowed values: ['SET ADD REMOVE RESET'] (REQUIRED)
        :param str members: Comma separated list of user or group ids.
            (REQUIRED)
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        """

        options['action'] = action
        return self._post(category='samples', resource='update', subcategory='acl', second_query_id=members, data=data, **options)

    def aggregation_stats(self, **options):
        """
        Fetch catalog sample stats.
        PATH: /{apiVersion}/samples/aggregationStats

        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param str source: Source.
        :param str creation_year: Creation year.
        :param str creation_month: Creation month (JANUARY, FEBRUARY...).
        :param str creation_day: Creation day.
        :param str creation_day_of_week: Creation day of week (MONDAY,
            TUESDAY...).
        :param str status: Status.
        :param str type: Type.
        :param str phenotypes: Phenotypes.
        :param str release: Release.
        :param str version: Version.
        :param bool somatic: Somatic.
        :param str annotation: Annotation filters. Example:
            age>30;gender=FEMALE. For more information, please visit
            http://docs.opencb.org/display/opencga/AnnotationSets+1.4.0.
        :param bool default: Calculate default stats.
        :param str field: List of fields separated by semicolons, e.g.:
            studies;type. For nested fields use >>, e.g.:
            studies>>biotype;type;numSamples[0..10]:1.
        """

        return self._get(category='samples', resource='aggregationStats', **options)

    def load_annotation_sets(self, variable_set_id, path, data=None, **options):
        """
        Load annotation sets from a TSV file.
        PATH: /{apiVersion}/samples/annotationSets/load

        :param str path: Path where the TSV file is located in OpenCGA or
            where it should be located. (REQUIRED)
        :param str variable_set_id: Variable set ID or name. (REQUIRED)
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param bool parents: Flag indicating whether to create parent
            directories if they don't exist (only when TSV file was not
            previously associated).
        :param str annotation_set_id: Annotation set id. If not provided,
            variableSetId will be used.
        :param dict data: JSON containing the 'content' of the TSV file if
            this has not yet been registered into OpenCGA.
        """

        options['variableSetId'] = variable_set_id
        options['path'] = path
        return self._post(category='samples', resource='load', subcategory='annotationSets', data=data, **options)

    def create(self, data=None, **options):
        """
        Create sample.
        PATH: /{apiVersion}/samples/create

        :param dict data: JSON containing sample information. (REQUIRED)
        :param str include: Fields included in the response, whole JSON path
            must be provided.
        :param str exclude: Fields excluded in the response, whole JSON path
            must be provided.
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param bool include_result: Flag indicating to include the created or
            updated document result in the response.
        """

        return self._post(category='samples', resource='create', data=data, **options)

    def distinct(self, field, **options):
        """
        Sample distinct method.
        PATH: /{apiVersion}/samples/distinct

        :param str field: Field for which to obtain the distinct values.
            (REQUIRED)
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param str id: Comma separated list sample IDs up to a maximum of 100.
        :param str uuid: Comma separated list sample UUIDs up to a maximum of
            100.
        :param bool somatic: Somatic sample.
        :param str individual_id: Individual ID or UUID.
        :param str file_ids: Comma separated list of file IDs, paths or UUIDs.
        :param str cohort_ids: Comma separated list of cohort IDs.
        :param str creation_date: Creation date. Format: yyyyMMddHHmmss.
            Examples: >2018, 2017-2018, <201805.
        :param str modification_date: Modification date. Format:
            yyyyMMddHHmmss. Examples: >2018, 2017-2018, <201805.
        :param str internal_status: Filter by internal status.
        :param str status: Filter by status.
        :param str processing_product: Processing product.
        :param str processing_preparation_method: Processing preparation
            method.
        :param str processing_extraction_method: Processing extraction method.
        :param str processing_lab_sample_id: Processing lab sample id.
        :param str collection_from: Collection from.
        :param str collection_type: Collection type.
        :param str collection_method: Collection method.
        :param str phenotypes: Comma separated list of phenotype ids or names.
        :param str annotation: Annotation filters. Example:
            age>30;gender=FEMALE. For more information, please visit
            http://docs.opencb.org/display/opencga/AnnotationSets+1.4.0.
        :param str acl: Filter entries for which a user has the provided
            permissions. Format: acl={user}:{permissions}. Example:
            acl=john:WRITE,WRITE_ANNOTATIONS will return all entries for which
            user john has both WRITE and WRITE_ANNOTATIONS permissions. Only
            study owners or administrators can query by this field. .
        :param str internal_rga_status: Index status of the sample for the
            Recessive Gene Analysis. Allowed values: ['NOT_INDEXED INDEXED
            INVALID_PERMISSIONS INVALID_METADATA INVALID']
        :param str release: Release when it was created.
        :param int snapshot: Snapshot value (Latest version of the entry in
            the specified release).
        :param bool deleted: Boolean to retrieve deleted entries.
        :param str stats_id: Sample variant stats Id. If this field is not
            provided and the user filters by other stats fields, it will
            automatically be set to ALL.
        :param str stats_variant_count: Sample variant stats VariantCount.
        :param str stats_chromosome_count: Sample variant stats
            ChromosomeCount.
        :param str stats_type_count: Sample variant stats TypeCount.
        :param str stats_genotype_count: Sample variant stats GenotypeCount.
        :param str stats_ti_tv_ratio: Sample variant stats TiTvRatio.
        :param str stats_quality_avg: Sample variant stats QualityAvg.
        :param str stats_quality_std_dev: Sample variant stats QualityStdDev.
        :param str stats_heterozygosity_rate: Sample variant stats
            HeterozygosityRate.
        :param str stats_depth_count: Sample variant stats DepthCount.
        :param str stats_biotype_count: Sample variant stats BiotypeCount.
        :param str stats_clinical_significance_count: Sample variant stats
            ClinicalSignificanceCount.
        :param str stats_consequence_type_count: Sample variant stats
            ConsequenceTypeCount.
        """

        options['field'] = field
        return self._get(category='samples', resource='distinct', **options)

    def load(self, file, **options):
        """
        Load samples from a ped file [EXPERIMENTAL].
        PATH: /{apiVersion}/samples/load

        :param str file: file. (REQUIRED)
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param str variable_set: variableSet.
        """

        options['file'] = file
        return self._get(category='samples', resource='load', **options)

    def search(self, **options):
        """
        Sample search method.
        PATH: /{apiVersion}/samples/search

        :param str include: Fields included in the response, whole JSON path
            must be provided.
        :param str exclude: Fields excluded in the response, whole JSON path
            must be provided.
        :param int limit: Number of results to be returned.
        :param int skip: Number of results to skip.
        :param bool count: Get the total number of results matching the query.
            Deactivated by default.
        :param bool include_individual: Include Individual object as an
            attribute.
        :param bool flatten_annotations: Flatten the annotations?.
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param str id: Comma separated list sample IDs up to a maximum of 100.
        :param str uuid: Comma separated list sample UUIDs up to a maximum of
            100.
        :param bool somatic: Somatic sample.
        :param str individual_id: Individual ID or UUID.
        :param str file_ids: Comma separated list of file IDs, paths or UUIDs.
        :param str cohort_ids: Comma separated list of cohort IDs.
        :param str creation_date: Creation date. Format: yyyyMMddHHmmss.
            Examples: >2018, 2017-2018, <201805.
        :param str modification_date: Modification date. Format:
            yyyyMMddHHmmss. Examples: >2018, 2017-2018, <201805.
        :param str internal_status: Filter by internal status.
        :param str status: Filter by status.
        :param str processing_product: Processing product.
        :param str processing_preparation_method: Processing preparation
            method.
        :param str processing_extraction_method: Processing extraction method.
        :param str processing_lab_sample_id: Processing lab sample id.
        :param str collection_from: Collection from.
        :param str collection_type: Collection type.
        :param str collection_method: Collection method.
        :param str phenotypes: Comma separated list of phenotype ids or names.
        :param str annotation: Annotation filters. Example:
            age>30;gender=FEMALE. For more information, please visit
            http://docs.opencb.org/display/opencga/AnnotationSets+1.4.0.
        :param str acl: Filter entries for which a user has the provided
            permissions. Format: acl={user}:{permissions}. Example:
            acl=john:WRITE,WRITE_ANNOTATIONS will return all entries for which
            user john has both WRITE and WRITE_ANNOTATIONS permissions. Only
            study owners or administrators can query by this field. .
        :param str internal_rga_status: Index status of the sample for the
            Recessive Gene Analysis. Allowed values: ['NOT_INDEXED INDEXED
            INVALID_PERMISSIONS INVALID_METADATA INVALID']
        :param str release: Release when it was created.
        :param int snapshot: Snapshot value (Latest version of the entry in
            the specified release).
        :param bool deleted: Boolean to retrieve deleted entries.
        :param str stats_id: Sample variant stats Id. If this field is not
            provided and the user filters by other stats fields, it will
            automatically be set to ALL.
        :param str stats_variant_count: Sample variant stats VariantCount.
        :param str stats_chromosome_count: Sample variant stats
            ChromosomeCount.
        :param str stats_type_count: Sample variant stats TypeCount.
        :param str stats_genotype_count: Sample variant stats GenotypeCount.
        :param str stats_ti_tv_ratio: Sample variant stats TiTvRatio.
        :param str stats_quality_avg: Sample variant stats QualityAvg.
        :param str stats_quality_std_dev: Sample variant stats QualityStdDev.
        :param str stats_heterozygosity_rate: Sample variant stats
            HeterozygosityRate.
        :param str stats_depth_count: Sample variant stats DepthCount.
        :param str stats_biotype_count: Sample variant stats BiotypeCount.
        :param str stats_clinical_significance_count: Sample variant stats
            ClinicalSignificanceCount.
        :param str stats_consequence_type_count: Sample variant stats
            ConsequenceTypeCount.
        """

        return self._get(category='samples', resource='search', **options)

    def acl(self, samples, **options):
        """
        Returns the acl of the samples. If member is provided, it will only
            return the acl for the member.
        PATH: /{apiVersion}/samples/{samples}/acl

        :param str samples: Comma separated list sample IDs or UUIDs up to a
            maximum of 100. (REQUIRED)
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param str member: User or group id.
        :param bool silent: Boolean to retrieve all possible entries that are
            queried for, false to raise an exception whenever one of the
            entries looked for cannot be shown for whichever reason.
        """

        return self._get(category='samples', resource='acl', query_id=samples, **options)

    def delete(self, samples, **options):
        """
        Delete samples.
        PATH: /{apiVersion}/samples/{samples}/delete

        :param str samples: Comma separated list sample IDs or UUIDs up to a
            maximum of 100. (REQUIRED)
        :param bool force: Force the deletion of samples even if they are
            associated to files, individuals or cohorts.
        :param str empty_files_action: Action to be performed over files that
            were associated only to the sample to be deleted. Possible actions
            are NONE, TRASH, DELETE.
        :param bool delete_empty_cohorts: Boolean indicating if the cohorts
            associated only to the sample to be deleted should be also deleted.
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        """

        return self._delete(category='samples', resource='delete', query_id=samples, **options)

    def info(self, samples, **options):
        """
        Get sample information.
        PATH: /{apiVersion}/samples/{samples}/info

        :param str samples: Comma separated list sample IDs or UUIDs up to a
            maximum of 100. (REQUIRED)
        :param str include: Fields included in the response, whole JSON path
            must be provided.
        :param str exclude: Fields excluded in the response, whole JSON path
            must be provided.
        :param bool include_individual: Include Individual object as an
            attribute.
        :param bool flatten_annotations: Flatten the annotations?.
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param str version: Comma separated list of sample versions. 'all' to
            get all the sample versions. Not supported if multiple sample ids
            are provided.
        :param bool deleted: Boolean to retrieve deleted entries.
        """

        return self._get(category='samples', resource='info', query_id=samples, **options)

    def update(self, samples, data=None, **options):
        """
        Update some sample attributes.
        PATH: /{apiVersion}/samples/{samples}/update

        :param str samples: Comma separated list sample IDs or UUIDs up to a
            maximum of 100. (REQUIRED)
        :param str include: Fields included in the response, whole JSON path
            must be provided.
        :param str exclude: Fields excluded in the response, whole JSON path
            must be provided.
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param str annotation_sets_action: Action to be performed if the array
            of annotationSets is being updated. Allowed values: ['ADD SET
            REMOVE']
        :param str phenotypes_action: Action to be performed if the array of
            phenotypes is being updated [SET, ADD, REMOVE]. Allowed values:
            ['ADD SET REMOVE']
        :param bool include_result: Flag indicating to include the created or
            updated document result in the response.
        :param dict data: body.
        """

        return self._post(category='samples', resource='update', query_id=samples, data=data, **options)

    def update_annotation_sets_annotations(self, sample, annotation_set, data=None, **options):
        """
        Update annotations from an annotationSet.
        PATH: /{apiVersion}/samples/{sample}/annotationSets/{annotationSet}/annotations/update

        :param str annotation_set: AnnotationSet ID to be updated. (REQUIRED)
        :param str sample: Sample ID. (REQUIRED)
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param str action: Action to be performed: ADD to add new annotations;
            REPLACE to replace the value of an already existing annotation; SET
            to set the new list of annotations removing any possible old
            annotations; REMOVE to remove some annotations; RESET to set some
            annotations to the default value configured in the corresponding
            variables of the VariableSet if any. Allowed values: ['ADD SET
            REMOVE RESET REPLACE']
        :param dict data: Json containing the map of annotations when the
            action is ADD, SET or REPLACE, a json with only the key 'remove'
            containing the comma separated variables to be removed as a value
            when the action is REMOVE or a json with only the key 'reset'
            containing the comma separated variables that will be set to the
            default value when the action is RESET.
        """

        return self._post(category='samples', resource='annotations/update', query_id=sample, subcategory='annotationSets', second_query_id=annotation_set, data=data, **options)

