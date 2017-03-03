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
import java.io.FilenameFilter;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.uml2.uml.Model;
import org.eclipse.viatra.query.patternlanguage.patternLanguage.PatternModel;

import cz.zcu.yafmt.model.fc.FeatureConfiguration;
import cz.zcu.yafmt.model.fm.FeatureModel;
import eu.supersede.dynadapt.dsl.aspect.Aspect;
import eu.supersede.dynadapt.model.IModelManager;
import eu.supersede.dynadapt.model.ModelManager;
import eu.supersede.integration.api.adaptation.types.ModelMetadata;
import eu.supersede.integration.api.adaptation.types.ModelSystem;
import eu.supersede.integration.api.adaptation.types.ModelType;
import eu.supersede.integration.api.adaptation.types.ModelUpdateMetadata;
import eu.supersede.integration.api.adaptation.types.Status;

public class ModelRepository extends GenericModelRepository implements IModelRepository{

	private String repository;
	private URL url;

	public ModelRepository(String repository, String repositoryRelativePath, ModelManager modelManager) throws Exception {
		super(repositoryRelativePath);
		this.repository = repository;
		String userdir = System.getProperty("user.dir");
		Path path = FileSystems.getDefault().getPath(userdir,repositoryRelativePath);
		this.url = new URL (path.toUri().toURL().toString()); //URL regenerated from textual representation, otherwise it does not work.
		this.modelManager = modelManager;
	}
	
	public ModelRepository(String repository, URL url, ModelManager modelManager) throws MalformedURLException {
		this.repository = repository;
		this.url = url;
		this.modelManager = modelManager;
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

		File[] aspectsFiles = getFiles(modelsLocation.get("aspects"), "aspect");

//		IAdaptationParser ap = loadModels(modelsLocation);
		loadModels(modelsLocation);

		if (aspectsFiles != null) {
			for (int i = 0; i < aspectsFiles.length; i++) {
//				Aspect a = getAspectModel(ap, repository + modelsLocation.get("aspects") + aspectsFiles[i].getName());
				Aspect a = getAspectModelFromPath(repository + modelsLocation.get("aspects") + aspectsFiles[i].getName());
				if (a.getFeature().getId().equalsIgnoreCase(featureSUPERSEDEId)) {
					aspects.add(a);
				}
			}
		}
		return aspects;
	}
	
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

		File[] aspectsFiles = getFiles(modelsLocation.get("aspects"), "aspect");

//		IAdaptationParser ap = loadModels(modelsLocation);
		loadModels(modelsLocation);

		if (aspectsFiles != null) {
			for (int i = 0; i < aspectsFiles.length; i++) {
				String aspectModelPath = repository + modelsLocation.get("aspects") + aspectsFiles[i].getName();
//				Aspect a = getAspectModel(ap, aspectModelPath);
				Aspect a = getAspectModelFromPath(aspectModelPath);
				if (a.getFeature().getId().equalsIgnoreCase(featureSUPERSEDEId)) {
					uris.add(URI.createURI(aspectModelPath));
				}
			}
		}
		return uris;
	}

	private IModelManager loadModels(Map<String, String> modelsLocation) {
//		IAdaptationParser parser = new AdaptationParser(modelManager);

		File[] variants = getFiles(modelsLocation.get("variants"), "uml"); //FIXME only uml models should be included
		for (int i = 0; i < variants.length; i++) {
//			parser.loadUMLResource(repository + modelsLocation.get("variants") + variants[i].getName());
			modelManager.loadUMLModel(repository + modelsLocation.get("variants") + variants[i].getName());
		}

		File[] profiles = getFiles(modelsLocation.get("profiles"), "uml");
		for (int i = 0; i < profiles.length; i++) {
//			parser.loadProfileResource(repository + modelsLocation.get("profiles") + profiles[i].getName());
			modelManager.loadProfile(repository + modelsLocation.get("profiles") + profiles[i].getName());
		}

		File[] patterns = getFiles(modelsLocation.get("patterns"), "vql");
		for (int i = 0; i < patterns.length; i++) {
//			parser.loadPatternResource(repository + modelsLocation.get("patterns") + patterns[i].getName());
			modelManager.loadPatternModel(repository + modelsLocation.get("patterns") + patterns[i].getName());
		}


		File[] features = getFiles(modelsLocation.get("features"), "yafm");
		for (int i = 0; i < features.length; i++) {
//			parser.loadFeatureResource(repository + modelsLocation.get("features") + features[i].getName());
			modelManager.loadFeatureModel(repository + modelsLocation.get("features") + features[i].getName());
		}

		//return parser;
		return modelManager;
	}
	
//	private Aspect getAspectModel(IAdaptationParser parser, String aspectModelPath) {
	private Aspect getAspectModelFromPath(String aspectModelPath) {
//		return parser.parseAdaptationModel(aspectModelPath); //Do not use: this approach gives problems with relative paths
		return modelManager.loadAspectModel(aspectModelPath);
	}
	
	private File[] getFiles(String folderPath, final String extension) {
		/*
		 * Models in class path
		 */
//		URL uriFolder = this.url.getClass().getResource("/" + folderPath);

		URL uriFolder = null;
		
		try {
			uriFolder = new URL(this.url.toString()+folderPath);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
		
		File[] files = null;
		File folder = null;

		try {
			folder = new File(uriFolder.toURI());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		// create new filename filter
        FilenameFilter fileNameFilter = new FilenameFilter() {
  
           @Override
           public boolean accept(File dir, String name) {
              if(name.lastIndexOf('.')>0)
              {
                 // get last index for '.' char
                 int lastIndex = name.lastIndexOf('.');
                 
                 // get extension
                 String str = name.substring(lastIndex);
                 
                 // match path name extension
                 if(str.equals("." + extension))
                 {
                    return true;
                 }
              }
              return false;
           }
        };
        
		return files = folder.listFiles(fileNameFilter);
	}

	//IModelRepository implementation
	//These methods support specialized (by Model Type) CRUD operations on the Model Repository Manager
	
	@Override
	public String storeBaseModel(Model model, ModelMetadata metadata) throws Exception {
		return storeModel(model, ModelType.BaseModel, metadata);
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
	public String storeProfileModel(Model model, ModelMetadata metadata) throws Exception {
		return storeModel(model, ModelType.ProfileModel, metadata);
	}

	@Override
	public Model getProfileModel(String id) throws Exception {
		return getModel(id, ModelType.ProfileModel, Model.class);
	}

	@Override
	public void updateProfileModel(Model model, ModelUpdateMetadata metadata, String id) throws Exception {
		updateModel(model, metadata, id, ModelType.ProfileModel);
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
		return getLatestModelOfTypeForSystemWithStatus (ModelType.FeatureConfiguration, system, Status.ComputedByDM, FeatureConfiguration.class);
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
	public List<Model> getProfilesForSystem(ModelSystem system) throws Exception{
		return getModelsOfTypeForSystemWithStatus (ModelType.ProfileModel, system, null, Model.class);
	}

	@Override
	public List<PatternModel> getPatternModelsForSystem(ModelSystem system) throws Exception{
		return getModelsOfTypeForSystemWithStatus (ModelType.PatternModel, system, null, PatternModel.class);
	}
}
