package eu.supersede.dynadapt.poc.feature.builder;

import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.FeatureModel;
import cz.zcu.yafmt.model.fm.Group;

public class FeatureModelUtility {
	
	/**
	 * Gets (Looks for) the feature identified by id in the feature model
	 * @param fm feature model where to look for
	 * @param id identifier of the feature to find
	 * @return Found feature
	 */
	public static Feature getFeatureById (FeatureModel fm, String id){
		return getFeatureById(fm.getRoot(), id);
	}
	
	/**
	 * Gets the parent feature of a given one
	 * @param feature the child feature of searched parent feature
	 * @return the parent feature
	 */
	public static Feature getParentFeature (Feature feature){
		if (feature.getParentFeature() != null){
			return feature.getParentFeature();
		}else if (feature.getParentGroup()!=null){
			return feature.getParentGroup().getParent();
		}else{
			return null;
		}
	}
	
	/**
	 * Searches for a feature, identified by id, within the feature tree defined by the given root feature
	 * @param feature the root feature defining the tree where to find for
	 * @param id identifier of the feature to find.
	 * @return found feature
	 */
	private static Feature getFeatureById(Feature feature, String id) {
		Feature result = null;
		if (feature.getId().equals(id)){
			result = feature;
		}else{
			if (feature.getGroups().isEmpty()){ //AND group
				for (Feature child: feature.getFeatures()){
					if ((result = getFeatureById(child, id)) != null){
						break;
					}
				}
			}else{
				for (Group group: feature.getGroups()){
					for (Feature child:  group.getFeatures()){
						if ((result = getFeatureById(child, id)) != null){
							break;
						}
					}
				}
			}
		}
		return result;
	}
}
