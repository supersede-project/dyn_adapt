/**
 * Generated from platform:/resource/eu.supersede.dynadapt.adapter/repository/patterns/eu/supersede/dynadapt/usecases/patterns/siemens_queries.vql
 */
package eu.supersede.dynadapt.usecases.patterns;

import eu.supersede.dynadapt.usecases.patterns.util.GetMeteorologicalDataServicesQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the eu.supersede.dynadapt.usecases.patterns.GetMeteorologicalDataServices pattern,
 * to be used in conjunction with {@link GetMeteorologicalDataServicesMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see GetMeteorologicalDataServicesMatcher
 * @see GetMeteorologicalDataServicesProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class GetMeteorologicalDataServicesMatch extends BasePatternMatch {
  private CallBehaviorAction fAction;
  
  private static List<String> parameterNames = makeImmutableList("action");
  
  private GetMeteorologicalDataServicesMatch(final CallBehaviorAction pAction) {
    this.fAction = pAction;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("action".equals(parameterName)) return this.fAction;
    return null;
  }
  
  public CallBehaviorAction getAction() {
    return this.fAction;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("action".equals(parameterName) ) {
    	this.fAction = (CallBehaviorAction) newValue;
    	return true;
    }
    return false;
  }
  
  public void setAction(final CallBehaviorAction pAction) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fAction = pAction;
  }
  
  @Override
  public String patternName() {
    return "eu.supersede.dynadapt.usecases.patterns.GetMeteorologicalDataServices";
  }
  
  @Override
  public List<String> parameterNames() {
    return GetMeteorologicalDataServicesMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fAction};
  }
  
  @Override
  public GetMeteorologicalDataServicesMatch toImmutable() {
    return isMutable() ? newMatch(fAction) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"action\"=" + prettyPrintValue(fAction)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fAction == null) ? 0 : fAction.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof GetMeteorologicalDataServicesMatch)) { // this should be infrequent
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
    GetMeteorologicalDataServicesMatch other = (GetMeteorologicalDataServicesMatch) obj;
    if (fAction == null) {if (other.fAction != null) return false;}
    else if (!fAction.equals(other.fAction)) return false;
    return true;
  }
  
  @Override
  public GetMeteorologicalDataServicesQuerySpecification specification() {
    try {
    	return GetMeteorologicalDataServicesQuerySpecification.instance();
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
  public static GetMeteorologicalDataServicesMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pAction the fixed value of pattern parameter action, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static GetMeteorologicalDataServicesMatch newMutableMatch(final CallBehaviorAction pAction) {
    return new Mutable(pAction);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pAction the fixed value of pattern parameter action, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static GetMeteorologicalDataServicesMatch newMatch(final CallBehaviorAction pAction) {
    return new Immutable(pAction);
  }
  
  private static final class Mutable extends GetMeteorologicalDataServicesMatch {
    Mutable(final CallBehaviorAction pAction) {
      super(pAction);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends GetMeteorologicalDataServicesMatch {
    Immutable(final CallBehaviorAction pAction) {
      super(pAction);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
