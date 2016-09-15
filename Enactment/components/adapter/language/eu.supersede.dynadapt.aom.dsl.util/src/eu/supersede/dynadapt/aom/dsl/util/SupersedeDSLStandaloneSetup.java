/*******************************************************************************
 * Copyright (c) 2014-2016 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Martin Fleck (Vienna University of Technology) - initial API and implementation
 * Jesús Gorroñogoitia (Atos Spain S.A.) - Adapted to Supesede project
 *
 * Initially developed in the context of ARTIST EU project www.artist-project.eu
 * Adapted in the context of SUPERSEDE EU project www.supersede.eu
 *******************************************************************************/
package eu.supersede.dynadapt.aom.dsl.util;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.uml2.types.TypesPackage;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.viatra.query.patternlanguage.PatternLanguageStandaloneSetup;
import org.eclipse.viatra.query.patternlanguage.emf.EMFPatternLanguageStandaloneSetup;
import org.eclipse.viatra.query.patternlanguage.patternLanguage.PatternLanguagePackage;

import cz.zcu.yafmt.model.fm.FeatureModelPackage;
import eu.supersede.dynadapt.dsl.AspectStandaloneSetup;
import eu.supersede.dynadapt.dsl.aspect.AspectPackage;
import eu.supersede.dynadapt.lang.uml.UmlSupport;
import eu.supersede.dynadapt.lang.yafmt.EMFYafmtStandaloneSetup;
import eu.supersede.dynadapt.lang.yafmt.YafmtSupport;

/**
 * This class provides a way to initialize support for running the SUPERSEDE 
 * DSL Xtext languages without the equinox extension registry.
 * 
 * @author Martin Fleck
 * @author Jesús Gorroñogoitia
 */
public class SupersedeDSLStandaloneSetup {
	private static boolean initialized = false;
	
	/**
	 * This method initializes support for running the SUPERSEDE DSL Xtext
	 * languages without the equinox extension registry. Calling this method
	 * creates the necessary injectors, registers the EMF packages of the 
	 * languages and provides the necessary resource factory and service 
	 * provider for handling the language extensions.
	 * <p/>
	 * Calling this method multiple times has no negative effect.
	 */
	public static void doSetup() {
		if(!Platform.isRunning() && !initialized) {
			//Register EMF/XText cross-referenced metamodels
			UmlSupport.doSetup();
			YafmtSupport.doSetup();
			new EMFPatternLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
			AspectStandaloneSetup.doSetup();
			
			// Initialize simple dependencies
			EcorePackage.eINSTANCE.eClass();
			TypesPackage.eINSTANCE.eClass();
			UMLPackage.eINSTANCE.eClass();
			FeatureModelPackage.eINSTANCE.eClass();
			PatternLanguagePackage.eINSTANCE.eClass();
			AspectPackage.eINSTANCE.eClass();
			
			initialized = true;
		}
	}
}
