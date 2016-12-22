package eu.supersede.dynadapt.modelrepository.manager.service.utils;

import com.google.gson.JsonObject;

public class Response {

	public static String error(String error) {
		JsonObject json = new JsonObject();
		json.addProperty("error", error);
		return json.toString();
	}
	
	public static String response(String status) {
		JsonObject json = new JsonObject();
		json.addProperty("status", status);
		return json.toString();
	}
		
}
