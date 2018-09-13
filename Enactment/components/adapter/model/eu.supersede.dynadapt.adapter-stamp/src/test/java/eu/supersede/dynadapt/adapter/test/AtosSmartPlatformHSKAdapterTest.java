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
import org.junit.Ignore;
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

public class AtosSmartPlatformHSKAdapterTest {
	
	private static final String MODELS_AUTHOR = "Yosu";
	String repository;
	String repositoryRelativePath;
	String platformRelativePath;
	
	Map<String, String> modelsLocation;

	ModelRepository mr = null;
	ModelManager mm = null;
	IAdapter adapter = null;

	URL url = null;
	
	@Ignore @Test
	public void testAtosHighHSKAdaptation() {
		try {
			boolean demo = true; //Required in test, demo flag will be transmitted to Enactor to simulate the enactment process on real UC systems
			adapter = new Adapter(mr, mm, modelsLocation, repositoryRelativePath, demo);
			String[] adaptationDecisionActionIds = new String[]{"highloadconfigurationinvm2_a", "lowloadconfigurationinvm2_a"};
			String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
			adapter.enactAdaptationDecisionActions(
					ModelSystem.Atos_HSK, Arrays.asList(adaptationDecisionActionIds), featureConfigurationId);
			
		} catch (EnactmentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Ignore @Test
	public void testBatchAtosHighHSKAdaptation() throws Exception{
		int numberRuns = 2;
		boolean demo = true; //Required in test, demo flag will be transmitted to Enactor to simulate the enactment process on real UC systems
		adapter = new Adapter(mr, mm, modelsLocation, repositoryRelativePath, demo);
		String[] adaptationDecisionActionIds = new String[]{"highloadconfigurationinvm2_a", "lowloadconfigurationinvm2_a"};
		String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
		for (int i=0; i<numberRuns; i++){
			adapter.enactAdaptationDecisionActions(
					ModelSystem.Atos_HSK, Arrays.asList(adaptationDecisionActionIds), featureConfigurationId);
		}	
		((Adapter)adapter).kpiComputerAdapter.reportComputedKPITimeSeries();
		((Adapter)adapter).kpiComputerEnactor.reportComputedKPITimeSeries();
	}
	
	
	
	@Ignore @Test
	public void testAtosHugeHSKAdaptation() {
		try {
			boolean demo = true; //Required in test, demo flag will be transmitted to Enactor to simulate the enactment process on real UC systems
			adapter = new Adapter(mr, mm, modelsLocation, repositoryRelativePath, demo);									
			String[] adaptationDecisionActionIds = new String[]{"mediumloadconfigurationinvm2_b"};
			String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_DualVM_HighMediumLoad.yafc");		
			adapter.enactAdaptationDecisionActions(
					ModelSystem.Atos_HSK, Arrays.asList(adaptationDecisionActionIds), featureConfigurationId);
		} catch (EnactmentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Ignore @Test
	public void testAtosHSKDualVMHighLowAdaptation() {
		try {
			boolean demo = true; //Required in test, demo flag will be transmitted to Enactor to simulate the enactment process on real UC systems
			adapter = new Adapter(mr, mm, modelsLocation, repositoryRelativePath, demo);									
			//High-Low
//			String[] adaptationDecisionActionIds = new String[]{"lowloadconfigurationinvm2_a","highloadconfigurationinvm2_a","lowloadconfigurationinvm2_b"}; //adding and deleting different configuration options
//			String featureConfigurationId = "SmartPlatformFC_HSK_DualVM_HighLowLoad";
			
			//Medium-Low
//			String[] adaptationDecisionActionIds = new String[]{"lowloadconfigurationinvm2_a","mediumloadconfigurationinvm2_a","lowloadconfigurationinvm2_b"}; //adding and deleting different configuration options
//			String featureConfigurationId = "SmartPlatformFC_HSK_DualVM_MediumLowLoad";
			
			//Low-Low
			String[] adaptationDecisionActionIds = new String[]{"lowloadconfigurationinvm2_b"}; //adding and deleting different configuration options
//			String featureConfigurationId = "SmartPlatformFC_HSK_DualVM_LowLowLoad";
			String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_DualVM_LowLowLoad.yafc");		
			adapter.enactAdaptationDecisionActions(
					ModelSystem.Atos_HSK, Arrays.asList(adaptationDecisionActionIds), featureConfigurationId);
		} catch (EnactmentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Ignore @Test
	public void testAtosHighHSKAdaptationSpecificActionsTakenFCfromString() {
		try {
			boolean demo = true; //Required in test, demo flag will be transmitted to Enactor to simulate the enactment process on real UC systems
			adapter = new Adapter(mr, mm, modelsLocation, repositoryRelativePath, demo);
			String[] adaptationDecisionActionIds = new String[]{"highloadconfigurationinvm2_a", "lowloadconfigurationinvm2_a"};
			String featureConfigurationAsString = readFCfromFile("/features/configurations/SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
			String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
			adapter.enactAdaptationDecisionActionsInFCasString(
					ModelSystem.Atos_HSK, Arrays.asList(adaptationDecisionActionIds), featureConfigurationAsString, featureConfigurationId);
		} catch (EnactmentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Ignore @Test
	public void testAtosHighHSKAdaptationTakenFCfromString() {
		try {
			boolean demo = true; //Required in test, demo flag will be transmitted to Enactor to simulate the enactment process on real UC systems
			adapter = new Adapter(mr, mm, modelsLocation, repositoryRelativePath, demo);
			String[] adaptationDecisionActionIds = new String[]{};
			String featureConfigurationAsString = readFCfromFile("/features/configurations/SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
			String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
			adapter.enactAdaptationDecisionActionsInFCasString(
					ModelSystem.Atos_HSK, Arrays.asList(adaptationDecisionActionIds), featureConfigurationAsString, featureConfigurationId);
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
				ModelSystem.Atos_HSK, Status.Computed,
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
