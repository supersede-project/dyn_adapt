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
import org.springframework.web.bind.annotation.RequestParam;
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
    public Enactment addEnactment(@RequestBody Enactment enactment,
    		@RequestParam(value="applyEnactment", defaultValue="false") boolean applyEnactment) throws Exception
    {
    	
    	Adaptation adaptation = adaptations.findOne(enactment.getFc_id());
    	if (adaptation == null) throw new Exception ("There is no suggested adaptation for " + enactment.getFc_id());
    	enactment.setAdaptation(adaptation);
    	
		Enactment enactmentExists = enactments.findOne(enactment.getFc_id());
		if (enactmentExists != null) throw new Exception("This adaptation has already been enacted");
    	
    	return enactments.save(enactment);
    }
    
}
