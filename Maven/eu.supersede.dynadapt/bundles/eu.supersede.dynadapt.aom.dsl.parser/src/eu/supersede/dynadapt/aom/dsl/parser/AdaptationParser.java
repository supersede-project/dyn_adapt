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
package eu.supersede.dynadapt.aom.dsl.parser;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.viatra.query.patternlanguage.patternLanguage.PatternModel;

import cz.zcu.yafmt.model.fm.FeatureModel;
import eu.supersede.dynadapt.aom.dsl.util.SupersedeDSLResourceUtil;
import eu.supersede.dynadapt.dsl.aspect.Aspect;
import eu.supersede.dynadapt.model.ModelManager;

public class AdaptationParser implements IAdaptationParser{
//	SupersedeDSLResourceSet resourceSet;
	ModelManager modelManager;
	
//	public AdaptationParser(){
//		resourceSet = SupersedeDSLLibraryResourcesUtil.createSupersedeDSLResourceSet();
//	}
	
	public AdaptationParser(ModelManager modelManager){
//		resourceSet = SupersedeDSLLibraryResourcesUtil.createSupersedeDSLResourceSet();
		this.modelManager = modelManager;
	}
	
	public Model loadUMLResource (String path){
		Model resource = modelManager.loadUMLModel(path);
		if (resource != null)
			EcoreUtil.resolveAll (resource);
		return resource;
	}
	
	public Profile loadProfileResource (String path){
		Profile resource = modelManager.loadProfile(path);
		if (resource != null)
			EcoreUtil.resolveAll (resource);
		return resource;
	}
	
	public PatternModel loadPatternResource (String path){
		PatternModel resource = modelManager.loadPatternModel(path);
		if (resource != null)
			EcoreUtil.resolveAll (resource);
		return resource;
	}
	
	public FeatureModel loadFeatureResource (String path){
		FeatureModel resource = modelManager.loadFeatureModel(path);
		if (resource != null)
			EcoreUtil.resolveAll (resource);
		return resource;
	}
	
	public Aspect parseAdaptationModel (IFile adaptationModelFile){
		URI fileURI = URI.createPlatformResourceURI(adaptationModelFile.getFullPath().toString(), true);
		Aspect adaptation = modelManager.loadAspectModel(SupersedeDSLResourceUtil.getPlatformResourceURI(fileURI.toString()));
		Assert.isNotNull(adaptation, "Adaptation model " + fileURI + " could not be parsed");
		return adaptation;
	}
	
	public Aspect parseAdaptationModel (String path){
		Aspect adaptation = modelManager.loadAspectModel(path);
		Assert.isNotNull(adaptation, "Adaptation model " + path + " could not be parsed");
		return adaptation;
	}
	
}
