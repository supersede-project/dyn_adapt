package eu.supersede.dm.util;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.Test;

import eu.supersede.dynadapt.dm.util.ConfigurationLoader;

public class ConfigurationLoaderTest {

	@Test
	public void testConfigurationLoader() {
		ConfigurationLoader configurationLoader = ConfigurationLoader.getInstance();
		assertNotEquals(configurationLoader, null);
	}

	@Test
	public void testLoadAttributesListOfString() {
		List<String> configuration = new ArrayList<String>();
		configuration.add("attachment");
		configuration.add("sharewithall");
		configuration.add("audio");
		
		ConfigurationLoader configurationLoader = ConfigurationLoader.getInstance();
		List<Properties> attributes = configurationLoader.loadAttributes(configuration);
		assertTrue(attributes != null);
		assertTrue(attributes.size() == 3);
	}

}
