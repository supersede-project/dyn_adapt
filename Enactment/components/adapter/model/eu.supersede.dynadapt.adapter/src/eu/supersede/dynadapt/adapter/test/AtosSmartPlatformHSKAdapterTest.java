package eu.supersede.dynadapt.adapter.test;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import eu.supersede.dynadapt.adapter.Adapter;
import eu.supersede.dynadapt.adapter.IAdapter;
import eu.supersede.dynadapt.adapter.exception.EnactmentException;
import eu.supersede.dynadapt.adapter.system.ModelRepositoryMapping;
import eu.supersede.dynadapt.adapter.system.RepositoryMetadata;
import eu.supersede.dynadapt.adapter.system.RepositoryMetadata.ResourceTimestamp;
import eu.supersede.dynadapt.adapter.system.RepositoryMetadata.ResourceType;
import eu.supersede.dynadapt.model.ModelManager;
import eu.supersede.dynadapt.modelrepository.repositoryaccess.ModelRepository;
import eu.supersede.integration.api.adaptation.types.ModelSystem;

public class AtosSmartPlatformHSKAdapterTest {
	
	String repository;
	String repositoryRelativePath;
	String repositoryResolverPath;
	String platformRelativePath;
	
	Map<String, String> modelsLocation;

	ModelRepository mr = null;
	ModelManager mm = null;
	IAdapter adapter = null;

	URL url = null;
	
	@Test
	public void testAtosHighHSKAdaptation() {
		try {
			adapter = new Adapter(mr, mm, modelsLocation, repositoryResolverPath, repositoryRelativePath);
			String[] adaptationDecisionActionIds = new String[]{"highloadconfigurationinvm2_a", "lowloadconfigurationinvm2_a"};
			String featureConfigurationId = "SmartPlatformFC_HSK_SingleVM_HighLoad";
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
		adapter = new Adapter(mr, mm, modelsLocation, repositoryResolverPath, repositoryRelativePath);
		String[] adaptationDecisionActionIds = new String[]{"highloadconfigurationinvm2_a", "lowloadconfigurationinvm2_a"};
		String featureConfigurationId = "SmartPlatformFC_HSK_SingleVM_HighLoad";
		
		for (int i=0; i<numberRuns; i++){
			adapter.enactAdaptationDecisionActions(
					ModelSystem.Atos_HSK, Arrays.asList(adaptationDecisionActionIds), featureConfigurationId);
		}
		
		((Adapter)adapter).kpiComputerAdapter.reportComputedKPITimeSeries();
		((Adapter)adapter).kpiComputerEnactor.reportComputedKPITimeSeries();
	}
	
	
	
	@Test
	public void testAtosHugeHSKAdaptation() {
		try {
			adapter = new Adapter(mr, mm, modelsLocation, repositoryResolverPath, repositoryRelativePath);
									
			String[] adaptationDecisionActionIds = new String[]{"mediumloadconfigurationinvm2_b"};
			String featureConfigurationId = "SmartPlatformFC_HSK_DualVM_HighMediumLoad";
			adapter.enactAdaptationDecisionActions(
					ModelSystem.Atos_HSK, Arrays.asList(adaptationDecisionActionIds), featureConfigurationId);
		} catch (EnactmentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAtosHSKDualVMHighLowAdaptation() {
		try {
			adapter = new Adapter(mr, mm, modelsLocation, repositoryResolverPath, repositoryRelativePath);
									
			String[] adaptationDecisionActionIds = new String[]{"lowloadconfigurationinvm2_a","highloadconfigurationinvm2_a","lowloadconfigurationinvm2_b"}; //adding and deleting different configuration options
			String featureConfigurationId = "SmartPlatformFC_HSK_DualVM_HighLowLoad";
			adapter.enactAdaptationDecisionActions(
					ModelSystem.Atos_HSK, Arrays.asList(adaptationDecisionActionIds), featureConfigurationId);
		} catch (EnactmentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAtosHighHSKAdaptationSpecificActionsTakenFCfromString() {
		try {
			adapter = new Adapter(mr, mm, modelsLocation, repositoryResolverPath, repositoryRelativePath);
			String[] adaptationDecisionActionIds = new String[]{"highloadconfigurationinvm2_a", "lowloadconfigurationinvm2_a"};
			URI fcUri = ModelRepositoryMapping.getModelURI (ModelSystem.Atos_HSK, new RepositoryMetadata(ResourceType.FEATURE_CONFIGURATION, ResourceTimestamp.NEWEST));
			String sFcUri = fcUri.toString();
			sFcUri = sFcUri.substring(sFcUri.indexOf('/',sFcUri.indexOf('/') + 1) + 1);
			Path fcPath = Paths.get(platformRelativePath, sFcUri);
			String featureConfigurationAsString = new String(Files.readAllBytes(fcPath));
			adapter.enactAdaptationDecisionActionsInFCasString(
					ModelSystem.Atos_HSK, Arrays.asList(adaptationDecisionActionIds), featureConfigurationAsString);
		} catch (EnactmentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAtosHighHSKAdaptationTakenFCfromString() {
		try {
			adapter = new Adapter(mr, mm, modelsLocation, repositoryResolverPath, repositoryRelativePath);
			String[] adaptationDecisionActionIds = new String[]{};
			URI fcUri = ModelRepositoryMapping.getModelURI (ModelSystem.Atos_HSK, new RepositoryMetadata(ResourceType.FEATURE_CONFIGURATION, ResourceTimestamp.NEWEST));
			String sFcUri = fcUri.toString();
			sFcUri = sFcUri.substring(sFcUri.indexOf('/',sFcUri.indexOf('/') + 1) + 1);
			Path fcPath = Paths.get(platformRelativePath, sFcUri);
			String featureConfigurationAsString = new String(Files.readAllBytes(fcPath));
			adapter.enactAdaptationDecisionActionsInFCasString(
					ModelSystem.Atos_HSK, Arrays.asList(adaptationDecisionActionIds), featureConfigurationAsString);
		} catch (EnactmentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Before
	public void setUp() throws Exception {
		setupPlatform();		
		mm = new ModelManager(); 
		mr = new ModelRepository(repository,repositoryRelativePath, mm);
	}

	private void setupPlatform() {
		repository = "platform:/resource/eu.supersede.dynadapt.adapter/repository/";
		repositoryRelativePath = "./repository";
		repositoryResolverPath = "platform:/resource/eu.supersede.dynadapt.adapter/repository";
		platformRelativePath = "../";

		new StandaloneSetup().setPlatformUri(platformRelativePath);
		modelsLocation = new HashMap<String, String>();
		modelsLocation.put("aspects", "adaptability_models/");
		modelsLocation.put("variants", "models/variants/");
		modelsLocation.put("base", "models/base/");
		modelsLocation.put("profiles", "models/profiles/");
		modelsLocation.put("patterns", "patterns/eu/supersede/dynadapt/usecases/atos/patterns/");
		modelsLocation.put("features", "features/models/");
		modelsLocation.put("adapted", "models/adapted/");
	}

}
