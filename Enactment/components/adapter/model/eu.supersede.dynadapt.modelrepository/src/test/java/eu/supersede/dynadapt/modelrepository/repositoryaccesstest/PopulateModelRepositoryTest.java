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
 * 	
 * Initially developed in the context of SUPERSEDE EU project
 * www.supersede.eu
 *******************************************************************************/
package eu.supersede.dynadapt.modelrepository.repositoryaccesstest;

import java.io.IOException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Profile;
import org.junit.Before;
import org.junit.Test;

import eu.supersede.dynadapt.dsl.aspect.Aspect;
import eu.supersede.dynadapt.featuremodel.fc.FeatureConfigDAO;
import eu.supersede.dynadapt.featuremodel.fc.FeatureConfigLAO;
import eu.supersede.dynadapt.featuremodel.fc.IFeatureConfigLAO;
import eu.supersede.dynadapt.model.ModelManager;
import eu.supersede.dynadapt.modelrepository.repositoryaccess.ModelRepository;
import eu.supersede.integration.api.adaptation.types.AdaptabilityModel;
import eu.supersede.integration.api.adaptation.types.BaseModel;
import eu.supersede.integration.api.adaptation.types.FeatureConfiguration;
import eu.supersede.integration.api.adaptation.types.FeatureModel;
import eu.supersede.integration.api.adaptation.types.IModel;
import eu.supersede.integration.api.adaptation.types.ModelMetadata;
import eu.supersede.integration.api.adaptation.types.ModelSystem;
import eu.supersede.integration.api.adaptation.types.ModelType;
import eu.supersede.integration.api.adaptation.types.PatternModel;
import eu.supersede.integration.api.adaptation.types.ProfileModel;
import eu.supersede.integration.api.adaptation.types.VariantModel;

public class PopulateModelRepositoryTest {

	String repository = "platform:/resource/eu.supersede.dynadapt.adapter/repository/";
	String repositoryRelativePath = "../eu.supersede.dynadapt.adapter/repository";

	Map<String, String> modelsLocation;

	URL url = null;

	ModelRepository mr = null;
	ModelManager mm = null;

	IFeatureConfigLAO fcLAO = null;

	@Before
	public void setUp() throws Exception {
		new StandaloneSetup().setPlatformUri("../");
		modelsLocation = new HashMap<String, String>();
		modelsLocation.put("aspects", "adaptability_models/");
		modelsLocation.put("variants", "models/variants/");
		modelsLocation.put("profiles", "models/profiles/");
		modelsLocation.put("patterns", "patterns/");
		modelsLocation.put("features", "features/models/");

		fcLAO = new FeatureConfigLAO(new FeatureConfigDAO());
		url = getClass().getResource("/");
		mm = new ModelManager(false);
		mr = new ModelRepository(repository, repositoryRelativePath, mm);
		
		//Clean-up repository
		cleanUpRepository();
	}

	private void cleanUpRepository() {
		//Remove all repository models
		mr.cleanUpRepository();
	}

	
	@Test
	public void testPopulateRepository() throws Exception {
		populateRepository();
	}
	
	private void populateRepository() throws Exception {
		//Read repository folder structure
		String userdir = System.getProperty("user.dir");
		Path path = FileSystems.getDefault().getPath(userdir,repositoryRelativePath);
		
		populateModels(path, "models/base", "uml", Model.class, ModelType.BaseModel, BaseModel.class);
		populateModels(path, "models/profiles", "uml", Profile.class, ModelType.ProfileModel, ProfileModel.class);
		populateModels(path, "models/variants", "uml", Model.class, ModelType.VariantModel, VariantModel.class);
		populateModels(path, "features/models", "yafm", cz.zcu.yafmt.model.fm.FeatureModel.class, ModelType.FeatureModel, FeatureModel.class);
		populateModels(path, "features/configurations", "yafc", cz.zcu.yafmt.model.fc.FeatureConfiguration.class, ModelType.FeatureConfiguration, FeatureConfiguration.class);
		populateModels(path, "adaptability_models", "aspect", Aspect.class, ModelType.AdaptabilityModel, AdaptabilityModel.class);
		populateModels(path, "patterns", "vql", org.eclipse.viatra.query.patternlanguage.patternLanguage.PatternModel.class, ModelType.PatternModel, PatternModel.class);
		
	}

//	private void populateBaseModels(Path path, String repositorySubFolder, String extension) throws IOException, Exception {
//		//Store Base Models. Read all models in folder, for each
//		Path baseModelsFolder = Paths.get(path.toString(), repositorySubFolder);
//		Map<Path, BasicFileAttributes> models = getFiles (baseModelsFolder, extension);
//		for (Path file: models.keySet()){
//			//Load Model
//			Model model = mm.loadModel(file.toString(), Model.class);
//			
//			//Create metadata
//			ModelMetadata metadata = createModelMetadata(new BaseModel(), file, models.get(file));
//			
//			//Store model in repository
//			mr.storeBaseModel(model, metadata);
//		}
//	}
	
	private <T extends EObject, S extends IModel> void populateModels(
			Path path, String repositorySubFolder, String fileExtension, Class<T> modelClass, ModelType modelType, Class<S> instanceMetadataType) throws IOException, Exception {
		Path baseModelsFolder = Paths.get(path.toString(), repositorySubFolder);
		Map<Path, BasicFileAttributes> models = getFiles (baseModelsFolder, fileExtension);
		for (Path file: models.keySet()){
			//Load Model
			T model = mm.loadModel(file.toString(), modelClass);
			
			//Create metadata
			S instanceMetadata = instanceMetadataType.newInstance();
			ModelMetadata metadata = createModelMetadata(instanceMetadata, file, models.get(file), fileExtension);
			
			//Store model in repository
			mr.storeModel(model, modelType, metadata);
		}
	}
	
	private <T extends IModel> ModelMetadata createModelMetadata(T instanceMetadata, Path file, BasicFileAttributes attributes, String fileExtension) throws Exception {
		ModelMetadata metadata = new ModelMetadata();
		metadata.setSender("ModelRepositoryInitialization");
		metadata.setTimeStamp(Calendar.getInstance().getTime());
		metadata.setModelInstances(createBaseModelMetadataInstances(instanceMetadata, file, attributes, fileExtension));
		
		return metadata;
	}
	
	private <T extends IModel> List<IModel> createBaseModelMetadataInstances(T metadata, Path file, BasicFileAttributes attributes, String fileExtension) throws Exception {
		List<IModel> modelInstances = new ArrayList<>();
		modelInstances.add(metadata);

		metadata.setValue("name", getFileName(file));
		metadata.setValue("authorId", getAuthorForModel (file));
		Calendar creationDateCalendar = Calendar.getInstance();
		creationDateCalendar.setTimeInMillis(attributes.creationTime().toMillis());
		metadata.setValue("creationDate", creationDateCalendar.getTime());
		Calendar lastModificationCalendar = Calendar.getInstance();
		lastModificationCalendar.setTimeInMillis(attributes.lastModifiedTime().toMillis());
		metadata.setValue ("lastModificationDate", lastModificationCalendar.getTime());
		metadata.setValue ("fileExtension", ModelType.BaseModel.getExtension());
		metadata.setValue ("systemId", getModelSystemForModel(file));
		metadata.setValue ("fileExtension", "." + fileExtension);
		try {
			metadata.setValue ("status", "");
		} catch (Exception e) {
			//Ignored
		}
		
		return modelInstances;
	}

	private String getFileName(Path file) {
		return file.getFileName().getName(file.getFileName().getNameCount()-1).toString();
	}
	
	private String getModelSystemForModel(Path file) {
		// Use heuristic knowledge of file name to set the model system
		if (getFileName(file).toLowerCase().contains("adm")){
			return ModelSystem.Supersede.getId();
		}else if (getFileName(file).toLowerCase().contains("atos") ||
				  getFileName(file).toLowerCase().contains("cms")){
			return ModelSystem.Atos.getId();
		}else if (getFileName(file).toLowerCase().contains("siemens") ||
				  getFileName(file).toLowerCase().contains("basemodel") ||
				  getFileName(file).toLowerCase().contains("composition") ||
				  getFileName(file).toLowerCase().contains("s1")){
			return ModelSystem.Siemens.getId();
		}else if (getFileName(file).toLowerCase().contains("health") ||
			      getFileName(file).toLowerCase().contains("authentication")){
			return ModelSystem.Health.getId();
		}else if (getFileName(file).toLowerCase().contains("monitoring") ||
			 	  getFileName(file).toLowerCase().contains("twitter")){
			return ModelSystem.MonitoringReconfiguration.getId();
		}else{
			return null;
		}
	}

	private String getAuthorForModel(Path file) {
		// Use heuristic knowledge of file name to set the owner
		if (getFileName(file).toLowerCase().contains("adm")){
			return "Supersede";
		}else if (getFileName(file).toLowerCase().contains("atos") ||
				  getFileName(file).toLowerCase().contains("cms")){
			return "Yosu";
		}else if (getFileName(file).toLowerCase().contains("siemens") ||
				  getFileName(file).toLowerCase().contains("basemodel") ||
				  getFileName(file).toLowerCase().contains("composition") ||
				  getFileName(file).toLowerCase().contains("s1")){
			return "Srdjan";
		}else if (getFileName(file).toLowerCase().contains("health") ||
			      getFileName(file).toLowerCase().contains("authentication")){
			return "Yosu";
		}else if (getFileName(file).toLowerCase().contains("monitoring") ||
			 	  getFileName(file).toLowerCase().contains("twitter")){
			return "Edith";
		}else{
			return null;
		}
	}

	private String serializeDate (Date date){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	    return dateFormat.format(date);
	}
	
	private String serializeDate (FileTime time){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	    return dateFormat.format(time.toMillis());
	}

	/**
	 * List files located within path that have extension
	 * @param path
	 * @param extension
	 * @return
	 */
	Map<Path, BasicFileAttributes> getFiles (Path path, final String extension){
		final Map<Path, BasicFileAttributes> files=new HashMap<>();
		try {
		    Files.walkFileTree(path, new SimpleFileVisitor<Path>(){
		     @Override
		     public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		          if(!attrs.isDirectory() && file.getFileName().toString().endsWith(extension)){
		               files.put(file, attrs);
		          }
		          return FileVisitResult.CONTINUE;
		      }
		     });
		 } catch (IOException e) {
		      e.printStackTrace();
		 }
		return files;
	}

}
