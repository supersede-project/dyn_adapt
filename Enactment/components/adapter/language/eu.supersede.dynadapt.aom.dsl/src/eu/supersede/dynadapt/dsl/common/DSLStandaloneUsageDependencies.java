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
package eu.supersede.dynadapt.dsl.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.mwe.utils.Mapping;

/**
 * This class is a single point of configuration for the standalone setup of
 * the SUPERSEDE languages used in modeling workflow files (mwe).
 * <p/>
 * Often used packages and libraries as well as the ARTIST language packages
 * can be simply included by specifying the respective boolean flag.
 * 
 * @author Martin Fleck, Jesús Gorroñogoitia
 * @see DSLStandaloneSetup
 */
public class DSLStandaloneUsageDependencies {
	
	public DSLStandaloneUsageDependencies() {
		ecore = true;
	}
		
	private boolean ecore;
	private boolean ecoreTypes;
	
	private boolean uml;
	private boolean umlTypes;
	
	private boolean pattern;
	
	private boolean feature;
		

	/**
	 * Return true if the {@link XtextLanguageUnit#ECORE_UNIT} unit
	 * is added in this setup, false otherwise.
	 * @return true if the {@link XtextLanguageUnit#ECORE_UNIT} unit
	 * is added in this setup, false otherwise.
	 */
	public boolean isEcore() {
		return ecore;
	}

	/**
	 * Adds/Removes the {@link XtextLanguageUnit#ECORE_UNIT} unit 
	 * to/from this setup.
	 * @param ecore if true, the necessary dependencies will be added.
	 */
	public void setEcore(boolean ecore) {
		this.ecore = ecore;
	}

	/**
	 * Return true if the {@link XtextLanguageUnit#ECORE_TYPES_UNIT} unit
	 * is added in this setup, false otherwise.
	 * @return true if the {@link XtextLanguageUnit#ECORE_TYPES_UNIT} unit
	 * is added in this setup, false otherwise.
	 */
	public boolean isEcoreTypes() {
		return ecoreTypes;
	}

	/**
	 * Adds/Removes the {@link XtextLanguageUnit#ECORE_TYPES_UNIT} unit 
	 * to/from this setup.
	 * @param ecoreTypes if true, the necessary dependencies will be added.
	 */
	public void setEcoreTypes(boolean ecoreTypes) {
		this.ecoreTypes = ecoreTypes;
	}

	/**
	 * Return true if the {@link XtextLanguageUnit#UML_UNIT} unit
	 * is added in this setup, false otherwise.
	 * @return true if the {@link XtextLanguageUnit#UML_UNIT} unit
	 * is added in this setup, false otherwise.
	 */
	public boolean isUml() {
		return uml;
	}

	/**
	 * Adds/Removes the {@link XtextLanguageUnit#UML_UNIT} unit 
	 * to/from this setup.
	 * @param uml if true, the necessary dependencies will be added.
	 */
	public void setUml(boolean uml) {
		this.uml = uml;
	}

	/**
	 * Return true if the {@link XtextLanguageUnit#UML_TYPES_UNIT} unit
	 * is added in this setup, false otherwise.
	 * @return true if the {@link XtextLanguageUnit#UML_TYPES_UNIT} unit
	 * is added in this setup, false otherwise.
	 */
	public boolean isUmlTypes() {
		return umlTypes;
	}

	/**
	 * Adds/Removes the {@link XtextLanguageUnit#UML_TYPES_UNIT} unit 
	 * to/from this setup.
	 * @param umlTypes if true, the necessary dependencies will be added.
	 */
	public void setUmlTypes(boolean umlTypes) {
		this.umlTypes = umlTypes;
	}

	/**
	 * Return true if the {@link XtextLanguageUnit#PATTERN_UNIT} unit
	 * is added in this setup, false otherwise.
	 * @return true if the {@link XtextLanguageUnit#PATTERN_UNIT} unit
	 * is added in this setup, false otherwise.
	 */
	public boolean isPattern() {
		return pattern;
	}

	/**
	 * Adds/Removes the {@link XtextLanguageUnit#PATTERN_UNIT} unit 
	 * to/from this setup.
	 * @param uml if true, the necessary dependencies will be added.
	 */
	public void setPattern(boolean pattern) {
		this.pattern = pattern;
	}

	/**
	 * Return true if the {@link XtextLanguageUnit#FEATURE_UNIT} unit
	 * is added in this setup, false otherwise.
	 * @return true if the {@link XtextLanguageUnit#FEATURE_UNIT} unit
	 * is added in this setup, false otherwise.
	 */
	public boolean isFeature() {
		return feature;
	}

	/**
	 * Adds/Removes the {@link XtextLanguageUnit#FEATURE_UNIT} unit 
	 * to/from this setup.
	 * @param uml if true, the necessary dependencies will be added.
	 */
	public void setFeature(boolean feature) {
		this.feature = feature;
	}
	
	/**
	 * Returns all {@link Mapping}s from the added {@link XtextLanguageUnit}s.
	 * @return all mappings from the added language units.
	 */
	public Collection<Mapping> getMappings() {
		List<Mapping> mappings = new ArrayList<Mapping>();
	
		if(isEcore())
			mappings.addAll(XtextLanguageUnit.ECORE_UNIT.getUriMappings());
		if(isEcoreTypes())
			mappings.addAll(XtextLanguageUnit.ECORE_TYPES_UNIT.getUriMappings());
		if(isUml())
			mappings.addAll(XtextLanguageUnit.UML_UNIT.getUriMappings());
		if(isUmlTypes())
			mappings.addAll(XtextLanguageUnit.UML_TYPES_UNIT.getUriMappings());
		if(isPattern())
			mappings.addAll(XtextLanguageUnit.PATTERN_UNIT.getUriMappings());
		if(isFeature())
			mappings.addAll(XtextLanguageUnit.FEATURE_UNIT.getUriMappings());
		
		return mappings;	
	}
	
	/**
	 * Returns all generated {@link EPackage}s from the added 
	 * {@link XtextLanguageUnit}s.
	 * @return all generated {@link EPackage}s from the added 
	 * {@link XtextLanguageUnit}s.
	 */
	public Collection<String> getGeneratedEPackages() {
		List<String> mappings = new ArrayList<String>();
		
		if(isEcore())
			mappings.addAll(XtextLanguageUnit.ECORE_UNIT.getGeneratedEPackages());
		if(isEcoreTypes())
			mappings.addAll(XtextLanguageUnit.ECORE_TYPES_UNIT.getGeneratedEPackages());
		if(isUml())
			mappings.addAll(XtextLanguageUnit.UML_UNIT.getGeneratedEPackages());
		if(isUmlTypes())
			mappings.addAll(XtextLanguageUnit.UML_TYPES_UNIT.getGeneratedEPackages());
		if(isPattern())
			mappings.addAll(XtextLanguageUnit.PATTERN_UNIT.getGeneratedEPackages());
		if(isFeature())
			mappings.addAll(XtextLanguageUnit.FEATURE_UNIT.getGeneratedEPackages());
		
		return mappings;	
	}
	
	/**
	 * Returns all GenModelFile locations from the added 
	 * {@link XtextLanguageUnit}s.
	 * @return all GenModelFile locations from the added 
	 * {@link XtextLanguageUnit}s.
	 */
	public Collection<String> getGenModelFiles() {
		List<String> mappings = new ArrayList<String>();
		if(isEcore())
			mappings.addAll(XtextLanguageUnit.ECORE_UNIT.getGenModelFiles());
		if(isEcoreTypes())
			mappings.addAll(XtextLanguageUnit.ECORE_TYPES_UNIT.getGenModelFiles());
		if(isUml())
			mappings.addAll(XtextLanguageUnit.UML_UNIT.getGenModelFiles());
		if(isUmlTypes())
			mappings.addAll(XtextLanguageUnit.UML_TYPES_UNIT.getGenModelFiles());
		if(isPattern())
			mappings.addAll(XtextLanguageUnit.PATTERN_UNIT.getGenModelFiles());
		if(isFeature())
			mappings.addAll(XtextLanguageUnit.FEATURE_UNIT.getGenModelFiles());
		
		return mappings;	
	}
}
