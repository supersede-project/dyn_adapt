package eu.supersede.dynadapt.enactor.HypervisorEnactor;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Model;
import org.junit.Assert;

import eu.supersede.dynadapt.enactor.IEnactor;
import eu.supersede.dynadapt.model.ModelManager;
import eu.supersede.dynadapt.model.compare.DiffType;
import eu.supersede.dynadapt.model.compare.ModelCompare;
import eu.supersede.dynadapt.model.compare.ModelCompareImpl;

public class HypervisorEnactor implements IEnactor{
	private final Logger log = LogManager.getLogger(this.getClass());
	private static List<String> arguments = new ArrayList<String>();
	private Path temp = null;
	ModelManager mm = null;
	ModelCompare mc = null;
	Properties hypervisorProperties = null;
	String supersede_account_user;
	String supersede_account_passwd;
	
	String hypervisor_account_passwd;
	String supersede_platform_host;
	
	boolean remoteConnection;
	boolean simulated_execution;
	
	public HypervisorEnactor () throws IOException {
		//Hypervisor properties
		hypervisorProperties = loadHypervisorHookProperties();
		
		// TODO Take passwords and all configurations for secure place		
		supersede_account_user = hypervisorProperties.getProperty("supersede_account_user");
		supersede_account_passwd = hypervisorProperties.getProperty("supersede_account_passwd");
				
		hypervisor_account_passwd = hypervisorProperties.getProperty("hypervisor_account_passwd");
		supersede_platform_host = hypervisorProperties.getProperty("supersede_platform_host");
				
		remoteConnection = Boolean.valueOf(hypervisorProperties.getProperty("remote_connection"));
		simulated_execution = Boolean.valueOf(hypervisorProperties.getProperty("simulated_execution"));
		
		//ModelManager
		mm = new ModelManager(false);
		
		//Model Compare
		mc = new ModelCompareImpl();
		
		//Create Temporary directory to store models 
		temp = createTemporaryDirectory();
		
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
	
	public void serializeVMConfigurationScriptsInFolder (String absoluteHypervisorModelPath, String absoluteTargetFolderPath) throws IOException{
		URI modelURI = URI.createFileURI(absoluteHypervisorModelPath);
		File targetFolder = new File (absoluteTargetFolderPath);
		eu.supersede.dynadapt.enactor.HypervisorEnactor.Main generator = 
			new eu.supersede.dynadapt.enactor.HypervisorEnactor.Main(modelURI, targetFolder, arguments);
		
		generator.doGenerate(new BasicMonitor());
	}

	private List<Path> createEnactmentArtefactsForAdaptedModel(Model adaptedModel) throws Exception {
		log.debug("Enacting adapted model: " + adaptedModel.getModel().getName());
		
		List<Path> enactmentArtefacts = null;
		//Store model in temporary folder for models
		URI adaptedModelURI = mm.saveModelInTemporaryFolder(adaptedModel, ".uml");
		
		//Create a temporary folder for serialization
		Path temporaryFolder = createTemporaryDirectoryInFolder(temp);
		
		//Serialize Hypervisor artifacts  in temporary folder
		serializeVMConfigurationScriptsInFolder (adaptedModelURI.toString(), temporaryFolder.toString());
		
		//Return list of generated artefacts
		enactmentArtefacts = findFilesInFolderWithExtension (temporaryFolder, "ps1");
				
		return enactmentArtefacts;
	}
	
	@Override
	public void enactAdaptedModel(Model adaptedModel, Model originalModel, boolean demo) throws Exception {
		//Compute model differences
		log.debug("Comparing base and adapted models");
		Map<DiffType,Set<Element>> diffElements = mc.computeDifferencesBetweenModels (adaptedModel, originalModel);
		
		//Enact adapted Model
		log.debug("Generating Hypervisor scripts out of model: " + adaptedModel.getName());
		List<Path> enactmentArfifacts = createEnactmentArtefactsForAdaptedModel(adaptedModel);
		
		//Select enactment artifacts associated to model differences
		log.debug("Selecting scripts associated to model differences");
		enactmentArfifacts = selectDiffArtefacts (enactmentArfifacts, diffElements);
		
		//Invoke enactment artifacts in Hypervisor Hook
		log.debug("Enacting hypervisor scripts");
		invokeEnactmentArtefactsInHypervisorHook(enactmentArfifacts, demo);
	}
	
	@Override
	public void enactAdaptedModel(Model adaptedModel, boolean demo) throws Exception {
		//Enact adapted Model
		List<Path> enactmentArfifacts = createEnactmentArtefactsForAdaptedModel(adaptedModel);
		
		//Invoke enactment artifacts in Hypervisor Hook
		invokeEnactmentArtefactsInHypervisorHook(enactmentArfifacts, demo);
	}
	
	private Properties loadHypervisorHookProperties() throws IOException{
		final Properties properties = new Properties();
		properties.load(this.getClass().getClassLoader().getResourceAsStream("hypervisor.properties"));
		return properties;
	}
	
	private void invokeEnactmentArtefactsInHypervisorHook(List<Path> enactmentArfifacts, boolean demo) throws Exception {
		
		for (Path script: enactmentArfifacts){
			log.info("Enacting Hypervisor script: " + script);
			
			//Simulating enactment whenever demo is true (set in test) and if not, whenever simulated_execution is true (set by configuration)
			if (demo || simulated_execution){ 
				configureScriptForSimulation (script);
			}
			
			if (remoteConnection){
				//Upload script to supersede platform
				String uploadCommand = "sshpass -p '" + supersede_account_passwd + "' scp -o StrictHostKeyChecking=no " + script +
						" " + supersede_account_user + "@" + supersede_platform_host + ":powershell_scripts/ > " + script + ".log 2>&1";
				executeCommand(uploadCommand);
				log.debug("Uploaded script in " + supersede_platform_host + " with result: " + 
					readFile(Paths.get(script.toString())));
			}
			
			//Execute script
			String scriptCommand = getScriptCommand(remoteConnection, script);
		
			executeCommand(scriptCommand);
			log.info("Executed script " + script.getFileName() + " with result: " + 
				readFile(Paths.get(script.toString())));
		}
	}
	
	
	
	private void configureScriptForSimulation(Path script) throws IOException {
		String scriptContent = readFile(script);
		scriptContent = scriptContent.replace("-Confirm:$false", "-Confirm:$false -whatif");
		Files.write(script, scriptContent.getBytes(), StandardOpenOption.WRITE);
	}

	private String getScriptCommand (boolean remoteConnection, Path script){
		String scriptCommand;
		if (remoteConnection){
			scriptCommand = "sshpass -p '" + supersede_account_passwd + "' ssh -o StrictHostKeyChecking=no " + 
				supersede_account_user + "@" + supersede_platform_host + " \"powershell -File powershell_scripts/" + 
				script.getFileName() + " -password " + hypervisor_account_passwd + "\" > " + script + ".log 2>&1";
		}else{
			scriptCommand = "powershell -File " + 
				script + " -password " + hypervisor_account_passwd + "\" > " + script + ".log 2>&1";
		}
		return scriptCommand;
	}
	
	
	public String injectPowerShellScript (String scriptPath, String serverPassword, String hypervisorPassword) throws Exception{
		//Store script in temporary folder
		//Inject password in script
		Path originalScript = Paths.get (scriptPath);
		String scriptContent = readFile(originalScript);
		scriptContent = scriptContent.replace("$password", hypervisorPassword);
		Path temp = createTemporaryDirectory();
		Path script = temp.resolve(originalScript.getFileName());
		Files.write(script, scriptContent.getBytes(), StandardOpenOption.CREATE,StandardOpenOption.APPEND);
		
		
		return executeCommand(
			"sshpass -p '" + serverPassword + "' scp -o StrictHostKeyChecking=no " + script + " supersede@platform.supersede.eu:powershell_scripts/ 2>&1");
	}
	
	public String executePowerShellScript (String scriptName, String serverPassword, String hypervisorPassword) throws Exception{
		return executeCommand(
				"sshpass -p '" + serverPassword + "' ssh -o StrictHostKeyChecking=no supersede@platform.supersede.eu \"powershell -File powershell_scripts/" + scriptName + " -password " + hypervisorPassword + "\" 2>&1");
	}
	
	
	public String executeCommand(String command) throws Exception {

		StringBuffer output = new StringBuffer();
		String[] shellCommand = { "/bin/sh", "-c", command};

		Process p = Runtime.getRuntime().exec(shellCommand);
		p.waitFor();
		readOutput(output, p);
		readErrorOutput(output, p);

		return output.toString();

	}
	
	private String readFile (Path path) throws IOException{
		return new String(Files.readAllBytes(path));
	}

	private void readOutput(StringBuffer output, Process p) throws IOException {
		BufferedReader reader =
				new BufferedReader(new InputStreamReader(p.getInputStream()));

        String line = "";
        output.append ("Normal output:\n");
		while ((line = reader.readLine())!= null) {
			output.append(line + "\n");
		}
	}
	
	private void readErrorOutput(StringBuffer output, Process p) throws IOException {
		BufferedReader reader =
				new BufferedReader(new InputStreamReader(p.getErrorStream()));

        String line = "";
        output.append ("Error output:\n");
		while ((line = reader.readLine())!= null) {
			output.append(line + "\n");
		}
	}

	//TODO Move Model Comparator stuff to ModelManager helper class
	private List<Path> selectDiffArtefacts(List<Path> enactedArfifacts, Map<DiffType,Set<Element>> diffElements) {
		//Getting modified VMConfigurations in adapted model (modelA)
		
		List<Path> result = new ArrayList<>();
		for (Element e: diffElements.get(DiffType.DiffInModelA)){
			if (e instanceof InstanceSpecification){
				InstanceSpecification ie = (InstanceSpecification)e;
				if (ie.getClassifiers().size()>0 && ie.getClassifiers().get(0).getName().equals("VMConfiguration")){
					Path path = findPathWithName (enactedArfifacts, ie.getName());
					if (path!=null){
						result.add (path);
					}
				}
			}
		}
		
		return result;
	
	}

	private Path findPathWithName(List<Path> paths, String name) {
		Path result = null;
		for (Path path: paths){
			if (path.getFileName().toString().contains(name)){
				result = path;
				break;
			}
		}
		return result;
	}



	private List<Path> findFilesInFolderWithExtension(Path temporaryFolder, String extension) throws IOException {
		List<Path> files = new ArrayList<>();
		Files.walkFileTree(temporaryFolder, new SimpleFileVisitor<Path>() { 
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                throws IOException
            {
            	if (file.getFileName().toString().endsWith(extension)){
            		files.add (file);
            	}
                return FileVisitResult.CONTINUE;
            }
        }); 
		return files;
	}


	
	private Path createTemporaryDirectory() throws IOException{
		String userdir = System.getProperty("user.dir");
		Path path = FileSystems.getDefault().getPath(userdir);
		Path temp = Files.createTempDirectory(path, "");
		Assert.assertNotNull("There was a problem creating a temporary directory", temp);
		return temp;
	}
	
	private Path createTemporaryDirectoryInFolder(Path folder) throws IOException{
		Path temp = Files.createTempDirectory(folder, "");
		Assert.assertNotNull("There was a problem creating a temporary directory", temp);
		return temp;
	}
	
//	private URI createTemporaryURI (String surl){
//		Path file = Paths.get(temp.toString(), surl);
//		return URI.createURI(file.toString());
//	}


}
