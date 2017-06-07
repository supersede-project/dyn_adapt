package eu.supersede.dynadapt.modelrepository.repositoryaccesstest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import eu.supersede.dynadapt.dsl.aspect.Aspect;
import eu.supersede.dynadapt.model.ModelManager;
import eu.supersede.dynadapt.modelrepository.repositoryaccess.ModelRepository;
import eu.supersede.integration.api.adaptation.types.ModelSystem;

public class ModelRepositoryClientServiceTest {

	private final static Logger log = LogManager.getLogger(ModelRepositoryClientServiceTest.class);
	
	String repository = "platform:/resource/eu.supersede.dynadapt.adapter/repository/";
	String repositoryRelativePath = "repository";

	Map<String, String> modelsLocation;

	ModelRepository mr = null;
	ModelManager mm = null;

	@Before
	public void setUp() throws Exception {
		new StandaloneSetup().setPlatformUri("../");
		modelsLocation = new HashMap<String, String>();
		modelsLocation.put("aspects", "adaptability_models/");
		modelsLocation.put("variants", "models/variants/");
		modelsLocation.put("profiles", "models/profiles/");
		modelsLocation.put("patterns", "patterns/eu/supersede/dynadapt/usecases/monitoring/patterns/");
		modelsLocation.put("features", "features/models/");

		mm = new ModelManager(false);
		mr = new ModelRepository(repository, repositoryRelativePath, mm);
	}

	@After
	public void cleanUp() {

	}
	
	@Test
	public void getAspectModels() throws Exception {
		List<Aspect> aspects = mr.getAspectModelsFromRepository(ModelSystem.MonitoringReconfiguration, "timeSlot_twitter");
		System.out.println("Found " + aspects.size() + " aspect models");
		for (Aspect a : aspects) {
			System.out.println(a.getName() + " with feature " + a.getFeature().getId());
		}
	}
	
	/*@Test
	public void loadModels() throws Exception {
		mr.loadModels(modelsLocation);
		
	}*/
	
}
