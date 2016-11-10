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
/**
 * 
 */
package eu.supersede.dm.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;
import java.util.Map.Entry;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Test;

/**
 * @author fitsum
 *
 */
public class JSONReaderTest {

	@Test
	public void test1() throws FileNotFoundException {
		String jsonFile = "input/refsq17/monitoring/feedbackreconfig/attribute.metadata.json";
		FileReader fileReader = new FileReader(jsonFile);
		JSONTokener jsonTokener = new JSONTokener(fileReader);
		JSONObject jsonObject = new JSONObject(jsonTokener);
//		String key = "/memory_consumption/opt";
		Map<String, Object> map = jsonObject.toMap();
		for (Entry<String, Object> entry : map.entrySet()){
			System.err.println(entry.getKey());
			Map<Object, Object> innerMap = (Map<Object, Object>)entry.getValue();
			System.out.println(innerMap.get("opt"));
//			for (Entry<Object, Object> innerEntry : innerMap.entrySet()){
//				System.out.println(innerEntry.getKey() + " " + innerEntry.getValue());
//			}
		}
	}

}
