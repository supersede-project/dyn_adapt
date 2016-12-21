package eu.supersede.dynadapt.modelrepository.manager;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import eu.supersede.dynadapt.modelrepository.model.IModel;

public class ManagerTest {
	
	@Before
	public void setUp() {
		
	}
	
	@Test
	public void initManager() {
		Manager manager = new Manager();
		assertNotNull(manager);
	}
	
	@Test
	public void listAllModels() {
		Manager manager = new Manager();
		try {
			List<IModel> models = manager.listAllModels("AdaptabilityModel");
			System.out.println("Number of adaptability models: " + models.size());
			for (IModel model : models) System.out.println("\tModel id: " + model.getValue("id"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
