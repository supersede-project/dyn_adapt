/*******************************************************************************
 * Copyright (c) 2016 ATOS Spain S.A.
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
package eu.supersede.dynadapt.poc.feature.builder;

import java.io.IOException;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import cz.zcu.yafmt.model.fc.FeatureConfiguration;
import cz.zcu.yafmt.model.fc.util.FeatureConfigurationUtil;
import cz.zcu.yafmt.model.fm.FeatureModel;
import cz.zcu.yafmt.model.fm.util.FeatureModelUtil;

public class ModelManager {
	private ResourceSet resourceSet = new ResourceSetImpl();
	static {
		//FeatureModel initialization before creating the resource set in standalone mode
		if(!Platform.isRunning()){
			FeatureModelUtil.hookPackageRegistry();
			FeatureModelUtil.hookResourceFactoryRegistry();
			FeatureConfigurationUtil.hookPackageRegistry();
			FeatureConfigurationUtil.hookResourceFactoryRegistry();
		}
	}
	
	/** 
	 * Loads a feature model identified by its file system path
	 * @param fmPath file system path defining the location of the feature model
	 * @return
	 */
	public FeatureModel loadFM (String fmPath){
		return loadModel(URI.createURI(fmPath), FeatureModel.class);
	}
	
	/** 
	 * Saves a given feature configuration into the location defined by URI
	 * @param fc feature model to save
	 * @param fcURI URI describing the location of the saved model
	 * @throws IOException
	 */
	public void saveFC (FeatureConfiguration fc, URI fcURI) throws IOException{
		Resource resource = resourceSet.createResource(fcURI);
        resource.getContents().add(fc);
        resource.save(null);
	}
	
	/**
	 * Loads the model resource with the given uri into this resource set. If
	 * no such resource is found or the root object is not an instance of the
	 * given class, null is returned.
	 * 
	 * @param uri uri of the model to be loaded
	 * @param clazz class the model resource should have
	 * @return model resource with the given uri or null.
	 */
	public <T extends EObject> T loadModel(URI uri, Class<T> clazz) {
		Resource resource = null;
		try {
			resource = loadModel(uri);
			if(resource == null)
				return null;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
			
		if(resource == null || resource.getContents().isEmpty())
			return null;
	
		EObject root = resource.getContents().get(0);
		try {
			return clazz.cast(root);
		} catch(ClassCastException e) {
			return null;
		}
	}
	
	/**
	 * Loads the model resource with the given uri into this resource set. If
	 * no such resource is found, null is returned.
	 * 
	 * @param uri uri of the model to be loaded
	 * @return model resource with the given uri or null.
	 */
	public Resource loadModel(URI uri) {
		Resource resource;
		try {
			resource = resourceSet.getResource(uri, true);
		} catch(Exception e) {
			return null;
		}
		if(resource != null)
			EcoreUtil.resolveAll(resourceSet);
		return resource;
	}
}
