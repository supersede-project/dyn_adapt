package eu.supersede.dynadapt.adapter.dashboard.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import eu.supersede.dynadapt.adapter.dashboard.jpa.ActionsJpa;
import eu.supersede.dynadapt.adapter.dashboard.model.Action;

@RestController
@RequestMapping("/action")
public class ActionRest
{
    @Autowired
    ActionsJpa actions;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Action> getActions()
    {
    	return actions.findAll();
    }
}