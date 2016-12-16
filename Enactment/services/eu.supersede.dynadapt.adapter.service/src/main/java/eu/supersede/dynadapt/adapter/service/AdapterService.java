package eu.supersede.dynadapt.adapter.service;

import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import eu.supersede.dynadapt.adapter.Adapter;
import eu.supersede.dynadapt.adapter.IAdapter;
import eu.supersede.dynadapt.adapter.exception.EnactmentException;
import eu.supersede.dynadapt.adapter.system.SupersedeSystem;
import eu.supersede.dynadapt.model.ModelManager;
import eu.supersede.dynadapt.modelrepository.repositoryaccess.ModelRepository;

@RestController
@RequestMapping(value="/enactment")
public class AdapterService implements IAdapter{	
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
	
	public AdapterService() throws Exception{
		setUp();
	}
	
//	public static void main (String[] args) throws Exception{
//		AdapterService instance = new AdapterService();
//		instance.testAtosUCAdaptation();
//	}

	private void testAtosUCAdaptation() {
		try {
			//FIXME featureConfigurationId is ignored. Use correct one
			//once Model Repository is available as service.
			String[] adaptationDecisionActionIds = new String[]{"cms_optimal_configuration", "cms_standard_configuration"};
			String featureConfigurationId = null;
			enactAdaptationDecisionActions(
					SupersedeSystem.ATOS.toString(), Arrays.asList(adaptationDecisionActionIds), featureConfigurationId);
			enactAdaptationDecisionAction(
					SupersedeSystem.ATOS.toString(), adaptationDecisionActionIds[0], featureConfigurationId);
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
		adapter = new Adapter(mr, mm, modelsLocation);
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

	@Override
	@RequestMapping(value="/adaptationDecisionAction/{adaptationDecisionActionId}/{featureConfigurationId}/{systemId}", method=RequestMethod.POST)
	public void enactAdaptationDecisionAction(@PathVariable String systemId, @PathVariable String adaptationDecisionActionId,
			@PathVariable String featureConfigurationId) throws EnactmentException {
		adapter.enactAdaptationDecisionAction(systemId, adaptationDecisionActionId, featureConfigurationId);
	}

	@Override
	@RequestMapping(value="/adaptationDecisionActions/{adaptationDecisionActionIds}/{featureConfigurationId}/{systemId}", method=RequestMethod.POST)
	public void enactAdaptationDecisionActions(@PathVariable String systemId, @PathVariable List<String> adaptationDecisionActionIds,
			@PathVariable String featureConfigurationId) throws EnactmentException {
		adapter.enactAdaptationDecisionActions(systemId, adaptationDecisionActionIds, featureConfigurationId);
	}
}
