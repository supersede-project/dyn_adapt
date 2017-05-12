package eu.supersede.dynadapt.modelrepository.repositoryaccess;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EContentsEList.FeatureIterator;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Profile;
import org.junit.Assert;

import eu.supersede.dynadapt.model.ModelManager;
import eu.supersede.integration.api.adaptation.proxies.ModelRepositoryProxy;
import eu.supersede.integration.api.adaptation.types.AdaptabilityModel;
import eu.supersede.integration.api.adaptation.types.GenericModel;
import eu.supersede.integration.api.adaptation.types.IModel;
import eu.supersede.integration.api.adaptation.types.IModelId;
import eu.supersede.integration.api.adaptation.types.ITypedModelId;
import eu.supersede.integration.api.adaptation.types.ModelMetadata;
import eu.supersede.integration.api.adaptation.types.ModelSystem;
import eu.supersede.integration.api.adaptation.types.ModelType;
import eu.supersede.integration.api.adaptation.types.ModelUpdateMetadata;
import eu.supersede.integration.api.adaptation.types.ProfileModel;
import eu.supersede.integration.api.adaptation.types.Status;
import eu.supersede.integration.api.adaptation.types.TypedModelId;

public abstract class GenericModelRepository {
	private final static Logger log = LogManager.getLogger(GenericModelRepository.class);
	protected ModelManager modelManager;
	private ModelRepositoryProxy<?, ?> proxy;
	private Path temp = null;
	
	protected GenericModelRepository(){
		
	}
	
	protected GenericModelRepository (String repositoryRelativePath) throws IOException{
		proxy = new ModelRepositoryProxy<Object, Object>();
		
		//Create temporary folder
		String userdir = System.getProperty("user.dir");
		Path path = FileSystems.getDefault().getPath(userdir,repositoryRelativePath);
		temp = createTemporaryDirectory(path);
		//Shutdown hook to clean up temporary folder
		Runtime.getRuntime().addShutdownHook(new Thread() {
		    public void run() {
		        removeTemporaryDirectory();
		    }
		});
	}
	
	/**
	 * Returns the model instance meta-data getting as much values as possible from the original meta-data.
	 * FIXME it would be nice to have this method in a Factory or Helper class.
	 * @param originalModelInstanceMetadata
	 * @param type The type of the model
	 * @param relativePath Relative path of the model with respect to the model repository where it was created
	 * @return The meta-data for the model instance
	 */
	protected ModelMetadata createModelMetadata(ModelMetadata originalMetadata, ModelType type, String relativePath) {
		// FIXME Assuming only one model instance is store
		Assert.assertNotNull("No model instance found in metadata", originalMetadata.getModelInstances().get(0));
		IModel originalModelInstanceMetadata = originalMetadata.getModelInstances().get(0);	
		
		ModelMetadata metadata = new ModelMetadata();
		metadata.setSender(originalMetadata.getSender());
		metadata.setTimeStamp(Calendar.getInstance().getTime());
		List<IModel> modelInstances = new ArrayList<IModel>();
		modelInstances.add(createMetadataInstance(originalModelInstanceMetadata, type, relativePath));
		metadata.setModelInstances(modelInstances);
		return metadata;
	}
	
	/**
	 * Returns the model instance meta-data getting as much values as possible from the original meta-data.
	 * FIXME it would be nice to have this method in a Factory or Helper class.
	 * @param originalModelInstanceMetadata
	 * @param type The type of the model
	 * @param relativePath Relative path of the model with respect to the model repository where it was created
	 * @return The meta-data for the model instance
	 */
	protected IModel createMetadataInstance(IModel originalMetadata, ModelType type, String relativePath) {
		switch (type) {
			case ProfileModel: 
				ProfileModel profileModel = new ProfileModel();
				if (originalMetadata instanceof GenericModel) {
					GenericModel originalGenericModel = (GenericModel)originalMetadata;
					profileModel.setName(type.toString() + " of " + originalGenericModel.getName());
					profileModel.setAuthorId(originalGenericModel.getAuthorId());
					profileModel.setCreationDate(Calendar.getInstance().getTime());
					profileModel.setLastModificationDate(Calendar.getInstance().getTime());
					profileModel.setFileExtension(ModelType.ProfileModel.getExtension());
					profileModel.setSystemId(originalGenericModel.getSystemId());
					profileModel.setRelativePath(relativePath);
					List<TypedModelId> dependencies = new ArrayList<TypedModelId>();
					profileModel.setDependencies(dependencies);
				}
				return profileModel;
		default:
			return null;
		}
	}
	
	public abstract ModelType getModelType(EObject model);
	
	/**
	 * FIXME Implement factory method.
	 * @param model
	 * @return the type of the model
	 */
	/*protected ModelType getModelType(EObject model) {
		if (model instanceof Model) {
			return ModelType.BaseModel;
		}
		else if (model instanceof Profile) {
			return ModelType.ProfileModel;
		}
		return null;
	}*/
		
	/**
	 * Returns the list of resources references by a given model's resource
	 * @param model EObject whose content must be explored to find inter-resource references
	 * @return The list of resources that are cross references by the content of the given model
	 */
	protected List<Resource> getDirectCrossResources(EObject model) {
		List<Resource> resourceDependencies = new ArrayList<Resource>();
		TreeIterator<EObject> contentIterator = model.eAllContents();
		while(contentIterator.hasNext()) {
			EObject eObject = contentIterator.next();
			FeatureIterator<EObject> featureIterator = (FeatureIterator<EObject>)eObject.eCrossReferences().iterator();
			while(featureIterator.hasNext()) {
			    EObject refEObject = featureIterator.next();
			    EReference ref = (EReference)featureIterator.feature();
			    Resource crossResource = refEObject.eResource();
			    log.debug(ref.toString() + " -> " + refEObject.toString());
			    if ((crossResource != null) &&
			    	(crossResource != model.eResource()) &&
			    	! resourceDependencies.contains(crossResource)) {
			    	resourceDependencies.add(crossResource);
			    }
			}
		}
		return resourceDependencies;
	}
	
	/**
	 * Stores in the model repository all those models (cross-)referenced by a given model.
	 * @param model Root object of the dependent model
	 * @param type Type of the dependent model
	 * @param metadata Model's meta-data for the dependent model
	 * @param originalRepoPath Path of the original repository the dependent model was stored in
	 * @return The number (relative to its ModelType) of the dependent model
	 * @throws Exception
	 */
	protected <T extends EObject, S extends IModel> 
		List<IModelId> storeDependencies(T model, ModelType type, ModelMetadata metadata, String originalRepoPath) throws Exception {
		List<IModelId> dependencies = new ArrayList<IModelId>();
		Iterator<Resource> itr = getDirectCrossResources(model).iterator();
		while(itr.hasNext()) {
			Resource resource = itr.next();
			if (resource != model.eResource()) {
				if (resource.getURI().isPlatformResource() || resource.getURI().isFile()) {			
					EObject dModel = resource.getContents().get(0);
					String dRelativePath = dModel.eResource().getURI().toString().replace(originalRepoPath, "");
					ModelType dType = getModelType(dModel);
					ModelMetadata dependMetadata = createModelMetadata(metadata, dType, dRelativePath);
					if (dependMetadata.getModelInstances().get(0) != null) {
						String dId = storeModel(dModel, dType, dependMetadata, originalRepoPath);
						ITypedModelId modelId = new TypedModelId(dType, dId);
						dependencies.add(modelId);
					}
				}
			}
		}
		return dependencies;
	}
	
	/**
	 * Stores a given model in the model repository
	 * @param model Root object of the model to be stored
	 * @param type Type of the model to be stored
	 * @param metadata Model's meta-data for the model store
	 * @param originalRepoPath Path of the original repository this model was stored in
	 * @return The number (relative to its ModelType) of the model
	 * @throws Exception
	 */
	protected <T extends EObject, S extends IModel> String storeModel(T model, ModelType type, ModelMetadata metadata, String originalRepoPath) throws Exception {
		// FIXME Assuming only one model instance is store
		Assert.assertNotNull("No model instance found in metadata", metadata.getModelInstances().get(0));
		
		@SuppressWarnings("unchecked")
		S modelInstanceMetadata = (S)metadata.getModelInstances().get(0);	
		
		//  Updating dependencies in model's meta-data
		List<IModelId> dependencies = storeDependencies(model, type, metadata, originalRepoPath);
		modelInstanceMetadata.setValue("dependencies", dependencies);
		
		// Store model in temporary local folder of the repository
		Path path = Paths.get(temp.toString(), (String)modelInstanceMetadata.getValue("relativePath"));
		modelManager.saveModel(model.eResource(), URI.createFileURI(path.toString()), null);
		
		// Updating model content in model's meta-data 
		String modelContent = readModelAsString (path);
		modelContent = modelContent.replace("\"","'"); // For XML-based models, replacing " by '
		modelInstanceMetadata.setValue("modelContent", modelContent);
		
		// Updating the model in the repository index
		@SuppressWarnings("unchecked")
		S[] result = (S[]) proxy.createModelInstances(type, metadata);
		Assert.assertNotNull("Retrieved null " + type.toString() + " model", result);
		Assert.assertTrue("Retrieved emtpy " + type.toString() + " model", result.length > 0);
		
		String id = (String)result[0].getValue("id");
		Assert.assertTrue("Retrieved " + type.toString() + " model without id", id.length() > 0);
		return id;
	}
	
	// FIXME Deprecate this method and use the above one
	protected <T extends EObject, S extends IModel> String storeModel(T model, ModelType type, ModelMetadata metadata) throws Exception {
		//Assuming only one model instance is store
		Assert.assertNotNull("No model instance found in metadata", metadata.getModelInstances().get(0));
		
		// FIXME profile extension lacks the "."
		String modelTypeExtension = type.getExtension().startsWith(".") ? type.getExtension() : ".".concat(type.getExtension());
				
		//TODO Store model in temporary file. Read it as String
		Path path = Paths.get(temp.toString(), UUID.randomUUID() + modelTypeExtension);
		modelManager.saveModel(model.eResource(), URI.createFileURI(path.toString()), null);
		
		// Updating metadata for the model 
		S modelInstanceMetadata = (S)metadata.getModelInstances().get(0);
		String modelContent = readModelAsString (path);
		// For XML-based models, replacing " by '
		modelContent = modelContent.replace("\"","'");
		modelInstanceMetadata.setValue("modelContent", modelContent);
		
		// Updating the model in the repository index
		S[] result = (S[]) proxy.createModelInstances(type, metadata);
		
		//Return model id
		Assert.assertNotNull("Retrieved null model", result);
		Assert.assertTrue("Retrieved emtpy model", result.length > 0);
		
		return (String)result[0].getValue("id");
	}
	
	/**
	 * Loads from the repository the root object of the models a given model depends on
	 * @param modelId Unique identifier of the model whose dependencies must be returned
	 * @return The list of the dependencies' root objects
	 * @throws Exception
	 */
	protected <T extends EObject, S extends IModel> List<T> getDependencies(ITypedModelId modelId) throws Exception {
		List<T> dependencies = new ArrayList<T>();
		@SuppressWarnings("unchecked")
		S result = (S) proxy.getModelInstance(modelId.getModelType(), modelId.getNumber());
		//Assert.assertNotNull("Retrieved null model", result);
		if (result == null) {
			return null;
		}	
		
		
		@SuppressWarnings("unchecked")
		List<IModelId> dependIds = (List<IModelId>)result.getValue("dependencies");
		for (IModelId dependId : dependIds) {
			if (dependId instanceof ITypedModelId) {
				ITypedModelId typedModelId = (ITypedModelId)dependId;
				@SuppressWarnings("unchecked")
				T dependency = (T)getModel(typedModelId.getNumber(), typedModelId.getModelType(), EObject.class);
				dependencies.add(dependency);
			}
		}	
		return dependencies;
	}
	
	/**
	 * Loads from the repository the root object of a given model stored in the repository
	 * @param id Number of the model (with respect to its type)
	 * @param type Type of the model
	 * @param modelClass Class of the object to return
	 * @return The model's root object
	 * @throws Exception
	 */
	protected <T extends EObject, S extends IModel> T getModel(String id, ModelType type, Class<T> modelClass) throws Exception {
		@SuppressWarnings("unchecked")
		S result = (S) proxy.getModelInstance(type, id);
		//Assert.assertNotNull("Retrieved null model", result);
		if (result == null) {
			return null;
		}					
		// Loading the models this model depends on
		ITypedModelId modelId = new TypedModelId(type, id);
		getDependencies(modelId);
		
		// Store model in temporary local folder of the repository
		String fileName = (String) result.getValue("name") + (String) result.getValue("fileExtension");
		Path path = Paths.get(temp.toString(), (String)result.getValue("relativePath"), fileName);
		String modelContent = (String) result.getValue ("modelContent"); // For XML-based models, replacing ' by "
		modelContent = modelContent.replace("'","\"");
		saveModelFromString(modelContent, path);
		
		//Use ModelManager to retrieve the model
		return modelManager.loadModel(path.toString(), modelClass);
	}
	
	protected <T extends EObject, S extends IModel> List<T> getModelsOfTypeForSystemWithStatus(ModelType modelType, ModelSystem system, Status status, Class<T> modelClass) throws Exception {
		@SuppressWarnings("unchecked")
		List<S> metadata = (List<S>) proxy.getModelInstances(modelType, system, status);
		List<T> results = new ArrayList<>();
		for (S metadatum: metadata){
			String id = (String) metadatum.getValue("id");
			if (metadatum.getValue("id")==null){
				log.error ("Model repository return a model with null identifier and metadatum: " + metadatum);
				continue;
			}
			T model = getModel (id, modelType, modelClass);
			if (model == null){
				log.error ("Model repository return a null model for identifier: " + id);
				continue;
			}
			results.add (model);
		}
		return results;
	}
	
	protected <T extends EObject, S extends IModel> T getLatestModelOfTypeForSystemWithStatus(ModelType modelType, ModelSystem system, Status status, Class<T> modelClass) throws Exception {
		@SuppressWarnings("unchecked")
		List<S> metadata = (List<S>) proxy.getModelInstances(modelType, system, status);
		Collections.sort (metadata); //Sorted by modification date, or creating date or id, inverse order
		IModel iModel = metadata.get(0);
		if (iModel.getValue("id") == null){
			log.error ("Model repository return a model with null identifier and metadatum: " + iModel);
			return null;
		}
		return getModel((String)iModel.getValue("id"), modelType, modelClass);
	}
	
	protected <T extends EObject, S extends IModel> List<T> getModelsFromMetadata(ModelType modelType, GenericModel modelMetadata, Class<T> modelClass) throws Exception {
		@SuppressWarnings("unchecked")
		List<S> metadata = (List<S>) proxy.getModelInstances(modelType, modelMetadata);
		List<T> results = new ArrayList<>();
		for (S metadatum: metadata){
			String id = (String) metadatum.getValue("id");
			if (metadatum.getValue("id")==null){
				log.error ("Model repository return a model with null identifier and metadatum: " + metadatum);
				continue;
			}
			T model = getModel (id, modelType, modelClass);
			if (model == null){
				log.error ("Model repository return a null model for identifier: " + id);
				continue;
			}
			results.add (model);
		}
		return results;
	}
	
	protected <T extends EObject> void updateModel(T model, ModelUpdateMetadata metadata, String id, ModelType type) throws Exception{
		///Assuming only one model instance is store
		Assert.assertNotNull("No model instance provided", model);
		Assert.assertNotNull("No model update metadad instance provided", metadata);
		Assert.assertTrue("No model id provided", id!=null && !id.isEmpty());
		
		//TODO Store model in temporary file. Read it as String
		Path path = Paths.get(temp.toString(), UUID.randomUUID() + type.getExtension());
		modelManager.saveModel(model.eResource(), URI.createFileURI(path.toString()), null);
		String modelContent = readModelAsString (path);
		//For XML-based models, replacing " by '
		modelContent = modelContent.replace("\"","'");
		
		metadata.getValues().put ("modelContent", modelContent);
		
		proxy.updateModelInstance(type, metadata, id);
	}

	protected void deleteModel(String id, ModelType type) throws Exception {
		proxy.deleteModelInstance(type, id);
	}
	
	//Clean-up all repository models
	protected void cleanUpRepository() {
		List<IModel> models;
		try {
			models = proxy.getModelInstances(ModelType.AdaptabilityModel, null, null);
			for (IModel model: models){
				proxy.deleteModelInstance(ModelType.AdaptabilityModel, (String)model.getValue("id"));
			}
			
			models = proxy.getModelInstances(ModelType.BaseModel, null, null);
			for (IModel model: models){
				proxy.deleteModelInstance(ModelType.BaseModel, (String)model.getValue("id"));
			}
			
			models = proxy.getModelInstances(ModelType.FeatureConfiguration, null, null);
			for (IModel model: models){
				proxy.deleteModelInstance(ModelType.FeatureConfiguration, (String)model.getValue("id"));
			}
			
			models = proxy.getModelInstances(ModelType.FeatureModel, null, null);
			for (IModel model: models){
				proxy.deleteModelInstance(ModelType.FeatureModel, (String)model.getValue("id"));
			}
			
			models = proxy.getModelInstances(ModelType.PatternModel, null, null);
			for (IModel model: models){
				proxy.deleteModelInstance(ModelType.PatternModel, (String)model.getValue("id"));
			}
			
			models = proxy.getModelInstances(ModelType.ProfileModel, null, null);
			for (IModel model: models){
				proxy.deleteModelInstance(ModelType.ProfileModel, (String)model.getValue("id"));
			}
			
			models = proxy.getModelInstances(ModelType.VariantModel, null, null);
			for (IModel model: models){
				proxy.deleteModelInstance(ModelType.VariantModel, (String)model.getValue("id"));
			}
					
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public <T extends EObject> T readModelFromString(String modelContent, ModelType type, Class<T> modelClass) throws Exception {
		//Store model in temporary file
		Path path = Paths.get(temp.toString(), UUID.randomUUID() + type.getExtension());
		saveModelFromString(modelContent, path);
		
		//Use ModelManager to retrieve the model
		return modelManager.loadModel(path.toString(), modelClass);
	}
	
	private void saveModelFromString (String model, Path path) throws IOException{
		//Check if the directory exists
		Path parentDir = path.getParent();
		if (!Files.exists(parentDir))
		    Files.createDirectories(parentDir);
		Files.write(path, model.getBytes());
	}
	
	private String readModelAsString (Path path) throws IOException{
		return new String(Files.readAllBytes(path));
	}
	
	private Path createTemporaryDirectory(Path repository) throws IOException{
		if (!Files.exists(repository)){
			Files.createDirectory(repository);
		}
		Path temp = Files.createTempDirectory(repository, "");
		Assert.assertNotNull("There was a problem creating a temporary directory", temp);
		return temp;
	}
	
	private void removeTemporaryDirectory() {
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
					@Override
					public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
						log.debug("deleting temporary folder: " + dir);
						Files.delete(dir);
					    return FileVisitResult.CONTINUE;
					}
		        }); 
        	}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}
