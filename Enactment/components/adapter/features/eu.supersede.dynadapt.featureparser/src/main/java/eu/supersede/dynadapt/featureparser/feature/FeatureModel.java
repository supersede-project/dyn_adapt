package eu.supersede.dynadapt.featureparser.feature;

import java.util.List;

public class FeatureModel implements IFeatureModel{
	
	private List<IFeature> features;
	
	/*V1 = FilePath */
	public FeatureModel(String featureModelLocation) {
		super();
		/*TODO: Read Feature Model and load Features*/
	}

	@Override
	public List<IFeature> getAllFeatures() {
		return null;
	}

	@Override
	public List<IFeature> getEnabledFeatures() {
		return null;
	}

	@Override
	public List<IFeature> getDisabledFeatures() {
		return null;
	}

	@Override
	public List<String> getAllConstraints() {
		return null;
	}
	
}
