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
package eu.supersede.dynadapt.aom.dsl.parser.test;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.types.TypesPackage;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.viatra.query.patternlanguage.PatternLanguageStandaloneSetup;
import org.eclipse.viatra.query.patternlanguage.patternLanguage.PatternLanguagePackage;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Injector;

import cz.zcu.yafmt.model.fm.FeatureModelPackage;
import eu.supersede.dynadapt.aom.dsl.parser.AdaptationParser;
import eu.supersede.dynadapt.aom.dsl.parser.IAdaptationParser;
import eu.supersede.dynadapt.aom.dsl.resources.SupersedeResources;
import eu.supersede.dynadapt.aom.dsl.util.SupersedeDSLResourceSet;
import eu.supersede.dynadapt.dsl.AspectStandaloneSetup;
import eu.supersede.dynadapt.dsl.aspect.Aspect;
import eu.supersede.dynadapt.dsl.aspect.AspectPackage;
import eu.supersede.dynadapt.lang.uml.UmlSupport;
import eu.supersede.dynadapt.lang.yafmt.YafmtSupport;
import eu.supersede.dynadapt.model.ModelManager;

public class AspectDSLTest {
	private IAdaptationParser parser;
	private ModelManager modelManager;
	
	@Before
	public void setup() throws IOException{
		modelManager = new ModelManager(false);
		parser = new AdaptationParser(modelManager);
	}

	@Test
	public void loadAspectModelTest() {
		new org.eclipse.emf.mwe.utils.StandaloneSetup().setPlatformUri("../");
//		URI aspectModelURI = URI.createFileURI("./models/concurrency.aspect");
		String aspectModelPath = "platform:/resource/eu.supersede.dynadapt.aom.dsl.parser/models/concurrency.aspect";
		
//		SupersedeDSLResourceSet set = SupersedeResources.createResourceSet();
//		Aspect aspectModel = set.loadAspectModel(aspectModelURI);
//		Assert.assertNotNull(aspectModel);
		
		parser.loadUMLResource("platform:/resource/eu.supersede.dynadapt.aom.dsl.parser/models/atos_base_model.uml");
		parser.loadProfileResource("platform:/resource/eu.supersede.dynadapt.aom.dsl.parser/models/adm.profile.uml");
		parser.loadPatternResource("platform:/resource/eu.supersede.dynadapt.aom.dsl.parser/models/atos_queries.vql");
		parser.loadFeatureModelResource("platform:/resource/eu.supersede.dynadapt.aom.dsl.parser/models/AtosUCFeatureModel.yafm");
		
		Aspect adaptation = parser.parseAdaptationModel(aspectModelPath);
		
		String featureName = adaptation.getFeature().getName();
		String patternName = adaptation.getPointcuts().get(0).getPattern().getName();
	}
	
	@Test
	public void loadAspectModelTest2() {
		new org.eclipse.emf.mwe.utils.StandaloneSetup().setPlatformUri("../");
		URI aspectModelURI = URI.createURI("platform:/resource/eu.supersede.dynadapt.aom.dsl.parser/models/concurrency.aspect");
		Injector injector = new AspectStandaloneSetup().createInjectorAndDoEMFRegistration();
		UmlSupport.doSetup();
		YafmtSupport.doSetup();
		PatternLanguageStandaloneSetup.doSetup();
//		AspectStandaloneSetup.doSetup();
		
		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();
		UMLPackage.eINSTANCE.eClass();
		FeatureModelPackage.eINSTANCE.eClass();
		PatternLanguagePackage.eINSTANCE.eClass();
		AspectPackage.eINSTANCE.eClass();
		
		XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
		Resource resource = resourceSet.getResource(aspectModelURI, true);
		Aspect model = (Aspect) resource.getContents().get(0);
	}

}
