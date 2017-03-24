package eu.supersede.dynadapt.adapter.service;

import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eu.supersede.dynadapt.adapter.Adapter;
import eu.supersede.dynadapt.adapter.IAdapter;
import eu.supersede.dynadapt.adapter.exception.EnactmentException;
import eu.supersede.dynadapt.adapter.system.SupersedeSystem;
import eu.supersede.dynadapt.model.ModelManager;
import eu.supersede.dynadapt.modelrepository.repositoryaccess.ModelRepository;
import eu.supersede.integration.api.adaptation.types.ModelSystem;

@RestController
@RequestMapping(value="/enactment")
public class AdapterService {	
	private final static Logger log = LogManager.getLogger(AdapterService.class);
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
	
	private void setUp() throws Exception {
		setupPlatform();		
		mm = new ModelManager(baseModelPath);
		mr = new ModelRepository(repository,repositoryRelativePath, mm);
		adapter = new Adapter(mr, mm, modelsLocation, repositoryRelativePath);
	}

	private void setupPlatform() {
		log.debug("Setting up Adapter Service. Execution path is: " + System.getProperty("user.dir"));
		baseModelPath = "platform:/resource/eu.supersede.dynadapt.adapter.service/repository/models/base/atos_base_model.uml";
		repository = "platform:/resource/eu.supersede.dynadapt.adapter.service/repository/";
		originalFeatureConfigPath = "platform:/resource/eu.supersede.dynadapt.adapter.service/repository/features/configurations/AtosNormalCMSCapacityConfiguration.yafc";
		newFeatureConfigPath = "platform:/resource/eu.supersede.dynadapt.adapter.service/repository/features/configurations/AtosOverloadedCMSCapacityConfiguration.yafc";
		featureModelPath = "platform:/resource/eu.supersede.dynadapt.adapter.service/repository/features/models/AtosUCFeatureModel_CMS_Capacity.yafm";
	
//		repositoryRelativePath = "./repository";
//		platformRelativePath = "../";
		
		//These relative paths are compatible for standalone execution within eu.supersede.dynadapt.adapter.service project
		//and within $TOMCAT/bin, provided above project is copied within $TOMCAT folder
		repositoryRelativePath = "../eu.supersede.dynadapt.adapter.service/repository";
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

	//FIXME: POST API with no content in request body or request param seems not to be working when dispatched by WSO2 ESB
	//Therefore this method is not exposed as REST API. This is not a problem because is subsumed by enactAdaptationDecisionActions

	//@RequestMapping(value="/adaptationDecisionAction/{adaptationDecisionActionId}/featureConfiguration/{featureConfigurationId}/system/{systemId}", method=RequestMethod.POST)
	public void enactAdaptationDecisionAction(@PathVariable String systemId, @PathVariable String adaptationDecisionActionId,
			@PathVariable String featureConfigurationId) throws EnactmentException {
		adapter.enactAdaptationDecisionAction(ModelSystem.valueOf(systemId), adaptationDecisionActionId, featureConfigurationId);
	}


	@RequestMapping(value="/adaptationDecisionActions/featureConfiguration/{featureConfigurationId}/system/{systemId}", method=RequestMethod.POST)
	public void enactAdaptationDecisionActions(@PathVariable String systemId, @RequestParam (value="adaptationDecisionActionIds") List<String> adaptationDecisionActionIds,
			@PathVariable String featureConfigurationId) throws EnactmentException {
		adapter.enactAdaptationDecisionActions(ModelSystem.valueOf(systemId), adaptationDecisionActionIds, featureConfigurationId);
	}
	
	@RequestMapping(value="/ping/{message}", method=RequestMethod.GET)
	public String ping(@PathVariable String message) {
		return "Pong: " + message;
	}

	@RequestMapping(value="/adaptationDecisionActionsForFC/featureConfiguration/{featureConfigurationId}/system/{systemId}", method=RequestMethod.POST)
	public void enactAdaptationDecisionActionsForFC(@PathVariable String systemId, @RequestParam (value="featureConfigurationId") String featureConfigurationId) throws EnactmentException {
		adapter.enactAdaptationDecisionActionsForFC(ModelSystem.valueOf(systemId), featureConfigurationId);
	}
}
