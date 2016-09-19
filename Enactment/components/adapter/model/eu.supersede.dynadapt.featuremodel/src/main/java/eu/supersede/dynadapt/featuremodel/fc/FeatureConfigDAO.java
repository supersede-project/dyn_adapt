/**
 * 
 * @author Edith Zavala
 * */

package eu.supersede.dynadapt.featuremodel.fc;

import org.eclipse.emf.mwe.utils.StandaloneSetup;

import cz.zcu.yafmt.model.fc.FeatureConfiguration;
import eu.supersede.dynadapt.model.ModelManager;

public class FeatureConfigDAO implements IFeatureConfigDAO {

	@Override
	public FeatureConfiguration loadFeatureConfig(String featureConfigPath) {
		new StandaloneSetup().setPlatformUri("../");
		return (new ModelManager()).loadFeatureConfiguration(featureConfigPath);
	}

}
