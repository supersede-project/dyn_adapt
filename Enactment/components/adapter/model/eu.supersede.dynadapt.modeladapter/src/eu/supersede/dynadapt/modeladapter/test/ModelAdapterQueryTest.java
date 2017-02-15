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

import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Type;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import eu.supersede.dynadapt.model.IModelManager;
import eu.supersede.dynadapt.model.ModelManager;
import eu.supersede.dynadapt.model.query.IModelQuery;
import eu.supersede.dynadapt.model.query.ModelQuery;
import eu.supersede.dynadapt.modeladapter.ModelAdapterUtilities;

@SuppressWarnings("restriction")
public class ModelAdapterQueryTest {
	
	String umlModelPath = "platform:/resource/eu.supersede.dynadapt.modeladapter/models/health_watcher.uml";
	String umlModelAdaptedPath = "platform:/resource/eu.supersede.dynadapt.adapter/repository/models/adapted/HealthWatcher_authenticated.uml";
	String variantPath = "platform:/resource/eu.supersede.dynadapt.modeladapter/models/authentication_advice2.uml";
	
	IModelManager modelManager = null;
	IModelQuery modelQuery = null;
	
	Model umlBaseModel = null;
	Model umlBaseAdaptedModel = null;
	Model umlVariantModel = null;
	
	//Search search = null;
	
	@Before
	public void setUp() throws Exception{
		new StandaloneSetup().setPlatformUri("../");
		modelManager = new ModelManager(umlModelPath);
		modelQuery = new ModelQuery (modelManager);
		
		umlBaseModel = modelManager.loadUMLModel(umlModelPath);
		umlBaseAdaptedModel = modelManager.loadUMLModel(umlModelAdaptedPath);
		umlVariantModel = modelManager.loadUMLModel(variantPath);
	}

	@After
	public void cleanUp(){
		
	}
	
	@Test
	public void testFindSubclassesOfType() {
		Class type = (Class)getElementByNameInModel ("SystemToAuthenticate", umlVariantModel);
		for (Type subclass : ModelAdapterUtilities.findSubclassesOfType(type, umlVariantModel)) {
			System.out.println ("Detected subclass: " + subclass.getName());
		}
	}
	
	@Test
	public void testElementIsReferencedInModel() {
		Class type = (Class)getElementByNameInModel ("Protected System", umlBaseAdaptedModel);
		boolean result = ModelAdapterUtilities.elementIsReferencedInModel(type, umlBaseAdaptedModel);
		System.out.println ("Element " + type.getName() + " is " + (result?" referenced":" not referenced"));
	}

	private PackageableElement getElementByNameInModel(String name, Model model) {
		PackageableElement found = null;
		for (PackageableElement element: model.getPackagedElements()){
			if (element.getName()!= null && element.getName().equals (name)){
				found = element;
				break;
			}
		}
		return found;
	}
	
	
}
