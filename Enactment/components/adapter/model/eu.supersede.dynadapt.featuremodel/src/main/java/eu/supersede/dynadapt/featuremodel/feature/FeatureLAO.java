package eu.supersede.dynadapt.featuremodel.feature;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cz.zcu.yafmt.model.fm.Constraint;
import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.FeatureModel;
import cz.zcu.yafmt.model.fm.Group;

public class FeatureLAO implements IFeatureLAO {

	public FeatureLAO() {

	}

	@Override
	public FeatureSUPERSEDE createFeatureSUPERSEDE(Feature f) {
		/**
		 * FeatureSUPERSEDE
		 * 
		 * String name, List<Feature> children, Feature parent, List<Feature>
		 * siblings, List<Attribute> attributes, List<Constraint> constraints
		 *
		 */
		List<Feature> children = getFeatureChildren(f);

		List<Feature> siblings = getFeatureSiblings(f);

		List<Constraint> constraints = getFeatureConstraints(f);

		return (new FeatureSUPERSEDE(f.getName(), children, f.getParentFeature(), siblings, f.getAttributes(), constraints));
	}

	/**
	 * This method return the children of a given feature if exist. Features
	 * under groups are also considered children
	 * 
	 * @param feature
	 */

	private List<Feature> getFeatureChildren(Feature feature) {
		List<Feature> children = feature.getFeatures();

		List<Group> featureGroups = feature.getGroups();
		if (!featureGroups.isEmpty()) {
			Iterator<Group> itgroups = featureGroups.iterator();
			while (itgroups.hasNext()) {
				Group g = itgroups.next();
				List<Feature> featuresGroup = g.getFeatures();
				children.addAll(featuresGroup);
			}
		}

		return children;
	}

	/**
	 * This method return the siblings of a given feature if exist. Siblings are
	 * features with the same parent.
	 * 
	 * @param feature
	 */

	private List<Feature> getFeatureSiblings(Feature feature) {
		Feature parent = feature.getParentFeature();
		return getFeatureChildren(parent);
	}

	/**
	 * This method return the constraints related with a given feature if exist.
	 * 
	 * @param feature
	 */

	private List<Constraint> getFeatureConstraints(Feature feature) {
		FeatureModel fm = feature.getFeatureModel();
		List<Constraint> fConstraints = new ArrayList<Constraint>();
		
		List<Constraint> mConstraints = fm.getConstraints();
		if (!mConstraints.isEmpty()) {
			Iterator<Constraint> itconstraints = mConstraints.iterator();
			while (itconstraints.hasNext()) {
				Constraint c = itconstraints.next();
				if (c.getValue().contains(feature.getId()))
					fConstraints.add(c);
			}
		}

		return fConstraints;
	}

}
