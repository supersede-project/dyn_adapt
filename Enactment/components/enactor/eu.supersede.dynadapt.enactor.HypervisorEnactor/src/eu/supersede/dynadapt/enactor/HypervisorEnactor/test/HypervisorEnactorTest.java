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

import org.junit.Before;
import org.junit.Test;

import eu.supersede.dynadapt.enactor.HypervisorEnactor.HypervisorEnactor;


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
			"/home/yosu/Projects/Supersede/workspaces/workspace-adaptation/eu.supersede.dynadapt.enactor.HypervisorEnactor/serialization";
		HypervisorEnactor.serializeVMConfigurationScriptsInFolder(absoluteModelPath, absoluteTargetFolderPath);
	}
	
}
