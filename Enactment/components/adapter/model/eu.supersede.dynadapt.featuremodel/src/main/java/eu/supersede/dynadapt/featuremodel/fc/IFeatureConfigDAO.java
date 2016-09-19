/**
 * 
 * @author Edith Zavala
 * */

package eu.supersede.dynadapt.featuremodel.fc;

import cz.zcu.yafmt.model.fc.FeatureConfiguration;

public interface IFeatureConfigDAO {

	public FeatureConfiguration loadFeatureConfig(String featureConfigPath);
}
