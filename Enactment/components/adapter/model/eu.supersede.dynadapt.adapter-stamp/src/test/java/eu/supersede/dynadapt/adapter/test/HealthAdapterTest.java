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

public class HealthAdapterTest {
	private final static Logger log = LogManager.getLogger(HealthAdapterTest.class);
	private static final String MODELS_AUTHOR = "Yosu";
	
//	String baseModelPath;
	String repository;
	String repositoryRelativePath;
	String repositoryResolverPath;
	String platformRelativePath;
	
	Map<String, String> modelsLocation;

	ModelRepository mr = null;
	ModelManager mm = null;
	IAdapter adapter = null;

	URL url = null;
	
	@Test
	public void testAuthenticatedHealthUCAdaptation() {
		try {
			boolean demo = true; //Required in test, demo flag will be transmitted to Enactor to simulate the enactment process on real UC systems
			adapter = new Adapter(mr, mm, modelsLocation, repositoryRelativePath, demo);
			//FIXME featureConfigurationId is ignored. Use correct one
			//once Model Repository is available as service.
			String[] adaptationDecisionActionIds = new String[]{"authenticated"};
			String featureConfigurationId = uploadLatestComputedFC("HealthAuthenticatedFeatureConfiguration.yafc");
			adapter.enactAdaptationDecisionAction(
					ModelSystem.Health, adaptationDecisionActionIds[0], featureConfigurationId);
		} catch (Exception e) {
			e.printStackTrace();
			fail (e.getMessage());
		}
	}
	
	@Test @Ignore
	public void testNotAuthenticatedHealthUCAdaptation() {
		try {
			//Setting input models for the test (overlapping default test models)
//			baseModelPath = "platform:/resource/eu.supersede.dynadapt.adapter/repository/models/adapted/HealthWatcher_authenticated.uml";
			mm = new ModelManager(); //Base Model loaded here
			mr = new ModelRepository(repository,repositoryRelativePath, mm);
			
			adapter = new Adapter(mr, mm, modelsLocation, repositoryRelativePath);
			
			//Current runtime base model
			RepositoryMetadata metadata = new RepositoryMetadata(ResourceType.BASE, ResourceTimestamp.CURRENT);
			ModelRepositoryMapping.setModelURI(ModelSystem.Health, metadata, "/models/adapted/HealthWatcher_authenticated.uml");
			
			//Current runtime FC
			metadata = new RepositoryMetadata(ResourceType.FEATURE_CONFIGURATION, ResourceTimestamp.CURRENT);
			ModelRepositoryMapping.setModelURI(ModelSystem.Health, metadata, "/features/configurations/HealthAuthenticatedFeatureConfiguration.yafc");
			
			//Computed optimal FC
			metadata = new RepositoryMetadata(ResourceType.FEATURE_CONFIGURATION, ResourceTimestamp.NEWEST);
			ModelRepositoryMapping.setModelURI(ModelSystem.Health, metadata, "/features/configurations/HealthNotAuthenticatedFeatureConfiguration.yafc");
			
			//FIXME featureConfigurationId is ignored. Use correct one
			//once Model Repository is available as service.
			String[] adaptationDecisionActionIds = new String[]{"notauthenticated"};
			String featureConfigurationId = "HealthNotAuthenticatedFeatureConfiguration";
			
			//FIXME Select correctly the current and newest FC
			adapter.enactAdaptationDecisionAction(
					ModelSystem.Health, adaptationDecisionActionIds[0], featureConfigurationId);
		} catch (EnactmentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Before
	public void setUp() throws Exception {
		setupPlatform();		
		mm = new ModelManager(); //Base Model loaded here
		mr = new ModelRepository(repository,repositoryRelativePath, mm);
	}

	private void setupPlatform() {
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
