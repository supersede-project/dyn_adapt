package eu.supersede.dynadapt.adapter.test;

import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.junit.Before;
import org.junit.Test;

import eu.supersede.dynadapt.adapter.Adapter;
import eu.supersede.dynadapt.adapter.IAdapter;
import eu.supersede.dynadapt.adapter.exception.EnactmentException;
import eu.supersede.dynadapt.adapter.system.ModelRepositoryMapping;
import eu.supersede.dynadapt.adapter.system.RepositoryMetadata;
import eu.supersede.dynadapt.adapter.system.SupersedeSystem;
import eu.supersede.dynadapt.adapter.system.RepositoryMetadata.ResourceTimestamp;
import eu.supersede.dynadapt.adapter.system.RepositoryMetadata.ResourceType;
import eu.supersede.dynadapt.model.ModelManager;
import eu.supersede.dynadapt.modelrepository.repositoryaccess.ModelRepository;
import eu.supersede.integration.api.adaptation.types.ModelSystem;

public class AtosSmartPlatformHSKAdapterTest {
	
//	String baseModelPath;
	String repository;
//	String originalFeatureConfigPath;
//	String newFeatureConfigPath;
//	String featureModelPath;
	String repositoryRelativePath;
	String platformRelativePath;
	
	Map<String, String> modelsLocation;

	ModelRepository mr = null;
	ModelManager mm = null;
	IAdapter adapter = null;

	URL url = null;
	
	@Test
	public void testAtosHighHSKAdaptation() {
		try {
			adapter = new Adapter(mr, mm, modelsLocation, repositoryRelativePath);
			//FIXME featureConfigurationId is ignored. Use correct one
			//once Model Repository is available as service.
			String[] adaptationDecisionActionIds = new String[]{"highloadconfigurationinvm2_a", "lowloadconfigurationinvm2_a"};
			String featureConfigurationId = null;
			adapter.enactAdaptationDecisionActions(
					ModelSystem.Atos_HSK, Arrays.asList(adaptationDecisionActionIds), featureConfigurationId);
//			adapter.enactAdaptationDecisionAction(
//					SupersedeSystem.ATOS_HSK.toString(), adaptationDecisionActionIds[0], featureConfigurationId);
		} catch (EnactmentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAtosHugeHSKAdaptation() {
		try {
			adapter = new Adapter(mr, mm, modelsLocation, repositoryRelativePath);
						
			//Computed optimal FC
			RepositoryMetadata metadata = new RepositoryMetadata(ResourceType.FEATURE_CONFIGURATION, ResourceTimestamp.NEWEST);
			ModelRepositoryMapping.setModelURI(SupersedeSystem.ATOS_HSK, metadata, "/features/configurations/SmartPlatformFC_HSK_HugeLoad.yafc");
			
			//FIXME featureConfigurationId is ignored. Use correct one
			//once Model Repository is available as service.
			String[] adaptationDecisionActionIds = new String[]{"mediumloadconfigurationinvm2_b"};
			String featureConfigurationId = null;
			adapter.enactAdaptationDecisionActions(
					ModelSystem.Atos_HSK, Arrays.asList(adaptationDecisionActionIds), featureConfigurationId);
//			adapter.enactAdaptationDecisionAction(
//					SupersedeSystem.ATOS_HSK.toString(), adaptationDecisionActionIds[0], featureConfigurationId);
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
//		baseModelPath = "platform:/resource/eu.supersede.dynadapt.adapter/repository/models/base/atos_smart_base_model.uml";
		repository = "platform:/resource/eu.supersede.dynadapt.adapter/repository/";
//		originalFeatureConfigPath = "platform:/resource/eu.supersede.dynadapt.adapter/repository/features/configurations/SmartPlatformFC_HSK_LowLoad.yafc";
//		newFeatureConfigPath = "platform:/resource/eu.supersede.dynadapt.adapter/repository/features/configurations/SmartPlatformFC_HSK_HighLoad.yafc";
//		featureModelPath = "platform:/resource/eu.supersede.dynadapt.adapter/repository/features/models/SmartPlatformFM_HSK.yafm";
		repositoryRelativePath = "./repository";
		platformRelativePath = "../";

		new StandaloneSetup().setPlatformUri(platformRelativePath);
		modelsLocation = new HashMap<String, String>();
		modelsLocation.put("aspects", "adaptability_models/");
		modelsLocation.put("variants", "models/variants/");
		modelsLocation.put("base", "models/base/");
		modelsLocation.put("profiles", "models/profiles/");
		modelsLocation.put("patterns", "patterns/eu/supersede/dynadapt/usecases/atos/patterns/");
		modelsLocation.put("features", "features/models/");
	}

}
