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
import eu.supersede.dynadapt.adapter.exception.EnactmentException;
import eu.supersede.dynadapt.model.ModelManager;
import eu.supersede.dynadapt.modelrepository.populate.PopulateRepositoryManager;
import eu.supersede.dynadapt.modelrepository.repositoryaccess.ModelRepository;
import eu.supersede.integration.api.adaptation.types.ModelSystem;
import eu.supersede.integration.api.adaptation.types.ModelType;
import eu.supersede.integration.api.adaptation.types.Status;

public class SiemensAdapterTest {
	private static final String MODELS_AUTHOR = "Orlando";
	
	String repository;
	String repositoryRelativePath;
	String platformRelativePath;
	
	Map<String, String> modelsLocation;

	ModelRepository mr = null;
	ModelManager mm = null;
	Adapter adapter = null;

	URL url = null;
	
	@Test
	public void testSiemensUCAdaptation() {
		try {
			boolean demo = true; //Required in test, demo flag will be transmitted to Enactor to simulate the enactment process on real UC systems			
			adapter = new Adapter(mr, mm, modelsLocation, repositoryRelativePath, demo);
			String[] adaptationDecisionActionIds = new String[]{"c4"};
			//TODO This following loc is not necessary in Siemens UC, as there is just one feature configuratin
			//in Status.COMPUTED state in the model repository. However, for completeness and simmetry with the
			//Atos UC, it'd ne nice to have it executed. The problem is that this model is not currently present
			//in the ./repository/features/configurations folder. Therefore, before decomenting this line, we
			//need to update the former with that of .adapter.service//repository/features/configurations first.
//			uploadLatestComputedFC("FeatureModel-S1c_dm_optimized.yafc");
			String featureConfigurationId = null;
			adapter.enactAdaptationDecisionActions(
					ModelSystem.Siemens, Arrays.asList(adaptationDecisionActionIds), featureConfigurationId);
		} catch (EnactmentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * FIXME THIS TEST WON'T WORK UNTIL WE UPDATE THE FOLDER "./repository/features/configurations" WITHT THE
	 * CONTENT OF ".adapter.service//repository/features/configurations", TO BRING THE FEATURE CONFIGURATION
	 * MODEL CALLED "FeatureModel-S1c_dm_optimized.yafc"
	 */
	@Test
	public void testSiemenesUCAdaptationSpecificActionsTakenFCfromString() {
		try {
			boolean demo = true; //Required in test, demo flag will be transmitted to Enactor to simulate the enactment process on real UC systems
			adapter = new Adapter(mr, mm, modelsLocation, repositoryRelativePath, demo);
			String[] adaptationDecisionActionIds = new String[]{"c4"};
			String featureConfigurationAsString = readFCfromFile("/features/configurations/FeatureModel-S1c_dm_optimized.yafc");
			adapter.enactAdaptationDecisionActionsInFCasString(
					ModelSystem.Siemens, Arrays.asList(adaptationDecisionActionIds), featureConfigurationAsString);
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
	 * @throws IOException
	 * @throws Exception
	 */
	private void uploadLatestComputedFC(String fcName) throws IOException, Exception {
		String userdir = System.getProperty("user.dir");
		Path repositoryPath = FileSystems.getDefault().getPath(userdir,repositoryRelativePath);
		PopulateRepositoryManager prm = new PopulateRepositoryManager (mm, mr);
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "features/configurations", fcName), 
				MODELS_AUTHOR,
				ModelSystem.Siemens, Status.Computed,
				modelsLocation.get("configurations"), 
				FeatureConfiguration.class,
				ModelType.FeatureConfiguration, 
				eu.supersede.integration.api.adaptation.types.FeatureConfiguration.class);
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