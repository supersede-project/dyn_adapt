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

	@Override
	public void addChild(FeatureSUPERSEDE parent, FeatureSUPERSEDE child) {
		List<FeatureSUPERSEDE> children = parent.getChildren();
		children.add(child);
		parent.setChildren(children);
	}

	public List<Constraint> getFeatureConstraints(Feature feature) {
		FeatureModel fm = feature.getFeatureModel();
		List<Constraint> fConstraints = new ArrayList<Constraint>();

		List<Constraint> mConstraints = fm.getConstraints();
		if (!mConstraints.isEmpty()) {
			Iterator<Constraint> itconstraints = mConstraints.iterator();
			while (itconstraints.hasNext()) {
				Constraint c = itconstraints.next();
				// Modify to regular expression for exactly matching feature id.
				// E.g. monitor != monitor1
				if (c.getValue().contains(feature.getId()))
					fConstraints.add(c);
			}
		}

		return fConstraints;
	}

	/**
	 * This method return the siblings of a given feature if exist. Siblings are
	 * features with the same parent.
	 * 
	 * @param feature
	 */

	public void setFeatureSiblings(FeatureSUPERSEDE featureSUPERSEDE) {
		FeatureSUPERSEDE parent = featureSUPERSEDE.getParent();
		/*Fix predicate*/
		Predicate<FeatureSUPERSEDE> filter = new Predicate<FeatureSUPERSEDE>() {
			
			@Override
			public boolean test(FeatureSUPERSEDE t) {
				
				return t.getName().equalsIgnoreCase(featureSUPERSEDE.getName());
			}
		};  
		if (parent != null){
			List<FeatureSUPERSEDE> siblings = parent.getChildren();
//			siblings.removeIf(filter);
			featureSUPERSEDE.setSiblings(siblings);
		}
	}

	// public FeatureLAO() {
	//
	// }
	//
	// @Override
	// public List<FeatureSUPERSEDE> createFeaturesSUPERSEDE(List<Feature> f) {
	// /**
	// * FeatureSUPERSEDE
	// *
	// * String name, List<Feature> children, Feature parent, List<Feature>
	// * siblings, List<Attribute> attributes, List<Constraint> constraints
	// *
	// */
	// List<FeatureSUPERSEDE> children = getFeatureChildren(f.get(0));
	//
	// List<Constraint> constraints = getFeatureConstraints(f);
	//
	// List<FeatureSUPERSEDE> siblings = new ArrayList<FeatureSUPERSEDE>();
	//
	// FeatureSUPERSEDE parent = null; // f.getParentFeature()
	//
	// if (!f.isRoot()) {
	// siblings = getFeatureSiblings(f);
	// }
	//
	// return (new FeatureSUPERSEDE(f.getName(), children, parent, siblings,
	// f.getAttributes(), constraints));
	// }
	//
	// /**
	// * This method return the children of a given feature if exist. Features
	// * under groups are also considered children
	// *
	// * @param feature
	// */
	//
	// private List<FeatureSUPERSEDE> getFeatureChildren(Feature feature) {
	// List<FeatureSUPERSEDE> childrenSUPERSEDE = new
	// ArrayList<FeatureSUPERSEDE>();
	// List<Feature> children = feature.getFeatures();
	//
	// List<Group> featureGroups = feature.getGroups();
	// if (!featureGroups.isEmpty()) {
	// Iterator<Group> itgroups = featureGroups.iterator();
	// while (itgroups.hasNext()) {
	// Group g = itgroups.next();
	// List<Feature> featuresGroup = g.getFeatures();
	// children.addAll(featuresGroup);
	// }
	// }
	//
	// Iterator<Feature> itchildren = children.iterator();
	// while (itchildren.hasNext()) {
	// childrenSUPERSEDE.add(createFeatureSUPERSEDE(itchildren.next()));
	// }
	//
	// return childrenSUPERSEDE;
	// }
	//
	// /**
	// * This method return the siblings of a given feature if exist. Siblings
	// are
	// * features with the same parent.
	// *
	// * @param feature
	// */
	//
	// private List<FeatureSUPERSEDE> getFeatureSiblings(Feature feature) {
	// Feature parent = feature.getParentFeature();
	// return getFeatureChildren(parent);
	// }
	//
	// /**
	// * This method return the constraints related with a given feature if
	// exist.
	// *
	// * @param feature
	// */
	//
	// private List<Constraint> getFeatureConstraints(Feature feature) {
	// FeatureModel fm = feature.getFeatureModel();
	// List<Constraint> fConstraints = new ArrayList<Constraint>();
	//
	// List<Constraint> mConstraints = fm.getConstraints();
	// if (!mConstraints.isEmpty()) {
	// Iterator<Constraint> itconstraints = mConstraints.iterator();
	// while (itconstraints.hasNext()) {
	// Constraint c = itconstraints.next();
	// if (c.getValue().contains(feature.getId()))
	// fConstraints.add(c);
	// }
	// }
	//
	// return fConstraints;
	// }

}
