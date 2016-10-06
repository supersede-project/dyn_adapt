/*******************************************************************************
 * Copyright (c) 2016 UPC
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
