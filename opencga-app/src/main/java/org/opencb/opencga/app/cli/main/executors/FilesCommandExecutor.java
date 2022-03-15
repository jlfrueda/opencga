package org.opencb.opencga.app.cli.main.executors;

import org.opencb.opencga.app.cli.main.executors.OpencgaCommandExecutor;
import org.opencb.opencga.app.cli.main.*;
import org.opencb.opencga.core.response.RestResponse;
import org.opencb.opencga.client.exceptions.ClientException;
import org.opencb.commons.datastore.core.ObjectMap;

import org.opencb.opencga.catalog.exceptions.CatalogAuthenticationException;

import java.util.List;

import org.opencb.opencga.app.cli.main.options.FilesCommandOptions;

import org.opencb.opencga.app.cli.main.parent.ParentFilesCommandExecutor;

import org.opencb.opencga.catalog.utils.ParamUtils.BasicUpdateAction;
import org.opencb.commons.datastore.core.FacetField;
import org.opencb.opencga.core.models.file.FileAclUpdateParams;
import org.opencb.opencga.core.models.file.FileUpdateParams;
import org.opencb.opencga.core.models.common.StatusParams;
import org.opencb.opencga.core.models.common.TsvAnnotationParams;
import org.opencb.opencga.core.models.file.FileLinkInternalParams;
import org.opencb.opencga.catalog.utils.ParamUtils.AclAction;
import java.io.DataInputStream;
import org.opencb.opencga.core.models.file.FileExperiment;
import org.opencb.opencga.core.models.file.FileTree;
import org.opencb.opencga.core.models.file.FileCreateParams;
import org.opencb.opencga.catalog.utils.ParamUtils.CompleteUpdateAction;
import org.opencb.biodata.models.clinical.interpretation.Software;
import org.opencb.opencga.core.models.file.SmallFileInternal;
import org.opencb.opencga.core.models.file.FileLinkParams;
import org.opencb.opencga.core.models.file.FileQualityControl;
import org.opencb.opencga.core.models.file.File.Bioformat;
import org.opencb.opencga.core.models.file.FileFetch;
import org.opencb.opencga.core.models.job.Job;
import org.opencb.opencga.core.models.file.File.Format;
import org.opencb.opencga.core.models.file.FileContent;
import org.opencb.opencga.core.models.file.FileLinkToolParams;
import org.opencb.opencga.core.models.file.PostLinkToolParams;
import java.io.InputStream;
import java.util.Map;
import org.opencb.opencga.core.models.file.File;


/*
* WARNING: AUTOGENERATED CODE
*
* This code was generated by a tool.
* Autogenerated on: 2022-03-15
*
* Manual changes to this file may cause unexpected behavior in your application.
* Manual changes to this file will be overwritten if the code is regenerated.
*/


/**
 * This class contains methods for the Files command line.
 *    OpenCGA version: 2.2.0-rc2-SNAPSHOT
 *    PATH: /{apiVersion}/files
 */
public class FilesCommandExecutor extends ParentFilesCommandExecutor {

    private FilesCommandOptions filesCommandOptions;

    public FilesCommandExecutor(FilesCommandOptions filesCommandOptions) throws CatalogAuthenticationException {
        super(filesCommandOptions.commonCommandOptions,filesCommandOptions);
        this.filesCommandOptions = filesCommandOptions;
    }

    @Override
    public void execute() throws Exception {

        logger.debug("Executing Files command line");

        String subCommandString = getParsedSubCommand(filesCommandOptions.jCommander);

        RestResponse queryResponse = null;

        switch (subCommandString) {
            case "acl-update":
                queryResponse = updateAcl();
                break;
            case "aggregationstats":
                queryResponse = aggregationStats();
                break;
            case "annotationsets-load":
                queryResponse = loadAnnotationSets();
                break;
            case "create":
                queryResponse = create();
                break;
            case "distinct":
                queryResponse = distinct();
                break;
            case "fetch":
                queryResponse = fetch();
                break;
            case "link":
                queryResponse = link();
                break;
            case "link-run":
                queryResponse = runLink();
                break;
            case "postlink-run":
                queryResponse = runPostlink();
                break;
            case "search":
                queryResponse = search();
                break;
            case "acl":
                queryResponse = acl();
                break;
            case "delete":
                queryResponse = delete();
                break;
            case "info":
                queryResponse = info();
                break;
            case "unlink":
                queryResponse = unlink();
                break;
            case "update":
                queryResponse = update();
                break;
            case "download":
                queryResponse = download();
                break;
            case "grep":
                queryResponse = grep();
                break;
            case "head":
                queryResponse = head();
                break;
            case "image":
                queryResponse = image();
                break;
            case "refresh":
                queryResponse = refresh();
                break;
            case "tail":
                queryResponse = tail();
                break;
            case "list":
                queryResponse = list();
                break;
            case "tree":
                queryResponse = tree();
                break;
            case "upload":
                queryResponse = upload();
                break;
            default:
                logger.error("Subcommand not valid");
                break;
        }

        createOutput(queryResponse);

    }

    private RestResponse<ObjectMap> updateAcl() throws Exception {

        logger.debug("Executing updateAcl in Files command line");

        FilesCommandOptions.UpdateAclCommandOptions commandOptions = filesCommandOptions.updateAclCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        if(queryParams.get("study")==null && OpencgaMain.isShellMode()){
                queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }


        FileAclUpdateParams fileAclUpdateParams = (FileAclUpdateParams) new FileAclUpdateParams()
            .setFile(commandOptions.file)
            .setSample(commandOptions.sample)
            .setPermissions(commandOptions.permissions);
        return openCGAClient.getFileClient().updateAcl(commandOptions.members, commandOptions.action, fileAclUpdateParams, queryParams);
    }

    private RestResponse<FacetField> aggregationStats() throws Exception {

        logger.debug("Executing aggregationStats in Files command line");

        FilesCommandOptions.AggregationStatsCommandOptions commandOptions = filesCommandOptions.aggregationStatsCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("name", commandOptions.name);
        queryParams.putIfNotEmpty("type", commandOptions.type);
        queryParams.putIfNotEmpty("format", commandOptions.format);
        queryParams.putIfNotEmpty("bioformat", commandOptions.bioformat);
        queryParams.putIfNotEmpty("creationYear", commandOptions.creationYear);
        queryParams.putIfNotEmpty("creationMonth", commandOptions.creationMonth);
        queryParams.putIfNotEmpty("creationDay", commandOptions.creationDay);
        queryParams.putIfNotEmpty("creationDayOfWeek", commandOptions.creationDayOfWeek);
        queryParams.putIfNotEmpty("status", commandOptions.status);
        queryParams.putIfNotEmpty("release", commandOptions.release);
        queryParams.putIfNotNull("external", commandOptions.external);
        queryParams.putIfNotEmpty("size", commandOptions.size);
        queryParams.putIfNotEmpty("software", commandOptions.software);
        queryParams.putIfNotEmpty("experiment", commandOptions.experiment);
        queryParams.putIfNotEmpty("numSamples", commandOptions.numSamples);
        queryParams.putIfNotEmpty("numRelatedFiles", commandOptions.numRelatedFiles);
        queryParams.putIfNotEmpty("annotation", commandOptions.annotation);
        queryParams.putIfNotNull("default_values", commandOptions.default_values);
        queryParams.putIfNotEmpty("field", commandOptions.field);
        if(queryParams.get("study")==null && OpencgaMain.isShellMode()){
                queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getFileClient().aggregationStats(queryParams);
    }

    private RestResponse<Job> loadAnnotationSets() throws Exception {

        logger.debug("Executing loadAnnotationSets in Files command line");

        FilesCommandOptions.LoadAnnotationSetsCommandOptions commandOptions = filesCommandOptions.loadAnnotationSetsCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotNull("parents", commandOptions.parents);
        queryParams.putIfNotEmpty("annotationSetId", commandOptions.annotationSetId);
        if(queryParams.get("study")==null && OpencgaMain.isShellMode()){
                queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }


        TsvAnnotationParams tsvAnnotationParams = (TsvAnnotationParams) new TsvAnnotationParams()
            .setContent(commandOptions.content);
        return openCGAClient.getFileClient().loadAnnotationSets(commandOptions.variableSetId, commandOptions.path, tsvAnnotationParams, queryParams);
    }

    private RestResponse<File> create() throws Exception {

        logger.debug("Executing create in Files command line");

        FilesCommandOptions.CreateCommandOptions commandOptions = filesCommandOptions.createCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotNull("parents", commandOptions.parents);
        if(queryParams.get("study")==null && OpencgaMain.isShellMode()){
                queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }


        StatusParams statusParams= new StatusParams();
        invokeSetter(statusParams, "id", commandOptions.statusId);
        invokeSetter(statusParams, "name", commandOptions.statusName);
        invokeSetter(statusParams, "description", commandOptions.statusDescription);

        Software software= new Software();
        invokeSetter(software, "name", commandOptions.softwareName);
        invokeSetter(software, "version", commandOptions.softwareVersion);
        invokeSetter(software, "repository", commandOptions.softwareRepository);
        invokeSetter(software, "commit", commandOptions.softwareCommit);
        invokeSetter(software, "website", commandOptions.softwareWebsite);
        File.Type typeParam = File.Type.valueOf(commandOptions.type);
        File.Format formatParam = File.Format.valueOf(commandOptions.format);
        File.Bioformat bioformatParam = File.Bioformat.valueOf(commandOptions.bioformat);

        FileCreateParams fileCreateParams = (FileCreateParams) new FileCreateParams()
            .setContent(commandOptions.content)
            .setPath(commandOptions.path)
            .setDescription(commandOptions.description)
            .setType(typeParam)
            .setFormat(formatParam)
            .setBioformat(bioformatParam)
            .setSampleIds(splitWithTrim(commandOptions.sampleIds))
            .setSoftware(software)
            .setTags(splitWithTrim(commandOptions.tags))
            .setJobId(commandOptions.jobId)
            .setCreationDate(commandOptions.creationDate)
            .setModificationDate(commandOptions.modificationDate)
            .setStatus(statusParams);
        return openCGAClient.getFileClient().create(fileCreateParams, queryParams);
    }

    private RestResponse<Object> distinct() throws Exception {

        logger.debug("Executing distinct in Files command line");

        FilesCommandOptions.DistinctCommandOptions commandOptions = filesCommandOptions.distinctCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("id", commandOptions.id);
        queryParams.putIfNotEmpty("uuid", commandOptions.uuid);
        queryParams.putIfNotEmpty("name", commandOptions.name);
        queryParams.putIfNotEmpty("path", commandOptions.path);
        queryParams.putIfNotEmpty("uri", commandOptions.uri);
        queryParams.putIfNotEmpty("type", commandOptions.type);
        queryParams.putIfNotEmpty("bioformat", commandOptions.bioformat);
        queryParams.putIfNotEmpty("format", commandOptions.format);
        queryParams.putIfNotNull("external", commandOptions.external);
        queryParams.putIfNotEmpty("status", commandOptions.status);
        queryParams.putIfNotEmpty("internalStatus", commandOptions.internalStatus);
        queryParams.putIfNotEmpty("internalVariantIndexStatus", commandOptions.internalVariantIndexStatus);
        queryParams.putIfNotEmpty("softwareName", commandOptions.softwareName);
        queryParams.putIfNotEmpty("directory", commandOptions.directory);
        queryParams.putIfNotEmpty("creationDate", commandOptions.creationDate);
        queryParams.putIfNotEmpty("modificationDate", commandOptions.modificationDate);
        queryParams.putIfNotEmpty("description", commandOptions.description);
        queryParams.putIfNotEmpty("tags", commandOptions.tags);
        queryParams.putIfNotEmpty("size", commandOptions.size);
        queryParams.putIfNotEmpty("sampleIds", commandOptions.sampleIds);
        queryParams.putIfNotEmpty("jobId", commandOptions.jobId);
        queryParams.putIfNotEmpty("annotation", commandOptions.annotation);
        queryParams.putIfNotEmpty("acl", commandOptions.acl);
        queryParams.putIfNotNull("deleted", commandOptions.deleted);
        queryParams.putIfNotEmpty("release", commandOptions.release);
        if(queryParams.get("study")==null && OpencgaMain.isShellMode()){
                queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getFileClient().distinct(commandOptions.field, queryParams);
    }

    private RestResponse<Job> fetch() throws Exception {

        logger.debug("Executing fetch in Files command line");

        FilesCommandOptions.FetchCommandOptions commandOptions = filesCommandOptions.fetchCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("jobId", commandOptions.jobId);
        queryParams.putIfNotEmpty("jobDescription", commandOptions.jobDescription);
        queryParams.putIfNotEmpty("jobDependsOn", commandOptions.jobDependsOn);
        queryParams.putIfNotEmpty("jobTags", commandOptions.jobTags);
        queryParams.putIfNotEmpty("study", commandOptions.study);
        if(queryParams.get("study")==null && OpencgaMain.isShellMode()){
                queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }


        FileFetch fileFetch = (FileFetch) new FileFetch()
            .setUrl(commandOptions.url)
            .setPath(commandOptions.path);
        return openCGAClient.getFileClient().fetch(fileFetch, queryParams);
    }

    private RestResponse<File> link() throws Exception {

        logger.debug("Executing link in Files command line");

        FilesCommandOptions.LinkCommandOptions commandOptions = filesCommandOptions.linkCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotNull("parents", commandOptions.parents);
        if(queryParams.get("study")==null && OpencgaMain.isShellMode()){
                queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }


        StatusParams statusParams= new StatusParams();
        invokeSetter(statusParams, "id", commandOptions.statusId);
        invokeSetter(statusParams, "name", commandOptions.statusName);
        invokeSetter(statusParams, "description", commandOptions.statusDescription);

        FileLinkParams fileLinkParams = (FileLinkParams) new FileLinkParams()
            .setUri(commandOptions.uri)
            .setPath(commandOptions.path)
            .setDescription(commandOptions.description)
            .setCreationDate(commandOptions.creationDate)
            .setModificationDate(commandOptions.modificationDate)
            .setStatus(statusParams);
        return openCGAClient.getFileClient().link(fileLinkParams, queryParams);
    }

    private RestResponse<Job> runLink() throws Exception {

        logger.debug("Executing runLink in Files command line");

        FilesCommandOptions.RunLinkCommandOptions commandOptions = filesCommandOptions.runLinkCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("jobId", commandOptions.jobId);
        queryParams.putIfNotEmpty("jobDependsOn", commandOptions.jobDependsOn);
        queryParams.putIfNotEmpty("jobDescription", commandOptions.jobDescription);
        queryParams.putIfNotEmpty("jobTags", commandOptions.jobTags);
        if(queryParams.get("study")==null && OpencgaMain.isShellMode()){
                queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }


        FileLinkToolParams fileLinkToolParams = (FileLinkToolParams) new FileLinkToolParams()
            .setUri(splitWithTrim(commandOptions.uri))
            .setPath(commandOptions.path)
            .setDescription(commandOptions.description)
            .setParents(commandOptions.parents);
        return openCGAClient.getFileClient().runLink(fileLinkToolParams, queryParams);
    }

    private RestResponse<Job> runPostlink() throws Exception {

        logger.debug("Executing runPostlink in Files command line");

        FilesCommandOptions.RunPostlinkCommandOptions commandOptions = filesCommandOptions.runPostlinkCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("jobId", commandOptions.jobId);
        queryParams.putIfNotEmpty("jobDependsOn", commandOptions.jobDependsOn);
        queryParams.putIfNotEmpty("jobDescription", commandOptions.jobDescription);
        queryParams.putIfNotEmpty("jobTags", commandOptions.jobTags);
        if(queryParams.get("study")==null && OpencgaMain.isShellMode()){
                queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }


        PostLinkToolParams postLinkToolParams = (PostLinkToolParams) new PostLinkToolParams()
            .setFiles(splitWithTrim(commandOptions.files))
            .setBatchSize(commandOptions.batchSize);
        return openCGAClient.getFileClient().runPostlink(postLinkToolParams, queryParams);
    }

    private RestResponse<File> search() throws Exception {

        logger.debug("Executing search in Files command line");

        FilesCommandOptions.SearchCommandOptions commandOptions = filesCommandOptions.searchCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("include", commandOptions.include);
        queryParams.putIfNotEmpty("exclude", commandOptions.exclude);
        queryParams.putIfNotNull("limit", commandOptions.limit);
        queryParams.putIfNotNull("skip", commandOptions.skip);
        queryParams.putIfNotNull("count", commandOptions.count);
        queryParams.putIfNotNull("flattenAnnotations", commandOptions.flattenAnnotations);
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("id", commandOptions.id);
        queryParams.putIfNotEmpty("uuid", commandOptions.uuid);
        queryParams.putIfNotEmpty("name", commandOptions.name);
        queryParams.putIfNotEmpty("path", commandOptions.path);
        queryParams.putIfNotEmpty("uri", commandOptions.uri);
        queryParams.putIfNotEmpty("type", commandOptions.type);
        queryParams.putIfNotEmpty("bioformat", commandOptions.bioformat);
        queryParams.putIfNotEmpty("format", commandOptions.format);
        queryParams.putIfNotNull("external", commandOptions.external);
        queryParams.putIfNotEmpty("status", commandOptions.status);
        queryParams.putIfNotEmpty("internalStatus", commandOptions.internalStatus);
        queryParams.putIfNotEmpty("internalVariantIndexStatus", commandOptions.internalVariantIndexStatus);
        queryParams.putIfNotEmpty("softwareName", commandOptions.softwareName);
        queryParams.putIfNotEmpty("directory", commandOptions.directory);
        queryParams.putIfNotEmpty("creationDate", commandOptions.creationDate);
        queryParams.putIfNotEmpty("modificationDate", commandOptions.modificationDate);
        queryParams.putIfNotEmpty("description", commandOptions.description);
        queryParams.putIfNotEmpty("tags", commandOptions.tags);
        queryParams.putIfNotEmpty("size", commandOptions.size);
        queryParams.putIfNotEmpty("sampleIds", commandOptions.sampleIds);
        queryParams.putIfNotEmpty("jobId", commandOptions.jobId);
        queryParams.putIfNotEmpty("annotation", commandOptions.annotation);
        queryParams.putIfNotEmpty("acl", commandOptions.acl);
        queryParams.putIfNotNull("deleted", commandOptions.deleted);
        queryParams.putIfNotEmpty("release", commandOptions.release);
        if(queryParams.get("study")==null && OpencgaMain.isShellMode()){
                queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getFileClient().search(queryParams);
    }

    private RestResponse<ObjectMap> acl() throws Exception {

        logger.debug("Executing acl in Files command line");

        FilesCommandOptions.AclCommandOptions commandOptions = filesCommandOptions.aclCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("member", commandOptions.member);
        queryParams.putIfNotNull("silent", commandOptions.silent);
        if(queryParams.get("study")==null && OpencgaMain.isShellMode()){
                queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getFileClient().acl(commandOptions.files, queryParams);
    }

    private RestResponse<Job> delete() throws Exception {

        logger.debug("Executing delete in Files command line");

        FilesCommandOptions.DeleteCommandOptions commandOptions = filesCommandOptions.deleteCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotNull("skipTrash", commandOptions.skipTrash);
        if(queryParams.get("study")==null && OpencgaMain.isShellMode()){
                queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getFileClient().delete(commandOptions.files, queryParams);
    }

    private RestResponse<File> info() throws Exception {

        logger.debug("Executing info in Files command line");

        FilesCommandOptions.InfoCommandOptions commandOptions = filesCommandOptions.infoCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("include", commandOptions.include);
        queryParams.putIfNotEmpty("exclude", commandOptions.exclude);
        queryParams.putIfNotNull("flattenAnnotations", commandOptions.flattenAnnotations);
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotNull("deleted", commandOptions.deleted);
        if(queryParams.get("study")==null && OpencgaMain.isShellMode()){
                queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getFileClient().info(commandOptions.files, queryParams);
    }

    private RestResponse<Job> unlink() throws Exception {

        logger.debug("Executing unlink in Files command line");

        FilesCommandOptions.UnlinkCommandOptions commandOptions = filesCommandOptions.unlinkCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        if(queryParams.get("study")==null && OpencgaMain.isShellMode()){
                queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getFileClient().unlink(commandOptions.files, queryParams);
    }

    private RestResponse<File> update() throws Exception {

        logger.debug("Executing update in Files command line");

        FilesCommandOptions.UpdateCommandOptions commandOptions = filesCommandOptions.updateCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("include", commandOptions.include);
        queryParams.putIfNotEmpty("exclude", commandOptions.exclude);
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotNull("sampleIdsAction", commandOptions.sampleIdsAction);
        if(queryParams.get("study")==null && OpencgaMain.isShellMode()){
                queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }


        StatusParams statusParams= new StatusParams();
        invokeSetter(statusParams, "id", commandOptions.statusId);
        invokeSetter(statusParams, "name", commandOptions.statusName);
        invokeSetter(statusParams, "description", commandOptions.statusDescription);

        FileExperiment fileExperiment= new FileExperiment();
        invokeSetter(fileExperiment, "manufacturer", commandOptions.experimentManufacturer);
        invokeSetter(fileExperiment, "platform", commandOptions.experimentPlatform);
        invokeSetter(fileExperiment, "library", commandOptions.experimentLibrary);
        invokeSetter(fileExperiment, "date", commandOptions.experimentDate);
        invokeSetter(fileExperiment, "center", commandOptions.experimentCenter);
        invokeSetter(fileExperiment, "lab", commandOptions.experimentLab);
        invokeSetter(fileExperiment, "responsible", commandOptions.experimentResponsible);
        invokeSetter(fileExperiment, "description", commandOptions.experimentDescription);

        Software software= new Software();
        invokeSetter(software, "name", commandOptions.softwareName);
        invokeSetter(software, "version", commandOptions.softwareVersion);
        invokeSetter(software, "repository", commandOptions.softwareRepository);
        invokeSetter(software, "commit", commandOptions.softwareCommit);
        invokeSetter(software, "website", commandOptions.softwareWebsite);
        File.Format formatParam = File.Format.valueOf(commandOptions.format);
        File.Bioformat bioformatParam = File.Bioformat.valueOf(commandOptions.bioformat);

        FileUpdateParams fileUpdateParams = (FileUpdateParams) new FileUpdateParams()
            .setName(commandOptions.name)
            .setDescription(commandOptions.description)
            .setCreationDate(commandOptions.creationDate)
            .setModificationDate(commandOptions.modificationDate)
            .setSampleIds(splitWithTrim(commandOptions.sampleIds))
            .setChecksum(commandOptions.checksum)
            .setSoftware(software)
            .setExperiment(fileExperiment)
            .setTags(splitWithTrim(commandOptions.tags))
            .setSize(commandOptions.size)
            .setStatus(statusParams);
        return openCGAClient.getFileClient().update(commandOptions.files, fileUpdateParams, queryParams);
    }

    private RestResponse<DataInputStream> download() throws Exception {

        logger.debug("Executing download in Files command line");

        FilesCommandOptions.DownloadCommandOptions commandOptions = filesCommandOptions.downloadCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        if(queryParams.get("study")==null && OpencgaMain.isShellMode()){
                queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getFileClient().download(commandOptions.file, queryParams);
    }

    private RestResponse<FileContent> grep() throws Exception {

        logger.debug("Executing grep in Files command line");

        FilesCommandOptions.GrepCommandOptions commandOptions = filesCommandOptions.grepCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("pattern", commandOptions.pattern);
        queryParams.putIfNotNull("ignoreCase", commandOptions.ignoreCase);
        queryParams.putIfNotNull("maxCount", commandOptions.maxCount);
        if(queryParams.get("study")==null && OpencgaMain.isShellMode()){
                queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getFileClient().grep(commandOptions.file, queryParams);
    }

    private RestResponse<FileContent> head() throws Exception {

        logger.debug("Executing head in Files command line");

        FilesCommandOptions.HeadCommandOptions commandOptions = filesCommandOptions.headCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotNull("offset", commandOptions.offset);
        queryParams.putIfNotNull("lines", commandOptions.lines);
        if(queryParams.get("study")==null && OpencgaMain.isShellMode()){
                queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getFileClient().head(commandOptions.file, queryParams);
    }

    private RestResponse<FileContent> image() throws Exception {

        logger.debug("Executing image in Files command line");

        FilesCommandOptions.ImageCommandOptions commandOptions = filesCommandOptions.imageCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        if(queryParams.get("study")==null && OpencgaMain.isShellMode()){
                queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getFileClient().image(commandOptions.file, queryParams);
    }

    private RestResponse<File> refresh() throws Exception {

        logger.debug("Executing refresh in Files command line");

        FilesCommandOptions.RefreshCommandOptions commandOptions = filesCommandOptions.refreshCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        if(queryParams.get("study")==null && OpencgaMain.isShellMode()){
                queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getFileClient().refresh(commandOptions.file, queryParams);
    }

    private RestResponse<FileContent> tail() throws Exception {

        logger.debug("Executing tail in Files command line");

        FilesCommandOptions.TailCommandOptions commandOptions = filesCommandOptions.tailCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotNull("lines", commandOptions.lines);
        if(queryParams.get("study")==null && OpencgaMain.isShellMode()){
                queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getFileClient().tail(commandOptions.file, queryParams);
    }

    private RestResponse<File> list() throws Exception {

        logger.debug("Executing list in Files command line");

        FilesCommandOptions.ListCommandOptions commandOptions = filesCommandOptions.listCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("include", commandOptions.include);
        queryParams.putIfNotEmpty("exclude", commandOptions.exclude);
        queryParams.putIfNotNull("limit", commandOptions.limit);
        queryParams.putIfNotNull("skip", commandOptions.skip);
        queryParams.putIfNotNull("count", commandOptions.count);
        queryParams.putIfNotEmpty("study", commandOptions.study);
        if(queryParams.get("study")==null && OpencgaMain.isShellMode()){
                queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getFileClient().list(commandOptions.folder, queryParams);
    }

    private RestResponse<FileTree> tree() throws Exception {

        logger.debug("Executing tree in Files command line");

        FilesCommandOptions.TreeCommandOptions commandOptions = filesCommandOptions.treeCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("include", commandOptions.include);
        queryParams.putIfNotEmpty("exclude", commandOptions.exclude);
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotNull("maxDepth", commandOptions.maxDepth);
        if(queryParams.get("study")==null && OpencgaMain.isShellMode()){
                queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getFileClient().tree(commandOptions.folder, queryParams);
    }
}