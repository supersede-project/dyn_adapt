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

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;
import org.eclipse.viatra.query.patternlanguage.patternLanguage.Pattern;
import org.eclipse.viatra.query.patternlanguage.patternLanguage.PatternModel;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.resource.XtextResourceSet;

import cz.zcu.yafmt.model.fc.util.FeatureConfigurationUtil;
import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.FeatureModel;
import cz.zcu.yafmt.model.fm.util.FeatureModelUtil;
import eu.supersede.dynadapt.dsl.aspect.Aspect;

/**
 * A SupersedeDSLResourceSet is a small wrapper around an 
 * {@link XtextResourceSet}, which registers the necessary {@link EPackage}s,
 * {@link IResourceFactory}s, and {@link IResourceServiceProvider}s to 
 * load and save UML and SUPERSEDE adaptation models,
 * <p/>
 * Note: To refer from one model to another, both must be contained in
 * the same resource set.
 * <p/>
 * Info: Helper methods to find elements in the different models are 
 * provided by {@link SupersedeDSLResourceUtil} class, model elements can be
 * created using the dedicated language factories or the 
 * {@link SupersedeDSLFactory}.
 * 
 * @author Martin Fleck, Jesús Gorroñogoitia
 * @see SupersedeDSLResourceUtil
 * @see SupersedeDSLFactory 
 *
 */
public class SupersedeDSLResourceSet {
	
	static {
		//FeatureModel initialization before creating the resource set in standalone mode
		if(!Platform.isRunning()){
			FeatureModelUtil.hookPackageRegistry();
			FeatureModelUtil.hookResourceFactoryRegistry();
			FeatureConfigurationUtil.hookPackageRegistry();
			FeatureConfigurationUtil.hookResourceFactoryRegistry();
		}
	}
	
	private XtextResourceSet resourceSet; // internal resource set
	
	/**
	 * Creates a new SupersedeDSLResourceSet, that can load and save UML and 
	 * SUPERSEDE adaptation models.
	 * <p/>
	 * Note: To refer from one model to another, both must be contained in
	 * the same resource set.
	 * <p/>
	 * Info: Helper methods to find elements in the different models are 
	 * provided by {@link SupersedeDSLResourceUtil} class, model elements can be
	 * created using the dedicated language factories or the 
	 * {@link SupersedeDSLFactory}.
	 * 
	 * @see SupersedeDSLResourceUtil
	 * @see SupersedeDSLFactory
	 */
	public SupersedeDSLResourceSet() {
		this(new XtextResourceSet());
	}
	
	/**
	 * Creates a new SupersedeDSLResourceSet, that can load and save UML and 
	 * SUPERSEDE DSL models.
	 * <p/>
	 * Note: To refer from one model to another, both must be contained in
	 * the same resource set.
	 * <p/>
	 * Info: Helper methods to find elements in the different models are 
	 * provided by {@link SupersedeDSLResourceUtil} class, model elements can be
	 * created using the dedicated language factories or the 
	 * {@link SupersedeDSLFactory}.
	 * 
	 * @see SupersedeDSLResourceUtil
	 * @see SupersedeDSLFactory
	 */
	public SupersedeDSLResourceSet(XtextResourceSet resourceSet) {
		setResourceSet(resourceSet);
	}
	
	/**
	 * Initializes the resource set with all necessary {@link EPackage}s,
	 * {@link IResourceFactory}s, and {@link IResourceServiceProvider}s to 
	 * load and save UML and SUPERSEDE DSL models.
	 */
	private void initResourceSet() {
		UMLResourcesUtil.init(getResourceSet());
		SupersedeDSLResourceUtil.init(getResourceSet());
	}
	
	/**
	 * Returns the internally used resource set.
	 * 
	 * @return Internal resource set
	 */
	public XtextResourceSet getResourceSet() {
		return resourceSet;
	}

	/**
	 * Sets and initializes the internally used resource set.
	 */
	protected void setResourceSet(XtextResourceSet resourceSet) {
		this.resourceSet = resourceSet;
		initResourceSet();
	}
	
	/**
	 * Loads the UML Package with the given platform resource uriString.
	 * If the uri is not in the platform resource format, it will be converted
	 * using {@link SupersedeDSLResourceUtil#getPlatformResourceURI(String)}.
	 * If the specified resource can not be found or its root is not an 
	 * instance of {@link Package}, null is returned.
	 * 
	 * @param uriString uri of the UML package
	 * @return the referenced UML package or null
	 * 
	 * @see SupersedeDSLResourceUtil#getPlatformResourceURI(String)
	 */
	public org.eclipse.uml2.uml.Package loadUMLPackage(String uriString) {
		return loadUMLPackage(SupersedeDSLResourceUtil.getPlatformResourceURI(uriString));
	}
	
	/**
	 * Loads the UML Package with the given uri. 
	 * If the specified resource can not be found or its root is not an 
	 * instance of {@link Package}, null is returned.
	 * 
	 * @param uri uri of the UML package
	 * @return the referenced UML package or null
	 */
	public org.eclipse.uml2.uml.Package loadUMLPackage(URI uri) {
		return loadModel(uri, org.eclipse.uml2.uml.Package.class);
	}
	
	/**
	 * Loads the UML Profile with the given platform resource uriString.
	 * If the uri is not in the platform resource format, it will be converted
	 * using {@link SupersedeDSLResourceUtil#getPlatformResourceURI(String)}.
	 * If the specified resource can not be found or its root is not an 
	 * instance of {@link Profile}, null is returned.
	 * 
	 * @param uriString uri of the UML profile
	 * @return the referenced UML profile or null
	 * 
	 * @see SupersedeDSLResourceUtil#getPlatformResourceURI(String)
	 */
	public Profile loadUMLProfile(String uriString) {
		return loadUMLProfile(SupersedeDSLResourceUtil.getPlatformResourceURI(uriString));
	}
	
	/**
	 * Loads the UML Profile with the given uri. 
	 * If the specified resource can not be found or its root is not an 
	 * instance of {@link Profile}, null is returned.
	 * 
	 * @param uri uri of the UML profile
	 * @return the referenced UML profile or null
	 */
	public Profile loadUMLProfile(URI uri) {
		return loadModel(uri, Profile.class);
	}
	
	/**
	 * Loads the UML Model with the given platform resource uriString.
	 * If the uri is not in the platform resource format, it will be converted
	 * using {@link SupersedeDSLResourceUtil#getPlatformResourceURI(String)}.
	 * If the specified resource can not be found or its root is not an 
	 * instance of {@link Model}, null is returned.
	 * 
	 * @param uriString uri of the UML model
	 * @return the referenced UML model or null
	 * 
	 * @see SupersedeDSLResourceUtil#getPlatformResourceURI(String)
	 */
	public Model loadUMLModel(String uriString) {
		return loadUMLModel(SupersedeDSLResourceUtil.getPlatformResourceURI(uriString));
	}
	
	/**
	 * Loads the UML Model with the given uri. 
	 * If the specified resource can not be found or its root is not an 
	 * instance of {@link Model}, null is returned.
	 * 
	 * @param uri uri of the UML model
	 * @return the referenced UML model or null
	 */
	public Model loadUMLModel(URI uri) {
		return loadModel(uri, Model.class);
	}
	
	/**
	 * Creates a new model under the given uri, if such a model does not 
	 * already exist. 
	 * 
	 * @param uri uri of the model resource to be created
	 * @param expectedRoot expected root node in case the resource already
	 * exists and needs to be overriden
	 * @param override
	 * @return newly created model or null if the model already exists and 
	 * should not be overriden
	 */
	protected Resource createModelResource(URI uri, Class<?> expectedRoot, boolean override) {
		Resource resource;
		if(getResourceSet().getURIResourceMap().containsKey(uri)) {
			if(!override)
				return null;
			resource = getResourceSet().getResource(uri, false);
			if(!resource.getContents().isEmpty())
				if(!(expectedRoot.isInstance(resource.getContents().get(0))))
					throw new IllegalArgumentException("Resource '" + uri + "' already exists, but does not contain a MeasurementModel.");
				else
					resource.getContents().clear();				
		} else {
			resource = getResourceSet().createResource(uri);
			if(resource == null)
				throw new IllegalArgumentException("Resource '" + uri + "' can not be created.");
		}
		return resource;
	}
	
	/**
	 * Loads the Aspect Model with the given platform resource uriString.
	 * If the uri is not in the platform resource format, it will be converted
	 * using {@link SupersedeDSLResourceUtil#getPlatformResourceURI(String)}.
	 * If the specified resource can not be found or its root is not an 
	 * instance of {@link Aspect}, null is returned.
	 * 
	 * @param uriString uri of the aspect model
	 * @return the referenced aspect model or null
	 * 
	 * @see SupersedeDSLResourceUtil#getPlatformResourceURI(String)
	 */
	public Aspect loadAspectModel(String uriString) {
		return loadAspectModel(SupersedeDSLResourceUtil.getPlatformResourceURI(uriString));
	}
	
	/**
	 * Loads the aspect Model with the given uri. 
	 * If the specified resource can not be found or its root is not an 
	 * instance of {@link Aspect}, null is returned.
	 * 
	 * @param uri uri of the aspect model
	 * @return the referenced aspect model or null
	 */
	public Aspect loadAspectModel(URI uri) {
		return loadModel(uri, Aspect.class);
	}
	
	public PatternModel loadPatternModel(URI uri) {
		return loadModel(uri, PatternModel.class);
	}
	
	public FeatureModel loadFeatureModel(URI uri) {
		return loadModel(uri, FeatureModel.class);
	}
	
	/**
	 * Creates a new aspect model. Please note, that the name of the
	 * newly created model is empty and needs to be set by the caller
	 * of this method.
	 * 
	 * @param uri uri of the aspect model to be created
	 * @param override if true, the aspect model previously stored at
	 * the given uri will be overriden
	 * @return newly created aspect model
	 */
	public Aspect createGoalModel(URI uri, boolean override)  {
		Resource resource = createModelResource(uri, Aspect.class, override);
		Aspect root = SupersedeDSLFactory.createAspectModel("");
		resource.getContents().add(root);
		return root;
	}
	
	/**
	 * Loads the aspect model with the given uri. 
	 * If the specified resource can not be found or its root is not an 
	 * instance of {@link EvaluationStrategyCatalogue}, null is returned.
	 * 
	 * @param uri uri of the aspect model
	 * @return the referenced aspect model or null
	 */
	public Aspect loadAspectModel(String uriString, boolean createIfNecessary) {
		return loadAspectModel(SupersedeDSLResourceUtil.getPlatformResourceURI(uriString), createIfNecessary);
	}
	
	/**
	 * Loads the aspect model with the given uri. 
	 * If the specified resource can not be found or its root is not an 
	 * instance of {@link Aspect}, null is returned.
	 * 
	 * @param uri uri of the aspect model
	 * @return the referenced aspect model or null
	 */
	public Aspect loadAspectModel(URI uri, boolean createIfNecessary) {
		Aspect aspectModel = null;
		try {
			aspectModel = loadModel(uri, Aspect.class);
		} catch(Exception e) {
			if(!createIfNecessary) 
				throw e;
		}
		
		if(aspectModel == null && createIfNecessary) 
			return createGoalModel(uri, true);
		
		return aspectModel;
	}

	/**
	 * Loads the model with the given platform resource
	 * uriString.
	 * If the uri is not in the platform resource format, it will be converted
	 * using {@link SupersedeDSLResourceUtil#getPlatformResourceURI(String)}.
	 * If the specified resource can not be found, null is returned.
	 * 
	 * @param uriString uri of the SUPERSEDE DSL evaluation
	 * @return the referenced model
	 * 
	 * @see SupersedeDSLResourceUtil#getPlatformResourceURI(String)
	 */
	public Resource loadModel(String uriString) {
		return loadModel(SupersedeDSLResourceUtil.getPlatformResourceURI(uriString));
	}
	
	/**
	 * Loads the model resource with the given uri into this resource set. If
	 * no such resource is found, null is returned.
	 * 
	 * @param uri uri of the model to be loaded
	 * @return model resource with the given uri or null.
	 */
	public Resource loadModel(URI uri) {
		Resource resource;
		try {
			resource = getResourceSet().getResource(uri, true);
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		if(resource != null)
			EcoreUtil.resolveAll(getResourceSet());
		return resource;
	}

	/**
	 * Loads the model resource with the given uri into this resource set. If
	 * no such resource is found or the root object is not an instance of the
	 * given class, null is returned.
	 * 
	 * @param uri uri of the model to be loaded
	 * @param clazz class the model resource should have
	 * @return model resource with the given uri or null.
	 */
	public <T extends EObject> T loadModel(URI uri, Class<T> clazz) {
		Resource resource = null;
		try {
			resource = loadModel(uri);
			if(resource == null)
				return null;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
			
		if(resource == null || resource.getContents().isEmpty())
			return null;
	
		EObject root = resource.getContents().get(0);
		try {
			return clazz.cast(root);
		} catch(ClassCastException e) {
			return null;
		}
	}
	
	/**
	 * Saves the given object under the given uri. 
	 * The given uriString will be converted into an uri using
	 * {@link URI#createURI(String)}.
	 * Any resource produced and any exception thrown during this 
	 * operation is recorded into the returned {@link SaveResult}.
	 * 
	 * @param root object to be saved
	 * @param uriString uri under which the object should be saved
	 * @return SaveResult containing any created resources or exceptions thrown
	 * 
	 * @see ResourceSet#createResource(URI)
	 * @see Resource#save(java.util.Map)
	 */
	public SaveResult saveModel(EObject root, String uriString) {
		return saveModel(root, URI.createURI(uriString));
	}
	
	/**
	 * Saves the given object under the given uri considering the specified 
	 * options. The given uriString will be converted into an uri using
	 * {@link URI#createURI(String)}.
	 * Any resource produced and any exception thrown during this 
	 * operation is recorded into the returned {@link SaveResult}.
	 * <p/>
	 * Note: {@link SaveOptions#newBuilder()} provides a convenient way to
	 * create {@link SaveOptions}.
	 * 
	 * @param root object to be saved
	 * @param uriString uri under which the object should be saved
	 * @param saveOptions options to be considered
	 * @return SaveResult containing any created resources or exceptions thrown
	 * 
	 * @see ResourceSet#createResource(URI)
	 * @see Resource#save(java.util.Map)
	 */
	public SaveResult saveModel(EObject root, String uriString, SaveOptions saveOptions) {
		return saveModel(root, URI.createURI(uriString), saveOptions);
	}
	
	/**
	 * Saves the given object under the given uri. 
	 * Any resource produced and any exception thrown during this 
	 * operation is recorded into the returned {@link SaveResult}.
	 * 
	 * @param root object to be saved
	 * @param uri uri under which the object should be saved
	 * @return SaveResult containing any created resources or exceptions thrown
	 * 
	 * @see ResourceSet#createResource(URI)
	 * @see Resource#save(java.util.Map)
	 */
	public SaveResult saveModel(EObject root, URI uri) {
		return saveModel(root, uri, SaveOptions.newBuilder().format().getOptions());
	}
	
	/**
	 * Saves the given object under the given uri considering the specified 
	 * options. Any resource produced and any exception thrown during this 
	 * operation is recorded into the returned {@link SaveResult}.
	 * <p/>
	 * Note: {@link SaveOptions#newBuilder()} provides a convenient way to
	 * create {@link SaveOptions}.
	 * 
	 * @param root object to be saved
	 * @param uri uri under which the object should be saved
	 * @param saveOptions options to be considered
	 * @return SaveResult containing any created resources or exceptions thrown
	 * 
	 * @see ResourceSet#createResource(URI)
	 * @see Resource#save(java.util.Map)
	 */
	public SaveResult saveModel(EObject root, URI uri, SaveOptions saveOptions) {
		Resource resource = null;
		Exception exception = null;		
        try {
        	if(root == null)
    			throw new IllegalArgumentException("No root element specified.");
    		
    		// no need to create a new resource, if uri is the same
    		if(root.eResource() != null && root.eResource().getURI().equals(uri))
    			try {
    				root.eResource().save(saveOptions.toOptionsMap());
    				return new SaveResult(root.eResource(), null);
    			} catch (IOException e) {
    				return new SaveResult(root.eResource(), e);
    			}
    		
    		EcoreUtil.resolveAll(root);
    		
    		try {
    			resource = getResourceSet().getResource(uri, false);
    		} catch(Exception e) {
    			System.err.println(e.getMessage()); // resource does not exist
    		}
    		if(resource == null)
    			resource = getResourceSet().createResource(uri);
    		
    		if(resource == null)
    			return null;
    		
    		resource.getContents().add(root);
    		EcoreUtil.resolveAll(resource);
    		
    		EcoreUtil.resolveAll(getResourceSet());
            
			resource.save(saveOptions.toOptionsMap());
		} catch (Exception e) {
			exception = e; 
			System.err.println(e);
		}
        return new SaveResult(resource, exception);
	}
	
	
	/**
	 * A SaveResult contains the information produced when saving a 
	 * {@link Resource} into a {@link ResourceSet}. If the saving was
	 * successful, a resource should have been produced. Any exception
	 * thrown during the save operation is also recorded.
	 * 
	 * @author Martin Fleck
	 *
	 */
	public class SaveResult {
		private Resource resource;
		private Exception exception;

		public SaveResult(Resource resource, Exception exception) {
			this.resource = resource;
			this.exception = exception;
		}

		/**
		 * {@link Resource} produced by the save operation.
		 * @return resource produced by the save operation
		 */
		public Resource getResource() {
			return resource;
		}

		/**
		 * {@link Exception} thrown by the save operation.
		 * @return exception thrown by the save operation
		 */
		public Exception getException() {
			return exception;
		}
		
		/**
		 * True if an exception has been thrown during the save operation,
		 * false otherwise.
		 * 
		 * @return true if an exception has been thrown during the save 
		 * operation, false otherwise
		 */
		public boolean hasException() {
			return exception != null;
		}
		
		/**
		 * True if a resource has been produced during the save operation,
		 * false otherwise.
		 * 
		 * @return true if a resource has been produced during the save 
		 * operation, false otherwise.
		 */
		public boolean hasResource() {
			return resource != null;
		}
		
		/**
		 * If no exception has been thrown, the save operation is considered
		 * successful.
		 * 
		 * @return true if no exception has been thrown, false otherwise
		 */
		public boolean isSuccess() {
			return !hasException();
		}
		
		/**
		 * Throws the recorded exception if there is one.
		 * 
		 * @return this {@link SaveResult}
		 * @throws Exception recorded exception
		 */
		public SaveResult throwException() throws Exception {
			if(hasException())
				throw exception;
			return this;
		}
		
		/**
		 * Prints the stack trace of the recorded exception if there is one.
		 * 
		 * @return this {@link SaveResult}
		 */
		public SaveResult printStackTrace() {
			if(hasException())
				exception.printStackTrace();
			return this;
		}
		
		/**
		 * Returns the message of the recorded exception if there is one, 
		 * otherwise an empty string is returned.
		 * 
		 * @return message of the exception or empty string
		 */
		public String getExceptionMessage() {
			if(hasException())
				return exception.getMessage();
			return "";
		}
		
		/**
		 * Returns the path to the locally accessible file of the produced 
		 * resource if there is one, otherwise an empty string is returned.
		 * 
		 * @return path to locally accessible resource file or empty string
		 */
		public String getResourceFileString() {
			if(hasResource())
				return getResource().getURI().toFileString();
			return "";
		}
		
		/**
		 * Validates the semantic of the produced resource. This method calls
		 * {@link SupersedeDSLResourceUtil#validateSemantic(Resource)}.
		 * 
		 * @return information about the validation
		 */
//		public DiagnosticInfo validateSemantic() {
//			return SupersedeDSLResourceUtil.validateSemantic(getResource());
//		}
		
		@Override
		public String toString() {
			String txt = "";
			if(hasResource()) 
				txt += "Resource '" + getResourceFileString() + "' has been saved. ";
			if(hasException()) {
				txt += "While saving '" + getResourceFileString() + "' the following exception occured:\n";
				txt += getExceptionMessage();
			}
			if(!hasResource() && !hasException())
				txt += "No resource and no exception specified in SaveResult.";
			return txt;
		}
	}
}
