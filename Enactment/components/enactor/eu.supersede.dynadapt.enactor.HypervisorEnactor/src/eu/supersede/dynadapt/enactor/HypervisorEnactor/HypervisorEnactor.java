package eu.supersede.dynadapt.enactor.HypervisorEnactor;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.uml.Model;
import org.junit.Assert;

public class HypervisorEnactor implements IEnactor{
	private final Logger log = LogManager.getLogger(this.getClass());
	private static List<String> arguments = new ArrayList<String>();
	private Path temp = null;
	
	public HypervisorEnactor () throws IOException {
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

	@Override
	public List<Path> enactAdaptedModel(Model adaptedModel) throws IOException {
		log.debug("Enacting adapted model: " + adaptedModel.getModel().getName());
		
		List<Path> enactedArtefacts = null;
		//Store model in temporary folder for models
		URI adaptedModelURI = saveModelInTemporaryFolder(adaptedModel, ".uml");
		
		//Create a temporary folder for serialization
		Path temporaryFolder = createTemporaryDirectoryInFolder(temp);
		
		//Serialize Hypervisor artifacts  in temporary folder
		serializeVMConfigurationScriptsInFolder (adaptedModelURI.toString(), temporaryFolder.toString());
		
		//Return list of generated artefacts
		enactedArtefacts = findFilesInFolderWithExtension (temporaryFolder, "ps1");
				
		return enactedArtefacts;
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

	//FIXME Move common methods to helper class (taken form Model Manager)
	private URI saveModelInTemporaryFolder(Model model, String suffixe) throws IOException {
		if (temp == null){
			temp = createTemporaryDirectory();
		}
		URI uri = createTemporaryURI (model.getName() + suffixe);
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(uri);
		resource.getContents().add(model);
		try {
			resource.save(null); // no save options needed
		} catch (IOException ioe) {
			throw ioe;
		}
		
		return uri;
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
	
	private URI createTemporaryURI (String surl){
		Path file = Paths.get(temp.toString(), surl);
		return URI.createURI(file.toString());
	}
}
