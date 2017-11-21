/*******************************************************************************
 * Copyright (c) 2016 FBK
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
 *     Denisse Muñante (FBK) - main development
 *
 * Initially developed in the context of SUPERSEDE EU project www.supersede.eu
 *******************************************************************************/
package eu.supersede.reconfiguration.enactor.uml2json;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;

public class Uml2Json {
private static List<String> arguments = new ArrayList<String>();
	
	/**
	 * Derives from a UML model to JSON entries
	 * @param absoluteUMLModelPath absolute path location for UML model
	 * @param absolutetargetFolderPath absolute path location for folder where to place generated JSON entries
	 * @throws IOException
	 */
	public static void deriveUMLToJsonInFolder (String absoluteUMLModelPath, String absoluteTargetFolderPath) throws IOException{
		URI modelURI = URI.createFileURI(absoluteUMLModelPath);
		File targetFolder = new File (absoluteTargetFolderPath);
		GenerateJson generator = new GenerateJson(modelURI, targetFolder, arguments);
		
		generator.doGenerate(new BasicMonitor());
	}
}
