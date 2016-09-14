package eu.supersede.dm.util;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.Test;

public class ConfigurationLoaderTest {

	@Test
	public void testConfigurationLoader() {
		ConfigurationLoader configurationLoader = new ConfigurationLoader();
		assertNotEquals(configurationLoader, null);
	}

	@Test
	public void testLoadAttributesListOfString() {
		List<String> configuration = new ArrayList<String>();
		configuration.add("webclient");
		configuration.add("ios");
		configuration.add("audio");
		
		ConfigurationLoader configurationLoader = new ConfigurationLoader();
		List<Properties> attributes = configurationLoader.loadAttributes(configuration);
		assertTrue(attributes != null);
		assertTrue(attributes.size() == 3);
	}

}
