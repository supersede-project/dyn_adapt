package eu.supersede.bdma.sa.rules;

import java.util.Date;
import java.util.List;

import com.google.common.collect.Lists;
import com.google.gson.Gson;

import eu.supersede.integration.api.dm.types.Alert;
import eu.supersede.integration.api.dm.types.Condition;
import eu.supersede.integration.api.dm.types.DataID;
import eu.supersede.integration.api.dm.types.Operator;
import eu.supersede.integration.api.dm.types.RequestClassification;
import eu.supersede.integration.api.dm.types.UserRequest;
import eu.supersede.integration.api.pubsub.SubscriptionTopic;
import eu.supersede.integration.api.pubsub.TopicPublisher;


/**
 * Created by snadal on 24/01/17.
 */
public class Action {

    private static Alert createAlert() {
        Alert alert = new Alert();

        alert.setId("id"+ System.currentTimeMillis());
        alert.setApplicationId("appId1");
        alert.setTimestamp(1481717773760L);
        alert.setTenant("siemens");

        List<Condition> conditions = Lists.newArrayList();
        conditions.add (new Condition(DataID.UNSPECIFIED, Operator.GEq, 10.5));
        alert.setConditions(conditions);

        List<UserRequest> requests = Lists.newArrayList();
        String[] feedbackIDs = new String[]{"feedbackId1"};
        String[] features = new String[]{"UI","backend"};
        long l = System.currentTimeMillis();
        requests.add(
        		new UserRequest(
        				"id"+ (l++), 
        				RequestClassification.FeatureRequest,
        				0.5, 
        				"description string of id" + l + " - " + new Date().getTime(), 
        				1, 2, 0, feedbackIDs, features));
        requests.add(
        		new UserRequest(
        				"id"+ (l++), 
        				RequestClassification.FeatureRequest,
        				0.5, 
        				"description string of id" + l, 
        				1, 2, 0, feedbackIDs, features));
        alert.setRequests(requests);

        return alert;
    }
    

    public static void sendAlert() throws Exception {
        TopicPublisher publisher = new TopicPublisher(SubscriptionTopic.ANALISIS_DM_EVOLUTION_EVENT_TOPIC,true);
        publisher.publishTextMesssageInTopic(new Gson().toJson(createAlert()));
        publisher.closeTopicConnection();
    }
}
