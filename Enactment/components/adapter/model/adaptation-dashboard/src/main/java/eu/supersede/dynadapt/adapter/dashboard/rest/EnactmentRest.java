package eu.supersede.dynadapt.adapter.dashboard.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import eu.supersede.dynadapt.adapter.dashboard.jpa.AdaptationsJpa;
import eu.supersede.dynadapt.adapter.dashboard.jpa.EnactmentsJpa;
import eu.supersede.dynadapt.adapter.dashboard.model.Adaptation;
import eu.supersede.dynadapt.adapter.dashboard.model.Enactment;

@RestController
@RequestMapping("/enactment")
public class EnactmentRest
{
    @Autowired
    EnactmentsJpa enactments;
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
    public Enactment addEnactment(Enactment enactment)
    {
    	Adaptation a = adaptations.findOne(enactment.getFc_id());
    	enactment.setAdaptation(a);
    	return enactments.save(enactment);
    }
    
}
