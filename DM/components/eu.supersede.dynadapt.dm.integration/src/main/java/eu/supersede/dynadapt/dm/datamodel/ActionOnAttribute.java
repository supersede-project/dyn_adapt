package eu.supersede.dynadapt.dm.datamodel;

public class ActionOnAttribute {

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public AttributeAction getTypeaction() {
		return typeaction;
	}

	public void setTypeaction(AttributeAction typeaction) {
		this.typeaction = typeaction;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}


	String					ID;
	AttributeAction			typeaction;
	double 					value;
	
	public ActionOnAttribute() {}

	public ActionOnAttribute(
			String 			iD, 
			AttributeAction typeaction, 
			double 			value) {
		super();
		ID = iD;
		this.typeaction = typeaction;
		this.value = value;
	}
	
	
}
