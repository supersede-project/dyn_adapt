package eu.supersede.dynadapt.featureparser.feature;

import java.util.List;

public interface IFeatureModel {

	public List<IFeature> getAllFeatures();
	
	public List<IFeature> getEnabledFeatures();
	
	public List<IFeature> getDisabledFeatures();
	
	public List<String> getAllConstraints();
}
