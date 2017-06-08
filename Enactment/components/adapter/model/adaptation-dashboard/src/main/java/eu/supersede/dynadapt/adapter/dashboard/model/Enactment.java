package eu.supersede.dynadapt.adapter.dashboard.model;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import ch.uzh.ifi.feedback.library.rest.annotations.Serialize;

@Entity
@Table(name = "enactments")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Enactment {
	
	@Id
	private String fc_id;
	private Timestamp enactment_request_time;
	private Time enactment_completion_time;
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

	public String getEnactment_request_time() {
		return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(enactment_request_time);
	}

	public void setEnactment_request_time(String enactment_request_time) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    Date parsedDate;
		try {
			parsedDate = dateFormat.parse(enactment_request_time);
			Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
			this.enactment_request_time = timestamp;
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public String getEnactment_completion_time() {
		return new SimpleDateFormat("mm:ss.SSS").format(enactment_completion_time);
	}

	public void setEnactment_completion_time(String enactment_completion_time) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss.SSS");
	    Date parsedDate;
		try {
			parsedDate = dateFormat.parse(enactment_completion_time);
			Time timestamp = new java.sql.Time(parsedDate.getTime());
			this.enactment_completion_time = timestamp;
		} catch (ParseException e) {
			e.printStackTrace();
		}
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
