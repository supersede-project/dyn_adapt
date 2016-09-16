/**
 * 
 * @author Edith Zavala
 * */

package eu.supersede.dynadapt.featuremodel.fc;

import org.eclipse.emf.mwe.utils.StandaloneSetup;

import eu.supersede.dynadapt.model.IModelManager;
import eu.supersede.dynadapt.model.ModelManager;

public class FeatureConfigDAO implements IFeatureConfigDAO{

	@Override
	public IFeatureConfigSUPERSEDE loadFeatureConfig(String featureConfigPath) {
		new StandaloneSetup().setPlatformUri("../");
		IModelManager modelManager = new ModelManager();
		FeatureConfigSUPERSEDE fc = new FeatureConfigSUPERSEDE(modelManager.loadFeatureConfiguration(featureConfigPath));
		return fc;
	}

}
