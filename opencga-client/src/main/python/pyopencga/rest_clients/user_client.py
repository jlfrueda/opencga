"""
WARNING: AUTOGENERATED CODE

    This code was generated by a tool.
    Autogenerated on: 2022-09-08 13:18:17
    
    Manual changes to this file may cause unexpected behavior in your application.
    Manual changes to this file will be overwritten if the code is regenerated.
"""

from pyopencga.rest_clients._parent_rest_clients import _ParentRestClient


class User(_ParentRestClient):
    """
    This class contains methods for the 'Users' webservices
    Client version: 2.4.4-SNAPSHOT [a0235fc06a210419356b9009831806910f18c4dd]
    PATH: /{apiVersion}/users
    """

    def __init__(self, configuration, token=None, login_handler=None, *args, **kwargs):
        super(User, self).__init__(configuration, token, login_handler, *args, **kwargs)

    def create(self, data=None, **options):
        """
        Create a new user.
        PATH: /{apiVersion}/users/create

        :param dict data: JSON containing the parameters. (REQUIRED)
        """

        return self._post(category='users', resource='create', data=data, **options)

    def login(self, data=None, **options):
        """
        Get identified and gain access to the system.
        PATH: /{apiVersion}/users/login

        :param dict data: JSON containing the authentication parameters.
        """

        return self._post(category='users', resource='login', data=data, **options)

    def password(self, data=None, **options):
        """
        Change the password of a user.
        PATH: /{apiVersion}/users/password

        :param dict data: JSON containing the change of password parameters.
            (REQUIRED)
        """

        return self._post(category='users', resource='password', data=data, **options)

    def info(self, users, **options):
        """
        Return the user information including its projects and studies.
        PATH: /{apiVersion}/users/{users}/info

        :param str users: Comma separated list of user IDs. (REQUIRED)
        :param str include: Fields included in the response, whole JSON path
            must be provided.
        :param str exclude: Fields excluded in the response, whole JSON path
            must be provided.
        """

        return self._get(category='users', resource='info', query_id=users, **options)

    def configs(self, user, **options):
        """
        Fetch a user configuration.
        PATH: /{apiVersion}/users/{user}/configs

        :param str user: User ID. (REQUIRED)
        :param str name: Unique name (typically the name of the application).
        """

        return self._get(category='users', resource='configs', query_id=user, **options)

    def update_configs(self, user, data=None, **options):
        """
        Add or remove a custom user configuration.
        PATH: /{apiVersion}/users/{user}/configs/update

        :param dict data: JSON containing anything useful for the application
            such as user or default preferences. When removing, only the id
            will be necessary. (REQUIRED)
        :param str user: User ID. (REQUIRED)
        :param str action: Action to be performed: ADD or REMOVE a group.
            Allowed values: ['ADD REMOVE']
        """

        return self._post(category='users', resource='update', query_id=user, subcategory='configs', data=data, **options)

    def filters(self, user, **options):
        """
        Fetch user filters.
        PATH: /{apiVersion}/users/{user}/filters

        :param str user: User ID. (REQUIRED)
        :param str id: Filter id. If provided, it will only fetch the
            specified filter.
        """

        return self._get(category='users', resource='filters', query_id=user, **options)

    def update_filters(self, user, data=None, **options):
        """
        Add or remove a custom user filter.
        PATH: /{apiVersion}/users/{user}/filters/update

        :param dict data: Filter parameters. When removing, only the 'name' of
            the filter will be necessary. (REQUIRED)
        :param str user: User ID. (REQUIRED)
        :param str action: Action to be performed: ADD or REMOVE a group.
            Allowed values: ['ADD REMOVE']
        """

        return self._post(category='users', resource='update', query_id=user, subcategory='filters', data=data, **options)

    def update_filter(self, user, filter_id, data=None, **options):
        """
        Update a custom filter.
        PATH: /{apiVersion}/users/{user}/filters/{filterId}/update

        :param dict data: Filter parameters. (REQUIRED)
        :param str filter_id: Filter id. (REQUIRED)
        :param str user: User ID. (REQUIRED)
        """

        return self._post(category='users', resource='update', query_id=user, subcategory='filters', second_query_id=filter_id, data=data, **options)

    def reset_password(self, user, **options):
        """
        Reset password.
        PATH: /{apiVersion}/users/{user}/password/reset

        :param str user: User ID. (REQUIRED)
        """

        return self._get(category='users', resource='reset', query_id=user, subcategory='password', **options)

    def projects(self, user, **options):
        """
        Retrieve the projects of the user.
        PATH: /{apiVersion}/users/{user}/projects

        :param str user: User ID. (REQUIRED)
        :param str include: Fields included in the response, whole JSON path
            must be provided.
        :param str exclude: Fields excluded in the response, whole JSON path
            must be provided.
        :param int limit: Number of results to be returned.
        :param int skip: Number of results to skip.
        """

        return self._get(category='users', resource='projects', query_id=user, **options)

    def update(self, user, data=None, **options):
        """
        Update some user attributes.
        PATH: /{apiVersion}/users/{user}/update

        :param dict data: JSON containing the params to be updated. (REQUIRED)
        :param str user: User ID. (REQUIRED)
        :param str include: Fields included in the response, whole JSON path
            must be provided.
        :param str exclude: Fields excluded in the response, whole JSON path
            must be provided.
        :param bool include_result: Flag indicating to include the created or
            updated document result in the response.
        """

        return self._post(category='users', resource='update', query_id=user, data=data, **options)

