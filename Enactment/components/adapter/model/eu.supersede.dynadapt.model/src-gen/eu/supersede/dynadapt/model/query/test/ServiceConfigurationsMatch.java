/**
 * Generated from platform:/resource/eu.supersede.dynadapt.model/src/eu/supersede/dynadapt/model/query/test/atos_queries.vql
 */
package eu.supersede.dynadapt.model.query.test;

import eu.supersede.dynadapt.model.query.test.util.ServiceConfigurationsQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the eu.supersede.dynadapt.model.query.test.serviceConfigurations pattern,
 * to be used in conjunction with {@link ServiceConfigurationsMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ServiceConfigurationsMatcher
 * @see ServiceConfigurationsProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ServiceConfigurationsMatch extends BasePatternMatch {
  private InstanceSpecification fService;
  
  private InstanceSpecification fConfiguration;
  
  private static List<String> parameterNames = makeImmutableList("service", "configuration");
  
  private ServiceConfigurationsMatch(final InstanceSpecification pService, final InstanceSpecification pConfiguration) {
    this.fService = pService;
    this.fConfiguration = pConfiguration;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("service".equals(parameterName)) return this.fService;
    if ("configuration".equals(parameterName)) return this.fConfiguration;
    return null;
  }
  
  public InstanceSpecification getService() {
    return this.fService;
  }
  
  public InstanceSpecification getConfiguration() {
    return this.fConfiguration;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("service".equals(parameterName) ) {
    	this.fService = (InstanceSpecification) newValue;
    	return true;
    }
    if ("configuration".equals(parameterName) ) {
    	this.fConfiguration = (InstanceSpecification) newValue;
    	return true;
    }
    return false;
  }
  
  public void setService(final InstanceSpecification pService) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fService = pService;
  }
  
  public void setConfiguration(final InstanceSpecification pConfiguration) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fConfiguration = pConfiguration;
  }
  
  @Override
  public String patternName() {
    return "eu.supersede.dynadapt.model.query.test.serviceConfigurations";
  }
  
  @Override
  public List<String> parameterNames() {
    return ServiceConfigurationsMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fService, fConfiguration};
  }
  
  @Override
  public ServiceConfigurationsMatch toImmutable() {
    return isMutable() ? newMatch(fService, fConfiguration) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"service\"=" + prettyPrintValue(fService) + ", ");
    
    result.append("\"configuration\"=" + prettyPrintValue(fConfiguration)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fService == null) ? 0 : fService.hashCode());
    result = prime * result + ((fConfiguration == null) ? 0 : fConfiguration.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ServiceConfigurationsMatch)) { // this should be infrequent
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
    ServiceConfigurationsMatch other = (ServiceConfigurationsMatch) obj;
    if (fService == null) {if (other.fService != null) return false;}
    else if (!fService.equals(other.fService)) return false;
    if (fConfiguration == null) {if (other.fConfiguration != null) return false;}
    else if (!fConfiguration.equals(other.fConfiguration)) return false;
    return true;
  }
  
  @Override
  public ServiceConfigurationsQuerySpecification specification() {
    try {
    	return ServiceConfigurationsQuerySpecification.instance();
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
  public static ServiceConfigurationsMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pService the fixed value of pattern parameter service, or null if not bound.
   * @param pConfiguration the fixed value of pattern parameter configuration, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ServiceConfigurationsMatch newMutableMatch(final InstanceSpecification pService, final InstanceSpecification pConfiguration) {
    return new Mutable(pService, pConfiguration);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pService the fixed value of pattern parameter service, or null if not bound.
   * @param pConfiguration the fixed value of pattern parameter configuration, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ServiceConfigurationsMatch newMatch(final InstanceSpecification pService, final InstanceSpecification pConfiguration) {
    return new Immutable(pService, pConfiguration);
  }
  
  private static final class Mutable extends ServiceConfigurationsMatch {
    Mutable(final InstanceSpecification pService, final InstanceSpecification pConfiguration) {
      super(pService, pConfiguration);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ServiceConfigurationsMatch {
    Immutable(final InstanceSpecification pService, final InstanceSpecification pConfiguration) {
      super(pService, pConfiguration);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
