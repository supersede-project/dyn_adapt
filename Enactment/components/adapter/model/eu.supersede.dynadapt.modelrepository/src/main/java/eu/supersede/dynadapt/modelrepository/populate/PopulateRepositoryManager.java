package eu.supersede.dynadapt.modelrepository.populate;

import java.io.IOException;
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

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;

import eu.supersede.dynadapt.dsl.aspect.Aspect;
import eu.supersede.dynadapt.model.ModelManager;
import eu.supersede.dynadapt.modelrepository.repositoryaccess.ModelRepository;
import eu.supersede.integration.api.adaptation.types.IModel;
import eu.supersede.integration.api.adaptation.types.ModelMetadata;
import eu.supersede.integration.api.adaptation.types.ModelSystem;
import eu.supersede.integration.api.adaptation.types.ModelType;
import eu.supersede.integration.api.adaptation.types.Status;

public class PopulateRepositoryManager {
	private final Logger log = LogManager.getLogger(this.getClass());
	private ModelManager mm;
	private ModelRepository mr;
	
	public PopulateRepositoryManager (ModelManager mm, ModelRepository mr){
		this.mm = mm;
		this.mr = mr;
	}

	public <T extends EObject, S extends IModel> void populateModels(
			Path path, String repositorySubFolder, String fileExtension, Class<T> modelClass, ModelType modelType, Class<S> instanceMetadataType) throws IOException, Exception {
		Path baseModelsFolder = Paths.get(path.toString(), repositorySubFolder);
		Map<Path, BasicFileAttributes> models = getFiles (baseModelsFolder, fileExtension);
		for (Path file: models.keySet()){
			//Load Model
			T model = mm.loadModel(file.toString(), modelClass);
			
			//FIXME get Aspect Feature Id
			HashMap<String,String> customMetadata = new HashMap<>();
			if (modelClass == Aspect.class ) customMetadata.put("featureId", ((Aspect) model).getFeature().getId());
			
			//Create metadata
			S instanceMetadata = instanceMetadataType.newInstance();
			ModelMetadata metadata = createModelMetadata(instanceMetadata, file, models.get(file), fileExtension, repositorySubFolder, modelType, customMetadata);
			
			//Store model in repository
			mr.storeModel(model, modelType, metadata, path.toRealPath().toString());
			
			System.out.println("Stored " + metadata.getModelInstances().get(0).getValue("name") + " model");
		}
	}
	
	public <T extends EObject, S extends IModel> void populateModel(
			Path modelPath, String author, ModelSystem system, Status status, String relativePath, Class<T> modelClass, ModelType modelType, Class<S> instanceMetadataType) throws IOException, Exception {
		
		//Load Model
		T model = mm.loadModel(modelPath.toString(), modelClass);
		
		//FIXME get Aspect Feature Id
		HashMap<String,String> customMetadata = new HashMap<>();
		if (modelClass == Aspect.class) customMetadata.put("featureId", ((Aspect) model).getFeature().getId());
		
		//Create metadata
		S instanceMetadata = instanceMetadataType.newInstance();
		BasicFileAttributes attributes = Files.readAttributes(modelPath, BasicFileAttributes.class);
		ModelMetadata metadata = createModelMetadata(instanceMetadata, modelPath.getFileName().toString(), author, attributes, system, relativePath, modelType, 
			 status, customMetadata);
		//Store model in repository
		mr.storeModel(model, modelType, metadata, relativePath);
		
		System.out.println("Stored " + metadata.getModelInstances().get(0).getValue("name") + " model");

	}
	
	private <T extends IModel> ModelMetadata createModelMetadata(T instanceMetadata, Path file, BasicFileAttributes attributes, 
			String fileExtension, String relativePath, ModelType modelType, HashMap<String,String> customMetadata) throws Exception {
		ModelMetadata metadata = new ModelMetadata();
		metadata.setSender("ModelRepositoryInitialization");
		metadata.setTimeStamp(Calendar.getInstance().getTime());
		metadata.setModelInstances(createModelMetadataInstances(instanceMetadata, file, attributes, fileExtension, relativePath, modelType, customMetadata));
		
		return metadata;
	}
	
	private <T extends IModel> List<IModel> createModelMetadataInstances(T metadata, Path file, BasicFileAttributes attributes, 
			String fileExtension, String relativePath, ModelType modelType, HashMap<String,String> customMetadata) throws Exception {
		List<IModel> modelInstances = new ArrayList<>();
		modelInstances.add(metadata);

		metadata.setValue("name", getFileName(file));
		metadata.setValue("authorId", getAuthorForModel (file));
		Calendar creationDateCalendar = Calendar.getInstance();
		creationDateCalendar.setTimeInMillis(attributes.creationTime().toMillis());
		metadata.setValue("creationDate", creationDateCalendar.getTime());
		Calendar lastModificationCalendar = Calendar.getInstance();
		lastModificationCalendar.setTimeInMillis(attributes.lastModifiedTime().toMillis());
		metadata.setValue("lastModificationDate", lastModificationCalendar.getTime());
		metadata.setValue("systemId", getModelSystemForModel(file));
		metadata.setValue("relativePath", relativePath);
//		System.out.println(repositoryRelativePath + relativePath);
//		metadata.setValue ("fileExtension", "." + fileExtension);

		switch (modelType) {
			case BaseModel:
				metadata.setValue("fileExtension", ModelType.BaseModel.getExtension());
				metadata.setValue("status", Status.Enacted.toString());
				break;
			case VariantModel:
				metadata.setValue("fileExtension", ModelType.VariantModel.getExtension());
				break;
			case ProfileModel:
				metadata.setValue("fileExtension", ModelType.ProfileModel.getExtension());
				break;
			case FeatureModel:
				metadata.setValue("fileExtension", ModelType.FeatureModel.getExtension());
				break;
			case FeatureConfiguration:
				metadata.setValue("fileExtension", ModelType.FeatureConfiguration.getExtension());
				metadata.setValue("status", Status.Computed.toString());
				break;
			case AdaptabilityModel:
				metadata.setValue("fileExtension", ModelType.AdaptabilityModel.getExtension());
				metadata.setValue("featureId", customMetadata.get("featureId"));
				break;
			case PatternModel:
				metadata.setValue("fileExtension", ModelType.PatternModel.getExtension());
				break;
			default:
				log.error("Not a valid model type");
		}
		
		return modelInstances;
	}
	
	private <T extends IModel> ModelMetadata createModelMetadata(T instanceMetadata, String name, String author,
			BasicFileAttributes attributes, ModelSystem system, String relativePath, ModelType modelType, 
			Status status, HashMap<String,String> customMetadata) throws Exception {
		ModelMetadata metadata = new ModelMetadata();
		metadata.setSender("ModelRepositoryInitialization");
		metadata.setTimeStamp(Calendar.getInstance().getTime());
		metadata.setModelInstances(
			createModelMetadataInstances(instanceMetadata, name, author, attributes, system, relativePath, modelType, status, customMetadata));
		
		return metadata;
	}
	
	
	private <T extends IModel> List<IModel> createModelMetadataInstances(T metadata, String name, String author,
			BasicFileAttributes attributes, ModelSystem system, String relativePath, ModelType modelType, 
			Status status, HashMap<String,String> customMetadata) throws Exception {
		List<IModel> modelInstances = new ArrayList<>();
		modelInstances.add(metadata);

		metadata.setValue("name", name);
		metadata.setValue("authorId", author);
		Calendar creationDateCalendar = Calendar.getInstance();
//		creationDateCalendar.setTimeInMillis(attributes.creationTime().toMillis());
		metadata.setValue("creationDate", creationDateCalendar.getTime());
		Calendar lastModificationCalendar = Calendar.getInstance();
//		lastModificationCalendar.setTimeInMillis(attributes.lastModifiedTime().toMillis());
		metadata.setValue("lastModificationDate", lastModificationCalendar.getTime());
		metadata.setValue("systemId", system);
		metadata.setValue("relativePath", relativePath);

		switch (modelType) {
			case BaseModel:
				metadata.setValue("fileExtension", ModelType.BaseModel.getExtension());
				metadata.setValue("status", status.toString());
				break;
			case VariantModel:
				metadata.setValue("fileExtension", ModelType.VariantModel.getExtension());
				break;
			case ProfileModel:
				metadata.setValue("fileExtension", ModelType.ProfileModel.getExtension());
				break;
			case FeatureModel:
				metadata.setValue("fileExtension", ModelType.FeatureModel.getExtension());
				break;
			case FeatureConfiguration:
				metadata.setValue("fileExtension", ModelType.FeatureConfiguration.getExtension());
				metadata.setValue("status", status.toString());
				break;
			case AdaptabilityModel:
				metadata.setValue("fileExtension", ModelType.AdaptabilityModel.getExtension());
				metadata.setValue("featureId", customMetadata.get("featureId"));
				break;
			case PatternModel:
				metadata.setValue("fileExtension", ModelType.PatternModel.getExtension());
				break;
			default:
				log.error("Not a valid model type");
		}
		
		return modelInstances;
	}

	private String getFileName(Path file) {
		return file.getFileName().getName(file.getFileName().getNameCount()-1).toString();
	}
	
	private ModelSystem getModelSystemForModel(Path file) {
		// Use heuristic knowledge of file name to set the model system
		if (getFileName(file).toLowerCase().contains("adm")){
			return ModelSystem.Supersede;
		}else if (getFileName(file).toLowerCase().contains("monitoring") ||
			 	  getFileName(file).toLowerCase().contains("twitter")){
			return ModelSystem.MonitoringReconfiguration;
		}else if (getFileName(file).toLowerCase().contains("health") ||
			      getFileName(file).toLowerCase().contains("authentication")){
			return ModelSystem.Health;
		}else if (getFileName(file).toLowerCase().contains("smart") ||
				  getFileName(file).toLowerCase().contains("hsk")) {
			return ModelSystem.Atos_HSK;
		}else if (getFileName(file).toLowerCase().contains("atos") ||
				  getFileName(file).toLowerCase().contains("cms")){
			return ModelSystem.Atos;
		}else if (getFileName(file).toLowerCase().contains("siemens") ||
				  getFileName(file).toLowerCase().contains("composition") ||
				  getFileName(file).toLowerCase().contains("s1") ||
				  getFileName(file).toLowerCase().contains("s2")){
			return ModelSystem.Siemens;
		}else{
			return ModelSystem.Supersede;
		}
	}

	private String getAuthorForModel(Path file) {
		// Use heuristic knowledge of file name to set the owner
		if (getFileName(file).toLowerCase().contains("adm")){
			return "Supersede";
		}else if (getFileName(file).toLowerCase().contains("atos") ||
				  getFileName(file).toLowerCase().contains("cms") ||
				  getFileName(file).toLowerCase().contains("smart")){
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
			return "Supersede";
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
