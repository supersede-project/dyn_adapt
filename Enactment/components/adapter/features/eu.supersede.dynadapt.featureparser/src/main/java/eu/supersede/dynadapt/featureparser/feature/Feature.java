package eu.supersede.dynadapt.featureparser.feature;

import java.util.HashMap;
import java.util.List;

public class Feature implements IFeature {

	private String name;

	/* Properties: Name, Value */
	private HashMap<String, String> properties;

	/* Attributes: Name, Value */
	private HashMap<String, String> attributes;

	private IFeature parent;

	private List<IFeature> children;

	/* Constraints: V1 = String | V2 = Predecessor, Successor */
	private List<String> relatedConstraints;

	public Feature(String name, HashMap<String, String> properties, HashMap<String, String> attributes, IFeature parent,
			List<IFeature> children, List<String> relatedConstraints) {
		super();
		this.name = name;
		this.properties = properties;
		this.attributes = attributes;
		this.parent = parent;
		this.children = children;
		this.relatedConstraints = relatedConstraints;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HashMap<String, String> getProperties() {
		return properties;
	}

	public void setProperties(HashMap<String, String> properties) {
		this.properties = properties;
	}

	public HashMap<String, String> getAttributes() {
		return attributes;
	}

	public void setAttributes(HashMap<String, String> attributes) {
		this.attributes = attributes;
	}

	public IFeature getParent() {
		return parent;
	}

	public void setParent(IFeature parent) {
		this.parent = parent;
	}

	public List<IFeature> getChildren() {
		return children;
	}

	public void setChildren(List<IFeature> children) {
		this.children = children;
	}

	public List<String> getRelatedConstraints() {
		return relatedConstraints;
	}

	public void setRelatedConstraints(List<String> relatedConstraints) {
		this.relatedConstraints = relatedConstraints;
	}
}
