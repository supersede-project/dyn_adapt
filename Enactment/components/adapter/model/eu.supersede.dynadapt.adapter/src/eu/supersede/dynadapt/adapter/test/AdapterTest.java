package eu.supersede.dynadapt.adapter.test;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import cz.zcu.yafmt.model.fm.FeatureModel;
import eu.supersede.dynadapt.adapter.Adapter;
import eu.supersede.dynadapt.dsl.aspect.Aspect;
import eu.supersede.dynadapt.featuremodel.fc.FeatureConfigDAO;
import eu.supersede.dynadapt.featuremodel.fc.FeatureConfigLAO;
import eu.supersede.dynadapt.featuremodel.fc.FeatureConfigSUPERSEDE;
import eu.supersede.dynadapt.featuremodel.fc.IFeatureConfigLAO;
import eu.supersede.dynadapt.featuremodel.selection.SelectionSUPERSEDE;
import eu.supersede.dynadapt.model.ModelManager;
import eu.supersede.dynadapt.modelrepository.repositoryaccess.ModelRepository;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.eclipse.uml2.uml.Model;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

public class AdapterTest {

	String baseModelPath = "platform:/resource/eu.supersede.dynadapt.monitoring.models/models/uml_models/base/MonitoringSystemBaseModel.uml";
	String repository = "platform:/resource/eu.supersede.dynadapt.monitoring.models/models/";
	String featureConfigPath = "platform:/resource/eu.supersede.dynadapt.monitoring.models/models/features/configurations/MonitoringSystemConfigDefault.yafc";
	String featureModelPath = "platform:/resource/eu.supersede.dynadapt.monitoring.models/models/features/models/MonitoringSystem.yafm";
	String localPath = "file:/home/jmotger/Escritorio/SUPERSEDE/dyn_adapt/Enactment/components/adapter/model/eu.supersede.dynadapt.monitoring.models/bin/";
	Map<String, String> modelsLocation;

	ModelRepository mr = null;
	ModelManager mm = null;
	Adapter adapter = null;

	URL url = null;
	
	IFeatureConfigLAO fcLAO = null;

	@Before
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
		mr = new ModelRepository(repository,url);
		mm = new ModelManager(baseModelPath);
		fcLAO = new FeatureConfigLAO(new FeatureConfigDAO());
	}
	
	@Test
	public void adapt() {
		try {
			adapter = new Adapter(mr, mm);
			Model baseModel = mm.loadUMLModel(baseModelPath);
			
			FeatureModel featureModel = mm.loadFeatureModel(featureModelPath);
			List<Aspect> a = mr.getAspectModels("timeSlot_twitter", modelsLocation);

			Model model = adapter.adapt(featureModel, a.get(0), baseModel);
			
			System.out.println("Saving model");
			save(model, URI.createURI(repository + modelsLocation.get("base") + "MonitoringSystemAdaptedBaseModel.uml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
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