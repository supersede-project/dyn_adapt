package eu.supersede.dynadapt.adapter.service;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eu.supersede.dynadapt.adapter.Adapter;
import eu.supersede.dynadapt.adapter.IAdapter;
import eu.supersede.dynadapt.adapter.exception.EnactmentException;
import eu.supersede.dynadapt.adapter.kpi.AdapterKPIComputer;
import eu.supersede.dynadapt.adapter.service.configuration.AdapterServiceConfiguration;
import eu.supersede.dynadapt.model.ModelManager;
import eu.supersede.dynadapt.modelrepository.repositoryaccess.ModelRepository;
import eu.supersede.integration.api.adaptation.types.ModelSystem;

@RestController
@RequestMapping(value = "/enactment")
public class AdapterService {
	private final static Logger log = LogManager.getLogger(AdapterService.class);
	String repository;
	String repositoryRelativePath;
	// String repositoryResolverPath;
	String platformRelativePath;

	Map<String, String> modelsLocation;

	ModelRepository mr = null;
	ModelManager mm = null;
	IAdapter adapter = null;

	URL url = null;

	public AdapterService() throws Exception {
		this(AdapterServiceConfiguration.getDemoMode());
	}

	public AdapterService(boolean demo) throws Exception {
		if (demo)
			log.debug("Starting Adapter Service in demo mode");
		else
			log.debug("Starting Adapter Service in production mode");
		setUp(demo);
	}

	private void setUp(boolean demo) throws Exception {
		setupPlatform();
		mm = new ModelManager();
		mr = new ModelRepository(repository, repositoryRelativePath, mm);
		adapter = new Adapter(mr, mm, modelsLocation, repositoryRelativePath, demo);
	}

	private void setupPlatform() {
		log.debug("Setting up Adapter Service. Execution path is: " + System.getProperty("user.dir"));
		repository = "platform:/resource/eu.supersede.dynadapt.adapter.service/repository/";

		// These relative paths are compatible for standalone execution within
		// eu.supersede.dynadapt.adapter.service project
		// and within $TOMCAT/bin, provided above project is copied within
		// $TOMCAT folder
		// repositoryRelativePath =
		// "../eu.supersede.dynadapt.adapter.service/repository";
		repositoryRelativePath = "./repository";
		// repositoryResolverPath =
		// "platform:/resource/eu.supersede.dynadapt.adapter.service/repository";
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

	// FIXME: POST API with no content in request body or request param seems
	// not to be working when dispatched by WSO2 ESB
	// Therefore this method is not exposed as REST API. This is not a problem
	// because is subsumed by enactAdaptationDecisionActions

	// @RequestMapping(value="/adaptationDecisionAction/{adaptationDecisionActionId}/featureConfiguration/{featureConfigurationId}/system/{systemId}",
	// method=RequestMethod.POST)
	public void enactAdaptationDecisionAction(@PathVariable String systemId,
			@PathVariable String adaptationDecisionActionId, @PathVariable String featureConfigurationId)
			throws EnactmentException {
		log.debug("featureConfigurationId: "
				+ (featureConfigurationId == null ? "Null pointer" : featureConfigurationId));
		if (featureConfigurationId.equals("null"))
			featureConfigurationId = null;
		adapter.enactAdaptationDecisionAction(ModelSystem.valueOf(systemId), adaptationDecisionActionId,
				featureConfigurationId);
	}

	@RequestMapping(value = "/adaptationDecisionActions/featureConfiguration/{featureConfigurationId}/system/{systemId}", method = RequestMethod.POST)
	public void enactAdaptationDecisionActions(@PathVariable String systemId,
			@RequestParam(value = "adaptationDecisionActionIds") List<String> adaptationDecisionActionIds,
			@PathVariable String featureConfigurationId) throws EnactmentException {
		log.debug("featureConfigurationId: "
				+ (featureConfigurationId == null ? "Null pointer" : featureConfigurationId));
		// if (featureConfigurationId.equals("null")) featureConfigurationId =
		// null;
		adapter.enactAdaptationDecisionActions(ModelSystem.valueOf(systemId), adaptationDecisionActionIds,
				featureConfigurationId);
	}

	@RequestMapping(value = "/adaptationDecisionActions/system/{systemId}", method = RequestMethod.POST)
	public void enactAdaptationDecisionActionsInFCasString(@PathVariable String systemId,
			@RequestParam(value = "fc") String featureConfigurationAsString,
			@RequestParam(value = "adaptationDecisionActionIds") List<String> adaptationDecisionActionIds,
			@RequestParam(value = "fc_id") String featureConfigurationId) throws EnactmentException {
		adapter.enactAdaptationDecisionActionsInFCasString(ModelSystem.valueOf(systemId), adaptationDecisionActionIds,
				featureConfigurationAsString, featureConfigurationId);
	}

	@RequestMapping(value = "/adaptationConfiguration/system/{systemId}", method = RequestMethod.POST)
	public void enactFCasString(@PathVariable String systemId, 
			@RequestParam(value = "fc") String featureConfigurationAsString,
			@RequestParam(value = "fc_id") String featureConfigurationId) throws EnactmentException {
		adapter.enactAdaptationDecisionActionsInFCasString(ModelSystem.valueOf(systemId), null,
				featureConfigurationAsString, featureConfigurationId);
	}

	@RequestMapping(value = "/ping/{message}", method = RequestMethod.GET)
	public String ping(@PathVariable String message) {
		return "Pong: " + message;
	}

	@RequestMapping(value = "/adaptationDecisionActionsForFC/featureConfiguration/{featureConfigurationId}/system/{systemId}", method = RequestMethod.POST)
	public void enactAdaptationDecisionActionsForFC(@PathVariable String systemId,
			@PathVariable String featureConfigurationId) throws EnactmentException {
		log.debug("featureConfigurationId: "
				+ (featureConfigurationId == null ? "Null pointer" : featureConfigurationId));
		if (featureConfigurationId != null && featureConfigurationId.equals("null"))
			featureConfigurationId = null;
		adapter.enactAdaptationDecisionActionsForFC(ModelSystem.valueOf(systemId), featureConfigurationId);
	}
	
	@RequestMapping(value = "/featureConfiguration/{featureConfigurationId}/system/{systemId}", method = RequestMethod.POST)
	public void enactFeatureConfiguration(@PathVariable String systemId, @PathVariable String featureConfigurationId) throws EnactmentException{
		log.debug("featureConfigurationId: "
				+ (featureConfigurationId == null ? "Null pointer" : featureConfigurationId));
		if (featureConfigurationId != null && featureConfigurationId.equals("null"))
			featureConfigurationId = null;
		adapter.enactFeatureConfiguration(ModelSystem.valueOf(systemId), featureConfigurationId);
	}

	public AdapterKPIComputer getEnactorKPIComputer() {
		return ((Adapter) adapter).kpiComputerEnactor;
	}

	public AdapterKPIComputer getAdapterKPIComputer() {
		return ((Adapter) adapter).kpiComputerAdapter;
	}
}
