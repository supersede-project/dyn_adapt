package eu.supersede.dynadapt.modelrepository.manager.service.utils;

import com.google.gson.JsonObject;

public class Utils {

	public static String response(String method) {
		JsonObject json = new JsonObject();
		json.addProperty("status", method);
		return json.toString();
	}
	
}
