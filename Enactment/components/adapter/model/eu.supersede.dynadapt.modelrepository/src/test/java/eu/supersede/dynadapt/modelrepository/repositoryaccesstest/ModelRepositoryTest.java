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
package eu.supersede.dynadapt.modelrepository.repositoryaccesstest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.net.URISyntaxException;
import java.net.URL;

import eu.supersede.dynadapt.dsl.aspect.Aspect;
import eu.supersede.dynadapt.featuremodel.fc.FeatureConfigDAO;
import eu.supersede.dynadapt.featuremodel.fc.FeatureConfigLAO;
import eu.supersede.dynadapt.featuremodel.fc.FeatureConfigSUPERSEDE;
import eu.supersede.dynadapt.featuremodel.fc.IFeatureConfigLAO;
import eu.supersede.dynadapt.modelrepository.repositoryaccess.ModelRepository;

public class ModelRepositoryTest {

	String repository = "platform:/resource/eu.supersede.dynadapt.modelrepository/models/";

	Map<String, String> modelsLocation;

	String featureConfigPath = "platform:/resource/eu.supersede.dynadapt.modelrepository/models/features/configurations/MonitoringSystemConfigDefault.yafc";

	String featureModelPath = "platform:/resource/eu.supersede.dynadapt.modelrepository/models/features/models/MonitoringSystem.yafm";

	URL url = null;
	
	ModelRepository mr = null;

	IFeatureConfigLAO fcLAO = null;

	@Before
	public void setUp() throws Exception {
		new StandaloneSetup().setPlatformUri("../");
		modelsLocation = new HashMap<String, String>();
		modelsLocation.put("aspects", "adaptability_models/");
		modelsLocation.put("variants", "uml_models/variants/");
		modelsLocation.put("profiles", "uml_models/profiles/");
		modelsLocation.put("patterns", "patterns/");
		modelsLocation.put("features", "features/models/");

		fcLAO = new FeatureConfigLAO(new FeatureConfigDAO());
		url = getClass().getResource("/");
		mr = new ModelRepository(repository, url);
	}

	@After
	public void cleanUp() {

	}

	@Test
	public void testGetValidFeatureAspects() {
		mr.getAspectModels("GooglePlay_API_GooglePlay", modelsLocation);
	}
	

//	@Test
//	public void testGetValidFeatureAspectsURIs() {
//		List<URI> uris = mr.getAspectModelsURIs("GooglePlay_API_GooglePlay", modelsLocation);
//	}
//
//	/**
//	 * This test shows how from a SelectionSUPERSEDE of a FeatureConfigSUPERSEDE model its
//	 * corresponding adaptation models can be retrieved. 
//	 */
//	@Test
//	public void testGetValidFeatureAspectsForASelection() {
//		FeatureConfigSUPERSEDE fc = fcLAO.getFeatureConfigSUPERSEDE(featureConfigPath, featureModelPath);
//		/* Example with google play api - in this iteration selection #5 */
//		String featureId = fc.getSelections().get(5).getFeature().getId();
//
//		List<Aspect> a = mr.getAspectModels(featureId, modelsLocation);
//	}

}
