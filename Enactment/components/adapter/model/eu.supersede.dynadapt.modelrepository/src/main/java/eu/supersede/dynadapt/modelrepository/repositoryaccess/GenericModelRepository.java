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
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.junit.Assert;

import eu.supersede.dynadapt.model.ModelManager;
import eu.supersede.integration.api.adaptation.proxies.ModelRepositoryProxy;
import eu.supersede.integration.api.adaptation.types.AdaptabilityModel;
import eu.supersede.integration.api.adaptation.types.IModel;
import eu.supersede.integration.api.adaptation.types.ModelMetadata;
import eu.supersede.integration.api.adaptation.types.ModelSystem;
import eu.supersede.integration.api.adaptation.types.ModelType;
import eu.supersede.integration.api.adaptation.types.ModelUpdateMetadata;
import eu.supersede.integration.api.adaptation.types.Status;

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
	
	protected <T extends EObject, S extends IModel> String storeModel(T model, ModelType type, ModelMetadata metadata) throws Exception {
		//Assuming only one model instance is store
		Assert.assertNotNull("No model instance found in metadata", metadata.getModelInstances().get(0));
		
		//TODO Store model in temporary file. Read it as String
		Path path = Paths.get(temp.toString(), UUID.randomUUID() + type.getExtension());
		modelManager.saveModel(model.eResource(), URI.createFileURI(path.toString()), null);
		
		String modelContent = readModelAsString (path);
		//For XML-based models, replacing " by '
		modelContent = modelContent.replace("\"","'");
		
		((S)metadata.getModelInstances().get(0)).setValue("modelContent",modelContent);
		S[] result = (S[]) proxy.createModelInstances(type, metadata);
		
		//Return model id
		Assert.assertNotNull("Retrieved null Adaptability Model", result);
		Assert.assertTrue("Retrieved emtpy Adaptability Model", result.length > 0);
		
		return (String)result[0].getValue("id");
	}

	protected <T extends EObject, S extends IModel> T getModel(String id, ModelType type, Class<T> modelClass) throws Exception {
		S result = (S) proxy.getModelInstance(type, id);
		
		//Store model in temporary File
		Assert.assertNotNull("Retrieved null model", result);
		
		Path path = Paths.get(temp.toString(), UUID.randomUUID() + type.getExtension());
		
		//For XML-based models, replacing ' by "
		String modelContent = (String) result.getValue ("modelContent");
		modelContent = modelContent.replace("'","\"");
		
		saveModelFromString(modelContent, path);
		
		//Use ModelManager to retrieve the model
		return modelManager.loadModel(path.toString(), modelClass);
	}
	
	protected <T extends EObject, S extends IModel> List<T> getModelsOfTypeForSystemWithStatus(ModelType modelType, ModelSystem system, Status status, Class<T> modelClass) throws Exception {
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
		List<S> metadata = (List<S>) proxy.getModelInstances(modelType, system, status);
		Collections.sort (metadata); //Sorted by modification date, or creating date or id, inverse order
		IModel iModel = metadata.get(0);
		if (iModel.getValue("id") == null){
			log.error ("Model repository return a model with null identifier and metadatum: " + iModel);
			return null;
		}
		return getModel((String)iModel.getValue("id"), modelType, modelClass);
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
	
	private void saveModelFromString (String model, Path path) throws IOException{
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
		        }); 
				log.debug("deleting temporary directory: " + temp);
				Files.deleteIfExists(temp);
        	}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
