package eu.supersede.dynadapt.dm.integration;

import javax.annotation.PostConstruct;
import javax.jms.JMSException;
import javax.naming.NamingException;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import eu.supersede.integration.api.adaptation.types.Alert;
import eu.supersede.integration.api.adaptation.types.Condition;
import eu.supersede.integration.api.adaptation.types.DataID;
import eu.supersede.integration.api.adaptation.types.ModelSystem;
import eu.supersede.integration.api.adaptation.types.Operator;
import eu.supersede.integration.api.pubsub.adaptation.AdaptationAlertMessageListener;
import eu.supersede.integration.api.pubsub.adaptation.AdaptationSubscriber;
import eu.supersede.integration.api.pubsub.adaptation.iAdaptationSubscriber;

@Component
public class ModuleLoader {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	public ModuleLoader() {}

	@PostConstruct
	public void init() {
		new Thread( new Runnable() {
			@Override
			public void run() {
				iAdaptationSubscriber subscriber = null;
				
				try {
					subscriber = new AdaptationSubscriber();
					subscriber.openTopicConnection();
					AdaptationAlertMessageListener messageListener = subscriber.createAdaptationAlertSubscriptionAndKeepListening();

					try {
						while( true ) {

							if (messageListener.areMessageReceived())
                            {
                                handleAlert(messageListener.getNextAlert());
                            }
                            else
                            {
                                Thread.sleep(1000); // FIXME Configure sleeping time
                            }
						}
					} catch( Exception e ) {
						e.printStackTrace();
					}
					subscriber.closeSubscription();
					subscriber.closeTopicConnection();
					
				}catch (JMSException e) {
					e.printStackTrace();
				}catch (NamingException e1)
                {
                    e1.printStackTrace();
                }finally
                {
                    if (subscriber != null)
                    {
                        try
                        {
                            subscriber.closeTopicConnection();
                        }
                        catch (JMSException e)
                        {
                            throw new RuntimeException("Error in closing topic connection", e);
                        }
                    }
                }
			}} ).start();
	}

	public void handleAlert(Alert alert) throws Exception
    {		
		log.debug("Handling alert: " + alert.getId() + ", " + alert.getApplicationId() + ", "
                + alert.getTenant() + ", " + alert.getTimestamp());
		
		//Check Alert for Atos HSK. Inject RT is case it is missing.
		if (alert.getTenant()==ModelSystem.Atos_HSK && !alert.getConditions().stream().anyMatch(
				c->c.getIdMonitoredData().getNameQualityMonitored().equals("response_time")))
			alert.getConditions().add (new Condition(new DataID("Tool", "response_time"), Operator.GEq, 1.0));
		
		//Check Alert for Siemens. Inject RT is case it is missing.
		if (alert.getTenant()==ModelSystem.Siemens && !alert.getConditions().stream().anyMatch(
				c->c.getIdMonitoredData().getNameQualityMonitored().equals("response_time"))){
			alert.getConditions().clear();
			alert.getConditions().add (new Condition(new DataID("Tool", "response_time"), Operator.GEq, 10.0));
		}
		
		ModelSystem system = alert.getTenant();
		
		// According to the type of alert (if alert contains actions, it is deterministic): 
		boolean deterministicAlert = (alert.getActionAttributes()!=null) || (alert.getActionFeatures()!=null);
				
		if(!deterministicAlert){
			// non-deterministic alert: optimizer
			new OptimizerHandler(system, alert).handle();
		}
		else {
			// deterministic alert: deterministic
			new DeterministicHandler(system, alert).handle();
		}
		
    }

}
