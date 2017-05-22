package eu.supersede.dynadapt.adapter.dashboard.model;

import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "adaptations")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Adaptation {
	 
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long adaptation_id;
    private String name;
	private String feature_id;
    private boolean enabled;
    private String description;
//    private Timestamp computation_timestamp;
//    private double rank;
    private boolean enacted;
    @Column(nullable=true)
    private Timestamp enacted_timestamp;
    @Column(nullable=true)
    private boolean result;
    @Column(nullable=true)
    private Time enacted_time;


    public Adaptation()
    {
    }

    public Long getAdaptationId()
    {
        return adaptation_id;
    }

    public void setAdaptationId(Long adaptation_id)
    {
        this.adaptation_id = adaptation_id;
    }
    
    public Long getAdaptation_id() {
		return adaptation_id;
	}

	public void setAdaptation_id(Long adaptation_id) {
		this.adaptation_id = adaptation_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFeature_id() {
		return feature_id;
	}

	public void setFeature_id(String feature_id) {
		this.feature_id = feature_id;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

/**
	public Timestamp getComputation_timestamp() {
		return computation_timestamp;
	}

	public void setComputation_timestamp(Timestamp computation_timestamp) {
		this.computation_timestamp = computation_timestamp;
	}

	public double getRank() {
		return rank;
	}

	public void setRank(double rank) {
		this.rank = rank;
	}
	*/

	public boolean isEnacted() {
		return enacted;
	}

	public void setEnacted(boolean enacted) {
		this.enacted = enacted;
	}

	public Timestamp getEnacted_timestamp() {
		return enacted_timestamp;
	}

	public void setEnacted_timestamp(Timestamp enacted_timestamp) {
		this.enacted_timestamp = enacted_timestamp;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public Time getEnacted_time() {
		return enacted_time;
	}

	public void setEnacted_time(Time enacted_time) {
		this.enacted_time = enacted_time;
	}

}
