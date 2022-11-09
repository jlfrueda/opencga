package org.opencb.opencga.core.api;

import com.beust.jcommander.DynamicParameter;
import com.beust.jcommander.Parameter;
import org.opencb.opencga.core.models.alignment.AlignmentQcParams;

import java.util.HashMap;
import java.util.Map;

public class FieldConstants {

    //Generic descriptions
    public static final String GENERIC_RELEASE_DESCRIPTION = "An integer describing the current data release.";
    public static final String GENERIC_UUID_DESCRIPTION = "Unique 32-character identifier assigned automatically by OpenCGA.";
    public static final String GENERIC_VERSION_DESCRIPTION = "Autoincremental version assigned to the registered entry. By default, "
            + "updates does not create new versions. To enable versioning, users must set the `incVersion` flag from the /update web "
            + "service when updating the document.";
    public static final String GENERIC_CREATION_DATE_DESCRIPTION = "Autogenerated date following the format YYYYMMDDhhmmss containing the "
            + "date when the entry was first registered.";
    public static final String GENERIC_MODIFICATION_DATE_DESCRIPTION = "Autogenerated date following the format YYYYMMDDhhmmss containing"
            + " the date when the entry was last modified.";
    public static final String GENERIC_DESCRIPTION_DESCRIPTION = "Users may provide a description for the entry.";
    public static final String GENERIC_ADDITIONAL_INFO_DESCRIPTION = "Dictionary that can be customised by users to store any additional "
            + "information users may require.";
    public static final String GENERIC_ATTRIBUTES_DESCRIPTION = "You can use this field to store any other information, "
            + "keep in mind this is not indexed so you cannot search by attributes.";

    public static final String GENERIC_PHENOTYPES_DESCRIPTION = "List of phenotypes .";
    public static final String GENERIC_QUALITY_CONTROL = "Contains different metrics to evaluate "
            + "the quality of the individual.";
    public static final String GENERIC_CUSTOM_STATUS = "Object to set a custom status.";
    public static final String GENERIC_INTERNAL = "Internal field to manage the object.";
    public static final String GENERIC_NAME = "Name of the .";
    public static final String GENERIC_ID_DESCRIPTION = "Object ID is a mandatory parameter when creating a new one, this ID cannot be changed at the moment.";
    public static final String GENERIC_STATUS_DESCRIPTION = "Object status.";
    public static final String GENERIC_STATS = "Stats of the object.";
    //QualityControl
    public static final String QUALITY_CONTROL_FILES_DESCRIPTION = "File IDs related to the quality control.";
    public static final String QUALITY_CONTROL_COMMENTS_DESCRIPTION = "Comments related to the quality control.";

    //Sample
    public static final String SAMPLE_ID_DESCRIPTION = "Sample data model hosts information about any biological material, normally "
            + "extracted from an _Individual_, that is used for a particular analysis. This is the main data model, it stores the most "
            + "basic and important information.";
    public static final String SAMPLE_PROCESSING_DESCRIPTION = "Describes how the sample was processed in the lab.";
    public static final String SAMPLE_SAMPLE_COLLECTION_DESCRIPTION = "Describes how the sample was collected.";
    public static final String SAMPLE_QUALITY_CONTROL_DESCRIPTION = "Contains different metrics to evaluate the quality of the sample.";
    public static final String SAMPLE_SOMATIC_DESCRIPTION = "Describes if the sample is somatic or not .";
    public static final String SAMPLE_INDIVIDUAL_ID_DESCRIPTION = "Individual id of the sample.";
    public static final String SAMPLE_FILE_IDS_DESCRIPTION = "File ids of the sample.";
    public static final String SAMPLE_COHORT_IDS_DESCRIPTION = "Cohort ids of the sample.";
    public static final String SAMPLE_INTERNAL_DESCRIPTION = "Sample internal information.";
    public static final String SAMPLE_EXTERNAL_SOURCE_DESCRIPTION = "The external source from where the example was imported.";

    //SampleProcessing
    public static final String SAMPLE_PROCESSING_PRODUCT_DESCRIPTION = "Describes which product was used to process the sample in the lab.";
    public static final String SAMPLE_PROCESSING_PREPARATION_METHOD = "Describes which preparation method was used to process the sample "
            + "in the lab.";
    public static final String SAMPLE_PROCESSING_EXTRACTION_METHOD = "Describes which extraction method was used to process the sample"
            + "in the lab.";
    public static final String SAMPLE_PROCESSING_LAB_SAMPLE_ID_DESCRIPTION = "Original id has the sample in the lab.";
    public static final String SAMPLE_PROCESSING_QUANTITY_DESCRIPTION = "Number of process has done the sample.";
    public static final String SAMPLE_PROCESSING_DATE_DESCRIPTION = "Date when the sample was processed in the lab.";
    public static final String SAMPLE_PROCESSING_ATTRIBUTES_DESCRIPTION = "Attributes of the processing.";

    //SampleCollection
    public static final String SAMPLE_COLLECTION_TISSUE_DESCRIPTION = "Describes the tissue of the sample collection.";
    public static final String SAMPLE_COLLECTION_QUANTITY_DESCRIPTION = "Quantity collected for the sample.";
    public static final String SAMPLE_COLLECTION_DATE_DESCRIPTION = "Date when the sample was collected.";
    public static final String SAMPLE_COLLECTION_ATTRIBUTES_DESCRIPTION = "Attributes of the sample collection.";
    public static final String SAMPLE_COLLECTION_METHOD_DESCRIPTION = "Describes which method was used to collect the sample.";
    public static final String SAMPLE_COLLECTION_FROM_DESCRIPTION = "OntologyTermAnnotation list.";
    public static final String SAMPLE_COLLECTION_TYPE_DESCRIPTION = "Type of the sample collection.";
    //SampleQualityControl
    public static final String SAMPLE_QUALITY_CONTROL_FILES_DESCRIPTION = "Files used for the quality control of the sample.";
    public static final String SAMPLE_QUALITY_CONTROL_COMMENTS_DESCRIPTION = "Comments for the quality control of the sample.";
    public static final String SAMPLE_QUALITY_CONTROL_VARIANT_DESCRIPTION = "Describes variant quality control.";

    //SampleVariantQualityControlMetrics
    public static final String SAMPLE_QUALITY_CONTROL_METRICS_VARIANT_STATS_DESCRIPTION = "Variant stats for the quality control of the "
            + "sample.";
    public static final String SAMPLE_QUALITY_CONTROL_METRICS_SIGNATURES_DESCRIPTION = "Signature for the quality control of the sample.";
    public static final String SAMPLE_QUALITY_CONTROL_METRICS_GENOME_PLOT_DESCRIPTION = "Genome plot for the quality control of the sample.";
    public static final String SAMPLE_QUALITY_CONTROL_METRICS_FILES_DESCRIPTION = "File for the quality control metrics of the "
            + "sample.";

    //CustomStatus
    public static final String CUSTOM_STATUS_NAME_DESCRIPTION = "Name of the status.";
    public static final String INTERNAL_STATUS_DESCRIPTION = "Status of the internal object.";
    public static final String INTERNAL_REGISTRATION_DATE_DESCRIPTION = "Registration date of the internal object.";
    public static final String INTERNAL_LAST_MODIFIED_DESCRIPTION = "Date of the last modification of the internal object.";

    //SampleInternal
    public static final String SAMPLE_INTERNAL_RGA_DESCRIPTION = "Rga index for Sample internal.";

    //RgaIndex
    public static final String RGAINDEX_STATUS_DESCRIPTION = "Status of the Rga index NOT_INDEXED, INDEXED, INVALID_PERMISSIONS, "
            + "INVALID_METADATA, INVALID.";
    public static final String RGAINDEX_DATE_DESCRIPTION = "Date of Rga index.";

    //Location
    public static final String LOCATION_ADDRESS = "Location address.";
    public static final String LOCATION_COUNTRY = "Location country.";
    public static final String LOCATION_CITY = "Location city.";
    public static final String LOCATION_STATE = "Location state.";
    public static final String LOCATION_POSTAL_CODE = "Location postal code.";

    //Individual population
    public static final String INDIVIDUAL_POPULATION_NAME = "Name of the individual population.";
    public static final String INDIVIDUAL_POPULATION_SUBPOPULATION = "Subpopulation of the individual population.";
    public static final String INDIVIDUAL_POPULATION_DESCRIPTION = "Description of the individual population.";


    //Individual
    public static final String INDIVIDUAL_ID_DESCRIPTION = "Individual ID in the study, this must be unique in the "
            + "study but can be repeated in different studies. This is a mandatory parameter "
            + "when creating a new Individual, this ID cannot be changed at the moment.";
    public static final String INDIVIDUAL_NAME = "Name of the individual.";
    public static final String INDIVIDUAL_MOTHER = "Mother of the individual.";
    public static final String INDIVIDUAL_FATHER = "Father of the individual.";
    public static final String INDIVIDUAL_FAMILY_IDS = "List of ids of the family members.";
    public static final String INDIVIDUAL_LOCATION = "Location of the individual.";
    public static final String INDIVIDUAL_SEX = "Sex of the individual.";
    public static final String INDIVIDUAL_KARYOTYPIC_SEX = "Karyotypic sex of the individual.";
    public static final String INDIVIDUAL_ETHNICITY = "Ethnicity of the individual.";
    public static final String INDIVIDUAL_DATE_OF_BIRTH = "Date of birth of the individual.";
    public static final String INDIVIDUAL_LIFE_STATUS = "Life status of the of the individual "
            + "ALIVE, ABORTED, DECEASED, UNBORN, STILLBORN, MISCARRIAGE, UNKNOWN.";
    public static final String INDIVIDUAL_DISORDERS = "List of the individual disorders.";
    public static final String INDIVIDUAL_SAMPLES = "List of the individual samples.";
    public static final String INDIVIDUAL_PARENTAL_CONSANGUINITY = "Indicates the parental consanguinity is "
            + "true or false.";

    //Family
    public static final String FAMILY_ID_DESCRIPTION = "Family is a mandatory parameter when creating a new sample, this ID cannot be changed at the moment.";
    public static final String FAMILY_NAME = "Family name.";
    public static final String FAMILY_MEMBERS = "List of individuals who are family members.";
    public static final String FAMILY_DISORDERS = "Family disorders.";
    public static final String FAMILY_EXPECTED_SIZE = "Family expected size.";
    public static final String FAMILY_ROLES = "Map of members ids and enum of roles (FATHER, MOTHER, IDENTICAL_TWIN, SON, UNCLE, PATERNAL_GRANDFATHER.)  .";

    //FamilyQualityControl
    public static final String FAMILY_QUALITY_CONTROL_RELATEDNESS_DESCRIPTION = "Reports of family relationship.";
    public static final String INDIVIDUAL_QUALITY_CONTROL_INFERRED_SEX_REPORT_DESCRIPTION = "List of inferred sex reports, it depends on the method (currently by coverage ratio).";
    public static final String INDIVIDUAL_QUALITY_CONTROL_SAMPLE_RELATEDNESS_REPORT_DESCRIPTION = "Reports of samples relatedness.";
    public static final String INDIVIDUAL_QUALITY_CONTROL_MENDELIAN_ERRORS_DESCRIPTION = "Mendelian errors.";

    //Status
    public static final String STATUS_DATE_DESCRIPTION = "Date has setted the status.";
    public static final String STATUS_MESSAGE_DESCRIPTION = "Deprecated: Message describing the status.";


    //Interpretation
    public static final String INTERPRETATION_STUDY_UID = "Study identifier.";
    public static final String INTERPRETATION_UID = "Interpretation identifier.";
    public static final String INTERPRETATION_PANELS = "Interpretation panel list.";

    //InterpretationInternal
    public static final String INTERPRETATION_INTERNAL_STATUS = "State of the interpretation that can have the values READY, "
            + "DELETED, NOT_REVIEWED, UNDER_REVIEW, REVIEWED and REJECTED.";

    //ClinicalAnalysis
    public static final String CLINICAL_ANALYSIS_ID_DESCRIPTION = "ClinicalAnalysis ID is a mandatory parameter when "
            + "creating a new ClinicalAnalysis, this ID cannot be changed at the moment.";
    public static final String CLINICAL_ANALYSIS_TYPE = "Enumeration of the diferent types of clinical analysis "
            + "SINGLE, FAMILY, CANCER, COHORT, AUTOCOMPARATIVE.";
    public static final String CLINICAL_ANALYSIS_DISORDER = "Disorder of the clinical analysis.";
    public static final String CLINICAL_ANALYSIS_FILES = "List of files (VCF, BAM and BIGWIG).";
    public static final String CLINICAL_ANALYSIS_PROBAND = "Individual proband of the clinical analysis.";
    public static final String CLINICAL_ANALYSIS_FAMILY = "Family of the clinical analysis.";
    public static final String CLINICAL_ANALYSIS_PANELS = "List of panels to the clinical analysis.";
    public static final String CLINICAL_ANALYSIS_PANEL_LOCK = "Boolean to set lock panels.";
    public static final String CLINICAL_ANALYSIS_LOCKED = "Boolean that indicates if the clinical analysis is locked or not.";
    public static final String CLINICAL_ANALYSIS_INTERPRETATION = "Interpretation of the clinical analysis.";
    public static final String CLINICAL_ANALYSIS_SECONDARY_INTERPRETATION = "List of Interpretations containing the second and consecutive.";
    public static final String CLINICAL_ANALYSIS_CONSENT = "Object contains consent annotations of clinical analysis.";
    public static final String CLINICAL_ANALYSIS_ANALYST = "The analyst of the clinical analysis.";
    public static final String CLINICAL_ANALYSIS_REPORT = "Report of the clinical analysis.";
    public static final String CLINICAL_ANALYSIS_PRIORITY = "Priority of the clinical analysis.";
    public static final String CLINICAL_ANALYSIS_FLAGS = "List of flags for the clinical analysis.";
    public static final String CLINICAL_ANALYSIS_DUE_DATE_DESCRIPTION = "Due date of the clinical analysis.";
    public static final String CLINICAL_ANALYSIS_COMMENTS = "List of Clinical Analysis comments.";
    public static final String CLINICAL_ANALYSIS_AUDIT = "List of Clinical Analysis audits.";

    //ClinicalConsentParam
    public static final String CLINICAL_CONSENT_PARAM_VALUE = "Value of the param that can have the values "
            + "YES, NO and UNKNOWN.";

    //ClinicalConsentAnnotation
    public static final String CLINICAL_CONSENT_ANNOTATION_CONSENTS = "List of ClinicalConsentParam.";
    public static final String CLINICAL_CONSENT_ANNOTATION_DATE = "Date of the ClinicalConsentAnnotation.";


    //ClinicalReport
    public static final String CLINICAL_REPORT_TITLE = "Report title.";
    public static final String CLINICAL_REPORT_OVERVIEW = "Report overview.";
    public static final String CLINICAL_REPORT_DISCUSSION = "Report discussion.";
    public static final String CLINICAL_REPORT_LOGO = "Report logo.";
    public static final String CLINICAL_REPORT_SIGNED_BY = "Indicates who has signed the report.";
    public static final String CLINICAL_REPORT_SIGNATURE = "Report signature.";
    public static final String CLINICAL_REPORT_DATE = "Report date.";

    //ClinicalPriorityAnnotation
    public static final String CLINICAL_PRIORITY_ANNOTATION_RANK_DESCRIPTION = "ClinicalPriorityAnnotation rank.";
    public static final String CLINICAL_PRIORITY_DATE = "ClinicalPriorityAnnotation date.";
    //FlagAnnotation
    public static final String FLAG_ANNOTATION_DATE_DESCRIPTION = "FlagAnnotation date.";


    //ClinicalAnalysisQualityControl
    public static final String CLINICAL_ANALYSIS_QUALITY_CONTROL_COMMENTS = "List of ClinicalAnalysisQualityControl comments.";
    public static final String CLINICAL_ANALYSIS_QUALITY_CONTROL_SUMMARY = "ClinicalAnalysisQualityControl summary that can have the values "
            + "HIGH, MEDIUM, LOW, DISCARD, NEEDS_REVIEW, UNKNOWN.";
    public static final String CLINICAL_ANALYSIS_QUALITY_CONTROL_FILES = "List of ClinicalAnalysisQualityControl files.";

    //Cohort
    public static final String COHORT_TYPE = "Cohort type that can have the values CASE_CONTROL, CASE_SET, CONTROL_SET, PAIRED, "
            + "PAIRED_TUMOR, AGGREGATE, TIME_SERIES, FAMILY, TRIO and COLLECTION.";
    public static final String COHORT_SAMPLES = "List of cohort samples.";
    public static final String COHORT_NUM_SAMPLES = "Number of samples.";

    //File
    public static final String FILE_NAME = "The name of the file.";
    public static final String FILE_TYPE = "The type can have the values FILE or DIRECTORY.";
    public static final String FILE_FORMAT = "The format can have the values VCF, BCF, GVCF, TBI, BIGWIG, SAM, BAM, BAI, "
            + "CRAM, CRAI, FASTQ, FASTA, PED, TAB_SEPARATED_VALUES, COMMA_SEPARATED_VALUES, XML, PROTOCOL_BUFFER, JSON, AVRO, "
            + "PARQUET, IMAGE, PLAIN, BINARY, NONE and UNKNOWN.";
    public static final String FILE_BIOFORMAT = "The bioformat can have the values MICROARRAY_EXPRESSION_ONECHANNEL_AGILENT, "
            + "MICROARRAY_EXPRESSION_ONECHANNEL_AFFYMETRIX, MICROARRAY_EXPRESSION_ONECHANNEL_GENEPIX, "
            + "MICROARRAY_EXPRESSION_TWOCHANNELS_AGILENT, MICROARRAY_EXPRESSION_TWOCHANNELS_GENEPIX, DATAMATRIX_EXPRESSION, "
            + "IDLIST, IDLIST_RANKED, ANNOTATION_GENEVSANNOTATION, OTHER_NEWICK, OTHER_BLAST, OTHER_INTERACTION, OTHER_GENOTYPE, "
            + "OTHER_PLINK, OTHER_VCF, OTHER_PED, @Deprecated VCF4, VARIANT, ALIGNMENT, COVERAGE, SEQUENCE, PEDIGREE, "
            + "REFERENCE_GENOME, NONE and UNKNOWN.";
    public static final String FILE_CHECKSUM = "The checksum of the file.";
    public static final String FILE_PATH = "The path of the file.";
    public static final String FILE_URI = "The uri of the file.";
    public static final String FILE_EXTERNAL = "Indicates the file is external or not.";
    public static final String FILE_SIZE = "The size of the file.";
    public static final String FILE_SOFTWARE = "Software related with file.";
    public static final String FILE_EXPERIMENT = "File experiment.";
    public static final String FILE_SAMPLE_IDS = "List of sample ids of the file.";
    public static final String FILE_JOB_ID = "File job id.";
    public static final String FILE_TAGS = "File tags.";
    public static final String FILE_RELATED_FILES = "List of objects FileRelatedFiles describing related files.";


    //ToolInfo
    public static final String TOOL_INFO_SCOPE_DESCRIPTION = "Tool info scope can have the values GLOBAL, PROJECT and STUDY.";
    public static final String TOOL_INFO_TYPE_DESCRIPTION = "Tool info type can have the values OPERATION and ANALYSIS.";
    public static final String TOOL_INFO_RESOURCE_DESCRIPTION = "Tool info resource can have the values AUDIT, USER, PROJECT, "
            + "STUDY, FILE, SAMPLE, JOB, INDIVIDUAL, COHORT, DISEASE_PANEL, FAMILY, CLINICAL_ANALYSIS, INTERPRETATION, "
            + "VARIANT, ALIGNMENT, CLINICAL, EXPRESSION, RGA and FUNCTIONAL.";

    //FileInternal
    public static final String FILE_INTERNAL_STATUS_DESCRIPTION = "File status can have the values READY, DELETED, "
            + "TRASHED, STAGE, MISSING, PENDING_DELETE, DELETING, REMOVED and MISSING_SAMPLES.";
    public static final String FILE_INTERNAL_ALIGNMENT_DESCRIPTION = "File internal alignment.";
    public static final String FILE_INTERNAL_VARIANT_DESCRIPTION = "File internal variant.";

    //FileIndex
    public static final String FILE_INDEX_USER_ID_DESCRIPTION = "Index user id.";
    public static final String FILE_INDEX_STATUS_DESCRIPTION = "File status can have the values READY, DELETED, NONE, "
            + "TRANSFORMED, TRANSFORMING, LOADING and INDEXING \n"
            + "         \n"
            + "   NONE --> TRANSFORMING --> TRANSFORMED --> LOADING --> READY\n"
            + "       \\                                              /\n"
            + "         ------------------> INDEXING ----------------/.";

    public static final String FILE_INDEX_JOB_ID_DESCRIPTION = "Index job id.";
    public static final String FILE_INTERNAL_SAMPLE_MAP_DESCRIPTION = "Map of samples.";
    public static final String FILE_INTERNAL_MISSING_SAMPLE_DESCRIPTION = "Object describes missing samples.";

    //MissingSamples
    public static final String MISSING_SAMPLE_EXISTING_DESCRIPTION = "List of existing samples.";
    public static final String MISSING_SAMPLE_NON_EXISTING_DESCRIPTION = "List of non existing samples.";

    //Panel
    public static final String PANEL_VERSION_DESCRIPTION = "OpenCGA version of this panel, this is incremented when the panel is updated.";
    public static final String PANEL_AUTHOR_DESCRIPTION = "Author of the panel.";
    public static final String PANEL_STATUS_DESCRIPTION = "Panel status can have the values READY or DELETED.";
    public static final String PANEL_STUDY_UID_DESCRIPTION = "Panel reference to study.";
    //JobInternal
    public static final String JOB_INTERNAL_STATUS_DESCRIPTION = "Job internal status can have the values PENDING, QUEUED, RUNNING, DONE, "
            + "ERROR, UNKNOWN, REGISTERING, UNREGISTERED, ABORTED, DELETED.";
    public static final String JOB_INTERNAL_EVENTS_DESCRIPTION = "Events of the internal job.";
    public static final String JOB_INTERNAL_WEBHOOK_DESCRIPTION = "Job internal Webhook.";

    //JobInternalWebhook
    public static final String JOB_INTERNAL_WEBHOOK_URL_DESCRIPTION = "Webhook URL.";
    public static final String JOB_INTERNAL_WEBHOOK_STATUS_DESCRIPTION = "Webhook status map can have the values SUCCESS or ERROR.";

    public static final String JOB_OUT_DIR_DESCRIPTION = "Output dir for the job.";
    public static final String JOB_INPUT_DESCRIPTION = "List of input files.";
    public static final String JOB_OUTPUT_DESCRIPTION = "List of output files.";
    public static final String JOB_TAGS_DESCRIPTION = "List of tags for the job.";
    public static final String JOB_DEPENDS_ON_DESCRIPTION = "List of jobs the current job depends on.";
    public static final String JOB_EXECUTION_DESCRIPTION = "Result of the execution.";

    //ExecutorInfo
    public static final String EXECUTION_INFO_CLASS_DESCRIPTION = "ExecutorInfo class.";
    public static final String EXECUTION_INFO_PARAMS_DESCRIPTION = "ExecutorInfo params.";
    public static final String EXECUTION_INFO_SOURCE_DESCRIPTION = "Executor info source can have the values FILE, PARQUET_FILE, "
            + "MONGODB,  HBASE, STORAGE.";
    public static final String EXECUTION_INFO_FRAMEWORK_DESCRIPTION = "Executor info framework can have the values LOCAL, MAP_REDUCE, SPARK.";

    //ExecutionResult
    public static final String EXECUTION_RESULT_EXECUTION_INFO = "Object describes execution information.";
    public static final String EXECUTION_RESULT_START = "Date the execution started.";
    public static final String EXECUTION_RESULT_END = "Date the execution was completed.";
    public static final String EXECUTION_RESULT_STATUS = "Executor status can have the values PENDING, RUNNING, DONE and ERROR.";
    public static final String EXECUTION_RESULT_EXTERNAL_FILES = "List of uris to the external files.";
    public static final String EXECUTION_RESULT_STEPS = "List of ToolStep.";
    public static final String EXECUTION_RESULT_EVENTS = "List of Event.";

    //Job
    public static final String JOB_TOOL = "Job tool info.";
    public static final String JOB_USER_ID = "Job user id.";
    public static final String JOB_COMMAND_LINE = "Job command line.";
    public static final String JOB_PARAMS = "Job params.";
    public static final String JOB_PRIORITY_DESCRIPTION = "Job priority.";
    public static final String JOB_STDOUT_DESCRIPTION = "Standard out file.";
    public static final String JOB_STDERR_DESCRIPTION = "Standard error file.";
    public static final String JOB_VISITED = "Boolean that represents if the job has been visited or not.";
    public static final String JOB_STUDY = "Job study.";
    public static final String JOB_STUDY_PARAM_OTHERS = "List of strings.";

    //Project
    public static final String PROJECT_FQN = "Full Qualified Name (user@projectId).";
    public static final String PROJECT_ORGANISM = "Organism to which the project belongs.";
    public static final String PROJECT_STUDIES = "Project study list.";

    //ProjectInternal
    public static final String PROJECT_INTERNAL_DATA_STORES = "Default value is VARIANT.";
    public static final String PROJECT_CELLBASE = "Cellbase configuration.";

    //StudyNotification
    public static final String STUDY_NOTIFICATION_WEBHOOK = "Url of the study notification.";

    //Study
    public static final String STUDY_ALIAS = "Study alias.";
    public static final String STUDY_SIZE = "Study size.";
    public static final String STUDY_NOTIFICATION = "Object represents study notification.";
    public static final String STUDY_GROUPS = "A List with related groups.";
    public static final String STUDY_FILES = "A List with related files.";
    public static final String STUDY_JOBS = "A List with related jobs.";
    public static final String STUDY_INDIVIDUALS = "A List with related individuals.";
    public static final String STUDY_FAMILIES = "A List with related families.";
    public static final String STUDY_SAMPLES = "A List with related samples.";
    public static final String STUDY_COHORTS = "A List with related cohorts.";
    public static final String STUDY_PANELS = "A List with related panels.";
    public static final String STUDY_ANALYSES = "A List with related clinicalAnalyses.";
    public static final String STUDY_VARIABLE_SETS = "A List with related variableSets.";
    public static final String STUDY_PERMISSION_RULES = "A map with related permission rules.\n"
            + "The key of the map can have the values SAMPLES, FILES, COHORTS, INDIVIDUALS, FAMILIES, "
            + "JOBS, CLINICAL_ANALYSES and DISEASE_PANELS. The value is a List of permission rules ";
    public static final String STUDY_URI = "Study uri";
    public static final String STUDY_EXTERNAL_SOURCES = "A List with related external sources.";
    public static final String STUDY_TYPE = "Study type description";

    //PermissionRule
    public static final String PERMISSION_RULE_QUERY = "PermissionRule query.";
    public static final String PERMISSION_RULE_MEMBERS = "List of members of the permission rule.";
    public static final String PERMISSION_RULE_PERMISSIONS = "List of permissions of the permission rule.";

    //StudyInternal
    public static final String STUDY_INTERNAL_INDEX = "Study index.";
    public static final String STUDY_INTERNAL_CONFIGURATION = "Study configuration.";

    //AdditionalInfo
    public static final String ADDITIONAL_INFO_TYPE = "Type of the additional info.";

    //User
    public static final String USER_NAME = "User name.";
    public static final String USER_EMAIL = "User email.";
    public static final String USER_ORGANIZATION = "User organization.";
    public static final String USER_ACCOUNT = "User account.";

    //Account
    public static final String ACCOUNT_TYPE = "User account type can have the values GUEST, FULL and ADMINISTRATOR.";
    public static final String ACCOUNT_EXPIRATION_DATE_DESCRIPTION = "Date the account expires.";
    public static final String ACCOUNT_AUTHENTICATION = "How the account is authenticated";
    public static final String USER_QUOTA = "User quota";
    public static final String USER_PROJECTS = "A List with related projects.";
    public static final String USER_SHARED_PROJECTS = "A List with shared projects.";
    public static final String USER_CONFIGS = "User configurations";
    public static final String USER_FILTERS = "A List with related filters.";

    //UserFilter
    public static final String USER_FILTER_RESOURCE_DESCRIPTION = "User resource can have the values AUDIT, USER, PROJECT, "
            + "STUDY, FILE, SAMPLE, JOB, INDIVIDUAL, COHORT, DISEASE_PANEL, FAMILY, CLINICAL_ANALYSIS, INTERPRETATION, "
            + "VARIANT, ALIGNMENT, CLINICAL, EXPRESSION, RGA and FUNCTIONAL.";
    public static final String USER_FILTER_QUERY = "User filter query";
    public static final String USER_FILTER_QUERY_OPTIONS = "User filter query options";


    // Mutational signature (sample-qc-run, mutationsl-signature-run, mutational-signature-query)
    public static final String MUTATIONAL_SIGNATURE_ID_DESCRIPTION = "Signature ID.";
    public static final String MUTATIONAL_SIGNATURE_DESCRIPTION_DESCRIPTION = "Signature description.";
    public static final String MUTATIONAL_SIGNATURE_QUERY_DESCRIPTION = "Signature query in JSON format, e.g: \"\"{\\\"sample\\\":"
            + "\\\"NR123456_T\\\", \\\"fileData\\\": \\\"NR.123456_T_vs_NR.1234567_G.annot.vcf.gz:FILTER=PASS;CLPM<=0;ASMD>=140\\\"}\".";
    public static final String MUTATIONAL_SIGNATURE_CATALOGUES_DESCRIPTION = "File name containing mutational catalogues. Each sample"
            + " catalogue is in a column, with sample names as column headers and channel.";
    public static final String MUTATIONAL_SIGNATURE_CATALOGUES_CONTENT_DESCRIPTION = "Mutational catalogues. Each sample catalogue is in a"
            + " column, with sample names as column headers and channel.";
    public static final String MUTATIONAL_SIGNATURE_FIT_METHOD_DESCRIPTION = "Either Fit or FitMS. If not specified then FitMS";
    public static final String MUTATIONAL_SIGNATURE_N_BOOT_DESCRIPTION = "Number of bootstrap to be used.";
    public static final String MUTATIONAL_SIGNATURE_SIG_VERSION_DESCRIPTION = "Either COSMICv2, COSMICv3.2, RefSigv1 or RefSigv2. If not"
            + " specified RefSigv2.";
    public static final String MUTATIONAL_SIGNATURE_ORGAN_DESCRIPTION = "When using RefSigv1 or RefSigv2 as SIGVERSION, organ-specific"
            + " signatures will be used. If SIGVERSION is COSMICv2 or COSMICv3.2, then a selection of signatures found in the given organ will be"
            + " used. Available organs depend on the selected SIGVERSION. For RefSigv1 or RefSigv2: Biliary, Bladder, Bone_SoftTissue, Breast,"
            + " Cervix (v1 only), CNS, Colorectal, Esophagus, Head_neck, Kidney, Liver, Lung, Lymphoid, NET (v2 only), Oral_Oropharyngeal"
            + " (v2 only), Ovary, Pancreas, Prostate, Skin, Stomach, Uterus.";
    public static final String MUTATIONAL_SIGNATURE_THRESHOLD_PERC_DESCRIPTION = "Threshold in percentage of total mutations in a sample,"
            + " only exposures larger than THRPERC are considered. If not specified 5.";
    public static final String MUTATIONAL_SIGNATURE_THRESHOLD_PVAL_DESCRIPTION = "P-value to determine the empirical probability that the"
            + " exposure is lower than the threshold. If not specified then 0.05.";
    public static final String MUTATIONAL_SIGNATURE_MAX_RARE_SIGS_DESCRIPTION = "Maximum number of rare signatures that are allowed to be"
            + " present in each sample. If not specified 1.";
    public static final String MUTATIONAL_SIGNATURE_SIGNATURES_FILE_DESCRIPTION = "The file name containing mutational signatures. Each"
            + " signature is in a column, with signature names as column hearders and channel names as row names in the first column with"
            + " no header. Each column must sum to 1. Use only to provide your own signatures. When fitmethod=FitMS, these signatures are"
            + " considered common signatures.";
    public static final String MUTATIONAL_SIGNATURE_RARE_SIGNATURES_FILE_DESCRIPTION = "The file name containing mutational signatures."
            + " Each signature is in a column, with signature names as column hearders and channel names as row names in the first column"
            + " with no header. Each column must sum to 1. Use only to provide your own signatures. When fitmethod=FitMS, these signatures"
            + " are considered rare signatures.";

    // Genome plot (sample-qc-run)
    public static final String GENOME_PLOT_ID_DESCRIPTION = "Genome plot ID.";
    public static final String GENOME_PLOT_DESCRIPTION_DESCRIPTION = "Genome plot description.";
    public static final String GENOME_PLOT_CONFIGURATION_FILE_DESCRIPTION = "Genome plot configuration file.";

    // Variant stats (sample-qc-run)
    public static final String VARIANT_STATS_ID_DESCRIPTION = "Variant stats ID.";
    public static final String VARIANT_STATS_DESCRIPTION_DESCRIPTION = "Variant stats description.";
    public static final String VARIANT_STATS_QUERY_DESCRIPTION = "Variant stats query in JSON format.";

    // Alignment QC analysis (asample-qc-run)
    public static final String ALIGNMENT_QC_BAM_FILE_DESCRIPTION = "ID for the BAM file to process.";
    public static final String ALIGNMENT_QC_SKIP_DESCRIPTION = "To skip any alignment QC metrics use the following keywords (separated by"
            + " commas): " + AlignmentQcParams.STATS_SKIP_VALUE + ", " + AlignmentQcParams.FLAGSTATS_SKIP_VALUE + ", "
            + AlignmentQcParams.FASTQC_METRICS_SKIP_VALUE;
    public static final String ALIGNMENT_QC_OVERWRITE_DESCRIPTION = "To overwrite the QC metrics already computed.";

}
