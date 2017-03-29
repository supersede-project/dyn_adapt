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
import eu.supersede.dynadapt.model.ModelManager;
import eu.supersede.dynadapt.modelrepository.repositoryaccess.ModelRepository;
import eu.supersede.integration.api.adaptation.types.ModelSystem;

public class AtosSmartPlatformHSKAdapterTest {
	
	String repository;
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
			String featureConfigurationId = "SmartPlatformFC_HSK_HighLoad";;
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
									
			//FIXME featureConfigurationId is ignored. Use correct one
			//once Model Repository is available as service.
			String[] adaptationDecisionActionIds = new String[]{"mediumloadconfigurationinvm2_b"};
			String featureConfigurationId = "SmartPlatformFC_HSK_HugeLoad";
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
		repository = "platform:/resource/eu.supersede.dynadapt.adapter/repository/";
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
