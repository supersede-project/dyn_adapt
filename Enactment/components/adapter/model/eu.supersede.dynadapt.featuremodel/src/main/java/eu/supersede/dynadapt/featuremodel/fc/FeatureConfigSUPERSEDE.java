/**
 * 
 * @author Edith Zavala
 */

package eu.supersede.dynadapt.featuremodel.fc;

import java.util.List;

import eu.supersede.dynadapt.featuremodel.selection.SelectionSUPERSEDE;

public class FeatureConfigSUPERSEDE implements IFeatureConfigSUPERSEDE {

	private String name;
	private List<SelectionSUPERSEDE> selections;

	/**
	 * Creates an instance of FeatureConfigSUPERSEDE 
	 * 
	 * @param name, selections
	 */
	public FeatureConfigSUPERSEDE(String name, List<SelectionSUPERSEDE> selections) {
		super();
		this.name = name;
		this.selections = selections;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SelectionSUPERSEDE> getSelections() {
		return selections;
	}

	public void setSelections(List<SelectionSUPERSEDE> selections) {
		this.selections = selections;
	}

	
}
