package eu.supersede.dynadapt.modelrepository.manager.database;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;

import eu.supersede.dynadapt.modelrepository.manager.enums.ModelType;
import eu.supersede.dynadapt.modelrepository.manager.enums.Status;
import eu.supersede.dynadapt.modelrepository.model.IModel;
import eu.supersede.dynadapt.modelrepository.model.TypedModelId;
import eu.supersede.integration.api.adaptation.types.ModelSystem;

public interface IDatabaseController {
	
	/**
	 * List models for a given type
	 */
	public List<IModel> getAllModels(ModelType type) throws Exception;
	
	/**
	 * Create new model instance for a given type
	 */
	public IModel createModel(ModelType type, IModel model) throws Exception;
	
	/**
	 * Get attribute values for a given model id and type
	 */
	public IModel getModel(ModelType type, String id) throws Exception;
	
	/**
	 * Get model metadata for a given typedModelId
	 */
	public IModel getModel(TypedModelId typedModelId) throws Exception;
	
	/**
	 * Get a metadata list of models given a model type and a model system
	 */
	public List<IModel> getModels(ModelType type, ModelSystem systemId) throws Exception;
	
	/**
	 * Get a metadata list of models given a model type, a model system and a status
	 */
	public List<IModel> getModels(ModelType type, ModelSystem systemId, Status status) throws Exception;
	
	/**
	 * Get a metadata list of models given a model type and a status
	 */
	public List<IModel> getModels(ModelType type, Status status) throws Exception;
	
	/**
	 * Get a metadata list of models given a model type and a relativePath
	 */
	public List<IModel> getModels(ModelType type, URI relativePath) throws Exception;
	
	/**
	 * Updates a model instance
	 */
	public IModel updateModel(ModelType type, String id, IModel model) throws Exception;
	
	/**
	 * Deletes a model instance
	 */
	public void deleteModel(ModelType type, String id) throws Exception;
	
	public List<IModel> getModels(ModelType type, HashMap<String,String> params) throws Exception;
	
}
