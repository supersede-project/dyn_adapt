/*******************************************************************************
 * Copyright (c) 2016 ATOS Spain S.A, Universitat Politécnica de Catalunya (UPC)
 * All rights reserved. Licensed under the Apache License, Version 2.0 (the "License");
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
 *     Yosu Gorroñogoitia (ATOS) - main development
 *
 * Initially developed in the context of SUPERSEDE EU project www.supersede.eu
 *******************************************************************************/
package eu.supersede.dynadapt.model;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.viatra.query.patternlanguage.patternLanguage.PatternModel;

import cz.zcu.yafmt.model.fc.FeatureConfiguration;
import cz.zcu.yafmt.model.fm.FeatureModel;
import eu.supersede.dynadapt.dsl.aspect.Aspect;

public interface IModelManager {

	/**
	 * Loads the UML base model resource from the passed file and returns this Resource object.
	 * 
	 * @param file
	 *            IFile object to be loaded as the resource
	 * @return Resource object loaded from the passed file
	 */
	Resource loadResource(String targetModelPath);

	/**
	 * Loads the profile of the given name and returns this Profile object.
	 * 
	 * @param profileFileName
	 *            Name of the file to be loaded as a profile
	 * @return Profie loaded from the file
	 */
	Profile loadProfile(String profilePath);

	/**
	 * Returns the associated UML base target model
	 * @return the associated UML base target model
	 */
	Model getTargetModel();
	Resource getTargetModelAsResource();

	/**
	 * @throws IOException 
	 * Save a model resource included in current resource set, into the outputModelURI recipient, adding suffixe to that URI
	 * @param modelResource
	 * @param outputModelURI
	 * @param suffixe
	 * @throws  
	 */
	URI saveModel(Resource modelResource, URI outputModelURI, String suffixe) throws IOException;

	/**
	 * Saves a copy of associated target model adding given suffixe to the original target model name
	 * @param suffixe suffixe added to the original target model name 
	 * @return locator for saved model
	 * @throws IOException
	 */
	URI saveTargetModel(String suffixe) throws IOException;
	
	/**
	 * Saves a associated target model replacing original file
	 * @return locator for saved model
	 * @throws IOException
	 */
	URI saveTargetModel() throws IOException;
	
//	/**
//	 * Regiser given model into the ModelManager resource set
//	 * @param ePackage model to register
//	 * @see org.eclipse.uml2.uml.resource.UMLResource
//	 */
//	void registerPackage (EPackage ePackage);
	
	/**
	 * Loads the model resource with the given uri into this resource set. If
	 * no such resource is found or the root object is not an instance of the
	 * given class, null is returned.
	 * 
	 * @param uri uri of the model to be loaded
	 * @param clazz class the model resource should have
	 * @return model resource with the given uri or null.
	 */

	<T extends EObject> T loadModel(URI uri, Class<T> clazz);
	<T extends EObject> T loadModel(String path, Class<T> clazz);
	
	Model loadUMLModel(String modelPath);
	PatternModel loadPatternModel(String patternPath);
	FeatureModel loadFeatureModel(String fmPath);
	FeatureConfiguration loadFeatureConfiguration(String fcPath);
	ResourceSet getResourceSet();
	Aspect loadAspectModel(String path);
	Aspect loadAspectModel(URI uri);

	URI saveModelInTemporaryFolder(Model model, String suffixe) throws IOException;
}