/**
 * Generated from platform:/resource/eu.supersede.dynadapt.atos.uml.query/src/eu/supersede/dynadapt/atos/queries/atos_queries.vql
 */
package eu.supersede.dynadapt.atos.queries;

import eu.supersede.dynadapt.atos.queries.util.CMSConfigurationInstancesQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the eu.supersede.dynadapt.atos.queries.CMSConfigurationInstances pattern,
 * to be used in conjunction with {@link CMSConfigurationInstancesMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see CMSConfigurationInstancesMatcher
 * @see CMSConfigurationInstancesProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class CMSConfigurationInstancesMatch extends BasePatternMatch {
  private InstanceSpecification fConfiguration;
  
  private static List<String> parameterNames = makeImmutableList("configuration");
  
  private CMSConfigurationInstancesMatch(final InstanceSpecification pConfiguration) {
    this.fConfiguration = pConfiguration;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("configuration".equals(parameterName)) return this.fConfiguration;
    return null;
  }
  
  public InstanceSpecification getConfiguration() {
    return this.fConfiguration;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("configuration".equals(parameterName) ) {
    	this.fConfiguration = (InstanceSpecification) newValue;
    	return true;
    }
    return false;
  }
  
  public void setConfiguration(final InstanceSpecification pConfiguration) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fConfiguration = pConfiguration;
  }
  
  @Override
  public String patternName() {
    return "eu.supersede.dynadapt.atos.queries.CMSConfigurationInstances";
  }
  
  @Override
  public List<String> parameterNames() {
    return CMSConfigurationInstancesMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fConfiguration};
  }
  
  @Override
  public CMSConfigurationInstancesMatch toImmutable() {
    return isMutable() ? newMatch(fConfiguration) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"configuration\"=" + prettyPrintValue(fConfiguration)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fConfiguration == null) ? 0 : fConfiguration.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof CMSConfigurationInstancesMatch)) { // this should be infrequent
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
    CMSConfigurationInstancesMatch other = (CMSConfigurationInstancesMatch) obj;
    if (fConfiguration == null) {if (other.fConfiguration != null) return false;}
    else if (!fConfiguration.equals(other.fConfiguration)) return false;
    return true;
  }
  
  @Override
  public CMSConfigurationInstancesQuerySpecification specification() {
    try {
    	return CMSConfigurationInstancesQuerySpecification.instance();
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
  public static CMSConfigurationInstancesMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pConfiguration the fixed value of pattern parameter configuration, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static CMSConfigurationInstancesMatch newMutableMatch(final InstanceSpecification pConfiguration) {
    return new Mutable(pConfiguration);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pConfiguration the fixed value of pattern parameter configuration, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static CMSConfigurationInstancesMatch newMatch(final InstanceSpecification pConfiguration) {
    return new Immutable(pConfiguration);
  }
  
  private static final class Mutable extends CMSConfigurationInstancesMatch {
    Mutable(final InstanceSpecification pConfiguration) {
      super(pConfiguration);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends CMSConfigurationInstancesMatch {
    Immutable(final InstanceSpecification pConfiguration) {
      super(pConfiguration);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
