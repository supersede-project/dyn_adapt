package eu.supersede.dynadapt.modelrepository.manager.service;

import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import eu.supersede.dynadapt.modelrepository.manager.Manager;
import eu.supersede.dynadapt.modelrepository.model.IModel;

@RestController
@RequestMapping("/models")
public class ModelManagerController {
	
	private final String packageRoute = "eu.supersede.dynadapt.modelrepository.model.";
	
	Manager manager;
	
	public ModelManagerController() {
		try {
			manager = new Manager("../repository");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*@RequestMapping(value="/{modelType}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public String listModels(@PathVariable String modelType) {
		List<IModel> models = new ArrayList<>();
		String response = "";
		try {
			models = manager.listAllModels(modelType);
		} catch (Exception e) {
			return Response.error(e.getMessage());
		}
		try {
			ObjectMapper mapper = new ObjectMapper();
			StringWriter writer = new StringWriter();
			mapper.writeValue(writer, models);
			response = writer.toString();
		} catch (Exception e) {
			return Response.error(e.getMessage());
		}
		return response;
	}*/

	@RequestMapping(value="/{modelType}", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
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
		}
		
	}
	
	@RequestMapping(value="/{modelType}/{modelId}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public String getModel(@PathVariable String modelType, @PathVariable String modelId) {
		String response = "";
		IModel model;
		try {
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
		return response;
	}
	
	@RequestMapping(value="/{modelType}/{modelId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	public String updateModel(@PathVariable String modelType, @PathVariable String modelId, 
			@RequestBody String input) {
		JsonObject jsonObject = (new JsonParser()).parse(input).getAsJsonObject();
		Map<String,String> propertySet = new HashMap<>();
		for (Entry<String,JsonElement> entry : jsonObject.get("values").getAsJsonObject().entrySet()) {
			propertySet.put(entry.getKey(), entry.getValue().getAsString());
		}
		try {
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
	}
	
	@RequestMapping(value="/{modelType}/{modelId}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
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
	    
	}

}
