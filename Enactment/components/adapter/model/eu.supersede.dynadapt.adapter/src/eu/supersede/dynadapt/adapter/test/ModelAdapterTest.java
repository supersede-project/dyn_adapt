package eu.supersede.dynadapt.adapter.test;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import eu.supersede.dynadapt.adapter.IModelAdapter;
import eu.supersede.dynadapt.adapter.ModelAdapter;
import eu.supersede.dynadapt.model.IModelManager;
import eu.supersede.dynadapt.model.ModelManager;

public class ModelAdapterTest {
	
	String umlModelPath = "platform:/resource/eu.supersede.dynadapt.adapter/models/model.uml";
	
	IModelManager modelManager = null;
	IModelAdapter modelAdapter = null;
	
	@Before
	public void setUp() throws Exception{
		new StandaloneSetup().setPlatformUri("../");
		modelManager = new ModelManager(umlModelPath);
		modelAdapter = new ModelAdapter();
	}

	@After
	public void cleanUp(){
		
	}
	
	@Test
	public void deleteClass() {
		
		Model umlModel = modelManager.loadUMLModel(umlModelPath);
				
		Model umlResult;
		try {
			umlResult = modelAdapter.applyDeleteComposition(umlModel, null, null, umlModel.getPackagedElement("Components").getOwnedElements().get(0));
			save(umlResult, URI.createURI(umlModelPath));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	protected void save(Model model, URI uri) {

		ResourceSet resourceSet = new ResourceSetImpl();
        UMLResourcesUtil.init(resourceSet);
        Resource resource = resourceSet.createResource(uri);
        resource.getContents().add(model);
        try {
            resource.save(null); // no save options needed
        } catch (IOException ioe) {
        }
    }

}
