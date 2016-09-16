/**
 * 
 * @author Edith Zavala
 */

package eu.supersede.dynadapt.featuremodel.fm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cz.zcu.yafmt.model.fm.Constraint;
import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.FeatureModel;
import cz.zcu.yafmt.model.fm.Group;

public class FeatureModelSUPERSEDE implements IFeatureModelSUPERSEDE {

	private String name;
	private List<Feature> features;
	private List<Constraint> constraints;

	/**
	 * Creates an instance of FeatureModelSUPERSEDE from a given Feature Model
	 * 
	 * @param FeatureModel
	 */
	public FeatureModelSUPERSEDE(FeatureModel fm) {
		super();
		this.name = fm.getName();
		this.features = new ArrayList<Feature>();
		loadModelFeatures(fm.getRoot());
		this.constraints = fm.getConstraints();
	}

	/**
	 * This recursive method loads all the features below a given feature. 
	 * In this class it is used for loading all the features of an
	 * FeatureModelSUPERSEDE instance, given its root.
	 * 
	 * @param startingFeature
	 */

	private void loadModelFeatures(Feature feature) {
		this.features.add(feature);
		List<Feature> featuresVar = feature.getFeatures();

		List<Group> featureGroups = feature.getGroups();
		if (!featureGroups.isEmpty()) {
			Iterator<Group> itgroups = featureGroups.iterator();
			while (itgroups.hasNext()) {
				Group g = itgroups.next();
				List<Feature> featuresGroup = g.getFeatures();
				featuresVar.addAll(featuresGroup);
			}
		}

		Iterator<Feature> itfeatures = featuresVar.iterator();
		while (itfeatures.hasNext()) {
			Feature f = itfeatures.next();
			loadModelFeatures(f);
		}
	}

	public String getName() {
		return name;
	}

	// public void setName(String name) {
	// this.name = name;
	// //fm.setName(name);
	// }

	public List<Feature> getFeatures() {
		return features;
	}

	// public void setFeatures(List<Feature> features) {
	// this.features = features;
	// }

	public List<Constraint> getConstraints() {
		return constraints;
	}

	// public void setConstraints(List<Constraint> constraints) {
	// this.constraints = constraints;
	// }

}
