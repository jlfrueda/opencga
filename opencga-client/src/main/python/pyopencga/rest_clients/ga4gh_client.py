"""
WARNING: AUTOGENERATED CODE

    This code was generated by a tool.
    Autogenerated on: 2023-03-28
    
    Manual changes to this file may cause unexpected behavior in your application.
    Manual changes to this file will be overwritten if the code is regenerated.
"""

from pyopencga.rest_clients._parent_rest_clients import _ParentRestClient


class GA4GH(_ParentRestClient):
    """
    This class contains methods for the 'GA4GH' webservices
    Client version: 2.8.0-SNAPSHOT
    PATH: /{apiVersion}/ga4gh
    """

    def __init__(self, configuration, token=None, login_handler=None, *args, **kwargs):
        super(GA4GH, self).__init__(configuration, token, login_handler, *args, **kwargs)

    def search_reads(self, **options):
        """
        Description.
        PATH: /{apiVersion}/ga4gh/reads/search
        """

        return self._post(category='ga4gh', resource='search', subcategory='reads', **options)

    def fetch_reads(self, study, file, **options):
        """
        Fetch alignment files using HTSget protocol.
        PATH: /{apiVersion}/ga4gh/reads/{study}/{file}

        :param str study: Study [[user@]project:]study where study and project
            can be either the ID or UUID. (REQUIRED)
        :param str file: File id, name or path. (REQUIRED)
        :param str reference_name: Reference sequence name (Example: 'chr1',
            '1' or 'chrX'.
        :param int start: The start position of the range on the reference,
            0-based, inclusive.
        :param int end: The end position of the range on the reference,
            0-based, exclusive.
        :param str reference_genome: Reference genome.
        """

        return self._get(category='ga4gh/reads', query_id=study, second_query_id=file, **options)

    def responses(self, chrom, pos, allele, beacon, **options):
        """
        Beacon webservice.
        PATH: /{apiVersion}/ga4gh/responses

        :param str beacon: Beacon IDs. If specified, only beacons with the
            given IDs are queried. Responses from all the supported beacons are
            obtained otherwise. Format: [id1,id2]. (REQUIRED)
        :param str allele: Any string of nucleotides A,C,T,G or D, I for
            deletion and insertion, respectively. Note: For compatibility with
            conventions set by some of the existing beacons, DEL and INS
            identifiers are also accepted. (REQUIRED)
        :param int pos: Coordinate within a chromosome. Position is a number
            and is 0-based. (REQUIRED)
        :param str chrom: Chromosome ID. Accepted values: 1-22, X, Y, MT.
            Note: For compatibility with conventions set by some of the
            existing beacons, an arbitrary prefix is accepted as well (e.g.
            chr1 is equivalent to chrom1 and 1). (REQUIRED)
        :param str ref: Genome ID. If not specified, all the genomes supported
            by the given beacons are queried. Note: For compatibility with
            conventions set by some of the existing beacons, both GRC or HG
            notation are accepted, case insensitive.
        """

        options['chrom'] = chrom
        options['pos'] = pos
        options['allele'] = allele
        options['beacon'] = beacon
        return self._get(category='ga4gh', resource='responses', **options)

    def search_variants(self, **options):
        """
        Description.
        PATH: /{apiVersion}/ga4gh/variants/search
        """

        return self._post(category='ga4gh', resource='search', subcategory='variants', **options)

