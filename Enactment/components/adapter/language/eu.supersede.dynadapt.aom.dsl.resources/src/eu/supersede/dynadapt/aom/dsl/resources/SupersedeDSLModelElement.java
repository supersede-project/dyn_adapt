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
package eu.supersede.dynadapt.aom.dsl.resources;

import org.eclipse.emf.ecore.EObject;

import eu.supersede.dynadapt.aom.dsl.util.SupersedeDSLResourceUtil;


/**
 * A {@link SupersedeDSLModelElement} is a convenience class, storing an ecore
 * element (EObject) as well as the uri of that element and the fully qualified
 * names as used by Xtext.
 * 
 * @author Martin Fleck, Jesús Gorroñogoitia
 *
 */
public class SupersedeDSLModelElement<T extends EObject> {
	
	private T element;
	private String uri;
	private String qualifiedName;

	/**
	 * Creates a new Supersede DSL model element with the given element. The
	 * fully qualified name (FQN) and the element uri will be evaluated
	 * if needed.
	 * 
	 * @param element
	 */
	public SupersedeDSLModelElement(T element) {
		this.element = element;
	}
	
	/**
	 * Stored ecore element.
	 * @return ecore element
	 */
	public T getElement() {
		return element;
	}
	
	/**
	 * Fully qualified name (FQN) of the stored ecore element
	 * @return fqn
	 */
	public String getFullyQualifiedName() {
		if(qualifiedName == null) 
			qualifiedName = SupersedeDSLResourceUtil.getFullyQualifiedName(getElement());
		return qualifiedName;
	}
	
	/**
	 * Uri of the stored ecore element
	 * @return uri
	 */
	public String getUri() {
		if(uri == null && element != null && element.eResource() != null)
			uri = element.eResource().getURI() + element.eResource().getURIFragment(element);
		return uri;
	}
	
	@Override
	public String toString() {
		String result = "FQN: " + getFullyQualifiedName() + "\n";
		result += "URI: " + getUri() + "\n";
		result += "Element: " + getElement() + "\n";
		return result;
	}
}
