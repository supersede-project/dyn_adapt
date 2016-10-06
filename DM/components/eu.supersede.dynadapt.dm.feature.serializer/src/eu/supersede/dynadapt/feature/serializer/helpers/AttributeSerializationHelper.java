package eu.supersede.dynadapt.feature.serializer.helpers;

import java.util.ArrayList;
import java.util.List;

public class AttributeSerializationHelper {
	public static List<String> serializedAttributes = new ArrayList<>();

	public boolean attributeHasBeenSerialized(String attributeName) {
		boolean alreadySerialized = serializedAttributes.contains(attributeName);
		if (!alreadySerialized){
			serializedAttributes.add(attributeName);
		}
		return alreadySerialized;
	}
}
