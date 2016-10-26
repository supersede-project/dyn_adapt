/*******************************************************************************
 * Copyright (c) 2016 Universitat Politécnica de Catalunya (UPC), ATOS Spain S.A
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
package eu.supersede.dynadapt.featuremodel.selection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import cz.zcu.yafmt.model.fc.AttributeValue;

public class SelectionLAO implements ISelectionLAO {

	/**
	 * This method returns a map containing the IDs (key) and values (value) of
	 * the attributes of a given selectionSUPERSEDE
	 * 
	 * 
	 * @param selectionSUPERSEDE
	 */
	@Override
	public Map<String, String> getAttrValueMap(SelectionSUPERSEDE s) {
		Map<String, String> attrVMap = new HashMap<String, String>();
		List<AttributeValue> attrValue = s.getAttValue();
		if (!attrValue.isEmpty()) {
			Iterator<AttributeValue> itattrValue = attrValue.iterator();
			while (itattrValue.hasNext()) {
				AttributeValue nextAttV = itattrValue.next();
				String stringAttV = "" + nextAttV;
				String value = "value: ";
				attrVMap.put(nextAttV.getId(),
						(stringAttV.substring(stringAttV.indexOf(value) + value.length(), stringAttV.length() - 1)));
			}
		}
		return attrVMap;
	}

}
