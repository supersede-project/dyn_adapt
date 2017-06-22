package eu.supersede.dynadapt.modelrepository.manager.service;

<<<<<<< HEAD
import java.io.IOException;
import java.io.StringWriter;
=======
import java.sql.Timestamp;
>>>>>>> multimodel-saver-loader
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

<<<<<<< HEAD
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import eu.supersede.dynadapt.modelrepository.manager.Manager;
=======
import eu.supersede.dynadapt.modelrepository.manager.Manager;
import eu.supersede.dynadapt.modelrepository.manager.enums.ModelType;
import eu.supersede.dynadapt.modelrepository.model.AdaptabilityModel;
import eu.supersede.dynadapt.modelrepository.model.BaseModel;
import eu.supersede.dynadapt.modelrepository.model.FeatureConfiguration;
import eu.supersede.dynadapt.modelrepository.model.FeatureModel;
>>>>>>> multimodel-saver-loader
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
<<<<<<< HEAD
	public String createModel(@PathVariable String modelType, @RequestBody String input) {
		JsonObject jsonObject = (new JsonParser()).parse(input).getAsJsonObject();
		ObjectMapper mapper = new ObjectMapper();
		Class classObject;
		try {
			classObject = Class.forName(packageRoute + modelType);
		} catch (ClassNotFoundException e) {
			throw new ResourceNotFoundException();
		}
		JsonArray array = jsonObject.get("modelInstances").getAsJsonArray();
		List<IModel> models = new ArrayList<>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		mapper.setDateFormat(format);
		for (int i = 0; i < array.size(); ++i) {
			JsonObject jsonModel = array.get(i).getAsJsonObject();
			try {
				IModel model = (IModel) mapper.readValue(jsonModel.toString(), classObject);
				models.add(model);
			} catch (IOException e) {
				throw new UnprocessableEntityException();
			}
		}
		try {
			manager.createModels(modelType, models);
			StringWriter writer = new StringWriter();
			mapper.writeValue(writer, models);
			return writer.toString();
		} catch (Exception e) {
			throw new UnprocessableEntityException();
=======
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
>>>>>>> multimodel-saver-loader
		}
		return modelsArray.toString();
		
	}
	
	@RequestMapping(value="/{modelType}/{modelId}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public String getModel(@PathVariable String modelType, @PathVariable String modelId) throws Exception {
		String response = "";
		IModel model;
		try {
<<<<<<< HEAD
			model = manager.getModel(modelType, modelId);
		} catch (Exception e) {
			throw new ResourceNotFoundException();
		}
		try {
			ObjectMapper mapper = new ObjectMapper();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
			mapper.setDateFormat(format);
			StringWriter writer = new StringWriter();
			mapper.writeValue(writer, model);
			response = writer.toString();
		} catch (Exception e) {
			throw new UnprocessableEntityException();
		}
=======
			model = manager.getModel(ModelType.valueOf(modelType), modelId);
			response = model.toJson().toString();
		} catch (NoSuchElementException e) {
			logger.error("There is no " + modelType + " with id " + modelId);
			throw new ResourceNotFoundException();
		} 
>>>>>>> multimodel-saver-loader
		return response;
	}
	
	@RequestMapping(value="/{modelType}/{modelId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	public String updateModel(@PathVariable String modelType, @PathVariable String modelId, 
			@RequestBody String input) throws Exception {
		JSONObject jsonObject = new JSONObject(input);
		try {
<<<<<<< HEAD
			IModel model = manager.updateModel(modelType, modelId, propertySet);
			ObjectMapper mapper = new ObjectMapper();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
			mapper.setDateFormat(format);
			StringWriter writer = new StringWriter();
			mapper.writeValue(writer, model);
			return writer.toString();
		} catch (Exception e) {
			throw new UnprocessableEntityException();
		}
=======
			IModel updateModel = jsonToModel(jsonObject.getJSONObject("values"), ModelType.valueOf(modelType));
			IModel model = manager.updateModel(ModelType.valueOf(modelType), modelId, updateModel);
			return model.toJson().toString();
		} catch (NoSuchElementException e) {
			logger.error("There is no " + modelType + " with id " + modelId);
			throw new ResourceNotFoundException();
		} 
>>>>>>> multimodel-saver-loader
	}
	
	@RequestMapping(value="/{modelType}/{modelId}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
<<<<<<< HEAD
	public void deleteModel(@PathVariable String modelType, @PathVariable String modelId) {
		try {
			manager.deleteModel(modelType, modelId);
		} catch (Exception e) {
			throw new ResourceNotFoundException();
		}
	}
	
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public class ResourceNotFoundException extends RuntimeException {
	    
	}
	
	@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
	public class UnprocessableEntityException extends RuntimeException {
	    
=======
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
>>>>>>> multimodel-saver-loader
	}

}
