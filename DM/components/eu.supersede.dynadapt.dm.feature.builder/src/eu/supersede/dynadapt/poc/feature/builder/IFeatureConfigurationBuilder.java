package eu.supersede.dynadapt.poc.feature.builder;

import java.util.List;

import cz.zcu.yafmt.model.fc.FeatureConfiguration;
import cz.zcu.yafmt.model.fm.FeatureModel;

public interface IFeatureConfigurationBuilder {

	/**
	 * Creates a configuration for given feature model, by selecting the features given by Ids
	 * @param fm the feature model for which the  configuration is created
	 * @param selectedFeatureIds the list of feature ids to be selected (e.g. enabled)
	 * @return
	 */
	FeatureConfiguration buildFeatureConfiguration(FeatureModel fm, List<String> selectedFeatureIds);

}