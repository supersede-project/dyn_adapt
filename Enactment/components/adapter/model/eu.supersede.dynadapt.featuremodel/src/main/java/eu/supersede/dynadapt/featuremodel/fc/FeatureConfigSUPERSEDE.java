/**
 * 
 * @author Edith Zavala
 */

package eu.supersede.dynadapt.featuremodel.fc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cz.zcu.yafmt.model.fc.FeatureConfiguration;
import cz.zcu.yafmt.model.fc.Selection;
import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.Group;

public class FeatureConfigSUPERSEDE implements IFeatureConfigSUPERSEDE {

	private String name;
	private List<Selection> selections;

	/**
	 * Creates an instance of FeatureConfigSUPERSEDE from a given Feature
	 * Configuration
	 * 
	 * @param FeatureConfiguration
	 */
	public FeatureConfigSUPERSEDE(FeatureConfiguration fc) {
		super();
		this.name = fc.getName();
		this.selections = new ArrayList<Selection>();
		loadModelSelections(fc.getRoot());
	}

	/**
	 * This recursive method loads all the features below a given feature. In
	 * this class it is used for loading all the features of an
	 * FeatureModelSUPERSEDE instance, given its root.
	 * 
	 * @param startingFeature
	 */

	private void loadModelSelections(Selection selection) {
		this.selections.add(selection);
		List<Selection> selectionsVar = selection.getSelections();

		// List<Group> featureGroups = selection.getGroups();
		// if (!featureGroups.isEmpty()) {
		// Iterator<Group> itgroups = featureGroups.iterator();
		// while (itgroups.hasNext()) {
		// Group g = itgroups.next();
		// List<Feature> featuresGroup = g.getFeatures();
		// featuresVar.addAll(featuresGroup);
		// }
		// }

		Iterator<Selection> itselections = selectionsVar.iterator();
		while (itselections.hasNext()) {
			Selection s = itselections.next();
			loadModelSelections(s);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		// fm.setName(name);
	}

	public List<Selection> getSelections() {
		return selections;
	}

	// public void setSelections(List<Selection> selections) {
	// this.selections = selections;
	// }
}
