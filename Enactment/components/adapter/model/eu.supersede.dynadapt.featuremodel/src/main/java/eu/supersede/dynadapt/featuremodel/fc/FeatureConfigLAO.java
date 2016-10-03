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

package eu.supersede.dynadapt.featuremodel.fc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cz.zcu.yafmt.model.fc.FeatureConfiguration;
import cz.zcu.yafmt.model.fc.Selection;
import eu.supersede.dynadapt.featuremodel.feature.FeatureSUPERSEDE;
import eu.supersede.dynadapt.featuremodel.fm.FeatureModelDAO;
import eu.supersede.dynadapt.featuremodel.fm.FeatureModelLAO;
import eu.supersede.dynadapt.featuremodel.fm.FeatureModelSUPERSEDE;
import eu.supersede.dynadapt.featuremodel.selection.SelectionSUPERSEDE;

public class FeatureConfigLAO implements IFeatureConfigLAO {

	private FeatureConfigDAO fcDAO;

	public FeatureConfigLAO(FeatureConfigDAO fcDAO) {
		super();
		this.fcDAO = fcDAO;
	}

	/**
	 * Creates an instance of FeatureConfigSUPERSEDE from a given Feature
	 * Configuration Path
	 * 
	 * @param featureConfigPath,
	 *            featureModelString
	 */
	@Override
	public FeatureConfigSUPERSEDE getFeatureConfigSUPERSEDE(String featureConfigPath, String featureModelPath) {
		FeatureConfiguration fcSUPERSEDE = fcDAO.loadFeatureConfig(featureConfigPath);
		
		/*Load the correspoding featureModelSUPERSEDE using its LAO*/
		FeatureModelLAO fmLAO = new FeatureModelLAO(new FeatureModelDAO());
		FeatureModelSUPERSEDE fmSUPERSEDE = fmLAO.getFeatureModelSUPERSEDE(featureModelPath);

		/*Initialize first SelectionSUPE5RSEDE with its related FeatureSUPERSEDE*/
		String rootName = fcSUPERSEDE.getRoot().getFeature().getName();
		FeatureSUPERSEDE f = fmLAO.getFeatureSUPERSEDEByName(fmSUPERSEDE, rootName);
		SelectionSUPERSEDE rootSelectionSUPERSEDE = new SelectionSUPERSEDE(fcSUPERSEDE.getRoot().getValues(), f);
		
		/*Load rest of SelectionSUPERSEDE realting them with their correspoding FeatureSUPERSEDE*/
		List<SelectionSUPERSEDE> selections = new ArrayList<SelectionSUPERSEDE>();
		loadModelSelections(fcSUPERSEDE.getRoot(), rootSelectionSUPERSEDE, fmLAO, fmSUPERSEDE, selections);

		return new FeatureConfigSUPERSEDE(fcSUPERSEDE.getName(), selections);
	}

	/**
	 * This recursive method loads all the selectionsSUPERSEDE, in selectionsSUPERSEDE list, below
	 * a given selectionSUPERSEDE.
	 * 
	 * @param selection, selectionSUPERSEDE, featureModelLAO, featureModelSUPERSEDE, selectionsSUPERSEDE list
	 *            selections list
	 */

	private void loadModelSelections(Selection selection, SelectionSUPERSEDE selectionSUPERSEDE, FeatureModelLAO fmLAO,
			FeatureModelSUPERSEDE fmSUPERSEDE, List<SelectionSUPERSEDE> selectionsSUPERSEDE) {
		selectionsSUPERSEDE.add(selectionSUPERSEDE);
		List<Selection> selectionsVar = selection.getSelections();

		Iterator<Selection> itselections = selectionsVar.iterator();
		while (itselections.hasNext()) {
			Selection s = itselections.next();
			FeatureSUPERSEDE f = fmLAO.getFeatureSUPERSEDEByName(fmSUPERSEDE, s.getFeature().getName());
			SelectionSUPERSEDE nextSelectionSUPERSEDE = new SelectionSUPERSEDE(s.getValues(), f);
			loadModelSelections(s,nextSelectionSUPERSEDE, fmLAO, fmSUPERSEDE, selectionsSUPERSEDE);
		}
	}
}
