package eu.supersede.dynadapt.dm.integration.datamodel;

public class ActionOnFeature {

	String			ID;
	FeatureAction	typeaction;
	
	public ActionOnFeature(){}
	
	public ActionOnFeature(
			String 			iD, 
			FeatureAction 	typeaction) {
		super();
		ID = iD;
		this.typeaction = typeaction;
	}

	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public FeatureAction getTypeaction() {
		return typeaction;
	}
	public void setTypeaction(FeatureAction typeaction) {
		this.typeaction = typeaction;
	}
}