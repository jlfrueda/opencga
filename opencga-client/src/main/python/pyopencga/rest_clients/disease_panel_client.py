"""
WARNING: AUTOGENERATED CODE

    This code was generated by a tool.
    Autogenerated on: 2022-09-15 16:02:35
    
    Manual changes to this file may cause unexpected behavior in your application.
    Manual changes to this file will be overwritten if the code is regenerated.
"""

from pyopencga.rest_clients._parent_rest_clients import _ParentRestClient


class DiseasePanel(_ParentRestClient):
    """
    This class contains methods for the 'Disease Panels' webservices
    Client version: 2.4.5-SNAPSHOT [d32f9175ff17decdba594f650ff68c535df17adf]
    PATH: /{apiVersion}/panels
    """

    def __init__(self, configuration, token=None, login_handler=None, *args, **kwargs):
        super(DiseasePanel, self).__init__(configuration, token, login_handler, *args, **kwargs)

    def update_acl(self, members, action, data=None, **options):
        """
        Update the set of permissions granted for the member.
        PATH: /{apiVersion}/panels/acl/{members}/update

        :param dict data: JSON containing the parameters to update the
            permissions. (REQUIRED)
        :param str action: Action to be performed [ADD, SET, REMOVE or RESET].
            Allowed values: ['SET ADD REMOVE RESET'] (REQUIRED)
        :param str members: Comma separated list of user or group ids.
            (REQUIRED)
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        """

        options['action'] = action
        return self._post(category='panels', resource='update', subcategory='acl', second_query_id=members, data=data, **options)

    def create(self, data=None, **options):
        """
        Create a panel.
        PATH: /{apiVersion}/panels/create

        :param str include: Fields included in the response, whole JSON path
            must be provided.
        :param str exclude: Fields excluded in the response, whole JSON path
            must be provided.
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param bool include_result: Flag indicating to include the created or
            updated document result in the response.
        :param dict data: Panel parameters.
        """

        return self._post(category='panels', resource='create', data=data, **options)

    def distinct(self, field, **options):
        """
        Panel distinct method.
        PATH: /{apiVersion}/panels/distinct

        :param str field: Field for which to obtain the distinct values.
            (REQUIRED)
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param str id: Comma separated list of panel IDs  up to a maximum of
            100.
        :param str uuid: Comma separated list of panel UUIDs  up to a maximum
            of 100.
        :param str name: Comma separated list of panel names  up to a maximum
            of 100.
        :param str internal_status: Filter by internal status.
        :param str disorders: Comma separated list of disorder ids or names.
        :param str variants: Comma separated list of variant ids.
        :param str genes: Comma separated list of gene ids.
        :param str source: Comma separated list of source ids or names.
        :param str regions: Comma separated list of regions.
        :param str categories: Comma separated list of category names.
        :param str tags: Panel tags.
        :param bool deleted: Boolean to retrieve deleted entries.
        :param str status: Filter by status.
        :param str creation_date: Creation date. Format: yyyyMMddHHmmss.
            Examples: >2018, 2017-2018, <201805.
        :param str modification_date: Modification date. Format:
            yyyyMMddHHmmss. Examples: >2018, 2017-2018, <201805.
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
        return self._get(category='panels', resource='distinct', **options)

    def import_panels(self, data=None, **options):
        """
        Import panels.
        PATH: /{apiVersion}/panels/import

        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param str job_id: Job ID. It must be a unique string within the
            study. An ID will be autogenerated automatically if not provided.
        :param str job_depends_on: Comma separated list of existing job IDs
            the job will depend on.
        :param str job_description: Job description.
        :param str job_tags: Job tags.
        :param dict data: Panel parameters.
        """

        return self._post(category='panels', resource='import', data=data, **options)

    def search(self, **options):
        """
        Panel search.
        PATH: /{apiVersion}/panels/search

        :param str include: Fields included in the response, whole JSON path
            must be provided.
        :param str exclude: Fields excluded in the response, whole JSON path
            must be provided.
        :param int limit: Number of results to be returned.
        :param int skip: Number of results to skip.
        :param bool count: Get the total number of results matching the query.
            Deactivated by default.
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param str id: Comma separated list of panel IDs  up to a maximum of
            100.
        :param str uuid: Comma separated list of panel UUIDs  up to a maximum
            of 100.
        :param str name: Comma separated list of panel names  up to a maximum
            of 100.
        :param str internal_status: Filter by internal status.
        :param str disorders: Comma separated list of disorder ids or names.
        :param str variants: Comma separated list of variant ids.
        :param str genes: Comma separated list of gene ids.
        :param str source: Comma separated list of source ids or names.
        :param str regions: Comma separated list of regions.
        :param str categories: Comma separated list of category names.
        :param str tags: Panel tags.
        :param bool deleted: Boolean to retrieve deleted entries.
        :param str status: Filter by status.
        :param str creation_date: Creation date. Format: yyyyMMddHHmmss.
            Examples: >2018, 2017-2018, <201805.
        :param str modification_date: Modification date. Format:
            yyyyMMddHHmmss. Examples: >2018, 2017-2018, <201805.
        :param str acl: Filter entries for which a user has the provided
            permissions. Format: acl={user}:{permissions}. Example:
            acl=john:WRITE,WRITE_ANNOTATIONS will return all entries for which
            user john has both WRITE and WRITE_ANNOTATIONS permissions. Only
            study owners or administrators can query by this field. .
        :param str release: Release when it was created.
        :param int snapshot: Snapshot value (Latest version of the entry in
            the specified release).
        """

        return self._get(category='panels', resource='search', **options)

    def acl(self, panels, **options):
        """
        Returns the acl of the panels. If member is provided, it will only
            return the acl for the member.
        PATH: /{apiVersion}/panels/{panels}/acl

        :param str panels: Comma separated list of panel IDs up to a maximum
            of 100. (REQUIRED)
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param str member: User or group id.
        :param bool silent: Boolean to retrieve all possible entries that are
            queried for, false to raise an exception whenever one of the
            entries looked for cannot be shown for whichever reason.
        """

        return self._get(category='panels', resource='acl', query_id=panels, **options)

    def delete(self, panels, **options):
        """
        Delete existing panels.
        PATH: /{apiVersion}/panels/{panels}/delete

        :param str panels: Comma separated list of panel ids. (REQUIRED)
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        """

        return self._delete(category='panels', resource='delete', query_id=panels, **options)

    def info(self, panels, **options):
        """
        Panel info.
        PATH: /{apiVersion}/panels/{panels}/info

        :param str panels: Comma separated list of panel IDs up to a maximum
            of 100. (REQUIRED)
        :param str include: Fields included in the response, whole JSON path
            must be provided.
        :param str exclude: Fields excluded in the response, whole JSON path
            must be provided.
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param str version: Comma separated list of panel versions. 'all' to
            get all the panel versions. Not supported if multiple panel ids are
            provided.
        :param bool deleted: Boolean to retrieve deleted panels.
        """

        return self._get(category='panels', resource='info', query_id=panels, **options)

    def update(self, panels, data=None, **options):
        """
        Update panel attributes.
        PATH: /{apiVersion}/panels/{panels}/update

        :param str panels: Comma separated list of panel ids. (REQUIRED)
        :param str include: Fields included in the response, whole JSON path
            must be provided.
        :param str exclude: Fields excluded in the response, whole JSON path
            must be provided.
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param bool include_result: Flag indicating to include the created or
            updated document result in the response.
        :param dict data: Panel parameters.
        """

        return self._post(category='panels', resource='update', query_id=panels, data=data, **options)

