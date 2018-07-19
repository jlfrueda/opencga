package org.opencb.opencga.analysis;

import org.junit.Test;
import org.junit.Before;
import org.opencb.opencga.catalog.managers.CatalogManager;
import org.opencb.opencga.catalog.managers.CatalogManagerExternalResource;
import org.opencb.opencga.catalog.managers.UserManager;


public class ClinicalInterpretationAnalysisTest {
	
	@Test
	public void testGetClinicalAnalysis() {
		// creamos una interpretación	
		CatalogManagerExternalResource catalogManagerResource = new CatalogManagerExternalResource();
		CatalogManager catalogManager = catalogManagerResource.getCatalogManager();
	}

}
