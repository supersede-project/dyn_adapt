package eu.supersede.dynadapt.dm.integration.datamodel;

public class Condition {

	DataID		idMonitoredData;
	Operator	operator;
	Double		value;
	
	public Condition() {}
	
	public Condition(
			DataID idMonitoredData, 
			Operator operator, 
			Double value) {
		super();
		this.idMonitoredData = idMonitoredData;
		this.operator = operator;
		this.value = value;
	}		

	public DataID getIdMonitoredData() {
		return idMonitoredData;
	}

	public void setIdMonitoredData(DataID idMonitoredData) {
		this.idMonitoredData = idMonitoredData;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
}
