package eu.supersede.feedbackgathering.reconfiguration.enactor;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileSystems;
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
import org.eclipse.uml2.uml.Model;
import org.junit.Assert;

import cz.zcu.yafmt.model.fc.FeatureConfiguration;
import eu.supersede.dynadapt.enactor.IEnactor;
import eu.supersede.dynadapt.model.ModelManager;
import eu.supersede.dynadapt.model.compare.ModelCompare;
import eu.supersede.feedbackgathering.reconfiguration.util.ReconfigurationCommon;
import eu.supersede.reconfiguration.configurationProfile.Main;

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
	
	boolean remoteConnection;
	boolean simulated_execution;
	
	public FeedbackGatheringConfigurationProfile() throws IOException{
		// Properties
		/*feedbackProperties = loadProperties();
		
		// TODO Take passwords and all configurations for secure place		
		supersede_account_user = feedbackProperties.getProperty("supersede_account_user");
		supersede_account_passwd = feedbackProperties.getProperty("supersede_account_passwd");
				
		//hypervisor_account_passwd = hypervisorProperties.getProperty("hypervisor_account_passwd");
		supersede_platform_host = feedbackProperties.getProperty("supersede_platform_host");
				
		remoteConnection = Boolean.valueOf(feedbackProperties.getProperty("remote_connection"));
		simulated_execution = Boolean.valueOf(feedbackProperties.getProperty("simulated_execution"));*/
		
		//ModelManager
		mm = new ModelManager(false);
				
		//Create Temporary directory to store models 
		temp = ReconfigurationCommon.createTemporaryDirectory();
		
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

	/*private Path createTemporaryDirectory() throws IOException{
		String userdir = System.getProperty("user.dir");
		Path path = FileSystems.getDefault().getPath(userdir);
		Path temp = Files.createTempDirectory(path, "");
		Assert.assertNotNull("There was a problem creating a temporary directory", temp);
		return temp;
	}*/
	
	private Properties loadProperties() throws IOException{
		final Properties properties = new Properties();
		properties.load(this.getClass().getClassLoader().getResourceAsStream("feedback.properties"));
		return properties;
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
		
		//Enact adapted Model
		log.debug("Generating JSON for configuration profil: ");
		
		// Store new FC model in temporary folder
		String temporaryFolder = temp.toString();
		PrintWriter out = new PrintWriter(temporaryFolder + newFeatureConfig.getName() + ".yafc");
		out.print(newFeatureConfig.toString());

		// Generates the Json File 
		configurationProfileFC2JsonInFolder(temporaryFolder + newFeatureConfig.getName() + ".yafc", temporaryFolder);
		
		//Invoke Orchestrator for reconfiguration
	
	}
	
}
