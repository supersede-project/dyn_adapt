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
 *******************************************************************************/package eu.supersede.dynadapt.aom.dsl.util;

import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.viatra.query.patternlanguage.patternLanguage.Pattern;

import cz.zcu.yafmt.model.fm.Feature;
import eu.supersede.dynadapt.dsl.aspect.Action;
import eu.supersede.dynadapt.dsl.aspect.Aspect;
import eu.supersede.dynadapt.dsl.aspect.AspectFactory;
import eu.supersede.dynadapt.dsl.aspect.Composition;
import eu.supersede.dynadapt.dsl.aspect.Pointcut;

/**
 * The SUPERSEDE DSL factory encapsulates the access to the different SUPERSEDE DSL
 * language factories (e.g., {@link GmlFactory}) and provides
 * convenient methods for creating objects for any of the SUPERSEDE DSL 
 * languages, i.e., also methods where optional parameters must not be
 * specified explicitly.
 * 
 * @author Martin Fleck
 * @author Jesús Gorroñogoitia
 * 
 */
public class SupersedeDSLFactory {
	public static final AspectFactory ASPECT = AspectFactory.eINSTANCE;
	
	/**
	 * Removes any invalid characters from the given name to produce a valid
	 * qualified name. 
	 * 
	 * @param name name to be converted to a qualified name
	 * @return valid qualified name
	 */
	public static String toQualifiedName(String name) {
		if(name == null)
			return null;
		return name.replace(" ", "_").replace("^", "");
	}
	
	
	//
	// ASPECT
	//
	
	/**
	 * Creates a new complete aspect model with the given data.
	 * <p/>
	 * An aspect model contains a feature, an advice model, pointcuts and composition directives. 
	 * An aspect model is considered fulfilled if all top-level elements 
	 * are included..
	 * 
	 * @param qualifiedName name to be used for the aspect model
	 * @param feature associated feature
	 * @param advice associated advice
	 * @param pointcuts pointcuts describing model elements where to apply the advice
	 * @param compositions composition directives that describe how to apply the advice in the pointcuts matches
	 * @return newly created aspect model
	 * 
	 * 
	 */
	public static Aspect createAspectModel(String qualifiedName, Feature feature, Model advice, Iterable<? extends Pointcut> pointcuts, Iterable<? extends Composition> compositions) {
		Aspect aspectModel = ASPECT.createAspect();
		aspectModel.setName(toQualifiedName(qualifiedName));
		aspectModel.setFeature(feature);
		aspectModel.setAdvice(advice);
		CollectionUtil.add(pointcuts, aspectModel.getPointcuts());
		CollectionUtil.add(compositions, aspectModel.getCompositions());
		return aspectModel;
	}
	
	/**
	 * Creates a new empty aspect model with the given name.
	 * <p/>
	 * 
	 */
	public static Aspect createAspectModel(String qualifiedName) {
		return createAspectModel(qualifiedName, null, null, null, null);
	}
	
	/**
	 * Creates a pointcut with the given data.
	 * <p/>
	 */
	public static Pointcut createWorkload(String name, Pattern pattern, Stereotype role) {
		Pointcut pointcut = ASPECT.createPointcut();
		pointcut.setName(toQualifiedName(name));
		pointcut.setPattern(pattern);
		pointcut.setRole(role);
		return pointcut;
	}
	
	/**
	 * Creates a composition with the given data.
	 * <p/>
	 */
	public static Composition createComposition(String name, Action action, Stereotype advice, boolean featureEnabled, Stereotype jointPointRole) {
		Composition composition = ASPECT.createComposition();
		composition.setName(toQualifiedName(name));
		composition.setAction(action);
		composition.setAdvice(advice);
		composition.setFeature_enabled(featureEnabled);
		composition.setJointpointRole(jointPointRole);
		
		return composition;
	}
}
