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
