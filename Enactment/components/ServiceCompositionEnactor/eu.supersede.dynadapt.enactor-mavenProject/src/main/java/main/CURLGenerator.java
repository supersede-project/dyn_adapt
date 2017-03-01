package main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import ptolemy.actor.TypedCompositeActor;
import ptolemy.actor.TypedIORelation;
import ptolemy.actor.lib.SingleEvent;
import ptolemy.domains.de.kernel.DEDirector;
import ptolemy.kernel.Relation;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;
import ptolemy.kernel.util.Workspace;

import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.DecisionNode;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.FinalNode;
import org.eclipse.uml2.uml.InitialNode;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;



public class CURLGenerator {

	//serialized output string
	private ArrayList<String> adaptationString = new ArrayList<String>();
	
	public ArrayList<String> get_adaptation_string()
	{
		return this.adaptationString;
	}
	
	/**This function works only for the serial execution of service-callback pairs, specified in the activity diagram.
	 * It generates CURL commands that are then injected to the system using the ProcessBuilder class (see fucntion injectAddaptation() below)
	 * The new PtolemyGenerator works for any specified workflow type (e.g. parallel execution of actors) 
	 * @param activity
	 * @param activity_nodes
	 * @return
	 */
	public void analyze(Activity activity,List<ActivityNode> activity_nodes)
	{
		
		//output curl adaptation string (index 0 - URL address, index 1 - adaptation steps to be executed)
	        this.adaptationString.add("http://localhost:4567/adapt/https://nike.erd.siemens.at/supersede/"+ activity.getName()+"/");
	        this.adaptationString.add("{steps: [");
				
		// finding the edge that is connected to the initial node
		ActivityEdge current_edge=null;
		for(int i=0;i<activity_nodes.size();i++)
		{
			if(activity_nodes.get(i) instanceof InitialNode)
			{
				current_edge=activity_nodes.get(i).getOutgoings().get(0);
				break;
			}
		}
		
		//analyzing the order the nodes in the activity diagram are connected 
		int number_nodes=activity_nodes.size()-2;
		int first_service=1; //used just for the "," when writing several steps in the curl
		while(number_nodes>0)
		{
			
			ActivityNode current_node=current_edge.getTarget();
			ActivityNode following_node=null;
			List <Stereotype> service_stereotypes=current_node.getAppliedStereotypes();
			String service_endpoint=null;
			String callback_function=null;
						
			if(service_stereotypes.size()!=0)
			{
				if(service_stereotypes.get(0).getName().equals("Service"))
				{
					Stereotype service_stereotype=service_stereotypes.get(0);
					service_endpoint=current_node.getValue(service_stereotype, "endpoint").toString();
					
					//getting the next node (callback)
					current_edge=current_node.getOutgoings().get(0);
					following_node=current_edge.getTarget();
					List <Stereotype> stereotypes_following_node=following_node.getAppliedStereotypes();
					if (stereotypes_following_node.size()!=0)
					{
						if(stereotypes_following_node.get(0).getName().equals("Callback"))
						{
							Stereotype stereotype_following_node=stereotypes_following_node.get(0);
							callback_function=following_node.getValue(stereotype_following_node, "function").toString();
						}						
					}
					else
					{
						callback_function="";
					}
				}
			}
			
			if(first_service==1)
			{
				first_service=0;
				this.adaptationString.set(this.adaptationString.size()-1, this.adaptationString.get(this.adaptationString.size()-1)+"{ type: 'REST-GET', url:"+"'"+service_endpoint+"'"+", callback:\\\""+callback_function+"\\\"}");
			}
			else
			{
				this.adaptationString.set(this.adaptationString.size()-1, this.adaptationString.get(this.adaptationString.size()-1)+",{ type: 'REST-GET', url:"+"'"+service_endpoint+"'"+", callback:\\\""+callback_function+"\\\"}");
			}
			
			if(!(following_node instanceof FinalNode))
			{
				current_edge=following_node.getOutgoings().get(0);
				number_nodes=number_nodes-2;		
			}
			else
			{
				number_nodes=0;
			}					
			
		}				
		
		this.adaptationString.set(this.adaptationString.size()-1, this.adaptationString.get(this.adaptationString.size()-1)+"]}");
			
		
	}

	/** injection of the generated CURL adaptation by executing the generated CURL command
	 * in the ProcessBuilder class
	 * @return
	 */
        public void inject() 
        {
            
            //this testing version of process builder is working fine (used before to create an appropriate process builder)
            //String s1="http://localhost:4567/adapt/https://nike.erd.siemens.at/supersede/format/";
            //String s2="{steps: [{ type: 'REST-GET', url: 'https://nike.erd.siemens.at/supersede/s0/', callback: \\\"function cb(jsonRequest, jsonReponse){ var reqRes = null; for(var i=0; i ^< jsonReponse.length;i++) { jsonResponse[i]['WIND_DIRECTION'] = jsonResponse[i]['WINDDIR']; delete jsonResponse[i]['WINDDIR']; }; reqRes = JSON.stringify(jsonResponse); return [ 'CONTINUE', reqRes]; }  \\\"}]}";
            //ProcessBuilder builder = new ProcessBuilder("curl", "-k", "-i", "-H", "Content-Type: application/json", s1 , "-XPOST", "-d", s2);
            
            ArrayList<String> adaptation = this.adaptationString;
            
            try {
                
                for(int i=0;i<adaptation.size()/2.;i++)
                {
                        String s1=adaptation.get(2*i);
                        String s2=adaptation.get(2*i+1);
                        ProcessBuilder builder = new ProcessBuilder("curl", "-k", "-i", "-H", "Content-Type: application/json", s1, "-XPOST", "-d", s2);
                        builder.redirectErrorStream(true);
                        Process p=builder.start();                         
                        
                        /**printing out the output received as a result of calling the corresponding REST function from cURL
                         * 
                         */
                        
                        StringBuilder sb = new StringBuilder();
                        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
                        String line=null;
                        while (true) {
                            line = r.readLine();
                            if (line == null) {
                                break;
                            }
                            sb.append(line);
                        }
                        System.out.println(sb);
                        
                }    
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        
    
        }
	


}