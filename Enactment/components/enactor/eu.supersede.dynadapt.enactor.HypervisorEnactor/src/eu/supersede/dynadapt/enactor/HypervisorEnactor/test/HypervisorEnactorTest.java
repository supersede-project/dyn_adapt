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
package eu.supersede.dynadapt.enactor.HypervisorEnactor.test;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eu.supersede.dynadapt.enactor.IEnactor;
import eu.supersede.dynadapt.enactor.HypervisorEnactor.HypervisorEnactor;
import eu.supersede.dynadapt.model.ModelManager;


public class HypervisorEnactorTest {	
	@Before
	public void doSetup() throws IOException{
	}
	
	@Test
	public void FMSerializerAtosTest () throws IOException{		
		// NOTE: Edit this absolute paths before testing
		String absoluteModelPath = 
			"/home/yosu/Projects/Supersede/Git/dyn_adapt/Enactment/components/adapter/model/eu.supersede.dynadapt.adapter/repository/models/adapted/atos_smart_adapted_model.uml";
		String absoluteTargetFolderPath = 
			"/home/yosu/Projects/Supersede/Git/dyn_adapt/Enactment/components/enactor/eu.supersede.dynadapt.enactor.HypervisorEnactor/serialization";
		new HypervisorEnactor().serializeVMConfigurationScriptsInFolder(absoluteModelPath, absoluteTargetFolderPath);
	}
	
	@Test
	public void HypervisorEnactorInAtosHSKTest () throws Exception{		
		// NOTE: Edit this absolute paths before testing		
		String absoluteModelPath = 
			"/home/yosu/Projects/Supersede/Git/dyn_adapt/Enactment/components/adapter/model/eu.supersede.dynadapt.adapter/repository/models/adapted/atos_smart_adapted_model.uml";
		
		ModelManager mm = new ModelManager(false);
		Model adaptedModel = mm.loadUMLModel(absoluteModelPath);
		IEnactor enactor = new HypervisorEnactor();
		enactor.enactAdaptedModel(adaptedModel);
	}
	
	@Test
	public void HypervisorEnactorInAtosHSKTest2 () throws Exception{		
		// NOTE: Edit this absolute paths before testing		
		String originalModelPath = 
				"/home/yosu/Projects/Supersede/Git/dyn_adapt/Enactment/components/adapter/model/eu.supersede.dynadapt.adapter/repository/models/base/atos_smart_base_model.uml";
		String adaptedModelPath = 
			"/home/yosu/Projects/Supersede/Git/dyn_adapt/Enactment/components/adapter/model/eu.supersede.dynadapt.adapter/repository/models/adapted/atos_smart_adapted_model.uml";
		
		ModelManager mm = new ModelManager(false);
		Model originalModel = mm.loadUMLModel(originalModelPath);
		Model adaptedModel = mm.loadUMLModel(adaptedModelPath);
		IEnactor enactor = new HypervisorEnactor();
		enactor.enactAdaptedModel(adaptedModel, originalModel);
	}
	
	@Test
	public void ExecuteCommandTest () throws Exception{		
		HypervisorEnactor enactor = new HypervisorEnactor();
		System.out.println(enactor.executeCommand("sshpass -p '|>4rkFl4g80.' scp -o StrictHostKeyChecking=no /home/yosu/Projects/Supersede/Git/dyn_adapt/Enactment/components/enactor/eu.supersede.dynadapt.enactor.HypervisorEnactor/7099013625468193598/975766981687724842/HighLoadConfigurationBOInVM2_A.ps1 supersede@platform.supersede.eu:powershell_scripts/"));
		System.out.println(enactor.executeCommand("sshpass -p '|>4rkFl4g80.' ssh -o StrictHostKeyChecking=no supersede@platform.supersede.eu \"powershell -File powershell_scripts/HighLoadConfigurationBOInVM2_A.ps1 -password diverS1celar\""));
	}

}
