/**
 * 
 * @author Edith Zavala
 */

package eu.supersede.dynadapt.featuremodel.fm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.FeatureModel;
import cz.zcu.yafmt.model.fm.Group;

public class FeatureModelLAO implements IFeatureModelLAO {

	FeatureModelDAO fmDAO;
	
	public FeatureModelLAO(FeatureModelDAO fmDAO){
		super();
		this.fmDAO = fmDAO;
	}
	
	/**
	 * Creates an instance of FeatureModelSUPERSEDE from a given Feature Model
	 * Path
	 * 
	 * @param FeatureModel
	 */

	@Override
	public FeatureModelSUPERSEDE getFeatureModelSUPERSEDE(String featureModelPath) {
		FeatureModel fmSUPERSEDE = fmDAO.loadFeatureModel(featureModelPath);
		List<Feature> features = new ArrayList<Feature>();
		loadModelFeatures(fmSUPERSEDE.getRoot(), features);
		return new FeatureModelSUPERSEDE(fmSUPERSEDE.getName(), features, fmSUPERSEDE.getConstraints());
	}

	/**
	 * This recursive method loads all the features, in the features list, below
	 * a given feature.
	 * 
	 * @param feature, features list
	 */

	private void loadModelFeatures(Feature feature, List<Feature> features) {
		features.add(feature);
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
			loadModelFeatures(f, features);
		}
	}

}
