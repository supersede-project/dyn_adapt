package eu.supersede.dynadapt.adapter.dashboard.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import eu.supersede.dynadapt.adapter.dashboard.jpa.AdaptationsJpa;
import eu.supersede.dynadapt.adapter.dashboard.model.Adaptation;

@RestController
@RequestMapping("/adaptation")
public class AdaptationRest
{
    @Autowired
    AdaptationsJpa adaptations;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Adaptation> getAdaptations()
    {
    	List<Adaptation> adapts = adaptations.findAll();
    	List<Adaptation> result = new ArrayList<>();
    	for (int i = 0; i < adapts.size(); ++i) {
    		if (adapts.get(i).isEnacted()) result.add(adapts.get(i));
    	}
    	return result;
    }
}