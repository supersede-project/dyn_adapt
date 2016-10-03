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

package eu.supersede.dynadapt.featuremodel.featuretest;

import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import eu.supersede.dynadapt.featuremodel.feature.FeatureLAO;
import eu.supersede.dynadapt.featuremodel.feature.FeatureSUPERSEDE;
import eu.supersede.dynadapt.featuremodel.feature.IFeatureLAO;

public class FeatureLAOTest {

	String featureModelPath = "platform:/resource/eu.supersede.dynadapt.featuremodel/models/MonitoringSystem.yafm";

	IFeatureLAO fLAO = null;

	@Mock
	FeatureSUPERSEDE parent;
	FeatureSUPERSEDE child;

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();

	@Before
	public void setUp() throws Exception {
		new StandaloneSetup().setPlatformUri("../");
		fLAO = new FeatureLAO();
	}

	@After
	public void cleanUp() {

	}

	@Test
	public void testCreateValidFeatureSUPERSEDE() {
		fLAO.addChild(parent, child);
		fLAO.setFeatureSiblings(parent);
	}

}
