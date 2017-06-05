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
@RequestMapping("/adaptation")
public class AdaptationRest
{
    @Autowired
    AdaptationsJpa adaptations;
    EnactmentsJpa enactments;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Adaptation> getAdaptations()
    {
    	return adaptations.findAll();
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET )
    public Adaptation getAdaptation(@PathVariable("id") String id)
    {
    	return adaptations.findOne(id);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE )
    public void deleteAdaptation(@PathVariable("id") String id)
    {
    	adaptations.delete(id);
    }
    
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json")
    public Adaptation addAdaptation(Adaptation adaptation)
    {
    	return adaptations.save(adaptation);
    }
    
    @RequestMapping(value = "/{id}/enact", method = RequestMethod.POST, consumes = "application/json")
    public Enactment enactAdaptation(Enactment enactment)
    {
    	Adaptation a = adaptations.findOne(enactment.getFc_id());
    	enactment.setAdaptation(a);
    	return enactments.save(enactment);
    }
    
}