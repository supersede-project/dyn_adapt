package eu.supersede.dynadapt.modelrepository.model;

import eu.supersede.dynadapt.modelrepository.manager.enums.ModelType;

public interface ITypedModelId extends IModelId {
	
	public String getNumber();
	public ModelType getModelType();

}
