/*******************************************************************************
 * Copyright (c) 2016 Universitat Politécnica de Catalunya (UPC), ATOS Spain S.A
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
 * 	Edith Zavala (UPC) - main development
 * 	
 * Initially developed in the context of SUPERSEDE EU project
 * www.supersede.eu
 *******************************************************************************/

package eu.supersede.dynadapt.featuremodel.fctest;

import java.io.IOException;
import java.util.Iterator;

import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import eu.supersede.dynadapt.featuremodel.fc.FeatureConfigDAO;
import eu.supersede.dynadapt.featuremodel.fc.FeatureConfigLAO;
import eu.supersede.dynadapt.featuremodel.fc.FeatureConfigSUPERSEDE;
import eu.supersede.dynadapt.featuremodel.fc.IFeatureConfigLAO;
import eu.supersede.dynadapt.featuremodel.selection.SelectionLAO;
import eu.supersede.dynadapt.featuremodel.selection.SelectionSUPERSEDE;

public class FeatureConfigLAOTest {

	String featureConfigPath = "platform:/resource/eu.supersede.dynadapt.featuremodel/models/MonitoringSystemConfigDefault.yafc";

	String featureModelPath = "platform:/resource/eu.supersede.dynadapt.featuremodel/models/MonitoringSystem.yafm";

	IFeatureConfigLAO fcLAO = null;

	@Before
	public void setUp() throws Exception {
//		new StandaloneSetup().setPlatformUri("../");
		fcLAO = new FeatureConfigLAO(new FeatureConfigDAO());
	}

	@After
	public void cleanUp() {

	}

	@Test
	public void testValidFeatureConfigSUPERSEDE() throws IOException {
		FeatureConfigSUPERSEDE fc = fcLAO.getFeatureConfigSUPERSEDE(featureConfigPath, featureModelPath);

//		System.out.println("Model name: " + fc.getName());
//
//		System.out.println("Model selections-------------");
//		Iterator<SelectionSUPERSEDE> itselections = fc.getSelections().iterator();
//		SelectionLAO sLAO = new SelectionLAO();
//		while (itselections.hasNext()) {
//			System.out.println(itselections.next().getClass());
//		}
	}

}
