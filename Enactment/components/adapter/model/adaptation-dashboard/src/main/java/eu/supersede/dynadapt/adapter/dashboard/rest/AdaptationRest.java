package eu.supersede.dynadapt.adapter.dashboard.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import eu.supersede.dynadapt.adapter.dashboard.jpa.ActionsJpa;
import eu.supersede.dynadapt.adapter.dashboard.jpa.AdaptationsJpa;
import eu.supersede.dynadapt.adapter.dashboard.jpa.EnactmentsJpa;
import eu.supersede.dynadapt.adapter.dashboard.model.Action;
import eu.supersede.dynadapt.adapter.dashboard.model.Adaptation;
import eu.supersede.dynadapt.adapter.dashboard.model.Enactment;

@RestController
@RequestMapping("/adaptation")
public class AdaptationRest
{
    @Autowired
    AdaptationsJpa adaptations;
    @Autowired
    ActionsJpa actions;
    @Autowired
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
    	Adaptation adaptation = adaptations.findOne(id);
    	List<Action> actionList = adaptation.getActions();
    	for (Action a : actionList) {
    		actions.delete(a);
    	}
    	Enactment enactment = enactments.findOne(id);
    	if (enactment != null) enactments.delete(enactment);
    	adaptations.delete(id);
    }
    
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json")
    public Adaptation addAdaptation(@RequestBody Adaptation adaptation)
    {
    	for (Action a : adaptation.getActions()) a.setFc_id(adaptation.getFc_id());
    	return adaptations.save(adaptation);
    }
    
}