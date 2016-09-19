/**
 * 
 * @author Edith Zavala
 */

package eu.supersede.dynadapt.featuremodel.fm;

import org.eclipse.emf.mwe.utils.StandaloneSetup;

import cz.zcu.yafmt.model.fm.FeatureModel;
import eu.supersede.dynadapt.model.ModelManager;

public class FeatureModelDAO implements IFeatureModelDAO {

	public FeatureModelDAO(){
		super();
	}
	
	@Override
	public FeatureModel loadFeatureModel(String featureModelPath) {
		new StandaloneSetup().setPlatformUri("../");
		return (new ModelManager()).loadFeatureModel(featureModelPath);
	}

}
