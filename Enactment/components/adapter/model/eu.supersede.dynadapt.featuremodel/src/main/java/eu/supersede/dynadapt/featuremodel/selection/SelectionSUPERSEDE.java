package eu.supersede.dynadapt.featuremodel.selection;

import java.util.List;

import cz.zcu.yafmt.model.fc.AttributeValue;
import cz.zcu.yafmt.model.fm.Feature;

public class SelectionSUPERSEDE implements ISelectionSUPERSEDE{

	private List<AttributeValue> attValue;
	private Feature feature;

	public SelectionSUPERSEDE(List<AttributeValue> attValue, Feature feature) {
		super();
		this.attValue = attValue;
		this.feature = feature;
	}

	public List<AttributeValue> getAttValue() {
		return attValue;
	}

	public void setAttValue(List<AttributeValue> attValue) {
		this.attValue = attValue;
	}
	
	public Feature getFeature() {
		return feature;
	}

	public void setFeature(Feature feature) {
		this.feature = feature;
	}
	
	
	
}
