package eu.supersede.dynadapt.adapter.dashboard.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "enactments")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Enactment {
	
	@Id
	private String fc_id;
    @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss")
	private Timestamp enactment_request_time;
    @JsonFormat(pattern="mm:ss.SSS")
	private Timestamp enactment_completion_time;
	private boolean result;
	
	@MapsId
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

	public Timestamp getEnactment_request_time() {
		return this.enactment_request_time;
	}

	public void setEnactment_request_time(Timestamp enactment_request_time) {
		this.enactment_request_time = enactment_request_time;
	}

	public Timestamp getEnactment_completion_time() {
		return this.enactment_completion_time;
	}

	public void setEnactment_completion_time(Timestamp enactment_completion_time) {
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
