package eu.supersede.dynadapt.feature.serializer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;

public class FMSerializer {
	private static List<String> arguments = new ArrayList<String>();
	
	/**
	 * Serializes an input feature model, as YAFMT FM instance, 
	 * into a number of artifacts: Grammar, JSON serialization of quality attributes
	 * @param absoluteFMModelPath absolute path location for FM
	 * @param absolutetargetFolderPath absolute path location for folder where to place generated artefacts
	 * @throws IOException
	 */
	public static void serializeFMToArtifactsInFolder (String absoluteFMModelPath, String absoluteTargetFolderPath) throws IOException{
		URI modelURI = URI.createFileURI(absoluteFMModelPath);
		File targetFolder = new File (absoluteTargetFolderPath);
		Main generator = new Main(modelURI, targetFolder, arguments);
		
		generator.doGenerate(new BasicMonitor());
	}
}
