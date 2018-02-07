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

import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

import eu.supersede.dynadapt.serializer.FMSerializer;

public class FeatureModelSerializerTest {

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
		String absoluteModelPath = "./input/refsq17/monitoring/feedbackreconfig/fm/FeedbackGatheringConfig.yafm";
		String absolutetargetFolderPath = "./serialization";
		new FMSerializer().serializeFMToArtifactsInFolder(absoluteModelPath, absolutetargetFolderPath);
	}
	
	@Test
	public void FCSerializerTest () throws IOException{		
		// NOTE: Edit this absolute paths before testing
		String absoluteFCModelPath = "./input/refsq17/monitoring/feedbackreconfig/fc/FeedbackGatheringConfigCurrent.yafc";
		String absoluteFMModelPath = "./input/refsq17/monitoring/feedbackreconfig/fm/FeedbackGatheringConfig.yafm";
		String absolutetargetFolderPath = "./serialization";
		new FMSerializer().serializeFCToArtifactsInFolder(absoluteFCModelPath, absoluteFMModelPath, absolutetargetFolderPath);
	}
	
	@Test
	public void SerializeAtosHSKTest () throws IOException{		
		// NOTE: Edit this absolute paths before testing
		String absoluteFCModelPath = "./input/atos_hsk/SmartPlatformFC_HSK_LowLoad.yafc";
		String absoluteFMModelPath = "./input/atos_hsk/SmartPlatformFM_HSK.yafm";
		String absolutetargetFolderPath = "./serialization";;
		new FMSerializer().serializeFMToArtifactsInFolder(absoluteFMModelPath, absolutetargetFolderPath);
		new FMSerializer().serializeFCToArtifactsInFolder(absoluteFCModelPath, absoluteFMModelPath, absolutetargetFolderPath);
	}
	
	@Test
	public void SerializeSiemens () throws IOException{		
		// NOTE: Edit this absolute paths before testing
		String absoluteFCModelPath = "../../../Scenarios/Siemens/SiemensModels/FeatureModel-S1c_dm.yafc";
		String absoluteFMModelPath = "../../../Scenarios/Siemens/SiemensModels/FeatureModel-S1c_dm.yafm";
		String absolutetargetFolderPath = "./serialization/siemens/";
		new FMSerializer().serializeFMToArtifactsInFolder(absoluteFMModelPath, absolutetargetFolderPath);
		new FMSerializer().serializeFCToArtifactsInFolder(absoluteFCModelPath, absoluteFMModelPath, absolutetargetFolderPath);
	}
	
	@Test
	public void SerializeMonitorReconfigurationTest () throws IOException{		
		// NOTE: Edit this absolute paths before testing
		String absoluteFCModelPath = "./input/httpMR/Scenario1/HttpMonitoringSystemConfigLowTimeslot.yafc";
		String absoluteFMModelPath = "./input/httpMR/Scenario1/HttpMonitoringSystemTimeslotFeatureModel.yafm";
		String absolutetargetFolderPath = "./serialization/httpMR/";;
		new FMSerializer().serializeFMToArtifactsInFolder(absoluteFMModelPath, absolutetargetFolderPath);
		new FMSerializer().serializeFCToArtifactsInFolder(absoluteFCModelPath, absoluteFMModelPath, absolutetargetFolderPath);
	}
}
