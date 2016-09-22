/*
 * @author Edith Zavala
 * */

package eu.supersede.dynadapt.featuremodel.fm;

import eu.supersede.dynadapt.featuremodel.feature.FeatureSUPERSEDE;

public interface IFeatureModelLAO {

	//public void creatFeatureModelSUPERSEDE(FeatureModelSUPERSEDE featureModelSUPERSEDE);
	
	public FeatureModelSUPERSEDE getFeatureModelSUPERSEDE(String featureModelPath);
	
	public FeatureSUPERSEDE getFeatureSUPERSEDEByName(FeatureModelSUPERSEDE m, String name);
}
