"""
WARNING: AUTOGENERATED CODE

    This code was generated by a tool.
    Autogenerated on: 2022-03-31 10:04:03
    
    Manual changes to this file may cause unexpected behavior in your application.
    Manual changes to this file will be overwritten if the code is regenerated.
"""

from pyopencga.rest_clients._parent_rest_clients import _ParentRestClient


class Meta(_ParentRestClient):
    """
    This class contains methods for the 'Meta' webservices
    Client version: 2.2.1-SNAPSHOT [e7ad366bbb7ce32d29b3d128a06f56e487a0c349]
    PATH: /{apiVersion}/meta
    """

    def __init__(self, configuration, token=None, login_handler=None, *args, **kwargs):
        super(Meta, self).__init__(configuration, token, login_handler, *args, **kwargs)

    def about(self, **options):
        """
        Returns info about current OpenCGA code.
        PATH: /{apiVersion}/meta/about
        """

        return self._get(category='meta', resource='about', **options)

    def api(self, **options):
        """
        API.
        PATH: /{apiVersion}/meta/api

        :param str category: List of categories to get API from.
        """

        return self._get(category='meta', resource='api', **options)

    def fail(self, **options):
        """
        Ping Opencga webservices.
        PATH: /{apiVersion}/meta/fail
        """

        return self._get(category='meta', resource='fail', **options)

    def ping(self, **options):
        """
        Ping Opencga webservices.
        PATH: /{apiVersion}/meta/ping
        """

        return self._get(category='meta', resource='ping', **options)

    def status(self, **options):
        """
        Database status.
        PATH: /{apiVersion}/meta/status
        """

        return self._get(category='meta', resource='status', **options)

