/**
 * Generated from platform:/resource/eu.supersede.dynadapt.model/src/eu/supersede/dynadapt/model/query/test/atos_queries.vql
 */
package eu.supersede.dynadapt.model.query.test;

import eu.supersede.dynadapt.model.query.test.util.MaxThreadValuesInCMSConfigurationsQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the eu.supersede.dynadapt.model.query.test.maxThreadValuesInCMSConfigurations pattern,
 * to be used in conjunction with {@link MaxThreadValuesInCMSConfigurationsMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see MaxThreadValuesInCMSConfigurationsMatcher
 * @see MaxThreadValuesInCMSConfigurationsProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class MaxThreadValuesInCMSConfigurationsMatch extends BasePatternMatch {
  private InstanceSpecification fConfiguration;
  
  private String fName;
  
  private Integer fValue;
  
  private static List<String> parameterNames = makeImmutableList("configuration", "name", "value");
  
  private MaxThreadValuesInCMSConfigurationsMatch(final InstanceSpecification pConfiguration, final String pName, final Integer pValue) {
    this.fConfiguration = pConfiguration;
    this.fName = pName;
    this.fValue = pValue;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("configuration".equals(parameterName)) return this.fConfiguration;
    if ("name".equals(parameterName)) return this.fName;
    if ("value".equals(parameterName)) return this.fValue;
    return null;
  }
  
  public InstanceSpecification getConfiguration() {
    return this.fConfiguration;
  }
  
  public String getName() {
    return this.fName;
  }
  
  public Integer getValue() {
    return this.fValue;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("configuration".equals(parameterName) ) {
    	this.fConfiguration = (InstanceSpecification) newValue;
    	return true;
    }
    if ("name".equals(parameterName) ) {
    	this.fName = (String) newValue;
    	return true;
    }
    if ("value".equals(parameterName) ) {
    	this.fValue = (Integer) newValue;
    	return true;
    }
    return false;
  }
  
  public void setConfiguration(final InstanceSpecification pConfiguration) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fConfiguration = pConfiguration;
  }
  
  public void setName(final String pName) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fName = pName;
  }
  
  public void setValue(final Integer pValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fValue = pValue;
  }
  
  @Override
  public String patternName() {
    return "eu.supersede.dynadapt.model.query.test.maxThreadValuesInCMSConfigurations";
  }
  
  @Override
  public List<String> parameterNames() {
    return MaxThreadValuesInCMSConfigurationsMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fConfiguration, fName, fValue};
  }
  
  @Override
  public MaxThreadValuesInCMSConfigurationsMatch toImmutable() {
    return isMutable() ? newMatch(fConfiguration, fName, fValue) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"configuration\"=" + prettyPrintValue(fConfiguration) + ", ");
    
    result.append("\"name\"=" + prettyPrintValue(fName) + ", ");
    
    result.append("\"value\"=" + prettyPrintValue(fValue)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fConfiguration == null) ? 0 : fConfiguration.hashCode());
    result = prime * result + ((fName == null) ? 0 : fName.hashCode());
    result = prime * result + ((fValue == null) ? 0 : fValue.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof MaxThreadValuesInCMSConfigurationsMatch)) { // this should be infrequent
    	if (obj == null) {
    		return false;
    	}
    	if (!(obj instanceof IPatternMatch)) {
    		return false;
    	}
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    MaxThreadValuesInCMSConfigurationsMatch other = (MaxThreadValuesInCMSConfigurationsMatch) obj;
    if (fConfiguration == null) {if (other.fConfiguration != null) return false;}
    else if (!fConfiguration.equals(other.fConfiguration)) return false;
    if (fName == null) {if (other.fName != null) return false;}
    else if (!fName.equals(other.fName)) return false;
    if (fValue == null) {if (other.fValue != null) return false;}
    else if (!fValue.equals(other.fValue)) return false;
    return true;
  }
  
  @Override
  public MaxThreadValuesInCMSConfigurationsQuerySpecification specification() {
    try {
    	return MaxThreadValuesInCMSConfigurationsQuerySpecification.instance();
    } catch (ViatraQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException (ex);
    }
  }
  
  /**
   * Returns an empty, mutable match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @return the empty match.
   * 
   */
  public static MaxThreadValuesInCMSConfigurationsMatch newEmptyMatch() {
    return new Mutable(null, null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pConfiguration the fixed value of pattern parameter configuration, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @param pValue the fixed value of pattern parameter value, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static MaxThreadValuesInCMSConfigurationsMatch newMutableMatch(final InstanceSpecification pConfiguration, final String pName, final Integer pValue) {
    return new Mutable(pConfiguration, pName, pValue);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pConfiguration the fixed value of pattern parameter configuration, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @param pValue the fixed value of pattern parameter value, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static MaxThreadValuesInCMSConfigurationsMatch newMatch(final InstanceSpecification pConfiguration, final String pName, final Integer pValue) {
    return new Immutable(pConfiguration, pName, pValue);
  }
  
  private static final class Mutable extends MaxThreadValuesInCMSConfigurationsMatch {
    Mutable(final InstanceSpecification pConfiguration, final String pName, final Integer pValue) {
      super(pConfiguration, pName, pValue);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends MaxThreadValuesInCMSConfigurationsMatch {
    Immutable(final InstanceSpecification pConfiguration, final String pName, final Integer pValue) {
      super(pConfiguration, pName, pValue);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
