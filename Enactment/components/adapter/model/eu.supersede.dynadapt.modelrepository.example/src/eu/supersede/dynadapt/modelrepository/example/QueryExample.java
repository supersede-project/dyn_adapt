package eu.supersede.dynadapt.modelrepository.example;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Scanner;

import eu.supersede.dynadapt.dsl.aspect.Aspect;
/**All dependencies should be dynamically added using the MANIFEST file 
 * instead of adding them to the  buildpath*/
import eu.supersede.dynadapt.model.ModelManager;
import eu.supersede.dynadapt.modelrepository.persistence.ModelRepositoryPersistence;

public class QueryExample {

	public static void main(String[] args) {
		try {
			ModelManager mm = new ModelManager();

			/** Model Repository Persistence configuration, omit later */
			String userdir = System.getProperty("user.dir");
			Path path = FileSystems.getDefault().getPath(userdir, "/Models");
			URL persistenceLocation = new URL(path.toUri().toURL().toString());
			ModelRepositoryPersistence mrp = new ModelRepositoryPersistence(persistenceLocation);
			/***/
			
			String fileContent = new Scanner(new File(userdir+"/googleplay_api_googleplay_tool.aspect")).useDelimiter("\\Z").next();
			
			/** Substitute for calls to MRMS service */
			/**Store Model*/
			/*MRMS store model in FS*/
			URL fileURL= mrp.storeModel("1", "Monitoring", "Adaptation", "Adaptability", "MyFirstAspect", fileContent, ".aspect");
			/***/
			
			/*Retrieve the actual model from FS using the url obtained when storing it*/
			Aspect a = mm.loadAspectModel(fileURL.getPath());
			
			System.out.println(a.getName());
		}catch(IOException e)
	{
		e.printStackTrace();
	}
}

}
