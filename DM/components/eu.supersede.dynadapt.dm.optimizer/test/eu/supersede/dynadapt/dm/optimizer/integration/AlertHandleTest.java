package eu.supersede.dynadapt.dm.optimizer.integration;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

import eu.supersede.dynadapt.dm.integration.ModuleLoader;
import eu.supersede.integration.api.adaptation.types.ActionOnAttribute;
import eu.supersede.integration.api.adaptation.types.Alert;
import eu.supersede.integration.api.adaptation.types.AttachedValue;
import eu.supersede.integration.api.adaptation.types.AttributeAction;
import eu.supersede.integration.api.adaptation.types.Condition;
import eu.supersede.integration.api.adaptation.types.DataID;
import eu.supersede.integration.api.adaptation.types.ModelSystem;
import eu.supersede.integration.api.adaptation.types.Operator;

public class AlertHandleTest {
	
	
	@Test
	public void SenerconNonDeterministicFGOptimization() throws Exception {
		ModuleLoader optimizer = new ModuleLoader();
		Alert alert = createSenerconNonDeterministicFGAlert();
		optimizer.handleAlert(alert);
	}
	
	@Test
	public void SenerconDeterministicFGCatOptimization() throws Exception {
		ModuleLoader optimizer = new ModuleLoader();
		Alert alert = createSenerconDeterministicFGAlert();
		optimizer.handleAlert(alert);
	}

	@Test
	public void SiemenesOptimizationBuildingsTest() throws Exception {
		ModuleLoader optimizer = new ModuleLoader();
		Alert alert = createSiemensAlert(ModelSystem.Siemens_Buildings);
		optimizer.handleAlert(alert);
	}
	
	@Test
	public void SiemenesOptimizationGetMinMaxTest() throws Exception {
		ModuleLoader optimizer = new ModuleLoader();
		Alert alert = createSiemensAlert(ModelSystem.Siemens_GetMinMaxDates);
		optimizer.handleAlert(alert);
	}
	
	
	@Test
	public void SiemenesOptimizationTypesTest() throws Exception {
		ModuleLoader optimizer = new ModuleLoader();
		Alert alert = createSiemensAlert(ModelSystem.Siemens_Types);
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
        alert.setTenant(ModelSystem.AtosMonitoringTimeSlot);

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
        alert.setTenant(ModelSystem.AtosMonitoringEnabling);

        List<Condition> conditions = Lists.newArrayList();
        conditions.add(new Condition(new DataID("HTTPMonitor", "startMonitor"), Operator.EQ, 1.0)); //start http monitors

        alert.setConditions(conditions);
        
        // FIXME here I'm adding actions (will not be used) b/c deterministic cases are determined by the presence of actions
        
//        List<ActionOnAttribute> actions = Lists.newArrayList();
//        // the ids correspond to the parameterId
//        actions.add(new ActionOnAttribute("CATEGORY_TYPE.BUG_CATEGORY.order", AttributeAction.update, 2));

//        alert.setActionAttributes(actions);
        
        return alert;
    }
    
    protected Alert createSiemensAlert(ModelSystem system) {
        Alert alert = new Alert();

        alert.setId("id"+ System.currentTimeMillis());
        alert.setApplicationId("dynamic");
        alert.setTimestamp(Calendar.getInstance().getTimeInMillis());
        alert.setTenant(system); //ModelSystem.Siemens);

        List<Condition> conditions = new ArrayList<Condition>();
        // response_time: quality attribute
        // 10.0: threshold
        conditions.add (new Condition(new DataID("Tool", "response_time"), Operator.GEq, 10.0));
        alert.setConditions(conditions);
        
        return alert;
    }
    
    protected Alert createSenerconNonDeterministicFGAlert() {
        Alert alert = new Alert();

        alert.setId("id"+ System.currentTimeMillis());
        alert.setApplicationId("feedback"); 
        alert.setTimestamp(1481717773760L);
        alert.setTenant(ModelSystem.SenerconFG);

        List<Condition> conditions = Lists.newArrayList();
        conditions.add(new Condition(new DataID("FGTool", "diskC"), Operator.GT, 30000.0));//33460.0
        
        alert.setConditions(conditions);
        
        List<AttachedValue> attach = Lists.newArrayList();
        attach.add(new AttachedValue("attachment", "7000.0"));
        //attach.add(new AttachedValue("screenshot", "8000.0"));
        attach.add(new AttachedValue("audio", "23000.0"));        
        
        alert.setAttachedValues(attach);
        
        return alert;
    }
    
    private static Alert createSenerconDeterministicFGAlert() {
        Alert alert = new Alert();

        alert.setId("id"+ System.currentTimeMillis());
        alert.setApplicationId("feedback"); 
        alert.setTimestamp(1481717773760L);
        alert.setTenant(ModelSystem.SenerconFGcat);

        List<Condition> conditions = Lists.newArrayList();
        conditions.add(new Condition(new DataID("FGTool", "category"), Operator.GT, 1.0)); //feature category

        alert.setConditions(conditions);
        
        List<ActionOnAttribute> actions = Lists.newArrayList();
        // the ids correspond to the parameterId
        actions.add(new ActionOnAttribute("category_type.id_514.order", AttributeAction.update, 3));
        actions.add(new ActionOnAttribute("category_type.id_515.order", AttributeAction.update, 1));
        actions.add(new ActionOnAttribute("category_type.id_516.order", AttributeAction.update, 2));

        alert.setActionAttributes(actions);
        
        return alert;
    }
}
