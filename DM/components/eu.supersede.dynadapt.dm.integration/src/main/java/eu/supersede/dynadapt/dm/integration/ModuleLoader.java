package eu.supersede.dynadapt.dm.integration;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

//import eu.supersede.gr.jpa.RequirementsJpa;
//import eu.supersede.gr.model.Requirement;

import eu.supersede.dynadapt.dm.datamodel.Alert;
import eu.supersede.dynadapt.dm.datamodel.ActionOnFeature;
import eu.supersede.dynadapt.dm.datamodel.ActionOnAttribute;

import eu.supersede.integration.api.pubsub.SubscriptionTopic;
import eu.supersede.integration.api.pubsub.TopicSubscriber;

@Component
public class ModuleLoader {

	//@Autowired
	//private RequirementsJpa requirementsTable;

	public ModuleLoader() {

	}

	@PostConstruct
	public void init() {
		new Thread( new Runnable() {
			@Override
			public void run() {
				TopicSubscriber subscriber = null;
				try {
					subscriber = new TopicSubscriber(SubscriptionTopic.ANALISIS_DM_ADAPTATION_EVENT_TOPIC);
					subscriber.openTopicConnection();
					TextMessageListener messageListener = new TextMessageListener();
					subscriber.createTopicSubscriptionAndKeepListening (messageListener);
					try {
						while( true ) {
							Thread.sleep(1000); //FIXME Configure sleeping time
						}
					} catch( InterruptedException e ) {
						e.printStackTrace();
					}
					subscriber.closeSubscription();
					subscriber.closeTopicConnection();
					
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					if (subscriber != null){
						try {
							subscriber.closeTopicConnection();
						} catch (JMSException e) {
							throw new RuntimeException( "Error in closing topic connection", e );
						}
					}
				}
			}} ).start();
	}

	public class TextMessageListener implements MessageListener {

		private void getActionsFeatures(Alert alert)
		{
			//List<Requirement> reqs = new ArrayList<>();
			for (ActionOnFeature action : alert.getActionFeatures())
			{
				System.out.println("Action on Feature: " + action.getID() + " " + action.getTypeaction().toString());
				//reqs.add(new Requirement(request.getId() + ": " + request.getDescription(), ""));
			}
		}
		
		private void getActionsAttributes(Alert alert)
		{
			//List<Requirement> reqs = new ArrayList<>();
			for (ActionOnAttribute action : alert.getActionAttributes())
			{
				System.out.println("Action on Feature: " + action.getID() + " " + action.getTypeaction().toString() 
						+ " " + action.getValue());
				//reqs.add(new Requirement(request.getId() + ": " + request.getDescription(), ""));
			}
		}

		public void onMessage(Message message) {
			try {
				
				//System.out.println( requirementsTable );
				
				System.out.println("Got the Message : " + ((TextMessage) message).getText());

				String text = ((TextMessage) message).getText();

				Alert alert = new Gson().fromJson( text, Alert.class );

				getActionsFeatures(alert);
				getActionsAttributes(alert);

				/*List<Requirement> requirements = getRequirements(alert);

				for (Requirement r : requirements)
				{

					r.setRequirementId(null);
					if( requirementsTable != null ) {
						requirementsTable.save(r);
					}
					else {
						System.out.println( "requirementsTable is NULL" );
					}

					//		            datastore.storeAsNew(r);
				}*/

//				messageReceived = true;
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}
}
