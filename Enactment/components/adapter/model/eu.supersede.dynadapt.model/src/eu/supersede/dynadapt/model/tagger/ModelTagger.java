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
package eu.supersede.dynadapt.model.tagger;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;

import eu.supersede.dynadapt.model.IModelManager;

public class ModelTagger implements IModelTagger{
	private IModelManager modelManager = null;
	private static final String OUTPUT_FILE_SUFFIX = "_tagged.uml";
	private Profile profile;
	private Package rootPackage;
	
	/**
	 * Creates an instance of ModelTagger that tags model elements with referenced profile stereotypes
	 * @param targetModelPath
	 */
	public ModelTagger (IModelManager modelManager){
		this.modelManager = modelManager;
	}
	
	public void tagModel(Element element, Profile profile, Stereotype stereotype)
			throws Exception {
		// Get the root package
		rootPackage = element.getNearestPackage();

		// Tag the model
		if (rootPackage.getAppliedProfile(profile.getQualifiedName()) == null) {
			rootPackage.applyProfile(profile);
		}
		if (element.getAppliedStereotype(stereotype.getQualifiedName()) == null) {
			element.applyStereotype(stereotype);
			System.out.println ("Tagged element " + element + " with stereotype " + stereotype.getQualifiedName());
		}
	}
	
	public void tagModel(NamedElement element, Profile profile, String stereotypeName)
			throws Exception {
		Stereotype stereotype = profile.getOwnedStereotype(stereotypeName);
		tagModel(element, profile, stereotype);
	}
	
	public void tagModel(NamedElement element, Profile profile, Stereotype stereotype)
			throws Exception {
		// Get the root package
		rootPackage = element.getNearestPackage();

		// Tag the model
		if (rootPackage.getAppliedProfile(profile.getQualifiedName()) == null) {
			rootPackage.applyProfile(profile);
		}
		if (element.getAppliedStereotype(stereotype.getQualifiedName()) == null) {
			element.applyStereotype(stereotype);
			System.out.println ("Tagged element " + element.getQualifiedName() + " with stereotype " + stereotype.getQualifiedName());
		}
	}

	public void tagModel(NamedElement element, String profileURI, String stereotypeName)
			throws Exception {
		profile = modelManager.loadProfile(profileURI);
//		this.modelManager.registerPackage(profile.getDefinition());
		tagModel(element, profile, stereotypeName);
	}
	
//	public static void main (String[] args) throws Exception{
//		String modelPath = "../models/atos_base_model.uml";
//		String profilePath = "../models/adm.profile.uml";
//		String patternModelPath = "../models/atos_queries.vql";
//		String patternFQN = "eu.supersede.dynadapt.atos.queries.nodeArtifacts";
//		
//		ModelManager modelManager = new ModelManager (modelPath);
//		
//		IModelQuery modelQuery = new ModelQuery (modelManager);
//		
//		String[] parameters = new String[]{"artifact"};
//		Collection <Map<String, Object>>results = modelQuery.query(patternFQN, patternModelPath, Arrays.asList(parameters));
//		
//		//Selecting first artifact match of nodeArtifacts search
//		NamedElement element = (NamedElement) (results.isEmpty()?null:results.iterator().next().get(parameters[0]));
//		
//		IModelTagger tagger = new ModelTagger(modelManager);
//		tagger.tagModel(element, profilePath, "Joinpoint");
//		
//		modelManager.saveTargetModel(OUTPUT_FILE_SUFFIX);
//	}
}
