package eu.supersede.dynadapt.featuremodel.selection;

import cz.zcu.yafmt.model.fc.Selection;

public class SelectionLAO implements ISelectionLAO {

	public SelectionLAO() {

	}

	@Override
	public SelectionSUPERSEDE createSelectionSUPERSEDE(Selection s){
		/**
		 * SelectionSUPERSEDE
		 * 
		 * List<AttributeValue> attValue
		 *
		 */
		
		return new SelectionSUPERSEDE(s.getValues(), s.getFeature());

	}

}
