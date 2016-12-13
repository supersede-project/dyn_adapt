package eu.supersede.dynadapt.modelrepository.manager;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class ManagerTest {
	
	@Before
	public void setUp() {
		
	}
	
	@Test
	public void initManager() {
		Manager manager = new Manager();
		assertNotNull(manager);
		assertNotNull(manager.getConnection());
	}
	
	@Test
	public void testDBConnection() {
		Manager manager = new Manager();
		//TODO test connection
	}

}
