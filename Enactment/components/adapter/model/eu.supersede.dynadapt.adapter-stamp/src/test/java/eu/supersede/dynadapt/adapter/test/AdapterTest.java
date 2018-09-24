package eu.supersede.dynadapt.adapter.test;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import cz.zcu.yafmt.model.fc.FeatureConfiguration;
import cz.zcu.yafmt.model.fc.Selection;
import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.FeatureModel;
import cz.zcu.yafmt.model.fm.Group;
import eu.supersede.dynadapt.adapter.Adapter;
import eu.supersede.dynadapt.adapter.IAdapter;
import eu.supersede.dynadapt.adapter.exception.EnactmentException;
import eu.supersede.dynadapt.adapter.system.ModelRepositoryMapping;
import eu.supersede.dynadapt.adapter.system.ModelRepositoryResolver;
import eu.supersede.dynadapt.adapter.system.RepositoryMetadata;
import eu.supersede.dynadapt.adapter.system.RepositoryMetadata.ResourceTimestamp;
import eu.supersede.dynadapt.adapter.system.RepositoryMetadata.ResourceType;
import eu.supersede.dynadapt.model.ModelManager;
import eu.supersede.dynadapt.modelrepository.populate.PopulateRepositoryManager;
import eu.supersede.dynadapt.modelrepository.repositoryaccess.ModelRepository;
import eu.supersede.integration.api.adaptation.types.ModelSystem;
import eu.supersede.integration.api.adaptation.types.ModelType;
import eu.supersede.integration.api.adaptation.types.Status;

public class AdapterTest {
	private final static Logger log = LogManager.getLogger(AdapterTest.class);
	private static final String MODELS_AUTHOR = "Yosu";
	
//	String baseModelPath;
	private static String repository;
	private static String repositoryRelativePath;
	private static String platformRelativePath;
	
	private static Map<String, String> modelsLocation;

	private static ModelRepository mr = null;
	private static ModelManager mm = null;
	private static Adapter adapter = null;

	private static boolean demo = true; //Required in test, demo flag will be transmitted to Enactor to simulate the enactment process on real UC systems

	
	@Test
	public void testAdapter_enactAdaptationDecisionAction_method() {
		try {
			log.debug("Running testAdapter_enactAdaptationDecisionAction_method");
			String[] adaptationDecisionActionIds = new String[]{"authenticated"};
			String featureConfigurationId = uploadLatestComputedFC("HealthAuthenticatedFeatureConfiguration.yafc");
			
			adapter.enactAdaptationDecisionAction(
					ModelSystem.Health, adaptationDecisionActionIds[0], featureConfigurationId);
		} catch (Exception e) {
			e.printStackTrace();
			fail (e.getMessage());
		}
	}
	
	@Test
	public void testAdapter_adapt_method() {
		try {
			log.debug("Running testAdapter_adapt_method");
			
			String featureId = "authenticated";
			mr.loadModelsFromRepository(ModelSystem.Health);
			FeatureConfiguration newFeatureConfig = mr.getLastComputedFeatureConfigurationForSystem(ModelSystem.Health);
			List<Selection> selections = newFeatureConfig.getSelectionsById(featureId);	
			
			Model baseModel = mr.getLastBaseModelForSystem(ModelSystem.Health);
			mm.setTargetModel(baseModel);
			
			adapter.adapt(ModelSystem.Health, selections, baseModel);
		} catch (Exception e) {
			e.printStackTrace();
			fail (e.getMessage());
		}
	}
	
	@BeforeClass
	public static void setUp() throws Exception {
		setupPlatform();		
		mm = new ModelManager(); //Base Model loaded here
		mr = new ModelRepository(repository,repositoryRelativePath, mm);
		adapter = new Adapter(mr, mm, modelsLocation, repositoryRelativePath, demo);
	}

	private static void setupPlatform() {
		repository = "platform:/resource/eu.supersede.dynadapt.adapter-stamp/repository/";
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
		modelsLocation.put("configurations", "features/configurations/");
		modelsLocation.put("adapted", "models/adapted/");
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
	
	/** 
	 * Load a given configuration model as the latest ComputedModel for Siemens system,
	 * simulating it is the result of the last decision-making optimization update
	 * @param fcName the name of the feature configuration file
	 * @return the id of the new model in the model repository
	 * @throws IOException
	 * @throws Exception
	 */
	private String uploadLatestComputedFC(String fcName) throws IOException, Exception {
		String userdir = System.getProperty("user.dir");
		Path repositoryPath = FileSystems.getDefault().getPath(userdir, repositoryRelativePath);
		PopulateRepositoryManager prm = new PopulateRepositoryManager (mm, mr);
		String modelId = prm.populateModel(
				Paths.get(repositoryPath.toString(), "features/configurations", fcName), 
				MODELS_AUTHOR,
				ModelSystem.Atos_HSK, Status.Computed,
				modelsLocation.get("configurations"), 
				FeatureConfiguration.class,
				ModelType.FeatureConfiguration, 
				eu.supersede.integration.api.adaptation.types.FeatureConfiguration.class);
		return modelId;
	}

}