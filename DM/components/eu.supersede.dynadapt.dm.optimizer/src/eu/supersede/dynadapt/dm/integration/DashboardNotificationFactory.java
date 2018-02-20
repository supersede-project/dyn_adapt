package eu.supersede.dynadapt.dm.integration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cz.zcu.yafmt.model.fc.Selection;
import eu.supersede.integration.api.adaptation.dashboad.types.Action;
import eu.supersede.integration.api.adaptation.dashboad.types.Adaptation;
import eu.supersede.integration.api.adaptation.dashboad.types.Enactment;
import eu.supersede.integration.api.adaptation.types.ModelSystem;

public class DashboardNotificationFactory {

	private static final String DEFAULT_ACTION_DESCRIPTION = "N/A";
	private static final double DEFAULT_ADAPTATION_RANK = 1.0;
	
	/**
	 * Create an {@link Adaptation} object related to the latest feature configuration id which is
	 * passed as parameter.
	 * @param fc_id id of the {@link Adaptation} whose enactment is required
	 * @param name of the adaptation
	 * @param system the {@link ModelSystem} the new adaptation belongs to
	 * @param features the list of features that have changed in the latest feature configuration
	 * @param inititialTime is the enactment process initiation time
	 * @return the {@link Enactment}
	 */
	public static Adaptation createAdaptation(String fc_id, String name, ModelSystem system, 
			List<Selection> features, 
			Date inititialTime,
			boolean update) {
		Adaptation adaptation = new Adaptation();
		adaptation.setFc_id(fc_id);
		adaptation.setComputation_timestamp(inititialTime);
		adaptation.setModel_system(system);
		adaptation.setName(name);
		adaptation.setRank(DEFAULT_ADAPTATION_RANK);
		adaptation.getActions().addAll(createAction(features, update));
		return adaptation;
	}
	
	/**
	 * This method manufacture and returns the list of actions corresponding to the selected features,
	 * that is, that have changed in the latest feature configuration.
	 * @param features the list of selected features 
	 * @return the list of enactment {@link Action}
	 */
	public static List<Action> createAction(List<Selection> features, boolean update) {
		List<Action> actions = new ArrayList<Action>();		
		for (Selection feature : features) {
			Action action = new Action ();
			action.setAction_id(feature.getId());
			String description = feature.getFeature().getDescription() != null ? feature.getFeature().getDescription() : DEFAULT_ACTION_DESCRIPTION;
			if (update) description = "Update attributes values for " + description;
			action.setDescription(description);
			action.setName(feature.getName());
			action.setEnabled(feature.isEnabled());			
			actions.add(action);
		}
		return actions;
	}

}
