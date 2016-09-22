package eu.supersede.dynadapt.featuremodel.feature;

import java.util.List;

import cz.zcu.yafmt.model.fm.Constraint;
import cz.zcu.yafmt.model.fm.Feature;

public interface IFeatureLAO {
	public void addChild(FeatureSUPERSEDE parent, FeatureSUPERSEDE child);
		
	public void setFeatureSiblings(FeatureSUPERSEDE featureSUPERSEDE);
}
