package eu.supersede.dynadapt.dm.optimizer.configuration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum AdaptationMode {
	SUPERVISED("supervised"), AUTOMATED("automated");
	
	private String mode;
 
    private AdaptationMode(String mode) {
        this.mode = mode;
    }
    
    @JsonCreator
    public static AdaptationMode fromNode(JsonNode node) {
        if (!node.has("mode"))
            return null;

        String name = node.get("mode").asText();

        return AdaptationMode.valueOf(name.toUpperCase());
    }

    
    @JsonProperty ("mode")
    public String getMode() {
        return mode;
    }
}
