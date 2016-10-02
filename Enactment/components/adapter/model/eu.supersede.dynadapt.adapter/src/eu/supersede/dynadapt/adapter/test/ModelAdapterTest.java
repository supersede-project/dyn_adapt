package eu.supersede.dynadapt.adapter.test;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.internal.impl.InstanceSpecificationImpl;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import eu.supersede.dynadapt.adapter.IModelAdapter;
import eu.supersede.dynadapt.adapter.ModelAdapter;
import eu.supersede.dynadapt.model.IModelManager;
import eu.supersede.dynadapt.model.ModelManager;
import eu.supersede.dynadapt.model.query.IModelQuery;
import eu.supersede.dynadapt.model.query.ModelQuery;
//import eu.supersede.monitor.reconfiguration.poc.uml.query;

@SuppressWarnings("restriction")
public class ModelAdapterTest {
	
	String umlModelPath = "platform:/resource/eu.supersede.dynadapt.adapter/models/atos_base_model.uml";
	String defaultVariantPath = "platform:/resource/eu.supersede.dynadapt.adapter/models/atos_cms_default_variant.uml";
	String overloadedVariantPath = "platform:/resource/eu.supersede.dynadapt.adapter/models/atos_cms_overloaded_variant.uml";
	
	IModelManager modelManager = null;
	IModelAdapter modelAdapter = null;
	IModelQuery modelQuery = null;
	
	Model umlBaseModel = null;
	Model umlDefaultModel = null;
	Model umlOverloadedModel = null;
	
	//Search search = null;
	
	@Before
	public void setUp() throws Exception{
		new StandaloneSetup().setPlatformUri("../");
		modelManager = new ModelManager(umlModelPath);
		modelAdapter = new ModelAdapter();
		
		umlBaseModel = modelManager.loadUMLModel(umlModelPath);
		umlDefaultModel = modelManager.loadUMLModel(defaultVariantPath);
		umlOverloadedModel = modelManager.loadUMLModel(overloadedVariantPath);
	}

	@After
	public void cleanUp(){
		
	}
	
	@Test
	public void test() {
		applyAddComposition();
		//applyDeleteComposition();
		//applyModifyValueComposition();
	}
	
	private void applyAddComposition() {
						
		Model umlResult = null;
		try {
			umlResult = modelAdapter.applyAddComposition(
					umlBaseModel, 
					umlBaseModel.getPackagedElement("Instances").getOwnedElements().get(14), 
					umlDefaultModel, 
					umlDefaultModel.getOwnedElements().get(0));
			save(umlResult, URI.createURI(umlModelPath));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void applyDeleteComposition() {
						
		Model umlResult = null;
		try {
			umlResult = modelAdapter.applyDeleteComposition(
					umlBaseModel, 
					umlBaseModel.getPackagedElement("Instances").getOwnedElements().get(15), 
					umlDefaultModel, 
					umlDefaultModel.getOwnedElements().get(0));
			save(umlResult, URI.createURI(umlModelPath));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("restriction")
	private void applyModifyValueComposition() {
						
		Model umlResult = null;
		try {
			InstanceSpecificationImpl instance = (InstanceSpecificationImpl) umlBaseModel.getPackagedElement("Instances").getOwnedElements().get(0);			
			Property p = instance.getClassifiers().get(0).getAllAttributes().get(1);
			umlResult = modelAdapter.applyModifyValueComposition(
					umlBaseModel, 
					p, 
					null);
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
