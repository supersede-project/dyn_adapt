package eu.supersede.dynadapt.serviceCompositionEnactor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.internal.impl.ActivityImpl;
import org.eclipse.uml2.uml.internal.impl.ModelImpl;
import org.eclipse.uml2.uml.resource.UMLResource;

import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;
import ptolemy.kernel.util.Workspace;

@SuppressWarnings("restriction")
public class ServiceCompositionEnactor implements eu.supersede.dynadapt.enactor.IEnactor{

	private Model umlEnactingModel=null;
	
	public static void main(String[] args) {

		/*
		String basePath = new File("").getAbsolutePath();
	    System.out.println(basePath);
		String FILENAME="./eu/supersede/dynadapt/enactor/package1/nashornHost.js";
		
		InputStream input=null;
		try {
			input = new FileInputStream("./src/eu/supersede/dynadapt/enactor/package1/nashornHost.js");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Reader reader = new InputStreamReader(input);
		BufferedReader br = new BufferedReader(reader);
		

		
		
		URL url=null;
		try {
			url = new URL ("jar:file:D:/SUPERSEDE/Code/eu.supersede.dynadapt.enactor/lib/jjs.jar!/ptolemy/actor/lib/jjs/nashornHost.js");
						
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		InputStream in=null;
		try {
			in = url.openStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
		ClassLoader classLoader=null;
            String referenceClassName = "ptolemy.util.FileUtilities";

            try {
                // WebStart: We might be in the Swing Event thread, so
                // Thread.currentThread().getContextClassLoader()
                // .getResource(entry) probably will not work so we
                // use a marker class.
                Class referenceClass = Class.forName(referenceClassName);
                classLoader = referenceClass.getClassLoader();
            } catch (Exception ex) {
                // IOException constructor does not take a cause
                IOException ioException = new IOException(
                        "Cannot look up class \"" + referenceClassName + "\" or get its ClassLoader.");
                ioException.initCause(ex);
                
            }
            String trimmedName="ptolemy/actor/lib/jjs/nashornHost.js";
            URL result = classLoader.getResource(trimmedName);
            InputStreamReader inputStreamReader = null;
            try {
				inputStreamReader = new InputStreamReader(result.openStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            BufferedReader buf_red=new BufferedReader(inputStreamReader);
            ScriptEngineManager factory = new ScriptEngineManager();
            // Create a Nashorn script engine
            ScriptEngine engine = factory.getEngineByName("nashorn");
            
            try {
                Object res=engine.eval(buf_red);
                int i=3;
            } catch (Throwable throwable) {
                System.out.println("ewedwde");
            }
			
		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		System.out.println("Current relative path is: " + s);
		
		*/
		
		
		
		
		
		
		ServiceCompositionEnactor main_class=new ServiceCompositionEnactor();
		main_class.getEnactmentCode();
        
	}

	public String getEnactmentCode() {
		
		// TODO Auto-generated method stub
		/** getting a UML resource (activity diagram from which the enactment code is generated)
		 * 
		 */
		ResourceSet set = new ResourceSetImpl();
		set.getPackageRegistry().put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);
		set.getResourceFactoryRegistry().getExtensionToFactoryMap()
		   .put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()
		   .put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);
		
		//this 3 lines of code are used for testing the Enactor with a uml model to be enacted that is located on the local file system 
		//Resource res2 = set.getResource(URI.createFileURI("/home/user/workspace_RCP/test/S2.uml"), true);
		//ArrayList<Resource> res_list = new ArrayList<Resource>();
		//res_list.add(res2);
		
		/**Load the model (this is also working but the approach above is used)
		 * 
		 */
//		URI modelUri = URI.createFileURI("D:/mars_workspace/test/model.uml");
//		ResourceSet modelSet = new ResourceSetImpl();
//		modelSet.getPackageRegistry().put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);
//		modelSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);
//		modelSet.createResource(modelUri);
//		Resource modelResource = modelSet.getResource(modelUri, true);
//		Model model = (Model)EcoreUtil.getObjectByType(modelResource.getContents(), UMLPackage.Literals.MODEL);

		
				
		/** Load the profile
		 *  
		 */
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

		PtolemyGenerator ptolemyModel = null;
		try {
                    ptolemyModel = new PtolemyGenerator(new Workspace());
		} catch (IllegalActionException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
		} catch (NameDuplicationException e) {
		    // TODO Auto-generated catch block
                    e.printStackTrace();
		}
		
		CURLGenerator CURLcode = new CURLGenerator();
		
		ActivityImpl activity=(ActivityImpl)this.umlEnactingModel.getPackagedElements().get(0);
		List <ActivityNode> activity_nodes=activity.getNodes();
		//CURLcode.analyze(activity, activity_nodes);
		//CURLcode.inject();
		ptolemyModel.analyze(activity, activity_nodes);
		ptolemyModel.inject();
		
						
		return "";
		
				
	}

	public void enactAdaptedModel(Model adaptedModel) throws Exception {
		// TODO Auto-generated method stub
		this.umlEnactingModel=adaptedModel;
		this.getEnactmentCode();
		
	}

	public void enactAdaptedModel(Model arg0, Model arg1) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
