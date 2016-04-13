package org.opencb.opencga.catalog.managers;

import org.opencb.commons.datastore.core.ObjectMap;
import org.opencb.commons.datastore.core.Query;
import org.opencb.commons.datastore.core.QueryOptions;
import org.opencb.commons.datastore.core.QueryResult;
import org.opencb.opencga.catalog.audit.AuditManager;
import org.opencb.opencga.catalog.audit.AuditRecord;
import org.opencb.opencga.catalog.authentication.AuthenticationManager;
import org.opencb.opencga.catalog.authorization.AuthorizationManager;
import org.opencb.opencga.catalog.authorization.CatalogPermission;
import org.opencb.opencga.catalog.authorization.StudyPermission;
import org.opencb.opencga.catalog.config.CatalogConfiguration;
import org.opencb.opencga.catalog.db.CatalogDBAdaptorFactory;
import org.opencb.opencga.catalog.db.api.CatalogFileDBAdaptor;
import org.opencb.opencga.catalog.db.api.CatalogJobDBAdaptor;
import org.opencb.opencga.catalog.exceptions.CatalogDBException;
import org.opencb.opencga.catalog.exceptions.CatalogException;
import org.opencb.opencga.catalog.io.CatalogIOManager;
import org.opencb.opencga.catalog.io.CatalogIOManagerFactory;
import org.opencb.opencga.catalog.managers.api.IJobManager;
import org.opencb.opencga.catalog.models.*;
import org.opencb.opencga.catalog.utils.ParamUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.*;

/**
 * @author Jacobo Coll &lt;jacobo167@gmail.com&gt;
 */
public class JobManager extends AbstractManager implements IJobManager {

    protected static Logger logger = LoggerFactory.getLogger(JobManager.class);

    public JobManager(AuthorizationManager authorizationManager, AuthenticationManager authenticationManager, AuditManager auditManager,
                      CatalogDBAdaptorFactory catalogDBAdaptorFactory, CatalogIOManagerFactory ioManagerFactory,
                      CatalogConfiguration catalogConfiguration) {
        super(authorizationManager, authenticationManager, auditManager, catalogDBAdaptorFactory, ioManagerFactory, catalogConfiguration);
    }

    @Deprecated
    public JobManager(AuthorizationManager authorizationManager, AuthenticationManager authenticationManager, AuditManager auditManager,
                      CatalogDBAdaptorFactory catalogDBAdaptorFactory, CatalogIOManagerFactory ioManagerFactory,
                      Properties catalogProperties) {
        super(authorizationManager, authenticationManager, auditManager, catalogDBAdaptorFactory, ioManagerFactory, catalogProperties);
    }


    @Override
    public Long getStudyId(long jobId) throws CatalogException {
        return jobDBAdaptor.getStudyIdByJobId(jobId);
    }

    @Override
    public QueryResult<ObjectMap> visit(long jobId, String sessionId) throws CatalogException {
        ParamUtils.checkParameter(sessionId, "sessionId");
        String userId = userDBAdaptor.getUserIdBySessionId(sessionId);
        authorizationManager.checkReadJob(userId, jobId);
        return jobDBAdaptor.incJobVisits(jobId);
    }

    @Deprecated
    @Override
    public QueryResult<Job> create(ObjectMap objectMap, QueryOptions options, String sessionId) throws CatalogException {
        ParamUtils.checkObj(objectMap, "objectMap");
        try {

            return create(
                    objectMap.getLong("studyId"),
                    objectMap.getString("name"),
                    objectMap.getString("toolName"),
                    objectMap.getString("description"),
                    objectMap.getString("execution"),
                    Collections.emptyMap(),
                    objectMap.getString("commandLine"),
                    objectMap.containsKey("tmpOutDirUri") ? new URI(null, objectMap.getString("tmpOutDirUri"), null) : null,
                    objectMap.getLong("outDirId"),
                    objectMap.getAsLongList("inputFiles"),
                    objectMap.getAsLongList("outputFiles"),
                    objectMap.getMap("attributes"),
                    objectMap.getMap("resourceManagerAttributes"),
                    new Job.JobStatus(options.getString("status")),
                    objectMap.getLong("startTime"),
                    objectMap.getLong("endTime"),
                    options,
                    sessionId
            );
        } catch (URISyntaxException e) {
            throw new CatalogException(e);
        }
    }

    @Override
    public QueryResult<Job> create(long studyId, String name, String toolName, String description, String executor,
                                   Map<String, String> params, String commandLine, URI tmpOutDirUri, long outDirId,
                                   List<Long> inputFiles, List<Long> outputFiles, Map<String, Object> attributes,
                                   Map<String, Object> resourceManagerAttributes, Job.JobStatus status, long startTime,
                                   long endTime, QueryOptions options, String sessionId) throws CatalogException {
        ParamUtils.checkParameter(sessionId, "sessionId");
        ParamUtils.checkParameter(name, "name");
        String userId = userDBAdaptor.getUserIdBySessionId(sessionId);
        ParamUtils.checkParameter(toolName, "toolName");
        ParamUtils.checkParameter(commandLine, "commandLine");
        description = ParamUtils.defaultString(description, "");
        status = ParamUtils.defaultObject(status, new Job.JobStatus(Job.JobStatus.PREPARED));
        inputFiles = ParamUtils.defaultObject(inputFiles, Collections.<Long>emptyList());
        outputFiles = ParamUtils.defaultObject(outputFiles, Collections.<Long>emptyList());

        // FIXME check inputFiles? is a null conceptually valid?

//        URI tmpOutDirUri = createJobOutdir(studyId, randomString, sessionId);

        authorizationManager.checkFilePermission(outDirId, userId, CatalogPermission.WRITE);
        for (Long inputFile : inputFiles) {
            authorizationManager.checkFilePermission(inputFile, userId, CatalogPermission.READ);
        }
        QueryOptions fileQueryOptions = new QueryOptions("include", Arrays.asList(
                "projects.studies.files.id",
                "projects.studies.files.type",
                "projects.studies.files.path"));
        File outDir = fileDBAdaptor.getFile(outDirId, fileQueryOptions).first();

        if (!outDir.getType().equals(File.Type.FOLDER)) {
            throw new CatalogException("Bad outDir type. Required type : " + File.Type.FOLDER);
        }

        Job job = new Job(name, userId, toolName, description, commandLine, outDir.getId(), tmpOutDirUri, inputFiles);
        job.setOutput(outputFiles);
        job.setStatus(status);
        job.setStartTime(startTime);
        job.setEndTime(endTime);
        job.setParams(params);
        job.setExecution(executor);

        if (resourceManagerAttributes != null) {
            job.getResourceManagerAttributes().putAll(resourceManagerAttributes);
        }
        if (attributes != null) {
            job.setAttributes(attributes);
        }

        QueryResult<Job> queryResult = jobDBAdaptor.createJob(studyId, job, options);
        auditManager.recordCreation(AuditRecord.Resource.job, queryResult.first().getId(), userId, queryResult.first(), null, null);
        return queryResult;
    }

    @Override
    public QueryResult<Job> read(Long jobId, QueryOptions options, String sessionId)
            throws CatalogException {
        ParamUtils.checkParameter(sessionId, "sessionId");
        String userId = userDBAdaptor.getUserIdBySessionId(sessionId);
        QueryResult<Job> queryResult = jobDBAdaptor.getJob(jobId, options);
        authorizationManager.checkReadJob(userId, queryResult.first());
        return queryResult;
    }

    @Override
    public QueryResult<Job> readAll(Query query, QueryOptions options, String sessionId) throws CatalogException {
        query = ParamUtils.defaultObject(query, Query::new);
        int studyId = query.getInt(CatalogJobDBAdaptor.QueryParams.STUDY_ID.key(), -1);
        return readAll(studyId, query, options, sessionId);
    }

    @Override
    public QueryResult<Job> readAll(long studyId, Query query, QueryOptions options, String sessionId) throws CatalogException {
        ParamUtils.checkParameter(sessionId, "sessionId");
        query = ParamUtils.defaultObject(query, Query::new);
        options = ParamUtils.defaultObject(options, QueryOptions::new);
        // If studyId is null, check if there is any on the query
        // Else, ensure that studyId is in the Query
        if (studyId < 0) {
            studyId = query.getInt(CatalogJobDBAdaptor.QueryParams.STUDY_ID.key(), -1);
        } else {
            query.put(CatalogJobDBAdaptor.QueryParams.STUDY_ID.key(), studyId);
        }
        //query.putAll(options);
        String userId = userDBAdaptor.getUserIdBySessionId(sessionId);
        if (!authorizationManager.getUserRole(userId).equals(User.Role.ADMIN)) {
            if (studyId < 0) {
                throw new CatalogException("Permission denied. Can't get jobs without specifying an StudyId");
            } else {
                authorizationManager.checkStudyPermission(studyId, userId, StudyPermission.READ_STUDY);
            }
        }
        QueryResult<Job> queryResult = jobDBAdaptor.get(query, options);
        authorizationManager.filterJobs(userId, queryResult.getResult(), studyId);
        queryResult.setNumResults(queryResult.getResult().size());
        return queryResult;
    }

    @Override
    public QueryResult<Job> update(Long jobId, ObjectMap parameters, QueryOptions options, String sessionId) throws CatalogException {
        ParamUtils.checkParameter(sessionId, "sessionId");
        ParamUtils.checkObj(parameters, "parameters");
        String userId = userDBAdaptor.getUserIdBySessionId(sessionId);
        long studyId = jobDBAdaptor.getStudyIdByJobId(jobId);
        if (!authorizationManager.getUserRole(userId).equals(User.Role.ADMIN)) {
            authorizationManager.checkStudyPermission(studyId, userId, StudyPermission.LAUNCH_JOBS);
        }
        QueryResult<Job> queryResult = jobDBAdaptor.update(jobId, parameters);
        auditManager.recordUpdate(AuditRecord.Resource.job, jobId, userId, parameters, null, null);
        return queryResult;
    }

    @Override
    public QueryResult<Job> delete(Long jobId, QueryOptions options, String sessionId) throws CatalogException {
        ParamUtils.checkParameter(sessionId, "sessionId");
        String userId = userDBAdaptor.getUserIdBySessionId(sessionId);
        long studyId = jobDBAdaptor.getStudyIdByJobId(jobId);
        authorizationManager.checkStudyPermission(studyId, userId, StudyPermission.MANAGE_STUDY);

        QueryResult<Job> queryResult = jobDBAdaptor.delete(jobId, false);
        // Delete the output files of the job if they are not in use.
        // TODO: Add an if clause to do this only when the user does not want to keep the output files.
        // 2. Check the output files that were created with the deleted jobs.
        Query query = new Query(CatalogFileDBAdaptor.QueryParams.ID.key(), queryResult.first().getOutput());
        try {
            fileDBAdaptor.delete(query, false);
        } catch (CatalogDBException e) {
            logger.info("Delete job { Job: " + queryResult.first() + " }:" + e.getMessage());
        }

        auditManager.recordDeletion(AuditRecord.Resource.job, jobId, userId, queryResult.first(), null, null);
        return queryResult;
    }

    @Override
    public QueryResult rank(Query query, String field, int numResults, boolean asc, String sessionId) throws CatalogException {
        return null;
    }

    @Override
    public QueryResult groupBy(Query query, String field, QueryOptions options, String sessionId) throws CatalogException {
        return null;
    }

    @Override
    public QueryResult groupBy(Query query, List<String> fields, QueryOptions options, String sessionId) throws CatalogException {
        return null;
    }

    @Override
    public URI createJobOutDir(long studyId, String dirName, String sessionId) throws CatalogException {
        ParamUtils.checkParameter(sessionId, "sessionId");
        ParamUtils.checkParameter(dirName, "dirName");

        String userId = userDBAdaptor.getUserIdBySessionId(sessionId);

        authorizationManager.checkStudyPermission(studyId, userId, StudyPermission.DELETE_JOBS);

        URI uri = studyDBAdaptor.getStudy(studyId, new QueryOptions("include", Collections.singletonList("projects.studies.uri")))
                .first().getUri();

        CatalogIOManager catalogIOManager = catalogIOManagerFactory.get(uri);
        return catalogIOManager.createJobOutDir(userId, dirName);
    }

    @Override
    public long getToolId(String toolId) throws CatalogException {
        try {
            return Integer.parseInt(toolId);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        String[] split = toolId.split("@");
        if (split.length != 2) {
            return -1;
        }
        return jobDBAdaptor.getToolId(split[0], split[1]);
    }

    @Override
    public QueryResult<Tool> createTool(String alias, String description, Object manifest, Object result,
                                        String path, boolean openTool, String sessionId) throws CatalogException {
        ParamUtils.checkParameter(alias, "alias");
        ParamUtils.checkObj(description, "description"); //description can be empty
        ParamUtils.checkParameter(path, "path");
        ParamUtils.checkParameter(sessionId, "sessionId");
        //TODO: Check Path

        String userId = userDBAdaptor.getUserIdBySessionId(sessionId);

        List<AclEntry> acl = Arrays.asList(new AclEntry(userId, true, true, true, true));
        if (openTool) {
            acl.add(new AclEntry(AclEntry.USER_OTHERS_ID, true, false, true, false));
        }

        String name = Paths.get(path).getFileName().toString();

        Tool tool = new Tool(-1, alias, name, description, manifest, result, path, acl);

        QueryResult<Tool> queryResult = jobDBAdaptor.createTool(userId, tool);
        auditManager.recordCreation(AuditRecord.Resource.tool, queryResult.first().getId(), userId, queryResult.first(), null, null);
        return queryResult;
    }

    @Override
    public QueryResult<Tool> readTool(long id, String sessionId) throws CatalogException {
        String userId = userDBAdaptor.getUserIdBySessionId(sessionId);
        ParamUtils.checkParameter(sessionId, "sessionId");

        //TODO: Check ACLs
        return jobDBAdaptor.getTool(id);
    }

    @Override
    public QueryResult<Tool> readAllTools(Query query, QueryOptions queryOptions, String sessionId) throws CatalogException {
        return jobDBAdaptor.getAllTools(query, queryOptions);
    }
}
