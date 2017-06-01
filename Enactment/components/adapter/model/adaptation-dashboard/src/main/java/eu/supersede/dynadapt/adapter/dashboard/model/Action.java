package eu.supersede.dynadapt.adapter.dashboard.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "actions")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@IdClass(ActionId.class)
public class Action implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String fc_id;
	@Id
	private String action_id;
	private String name;
	private String description;
	private boolean enabled;
	
	@MapsId
	@ManyToOne
	@JoinColumn(name = "fc_id")
	@JsonBackReference
	private Adaptation adaptation;
	
	public Action()
    {
    }
	
	public String getAc_id() {
		return action_id;
	}

	public void setAc_id(String ac_id) {
		this.action_id = ac_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public Adaptation getAdaptation() {
		return adaptation;
	}
	
	public void setAdaptation(Adaptation adaptation) {
		this.adaptation = adaptation;
	}
	
}
