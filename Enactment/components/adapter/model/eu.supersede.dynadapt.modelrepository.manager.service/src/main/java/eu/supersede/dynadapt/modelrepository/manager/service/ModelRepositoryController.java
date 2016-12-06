package eu.supersede.dynadapt.modelrepository.manager.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;

@RestController
@RequestMapping("/models")
public class ModelRepositoryController {

	@RequestMapping(method = RequestMethod.GET, value = "/{modelId}")
	@ResponseStatus(value = HttpStatus.OK)
	public String getModel(@PathVariable String modelId) {
		// TODO Auto-generated method stub
		return response("GET");
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public String createModel(@RequestBody JsonObject input) {
		// TODO Auto-generated method stub
		return response("POST");
	}

	@RequestMapping(method = RequestMethod.PUT, value="/{modelId}")
	@ResponseStatus(value = HttpStatus.OK)
	public String updateModel(@PathVariable String modelId, @RequestBody JsonObject input) {
		// TODO Auto-generated method stub
		return response("PUT");
	}

	@RequestMapping(method = RequestMethod.DELETE, value="/{modelId}")
	@ResponseStatus(value = HttpStatus.OK)
	public String deleteModel(@PathVariable String modelId) {
		// TODO Auto-generated method stub
		return response("DELETE");
	}
	
	private String response(String method) {
		JsonObject json = new JsonObject();
		json.addProperty("status", method);
		return json.toString();
	}

}
