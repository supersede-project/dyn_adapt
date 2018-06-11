package eu.supersede.feedbackgathering.reconfiguration.enactor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.json.JSONArray;

import cz.zcu.yafmt.model.fc.FeatureConfiguration;
import eu.supersede.dynadapt.enactor.IEnactor;
import eu.supersede.dynadapt.model.ModelManager;
import eu.supersede.dynadapt.model.compare.ModelCompare;
import eu.supersede.feedbackgathering.reconfiguration.util.ReconfigurationCommon;
import eu.supersede.reconfiguration.configurationProfile.Main;
import eu.supersede.integration.api.adaptation.types.ModelSystem;
import eu.supersede.integration.api.feedback.orchestrator.types.Mechanism;
import eu.supersede.integration.api.feedback.orchestrator.types.Parameter;
import eu.supersede.integration.api.feedback.proxies.FeedbackOrchestratorProxy;

public class FeedbackGatheringConfigurationProfile implements IEnactor {
	
	private final Logger log = LogManager.getLogger(this.getClass());
	private static List<String> arguments = new ArrayList<String>();
	private Path temp = null;
	ModelManager mm = null;
	ModelCompare mc = null;
	Properties feedbackProperties = null;
	String supersede_account_user;
	String supersede_account_passwd;
	
	//String hypervisor_account_passwd;
	String supersede_platform_host;
	
	String server;
	boolean simulated_execution;

	private ResourceSet resourceSet;
	
	//Orchestrator for the FG tool
	private FeedbackOrchestratorProxy<?, ?> proxy;
	//private String token;
	private long idApplication;
	private long idConfiguration;
	
	public FeedbackGatheringConfigurationProfile(ModelSystem system) throws Exception{

		resourceSet = new ResourceSetImpl();
		
		// Properties
		feedbackProperties = loadProperties();
		
		// TODO Take passwords and all configurations for secure place		
		supersede_account_user = feedbackProperties.getProperty("supersede_account_user");
		supersede_account_passwd = feedbackProperties.getProperty("supersede_account_passwd");
				
		//hypervisor_account_passwd = hypervisorProperties.getProperty("hypervisor_account_passwd");
		supersede_platform_host = feedbackProperties.getProperty("supersede_platform_host");
				
		server = feedbackProperties.getProperty("server");
		simulated_execution = Boolean.valueOf(feedbackProperties.getProperty("simulated_execution"));
		
		idApplication = ReconfigurationCommon.getIdApplication(system, server, feedbackProperties);
		idConfiguration = ReconfigurationCommon.getIdConfiguration(system, server, feedbackProperties);
		
		//ModelManager
		mm = new ModelManager(false);
				
		//Create Temporary directory to store models 
		temp = ReconfigurationCommon.createTemporaryDirectory();
		
		//Instantiation of Orchestrator
		proxy = new FeedbackOrchestratorProxy<Object, Object>(supersede_account_user, supersede_account_passwd);
		//token = proxy.authenticate(supersede_account_user, supersede_account_passwd);
		
		//Shutdown hook to clean up temporary folder
		Runtime.getRuntime().addShutdownHook(new Thread() {
		    public void run() {
		        try {
		        	if (temp != null){
		        		Files.walk(temp)
		        	    .sorted(Comparator.reverseOrder())
		        	    .map(Path::toFile)
		        	    .peek(System.out::println)
		        	    .forEach(File::delete);
		        	}
				} catch (IOException e) {
					e.printStackTrace();
				}
		    }
		});	
	}
	
	private Properties loadProperties() throws IOException{
		final Properties properties = new Properties();
		properties.load(this.getClass().getClassLoader().getResourceAsStream("feedback.properties"));
		return properties;
	}

	protected void saveFC(cz.zcu.yafmt.model.fc.FeatureConfiguration fc, URI fcURI) throws IOException{
		Resource resource = resourceSet.createResource(fcURI);
        resource.getContents().add(fc);
        resource.save(null);
	}
	
	/**
	 * Derives from a Feature Configuration (FC) model to JSON entries
	 * This method takes a (FC) that contains feature with their configuration profiles
	 * @param absoluteFCModelPath absolute path location for FC model
	 * @param absolutetargetFolderPath absolute path location for folder where to place generated JSON entries
	 * @throws IOException
	 */
	public void configurationProfileFC2JsonInFolder (String absoluteFCModelPath, String absoluteTargetFolderPath) throws IOException{
		URI modelURI = URI.createFileURI(absoluteFCModelPath);
		File targetFolder = new File (absoluteTargetFolderPath);
		Main generator = new Main(modelURI, targetFolder, arguments);
		
		generator.doGenerate(new BasicMonitor());
	}
	
	@Override
	public void enactFeatureConfiguration(FeatureConfiguration newFeatureConfig, boolean demo) throws Exception{
				
		String temporaryFile = "";
		
		//Enact adapted Model
		log.debug("Generating JSON for configuration profil: ");
		
		// Save new FC model in temporary folder
		temporaryFile = temp + "/" + newFeatureConfig.getName() + ".yafc";
		saveFC(newFeatureConfig, URI.createFileURI(temporaryFile));
		
		// Generates the Json File 
		configurationProfileFC2JsonInFolder(temporaryFile, temp.toString());		
		
		//Read the Json file
		JSONArray arr = ReconfigurationCommon.readJsonArray(temp.toString() + "/", newFeatureConfig.getName() + ".json");
		
		//Invoke Orchestrator for reconfiguration
		Mechanism objMechanism = null;
		Parameter objParam = null;
		boolean changeParam; 
		List<Mechanism> mechanisms = proxy.getConfiguration(idApplication, idConfiguration).getMechanisms();
				//proxy.getMechanismsOfApplication(idApplication);
		for (int i = 0; i < arr.length(); i++){
			for(Mechanism m : mechanisms){
				if(m.isActive() && m.getType().name().equals(arr.getJSONObject(i).getString("type"))){
					objMechanism = m;
					break;
				}
			}
			if(objMechanism != null){
				JSONArray lstParam = arr.getJSONObject(i).getJSONArray("parameters");
				//Update the parameters of the mechanism
				for(int j=0; j < lstParam.length() ; j++){
					changeParam = false; 
					for(Parameter p : objMechanism.getParameters()){
						if(lstParam.getJSONObject(j).getString("key").toUpperCase().equals(
								p.getKey().toUpperCase())){
							//update the parameter
							changeParam = true;
							p.setValue(lstParam.getJSONObject(j).getString("value"));
							objParam = p;
							break;
						}
					}
					//For each parameter to be modified in Mechanism
					if(changeParam){
						//Invoke Orchestrator for reconfiguration
						Integer idMechanism = new Integer ((int)objMechanism.getId());
						proxy.updateParameterInMechanism(objParam, idMechanism);
						//log.debug("The parameter " + objParam.getId() + "whose key is " + objParam.getKey() + " was modified to value " + objParam.getValue());
					}
				}	
				
			}
		}

	}
}