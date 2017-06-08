package eu.supersede.dynadapt.adapter.dashboard.model;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ActionId implements Serializable {
 
    private String fc_id;
    private String action_id;
 
    public ActionId() {
    }
 
    public ActionId(String fc_id, String action_id) {
        this.fc_id = fc_id;
        this.action_id = action_id;
    }
 
    public String getFeatureId() {
    	return this.fc_id;
    }
 
    public String getActionId() {
        return this.action_id;
    }
 
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ActionId)) return false;
        ActionId that = (ActionId) o;
        return Objects.equals(getFeatureId(), that.getFeatureId()) &&
                Objects.equals(getActionId(), that.getActionId());
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(getFeatureId(), getActionId());
    }
}