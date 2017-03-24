package eu.supersede.dynadapt.dm.integration.datamodel;

public class DataID {

	String nameComponent; 		 // Related to the feature
	String nameQualityMonitored; // Related to the quality attribute in the feature model

	public DataID() {}
	
	public DataID(
			String nameComponent, 
			String nameQualityMonitored) {
		super();
		this.nameComponent = nameComponent;
		this.nameQualityMonitored = nameQualityMonitored;
	}

	public String getNameComponent() {
		return nameComponent;
	}
	public void setNameComponent(String nameComponent) {
		this.nameComponent = nameComponent;
	}
	public String getNameQualityMonitored() {
		return nameQualityMonitored;
	}
	public void setNameQualityMonitored(String nameQualityMonitored) {
		this.nameQualityMonitored = nameQualityMonitored;
	}
}
