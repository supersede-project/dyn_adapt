/*******************************************************************************
 * Copyright (c) 2016 UPC
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

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cz.zcu.yafmt.model.fc.FeatureConfiguration;
import cz.zcu.yafmt.model.fc.Selection;
import eu.supersede.dynadapt.featuremodel.fc.FeatureConfigDAO;
import eu.supersede.dynadapt.featuremodel.fc.FeatureConfigSUPERSEDE;
import eu.supersede.dynadapt.featuremodel.fc.IFeatureConfigDAO;

public class FeatureConfigDAOTest {

	String featureConfigPath = "platform:/resource/eu.supersede.dynadapt.featuremodel/models/MonitoringSystemConfigDefault.yafc";

	IFeatureConfigDAO configDAO = null;

	@Before
	public void setUp() throws Exception {
		configDAO = new FeatureConfigDAO();
	}

	@After
	public void cleanUp() {

	}

	@Test
	public void testValidFeatureModelDAOLoad() {
		FeatureConfiguration fc = configDAO.loadFeatureConfig(featureConfigPath);
	}

}
