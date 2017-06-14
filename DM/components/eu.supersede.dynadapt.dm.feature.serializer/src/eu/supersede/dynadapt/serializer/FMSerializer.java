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
package eu.supersede.dynadapt.serializer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import cz.zcu.yafmt.model.fc.impl.FeatureConfigurationImpl;
import cz.zcu.yafmt.model.fm.FeatureModel;

public class FMSerializer {
	private List<String> arguments = new ArrayList<String>();
	private ResourceSet resultSet;
	
	/**
	 * Serializes an input feature model, as YAFMT FM instance, 
	 * into a number of artifacts: Grammar, JSON serialization of quality attributes
	 * @param absoluteFMModelPath absolute path location for FM
	 * @param absolutetargetFolderPath absolute path location for folder where to place generated artefacts
	 * @throws IOException
	 */
	public void serializeFMToArtifactsInFolder (String absoluteFMModelPath, String absoluteTargetFolderPath) throws IOException{
		resultSet = new ResourceSetImpl();
		URI modelURI = URI.createFileURI(absoluteFMModelPath);
		File targetFolder = new File (absoluteTargetFolderPath);
		eu.supersede.dynadapt.feature.serializer.Main generator = new eu.supersede.dynadapt.feature.serializer.Main(modelURI, targetFolder, arguments);
		
		generator.doGenerate(new BasicMonitor());
	}
	
	public void serializeFCToArtifactsInFolder (String absoluteFCModelPath, String absoluteFMModelPath, String absoluteTargetFolderPath) throws IOException{
		resultSet = new ResourceSetImpl();
		URI fcURI = URI.createFileURI(absoluteFCModelPath);
		File targetFolder = new File (absoluteTargetFolderPath);
		eu.supersede.dynadapt.configuration.serializer.Main generator = new eu.supersede.dynadapt.configuration.serializer.Main(fcURI, targetFolder, arguments);
		
		//TODO: Inject in feature configuration model the default values for quality attributes in associated feature model attributes
		FeatureConfigurationImpl fc = (FeatureConfigurationImpl)generator.getModel();
		//Loading FM
		URI fmURI = URI.createFileURI(absoluteFMModelPath);
		FeatureModel fm = loadModel (fmURI, FeatureModel.class);
		
		//Injecting the entire fc into the fm
		fc.setFeatureModel(fm);
		fc.setFeatureModelCopy(fm);
		
		generator.doGenerate(new BasicMonitor());
	}

	private  Resource loadModel(URI uri) {
		Resource resource;
		try {
			resource = resultSet.getResource(uri, true);
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		if(resource != null)
			EcoreUtil.resolveAll(resultSet);
		return resource;
	}
	
	private <T extends EObject> T loadModel(URI uri, Class<T> clazz) {
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
}
