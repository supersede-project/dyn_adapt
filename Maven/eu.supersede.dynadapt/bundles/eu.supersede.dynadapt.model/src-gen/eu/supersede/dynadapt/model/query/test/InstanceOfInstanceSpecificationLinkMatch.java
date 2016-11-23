package eu.supersede.dynadapt.model.query.test;

import eu.supersede.dynadapt.model.query.test.util.InstanceOfInstanceSpecificationLinkQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the eu.supersede.dynadapt.model.query.test.InstanceOfInstanceSpecificationLink pattern,
 * to be used in conjunction with {@link InstanceOfInstanceSpecificationLinkMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see InstanceOfInstanceSpecificationLinkMatcher
 * @see InstanceOfInstanceSpecificationLinkProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class InstanceOfInstanceSpecificationLinkMatch extends BasePatternMatch {
  private InstanceSpecification fLink;
  
  private InstanceSpecification fInstance;
  
  private static List<String> parameterNames = makeImmutableList("link", "instance");
  
  private InstanceOfInstanceSpecificationLinkMatch(final InstanceSpecification pLink, final InstanceSpecification pInstance) {
    this.fLink = pLink;
    this.fInstance = pInstance;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("link".equals(parameterName)) return this.fLink;
    if ("instance".equals(parameterName)) return this.fInstance;
    return null;
  }
  
  public InstanceSpecification getLink() {
    return this.fLink;
  }
  
  public InstanceSpecification getInstance() {
    return this.fInstance;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("link".equals(parameterName) ) {
    	this.fLink = (InstanceSpecification) newValue;
    	return true;
    }
    if ("instance".equals(parameterName) ) {
    	this.fInstance = (InstanceSpecification) newValue;
    	return true;
    }
    return false;
  }
  
  public void setLink(final InstanceSpecification pLink) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fLink = pLink;
  }
  
  public void setInstance(final InstanceSpecification pInstance) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fInstance = pInstance;
  }
  
  @Override
  public String patternName() {
    return "eu.supersede.dynadapt.model.query.test.InstanceOfInstanceSpecificationLink";
  }
  
  @Override
  public List<String> parameterNames() {
    return InstanceOfInstanceSpecificationLinkMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fLink, fInstance};
  }
  
  @Override
  public InstanceOfInstanceSpecificationLinkMatch toImmutable() {
    return isMutable() ? newMatch(fLink, fInstance) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"link\"=" + prettyPrintValue(fLink) + ", ");
    
    result.append("\"instance\"=" + prettyPrintValue(fInstance)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fLink == null) ? 0 : fLink.hashCode());
    result = prime * result + ((fInstance == null) ? 0 : fInstance.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof InstanceOfInstanceSpecificationLinkMatch)) { // this should be infrequent
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
    InstanceOfInstanceSpecificationLinkMatch other = (InstanceOfInstanceSpecificationLinkMatch) obj;
    if (fLink == null) {if (other.fLink != null) return false;}
    else if (!fLink.equals(other.fLink)) return false;
    if (fInstance == null) {if (other.fInstance != null) return false;}
    else if (!fInstance.equals(other.fInstance)) return false;
    return true;
  }
  
  @Override
  public InstanceOfInstanceSpecificationLinkQuerySpecification specification() {
    try {
    	return InstanceOfInstanceSpecificationLinkQuerySpecification.instance();
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
  public static InstanceOfInstanceSpecificationLinkMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pLink the fixed value of pattern parameter link, or null if not bound.
   * @param pInstance the fixed value of pattern parameter instance, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static InstanceOfInstanceSpecificationLinkMatch newMutableMatch(final InstanceSpecification pLink, final InstanceSpecification pInstance) {
    return new Mutable(pLink, pInstance);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pLink the fixed value of pattern parameter link, or null if not bound.
   * @param pInstance the fixed value of pattern parameter instance, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static InstanceOfInstanceSpecificationLinkMatch newMatch(final InstanceSpecification pLink, final InstanceSpecification pInstance) {
    return new Immutable(pLink, pInstance);
  }
  
  private static final class Mutable extends InstanceOfInstanceSpecificationLinkMatch {
    Mutable(final InstanceSpecification pLink, final InstanceSpecification pInstance) {
      super(pLink, pInstance);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends InstanceOfInstanceSpecificationLinkMatch {
    Immutable(final InstanceSpecification pLink, final InstanceSpecification pInstance) {
      super(pLink, pInstance);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
