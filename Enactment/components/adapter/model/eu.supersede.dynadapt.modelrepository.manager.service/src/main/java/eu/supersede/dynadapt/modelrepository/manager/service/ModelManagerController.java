package eu.supersede.dynadapt.modelrepository.manager.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;

import eu.supersede.dynadapt.modelrepository.manager.Manager;
import eu.supersede.dynadapt.modelrepository.manager.service.utils.Utils;
import eu.supersede.dynadapt.modelrepository.model.IModel;

@RestController
@RequestMapping("/models")
public class ModelManagerController {
	
	Manager manager = new Manager();

	@RequestMapping(value="/{modelType}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public String listModels(@PathVariable String modelType) {
		List<IModel> models = new ArrayList<>();
		try {
			models = manager.listAllModels(modelType);
		} catch (Exception e) {
			return Utils.error("There is no model type with this name");
		}
		return Utils.response(String.valueOf(models.size()));
	}

	@RequestMapping(value="/{modelType}", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public String createModel(@RequestBody JsonObject input) {
		// TODO Auto-generated method stub
		return Utils.response("POST");
	}
	
	@RequestMapping(value="/{modelType}/{modelId}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public String getModel(@PathVariable String modelType, @PathVariable String modelId) {
		// TODO Auto-generated method stub
		return Utils.response("GET");
	}
	
	@RequestMapping(value="/{modelType}/{modelId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	public String updateModel(@PathVariable String modelType, @PathVariable String modelId) {
		// TODO Auto-generated method stub
		return Utils.response("PUT");
	}
	
	@RequestMapping(value="/{modelType}/{modelId}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public String deleteModel(@PathVariable String modelType, @PathVariable String modelId) {
		// TODO Auto-generated method stub
		return Utils.response("DELETE");
	}

}
