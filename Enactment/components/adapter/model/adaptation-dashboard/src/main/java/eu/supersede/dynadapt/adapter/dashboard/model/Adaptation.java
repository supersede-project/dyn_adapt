package eu.supersede.dynadapt.adapter.dashboard.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import eu.supersede.integration.api.adaptation.types.ModelSystem;

@Entity
@Table(name = "adaptations")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Adaptation {
	 	
	@Id
    private String fc_id;
	private String name;
    @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss")
    private Timestamp computation_timestamp;
    private double rank;
    private ModelSystem model_system;
    
    @OneToMany(mappedBy="adaptation", cascade = CascadeType.ALL)
    @JsonManagedReference
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
		return this.computation_timestamp;
	}

	public void setComputation_timestamp(Timestamp computation_timestamp) {
		this.computation_timestamp = computation_timestamp;
	}

	public double getRank() {
		//return String.format("%.5f", rank);
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
	
	public ModelSystem getModel_system() {
		return model_system;
	}
	
	public void setModel_system(ModelSystem modelSystem) {
		this.model_system = modelSystem;
	}

}
