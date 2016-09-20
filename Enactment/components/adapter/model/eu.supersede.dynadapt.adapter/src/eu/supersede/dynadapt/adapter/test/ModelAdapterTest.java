package eu.supersede.dynadapt.adapter.test;

import java.io.IOException;

import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.eclipse.uml2.uml.Model;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import eu.supersede.dynadapt.model.IModelManager;
import eu.supersede.dynadapt.model.ModelManager;

public class ModelAdapterTest {
	
	String umlModelPath = "platform:/resource/eu.supersede.dynadapt.adapter/models/atos_base_model.uml";
	String savePath = "platform:/resource/eu.supersede.dynadapt.adapter/models/save.uml";

	
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
	public void add() throws IOException {
		
		Model umlModel = modelManager.loadUMLModel(umlModelPath);
		//modelManager.saveModel(umlModel.eResource(), URI.createURI(savePath), "uml");
		
		
	}

}
