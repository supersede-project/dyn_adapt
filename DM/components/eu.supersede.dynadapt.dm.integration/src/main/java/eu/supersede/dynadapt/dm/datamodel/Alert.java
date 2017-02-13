package eu.supersede.dynadapt.dm.datamodel;

import java.util.List;

public class Alert {
	
	public void setID(String iD) {
		ID = iD;
	}


	public void setApplicationID(String applicationID) {
		this.applicationID = applicationID;
	}


	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}


	public void setTenant(String tenant) {
		this.tenant = tenant;
	}


	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
	}


	public List<ActionOnFeature> getActionFeatures() {
		return actionFeatures;
	}


	public void setActionFeatures(List<ActionOnFeature> actionFeatures) {
		this.actionFeatures = actionFeatures;
	}


	public List<ActionOnAttribute> getActionAttributes() {
		return actionAttributes;
	}


	public void setActionAttributes(List<ActionOnAttribute> actionAttributes) {
		this.actionAttributes = actionAttributes;
	}



	String					ID;
	String					applicationID;
	long					timestamp;
	String					tenant;
	List<Condition>			conditions;
	List<ActionOnFeature>	actionFeatures;
	List<ActionOnAttribute>	actionAttributes;	
	
	public Alert(	
			String 					iD, 
			String 					applicationID, 
			long 					timestamp, 
			String 					tenant, 
			List<Condition> 		conditions, 
			List<ActionOnFeature>	actionFeatures,
			List<ActionOnAttribute>	actionAttributes) {
		super();
		ID = iD;
		this.applicationID = applicationID;
		this.timestamp = timestamp;
		this.tenant = tenant;
		this.conditions = conditions;
		//this.requests = requests;
		this.actionFeatures = actionFeatures;
		this.actionAttributes = actionAttributes;
	}


	public Alert() {}
	
	
	public String getID() {
		return ID;
	}


	public String getApplicationID() {
		return applicationID;
	}


	public long getTimestamp() {
		return timestamp;
	}


	public String getTenant() {
		return tenant;
	}


	public List<Condition> getConditions() {
		return conditions;
	}


}
