package eu.supersede.dynadapt.modelrepository.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import eu.supersede.dynadapt.modelrepository.manager.database.DatabaseController;
import eu.supersede.dynadapt.modelrepository.manager.enums.ModelType;
import eu.supersede.dynadapt.modelrepository.manager.enums.Status;
import eu.supersede.dynadapt.modelrepository.model.IModel;
import eu.supersede.integration.api.adaptation.types.ModelSystem;

public class Manager implements IManager {
	
	DatabaseController dbController;

	public Manager(String modelStoragePath) throws Exception {
		dbController = new DatabaseController(modelStoragePath);
	}
	
	@Override
	public List<IModel> listAllModels(ModelType type) throws Exception {
		return dbController.getAllModels(type);
	}
	
	@Override
	public List<IModel> createModels(ModelType type, List<IModel> modelList) throws Exception {
		List<IModel> models = new ArrayList<>();
		for (IModel model : modelList) {
			models.add(dbController.createModel(type, model));
		}
		return models;
	}
	
	@Override
	public IModel createModel(ModelType type, IModel model) throws Exception {
		return dbController.createModel(type, model);
	}
	
	@Override
	public IModel getModel(ModelType type, String id) throws Exception {
		return dbController.getModel(type, id);
	}
	
	@Override
	public List<IModel> getModels(ModelType type, ModelSystem systemId) throws Exception {
		return dbController.getModels(type, systemId);
	}
	
	@Override
	public List<IModel> getModels(ModelType type, Status status) throws Exception {
		return dbController.getModels(type, status);
	}

	@Override
	public List<IModel> getModels(ModelType type,  ModelSystem systemId, Status status) throws Exception {
		return dbController.getModels(type, systemId, status);
	}
	
	@Override
	public void deleteModel(ModelType type, String id) throws Exception {
		dbController.deleteModel(type, id);
	}
	
	@Override
	public IModel updateModel(ModelType type, String id, Map<String,String> propertySet) throws Exception {
		return dbController.updateModel(type, id, propertySet);
	}
	
}
