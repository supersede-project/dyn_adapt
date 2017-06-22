package eu.supersede.dynadapt.dm.optimizer.integration;

import org.junit.Before;
import org.springframework.util.Assert;
import org.junit.Test;
import eu.supersede.dynadapt.dm.integration.ModuleLoader;

public class ListenAlert {
	ModuleLoader m;
	
	@Before
    public void setup() throws Exception {
		this.m = new ModuleLoader();
    }
	
	@Test
	public void test() {
		m.init();
		Assert.notNull(m);
	}

}
