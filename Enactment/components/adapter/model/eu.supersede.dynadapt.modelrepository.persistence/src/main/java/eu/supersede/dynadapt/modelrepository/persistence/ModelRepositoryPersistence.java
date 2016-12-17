package eu.supersede.dynadapt.modelrepository.persistence;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/*******************************************************************************
 * Copyright (c) 2016 Universitat Politécnica de Catalunya (UPC)
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 *
 * Contributors: Edith Zavala (UPC) - main development
 * 
 * Initially developed in the context of SUPERSEDE EU project www.supersede.eu
 *******************************************************************************/

public class ModelRepositoryPersistence {

	private URL persistenceLocation;

	/**
	 * This method creates a Model Repository Persistence instance with the
	 * specified persistence location where it should locate the models.
	 */
	public ModelRepositoryPersistence(URL persistenceLocation) {
		super();
		this.persistenceLocation = persistenceLocation;
	}

	/**
	 * This method stores a model in this Model Repository Persistence instance
	 * under the specified system, sender and modelType folders with the
	 * indicated id as name, content and extension 
	 */
	public URL storeModel(String id, String system, String sender, String modelType, String modelName, String fileContent, String fileExtension) {
		URL url = null;
		try {
			File file = new File(this.persistenceLocation.getPath() + "/" + system + "/" + sender + "/" + modelType + "/" + modelName + "_" + id
					+ fileExtension);
			file.getParentFile().mkdirs();
			file.createNewFile();

			FileOutputStream fos = new FileOutputStream(file.getPath());
			Writer writer = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"));
			writer.write(fileContent);
			writer.close();

			url = new URL(file.toURI().toURL().toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return url;
	}
}