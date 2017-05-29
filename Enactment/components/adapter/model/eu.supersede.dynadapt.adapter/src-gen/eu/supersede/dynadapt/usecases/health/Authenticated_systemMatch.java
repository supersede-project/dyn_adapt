/**
 * Generated from platform:/resource/eu.supersede.dynadapt.adapter/repository/patterns/eu/supersede/dynadapt/usecases/health/health.vql
 */
package eu.supersede.dynadapt.usecases.health;

import eu.supersede.dynadapt.usecases.health.util.Authenticated_systemQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the eu.supersede.dynadapt.usecases.health.authenticated_system pattern,
 * to be used in conjunction with {@link Authenticated_systemMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see Authenticated_systemMatcher
 * @see Authenticated_systemProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class Authenticated_systemMatch extends BasePatternMatch {
  private org.eclipse.uml2.uml.Class fClass;
  
  private static List<String> parameterNames = makeImmutableList("class");
  
  private Authenticated_systemMatch(final org.eclipse.uml2.uml.Class pClass) {
    this.fClass = pClass;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("class".equals(parameterName)) return this.fClass;
    return null;
  }
  
  public org.eclipse.uml2.uml.Class getValueOfClass() {
    return this.fClass;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("class".equals(parameterName) ) {
    	this.fClass = (org.eclipse.uml2.uml.Class) newValue;
    	return true;
    }
    return false;
  }
  
  public void setClass(final org.eclipse.uml2.uml.Class pClass) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fClass = pClass;
  }
  
  @Override
  public String patternName() {
    return "eu.supersede.dynadapt.usecases.health.authenticated_system";
  }
  
  @Override
  public List<String> parameterNames() {
    return Authenticated_systemMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fClass};
  }
  
  @Override
  public Authenticated_systemMatch toImmutable() {
    return isMutable() ? newMatch(fClass) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"class\"=" + prettyPrintValue(fClass)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fClass == null) ? 0 : fClass.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof Authenticated_systemMatch)) { // this should be infrequent
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
    Authenticated_systemMatch other = (Authenticated_systemMatch) obj;
    if (fClass == null) {if (other.fClass != null) return false;}
    else if (!fClass.equals(other.fClass)) return false;
    return true;
  }
  
  @Override
  public Authenticated_systemQuerySpecification specification() {
    try {
    	return Authenticated_systemQuerySpecification.instance();
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
  public static Authenticated_systemMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pClass the fixed value of pattern parameter class, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static Authenticated_systemMatch newMutableMatch(final org.eclipse.uml2.uml.Class pClass) {
    return new Mutable(pClass);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pClass the fixed value of pattern parameter class, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static Authenticated_systemMatch newMatch(final org.eclipse.uml2.uml.Class pClass) {
    return new Immutable(pClass);
  }
  
  private static final class Mutable extends Authenticated_systemMatch {
    Mutable(final org.eclipse.uml2.uml.Class pClass) {
      super(pClass);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends Authenticated_systemMatch {
    Immutable(final org.eclipse.uml2.uml.Class pClass) {
      super(pClass);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
