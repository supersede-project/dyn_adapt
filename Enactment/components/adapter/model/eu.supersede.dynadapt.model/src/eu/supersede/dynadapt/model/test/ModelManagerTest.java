package eu.supersede.dynadapt.model.test;


import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.viatra.query.patternlanguage.patternLanguage.PatternModel;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cz.zcu.yafmt.model.fm.FeatureModel;
import eu.supersede.dynadapt.model.IModelManager;
import eu.supersede.dynadapt.model.ModelManager;


public class ModelManagerTest {
	
//	String modelPath = "./models/atos_base_model.uml";
//	String patternModelPath = "./models/atos_queries.vql";
	
	String umlModelPath = "platform:/resource/eu.supersede.dynadapt.model/models/atos_base_model.uml";
	String profilePath = "platform:/resource/eu.supersede.dynadapt.model/models/adm.profile.uml";
	String patternModelPath = "platform:/resource/eu.supersede.dynadapt.model/models/atos_queries.vql";
	String featureModelPath = "platform:/resource/eu.supersede.dynadapt.model/models/AtosUCFeatureModel.yafm";
	
	IModelManager modelManager = null;
	
	@Before
	public void setUp() throws Exception{
		new StandaloneSetup().setPlatformUri("../");
		modelManager = new ModelManager (umlModelPath);
	}

	@After
	public void cleanUp(){
		
	}
	
	@Test
	public void modelLoadTest() throws ViatraQueryException {
		Assert.assertNotNull(modelManager);
		
		Model umlModel = modelManager.loadUMLModel(umlModelPath);
		Profile profile = modelManager.loadProfile(profilePath);
		PatternModel patternModel = modelManager.loadPatternModel(patternModelPath);
		FeatureModel featureModel = modelManager.loadFeatureModel(featureModelPath);
		
		Assert.assertNotNull(umlModel);
		Assert.assertNotNull(profile);
		Assert.assertNotNull(patternModel);
		Assert.assertNotNull(featureModel);
	}
}
