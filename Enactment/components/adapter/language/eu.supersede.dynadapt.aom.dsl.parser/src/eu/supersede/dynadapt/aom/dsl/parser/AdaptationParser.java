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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.internal.impl.ProfileImpl;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.eclipse.viatra.query.patternlanguage.patternLanguage.Pattern;
import org.eclipse.viatra.query.patternlanguage.patternLanguage.PatternModel;
import org.eclipse.viatra.query.patternlanguage.patternLanguage.impl.PatternImpl;

import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.FeatureModel;
import eu.supersede.dynadapt.aom.dsl.resources.SupersedeDSLLibraryResourcesUtil;
import eu.supersede.dynadapt.aom.dsl.util.SupersedeDSLResourceSet;
import eu.supersede.dynadapt.aom.dsl.util.SupersedeDSLResourceUtil;
import eu.supersede.dynadapt.dsl.aspect.Aspect;

public class AdaptationParser implements IAdaptationParser{
	SupersedeDSLResourceSet resourceSet;
	
	public AdaptationParser(){
		resourceSet = SupersedeDSLLibraryResourcesUtil.createSupersedeDSLResourceSet();
	}
	
	public Model loadUMLResource (URI uri){
		Model resource = resourceSet.loadUMLModel(uri);
		if (resource != null)
			EcoreUtil.resolveAll (resource);
		return resource;
	}
	
	public Profile loadProfileResource (URI uri){
		Profile resource = resourceSet.loadUMLProfile(uri);
		if (resource != null)
			EcoreUtil.resolveAll (resource);
		return resource;
	}
	
	public PatternModel loadPatternResource (URI uri){
		PatternModel resource = resourceSet.loadPatternModel(uri);
		if (resource != null)
			EcoreUtil.resolveAll (resource);
		return resource;
	}
	
	public FeatureModel loadFeatureResource (URI uri){
		FeatureModel resource = resourceSet.loadFeatureModel(uri);
		if (resource != null)
			EcoreUtil.resolveAll (resource);
		return resource;
	}
	
	public Aspect parseAdaptationModel (IFile adaptationModelFile){
		URI fileURI = URI.createPlatformResourceURI(adaptationModelFile.getFullPath().toString(), true);
		Aspect adaptation = resourceSet.loadAspectModel(SupersedeDSLResourceUtil.getPlatformResourceURI(fileURI.toString()));
		Assert.isNotNull(adaptation, "Adaptation model " + fileURI + " could not be parsed");
		return adaptation;
	}
	
	public Aspect parseAdaptationModel (URI fileURI){
		Aspect adaptation = resourceSet.loadAspectModel(fileURI);
		Assert.isNotNull(adaptation, "Adaptation model " + fileURI + " could not be parsed");
		return adaptation;
	}
	
}
