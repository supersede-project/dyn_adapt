package eu.supersede.dynadapt.dm.optimizer.integration;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import eu.supersede.dynadapt.dm.integration.ModuleLoader;
import eu.supersede.integration.api.adaptation.types.Alert;
import eu.supersede.integration.api.adaptation.types.Condition;
import eu.supersede.integration.api.adaptation.types.DataID;
import eu.supersede.integration.api.adaptation.types.ModelSystem;
import eu.supersede.integration.api.adaptation.types.Operator;

public class AlertHandleTest {

	@Test
	@Ignore
	public void SiemenesOptimizationTest() throws Exception {
		ModuleLoader optimizer = new ModuleLoader();
		Alert alert = createSiemensAlert();
		optimizer.handleAlert(alert);
	}
	
	@Test
	@Ignore
	public void AtosHSKOptimizationTest() throws Exception {
		ModuleLoader optimizer = new ModuleLoader();
		Alert alert = createAtosHSKAlert();
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
