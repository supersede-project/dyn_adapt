package eu.supersede.dynadapt.feature.serializer.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;
import org.junit.Before;
import org.junit.Test;

import eu.supersede.dynadapt.feature.serializer.FMSerializer;
import eu.supersede.dynadapt.feature.serializer.Main;

public class FeatureModelGrammarSerializerTest {
	private URI modelURI;
	private File targetFolder;
	private List<String> arguments = new ArrayList<String>();
	private Main generator;
	
	@Before
	public void doSetup() throws IOException{
		// NOTE: Edit this absolute paths before testing
//		String absoluteModelPath = "/home/yosu/Projects/Supersede/Git/yafmt/examples/CarExample/CarExample.yafm";
//		String absolutetargetFolderPath = "/home/yosu/Projects/Supersede/Git/dyn_adapt/PoC/eu.supersede.dynadapt.poc.feature.serializer/serialization";
		
//		modelURI = URI.createFileURI(absoluteModelPath);
//		targetFolder = new File (absolutetargetFolderPath);
//		generator = new Main(modelURI, targetFolder, arguments);
	}
	
	@Test
	public void FMSerializerTest () throws IOException{		
		// NOTE: Edit this absolute paths before testing
		String absoluteModelPath = "/home/yosu/Projects/Supersede/Git/dyn_adapt/Scenarios/Atos/eu.supersede.dynadapt.usecases.atos/features/models/AtosUCFeatureModel_CMS_Capacity.yafm";
		String absolutetargetFolderPath = "/home/yosu/Projects/Supersede/Git/dyn_adapt/DM/components/eu.supersede.dynadapt.dm.feature.serializer/serialization";
		FMSerializer.serializeFMToArtifactsInFolder(absoluteModelPath, absolutetargetFolderPath);
	}
}
