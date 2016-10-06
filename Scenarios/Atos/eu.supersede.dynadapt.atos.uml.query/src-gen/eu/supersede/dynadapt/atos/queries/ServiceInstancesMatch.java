/**
 * Generated from platform:/resource/eu.supersede.dynadapt.atos.uml.query/src/eu/supersede/dynadapt/atos/queries/atos_queries.vql
 */
package eu.supersede.dynadapt.atos.queries;

import eu.supersede.dynadapt.atos.queries.util.ServiceInstancesQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.uml2.uml.Artifact;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the eu.supersede.dynadapt.atos.queries.serviceInstances pattern,
 * to be used in conjunction with {@link ServiceInstancesMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ServiceInstancesMatcher
 * @see ServiceInstancesProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ServiceInstancesMatch extends BasePatternMatch {
  private Artifact fService;
  
  private NamedElement fInstance;
  
  private static List<String> parameterNames = makeImmutableList("service", "instance");
  
  private ServiceInstancesMatch(final Artifact pService, final NamedElement pInstance) {
    this.fService = pService;
    this.fInstance = pInstance;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("service".equals(parameterName)) return this.fService;
    if ("instance".equals(parameterName)) return this.fInstance;
    return null;
  }
  
  public Artifact getService() {
    return this.fService;
  }
  
  public NamedElement getInstance() {
    return this.fInstance;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("service".equals(parameterName) ) {
    	this.fService = (Artifact) newValue;
    	return true;
    }
    if ("instance".equals(parameterName) ) {
    	this.fInstance = (NamedElement) newValue;
    	return true;
    }
    return false;
  }
  
  public void setService(final Artifact pService) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fService = pService;
  }
  
  public void setInstance(final NamedElement pInstance) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fInstance = pInstance;
  }
  
  @Override
  public String patternName() {
    return "eu.supersede.dynadapt.atos.queries.serviceInstances";
  }
  
  @Override
  public List<String> parameterNames() {
    return ServiceInstancesMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fService, fInstance};
  }
  
  @Override
  public ServiceInstancesMatch toImmutable() {
    return isMutable() ? newMatch(fService, fInstance) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"service\"=" + prettyPrintValue(fService) + ", ");
    
    result.append("\"instance\"=" + prettyPrintValue(fInstance)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fService == null) ? 0 : fService.hashCode());
    result = prime * result + ((fInstance == null) ? 0 : fInstance.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ServiceInstancesMatch)) { // this should be infrequent
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
    ServiceInstancesMatch other = (ServiceInstancesMatch) obj;
    if (fService == null) {if (other.fService != null) return false;}
    else if (!fService.equals(other.fService)) return false;
    if (fInstance == null) {if (other.fInstance != null) return false;}
    else if (!fInstance.equals(other.fInstance)) return false;
    return true;
  }
  
  @Override
  public ServiceInstancesQuerySpecification specification() {
    try {
    	return ServiceInstancesQuerySpecification.instance();
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
  public static ServiceInstancesMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pService the fixed value of pattern parameter service, or null if not bound.
   * @param pInstance the fixed value of pattern parameter instance, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ServiceInstancesMatch newMutableMatch(final Artifact pService, final NamedElement pInstance) {
    return new Mutable(pService, pInstance);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pService the fixed value of pattern parameter service, or null if not bound.
   * @param pInstance the fixed value of pattern parameter instance, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ServiceInstancesMatch newMatch(final Artifact pService, final NamedElement pInstance) {
    return new Immutable(pService, pInstance);
  }
  
  private static final class Mutable extends ServiceInstancesMatch {
    Mutable(final Artifact pService, final NamedElement pInstance) {
      super(pService, pInstance);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ServiceInstancesMatch {
    Immutable(final Artifact pService, final NamedElement pInstance) {
      super(pService, pInstance);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
