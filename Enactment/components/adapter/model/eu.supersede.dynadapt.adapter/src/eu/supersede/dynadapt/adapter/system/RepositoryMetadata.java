package eu.supersede.dynadapt.adapter.system;

import java.net.URI;

@Deprecated
public class RepositoryMetadata {
	ResourceType type;
	ResourceTimestamp timestamp;
	URI uri;
	
	public RepositoryMetadata(ResourceType type, ResourceTimestamp timestamp) {
		this.type = type;
		this.timestamp = timestamp;
	}
	
	public RepositoryMetadata(URI uri) {
		this.uri = uri;
	}
	
	public ResourceType getType (){
		return type;
	}
	
	public ResourceTimestamp getTimestamp (){
		return timestamp;
	}
	
	public URI getURI(){
		return uri;
	}
	
	public enum ResourceType { BASE, VARIANT, FEATURE_CONFIGURATION}
	public enum ResourceTimestamp { CURRENT, NEWEST }
	
}
