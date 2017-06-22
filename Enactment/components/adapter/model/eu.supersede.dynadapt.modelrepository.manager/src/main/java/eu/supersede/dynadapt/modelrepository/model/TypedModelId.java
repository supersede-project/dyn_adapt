package eu.supersede.dynadapt.modelrepository.model;

import eu.supersede.dynadapt.modelrepository.manager.enums.ModelType;

public class TypedModelId implements ITypedModelId {
	
	private String number;
	private ModelType modelType;
	
	public TypedModelId(ModelType modelType, String number) {
		this.number = number;
		this.modelType = modelType;
	}

	@Override
	public int compareTo(IModelId  modelId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getNumber() {
		return number;
	}

	@Override
	public ModelType getModelType() {
		return modelType;
	}

}
