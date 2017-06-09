package eu.supersede.dynadapt.adapter.dashboard.rest;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import eu.supersede.dynadapt.adapter.dashboard.jpa.AdaptationsJpa;
import eu.supersede.dynadapt.adapter.dashboard.jpa.EnactmentsJpa;
import eu.supersede.dynadapt.adapter.dashboard.model.Action;
import eu.supersede.dynadapt.adapter.dashboard.model.Adaptation;
import eu.supersede.dynadapt.adapter.dashboard.model.Enactment;
import eu.supersede.integration.api.adaptation.proxies.AdapterProxy;
import eu.supersede.integration.api.adaptation.types.ModelSystem;

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
    public Enactment addEnactment(@RequestBody Enactment enactment)
    {
    	AdapterProxy<?,?> proxy = new AdapterProxy<Object, Object>();
    	List<String> actionIds = new ArrayList<>();
    	for (Action a : enactment.getAdaptation().getActions()) actionIds.add(a.getAc_id());
    	try {
			Adaptation a = adaptations.findOne(enactment.getFc_id());
			boolean result = proxy.enactAdaptationDecisionActions(a.getModel_system(), actionIds, enactment.getFc_id());
			enactment.setResult(result);
	    	enactment.setAdaptation(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return enactments.save(enactment);
    }
    
}
