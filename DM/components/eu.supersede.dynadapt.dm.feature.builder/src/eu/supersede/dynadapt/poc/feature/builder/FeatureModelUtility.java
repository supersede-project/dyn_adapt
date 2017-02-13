/*******************************************************************************
 * Copyright (c) 2016 ATOS Spain S.A.
 * All rights reserved. Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     Yosu Gorroñogoitia (ATOS) - main development
 *
 * Initially developed in the context of SUPERSEDE EU project www.supersede.eu
 *******************************************************************************/
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
	 * Gets (Looks for) the feature identified by name in the feature model
	 * @param fm feature model where to look for
	 * @param name name of the feature to find
	 * @return Found feature
	 */
	public static Feature getFeatureByName (FeatureModel fm, String name){
		return getFeatureByName(fm.getRoot(), name);
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
	
	/**
	 * Searches for a feature, identified by name, within the feature tree defined by the given root feature
	 * @param feature the root feature defining the tree where to find for
	 * @param nane name of the feature to find.
	 * @return found feature
	 */
	private static Feature getFeatureByName(Feature feature, String name) {
		Feature result = null;
		if (feature.getName().equals(name)){
			result = feature;
		}else{
			if (feature.getGroups().isEmpty()){ //AND group
				for (Feature child: feature.getFeatures()){
					if ((result = getFeatureByName(child, name)) != null){
						break;
					}
				}
			}else{
				for (Group group: feature.getGroups()){
					for (Feature child:  group.getFeatures()){
						if ((result = getFeatureByName(child, name)) != null){
							break;
						}
					}
				}
			}
		}
		return result;
	}
}
