/*******************************************************************************
 * Copyright (c) 2016 Universitat Politécnica de Catalunya (UPC), ATOS Spain S.A
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
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
 * 	Edith Zavala (UPC) - main development
 * 	Yosu Gorroñogotia (Atos) - main development
 * Initially developed in the context of SUPERSEDE EU project
 * www.supersede.eu
 *******************************************************************************/
package eu.supersede.dynadapt.modelrepository.repositoryaccess;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.viatra.query.patternlanguage.patternLanguage.PatternModel;

import cz.zcu.yafmt.model.fc.FeatureConfiguration;
import cz.zcu.yafmt.model.fm.FeatureModel;
import eu.supersede.dynadapt.aom.dsl.parser.AdaptationParser;
import eu.supersede.dynadapt.aom.dsl.parser.IAdaptationParser;
import eu.supersede.dynadapt.dsl.aspect.Aspect;
import eu.supersede.dynadapt.model.ModelManager;
import eu.supersede.integration.api.adaptation.types.IModel;
import eu.supersede.integration.api.adaptation.types.ModelMetadata;
import eu.supersede.integration.api.adaptation.types.ModelSystem;
import eu.supersede.integration.api.adaptation.types.ModelType;
import eu.supersede.integration.api.adaptation.types.ModelUpdateMetadata;
import eu.supersede.integration.api.adaptation.types.Status;

public class ModelRepository extends GenericModelRepository implements IModelRepository{

	private final static Logger log = LogManager.getLogger(ModelRepository.class);
	
	private URL url;

	public ModelRepository(String repository, String repositoryRelativePath, ModelManager modelManager) throws Exception {
		super(repository, repositoryRelativePath);

		// FIXME To use "repositoryURI" rather than "url"
		String userdir = System.getProperty("user.dir");
		Path path = FileSystems.getDefault().getPath(userdir, this.repositoryRelativePath);
		this.url = new URL (path.toUri().toURL().toString()); //URL regenerated from textual representation, otherwise it does not work.
		this.modelManager = modelManager;
		this.parser = new AdaptationParser(modelManager);
	}
	
	public ModelRepository(String repository, String repositoryRelativePath) throws Exception {
		this(repository, repositoryRelativePath, new ModelManager());
	}
	
	public ModelRepository(String repository, URL url, ModelManager modelManager) throws IOException {
		this.repository = repository;
		this.url = url;
		this.modelManager = modelManager;
		this.parser = new AdaptationParser(modelManager);
	}
	
	public ModelRepository(String repository, URL url) throws Exception {
		this(repository, url, new ModelManager());
	}

	/**
	 * To be modified by specializing classes to have a different temporal folder strategy.
	 * The method should ensure the folder exists and it is valid. 
	 * @param path the temporal folder path
	 * @return the path for the repository's temporary folder
	 * @throws IOException 
	 */
	protected Path getTemporaryDirectory(Path path) throws IOException {
		return createTemporaryDirectory(path, true);
	}
	
	/**
	 * Factory method to allow specializing classes to define the model load strategy.
	 * @param relativePath
	 * @param fileName
	 * @param clazz class of the model root element
	 * @return model root element
	 */
	protected <T extends EObject> T loadModel(String relativePath, String fileName, Class<T> clazz) {
		String path = repository + "/" + relativePath + "/" + fileName;
		
		if (clazz == Profile.class)
			return (T) parser.loadProfileResource(path.toString());
		else if (clazz == Model.class)
			return (T) parser.loadUMLResource(path.toString());
		else if (clazz == PatternModel.class)
			return (T) parser.loadPatternResource(path.toString());
		else if (clazz == FeatureModel.class)
			return (T) parser.loadFeatureModelResource(path.toString());
		else if (clazz == FeatureConfiguration.class)
			return (T) parser.loadFeatureConfigurationResource(path.toString());
		else if (clazz == Aspect.class)
			return (T) parser.loadAspectResource(path.toString());
		else
			return null;
	}
	
	/**
	 * This method returns a list of aspect models linked to an specific
	 * featureSUPERSEDE given the featureSUPERSEDE id and the models' location
	 * required for loading the aspects
	 * 
	 * @param featureSUPERSEDEId,
	 *            modelsLocation
	 */
	public List<Aspect> getAspectModels(String featureSUPERSEDEId, Map<String, String> modelsLocation) {
		List<Aspect> aspects = new ArrayList<Aspect>();

		File[] aspectsFiles = getFiles(modelsLocation.get("aspects"));

		loadModels(modelsLocation);

		if (aspectsFiles != null) {
			for (int i = 0; i < aspectsFiles.length; i++) {
				Aspect a = getAspectModelFromPath(repository + modelsLocation.get("aspects") + aspectsFiles[i].getName());
				if (a.getFeature().getId().equalsIgnoreCase(featureSUPERSEDEId)) {
					aspects.add(a);
				}
			}
		}
		return aspects;
	}
	
//	/**
//	 * TODO Take away the modelsLocation parameter; if we get them from model
//	 * repository this is not requiered.
//	 * @param system
//	 * @param featureSUPERSEDEId
//	 * @param modelsLocation
//	 * @return
//	 */
//	public List<Aspect> getAspectModelsFromRepository(ModelSystem system, String featureId) {
//		List<Aspect> aspects = new ArrayList<Aspect>();
//		
//		log.debug("Loading adaptability models' dependencies from repository...");
//		loadModelsFromRepository (system);
//		
//		log.debug("Adaptability models' dependencies loaded");
//
//		try {
//			AdaptabilityModel modelMetadata = new AdaptabilityModel();
//			modelMetadata.setFeatureId(featureId);
//			modelMetadata.setSystemId(system);
//			
//			log.debug("Loading adaptability models from " + system + " with feature " + featureId + "...");
//			List<Aspect> loadedAspects = getModelsFromMetadata(ModelType.AdaptabilityModel, modelMetadata, Aspect.class);
//			log.debug("Adaptability models loaded");
//			
//			log.debug("Filtering adaptability models referencing feature: " + featureId);
//			for (Aspect aspect: loadedAspects){
//				EcoreUtil.resolveAll(aspect);
//				
//				if (aspect.getFeature().getId().equalsIgnoreCase(featureId)) {
//					aspects.add(aspect);
//				}
//			}
//						
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return aspects;
//	}
	
	/**
	 * This method returns a list of aspect models URIs linked to an specific
	 * featureSUPERSEDE given the featureSUPERSEDE id and the models' location
	 * required for loading the aspects
	 * 
	 * The URIs returned are of the form: platform:/resource/eclipse_project/aspect.aspect
	 * 
	 * @param featureSUPERSEDEId,
	 *            modelsLocation
	 */

	public List<URI> getAspectModelsURIs(String featureSUPERSEDEId, Map<String, String> modelsLocation) {
		List<URI> uris = new ArrayList<URI>();

		File[] aspectsFiles = getFiles(modelsLocation.get("aspects"));

		loadModels(modelsLocation);

		if (aspectsFiles != null) {
			for (int i = 0; i < aspectsFiles.length; i++) {
				String aspectModelPath = repository + modelsLocation.get("aspects") + aspectsFiles[i].getName();
				Aspect a = getAspectModelFromPath(aspectModelPath);
				if (a.getFeature().getId().equalsIgnoreCase(featureSUPERSEDEId)) {
					uris.add(URI.createURI(aspectModelPath));
				}
			}
		}
		return uris;
	}

	private void loadModels(Map<String, String> modelsLocation) {
		IAdaptationParser parser = new AdaptationParser(modelManager);

		File[] variants = getFiles(modelsLocation.get("variants")); //FIXME only uml models should be included
		for (int i = 0; i < variants.length; i++) {
			parser.loadUMLResource(repository + modelsLocation.get("variants") + variants[i].getName());
		}
		
		File[] profiles = getFiles(modelsLocation.get("profiles"));
		for (int i = 0; i < profiles.length; i++) {
			parser.loadProfileResource(repository + modelsLocation.get("profiles") + profiles[i].getName());
		}

		File[] patterns = getFiles(modelsLocation.get("patterns"));
		for (int i = 0; i < patterns.length; i++) {
			parser.loadPatternResource(repository + modelsLocation.get("patterns") + patterns[i].getName());
		}

		File[] features = getFiles(modelsLocation.get("features"));
		for (int i = 0; i < features.length; i++) {
			parser.loadFeatureModelResource(repository + modelsLocation.get("features") + features[i].getName());
		}

	}
	
	
	//Retrieve models from remote repositoy and store them in the local temporal repository
	public void loadModelsFromRepository(ModelSystem system) {
		
		try {
			
			this.getProfilesForSystem(system);
			
			this.getVariantModelsForSystem(system);
						
			this.getPatternModelsForSystem(system);
			
			this.getFeatureModelsForSystem(system);
						
			this.getAspectModelsForSystem(system);
			
		} catch (Exception e) {
			log.error("Error loading adaptability model's dependencies from repository", e);
		}
	}
	
	private Aspect getAspectModelFromPath(String aspectModelPath) {
		return modelManager.loadAspectModel(aspectModelPath);
	}
	
	private File[] getFiles(String folderPath) {
		/*
		 * Models in class path
		 */

		URL uriFolder = null;
		
		try {
			uriFolder = new URL(this.url.toString()+folderPath);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
		
		File folder = null;

		try {
			folder = new File(uriFolder.toURI());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		File[] files = folder.listFiles();
		return files;
	}

	//IModelRepository implementation
	//These methods support specialized (by Model Type) CRUD operations on the Model Repository Manager
	@Override
	public <T extends EObject, S extends IModel> String storeModel(T model, ModelType type, ModelMetadata metadata) throws Exception{
		return super.storeModel(model, type, metadata);
	}
	
	// TODO pass declaration to the interface
	public <T extends EObject, S extends IModel> String storeModel(T model, ModelType type, ModelMetadata metadata, String repository) throws Exception{
		return super.storeModel(model, type, metadata, repository);
	}
	
	@Override
	public String storeBaseModel(Model model, ModelMetadata metadata) throws Exception {
		return storeModel(model, ModelType.BaseModel, metadata);
	}
	
	//TODO promote this method to the interface instead of the above one
	public String storeBaseModel(Model model, ModelMetadata metadata, String repository) throws Exception {
		return storeModel(model, ModelType.BaseModel, metadata, repository);
	}

	@Override
	public Model getBaseModel(String id) throws Exception {
		return getModel(id, ModelType.BaseModel, Model.class);
	}

	@Override
	public void updateBaseModel(Model model, ModelUpdateMetadata metadata, String id) throws Exception {
		updateModel(model, metadata, id, ModelType.BaseModel);
	}

	@Override
	public void deleteBaseModel(String id) throws Exception {
		deleteModel(id, ModelType.BaseModel);
	}

	@Override
	public String storeVariantModel(Model model, ModelMetadata metadata) throws Exception {
		return storeModel(model, ModelType.VariantModel, metadata);
	}

	@Override
	public Model getVariantModel(String id) throws Exception {
		return getModel(id, ModelType.VariantModel, Model.class);
	}

	@Override
	public void updateVariantModel(Model model, ModelUpdateMetadata metadata, String id) throws Exception {
		updateModel(model, metadata, id, ModelType.VariantModel);
	}

	@Override
	public void deleteVariantModel(String id) throws Exception {
		deleteModel(id, ModelType.VariantModel);
	}

	@Override
	public String storeProfileModel(Profile profile, ModelMetadata metadata) throws Exception {
		return storeModel(profile, ModelType.ProfileModel, metadata);
	}

	@Override
	public Profile getProfileModel(String id) throws Exception {
		return getModel(id, ModelType.ProfileModel, Profile.class);
	}

	@Override
	public void updateProfileModel(Profile profile, ModelUpdateMetadata metadata, String id) throws Exception {
		updateModel(profile, metadata, id, ModelType.ProfileModel);
	}

	@Override
	public void deleteProfileModel(String id) throws Exception {
		deleteModel(id, ModelType.ProfileModel);
	}

	@Override
	public String storePatternModel(PatternModel model, ModelMetadata metadata) throws Exception {
		return storeModel(model, ModelType.PatternModel, metadata);
	}

	@Override
	public PatternModel getPatternModel(String id) throws Exception {
		return getModel(id, ModelType.PatternModel, PatternModel.class);
	}

	@Override
	public void updatePatternModel(PatternModel model, ModelUpdateMetadata metadata, String id) throws Exception {
		updateModel(model, metadata, id, ModelType.PatternModel);
	}

	@Override
	public void deletePatternModel(String id) throws Exception {
		deleteModel(id, ModelType.PatternModel);
	}

	@Override
	public String storeFeatureModel(FeatureModel model, ModelMetadata metadata) throws Exception {
		return storeModel(model, ModelType.FeatureModel, metadata);
	}

	@Override
	public FeatureModel getFeatureModel(String id) throws Exception {
		return getModel(id, ModelType.FeatureModel, FeatureModel.class);
	}

	@Override
	public void updateModel(FeatureModel model, ModelUpdateMetadata metadata, String id) throws Exception {
		updateModel(model, metadata, id, ModelType.FeatureModel);
	}

	@Override
	public void deleteFeatureModel(String id) throws Exception {
		deleteModel(id, ModelType.FeatureModel);
	}

	@Override
	public String storeFeatureConfigurationModel(FeatureConfiguration model, ModelMetadata metadata) throws Exception {
		return storeModel(model, ModelType.FeatureConfiguration, metadata);
	}

	@Override
	public FeatureConfiguration getFeatureConfigurationModel(String id) throws Exception {
		return getModel(id, ModelType.FeatureConfiguration, FeatureConfiguration.class);
	}

	@Override
	public void updateFeatureConfigurationModel(FeatureConfiguration model,
			ModelUpdateMetadata metadata, String id) throws Exception {
		updateModel(model, metadata, id, ModelType.FeatureConfiguration);
	}

	@Override
	public void deleteFeatureConfigurationModel(String id) throws Exception {
		deleteModel(id, ModelType.FeatureConfiguration);
	}

	@Override
	public String storeAspectModel(Aspect model, ModelMetadata metadata) throws Exception {
		return storeModel(model, ModelType.AdaptabilityModel, metadata);
	}

	@Override
	public Aspect getAspectModel(String id) throws Exception {
		return getModel(id, ModelType.AdaptabilityModel, Aspect.class);
	}

	@Override
	public void updateAspectModel(Aspect model, ModelUpdateMetadata metadata, String id) throws Exception{
		updateModel(model, metadata, id, ModelType.AdaptabilityModel);
	}

	@Override
	public void deleteAspectModel(String id) throws Exception {
		deleteModel(id, ModelType.AdaptabilityModel);
	}

	//Query Methods
	
	@Override
	public Model getLastEnactedBaseModelForSystem(ModelSystem system) throws Exception {
		return getLatestModelOfTypeForSystemWithStatus (ModelType.BaseModel, system, Status.Enacted, Model.class);
	}
	
	@Override
	public Model getLastBaseModelForSystem(ModelSystem system) throws Exception {
		return getLatestModelOfTypeForSystemWithStatus (ModelType.BaseModel, system, null, Model.class);
	}

	@Override
	public FeatureConfiguration getLastEnactedFeatureConfigurationForSystem(ModelSystem system) throws Exception{
		return getLatestModelOfTypeForSystemWithStatus (ModelType.FeatureConfiguration, system, Status.Enacted, FeatureConfiguration.class);
	}

	@Override
	public FeatureConfiguration getLastComputedFeatureConfigurationForSystem(ModelSystem system) throws Exception{
		return getLatestModelOfTypeForSystemWithStatus (ModelType.FeatureConfiguration, system, Status.Computed, FeatureConfiguration.class);
	}

	@Override
	public List<Aspect> getAspectModelsForSystem(ModelSystem system) throws Exception{
		return getModelsOfTypeForSystemWithStatus (ModelType.AdaptabilityModel, system, null, Aspect.class);
	}

	@Override
	public List<Model> getVariantModelsForSystem(ModelSystem system) throws Exception{
		return getModelsOfTypeForSystemWithStatus (ModelType.VariantModel, system, null, Model.class);
	}

	@Override
	public List<Profile> getProfilesForSystem(ModelSystem system) throws Exception{
		return getModelsOfTypeForSystemWithStatus (ModelType.ProfileModel, system, null, Profile.class);
	}
	
	@Override
	public List<FeatureModel> getFeatureModelsForSystem(ModelSystem system) throws Exception {
		return getModelsOfTypeForSystemWithStatus(ModelType.FeatureModel, system, null, FeatureModel.class);
	}

	@Override
	public List<PatternModel> getPatternModelsForSystem(ModelSystem system) throws Exception{
		return getModelsOfTypeForSystemWithStatus (ModelType.PatternModel, system, null, PatternModel.class);
	}

	@Override
	public void cleanUpRepository() {
		super.cleanUpRepository();
	}

	@Override
	public ModelType getModelType(EObject model) {
		if (model instanceof Model) {
			return ModelType.BaseModel;
		}
		else if (model instanceof Profile) {
			return ModelType.ProfileModel;
		} else if (model instanceof FeatureConfiguration) {
			return ModelType.FeatureConfiguration;
		} else if (model instanceof FeatureModel) {
			return ModelType.FeatureModel;
		} else if (model instanceof PatternModel) {
			return ModelType.PatternModel;
		}
		return null;
	}
}
