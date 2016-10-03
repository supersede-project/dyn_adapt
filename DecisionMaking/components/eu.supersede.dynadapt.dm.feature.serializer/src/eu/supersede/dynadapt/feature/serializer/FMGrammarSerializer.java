package eu.supersede.dynadapt.feature.serializer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;

public class FMGrammarSerializer {
	private static List<String> arguments = new ArrayList<String>();
	
	public static void serializeGrammarInFolder (String absoluteModelPath, String absolutetargetFolderPath) throws IOException{
		URI modelURI = URI.createFileURI(absoluteModelPath);
		File targetFolder = new File (absolutetargetFolderPath);
		Main generator = new Main(modelURI, targetFolder, arguments);
		
		generator.doGenerate(new BasicMonitor());
	}
}
