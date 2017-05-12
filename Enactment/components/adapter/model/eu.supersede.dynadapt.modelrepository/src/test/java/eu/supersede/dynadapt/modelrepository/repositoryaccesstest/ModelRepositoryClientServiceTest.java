package eu.supersede.dynadapt.modelrepository.repositoryaccesstest;

import java.net.URL;
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
import eu.supersede.dynadapt.featuremodel.fc.FeatureConfigDAO;
import eu.supersede.dynadapt.featuremodel.fc.FeatureConfigLAO;
import eu.supersede.dynadapt.featuremodel.fc.IFeatureConfigLAO;
import eu.supersede.dynadapt.model.ModelManager;
import eu.supersede.dynadapt.modelrepository.repositoryaccess.GenericModelRepository;
import eu.supersede.dynadapt.modelrepository.repositoryaccess.ModelRepository;

public class ModelRepositoryClientServiceTest {

	private final static Logger log = LogManager.getLogger(ModelRepositoryClientServiceTest.class);
	
	String repository = "platform:/resource/eu.supersede.dynadapt.modelrepository/models/";
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
		modelsLocation.put("patterns", "patterns/");
		modelsLocation.put("features", "features/models/");

		mm = new ModelManager(false);
		mr = new ModelRepository(repository, repositoryRelativePath, mm);
	}

	@After
	public void cleanUp() {

	}
	
	@Test
	public void getAspectModels() throws Exception {
		List<Aspect> aspects = mr.getAspectModels("featureId", modelsLocation);
		System.out.println("Retrieved " + aspects.size() + " aspect models");
		for (int i = 0; i < aspects.size(); ++i) {
			System.out.println(aspects.get(0).getName());
		}
	}
	
	/*@Test
	public void loadModels() throws Exception {
		mr.loadModels(modelsLocation);
		
	}*/
	
}
