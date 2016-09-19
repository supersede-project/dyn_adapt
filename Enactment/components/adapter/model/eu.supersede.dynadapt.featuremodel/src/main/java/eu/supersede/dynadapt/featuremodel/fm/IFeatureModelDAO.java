/**
 * 
 * @author Edith Zavala
 */

package eu.supersede.dynadapt.featuremodel.fm;

import cz.zcu.yafmt.model.fm.FeatureModel;

public interface IFeatureModelDAO {

	public FeatureModel loadFeatureModel(String featureModelPath);
}
