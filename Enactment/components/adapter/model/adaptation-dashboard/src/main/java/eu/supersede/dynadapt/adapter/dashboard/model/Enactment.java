package eu.supersede.dynadapt.adapter.dashboard.model;

import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "enactments")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Enactment {

	@Id
    private String fc_id;
	private Timestamp enactment_request_timestamp;
	private Time enactment_completion_time;
	private boolean result;
	
	@ManyToOne
	@JoinColumn(name = "fc_id")
	private Adaptation adaptation;
	
	public Enactment()
    {
    }
	
	public String getFc_id() {
		return fc_id;
	}

	public void setFc_id(String fc_id) {
		this.fc_id = fc_id;
	}

	public Timestamp getEnactment_request_timestamp() {
		return enactment_request_timestamp;
	}

	public void setEnactment_request_timestamp(Timestamp enactment_request_timestamp) {
		this.enactment_request_timestamp = enactment_request_timestamp;
	}

	public Time getEnactment_completion_time() {
		return enactment_completion_time;
	}

	public void setEnactment_completion_time(Time enactment_completion_time) {
		this.enactment_completion_time = enactment_completion_time;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}


	public Adaptation getAdaptation() {
		return adaptation;
	}

	public void setAdaptation(Adaptation adaptation) {
		this.adaptation = adaptation;
	}
	
}
