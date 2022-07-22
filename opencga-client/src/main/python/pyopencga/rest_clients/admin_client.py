"""
WARNING: AUTOGENERATED CODE

    This code was generated by a tool.
<<<<<<< HEAD
    Autogenerated on: 2022-06-21 13:26:41
=======
    Autogenerated on: 2022-07-13 11:13:18
>>>>>>> release-2.2.x
    
    Manual changes to this file may cause unexpected behavior in your application.
    Manual changes to this file will be overwritten if the code is regenerated.
"""

from pyopencga.rest_clients._parent_rest_clients import _ParentRestClient


class Admin(_ParentRestClient):
    """
    This class contains methods for the 'Admin' webservices
<<<<<<< HEAD
    Client version: 2.3.1-SNAPSHOT [7a1ea0dda5a9cbac3691ef8eb5c1e9e39d1047b2]
=======
    Client version: 2.2.4-SNAPSHOT [a5b6f4334f26b4e2e2d8b2843830c3b8f1b5b6e8]
>>>>>>> release-2.2.x
    PATH: /{apiVersion}/admin
    """

    def __init__(self, configuration, token=None, login_handler=None, *args, **kwargs):
        super(Admin, self).__init__(configuration, token, login_handler, *args, **kwargs)

    def group_by_audit(self, fields, entity, **options):
        """
        Group by operation.
        PATH: /{apiVersion}/admin/audit/groupBy

        :param str entity: Entity to be grouped by. (REQUIRED)
        :param str fields: Comma separated list of fields by which to group
            by. (REQUIRED)
        :param bool count: Count the number of elements matching the group.
        :param int limit: Maximum number of documents (groups) to be returned.
        :param str action: Action performed.
        :param str before: Object before update.
        :param str after: Object after update.
        :param str date: Date <,<=,>,>=(Format: yyyyMMddHHmmss) and
            yyyyMMddHHmmss-yyyyMMddHHmmss.
        """

        options['fields'] = fields
        options['entity'] = entity
        return self._get(category='admin', resource='groupBy', subcategory='audit', **options)

    def index_stats_catalog(self, **options):
        """
        Sync Catalog into the Solr.
        PATH: /{apiVersion}/admin/catalog/indexStats

        :param str collection: Collection to be indexed (file, sample,
            individual, family, cohort and/or job). If not provided, all of
            them will be indexed.
        """

        return self._post(category='admin', resource='indexStats', subcategory='catalog', **options)

    def install_catalog(self, data=None, **options):
        """
        Install OpenCGA database.
        PATH: /{apiVersion}/admin/catalog/install

        :param dict data: JSON containing the mandatory parameters. (REQUIRED)
        """

        return self._post(category='admin', resource='install', subcategory='catalog', data=data, **options)

    def jwt_catalog(self, data=None, **options):
        """
        Change JWT secret key.
        PATH: /{apiVersion}/admin/catalog/jwt

        :param dict data: JSON containing the parameters. (REQUIRED)
        """

        return self._post(category='admin', resource='jwt', subcategory='catalog', data=data, **options)

    def create_users(self, data=None, **options):
        """
        Create a new user.
        PATH: /{apiVersion}/admin/users/create

        :param dict data: JSON containing the parameters. (REQUIRED)
        """

        return self._post(category='admin', resource='create', subcategory='users', data=data, **options)

    def import_users(self, data=None, **options):
        """
        Import users or a group of users from LDAP or AAD.
        PATH: /{apiVersion}/admin/users/import

        :param dict data: JSON containing the parameters. (REQUIRED)
        """

        return self._post(category='admin', resource='import', subcategory='users', data=data, **options)

    def search_users(self, **options):
        """
        User search method.
        PATH: /{apiVersion}/admin/users/search

        :param str include: Fields included in the response, whole JSON path
            must be provided.
        :param str exclude: Fields excluded in the response, whole JSON path
            must be provided.
        :param int limit: Number of results to be returned.
        :param int skip: Number of results to skip.
        :param bool count: Get the total number of results matching the query.
            Deactivated by default.
        :param str user: User ID.
        :param str account: Account type [GUEST, FULL, ADMINISTRATOR].
        :param str authentication_id: Authentication origin ID.
        """

        return self._get(category='admin', resource='search', subcategory='users', **options)

    def sync_users(self, data=None, **options):
        """
        Synchronise a group of users from an authentication origin with a
            group in a study from catalog.
        PATH: /{apiVersion}/admin/users/sync

        :param dict data: JSON containing the parameters. (REQUIRED)
        """

        return self._post(category='admin', resource='sync', subcategory='users', data=data, **options)

