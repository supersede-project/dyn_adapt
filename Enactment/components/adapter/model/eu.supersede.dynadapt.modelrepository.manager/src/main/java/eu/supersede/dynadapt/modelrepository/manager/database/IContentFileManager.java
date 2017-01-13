package eu.supersede.dynadapt.modelrepository.manager.database;

import eu.supersede.dynadapt.modelrepository.model.IModel;

public interface IContentFileManager {

	public String saveModelContent(IModel model) throws Exception;
	
	public String loadModelContent(IModel model) throws Exception;
	
	public void deleteModelContent(IModel model) throws Exception;
			
}
