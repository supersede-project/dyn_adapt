package eu.supersede.dynadapt.adapter.dashboard.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "adaptations")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Adaptation {
	 
	@Id
    private String fc_id;
	private String name;
    private Timestamp computation_timestamp;
    private double rank;
    
    @OneToMany(mappedBy="adaptation")
    private List<Action> actions;

	public Adaptation()
    {
    }
    
    public String getFc_id() {
		return fc_id;
	}

	public void setFc_id(String fc_id) {
		this.fc_id = fc_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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
	
	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

}
