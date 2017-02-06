package eu.supersede.dynadapt.dm.integration;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import eu.supersede.dynadapt.dm.datamodel.Condition;
import eu.supersede.dynadapt.dm.datamodel.ActionOnAttribute;
import eu.supersede.dynadapt.dm.datamodel.ActionOnFeature;
import eu.supersede.dynadapt.dm.datamodel.Alert;

import eu.supersede.dynadapt.dm.datamodel.DataID;
import eu.supersede.dynadapt.dm.datamodel.FeatureAction;
import eu.supersede.dynadapt.dm.datamodel.Operator;

public class TestJSON {
	
	public static void main( String[] args ) {
		
		List<Condition> conditions = new ArrayList<>();
		List<ActionOnFeature> actionsF = new ArrayList<>();
		List<ActionOnAttribute> actionsA = new ArrayList<>();
		
		DataID idMonitored = new DataID("audio", "responsetime");
				
		conditions.add(new Condition(idMonitored, Operator.GEq, 10.0));
		actionsF.add(new ActionOnFeature("attachment", FeatureAction.deselect));
		
		
		Alert alert = new Alert( 
				"id1", "appId1", System.currentTimeMillis(), "atos", conditions,  actionsF, actionsA);
		
		Gson gson = new Gson();
		
		System.out.println( gson.toJson( alert ) );
		
	}
	
}