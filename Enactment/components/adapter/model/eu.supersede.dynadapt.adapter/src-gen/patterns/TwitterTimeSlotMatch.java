/**
 * Generated from platform:/resource/eu.supersede.dynadapt.adapter/repository/patterns/eu/supersede/dynadapt/usecases/monitoring/patterns/monitoring_reconfiguration_queries.vql
 */
package patterns;

import java.util.Arrays;
import java.util.List;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import patterns.util.TwitterTimeSlotQuerySpecification;

/**
 * Pattern-specific match representation of the patterns.twitterTimeSlot pattern,
 * to be used in conjunction with {@link TwitterTimeSlotMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see TwitterTimeSlotMatcher
 * @see TwitterTimeSlotProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class TwitterTimeSlotMatch extends BasePatternMatch {
  private Slot fSlot;
  
  private static List<String> parameterNames = makeImmutableList("slot");
  
  private TwitterTimeSlotMatch(final Slot pSlot) {
    this.fSlot = pSlot;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("slot".equals(parameterName)) return this.fSlot;
    return null;
  }
  
  public Slot getSlot() {
    return this.fSlot;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("slot".equals(parameterName) ) {
    	this.fSlot = (Slot) newValue;
    	return true;
    }
    return false;
  }
  
  public void setSlot(final Slot pSlot) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSlot = pSlot;
  }
  
  @Override
  public String patternName() {
    return "patterns.twitterTimeSlot";
  }
  
  @Override
  public List<String> parameterNames() {
    return TwitterTimeSlotMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fSlot};
  }
  
  @Override
  public TwitterTimeSlotMatch toImmutable() {
    return isMutable() ? newMatch(fSlot) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"slot\"=" + prettyPrintValue(fSlot)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fSlot == null) ? 0 : fSlot.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof TwitterTimeSlotMatch)) { // this should be infrequent
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
    TwitterTimeSlotMatch other = (TwitterTimeSlotMatch) obj;
    if (fSlot == null) {if (other.fSlot != null) return false;}
    else if (!fSlot.equals(other.fSlot)) return false;
    return true;
  }
  
  @Override
  public TwitterTimeSlotQuerySpecification specification() {
    try {
    	return TwitterTimeSlotQuerySpecification.instance();
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
  public static TwitterTimeSlotMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static TwitterTimeSlotMatch newMutableMatch(final Slot pSlot) {
    return new Mutable(pSlot);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static TwitterTimeSlotMatch newMatch(final Slot pSlot) {
    return new Immutable(pSlot);
  }
  
  private static final class Mutable extends TwitterTimeSlotMatch {
    Mutable(final Slot pSlot) {
      super(pSlot);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends TwitterTimeSlotMatch {
    Immutable(final Slot pSlot) {
      super(pSlot);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
