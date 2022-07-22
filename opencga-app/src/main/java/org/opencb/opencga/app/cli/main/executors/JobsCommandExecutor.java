package org.opencb.opencga.app.cli.main.executors;

import org.opencb.opencga.app.cli.main.executors.OpencgaCommandExecutor;
import org.opencb.opencga.app.cli.main.*;
import org.opencb.opencga.core.response.RestResponse;
import org.opencb.opencga.client.exceptions.ClientException;
import org.opencb.commons.datastore.core.ObjectMap;

import org.opencb.opencga.catalog.exceptions.CatalogAuthenticationException;
import org.opencb.opencga.core.common.JacksonUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.HashMap;
import org.opencb.opencga.core.response.QueryType;
import org.opencb.commons.utils.PrintUtils;

import org.opencb.opencga.app.cli.main.options.JobsCommandOptions;

import org.opencb.opencga.app.cli.main.parent.ParentJobsCommandExecutor;

import java.util.Date;
import java.util.Map;
import org.opencb.commons.datastore.core.FacetField;
import org.opencb.commons.datastore.core.ObjectMap;
import org.opencb.opencga.catalog.utils.ParamUtils.AclAction;
import org.opencb.opencga.core.models.common.Enums;
import org.opencb.opencga.core.models.file.FileContent;
import org.opencb.opencga.core.models.job.Job;
import org.opencb.opencga.core.models.job.JobAclUpdateParams;
import org.opencb.opencga.core.models.job.JobCreateParams;
import org.opencb.opencga.core.models.job.JobRetryParams;
import org.opencb.opencga.core.models.job.JobTop;
import org.opencb.opencga.core.models.job.JobUpdateParams;
import org.opencb.opencga.core.models.job.ToolInfo;
import org.opencb.opencga.core.tools.annotations.Tool;
import org.opencb.opencga.core.tools.result.ExecutionResult;
import org.opencb.opencga.core.tools.result.ExecutorInfo;
import org.opencb.opencga.core.tools.result.Status;


/*
* WARNING: AUTOGENERATED CODE
*
* This code was generated by a tool.
<<<<<<< HEAD
* Autogenerated on: 2022-06-21
=======
* Autogenerated on: 2022-07-13
>>>>>>> release-2.2.x
*
* Manual changes to this file may cause unexpected behavior in your application.
* Manual changes to this file will be overwritten if the code is regenerated.
*/


/**
 * This class contains methods for the Jobs command line.
<<<<<<< HEAD
 *    OpenCGA version: 2.3.1-SNAPSHOT
=======
 *    OpenCGA version: 2.2.4-SNAPSHOT
>>>>>>> release-2.2.x
 *    PATH: /{apiVersion}/jobs
 */
public class JobsCommandExecutor extends ParentJobsCommandExecutor {

    private JobsCommandOptions jobsCommandOptions;

    public JobsCommandExecutor(JobsCommandOptions jobsCommandOptions) throws CatalogAuthenticationException {
        super(jobsCommandOptions.commonCommandOptions,jobsCommandOptions);
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
            case "aggregationstats":
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
            case "log":
                queryResponse = log();
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

        JobAclUpdateParams jobAclUpdateParams= null;
        if (commandOptions.jsonDataModel) {
            jobAclUpdateParams = new JobAclUpdateParams();
            RestResponse<ObjectMap> res = new RestResponse<>();
            res.setType(QueryType.VOID);
            PrintUtils.println(getObjectAsJSON(jobAclUpdateParams));
            return res;
        } else if (commandOptions.jsonFile != null) {
            jobAclUpdateParams = JacksonUtils.getDefaultObjectMapper()
                    .readValue(new java.io.File(commandOptions.jsonFile), JobAclUpdateParams.class);
        } else {
<<<<<<< HEAD
            jobAclUpdateParams.setPermissions(commandOptions.permissions);
            jobAclUpdateParams.setJob(commandOptions.job);

=======
            ObjectMap beanParams = new ObjectMap();
            putNestedIfNotEmpty(beanParams, "job",commandOptions.job, true);
             putNestedIfNotEmpty(beanParams, "permissions",commandOptions.permissions, true);
 
            jobAclUpdateParams = JacksonUtils.getDefaultObjectMapper()
                    .readValue(beanParams.toJson(), JobAclUpdateParams.class);
>>>>>>> release-2.2.x
        }
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
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getJobClient().aggregationStats(queryParams);
    }

    private RestResponse<Job> create() throws Exception {

        logger.debug("Executing create in Jobs command line");

        JobsCommandOptions.CreateCommandOptions commandOptions = jobsCommandOptions.createCommandOptions;

        ObjectMap queryParams = new ObjectMap();
        queryParams.putIfNotEmpty("study", commandOptions.study);
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }


<<<<<<< HEAD
        JobCreateParams jobCreateParams = new JobCreateParams();
=======
        JobCreateParams jobCreateParams= null;
>>>>>>> release-2.2.x
        if (commandOptions.jsonDataModel) {
            jobCreateParams = new JobCreateParams();
            RestResponse<Job> res = new RestResponse<>();
            res.setType(QueryType.VOID);
            PrintUtils.println(getObjectAsJSON(jobCreateParams));
            return res;
        } else if (commandOptions.jsonFile != null) {
            jobCreateParams = JacksonUtils.getDefaultObjectMapper()
                    .readValue(new java.io.File(commandOptions.jsonFile), JobCreateParams.class);
        } else {
<<<<<<< HEAD
            // Generate beans for nested objects
            ToolInfo toolParam = new ToolInfo();
            toolParam.setId(commandOptions.toolId);
            toolParam.setDescription(commandOptions.toolDescription);
            toolParam.setScope(commandOptions.toolScope == null ? null : Tool.Scope.valueOf(commandOptions.toolScope));
            toolParam.setType(commandOptions.toolType == null ? null : Tool.Type.valueOf(commandOptions.toolType));
            toolParam.setResource(commandOptions.toolResource == null ? null : Enums.Resource.valueOf(commandOptions.toolResource));

            JobCreateParams.JobInternal internalParam = new JobCreateParams.JobInternal();
            //internalParam.setStatus(commandOptions.internalStatus);  // Unsupported param. FIXME

            JobCreateParams.TinyFile outDirParam = new JobCreateParams.TinyFile();
            outDirParam.setPath(commandOptions.outDirPath);

            ExecutionResult resultParam = new ExecutionResult();
            resultParam.setId(commandOptions.resultId);
            //resultParam.setExecutor(commandOptions.resultExecutor);  // Unsupported param. FIXME
            //resultParam.setStart(commandOptions.resultStart);  // Unsupported param. FIXME
            //resultParam.setEnd(commandOptions.resultEnd);  // Unsupported param. FIXME
            //resultParam.setStatus(commandOptions.resultStatus);  // Unsupported param. FIXME
            //resultParam.setExternalFiles(commandOptions.resultExternalFiles);  // Unsupported param. FIXME
            //resultParam.setSteps(commandOptions.resultSteps);  // Unsupported param. FIXME
            //resultParam.setEvents(commandOptions.resultEvents);  // Unsupported param. FIXME
            resultParam.setAttributes(new ObjectMap(commandOptions.resultAttributes));

            JobCreateParams.TinyFile stdoutParam = new JobCreateParams.TinyFile();
            stdoutParam.setPath(commandOptions.stdoutPath);

            JobCreateParams.TinyFile stderrParam = new JobCreateParams.TinyFile();
            stderrParam.setPath(commandOptions.stderrPath);

            //Set main body params
            jobCreateParams.setId(commandOptions.id);
            jobCreateParams.setDescription(commandOptions.description);
            jobCreateParams.setTool(toolParam);
            jobCreateParams.setPriority(commandOptions.priority == null ? null : Enums.Priority.valueOf(commandOptions.priority));
            jobCreateParams.setCommandLine(commandOptions.commandLine);
            jobCreateParams.setParams(new HashMap<>(commandOptions.params));
            jobCreateParams.setCreationDate(commandOptions.creationDate);
            jobCreateParams.setModificationDate(commandOptions.modificationDate);
            jobCreateParams.setInternal(internalParam);
            jobCreateParams.setOutDir(outDirParam);
            //jobCreateParams.setInput(commandOptions.input); // Unsupported param. FIXME 
            //jobCreateParams.setOutput(commandOptions.output); // Unsupported param. FIXME 
            jobCreateParams.setTags(splitWithTrim(commandOptions.tags));
            jobCreateParams.setResult(resultParam);
            jobCreateParams.setStdout(stdoutParam);
            jobCreateParams.setStderr(stderrParam);
            jobCreateParams.setAttributes(new HashMap<>(commandOptions.attributes));

=======
            ObjectMap beanParams = new ObjectMap();
            putNestedIfNotEmpty(beanParams, "id",commandOptions.id, true);
             putNestedIfNotEmpty(beanParams, "description",commandOptions.description, true);
             putNestedIfNotEmpty(beanParams, "tool.id",commandOptions.toolId, true);
             putNestedIfNotEmpty(beanParams, "tool.description",commandOptions.toolDescription, true);
             putNestedIfNotEmpty(beanParams, "commandLine",commandOptions.commandLine, true);
             putNestedIfNotEmpty(beanParams, "creationDate",commandOptions.creationDate, true);
             putNestedIfNotEmpty(beanParams, "modificationDate",commandOptions.modificationDate, true);
             putNestedIfNotNull(beanParams, "tags",commandOptions.tags, true);
             putNestedIfNotEmpty(beanParams, "result.id",commandOptions.resultId, true);
 
            jobCreateParams = JacksonUtils.getDefaultObjectMapper()
                    .readValue(beanParams.toJson(), JobCreateParams.class);
>>>>>>> release-2.2.x
        }
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
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
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
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }


        JobRetryParams jobRetryParams= null;
        if (commandOptions.jsonDataModel) {
            jobRetryParams = new JobRetryParams();
            RestResponse<Job> res = new RestResponse<>();
            res.setType(QueryType.VOID);
            PrintUtils.println(getObjectAsJSON(jobRetryParams));
            return res;
        } else if (commandOptions.jsonFile != null) {
            jobRetryParams = JacksonUtils.getDefaultObjectMapper()
                    .readValue(new java.io.File(commandOptions.jsonFile), JobRetryParams.class);
        } else {
<<<<<<< HEAD
            jobRetryParams.setJob(commandOptions.job);
            jobRetryParams.setParams(new ObjectMap(commandOptions.params));

            if (commandOptions.force != null) {
                jobRetryParams.setForce(commandOptions.force);
            }
=======
            ObjectMap beanParams = new ObjectMap();
            putNestedIfNotEmpty(beanParams, "job",commandOptions.job, true);
             putNestedIfNotNull(beanParams, "force",commandOptions.force, true);
 
            jobRetryParams = JacksonUtils.getDefaultObjectMapper()
                    .readValue(beanParams.toJson(), JobRetryParams.class);
>>>>>>> release-2.2.x
        }
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
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getJobClient().search(queryParams);
    }

    protected RestResponse<JobTop> top() throws Exception {

        logger.debug("Executing top in Jobs command line");

        return super.top();

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
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
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
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
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
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }


        JobUpdateParams jobUpdateParams= null;
        if (commandOptions.jsonDataModel) {
            jobUpdateParams = new JobUpdateParams();
            RestResponse<Job> res = new RestResponse<>();
            res.setType(QueryType.VOID);
            PrintUtils.println(getObjectAsJSON(jobUpdateParams));
            return res;
        } else if (commandOptions.jsonFile != null) {
            jobUpdateParams = JacksonUtils.getDefaultObjectMapper()
                    .readValue(new java.io.File(commandOptions.jsonFile), JobUpdateParams.class);
        } else {
<<<<<<< HEAD
            jobUpdateParams.setDescription(commandOptions.description);
            jobUpdateParams.setTags(splitWithTrim(commandOptions.tags));
            jobUpdateParams.setAttributes(new HashMap<>(commandOptions.attributes));

            if (commandOptions.visited != null) {
                jobUpdateParams.setVisited(commandOptions.visited);
            }
=======
            ObjectMap beanParams = new ObjectMap();
            putNestedIfNotEmpty(beanParams, "description",commandOptions.description, true);
             putNestedIfNotNull(beanParams, "tags",commandOptions.tags, true);
             putNestedIfNotNull(beanParams, "visited",commandOptions.visited, true);
 
            jobUpdateParams = JacksonUtils.getDefaultObjectMapper()
                    .readValue(beanParams.toJson(), JobUpdateParams.class);
>>>>>>> release-2.2.x
        }
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
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
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
        if (queryParams.get("study") == null && OpencgaMain.isShellMode()) {
            queryParams.putIfNotEmpty("study", sessionManager.getSession().getCurrentStudy());
        }

        return openCGAClient.getJobClient().tailLog(commandOptions.job, queryParams);
    }
}