/*******************************************************************************
 * Copyright (c) 2016 Universitat Politécnica de Catalunya (UPC)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 * 	Quim Motger (UPC) - main development
 * 	
 * Initially developed in the context of SUPERSEDE EU project
 * www.supersede.eu
 *******************************************************************************/
package eu.supersede.monitor.reconfiguration.enactor;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import cz.zcu.yafmt.model.fc.FeatureConfiguration;

import org.eclipse.emf.common.util.URI;
import org.eclipse.uml2.uml.Model;

import eu.supersede.dynadapt.enactor.IEnactor;
import eu.supersede.dynadapt.model.ModelManager;
import eu.supersede.monitor.reconfiguration.executor.IMonitorReconfigExecutor;
import eu.supersede.monitor.reconfiguration.executor.MonitorReconfigExecutor;
import eu.supersede.reconfiguration.enactor.uml2json.Uml2Json;

public class MonitoringEnactor implements IEnactor {
	
	private final static Logger log = LogManager.getLogger(MonitoringEnactor.class);
	
	IMonitorReconfigExecutor executor;
	private ModelManager mm;
	
	private Path temp = null;
	
	public MonitoringEnactor() throws IOException {
		
		executor = new MonitorReconfigExecutor();
		
		mm = new ModelManager(false);
		
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
	
	@Override
	public void enactAdaptedModel(Model adaptedModel, Model originalModel, boolean demo) throws Exception {
				
		URI adaptedModelURI = mm.saveModelInTemporaryFolder(adaptedModel, adaptedModel.getName() + ".uml");
		Path temporaryFolder = createTemporaryDirectoryInFolder(temp);
		
		Uml2Json.deriveUMLToJsonInFolder(adaptedModelURI.toString(), temporaryFolder.toString());
		
		List<Path> paths = findFilesInFolderWithExtension (temporaryFolder, "txt");
		
		String json = new Scanner(new File(paths.get(0).toString())).useDelimiter("\\Z").next();
		//FIXME generated json has an extra comma at the closing
		json = json.replace(",\n}", "\n}");
		
		JsonObject jsonObject = (new JsonParser()).parse(json).getAsJsonObject();
		
		executor.executeMonitorReconfiguration(jsonObject);
		System.out.println(jsonObject);
		log.debug("Monitor updated correctly");
		
		
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
	
	private Path createTemporaryDirectoryInFolder(Path folder) throws IOException{
		Path temp = Files.createTempDirectory(folder, "");
		//Assert.assertNotNull("There was a problem creating a temporary directory", temp);
		return temp;
	}
	
	private Path createTemporaryDirectory() throws IOException{
		String userdir = System.getProperty("user.dir");
		Path path = FileSystems.getDefault().getPath(userdir);
		Path temp = Files.createTempDirectory(path, "");
		//Assert.assertNotNull("There was a problem creating a temporary directory", temp);
		return temp;
	}


	@Override
	public void enactAdaptedModel(Model adaptedModel, boolean demo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enactFeatureConfiguration(FeatureConfiguration newFeatureConfig, boolean demo) {
		// TODO Auto-generated method stub
		
	}

}
