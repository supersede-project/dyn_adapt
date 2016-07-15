/*******************************************************************************
 * Copyright (c) 2014 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Martin Fleck (Vienna University of Technology) - initial API and implementation
 *
 * Initially developed in the context of ARTIST EU project www.artist-project.eu
 *******************************************************************************/
package eu.supersede.dynadapt.aom.dsl.resources.constants;

import org.eclipse.emf.common.util.URI;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PrimitiveType;

import eu.supersede.dynadapt.aom.dsl.resources.SupersedeDSLModelElement;
/**
 * A convenience class that provides access to all Java Primitive Types
 * through constants. The library containing those types is located 
 * {@link Java_PrimitiveTypes#PACKAGE_URI}.
 *  
 * @author Martin Fleck
 *
 */
public class Java_PrimitiveTypes extends AbstractUMLPackageConstant {
	public static final String PACKAGE_URI_STRING = "pathmap://UML_LIBRARIES/JavaPrimitiveTypes.library.uml";
	public static final URI PACKAGE_URI = URI.createURI(PACKAGE_URI_STRING);

	public interface Element {
		final Package PACKAGE = Java_PrimitiveTypes.getInstance().PACKAGE.getElement();
		
		final PrimitiveType SHORT = Java_PrimitiveTypes.getInstance().SHORT.getElement();
		final PrimitiveType CHAR = Java_PrimitiveTypes.getInstance().CHAR.getElement();
		final PrimitiveType BYTE = Java_PrimitiveTypes.getInstance().BYTE.getElement();
		final PrimitiveType INT = Java_PrimitiveTypes.getInstance().INT.getElement();
		final PrimitiveType BOOLEAN = Java_PrimitiveTypes.getInstance().BOOLEAN.getElement();
		final PrimitiveType LONG = Java_PrimitiveTypes.getInstance().LONG.getElement();
		final PrimitiveType DOUBLE = Java_PrimitiveTypes.getInstance().DOUBLE.getElement();
		final PrimitiveType FLOAT = Java_PrimitiveTypes.getInstance().FLOAT.getElement();
	}

	public interface FQN {
		final String PACKAGE = Java_PrimitiveTypes.getInstance().PACKAGE.getFullyQualifiedName();
		
		final String SHORT = Java_PrimitiveTypes.getInstance().SHORT.getFullyQualifiedName();
		final String CHAR = Java_PrimitiveTypes.getInstance().CHAR.getFullyQualifiedName();
		final String BYTE = Java_PrimitiveTypes.getInstance().BYTE.getFullyQualifiedName();
		final String INT = Java_PrimitiveTypes.getInstance().INT.getFullyQualifiedName();
		final String BOOLEAN = Java_PrimitiveTypes.getInstance().BOOLEAN.getFullyQualifiedName();
		final String LONG = Java_PrimitiveTypes.getInstance().LONG.getFullyQualifiedName();
		final String DOUBLE = Java_PrimitiveTypes.getInstance().DOUBLE.getFullyQualifiedName();
		final String FLOAT = Java_PrimitiveTypes.getInstance().FLOAT.getFullyQualifiedName();
	}

	public interface Uri {
		final String PACKAGE = Java_PrimitiveTypes.getInstance().PACKAGE.getUri();
		
		final String SHORT = Java_PrimitiveTypes.getInstance().SHORT.getUri();
		final String CHAR = Java_PrimitiveTypes.getInstance().CHAR.getUri();
		final String BYTE = Java_PrimitiveTypes.getInstance().BYTE.getUri();
		final String INT = Java_PrimitiveTypes.getInstance().INT.getUri();
		final String BOOLEAN = Java_PrimitiveTypes.getInstance().BOOLEAN.getUri();
		final String LONG = Java_PrimitiveTypes.getInstance().LONG.getUri();
		final String DOUBLE = Java_PrimitiveTypes.getInstance().DOUBLE.getUri();
		final String FLOAT = Java_PrimitiveTypes.getInstance().FLOAT.getUri();
	}

	public final SupersedeDSLModelElement<PrimitiveType> SHORT;
	public final SupersedeDSLModelElement<PrimitiveType> CHAR;
	public final SupersedeDSLModelElement<PrimitiveType> BYTE;
	public final SupersedeDSLModelElement<PrimitiveType> INT;
	public final SupersedeDSLModelElement<PrimitiveType> BOOLEAN;
	public final SupersedeDSLModelElement<PrimitiveType> LONG;
	public final SupersedeDSLModelElement<PrimitiveType> DOUBLE;
	public final SupersedeDSLModelElement<PrimitiveType> FLOAT;
	
	private static Java_PrimitiveTypes instance;
	
	public static Java_PrimitiveTypes getInstance() {
		if(instance == null)
			instance = new Java_PrimitiveTypes();
		return instance;
	}
	
	protected Java_PrimitiveTypes() {
		super(PACKAGE_URI);

		SHORT = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("short"));
		CHAR = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("char"));
		BYTE = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("byte"));
		INT = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("int"));
		BOOLEAN = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("boolean"));
		LONG = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("long"));
		DOUBLE = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("double"));
		FLOAT = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("float"));
	}
}
