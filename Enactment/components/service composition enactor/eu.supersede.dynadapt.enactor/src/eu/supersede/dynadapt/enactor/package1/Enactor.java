package eu.supersede.dynadapt.enactor.package1;

import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.InitialNode;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.internal.impl.ActivityImpl;
import org.eclipse.uml2.uml.internal.impl.ModelImpl;
import org.eclipse.uml2.uml.resource.UMLResource;

@SuppressWarnings("restriction")
public class Enactor implements IEnactor{

	public static void main(String[] args) {
	// TODO Auto-generated method stub
		
		Enactor main_class=new Enactor();
		System.out.print(main_class.getEnactmentCode());
        
	}

	@Override
	public String getEnactmentCode() {
		
		// TODO Auto-generated method stub
		// getting a UML resource 
		ResourceSet set = new ResourceSetImpl();
		set.getPackageRegistry().put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);
		set.getResourceFactoryRegistry().getExtensionToFactoryMap()
		   .put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()
		   .put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);
		Resource res = set.getResource(URI.createFileURI("D:/mars_workspace/test/S1.uml"), true);
		

		//Load the model (this is also working but the approach above is used)
//		URI modelUri = URI.createFileURI("D:/mars_workspace/test/model.uml");
//		ResourceSet modelSet = new ResourceSetImpl();
//		modelSet.getPackageRegistry().put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);
//		modelSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);
//		modelSet.createResource(modelUri);
//		Resource modelResource = modelSet.getResource(modelUri, true);
//		Model model = (Model)EcoreUtil.getObjectByType(modelResource.getContents(), UMLPackage.Literals.MODEL);

		
				
		// Load the profile 
//		URI profileUri = URI.createFileURI("D:/mars_workspace/Supersede-Profile/model.profile.uml");
//		ResourceSet profileSet = new ResourceSetImpl();
//		profileSet.getPackageRegistry().put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);
//		profileSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);
//		profileSet.createResource(profileUri);
//		Resource profileResource = profileSet.getResource(profileUri, true);
//		Profile profile = (Profile)EcoreUtil.getObjectByType(profileResource.getContents(), UMLPackage.Literals.PROFILE);
//		Profile sopraProfile = (Profile)profile.getOwnedMember("RootElement");
//		Stereotype Stereotype1 = (Stereotype)profile.getPackagedElements().get(0);
//		Stereotype Stereotype2 = (Stereotype)profile.getPackagedElements().get(1);

		
		
		ModelImpl root=(ModelImpl)res.getContents().get(0);
		ActivityImpl activity=(ActivityImpl)root.getPackagedElements().get(0);
		List <ActivityNode> activity_nodes=activity.getNodes();
		
		Adaptation.analyze(activity, activity_nodes);
						
		return Adaptation.get_adaptation_string();
		

		
	}

}
