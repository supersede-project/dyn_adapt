package srdjan.supersede.extension;

 import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ptolemy.actor.NoTokenException;
import ptolemy.actor.TypedAtomicActor;
 import ptolemy.actor.TypedIOPort;
 import ptolemy.data.IntToken;
import ptolemy.data.StringToken;
import ptolemy.data.Token;
import ptolemy.data.expr.Parameter;
 import ptolemy.data.type.BaseType;
 import ptolemy.kernel.CompositeEntity;
 import ptolemy.kernel.util.IllegalActionException;
 import ptolemy.kernel.util.NameDuplicationException;
 
 
 import java.awt.Desktop;
 import java.net.URI;
 import java.net.URISyntaxException;
 

 import java.net.HttpURLConnection;
 import java.net.MalformedURLException;
 import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jetty.util.ajax.JSON;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


 //class for calling a REST service with a given endpoint using cURL 
 public class RESTGet extends TypedAtomicActor {
 /** Constructor */
 public RESTGet(CompositeEntity container, String name) throws NameDuplicationException, IllegalActionException {
     super(container, name);
     trigger = new TypedIOPort(this, "trigger", true, false);
     initial = new Parameter(this, "initial", new IntToken(0));
     initial.setTypeEquals(BaseType.INT);
     
     endpoint=new Parameter(this, "endpoint", new StringToken("http://localhost:4567/adapt/https://nike.erd.siemens.at/supersede/format/"));
     
     output = new TypedIOPort(this, "output", false, true);
     output.setTypeEquals(BaseType.STRING);
 }
 /** Ports and parameters. */
 public TypedIOPort trigger, output;
 public Parameter initial, endpoint;

 /** Action methods. */
 public void initialize() throws IllegalActionException {
     super.initialize();
     _count = ((IntToken)initial.getToken()).intValue();
 }
 
 //creating a URL based on the passed parameters from the previous actor
 // parameters should be passed in the format that contains the word URLParameters: {URLParameters:{par1:val1,par2:val2,...}}
 public String createURL() {
          
     String input="";
     //taking a base URL from the actor parameter (to be defined by the user in Vergil-visual editor)
     String URL_base=this.endpoint.getValueAsString();
     String URL_final=URL_base;
     
     try {
        
         Token input_token=trigger.get(0);
         if(input_token instanceof StringToken)
         {
             URL_final = URL_final.substring(1, URL_final.length()-1);
             input=((StringToken)input_token).stringValue();
             //the passed parameters must contain string "URLParameters"
             if(input.contains("URLParameters")){
                
                JSONObject obj = new JSONObject(input);
                JSONObject url_param = obj.getJSONObject("URLParameters");
                Iterator<?> keys = url_param.keys(); 
                while( keys.hasNext() ) {
                    String key = (String)keys.next();
                    String value = (String) url_param.get(key);
                    URL_final=URL_final+key+"="+value;
                    URL_final+="&";
                    
                }
                  
                URL_final+="username=srdjan.stevanetic";
             }
       
             
         }
         else
         {
             //removing remained "" from the string to be appropriately formated
             URL_final = URL_final.substring(1, URL_final.length()-1);
         }
             
    } catch (NoTokenException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IllegalActionException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (JSONException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
     
         
     return URL_final;
     
 }

 public void fire() throws IllegalActionException {
    
     //String s1_1=this.endpoint.getValueAsString();
     
     
     //creating a URL with parameters that are passed to the actor
     String url_final=this.createURL();
          
     //REST client GET method call
     // for the POST request see: https://www.mkyong.com/webservices/jax-rs/restfull-java-client-with-java-net-url/
     try {
    
         //URL url = new URL("http://localhost:8080/RESTfulExample/json/product/get");
         URL url = new URL(url_final);
                 
         //without proxy, external services like geoNames are not working         
         //System.getProperties().put("proxySet", "true");
         System.setProperty("http.proxyHost", "194.138.0.3");
         System.setProperty("http.proxyPort", "9400");
         //System.clearProperty("http.proxyHost");
         //System.clearProperty("http.proxyPort");
         
         HttpURLConnection conn = (HttpURLConnection) url.openConnection();
         
         //SETTING ALL THESE PARAMETERS IS NOT NECESARRY AND EACH CALL TO THE set... METHOD INHERENTLY CALLS THE CONNECT() METHOD...WHICH CAUSES THE CONNECTION TO BE REDIRECTED/REFUSED
         //conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
         //conn.setRequestMethod("GET");
         //conn.setRequestProperty("Accept", "application/json");
         //conn.connect();
         //List<String> cookies = conn1.getHeaderFields().get("Set-Cookie");
         // ...
         // Then use the same cookies on all subsequent requests.
         //HttpURLConnection conn = (HttpURLConnection) url.openConnection();
         //for (String cookie : cookies) {
         //     conn.addRequestProperty("Cookie", cookie.split(";", 2)[0]);
         //}                  
         //conn.setRequestMethod("GET");
         //conn.setRequestProperty("Accept", "application/json");
                  
         if (conn.getResponseCode() != 200) {
                 throw new RuntimeException("Failed : HTTP error code : "
                                 + conn.getResponseCode());
         }
    
         //BufferedReader br  = new BufferedReader(new InputStreamReader(conn.getInputStream(), Charset.forName("UTF-8")));
         BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
         StringBuilder sb = new StringBuilder();
         String line;
         while ((line = br.readLine()) != null) {
             sb.append(line);
         }
         String response = sb.toString();
         
         System.out.println("Output from Server .... \n"+response);
                        
         // Now, 'unset' the proxy.
         System.clearProperty("http.proxyHost");
         
         super.fire();
         if (trigger.getWidth() > 0 && trigger.hasToken(0)) {
         trigger.get(0);
         }
         
         output.send(0, new StringToken(response));
         
         
    
    } catch (MalformedURLException e) {
    
         e.printStackTrace();
    
    } catch (IOException e) {
    
         e.printStackTrace();
    
    }
 }
 
 
 
 //backaup function for calling REST web services with cURL
 public void fire2() throws IllegalActionException {
     
     String s1_1=this.endpoint.getValueAsString();
     s1_1 = s1_1.substring(1, s1_1.length()-1);
         
     
     ProcessBuilder builder = new ProcessBuilder("curl", "-k", "-i", "-H", "Content-Type: application/json", s1_1);
     
     builder.redirectErrorStream(true);
     Process p=null;
     try {
             p = builder.start();
     } catch (IOException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
     }
     
     //printing out the output received as a result of calling the corresponding REST function from cURL
     StringBuilder sb = new StringBuilder();
     BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
     String line=null;
     int linenum = 0;
     while (true) {
         linenum++;
         try {
                     line = r.readLine();
             } catch (IOException e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
             }
         if (line == null) {
             break;
         }
         sb.append(line);
     }
     System.out.println(sb);
     
     
     
     super.fire();
     if (trigger.getWidth() > 0 && trigger.hasToken(0)) {
     trigger.get(0);
     }
     
     output.send(0, new StringToken(sb.toString()));
 }
 public boolean postfire() throws IllegalActionException {
     _count += 1;
     return super.postfire();
 }
 private int _count = 0; /** Local variable. */
 
 }
