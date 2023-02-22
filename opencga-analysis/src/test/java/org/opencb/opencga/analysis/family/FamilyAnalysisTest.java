package org.opencb.opencga.analysis.family;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.yarn.webapp.hamlet2.Hamlet;
import org.junit.*;
import org.junit.rules.ExpectedException;
import org.opencb.biodata.models.clinical.ClinicalComment;
import org.opencb.biodata.models.clinical.Disorder;
import org.opencb.biodata.models.clinical.Phenotype;
import org.opencb.biodata.models.core.SexOntologyTermAnnotation;
import org.opencb.biodata.models.pedigree.IndividualProperty;
import org.opencb.commons.datastore.core.DataResult;
import org.opencb.commons.datastore.core.ObjectMap;
import org.opencb.commons.datastore.core.Query;
import org.opencb.commons.datastore.core.QueryOptions;
import org.opencb.commons.test.GenericTest;
import org.opencb.opencga.TestParamConstants;
import org.opencb.opencga.analysis.tools.ToolRunner;
import org.opencb.opencga.analysis.variant.OpenCGATestExternalResource;
import org.opencb.opencga.analysis.variant.manager.VariantStorageManager;
import org.opencb.opencga.catalog.db.api.FamilyDBAdaptor;
import org.opencb.opencga.catalog.db.api.IndividualDBAdaptor;
import org.opencb.opencga.catalog.exceptions.CatalogAuthorizationException;
import org.opencb.opencga.catalog.exceptions.CatalogException;
import org.opencb.opencga.catalog.managers.CatalogManager;
import org.opencb.opencga.catalog.managers.CatalogManagerExternalResource;
import org.opencb.opencga.catalog.managers.DummyModelUtils;
import org.opencb.opencga.catalog.managers.FamilyManager;
import org.opencb.opencga.catalog.utils.Constants;
import org.opencb.opencga.catalog.utils.ParamUtils;
import org.opencb.opencga.catalog.utils.PedigreeGraphUtils;
import org.opencb.opencga.core.api.ParamConstants;
import org.opencb.opencga.core.exceptions.ToolException;
import org.opencb.opencga.core.models.AclEntryList;
import org.opencb.opencga.core.models.clinical.ClinicalAnalysis;
import org.opencb.opencga.core.models.clinical.ClinicalAnalysisUpdateParams;
import org.opencb.opencga.core.models.family.*;
import org.opencb.opencga.core.models.individual.Individual;
import org.opencb.opencga.core.models.individual.IndividualAclParams;
import org.opencb.opencga.core.models.individual.IndividualReferenceParam;
import org.opencb.opencga.core.models.individual.IndividualUpdateParams;
import org.opencb.opencga.core.models.sample.Sample;
import org.opencb.opencga.core.models.sample.SamplePermissions;
import org.opencb.opencga.core.models.sample.SampleReferenceParam;
import org.opencb.opencga.core.models.user.Account;
import org.opencb.opencga.core.response.OpenCGAResult;
import org.opencb.opencga.storage.core.StorageEngineFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class FamilyAnalysisTest extends GenericTest {

    public final static String STUDY = "user@1000G:phase1";
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @ClassRule
    public static OpenCGATestExternalResource opencga = new OpenCGATestExternalResource();

    protected CatalogManager catalogManager;
    private FamilyManager familyManager;
    private String opencgaToken;
    protected String sessionIdUser;

    protected Family family;

    protected String projectId;
    protected String studyId;

    private static final QueryOptions INCLUDE_RESULT = new QueryOptions(ParamConstants.INCLUDE_RESULT_PARAM, true);

    @Before
    public void setUp() throws IOException, CatalogException {
        catalogManager = opencga.getCatalogManager();
        familyManager = catalogManager.getFamilyManager();
        setUpCatalogManager(catalogManager);
    }

    public void setUpCatalogManager(CatalogManager catalogManager) throws CatalogException {
        opencgaToken = catalogManager.getUserManager().loginAsAdmin(TestParamConstants.ADMIN_PASSWORD).getToken();

        catalogManager.getUserManager().create("user", "User Name", "mail@ebi.ac.uk", TestParamConstants.PASSWORD, "", null, Account.AccountType.FULL, opencgaToken);
        sessionIdUser = catalogManager.getUserManager().login("user", TestParamConstants.PASSWORD).getToken();

        projectId = catalogManager.getProjectManager().create("1000G", "Project about some genomes", "", "Homo sapiens", null, "GRCh38", INCLUDE_RESULT, sessionIdUser).first().getId();
        studyId = catalogManager.getStudyManager().create(projectId, "phase1", null, "Phase 1", "Done", null, null, null, null, null, sessionIdUser).first().getId();

        family = createDummyFamily("Martinez-Martinez", true).first();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void creationTest() {
        String b64PedigreeGraph = family.getB64PedigreeGraph();
        assertTrue(b64PedigreeGraph.startsWith("iVBORw0KGgoAAAANSUhEUgAAAeAAAAHgCAM"));
        assertTrue(b64PedigreeGraph.endsWith("U949gmplQAAAABJRU5ErkJggg=="));
    }

    @Test
    public void updateTest() throws CatalogException {
        FamilyUpdateParams updateParams = new FamilyUpdateParams();

        QueryOptions queryOptions = new QueryOptions()
                .append(ParamConstants.FAMILY_UPDATE_ROLES_PARAM, true)
                .append(ParamConstants.INCLUDE_RESULT_PARAM, true);
        Family updatedFamily = catalogManager.getFamilyManager().update(studyId, family.getId(), updateParams, queryOptions, sessionIdUser).first();

        String b64PedigreeGraph = updatedFamily.getB64PedigreeGraph();
        assertTrue(b64PedigreeGraph.startsWith("iVBORw0KGgoAAAANSUhEUgAAAeAAAAHgCAM"));
        assertTrue(b64PedigreeGraph.endsWith("U949gmplQAAAABJRU5ErkJggg=="));
    }

    @Test
    public void testPedigreeGraphAnalysis() throws ToolException, IOException {
        Path outDir = Paths.get(opencga.createTmpOutdir("_pedigree_graph"));
        System.out.println("out dir = " + outDir.toAbsolutePath());
        System.out.println("opencga home = " + opencga.getOpencgaHome().toAbsolutePath());
        System.out.println(Paths.get("workspace parent = " + catalogManager.getConfiguration().getWorkspace()).getParent());

        VariantStorageManager variantStorageManager = new VariantStorageManager(catalogManager, opencga.getStorageEngineFactory());
        ToolRunner toolRunner = new ToolRunner(opencga.getOpencgaHome().toString(), catalogManager,
                StorageEngineFactory.get(variantStorageManager.getStorageConfiguration()));

        // Pedigree graph params
        PedigreeGraphAnalysisParams params = new PedigreeGraphAnalysisParams();
        params.setFamilyId(family.getId());

        toolRunner.execute(PedigreeGraphAnalysis.class, params, new ObjectMap(ParamConstants.STUDY_PARAM, studyId), outDir, null,
                sessionIdUser);

        String b64PedigreeGraph = PedigreeGraphUtils.getB64PedigreeGraph(outDir);
        assertTrue(b64PedigreeGraph.startsWith("iVBORw0KGgoAAAANSUhEUgAAAeAAAAHgCAM"));
        assertTrue(b64PedigreeGraph.endsWith("U949gmplQAAAABJRU5ErkJggg=="));

        String tsvPedigreeGraph = PedigreeGraphUtils.getTsvPedigreeGraph(outDir);
        assertTrue(tsvPedigreeGraph.startsWith("id\tdadid\tmomid\tsex\taffected"));
        assertTrue(tsvPedigreeGraph.endsWith("2\t1\t2\t1\tNA\t2\t2\n"));

        assertEquals(family.getB64PedigreeGraph(), b64PedigreeGraph);
    }

    private DataResult<Family> createDummyFamily(String familyName, boolean createMissingMembers) throws CatalogException {
        if (createMissingMembers) {
            Sample sample1 = new Sample().setId("sample1");
            catalogManager.getSampleManager().create(STUDY, sample1, QueryOptions.empty(), sessionIdUser);

            Sample sample2 = new Sample().setId("sample2");
            catalogManager.getSampleManager().create(STUDY, sample2, QueryOptions.empty(), sessionIdUser);

            Sample sample3 = new Sample().setId("sample3");
            catalogManager.getSampleManager().create(STUDY, sample3, QueryOptions.empty(), sessionIdUser);
        }

        Phenotype phenotype1 = new Phenotype("dis1", "Phenotype 1", "HPO");
        Phenotype phenotype2 = new Phenotype("dis2", "Phenotype 2", "HPO");

        Disorder disorder1 = new Disorder("disorder-1", null, null, null, null, null, null);
        Disorder disorder2 = new Disorder("disorder-2", null, null, null, null, null, null);

        Individual father = new Individual().setId("father")
                .setPhenotypes(Arrays.asList(phenotype1))
                .setSex(SexOntologyTermAnnotation.initMale())
                .setLifeStatus(IndividualProperty.LifeStatus.ALIVE)
                .setDisorders(Collections.singletonList(disorder1));

        Individual mother = new Individual().setId("mother")
                .setPhenotypes(Arrays.asList(phenotype2))
                .setSex(SexOntologyTermAnnotation.initFemale())
                .setLifeStatus(IndividualProperty.LifeStatus.ALIVE);

//        // We create a new father and mother with the same information to mimic the behaviour of the webservices. Otherwise, we would be
//        // ingesting references to exactly the same object and this test would not work exactly the same way.
        Individual relFather = new Individual().setId("father").setPhenotypes(Arrays.asList(phenotype1));
        Individual relMother = new Individual().setId("mother").setPhenotypes(Arrays.asList(phenotype2));

        Individual relChild1 = new Individual().setId("child1")
                .setPhenotypes(Arrays.asList(phenotype1, phenotype2))
                .setFather(father)
                .setMother(mother)
                .setSex(SexOntologyTermAnnotation.initMale())
                .setLifeStatus(IndividualProperty.LifeStatus.ALIVE)
                .setParentalConsanguinity(true);

        Individual relChild2 = new Individual().setId("child2")
                .setPhenotypes(Arrays.asList(phenotype1))
                .setFather(father)
                .setMother(mother)
                .setSex(SexOntologyTermAnnotation.initFemale())
                .setLifeStatus(IndividualProperty.LifeStatus.ALIVE)
                .setDisorders(Collections.singletonList(disorder1))
                .setParentalConsanguinity(true);

        Individual relChild3 = new Individual().setId("child3")
                .setPhenotypes(Arrays.asList(phenotype1))
                .setFather(father)
                .setMother(mother)
                .setSex(SexOntologyTermAnnotation.initFemale())
                .setLifeStatus(IndividualProperty.LifeStatus.DECEASED)
                .setDisorders(Collections.singletonList(disorder2))
                .setParentalConsanguinity(true);

        List<Individual> members = null;
        List<String> memberIds = null;
        if (createMissingMembers) {
            members = Arrays.asList(relChild1, relChild2, relChild3, father, mother);
        } else {
            memberIds = Arrays.asList("father", "mother", "child1", "child2", "child3");
        }

        Family family = new Family(familyName, familyName, null, null, members, "", 5,
                Collections.emptyList(), Collections.emptyMap());

        OpenCGAResult<Family> familyOpenCGAResult = familyManager.create(STUDY, family, memberIds, INCLUDE_RESULT, sessionIdUser);

        if (createMissingMembers) {
            catalogManager.getIndividualManager().update(STUDY, relChild1.getId(),
                    new IndividualUpdateParams().setSamples(Collections.singletonList(new SampleReferenceParam().setId("sample1"))),
                    QueryOptions.empty(), sessionIdUser);
            catalogManager.getIndividualManager().update(STUDY, relFather.getId(),
                    new IndividualUpdateParams().setSamples(Collections.singletonList(new SampleReferenceParam().setId("sample2"))),
                    QueryOptions.empty(), sessionIdUser);
            catalogManager.getIndividualManager().update(STUDY, relMother.getId(),
                    new IndividualUpdateParams().setSamples(Collections.singletonList(new SampleReferenceParam().setId("sample3"))),
                    QueryOptions.empty(), sessionIdUser);
        }

        return familyOpenCGAResult;
    }
}
