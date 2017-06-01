/**
 * Generated from platform:/resource/eu.supersede.dynadapt.adapter/repository/patterns/eu/supersede/dynadapt/usecases/atos/patterns/atos_query_patterns.vql
 */
package eu.supersede.dynadapt.usecases.atos.patterns;

import eu.supersede.dynadapt.usecases.atos.patterns.util.InstanceSpecificationLinkQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the eu.supersede.dynadapt.usecases.atos.patterns.InstanceSpecificationLink pattern,
 * to be used in conjunction with {@link InstanceSpecificationLinkMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see InstanceSpecificationLinkMatcher
 * @see InstanceSpecificationLinkProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class InstanceSpecificationLinkMatch extends BasePatternMatch {
  private InstanceSpecification fLink;
  
  private static List<String> parameterNames = makeImmutableList("link");
  
  private InstanceSpecificationLinkMatch(final InstanceSpecification pLink) {
    this.fLink = pLink;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("link".equals(parameterName)) return this.fLink;
    return null;
  }
  
  public InstanceSpecification getLink() {
    return this.fLink;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("link".equals(parameterName) ) {
    	this.fLink = (InstanceSpecification) newValue;
    	return true;
    }
    return false;
  }
  
  public void setLink(final InstanceSpecification pLink) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fLink = pLink;
  }
  
  @Override
  public String patternName() {
    return "eu.supersede.dynadapt.usecases.atos.patterns.InstanceSpecificationLink";
  }
  
  @Override
  public List<String> parameterNames() {
    return InstanceSpecificationLinkMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fLink};
  }
  
  @Override
  public InstanceSpecificationLinkMatch toImmutable() {
    return isMutable() ? newMatch(fLink) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"link\"=" + prettyPrintValue(fLink)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fLink == null) ? 0 : fLink.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof InstanceSpecificationLinkMatch)) { // this should be infrequent
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
    InstanceSpecificationLinkMatch other = (InstanceSpecificationLinkMatch) obj;
    if (fLink == null) {if (other.fLink != null) return false;}
    else if (!fLink.equals(other.fLink)) return false;
    return true;
  }
  
  @Override
  public InstanceSpecificationLinkQuerySpecification specification() {
    try {
    	return InstanceSpecificationLinkQuerySpecification.instance();
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
  public static InstanceSpecificationLinkMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pLink the fixed value of pattern parameter link, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static InstanceSpecificationLinkMatch newMutableMatch(final InstanceSpecification pLink) {
    return new Mutable(pLink);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pLink the fixed value of pattern parameter link, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static InstanceSpecificationLinkMatch newMatch(final InstanceSpecification pLink) {
    return new Immutable(pLink);
  }
  
  private static final class Mutable extends InstanceSpecificationLinkMatch {
    Mutable(final InstanceSpecification pLink) {
      super(pLink);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends InstanceSpecificationLinkMatch {
    Immutable(final InstanceSpecification pLink) {
      super(pLink);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
