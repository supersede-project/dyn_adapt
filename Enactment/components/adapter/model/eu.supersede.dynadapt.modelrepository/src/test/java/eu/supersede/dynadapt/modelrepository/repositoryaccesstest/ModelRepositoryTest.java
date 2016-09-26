package eu.supersede.dynadapt.modelrepository.repositoryaccesstest;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import eu.supersede.dynadapt.modelrepository.repositoryaccess.ModelRepository;

public class ModelRepositoryTest {

	String loc = "platform:/resource/eu.supersede.dynadapt.modelrepository/models/";

	Map<String, String> models;

	ModelRepository mr = null;

	@Before
	public void setUp() throws Exception {
		models = new HashMap<String, String>();
		models.put("aspects", "aspects/");
		models.put("advices", "advices/");
		models.put("profiles", "profiles/adm.profile.uml");
		models.put("patterns", "patterns/monitoring_reconfiguration_queries.vql");
		models.put("featureconfigmodels", "featureconfigmodels/MonitoringSystem.yafm");

		mr = new ModelRepository(loc, models);
	}

	@After
	public void cleanUp() {

	}

	@Test
	public void testGetValidFeatureAspects() {
		mr.getAspectModels("GooglePlay_API_GooglePlay");
	}
	
	@Test
	public void testGetValidFeatureAspectsURIs() {
		mr.getAspectModelsURIs("GooglePlay_API_GooglePlay");
	}
	
}
