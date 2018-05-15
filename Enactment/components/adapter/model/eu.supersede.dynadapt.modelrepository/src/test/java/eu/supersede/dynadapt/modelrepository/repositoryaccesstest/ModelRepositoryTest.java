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
package eu.supersede.dynadapt.modelrepository.repositoryaccesstest;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.viatra.query.patternlanguage.patternLanguage.PatternModel;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cz.zcu.yafmt.model.fc.FeatureConfiguration;
import eu.supersede.dynadapt.dsl.aspect.Aspect;
import eu.supersede.dynadapt.featuremodel.fc.FeatureConfigDAO;
import eu.supersede.dynadapt.featuremodel.fc.FeatureConfigLAO;
import eu.supersede.dynadapt.featuremodel.fc.IFeatureConfigLAO;
import eu.supersede.dynadapt.model.ModelManager;
import eu.supersede.dynadapt.modelrepository.repositoryaccess.ModelRepository;
import eu.supersede.integration.api.adaptation.types.AdaptabilityModel;
import eu.supersede.integration.api.adaptation.types.BaseModel;
import eu.supersede.integration.api.adaptation.types.IModel;
import eu.supersede.integration.api.adaptation.types.ModelMetadata;
import eu.supersede.integration.api.adaptation.types.ModelSystem;
import eu.supersede.integration.api.adaptation.types.ModelType;
import eu.supersede.integration.api.adaptation.types.ModelUpdateMetadata;
import eu.supersede.integration.api.adaptation.types.TypedModelId;

public class ModelRepositoryTest {

	String repository = "platform:/resource/eu.supersede.dynadapt.modelrepository/repository/";
	String repositoryRelativePath = "repository";

	Map<String, String> modelsLocation;

	String featureConfigPath = "platform:/resource/eu.supersede.dynadapt.modelrepository/models/features/configurations/MonitoringSystemConfigDefault.yafc";

	String featureModelPath = "platform:/resource/eu.supersede.dynadapt.modelrepository/models/features/models/MonitoringSystem.yafm";

	URL url = null;

	ModelRepository mr = null;
	ModelManager mm = null;

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
		mm = new ModelManager(false);
//		mr = new ModelRepository(repository, url, mm);
		mr = new ModelRepository(repository, repositoryRelativePath, mm);
	}

	@After
	public void cleanUp() {

	}

	@Test
	public void testGetValidFeatureAspects() {
		mr.getAspectModels("GooglePlay_API_GooglePlay", modelsLocation);
	}

	// @Test
	// public void testGetValidFeatureAspectsURIs() {
	// List<URI> uris = mr.getAspectModelsURIs("GooglePlay_API_GooglePlay",
	// modelsLocation);
	// }
	//
	// /**
	// * This test shows how from a SelectionSUPERSEDE of a
	// FeatureConfigSUPERSEDE model its
	// * corresponding adaptation models can be retrieved.
	// */
	// @Test
	// public void testGetValidFeatureAspectsForASelection() {
	// FeatureConfigSUPERSEDE fc =
	// fcLAO.getFeatureConfigSUPERSEDE(featureConfigPath, featureModelPath);
	// /* Example with google play api - in this iteration selection #5 */
	// String featureId = fc.getSelections().get(5).getFeature().getId();
	//
	// List<Aspect> a = mr.getAspectModels(featureId, modelsLocation);
	// }
	
	@Test
	public void testCreateGetUpdateAndDeleteAdaptationModel() throws Exception {
		//Create model
		ModelMetadata metadata = createAdatabilityModelMetadata();
		Aspect aspectModel = 
			mm.loadAspectModel(
				"platform:/resource/eu.supersede.dynadapt.modelrepository/models/adaptability_models/googleplay_api_googleplay_tool.aspect");
		String id = mr.storeAspectModel(aspectModel, metadata);
		Assert.assertNotNull(id);
		Assert.assertTrue(!id.isEmpty());
		
		//Read created model
		Aspect am = mr.getAspectModel(id);
		Assert.assertNotNull(am);
		
		//Update created model
		ModelUpdateMetadata mum = createAdaptatibityModelupdateMetadata();
		mr.updateAspectModel(am, mum, id);
		
		//Delete created model
		mr.deleteAspectModel(id);
	}
	
	@Test
	public void testCreateGetUpdateAndDeleteBaseModel() throws Exception {
		//Create model
		ModelMetadata metadata = createBaseModelMetadata();
		Model baseModel = 
			mm.loadUMLModel(
				"platform:/resource/eu.supersede.dynadapt.modelrepository/models/uml_models/base/MonitoringSystemBaseModel.uml");
		String id = mr.storeBaseModel(baseModel, metadata);
		Assert.assertNotNull(id);
		Assert.assertTrue(!id.isEmpty());
		
		//Read created model
		Model model = mr.getBaseModel(id);
		Assert.assertNotNull(model);
		
		//Update created model
		ModelUpdateMetadata mum = createBaseModelupdateMetadata();
		mr.updateBaseModel(model, mum, id);
		
		//Delete created model
		mr.deleteBaseModel(id);
	}
	
	@Test
	public void testGetLastEnactedBaseModelForSystem() throws Exception {
		Model baseModel = mr.getLastEnactedBaseModelForSystem (ModelSystem.Atos_HSK);
		Assert.assertNotNull(baseModel);
	}
	
	@Test
	public void testGetLastBaseModelForSystem() throws Exception {
		Model baseModel = mr.getLastBaseModelForSystem (ModelSystem.Atos_HSK);
		Assert.assertNotNull(baseModel);
	}
	
	@Test
	public void testGetLastEnactedFeatureConfigurationForSystem() throws Exception {
		FeatureConfiguration fc = mr.getLastEnactedFeatureConfigurationForSystem (ModelSystem.SenerconFGcat);
		Assert.assertNotNull(fc);
	}
	
	@Test
	public void testGetLastComputedFeatureConfigurationForSystem() throws Exception {		
		FeatureConfiguration fc = mr.getLastComputedFeatureConfigurationForSystem (ModelSystem.Atos_HSK);
		Assert.assertNotNull(fc);
	}
	
	@Test
	public void testGetFeatureConfigurationModel() throws Exception {
		String id = "620";
		FeatureConfiguration fc = mr.getFeatureConfigurationModel(id);
		Assert.assertNotNull(fc);
	}
	
	@Test
	public void testGetAspectModelsForSystem() throws Exception {
		List<Aspect> models = mr.getAspectModelsForSystem (ModelSystem.Atos_HSK);
		Assert.assertNotNull(models);
		Assert.assertTrue(!models.isEmpty());
	}
	
	@Test
	public void testGetVariantModelsForSystem() throws Exception {
		List<Model> models = mr.getVariantModelsForSystem (ModelSystem.Atos_HSK);
		Assert.assertNotNull(models);
		Assert.assertTrue(!models.isEmpty());
	} 
	
	@Test
	public void testGetProfilesForSystem() throws Exception {
		List<Profile> profiles = mr.getProfilesForSystem (ModelSystem.Health);
		Assert.assertNotNull(profiles);
		Assert.assertTrue(!profiles.isEmpty());
	} 
	
	@Test
	public void testGetPatternModelsForSystem() throws Exception {
		List<PatternModel> patterns = mr.getPatternModelsForSystem (ModelSystem.Atos);
		Assert.assertNotNull(patterns);
		Assert.assertTrue(!patterns.isEmpty());
	} 
	
	private ModelUpdateMetadata createAdaptatibityModelupdateMetadata() {
		ModelUpdateMetadata mum = new ModelUpdateMetadata();
		mum.setSender("Adapter");
		mum.setTimeStamp(Calendar.getInstance().getTime());
		
		Map<String, Object> values = new HashMap<>();
		values.put("authorId", "yosu");
		values.put("featureId", "GooglePlay_API");
		mum.setValues(values);
		
		return mum;
	}
	
	private ModelUpdateMetadata createBaseModelupdateMetadata() {
		ModelUpdateMetadata mum = new ModelUpdateMetadata();
		mum.setSender("Adapter");
		mum.setTimeStamp(Calendar.getInstance().getTime());
		
		Map<String, Object> values = new HashMap<>();
		values.put("authorId", "burak");
		values.put("status", "adapted");
		mum.setValues(values);
		
		return mum;
	}

	private ModelMetadata createAdatabilityModelMetadata() throws IOException {
		ModelMetadata metadata = new ModelMetadata();
		
		metadata.setSender("Adapter");
		metadata.setTimeStamp(Calendar.getInstance().getTime());
		List<IModel> modelInstances = createAdaptabilityModelMetadataInstances();
		metadata.setModelInstances(modelInstances);
		
		return metadata;
	}

	private List<IModel> createAdaptabilityModelMetadataInstances() throws IOException {
		List<IModel> modelInstances = new ArrayList<>();
		AdaptabilityModel am = new AdaptabilityModel();
		modelInstances.add(am);
		
		am.setName("googleplay_api_googleplay_tool");
		am.setAuthorId("zavala");
		am.setCreationDate(Calendar.getInstance().getTime());
		am.setLastModificationDate(Calendar.getInstance().getTime());
		am.setFileExtension(ModelType.AdaptabilityModel.getExtension());
		am.setSystemId(ModelSystem.MonitoringReconfiguration);
		am.setFeatureId("GooglePlay");
		am.setRelativePath("relativepath");
		am.setDependencies(new ArrayList<TypedModelId>());
		
		return modelInstances;
	}

	private ModelMetadata createBaseModelMetadata() throws IOException {
		ModelMetadata metadata = new ModelMetadata();
		
		metadata.setSender("Adapter");
		metadata.setTimeStamp(Calendar.getInstance().getTime());
		List<IModel> modelInstances = createBaseModelMetadataInstances();
		metadata.setModelInstances(modelInstances);
		
		return metadata;
	}
	
	private List<IModel> createBaseModelMetadataInstances() throws IOException {
		List<IModel> modelInstances = new ArrayList<>();
		BaseModel am = new BaseModel();
		modelInstances.add(am);
		
		am.setName("ATOS Base Model");
		am.setAuthorId("yosu");
		am.setCreationDate(Calendar.getInstance().getTime());
		am.setLastModificationDate(Calendar.getInstance().getTime());
		am.setFileExtension(ModelType.BaseModel.getExtension());
		am.setSystemId(ModelSystem.Atos);
		am.setStatus("not adapted");
		am.setRelativePath("relativepath");
		am.setDependencies(new ArrayList<TypedModelId>());
		
		return modelInstances;
	}
}
