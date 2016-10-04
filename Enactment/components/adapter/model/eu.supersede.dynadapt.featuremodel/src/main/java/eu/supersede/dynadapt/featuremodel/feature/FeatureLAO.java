/*******************************************************************************
 * Copyright (c) 2016 UPC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
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
 * 	Edith Zavala (UPC) - main development
 * 	
 * Initially developed in the context of SUPERSEDE EU project
 * www.supersede.eu
 *******************************************************************************/
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

	/**
	 * This method add a featureSUPERSEDE child to a featureSUPERSEDE parent.
	 * 
	 * @param parent,
	 *            child
	 */
	@Override
	public void addChild(FeatureSUPERSEDE parent, FeatureSUPERSEDE child) {
		List<FeatureSUPERSEDE> children = parent.getChildren();
		children.add(child);
		parent.setChildren(children);
	}

	/**
	 * This method return the siblings of a given featureSUPERSEDE if exist.
	 * Siblings are featuresSUPERSEDE with the same parent.
	 * 
	 * @param featureSUPERSEDE
	 */
	@Override
	public void setFeatureSiblings(FeatureSUPERSEDE featureSUPERSEDE) {
		FeatureSUPERSEDE parent = featureSUPERSEDE.getParent();
		if (parent != null) {
			List<FeatureSUPERSEDE> siblings = parent.getChildren();
			featureSUPERSEDE.setSiblings(removeFeature(featureSUPERSEDE, siblings));
		}
	}

	private List<FeatureSUPERSEDE> removeFeature(FeatureSUPERSEDE featureSUPERSEDE, List<FeatureSUPERSEDE> featuresSUPERSEDEList) {
		List<FeatureSUPERSEDE> outputList = new ArrayList<FeatureSUPERSEDE>();
		Iterator<FeatureSUPERSEDE> itList = featuresSUPERSEDEList.iterator();
		while (itList.hasNext()) {
			FeatureSUPERSEDE f = itList.next();
			if (!featureSUPERSEDE.equals(f))
				outputList.add(f);
		}
		return outputList;
	}

}
