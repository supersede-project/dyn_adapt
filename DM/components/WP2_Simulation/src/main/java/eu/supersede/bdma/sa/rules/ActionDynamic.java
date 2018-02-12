package eu.supersede.bdma.sa.rules;

import java.util.List;

import com.google.common.collect.Lists;
import com.google.gson.Gson;

import eu.supersede.integration.api.adaptation.types.ActionOnAttribute;
import eu.supersede.integration.api.adaptation.types.Alert;
import eu.supersede.integration.api.adaptation.types.AttributeAction;
import eu.supersede.integration.api.adaptation.types.Condition;
import eu.supersede.integration.api.adaptation.types.DataID;
import eu.supersede.integration.api.adaptation.types.Operator;
import eu.supersede.integration.api.pubsub.SubscriptionTopic;
import eu.supersede.integration.api.pubsub.TopicPublisher;
import eu.supersede.integration.api.adaptation.types.ModelSystem;

public class ActionDynamic {

    private static Alert createAlert() {
        Alert alert = new Alert();

        alert.setId("id"+ System.currentTimeMillis());
        alert.setApplicationId("feedback"); 
        alert.setTimestamp(1481717773760L);
        alert.setTenant(ModelSystem.SenerconFG);

        List<Condition> conditions = Lists.newArrayList();
        conditions.add(new Condition(new DataID("FGTool", "diskC"), Operator.GT, 110000.0));
        conditions.add(new Condition(new DataID("FGTool", "attachment"), Operator.EQ, 8000.0));
        conditions.add(new Condition(new DataID("FGTool", "screenshot"), Operator.EQ, 8000.0));
        conditions.add(new Condition(new DataID("FGTool", "audio"), Operator.EQ, 96000.0));        
        
        alert.setConditions(conditions);
        
        return alert;
    }
    
    private static Alert createAlertDeterministic() {
        Alert alert = new Alert();

        alert.setId("id"+ System.currentTimeMillis());
        alert.setApplicationId("feedback"); 
        alert.setTimestamp(1481717773760L);
        alert.setTenant(ModelSystem.SiemensFG);

        List<Condition> conditions = Lists.newArrayList();
        conditions.add(new Condition(new DataID("FGTool", "category"), Operator.GT, 1.0)); //feature category

        alert.setConditions(conditions);
        
        List<ActionOnAttribute> actions = Lists.newArrayList();
        // the ids correspond to the parameterId
        actions.add(new ActionOnAttribute("CATEGORY_TYPE.514.order", AttributeAction.update, 2));
        actions.add(new ActionOnAttribute("CATEGORY_TYPE.515.order", AttributeAction.update, 1));
        actions.add(new ActionOnAttribute("CATEGORY_TYPE.516.order", AttributeAction.update, 3));

        alert.setActionAttributes(actions);
        
        return alert;
    }

    public static void sendAlert() throws Exception {
        TopicPublisher publisher = new TopicPublisher(SubscriptionTopic.ANALISIS_DM_ADAPTATION_EVENT_TOPIC,true, "development");
        boolean deterministica = true;
        if(deterministica){
            publisher.publishTextMesssageInTopic(new Gson().toJson(createAlertDeterministic()));
        }
        else{
            publisher.publishTextMesssageInTopic(new Gson().toJson(createAlert()));        	
        }
        publisher.closeTopicConnection();
    }
}
