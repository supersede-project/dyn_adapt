package eu.supersede.dynadapt.modelrepository.manager.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import eu.supersede.dynadapt.modelrepository.manager.Manager;
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

@RestController
@RequestMapping("/models")
public class ModelManagerController {
	
	final static Logger logger = Logger.getLogger(ModelManagerController.class);
		
	Manager manager;
	
	public ModelManagerController() {
		try {
			manager = new Manager("../repository");
			logger.debug("Model Manager Controller initialization - SUCCESS");
		} catch (Exception e) {
			logger.debug(e.getMessage());
			e.printStackTrace();
		}
	}

	@RequestMapping(value="/{modelType}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public String listModels(@PathVariable String modelType,
							@RequestParam(value = "systemId", required = false) String systemId,
				            @RequestParam(value = "status", required = false) String status,
				            @RequestParam(value = "name", required = false) String name,
				            @RequestParam(value = "url", required = false) String url,
				            @RequestParam(value = "authorId", required = false) String authorId,
				            @RequestParam(value = "creationDate", required = false) String creationDate,
				            @RequestParam(value = "lastModificationDate", required = false) String lastModificationDate,
				            @RequestParam(value = "fileExtension", required = false) String fileExtension,
				            @RequestParam(value = "relativePath", required = false) String relativePath) throws Exception {
		
		List<IModel> models = new ArrayList<>();
		String response = "";
		HashMap<String,String> params = new HashMap<>();
		if (systemId != null) params.put("systemId", systemId);
		if (status != null) params.put("status", status);
		if (name != null) params.put("name", name);
		if (url != null) params.put("url", url);
		if (authorId != null) params.put("authorId", authorId);
		if (creationDate != null) params.put("creationDate", creationDate);
		if (lastModificationDate != null) params.put("lastModificationDate", lastModificationDate);
		if (fileExtension != null) params.put("fileExtension", fileExtension);
		if (relativePath != null) params.put("relativePath", relativePath);
		models = manager.getModels(ModelType.valueOf(modelType), params);
		JSONArray array = new JSONArray();
		for (IModel model : models) {
			array.put(model.toJson());
		}
		response = array.toString();
		return response;
	}

	@RequestMapping(value="/{modelType}", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public String createModel(@PathVariable String modelType, @RequestBody String input) throws Exception {
		JSONObject jsonObject = new JSONObject(input);
		JSONArray array = jsonObject.getJSONArray("modelInstances");
		List<IModel> models = new ArrayList<>();
		for (int i = 0; i < array.length(); ++i) {
			JSONObject jsonModel = array.getJSONObject(i);
			IModel model = jsonToModel(jsonModel, ModelType.valueOf(modelType));
			models.add(model);
		}
		manager.createModels(ModelType.valueOf(modelType), models);
		JSONArray modelsArray = new JSONArray();
		for (IModel model : models) {
			modelsArray.put(model.toJson());
		}
		return modelsArray.toString();
		
	}
	
	@RequestMapping(value="/{modelType}/{modelId}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public String getModel(@PathVariable String modelType, @PathVariable String modelId) throws Exception {
		String response = "";
		IModel model;
		try {
			model = manager.getModel(ModelType.valueOf(modelType), modelId);
			response = model.toJson().toString();
		} catch (NoSuchElementException e) {
			logger.error("There is no " + modelType + " with id " + modelId);
			throw new ResourceNotFoundException();
		} 
		return response;
	}
	
	@RequestMapping(value="/{modelType}/{modelId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	public String updateModel(@PathVariable String modelType, @PathVariable String modelId, 
			@RequestBody String input) throws Exception {
		JSONObject jsonObject = new JSONObject(input);
		try {
			IModel updateModel = jsonToModel(jsonObject.getJSONObject("values"), ModelType.valueOf(modelType));
			IModel model = manager.updateModel(ModelType.valueOf(modelType), modelId, updateModel);
			return model.toJson().toString();
		} catch (NoSuchElementException e) {
			logger.error("There is no " + modelType + " with id " + modelId);
			throw new ResourceNotFoundException();
		} 
	}
	
	@RequestMapping(value="/{modelType}/{modelId}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteModel(@PathVariable String modelType, @PathVariable String modelId) throws Exception {
		try {
			manager.deleteModel(ModelType.valueOf(modelType), modelId);
		} catch (NoSuchElementException e) {
			logger.error("There is no " + modelType + " with id " + modelId);
			throw new ResourceNotFoundException();
		} 
	}
	
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public class ResourceNotFoundException extends RuntimeException {
	    
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
			try {
			    String key = (String)keys.next();
			    if (key.equals("dependencies")) {
			    	JSONArray array = json.getJSONArray(key);
			    	List<TypedModelId> dependencies = new ArrayList<>();
			    	for (int i = 0; i < array.length(); ++i) {
			    		JSONObject obj = array.getJSONObject(i);
			    		dependencies.add(new TypedModelId(ModelType.valueOf(obj.get("modelType").toString()), obj.get("number").toString()));
			    	}
			    	model.setValue(key, dependencies);
			    } else if (key.equals("lastModificationDate") || key.equals("creationDate")) {
			    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
			        Date parsedDate = dateFormat.parse(json.get(key).toString());
			        Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
			        model.setValue(key, timestamp);
			    } else model.setValue(key, json.get(key));
			} catch (Exception e) {
				throw new IllegalAccessException();
			}
		}
		if (!model.validateFields()) throw new Exception("Missing mandatory fields");
		return model;
	}

}
