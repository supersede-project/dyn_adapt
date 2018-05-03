package eu.supersede.dynadapt.dm.optimizer.integration;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

import eu.supersede.dynadapt.dm.integration.ModuleLoader;
import eu.supersede.integration.api.adaptation.types.ActionOnAttribute;
import eu.supersede.integration.api.adaptation.types.Alert;
import eu.supersede.integration.api.adaptation.types.AttributeAction;
import eu.supersede.integration.api.adaptation.types.Condition;
import eu.supersede.integration.api.adaptation.types.DataID;
import eu.supersede.integration.api.adaptation.types.ModelSystem;
import eu.supersede.integration.api.adaptation.types.Operator;

public class AlertHandleTest {

	@Test
	public void SiemenesOptimizationTest() throws Exception {
		ModuleLoader optimizer = new ModuleLoader();
		Alert alert = createSiemensAlert();
		optimizer.handleAlert(alert);
	}
	
	@Test
	public void AtosHSKOptimizationTest() throws Exception {
		ModuleLoader optimizer = new ModuleLoader();
		Alert alert = createAtosHSKAlert();
		optimizer.handleAlert(alert);
	}

	@Test
	public void AtosMonitoringOptimizationTest() throws Exception {
		ModuleLoader optimizer = new ModuleLoader();
		Alert alert = createAtosMonitoringAlert();
		optimizer.handleAlert(alert);
	}
	
	@Test
	public void deterministicAtosMonitoringOptimizationTest() throws Exception {
		ModuleLoader optimizer = new ModuleLoader();
		Alert alert = createDeterministicAtosMonitoringAlert();
		optimizer.handleAlert(alert);
	}
	
    protected Alert createAtosHSKAlert() {
        Alert alert = new Alert();

        alert.setId("id"+ System.currentTimeMillis());
        alert.setApplicationId("dynamic");
        alert.setTimestamp(Calendar.getInstance().getTimeInMillis());
        alert.setTenant(ModelSystem.Atos_HSK);

        List<Condition> conditions = new ArrayList<Condition>();
        conditions.add (new Condition(new DataID("Tool", "response_time"), Operator.GEq, 1.0));
        // response_time: quality attribute
        // 10.0: threshold

        alert.setConditions(conditions);
        
        return alert;
    }
    
    protected Alert createAtosMonitoringAlert() {
        Alert alert = new Alert();

        alert.setId("id"+ System.currentTimeMillis());
        alert.setApplicationId("dynamic");
        alert.setTimestamp(Calendar.getInstance().getTimeInMillis());
        alert.setTenant(ModelSystem.AtosMonitoring);

        List<Condition> conditions = new ArrayList<Condition>();
        conditions.add (new Condition(new DataID("Tool", "response_time"), Operator.GEq, 1.0));
        // response_time: quality attribute
        // 10.0: threshold

        alert.setConditions(conditions);
        
        return alert;
    }
    
    
    protected Alert createDeterministicAtosMonitoringAlert() {
    	Alert alert = new Alert();

        alert.setId("id"+ System.currentTimeMillis());
        alert.setApplicationId("httpMonitor"); 
        alert.setTimestamp(System.currentTimeMillis());
        alert.setTenant(ModelSystem.AtosMonitoring);

        List<Condition> conditions = Lists.newArrayList();
        conditions.add(new Condition(new DataID("HTTPMonitor", "startMonitor"), Operator.EQ, 1.0)); //start http monitors

        alert.setConditions(conditions);
        
        // FIXME here I'm adding actions (will not be used) b/c deterministic cases are determined by the presence of actions
        
        List<ActionOnAttribute> actions = Lists.newArrayList();
        // the ids correspond to the parameterId
        actions.add(new ActionOnAttribute("CATEGORY_TYPE.BUG_CATEGORY.order", AttributeAction.update, 2));

        alert.setActionAttributes(actions);
        
        return alert;
    }
    
    protected Alert createSiemensAlert() {
        Alert alert = new Alert();

        alert.setId("id"+ System.currentTimeMillis());
        alert.setApplicationId("dynamic");
        alert.setTimestamp(Calendar.getInstance().getTimeInMillis());
        alert.setTenant(ModelSystem.Siemens);

        List<Condition> conditions = new ArrayList<Condition>();
        // response_time: quality attribute
        // 10.0: threshold
        conditions.add (new Condition(new DataID("Tool", "response_time"), Operator.GEq, 10.0));
        alert.setConditions(conditions);
        
        return alert;
    }
}
