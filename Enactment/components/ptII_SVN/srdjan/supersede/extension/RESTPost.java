package srdjan.supersede.extension;

 import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ptolemy.actor.TypedAtomicActor;
 import ptolemy.actor.TypedIOPort;
 import ptolemy.data.IntToken;
import ptolemy.data.StringToken;
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

import org.eclipse.jetty.util.ajax.JSON;

import java.io.OutputStream;

 //class for calling a REST service with a given endpoint using cURL 
 public class RESTPost extends TypedAtomicActor {
 /** Constructor */
 public RESTPost(CompositeEntity container, String name) throws NameDuplicationException, IllegalActionException {
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

 public void fire() throws IllegalActionException {
    
     String s1_1=this.endpoint.getValueAsString();
     //creating an URL with parameters that are passed to the actor
     if(trigger.toString().contains("URLParameters"))
     {
         Object inputJSONString = JSON.parse(trigger.toString());
         int i=5;
         
     }
     s1_1 = s1_1.substring(1, s1_1.length()-1);

     //REST POST
     try {

         URL url = new URL("http://api.geonames.org/countryInfoJSON?");
         //URL url = new URL(s1_1);
         HttpURLConnection conn = (HttpURLConnection) url.openConnection();
         conn.setDoOutput(true);
         conn.setRequestMethod("POST");
         conn.setRequestProperty("Content-Type", "application/json");

         String input = "{\"lang\":\"en\",\"country\":\"DE\", \"username\":\"srdjan.stevanetic\"}";

         OutputStream os = conn.getOutputStream();
         os.write(input.getBytes());
         os.flush();

         if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
                 throw new RuntimeException("Failed : HTTP error code : "
                         + conn.getResponseCode());
         }

         BufferedReader br = new BufferedReader(new InputStreamReader(
                         (conn.getInputStream())));

         String response="";
         String output_save="";
         System.out.println("Output from Server .... \n");
         
         while ((response = br.readLine()) != null) {
             output_save+=response;
             System.out.println(output_save);
         }

         conn.disconnect();
         
         super.fire();
         if (trigger.getWidth() > 0 && trigger.hasToken(0)) {
         trigger.get(0);
         }
         
         output.send(0, new StringToken(output_save));

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
