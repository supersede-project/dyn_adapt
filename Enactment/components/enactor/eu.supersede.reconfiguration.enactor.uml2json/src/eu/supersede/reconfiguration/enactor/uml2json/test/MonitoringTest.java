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
 *     Denisse Muñante (FBK) - main development
 *
 * Initially developed in the context of SUPERSEDE EU project www.supersede.eu
 *******************************************************************************/
package eu.supersede.reconfiguration.enactor.uml2json.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import eu.supersede.reconfiguration.enactor.uml2json.Uml2Json;

public class MonitoringTest {

	@Test
	public void uml2jsonTest() throws IOException{
		// NOTE: Edit this absolute paths before testing
		String absoluteModelPath = "/home/denisse/workspaceModel/eu.supersede.reconfiguration.enactor.uml2json/models/MonitoringSystemBaseModel.uml";
		String absolutetargetFolderPath = "/home/denisse/workspaceModel/eu.supersede.reconfiguration.enactor.uml2json/json/";
		Uml2Json.deriveUMLToJsonInFolder(absoluteModelPath, absolutetargetFolderPath);
	}
}