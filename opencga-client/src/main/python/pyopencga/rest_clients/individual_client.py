"""
WARNING: AUTOGENERATED CODE

    This code was generated by a tool.
    Autogenerated on: 2022-07-23 01:15:43
    
    Manual changes to this file may cause unexpected behavior in your application.
    Manual changes to this file will be overwritten if the code is regenerated.
"""

from pyopencga.rest_clients._parent_rest_clients import _ParentRestClient


class Individual(_ParentRestClient):
    """
    This class contains methods for the 'Individuals' webservices
    Client version: 2.4.1-SNAPSHOT [d0033c194a835983d9b17967777c10bbbf616646]
    PATH: /{apiVersion}/individuals
    """

    def __init__(self, configuration, token=None, login_handler=None, *args, **kwargs):
        super(Individual, self).__init__(configuration, token, login_handler, *args, **kwargs)

    def update_acl(self, members, action, data=None, **options):
        """
        Update the set of permissions granted for the member.
        PATH: /{apiVersion}/individuals/acl/{members}/update

        :param dict data: JSON containing the parameters to update the
            permissions. If propagate flag is set to true, it will propagate
            the permissions defined to the samples that are associated to the
            matching individuals. (REQUIRED)
        :param str action: Action to be performed [ADD, SET, REMOVE or RESET].
            Allowed values: ['SET ADD REMOVE RESET'] (REQUIRED)
        :param str members: Comma separated list of user or group ids.
            (REQUIRED)
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param bool propagate: Propagate individual permissions to related
            samples.
        """

        options['action'] = action
        return self._post(category='individuals', resource='update', subcategory='acl', second_query_id=members, data=data, **options)

    def aggregation_stats(self, **options):
        """
        Fetch catalog individual stats.
        PATH: /{apiVersion}/individuals/aggregationStats

        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param bool has_father: Has father.
        :param bool has_mother: Has mother.
        :param str sex: Sex.
        :param str karyotypic_sex: Karyotypic sex.
        :param str ethnicity: Ethnicity.
        :param str population: Population.
        :param str creation_year: Creation year.
        :param str creation_month: Creation month (JANUARY, FEBRUARY...).
        :param str creation_day: Creation day.
        :param str creation_day_of_week: Creation day of week (MONDAY,
            TUESDAY...).
        :param str status: Status.
        :param str life_status: Life status.
        :param str phenotypes: Phenotypes.
        :param str num_samples: Number of samples.
        :param bool parental_consanguinity: Parental consanguinity.
        :param str release: Release.
        :param str version: Version.
        :param str annotation: Annotation filters. Example:
            age>30;gender=FEMALE. For more information, please visit
            http://docs.opencb.org/display/opencga/AnnotationSets+1.4.0.
        :param bool default: Calculate default stats.
        :param str field: List of fields separated by semicolons, e.g.:
            studies;type. For nested fields use >>, e.g.:
            studies>>biotype;type;numSamples[0..10]:1.
        """

        return self._get(category='individuals', resource='aggregationStats', **options)

    def load_annotation_sets(self, variable_set_id, path, data=None, **options):
        """
        Load annotation sets from a TSV file.
        PATH: /{apiVersion}/individuals/annotationSets/load

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
        return self._post(category='individuals', resource='load', subcategory='annotationSets', data=data, **options)

    def create(self, data=None, **options):
        """
        Create individual.
        PATH: /{apiVersion}/individuals/create

        :param dict data: JSON containing individual information. (REQUIRED)
        :param str include: Fields included in the response, whole JSON path
            must be provided.
        :param str exclude: Fields excluded in the response, whole JSON path
            must be provided.
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param str samples: Comma separated list of sample ids to be
            associated to the created individual.
        :param bool include_result: Flag indicating to include the created or
            updated document result in the response.
        """

        return self._post(category='individuals', resource='create', data=data, **options)

    def distinct(self, field, **options):
        """
        Individual distinct method.
        PATH: /{apiVersion}/individuals/distinct

        :param str field: Field for which to obtain the distinct values.
            (REQUIRED)
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param str id: Comma separated list individual IDs up to a maximum of
            100.
        :param str uuid: Comma separated list individual UUIDs up to a maximum
            of 100.
        :param str name: Comma separated list individual names up to a maximum
            of 100.
        :param str family_ids: Comma separated list of family ids the
            individuals may belong to.
        :param str father: Father ID, name or UUID.
        :param str mother: Mother ID, name or UUID.
        :param str samples: Sample ID, name or UUID.
        :param str sex: Individual sex.
        :param str ethnicity: Individual ethnicity.
        :param str date_of_birth: Individual date of birth.
        :param str disorders: Comma separated list of disorder ids or names.
        :param str phenotypes: Comma separated list of phenotype ids or names.
        :param str population_name: Population name.
        :param str population_subpopulation: Subpopulation name.
        :param str karyotypic_sex: Individual karyotypic sex.
        :param str life_status: Individual life status.
        :param str internal_status: Filter by internal status.
        :param str status: Filter by status.
        :param bool deleted: Boolean to retrieve deleted entries.
        :param str creation_date: Creation date. Format: yyyyMMddHHmmss.
            Examples: >2018, 2017-2018, <201805.
        :param str modification_date: Modification date. Format:
            yyyyMMddHHmmss. Examples: >2018, 2017-2018, <201805.
        :param str annotation: Annotation filters. Example:
            age>30;gender=FEMALE. For more information, please visit
            http://docs.opencb.org/display/opencga/AnnotationSets+1.4.0.
        :param str acl: Filter entries for which a user has the provided
            permissions. Format: acl={user}:{permissions}. Example:
            acl=john:WRITE,WRITE_ANNOTATIONS will return all entries for which
            user john has both WRITE and WRITE_ANNOTATIONS permissions. Only
            study owners or administrators can query by this field. .
        :param str release: Release when it was created.
        :param int snapshot: Snapshot value (Latest version of the entry in
            the specified release).
        """

        options['field'] = field
        return self._get(category='individuals', resource='distinct', **options)

    def search(self, **options):
        """
        Search for individuals.
        PATH: /{apiVersion}/individuals/search

        :param str include: Fields included in the response, whole JSON path
            must be provided.
        :param str exclude: Fields excluded in the response, whole JSON path
            must be provided.
        :param int limit: Number of results to be returned.
        :param int skip: Number of results to skip.
        :param bool count: Get the total number of results matching the query.
            Deactivated by default.
        :param bool flatten_annotations: Flatten the annotations?.
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param str id: Comma separated list individual IDs up to a maximum of
            100.
        :param str uuid: Comma separated list individual UUIDs up to a maximum
            of 100.
        :param str name: Comma separated list individual names up to a maximum
            of 100.
        :param str father: Father ID, name or UUID.
        :param str mother: Mother ID, name or UUID.
        :param str samples: Sample ID, name or UUID.
        :param str family_ids: Comma separated list of family ids the
            individuals may belong to.
        :param str sex: Individual sex.
        :param str date_of_birth: Individual date of birth.
        :param str ethnicity: Individual ethnicity.
        :param str disorders: Comma separated list of disorder ids or names.
        :param str phenotypes: Comma separated list of phenotype ids or names.
        :param str population_name: Population name.
        :param str population_subpopulation: Subpopulation name.
        :param str karyotypic_sex: Individual karyotypic sex.
        :param str life_status: Individual life status.
        :param str internal_status: Filter by internal status.
        :param str status: Filter by status.
        :param bool deleted: Boolean to retrieve deleted entries.
        :param str creation_date: Creation date. Format: yyyyMMddHHmmss.
            Examples: >2018, 2017-2018, <201805.
        :param str modification_date: Modification date. Format:
            yyyyMMddHHmmss. Examples: >2018, 2017-2018, <201805.
        :param str annotation: Annotation filters. Example:
            age>30;gender=FEMALE. For more information, please visit
            http://docs.opencb.org/display/opencga/AnnotationSets+1.4.0.
        :param str acl: Filter entries for which a user has the provided
            permissions. Format: acl={user}:{permissions}. Example:
            acl=john:WRITE,WRITE_ANNOTATIONS will return all entries for which
            user john has both WRITE and WRITE_ANNOTATIONS permissions. Only
            study owners or administrators can query by this field. .
        :param str release: Release when it was created.
        :param int snapshot: Snapshot value (Latest version of the entry in
            the specified release).
        """

        return self._get(category='individuals', resource='search', **options)

    def acl(self, individuals, **options):
        """
        Return the acl of the individual. If member is provided, it will only
            return the acl for the member.
        PATH: /{apiVersion}/individuals/{individuals}/acl

        :param str individuals: Comma separated list of individual IDs, names
            or UUIDs up to a maximum of 100. (REQUIRED)
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param str member: User or group id.
        :param bool silent: Boolean to retrieve all possible entries that are
            queried for, false to raise an exception whenever one of the
            entries looked for cannot be shown for whichever reason.
        """

        return self._get(category='individuals', resource='acl', query_id=individuals, **options)

    def delete(self, individuals, **options):
        """
        Delete existing individuals.
        PATH: /{apiVersion}/individuals/{individuals}/delete

        :param str individuals: Comma separated list of individual ids.
            (REQUIRED)
        :param bool force: Force the deletion of individuals that already
            belong to families.
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        """

        return self._delete(category='individuals', resource='delete', query_id=individuals, **options)

    def info(self, individuals, **options):
        """
        Get individual information.
        PATH: /{apiVersion}/individuals/{individuals}/info

        :param str individuals: Comma separated list of individual IDs, names
            or UUIDs up to a maximum of 100. (REQUIRED)
        :param str include: Fields included in the response, whole JSON path
            must be provided.
        :param str exclude: Fields excluded in the response, whole JSON path
            must be provided.
        :param bool flatten_annotations: Flatten the annotations?.
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param str version: Comma separated list of individual versions. 'all'
            to get all the individual versions. Not supported if multiple
            individual ids are provided.
        :param bool deleted: Boolean to retrieve deleted individuals.
        """

        return self._get(category='individuals', resource='info', query_id=individuals, **options)

    def update(self, individuals, data=None, **options):
        """
        Update some individual attributes.
        PATH: /{apiVersion}/individuals/{individuals}/update

        :param str individuals: Comma separated list of individual ids.
            (REQUIRED)
        :param str include: Fields included in the response, whole JSON path
            must be provided.
        :param str exclude: Fields excluded in the response, whole JSON path
            must be provided.
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param str samples_action: Action to be performed if the array of
            samples is being updated. Allowed values: ['ADD SET REMOVE']
        :param str phenotypes_action: Action to be performed if the array of
            phenotypes is being updated [SET, ADD, REMOVE]. Allowed values:
            ['ADD SET REMOVE']
        :param str disorders_action: Action to be performed if the array of
            disorders is being updated [SET, ADD, REMOVE]. Allowed values:
            ['ADD SET REMOVE']
        :param str annotation_sets_action: Action to be performed if the array
            of annotationSets is being updated. Allowed values: ['ADD SET
            REMOVE']
        :param bool include_result: Flag indicating to include the created or
            updated document result in the response.
        :param dict data: body.
        """

        return self._post(category='individuals', resource='update', query_id=individuals, data=data, **options)

    def update_annotation_sets_annotations(self, individual, annotation_set, data=None, **options):
        """
        Update annotations from an annotationSet.
        PATH: /{apiVersion}/individuals/{individual}/annotationSets/{annotationSet}/annotations/update

        :param str annotation_set: AnnotationSet ID to be updated. (REQUIRED)
        :param str individual: Individual ID, name or UUID. (REQUIRED)
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

        return self._post(category='individuals', resource='annotations/update', query_id=individual, subcategory='annotationSets', second_query_id=annotation_set, data=data, **options)

    def relatives(self, individual, **options):
        """
        Get individual relatives.
        PATH: /{apiVersion}/individuals/{individual}/relatives

        :param str individual: Individual ID, name or UUID. (REQUIRED)
        :param str include: Fields included in the response, whole JSON path
            must be provided.
        :param str exclude: Fields excluded in the response, whole JSON path
            must be provided.
        :param bool flatten_annotations: Flatten the annotations?.
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param int degree: Pedigree degree.
        """

        return self._get(category='individuals', resource='relatives', query_id=individual, **options)

