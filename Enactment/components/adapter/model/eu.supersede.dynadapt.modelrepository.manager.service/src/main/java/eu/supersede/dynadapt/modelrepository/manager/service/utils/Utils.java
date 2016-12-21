package eu.supersede.dynadapt.modelrepository.manager.service.utils;

import com.google.gson.JsonObject;

public class Utils {

	public static String error(String error) {
		JsonObject json = new JsonObject();
		json.addProperty("error", error);
		return json.toString();
	}
	
	public static String response(String method) {
		JsonObject json = new JsonObject();
		json.addProperty("response", method);
		return json.toString();
	}
	
}
