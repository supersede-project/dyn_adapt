package eu.supersede.dynadapt.featuremodel.feature;

import java.util.List;

import cz.zcu.yafmt.model.fm.Attribute;
import cz.zcu.yafmt.model.fm.Constraint;
import cz.zcu.yafmt.model.fm.Feature;

public class FeatureSUPERSEDE implements IFeatureSUPERSEDE{

	private String name;
	private List<Feature> children;
	private Feature parent;
	private List<Feature> siblings;
	private List<Attribute> attributes;
	private List<Constraint> constraints;
	
		
	public FeatureSUPERSEDE(String name, List<Feature> children, Feature parent, List<Feature> siblings, List<Attribute> attributes,
			List<Constraint> constraints) {
		super();
		this.name = name;
		this.children = children;
		this.parent = parent;
		this.siblings = siblings;
		this.attributes = attributes;
		this.constraints = constraints;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Feature> getChildren() {
		return children;
	}
	public void setChildren(List<Feature> children) {
		this.children = children;
	}
	public Feature getParent() {
		return parent;
	}
	public void setParent(Feature parent) {
		this.parent = parent;
	}
	public List<Feature> getSiblings() {
		return siblings;
	}
	public void setSiblings(List<Feature> siblings) {
		this.siblings = siblings;
	}
	public List<Attribute> getAttributes() {
		return attributes;
	}
	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}
	public List<Constraint> getConstraints() {
		return constraints;
	}
	public void setConstraints(List<Constraint> constraints) {
		this.constraints = constraints;
	}
}
