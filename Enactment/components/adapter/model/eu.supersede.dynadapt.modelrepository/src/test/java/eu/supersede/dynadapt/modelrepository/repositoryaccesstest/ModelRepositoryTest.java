package eu.supersede.dynadapt.modelrepository.repositoryaccesstest;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import eu.supersede.dynadapt.modelrepository.repositoryaccess.ModelRepository;

public class ModelRepositoryTest {

	String repository = "platform:/resource/eu.supersede.dynadapt.modelrepository/models/";

	Map<String, String> modelsLocation;

	ModelRepository mr = null;

	@Before
	public void setUp() throws Exception {
		modelsLocation = new HashMap<String, String>();
		modelsLocation.put("aspects", "adaptability_models/");
		modelsLocation.put("variants", "uml_models/variants/");
		modelsLocation.put("profiles", "uml_models/profiles/");
		modelsLocation.put("patterns", "patterns/");
		modelsLocation.put("features", "features/models");

		mr = new ModelRepository(repository);
	}

	@After
	public void cleanUp() {

	}

	@Test
	public void testGetValidFeatureAspects() {
		mr.getAspectModels("GooglePlay_API_GooglePlay", modelsLocation);
	}
	
//	@Test
//	public void testGetValidFeatureAspectsURIs() {
//		mr.getAspectModelsURIs("GooglePlay_API_GooglePlay");
//	}
	
}
