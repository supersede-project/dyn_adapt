/*******************************************************************************
 * Copyright (c) 2016 ATOS Spain S.A, Universitat Politécnica de Catalunya (UPC)
 * All rights reserved. Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     Yosu Gorroñogoitia (ATOS) - main development
 *
 * Initially developed in the context of SUPERSEDE EU project www.supersede.eu
 *******************************************************************************/
package eu.supersede.dynadapt.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.viatra.query.patternlanguage.patternLanguage.PatternModel;
import org.junit.Assert;

import com.google.common.base.Optional;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import cz.zcu.yafmt.model.fc.FeatureConfiguration;
import cz.zcu.yafmt.model.fm.FeatureModel;
import eu.supersede.dynadapt.aom.dsl.util.SupersedeDSLResourceSet;
import eu.supersede.dynadapt.dsl.aspect.Aspect;

public class ModelManager implements IModelManager {
	private final static Logger log = LogManager.getLogger(ModelManager.class);
	private SupersedeDSLResourceSet resourceSet = new SupersedeDSLResourceSet();
	private Resource targetModelResource = null;
	private URI targetModelURI = null;
	private Path temp = null;
	private static boolean cache = false;
	private LoadingCache<String, Optional<Model>> modelCache;
	
	private void initCache (){
		//Setting up cache
		if (cache){
			//Model Cache
			modelCache = CacheBuilder.newBuilder()
		            .maximumSize(1000)
		            .expireAfterAccess(24, TimeUnit.HOURS)
		            .recordStats()
		            .build(new CacheLoader<String, Optional<Model>>() {
		                @Override
		                public Optional<Model> load(String modelPath) throws IOException {
		                    Optional<Model> model = getUMLModel(modelPath);
		                    log.debug("Storing model " + modelPath + " in cache");
		                    return model;
		                }
		            });
		}
	}
	
	@Override
	public Model loadUMLModel(String modelPath) {
		Optional<Model> model = null;
		try {
			if (cache){
				model = modelCache.get(modelPath);
			}else{
				model = getUMLModel(modelPath);
			}
		} catch (ExecutionException e) {
			e.printStackTrace();
			return null;
		}
		return model.get();
	}
	
	private Optional<Model> getUMLModel(String modelPath) {
		//TODO Use cache
		Model model = null;
		if (modelPath.startsWith("http")){
			model = resourceSet.loadModel(downloadModel(modelPath), Model.class);
		}else{
			model = resourceSet.loadModel(URI.createURI(modelPath), Model.class);
		}
		return Optional.fromNullable(model);
	}
	
	public ModelManager (boolean createTemporaryFolder) throws IOException {
		//Create Temporary directory to store models downloaded from ModelRepository
		if (createTemporaryFolder)
			temp = createTemporaryDirectory();
		
		//Shutdown hook to clean up temporary folder
		Runtime.getRuntime().addShutdownHook(new Thread() {
		    public void run() {
		        try {
		        	if (temp != null){
						Files.walkFileTree(temp, new SimpleFileVisitor<Path>() { 
				            @Override
				            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
				                throws IOException
				            {
				            	log.debug("deleting temporary file: " + file);
				                Files.delete(file);
				                return FileVisitResult.CONTINUE;
				            }
				        }); 
						log.debug("deleting temporary directory: " + temp);
						Files.deleteIfExists(temp);
		        	}
				} catch (IOException e) {
					e.printStackTrace();
				}
		    }
		});
		
		initCache();
	}
	
	/**
	 * Creates an instance of ModelManager, associated to a target UML base model defined by its path
	 * @param targetModelPath path of the associated target UML base model
	 * @throws Exception
	 */
	public ModelManager () throws Exception{
		this(true);
	}

	/**
	 * Creates an instance of ModelManager, associated to a target UML base model defined by its path
	 * @param targetModelPath path of the associated target UML base model
	 * @throws Exception
	 */
	public ModelManager (String targetModelPath) throws Exception{
		this(true);
		
		this.targetModelURI = URI.createURI(targetModelPath);
		targetModelResource = loadResource(targetModelPath);
		if (targetModelResource == null){
			throw new Exception("Target Model initialization. Target Model " + targetModelPath +" could not be loaded");
		}
	}
	
	//Create a ModelManager from an existing model
	public ModelManager (Model targetModel, URI targetModelURI) throws Exception{
		this(false);
		this.targetModelURI = targetModelURI;
		targetModelResource = this.resourceSet.getResourceSet().createResource(this.targetModelURI);
		targetModelResource.getContents().add (targetModel);
	}
	
	
	public ResourceSet getResourceSet(){
		return (ResourceSet) resourceSet.getResourceSet();
	}
	
	/* (non-Javadoc)
	 * @see eu.supersede.dynadapt.model.IModelManager#getTargetModel()
	 */
	@Override
	public Model getTargetModel (){
		return Model.class.cast(targetModelResource.getContents().get(0));
	}
	
	@Override
	public Resource getTargetModelAsResource(){
		return targetModelResource;
	}
	
	@Override
	public void setTargetModel (Model model){
		//this.targetModelURI = URI.createURI(model.getURI());
		this.targetModelResource = model.eResource();
	}
	
	@Override
	public Aspect loadAspectModel(String aspectPath) {
		//TODO Use cache
//		return resourceSet.loadAspectModel(aspectPath); //Do not use: this approach gives problems with relative paths
		if (aspectPath.startsWith("http")){
			return resourceSet.loadModel(downloadModel(aspectPath), Aspect.class);
		}
		return resourceSet.loadModel(URI.createURI(aspectPath), Aspect.class);
	}
	
	@Override
	public Aspect loadAspectModel(URI uri) {
		//TODO Use cache
//		return resourceSet.loadAspectModel(uri); //Do not use: this approach gives problems with relative paths
		return resourceSet.loadModel(uri, Aspect.class);
	}
	
	
	@Override
	public FeatureConfiguration loadFeatureConfiguration(String fcPath) {
		//TODO Use cache
		if (fcPath.startsWith("http")){
			return resourceSet.loadModel(downloadModel(fcPath), FeatureConfiguration.class);
		}
		return resourceSet.loadModel(URI.createURI(fcPath), FeatureConfiguration.class);
	}
	
	@Override
	public FeatureModel loadFeatureModel(String fmPath) {
		//TODO Use cache
		if (fmPath.startsWith("http")){
			return resourceSet.loadModel(downloadModel(fmPath), FeatureModel.class);
		}
		return resourceSet.loadModel(URI.createURI(fmPath), FeatureModel.class);
	}
	
	@Override
	public <T extends EObject> T loadModel(String path, Class<T> clazz){
		if (path.startsWith("http")){
			return resourceSet.loadModel(downloadModel(path), clazz);
		}
		return resourceSet.loadModel(URI.createURI(path), clazz);
	}
	
	@Override
	public <T extends EObject> T loadModel(URI uri, Class<T> clazz) { 
		Resource resource = null;
		try {
			resource = resourceSet.loadModel(uri);
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
	
	@Override
	public PatternModel loadPatternModel(String patternPath) {
		//TODO Use cache
		if (patternPath.startsWith("http")){
			return resourceSet.loadModel(downloadModel(patternPath), PatternModel.class);
		}
		return resourceSet.loadModel(URI.createURI(patternPath), PatternModel.class);
	}
	
	/* (non-Javadoc)
	 * @see eu.supersede.dynadapt.model.IModelManager#loadProfile(java.lang.String)
	 */
	@Override
	public Profile loadProfile(String profilePath) {
		//TODO Use cache
		Resource resource = resourceSet.loadModel(URI.createURI(profilePath));
		return (Profile) EcoreUtil.getObjectByType(resource.getContents(), UMLPackage.Literals.PROFILE);
	}
	
	/* (non-Javadoc)
	 * @see eu.supersede.dynadapt.model.IModelManager#loadResource(java.lang.String)
	 */
	@Override
	public Resource loadResource(String targetModelPath) {
		//TODO Use cache
		return resourceSet.loadModel(URI.createURI(targetModelPath));
//		return resourceSet.getResource(URI.createURI(targetModelPath), true);
	}
	
	
	/* (non-Javadoc)
	 * @see eu.supersede.dynadapt.model.IModelManager#saveModel(org.eclipse.emf.ecore.resource.Resource, org.eclipse.emf.common.util.URI, java.lang.String)
	 */
	@Override
	public URI saveModel (Resource modelResource, URI outputModelURI, String suffixe) throws IOException{
		FileOutputStream foStream = null;
		if (modelResource != null) {
			try {
				File outputFile = createOutputFile(outputModelURI, suffixe);
				foStream = new FileOutputStream(outputFile);
				modelResource.save(foStream, null);
				return URI.createURI(outputFile.getAbsolutePath());
			} catch (IOException e) {
				throw e;
			} finally {
				if (foStream != null) {
					try {
						foStream.flush();
						foStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		throw new NullPointerException("modelResource is null");
	}

	@Override
	public URI saveModelInTemporaryFolder(Model model, String suffixe) throws IOException {
		if (temp == null){
			temp = createTemporaryDirectory();
		}
		URI uri = createTemporaryURI (model.getName() + suffixe);
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(uri);
		resource.getContents().add(model);
		try {
			resource.save(null); // no save options needed // save(null)=> save(OPTION_SAVE_ONLY_IF_CHANGED)??<-- EXCEPTION!!!!!
		} catch (IOException ioe) {
			throw ioe;
		}
		
		return uri;
	}
	
	/* (non-Javadoc)
	 * @see eu.supersede.dynadapt.model.IModelManager#loadModel(org.eclipse.emf.common.util.URI, java.lang.Class)
	 */

	/* (non-Javadoc)
	 * @see eu.supersede.dynadapt.model.IModelManager#saveTargetModel()
	 */
	@Override
	public URI saveTargetModel () throws IOException{
		return saveModel(getTargetModelAsResource(), getTargetModelURI(), null);
	}

	/* (non-Javadoc)
	 * @see eu.supersede.dynadapt.model.IModelManager#saveTargetModel(java.lang.String)
	 */
	@Override
	public URI saveTargetModel (String suffixe) throws IOException{
		return saveModel(getTargetModelAsResource(), getTargetModelURI(), suffixe);
	}
	
	/**
	 * This method creates a file in the same folder as the input model file to
	 * store the tagged model. The generated file's name is the same as the
	 * input filename followed by a suffix defined in the static field
	 * {@code OUTPUT_FILE_SUFFIX}
	 * 
	 * @return Returns an instance of {@link File} to be used to save the
	 *         results.
	 * @throws IOException
	 */
	private File createOutputFile(URI outputModelURI, String suffixe) throws IOException {
		String inputFileName = outputModelURI.lastSegment();
		String inputFilePath = outputModelURI.path();
		// Find output directory
		String outputDirectory = inputFilePath.substring(0, (inputFilePath.lastIndexOf('/') + 1));
		// Create the output filename
		String outputFileName = inputFileName;
		if (suffixe != null){
			outputFileName = inputFileName.substring(0, inputFileName.lastIndexOf('.')) + suffixe;
		}
		
		File outputFile = new File(outputDirectory + outputFileName);

		if (!outputFile.exists()) {
			outputFile.createNewFile();
		}

		return outputFile;
	}
	
	private Path createTemporaryDirectory() throws IOException{
		String userdir = System.getProperty("user.dir");
		Path path = FileSystems.getDefault().getPath(userdir);
		Path temp = Files.createTempDirectory(path, "");
		Assert.assertNotNull("There was a problem creating a temporary directory", temp);
		return temp;
	}
	
	private URI createTemporaryURI (String surl){
		Path file = Paths.get(temp.toString(), surl);
		String file2="file:///"+file.toString(); //added to fix uri problems for windows C:/ <- c taken as scheme(protecol)
		//return URI.createURI(file.toString());
		return URI.createURI(file2);
	}

	private URI downloadModel (String surl){
		URI uri = null;
		try {
			URL url = new URL (surl);
			InputStream in = url.openStream();
			Assert.assertNotNull(in);
			Path file = Paths.get(temp.toString(), url.getFile().substring(url.getFile().lastIndexOf("/") + 1));
			Files.copy(in, file, StandardCopyOption.REPLACE_EXISTING);
			in.close();
			
			uri = URI.createFileURI(file.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return uri;
	}
	
	/**
	 * returns the URI locator of associated UML target base model
	 * @return
	 */
	private URI getTargetModelURI(){
		return targetModelURI;
	}

}
