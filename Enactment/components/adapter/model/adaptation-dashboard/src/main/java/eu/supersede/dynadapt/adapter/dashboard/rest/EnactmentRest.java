package eu.supersede.dynadapt.adapter.dashboard.rest;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import eu.supersede.dynadapt.adapter.dashboard.jpa.ActionsJpa;
import eu.supersede.dynadapt.adapter.dashboard.jpa.AdaptationsJpa;
import eu.supersede.dynadapt.adapter.dashboard.jpa.EnactmentsJpa;
import eu.supersede.dynadapt.adapter.dashboard.model.Action;
import eu.supersede.dynadapt.adapter.dashboard.model.Adaptation;
import eu.supersede.dynadapt.adapter.dashboard.model.Enactment;
import eu.supersede.integration.api.adaptation.proxies.AdapterProxy;

@RestController
@RequestMapping("/enactment")
public class EnactmentRest
{
    @Autowired
    EnactmentsJpa enactments;
    @Autowired
    AdaptationsJpa adaptations;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Enactment> getEnactments()
    {
    	return enactments.findAll();
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET )
    public Enactment getEnactment(@PathVariable("id") String id)
    {
    	return enactments.findOne(id);
    }
   
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE )
    public void deleteEnactment(@PathVariable("id") String id)
    {
    	enactments.delete(id);
    }
    
    @RequestMapping(value = "", method = RequestMethod.POST )
    public Enactment addEnactment(@RequestBody Enactment enactment) throws Exception
    {
    	Timestamp initTime = new Timestamp(System.currentTimeMillis());
    	enactment.setEnactment_request_time(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(initTime));
    	
		Adaptation adaptation = adaptations.findOne(enactment.getFc_id());
		Enactment enactmentExists = enactments.findOne(enactment.getFc_id());
		if (enactmentExists != null) throw new Exception("This adaptation has already been enacted");
    	
    	AdapterProxy<?,?> proxy = new AdapterProxy<Object, Object>();
    	List<String> actionIds = new ArrayList<>();
    	
    	for (Action a : adaptation.getActions()) actionIds.add(a.getAc_id());
    	
    	try {
    		
    		//FIXME uncomment when ready to test
			//boolean result = proxy.enactAdaptationDecisionActions(a.getModel_system(), actionIds, enactment.getFc_id());
			boolean result = true;
			
			Timestamp endTime = new Timestamp(System.currentTimeMillis());
			Time time = new Time(endTime.getTime() - initTime.getTime());
			enactment.setEnactment_completion_time(new SimpleDateFormat("mm:ss.SSS").format(time));
			
			enactment.setResult(result);
	    	enactment.setAdaptation(adaptation);
	    	
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return enactments.save(enactment);
    }
    
}
