/*******************************************************************************
 * Copyright (c) 2016 FBK
 * All rights reserved. Licensed under the Apache License, Version 2.0 (the "License");
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
 *     Fitsum Kifetew (FBK) - main development
 *
 * Initially developed in the context of SUPERSEDE EU project www.supersede.eu
 *******************************************************************************/
/**
 * 
 */
package eu.supersede.dynadapt.dm.util;


/**
 * @author fitsum
 *
 */
public class FeatureAttributeMetadata {
	private String name;
	private Class domain;
	private double minimumValue;
	private double maximumValue;
	private double weight;
	private boolean minimize;
	private boolean alert;
	
	private Aggregators aggregator;
	
	public enum Aggregators{
		sum, product, min, max
	}
	
	public String getName() {
		return name;
	}
	public void setName(String attributeName) {
		this.name = attributeName;
	}
	public Class getDomain() {
		return domain;
	}
	public void setDomain(Class domain) {
		this.domain = domain;
	}
	public double getMinimumValue() {
		return minimumValue;
	}
	public void setMinimumValue(double minimumValue) {
		this.minimumValue = minimumValue;
	}
	public double getMaximumValue() {
		return maximumValue;
	}
	public void setMaximumValue(double maximumValue) {
		this.maximumValue = maximumValue;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public boolean isMinimize() {
		return minimize;
	}
	public void setMinimize(boolean minimize) {
		this.minimize = minimize;
	}
	public Aggregators getAggregator() {
		return aggregator;
	}
	public void setAggregator(Aggregators aggregator) {
		this.aggregator = aggregator;
	}
	public boolean isAlert() {
		return alert;
	}
	public void setAlert(boolean alert) {
		this.alert = alert;
	}
}
