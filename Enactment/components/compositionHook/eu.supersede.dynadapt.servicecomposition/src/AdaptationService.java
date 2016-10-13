import static spark.Spark.*;

import java.time.LocalDateTime;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import spark.Request;
import spark.Response;

import java.util.*;
import java.util.concurrent.*;

import org.json.*;

public class AdaptationService {
	
	static ConcurrentHashMap<String,String> adaptations = new ConcurrentHashMap<String,String>(); 
	static ConcurrentHashMap<String,ScriptEngine> engines = new ConcurrentHashMap<String,ScriptEngine>();
	
	static ConcurrentHashMap<String,CopyOnWriteArrayList<String>> errorLog = new ConcurrentHashMap<String,CopyOnWriteArrayList<String>>();
	static ConcurrentHashMap<String,CopyOnWriteArrayList<String>> history = new ConcurrentHashMap<String,CopyOnWriteArrayList<String>>();
	
	static ScriptEngineManager manager = new ScriptEngineManager();
	
	public enum FlowCondition {
	    CONTINUE, // will continue the execution of the steps (default)  
		STOP, // will stop the execution of the remaining steps and return resReq
		STOP_NOT_NULL, // will stop if resReq is not null
		ERROR, // will throw an error
	    ERROR_NULL // will throw an error if resReq is null	     
	}
	
	public static void main(String[] args) throws ScriptException, FileNotFoundException {
		
		/*
		ScriptEngine eng = manager.getEngineByName("JavaScript");
		eng.eval("function test() { return null; }");
		eng.eval("var x = test();");
		
		String result = (String)eng.get("x");
		*/
		
		// GET
		get("/relay/*", (req, res) -> { 
			String url = Util.getServiceURL(req);
			if(adaptations.containsKey(url))
			{
				String newResponse = processSteps(url,req);
				res.body(newResponse);
			}
			else
			{
				res.body(Util.sendGet(url));
			}
			return res.body();						
		});

		
		// POST
		post("/relay/*", (req, res) -> {
			String url = Util.getServiceURL(req);
			if(adaptations.containsKey(url))
			{
				String newResponse = processSteps(url,req);
				res.body(newResponse);
			}
			else
			{
				res.body(Util.sendPost(url,req.body()));
			}
			return res.body();			
		});		

		// ADAPT

		post("/adapt/*", (req, res) -> {
			String url = Util.getServiceURL(req);
			
			ScriptEngine engine = manager.getEngineByName("JavaScript");
			adaptations.put(url, req.body());
			
			File file = new File("./ramda.js");
			Reader reader = new FileReader(file);
			engine.eval(reader);
			engine.eval("print(R.add(2, 3))"); 
			
			engines.put(url, engine);
			
			history.put(url, new CopyOnWriteArrayList<String>());
			errorLog.put(url, new CopyOnWriteArrayList<String>());
			
			history.get(url).add("[" + LocalDateTime.now() + "][" + url + "]" + req.body() + "<hr>");
			return "The service " + url + " has been successfully adapted.";
		});
		
		
		// HISTORY and ERRORS
		get("/history/*", (req, res) -> {
			String url = Util.getServiceURL(req);
			String hist = "";
			for(int i=0; i<history.get(url).size();i++)
			{
				hist += history.get(url).get(i);
			}
			return hist;						
		});
		
		get("/errors/*", (req, res) -> {
			String url = Util.getServiceURL(req);
			String errors = "";
			for(int i=0; i<errorLog.get(url).size();i++)
			{
				errors += errorLog.get(url).get(i);
			}
			return errors;						
		});

	}

	public static String processSteps(String url, Request req) throws Exception
	{
		String reqRes = req.body();
		String fallbackResponse = "";
		String response = "";
		
		synchronized(url)
		{
			ScriptEngine engine = engines.get(url);
			String adaptation = adaptations.get(url);
			
			JSONArray steps = (new JSONObject(adaptation)).getJSONArray("steps");		
			
			for(int i = 0; i < steps.length(); i++)
			{
				String type = (String) steps.getJSONObject(i).getString("type");
				String targetURL = (String) steps.getJSONObject(i).getString("url");
				
				try 
				{
					if(type.equals("REST-GET"))
					{
						response = Util.sendGet(targetURL);
					}
					else if(type.equals("REST-POST"))
					{
						response = Util.sendPost(targetURL, reqRes);
					}
					
					if(i == 0)
					{
						fallbackResponse = response;
					}
					
					String callback = (String) steps.getJSONObject(i).getString("callback");
					
					engine.put("response", response);
					engine.put("request", (req.body() != null && !req.body().equals("")? req.body() : "{\"request\":\"null\"}"));
					
					engine.eval("var jsonRequest = JSON.parse(request);");
					engine.eval("var jsonResponse = JSON.parse(response);");
					if(i == 0)
					{
						engine.eval("var flowData = {\"data\": \"\"};"); // var flowData is used to pass the data among different callbacks
					}
					
					engine.eval(callback);				
					engine.eval("var cbResult = cb(jsonRequest, jsonResponse);");
					engine.eval("var flowCondition = cbResult[0];");
					engine.eval("var reqRes = cbResult[1];");
					
					reqRes = (String)engine.get("reqRes");
					
					String flowCondition = (String)engine.get("flowCondition");
					
					if(flowCondition == null) {
						flowCondition = "CONTINUE";
					}
					
					FlowCondition fc = FlowCondition.valueOf(flowCondition);
					
					System.out.println("URL: " + url);
					
					switch (fc) {
			            case STOP: 
			            	errorLog.get(url).add("[" + LocalDateTime.now() + "][" + url + "] Stopping execution [STOP] <hr>");
			                System.out.println("Stopping execution [STOP]");
			                return reqRes;			                
	
			            case STOP_NOT_NULL:
			            	if(reqRes != null)
			            	{
			            		errorLog.get(url).add("[" + LocalDateTime.now() + "][" + url + "] Stopping execution [STOP_NOT_NULL] <hr>");
			            		System.out.println("Stopping execution [STOP_NOT_NULL]");
			            		return reqRes;
			            	}
			            	break;
			            
			            case ERROR: 
			            	System.out.println("Step number " + i + " returned an error: " + reqRes + " [ERROR]");
			                throw new Exception("Step number " + i + " returned an error: " + reqRes + " [ERROR]");
			                
			            case ERROR_NULL: 
			            case CONTINUE:
			            default: 
			            	if(reqRes == null)
			                {
			            		System.out.println("Step number " + i + " returned an error: [ERROR]");
			                	throw new Exception("Step number " + i + " returned an error: [ERROR]");
			                }
			            	System.out.println("Everything OK [" + fc + "]");
			                break;
			        }
				}
				catch(Exception e)
				{
					String stacktrace = Util.getStackTrace(e);
					errorLog.get(url).add("[" + LocalDateTime.now() + "][" + url + "]" + stacktrace + "<hr>");
					return fallbackResponse;
				}				
			}
		}
		return reqRes;
	}
}
