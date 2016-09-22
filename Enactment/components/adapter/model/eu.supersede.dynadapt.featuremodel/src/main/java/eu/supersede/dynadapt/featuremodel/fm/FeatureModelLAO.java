/**
 * 
 * @author Edith Zavala
 */

package eu.supersede.dynadapt.featuremodel.fm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cz.zcu.yafmt.model.fm.Attribute;
import cz.zcu.yafmt.model.fm.Constraint;
import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.FeatureModel;
import cz.zcu.yafmt.model.fm.Group;
import eu.supersede.dynadapt.featuremodel.feature.FeatureLAO;
import eu.supersede.dynadapt.featuremodel.feature.FeatureSUPERSEDE;

public class FeatureModelLAO implements IFeatureModelLAO {

	FeatureModelDAO fmDAO;
	FeatureLAO fLAO;

	public FeatureModelLAO(FeatureModelDAO fmDAO) {
		super();
		this.fmDAO = fmDAO;
		fLAO = new FeatureLAO();
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

		List<FeatureSUPERSEDE> featuresSUPERSEDE = new ArrayList<FeatureSUPERSEDE>();

		FeatureSUPERSEDE rootSUPERSEDE = new FeatureSUPERSEDE(fmSUPERSEDE.getRoot().getName(),
				new ArrayList<FeatureSUPERSEDE>(), null, new ArrayList<FeatureSUPERSEDE>(),
				fmSUPERSEDE.getRoot().getAttributes(), new ArrayList<Constraint>());
		loadModelFeaturesSUPERSEDE(fmSUPERSEDE.getRoot(), rootSUPERSEDE, featuresSUPERSEDE);

		calculateFeaturesSUPERSEDESiblings(featuresSUPERSEDE);

		return new FeatureModelSUPERSEDE(fmSUPERSEDE.getName(), featuresSUPERSEDE, fmSUPERSEDE.getConstraints());
	}

	/**
	 * This recursive method loads all the features, in the features list, below
	 * a given feature.
	 * 
	 * @param feature,
	 *            features list
	 */

	private void loadModelFeaturesSUPERSEDE(Feature feature, FeatureSUPERSEDE fSUPERSEDE,
			List<FeatureSUPERSEDE> featuresSUPERSEDE) {
		featuresSUPERSEDE.add(fSUPERSEDE);
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
			FeatureSUPERSEDE newFeatureSUPERSEDE = new FeatureSUPERSEDE(f.getName(), new ArrayList<FeatureSUPERSEDE>(),
					fSUPERSEDE, new ArrayList<FeatureSUPERSEDE>(), f.getAttributes(), getFeatureConstraints(f));
			fLAO.addChild(fSUPERSEDE, newFeatureSUPERSEDE);
			loadModelFeaturesSUPERSEDE(f, newFeatureSUPERSEDE, featuresSUPERSEDE);
		}
	}

	private void calculateFeaturesSUPERSEDESiblings(List<FeatureSUPERSEDE> featuresSUPERSEDE) {
		Iterator<FeatureSUPERSEDE> itfeaturesSUPERSEDE = featuresSUPERSEDE.iterator();
		while (itfeaturesSUPERSEDE.hasNext()) {
			FeatureSUPERSEDE f = itfeaturesSUPERSEDE.next();
			fLAO.setFeatureSiblings(f);
		}
	}

	/**
	 * This method return a list of constraints related to a feature if exist.
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
				String regex = "(.*)" + feature.getId() + "($|[ ](.*))";
				if (c.getValue().matches(regex))
					fConstraints.add(c);
			}
		}

		return fConstraints;
	}

	@Override
	public FeatureSUPERSEDE getFeatureSUPERSEDEByName(FeatureModelSUPERSEDE m, String name) {
		List<FeatureSUPERSEDE> fSUPERSEDE = m.getFeatures();
		FeatureSUPERSEDE f = null;
		Iterator<FeatureSUPERSEDE> itfSUPERSEDE = fSUPERSEDE.iterator();
		while (itfSUPERSEDE.hasNext()) {
			FeatureSUPERSEDE mfeature = itfSUPERSEDE.next();
			if (mfeature.getName().equalsIgnoreCase(name)) {
				f = mfeature;
				break;
			}
		}
		return f;
	}
}
