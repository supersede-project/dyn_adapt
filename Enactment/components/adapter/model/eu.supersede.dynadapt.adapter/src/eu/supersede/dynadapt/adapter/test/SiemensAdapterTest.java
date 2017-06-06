package eu.supersede.dynadapt.adapter.test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.net.URL;
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
import org.eclipse.uml2.uml.Stereotype;
import org.junit.Before;
import org.junit.Test;

import eu.supersede.dynadapt.adapter.Adapter;
import eu.supersede.dynadapt.adapter.exception.EnactmentException;
import eu.supersede.dynadapt.dsl.aspect.Aspect;
import eu.supersede.dynadapt.featuremodel.fc.IFeatureConfigLAO;
import eu.supersede.dynadapt.model.ModelManager;
import eu.supersede.dynadapt.modelrepository.repositoryaccess.ModelRepository;
import eu.supersede.integration.api.adaptation.types.ModelSystem;

public class SiemensAdapterTest {
	private final static Logger log = LogManager.getLogger(SiemensAdapterTest.class);

	String baseModelPath;
	String repository;
	String featureConfigPath;
	String featureModelPath;
	String localPath;
	String repositoryRelativePath;
	String repositoryResolverPath;
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
		mm = new ModelManager();
		mr = new ModelRepository(repository, repositoryRelativePath, mm);
	}

	private void setupPlatform() {
		baseModelPath = "platform:/resource/eu.supersede.dynadapt.adapter/repository/models/base/BaseModel-S2.uml";
		repository = "platform:/resource/eu.supersede.dynadapt.adapter/repository";
		featureModelPath = "platform:/resource/eu.supersede.dynadapt.adapter/repository/features/models/FeatureModel-S1c.yafm";
		repositoryRelativePath = "./repository";
		repositoryResolverPath = "platform:/resource/eu.supersede.dynadapt.adapter/repository";
		platformRelativePath = "../";

		new StandaloneSetup().setPlatformUri(platformRelativePath);
		modelsLocation = new HashMap<String, String>();
		modelsLocation.put("aspects", "adaptability_models/");
		modelsLocation.put("variants", "models/variants/");
		modelsLocation.put("base", "models/base/");
		modelsLocation.put("profiles", "models/profiles/");
		modelsLocation.put("patterns", "patterns/eu/supersede/dynadapt/usecases/siemens/patterns/");
		modelsLocation.put("features", "features/models/");
		modelsLocation.put("adapted", "models/adapted/");
	}
	
	@Test
	public void testSiemensGetAspectModelsFromRepository() {
		List<Aspect> aspects = mr.getAspectModelsFromRepository(ModelSystem.Siemens, "c4", null);
		assertNotNull("List of aspects is null", aspects);
		assertNotEquals("List of aspects is empty", 0, aspects.size());
		Aspect aspect = aspects.get(0);
		assertNotNull("Aspect's advice is null", aspect.getAdvice());
		assertNotNull("Aspect's compositions is null", aspect.getCompositions());
		assertNotEquals("List of aspect's compositions is empty", 0, aspect.getCompositions().size());
		assertNotNull("Aspect's feature is null", aspect.getFeature());
		assertNotNull("Aspect's pointcusts is null", aspect.getPointcuts());
		assertNotNull("Aspect's first poincut's pattern is null", aspect.getPointcuts().get(0).getPattern());
		assertNotNull("Aspect's first poincut's role is null", aspect.getPointcuts().get(0).getRole());
		Stereotype role = aspect.getPointcuts().get(0).getRole();
		assertNotNull("Aspect's first poincut's role cannot be resolverd", role.getName());
	}
	
	@Test
	public void testSiemensUCAdaptation() {
		try {
			adapter = new Adapter(mr, mm, modelsLocation, repositoryResolverPath, repositoryRelativePath);
			String[] adaptationDecisionActionIds = new String[]{"c4"};
			String featureConfigurationId = "FeatureModel-S1c_dm_optimized";
			adapter.enactAdaptationDecisionActions(
					ModelSystem.Siemens, Arrays.asList(adaptationDecisionActionIds), featureConfigurationId);
		} catch (EnactmentException e) {
			e.printStackTrace();
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