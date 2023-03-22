"""
WARNING: AUTOGENERATED CODE

    This code was generated by a tool.
    Autogenerated on: 2023-03-21
    
    Manual changes to this file may cause unexpected behavior in your application.
    Manual changes to this file will be overwritten if the code is regenerated.
"""

from pyopencga.rest_clients._parent_rest_clients import _ParentRestClient


class Job(_ParentRestClient):
    """
    This class contains methods for the 'Jobs' webservices
    Client version: 2.8.0-SNAPSHOT
    PATH: /{apiVersion}/jobs
    """

    def __init__(self, configuration, token=None, login_handler=None, *args, **kwargs):
        super(Job, self).__init__(configuration, token, login_handler, *args, **kwargs)

    def update_acl(self, members, action, data=None, **options):
        """
        Update the set of permissions granted for the member.
        PATH: /{apiVersion}/jobs/acl/{members}/update

        :param dict data: JSON containing the parameters to add ACLs.
            (REQUIRED)
        :param str action: Action to be performed [ADD, SET, REMOVE or RESET].
            Allowed values: ['SET ADD REMOVE RESET'] (REQUIRED)
        :param str members: Comma separated list of user or group ids.
            (REQUIRED)
        """

        options['action'] = action
        return self._post(category='jobs', resource='update', subcategory='acl', second_query_id=members, data=data, **options)

    def aggregation_stats(self, **options):
        """
        Fetch catalog job stats.
        PATH: /{apiVersion}/jobs/aggregationStats

        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param str tool_id: Tool id.
        :param str tool_scope: Tool scope.
        :param str tool_type: Tool type.
        :param str tool_resource: Tool resource.
        :param str user_id: User id.
        :param str priority: Priority.
        :param str tags: Tags.
        :param str executor_id: Executor id.
        :param str executor_framework: Executor framework.
        :param str creation_year: Creation year.
        :param str creation_month: Creation month (JANUARY, FEBRUARY...).
        :param str creation_day: Creation day.
        :param str creation_day_of_week: Creation day of week (MONDAY,
            TUESDAY...).
        :param str status: Status.
        :param str release: Release.
        :param bool default: Calculate default stats.
        :param str field: List of fields separated by semicolons, e.g.:
            studies;type. For nested fields use >>, e.g.:
            studies>>biotype;type;numSamples[0..10]:1.
        """

        return self._get(category='jobs', resource='aggregationStats', **options)

    def create(self, data=None, **options):
        """
        Register an executed job with POST method.
        PATH: /{apiVersion}/jobs/create

        :param dict data: job. (REQUIRED)
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        """

        return self._post(category='jobs', resource='create', data=data, **options)

    def distinct(self, field, **options):
        """
        Job distinct method.
        PATH: /{apiVersion}/jobs/distinct

        :param str field: Comma separated list of fields for which to obtain
            the distinct values. (REQUIRED)
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param bool other_studies: Flag indicating the entries being queried
            can belong to any related study, not just the primary one.
        :param str id: Comma separated list of job IDs up to a maximum of 100.
        :param str uuid: Comma separated list of job UUIDs up to a maximum of
            100.
        :param str tool_id: Tool ID executed by the job.
        :param str tool_type: Tool type executed by the job [OPERATION,
            ANALYSIS].
        :param str user_id: User that created the job.
        :param str priority: Priority of the job.
        :param str status: Filter by status.
        :param str internal_status: Filter by internal status.
        :param str creation_date: Creation date. Format: yyyyMMddHHmmss.
            Examples: >2018, 2017-2018, <201805.
        :param str modification_date: Modification date. Format:
            yyyyMMddHHmmss. Examples: >2018, 2017-2018, <201805.
        :param bool visited: Visited status of job.
        :param str tags: Job tags.
        :param str input: Comma separated list of file IDs used as input.
        :param str output: Comma separated list of file IDs used as output.
        :param str acl: Filter entries for which a user has the provided
            permissions. Format: acl={user}:{permissions}. Example:
            acl=john:WRITE,WRITE_ANNOTATIONS will return all entries for which
            user john has both WRITE and WRITE_ANNOTATIONS permissions. Only
            study owners or administrators can query by this field. .
        :param str release: Release when it was created.
        :param bool deleted: Boolean to retrieve deleted entries.
        """

        options['field'] = field
        return self._get(category='jobs', resource='distinct', **options)

    def retry(self, data=None, **options):
        """
        Relaunch a failed job.
        PATH: /{apiVersion}/jobs/retry

        :param dict data: job. (REQUIRED)
        :param str job_id: Job ID. It must be a unique string within the
            study. An ID will be autogenerated automatically if not provided.
        :param str job_description: Job description.
        :param str job_depends_on: Comma separated list of existing job IDs
            the job will depend on.
        :param str job_tags: Job tags.
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        """

        return self._post(category='jobs', resource='retry', data=data, **options)

    def search(self, **options):
        """
        Job search method.
        PATH: /{apiVersion}/jobs/search

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
        :param bool other_studies: Flag indicating the entries being queried
            can belong to any related study, not just the primary one.
        :param str id: Comma separated list of job IDs up to a maximum of 100.
        :param str uuid: Comma separated list of job UUIDs up to a maximum of
            100.
        :param str tool_id: Tool ID executed by the job.
        :param str tool_type: Tool type executed by the job [OPERATION,
            ANALYSIS].
        :param str user_id: User that created the job.
        :param str priority: Priority of the job.
        :param str status: Filter by status.
        :param str internal_status: Filter by internal status.
        :param str creation_date: Creation date. Format: yyyyMMddHHmmss.
            Examples: >2018, 2017-2018, <201805.
        :param str modification_date: Modification date. Format:
            yyyyMMddHHmmss. Examples: >2018, 2017-2018, <201805.
        :param bool visited: Visited status of job.
        :param str tags: Job tags.
        :param str input: Comma separated list of file IDs used as input.
        :param str output: Comma separated list of file IDs used as output.
        :param str acl: Filter entries for which a user has the provided
            permissions. Format: acl={user}:{permissions}. Example:
            acl=john:WRITE,WRITE_ANNOTATIONS will return all entries for which
            user john has both WRITE and WRITE_ANNOTATIONS permissions. Only
            study owners or administrators can query by this field. .
        :param str release: Release when it was created.
        :param bool deleted: Boolean to retrieve deleted entries.
        """

        return self._get(category='jobs', resource='search', **options)

    def top(self, **options):
        """
        Provide a summary of the running jobs.
        PATH: /{apiVersion}/jobs/top

        :param int limit: Maximum number of jobs to be returned.
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param str internal_status: Filter by internal status.
        :param str priority: Priority of the job.
        :param str user_id: User that created the job.
        :param str tool_id: Tool ID executed by the job.
        """

        return self._get(category='jobs', resource='top', **options)

    def acl(self, jobs, **options):
        """
        Return the acl of the job. If member is provided, it will only return
            the acl for the member.
        PATH: /{apiVersion}/jobs/{jobs}/acl

        :param str jobs: Comma separated list of job IDs or UUIDs up to a
            maximum of 100. (REQUIRED)
        :param str member: User or group id.
        :param bool silent: Boolean to retrieve all possible entries that are
            queried for, false to raise an exception whenever one of the
            entries looked for cannot be shown for whichever reason.
        """

        return self._get(category='jobs', resource='acl', query_id=jobs, **options)

    def delete(self, jobs, **options):
        """
        Delete existing jobs.
        PATH: /{apiVersion}/jobs/{jobs}/delete

        :param str jobs: Comma separated list of job ids. (REQUIRED)
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        """

        return self._delete(category='jobs', resource='delete', query_id=jobs, **options)

    def info(self, jobs, **options):
        """
        Get job information.
        PATH: /{apiVersion}/jobs/{jobs}/info

        :param str jobs: Comma separated list of job IDs or UUIDs up to a
            maximum of 100. (REQUIRED)
        :param str include: Fields included in the response, whole JSON path
            must be provided.
        :param str exclude: Fields excluded in the response, whole JSON path
            must be provided.
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param bool deleted: Boolean to retrieve deleted jobs.
        """

        return self._get(category='jobs', resource='info', query_id=jobs, **options)

    def update(self, jobs, data=None, **options):
        """
        Update some job attributes.
        PATH: /{apiVersion}/jobs/{jobs}/update

        :param str jobs: Comma separated list of job IDs or UUIDs up to a
            maximum of 100. (REQUIRED)
        :param str include: Fields included in the response, whole JSON path
            must be provided.
        :param str exclude: Fields excluded in the response, whole JSON path
            must be provided.
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param bool include_result: Flag indicating to include the created or
            updated document result in the response.
        :param dict data: body.
        """

        return self._post(category='jobs', resource='update', query_id=jobs, data=data, **options)

    def head_log(self, job, **options):
        """
        Show the first lines of a log file (up to a limit).
        PATH: /{apiVersion}/jobs/{job}/log/head

        :param str job: Job ID or UUID. (REQUIRED)
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param int offset: Starting byte from which the file will be read.
        :param int lines: Maximum number of lines to be returned up to a
            maximum of 1000.
        :param str type: Log file to be shown (stdout or stderr).
        """

        return self._get(category='jobs', resource='head', query_id=job, subcategory='log', **options)

    def tail_log(self, job, **options):
        """
        Show the last lines of a log file (up to a limit).
        PATH: /{apiVersion}/jobs/{job}/log/tail

        :param str job: Job ID or UUID. (REQUIRED)
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param int lines: Maximum number of lines to be returned up to a
            maximum of 1000.
        :param str type: Log file to be shown (stdout or stderr).
        """

        return self._get(category='jobs', resource='tail', query_id=job, subcategory='log', **options)

