/**
 * Generated from platform:/resource/eu.supersede.dynadapt.adapter/repository/patterns/eu/supersede/dynadapt/usecases/patterns/atos_query_patterns.vql
 */
package eu.supersede.dynadapt.usecases.patterns;

import eu.supersede.dynadapt.usecases.patterns.util.VMInstancesContainingHSKServicesQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the eu.supersede.dynadapt.usecases.patterns.VMInstancesContainingHSKServices pattern,
 * to be used in conjunction with {@link VMInstancesContainingHSKServicesMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see VMInstancesContainingHSKServicesMatcher
 * @see VMInstancesContainingHSKServicesProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class VMInstancesContainingHSKServicesMatch extends BasePatternMatch {
  private InstanceSpecification fInstance;
  
  private static List<String> parameterNames = makeImmutableList("instance");
  
  private VMInstancesContainingHSKServicesMatch(final InstanceSpecification pInstance) {
    this.fInstance = pInstance;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("instance".equals(parameterName)) return this.fInstance;
    return null;
  }
  
  public InstanceSpecification getInstance() {
    return this.fInstance;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("instance".equals(parameterName) ) {
    	this.fInstance = (InstanceSpecification) newValue;
    	return true;
    }
    return false;
  }
  
  public void setInstance(final InstanceSpecification pInstance) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fInstance = pInstance;
  }
  
  @Override
  public String patternName() {
    return "eu.supersede.dynadapt.usecases.patterns.VMInstancesContainingHSKServices";
  }
  
  @Override
  public List<String> parameterNames() {
    return VMInstancesContainingHSKServicesMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fInstance};
  }
  
  @Override
  public VMInstancesContainingHSKServicesMatch toImmutable() {
    return isMutable() ? newMatch(fInstance) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"instance\"=" + prettyPrintValue(fInstance)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fInstance == null) ? 0 : fInstance.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof VMInstancesContainingHSKServicesMatch)) { // this should be infrequent
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
    VMInstancesContainingHSKServicesMatch other = (VMInstancesContainingHSKServicesMatch) obj;
    if (fInstance == null) {if (other.fInstance != null) return false;}
    else if (!fInstance.equals(other.fInstance)) return false;
    return true;
  }
  
  @Override
  public VMInstancesContainingHSKServicesQuerySpecification specification() {
    try {
    	return VMInstancesContainingHSKServicesQuerySpecification.instance();
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
  public static VMInstancesContainingHSKServicesMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pInstance the fixed value of pattern parameter instance, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static VMInstancesContainingHSKServicesMatch newMutableMatch(final InstanceSpecification pInstance) {
    return new Mutable(pInstance);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pInstance the fixed value of pattern parameter instance, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static VMInstancesContainingHSKServicesMatch newMatch(final InstanceSpecification pInstance) {
    return new Immutable(pInstance);
  }
  
  private static final class Mutable extends VMInstancesContainingHSKServicesMatch {
    Mutable(final InstanceSpecification pInstance) {
      super(pInstance);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends VMInstancesContainingHSKServicesMatch {
    Immutable(final InstanceSpecification pInstance) {
      super(pInstance);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
