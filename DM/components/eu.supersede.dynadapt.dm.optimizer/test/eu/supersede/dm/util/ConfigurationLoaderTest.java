/*******************************************************************************
 * Copyright (c) 2016 FBK
 * All rights reserved. Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     Fitsum Kifetew (FBK) - main development
 *
 * Initially developed in the context of SUPERSEDE EU project www.supersede.eu
 *******************************************************************************/
package eu.supersede.dm.util;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

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
