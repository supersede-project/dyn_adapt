package main;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import spark.Request;

public class Util {
	public static boolean isJSON(String s)
	{
		try{new JSONObject(s); return true;}catch(Exception e){};
		try{new JSONArray(s); return true;}catch(Exception e){};
		
		return false;
	}
	
	/*
	public static String buildURL(Request req)
	{
		String host = req.params(":host");
		String endpoint = req.params(":endpoint");
		String url = "https://" + host + "/" + endpoint;
		
		return url;
	}*/
	
	public static String getStackTrace(final Throwable throwable) {
	     final StringWriter sw = new StringWriter();
	     final PrintWriter pw = new PrintWriter(sw, true);
	     throwable.printStackTrace(pw);
	     return sw.getBuffer().toString();
	}
	
	public static String buildURL(Request req)
	{
		String url = "https://wiki.ct.siemens.de/rest/api/content/search";
		
		Object [] params = req.queryParams().toArray();
		
		boolean first = true;
		for(int i=0; i < params.length; i++)
		{
			String paramName = params[i].toString();
			if(!isJSON(paramName))
			{
				if(first)
				{
					url += "?";
				}
				else
				{
					url += "&";
				}
				
				url += paramName + "=" + req.queryParams(paramName);
				first = false;
				
			}
		}
		return url;
	}
	
	public static String getServiceURL(Request req)
	{
		String url = req.splat()[0].replaceAll("http:/", "http://").replaceAll("https:/", "https://").replaceAll("///", "//");
		
		Object [] params = req.queryParams().toArray();
		
		boolean first = true;
		for(int i=0; i < params.length; i++)
		{
			String paramName = params[i].toString();
			if(!isJSON(paramName))
			{
				if(first)
				{
					url += "?";
				}
				else
				{
					url += "&";
				}
				
				url += paramName + "=" + req.queryParams(paramName);
				first = false;
				
			}
		}
		return url;
	}
	
	public static String buildURLWithQuery(Request req)
	{
		String host = req.params(":host");
		String endpoint = req.params(":endpoint");
		String query = req.params(":query");
		String url = "https://" + host + "/" + endpoint + "/" + query;
		
		Object [] params = req.queryParams().toArray();
		
		boolean first = true;
		for(int i=0; i < params.length; i++)
		{
			String paramName = params[i].toString();
			if(!isJSON(paramName))
			{
				if(first)
				{
					url += "?";
				}
				else
				{
					url += "&";
				}
				
				url += paramName + "=" + req.queryParams(paramName);
				first = false;
				
			}
		}
		return url;
	}
	
	// HTTP GET request
	public static String sendGet(String url) throws Exception {

		SSLUtilities.trustAllHostnames();
		SSLUtilities.trustAllHttpsCertificates();
		
		
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// optional default is GET
			con.setRequestMethod("GET");

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			//print result
			return response.toString();

		}
		
		// HTTP POST request
		public static String sendPost(String url, String newRequest) throws Exception {

			SSLUtilities.trustAllHostnames();
			SSLUtilities.trustAllHttpsCertificates();
			
			Client client = Client.create();

			WebResource webResource = client.resource(url);

			ClientResponse response = webResource.type("application/json").post(ClientResponse.class, newRequest);
			
			/*
			if (response.getStatus() != 200 && response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}
			*/			

			String output = response.getEntity(String.class);
			return output;
		}
}
