/**
 * 
 * @author Edith Zavala
 */

package eu.supersede.dynadapt.featuremodel.fm;

import org.eclipse.emf.mwe.utils.StandaloneSetup;

import eu.supersede.dynadapt.model.IModelManager;
import eu.supersede.dynadapt.model.ModelManager;

public class FeatureModelDAO implements IFeatureModelDAO {

	public FeatureModelDAO(){
		super();
	}
	
	@Override
	public IFeatureModelSUPERSEDE loadFeatureModel(String featureModelPath) {
		new StandaloneSetup().setPlatformUri("../");
		IModelManager modelManager = new ModelManager();
		FeatureModelSUPERSEDE fm = new FeatureModelSUPERSEDE(modelManager.loadFeatureModel(featureModelPath));
		return fm;
	}

}
