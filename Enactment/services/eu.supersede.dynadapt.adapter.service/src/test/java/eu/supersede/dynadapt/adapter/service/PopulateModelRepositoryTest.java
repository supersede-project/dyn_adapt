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
package eu.supersede.dynadapt.adapter.service;

import java.io.IOException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Profile;
import org.junit.Before;
import org.junit.Test;

import eu.supersede.dynadapt.dsl.aspect.Aspect;
//import eu.supersede.dynadapt.featuremodel.fc.FeatureConfigDAO;
//import eu.supersede.dynadapt.featuremodel.fc.FeatureConfigLAO;
//import eu.supersede.dynadapt.featuremodel.fc.IFeatureConfigLAO;
import eu.supersede.dynadapt.model.ModelManager;
import eu.supersede.dynadapt.modelrepository.populate.PopulateRepositoryManager;
import eu.supersede.dynadapt.modelrepository.repositoryaccess.ModelRepository;
import eu.supersede.integration.api.adaptation.types.AdaptabilityModel;
import eu.supersede.integration.api.adaptation.types.BaseModel;
import eu.supersede.integration.api.adaptation.types.FeatureConfiguration;
import eu.supersede.integration.api.adaptation.types.FeatureModel;
import eu.supersede.integration.api.adaptation.types.ModelSystem;
import eu.supersede.integration.api.adaptation.types.ModelType;
import eu.supersede.integration.api.adaptation.types.PatternModel;
import eu.supersede.integration.api.adaptation.types.ProfileModel;
import eu.supersede.integration.api.adaptation.types.Status;
import eu.supersede.integration.api.adaptation.types.VariantModel;

public class PopulateModelRepositoryTest {

	private static final String ATOS_HSK_MODELS_AUTHOR = "Yosu";

	private static final String SIEMENS_MODELS_AUTHOR = "Orlando";
	
	private static final String SENERCON_MODELS_AUTHOR = "Denisse";
	
	private static final String MONITORING_MODELS_AUTHOR = "Quim";

	private final static Logger log = LogManager.getLogger(PopulateModelRepositoryTest.class);
	
	String repository = "platform:/resource/eu.supersede.dynadapt.adapter.service/repository/";
	String repositoryRelativePath = "./repository/";

	Map<String, String> modelsLocation;

	URL url = null;

	ModelRepository mr = null;
	ModelManager mm = null;
	PopulateRepositoryManager prm = null;

	//IFeatureConfigLAO fcLAO = null;
	
//	public PopulateModelRepositoryTest (String repositoryRelativePath){
//		this.repositoryRelativePath = repositoryRelativePath;
//	}
	
	public static void main (String[] args){
		//Ignored, added to permit the creation of an executable Java for tests
	}

	@Before
	public void setUp() throws Exception {
		new StandaloneSetup().setPlatformUri("../");
		modelsLocation = new HashMap<String, String>();
		modelsLocation.put("aspects", "adaptability_models/");
		modelsLocation.put("variants", "models/variants/");
		modelsLocation.put("profiles", "models/profiles/");
		modelsLocation.put("patterns", "patterns/");
		modelsLocation.put("features", "features/models/");
		modelsLocation.put("configurations", "features/configurations/");

		//fcLAO = new FeatureConfigLAO(new FeatureConfigDAO());
		url = getClass().getResource("/");
		mm = new ModelManager(false);
		mr = new ModelRepository(repository, repositoryRelativePath, mm);
		prm = new PopulateRepositoryManager (mm, mr);
		
		//Clean-up repository
		cleanUpRepository();
	}

	/**
	 * To remove all models from remote model repository
	 */
	private void cleanUpRepository() {
		mr.cleanUpRepository();
	}

	
	@Test
	public void testCleanUp() throws Exception {
		log.debug ("Repository cleaned up");
	}
	
	@Test
	public void testPopulateRepository() throws Exception {
//		populateRepository();
		populateAtosModels();
		populateSiemenesModels();
		populateSiemens_UI_Buildings_Models();
		populateSiemens_UI_MinMaxDates_Models();
		populateSiemens_UI_Types_Models();
		populateAtosMonitoringReconfigurationEnabligModels();
		populateAtosMonitoringReconfigurationTimeslotModels();
		populateFGReconfigurationModels();
	}
	
	private void populateAtosMonitoringReconfigurationEnabligModels() throws Exception {
		
		String userdir = System.getProperty("user.dir");
		Path repositoryPath = FileSystems.getDefault().getPath(userdir,repositoryRelativePath);
		
		log.debug("Loading " + ModelSystem.AtosMonitoringEnabling.toString());
		
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "models/base", "HttpMonitoringSystemBaseModelEnabling.uml"), 
				MONITORING_MODELS_AUTHOR, ModelSystem.AtosMonitoringEnabling, Status.Enacted, "models/base", Model.class,
				ModelType.BaseModel, BaseModel.class);
			
			//Profile
			prm.populateModel(
				Paths.get(repositoryPath.toString(), "models/profiles", "adm.profile.uml"), 
				MONITORING_MODELS_AUTHOR, ModelSystem.AtosMonitoringEnabling, Status.Designed, "models/profiles", Profile.class,
				ModelType.ProfileModel, ProfileModel.class);
			
			//Variant FIXME used for avoid null error
			prm.populateModel(
				Paths.get(repositoryPath.toString(), "models/variants", "HttpAddConf.uml"), 
				MONITORING_MODELS_AUTHOR, ModelSystem.AtosMonitoringEnabling, Status.Designed, "models/variants", Model.class,
				ModelType.VariantModel, VariantModel.class);
		
			populateAtosMonitoringEnablingScenario(repositoryPath);

		log.debug(ModelSystem.AtosMonitoringEnabling.toString() + " models loaded");
		
	}
	
	private void populateAtosMonitoringReconfigurationTimeslotModels() throws Exception {
		
		String userdir = System.getProperty("user.dir");
		Path repositoryPath = FileSystems.getDefault().getPath(userdir,repositoryRelativePath);
		
		log.debug("Loading " + ModelSystem.AtosMonitoringTimeSlot.toString());
		
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "models/base", "HttpMonitoringSystemBaseModelTimeSlot.uml"), 
				MONITORING_MODELS_AUTHOR, ModelSystem.AtosMonitoringTimeSlot, Status.Enacted, "models/base", Model.class,
				ModelType.BaseModel, BaseModel.class);
			
			//Profile
			prm.populateModel(
				Paths.get(repositoryPath.toString(), "models/profiles", "adm.profile.uml"), 
				MONITORING_MODELS_AUTHOR, ModelSystem.AtosMonitoringTimeSlot, Status.Designed, "models/profiles", Profile.class,
				ModelType.ProfileModel, ProfileModel.class);
			
			//Variant FIXME used for avoid null error
			prm.populateModel(
				Paths.get(repositoryPath.toString(), "models/variants", "HttpAddConf.uml"), 
				MONITORING_MODELS_AUTHOR, ModelSystem.AtosMonitoringTimeSlot, Status.Designed, "models/variants", Model.class,
				ModelType.VariantModel, VariantModel.class);
		
		populateAtosMonitoringTimeSlotScenario(repositoryPath);

		log.debug(ModelSystem.AtosMonitoringTimeSlot.toString() + " models loaded");
		
	}

	private void populateAtosMonitoringEnablingScenario(Path repositoryPath) throws Exception {

		//Feature Model
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "features/models", "HttpMonitoringSystemEnableFeatureModel.yafm"), 
				MONITORING_MODELS_AUTHOR, ModelSystem.AtosMonitoringEnabling, Status.Designed, "features/models",
				cz.zcu.yafmt.model.fm.FeatureModel.class, ModelType.FeatureModel, FeatureModel.class);

		//Feature Configurations
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "features/configurations", "HttpMonitoringSystemConfigDisabled.yafc"), 
				MONITORING_MODELS_AUTHOR, ModelSystem.AtosMonitoringEnabling, Status.Enacted, "features/configurations",
				cz.zcu.yafmt.model.fc.FeatureConfiguration.class, ModelType.FeatureConfiguration, FeatureConfiguration.class);
		
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "features/configurations", "HttpMonitoringSystemConfigEnabled.yafc"), 
				MONITORING_MODELS_AUTHOR, ModelSystem.AtosMonitoringEnabling, Status.Computed, "features/configurations",
				cz.zcu.yafmt.model.fc.FeatureConfiguration.class, ModelType.FeatureConfiguration, FeatureConfiguration.class);

		//Patterns
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "patterns/eu/supersede/dynadapt/usecases/patterns", "monitoring_reconfiguration_queries.vql"), 
				MONITORING_MODELS_AUTHOR, ModelSystem.AtosMonitoringEnabling, Status.Designed, "patterns/eu/supersede/dynadapt/usecases/patterns",
				org.eclipse.viatra.query.patternlanguage.patternLanguage.PatternModel.class, ModelType.PatternModel, PatternModel.class);

		//Adaptability models
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "adaptability_models", "enable_http_monitor.aspect"), 
				MONITORING_MODELS_AUTHOR, ModelSystem.AtosMonitoringEnabling, Status.Designed, "adaptability_models", Aspect.class,
				ModelType.AdaptabilityModel, AdaptabilityModel.class);
	}

	private void populateAtosMonitoringTimeSlotScenario(Path repositoryPath) throws Exception {

		//Feature Model
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "features/models", "HttpMonitoringSystemTimeslotFeatureModel.yafm"), 
				MONITORING_MODELS_AUTHOR, ModelSystem.AtosMonitoringTimeSlot, Status.Designed, "features/models",
				cz.zcu.yafmt.model.fm.FeatureModel.class, ModelType.FeatureModel, FeatureModel.class);

		//Feature Configurations
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "features/configurations", "HttpMonitoringSystemConfigHighTimeslot.yafc"), 
				MONITORING_MODELS_AUTHOR, ModelSystem.AtosMonitoringTimeSlot, Status.Computed, "features/configurations",
				cz.zcu.yafmt.model.fc.FeatureConfiguration.class, ModelType.FeatureConfiguration, FeatureConfiguration.class);
		
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "features/configurations", "HttpMonitoringSystemConfigLowTimeslot.yafc"), 
				MONITORING_MODELS_AUTHOR, ModelSystem.AtosMonitoringTimeSlot, Status.Enacted, "features/configurations",
				cz.zcu.yafmt.model.fc.FeatureConfiguration.class, ModelType.FeatureConfiguration, FeatureConfiguration.class);

		//Patterns
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "patterns/eu/supersede/dynadapt/usecases/patterns", "monitoring_reconfiguration_queries.vql"), 
				MONITORING_MODELS_AUTHOR, ModelSystem.AtosMonitoringTimeSlot, Status.Designed, "patterns/eu/supersede/dynadapt/usecases/patterns",
				org.eclipse.viatra.query.patternlanguage.patternLanguage.PatternModel.class, ModelType.PatternModel, PatternModel.class);

		//Adaptability models
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "adaptability_models", "timeslot_http_monitor.aspect"), 
				MONITORING_MODELS_AUTHOR, ModelSystem.AtosMonitoringTimeSlot, Status.Designed, "adaptability_models", Aspect.class,
				ModelType.AdaptabilityModel, AdaptabilityModel.class);
		
	}

	private void populateAtosModels() throws IOException, Exception {
		String userdir = System.getProperty("user.dir");
		Path repositoryPath = FileSystems.getDefault().getPath(userdir,repositoryRelativePath);
		
		log.debug("Loading " + ModelSystem.Atos_HSK.toString());
		
		//BaseModel
		prm.populateModel(
			Paths.get(repositoryPath.toString(), "models/base", "atos_smart_base_model.uml"), 
			ATOS_HSK_MODELS_AUTHOR, ModelSystem.Atos_HSK, Status.Enacted, "models/base", Model.class,
			ModelType.BaseModel, BaseModel.class);
		
		//Profile
		prm.populateModel(
			Paths.get(repositoryPath.toString(), "models/profiles", "adm.profile.uml"), 
			ATOS_HSK_MODELS_AUTHOR, ModelSystem.Atos_HSK, Status.Designed, "models/profiles", Profile.class,
			ModelType.ProfileModel, ProfileModel.class);
		
		//Variants
		prm.populateModel(
			Paths.get(repositoryPath.toString(), "models/variants", "atos_smart_hsk_vm2a_high.uml"), 
			ATOS_HSK_MODELS_AUTHOR, ModelSystem.Atos_HSK, Status.Designed, "models/variants", Model.class,
			ModelType.VariantModel, VariantModel.class);

		prm.populateModel(
				Paths.get(repositoryPath.toString(), "models/variants", "atos_smart_hsk_vm2a_low.uml"), 
				ATOS_HSK_MODELS_AUTHOR, ModelSystem.Atos_HSK, Status.Designed, "models/variants", Model.class,
				ModelType.VariantModel, VariantModel.class);

		prm.populateModel(
				Paths.get(repositoryPath.toString(), "models/variants", "atos_smart_hsk_vm2a_medium.uml"), 
				ATOS_HSK_MODELS_AUTHOR, ModelSystem.Atos_HSK, Status.Designed, "models/variants", Model.class,
				ModelType.VariantModel, VariantModel.class);

		prm.populateModel(
				Paths.get(repositoryPath.toString(), "models/variants", "atos_smart_hsk_vm2b_high.uml"), 
				ATOS_HSK_MODELS_AUTHOR, ModelSystem.Atos_HSK, Status.Designed, "models/variants", Model.class,
				ModelType.VariantModel, VariantModel.class);

		prm.populateModel(
				Paths.get(repositoryPath.toString(), "models/variants", "atos_smart_hsk_vm2b_low.uml"), 
				ATOS_HSK_MODELS_AUTHOR, ModelSystem.Atos_HSK, Status.Designed, "models/variants", Model.class,
				ModelType.VariantModel, VariantModel.class);
		
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "models/variants", "atos_smart_hsk_vm2b_medium.uml"), 
				ATOS_HSK_MODELS_AUTHOR, ModelSystem.Atos_HSK, Status.Designed, "models/variants", Model.class,
				ModelType.VariantModel, VariantModel.class);

		//Feature Model
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "features/models", "SmartPlatformFM_HSK.yafm"), 
				ATOS_HSK_MODELS_AUTHOR, ModelSystem.Atos_HSK, Status.Designed, "features/models",
				cz.zcu.yafmt.model.fm.FeatureModel.class, ModelType.FeatureModel, FeatureModel.class);

		//Feature Configurations
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "features/configurations", "SmartPlatformFC_HSK_SingleVM_LowLoad.yafc"), 
				ATOS_HSK_MODELS_AUTHOR, ModelSystem.Atos_HSK, Status.Enacted, "features/configurations",
				cz.zcu.yafmt.model.fc.FeatureConfiguration.class, ModelType.FeatureConfiguration, FeatureConfiguration.class);

		prm.populateModel(
				Paths.get(repositoryPath.toString(), "features/configurations", "SmartPlatformFC_HSK_SingleVM_HighLoad.yafc"), 
				ATOS_HSK_MODELS_AUTHOR, ModelSystem.Atos_HSK, Status.Computed, "features/configurations",
				cz.zcu.yafmt.model.fc.FeatureConfiguration.class, ModelType.FeatureConfiguration, FeatureConfiguration.class);

//		prm.populateModel(
//				Paths.get(repositoryPath.toString(), "features/configurations", "SmartPlatformFC_HSK_LowLoad_optimized.yafc"), 
//				"Yosu", ModelSystem.Atos_HSK, Status.Computed, "features/configurations",
//				cz.zcu.yafmt.model.fc.FeatureConfiguration.class, ModelType.FeatureConfiguration, FeatureConfiguration.class);

		prm.populateModel(
				Paths.get(repositoryPath.toString(), "features/configurations", "SmartPlatformFC_HSK_DualVM_HighLowLoad.yafc"), 
				ATOS_HSK_MODELS_AUTHOR, ModelSystem.Atos_HSK, Status.Computed, "features/configurations",
				cz.zcu.yafmt.model.fc.FeatureConfiguration.class, ModelType.FeatureConfiguration, FeatureConfiguration.class);

		prm.populateModel(
				Paths.get(repositoryPath.toString(), "features/configurations", "SmartPlatformFC_HSK_DualVM_HighMediumLoad.yafc"), 
				ATOS_HSK_MODELS_AUTHOR, ModelSystem.Atos_HSK, Status.Computed, "features/configurations",
				cz.zcu.yafmt.model.fc.FeatureConfiguration.class, ModelType.FeatureConfiguration, FeatureConfiguration.class);

		prm.populateModel(
				Paths.get(repositoryPath.toString(), "features/configurations", "SmartPlatformFC_HSK_DualVM_LowLowLoad.yafc"), 
				ATOS_HSK_MODELS_AUTHOR, ModelSystem.Atos_HSK, Status.Computed, "features/configurations",
				cz.zcu.yafmt.model.fc.FeatureConfiguration.class, ModelType.FeatureConfiguration, FeatureConfiguration.class);

		prm.populateModel(
				Paths.get(repositoryPath.toString(), "features/configurations", "SmartPlatformFC_HSK_DualVM_MediumLowLoad.yafc"), 
				ATOS_HSK_MODELS_AUTHOR, ModelSystem.Atos_HSK, Status.Computed, "features/configurations",
				cz.zcu.yafmt.model.fc.FeatureConfiguration.class, ModelType.FeatureConfiguration, FeatureConfiguration.class);
		
		//Patterns
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "patterns/eu/supersede/dynadapt/usecases/patterns", "atos_query_patterns.vql"), 
				ATOS_HSK_MODELS_AUTHOR, ModelSystem.Atos_HSK, Status.Designed, "patterns/eu/supersede/dynadapt/usecases/patterns",
				org.eclipse.viatra.query.patternlanguage.patternLanguage.PatternModel.class, ModelType.PatternModel, PatternModel.class);

		//Adaptability models
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "adaptability_models", "atos_smart_hsk_vm2a_high_load.aspect"), 
				ATOS_HSK_MODELS_AUTHOR, ModelSystem.Atos_HSK, Status.Designed, "adaptability_models", Aspect.class,
				ModelType.AdaptabilityModel, AdaptabilityModel.class);
		
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "adaptability_models", "atos_smart_hsk_vm2a_low_load.aspect"), 
				ATOS_HSK_MODELS_AUTHOR, ModelSystem.Atos_HSK, Status.Designed, "adaptability_models", Aspect.class,
				ModelType.AdaptabilityModel, AdaptabilityModel.class);

		prm.populateModel(
				Paths.get(repositoryPath.toString(), "adaptability_models", "atos_smart_hsk_vm2a_medium_load.aspect"), 
				ATOS_HSK_MODELS_AUTHOR, ModelSystem.Atos_HSK, Status.Designed, "adaptability_models", Aspect.class,
				ModelType.AdaptabilityModel, AdaptabilityModel.class);

		prm.populateModel(
				Paths.get(repositoryPath.toString(), "adaptability_models", "atos_smart_hsk_vm2b_high_load.aspect"), 
				ATOS_HSK_MODELS_AUTHOR, ModelSystem.Atos_HSK, Status.Designed, "adaptability_models", Aspect.class,
				ModelType.AdaptabilityModel, AdaptabilityModel.class);

		prm.populateModel(
				Paths.get(repositoryPath.toString(), "adaptability_models", "atos_smart_hsk_vm2b_low_load.aspect"), 
				ATOS_HSK_MODELS_AUTHOR, ModelSystem.Atos_HSK, Status.Designed, "adaptability_models", Aspect.class,
				ModelType.AdaptabilityModel, AdaptabilityModel.class);

		prm.populateModel(
				Paths.get(repositoryPath.toString(), "adaptability_models", "atos_smart_hsk_vm2b_medium_load.aspect"), 
				ATOS_HSK_MODELS_AUTHOR, ModelSystem.Atos_HSK, Status.Designed, "adaptability_models", Aspect.class,
				ModelType.AdaptabilityModel, AdaptabilityModel.class);

		log.debug(ModelSystem.Atos_HSK.toString() + " models loaded");	
	}
	
	private void populateSiemens_UI_Buildings_Models() throws IOException, Exception {
		String userdir = System.getProperty("user.dir");
		Path repositoryPath = FileSystems.getDefault().getPath(userdir,repositoryRelativePath);

		log.debug("Loading " + ModelSystem.Siemens_Buildings.toString());
		
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "models/base", "UI_getBuildings_base.uml"),
				SIEMENS_MODELS_AUTHOR, ModelSystem.Siemens_Buildings, Status.Enacted, "models/base", Model.class,
				ModelType.BaseModel, BaseModel.class);
		
		//Profiles
		prm.populateModel(
			Paths.get(repositoryPath.toString(), "models/profiles", "adm.profile.uml"), 
			SIEMENS_MODELS_AUTHOR, ModelSystem.Siemens_Buildings, Status.Designed, "models/profiles", Profile.class,
			ModelType.ProfileModel, ProfileModel.class);

		prm.populateModel(
			Paths.get(repositoryPath.toString(), "models/profiles", "model.profile.uml"), 
			SIEMENS_MODELS_AUTHOR, ModelSystem.Siemens_Buildings, Status.Designed, "models/profiles", Profile.class,
			ModelType.ProfileModel, ProfileModel.class);

		//Variants
		
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "models/variants", "UI_getBuildings_variant1.uml"), 
				SIEMENS_MODELS_AUTHOR, ModelSystem.Siemens_Buildings, Status.Designed, "models/variants", Model.class,
				ModelType.VariantModel, VariantModel.class);
		
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "models/variants", "UI_getBuildings_variant2.uml"), 
				SIEMENS_MODELS_AUTHOR, ModelSystem.Siemens_Buildings, Status.Designed, "models/variants", Model.class,
				ModelType.VariantModel, VariantModel.class);

		//Feature Model		
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "features/models", "FeatureModel-SiemensCachingBuildings.yafm"), 
				SIEMENS_MODELS_AUTHOR, ModelSystem.Siemens_Buildings, Status.Designed, "features/models",
				cz.zcu.yafmt.model.fm.FeatureModel.class, ModelType.FeatureModel, FeatureModel.class);
		
		//Feature Configurations		
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "features/configurations", "FeatureConfiguration-SiemensCachingBuildings-Strategy1.yafc"), 
				SIEMENS_MODELS_AUTHOR, ModelSystem.Siemens_Buildings, Status.Enacted, "features/configurations",
				cz.zcu.yafmt.model.fc.FeatureConfiguration.class, ModelType.FeatureConfiguration, FeatureConfiguration.class);

		prm.populateModel(
			Paths.get(repositoryPath.toString(), "features/configurations", "FeatureConfiguration-SiemensCachingBuildings-Strategy2.yafc"), 
			SIEMENS_MODELS_AUTHOR, ModelSystem.Siemens_Buildings, Status.Computed, "features/configurations",
			cz.zcu.yafmt.model.fc.FeatureConfiguration.class, ModelType.FeatureConfiguration, FeatureConfiguration.class);
		
		//Patterns
		prm.populateModel(
			Paths.get(repositoryPath.toString(), "patterns/eu/supersede/dynadapt/usecases/patterns", "siemens_queries.vql"), 
			SIEMENS_MODELS_AUTHOR, ModelSystem.Siemens_Buildings, Status.Designed, "patterns/eu/supersede/dynadapt/usecases/patterns",
			org.eclipse.viatra.query.patternlanguage.patternLanguage.PatternModel.class, ModelType.PatternModel, PatternModel.class);

		//Adaptability models
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "adaptability_models", "aspectComposition_Siemens_caching_UI_buildings_SC1.aspect"), 
				SIEMENS_MODELS_AUTHOR, ModelSystem.Siemens_Buildings, Status.Designed, "adaptability_models", Aspect.class,
				ModelType.AdaptabilityModel, AdaptabilityModel.class);
		
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "adaptability_models", "aspectComposition_Siemens_caching_UI_buildings_SC2.aspect"), 
				SIEMENS_MODELS_AUTHOR, ModelSystem.Siemens_Buildings, Status.Designed, "adaptability_models", Aspect.class,
				ModelType.AdaptabilityModel, AdaptabilityModel.class);
		
		log.debug(ModelSystem.Siemens_Buildings.toString() + " models loaded");	
	}
	
	private void populateSiemens_UI_MinMaxDates_Models() throws IOException, Exception {
		String userdir = System.getProperty("user.dir");
		Path repositoryPath = FileSystems.getDefault().getPath(userdir,repositoryRelativePath);

		log.debug("Loading " + ModelSystem.Siemens_GetMinMaxDates.toString());
		
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "models/base", "UI_getMinMaxDates_base.uml"),
				SIEMENS_MODELS_AUTHOR, ModelSystem.Siemens_GetMinMaxDates, Status.Enacted, "models/base", Model.class,
				ModelType.BaseModel, BaseModel.class);
		
		//Profiles
		prm.populateModel(
			Paths.get(repositoryPath.toString(), "models/profiles", "adm.profile.uml"), 
			SIEMENS_MODELS_AUTHOR, ModelSystem.Siemens_GetMinMaxDates, Status.Designed, "models/profiles", Profile.class,
			ModelType.ProfileModel, ProfileModel.class);

		prm.populateModel(
			Paths.get(repositoryPath.toString(), "models/profiles", "model.profile.uml"), 
			SIEMENS_MODELS_AUTHOR, ModelSystem.Siemens_GetMinMaxDates, Status.Designed, "models/profiles", Profile.class,
			ModelType.ProfileModel, ProfileModel.class);

		//Variants
		
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "models/variants", "UI_getMinMaxDates_variant1.uml"), 
				SIEMENS_MODELS_AUTHOR, ModelSystem.Siemens_GetMinMaxDates, Status.Designed, "models/variants", Model.class,
				ModelType.VariantModel, VariantModel.class);
		
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "models/variants", "UI_getMinMaxDates_variant2.uml"), 
				SIEMENS_MODELS_AUTHOR, ModelSystem.Siemens_GetMinMaxDates, Status.Designed, "models/variants", Model.class,
				ModelType.VariantModel, VariantModel.class);

		//Feature Model		
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "features/models", "FeatureModel-SiemensCachingGetMinMaxDates.yafm"), 
				SIEMENS_MODELS_AUTHOR, ModelSystem.Siemens_GetMinMaxDates, Status.Designed, "features/models",
				cz.zcu.yafmt.model.fm.FeatureModel.class, ModelType.FeatureModel, FeatureModel.class);
		
		//Feature Configurations		
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "features/configurations", "FeatureConfiguration-SiemensCachingGetMinMaxDates-Strategy1.yafc"), 
				SIEMENS_MODELS_AUTHOR, ModelSystem.Siemens_GetMinMaxDates, Status.Enacted, "features/configurations",
				cz.zcu.yafmt.model.fc.FeatureConfiguration.class, ModelType.FeatureConfiguration, FeatureConfiguration.class);

		prm.populateModel(
			Paths.get(repositoryPath.toString(), "features/configurations", "FeatureConfiguration-SiemensCachingGetMinMaxDates-Strategy2.yafc"), 
			SIEMENS_MODELS_AUTHOR, ModelSystem.Siemens_GetMinMaxDates, Status.Computed, "features/configurations",
			cz.zcu.yafmt.model.fc.FeatureConfiguration.class, ModelType.FeatureConfiguration, FeatureConfiguration.class);
		
		//Patterns
		prm.populateModel(
			Paths.get(repositoryPath.toString(), "patterns/eu/supersede/dynadapt/usecases/patterns", "siemens_queries.vql"), 
			SIEMENS_MODELS_AUTHOR, ModelSystem.Siemens_GetMinMaxDates, Status.Designed, "patterns/eu/supersede/dynadapt/usecases/patterns",
			org.eclipse.viatra.query.patternlanguage.patternLanguage.PatternModel.class, ModelType.PatternModel, PatternModel.class);

		//Adaptability models
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "adaptability_models", "aspectComposition_Siemens_caching_UI_minmaxdates_SC1.aspect"), 
				SIEMENS_MODELS_AUTHOR, ModelSystem.Siemens_GetMinMaxDates, Status.Designed, "adaptability_models", Aspect.class,
				ModelType.AdaptabilityModel, AdaptabilityModel.class);
		
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "adaptability_models", "aspectComposition_Siemens_caching_UI_minmaxdates_SC2.aspect"), 
				SIEMENS_MODELS_AUTHOR, ModelSystem.Siemens_GetMinMaxDates, Status.Designed, "adaptability_models", Aspect.class,
				ModelType.AdaptabilityModel, AdaptabilityModel.class);
		
		log.debug(ModelSystem.Siemens_GetMinMaxDates.toString() + " models loaded");	
	}
	
	private void populateSiemens_UI_Types_Models() throws IOException, Exception {
		String userdir = System.getProperty("user.dir");
		Path repositoryPath = FileSystems.getDefault().getPath(userdir,repositoryRelativePath);

		log.debug("Loading " + ModelSystem.Siemens_Types.toString());
		
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "models/base", "UI_getTypes_base.uml"),
				SIEMENS_MODELS_AUTHOR, ModelSystem.Siemens_Types, Status.Enacted, "models/base", Model.class,
				ModelType.BaseModel, BaseModel.class);
		
		//Profiles
		prm.populateModel(
			Paths.get(repositoryPath.toString(), "models/profiles", "adm.profile.uml"), 
			SIEMENS_MODELS_AUTHOR, ModelSystem.Siemens_Types, Status.Designed, "models/profiles", Profile.class,
			ModelType.ProfileModel, ProfileModel.class);

		prm.populateModel(
			Paths.get(repositoryPath.toString(), "models/profiles", "model.profile.uml"), 
			SIEMENS_MODELS_AUTHOR, ModelSystem.Siemens_Types, Status.Designed, "models/profiles", Profile.class,
			ModelType.ProfileModel, ProfileModel.class);

		//Variants	
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "models/variants", "UI_getTypes_variant1.uml"), 
				SIEMENS_MODELS_AUTHOR, ModelSystem.Siemens_Types, Status.Designed, "models/variants", Model.class,
				ModelType.VariantModel, VariantModel.class);
		
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "models/variants", "UI_getTypes_variant2.uml"), 
				SIEMENS_MODELS_AUTHOR, ModelSystem.Siemens_Types, Status.Designed, "models/variants", Model.class,
				ModelType.VariantModel, VariantModel.class);

		//Feature Model		
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "features/models", "FeatureModel-SiemensCachingTypes.yafm"), 
				SIEMENS_MODELS_AUTHOR, ModelSystem.Siemens_Types, Status.Designed, "features/models",
				cz.zcu.yafmt.model.fm.FeatureModel.class, ModelType.FeatureModel, FeatureModel.class);
		
		//Feature Configurations		
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "features/configurations", "FeatureConfiguration-SiemensCachingTypes-Strategy1.yafc"), 
				SIEMENS_MODELS_AUTHOR, ModelSystem.Siemens_Types, Status.Enacted, "features/configurations",
				cz.zcu.yafmt.model.fc.FeatureConfiguration.class, ModelType.FeatureConfiguration, FeatureConfiguration.class);

		prm.populateModel(
			Paths.get(repositoryPath.toString(), "features/configurations", "FeatureConfiguration-SiemensCachingTypes-Strategy2.yafc"), 
			SIEMENS_MODELS_AUTHOR, ModelSystem.Siemens_Types, Status.Computed, "features/configurations",
			cz.zcu.yafmt.model.fc.FeatureConfiguration.class, ModelType.FeatureConfiguration, FeatureConfiguration.class);
		
		//Patterns
		prm.populateModel(
			Paths.get(repositoryPath.toString(), "patterns/eu/supersede/dynadapt/usecases/patterns", "siemens_queries.vql"), 
			SIEMENS_MODELS_AUTHOR, ModelSystem.Siemens_Types, Status.Designed, "patterns/eu/supersede/dynadapt/usecases/patterns",
			org.eclipse.viatra.query.patternlanguage.patternLanguage.PatternModel.class, ModelType.PatternModel, PatternModel.class);

		//Adaptability models
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "adaptability_models", "aspectComposition_Siemens_caching_UI_types_SC1.aspect"), 
				SIEMENS_MODELS_AUTHOR, ModelSystem.Siemens_Types, Status.Designed, "adaptability_models", Aspect.class,
				ModelType.AdaptabilityModel, AdaptabilityModel.class);
		
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "adaptability_models", "aspectComposition_Siemens_caching_UI_types_SC2.aspect"), 
				SIEMENS_MODELS_AUTHOR, ModelSystem.Siemens_Types, Status.Designed, "adaptability_models", Aspect.class,
				ModelType.AdaptabilityModel, AdaptabilityModel.class);
		
		log.debug(ModelSystem.Siemens_Types.toString() + " models loaded");	
	}

	private void populateSiemenesModels() throws IOException, Exception {
		String userdir = System.getProperty("user.dir");
		Path repositoryPath = FileSystems.getDefault().getPath(userdir,repositoryRelativePath);

		log.debug("Loading " + ModelSystem.Siemens.toString());
		
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "models/base", "S2_getBuildings_base.uml"),
				SIEMENS_MODELS_AUTHOR, ModelSystem.Siemens, Status.Enacted, "models/base", Model.class,
				ModelType.BaseModel, BaseModel.class);
		
		//Profiles
		prm.populateModel(
			Paths.get(repositoryPath.toString(), "models/profiles", "adm.profile.uml"), 
			SIEMENS_MODELS_AUTHOR, ModelSystem.Siemens, Status.Designed, "models/profiles", Profile.class,
			ModelType.ProfileModel, ProfileModel.class);

		prm.populateModel(
			Paths.get(repositoryPath.toString(), "models/profiles", "model.profile.uml"), 
			SIEMENS_MODELS_AUTHOR, ModelSystem.Siemens, Status.Designed, "models/profiles", Profile.class,
			ModelType.ProfileModel, ProfileModel.class);

		//Variants
		
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "models/variants", "S2_getBuildings_variant1.uml"), 
				SIEMENS_MODELS_AUTHOR, ModelSystem.Siemens, Status.Designed, "models/variants", Model.class,
				ModelType.VariantModel, VariantModel.class);
		
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "models/variants", "S2_getBuildings_variant2.uml"), 
				SIEMENS_MODELS_AUTHOR, ModelSystem.Siemens, Status.Designed, "models/variants", Model.class,
				ModelType.VariantModel, VariantModel.class);

		//Feature Model		
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "features/models", "FeatureModel-SiemensCaching.yafm"), 
				SIEMENS_MODELS_AUTHOR, ModelSystem.Siemens, Status.Designed, "features/models",
				cz.zcu.yafmt.model.fm.FeatureModel.class, ModelType.FeatureModel, FeatureModel.class);
		
		//Feature Configurations		
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "features/configurations", "FeatureConfiguration-SiemensCaching-Strategy1.yafc"), 
				SIEMENS_MODELS_AUTHOR, ModelSystem.Siemens, Status.Enacted, "features/configurations",
				cz.zcu.yafmt.model.fc.FeatureConfiguration.class, ModelType.FeatureConfiguration, FeatureConfiguration.class);

		prm.populateModel(
			Paths.get(repositoryPath.toString(), "features/configurations", "FeatureConfiguration-SiemensCaching-Strategy2.yafc"), 
			SIEMENS_MODELS_AUTHOR, ModelSystem.Siemens, Status.Computed, "features/configurations",
			cz.zcu.yafmt.model.fc.FeatureConfiguration.class, ModelType.FeatureConfiguration, FeatureConfiguration.class);
		
		//Patterns
		prm.populateModel(
			Paths.get(repositoryPath.toString(), "patterns/eu/supersede/dynadapt/usecases/patterns", "siemens_queries.vql"), 
			SIEMENS_MODELS_AUTHOR, ModelSystem.Siemens, Status.Designed, "patterns/eu/supersede/dynadapt/usecases/patterns",
			org.eclipse.viatra.query.patternlanguage.patternLanguage.PatternModel.class, ModelType.PatternModel, PatternModel.class);

		//Adaptability models
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "adaptability_models", "aspectComposition_Siemens_caching_SC1.aspect"), 
				SIEMENS_MODELS_AUTHOR, ModelSystem.Siemens, Status.Designed, "adaptability_models", Aspect.class,
				ModelType.AdaptabilityModel, AdaptabilityModel.class);
		
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "adaptability_models", "aspectComposition_Siemens_caching_SC2.aspect"), 
				SIEMENS_MODELS_AUTHOR, ModelSystem.Siemens, Status.Designed, "adaptability_models", Aspect.class,
				ModelType.AdaptabilityModel, AdaptabilityModel.class);
		
		log.debug(ModelSystem.Siemens.toString() + " models loaded");	
	}
	
	private void populateFGReconfigurationModels() throws IOException, Exception {
		String userdir = System.getProperty("user.dir");
		Path repositoryPath = FileSystems.getDefault().getPath(userdir,repositoryRelativePath);

		log.debug("Loading " + ModelSystem.FeedbackGatheringReconfiguration.toString());
		
		//BaseModel
		
		
		//Profiles
		

		//Variants
		

		//Feature Model
		prm.populateModel(
			Paths.get(repositoryPath.toString(), "features/models", "FeedbackGatheringConfigV6.yafm"), 
			SENERCON_MODELS_AUTHOR, ModelSystem.SenerconFG, Status.Designed, "features/models",
			cz.zcu.yafmt.model.fm.FeatureModel.class, ModelType.FeatureModel, FeatureModel.class);
		
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "features/models", "FeedbackGatheringConfigCategory.yafm"), 
				SENERCON_MODELS_AUTHOR, ModelSystem.SenerconFGcat, Status.Designed, "features/models",
				cz.zcu.yafmt.model.fm.FeatureModel.class, ModelType.FeatureModel, FeatureModel.class);
		
		//Feature Configurations
		prm.populateModel(
			Paths.get(repositoryPath.toString(), "features/configurations", "FeedbackGatheringConfigV6.yafc"), 
			SENERCON_MODELS_AUTHOR, ModelSystem.SenerconFG, Status.Enacted, "features/configurations",
			cz.zcu.yafmt.model.fc.FeatureConfiguration.class, ModelType.FeatureConfiguration, FeatureConfiguration.class);
		
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "features/configurations", "FeedbackGatheringConfigCategory.yafc"), 
				SENERCON_MODELS_AUTHOR, ModelSystem.SenerconFGcat, Status.Enacted, "features/configurations",
				cz.zcu.yafmt.model.fc.FeatureConfiguration.class, ModelType.FeatureConfiguration, FeatureConfiguration.class);

		//Patterns
		

		//Adaptability models
		
		
		log.debug(ModelSystem.SenerconFG.toString() + " models loaded");	
	}
	
	private void populateRepository() throws Exception {
		//Read repository folder structure
		String userdir = System.getProperty("user.dir");
		Path path = FileSystems.getDefault().getPath(userdir,repositoryRelativePath);
		
		prm.populateModels(path, "models/base", "uml", Model.class, ModelType.BaseModel, BaseModel.class);
		prm.populateModels(path, "models/profiles", "uml", Profile.class, ModelType.ProfileModel, ProfileModel.class);
		prm.populateModels(path, "models/variants", "uml", Model.class, ModelType.VariantModel, VariantModel.class);
		prm.populateModels(path, "features/models", "yafm", cz.zcu.yafmt.model.fm.FeatureModel.class, ModelType.FeatureModel, FeatureModel.class);
		prm.populateModels(path, "features/configurations", "yafc", cz.zcu.yafmt.model.fc.FeatureConfiguration.class, ModelType.FeatureConfiguration, FeatureConfiguration.class);
		prm.populateModels(path, "adaptability_models", "aspect", Aspect.class, ModelType.AdaptabilityModel, AdaptabilityModel.class);
		//FIXME add other system patterns
		prm.populateModels(path, "patterns/eu/supersede/dynadapt/usecases/patterns", "vql", org.eclipse.viatra.query.patternlanguage.patternLanguage.PatternModel.class, ModelType.PatternModel, PatternModel.class);
	}

}
