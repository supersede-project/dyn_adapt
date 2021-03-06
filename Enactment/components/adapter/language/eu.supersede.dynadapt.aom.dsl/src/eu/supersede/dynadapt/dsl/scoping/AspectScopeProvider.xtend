/*
 * generated by Xtext
 */
/*******************************************************************************
 * Copyright (c) 2014-2016 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Martin Fleck (Vienna University of Technology) - initial API and implementation
 * Jesús Gorroñogoitia (Atos Spain S.A.) - Adapted to Supersede project
 *
 * Initially developed in the context of ARTIST EU project www.artist-project.eu
 * Adapted in the context of SUPERSEDE EU project www.supersede.eu
 *******************************************************************************/
package eu.supersede.dynadapt.dsl.scoping

import org.eclipse.xtext.scoping.IScope
import eu.supersede.dynadapt.dsl.aspect.Aspect
import org.eclipse.emf.ecore.EReference
import eu.supersede.dynadapt.aom.dsl.extensionpoint.RegisteredModelResources
import org.eclipse.xtext.scoping.impl.SimpleScope

/**
 * This class contains custom scoping description.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 *
 */
class AspectScopeProvider extends org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider {
	def IScope scope_Aspect_advice(Aspect aspect, EReference ref) {
		var scope = delegate.getScope(aspect, ref);
		val converter = aspect.eResource.resourceSet.URIConverter;
		val preloadedURIs = RegisteredModelResources.getInstance.URIs.map[u | converter.normalize(u)].toSet;
		scope = new SimpleScope(scope.allElements.filter[desc | !preloadedURIs.contains(converter.normalize(desc.EObjectURI).trimFragment)]);
		return scope;
	}
}
