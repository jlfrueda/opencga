package org.opencb.opencga.app.cli.main.executors;

import org.opencb.opencga.app.cli.main.executors.OpencgaCommandExecutor;
import org.opencb.opencga.app.cli.main.*;
import org.opencb.opencga.core.response.RestResponse;
import org.opencb.opencga.client.exceptions.ClientException;
import org.opencb.commons.datastore.core.ObjectMap;

import org.opencb.opencga.catalog.exceptions.CatalogAuthenticationException;

import java.util.List;

import org.opencb.opencga.app.cli.main.options.JobsCommandOptions;

import org.opencb.opencga.core.models.job.JobTop;
import org.opencb.opencga.core.models.job.Job;
import org.opencb.opencga.core.models.job.JobRetryParams;
import java.util.Map;
import org.opencb.commons.datastore.core.FacetField;
import org.opencb.opencga.core.models.job.JobAclUpdateParams;
import org.opencb.opencga.core.tools.result.ExecutionResult;
import org.opencb.opencga.core.models.file.FileContent;
import org.opencb.opencga.catalog.utils.ParamUtils.AclAction;
import org.opencb.opencga.core.models.job.JobCreateParams;
import org.opencb.opencga.core.models.job.ToolInfo;
import org.opencb.opencga.core.models.job.JobUpdateParams;


/*
* WARNING: AUTOGENERATED CODE
*
* This code was generated by a tool.
* Autogenerated on: 2022-02-03
*
* Manual changes to this file may cause unexpected behavior in your application.
* Manual changes to this file will be overwritten if the code is regenerated.
*/


/**
 * This class contains methods for the Jobs command line.
 *    OpenCGA version: 2.2.0-SNAPSHOT
 *    PATH: /{apiVersion}/jobs
 */
public class JobsCommandExecutor extends OpencgaCommandExecutor {

    private JobsCommandOptions jobsCommandOptions;

    public JobsCommandExecutor(JobsCommandOptions jobsCommandOptions) throws CatalogAuthenticationException {
        super(jobsCommandOptions.commonCommandOptions);
        this.jobsCommandOptions = jobsCommandOptions;
    }

    @Override
    public void execute() throws Exception {

        logger.debug("Executing Jobs command line");

        String subCommandString = getParsedSubCommand(jobsCommandOptions.jCommander);

        RestResponse queryResponse = null;

        switch (subCommandString) {
            case "acl-update":
                queryResponse = updateAcl();
                break;
            case "aggregationStats":
                queryResponse = aggregationStats();
                break;
            case "create":
                queryResponse = create();
                break;
            case "distinct":
                queryResponse = distinct();
                break;
            case "retry":
                queryResponse = retry();
                break;
            case "search":
                queryResponse = search();
                break;
            case "top":
                queryResponse = top();
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
            case "update":
                queryResponse = update();
                break;
            case "log-head":
                queryResponse = headLog();
                break;
            case "log-tail":
                queryResponse = tailLog();
                break;
            default:
                logger.error("Subcommand not valid");
                break;
        }

        createOutput(queryResponse);

    }

    private RestResponse<ObjectMap> updateAcl() throws Exception {

        logger.debug("Executing updateAcl in Jobs command line");

        JobsCommandOptions.UpdateAclCommandOptions commandOptions = jobsCommandOptions.updateAclCommandOptions;

        JobAclUpdateParams jobAclUpdateParams = (JobAclUpdateParams) new JobAclUpdateParams()
            .setJob(commandOptions.job)
            .setPermissions(commandOptions.permissions);
        return openCGAClient.getJobClient().updateAcl(commandOptions.members, commandOptions.action, jobAclUpdateParams);
    }

    private RestResponse<FacetField> aggregationStats() throws Exception {

        logger.debug("Executing aggregationStats in Jobs command line");

        JobsCommandOptions.AggregationStatsCommandOptions commandOptions = jobsCommandOptions.aggregationStatsCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("toolId", commandOptions.toolId);
        queryParams.putIfNotEmpty("toolScope", commandOptions.toolScope);
        queryParams.putIfNotEmpty("toolType", commandOptions.toolType);
        queryParams.putIfNotEmpty("toolResource", commandOptions.toolResource);
        queryParams.putIfNotEmpty("userId", commandOptions.userId);
        queryParams.putIfNotEmpty("priority", commandOptions.priority);
        queryParams.putIfNotEmpty("tags", commandOptions.tags);
        queryParams.putIfNotEmpty("executorId", commandOptions.executorId);
        queryParams.putIfNotEmpty("executorFramework", commandOptions.executorFramework);
        queryParams.putIfNotEmpty("creationYear", commandOptions.creationYear);
        queryParams.putIfNotEmpty("creationMonth", commandOptions.creationMonth);
        queryParams.putIfNotEmpty("creationDay", commandOptions.creationDay);
        queryParams.putIfNotEmpty("creationDayOfWeek", commandOptions.creationDayOfWeek);
        queryParams.putIfNotEmpty("status", commandOptions.status);
        queryParams.putIfNotEmpty("release", commandOptions.release);
        queryParams.putIfNotNull("default_values", commandOptions.default_values);
        queryParams.putIfNotEmpty("field", commandOptions.field);
        if(queryParams.get("study")==null && OpencgaMain.isShellMode()){
                queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getJobClient().aggregationStats(queryParams);
    }

    private RestResponse<Job> create() throws Exception {

        logger.debug("Executing create in Jobs command line");

        JobsCommandOptions.CreateCommandOptions commandOptions = jobsCommandOptions.createCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        if(queryParams.get("study")==null && OpencgaMain.isShellMode()){
                queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }


        ToolInfo toolInfo= new ToolInfo();
        invokeSetter(toolInfo, "id", commandOptions.toolId);
        invokeSetter(toolInfo, "description", commandOptions.toolDescription);

        ExecutionResult executionResult= new ExecutionResult();
        invokeSetter(executionResult, "id", commandOptions.resultId);

        JobCreateParams jobCreateParams = (JobCreateParams) new JobCreateParams()
            .setId(commandOptions.id)
            .setDescription(commandOptions.description)
            .setTool(toolInfo)
            .setCommandLine(commandOptions.commandLine)
            .setCreationDate(commandOptions.creationDate)
            .setModificationDate(commandOptions.modificationDate)
            .setTags(splitWithTrim(commandOptions.tags))
            .setResult(executionResult);
        return openCGAClient.getJobClient().create(jobCreateParams, queryParams);
    }

    private RestResponse<Object> distinct() throws Exception {

        logger.debug("Executing distinct in Jobs command line");

        JobsCommandOptions.DistinctCommandOptions commandOptions = jobsCommandOptions.distinctCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotNull("otherStudies", commandOptions.otherStudies);
        queryParams.putIfNotEmpty("id", commandOptions.id);
        queryParams.putIfNotEmpty("uuid", commandOptions.uuid);
        queryParams.putIfNotEmpty("toolId", commandOptions.toolId);
        queryParams.putIfNotEmpty("toolType", commandOptions.toolType);
        queryParams.putIfNotEmpty("userId", commandOptions.userId);
        queryParams.putIfNotEmpty("priority", commandOptions.priority);
        queryParams.putIfNotEmpty("status", commandOptions.status);
        queryParams.putIfNotEmpty("internalStatus", commandOptions.internalStatus);
        queryParams.putIfNotEmpty("creationDate", commandOptions.creationDate);
        queryParams.putIfNotEmpty("modificationDate", commandOptions.modificationDate);
        queryParams.putIfNotNull("visited", commandOptions.visited);
        queryParams.putIfNotEmpty("tags", commandOptions.tags);
        queryParams.putIfNotEmpty("input", commandOptions.input);
        queryParams.putIfNotEmpty("output", commandOptions.output);
        queryParams.putIfNotEmpty("acl", commandOptions.acl);
        queryParams.putIfNotEmpty("release", commandOptions.release);
        queryParams.putIfNotNull("deleted", commandOptions.deleted);
        if(queryParams.get("study")==null && OpencgaMain.isShellMode()){
                queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getJobClient().distinct(commandOptions.field, queryParams);
    }

    private RestResponse<Job> retry() throws Exception {

        logger.debug("Executing retry in Jobs command line");

        JobsCommandOptions.RetryCommandOptions commandOptions = jobsCommandOptions.retryCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("jobId", commandOptions.jobId);
        queryParams.putIfNotEmpty("jobDescription", commandOptions.jobDescription);
        queryParams.putIfNotEmpty("jobDependsOn", commandOptions.jobDependsOn);
        queryParams.putIfNotEmpty("jobTags", commandOptions.jobTags);
        queryParams.putIfNotEmpty("study", commandOptions.study);
        if(queryParams.get("study")==null && OpencgaMain.isShellMode()){
                queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }


        JobRetryParams jobRetryParams = (JobRetryParams) new JobRetryParams()
            .setJob(commandOptions.job);
        return openCGAClient.getJobClient().retry(jobRetryParams, queryParams);
    }

    private RestResponse<Job> search() throws Exception {

        logger.debug("Executing search in Jobs command line");

        JobsCommandOptions.SearchCommandOptions commandOptions = jobsCommandOptions.searchCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("include", commandOptions.include);
        queryParams.putIfNotEmpty("exclude", commandOptions.exclude);
        queryParams.putIfNotNull("limit", commandOptions.limit);
        queryParams.putIfNotNull("skip", commandOptions.skip);
        queryParams.putIfNotNull("count", commandOptions.count);
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotNull("otherStudies", commandOptions.otherStudies);
        queryParams.putIfNotEmpty("id", commandOptions.id);
        queryParams.putIfNotEmpty("uuid", commandOptions.uuid);
        queryParams.putIfNotEmpty("toolId", commandOptions.toolId);
        queryParams.putIfNotEmpty("toolType", commandOptions.toolType);
        queryParams.putIfNotEmpty("userId", commandOptions.userId);
        queryParams.putIfNotEmpty("priority", commandOptions.priority);
        queryParams.putIfNotEmpty("status", commandOptions.status);
        queryParams.putIfNotEmpty("internalStatus", commandOptions.internalStatus);
        queryParams.putIfNotEmpty("creationDate", commandOptions.creationDate);
        queryParams.putIfNotEmpty("modificationDate", commandOptions.modificationDate);
        queryParams.putIfNotNull("visited", commandOptions.visited);
        queryParams.putIfNotEmpty("tags", commandOptions.tags);
        queryParams.putIfNotEmpty("input", commandOptions.input);
        queryParams.putIfNotEmpty("output", commandOptions.output);
        queryParams.putIfNotEmpty("acl", commandOptions.acl);
        queryParams.putIfNotEmpty("release", commandOptions.release);
        queryParams.putIfNotNull("deleted", commandOptions.deleted);
        if(queryParams.get("study")==null && OpencgaMain.isShellMode()){
                queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getJobClient().search(queryParams);
    }

    private RestResponse<JobTop> top() throws Exception {

        logger.debug("Executing top in Jobs command line");

        JobsCommandOptions.TopCommandOptions commandOptions = jobsCommandOptions.topCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotNull("limit", commandOptions.limit);
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotEmpty("internalStatus", commandOptions.internalStatus);
        queryParams.putIfNotEmpty("priority", commandOptions.priority);
        queryParams.putIfNotEmpty("userId", commandOptions.userId);
        queryParams.putIfNotEmpty("toolId", commandOptions.toolId);
        if(queryParams.get("study")==null && OpencgaMain.isShellMode()){
                queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getJobClient().top(queryParams);
    }

    private RestResponse<ObjectMap> acl() throws Exception {

        logger.debug("Executing acl in Jobs command line");

        JobsCommandOptions.AclCommandOptions commandOptions = jobsCommandOptions.aclCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("member", commandOptions.member);
        queryParams.putIfNotNull("silent", commandOptions.silent);

        return openCGAClient.getJobClient().acl(commandOptions.jobs, queryParams);
    }

    private RestResponse<Job> delete() throws Exception {

        logger.debug("Executing delete in Jobs command line");

        JobsCommandOptions.DeleteCommandOptions commandOptions = jobsCommandOptions.deleteCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        if(queryParams.get("study")==null && OpencgaMain.isShellMode()){
                queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getJobClient().delete(commandOptions.jobs, queryParams);
    }

    private RestResponse<Job> info() throws Exception {

        logger.debug("Executing info in Jobs command line");

        JobsCommandOptions.InfoCommandOptions commandOptions = jobsCommandOptions.infoCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("include", commandOptions.include);
        queryParams.putIfNotEmpty("exclude", commandOptions.exclude);
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotNull("deleted", commandOptions.deleted);
        if(queryParams.get("study")==null && OpencgaMain.isShellMode()){
                queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getJobClient().info(commandOptions.jobs, queryParams);
    }

    private RestResponse<Job> update() throws Exception {

        logger.debug("Executing update in Jobs command line");

        JobsCommandOptions.UpdateCommandOptions commandOptions = jobsCommandOptions.updateCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("include", commandOptions.include);
        queryParams.putIfNotEmpty("exclude", commandOptions.exclude);
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotNull("includeResult", commandOptions.includeResult);
        if(queryParams.get("study")==null && OpencgaMain.isShellMode()){
                queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }


        JobUpdateParams jobUpdateParams = (JobUpdateParams) new JobUpdateParams()
            .setDescription(commandOptions.description)
            .setTags(splitWithTrim(commandOptions.tags))
            .setVisited(commandOptions.visited);
        return openCGAClient.getJobClient().update(commandOptions.jobs, jobUpdateParams, queryParams);
    }

    private RestResponse<FileContent> headLog() throws Exception {

        logger.debug("Executing headLog in Jobs command line");

        JobsCommandOptions.HeadLogCommandOptions commandOptions = jobsCommandOptions.headLogCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotNull("offset", commandOptions.offset);
        queryParams.putIfNotNull("lines", commandOptions.lines);
        queryParams.putIfNotEmpty("type", commandOptions.type);
        if(queryParams.get("study")==null && OpencgaMain.isShellMode()){
                queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getJobClient().headLog(commandOptions.job, queryParams);
    }

    private RestResponse<FileContent> tailLog() throws Exception {

        logger.debug("Executing tailLog in Jobs command line");

        JobsCommandOptions.TailLogCommandOptions commandOptions = jobsCommandOptions.tailLogCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        queryParams.putIfNotNull("lines", commandOptions.lines);
        queryParams.putIfNotEmpty("type", commandOptions.type);
        if(queryParams.get("study")==null && OpencgaMain.isShellMode()){
                queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getJobClient().tailLog(commandOptions.job, queryParams);
    }
}