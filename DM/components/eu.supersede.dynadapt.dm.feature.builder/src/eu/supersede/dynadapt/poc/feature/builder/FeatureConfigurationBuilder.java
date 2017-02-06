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

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.common.util.URI;

import cz.zcu.yafmt.model.fc.AttributeValue;
import cz.zcu.yafmt.model.fc.BooleanValue;
import cz.zcu.yafmt.model.fc.DoubleValue;
import cz.zcu.yafmt.model.fc.FeatureConfiguration;
import cz.zcu.yafmt.model.fc.IntegerValue;
import cz.zcu.yafmt.model.fc.Selection;
import cz.zcu.yafmt.model.fc.StringValue;
import cz.zcu.yafmt.model.fc.util.FeatureConfigurationUtil;
import cz.zcu.yafmt.model.fm.Attribute;
import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.FeatureModel;

public class FeatureConfigurationBuilder implements IFeatureConfigurationBuilder {
	
	/* (non-Javadoc)
	 * @see eu.supersede.dynadapt.poc.feature.builder.IFeatureConfigurationBuilder#buildFeatureConfiguration(cz.zcu.yafmt.model.fm.FeatureModel, java.util.List)
	 */
	@Override
	public FeatureConfiguration buildFeatureConfiguration (FeatureModel fm, List<String> selectedFeatureIds){
		FeatureConfiguration fc = FeatureConfigurationUtil.createEmptyFeatureConfiguration(fm, fm.getName() + "Conf");

		Selection rootSelection = fc.getRoot();
		
		for (String selectedId: selectedFeatureIds){
			Feature selectedFeature = FeatureModelUtility.getFeatureById(fm, selectedId);
			createSelectionTreeForFeatureInSelectionTree (selectedFeature, rootSelection);
			setDefaultSelectionValues (getSelectionForFeatureInRootSelection(selectedFeature, rootSelection), selectedFeature);
		}
		
		return fc;
	}
	
	/**
	 * Set values for feature attributes taken from the default values declared in the feature model for each attribute (e.g. default value property
	 * @param selection the selection in the feature configuration corresponding to the feature in the feature model
	 * @param feature the feature defined in the feature model
	 */
	private void setDefaultSelectionValues(Selection selection, Feature feature) {
		for (AttributeValue value: selection.getValues()){
			Attribute attribute = getAttributeByIdInFeature (value.getId(), feature);
			String defaultValue = attribute.getDefaultValue();
			if (defaultValue == null || defaultValue.isEmpty())
				continue;
			if (value instanceof BooleanValue){
				((BooleanValue)value).setValue(Boolean.valueOf(attribute.getDefaultValue()));
			}else if (value instanceof IntegerValue){
				((IntegerValue)value).setValue(Integer.valueOf(attribute.getDefaultValue()));
			}else if (value instanceof DoubleValue){
				((DoubleValue)value).setValue(Double.valueOf(attribute.getDefaultValue()));
			}else if (value instanceof StringValue){
				((StringValue)value).setValue(attribute.getDefaultValue());
			}
		}
	}

	/**
	 * Returns the attribute, identified by id, located in the given feature
	 * @param id the identifier of requested attribute
	 * @param feature the  feature owning  the feature.
	 * @return found attribute
	 */
	private Attribute getAttributeByIdInFeature(String id, Feature feature) {
		Attribute foundAttribute = null;
		for (Attribute attr: feature.getAttributes()){
			if (attr.getId().equals(id)){
				foundAttribute = attr;
				break;
			}
		}
		return foundAttribute;
	}

	/**
	 * Creates the complete selection tree branch for given feature up to the given root selection tree, 
	 * creating all missing parent selections in the tree branch from given feature up to the root selection
	 * @param feature leave feature defining the leave selection in the tree branch to be created.
	 * @param rootSelectionTree the top of the tree branch to be created.
	 * @return
	 */
	private Selection createSelectionTreeForFeatureInSelectionTree (Feature feature, Selection rootSelectionTree){
		Selection parentSelection = getSelectionForFeatureInRootSelection (FeatureModelUtility.getParentFeature(feature), rootSelectionTree);
		if (parentSelection == null){
			parentSelection = createSelectionTreeForFeatureInSelectionTree (FeatureModelUtility.getParentFeature(feature), rootSelectionTree);
		}
		Selection childSelection = FeatureConfigurationUtil.createSelection(feature);
		if (!parentSelectionContainsChildSelection (parentSelection, childSelection)){
			parentSelection.getSelections().add(childSelection);
		}else{
			childSelection = getSelectionForFeatureInRootSelection(feature, parentSelection);
		}
		return childSelection;
	}
	
	/**
	 * Checks if parentSelection already contains child selection
	 * NOTE: Id comparison in Selection Type will simplify it, but we prefer not to modify YAFMT code
	 * @param parentSelection parent selection
	 * @param childSelection child selection
	 * @return
	 */
	private boolean parentSelectionContainsChildSelection(Selection parentSelection, Selection childSelection) {
		boolean result = false;
		for (Selection selection: parentSelection.getSelections()){
			if (selection.getId().equals(childSelection.getId())){
				result = true;
				break;
			}
		}
		return result;
	}

	/**
	 * Looks for the selection associated to the given feature in the descendant tree from given root selection
	 * @param feature feature associated to the selection to find
	 * @param rootSelectionTree tree selection root where to look for
	 * @return
	 */
	private Selection getSelectionForFeatureInRootSelection(Feature feature, Selection rootSelectionTree) {
		Selection result = null;
		if (rootSelectionTree.getId().equals(feature.getId())){
			result = rootSelectionTree;
		}else{
			for (Selection selection: rootSelectionTree.getSelections()){
				if (selection.getId().equals(feature.getId())){
					result = selection;
				}else{
					result = getSelectionForFeatureInRootSelection(feature, selection);
				}
				if (result != null){
					break;
				}
			}
		}
		return result;
	}
	
	public static void main (String[] args) throws IOException{
		String fmPath = "./features/FeedbackGathering.yafm";
		String fcPath = "./features/FeedbackGatheringConf.yafc";
		List<String> selectedFeatureIds = 
				Arrays.asList("rating", "selectcategory", "sharewithallhelpdesk", "popup", "android");
		IFeatureConfigurationBuilder fcb = new FeatureConfigurationBuilder();
		ModelManager mm = new ModelManager();
		FeatureModel fm = mm.loadFM(fmPath);
		Feature feature = FeatureModelUtility.getFeatureById(fm, "sharewithallhelpdesk");
		Feature parentFeature = FeatureModelUtility.getParentFeature(feature);
		FeatureConfiguration fc = 
				new FeatureConfigurationBuilder().buildFeatureConfiguration(fm, selectedFeatureIds);
		URI fcUri = URI.createFileURI(fcPath);
		mm.saveFC(fc, fcUri);
	}
}
