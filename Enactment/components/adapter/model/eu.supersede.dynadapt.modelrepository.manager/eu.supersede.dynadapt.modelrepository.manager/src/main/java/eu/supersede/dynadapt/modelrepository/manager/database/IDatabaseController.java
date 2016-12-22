package eu.supersede.dynadapt.modelrepository.manager.database;

import java.util.List;
import java.util.Map;

import com.google.gson.JsonObject;

import eu.supersede.dynadapt.modelrepository.model.IModel;

public interface IDatabaseController {
	
	/**
	 * List models for a given type
	 */
	public List<IModel> getAllModels(String type) throws Exception;
	
	/**
	 * Create new model instance for a given type
	 */
	public IModel createModel(String type, IModel model) throws Exception;
	
	/**
	 * Get attribute values for a given model id and type
	 */
	public IModel getModel(String type, String id) throws Exception;
	
	/**
	 * Updates a model instance
	 */
	public IModel updateModel(String type, String id, Map<String,String> propertySet) throws Exception;
	
	/**
	 * Deletes a model instance
	 */
	public void deleteModel(String type, String id) throws Exception;
	
}
