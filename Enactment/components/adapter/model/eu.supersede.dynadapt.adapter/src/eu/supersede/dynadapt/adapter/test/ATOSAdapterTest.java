package eu.supersede.dynadapt.adapter.test;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.eclipse.uml2.uml.Model;
import org.junit.Before;
import org.junit.Test;

import cz.zcu.yafmt.model.fc.FeatureConfiguration;
import cz.zcu.yafmt.model.fc.Selection;
import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.FeatureModel;
import cz.zcu.yafmt.model.fm.Group;
import eu.supersede.dynadapt.adapter.Adapter;
import eu.supersede.dynadapt.dsl.aspect.Aspect;
import eu.supersede.dynadapt.featuremodel.fc.FeatureConfigDAO;
import eu.supersede.dynadapt.featuremodel.fc.FeatureConfigLAO;
import eu.supersede.dynadapt.featuremodel.fc.IFeatureConfigLAO;
import eu.supersede.dynadapt.model.ModelManager;
import eu.supersede.dynadapt.modelrepository.repositoryaccess.ModelRepository;

public class ATOSAdapterTest {
	
	String baseModelPath = "platform:/resource/eu.supersede.dynadapt.usecases.atos/models/base/atos_base_model.uml";
	String repository = "platform:/resource/eu.supersede.dynadapt.usecases.atos/";
	String originalFeatureConfigPath = "platform:/resource/eu.supersede.dynadapt.usecases.atos/features/configurations/AtosNormalCMSCapacityConfiguration.yafc";
	String newFeatureConfigPath = "platform:/resource/eu.supersede.dynadapt.usecases.atos/features/configurations/AtosOverloadedCMSCapacityConfiguration.yafc";
	String featureModelPath = "platform:/resource/eu.supersede.dynadapt.usecases.atos/features/models/AtosUCFeatureModel_CMS_Capacity.yafm";
	//TODO: avoid using local paths
	String localPath = "file:/home/yosu/Projects/Supersede/Git/dyn_adapt/Scenarios/Atos/eu.supersede.dynadapt.usecases.atos/";
	Map<String, String> modelsLocation;

	ModelRepository mr = null;
	ModelManager mm = null;
	Adapter adapter = null;

	URL url = null;
	
	IFeatureConfigLAO fcLAO = null;
	
	@Before
	public void setUp() throws Exception {
		new StandaloneSetup().setPlatformUri("../../../../../Scenarios/Atos/");
		modelsLocation = new HashMap<String, String>();
		modelsLocation.put("aspects", "adaptability_models/");
		modelsLocation.put("variants", "models/variants/");
		modelsLocation.put("base", "models/base/");
		modelsLocation.put("profiles", "models/profiles/");
		modelsLocation.put("patterns", "src/eu/supersede/dynadapt/usecases/atos/patterns/");
		modelsLocation.put("features", "features/models/");
		
		url = new URL(localPath);
		mm = new ModelManager(baseModelPath);
		mr = new ModelRepository(repository,url, mm);
		fcLAO = new FeatureConfigLAO(new FeatureConfigDAO());
	}
	
	@Test
	public void adapt() {
		try {
			adapter = new Adapter(mr, mm, modelsLocation);
			Model baseModel = mm.loadUMLModel(baseModelPath);
			
			FeatureConfiguration originalFeatureConfig = mm.loadFeatureConfiguration(originalFeatureConfigPath);
			FeatureConfiguration newFeatureConfig = mm.loadFeatureConfiguration(newFeatureConfigPath);
			List<Selection> changedSelections = diffFeatureConfigurations (originalFeatureConfig, newFeatureConfig);

			Model model = adapter.adapt(changedSelections, baseModel);
			
			System.out.println("Saving model");
			
			if (model != null){
				save(model, URI.createURI(repository + modelsLocation.get("base") + "atos_adapted_base_model.uml"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private List<Selection> diffFeatureConfigurations(FeatureConfiguration originalFeatureConfig, FeatureConfiguration newFeatureConfig) {
		FeatureModel fm = originalFeatureConfig.getFeatureModel();
		Feature root = fm.getRoot();
		
		return diffFeatureConfigurationsInFeature (root, originalFeatureConfig, newFeatureConfig);
	}
	
	private List<Selection> diffFeatureConfigurationsInFeature(Feature feature, FeatureConfiguration originalFeatureConfig,
			FeatureConfiguration newFeatureConfig) {
		List<Selection> selections = diffFeatureConfigurationsInFeature (feature.getId(), originalFeatureConfig, newFeatureConfig);
		
		for (Feature child: feature.getFeatures()){
			selections.addAll (diffFeatureConfigurationsInFeature (child, originalFeatureConfig, newFeatureConfig));
		}
		
		for (Group group: feature.getGroups()){
			for (Feature childInGroup: group.getFeatures()){
				selections.addAll (diffFeatureConfigurationsInFeature (childInGroup, originalFeatureConfig, newFeatureConfig));
			}
		}
		return selections;
	}

	private List<Selection> diffFeatureConfigurationsInFeature(String featureId, FeatureConfiguration originalFeatureConfig,
			FeatureConfiguration newFeatureConfig) {
		List<Selection> selections = new ArrayList<Selection>();
		
		List<Selection> originalSelections = originalFeatureConfig.getSelectionsById(featureId);
		List<Selection> newSelections = newFeatureConfig.getSelectionsById(featureId);
		
		for (Selection s1: originalSelections){
			if (!selectionExistsInList(s1, newSelections)){
				s1.setEnabled(false);
				selections.add (s1);
			}
		}
		
		for (Selection s1: newSelections){
			if (!selectionExistsInList(s1, originalSelections)){
				selections.add (s1);
			}
		}
		
		return selections;
	}

	private boolean selectionExistsInList(Selection s1, List<Selection> list) {
		boolean result = false;
		
		for (Selection s: list){
			if (s.getId().equals(s1.getId())){
				result = true;
				break;
			}
		}
		
		return result;
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
