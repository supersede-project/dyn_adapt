package eu.supersede.dynadapt.serviceCompositionEnactor;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.internal.impl.ActivityImpl;
import org.eclipse.uml2.uml.resource.UMLResource;

import cz.zcu.yafmt.model.fc.FeatureConfiguration;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;
import ptolemy.kernel.util.Workspace;

import java.nio.file.Paths;

import cz.zcu.yafmt.model.fc.FeatureConfiguration;


@SuppressWarnings("restriction")
public class ServiceCompositionEnactor implements eu.supersede.dynadapt.enactor.IEnactor{
	private final Logger log = LogManager.getLogger(this.getClass());
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
		main_class.injectUMLModelsForValidation();
		main_class.getEnactmentCodeHardCoded();
        
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
		//Resource res1 = set.getResource(URI.createFileURI("D:/mars_workspace/test/S1.uml"), true);
		//Resource res2 = set.getResource(URI.createFileURI("/home/user/workspace_RCP/test/S2.uml"), true);
		//Resource res2 = set.getResource(URI.createFileURI("/home/user/workspace_RCP/test/SiemensBaseModel.uml"), true);

		/*
		 * Comment the below lines for setting this.umlEnactingModel, when executing from SUPERSEDE components.
		 * They are just used for testing the UML models locally  
		 */		
		//Resource res2 = set.getResource(URI.createFileURI("/home/user/workspace_RCP/test-Srdjo/S2.uml"), true);
		//Resource res2 = set.getResource(URI.createFileURI("/home/user/workspace_RCP/test-Srdjo/S2_unavailable.uml"), true);
		//Resource res2 = set.getResource(URI.createFileURI("/home/user/workspace_RCP/eu.supersede.dynadapt.enactor-mavenProject/umlmodels-validation/S2_unavailable_variant1.uml"), true);
		//Resource res2 = set.getResource(URI.createFileURI("/home/user/workspace_RCP/UmlModelsSUPERSEDE/SiemensBaseModel_32bd5fab-9aa7-481c-b1a0-10ea63a5b8a3.uml"), true);
	
//		String umlModelsPath=Paths.get(".").toAbsolutePath().normalize().toString();
//		String res2_3_path_initial_variant=umlModelsPath+"/repository/umlmodels-validation/S2_unavailable_variant1.uml";
//		System.out.println("Enacting model: " + res2_3_path_initial_variant);
//		Resource res2 = set.getResource(URI.createFileURI(res2_3_path_initial_variant), true);
//		
//		
//		//String umlModelsPath=Paths.get(".").toAbsolutePath().normalize().toString();
//		//String res2_path=umlModelsPath+"/umlmodels-validation/S2_unavailable_variant1.uml";
//		//Resource res2 = set.getResource(URI.createFileURI(res2_path), true);
//		Model umlModel = (Model)EcoreUtil.getObjectByType(res2.getContents(), UMLPackage.Literals.MODEL);
//		this.umlEnactingModel=umlModel;
		
		
		/*
		 * How to get the activity diagram from the Resource
		 */
		//Resource res=res_list.get(i);
		//ModelImpl root=(ModelImpl)res.getContents().get(0);
		//ActivityImpl activity=(ActivityImpl)root.getPackagedElements().get(0);
		
		
		
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
		
		//CURLGenerator CURLcode = new CURLGenerator();
				
		ActivityImpl activity=(ActivityImpl)this.umlEnactingModel.getPackagedElements().get(0);
		
		List <ActivityNode> activity_nodes=activity.getNodes();
		//CURLcode.analyze(activity, activity_nodes);
		//CURLcode.inject();
		ptolemyModel.analyze(activity, activity_nodes);
		ptolemyModel.inject();
		
						
		return "";
		
				
	}

	public String getEnactmentCodeHardCoded() {
		
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
		//Resource res1 = set.getResource(URI.createFileURI("D:/mars_workspace/test/S1.uml"), true);
		//Resource res2 = set.getResource(URI.createFileURI("/home/user/workspace_RCP/test/S2.uml"), true);
		//Resource res2 = set.getResource(URI.createFileURI("/home/user/workspace_RCP/test/SiemensBaseModel.uml"), true);

		/*
		 * Comment the below lines for setting this.umlEnactingModel, when executing from SUPERSEDE components.
		 * They are just used for testing the UML models locally  
		 */		
		//Resource res2 = set.getResource(URI.createFileURI("/home/user/workspace_RCP/test-Srdjo/S2.uml"), true);
		//Resource res2 = set.getResource(URI.createFileURI("/home/user/workspace_RCP/test-Srdjo/S2_unavailable.uml"), true);
		//Resource res2 = set.getResource(URI.createFileURI("/home/user/workspace_RCP/eu.supersede.dynadapt.enactor-mavenProject/umlmodels-validation/S2_unavailable_variant1.uml"), true);
		//Resource res2 = set.getResource(URI.createFileURI("/home/user/workspace_RCP/UmlModelsSUPERSEDE/SiemensBaseModel_32bd5fab-9aa7-481c-b1a0-10ea63a5b8a3.uml"), true);
	
		String umlModelsPath=Paths.get(".").toAbsolutePath().normalize().toString();
		String res2_3_path_initial_variant=umlModelsPath+"/repository/umlmodels-validation/S2_unavailable_variant1.uml";
		System.out.println("Enacting model: " + res2_3_path_initial_variant);
		Resource res2 = set.getResource(URI.createFileURI(res2_3_path_initial_variant), true);
		
		
		//String umlModelsPath=Paths.get(".").toAbsolutePath().normalize().toString();
		//String res2_path=umlModelsPath+"/umlmodels-validation/S2_unavailable_variant1.uml";
		//Resource res2 = set.getResource(URI.createFileURI(res2_path), true);
		Model umlModel = (Model)EcoreUtil.getObjectByType(res2.getContents(), UMLPackage.Literals.MODEL);
		this.umlEnactingModel=umlModel;
		
		
		/*
		 * How to get the activity diagram from the Resource
		 */
		//Resource res=res_list.get(i);
		//ModelImpl root=(ModelImpl)res.getContents().get(0);
		//ActivityImpl activity=(ActivityImpl)root.getPackagedElements().get(0);
		
		
		
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
		
		//CURLGenerator CURLcode = new CURLGenerator();
				
		ActivityImpl activity=(ActivityImpl)this.umlEnactingModel.getPackagedElements().get(0);
		
		List <ActivityNode> activity_nodes=activity.getNodes();
		//CURLcode.analyze(activity, activity_nodes);
		//CURLcode.inject();
		ptolemyModel.analyze(activity, activity_nodes);
		ptolemyModel.inject();
		
						
		return "";
		
				
	}
	
	
	public String injectUMLModelsForValidation() {
		
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
		//Resource res1 = set.getResource(URI.createFileURI("D:/mars_workspace/test/S1.uml"), true);
		//Resource res2 = set.getResource(URI.createFileURI("/home/user/workspace_RCP/test/S2.uml"), true);
		//Resource res2 = set.getResource(URI.createFileURI("/home/user/workspace_RCP/test/SiemensBaseModel.uml"), true);

		/*
		 * Comment the below 4 lines when executing from SUPERSEDE components.
		 * They are just used for testing the UML models locally  
		 */		
		//Resource res2 = set.getResource(URI.createFileURI("/home/user/workspace_RCP/test-Srdjo/S2.uml"), true);

		
		//Resource res2_1 = set.getResource(URI.createFileURI("/home/user/workspace_RCP/test-Srdjo/S2_unavailable5.uml"), true);
		//Resource res2_2 = set.getResource(URI.createFileURI("/home/user/workspace_RCP/test-Srdjo/S2_unavailable10.uml"), true);
		//Resource res2 = set.getResource(URI.createFileURI("/home/user/workspace_RCP/UmlModelsSUPERSEDE/SiemensBaseModel_32bd5fab-9aa7-481c-b1a0-10ea63a5b8a3.uml"), true);

		//Resource res2_1 = set.getResource(URI.createFileURI("/home/user/workspace_RCP/eu.supersede.dynadapt.enactor-mavenProject/umlmodels-validation/S2_unavailable5.uml"), true);
		//Resource res2_2 = set.getResource(URI.createFileURI("/home/user/workspace_RCP/eu.supersede.dynadapt.enactor-mavenProject/umlmodels-validation/S2_unavailable10.uml"), true);

		String umlModelsPath=Paths.get(".").toAbsolutePath().normalize().toString();
		String res2_1_path=umlModelsPath+"/repository/umlmodels-validation/S2_unavailable5.uml";
		String res2_2_path=umlModelsPath+"/repository/umlmodels-validation/S2_unavailable10.uml";
		Resource res2_1 = set.getResource(URI.createFileURI(res2_1_path), true);
		Resource res2_2 = set.getResource(URI.createFileURI(res2_2_path), true);
		//Resource res2_3_initial_variant = set.getResource(URI.createFileURI(res2_3_path_initial_variant), true);

		Model umlModel_1 = (Model)EcoreUtil.getObjectByType(res2_1.getContents(), UMLPackage.Literals.MODEL);
		Model umlModel_2 = (Model)EcoreUtil.getObjectByType(res2_2.getContents(), UMLPackage.Literals.MODEL);
		//Model umlModel_3_initial_variant = (Model)EcoreUtil.getObjectByType(res2_3_initial_variant.getContents(), UMLPackage.Literals.MODEL);
		List<Model> uml_models_to_inject=new ArrayList<Model>();
		uml_models_to_inject.add(umlModel_1);
		uml_models_to_inject.add(umlModel_2);
		//uml_models_to_inject.add(umlModel_3_initial_variant);
		
		/*
		 * How to get the activity diagram from the Resource
		 */
		//Resource res=res_list.get(i);
		//ModelImpl root=(ModelImpl)res.getContents().get(0);
		//ActivityImpl activity=(ActivityImpl)root.getPackagedElements().get(0);
		
		
		
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
		
		//CURLGenerator CURLcode = new CURLGenerator();
		for(int i=0;i<uml_models_to_inject.size();i++)
		{		
			ActivityImpl activity=(ActivityImpl)uml_models_to_inject.get(i).getPackagedElements().get(0);
			List <ActivityNode> activity_nodes=activity.getNodes();
			//CURLcode.analyze(activity, activity_nodes);
			//CURLcode.inject();
			ptolemyModel.analyze(activity, activity_nodes);
			ptolemyModel.inject();
		}
						
		return "";
		
				
	}
	
	@Override
	public void enactAdaptedModel(Model adaptedModel, boolean demo) throws Exception {	
		log.debug("Enacting model: " + adaptedModel.getName());
		this.umlEnactingModel=adaptedModel;
		this.injectUMLModelsForValidation();
		this.getEnactmentCode();
	}

	@Override
	public void enactAdaptedModel(Model adaptedModel, Model originalModel, boolean demo) throws Exception {
		enactAdaptedModel (adaptedModel, demo);		
	}
	
	@Override
	public void enactFeatureConfiguration(FeatureConfiguration newFeatureConfig, boolean demo) {
		// TODO Auto-generated method stub
		// Ignore: Hypervisor enactor does not directly enact a FC
	}

}
