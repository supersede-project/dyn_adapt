
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
import srdjan.supersede.extension.LoggingPtolemy;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import spark.servlet.SparkApplication;
import static spark.Spark.get;
import static spark.Spark.post;

public class AdaptationService implements SparkApplication {
	
	static ConcurrentHashMap<String,String> adaptations = new ConcurrentHashMap<String,String>(); 
	static ConcurrentHashMap<String,MoMLThreadSupersede> threadsInBackground = new ConcurrentHashMap<String,MoMLThreadSupersede>(); 
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
	static int number_of_times_good=5;
	static int number_of_times_bad=5;
	static final String currentPtolemyWorkflow="currentPtolemyWorkflow.xml"; 	
	static File ptolemyExecutionFile=new File (currentPtolemyWorkflow);
		
	public static void main(String[] args) {
		
		new AdaptationService().init();
		
	}
	
	@Override
	public void init() {
		/*
		ScriptEngine eng = manager.getEngineByName("JavaScript");
		eng.eval("function test() { return null; }");
		eng.eval("var x = test();");
		
		String result = (String)eng.get("x");
		*/
		// if file doesnt exists, then create it
    
		if (!ptolemyExecutionFile.exists()) {
			try {
				ptolemyExecutionFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//creating a logger for  logging the infos 
   	 	try {
			LoggingPtolemy.createLogger();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
   	 	//GET TEST
		get("/hello", (req, res) -> {return "Hello World";});
			
		
		// GET
		get("/relay/*", (req, res) -> { 
			
			String url = Util.getServiceURL(req);
			if(adaptations.containsKey(url))
			{
			    //Tudor's version with steps
				//String newResponse = processSteps(url,req);
				//res.body(newResponse);

				LoggingPtolemy.getLogger().info("GET method is called.\n");
				LoggingPtolemy.getLogger().info("The url called in the request is: " + url + "\n");
				LoggingPtolemy.getLogger().info("The ptolemy adaptation code is: " + adaptations.get(url) + "\n");
	                     
		        //Srdjan's version with ptolemy .xml file
		        String newResponse =processSteps_ptolemy(url,req,false);
		        
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
			    
			    LoggingPtolemy.getLogger().info("The unavalable5 service is used\n");
			    	            
			    
			}
			//for the validation purpose (make a service unavailable 10% of the time)
			else if(url.contains("unavailable10"))
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
			    LoggingPtolemy.getLogger().info("The unavalable10 service is used\n");	            
	            

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
		        String newResponse = processSteps_ptolemy(url,req,false);
		        
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
			
			LoggingPtolemy.getLogger().info("The current addaptation (not running in background) is: ");
			LoggingPtolemy.getLogger().info("Key: " + url);
			LoggingPtolemy.getLogger().info("Value: " + decodedString);
			
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
	
		// CONTINUOUS ADAPTATION IN BACKGROUND
		post("/adapt-in-background/*", (req, res) -> {
			
			String url = Util.getServiceURL(req);
	
			//decoding the string (the content of the ptolemy xml-file)
			String decodedString=null;
			try {
			    decodedString = URLDecoder.decode(req.body(), "UTF-8");
			} catch (UnsupportedEncodingException e1) {
			    // TODO Auto-generated catch block
			    e1.printStackTrace();
			}
			adaptations.put(url, decodedString);
			
			LoggingPtolemy.getLogger().info("The current addaptation (running in background) is: ");
			LoggingPtolemy.getLogger().info("Key: " + url);
			LoggingPtolemy.getLogger().info("Value: " + decodedString);
			          
			
			//File file = new File("./ramda.js");
			//Reader reader = new FileReader(file);
			//engine.eval(reader);
			//engine.eval("print(R.add(2, 3))"); 			
			//engines.put(url, engine);
			
			history.put(url, new CopyOnWriteArrayList<String>());
			errorLog.put(url, new CopyOnWriteArrayList<String>());
			
	        //Srdjan's version with ptolemy .xml file
			//Running the Ptolemy adaptation in background in a separate thread
	        String newResponse = processSteps_ptolemy(url,req,true);
	        	
			history.get(url).add("[" + LocalDateTime.now() + "][" + url + "]" + req.body() + "<hr>");
			return "The service " + url + " has been successfully adapted." + newResponse;
		});

		// STOP THE CONTINUOUS ADAPTATION RUNNING IN BACKGROUND
		get("/stop-in-background/*", (req, res) -> {
			
			String url = Util.getServiceURL(req);
			if(threadsInBackground.containsKey(url))
			{
				MoMLThreadSupersede backgroundThread = threadsInBackground.get(url);
				backgroundThread.stopModelExecution();
				threadsInBackground.remove(url);
				LoggingPtolemy.getLogger().info("The background Thread running the service with URL: " + url + " has been successfully stopped.");
				return "The background Thread running the service with URL: " + url + " has been successfully stopped.";
			}
			else
			{
				LoggingPtolemy.getLogger().info("The background Thread running the service with URL: " + url + " has not been found.");
				return "The background Thread running the service with URL: " + url + " has not been found.";
			}
			
			
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
	/**
	 * @param url - the url of the request
	 * @param req - the HTTP Request comming to the server
	 * @param runInBackgrund - if the Ptolemy workflow needs to be run in the background (e.g. when caching is used for some data we need to update the data in the background)
	 */
	public static String processSteps_ptolemy(String url, Request req, boolean runInBackgrund) throws Exception
    {

	String reqRes=null;
    synchronized(url)
        {
        String adaptation = adaptations.get(url);
        
        //creating a contemporary File from an XML String representing the adaptation (just for testing purposes)
        try {
        	Random randomGenerator = new Random();
		    //int randomInt = randomGenerator.nextInt(1000);
            //file = new File("test-"+randomInt+".txt");
            FileWriter fileWriterPtolemy = new FileWriter(ptolemyExecutionFile.getAbsoluteFile(), false);
            fileWriterPtolemy.write(adaptation);
            fileWriterPtolemy.flush();
            if(fileWriterPtolemy!=null) fileWriterPtolemy.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
          
            //geting the name of the Recorder actor from the executed xml file in order to query it for the output results
            String ptolemyRecorder=ReadXML.getRecorderName(ptolemyExecutionFile.getAbsoluteFile());

			LoggingPtolemy.getLogger().info("Recorder actor name of the executed Ptolemy worlflow is: " + ptolemyRecorder + "\n");
            
            if(runInBackgrund)
            {
	            //running Ptolemy in a new thread when it need to be executed n the background (previously the commented code below is used)
	            MoMLThreadSupersede runPtolemyRunnable=new MoMLThreadSupersede (adaptation,ptolemyRecorder);
	            Thread runPtolemyThread= new Thread (runPtolemyRunnable);
	            runPtolemyThread.start();
	            threadsInBackground.put(url, runPtolemyRunnable);
	            LoggingPtolemy.getLogger().info("Injected adaptation is succesfully started in background in another thread!");
	            reqRes="Injected adaptation is succesfully started in background in another thread!";
	            //reqRes=runPtolemyRunnable.getOutputFromRecorder();
	            //fileWriterLog.write("The Recorder actor input Token is arrived. Current system time is: " + String.valueOf(System.currentTimeMillis()/1000.0));
            }
            else
            {
            	MoMLSimpleApplication2 runPtolemy=null;
	            try {
	                //running an xml file in ptolemy
	            	runPtolemy=new MoMLSimpleApplication2();                
	            	if(runPtolemy!=null)
	            	{
	            		runPtolemy.MoMLSimpleApplicationExecute(adaptation,ptolemyRecorder);
	            		LoggingPtolemy.getLogger().info("Running the Ptolemy workflow file... Please wait for some moments...\n");
	            	}	            	
	                
	            } catch (Throwable e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }            
	            //getting the final result that is saved in the Recorder element from running the file
	            if(runPtolemy!=null)
	            {
	                reqRes=runPtolemy.getFinalResult();
	                LoggingPtolemy.getLogger().info("Response from the Recorder actor of the executed Ptolemy workflow: \n");
	                LoggingPtolemy.getLogger().info(reqRes);
	                //this is added for updating the executed MOML file in the adaptation list: the reason is because after execution some parameters can be updated and need to be saved if they are used in the next execution
	                String new_Moml_file = runPtolemy.getExecutedMOMLModel();
	                adaptations.put(url, new_Moml_file);
	                
	            }
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
