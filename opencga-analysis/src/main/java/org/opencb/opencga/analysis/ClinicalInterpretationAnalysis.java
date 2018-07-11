/*
 * Copyright 2015-2017 OpenCB
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.opencb.opencga.analysis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.opencb.biodata.models.variant.Variant;
import org.opencb.commons.datastore.core.Query;
import org.opencb.commons.datastore.core.QueryOptions;
import org.opencb.commons.datastore.core.QueryResult;
import org.opencb.opencga.catalog.db.api.DiseasePanelDBAdaptor;
import org.opencb.opencga.catalog.exceptions.CatalogException;
import org.opencb.opencga.catalog.managers.ClinicalAnalysisManager;
import org.opencb.opencga.catalog.managers.IndividualManager;
import org.opencb.opencga.core.common.TimeUtils;
import org.opencb.opencga.core.models.ClinicalAnalysis;
import org.opencb.opencga.core.models.ClinicalAnalysis.Type;
import org.opencb.opencga.core.models.DiseasePanel;
import org.opencb.opencga.core.models.Family;
import org.opencb.opencga.core.models.Individual;
import org.opencb.opencga.core.models.User;
import org.opencb.opencga.core.models.clinical.Analyst;
import org.opencb.opencga.core.models.clinical.Interpretation;
import org.opencb.opencga.core.models.clinical.ReportedVariant;
import org.opencb.opencga.core.results.VariantQueryResult;
import org.opencb.opencga.storage.core.StorageEngineFactory;
import org.opencb.opencga.storage.core.exceptions.StorageEngineException;
import org.opencb.opencga.storage.core.manager.variant.VariantStorageManager;
import org.opencb.opencga.storage.core.variant.adaptors.VariantQueryParam;

public class ClinicalInterpretationAnalysis extends OpenCgaAnalysis {
	
	// fundamental information
	private Interpretation interpretation;
	
	private /*final*/ String sessionId;
    private /*final*/ String studyStr;
    
    private /*final*/ String panelId;
    private /*final*/ String panelVersion;
	
	private /*final*/ List<String> samples;
	// TODO: how should we use this? while deciding, leave it out
	// private /*final*/ String type;
	
    private /*final*/ String interpretationId;
    private /*final*/ String interpretationName;
    private /*final*/ boolean save;
    
    private /*final*/ Query variantQuery;
		
	// alternative sources for samples
    // private ClinicalAnalysis clinicalAnalysis;
    private String clinicalAnalysisId;
    private String family;
    private List<String> subjects;
    
    // mininal constructor
//    public ClinicalInterpretationAnalysis(
//    		String opencgaHome,
//    		String panelId,
//    		String panelVersion,
//    		String clinicalAnalysisId,
//    		String sessionId) {
//    	super(opencgaHome);
//    	
//    }
    
    // pure constructor, with only the parameters that needs to be here
    public ClinicalInterpretationAnalysis(
    		String opencgaHome,
    	    String studyStr,
    		String panelId,
            String panelVersion,
    		List<String> samples,
    		String interpretationId,
    		String interpretationName,
    		Query variantQuery,
    		boolean save,
    		String sessionId) {
    	super(opencgaHome);

    	this.studyStr = studyStr;
    	this.panelId = panelId;
    	this.panelVersion = panelVersion;
    	// should probably make a deep copy of this?
    	this.samples = samples;
    	this.interpretationId = interpretationId;
    	this.interpretationName = interpretationName;
    	this.save = save;
    	this.variantQuery = variantQuery;
    	this.sessionId = sessionId;    	
    }
    

//    public ClinicalInterpretationAnalysis(String clnicalAnalysisId, String panelId, Query variantQuery, String sessionId) {
//
//    }

    // most general constructor, take all the params
    public ClinicalInterpretationAnalysis(
    		String opencgaHome,
    	    String studyStr,
    		String panelId,
            String panelVersion,
            // alternative to samples
            String clinicalAnalysisId,
            String family,
    		List<String> subjects,            
    		List<String> samples,
    		String interpretationId,
    		String interpretationName,
    		Query variantQuery,
    		boolean save,
    		String sessionId    		
    ) {
        super(opencgaHome);
        
        private String clinicalAnalysisId;
        private String family;
        private List<String> subjects;
        
        
        this.sessionId = sessionId;
        this.studyStr = studyStr;
        this.clinicalAnalysisId = clinicalAnalysisId;
        this.family = family;
        // should deeply clone this one...
        this.subjects = subjects;
        this.panelId = panelId;
        this.panelVersion = panelVersion;
        this.interpretationId = interpretationId;
        this.interpretationName = interpretationName;
        // ... and maybe these two, if not immutable
        this.variantQuery = variantQuery;
        this.save = save;
    }
    
    private List<String> getSampleIds() throws CatalogException {
    	
    	// 1) if we've got a list of samples, just use it
    	// if not...
    	
    	if (CollectionUtils.isEmpty(this.samples)) {
    		/
    		
    	}
    	
    	
    	
    	List<Individual> individuals = null;
    	
    	if (StringUtils.isNotEmpty(this.clinicalAnalysisId)) {
    		final ClinicalAnalysisManager clinicalAnalysisManager = catalogManager.getClinicalAnalysisManager();
    		QueryResult<ClinicalAnalysis> clinicalAnalyses = clinicalAnalysisManager.get(    				
                    studyStr,
                    clinicalAnalysisId,
                    QueryOptions.empty(),
                    sessionId
            );
    		ClinicalAnalysis clinicalAnalysis = clinicalAnalyses.first();
    		Family family = clinicalAnalysis.getFamily();
    		individuals = family.getMembers();
    	}
    	if (CollectionUtils.isNotEmpty(this.subjects)) {
    		IndividualManager individualManager = this.catalogManager.getIndividualManager();
    		List<QueryResult<Individual>> queryResults = individualManager.get(studyStr, this.subjects, new Query(), QueryOptions.empty(), sessionId);
    		individuals = queryResults.stream().map(result -> result.first()).collect(Collectors.toList());    		
    	}
    	// check that all our individuals have just one sample, and only one
    	if (individuals.stream().allMatch(individual -> (1 == individual.getSamples().size()))) {
    		// TODO: throw a proper exception
    		throw new CatalogException();
    	} else {
    		return individuals;
    	}
    	
    	// TODO: add this; this should be the main source of individuals
//    	if (StringUtils.isNotEmpty(clinicalAnalysisId)) {
//            ClinicalAnalysis clinicalAnalysis = getClinicalAnalysis();
//
//            for (Individual individual : clinicalAnalysis.getSubjects()) {
//                samples.add(individual.getSamples().get(0).getId());
//            }
//        }
    }


    private ClinicalAnalysis getClinicalAnalysis() throws CatalogException {
        assert(null != catalogManager);
        if (StringUtils.isNotEmpty(clinicalAnalysisId)) {           

            // have to convert session            
            
            return clinicalAnalysis;
        }
        return null;
    }
    
    private List<ReportedVariant> getDiagnosticVariants(VariantStorageManager variantManager, DiseasePanel diseasePanel, List<String> samples) throws CatalogException, StorageEngineException, IOException {
        List<DiseasePanel.VariantPanel> variants = diseasePanel.getVariants();
        Query variantQuery = new Query();
        variantQuery.put(VariantQueryParam.ID.key(), StringUtils.join(variants, ","));
        variantQuery.put(VariantQueryParam.SAMPLE.key(), StringUtils.join(samples, ","));
        VariantQueryResult<Variant> variantQueryResult = variantManager.get(variantQuery, QueryOptions.empty(), sessionId);
        List<ReportedVariant> reportedVariants = variantQueryResult.getResult().stream().map(variant -> {
            ReportedVariant reportedVariant = new ReportedVariant(variant.getImpl());
            return reportedVariant;
        }).collect(Collectors.toList());
        return reportedVariants;
    }
    
    private List<ReportedVariant> getVUS(VariantStorageManager variantManager, DiseasePanel diseasePanel, List<String> samples) throws CatalogException, StorageEngineException, IOException {
        List<String> geneIds = getGeneIdsFromPanel(diseasePanel);
        
        Query variantQuery = new Query();
        query.put(VariantQueryParam.GENE.key(), StringUtils.join(geneIds, ","));
        variantQuery.put(VariantQueryParam.SAMPLE.key(), StringUtils.join(samples, ","));
        variantQuery.put(VariantQueryParam.ANNOT_BIOTYPE.key(), "protein_coding");
        // ...
        QueryOptions queryOptions = new QueryOptions();
        queryOptions.put(QueryOptions.LIMIT, 1000);
        VariantQueryResult<Variant> variantQueryResult = variantManager.get(variantQuery, queryOptions, sessionId);
        List<ReportedVariant> reportedVariants = variantQueryResult.getResult().stream().map(variant -> {
            ReportedVariant reportedVariant = new ReportedVariant(variant.getImpl());
            return reportedVariant;
        }).collect(Collectors.toList());
        return reportedVariants;
    }
    
    private List<ReportedVariant> getUnexpectedFindings() {
        return new ArrayList<ReportedVariant>();
    }
    
    private DiseasePanel getDiseasePanel() throws CatalogException {
        Query panelQuery = new Query();
        panelQuery.put(DiseasePanelDBAdaptor.QueryParams.ID.key(), panelId);
        panelQuery.put(DiseasePanelDBAdaptor.QueryParams.VERSION.key(), panelVersion);
        QueryResult<DiseasePanel> panelResult = catalogManager.getDiseasePanelManager().get(studyStr, panelQuery, QueryOptions.empty(), sessionId);
        return panelResult.first();        
    }

    public void execute() throws Exception {
    	List<String> samples = getSampleIds();
    	
//     	Type type;
    	
    	Individual i = new Individual();
    	Family f = new Family();


        
        

        // TODO throw a proper Exception
        if (StringUtils.isEmpty(this.panelId)) {
            logger.error("No disease panel provided");
            return;
        }

        // fetch disease panel
        DiseasePanel diseasePanel = getDiseasePanel();

        // we create the variant strage manager
        StorageEngineFactory storageEngineFactory = StorageEngineFactory.get(storageConfiguration);
        VariantStorageManager variantManager = new VariantStorageManager(catalogManager, storageEngineFactory);

        // Step 1 - we first try to fetch diagnostic variants
        List<ReportedVariant> reportedVariants = getDiagnosticVariants(variantManager, diseasePanel, samples);
        
        // Step 2 - if no results, try to fetch VUS variants
        if (reportedVariants.isEmpty()) {
            reportedVariants = getVUS(variantManager, diseasePanel, samples);
        }
        // Step 3 - in any case, add potential unexpected findings
        reportedVariants.addAll(getUnexpectedFindings());

        // just write the result
        // the result can be an error, but the analysis should always generate a result

        if (interpretationId != null && clinicalAnalysis != null) {
            // save in catalog
            interpretation = (new Interpretation());
            interpretation
                .setDescription("Automatic interpretation based on panel " + diseasePanel.getId())
                .setPanel(diseasePanel)
                // .setSoftware()
                // .setVersions(versions)
                // .setFilters(filters)
                .setCreationDate(TimeUtils.getTime())
                // .setComments(comments)
                // .setAttributes(attributes)
                .setReportedVariants(reportedVariants);
                ;
            if (StringUtils.isNotEmpty(interpretationId)) {
            	interpretation.setId(interpretationId);
            }
            if (StringUtils.isNotEmpty(interpretationName)) {
            	interpretation.setName(interpretationName);
            }
            // analyst
               String userId = catalogManager.getUserManager().getUserId(sessionId);
            User user = catalogManager.getUserManager().get(userId,  QueryOptions.empty(), sessionId).first();          
            interpretation.setAnalyst(new Analyst(user.getName(), user.getEmail(), user.getOrganization()));
        }
        
        // store the results in clinical analysis if the user asked for this
        if (BooleanUtils.isTrue(save)) {
        	// TODO: save this
        	// clinicalAnalysis.getInterpretations().add(interpretation);
        	
        }
    }

    private List<String> getGeneIdsFromPanel(DiseasePanel diseasePanel) throws CatalogException {
        List<String> geneIds = new ArrayList<>(diseasePanel.getGenes().size());
        for (DiseasePanel.GenePanel gene : diseasePanel.getGenes()) {
            geneIds.add(gene.getId());
        }
        return geneIds;
    }


    public Interpretation getInterpretation() {
        return interpretation;
    }

    public ClinicalInterpretationAnalysis setInterpretation(Interpretation interpretation) {
        this.interpretation = interpretation;
        return this;
    }
}
