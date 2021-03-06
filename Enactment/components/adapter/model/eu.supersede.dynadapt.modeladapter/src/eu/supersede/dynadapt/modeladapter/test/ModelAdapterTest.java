/*******************************************************************************
 * Copyright (c) 2016 Universitat Politécnica de Catalunya (UPC), ATOS Spain S.A
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 * 	Quim Motger (UPC) - main development
 * 	
 * Initially developed in the context of SUPERSEDE EU project
 * www.supersede.eu
 *******************************************************************************/

package eu.supersede.dynadapt.modeladapter.test;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.internal.impl.InstanceSpecificationImpl;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;
import org.eclipse.uml2.uml.Element;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import eu.supersede.dynadapt.model.IModelManager;
import eu.supersede.dynadapt.model.ModelManager;
import eu.supersede.dynadapt.model.query.IModelQuery;
import eu.supersede.dynadapt.model.query.ModelQuery;
import eu.supersede.dynadapt.modeladapter.Composable;
import eu.supersede.dynadapt.modeladapter.ComposableOpaqueAction;
//import eu.supersede.monitor.reconfiguration.poc.uml.query;
import eu.supersede.dynadapt.modeladapter.IModelAdapter;
import eu.supersede.dynadapt.modeladapter.ModelAdapter;

@SuppressWarnings("restriction")
public class ModelAdapterTest {

	String umlModelPath = "platform:/resource/eu.supersede.dynadapt.modeladapter/models/atos_base_model.uml";
	String defaultVariantPath = "platform:/resource/eu.supersede.dynadapt.modeladapter/models/atos_cms_default_variant.uml";
	String overloadedVariantPath = "platform:/resource/eu.supersede.dynadapt.modeladapter/models/atos_cms_overloaded_variant.uml";
	String monitoringBasePath = "platform:/resource/eu.supersede.dynadapt.modeladapter/models/MonitoringSystemBaseModel.uml";
	String monitoringVariantPath = "platform:/resource/eu.supersede.dynadapt.modeladapter/models/MonitoringSystemVariantModel.uml";

	// Siemens models for testing
	String siemensBasePath = "platform:/resource/eu.supersede.dynadapt.modeladapter/models/UI_getBuildings_base.uml";
	String siemensVariantPath = "platform:/resource/eu.supersede.dynadapt.modeladapter/models/UI_getBuildings_variant1.uml";
	String siemensBaseAdaptedPath = "platform:/resource/eu.supersede.dynadapt.modeladapter/models/UI_getBuildings_base_adapted.uml";

	IModelManager modelManager = null;
	IModelAdapter modelAdapter = null;
	IModelQuery modelQuery = null;

	Model umlBaseModel = null;
	Model umlDefaultModel = null;
	Model umlOverloadedModel = null;
	Model monitoringBaseModel = null;
	Model monitoringVariantModel = null;
	Model siemensBaseModel = null;
	Model siemensVariantModel = null;

	// Search search = null;

	@Before
	public void setUp() throws Exception {
		new StandaloneSetup().setPlatformUri("../");
		modelManager = new ModelManager(umlModelPath);
		modelAdapter = new ModelAdapter(modelManager);

		umlBaseModel = modelManager.loadUMLModel(umlModelPath);
		umlDefaultModel = modelManager.loadUMLModel(defaultVariantPath);
		umlOverloadedModel = modelManager.loadUMLModel(overloadedVariantPath);
		monitoringBaseModel = modelManager.loadUMLModel(monitoringBasePath);
		monitoringVariantModel = modelManager.loadUMLModel(monitoringVariantPath);

		siemensBaseModel = modelManager.loadUMLModel(siemensBasePath);
		siemensVariantModel = modelManager.loadUMLModel(siemensVariantPath);
	}

	@After
	public void cleanUp() {

	}

	@Test
	public void test() {
		// applyAddInstanceComposition();
		// applyDeleteInstanceComposition();
		// applyAddClassComposition();
		// applyDeleteClassComposition();
		// applyModifyValueComposition();
		applyAddClassComposition();
	}

	// private void applyAddInstanceComposition() {
	//
	// Model umlResult = null;
	// try {
	// umlResult = modelAdapter.applyAddComposition(
	// umlBaseModel,
	// umlBaseModel.getPackagedElement("Instances").getOwnedElements().get(14),
	// umlDefaultModel,
	// umlDefaultModel.getOwnedElements().get(0));
	// save(umlResult, URI.createURI(umlModelPath));
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//
	// }

	// private void applyDeleteInstanceComposition() {
	//
	// Model umlResult = null;
	// try {
	// umlResult = modelAdapter.applyDeleteComposition(
	// umlBaseModel,
	// umlBaseModel.getPackagedElement("Instances").getOwnedElements().get(14),
	// umlDefaultModel,
	// umlDefaultModel.getOwnedElements().get(0));
	// save(umlResult, URI.createURI(monitoringBasePath));
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//
	// }

	// private void applyAddClassComposition() {
	//
	// Model umlResult = null;
	// try {
	// umlResult = modelAdapter.applyAddComposition(
	// monitoringBaseModel,
	// monitoringBaseModel.getOwnedElements().get(6),
	// monitoringVariantModel,
	// monitoringVariantModel.getOwnedElements().get(1));
	// save(umlResult, URI.createURI(monitoringBasePath));
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//
	// }

	// private void applyDeleteClassComposition() {
	//
	// Model umlResult = null;
	// try {
	// umlResult = modelAdapter.applyDeleteComposition(
	// monitoringBaseModel,
	// monitoringBaseModel.getOwnedElements().get(6),
	// monitoringVariantModel,
	// monitoringVariantModel.getOwnedElements().get(1));
	// save(umlResult, URI.createURI(monitoringBasePath));
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//
	// }

	@SuppressWarnings("restriction")
	private void applyModifyValueComposition() {

		Model umlResult = null;
		try {
			InstanceSpecificationImpl instance = (InstanceSpecificationImpl) umlBaseModel
					.getPackagedElement("Instances").getOwnedElements().get(0);
			Slot s = (Slot) instance.getOwnedElements().get(1);
			LiteralInteger integer = UMLFactory.eINSTANCE.createLiteralInteger();
			integer.setValue(20);
			umlResult = modelAdapter.applyUpdateComposition(umlBaseModel, s, integer.toString());
			save(umlResult, URI.createURI(umlModelPath));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void applyAddClassComposition() {
		Composable composable = new ComposableOpaqueAction();
		try {
			Element baseElement = find ("UIGetBuildingsCachingAction", siemensBaseModel);
			Element variantElement = find ("UIGetBuildingsCaching", siemensVariantModel);
			composable.applyReplaceComposition(siemensBaseModel, baseElement, siemensVariantModel, variantElement);
			save(siemensBaseModel, URI.createURI(siemensBaseAdaptedPath));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private Element find(String name, Model model) {
		return find (name, (Element)model);
	}
	
	private Element find(String name, Element element) {
		Element result = null;
		for (Element e: element.getOwnedElements()){
			if (e instanceof NamedElement){
				NamedElement ne = (NamedElement)e;
				if (ne.getName()!=null && ne.getName().equals(name)){
					result = e;
					break;
				}else{
					result = find (name, e);
				}
			}
		}
		return result;
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
