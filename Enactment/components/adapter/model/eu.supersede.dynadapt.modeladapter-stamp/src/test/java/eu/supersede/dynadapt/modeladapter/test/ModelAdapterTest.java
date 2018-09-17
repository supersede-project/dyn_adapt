package eu.supersede.dynadapt.modeladapter.test;


import static org.junit.Assert.fail;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Stereotype;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import cz.zcu.yafmt.model.fc.FeatureConfiguration;
import cz.zcu.yafmt.model.fc.Selection;
import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.FeatureModel;
import cz.zcu.yafmt.model.fm.Group;
import eu.supersede.dynadapt.dsl.aspect.Aspect;
import eu.supersede.dynadapt.dsl.aspect.Composition;
import eu.supersede.dynadapt.dsl.aspect.Pointcut;
import eu.supersede.dynadapt.model.ModelManager;
import eu.supersede.dynadapt.modeladapter.ModelAdapter;
import eu.supersede.dynadapt.modelrepository.populate.PopulateRepositoryManager;
import eu.supersede.dynadapt.modelrepository.repositoryaccess.ModelRepository;
import eu.supersede.integration.api.adaptation.types.ModelSystem;
import eu.supersede.integration.api.adaptation.types.ModelType;
import eu.supersede.integration.api.adaptation.types.Status;

public class ModelAdapterTest {
	private static final String MODELS_AUTHOR = "Yosu";
	
//	String baseModelPath;
	private static String repository;
	private static String repositoryRelativePath;
	private static String platformRelativePath;
	
	private static Map<String, String> modelsLocation;

	private static ModelRepository mr = null;
	private static ModelManager mm = null;
	private static ModelAdapter ma;

	private static boolean demo = true; //Required in test, demo flag will be transmitted to Enactor to simulate the enactment process on real UC systems

	
	@Test
	public void testModelAdapter_applyUpdateComposition_method() {
		try {			
			String featureId = "authenticated";
			mr.loadModelsFromRepository(ModelSystem.Health);
			
			Model baseModel = mr.getLastBaseModelForSystem(ModelSystem.Health);
			mm.setTargetModel(baseModel);
			
			//Load aspect
			List<Aspect> aspects = mr.getAspectModels(featureId, modelsLocation);
			Aspect aspect = aspects.get(0);
			
			//Get advice model
			Model variant = aspect.getAdvice();
			
			//pointcuts
			List<Pointcut> pointcuts = aspect.getPointcuts();
			HashMap<Stereotype, List<Element>> jointpoints = new HashMap<>();
			List<Element> jps1 = new ArrayList<Element>() {{
				add (baseModel.getOwnedMember("Employee"));
			}};
			jointpoints.put(getPointCutByName(pointcuts, "AuthenticatedUser"), jps1);
			
			List<Element> jps2 = new ArrayList<Element>() {{
				add(baseModel.getOwnedMember("HealthWatcher"));
			}};
			jointpoints.put(getPointCutByName(pointcuts, "AuthenticatedSystem"), jps2); 
			
			//Get composition EnableAuthenticationOnSystem
			for (Composition c: aspect.getCompositions()){
				if (c.getName().startsWith("Enable"))
					ma.applyCompositionDirective(c.getAction(), baseModel, jointpoints, c.getAdvice(), variant);
			}
			
			//Oracles
			Assert.assertNotNull(baseModel.getOwnedMember("Protected System"));
			Assert.assertNotNull(baseModel.getOwnedMember("UserRepository"));
			
		} catch (Exception e) {
			e.printStackTrace();
			fail (e.getMessage());
		}
	}
	
	private Stereotype getPointCutByName(List<Pointcut> pointcuts, String name) {
		for (Pointcut pc: pointcuts) {
			if (pc.getName().equals(name))
				return pc.getRole();
		}
		return null;
	}

	@BeforeClass
	public static void setUp() throws Exception {
		setupPlatform();		
		mm = new ModelManager(); //Base Model loaded here
		mr = new ModelRepository(repository,repositoryRelativePath, mm);
		ma = new ModelAdapter(mm);
	}

	private static void setupPlatform() {
		repository = "platform:/resource/eu.supersede.dynadapt.modeladapter-stamp/repository/";
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
