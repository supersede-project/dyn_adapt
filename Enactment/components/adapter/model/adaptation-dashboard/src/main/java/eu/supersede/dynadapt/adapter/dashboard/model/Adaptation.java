package eu.supersede.dynadapt.adapter.dashboard.model;

import java.util.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "adaptations")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Adaptation {
	 	
	@Id
    private String fc_id;
	private String name;
    private Timestamp computation_timestamp;
    private double rank;
    
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

	public String getComputation_timestamp() {
		return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(computation_timestamp);
	}

	public void setComputation_timestamp(String computation_timestamp) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    Date parsedDate;
		try {
			parsedDate = dateFormat.parse(computation_timestamp);
			Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
			this.computation_timestamp = timestamp;
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public String getRank() {
		return String.format("%.5f", rank);
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
