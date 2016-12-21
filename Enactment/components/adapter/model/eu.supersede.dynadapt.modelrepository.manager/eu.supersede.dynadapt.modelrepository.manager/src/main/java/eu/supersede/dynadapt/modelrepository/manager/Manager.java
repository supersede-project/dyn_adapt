package eu.supersede.dynadapt.modelrepository.manager;

import java.util.List;

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
	
}
