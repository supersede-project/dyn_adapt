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
import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.Group;

public class FeatureConfigSUPERSEDE implements IFeatureConfigSUPERSEDE {

	private String name;
	private List<Selection> selections;

	/**
	 * Creates an instance of FeatureConfigSUPERSEDE 
	 * 
	 * @param name, selections
	 */
	public FeatureConfigSUPERSEDE(String name, List<Selection> selections) {
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

	public List<Selection> getSelections() {
		return selections;
	}

	public void setSelections(List<Selection> selections) {
		this.selections = selections;
	}

	
}
