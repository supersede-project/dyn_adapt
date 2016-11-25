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
 * 	Edith Zavala (UPC) - main development
 * 	
 * Initially developed in the context of SUPERSEDE EU project
 * www.supersede.eu
 *******************************************************************************/
package eu.supersede.dynadapt.modelrepository.repositoryaccess;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;

import eu.supersede.dynadapt.aom.dsl.parser.AdaptationParser;
import eu.supersede.dynadapt.aom.dsl.parser.IAdaptationParser;
import eu.supersede.dynadapt.dsl.aspect.Aspect;
import eu.supersede.dynadapt.model.ModelManager;

public class ModelRepository {

	private String repository;
	private URL url;
	private ModelManager modelManager;

	public ModelRepository(String repository, URL url, ModelManager modelManager) {
		super();
		this.repository = repository;
		this.url = url;
		this.modelManager = modelManager;
	}

	/**
	 * This method returns a list of aspect models linked to an specific
	 * featureSUPERSEDE given the featureSUPERSEDE id and the models' location
	 * required for loading the aspects
	 * 
	 * @param featureSUPERSEDEId,
	 *            modelsLocation
	 */
	public List<Aspect> getAspectModels(String featureSUPERSEDEId, Map<String, String> modelsLocation) {
		List<Aspect> aspects = new ArrayList<Aspect>();

		File[] aspectsFiles = getFiles(modelsLocation.get("aspects"), "aspect");

		IAdaptationParser ap = loadModels(modelsLocation);

		if (aspectsFiles != null) {
			for (int i = 0; i < aspectsFiles.length; i++) {
				Aspect a = getAspectModel(ap, repository + modelsLocation.get("aspects") + aspectsFiles[i].getName());
				if (a.getFeature().getId().equalsIgnoreCase(featureSUPERSEDEId)) {
					aspects.add(a);
				}
			}
		}
		return aspects;
	}
	
	/**
	 * This method returns a list of aspect models URIs linked to an specific
	 * featureSUPERSEDE given the featureSUPERSEDE id and the models' location
	 * required for loading the aspects
	 * 
	 * The URIs returned are of the form: platform:/resource/eclipse_project/aspect.aspect
	 * 
	 * @param featureSUPERSEDEId,
	 *            modelsLocation
	 */

	public List<URI> getAspectModelsURIs(String featureSUPERSEDEId, Map<String, String> modelsLocation) {
		List<URI> uris = new ArrayList<URI>();

		File[] aspectsFiles = getFiles(modelsLocation.get("aspects"), "aspect");

		IAdaptationParser ap = loadModels(modelsLocation);

		if (aspectsFiles != null) {
			for (int i = 0; i < aspectsFiles.length; i++) {
				String aspectModelPath = repository + modelsLocation.get("aspects") + aspectsFiles[i].getName();
				Aspect a = getAspectModel(ap, aspectModelPath);
				if (a.getFeature().getId().equalsIgnoreCase(featureSUPERSEDEId)) {
					uris.add(URI.createURI(aspectModelPath));
				}
			}
		}
		return uris;
	}

	private IAdaptationParser loadModels(Map<String, String> modelsLocation) {
		IAdaptationParser parser = new AdaptationParser(modelManager);

		File[] variants = getFiles(modelsLocation.get("variants"), "uml"); //FIXME only uml models should be included
		for (int i = 0; i < variants.length; i++) {
			parser.loadUMLResource(repository + modelsLocation.get("variants") + variants[i].getName());
		}

		File[] profiles = getFiles(modelsLocation.get("profiles"), "uml");
		for (int i = 0; i < profiles.length; i++) {
			parser.loadProfileResource(repository + modelsLocation.get("profiles") + profiles[i].getName());
		}

		File[] patterns = getFiles(modelsLocation.get("patterns"), "vql");
		for (int i = 0; i < patterns.length; i++) {
			parser.loadPatternResource(repository + modelsLocation.get("patterns") + patterns[i].getName());
		}


		File[] features = getFiles(modelsLocation.get("features"), "yafm");
		for (int i = 0; i < features.length; i++) {
			parser.loadFeatureResource(repository + modelsLocation.get("features") + features[i].getName());
		}

		return parser;
	}
	
	private Aspect getAspectModel(IAdaptationParser parser, String aspectModelPath) {
		return parser.parseAdaptationModel(aspectModelPath);
	}
	
	private File[] getFiles(String folderPath, String extension) {
		/*
		 * Models in class path
		 */
//		URL uriFolder = this.url.getClass().getResource("/" + folderPath);

		URL uriFolder = null;
		
		try {
			uriFolder = new URL(this.url.toString()+folderPath);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
		
		File[] files = null;
		File folder = null;

		try {
			folder = new File(uriFolder.toURI());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		// create new filename filter
        FilenameFilter fileNameFilter = new FilenameFilter() {
  
           @Override
           public boolean accept(File dir, String name) {
              if(name.lastIndexOf('.')>0)
              {
                 // get last index for '.' char
                 int lastIndex = name.lastIndexOf('.');
                 
                 // get extension
                 String str = name.substring(lastIndex);
                 
                 // match path name extension
                 if(str.equals("." + extension))
                 {
                    return true;
                 }
              }
              return false;
           }
        };
        
		return files = folder.listFiles(fileNameFilter);
	}
}
