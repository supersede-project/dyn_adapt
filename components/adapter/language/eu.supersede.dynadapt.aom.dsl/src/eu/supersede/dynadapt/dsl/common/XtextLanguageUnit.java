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
package eu.supersede.dynadapt.dsl.common;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.mwe.utils.Mapping;
import org.eclipse.uml2.uml.resource.UMLResource;

/**
 * A XtextLanguageUnit encapsulates all necessary information to use one 
 * language in another language. This may include the Namespace URI, the
 * URI mappings, the generated EPackage and the GenModelFile.
 * <p/>
 * This class provides some static instances for the more often used
 * languages.
 * 
 * @author Martin Fleck
 *
 */
public class XtextLanguageUnit {
	
	/**
	 * Viatra Query pattern language unit containing the Namespace URI, the URI 
	 * mappings, the generated EPackages and the GenModelFiles.
	 */
	protected static XtextLanguageUnit PATTERN_UNIT = new XtextLanguageUnit();
	static {
		PATTERN_UNIT = new XtextLanguageUnit();
		PATTERN_UNIT.addNsUri("http://www.eclipse.org/viatra/query/patternlanguage/PatternLanguage");
		
		PATTERN_UNIT.addUriMapping(
				"platform:/plugin/org.eclipse.viatra.query.patternlanguage/model/generated/PatternLanguage.ecore", 
				"platform:/resource/org.eclipse.viatra.query.patternlanguage/model/generated/PatternLanguage.ecore");
		PATTERN_UNIT.addUriMapping(
				"platform:/plugin/org.eclipse.viatra.query.patternlanguage/model/generated/PatternLanguage.genmodel",
				"platform:/resource/org.eclipse.viatra.query.patternlanguage/model/generated/PatternLanguage.genmodel");
		
		
		PATTERN_UNIT.addGeneratedEPackage("org.eclipse.viatra.query.patternlanguage.patternLanguage.PatternLanguagePackage");

		PATTERN_UNIT.addGenModelFile("platform:/resource/org.eclipse.viatra.query.patternlanguage/model/generated/PatternLanguage.genmodel");
	}
	
	/**
	 * YAMFT Feature language unit containing the Namespace URI, the URI 
	 * mappings, the generated EPackages and the GenModelFiles.
	 */
	protected static XtextLanguageUnit FEATURE_UNIT = new XtextLanguageUnit();
	static {
		FEATURE_UNIT = new XtextLanguageUnit();
		FEATURE_UNIT.addNsUri("http://zcu.cz/yafmt/model/fm");
		
		FEATURE_UNIT.addUriMapping(
				"platform:/plugin/cz.zcu.yafmt.model/model/FeatureModel.ecore", 
				"platform:/resource/cz.zcu.yafmt.model/model/FeatureModel.ecore");
		FEATURE_UNIT.addUriMapping(
				"platform:/plugin/cz.zcu.yafmt.model/model/FeatureModel.genmodel",
				"platform:/resource/cz.zcu.yafmt.model/model/FeatureModel.genmodel");
		
		
		FEATURE_UNIT.addGeneratedEPackage("cz.zcu.yafmt.model.fm.FeatureModelPackage");

		FEATURE_UNIT.addGenModelFile("platform:/resource/cz.zcu.yafmt.model/model/FeatureModel.genmodel");
	}
	
	
	/**
	 * Ecore Unit containing the Namespace URI, the URI mappings, the generated
	 * EPackages and the GenModelFiles.
	 */
	protected static XtextLanguageUnit ECORE_UNIT = new XtextLanguageUnit();
	static {
		ECORE_UNIT = new XtextLanguageUnit();
		ECORE_UNIT.addNsUri("http://www.eclipse.org/emf/2002/Ecore");
		
		ECORE_UNIT.addUriMapping(
				"platform:/plugin/org.eclipse.emf.ecore/model/Ecore.ecore", 
				"platform:/resource/org.eclipse.emf.ecore/model/Ecore.ecore");
		ECORE_UNIT.addUriMapping(
				"platform:/plugin/org.eclipse.uml2.uml/model/Ecore.uml",
				"platform:/resource/org.eclipse.uml2.uml/model/Ecore.uml");
		ECORE_UNIT.addUriMapping(
				"platform:/plugin/org.eclipse.emf.codegen.ecore/model/GenModel.genmodel",
				"platform:/resource/org.eclipse.emf.codegen.ecore/model/GenModel.genmodel");
		ECORE_UNIT.addUriMapping(
				"platform:/plugin/org.eclipse.emf.ecore/model/Ecore.genmodel",
				"platform:/resource/org.eclipse.emf.ecore/model/Ecore.genmodel");
		
		ECORE_UNIT.addGeneratedEPackage("org.eclipse.emf.ecore.EcorePackage");
		ECORE_UNIT.addGeneratedEPackage("org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage");

		ECORE_UNIT.addGenModelFile("platform:/resource/org.eclipse.emf.ecore/model/Ecore.genmodel");
		ECORE_UNIT.addGenModelFile("platform:/resource/org.eclipse.emf.codegen.ecore/model/GenModel.genmodel");
//		
//		ECORE_UNIT.addUri(UMLResource.ECORE_METAMODEL_URI);
//		ECORE_UNIT.addUri(UMLResource.ECORE_PROFILE_URI);
	}
	
	/**
	 * Ecore Primitive Types Library unit containing the library URI.
	 */
	protected static XtextLanguageUnit ECORE_TYPES_UNIT = new XtextLanguageUnit();
	static {
		ECORE_TYPES_UNIT = new XtextLanguageUnit();
		ECORE_TYPES_UNIT.addUri(UMLResource.ECORE_PRIMITIVE_TYPES_LIBRARY_URI);
	}
	
	/**
	 * UML Unit containing the Namespace URI, the URI mappings, the generated
	 * EPackages and the GenModelFiles.
	 */
	protected static XtextLanguageUnit UML_UNIT = new XtextLanguageUnit();
	static {
		UML_UNIT = new XtextLanguageUnit();
		UML_UNIT.addNsUri("http://www.eclipse.org/uml2/5.0.0/UML");
		
		UML_UNIT.addUriMapping(
				"platform:/plugin/org.eclipse.uml2.uml/model/UML.ecore",
				"platform:/resource/org.eclipse.uml2.uml/model/UML.ecore");
		UML_UNIT.addUriMapping(
				"platform:/plugin/org.eclipse.uml2.uml/model/UML30.ecore",
				"platform:/resource/org.eclipse.uml2.uml/model/UML.ecore");
		UML_UNIT.addUriMapping(
				"platform:/plugin/org.eclipse.uml2.uml/model/UML.uml",
				"platform:/resource/org.eclipse.uml2.uml/model/UML.uml");
		UML_UNIT.addUriMapping(
				"platform:/plugin/org.eclipse.uml2.uml/model/UML.genmodel",
				"platform:/resource/org.eclipse.uml2.uml/model/UML.genmodel");
		UML_UNIT.addUriMapping(
				"platform:/plugin/org.eclipse.uml2.codegen.ecore/model/GenModel.genmodel",
				"platform:/resource/org.eclipse.uml2.codegen.ecore/model/GenModel.genmodel");
		UML_UNIT.addUriMapping(
				"platform:/plugin/org.eclipse.uml2.codegen.ecore/model/GenModel.ecore",
				"platform:/resource/org.eclipse.uml2.codegen.ecore/model/GenModel.ecore");
		
		UML_UNIT.addGeneratedEPackage("org.eclipse.uml2.uml.UMLPackage");
		UML_UNIT.addGeneratedEPackage("org.eclipse.uml2.codegen.ecore.genmodel.GenModelPackage");

		UML_UNIT.addGenModelFile("platform:/resource/org.eclipse.uml2.uml/model/UML.genmodel");
		UML_UNIT.addGenModelFile("platform:/resource/org.eclipse.uml2.codegen.ecore/model/GenModel.genmodel");
		
//		UML_UNIT.addUri(UMLResource.UML_METAMODEL_URI);
//		UML_UNIT.addUri(UMLResource.UML2_PROFILE_URI);
	}
	
	/**
	 * Xtext Unit containing the Namespace URI, the URI mappings, the generated
	 * EPackages and the GenModelFiles.
	 */
	protected static XtextLanguageUnit UML_TYPES_UNIT = new XtextLanguageUnit();
	static {
		UML_TYPES_UNIT = new XtextLanguageUnit();
//		UML_TYPES_UNIT.addNsUri("http://www.eclipse.org/emf/2002/Ecore");
//		
		UML_TYPES_UNIT.addUriMapping(
				"platform:/plugin/org.eclipse.uml2.types/model/Types.ecore",
				"platform:/resource/org.eclipse.uml2.types/model/Types.ecore");
		UML_TYPES_UNIT.addUriMapping(
				"platform:/plugin/org.eclipse.uml2.types/model/Types.uml",
				"platform:/resource/org.eclipse.uml2.types/model/Types.uml");
		UML_TYPES_UNIT.addUriMapping(
				"platform:/plugin/org.eclipse.uml2.types/model/Types.genmodel",
				"platform:/resource/org.eclipse.uml2.types/model/Types.genmodel");
		
		UML_TYPES_UNIT.addGeneratedEPackage("org.eclipse.uml2.types.TypesPackage");
		UML_TYPES_UNIT.addGenModelFile("platform:/resource/org.eclipse.uml2.types/model/Types.genmodel");
//		UML_TYPES_UNIT.addUri(UMLResource.UML_PRIMITIVE_TYPES_LIBRARY_URI);
	}
	
	/**
	 * Xbase Language Unit containing the generated EPackage and the GenModelFile.
	 */
	protected static XtextLanguageUnit XBASE_UNIT = new XtextLanguageUnit();
	static {	
		XBASE_UNIT = new XtextLanguageUnit();
		XBASE_UNIT.addGeneratedEPackage("org.eclipse.xtext.xbase.XbasePackage");
		XBASE_UNIT.addGenModelFile("platform:/resource/org.eclipse.xtext.xbase/model/Xbase.genmodel");
	}

	private List<String> nsUris = new ArrayList<String>();
	private List<URI> uris = new ArrayList<URI>();
	private List<Mapping> uriMappings = new ArrayList<Mapping>();
	private List<String> generatedEPackages = new ArrayList<String>();
	private List<String> genModelFiles = new ArrayList<String>();
	
	public XtextLanguageUnit() {
	}
	
	public XtextLanguageUnit(XtextLanguageUnit unit) {
		this.nsUris.addAll(unit.getNsUris());
		this.uris.addAll(unit.getUris());
		this.uriMappings.addAll(unit.getUriMappings());
		this.generatedEPackages.addAll(unit.getGeneratedEPackages());
		this.genModelFiles.addAll(unit.getGenModelFiles());
	}
	
	public List<String> getNsUris() {
		return nsUris;
	}
	
	public List<URI> getUris() {
		return uris;
	}
	
	public List<Mapping> getUriMappings() {
		return uriMappings;
	}
	
	public List<String> getGeneratedEPackages() {
		return generatedEPackages;
	}
	
	public List<String> getGenModelFiles() {
		return genModelFiles;
	}
	
	public void addNsUri(String nsUri) {
		nsUris.add(nsUri);
	}
	
	public void addUri(String uri) {
		addUri(URI.createURI(uri));
	}
	
	public void addUri(URI uri) {
		uris.add(uri);
	}
	
	public void addUriMapping(String from, String to) {
		uriMappings.add(new Mapping(from, to));
	}
	
	public void addUriMapping(Mapping mapping) {
		uriMappings.add(mapping);
	}
	
	public void addGeneratedEPackage(String generatedEPackage) {
		generatedEPackages.add(generatedEPackage);
	}
	
	public void addGenModelFile(String genModelFile) {
		genModelFiles.add(genModelFile);
	}
}
