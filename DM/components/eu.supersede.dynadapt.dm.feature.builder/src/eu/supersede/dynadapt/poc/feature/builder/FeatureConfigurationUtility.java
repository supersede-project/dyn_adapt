package eu.supersede.dynadapt.poc.feature.builder;

import java.util.ArrayList;
import java.util.List;

import cz.zcu.yafmt.model.fc.FeatureConfiguration;
import cz.zcu.yafmt.model.fc.Selection;
import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.FeatureModel;
import cz.zcu.yafmt.model.fm.Group;

public class FeatureConfigurationUtility {

	//Calculate leaf selection changes among provided feature configurations
	public static List<Selection> diffFeatureConfigurations(FeatureConfiguration originalFeatureConfig,
			FeatureConfiguration newFeatureConfig) {
		FeatureModel fm = originalFeatureConfig.getFeatureModelCopy();
		Feature root = fm.getRoot();

		return diffFeatureConfigurationsInFeature(root, originalFeatureConfig, newFeatureConfig);
	}
	
	protected static List<Selection> diffFeatureConfigurationsInFeature(Feature feature,
			FeatureConfiguration originalFeatureConfig, FeatureConfiguration newFeatureConfig) {
		
		List<Selection> selections = new ArrayList<Selection>();
		
		//Only computes differences for leaf features
		if (isLeafFeature(feature)){
			selections = diffFeatureConfigurationsInFeature(feature.getId(), originalFeatureConfig,
				newFeatureConfig);
		}

		for (Feature child : feature.getFeatures()) {
			selections.addAll(diffFeatureConfigurationsInFeature(child, originalFeatureConfig, newFeatureConfig));
		}

		for (Group group : feature.getGroups()) {
			for (Feature childInGroup : group.getFeatures()) {
				selections.addAll(
						diffFeatureConfigurationsInFeature(childInGroup, originalFeatureConfig, newFeatureConfig));
			}
		}
		return selections;
	}

	private static boolean isLeafFeature(Feature feature) {
		return feature.getFeatures().isEmpty() && feature.getGroups().isEmpty();
	}

	private static List<Selection> diffFeatureConfigurationsInFeature(String featureId,
			FeatureConfiguration originalFeatureConfig, FeatureConfiguration newFeatureConfig) {
		List<Selection> selections = new ArrayList<Selection>();

		List<Selection> originalSelections = originalFeatureConfig.getSelectionsById(featureId);
		List<Selection> newSelections = newFeatureConfig.getSelectionsById(featureId);

		for (Selection s1 : originalSelections) {
			if (!selectionExistsInList(s1, newSelections)) {
				s1.setEnabled(false);
				selections.add(s1);
			}
		}

		for (Selection s1 : newSelections) {
			if (!selectionExistsInList(s1, originalSelections)) {
				selections.add(s1);
			}
		}
		
		/**
		 * Monitoring UC testing
		 */
		for (Selection s1 : originalSelections) {
			if (selectionIsModified(s1, newSelections)) {
				selections.add(s1);
			}
		}

		return selections;
	}
	
	private static boolean selectionExistsInList(Selection s1, List<Selection> list) {
		boolean result = false;

		for (Selection s : list) {
			if (s.getId().equals(s1.getId())) {
				result = true;
				break;
			}
		}

		return result;
	}
	
	private static boolean selectionIsModified(Selection s1, List<Selection> list) {
		boolean result = false;
		
		for (Selection s : list) {
			if (s.getId().equals(s1.getId()) && s.getValues().size() > 0) {
				if ( !s.getValues().get(0).eGet(s.getValues().get(0).eClass().getEStructuralFeature("value"))
						.equals( s1.getValues().get(0).eGet(s.getValues().get(0).eClass().getEStructuralFeature("value")))) result = true;
				break;
			}
		}
		
		return result;
	}
	
}
