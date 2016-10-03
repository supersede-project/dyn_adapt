/**
 * 
 */
package eu.supersede.dm.util;

/**
 * @author fitsum
 *
 */
public class FeatureAttribute {
	private String name;
	private double value;
	private boolean minimize;
	private Class domain;
	
	private Aggregators aggregator;
	
	public enum Aggregators{
		sum, product, min, max
	}
	
	public enum Optimization{
		min, max
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getValue() {
		return value;
	}
	
	public void setValue(double value) {
		this.value = value;
	}
	public boolean isMinimize() {
		return minimize;
	}
	public void setMinimize(boolean min) {
		this.minimize = min;
	}
	public Class getDomain() {
		return domain;
	}
	public void setDomain(Class domain) {
		this.domain = domain;
	}
	public Aggregators getAggregator() {
		return aggregator;
	}
	public void setAggregator(Aggregators aggregator) {
		this.aggregator = aggregator;
	}
}
