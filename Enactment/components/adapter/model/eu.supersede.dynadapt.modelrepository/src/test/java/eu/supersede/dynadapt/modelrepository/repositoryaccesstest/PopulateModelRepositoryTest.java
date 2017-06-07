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
import java.net.URI;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Profile;
import org.junit.Before;
import org.junit.Test;

import eu.supersede.dynadapt.dsl.aspect.Aspect;
import eu.supersede.dynadapt.featuremodel.fc.FeatureConfigDAO;
import eu.supersede.dynadapt.featuremodel.fc.FeatureConfigLAO;
import eu.supersede.dynadapt.featuremodel.fc.IFeatureConfigLAO;
import eu.supersede.dynadapt.model.ModelManager;
import eu.supersede.dynadapt.modelrepository.populate.PopulateRepositoryManager;
import eu.supersede.dynadapt.modelrepository.repositoryaccess.ModelRepository;
import eu.supersede.integration.api.adaptation.types.AdaptabilityModel;
import eu.supersede.integration.api.adaptation.types.BaseModel;
import eu.supersede.integration.api.adaptation.types.FeatureConfiguration;
import eu.supersede.integration.api.adaptation.types.FeatureModel;
import eu.supersede.integration.api.adaptation.types.IModel;
import eu.supersede.integration.api.adaptation.types.ModelMetadata;
import eu.supersede.integration.api.adaptation.types.ModelSystem;
import eu.supersede.integration.api.adaptation.types.ModelType;
import eu.supersede.integration.api.adaptation.types.PatternModel;
import eu.supersede.integration.api.adaptation.types.ProfileModel;
import eu.supersede.integration.api.adaptation.types.Status;
import eu.supersede.integration.api.adaptation.types.VariantModel;

public class PopulateModelRepositoryTest {

	private final static Logger log = LogManager.getLogger(PopulateModelRepositoryTest.class);
	
	String repository = "platform:/resource/eu.supersede.dynadapt.adapter.service/repository/";
	String repositoryRelativePath = "../../../../services/eu.supersede.dynadapt.adapter.service/repository/";

	Map<String, String> modelsLocation;

	URL url = null;

	ModelRepository mr = null;
	ModelManager mm = null;
	PopulateRepositoryManager prm = null;

	IFeatureConfigLAO fcLAO = null;

	@Before
	public void setUp() throws Exception {
		new StandaloneSetup().setPlatformUri("../");
		modelsLocation = new HashMap<String, String>();
		modelsLocation.put("aspects", "adaptability_models/");
		modelsLocation.put("variants", "models/variants/");
		modelsLocation.put("profiles", "models/profiles/");
		modelsLocation.put("patterns", "patterns/");
		modelsLocation.put("features", "features/models/");

		fcLAO = new FeatureConfigLAO(new FeatureConfigDAO());
		url = getClass().getResource("/");
		mm = new ModelManager(false);
		mr = new ModelRepository(repository, repositoryRelativePath, mm);
		prm = new PopulateRepositoryManager (mm, mr);
		
		//Clean-up repository
		cleanUpRepository();
	}

	private void cleanUpRepository() {
		//Remove all repository models
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
	}
	
	private void populateAtosModels() throws IOException, Exception {
		String userdir = System.getProperty("user.dir");
		Path repositoryPath = FileSystems.getDefault().getPath(userdir,repositoryRelativePath);
		

		//BaseModel
		prm.populateModel(
			Paths.get(repositoryPath.toString(), "models/base", "atos_smart_base_model.uml"), 
			"Yosu", ModelSystem.Atos_HSK, Status.Enacted, "models/base", Model.class, ModelType.BaseModel, BaseModel.class);
		
		//Profile
		prm.populateModel(
			Paths.get(repositoryPath.toString(), "models/profiles", "adm.profile.uml"), 
			"Yosu", ModelSystem.Atos_HSK, Status.Designed, "models/profiles", Profile.class, ModelType.ProfileModel, ProfileModel.class);
		
		//Variants
		prm.populateModel(
			Paths.get(repositoryPath.toString(), "models/variants", "atos_smart_hsk_vm2a_high.uml"), 
			"Yosu", ModelSystem.Atos_HSK, Status.Designed, "models/variants", Model.class, ModelType.VariantModel, VariantModel.class);

		prm.populateModel(
				Paths.get(repositoryPath.toString(), "models/variants", "atos_smart_hsk_vm2a_low.uml"), 
				"Yosu", ModelSystem.Atos_HSK, Status.Designed, "models/variants", Model.class, ModelType.VariantModel, VariantModel.class);

		prm.populateModel(
				Paths.get(repositoryPath.toString(), "models/variants", "atos_smart_hsk_vm2a_medium.uml"), 
				"Yosu", ModelSystem.Atos_HSK, Status.Designed, "models/variants", Model.class, ModelType.VariantModel, VariantModel.class);

		prm.populateModel(
				Paths.get(repositoryPath.toString(), "models/variants", "atos_smart_hsk_vm2b_high.uml"), 
				"Yosu", ModelSystem.Atos_HSK, Status.Designed, "models/variants", Model.class, ModelType.VariantModel, VariantModel.class);

		prm.populateModel(
				Paths.get(repositoryPath.toString(), "models/variants", "atos_smart_hsk_vm2b_low.uml"), 
				"Yosu", ModelSystem.Atos_HSK, Status.Designed, "models/variants", Model.class, ModelType.VariantModel, VariantModel.class);
		
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "models/variants", "atos_smart_hsk_vm2b_medium.uml"), 
				"Yosu", ModelSystem.Atos_HSK, Status.Designed, "models/variants", Model.class, ModelType.VariantModel, VariantModel.class);

		//Feature Model
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "features/models", "SmartPlatformFM_HSK.yafm"), 
				"Yosu", ModelSystem.Atos_HSK, Status.Designed, "features/models", cz.zcu.yafmt.model.fm.FeatureModel.class, ModelType.FeatureModel, FeatureModel.class);

		//Feature Configurations
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "features/configurations", "SmartPlatformFC_HSK_SingleVM_LowLoad.yafc"), 
				"Yosu", ModelSystem.Atos_HSK, Status.Enacted, "features/configurations", cz.zcu.yafmt.model.fc.FeatureConfiguration.class, ModelType.FeatureConfiguration, FeatureConfiguration.class);

		prm.populateModel(
				Paths.get(repositoryPath.toString(), "features/configurations", "SmartPlatformFC_HSK_SingleVM_HighLoad.yafc"), 
				"Yosu", ModelSystem.Atos_HSK, Status.Computed, "features/configurations", cz.zcu.yafmt.model.fc.FeatureConfiguration.class, ModelType.FeatureConfiguration, FeatureConfiguration.class);

//		prm.populateModel(
//				Paths.get(repositoryPath.toString(), "features/configurations", "SmartPlatformFC_HSK_LowLoad_optimized.yafc"), 
//				"Yosu", ModelSystem.Atos_HSK, Status.Computed, "features/configurations", cz.zcu.yafmt.model.fc.FeatureConfiguration.class, ModelType.FeatureConfiguration, FeatureConfiguration.class);

		prm.populateModel(
				Paths.get(repositoryPath.toString(), "features/configurations", "SmartPlatformFC_HSK_DualVM_HighMediumLoad.yafc"), 
				"Yosu", ModelSystem.Atos_HSK, Status.Computed, "features/configurations", cz.zcu.yafmt.model.fc.FeatureConfiguration.class, ModelType.FeatureConfiguration, FeatureConfiguration.class);

		prm.populateModel(
				Paths.get(repositoryPath.toString(), "features/configurations", "SmartPlatformFC_HSK_DualVM_HighLowLoad.yafc"), 
				"Yosu", ModelSystem.Atos_HSK, Status.Computed, "features/configurations", cz.zcu.yafmt.model.fc.FeatureConfiguration.class, ModelType.FeatureConfiguration, FeatureConfiguration.class);

		//Patterns
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "patterns/eu/supersede/dynadapt/usecases/patterns", "atos_query_patterns.vql"), 
				"Yosu", ModelSystem.Atos_HSK, Status.Designed, "patterns/eu/supersede/dynadapt/usecases/patterns", org.eclipse.viatra.query.patternlanguage.patternLanguage.PatternModel.class, ModelType.PatternModel, PatternModel.class);

		//Adaptability models
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "adaptability_models", "atos_smart_hsk_vm2a_high_load.aspect"), 
				"Yosu", ModelSystem.Atos_HSK, Status.Designed, "adaptability_models", Aspect.class, ModelType.AdaptabilityModel, AdaptabilityModel.class);
		
		prm.populateModel(
				Paths.get(repositoryPath.toString(), "adaptability_models", "atos_smart_hsk_vm2a_low_load.aspect"), 
				"Yosu", ModelSystem.Atos_HSK, Status.Designed, "adaptability_models", Aspect.class, ModelType.AdaptabilityModel, AdaptabilityModel.class);

		prm.populateModel(
				Paths.get(repositoryPath.toString(), "adaptability_models", "atos_smart_hsk_vm2a_medium_load.aspect"), 
				"Yosu", ModelSystem.Atos_HSK, Status.Designed, "adaptability_models", Aspect.class, ModelType.AdaptabilityModel, AdaptabilityModel.class);

		prm.populateModel(
				Paths.get(repositoryPath.toString(), "adaptability_models", "atos_smart_hsk_vm2b_high_load.aspect"), 
				"Yosu", ModelSystem.Atos_HSK, Status.Designed, "adaptability_models", Aspect.class, ModelType.AdaptabilityModel, AdaptabilityModel.class);

		prm.populateModel(
				Paths.get(repositoryPath.toString(), "adaptability_models", "atos_smart_hsk_vm2b_low_load.aspect"), 
				"Yosu", ModelSystem.Atos_HSK, Status.Designed, "adaptability_models", Aspect.class, ModelType.AdaptabilityModel, AdaptabilityModel.class);

		prm.populateModel(
				Paths.get(repositoryPath.toString(), "adaptability_models", "atos_smart_hsk_vm2b_medium_load.aspect"), 
				"Yosu", ModelSystem.Atos_HSK, Status.Designed, "adaptability_models", Aspect.class, ModelType.AdaptabilityModel, AdaptabilityModel.class);

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
