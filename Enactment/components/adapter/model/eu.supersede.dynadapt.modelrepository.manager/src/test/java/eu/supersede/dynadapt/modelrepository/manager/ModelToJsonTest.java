package eu.supersede.dynadapt.modelrepository.manager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import eu.supersede.dynadapt.modelrepository.manager.enums.ModelType;
import eu.supersede.dynadapt.modelrepository.model.AdaptabilityModel;
import eu.supersede.dynadapt.modelrepository.model.BaseModel;
import eu.supersede.dynadapt.modelrepository.model.FeatureConfiguration;
import eu.supersede.dynadapt.modelrepository.model.FeatureModel;
import eu.supersede.dynadapt.modelrepository.model.IModel;
import eu.supersede.dynadapt.modelrepository.model.PatternModel;
import eu.supersede.dynadapt.modelrepository.model.ProfileModel;
import eu.supersede.dynadapt.modelrepository.model.TypedModelId;
import eu.supersede.dynadapt.modelrepository.model.VariantModel;

public class ModelToJsonTest {
	
	Manager manager;
	
	@Before
	public void setUp() {
		
		try {
			manager = new Manager("../repository");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void listAdaptabilityModels() {
		try {
			List<IModel> models = manager.listAllModels(ModelType.BaseModel);
			for (IModel model : models) {
				IModel modelConverted = jsonToModel(model.toJson(), ModelType.BaseModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private IModel jsonToModel(JSONObject json, ModelType type) throws Exception {
		IModel model = null;
		if (type.equals(ModelType.AdaptabilityModel)) model = new AdaptabilityModel();
		if (type.equals(ModelType.BaseModel)) model = new BaseModel();
		if (type.equals(ModelType.FeatureConfiguration)) model = new FeatureConfiguration();
		if (type.equals(ModelType.FeatureModel)) model = new FeatureModel();
		if (type.equals(ModelType.ProfileModel)) model = new ProfileModel();
		if (type.equals(ModelType.PatternModel)) model = new PatternModel();
		if (type.equals(ModelType.VariantModel)) model = new VariantModel();

		Iterator<?> keys = json.keys();
		while(keys.hasNext()) {
		    String key = (String)keys.next();
		    if (key.equals("dependencies")) {
		    	JSONArray array = json.getJSONArray(key);
		    	List<TypedModelId> dependencies = new ArrayList<>();
		    	for (int i = 0; i < array.length(); ++i) {
		    		JSONObject obj = array.getJSONObject(i);
		    		dependencies.add(new TypedModelId(ModelType.valueOf(obj.get("modelType").toString()), obj.get("number").toString()));
		    	}
		    	model.setValue(key, dependencies);
		    } else model.setValue(key, json.get(key));
		}
		return model;
	}

}
