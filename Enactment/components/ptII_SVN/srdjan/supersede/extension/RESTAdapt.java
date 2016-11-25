package srdjan.supersede.extension;

 import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import ptolemy.actor.TypedAtomicActor;
 import ptolemy.actor.TypedIOPort;
 import ptolemy.data.IntToken;
import ptolemy.data.StringToken;
import ptolemy.data.XMLToken;
import ptolemy.data.expr.Parameter;
 import ptolemy.data.type.BaseType;
 import ptolemy.kernel.CompositeEntity;
 import ptolemy.kernel.util.IllegalActionException;
 import ptolemy.kernel.util.NameDuplicationException;
 
 
 import java.awt.Desktop;
 import java.net.URI;
 import java.net.URISyntaxException;
 
 import org.apache.commons.io.FileUtils;
 
 import java.io.OutputStream;
 import java.net.HttpURLConnection;
 import java.net.MalformedURLException;
 import java.net.URL;
 
 import java.io.UnsupportedEncodingException;
 import java.net.URLEncoder;

 //class for injecting a REST service adaptation 
 public class RESTAdapt extends TypedAtomicActor {
 /** Constructor */
 public RESTAdapt(CompositeEntity container, String name) throws NameDuplicationException, IllegalActionException {
     super(container, name);
     trigger = new TypedIOPort(this, "trigger", true, false);
     initial = new Parameter(this, "initial", new IntToken(0));
     initial.setTypeEquals(BaseType.INT);
     
     endpoint=new Parameter(this, "endpoint", new StringToken("http://localhost:4567/adapt/https://nike.erd.siemens.at/supersede/format/"));
     callback=new Parameter(this, "callback", new StringToken("{steps: [{ type: 'REST-GET', url: 'https://nike.erd.siemens.at/supersede/s0/', callback: \"function cb(jsonRequest, jsonReponse){ var reqRes = null; for(var i=0; i < jsonReponse.length;i++) { jsonResponse[i]['WIND_DIRECTION'] = jsonResponse[i]['WINDDIR']; delete jsonResponse[i]['WINDDIR']; }; reqRes = JSON.stringify(jsonResponse); return [ 'ERROR_NULL', reqRes]; }  \"}]}"));
     ptolemy_adapt = new Parameter(this, "xmlfile", new XMLToken());
     
     output = new TypedIOPort(this, "output", false, true);
     output.setTypeEquals(BaseType.INT);
 }
 /** Ports and parameters. */
 public TypedIOPort trigger, output;
 public Parameter initial, endpoint, callback, ptolemy_adapt;

 /** Action methods. */
 public void initialize() throws IllegalActionException {
     super.initialize();
     _count = ((IntToken)initial.getToken()).intValue();
 }
 
 //injecting the adaptation as a ptolemy .xml file (Srdjan's version) 
 public void fire() throws IllegalActionException {
     
     //String s1="http://localhost:4567/adapt/https://nike.erd.siemens.at/supersede/format/";
     //String s2="{steps: [{ type: 'REST-GET', url: 'https://nike.erd.siemens.at/supersede/s0/', callback: \\\"function cb(jsonRequest, jsonReponse){ var reqRes = null; for(var i=0; i < jsonReponse.length;i++) { jsonResponse[i]['WIND_DIRECTION'] = jsonResponse[i]['WINDDIR']; delete jsonResponse[i]['WINDDIR']; }; reqRes = JSON.stringify(jsonResponse); return [ 'ERROR_NULL', reqRes]; }  \\\"}]}";
         
     String endpoint_string=this.endpoint.getValueAsString();
     String callback_string=this.callback.getValueAsString(); 
     String xmlfile_string=this.ptolemy_adapt.getValueAsString();
     
     endpoint_string = endpoint_string.substring(1, endpoint_string.length()-1);
     callback_string = callback_string.substring(1, callback_string.length()-1);   
     xmlfile_string = xmlfile_string.substring(1, xmlfile_string.length()-1);   
     
     String xmlfile_content="";
     try {
         xmlfile_content+=FileUtils.readFileToString(new File (xmlfile_string));
    } catch (IOException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    }
    
     
     //Srdjan: string encoding in order to be easily send over the network because of the string unsafely characters like ""
     String encodedString=null;
     try {
        encodedString = URLEncoder.encode(xmlfile_content, "UTF-8");
    } catch (UnsupportedEncodingException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    }
     
    //Srdjan : REST POST without cURL
    try {
    
            URL url = new URL(endpoint_string);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
    
            String input = encodedString;
    
            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();
    
            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                    throw new RuntimeException("Failed : HTTP error code : "
                            + conn.getResponseCode());
            }
    
            BufferedReader br = new BufferedReader(new InputStreamReader(
                            (conn.getInputStream())));
    
            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                    System.out.println(output);
            }
    
            conn.disconnect();
    
            } 
    catch (MalformedURLException e) {
    
          e.printStackTrace();
    
    } catch (IOException e) {
    
          e.printStackTrace();
    
    }
     
     super.fire();
     if (trigger.getWidth() > 0 && trigger.hasToken(0)) {
     trigger.get(0);
     }
     output.send(0, new IntToken(_count + 1));
     
 }
 
 //injecting the adaptation as a set of steps (Tudor's version) 
 public void fire2() throws IllegalActionException {
     
     //String s1="http://localhost:4567/adapt/https://nike.erd.siemens.at/supersede/format/";
     //String s2="{steps: [{ type: 'REST-GET', url: 'https://nike.erd.siemens.at/supersede/s0/', callback: \\\"function cb(jsonRequest, jsonReponse){ var reqRes = null; for(var i=0; i < jsonReponse.length;i++) { jsonResponse[i]['WIND_DIRECTION'] = jsonResponse[i]['WINDDIR']; delete jsonResponse[i]['WINDDIR']; }; reqRes = JSON.stringify(jsonResponse); return [ 'ERROR_NULL', reqRes]; }  \\\"}]}";
     
     String s1_1=this.endpoint.getValueAsString();
     String s2_1=this.callback.getValueAsString(); 
     s1_1 = s1_1.substring(1, s1_1.length()-1);
     s2_1 = s2_1.substring(1, s2_1.length()-1);   
     
     
     ProcessBuilder builder = new ProcessBuilder("curl", "-k", "-i", "-H", "Content-Type: application/json", s1_1 , "-XPOST", "-d", s2_1);
     
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
     output.send(0, new IntToken(_count + 1));
     
 }
 public boolean postfire() throws IllegalActionException {
     _count += 1;
     return super.postfire();
 }
 private int _count = 0; /** Local variable. */
 
 }
