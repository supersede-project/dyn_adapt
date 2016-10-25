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

public class FeatureModelSerializerTest {
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
