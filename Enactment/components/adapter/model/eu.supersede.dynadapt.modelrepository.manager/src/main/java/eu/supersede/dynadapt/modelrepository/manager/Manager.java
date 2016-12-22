package eu.supersede.dynadapt.modelrepository.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import eu.supersede.dynadapt.modelrepository.manager.database.DatabaseController;
import eu.supersede.dynadapt.modelrepository.model.IModel;

public class Manager {
	
	DatabaseController dbController;

	public Manager() throws Exception {
		dbController = new DatabaseController();
	}
	
	public List<IModel> listAllModels(String type) throws Exception {
		return dbController.getAllModels(type);
	}
	
	public List<IModel> createModels(String type, List<IModel> modelList) throws Exception {
		List<IModel> models = new ArrayList<>();
		for (IModel model : modelList) {
			models.add(dbController.createModel(type, model));
		}
		return models;
	}
	
	public IModel createModel(String type, IModel model) throws Exception {
		return dbController.createModel(type, model);
	}
	
	public IModel getModel(String type, String id) throws Exception {
		return dbController.getModel(type, id);
	}
	
	public void deleteModel(String type, String id) throws Exception {
		dbController.deleteModel(type, id);
	}
	
	public IModel updateModel(String type, String id, Map<String,String> propertySet) throws Exception {
		return dbController.updateModel(type, id, propertySet);
	}
	
}
