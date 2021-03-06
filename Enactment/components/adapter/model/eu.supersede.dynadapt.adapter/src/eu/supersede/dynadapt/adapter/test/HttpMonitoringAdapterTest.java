package eu.supersede.dynadapt.adapter.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.junit.Before;
import org.junit.Test;

import eu.supersede.dynadapt.adapter.Adapter;
import eu.supersede.dynadapt.adapter.IAdapter;
import eu.supersede.dynadapt.adapter.exception.EnactmentException;
import eu.supersede.dynadapt.model.ModelManager;
import eu.supersede.dynadapt.modelrepository.repositoryaccess.ModelRepository;
import eu.supersede.integration.api.adaptation.types.ModelSystem;

public class HttpMonitoringAdapterTest {
	
	private final static Logger log = LogManager.getLogger(HttpMonitoringAdapterTest.class);
	
	private String baseModelPath;
	private String repository;
	private String repositoryRelativePath;
	private String platformRelativePath;
	
	private Map<String, String> modelsLocation;
	
	private ModelManager mm;
	private ModelRepository mr;
	
	private IAdapter adapter;
	
	@Before
	public void setUp() throws Exception {
		setupPlatform();		
		mm = new ModelManager(baseModelPath);
		mr = new ModelRepository(repository,repositoryRelativePath, mm);
	}

	private void setupPlatform() {
		baseModelPath = "platform:/resource/eu.supersede.dynadapt.adapter/repository/models/base/HttpMonitoringSystemBaseModel.uml";
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
	}
	
	@Test
	public void testHttpMonitorAdaptation() {
		try {
			boolean demo = true;
			adapter = new Adapter(mr, mm, modelsLocation, repositoryRelativePath, demo);

			//String adaptationDecisionActionId = "low_timeslot";
			String adaptationDecisionActionId = "f_873247801";
			adapter.enactAdaptationDecisionAction(
					ModelSystem.AtosMonitoringEnabling, adaptationDecisionActionId, null);
		} catch (EnactmentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
