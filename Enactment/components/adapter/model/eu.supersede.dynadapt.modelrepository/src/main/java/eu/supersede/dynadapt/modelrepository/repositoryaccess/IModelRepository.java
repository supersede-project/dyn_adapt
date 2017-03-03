package eu.supersede.dynadapt.modelrepository.repositoryaccess;

import java.util.List;

import org.eclipse.uml2.uml.Model;
import org.eclipse.viatra.query.patternlanguage.patternLanguage.PatternModel;

import cz.zcu.yafmt.model.fc.FeatureConfiguration;
import cz.zcu.yafmt.model.fm.FeatureModel;
import eu.supersede.dynadapt.dsl.aspect.Aspect;
import eu.supersede.integration.api.adaptation.types.ModelMetadata;
import eu.supersede.integration.api.adaptation.types.ModelSystem;
import eu.supersede.integration.api.adaptation.types.ModelUpdateMetadata;

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
	String storeProfileModel(Model model, ModelMetadata metadata) throws Exception;

	Model getProfileModel(String id) throws Exception;

	void updateProfileModel(Model model, ModelUpdateMetadata metadata, String id) throws Exception;

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
	Model getLastBaseModelForSystem(ModelSystem system) throws Exception;
	FeatureConfiguration getLastEnactedFeatureConfigurationForSystem (ModelSystem system) throws Exception; 
	FeatureConfiguration getLastComputedFeatureConfigurationForSystem (ModelSystem system) throws Exception; 
	List<Aspect> getAspectModelsForSystem (ModelSystem system) throws Exception; 
	List<Model> getVariantModelsForSystem (ModelSystem system) throws Exception;
	List<Model> getProfilesForSystem (ModelSystem system) throws Exception;
	List<PatternModel> getPatternModelsForSystem (ModelSystem system) throws Exception;
	
}
