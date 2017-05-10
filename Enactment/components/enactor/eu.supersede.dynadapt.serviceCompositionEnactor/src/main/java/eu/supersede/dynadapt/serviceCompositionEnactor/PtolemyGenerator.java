package eu.supersede.dynadapt.serviceCompositionEnactor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.FinalNode;
import org.eclipse.uml2.uml.ForkNode;
import org.eclipse.uml2.uml.InitialNode;
import org.eclipse.uml2.uml.JoinNode;
import org.eclipse.uml2.uml.OpaqueAction;
import org.eclipse.uml2.uml.Stereotype;

import ptolemy.actor.TypedCompositeActor;
import ptolemy.actor.TypedIOPort;
import ptolemy.actor.TypedIORelation;
import ptolemy.domains.de.kernel.DEDirector;
import ptolemy.kernel.Relation;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;
import ptolemy.kernel.util.NamedObj;
import ptolemy.kernel.util.Workspace;
import srdjan.supersede.extension.RESTGet;
import ptolemy.actor.lib.SingleEvent;
import ptolemy.actor.lib.jjs.JavaScript;
import ptolemy.actor.lib.gui.Display;
import ptolemy.actor.lib.RecordAssembler;
import ptolemy.actor.lib.SingleEvent;
import ptolemy.actor.lib.gui.Display;
import ptolemy.actor.lib.Recorder;

public class PtolemyGenerator extends TypedCompositeActor {

    /** the two lists are used for saving which nodes from the activity diagram correspond 
     * to which ptolemy actors
     * "totalNumberNamedEntities" - used for creating the names of the entities that need to be different for
     * all created entities 
    */
    
    private static List<ActivityNode> UMLActivityNodes = new ArrayList <ActivityNode> ();
    private static List<NamedObj> PtolemyNodes = new ArrayList <NamedObj> ();
    private int totalNumberNamedEntities;
    private String XMLPtolemyModel;
    private String serviceEndpoint;
    private boolean serviceEndpointSet;

    public PtolemyGenerator (Workspace workspace)
            throws IllegalActionException, NameDuplicationException {
            super(workspace);   
            this.totalNumberNamedEntities=1;
            this.XMLPtolemyModel=null;
            this.serviceEndpoint=null;
            this.serviceEndpointSet=false;
            
            DEDirector director = new DEDirector(this, "DEdirector");
            setDirector(director);
            director.stopTime.setExpression("10.0");           
    
    }
    
    /**a simple example of creating a ptolemy model, used just for testing
     */
    
    public void createModel ()
    {
        // Create the director.
        DEDirector DEdirector;
        try {
            DEdirector = new DEDirector(this, "DEdirector");
        
            setDirector(DEdirector);
            DEdirector.stopTime.setExpression("10.0");
            // Create two actors.
            SingleEvent singleEvent = new SingleEvent(this,"singleEvent");
            RESTGet restGet = new RESTGet (this, "restGet");
            restGet.endpoint.setExpression("\"http://api.geonames.org/countryInfoJSON?lang=en&country=DE&username=srdjan.stevanetic\"");
            JavaScript javaScript = new JavaScript (this,"javaScript");
            TypedIOPort jsInputPort = new TypedIOPort(javaScript, "input", true, false);
            TypedIOPort jsOutputPort = new TypedIOPort(javaScript, "output", false, true);
            
            
            javaScript.script.setExpression(
            "exports.setup = function() { "
            + "this.input('input');      "
            + "this.output('output');"
            + "};"
            + " exports.fire = function () {"
            + " var value = this.get('input');"
            + " var request = (value != null && !value.equals(\"\")) ? value : \"{\\\"request\\\":\\\"null\\\"}\";"
            + "var response=\"\";"
            + "request=JSON.parse(request);"
            + " var south=request.geonames[0].south;"
            + "   var north=request.geonames[0].north;"
            + "   var east=request.geonames[0].east;"
            + "   var west=request.geonames[0].west;"
            + "   var BoundingBox = {};"
            + "   BoundingBox[\"south\"]= String(south);"
            + "   BoundingBox[\"north\"]= String(north);"
            + "   BoundingBox[\"east\"]= String(east);"
            + "   BoundingBox[\"west\"]= String(west);"
            + "   var reqRes = {};"
            + "   reqRes[\"URLParameters\"]=BoundingBox;"
                    + "   reqRes=JSON.stringify(reqRes);"
                    + "   this.send('output', reqRes);};");
            
            RESTGet restGet2 = new RESTGet (this, "restGet2");
            restGet2.endpoint.setExpression("\"http://api.geonames.org/earthquakesJSON?\"");
            Display display = new Display (this, "display");
            
            
            // Connect them.
            connect(singleEvent.output, restGet.trigger);
            connect(restGet.output, jsInputPort);
            connect(jsOutputPort, restGet2.trigger);
            connect(restGet2.output, display.input);
            
            String xml_content = this.exportMoML();
            
            File file = null;  
            //creating a contemporary File from an XML String representing the adaptation
            try {
                file = new File("D:/SUPERSEDE/Tudor-docs/GreenAnalytics_ptolemy/ptolemyModelFromJava.xml");
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(xml_content);
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        catch (IllegalActionException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (NameDuplicationException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
    }
    

    
    /** adding actors to the ptolemy model based on the nodes in the activity diagram
     * The logic for translating the activity diagram to the ptolemy model is the following: 
     * for each node from the activity diagram a corresponding ptolemy actor (or Relation for the ForkNode) is created.
     * After that a list of edges in the activity diagram is analysed and for each edge a corresponding connection
     * is created in the ptolemy model (see function addConnections below). 
     * 
     * @param activityElement
     * @param stereotype
     * @param endpoint_callback
     */
    public void addActors (ActivityNode activityElement, String stereotype, String endpoint_callback)
    {
        try 
        {
            if(activityElement instanceof ForkNode)
            {
                //TypedIORelation node = (TypedIORelation) new Relation("node");
                /**relation is not added to the composite actor and therefore we do not manage the name of it using totalNumberNamedEntities
                *
                */
                //Relation node = new Relation("node"+Integer.toString(this.totalNumberNamedEntities));
                TypedIORelation IOrelation = (TypedIORelation) new TypedIORelation (this, "IOrelation"+Integer.toString(this.totalNumberNamedEntities++));
                UMLActivityNodes.add(activityElement);
                PtolemyNodes.add(IOrelation);
                    
                
            }
            else if (activityElement instanceof JoinNode)
            {
                RecordAssembler recordAssembler = new RecordAssembler(this, "recordAssembler"+Integer.toString(this.totalNumberNamedEntities++));
                UMLActivityNodes.add(activityElement);
                PtolemyNodes.add(recordAssembler);         
                
            }
            else if ((activityElement instanceof OpaqueAction) && (stereotype.equals("Service")))
            {
                RESTGet restGet = new RESTGet (this, "restGet"+Integer.toString(this.totalNumberNamedEntities++));
                //restGet.endpoint.setExpression("\"http://api.geonames.org/countryInfoJSON?lang=en&country=DE&username=srdjan.stevanetic\"");
                restGet.endpoint.setExpression(endpoint_callback);
                UMLActivityNodes.add(activityElement);
                PtolemyNodes.add(restGet);      
                
    
            }
            else if ((activityElement instanceof OpaqueAction) && (stereotype.equals("Callback")))
            {
                JavaScript javaScript = new JavaScript (this,"javaScript"+Integer.toString(this.totalNumberNamedEntities++));
                javaScript.script.setExpression(endpoint_callback);
                UMLActivityNodes.add(activityElement);
                PtolemyNodes.add(javaScript);              
                
            }
            else if (activityElement instanceof InitialNode)
            {
                
                SingleEvent singleEvevnt = new SingleEvent (this,"singleEvent"+Integer.toString(this.totalNumberNamedEntities++));
                UMLActivityNodes.add(activityElement);
                PtolemyNodes.add(singleEvevnt);    
                
            }
            else if (activityElement instanceof FinalNode)
            {
                TypedIORelation IOrelation = (TypedIORelation) new TypedIORelation (this, "IOrelation"+Integer.toString(this.totalNumberNamedEntities++));
                UMLActivityNodes.add(activityElement);
                PtolemyNodes.add(IOrelation);
                
                Display display = new Display (this,"display"+Integer.toString(this.totalNumberNamedEntities++));
                display.input.link(IOrelation);    
                
                Recorder recorder = new Recorder (this,"recorder"+Integer.toString(this.totalNumberNamedEntities++));
                recorder.input.link(IOrelation);    

            }
        } catch (NameDuplicationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalActionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /** adding the connections between the ptolemy actors based on the connections between the
     * nodes in the activity diagram
     *  
     * @param activityEdge
     * @param source
     * @param target
     */
    public void addConnections (ActivityEdge activityEdge, ActivityNode source, ActivityNode target)
    {
        try 
        {
        
            if(PtolemyNodes.get(UMLActivityNodes.indexOf(source)) instanceof TypedIORelation)
            {
                TypedIORelation rel_source= (TypedIORelation) PtolemyNodes.get(UMLActivityNodes.indexOf(source));
                if(PtolemyNodes.get(UMLActivityNodes.indexOf(target)) instanceof TypedIORelation)
                {
                    Relation rel_target= (Relation) PtolemyNodes.get(UMLActivityNodes.indexOf(target));
                    rel_target.link(rel_source);
                    
                }
                else 
                {
                    TypedIOPort input_port=this.getPort(PtolemyNodes.get(UMLActivityNodes.indexOf(target)), 1);
                    input_port.link(rel_source);
                }
                       
            }
            else if(PtolemyNodes.get(UMLActivityNodes.indexOf(target)) instanceof TypedIORelation)
            {
                TypedIORelation rel_target= (TypedIORelation) PtolemyNodes.get(UMLActivityNodes.indexOf(target));
                TypedIOPort output_port=this.getPort(PtolemyNodes.get(UMLActivityNodes.indexOf(source)), 0);
                output_port.link(rel_target);
               
            }
            else
            {
                TypedIOPort output_port=this.getPort(PtolemyNodes.get(UMLActivityNodes.indexOf(source)), 0);
                TypedIOPort input_port=this.getPort(PtolemyNodes.get(UMLActivityNodes.indexOf(target)), 1);
                connect(output_port,input_port);
            }
        }
        catch (IllegalActionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        
    }
    

    /**get the input or output port of a ptolemy actor
     * @param ptolemyActor
     * @param input (1 for getting the input port, 0 for the output)
     * @return
     */
    public TypedIOPort getPort (NamedObj ptolemyActor, int input)
    {
        try 
        {
            if(input == 1)
            {
                if(ptolemyActor instanceof RESTGet)
                {
                    return ((RESTGet)ptolemyActor).trigger;
                }
                else if (ptolemyActor instanceof JavaScript)
                {
                    TypedIOPort InputPort=new TypedIOPort((JavaScript)ptolemyActor, "input", true, false);
                    return InputPort;
                }
                else if (ptolemyActor instanceof RecordAssembler)
                {
                    RecordAssembler recAss=(RecordAssembler)ptolemyActor;
                    TypedIOPort InputPort=new TypedIOPort(recAss, "input"+Integer.toString(this.totalNumberNamedEntities++), true, false);
                    return InputPort;
                }
                else if (ptolemyActor instanceof Display)
                {
                    return ((Display)ptolemyActor).input;
                }
                else
                {
                    return null;
                }
                
            }
            else
            {
                if(ptolemyActor instanceof RESTGet)
                {
                    return ((RESTGet)ptolemyActor).output;
                }
                else if (ptolemyActor instanceof SingleEvent)
                {
                    return ((SingleEvent)ptolemyActor).output;
                }
                else if (ptolemyActor instanceof JavaScript)
                {
                    TypedIOPort OutputPort=new TypedIOPort((JavaScript)ptolemyActor, "output", false,true);
                    return OutputPort;
                }
                else if (ptolemyActor instanceof RecordAssembler)
                {                   
                    return ((RecordAssembler)ptolemyActor).output;                    
                }
                else
                {
                    return null;
                }
                   
            }
        }
        catch (IllegalActionException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        } catch (NameDuplicationException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        }
    
        return null;
    
    }
    
  /** function that creates a prolemy model based on the given activity diagram
   * 
   * @param activity
   * @param activity_nodes
   * @return
   */
    public void analyze (Activity activity,List<ActivityNode> activity_nodes)
    {
        /** setting the endpoint of the service being composed from other services
         * 
         */
        if (this.serviceEndpointSet==false)
        {
            List <Stereotype> activityStereotypes=activity.getAppliedStereotypes();
            if(activityStereotypes.size()!=0)
            {
                if(activityStereotypes.get(0).getName().equals("Service"))
                {
                    Stereotype service_stereotype=activityStereotypes.get(0);
                    this.setServiceEndpoint(activity.getValue(service_stereotype, "endpoint").toString());
                }
            }
            this.serviceEndpointSet=true;
        }

        
        List<ActivityNode> activity_nodes_backup = new ArrayList <ActivityNode>(); 
        for(int i=0;i<activity_nodes.size();i++)
        {
            activity_nodes_backup.add(activity_nodes.get(i));
        }
        
        
        
        List<ActivityEdge> activity_edges_backup = new ArrayList <ActivityEdge>(); 
        for(int i=0;i<activity.getEdges().size();i++)
        {
            activity_edges_backup.add(activity.getEdges().get(i));
        }
        
        
        
        while(activity_nodes_backup.size()>0)
        {
            List <Stereotype> service_stereotypes=activity_nodes_backup.get(0).getAppliedStereotypes();
            if(service_stereotypes.size()!=0)
            {
                if(service_stereotypes.get(0).getName().equals("Service"))
                {
                    Stereotype service_stereotype=service_stereotypes.get(0);
                    this.addActors(activity_nodes_backup.get(0), "Service", activity_nodes_backup.get(0).getValue(service_stereotype, "endpoint").toString());
                    
                }
                else if (service_stereotypes.get(0).getName().equals("Callback"))
                {
                    Stereotype service_stereotype=service_stereotypes.get(0);
                    this.addActors(activity_nodes_backup.get(0), "Callback", activity_nodes_backup.get(0).getValue(service_stereotype, "function").toString());
                    
                }
                //this else is added in case that element has some other stereotype that is not Service or Callback (e.g. <<Jointpoint>> in SUPERSEDE)
                else
                {
                    this.addActors(activity_nodes_backup.get(0), "","");
                    
                }
            
            }
            else
            {
                this.addActors(activity_nodes_backup.get(0), "","");
                
            }
            
            activity_nodes_backup.remove(activity_nodes_backup.get(0));
        }
        
        while(activity_edges_backup.size()>0)
        {
            ActivityEdge current_edge=activity_edges_backup.get(0);
            this.addConnections(current_edge, current_edge.getSource(), current_edge.getTarget());
            activity_edges_backup.remove(activity_edges_backup.get(0));
        }
        
        String xml_content = this.exportMoML();
        
        this.XMLPtolemyModel=xml_content;
        
        File file = null;  
        /**creating an output XML File from the model
         * 
         */
        try {
            file = new File("ptolemyModelFromJava.xml");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(xml_content);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
                  
            
    }
    
    public void inject() 
    {
        /**Srdjan: string encoding in order to be easily send over the network 
         * because of the string unsafely characters like ""
         */
                
        //Srdjan : REST POST without cURL
        try 
        {
       
           String encodedString = URLEncoder.encode(this.XMLPtolemyModel, "UTF-8");
           String URLString = this.serviceEndpoint.substring(1, this.serviceEndpoint.length()-1);
           URL url = new URL(URLString);
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
        catch (UnsupportedEncodingException e) {
            
            e.printStackTrace();
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
       
             e.printStackTrace();
       
        }
        
    }
    /** used to set the endpoint of the service being adapted as a composition of other services 
     * 
     * @param endpointStr
     */
    public void setServiceEndpoint (String endpointStr)
    {
        this.serviceEndpoint=endpointStr;
    }
 
  
}


