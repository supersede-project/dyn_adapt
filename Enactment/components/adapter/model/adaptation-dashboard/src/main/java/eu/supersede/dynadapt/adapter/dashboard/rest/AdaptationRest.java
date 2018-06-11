package eu.supersede.dynadapt.adapter.dashboard.rest;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
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
import eu.supersede.fe.security.DatabaseUser;
import eu.supersede.integration.api.adaptation.proxies.AdaptationConfigurationProxy;
import eu.supersede.integration.api.adaptation.proxies.AdapterProxy;
import eu.supersede.integration.api.adaptation.types.AdaptationMode;
import eu.supersede.integration.api.adaptation.types.ModelSystem;

@RestController
@RequestMapping("/adaptation")
public class AdaptationRest {
	@Autowired
	AdaptationsJpa adaptations;
	@Autowired
	ActionsJpa actions;
	@Autowired
	EnactmentsJpa enactments;
	protected final Logger log = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Adaptation> getAdaptations() {
		return adaptations.findAll();
	}

	@RequestMapping(value = "/suggested", method = RequestMethod.GET)
	public List<Adaptation> getSuggestedAdaptations(Authentication authentication,
			@RequestParam(required = false) String modelSystem) {
		ModelSystem mSystem;
		try {
			mSystem = ModelSystem.valueOf(modelSystem);
		} catch (Exception e) {
			mSystem = null;
		}
		// Returning only adaptations that having been enacted
		List<Adaptation> adapts = adaptations.findAll();

		List<Adaptation> result = new ArrayList<>();
		DatabaseUser currentUser = (DatabaseUser) authentication.getPrincipal();
		String tenantId = currentUser.getTenantId();

		for (Adaptation ad : adapts) {
			if (enactments.findOne(ad.getFc_id()) == null
					&& ad.getModel_system().getTenant().toString().equals(tenantId)) {
				if (mSystem == null || mSystem != null && ad.getModel_system().equals(mSystem))
					result.add(ad);
			}
		}

		return result;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Adaptation getAdaptation(@PathVariable("id") String id) {
		return adaptations.findOne(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteAdaptation(@PathVariable("id") String id) {
		Adaptation adaptation = adaptations.findOne(id);
		List<Action> actionList = adaptation.getActions();
		for (Action a : actionList) {
			actions.delete(a);
		}
		Enactment enactment = enactments.findOne(id);
		if (enactment != null)
			enactments.delete(enactment);
		adaptations.delete(id);
	}

	@RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json")
	public Adaptation addAdaptation(@RequestBody Adaptation adaptation) {
		for (Action a : adaptation.getActions())
			a.setFc_id(adaptation.getFc_id());
		return adaptations.save(adaptation);
	}

	@RequestMapping(value = "/enact/{id}", method = RequestMethod.POST)
	public void enactAdaptation(@PathVariable("id") String id) throws Exception {
		AdapterProxy<?, ?> proxy = new AdapterProxy<Object, Object>();
		List<String> actionIds = new ArrayList<>();

		Adaptation adaptation = adaptations.findOne(id);
		if (adaptation == null) {
			throw new Exception("Adaptation not found");
		}

		for (Action a : adaptation.getActions())
			actionIds.add(a.getAc_id());

		// FG Reconfiguration system requires a different invocation
		if (adaptation.getModel_system() == ModelSystem.SenerconFG || 
			adaptation.getModel_system() == ModelSystem.SenerconFGcat ||
			adaptation.getModel_system() == ModelSystem.SiemensFG || 
			adaptation.getModel_system() == ModelSystem.SiemensFGcat ||
			adaptation.getModel_system() == ModelSystem.AtosFG || 
			adaptation.getModel_system() == ModelSystem.AtosFGcat) {
			log.info("Invoking Adapter: enactFeatureConfiguration for system " + adaptation.getModel_system()
					+ " and FC id: " + adaptation.getFc_id());
			if (!proxy.enactFeatureConfiguration(adaptation.getModel_system(), adaptation.getFc_id())) {
				throw new Exception("Adaptation: " + id + " could not be enacted. Check backend service log");
			}
		} else {
			log.info("Invoking Adapter: enactAdaptationDecisionActionsForFC for system " + adaptation.getModel_system()
			+ " and FC id: " + adaptation.getFc_id());
			if (!proxy.enactAdaptationDecisionActionsForFC(adaptation.getModel_system(), adaptation.getFc_id())) {
				throw new Exception("Adaptation: " + id + " could not be enacted. Check backend service log");
			}
		}
	}

	@RequestMapping(value = "/configuration/{conf}", method = RequestMethod.POST)
	public void setConfiguration(@PathVariable String conf) throws Exception {
		System.out.println("New adaptation configuration: " + conf);
		AdaptationConfigurationProxy<?, ?> proxy = new AdaptationConfigurationProxy<Object, Object>();

		proxy.setAdaptationConfigurationMode(AdaptationMode.valueOf(conf.toUpperCase()));
	}

	@RequestMapping(value = "/configuration", method = RequestMethod.GET)
	public AdaptationMode getConfiguration() throws Exception {
		System.out.println("Requested to get the adaptation configuration mode");
		AdaptationConfigurationProxy<?, ?> proxy = new AdaptationConfigurationProxy<Object, Object>();
		AdaptationMode mode = proxy.getAdaptationConfigurationMode();
		return mode;
	}

}