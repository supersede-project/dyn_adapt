/**
 * Generated from platform:/resource/eu.supersede.dynadapt.model/src/eu/supersede/dynadapt/model/query/test/atos_queries.vql
 */
package eu.supersede.dynadapt.model.query.test;

import eu.supersede.dynadapt.model.query.test.util.ServicesQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.uml2.uml.Artifact;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the eu.supersede.dynadapt.model.query.test.services pattern,
 * to be used in conjunction with {@link ServicesMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ServicesMatcher
 * @see ServicesProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ServicesMatch extends BasePatternMatch {
  private Artifact fService;
  
  private static List<String> parameterNames = makeImmutableList("service");
  
  private ServicesMatch(final Artifact pService) {
    this.fService = pService;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("service".equals(parameterName)) return this.fService;
    return null;
  }
  
  public Artifact getService() {
    return this.fService;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("service".equals(parameterName) ) {
    	this.fService = (Artifact) newValue;
    	return true;
    }
    return false;
  }
  
  public void setService(final Artifact pService) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fService = pService;
  }
  
  @Override
  public String patternName() {
    return "eu.supersede.dynadapt.model.query.test.services";
  }
  
  @Override
  public List<String> parameterNames() {
    return ServicesMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fService};
  }
  
  @Override
  public ServicesMatch toImmutable() {
    return isMutable() ? newMatch(fService) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"service\"=" + prettyPrintValue(fService)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fService == null) ? 0 : fService.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ServicesMatch)) { // this should be infrequent
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
    ServicesMatch other = (ServicesMatch) obj;
    if (fService == null) {if (other.fService != null) return false;}
    else if (!fService.equals(other.fService)) return false;
    return true;
  }
  
  @Override
  public ServicesQuerySpecification specification() {
    try {
    	return ServicesQuerySpecification.instance();
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
  public static ServicesMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pService the fixed value of pattern parameter service, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ServicesMatch newMutableMatch(final Artifact pService) {
    return new Mutable(pService);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pService the fixed value of pattern parameter service, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ServicesMatch newMatch(final Artifact pService) {
    return new Immutable(pService);
  }
  
  private static final class Mutable extends ServicesMatch {
    Mutable(final Artifact pService) {
      super(pService);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ServicesMatch {
    Immutable(final Artifact pService) {
      super(pService);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
