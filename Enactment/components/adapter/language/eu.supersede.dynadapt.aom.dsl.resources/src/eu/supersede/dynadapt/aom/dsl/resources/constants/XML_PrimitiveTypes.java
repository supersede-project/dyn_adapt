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
 * A convenience class that provides access to all XML Primitive Types
 * through constants. The package containing those types is located 
 * {@link XML_PrimitiveTypes#PACKAGE_URI}.
 *  
 * @author Martin Fleck, Jesús Gorroñogoitia
 *
 */
public class XML_PrimitiveTypes extends AbstractUMLPackageConstant {
	public static final String PACKAGE_URI_STRING = "pathmap://UML_LIBRARIES/XMLPrimitiveTypes.library.uml";
	public static final URI PACKAGE_URI = URI.createURI(PACKAGE_URI_STRING);

	public interface Element {
		final Package PACKAGE = XML_PrimitiveTypes.getInstance().PACKAGE.getElement();
		
		final PrimitiveType NC_NAME = XML_PrimitiveTypes.getInstance().NC_NAME.getElement();
		final PrimitiveType UNSIGNED_SHORT_OBJECT = XML_PrimitiveTypes.getInstance().UNSIGNED_SHORT_OBJECT.getElement();
		final PrimitiveType NOTATION = XML_PrimitiveTypes.getInstance().NOTATION.getElement();
		final PrimitiveType G_MONTH = XML_PrimitiveTypes.getInstance().G_MONTH.getElement();
		final PrimitiveType SHORT = XML_PrimitiveTypes.getInstance().SHORT.getElement();
		final PrimitiveType ENTITIES_BASE = XML_PrimitiveTypes.getInstance().ENTITIES_BASE.getElement();
		final PrimitiveType ANY_SIMPLE_TYPE = XML_PrimitiveTypes.getInstance().ANY_SIMPLE_TYPE.getElement();
		final PrimitiveType SHORT_OBJECT = XML_PrimitiveTypes.getInstance().SHORT_OBJECT.getElement();
		final PrimitiveType DATE = XML_PrimitiveTypes.getInstance().DATE.getElement();
		final PrimitiveType DATE_TIME = XML_PrimitiveTypes.getInstance().DATE_TIME.getElement();
		final PrimitiveType DECIMAL = XML_PrimitiveTypes.getInstance().DECIMAL.getElement();
		final PrimitiveType ID = XML_PrimitiveTypes.getInstance().ID.getElement();
		final PrimitiveType INT = XML_PrimitiveTypes.getInstance().INT.getElement();
		final PrimitiveType UNSIGNED_BYTE = XML_PrimitiveTypes.getInstance().UNSIGNED_BYTE.getElement();
		final PrimitiveType ENTITY = XML_PrimitiveTypes.getInstance().ENTITY.getElement();
		final PrimitiveType BASE64_BINARY = XML_PrimitiveTypes.getInstance().BASE64_BINARY.getElement();
		final PrimitiveType ANY_U_R_I = XML_PrimitiveTypes.getInstance().ANY_U_R_I.getElement();
		final PrimitiveType LONG = XML_PrimitiveTypes.getInstance().LONG.getElement();
		final PrimitiveType IDREFS = XML_PrimitiveTypes.getInstance().IDREFS.getElement();
		final PrimitiveType NON_POSITIVE_INTEGER = XML_PrimitiveTypes.getInstance().NON_POSITIVE_INTEGER.getElement();
		final PrimitiveType BOOLEAN_OBJECT = XML_PrimitiveTypes.getInstance().BOOLEAN_OBJECT.getElement();
		final PrimitiveType BYTE = XML_PrimitiveTypes.getInstance().BYTE.getElement();
		final PrimitiveType UNSIGNED_BYTE_OBJECT = XML_PrimitiveTypes.getInstance().UNSIGNED_BYTE_OBJECT.getElement();
		final PrimitiveType ENTITIES = XML_PrimitiveTypes.getInstance().ENTITIES.getElement();
		final PrimitiveType STRING = XML_PrimitiveTypes.getInstance().STRING.getElement();
		final PrimitiveType HEX_BINARY = XML_PrimitiveTypes.getInstance().HEX_BINARY.getElement();
		final PrimitiveType UNSIGNED_INT_OBJECT = XML_PrimitiveTypes.getInstance().UNSIGNED_INT_OBJECT.getElement();
		final PrimitiveType DOUBLE = XML_PrimitiveTypes.getInstance().DOUBLE.getElement();
		final PrimitiveType G_MONTH_DAY = XML_PrimitiveTypes.getInstance().G_MONTH_DAY.getElement();
		final PrimitiveType NMTOKEN_S = XML_PrimitiveTypes.getInstance().NMTOKEN_S.getElement();
		final PrimitiveType UNSIGNED_INT = XML_PrimitiveTypes.getInstance().UNSIGNED_INT.getElement();
		final PrimitiveType BYTE_OBJECT = XML_PrimitiveTypes.getInstance().BYTE_OBJECT.getElement();
		final PrimitiveType INT_OBJECT = XML_PrimitiveTypes.getInstance().INT_OBJECT.getElement();
		final PrimitiveType UNSIGNED_LONG = XML_PrimitiveTypes.getInstance().UNSIGNED_LONG.getElement();
		final PrimitiveType Q_NAME = XML_PrimitiveTypes.getInstance().Q_NAME.getElement();
		final PrimitiveType G_YEAR = XML_PrimitiveTypes.getInstance().G_YEAR.getElement();
		final PrimitiveType LONG_OBJECT = XML_PrimitiveTypes.getInstance().LONG_OBJECT.getElement();
		final PrimitiveType NMTOKEN = XML_PrimitiveTypes.getInstance().NMTOKEN.getElement();
		final PrimitiveType TIME = XML_PrimitiveTypes.getInstance().TIME.getElement();
		final PrimitiveType POSITIVE_INTEGER = XML_PrimitiveTypes.getInstance().POSITIVE_INTEGER.getElement();
		final PrimitiveType DURATION = XML_PrimitiveTypes.getInstance().DURATION.getElement();
		final PrimitiveType NON_NEGATIVE_INTEGER = XML_PrimitiveTypes.getInstance().NON_NEGATIVE_INTEGER.getElement();
		final PrimitiveType G_DAY = XML_PrimitiveTypes.getInstance().G_DAY.getElement();
		final PrimitiveType NMTOKENS_BASE = XML_PrimitiveTypes.getInstance().NMTOKENS_BASE.getElement();
		final PrimitiveType G_YEAR_MONTH = XML_PrimitiveTypes.getInstance().G_YEAR_MONTH.getElement();
		final PrimitiveType IDREFS_BASE = XML_PrimitiveTypes.getInstance().IDREFS_BASE.getElement();
		final PrimitiveType FLOAT = XML_PrimitiveTypes.getInstance().FLOAT.getElement();
		final PrimitiveType TOKEN = XML_PrimitiveTypes.getInstance().TOKEN.getElement();
		final PrimitiveType BOOLEAN = XML_PrimitiveTypes.getInstance().BOOLEAN.getElement();
		final PrimitiveType NORMALIZED_STRING = XML_PrimitiveTypes.getInstance().NORMALIZED_STRING.getElement();
		final PrimitiveType NAME = XML_PrimitiveTypes.getInstance().NAME.getElement();
		final PrimitiveType DOUBLE_OBJECT = XML_PrimitiveTypes.getInstance().DOUBLE_OBJECT.getElement();
		final PrimitiveType NEGATIVE_INTEGER = XML_PrimitiveTypes.getInstance().NEGATIVE_INTEGER.getElement();
		final PrimitiveType IDREF = XML_PrimitiveTypes.getInstance().IDREF.getElement();
		final PrimitiveType UNSIGNED_SHORT = XML_PrimitiveTypes.getInstance().UNSIGNED_SHORT.getElement();
		final PrimitiveType FLOAT_OBJECT = XML_PrimitiveTypes.getInstance().FLOAT_OBJECT.getElement();
		final PrimitiveType LANGUAGE = XML_PrimitiveTypes.getInstance().LANGUAGE.getElement();
		final PrimitiveType INTEGER = XML_PrimitiveTypes.getInstance().INTEGER.getElement();
	}

	public interface FQN {
		final String PACKAGE = XML_PrimitiveTypes.getInstance().PACKAGE.getFullyQualifiedName();
		
		final String NC_NAME = XML_PrimitiveTypes.getInstance().NC_NAME.getFullyQualifiedName();
		final String UNSIGNED_SHORT_OBJECT = XML_PrimitiveTypes.getInstance().UNSIGNED_SHORT_OBJECT.getFullyQualifiedName();
		final String NOTATION = XML_PrimitiveTypes.getInstance().NOTATION.getFullyQualifiedName();
		final String G_MONTH = XML_PrimitiveTypes.getInstance().G_MONTH.getFullyQualifiedName();
		final String SHORT = XML_PrimitiveTypes.getInstance().SHORT.getFullyQualifiedName();
		final String ENTITIES_BASE = XML_PrimitiveTypes.getInstance().ENTITIES_BASE.getFullyQualifiedName();
		final String ANY_SIMPLE_TYPE = XML_PrimitiveTypes.getInstance().ANY_SIMPLE_TYPE.getFullyQualifiedName();
		final String SHORT_OBJECT = XML_PrimitiveTypes.getInstance().SHORT_OBJECT.getFullyQualifiedName();
		final String DATE = XML_PrimitiveTypes.getInstance().DATE.getFullyQualifiedName();
		final String DATE_TIME = XML_PrimitiveTypes.getInstance().DATE_TIME.getFullyQualifiedName();
		final String DECIMAL = XML_PrimitiveTypes.getInstance().DECIMAL.getFullyQualifiedName();
		final String ID = XML_PrimitiveTypes.getInstance().ID.getFullyQualifiedName();
		final String INT = XML_PrimitiveTypes.getInstance().INT.getFullyQualifiedName();
		final String UNSIGNED_BYTE = XML_PrimitiveTypes.getInstance().UNSIGNED_BYTE.getFullyQualifiedName();
		final String ENTITY = XML_PrimitiveTypes.getInstance().ENTITY.getFullyQualifiedName();
		final String BASE64_BINARY = XML_PrimitiveTypes.getInstance().BASE64_BINARY.getFullyQualifiedName();
		final String ANY_U_R_I = XML_PrimitiveTypes.getInstance().ANY_U_R_I.getFullyQualifiedName();
		final String LONG = XML_PrimitiveTypes.getInstance().LONG.getFullyQualifiedName();
		final String IDREFS = XML_PrimitiveTypes.getInstance().IDREFS.getFullyQualifiedName();
		final String NON_POSITIVE_INTEGER = XML_PrimitiveTypes.getInstance().NON_POSITIVE_INTEGER.getFullyQualifiedName();
		final String BOOLEAN_OBJECT = XML_PrimitiveTypes.getInstance().BOOLEAN_OBJECT.getFullyQualifiedName();
		final String BYTE = XML_PrimitiveTypes.getInstance().BYTE.getFullyQualifiedName();
		final String UNSIGNED_BYTE_OBJECT = XML_PrimitiveTypes.getInstance().UNSIGNED_BYTE_OBJECT.getFullyQualifiedName();
		final String ENTITIES = XML_PrimitiveTypes.getInstance().ENTITIES.getFullyQualifiedName();
		final String STRING = XML_PrimitiveTypes.getInstance().STRING.getFullyQualifiedName();
		final String HEX_BINARY = XML_PrimitiveTypes.getInstance().HEX_BINARY.getFullyQualifiedName();
		final String UNSIGNED_INT_OBJECT = XML_PrimitiveTypes.getInstance().UNSIGNED_INT_OBJECT.getFullyQualifiedName();
		final String DOUBLE = XML_PrimitiveTypes.getInstance().DOUBLE.getFullyQualifiedName();
		final String G_MONTH_DAY = XML_PrimitiveTypes.getInstance().G_MONTH_DAY.getFullyQualifiedName();
		final String NMTOKEN_S = XML_PrimitiveTypes.getInstance().NMTOKEN_S.getFullyQualifiedName();
		final String UNSIGNED_INT = XML_PrimitiveTypes.getInstance().UNSIGNED_INT.getFullyQualifiedName();
		final String BYTE_OBJECT = XML_PrimitiveTypes.getInstance().BYTE_OBJECT.getFullyQualifiedName();
		final String INT_OBJECT = XML_PrimitiveTypes.getInstance().INT_OBJECT.getFullyQualifiedName();
		final String UNSIGNED_LONG = XML_PrimitiveTypes.getInstance().UNSIGNED_LONG.getFullyQualifiedName();
		final String Q_NAME = XML_PrimitiveTypes.getInstance().Q_NAME.getFullyQualifiedName();
		final String G_YEAR = XML_PrimitiveTypes.getInstance().G_YEAR.getFullyQualifiedName();
		final String LONG_OBJECT = XML_PrimitiveTypes.getInstance().LONG_OBJECT.getFullyQualifiedName();
		final String NMTOKEN = XML_PrimitiveTypes.getInstance().NMTOKEN.getFullyQualifiedName();
		final String TIME = XML_PrimitiveTypes.getInstance().TIME.getFullyQualifiedName();
		final String POSITIVE_INTEGER = XML_PrimitiveTypes.getInstance().POSITIVE_INTEGER.getFullyQualifiedName();
		final String DURATION = XML_PrimitiveTypes.getInstance().DURATION.getFullyQualifiedName();
		final String NON_NEGATIVE_INTEGER = XML_PrimitiveTypes.getInstance().NON_NEGATIVE_INTEGER.getFullyQualifiedName();
		final String G_DAY = XML_PrimitiveTypes.getInstance().G_DAY.getFullyQualifiedName();
		final String NMTOKENS_BASE = XML_PrimitiveTypes.getInstance().NMTOKENS_BASE.getFullyQualifiedName();
		final String G_YEAR_MONTH = XML_PrimitiveTypes.getInstance().G_YEAR_MONTH.getFullyQualifiedName();
		final String IDREFS_BASE = XML_PrimitiveTypes.getInstance().IDREFS_BASE.getFullyQualifiedName();
		final String FLOAT = XML_PrimitiveTypes.getInstance().FLOAT.getFullyQualifiedName();
		final String TOKEN = XML_PrimitiveTypes.getInstance().TOKEN.getFullyQualifiedName();
		final String BOOLEAN = XML_PrimitiveTypes.getInstance().BOOLEAN.getFullyQualifiedName();
		final String NORMALIZED_STRING = XML_PrimitiveTypes.getInstance().NORMALIZED_STRING.getFullyQualifiedName();
		final String NAME = XML_PrimitiveTypes.getInstance().NAME.getFullyQualifiedName();
		final String DOUBLE_OBJECT = XML_PrimitiveTypes.getInstance().DOUBLE_OBJECT.getFullyQualifiedName();
		final String NEGATIVE_INTEGER = XML_PrimitiveTypes.getInstance().NEGATIVE_INTEGER.getFullyQualifiedName();
		final String IDREF = XML_PrimitiveTypes.getInstance().IDREF.getFullyQualifiedName();
		final String UNSIGNED_SHORT = XML_PrimitiveTypes.getInstance().UNSIGNED_SHORT.getFullyQualifiedName();
		final String FLOAT_OBJECT = XML_PrimitiveTypes.getInstance().FLOAT_OBJECT.getFullyQualifiedName();
		final String LANGUAGE = XML_PrimitiveTypes.getInstance().LANGUAGE.getFullyQualifiedName();
		final String INTEGER = XML_PrimitiveTypes.getInstance().INTEGER.getFullyQualifiedName();
	}

	public interface Uri {
		final String PACKAGE = XML_PrimitiveTypes.getInstance().PACKAGE.getUri();
		
		final String NC_NAME = XML_PrimitiveTypes.getInstance().NC_NAME.getUri();
		final String UNSIGNED_SHORT_OBJECT = XML_PrimitiveTypes.getInstance().UNSIGNED_SHORT_OBJECT.getUri();
		final String NOTATION = XML_PrimitiveTypes.getInstance().NOTATION.getUri();
		final String G_MONTH = XML_PrimitiveTypes.getInstance().G_MONTH.getUri();
		final String SHORT = XML_PrimitiveTypes.getInstance().SHORT.getUri();
		final String ENTITIES_BASE = XML_PrimitiveTypes.getInstance().ENTITIES_BASE.getUri();
		final String ANY_SIMPLE_TYPE = XML_PrimitiveTypes.getInstance().ANY_SIMPLE_TYPE.getUri();
		final String SHORT_OBJECT = XML_PrimitiveTypes.getInstance().SHORT_OBJECT.getUri();
		final String DATE = XML_PrimitiveTypes.getInstance().DATE.getUri();
		final String DATE_TIME = XML_PrimitiveTypes.getInstance().DATE_TIME.getUri();
		final String DECIMAL = XML_PrimitiveTypes.getInstance().DECIMAL.getUri();
		final String ID = XML_PrimitiveTypes.getInstance().ID.getUri();
		final String INT = XML_PrimitiveTypes.getInstance().INT.getUri();
		final String UNSIGNED_BYTE = XML_PrimitiveTypes.getInstance().UNSIGNED_BYTE.getUri();
		final String ENTITY = XML_PrimitiveTypes.getInstance().ENTITY.getUri();
		final String BASE64_BINARY = XML_PrimitiveTypes.getInstance().BASE64_BINARY.getUri();
		final String ANY_U_R_I = XML_PrimitiveTypes.getInstance().ANY_U_R_I.getUri();
		final String LONG = XML_PrimitiveTypes.getInstance().LONG.getUri();
		final String IDREFS = XML_PrimitiveTypes.getInstance().IDREFS.getUri();
		final String NON_POSITIVE_INTEGER = XML_PrimitiveTypes.getInstance().NON_POSITIVE_INTEGER.getUri();
		final String BOOLEAN_OBJECT = XML_PrimitiveTypes.getInstance().BOOLEAN_OBJECT.getUri();
		final String BYTE = XML_PrimitiveTypes.getInstance().BYTE.getUri();
		final String UNSIGNED_BYTE_OBJECT = XML_PrimitiveTypes.getInstance().UNSIGNED_BYTE_OBJECT.getUri();
		final String ENTITIES = XML_PrimitiveTypes.getInstance().ENTITIES.getUri();
		final String STRING = XML_PrimitiveTypes.getInstance().STRING.getUri();
		final String HEX_BINARY = XML_PrimitiveTypes.getInstance().HEX_BINARY.getUri();
		final String UNSIGNED_INT_OBJECT = XML_PrimitiveTypes.getInstance().UNSIGNED_INT_OBJECT.getUri();
		final String DOUBLE = XML_PrimitiveTypes.getInstance().DOUBLE.getUri();
		final String G_MONTH_DAY = XML_PrimitiveTypes.getInstance().G_MONTH_DAY.getUri();
		final String NMTOKEN_S = XML_PrimitiveTypes.getInstance().NMTOKEN_S.getUri();
		final String UNSIGNED_INT = XML_PrimitiveTypes.getInstance().UNSIGNED_INT.getUri();
		final String BYTE_OBJECT = XML_PrimitiveTypes.getInstance().BYTE_OBJECT.getUri();
		final String INT_OBJECT = XML_PrimitiveTypes.getInstance().INT_OBJECT.getUri();
		final String UNSIGNED_LONG = XML_PrimitiveTypes.getInstance().UNSIGNED_LONG.getUri();
		final String Q_NAME = XML_PrimitiveTypes.getInstance().Q_NAME.getUri();
		final String G_YEAR = XML_PrimitiveTypes.getInstance().G_YEAR.getUri();
		final String LONG_OBJECT = XML_PrimitiveTypes.getInstance().LONG_OBJECT.getUri();
		final String NMTOKEN = XML_PrimitiveTypes.getInstance().NMTOKEN.getUri();
		final String TIME = XML_PrimitiveTypes.getInstance().TIME.getUri();
		final String POSITIVE_INTEGER = XML_PrimitiveTypes.getInstance().POSITIVE_INTEGER.getUri();
		final String DURATION = XML_PrimitiveTypes.getInstance().DURATION.getUri();
		final String NON_NEGATIVE_INTEGER = XML_PrimitiveTypes.getInstance().NON_NEGATIVE_INTEGER.getUri();
		final String G_DAY = XML_PrimitiveTypes.getInstance().G_DAY.getUri();
		final String NMTOKENS_BASE = XML_PrimitiveTypes.getInstance().NMTOKENS_BASE.getUri();
		final String G_YEAR_MONTH = XML_PrimitiveTypes.getInstance().G_YEAR_MONTH.getUri();
		final String IDREFS_BASE = XML_PrimitiveTypes.getInstance().IDREFS_BASE.getUri();
		final String FLOAT = XML_PrimitiveTypes.getInstance().FLOAT.getUri();
		final String TOKEN = XML_PrimitiveTypes.getInstance().TOKEN.getUri();
		final String BOOLEAN = XML_PrimitiveTypes.getInstance().BOOLEAN.getUri();
		final String NORMALIZED_STRING = XML_PrimitiveTypes.getInstance().NORMALIZED_STRING.getUri();
		final String NAME = XML_PrimitiveTypes.getInstance().NAME.getUri();
		final String DOUBLE_OBJECT = XML_PrimitiveTypes.getInstance().DOUBLE_OBJECT.getUri();
		final String NEGATIVE_INTEGER = XML_PrimitiveTypes.getInstance().NEGATIVE_INTEGER.getUri();
		final String IDREF = XML_PrimitiveTypes.getInstance().IDREF.getUri();
		final String UNSIGNED_SHORT = XML_PrimitiveTypes.getInstance().UNSIGNED_SHORT.getUri();
		final String FLOAT_OBJECT = XML_PrimitiveTypes.getInstance().FLOAT_OBJECT.getUri();
		final String LANGUAGE = XML_PrimitiveTypes.getInstance().LANGUAGE.getUri();
		final String INTEGER = XML_PrimitiveTypes.getInstance().INTEGER.getUri();
	}

	public final SupersedeDSLModelElement<PrimitiveType> NC_NAME;
	public final SupersedeDSLModelElement<PrimitiveType> UNSIGNED_SHORT_OBJECT;
	public final SupersedeDSLModelElement<PrimitiveType> NOTATION;
	public final SupersedeDSLModelElement<PrimitiveType> G_MONTH;
	public final SupersedeDSLModelElement<PrimitiveType> SHORT;
	public final SupersedeDSLModelElement<PrimitiveType> ENTITIES_BASE;
	public final SupersedeDSLModelElement<PrimitiveType> ANY_SIMPLE_TYPE;
	public final SupersedeDSLModelElement<PrimitiveType> SHORT_OBJECT;
	public final SupersedeDSLModelElement<PrimitiveType> DATE;
	public final SupersedeDSLModelElement<PrimitiveType> DATE_TIME;
	public final SupersedeDSLModelElement<PrimitiveType> DECIMAL;
	public final SupersedeDSLModelElement<PrimitiveType> ID;
	public final SupersedeDSLModelElement<PrimitiveType> INT;
	public final SupersedeDSLModelElement<PrimitiveType> UNSIGNED_BYTE;
	public final SupersedeDSLModelElement<PrimitiveType> ENTITY;
	public final SupersedeDSLModelElement<PrimitiveType> BASE64_BINARY;
	public final SupersedeDSLModelElement<PrimitiveType> ANY_U_R_I;
	public final SupersedeDSLModelElement<PrimitiveType> LONG;
	public final SupersedeDSLModelElement<PrimitiveType> IDREFS;
	public final SupersedeDSLModelElement<PrimitiveType> NON_POSITIVE_INTEGER;
	public final SupersedeDSLModelElement<PrimitiveType> BOOLEAN_OBJECT;
	public final SupersedeDSLModelElement<PrimitiveType> BYTE;
	public final SupersedeDSLModelElement<PrimitiveType> UNSIGNED_BYTE_OBJECT;
	public final SupersedeDSLModelElement<PrimitiveType> ENTITIES;
	public final SupersedeDSLModelElement<PrimitiveType> STRING;
	public final SupersedeDSLModelElement<PrimitiveType> HEX_BINARY;
	public final SupersedeDSLModelElement<PrimitiveType> UNSIGNED_INT_OBJECT;
	public final SupersedeDSLModelElement<PrimitiveType> DOUBLE;
	public final SupersedeDSLModelElement<PrimitiveType> G_MONTH_DAY;
	public final SupersedeDSLModelElement<PrimitiveType> NMTOKEN_S;
	public final SupersedeDSLModelElement<PrimitiveType> UNSIGNED_INT;
	public final SupersedeDSLModelElement<PrimitiveType> BYTE_OBJECT;
	public final SupersedeDSLModelElement<PrimitiveType> INT_OBJECT;
	public final SupersedeDSLModelElement<PrimitiveType> UNSIGNED_LONG;
	public final SupersedeDSLModelElement<PrimitiveType> Q_NAME;
	public final SupersedeDSLModelElement<PrimitiveType> G_YEAR;
	public final SupersedeDSLModelElement<PrimitiveType> LONG_OBJECT;
	public final SupersedeDSLModelElement<PrimitiveType> NMTOKEN;
	public final SupersedeDSLModelElement<PrimitiveType> TIME;
	public final SupersedeDSLModelElement<PrimitiveType> POSITIVE_INTEGER;
	public final SupersedeDSLModelElement<PrimitiveType> DURATION;
	public final SupersedeDSLModelElement<PrimitiveType> NON_NEGATIVE_INTEGER;
	public final SupersedeDSLModelElement<PrimitiveType> G_DAY;
	public final SupersedeDSLModelElement<PrimitiveType> NMTOKENS_BASE;
	public final SupersedeDSLModelElement<PrimitiveType> G_YEAR_MONTH;
	public final SupersedeDSLModelElement<PrimitiveType> IDREFS_BASE;
	public final SupersedeDSLModelElement<PrimitiveType> FLOAT;
	public final SupersedeDSLModelElement<PrimitiveType> TOKEN;
	public final SupersedeDSLModelElement<PrimitiveType> BOOLEAN;
	public final SupersedeDSLModelElement<PrimitiveType> NORMALIZED_STRING;
	public final SupersedeDSLModelElement<PrimitiveType> NAME;
	public final SupersedeDSLModelElement<PrimitiveType> DOUBLE_OBJECT;
	public final SupersedeDSLModelElement<PrimitiveType> NEGATIVE_INTEGER;
	public final SupersedeDSLModelElement<PrimitiveType> IDREF;
	public final SupersedeDSLModelElement<PrimitiveType> UNSIGNED_SHORT;
	public final SupersedeDSLModelElement<PrimitiveType> FLOAT_OBJECT;
	public final SupersedeDSLModelElement<PrimitiveType> LANGUAGE;
	public final SupersedeDSLModelElement<PrimitiveType> INTEGER;

	private static XML_PrimitiveTypes instance;
	
	public static XML_PrimitiveTypes getInstance() {
		if(instance == null)
			instance = new XML_PrimitiveTypes();
		return instance;
	}
	
	protected XML_PrimitiveTypes() {
		super(PACKAGE_URI);

		NC_NAME = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("NCName"));
		UNSIGNED_SHORT_OBJECT = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("UnsignedShortObject"));
		NOTATION = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("NOTATION"));
		G_MONTH = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("GMonth"));
		SHORT = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("Short"));
		ENTITIES_BASE = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("ENTITIESBase"));
		ANY_SIMPLE_TYPE = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("AnySimpleType"));
		SHORT_OBJECT = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("ShortObject"));
		DATE = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("Date"));
		DATE_TIME = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("DateTime"));
		DECIMAL = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("Decimal"));
		ID = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("ID"));
		INT = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("Int"));
		UNSIGNED_BYTE = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("UnsignedByte"));
		ENTITY = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("ENTITY"));
		BASE64_BINARY = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("Base64Binary"));
		ANY_U_R_I = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("AnyURI"));
		LONG = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("Long"));
		IDREFS = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("IDREFS"));
		NON_POSITIVE_INTEGER = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("NonPositiveInteger"));
		BOOLEAN_OBJECT = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("BooleanObject"));
		BYTE = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("Byte"));
		UNSIGNED_BYTE_OBJECT = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("UnsignedByteObject"));
		ENTITIES = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("ENTITIES"));
		STRING = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("String"));
		HEX_BINARY = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("HexBinary"));
		UNSIGNED_INT_OBJECT = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("UnsignedIntObject"));
		DOUBLE = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("Double"));
		G_MONTH_DAY = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("GMonthDay"));
		NMTOKEN_S = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("NMTOKENS"));
		UNSIGNED_INT = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("UnsignedInt"));
		BYTE_OBJECT = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("ByteObject"));
		INT_OBJECT = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("IntObject"));
		UNSIGNED_LONG = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("UnsignedLong"));
		Q_NAME = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("QName"));
		G_YEAR = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("GYear"));
		LONG_OBJECT = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("LongObject"));
		NMTOKEN = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("NMTOKEN"));
		TIME = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("Time"));
		POSITIVE_INTEGER = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("PositiveInteger"));
		DURATION = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("Duration"));
		NON_NEGATIVE_INTEGER = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("NonNegativeInteger"));
		G_DAY = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("GDay"));
		NMTOKENS_BASE = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("NMTOKENSBase"));
		G_YEAR_MONTH = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("GYearMonth"));
		IDREFS_BASE = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("IDREFSBase"));
		FLOAT = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("Float"));
		TOKEN = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("Token"));
		BOOLEAN = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("Boolean"));
		NORMALIZED_STRING = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("NormalizedString"));
		NAME = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("Name"));
		DOUBLE_OBJECT = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("DoubleObject"));
		NEGATIVE_INTEGER = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("NegativeInteger"));
		IDREF = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("IDREF"));
		UNSIGNED_SHORT = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("UnsignedShort"));
		FLOAT_OBJECT = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("FloatObject"));
		LANGUAGE = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("Language"));
		INTEGER = new SupersedeDSLModelElement<PrimitiveType>(getPrimitiveTypeByName("Integer"));
	}
}
