/*******************************************************************************
 * Copyright (c) 2016 ATOS Spain S.A.
 * All rights reserved. Licensed under the Apache License, Version 2.0 (the "License");
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
 *     Yosu Gorroñogoitia (ATOS) - main development
 *
 * Initially developed in the context of SUPERSEDE EU project www.supersede.eu
 *******************************************************************************/
package eu.supersede.dynadapt.serializer;

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
		eu.supersede.dynadapt.feature.serializer.Main generator = new eu.supersede.dynadapt.feature.serializer.Main(modelURI, targetFolder, arguments);
		
		generator.doGenerate(new BasicMonitor());
	}
	
	public static void serializeFCToArtifactsInFolder (String absoluteFMModelPath, String absoluteTargetFolderPath) throws IOException{
		URI modelURI = URI.createFileURI(absoluteFMModelPath);
		File targetFolder = new File (absoluteTargetFolderPath);
		eu.supersede.dynadapt.configuration.serializer.Main generator = new eu.supersede.dynadapt.configuration.serializer.Main(modelURI, targetFolder, arguments);
		
		generator.doGenerate(new BasicMonitor());
	}
}
