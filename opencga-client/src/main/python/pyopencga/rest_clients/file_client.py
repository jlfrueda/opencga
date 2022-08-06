"""
WARNING: AUTOGENERATED CODE

    This code was generated by a tool.
    Autogenerated on: 2022-08-06 18:42:58
    
    Manual changes to this file may cause unexpected behavior in your application.
    Manual changes to this file will be overwritten if the code is regenerated.
"""

from pyopencga.rest_clients._parent_rest_clients import _ParentRestClient


class File(_ParentRestClient):
    """
    This class contains methods for the 'Files' webservices
    Client version: 2.4.3-SNAPSHOT [4765ba9e7d10df8d165cac8a1649b2d0d433b617]
    PATH: /{apiVersion}/files
    """

    def __init__(self, configuration, token=None, login_handler=None, *args, **kwargs):
        super(File, self).__init__(configuration, token, login_handler, *args, **kwargs)

    def update_acl(self, members, action, data=None, **options):
        """
        Update the set of permissions granted for the member.
        PATH: /{apiVersion}/files/acl/{members}/update

        :param dict data: JSON containing the parameters to add ACLs.
            (REQUIRED)
        :param str action: Action to be performed [ADD, SET, REMOVE or RESET].
            Allowed values: ['SET ADD REMOVE RESET'] (REQUIRED)
        :param str members: Comma separated list of user or group ids.
            (REQUIRED)
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        """

        options['action'] = action
        return self._post(category='files', resource='update', subcategory='acl', second_query_id=members, data=data, **options)

    def aggregation_stats(self, **options):
        """
        Fetch catalog file stats.
        PATH: /{apiVersion}/files/aggregationStats

        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param str name: Name.
        :param str type: Type.
        :param str format: Format.
        :param str bioformat: Bioformat.
        :param str creation_year: Creation year.
        :param str creation_month: Creation month (JANUARY, FEBRUARY...).
        :param str creation_day: Creation day.
        :param str creation_day_of_week: Creation day of week (MONDAY,
            TUESDAY...).
        :param str status: Status.
        :param str release: Release.
        :param bool external: External.
        :param str size: Size.
        :param str software: Software.
        :param str experiment: Experiment.
        :param str num_samples: Number of samples.
        :param str num_related_files: Number of related files.
        :param str annotation: Annotation filters. Example:
            age>30;gender=FEMALE. For more information, please visit
            http://docs.opencb.org/display/opencga/AnnotationSets+1.4.0.
        :param bool default: Calculate default stats.
        :param str field: List of fields separated by semicolons, e.g.:
            studies;type. For nested fields use >>, e.g.:
            studies>>biotype;type;numSamples[0..10]:1.
        """

        return self._get(category='files', resource='aggregationStats', **options)

    def load_annotation_sets(self, variable_set_id, path, data=None, **options):
        """
        Load annotation sets from a TSV file.
        PATH: /{apiVersion}/files/annotationSets/load

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
        return self._post(category='files', resource='load', subcategory='annotationSets', data=data, **options)

    def bioformats(self, **options):
        """
        List of accepted file bioformats.
        PATH: /{apiVersion}/files/bioformats
        """

        return self._get(category='files', resource='bioformats', **options)

    def create(self, data=None, **options):
        """
        Create file or folder.
        PATH: /{apiVersion}/files/create

        :param dict data: File parameters. (REQUIRED)
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param bool parents: Create the parent directories if they do not
            exist.
        """

        return self._post(category='files', resource='create', data=data, **options)

    def distinct(self, field, **options):
        """
        File distinct method.
        PATH: /{apiVersion}/files/distinct

        :param str field: Field for which to obtain the distinct values.
            (REQUIRED)
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param str id: Comma separated list of file IDs up to a maximum of
            100.
        :param str uuid: Comma separated list file UUIDs up to a maximum of
            100.
        :param str name: Comma separated list of file names.
        :param str path: Comma separated list of paths.
        :param str uri: Comma separated list of uris.
        :param str type: File type, either FILE or DIRECTORY.
        :param str bioformat: Comma separated Bioformat values. For existing
            Bioformats see files/bioformats.
        :param str format: Comma separated Format values. For existing Formats
            see files/formats.
        :param bool external: Boolean field indicating whether to filter by
            external or non external files.
        :param str status: Filter by status.
        :param str internal_status: Filter by internal status.
        :param str internal_variant_index_status: Filter by internal variant
            index status.
        :param str software_name: Software name.
        :param str directory: Directory under which we want to look for files
            or folders.
        :param str creation_date: Creation date. Format: yyyyMMddHHmmss.
            Examples: >2018, 2017-2018, <201805.
        :param str modification_date: Modification date. Format:
            yyyyMMddHHmmss. Examples: >2018, 2017-2018, <201805.
        :param str description: Description.
        :param str tags: Tags.
        :param str size: File size.
        :param str sample_ids: Comma separated list sample IDs or UUIDs up to
            a maximum of 100.
        :param str job_id: Job ID that created the file(s) or folder(s).
        :param str annotation: Annotation filters. Example:
            age>30;gender=FEMALE. For more information, please visit
            http://docs.opencb.org/display/opencga/AnnotationSets+1.4.0.
        :param str acl: Filter entries for which a user has the provided
            permissions. Format: acl={user}:{permissions}. Example:
            acl=john:WRITE,WRITE_ANNOTATIONS will return all entries for which
            user john has both WRITE and WRITE_ANNOTATIONS permissions. Only
            study owners or administrators can query by this field. .
        :param bool deleted: Boolean to retrieve deleted entries.
        :param str release: Release when it was created.
        """

        options['field'] = field
        return self._get(category='files', resource='distinct', **options)

    def fetch(self, data=None, **options):
        """
        Download an external file to catalog and register it.
        PATH: /{apiVersion}/files/fetch

        :param dict data: Fetch parameters. (REQUIRED)
        :param str job_id: Job ID. It must be a unique string within the
            study. An ID will be autogenerated automatically if not provided.
        :param str job_description: Job description.
        :param str job_depends_on: Comma separated list of existing job IDs
            the job will depend on.
        :param str job_tags: Job tags.
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        """

        return self._post(category='files', resource='fetch', data=data, **options)

    def formats(self, **options):
        """
        List of accepted file formats.
        PATH: /{apiVersion}/files/formats
        """

        return self._get(category='files', resource='formats', **options)

    def link(self, data=None, **options):
        """
        Link an external file into catalog.
        PATH: /{apiVersion}/files/link

        :param dict data: File parameters. (REQUIRED)
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param bool parents: Create the parent directories if they do not
            exist.
        """

        return self._post(category='files', resource='link', data=data, **options)

    def run_link(self, data=None, **options):
        """
        Link an external file into catalog asynchronously.
        PATH: /{apiVersion}/files/link/run

        :param dict data: File parameters. (REQUIRED)
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param str job_id: Job ID. It must be a unique string within the
            study. An ID will be autogenerated automatically if not provided.
        :param str job_depends_on: Comma separated list of existing job IDs
            the job will depend on.
        :param str job_description: Job description.
        :param str job_tags: Job tags.
        """

        return self._post(category='files', resource='run', subcategory='link', data=data, **options)

    def run_postlink(self, data=None, **options):
        """
        Associate non-registered samples for files with high volumes of
            samples.
        PATH: /{apiVersion}/files/postlink/run

        :param dict data: File parameters. (REQUIRED)
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param str job_id: Job ID. It must be a unique string within the
            study. An ID will be autogenerated automatically if not provided.
        :param str job_depends_on: Comma separated list of existing job IDs
            the job will depend on.
        :param str job_description: Job description.
        :param str job_tags: Job tags.
        """

        return self._post(category='files', resource='run', subcategory='postlink', data=data, **options)

    def search(self, **options):
        """
        File search method.
        PATH: /{apiVersion}/files/search

        :param str include: Fields included in the response, whole JSON path
            must be provided.
        :param str exclude: Fields excluded in the response, whole JSON path
            must be provided.
        :param int limit: Number of results to be returned.
        :param int skip: Number of results to skip.
        :param bool count: Get the total number of results matching the query.
            Deactivated by default.
        :param bool flatten_annotations: Boolean indicating to flatten the
            annotations.
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param str id: Comma separated list of file IDs up to a maximum of
            100.
        :param str uuid: Comma separated list file UUIDs up to a maximum of
            100.
        :param str name: Comma separated list of file names.
        :param str path: Comma separated list of paths.
        :param str uri: Comma separated list of uris.
        :param str type: File type, either FILE or DIRECTORY.
        :param str bioformat: Comma separated Bioformat values. For existing
            Bioformats see files/bioformats.
        :param str format: Comma separated Format values. For existing Formats
            see files/formats.
        :param bool external: Boolean field indicating whether to filter by
            external or non external files.
        :param str status: Filter by status.
        :param str internal_status: Filter by internal status.
        :param str internal_variant_index_status: Filter by internal variant
            index status.
        :param str software_name: Software name.
        :param str directory: Directory under which we want to look for files
            or folders.
        :param str creation_date: Creation date. Format: yyyyMMddHHmmss.
            Examples: >2018, 2017-2018, <201805.
        :param str modification_date: Modification date. Format:
            yyyyMMddHHmmss. Examples: >2018, 2017-2018, <201805.
        :param str description: Description.
        :param str tags: Tags.
        :param str size: File size.
        :param str sample_ids: Comma separated list sample IDs or UUIDs up to
            a maximum of 100.
        :param str job_id: Job ID that created the file(s) or folder(s).
        :param str annotation: Annotation filters. Example:
            age>30;gender=FEMALE. For more information, please visit
            http://docs.opencb.org/display/opencga/AnnotationSets+1.4.0.
        :param str acl: Filter entries for which a user has the provided
            permissions. Format: acl={user}:{permissions}. Example:
            acl=john:WRITE,WRITE_ANNOTATIONS will return all entries for which
            user john has both WRITE and WRITE_ANNOTATIONS permissions. Only
            study owners or administrators can query by this field. .
        :param bool deleted: Boolean to retrieve deleted entries.
        :param str release: Release when it was created.
        """

        return self._get(category='files', resource='search', **options)

    def upload(self, **options):
        """
        Resource to upload a file by chunks.
        PATH: /{apiVersion}/files/upload

        :param inputstream file: File to upload.
        :param str filename: File name to overwrite the input fileName.
        :param str file_format: File format. Allowed values: ['VCF BCF GVCF
            TBI BIGWIG SAM BAM BAI CRAM CRAI FASTQ FASTA PED
            TAB_SEPARATED_VALUES COMMA_SEPARATED_VALUES XML PROTOCOL_BUFFER
            JSON AVRO PARQUET IMAGE PLAIN BINARY NONE UNKNOWN']
        :param str bioformat: File bioformat. Allowed values:
            ['MICROARRAY_EXPRESSION_ONECHANNEL_AGILENT
            MICROARRAY_EXPRESSION_ONECHANNEL_AFFYMETRIX
            MICROARRAY_EXPRESSION_ONECHANNEL_GENEPIX
            MICROARRAY_EXPRESSION_TWOCHANNELS_AGILENT
            MICROARRAY_EXPRESSION_TWOCHANNELS_GENEPIX DATAMATRIX_EXPRESSION
            IDLIST IDLIST_RANKED ANNOTATION_GENEVSANNOTATION OTHER_NEWICK
            OTHER_BLAST OTHER_INTERACTION OTHER_GENOTYPE OTHER_PLINK OTHER_VCF
            OTHER_PED VCF4 VARIANT ALIGNMENT COVERAGE SEQUENCE PEDIGREE
            REFERENCE_GENOME NONE UNKNOWN']
        :param str checksum: Expected MD5 file checksum.
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param str relative_file_path: Path within catalog where the file will
            be located (default: root folder).
        :param str description: description.
        :param bool parents: Create the parent directories if they do not
            exist.
        """

        return self._post(category='files', resource='upload', **options)

    def acl(self, files, **options):
        """
        Return the acl defined for the file or folder. If member is provided,
            it will only return the acl for the member.
        PATH: /{apiVersion}/files/{files}/acl

        :param str files: Comma separated list of file IDs or names up to a
            maximum of 100. (REQUIRED)
        :param str study: Comma separated list of Studies
            [[user@]project:]study where study and project can be either the ID
            or UUID up to a maximum of 100.
        :param str member: User or group id.
        :param bool silent: Boolean to retrieve all possible entries that are
            queried for, false to raise an exception whenever one of the
            entries looked for cannot be shown for whichever reason.
        """

        return self._get(category='files', resource='acl', query_id=files, **options)

    def delete(self, files, **options):
        """
        Delete existing files and folders.
        PATH: /{apiVersion}/files/{files}/delete

        :param str files: Comma separated list of file ids, names or paths.
            (REQUIRED)
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param bool skip_trash: Skip trash and delete the files/folders from
            disk directly (CANNOT BE RECOVERED).
        """

        return self._delete(category='files', resource='delete', query_id=files, **options)

    def info(self, files, **options):
        """
        File info.
        PATH: /{apiVersion}/files/{files}/info

        :param str files: Comma separated list of file IDs or names up to a
            maximum of 100. (REQUIRED)
        :param str include: Fields included in the response, whole JSON path
            must be provided.
        :param str exclude: Fields excluded in the response, whole JSON path
            must be provided.
        :param bool flatten_annotations: Flatten the annotations?.
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param bool deleted: Boolean to retrieve deleted files.
        """

        return self._get(category='files', resource='info', query_id=files, **options)

    def unlink(self, files, **options):
        """
        Unlink linked files and folders.
        PATH: /{apiVersion}/files/{files}/unlink

        :param str files: Comma separated list of file ids, names or paths.
            (REQUIRED)
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        """

        return self._delete(category='files', resource='unlink', query_id=files, **options)

    def update(self, files, data=None, **options):
        """
        Update some file attributes.
        PATH: /{apiVersion}/files/{files}/update

        :param dict data: Parameters to modify. (REQUIRED)
        :param str files: Comma separated list of file ids, names or paths.
            Paths must be separated by : instead of /. (REQUIRED)
        :param str include: Fields included in the response, whole JSON path
            must be provided.
        :param str exclude: Fields excluded in the response, whole JSON path
            must be provided.
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param str sample_ids_action: Action to be performed if the array of
            samples is being updated. Allowed values: ['ADD SET REMOVE']
        :param str annotation_sets_action: Action to be performed if the array
            of annotationSets is being updated. Allowed values: ['ADD SET
            REMOVE']
        :param str related_files_action: Action to be performed if the array
            of relatedFiles is being updated. Allowed values: ['ADD SET
            REMOVE']
        :param str tags_action: Action to be performed if the array of tags is
            being updated. Allowed values: ['ADD SET REMOVE']
        """

        return self._post(category='files', resource='update', query_id=files, data=data, **options)

    def update_annotation_sets_annotations(self, file, annotation_set, data=None, **options):
        """
        Update annotations from an annotationSet.
        PATH: /{apiVersion}/files/{file}/annotationSets/{annotationSet}/annotations/update

        :param str annotation_set: AnnotationSet ID to be updated. (REQUIRED)
        :param str file: File id, name or path. Paths must be separated by :
            instead of /. (REQUIRED)
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

        return self._post(category='files', resource='annotations/update', query_id=file, subcategory='annotationSets', second_query_id=annotation_set, data=data, **options)

    def download(self, file, **options):
        """
        Download file.
        PATH: /{apiVersion}/files/{file}/download

        :param str file: File id, name or path. Paths must be separated by :
            instead of /. (REQUIRED)
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        """

        return self._get(category='files', resource='download', query_id=file, **options)

    def grep(self, file, **options):
        """
        Filter lines of the file containing the pattern.
        PATH: /{apiVersion}/files/{file}/grep

        :param str file: File uuid, id, or name. (REQUIRED)
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param str pattern: String pattern.
        :param bool ignore_case: Flag to perform a case insensitive search.
        :param int max_count: Stop reading a file after 'n' matching lines. 0
            means no limit.
        """

        return self._get(category='files', resource='grep', query_id=file, **options)

    def head(self, file, **options):
        """
        Show the first lines of a file (up to a limit).
        PATH: /{apiVersion}/files/{file}/head

        :param str file: File uuid, id, or name. (REQUIRED)
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param int offset: Starting byte from which the file will be read.
        :param int lines: Maximum number of lines to be returned up to a
            maximum of 1000.
        """

        return self._get(category='files', resource='head', query_id=file, **options)

    def image(self, file, **options):
        """
        Obtain the base64 content of an image.
        PATH: /{apiVersion}/files/{file}/image

        :param str file: File ID. (REQUIRED)
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        """

        return self._get(category='files', resource='image', query_id=file, **options)

    def refresh(self, file, **options):
        """
        Refresh metadata from the selected file or folder. Return updated
            files.
        PATH: /{apiVersion}/files/{file}/refresh

        :param str file: File id, name or path. Paths must be separated by :
            instead of /. (REQUIRED)
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        """

        return self._get(category='files', resource='refresh', query_id=file, **options)

    def tail(self, file, **options):
        """
        Show the last lines of a file (up to a limit).
        PATH: /{apiVersion}/files/{file}/tail

        :param str file: File uuid, id, or name. (REQUIRED)
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param int lines: Maximum number of lines to be returned up to a
            maximum of 1000.
        """

        return self._get(category='files', resource='tail', query_id=file, **options)

    def list(self, folder, **options):
        """
        List all the files inside the folder.
        PATH: /{apiVersion}/files/{folder}/list

        :param str folder: Folder ID, name or path. (REQUIRED)
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
        """

        return self._get(category='files', resource='list', query_id=folder, **options)

    def tree(self, folder, **options):
        """
        Obtain a tree view of the files and folders within a folder.
        PATH: /{apiVersion}/files/{folder}/tree

        :param str folder: Folder id or name. Paths must be separated by :
            instead of /. (REQUIRED)
        :param str include: Fields included in the response, whole JSON path
            must be provided.
        :param str exclude: Fields excluded in the response, whole JSON path
            must be provided.
        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID.
        :param int max_depth: Maximum depth to get files from.
        """

        return self._get(category='files', resource='tree', query_id=folder, **options)

