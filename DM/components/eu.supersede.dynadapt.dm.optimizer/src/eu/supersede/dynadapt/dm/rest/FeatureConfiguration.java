package eu.supersede.dynadapt.dm.rest;

public class FeatureConfiguration {
	private String optimalConfig;
	
	public FeatureConfiguration(String optimalConfig){
		this.optimalConfig = optimalConfig;
	}

	public String getOptimalConfig() {
		return optimalConfig;
	}

	public void setOptimalConfig(String optimalConfig) {
		this.optimalConfig = optimalConfig;
	}
	
}
