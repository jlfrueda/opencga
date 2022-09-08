"""
WARNING: AUTOGENERATED CODE

    This code was generated by a tool.
    Autogenerated on: 2022-09-08 16:20:20
    
    Manual changes to this file may cause unexpected behavior in your application.
    Manual changes to this file will be overwritten if the code is regenerated.
"""

from pyopencga.rest_clients._parent_rest_clients import _ParentRestClient


class Study(_ParentRestClient):
    """
    This class contains methods for the 'Studies' webservices
    Client version: 2.4.4-SNAPSHOT [75f61bdd6fe4cdfc4526f1b885087c51a9545a00]
    PATH: /{apiVersion}/studies
    """

    def __init__(self, configuration, token=None, login_handler=None, *args, **kwargs):
        super(Study, self).__init__(configuration, token, login_handler, *args, **kwargs)

    def update_acl(self, members, action, data=None, **options):
        """
        Update the set of permissions granted for the member.
        PATH: /{apiVersion}/studies/acl/{members}/update

        :param dict data: JSON containing the parameters to modify ACLs.
            'template' could be either 'admin', 'analyst' or 'view_only'.
            (REQUIRED)
        :param str action: Action to be performed [ADD, SET, REMOVE or RESET].
            Allowed values: ['SET ADD REMOVE RESET'] (REQUIRED)
        :param str members: Comma separated list of user or group ids.
            (REQUIRED)
        """

        options['action'] = action
        return self._post(category='studies', resource='update', subcategory='acl', second_query_id=members, data=data, **options)

    def create(self, data=None, **options):
        """
        Create a new study.
        PATH: /{apiVersion}/studies/create

        :param dict data: study. (REQUIRED)
        :param str include: Fields included in the response, whole JSON path
            must be provided.
        :param str exclude: Fields excluded in the response, whole JSON path
            must be provided.
        :param str project: Project [user@]project where project can be either
            the ID or the alias.
        :param bool include_result: Flag indicating to include the created or
            updated document result in the response.
        """

        return self._post(category='studies', resource='create', data=data, **options)

    def search(self, project, **options):
        """
        Search studies.
        PATH: /{apiVersion}/studies/search

        :param str project: Project [user@]project where project can be either
            the ID or the alias. (REQUIRED)
        :param str include: Fields included in the response, whole JSON path
            must be provided.
        :param str exclude: Fields excluded in the response, whole JSON path
            must be provided.
        :param int limit: Number of results to be returned.
        :param int skip: Number of results to skip.
        :param bool count: Get the total number of results matching the query.
            Deactivated by default.
        :param str name: Study name.
        :param str id: Study ID.
        :param str alias: Study alias.
        :param str fqn: Study full qualified name.
        :param str creation_date: Creation date. Format: yyyyMMddHHmmss.
            Examples: >2018, 2017-2018, <201805.
        :param str modification_date: Modification date. Format:
            yyyyMMddHHmmss. Examples: >2018, 2017-2018, <201805.
        :param str internal_status: Filter by internal status.
        :param str status: Filter by status.
        :param str attributes: Attributes.
        :param str release: Release value.
        """

        options['project'] = project
        return self._get(category='studies', resource='search', **options)

    def acl(self, studies, **options):
        """
        Return the acl of the study. If member is provided, it will only
            return the acl for the member.
        PATH: /{apiVersion}/studies/{studies}/acl

        :param str studies: Comma separated list of Studies
            [[user@]project:]study where study and project can be either the ID
            or UUID up to a maximum of 100. (REQUIRED)
        :param str member: User or group id.
        :param bool silent: Boolean to retrieve all possible entries that are
            queried for, false to raise an exception whenever one of the
            entries looked for cannot be shown for whichever reason.
        """

        return self._get(category='studies', resource='acl', query_id=studies, **options)

    def aggregation_stats(self, studies, **options):
        """
        Fetch catalog study stats.
        PATH: /{apiVersion}/studies/{studies}/aggregationStats

        :param str studies: Comma separated list of studies
            [[user@]project:]study up to a maximum of 100. (REQUIRED)
        :param bool default: Calculate default stats.
        :param str file_fields: List of file fields separated by semicolons,
            e.g.: studies;type. For nested fields use >>, e.g.:
            studies>>biotype;type.
        :param str individual_fields: List of individual fields separated by
            semicolons, e.g.: studies;type. For nested fields use >>, e.g.:
            studies>>biotype;type.
        :param str family_fields: List of family fields separated by
            semicolons, e.g.: studies;type. For nested fields use >>, e.g.:
            studies>>biotype;type.
        :param str sample_fields: List of sample fields separated by
            semicolons, e.g.: studies;type. For nested fields use >>, e.g.:
            studies>>biotype;type.
        :param str cohort_fields: List of cohort fields separated by
            semicolons, e.g.: studies;type. For nested fields use >>, e.g.:
            studies>>biotype;type.
        :param str job_fields: List of job fields separated by semicolons,
            e.g.: studies;type. For nested fields use >>, e.g.:
            studies>>biotype;type.
        """

        return self._get(category='studies', resource='aggregationStats', query_id=studies, **options)

    def info(self, studies, **options):
        """
        Fetch study information.
        PATH: /{apiVersion}/studies/{studies}/info

        :param str studies: Comma separated list of Studies
            [[user@]project:]study where study and project can be either the ID
            or UUID up to a maximum of 100. (REQUIRED)
        :param str include: Fields included in the response, whole JSON path
            must be provided.
        :param str exclude: Fields excluded in the response, whole JSON path
            must be provided.
        """

        return self._get(category='studies', resource='info', query_id=studies, **options)

    def search_audit(self, study, **options):
        """
        Search audit collection.
        PATH: /{apiVersion}/studies/{study}/audit/search

        :param str study: Study ID. (REQUIRED)
        :param str include: Fields included in the response, whole JSON path
            must be provided.
        :param str exclude: Fields excluded in the response, whole JSON path
            must be provided.
        :param int limit: Number of results to be returned.
        :param int skip: Number of results to skip.
        :param bool count: Get the total number of results matching the query.
            Deactivated by default.
        :param str operation_id: Audit operation UUID.
        :param str user_id: User ID.
        :param str action: Action performed by the user.
        :param str resource: Resource involved. Allowed values: ['AUDIT USER
            PROJECT STUDY FILE SAMPLE JOB INDIVIDUAL COHORT DISEASE_PANEL
            FAMILY CLINICAL_ANALYSIS INTERPRETATION VARIANT ALIGNMENT CLINICAL
            EXPRESSION RGA FUNCTIONAL']
        :param str resource_id: Resource ID.
        :param str resource_uuid: resource UUID.
        :param str status: Filter by status. Allowed values: ['SUCCESS ERROR']
        :param str date: Date. Format: yyyyMMddHHmmss. Examples: >2018,
            2017-2018, <201805.
        """

        return self._get(category='studies', resource='search', query_id=study, subcategory='audit', **options)

    def groups(self, study, **options):
        """
        Return the groups present in the study. For owners and administrators
            only.
        PATH: /{apiVersion}/studies/{study}/groups

        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID. (REQUIRED)
        :param str id: Group id. If provided, it will only fetch information
            for the provided group.
        :param bool silent: Boolean to retrieve all possible entries that are
            queried for, false to raise an exception whenever one of the
            entries looked for cannot be shown for whichever reason.
        """

        return self._get(category='studies', resource='groups', query_id=study, **options)

    def update_groups(self, study, data=None, **options):
        """
        Add or remove a group.
        PATH: /{apiVersion}/studies/{study}/groups/update

        :param dict data: JSON containing the parameters. (REQUIRED)
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID. (REQUIRED)
        :param str action: Action to be performed: ADD or REMOVE a group.
            Allowed values: ['ADD REMOVE']
        """

        return self._post(category='studies', resource='update', query_id=study, subcategory='groups', data=data, **options)

    def update_groups_users(self, study, group, data=None, **options):
        """
        Add, set or remove users from an existing group.
        PATH: /{apiVersion}/studies/{study}/groups/{group}/users/update

        :param dict data: JSON containing the parameters. (REQUIRED)
        :param str group: Group name. (REQUIRED)
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID. (REQUIRED)
        :param str action: Action to be performed: ADD, SET or REMOVE users
            to/from a group. Allowed values: ['ADD SET REMOVE']
        """

        return self._post(category='studies', resource='users/update', query_id=study, subcategory='groups', second_query_id=group, data=data, **options)

    def permission_rules(self, study, entity, **options):
        """
        Fetch permission rules.
        PATH: /{apiVersion}/studies/{study}/permissionRules

        :param str entity: Entity where the permission rules should be applied
            to. Allowed values: ['SAMPLES FILES COHORTS INDIVIDUALS FAMILIES
            JOBS CLINICAL_ANALYSES DISEASE_PANELS'] (REQUIRED)
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID. (REQUIRED)
        """

        options['entity'] = entity
        return self._get(category='studies', resource='permissionRules', query_id=study, **options)

    def update_permission_rules(self, study, entity, data=None, **options):
        """
        Add or remove a permission rule.
        PATH: /{apiVersion}/studies/{study}/permissionRules/update

        :param dict data: JSON containing the permission rule to be created or
            removed. (REQUIRED)
        :param str entity: Entity where the permission rules should be applied
            to. Allowed values: ['SAMPLES FILES COHORTS INDIVIDUALS FAMILIES
            JOBS CLINICAL_ANALYSES DISEASE_PANELS'] (REQUIRED)
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID. (REQUIRED)
        :param str action: Action to be performed: ADD to add a new permission
            rule; REMOVE to remove all permissions assigned by an existing
            permission rule (even if it overlaps any manual permission); REVERT
            to remove all permissions assigned by an existing permission rule
            (keep manual overlaps); NONE to remove an existing permission rule
            without removing any permissions that could have been assigned
            already by the permission rule. Allowed values: ['ADD REMOVE REVERT
            NONE']
        """

        options['entity'] = entity
        return self._post(category='studies', resource='update', query_id=study, subcategory='permissionRules', data=data, **options)

    def run_templates(self, study, data=None, **options):
        """
        Execute template.
        PATH: /{apiVersion}/studies/{study}/templates/run

        :param dict data: Template loader parameters. (REQUIRED)
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID. (REQUIRED)
        :param str job_id: Job ID. It must be a unique string within the
            study. An ID will be autogenerated automatically if not provided.
        :param str job_depends_on: Comma separated list of existing job IDs
            the job will depend on.
        :param str job_description: Job description.
        :param str job_tags: Job tags.
        """

        return self._post(category='studies', resource='run', query_id=study, subcategory='templates', data=data, **options)

    def upload_templates(self, study, **options):
        """
        Resource to upload a zipped template.
        PATH: /{apiVersion}/studies/{study}/templates/upload

        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID. (REQUIRED)
        :param inputstream file: File to upload.
        """

        return self._post(category='studies', resource='upload', query_id=study, subcategory='templates', **options)

    def delete_templates(self, study, template_id, **options):
        """
        Delete template.
        PATH: /{apiVersion}/studies/{study}/templates/{templateId}/delete

        :param str template_id: Template id. (REQUIRED)
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        """

        return self._delete(category='studies', resource='delete', query_id=study, subcategory='templates', second_query_id=template_id, **options)

    def update(self, study, data=None, **options):
        """
        Update some study attributes.
        PATH: /{apiVersion}/studies/{study}/update

        :param dict data: JSON containing the params to be updated. (REQUIRED)
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID. (REQUIRED)
        :param str include: Fields included in the response, whole JSON path
            must be provided.
        :param str exclude: Fields excluded in the response, whole JSON path
            must be provided.
        :param bool include_result: Flag indicating to include the created or
            updated document result in the response.
        """

        return self._post(category='studies', resource='update', query_id=study, data=data, **options)

    def variable_sets(self, study, **options):
        """
        Fetch variableSets from a study.
        PATH: /{apiVersion}/studies/{study}/variableSets

        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID. (REQUIRED)
        :param str id: Id of the variableSet to be retrieved. If no id is
            passed, it will show all the variableSets of the study.
        """

        return self._get(category='studies', resource='variableSets', query_id=study, **options)

    def update_variable_sets(self, study, data=None, **options):
        """
        Add or remove a variableSet.
        PATH: /{apiVersion}/studies/{study}/variableSets/update

        :param dict data: JSON containing the VariableSet to be created or
            removed. (REQUIRED)
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID. (REQUIRED)
        :param str action: Action to be performed: ADD, REMOVE or FORCE_REMOVE
            a variableSet. Allowed values: ['ADD REMOVE FORCE_REMOVE']
        """

        return self._post(category='studies', resource='update', query_id=study, subcategory='variableSets', data=data, **options)

    def update_variable_sets_variables(self, study, variable_set, data=None, **options):
        """
        Add or remove variables to a VariableSet.
        PATH: /{apiVersion}/studies/{study}/variableSets/{variableSet}/variables/update

        :param dict data: JSON containing the variable to be added or removed.
            For removing, only the variable id will be needed. (REQUIRED)
        :param str variable_set: VariableSet id of the VariableSet to be
            updated. (REQUIRED)
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID. (REQUIRED)
        :param str action: Action to be performed: ADD or REMOVE a variable.
            Allowed values: ['ADD REMOVE']
        """

        return self._post(category='studies', resource='variables/update', query_id=study, subcategory='variableSets', second_query_id=variable_set, data=data, **options)

