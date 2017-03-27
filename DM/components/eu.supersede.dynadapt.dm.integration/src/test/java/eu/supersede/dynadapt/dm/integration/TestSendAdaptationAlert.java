package eu.supersede.dynadapt.dm.integration;

import java.util.ArrayList;
import java.util.List;

import javax.jms.JMSException;
import javax.naming.NamingException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import eu.supersede.integration.api.adaptation.types.Alert;
import eu.supersede.integration.api.adaptation.types.Condition;
import eu.supersede.integration.api.adaptation.types.DataID;
import eu.supersede.integration.api.adaptation.types.Operator;
import eu.supersede.integration.api.pubsub.adaptation.AdaptationPublisher;
import eu.supersede.integration.api.pubsub.adaptation.iAdaptationPublisher;

public class TestSendAdaptationAlert {
	
    @Test
    public void testPublishAdaptionAlertMessage() throws Exception{
    	sendAlert();
    }

	private void sendAlert() throws NamingException, JsonProcessingException {
		iAdaptationPublisher publisher = null;
		try {
		
			publisher = new AdaptationPublisher(true);
			Alert alert = createAlert();
			publisher.publishAdaptationAlertMesssage(alert);
			
		} catch (JMSException e) {
			e.printStackTrace();
		} finally {
			if (publisher != null){
				try {
					publisher.closeTopicConnection();
				} catch (JMSException e) {
					throw new RuntimeException("Error in closing topic connection", e);
				}
			}
		}
	}
	
	private Alert createAlert() {
		Alert alert = new Alert();
		
		alert.setID("id1");
		alert.setApplicationID("feedback");
		alert.setTimestamp(System.currentTimeMillis());
		alert.setTenant("atos");
		
		List<Condition> conditions = new ArrayList<Condition>();
		DataID dataId = new DataID();
		dataId.setNameComponent("hsk");
		dataId.setNameQualityMonitored("response_time");
		conditions.add (new Condition(dataId, Operator.GEq, 10.0));
		alert.setConditions(conditions);
		
		return alert;
	}
}