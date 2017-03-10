package eu.supersede.dynadapt.enactor.HypervisorEnactor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;

public class HypervisorEnactor {
	private static List<String> arguments = new ArrayList<String>();

	
	public static void serializeVMConfigurationScriptsInFolder (String absoluteHypervisorModelPath, String absoluteTargetFolderPath) throws IOException{
		URI modelURI = URI.createFileURI(absoluteHypervisorModelPath);
		File targetFolder = new File (absoluteTargetFolderPath);
		eu.supersede.dynadapt.enactor.HypervisorEnactor.Main generator = 
			new eu.supersede.dynadapt.enactor.HypervisorEnactor.Main(modelURI, targetFolder, arguments);
		
		generator.doGenerate(new BasicMonitor());
	}
}
