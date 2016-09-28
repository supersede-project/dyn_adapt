/**
 * 
 */
package eu.supersede.dm.util;

import eu.supersede.dm.util.FeatureAttribute.Aggregators;

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
}
