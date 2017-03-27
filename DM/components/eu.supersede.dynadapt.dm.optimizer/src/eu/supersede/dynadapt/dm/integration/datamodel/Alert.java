package eu.supersede.dynadapt.dm.integration.datamodel;

import java.util.List;

public class Alert {

	String					id;
	String					applicationID;
	long					timestamp;
	String					tenant;
	List<Condition>			conditions;
	List<ActionOnFeature>	actionFeatures;
	List<ActionOnAttribute>	actionAttributes;	
	TypeAlert				type;
	
	public Alert() {}
	
	public Alert(	
			String 					iD, 
			String 					applicationID, 
			long 					timestamp, 
			String 					tenant, 
			List<Condition> 		conditions, 
			List<ActionOnFeature>	actionFeatures,
			List<ActionOnAttribute>	actionAttributes,
			TypeAlert				type) {		
		super();
		this.id = iD;
		this.applicationID = applicationID;
		this.timestamp = timestamp;
		this.tenant = tenant;
		this.conditions = conditions;
		this.actionFeatures = actionFeatures;
		this.actionAttributes = actionAttributes;
		this.type = type;
	}
	
	public void setID(String iD) {
		this.id = iD;
	}
	
	public String getID() {
		return this.id;
	}

	public void setApplicationID(String applicationID) {
		this.applicationID = applicationID;
	}

	public String getApplicationID() {
		return applicationID;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTenant(String tenant) {
		this.tenant = tenant;
	}

	public String getTenant() {
		return tenant;
	}

	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
	}

	public List<Condition> getConditions() {
		return conditions;
	}

	public void setActionFeatures(List<ActionOnFeature> actionFeatures) {
		this.actionFeatures = actionFeatures;
	}

	public List<ActionOnFeature> getActionFeatures() {
		return actionFeatures;
	}

	public void setActionAttributes(List<ActionOnAttribute> actionAttributes) {
		this.actionAttributes = actionAttributes;
	}

	public List<ActionOnAttribute> getActionAttributes() {
		return actionAttributes;
	}

	public TypeAlert getType() {
		return type;
	}

	public void setType(TypeAlert type) {
		this.type = type;
	}
}