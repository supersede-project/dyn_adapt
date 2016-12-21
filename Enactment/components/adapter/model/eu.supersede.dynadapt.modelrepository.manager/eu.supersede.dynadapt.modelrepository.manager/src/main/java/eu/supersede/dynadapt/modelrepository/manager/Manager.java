package eu.supersede.dynadapt.modelrepository.manager;

import java.util.List;
import java.util.Map;

import eu.supersede.dynadapt.modelrepository.manager.database.DatabaseController;
import eu.supersede.dynadapt.modelrepository.model.IModel;

public class Manager {
	
	DatabaseController dbController;

	public Manager() {
		dbController = new DatabaseController();
	}
	
	public List<IModel> listAllModels(String type) throws Exception {
		return dbController.getAllModels(type);
	}
	
	public IModel createModel(String type, Map<String,String> propertySet) throws Exception {
		return dbController.createModel(type, propertySet);
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
