package eu.supersede.dynadapt.modelrepository.persistence.test;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import org.junit.Before;
/*******************************************************************************
 * Copyright (c) 2016 Universitat Politécnica de Catalunya (UPC)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
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
 * 	Edith Zavala (UPC) - main development
 * 	
 * Initially developed in the context of SUPERSEDE EU project
 * www.supersede.eu
 *******************************************************************************/
import org.junit.Test;

import eu.supersede.dynadapt.modelrepository.persistence.ModelRepositoryPersistence;

public class ModelRepositoryPersistenceTest {
	
	ModelRepositoryPersistence mrp;
	URL persistenceLocation;
	
	@Before
	public void setUp() throws Exception {
		String userdir = System.getProperty("user.dir");
		Path path = FileSystems.getDefault().getPath(userdir,"/Models");
		persistenceLocation = new URL (path.toUri().toURL().toString());
		mrp = new ModelRepositoryPersistence(persistenceLocation);
	}
	
    @Test public void testSomeLibraryMethod() {
    	URL fileURL= mrp.storeModel("1", "Monitoring", "Adaptation", "Base", "MyFirstBase", "I'm a base model", ".uml");
    	
        //assertTrue("someLibraryMethod should return 'true'", classUnderTest.someLibraryMethod());
    }
}