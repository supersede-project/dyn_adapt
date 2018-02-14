package eu.supersede.dynadapt.dm.integration;

import java.io.IOException;
import java.util.Map;

import eu.supersede.integration.api.adaptation.types.FeatureConfiguration;
import eu.supersede.dynadapt.model.ModelManager;
import eu.supersede.dynadapt.modelrepository.populate.PopulateRepositoryManager;
import eu.supersede.dynadapt.modelrepository.repositoryaccess.ModelRepository;
import eu.supersede.integration.api.adaptation.types.ModelSystem;
import eu.supersede.integration.api.adaptation.types.ModelType;
import eu.supersede.integration.api.adaptation.types.Status;

public class FeatureUtils {

	private ModelRepository mr;
	private ModelManager mm;
	
	public FeatureUtils(ModelRepository mr, ModelManager mm) {
		this.mr = mr;
		this.mm = mm;
	}
	
	/** 
	 * FIXME Take this method to PopulateRepositoryManager as it is duplicated in Adapter and
	 * Adapter's tests!!!
	 * Load the latest computed FeatureConfiguration for the given system.
	 * @param fc the latest {@link FeatureConfiguration} model
	 * @param fcName the name of the feature configuration file
	 * @param system the system owner of the adated model
	 * @return the id of the uploaded model in the model repository
	 * @throws IOException
	 * @throws Exception
	 */
	protected String uploadLatestComputedFC(cz.zcu.yafmt.model.fc.FeatureConfiguration fc,
			String fcName, ModelSystem system,
			String modelAuthor,
			String location) throws IOException, Exception {
		PopulateRepositoryManager prm = new PopulateRepositoryManager (mm, mr);
		String modelId = prm.populateModel(fc, fcName, modelAuthor, system, Status.Computed,
				location, cz.zcu.yafmt.model.fc.FeatureConfiguration.class,
				ModelType.FeatureConfiguration, FeatureConfiguration.class);
		return modelId;
	}
}
