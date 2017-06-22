package eu.supersede.bdma.sa.rules;

import java.util.Calendar;
import java.util.List;

import com.google.common.collect.Lists;
import com.google.gson.Gson;

import eu.supersede.integration.api.adaptation.types.Alert;
import eu.supersede.integration.api.adaptation.types.Condition;
import eu.supersede.integration.api.adaptation.types.DataID;
import eu.supersede.integration.api.adaptation.types.ModelSystem;
import eu.supersede.integration.api.adaptation.types.Operator;
import eu.supersede.integration.api.pubsub.SubscriptionTopic;
import eu.supersede.integration.api.pubsub.TopicPublisher;

/**
 * Created by snadal on 24/01/17.
 */
public class ActionDynamic {

    private static Alert createAtosHSKAlert() {
        Alert alert = new Alert();

        alert.setId("id"+ System.currentTimeMillis());
        alert.setApplicationId("dynamic");
        alert.setTimestamp(Calendar.getInstance().getTimeInMillis());
        alert.setTenant(ModelSystem.Atos_HSK);

        List<Condition> conditions = Lists.newArrayList();
        conditions.add (new Condition(new DataID("Tool", "response_time"), Operator.GEq, 1.0));
        // response_time: quality attribute
        // 10.0: threshold

        alert.setConditions(conditions);
        
        return alert;
    }
    
    private static Alert createSiemensAlert() {
        Alert alert = new Alert();

        alert.setId("id"+ System.currentTimeMillis());
        alert.setApplicationId("dynamic");
        alert.setTimestamp(Calendar.getInstance().getTimeInMillis());
        alert.setTenant(ModelSystem.Siemens);

        List<Condition> conditions = Lists.newArrayList();
        conditions.add (new Condition(new DataID("Tool", "response_time"), Operator.GEq, 10.0));
        // response_time: quality attribute
        // 10.0: threshold

        alert.setConditions(conditions);
        
        return alert;
    }
    

    public static void sendAlert() throws Exception {
        TopicPublisher publisher = new TopicPublisher(SubscriptionTopic.ANALISIS_DM_ADAPTATION_EVENT_TOPIC,true);
        publisher.publishTextMesssageInTopic(new Gson().toJson(createAtosHSKAlert()));
        //publisher.publishTextMesssageInTopic(new Gson().toJson(createSiemensAlert()));
        publisher.closeTopicConnection();
    }
}
