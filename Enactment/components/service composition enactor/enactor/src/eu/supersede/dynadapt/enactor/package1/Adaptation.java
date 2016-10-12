package eu.supersede.dynadapt.enactor.package1;
import java.util.ArrayList;
import java.util.List;
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

public class Adaptation {

	//serialized output string
	private static ArrayList<String> adaptation_string = new ArrayList<String>(2);
	
	public static ArrayList<String> get_adaptation_string()
	{
		return Adaptation.adaptation_string;
	}
	
	public static String analyze(Activity activity,List<ActivityNode> activity_nodes)
	{
		
		//output curl adaptation string (index 0 - URL address, index 1 - adaptation steps to be executed)
		adaptation_string.add(0,"http://localhost:4567/adapt/https://nike.erd.siemens.at/supersede/"+ activity.getName()+"/");
		adaptation_string.add(1,"{steps: [");
				
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
				Adaptation.adaptation_string.set(1, Adaptation.adaptation_string.get(1)+"{ type: 'REST-GET', url:"+"'"+service_endpoint+"'"+", callback:\\\""+callback_function+"\\\"}");
			}
			else
			{
				Adaptation.adaptation_string.set(1, Adaptation.adaptation_string.get(1)+",{ type: 'REST-GET', url:"+"'"+service_endpoint+"'"+", callback:\\\""+callback_function+"\\\"}");
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
		
		Adaptation.adaptation_string.set(1, Adaptation.adaptation_string.get(1)+"]}");
		return "";		
		
	}
		
}
