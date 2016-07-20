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
package eu.supersede.dynadapt.aom.dsl.resources.constants;

import org.eclipse.emf.common.util.URI;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PrimitiveType;

import eu.supersede.dynadapt.aom.dsl.resources.SupersedeDSLModelElement;

/**
 * A convenience class that provides access to all UML Primitive Types
 * through constants. The package containing those types is located 
 * {@link SupersedeDSLModelElement#PACKAGE_URI}.
 *  
 * @author Martin Fleck, Jesús Gorroñogoitia
 *
 */
public class UML_PrimitiveTypes extends AbstractUMLPackageConstant {
	public static final String PACKAGE_URI_STRING = "pathmap://UML_LIBRARIES/UMLPrimitiveTypes.library.uml";
	public static final URI PACKAGE_URI = URI.createURI(PACKAGE_URI_STRING);

	public interface Element {
		final Package PACKAGE = UML_PrimitiveTypes.getInstance().PACKAGE.getElement();
		
		final PrimitiveType REAL = UML_PrimitiveTypes.getInstance().REAL.getElement();
		final PrimitiveType STRING = UML_PrimitiveTypes.getInstance().STRING.getElement();
		final PrimitiveType INTEGER = UML_PrimitiveTypes.getInstance().INTEGER.getElement();
		final PrimitiveType BOOLEAN = UML_PrimitiveTypes.getInstance().BOOLEAN.getElement();
		final PrimitiveType UNLIMITED_NATURAL = UML_PrimitiveTypes.getInstance().UNLIMITED_NATURAL.getElement();
	}

	public interface FQN {
		final String PACKAGE = UML_PrimitiveTypes.getInstance().PACKAGE.getFullyQualifiedName();
		
		final String REAL = UML_PrimitiveTypes.getInstance().REAL.getFullyQualifiedName();
		final String STRING = UML_PrimitiveTypes.getInstance().STRING.getFullyQualifiedName();
		final String INTEGER = UML_PrimitiveTypes.getInstance().INTEGER.getFullyQualifiedName();
		final String BOOLEAN = UML_PrimitiveTypes.getInstance().BOOLEAN.getFullyQualifiedName();
		final String UNLIMITED_NATURAL = UML_PrimitiveTypes.getInstance().UNLIMITED_NATURAL.getFullyQualifiedName();
	}

	public interface Uri {
		final String PACKAGE = UML_PrimitiveTypes.getInstance().PACKAGE.getUri();
		
		final String REAL = UML_PrimitiveTypes.getInstance().REAL.getUri();
		final String STRING = UML_PrimitiveTypes.getInstance().STRING.getUri();
		final String INTEGER = UML_PrimitiveTypes.getInstance().INTEGER.getUri();
		final String BOOLEAN = UML_PrimitiveTypes.getInstance().BOOLEAN.getUri();
		final String UNLIMITED_NATURAL = UML_PrimitiveTypes.getInstance().UNLIMITED_NATURAL.getUri();
	}

	public final SupersedeDSLModelElement<PrimitiveType> REAL;
	public final SupersedeDSLModelElement<PrimitiveType> STRING;
	public final SupersedeDSLModelElement<PrimitiveType> INTEGER;
	public final SupersedeDSLModelElement<PrimitiveType> BOOLEAN;
	public final SupersedeDSLModelElement<PrimitiveType> UNLIMITED_NATURAL;
	
	private static UML_PrimitiveTypes instance;
	
	public static UML_PrimitiveTypes getInstance() {
		if(instance == null)
			instance = new UML_PrimitiveTypes();
		return instance;
	}
	
	protected UML_PrimitiveTypes() {
		super(PACKAGE_URI);

		REAL = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("Real"));
		STRING = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("String"));
		INTEGER = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("Integer"));
		BOOLEAN = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("Boolean"));
		UNLIMITED_NATURAL = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("UnlimitedNatural"));
	}
}
