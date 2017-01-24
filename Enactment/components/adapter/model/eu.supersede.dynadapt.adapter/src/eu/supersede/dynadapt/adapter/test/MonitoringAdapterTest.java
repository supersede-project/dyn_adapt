package eu.supersede.dynadapt.adapter.test;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import cz.zcu.yafmt.model.fc.FeatureConfiguration;
import cz.zcu.yafmt.model.fm.FeatureModel;
import eu.supersede.dynadapt.adapter.Adapter;
import eu.supersede.dynadapt.adapter.exception.EnactmentException;
import eu.supersede.dynadapt.adapter.system.SupersedeSystem;
import eu.supersede.dynadapt.dsl.aspect.Aspect;
import eu.supersede.dynadapt.featuremodel.fc.FeatureConfigDAO;
import eu.supersede.dynadapt.featuremodel.fc.FeatureConfigLAO;
import eu.supersede.dynadapt.featuremodel.fc.FeatureConfigSUPERSEDE;
import eu.supersede.dynadapt.featuremodel.fc.IFeatureConfigLAO;
import eu.supersede.dynadapt.featuremodel.selection.SelectionSUPERSEDE;
import eu.supersede.dynadapt.model.ModelManager;
import eu.supersede.dynadapt.modelrepository.repositoryaccess.ModelRepository;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.eclipse.uml2.uml.Model;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

public class MonitoringAdapterTest {
	private final static Logger log = LogManager.getLogger(MonitoringAdapterTest.class);

	String baseModelPath;
	String repository;
	String featureConfigPath;
	String featureModelPath;
	String localPath;
	String repositoryRelativePath;
	String platformRelativePath;
	Map<String, String> modelsLocation;

	ModelRepository mr = null;
	ModelManager mm = null;
	Adapter adapter = null;

	URL url = null;
	
	IFeatureConfigLAO fcLAO = null;
	
	@Before
	public void setUp() throws Exception {
		setupPlatform();		
		mm = new ModelManager(baseModelPath); //Base Model loaded here
		mr = new ModelRepository(repository,repositoryRelativePath, mm);
	}

	private void setupPlatform() {
		baseModelPath = "platform:/resource/eu.supersede.dynadapt.adapter/repository/models/base/MonitoringSystemBaseModel.uml";
		repository = "platform:/resource/eu.supersede.dynadapt.adapter/repository/";
		featureModelPath = "platform:/resource/eu.supersede.dynadapt.adapter/repository/features/models/MonitoringSystem.yafm";
		repositoryRelativePath = "./repository";
		platformRelativePath = "../";

		new StandaloneSetup().setPlatformUri(platformRelativePath);
		modelsLocation = new HashMap<String, String>();
		modelsLocation.put("aspects", "adaptability_models/");
		modelsLocation.put("variants", "models/variants/");
		modelsLocation.put("base", "models/base/");
		modelsLocation.put("profiles", "models/profiles/");
		modelsLocation.put("patterns", "patterns/eu/supersede/dynadapt/usecases/monitoring/patterns/");
		modelsLocation.put("features", "features/models/");
	}

	/*@Before
	public void setUp() throws Exception {
		new StandaloneSetup().setPlatformUri("../");
		modelsLocation = new HashMap<String, String>();
		modelsLocation.put("aspects", "adaptability_models/");
		modelsLocation.put("variants", "uml_models/variants/");
		modelsLocation.put("base", "uml_models/base/");
		modelsLocation.put("profiles", "uml_models/profiles/");
		modelsLocation.put("patterns", "patterns/");
		modelsLocation.put("features", "features/models/");
		
		url = new URL(localPath);
		mm = new ModelManager(baseModelPath);
		mr = new ModelRepository(repository,url, mm);
		
		fcLAO = new FeatureConfigLAO(new FeatureConfigDAO());
	}*/
	
	@Test
	public void testMonitoringUCAdaptation() {
		try {
			adapter = new Adapter(mr, mm, modelsLocation, repositoryRelativePath);
			//FIXME featureConfigurationId is ignored. Use correct one
			//once Model Repository is available as service.
			String adaptationDecisionActionId = "timeSlot_twitter";
			String featureConfigurationId = null;
			adapter.enactAdaptationDecisionAction(
					SupersedeSystem.MONITORING.toString(), adaptationDecisionActionId, featureConfigurationId);
		} catch (EnactmentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*@Test
	public void adapt() {
		try {
			adapter = new Adapter(mr, mm, modelsLocation, localPath);
			Model baseModel = mm.loadUMLModel(baseModelPath); //FIXME Already loaded during ModelManager instantiation
			
			FeatureModel featureModel = mm.loadFeatureModel(featureModelPath);
			List<Aspect> a = mr.getAspectModels("timeSlot_twitter", modelsLocation);
			FeatureConfiguration featureConfig = mm.loadFeatureConfiguration(featureConfigPath);

			Model model = adapter.adapt(featureModel, featureConfig, a.get(0), baseModel);
			
			System.out.println("Saving model");
			save(model, URI.createURI(repository + modelsLocation.get("base") + "MonitoringSystemAdaptedBaseModel.uml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	protected void save(Model model, URI uri) {

		ResourceSet resourceSet = new ResourceSetImpl();
       // UMLResourcesUtil.init(resourceSet);
        Resource resource = resourceSet.createResource(uri);
        resource.getContents().add(model);
        try {
            resource.save(null); // no save options needed
        } catch (IOException ioe) {
        }
    }

}