"""
WARNING: AUTOGENERATED CODE

    This code was generated by a tool.
    Autogenerated on: 2022-05-17 10:42:16
    
    Manual changes to this file may cause unexpected behavior in your application.
    Manual changes to this file will be overwritten if the code is regenerated.
"""

from pyopencga.rest_clients._parent_rest_clients import _ParentRestClient


class Family(_ParentRestClient):
    """
    This class contains methods for the 'Families' webservices
    Client version: 2.3.0-SNAPSHOT [c37899f2d43a9e86997fbf482c011506fd0b0381]
    PATH: /{apiVersion}/families
    """

    def __init__(self, configuration, token=None, login_handler=None, *args, **kwargs):
        super(Family, self).__init__(configuration, token, login_handler, *args, **kwargs)

    def update_acl(self, members, action, data=None, **options):
        """
        Update the set of permissions granted for the member.
        PATH: /{apiVersion}/families/acl/{members}/update

        :param dict data: JSON containing the parameters to add ACLs.
            (REQUIRED)
        :param str action: Action to be performed [ADD, SET, REMOVE or RESET].
            (REQUIRED)
        :param str members: Comma separated list of user or group ids.
            (REQUIRED)
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param str propagate: Propagate family permissions to related
            individuals and samples.
        """

        options['action'] = action
        return self._post(category='families', resource='update', subcategory='acl', second_query_id=members, data=data, **options)

    def aggregation_stats(self, **options):
        """
        Fetch catalog family stats.
        PATH: /{apiVersion}/families/aggregationStats

        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param str creation_year: Creation year.
        :param str creation_month: Creation month (JANUARY, FEBRUARY...).
        :param str creation_day: Creation day.
        :param str creation_day_of_week: Creation day of week (MONDAY,
            TUESDAY...).
        :param str status: Status.
        :param str phenotypes: Phenotypes.
        :param str release: Release.
        :param str version: Version.
        :param str num_members: Number of members.
        :param str expected_size: Expected size.
        :param str annotation: Annotation filters. Example:
            age>30;gender=FEMALE. For more information, please visit
            http://docs.opencb.org/display/opencga/AnnotationSets+1.4.0.
        :param bool default: Calculate default stats.
        :param str field: List of fields separated by semicolons, e.g.:
            studies;type. For nested fields use >>, e.g.:
            studies>>biotype;type;numSamples[0..10]:1.
        """

        return self._get(category='families', resource='aggregationStats', **options)

    def load_annotation_sets(self, variable_set_id, path, data=None, **options):
        """
        Load annotation sets from a TSV file.
        PATH: /{apiVersion}/families/annotationSets/load

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
        return self._post(category='families', resource='load', subcategory='annotationSets', data=data, **options)

    def create(self, data=None, **options):
        """
        Create family and the individual objects if they do not exist.
        PATH: /{apiVersion}/families/create

        :param dict data: JSON containing family information. (REQUIRED)
        :param str include: Fields included in the response, whole JSON path
            must be provided.
        :param str exclude: Fields excluded in the response, whole JSON path
            must be provided.
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param str members: Comma separated list of member ids to be
            associated to the created family.
        :param bool include_result: Flag indicating to include the created or
            updated document result in the response.
        """

        return self._post(category='families', resource='create', data=data, **options)

    def distinct(self, field, **options):
        """
        Family distinct method.
        PATH: /{apiVersion}/families/distinct

        :param str field: Field for which to obtain the distinct values.
            (REQUIRED)
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param str id: Comma separated list family IDs up to a maximum of 100.
        :param str name: Comma separated list family names up to a maximum of
            100.
        :param str uuid: Comma separated list family UUIDs up to a maximum of
            100.
        :param str members: Comma separated list of family members.
        :param int expected_size: Expected size of the family (number of
            members).
        :param str samples: Comma separated list of member's samples.
        :param str phenotypes: Comma separated list of phenotype ids or names.
        :param str disorders: Comma separated list of disorder ids or names.
        :param str creation_date: Creation date. Format: yyyyMMddHHmmss.
            Examples: >2018, 2017-2018, <201805.
        :param str modification_date: Modification date. Format:
            yyyyMMddHHmmss. Examples: >2018, 2017-2018, <201805.
        :param bool deleted: Boolean to retrieve deleted entries.
        :param str internal_status: Filter by internal status.
        :param str status: Filter by status.
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
        return self._get(category='families', resource='distinct', **options)

    def search(self, **options):
        """
        Search families.
        PATH: /{apiVersion}/families/search

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
        :param str id: Comma separated list family IDs up to a maximum of 100.
        :param str name: Comma separated list family names up to a maximum of
            100.
        :param str uuid: Comma separated list family UUIDs up to a maximum of
            100.
        :param str members: Comma separated list of family members.
        :param int expected_size: Expected size of the family (number of
            members).
        :param str samples: Comma separated list of member's samples.
        :param str phenotypes: Comma separated list of phenotype ids or names.
        :param str disorders: Comma separated list of disorder ids or names.
        :param str creation_date: Creation date. Format: yyyyMMddHHmmss.
            Examples: >2018, 2017-2018, <201805.
        :param str modification_date: Modification date. Format:
            yyyyMMddHHmmss. Examples: >2018, 2017-2018, <201805.
        :param bool deleted: Boolean to retrieve deleted entries.
        :param str internal_status: Filter by internal status.
        :param str status: Filter by status.
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

        return self._get(category='families', resource='search', **options)

    def acl(self, families, **options):
        """
        Returns the acl of the families. If member is provided, it will only
            return the acl for the member.
        PATH: /{apiVersion}/families/{families}/acl

        :param str families: Comma separated list of family IDs or names up to
            a maximum of 100. (REQUIRED)
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param str member: User or group id.
        :param bool silent: Boolean to retrieve all possible entries that are
            queried for, false to raise an exception whenever one of the
            entries looked for cannot be shown for whichever reason.
        """

        return self._get(category='families', resource='acl', query_id=families, **options)

    def delete(self, families, **options):
        """
        Delete existing families.
        PATH: /{apiVersion}/families/{families}/delete

        :param str families: Comma separated list of family ids. (REQUIRED)
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        """

        return self._delete(category='families', resource='delete', query_id=families, **options)

    def info(self, families, **options):
        """
        Get family information.
        PATH: /{apiVersion}/families/{families}/info

        :param str families: Comma separated list of family IDs or names up to
            a maximum of 100. (REQUIRED)
        :param str include: Fields included in the response, whole JSON path
            must be provided.
        :param str exclude: Fields excluded in the response, whole JSON path
            must be provided.
        :param bool flatten_annotations: Flatten the annotations?.
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param str version: Comma separated list of family versions. 'all' to
            get all the family versions. Not supported if multiple family ids
            are provided.
        :param bool deleted: Boolean to retrieve deleted families.
        """

        return self._get(category='families', resource='info', query_id=families, **options)

    def update(self, families, data=None, **options):
        """
        Update some family attributes.
        PATH: /{apiVersion}/families/{families}/update

        :param str families: Comma separated list of family ids. (REQUIRED)
        :param str include: Fields included in the response, whole JSON path
            must be provided.
        :param str exclude: Fields excluded in the response, whole JSON path
            must be provided.
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param bool update_roles: Update the member roles within the family.
        :param str annotation_sets_action: Action to be performed if the array
            of annotationSets is being updated. Allowed values: ['ADD', 'SET',
            'REMOVE']
        :param bool include_result: Flag indicating to include the created or
            updated document result in the response.
        :param dict data: body.
        """

        return self._post(category='families', resource='update', query_id=families, data=data, **options)

    def update_annotation_sets_annotations(self, family, annotation_set, data=None, **options):
        """
        Update annotations from an annotationSet.
        PATH: /{apiVersion}/families/{family}/annotationSets/{annotationSet}/annotations/update

        :param str annotation_set: AnnotationSet ID to be updated. (REQUIRED)
        :param str family: Family id. (REQUIRED)
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param str action: Action to be performed: ADD to add new annotations;
            REPLACE to replace the value of an already existing annotation; SET
            to set the new list of annotations removing any possible old
            annotations; REMOVE to remove some annotations; RESET to set some
            annotations to the default value configured in the corresponding
            variables of the VariableSet if any. Allowed values: ['ADD', 'SET',
            'REMOVE', 'RESET', 'REPLACE']
        :param dict data: Json containing the map of annotations when the
            action is ADD, SET or REPLACE, a json with only the key 'remove'
            containing the comma separated variables to be removed as a value
            when the action is REMOVE or a json with only the key 'reset'
            containing the comma separated variables that will be set to the
            default value when the action is RESET.
        """

        return self._post(category='families', resource='annotations/update', query_id=family, subcategory='annotationSets', second_query_id=annotation_set, data=data, **options)

