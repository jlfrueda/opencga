package org.opencb.opencga.server.json;

import org.opencb.opencga.server.json.beans.Category;
import org.opencb.opencga.server.json.beans.Endpoint;
import org.opencb.opencga.server.json.beans.Parameter;
import org.opencb.opencga.server.json.beans.RestApi;
import org.opencb.opencga.server.json.clients.ExecutorsCliRestApiWriter;
import org.opencb.opencga.server.json.clients.OptionsCliRestApiWriter;
import org.opencb.opencga.server.json.config.Configuration;
import org.opencb.opencga.server.json.config.ConfigurationManager;
import org.opencb.opencga.server.rest.*;
import org.opencb.opencga.server.rest.admin.AdminWSServer;
import org.opencb.opencga.server.rest.analysis.AlignmentWebService;
import org.opencb.opencga.server.rest.analysis.ClinicalWebService;
import org.opencb.opencga.server.rest.analysis.VariantWebService;
import org.opencb.opencga.server.rest.ga4gh.Ga4ghWSServer;
import org.opencb.opencga.server.rest.operations.VariantOperationWebService;

import java.util.ArrayList;
import java.util.List;

public class MainClientGenerator {

    private static RestApi restApi;
    private static Configuration config;

    public static void main(String[] args) {
        List<Class> classes = new ArrayList<>();
        classes.add(UserWSServer.class);
        classes.add(ProjectWSServer.class);
        classes.add(StudyWSServer.class);
        classes.add(FileWSServer.class);
        classes.add(JobWSServer.class);
        classes.add(SampleWSServer.class);
        classes.add(IndividualWSServer.class);
        classes.add(FamilyWSServer.class);
        classes.add(CohortWSServer.class);
        classes.add(PanelWSServer.class);
        classes.add(AlignmentWebService.class);
        classes.add(VariantWebService.class);
        classes.add(ClinicalWebService.class);
        classes.add(VariantOperationWebService.class);
        classes.add(MetaWSServer.class);
        classes.add(Ga4ghWSServer.class);
        classes.add(AdminWSServer.class);
        restApi = prepare(RestApiParser.getApi(classes));

        try {
            config = ConfigurationManager.setUp(restApi);
            config.initialize();
        } catch (Exception e) {
            e.printStackTrace();
        }
        cli();
    }

    private static RestApi prepare(RestApi api) {
        //To process endpoints the parameter for each one must have a different name
        //Sometimes body parameter has the same name of a query parameter
        for (Category category : api.getCategories()) {
            for (Endpoint endpoint : category.getEndpoints()) {
                List<String> aux = new ArrayList<>();
                for (Parameter parameter : endpoint.getParameters()) {
                    aux.add(parameter.getName());
                }
                for (Parameter parameter : endpoint.getParameters()) {
                    if (parameter.getData() != null) {
                        for (Parameter body_parameter : parameter.getData()) {
                            if (aux.contains(body_parameter.getName())) {
                                body_parameter.setName("body_" + body_parameter.getName());
                            }
                        }
                    }
                }
            }
        }

        return api;
    }

    private static void cli() {
        OptionsCliRestApiWriter optionsCliRestApiWriter = new OptionsCliRestApiWriter(restApi, config);
        optionsCliRestApiWriter.write();
        ExecutorsCliRestApiWriter executorsCliRestApiWriter = new ExecutorsCliRestApiWriter(restApi, config);
        executorsCliRestApiWriter.write();
    }
}
