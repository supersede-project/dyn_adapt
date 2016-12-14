package eu.supersede.dynadapt.adapter.service;

import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.mwe.utils.StandaloneSetup;

import eu.supersede.dynadapt.adapter.Adapter;
import eu.supersede.dynadapt.adapter.IAdapter;
import eu.supersede.dynadapt.adapter.exception.EnactmentException;
import eu.supersede.dynadapt.adapter.system.SupersedeSystem;
import eu.supersede.dynadapt.model.ModelManager;
import eu.supersede.dynadapt.modelrepository.repositoryaccess.ModelRepository;

public class AdapterService {	
	String baseModelPath;
	String repository;
	String originalFeatureConfigPath;
	String newFeatureConfigPath;
	String featureModelPath;
	String repositoryRelativePath;
	String platformRelativePath;
	
	Map<String, String> modelsLocation;

	ModelRepository mr = null;
	ModelManager mm = null;
	IAdapter adapter = null;

	URL url = null;
	
	public static void main (String[] args) throws Exception{
		AdapterService instance = new AdapterService();
		instance.setUp();
		instance.testAtosUCAdaptation();
	}

	private void testAtosUCAdaptation() {
		try {
			adapter = new Adapter(mr, mm, modelsLocation);
			//FIXME featureConfigurationId is ignored. Use correct one
			//once Model Repository is available as service.
			String[] adaptationDecisionActionIds = new String[]{"cms_optimal_configuration", "cms_standard_configuration"};
			String featureConfigurationId = null;
			adapter.enactAdaptationDecisionActions(
					SupersedeSystem.ATOS.toString(), Arrays.asList(adaptationDecisionActionIds), featureConfigurationId);
		} catch (EnactmentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	private void setUp() throws Exception {
		setupPlatform();		
		mm = new ModelManager(baseModelPath);
		mr = new ModelRepository(repository,repositoryRelativePath, mm);
	}

	private void setupPlatform() {
		baseModelPath = "platform:/resource/eu.supersede.dynadapt.adapter.service/repository/models/base/atos_base_model.uml";
		repository = "platform:/resource/eu.supersede.dynadapt.adapter.service/repository/";
		originalFeatureConfigPath = "platform:/resource/eu.supersede.dynadapt.adapter.service/repository/features/configurations/AtosNormalCMSCapacityConfiguration.yafc";
		newFeatureConfigPath = "platform:/resource/eu.supersede.dynadapt.adapter.service/repository/features/configurations/AtosOverloadedCMSCapacityConfiguration.yafc";
		featureModelPath = "platform:/resource/eu.supersede.dynadapt.adapter.service/repository/features/models/AtosUCFeatureModel_CMS_Capacity.yafm";
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
