package eu.supersede.dynadapt.modelrepository.manager.database;

import eu.supersede.dynadapt.modelrepository.model.IModel;

public interface IContentFileManager {

	public String saveModel(IModel model) throws Exception;
	
	public String loadModel(String path) throws Exception;
	
	public void deleteModel(String path) throws Exception;
		
}
