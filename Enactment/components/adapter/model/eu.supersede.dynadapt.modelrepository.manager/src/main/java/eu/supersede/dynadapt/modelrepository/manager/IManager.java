package eu.supersede.dynadapt.modelrepository.manager;

import java.util.List;
import java.util.Map;

import eu.supersede.dynadapt.modelrepository.manager.enums.ModelType;
import eu.supersede.dynadapt.modelrepository.manager.enums.Status;
import eu.supersede.dynadapt.modelrepository.manager.enums.SystemId;
import eu.supersede.dynadapt.modelrepository.model.IModel;

public interface IManager {
		
	public List<IModel> listAllModels(ModelType type) throws Exception;
	
	public List<IModel> createModels(ModelType type, List<IModel> modelList) throws Exception;
	
	public IModel createModel(ModelType type, IModel model) throws Exception;
	
	public IModel getModel(ModelType type, String id) throws Exception;
	//FIXME change SystemId enum to IF
	public List<IModel> getModels(ModelType type, SystemId systemId) throws Exception;
	//FIXME change SystemId enum to IF
	public List<IModel> getModels(ModelType type, SystemId systemId, Status status) throws Exception;
		
	public void deleteModel(ModelType type, String id) throws Exception;
	
	public IModel updateModel(ModelType type, String id, Map<String,String> propertySet) throws Exception;

}
