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
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

import org.eclipse.jetty.util.ajax.JSON;

 //this actor is just used to test dhow to call the web service appropriatelly
 // the main actor is RESTGet

 public class RESTGet2 extends TypedAtomicActor {
 /** Constructor */
 public RESTGet2(CompositeEntity container, String name) throws NameDuplicationException, IllegalActionException {
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

     //REST client GET method call
     // for the POST request see: https://www.mkyong.com/webservices/jax-rs/restfull-java-client-with-java-net-url/
     try {
    
         //URL url = new URL("http://localhost:8080/RESTfulExample/json/product/get");
         URL url = new URL(s1_1);
                 
         //System.getProperties().put("proxySet", "true");
         System.setProperty("http.proxyHost", "194.138.0.3");
         System.setProperty("http.proxyPort", "9400");
                                
         
         HttpURLConnection conn = (HttpURLConnection) url.openConnection();
         String response=null;
         
         if(conn.getResponseCode()==HttpURLConnection.HTTP_OK)
         {
             BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
             StringBuilder sb = new StringBuilder();
             String line;
             while ((line = br.readLine()) != null) {
                 sb.append(line);
             }
             response = sb.toString();
             System.out.println("Response" + response);
             br.close();

         }

         
         //calling methods like conn.getHeaderFields() calls inherently the connect() method, so that after that calling setRequestProperty() and similar methods returns an error 
/*         Map<String, List<String>> map = conn.getHeaderFields();
         System.out.println("Printing Response Header...\n");

         for (Map.Entry<String, List<String>> entry : map.entrySet())
         {
             System.out.println("Key : " + entry.getKey() + " ,Value : " + entry.getValue());
         }
         
*/        
         
         //conn.setRequestMethod("GET");
         //conn.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
         //conn.addRequestProperty("Cache-Control", "max-age=0");
         //conn.addRequestProperty("Upgrade-Insecure-Requests", "1");
         //conn.addRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
         //conn.addRequestProperty("Accept-Encoding", "gzip, deflate, sdch");
         //conn.addRequestProperty("Accept-Language", "en-US,en;q=0.8");
        
                
        
/*         
         Map<String, List<String>> map = conn.getHeaderFields();
         String newRedirectedUrlString=null;
         System.out.println("Printing Response Header...\n");

         for (Map.Entry<String, List<String>> entry : map.entrySet())
         {
             System.out.println("Key : " + entry.getKey() + " ,Value : " + entry.getValue());
             if(entry.getKey()!=null &&  entry.getKey().equals("Location"))
             {
                 newRedirectedUrlString=entry.getValue().get(0);
             }
         }
*/        
           
         
         //BufferedReader br  = new BufferedReader(new InputStreamReader(conn.getInputStream(), Charset.forName("UTF-8")));
    
              
          
         //conn.disconnect();
         
         // Now, let's 'unset' the proxy.
         System.clearProperty("http.proxyHost");
         System.clearProperty("http.proxyPort");
         
         
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
