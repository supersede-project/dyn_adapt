package eu.supersede.dynadapt.featuremodel.feature;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

import cz.zcu.yafmt.model.fm.Constraint;
import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.FeatureModel;
import cz.zcu.yafmt.model.fm.Group;

public class FeatureLAO implements IFeatureLAO {

	/**
	 * This method add a featureSUPERSEDE child to a featureSUPERSEDE parent.
	 * 
	 * @param parent,
	 *            child
	 */
	@Override
	public void addChild(FeatureSUPERSEDE parent, FeatureSUPERSEDE child) {
		List<FeatureSUPERSEDE> children = parent.getChildren();
		children.add(child);
		parent.setChildren(children);
	}

	/**
	 * This method return the siblings of a given featureSUPERSEDE if exist.
	 * Siblings are featuresSUPERSEDE with the same parent.
	 * 
	 * @param featureSUPERSEDE
	 */
	@Override
	public void setFeatureSiblings(FeatureSUPERSEDE featureSUPERSEDE) {
		FeatureSUPERSEDE parent = featureSUPERSEDE.getParent();
		if (parent != null) {
			List<FeatureSUPERSEDE> siblings = parent.getChildren();
			featureSUPERSEDE.setSiblings(removeFeature(featureSUPERSEDE, siblings));
		}
	}

	private List<FeatureSUPERSEDE> removeFeature(FeatureSUPERSEDE featureSUPERSEDE, List<FeatureSUPERSEDE> featuresSUPERSEDEList) {
		List<FeatureSUPERSEDE> outputList = new ArrayList<FeatureSUPERSEDE>();
		Iterator<FeatureSUPERSEDE> itList = featuresSUPERSEDEList.iterator();
		while (itList.hasNext()) {
			FeatureSUPERSEDE f = itList.next();
			if (!featureSUPERSEDE.equals(f))
				outputList.add(f);
		}
		return outputList;
	}

}
