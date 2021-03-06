package eu.supersede.dynadapt.modelrepository.repositoryaccess;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.viatra.query.patternlanguage.patternLanguage.PatternModel;

import cz.zcu.yafmt.model.fc.FeatureConfiguration;
import cz.zcu.yafmt.model.fm.FeatureModel;
import eu.supersede.dynadapt.aom.dsl.parser.IAdaptationParser;
import eu.supersede.dynadapt.dsl.aspect.Aspect;
import eu.supersede.integration.api.adaptation.types.AdaptabilityModel;
import eu.supersede.integration.api.adaptation.types.BaseModel;
import eu.supersede.integration.api.adaptation.types.IModel;
import eu.supersede.integration.api.adaptation.types.ModelMetadata;
import eu.supersede.integration.api.adaptation.types.ModelSystem;
import eu.supersede.integration.api.adaptation.types.ModelType;
import eu.supersede.integration.api.adaptation.types.ModelUpdateMetadata;
import eu.supersede.integration.api.adaptation.types.ProfileModel;
import eu.supersede.integration.api.adaptation.types.VariantModel;

/*
 * Defines CRUD operations for specialized models, including UML, YAFMT, Viatra, AdaptabilityModels
 * Implementation should use IF Proxy for Model Repository Manager
 */
public interface IModelRepository {
	// UML Base Models
	String storeBaseModel(Model model, ModelMetadata metadata) throws Exception;

	Model getBaseModel(String id) throws Exception;

	void updateBaseModel(Model model, ModelUpdateMetadata metadata, String id) throws Exception;

	void deleteBaseModel(String id) throws Exception;

	// UML Variant Models
	String storeVariantModel(Model model, ModelMetadata metadata) throws Exception;

	Model getVariantModel(String id) throws Exception;

	void updateVariantModel(Model model, ModelUpdateMetadata metadata, String id) throws Exception;

	void deleteVariantModel(String id) throws Exception;

	// UML Profile Models
	String storeProfileModel(Profile profile, ModelMetadata metadata) throws Exception;

	Profile getProfileModel(String id) throws Exception;

	void updateProfileModel(Profile profile, ModelUpdateMetadata metadata, String id) throws Exception;

	void deleteProfileModel(String id) throws Exception;

	// Pattern Models
	String storePatternModel(PatternModel model, ModelMetadata metadata) throws Exception;

	PatternModel getPatternModel(String id) throws Exception;

	void updatePatternModel(PatternModel model, ModelUpdateMetadata metadata, String id) throws Exception;

	void deletePatternModel(String id) throws Exception;

	// Feature Models
	String storeFeatureModel(FeatureModel model, ModelMetadata metadata) throws Exception;

	FeatureModel getFeatureModel(String id) throws Exception;

	void updateModel(FeatureModel model, ModelUpdateMetadata metadata, String id) throws Exception;

	void deleteFeatureModel(String id) throws Exception;

	// Feature Configuration Models
	String storeFeatureConfigurationModel(FeatureConfiguration model, ModelMetadata metadata) throws Exception;

	FeatureConfiguration getFeatureConfigurationModel(String id) throws Exception;

	void updateFeatureConfigurationModel(FeatureConfiguration model, ModelUpdateMetadata metadata, String id) throws Exception;

	void deleteFeatureConfigurationModel(String id) throws Exception;

	// Adaptability Models
	String storeAspectModel(Aspect model, ModelMetadata metadata) throws Exception;

	Aspect getAspectModel(String id) throws Exception;

	void updateAspectModel(Aspect model, ModelUpdateMetadata metadata, String id) throws Exception;

	void deleteAspectModel(String id) throws Exception;
	
	//Query Operations
	Model getLastEnactedBaseModelForSystem (ModelSystem system) throws Exception;
	String getIdOfLastBaseModelForSystem(ModelSystem system) throws Exception;
	BaseModel getMetadataOfLastBaseModelForSystem(ModelSystem system) throws Exception;
	Model getLastBaseModelForSystem(ModelSystem system) throws Exception;
	FeatureConfiguration getLastEnactedFeatureConfigurationForSystem (ModelSystem system) throws Exception; 
	FeatureConfiguration getLastComputedFeatureConfigurationForSystem (ModelSystem system) throws Exception; 
	eu.supersede.integration.api.adaptation.types.FeatureConfiguration getMetadataOfLastComputedFeatureConfigurationForSystem(ModelSystem system) throws Exception;
	List<Aspect> getAspectModelsForSystem (ModelSystem system) throws Exception; 
	List<Model> getVariantModelsForSystem (ModelSystem system) throws Exception;
	List<Profile> getProfilesForSystem (ModelSystem system) throws Exception;
	List<PatternModel> getPatternModelsForSystem (ModelSystem system) throws Exception;
	List<FeatureModel> getFeatureModelsForSystem(ModelSystem system) throws Exception;
	
	//Repository clean-up
	void cleanUpRepository();
	
	//Reading models from string
	public <T extends EObject> T readModelFromString(String modelContent, ModelType type, Class<T> modelClass) throws Exception;

}
