/**
 * Generated from platform:/resource/eu.supersede.dynadapt.adapter/repository/patterns/eu/supersede/dynadapt/usecases/health/health.vql
 */
package eu.supersede.dynadapt.usecases.health;

import eu.supersede.dynadapt.usecases.health.util.Authenticated_userQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the eu.supersede.dynadapt.usecases.health.authenticated_user pattern,
 * to be used in conjunction with {@link Authenticated_userMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see Authenticated_userMatcher
 * @see Authenticated_userProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class Authenticated_userMatch extends BasePatternMatch {
  private org.eclipse.uml2.uml.Class fUser;
  
  private static List<String> parameterNames = makeImmutableList("user");
  
  private Authenticated_userMatch(final org.eclipse.uml2.uml.Class pUser) {
    this.fUser = pUser;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("user".equals(parameterName)) return this.fUser;
    return null;
  }
  
  public org.eclipse.uml2.uml.Class getUser() {
    return this.fUser;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("user".equals(parameterName) ) {
    	this.fUser = (org.eclipse.uml2.uml.Class) newValue;
    	return true;
    }
    return false;
  }
  
  public void setUser(final org.eclipse.uml2.uml.Class pUser) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fUser = pUser;
  }
  
  @Override
  public String patternName() {
    return "eu.supersede.dynadapt.usecases.health.authenticated_user";
  }
  
  @Override
  public List<String> parameterNames() {
    return Authenticated_userMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fUser};
  }
  
  @Override
  public Authenticated_userMatch toImmutable() {
    return isMutable() ? newMatch(fUser) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"user\"=" + prettyPrintValue(fUser)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fUser == null) ? 0 : fUser.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof Authenticated_userMatch)) { // this should be infrequent
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
    Authenticated_userMatch other = (Authenticated_userMatch) obj;
    if (fUser == null) {if (other.fUser != null) return false;}
    else if (!fUser.equals(other.fUser)) return false;
    return true;
  }
  
  @Override
  public Authenticated_userQuerySpecification specification() {
    try {
    	return Authenticated_userQuerySpecification.instance();
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
  public static Authenticated_userMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pUser the fixed value of pattern parameter user, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static Authenticated_userMatch newMutableMatch(final org.eclipse.uml2.uml.Class pUser) {
    return new Mutable(pUser);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pUser the fixed value of pattern parameter user, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static Authenticated_userMatch newMatch(final org.eclipse.uml2.uml.Class pUser) {
    return new Immutable(pUser);
  }
  
  private static final class Mutable extends Authenticated_userMatch {
    Mutable(final org.eclipse.uml2.uml.Class pUser) {
      super(pUser);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends Authenticated_userMatch {
    Immutable(final org.eclipse.uml2.uml.Class pUser) {
      super(pUser);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
