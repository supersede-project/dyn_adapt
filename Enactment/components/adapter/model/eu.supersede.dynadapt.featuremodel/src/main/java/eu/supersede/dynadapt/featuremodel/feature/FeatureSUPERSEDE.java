package eu.supersede.dynadapt.featuremodel.feature;

import java.util.List;

import cz.zcu.yafmt.model.fm.Attribute;
import cz.zcu.yafmt.model.fm.Constraint;
import cz.zcu.yafmt.model.fm.Feature;

public class FeatureSUPERSEDE implements IFeatureSUPERSEDE{

	private String name;
	private String id;
	private List<FeatureSUPERSEDE> children;
	private FeatureSUPERSEDE parent;
	private List<FeatureSUPERSEDE> siblings;
	private List<Attribute> attributes;
	private List<Constraint> constraints;
	
		
	public FeatureSUPERSEDE(String id, String name, List<FeatureSUPERSEDE> children, FeatureSUPERSEDE parent, List<FeatureSUPERSEDE> siblings, List<Attribute> attributes,
			List<Constraint> constraints) {
		super();
		this.name = name;
		this.id = id;
		this.children = children;
		this.parent = parent;
		this.siblings = siblings;
		this.attributes = attributes;
		this.constraints = constraints;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<FeatureSUPERSEDE> getChildren() {
		return children;
	}
	public void setChildren(List<FeatureSUPERSEDE> children) {
		this.children = children;
	}
	public FeatureSUPERSEDE getParent() {
		return parent;
	}
	public void setParent(FeatureSUPERSEDE parent) {
		this.parent = parent;
	}
	public List<FeatureSUPERSEDE> getSiblings() {
		return siblings;
	}
	public void setSiblings(List<FeatureSUPERSEDE> siblings) {
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
