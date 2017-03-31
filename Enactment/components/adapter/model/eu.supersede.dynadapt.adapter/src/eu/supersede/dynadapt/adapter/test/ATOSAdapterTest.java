package eu.supersede.dynadapt.adapter.test;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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
import eu.supersede.dynadapt.adapter.IAdapter;
import eu.supersede.dynadapt.adapter.exception.EnactmentException;
import eu.supersede.dynadapt.adapter.system.SupersedeSystem;
import eu.supersede.dynadapt.model.ModelManager;
import eu.supersede.dynadapt.modelrepository.repositoryaccess.ModelRepository;
import eu.supersede.integration.api.adaptation.types.ModelSystem;

public class ATOSAdapterTest {
	private final static Logger log = LogManager.getLogger(ATOSAdapterTest.class);
	
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
	
	@Test
	public void testAtosUCAdaptation() {
		try {
			adapter = new Adapter(mr, mm, modelsLocation, repositoryRelativePath);
			//FIXME featureConfigurationId is ignored. Use correct one
			//once Model Repository is available as service.
			String[] adaptationDecisionActionIds = new String[]{"cms_optimal_configuration", "cms_standard_configuration"};
			String featureConfigurationId = null;
			adapter.enactAdaptationDecisionActions(
					ModelSystem.Atos, Arrays.asList(adaptationDecisionActionIds), featureConfigurationId);
//			adapter.enactAdaptationDecisionAction(
//					SupersedeSystem.ATOS.toString(), adaptationDecisionActionIds[0], featureConfigurationId);
		} catch (EnactmentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	@Test
//	public void adapt() {
//		try {
//			adapter = new Adapter(mr, mm, modelsLocation, repositoryRelativePath);
//			Model baseModel = mm.loadUMLModel(baseModelPath);
//			
//			FeatureConfiguration originalFeatureConfig = mm.loadFeatureConfiguration(originalFeatureConfigPath);
//			FeatureConfiguration newFeatureConfig = mm.loadFeatureConfiguration(newFeatureConfigPath);
//			List<Selection> changedSelections = diffFeatureConfigurations (originalFeatureConfig, newFeatureConfig);
//
//			Model model = ((Adapter)adapter).adapt(changedSelections, baseModel);
//			
//			System.out.println("Saving model");
//			
//			if (model != null){
//				URI uri = URI.createURI(repository + modelsLocation.get("base") + "atos_adapted_base_model.uml");
//				log.debug("Saving updated model in " + uri);
//				save(model, uri);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	@Before
	public void setUp() throws Exception {
		setupPlatform();		
		mm = new ModelManager(baseModelPath); //Base Model loaded here
		mr = new ModelRepository(repository,repositoryRelativePath, mm);
	}

	private void setupPlatform() {
		baseModelPath = "platform:/resource/eu.supersede.dynadapt.adapter/repository/models/base/atos_base_model.uml";
		repository = "platform:/resource/eu.supersede.dynadapt.adapter/repository/";
		originalFeatureConfigPath = "platform:/resource/eu.supersede.dynadapt.adapter/repository/features/configurations/AtosNormalCMSCapacityConfiguration.yafc";
		newFeatureConfigPath = "platform:/resource/eu.supersede.dynadapt.adapter/repository/features/configurations/AtosOverloadedCMSCapacityConfiguration.yafc";
		featureModelPath = "platform:/resource/eu.supersede.dynadapt.adapter/repository/features/models/AtosUCFeatureModel_CMS_Capacity.yafm";
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
