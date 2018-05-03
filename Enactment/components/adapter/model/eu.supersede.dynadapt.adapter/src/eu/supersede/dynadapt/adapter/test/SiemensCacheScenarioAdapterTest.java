package eu.supersede.dynadapt.adapter.test;

import java.io.IOException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.junit.Before;
import org.junit.Test;

import cz.zcu.yafmt.model.fc.FeatureConfiguration;
import eu.supersede.dynadapt.adapter.Adapter;
import eu.supersede.dynadapt.adapter.IAdapter;
import eu.supersede.dynadapt.adapter.exception.EnactmentException;
import eu.supersede.dynadapt.model.ModelManager;
import eu.supersede.dynadapt.modelrepository.populate.PopulateRepositoryManager;
import eu.supersede.dynadapt.modelrepository.repositoryaccess.ModelRepository;
import eu.supersede.integration.api.adaptation.types.ModelSystem;
import eu.supersede.integration.api.adaptation.types.ModelType;
import eu.supersede.integration.api.adaptation.types.Status;

public class SiemensCacheScenarioAdapterTest {
	
	private static final String MODELS_AUTHOR = "Srdjan";
	String repository;
	String repositoryRelativePath;
	String platformRelativePath;
	
	Map<String, String> modelsLocation;

	ModelRepository mr = null;
	ModelManager mm = null;
	IAdapter adapter = null;

	URL url = null;
	
	@Test
	public void testSiemensCachingServiceAdaptationStrategy1() {
		try {
			boolean demo = true; //Required in test, demo flag will be transmitted to Enactor to simulate the enactment process on real UC systems
			adapter = new Adapter(mr, mm, modelsLocation, repositoryRelativePath, demo);
			String[] adaptationDecisionActionIds = new String[]{"c1"};
			String featureConfigurationId = uploadLatestComputedFC("FeatureConfiguration-SiemensCaching-Strategy1.yafc");
			adapter.enactAdaptationDecisionActions(
					ModelSystem.Siemens, Arrays.asList(adaptationDecisionActionIds), featureConfigurationId);
			
		} catch (EnactmentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSiemensCachingServiceAdaptationStrategy2() {
		try {
			boolean demo = true; //Required in test, demo flag will be transmitted to Enactor to simulate the enactment process on real UC systems
			adapter = new Adapter(mr, mm, modelsLocation, repositoryRelativePath, demo);
			String featureConfigurationId = uploadLatestComputedFC("FeatureConfiguration-SiemensCaching-Strategy2.yafc");
			adapter.enactAdaptationDecisionActionsForFC(ModelSystem.Siemens, featureConfigurationId);
			
		} catch (EnactmentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * To get the serialization string of a given configuration model
	 * @param filePath the name of the feature configuration file, relative to the model repository folder.
	 * @return
	 * @throws EnactmentException
	 * @throws IOException
	 */
	private String readFCfromFile(String filePath) throws EnactmentException, IOException {
		String userdir = System.getProperty("user.dir");
		Path repositoryPath = FileSystems.getDefault().getPath(userdir,repositoryRelativePath);
		
		Path fcPath = Paths.get(repositoryPath.toString(), filePath);
		String featureConfigurationAsString = new String(Files.readAllBytes(fcPath));
		return featureConfigurationAsString;
	}
	
	/** 
	 * Load a given configuration model as the latest ComputedModel for Siemens system,
	 * simulating it is the result of the last decision-making optimization update
	 * @param fcName the name of the feature configuration file
	 * @return the id of the new model in the model repository
	 * @throws IOException
	 * @throws Exception
	 */
	private String uploadLatestComputedFC(String fcName) throws IOException, Exception {
		String userdir = System.getProperty("user.dir");
		Path repositoryPath = FileSystems.getDefault().getPath(userdir,repositoryRelativePath);
		PopulateRepositoryManager prm = new PopulateRepositoryManager (mm, mr);
		String modelId = prm.populateModel(
				Paths.get(repositoryPath.toString(), "features/configurations", fcName), 
				MODELS_AUTHOR,
				ModelSystem.Siemens, Status.Computed,
				modelsLocation.get("configurations"), 
				FeatureConfiguration.class,
				ModelType.FeatureConfiguration, 
				eu.supersede.integration.api.adaptation.types.FeatureConfiguration.class);
		return modelId;
	}
	
	@Before
	public void setUp() throws Exception {
		setupPlatform();		
		mm = new ModelManager(); 
		mr = new ModelRepository(repository, repositoryRelativePath, mm);
	}

	private void setupPlatform() {
		repository = "platform:/resource/eu.supersede.dynadapt.adapter/repository/";
		repositoryRelativePath = "./repository";
		platformRelativePath = "../";

		new StandaloneSetup().setPlatformUri(platformRelativePath);
		modelsLocation = new HashMap<String, String>();
		modelsLocation.put("aspects", "adaptability_models/");
		modelsLocation.put("variants", "models/variants/");
		modelsLocation.put("base", "models/base/");
		modelsLocation.put("profiles", "models/profiles/");
		modelsLocation.put("patterns", "patterns/eu/supersede/dynadapt/usecases/patterns/");
		modelsLocation.put("features", "features/models/");
		modelsLocation.put("configurations", "features/configurations/");
		modelsLocation.put("adapted", "models/adapted/");
	}

}
