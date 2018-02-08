package eu.supersede.feedbackgathering.reconfiguration.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;
import eu.supersede.dynadapt.modelrepository.repositoryaccess.ModelRepository;
import cz.zcu.yafmt.model.fc.FeatureConfiguration;
import eu.supersede.feedbackgathering.reconfiguration.enactor.FeatureConfiguration2Json;
import eu.supersede.feedbackgathering.reconfiguration.enactor.FeedbackGatheringConfigurationProfile;
import eu.supersede.feedbackgathering.reconfiguration.enactor.FeedbackGatheringUpdateAttributes;
//import eu.supersede.integration.api.adaptation.types.ModelSystem;

public class FeedbackGatheringReconfigurationTest {

	private ModelRepository mr;
	
	@Test
	public void testConfigure() throws IOException {
		// NOTE: Edit this absolute paths before testing
		String absoluteModelPath = "/workspaceSTS/monitor_feedback_reconfig/feedback_reconf/ModelSystem/FC/FeedbackGatheringConfigV5_optimized.yafc";
		//String absoluteModelPath = "/workspaceSTS/monitor_feedback_reconfig/feedback_reconf/ModelSystem/FC/FeedbackGatheringConfigCategory_reconfig.yafc";
		String absolutetargetFolderPath = "/workspaceSTS/monitor_feedback_reconfig/feedback_reconf/ModelSystem/json/";
		FeatureConfiguration2Json.configurationProfileFC2JsonInFolder(absoluteModelPath, absolutetargetFolderPath);
	}
	
	@Test
	public void testUpdate() throws IOException {
		// NOTE: Edit this absolute paths before testing
		//String absoluteModelPath = "/workspaceSTS/monitor_feedback_reconfig/feedback_reconf/ModelSystem/FC/FeedbackGatheringConfigV5_optimized.yafc";
		String absoluteModelPath = "/workspaceSTS/monitor_feedback_reconfig/feedback_reconf/ModelSystem/FC/FeedbackGatheringConfigCategory_reconfig.yafc";
		String absolutetargetFolderPath = "/workspaceSTS/monitor_feedback_reconfig/feedback_reconf/ModelSystem/json/";
		FeatureConfiguration2Json.updateFeatureAttributesFC2JsonInFolder(absoluteModelPath, absolutetargetFolderPath);
	}
	
	@Test
	public void testFGEnactorUpdate() throws Exception {
		FeedbackGatheringUpdateAttributes FGenactor = new FeedbackGatheringUpdateAttributes();
		FeatureConfiguration newFeatureConfig = mr.getFeatureConfigurationModel("FeedbackGatheringConfigCategory.yafc");
		FGenactor.enactFeatureConfiguration(newFeatureConfig, true);
	}
	
	@Test
	public void testFGEnactorProfile() throws Exception {
		FeedbackGatheringConfigurationProfile FGenactor = new FeedbackGatheringConfigurationProfile();
		BufferedReader br = null;
		FileReader fr = null;
		
		fr = new FileReader("/workspaceSTS/monitor_feedback_reconfig/feedback_reconf/ModelSystem/FC/FeedbackGatheringConfigV5_optimized.yafc");
		br = new BufferedReader(fr);
		
		//FeatureConfiguration newFeatureConfig = mr.getLastEnactedFeatureConfigurationForSystem();
				//mr.getFeatureConfigurationModel("FeedbackGatheringConfigV5.yafc");
		//FGenactor.enactFeatureConfiguration(newFeatureConfig, true);
	}
}