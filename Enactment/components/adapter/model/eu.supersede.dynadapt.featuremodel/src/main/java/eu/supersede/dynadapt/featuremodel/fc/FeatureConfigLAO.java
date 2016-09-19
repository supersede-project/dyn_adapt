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
	 * @param featureConfigPath
	 */
	@Override
	public FeatureConfigSUPERSEDE getFeatureConfigSUPERSEDE(String featureConfigPath) {
		FeatureConfiguration fcSUPERSEDE = fcDAO.loadFeatureConfig(featureConfigPath);
		List<Selection> selections = new ArrayList<Selection>();
		loadModelSelections(fcSUPERSEDE.getRoot(), selections);
		return new FeatureConfigSUPERSEDE(fcSUPERSEDE.getName(), selections);
	}

	/**
	 * This recursive method loads all the selections, in selections list, below
	 * a given selection.
	 * 
	 * @param selection, selections list
	 */

	private void loadModelSelections(Selection selection, List<Selection> selections) {
		selections.add(selection);
		List<Selection> selectionsVar = selection.getSelections();

		Iterator<Selection> itselections = selectionsVar.iterator();
		while (itselections.hasNext()) {
			Selection s = itselections.next();
			loadModelSelections(s, selections);
		}
	}
}
