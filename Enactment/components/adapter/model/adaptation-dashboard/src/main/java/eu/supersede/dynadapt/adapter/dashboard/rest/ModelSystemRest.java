package eu.supersede.dynadapt.adapter.dashboard.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import eu.supersede.fe.security.DatabaseUser;
import eu.supersede.integration.api.adaptation.types.ModelSystem;
import eu.supersede.integration.api.adaptation.types.Tenant;

@RestController
@RequestMapping("/model-system")
public class ModelSystemRest {

	@RequestMapping(value = "", method = RequestMethod.GET)
    public List<ModelSystem> getAdaptations(Authentication authentication)
    {
		List<ModelSystem> modelSystems = new ArrayList<>();
		DatabaseUser currentUser = (DatabaseUser) authentication.getPrincipal();
        String tenantId = currentUser.getTenantId();
        
        for (ModelSystem modelSystem : ModelSystem.values()) {
        	if (modelSystem.getTenant().toString().toLowerCase().equals(tenantId.toLowerCase()))
        		modelSystems.add(modelSystem);
        }
        
        return modelSystems;
    }
	
}
