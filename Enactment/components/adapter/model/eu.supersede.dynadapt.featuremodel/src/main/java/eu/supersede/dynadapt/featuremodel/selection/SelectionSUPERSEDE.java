package eu.supersede.dynadapt.featuremodel.selection;

import java.util.List;

import cz.zcu.yafmt.model.fc.AttributeValue;
import eu.supersede.dynadapt.featuremodel.feature.FeatureSUPERSEDE;

public class SelectionSUPERSEDE implements ISelectionSUPERSEDE{

	private List<AttributeValue> attValue;
	private FeatureSUPERSEDE feature;

	public SelectionSUPERSEDE(List<AttributeValue> attValue, FeatureSUPERSEDE feature) {
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
	
	public FeatureSUPERSEDE getFeature() {
		return feature;
	}

	public void setFeature(FeatureSUPERSEDE feature) {
		this.feature = feature;
	}
	
	
	
}
