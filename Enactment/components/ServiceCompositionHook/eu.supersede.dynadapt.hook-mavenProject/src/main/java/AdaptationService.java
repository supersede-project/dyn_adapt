
import static spark.Spark.*;

import java.time.LocalDateTime;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import spark.Request;
import spark.Response;

import java.util.*;
import java.util.concurrent.*;

import org.apache.commons.io.FileUtils;
import org.json.*;
import ptolemy.moml.MoMLSimpleApplication2;
import srdjan.supersede.extension.ReadXML;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;


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
	
	//these static variables are just used for manipulating the availability of services used in the "availability scenario"
	static int unavailable5=0;
	static int unavailable10=0;
	static int number_of_times_good=20;
	static int number_of_times_bad=20;
	static final String currentPtolemyWorkflow="currentPtolemyWorkflow.xml"; 
	
	public static void main(String[] args) throws ScriptException, FileNotFoundException {
		
		/*
		ScriptEngine eng = manager.getEngineByName("JavaScript");
		eng.eval("function test() { return null; }");
		eng.eval("var x = test();");
		
		String result = (String)eng.get("x");
		*/
		//GET TEST
		get("/hello", (req, res) -> "Hello World");
			
		
		// GET
		get("/relay/*", (req, res) -> { 
			String url = Util.getServiceURL(req);
			if(adaptations.containsKey(url))
			{
			        //Tudor's version with steps
				//String newResponse = processSteps(url,req);
				//res.body(newResponse);
			    
			        //Srdjan's version with ptolemy .xml file
			        String newResponse =processSteps_ptolemy(url,req);
			        
			        //Srdjan: added when the service called within a composite service is one from the spark adaptation services
			        //in that case the response has the substrings like \" instead of only a single quote which is the problem for parsing from JavaScript engine
			        String replacedResponse = newResponse.replaceAll("\\\\\"", "\"");
			        String newResponseReturn="";
			        if(replacedResponse.compareTo(newResponse)!=0)
			        {
			        	newResponseReturn = replacedResponse.substring(1, replacedResponse.length()-1);
			        	res.body(newResponseReturn);
			        }
			        else
			        {
			        	res.body(newResponse);
			        }
			}
			else
			{
				res.body(Util.sendGet(url));
			}
			
			//for the validation purpose (make a service unavailable 5% of the time)
			if(url.contains("unavailable5"))
			{
			    //Random numbers from the range 0..99 is generated
			    Random randomGenerator = new Random();
			    int randomInt = randomGenerator.nextInt(100);
			    unavailable5++;
			    if(randomInt<5 && unavailable5<=number_of_times_good) 
			    {
			    	res.status(500);
			    	res.body("Service is unavailable at the moment!");
			    }
			    else if(randomInt<60 && (unavailable5<=number_of_times_good+number_of_times_bad && unavailable5>number_of_times_good))
			    {
			    	res.status(500);
			    	res.body("Service is unavailable at the moment!");	
			    }

			    if(unavailable5>number_of_times_good+number_of_times_bad) unavailable5=0;
			}
			//for the validation purpose (make a service unavailable 10% of the time)
			if(url.contains("unavailable10"))
			{
			    //Random numbers from the range 0..99 is generated
			    Random randomGenerator = new Random();
			    int randomInt = randomGenerator.nextInt(100);
			    unavailable10++;
			    if(randomInt<0) 
			    {
			    	res.status(500);
			    	res.body("Service is unavailable at the moment!");
			    }
			}
		    
			return res.body();						
		});
		
		// POST
		post("/relay/*", (req, res) -> {
			String url = Util.getServiceURL(req);
			if(adaptations.containsKey(url))
			{
			        //Tudor's version with steps
			        //String newResponse = processSteps(url,req);
				//res.body(newResponse);
			    
			        //Srdjan's version with ptolemy .xml file
			        String newResponse = processSteps_ptolemy(url,req);
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
			
			//decoding the string (the content of the ptolemy xml-file)
			String decodedString=null;
			try {
			    decodedString = URLDecoder.decode(req.body(), "UTF-8");
			} catch (UnsupportedEncodingException e1) {
			    // TODO Auto-generated catch block
			    e1.printStackTrace();
			}
			adaptations.put(url, decodedString);
			
			//File file = new File("./ramda.js");
			//Reader reader = new FileReader(file);
			//engine.eval(reader);
			//engine.eval("print(R.add(2, 3))"); 
			
			//engines.put(url, engine);
			
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

	//service adaptation using ptolemy workflow software (.xml files that represents the adaptation model are saved as adaptations and then executed in ptolemy)
	public static String processSteps_ptolemy(String url, Request req) throws Exception
    {
	
	File file=new File (currentPtolemyWorkflow);
	// if file doesnt exists, then create it
	if (!file.exists()) {
		file.createNewFile();
	}
	
    String reqRes=null;
    synchronized(url)
        {
        String adaptation = adaptations.get(url);
        
        //creating a contemporary File from an XML String representing the adaptation
        try {
        	Random randomGenerator = new Random();
		    int randomInt = randomGenerator.nextInt(1000);
            //file = new File("test-"+randomInt+".txt");
            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
            fileWriter.write(adaptation);
            fileWriter.flush();
            if(fileWriter!=null) fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
          
        //geting the name of the Recorder actor from the executed xml file in order to query it for the output results
            String ptolemyRecorder=ReadXML.getRecorderName(file.getAbsoluteFile());
            
            MoMLSimpleApplication2 runPtolemy=null;
            try {
                //running an xml file in ptolemy
                runPtolemy=new MoMLSimpleApplication2(adaptation,ptolemyRecorder);
            } catch (Throwable e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            //getting the final result that is saved in the Recorder element from running the file
            if(runPtolemy!=null)
            {
                reqRes=runPtolemy.getFinalResult();
                //this is added for updating the executed MOML file in the adaptation list: the reason is because after execution some parameters can be updated and need to be saved if they are used in the next execution
                String new_Moml_file = runPtolemy.getExecutedMOMLModel();
                adaptations.put(url, new_Moml_file);
                
            }
           
        }
    
    
    //deleting a contemporary file    
/*    if(file != null) 
    {  
        file.delete();
    }
*/    
    
    return reqRes;
    }
	
	//service adaptation using "steps" keyword in the cURL command (made by Tudor)
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
