/**
 * Generated from platform:/resource/eu.supersede.dynadapt.modeladapter-stamp/src/main/java/eu/supersede/dynadapt/modeladapter/queries/model_adapter.vql
 */
package eu.supersede.dynadapt.modeladapter.queries;

import eu.supersede.dynadapt.modeladapter.queries.util.ReferencesToTypeQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.uml2.uml.Element;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the eu.supersede.dynadapt.modeladapter.queries.referencesToType pattern,
 * to be used in conjunction with {@link ReferencesToTypeMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ReferencesToTypeMatcher
 * @see ReferencesToTypeProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ReferencesToTypeMatch extends BasePatternMatch {
  private Element fElement;
  
  private org.eclipse.uml2.uml.Class fType;
  
  private static List<String> parameterNames = makeImmutableList("element", "type");
  
  private ReferencesToTypeMatch(final Element pElement, final org.eclipse.uml2.uml.Class pType) {
    this.fElement = pElement;
    this.fType = pType;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("element".equals(parameterName)) return this.fElement;
    if ("type".equals(parameterName)) return this.fType;
    return null;
  }
  
  public Element getElement() {
    return this.fElement;
  }
  
  public org.eclipse.uml2.uml.Class getType() {
    return this.fType;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("element".equals(parameterName) ) {
        this.fElement = (Element) newValue;
        return true;
    }
    if ("type".equals(parameterName) ) {
        this.fType = (org.eclipse.uml2.uml.Class) newValue;
        return true;
    }
    return false;
  }
  
  public void setElement(final Element pElement) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fElement = pElement;
  }
  
  public void setType(final org.eclipse.uml2.uml.Class pType) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fType = pType;
  }
  
  @Override
  public String patternName() {
    return "eu.supersede.dynadapt.modeladapter.queries.referencesToType";
  }
  
  @Override
  public List<String> parameterNames() {
    return ReferencesToTypeMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fElement, fType};
  }
  
  @Override
  public ReferencesToTypeMatch toImmutable() {
    return isMutable() ? newMatch(fElement, fType) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"element\"=" + prettyPrintValue(fElement) + ", ");
    
    result.append("\"type\"=" + prettyPrintValue(fType)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fElement == null) ? 0 : fElement.hashCode());
    result = prime * result + ((fType == null) ? 0 : fType.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
        return true;
    if (!(obj instanceof ReferencesToTypeMatch)) { // this should be infrequent
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
    ReferencesToTypeMatch other = (ReferencesToTypeMatch) obj;
    if (fElement == null) {if (other.fElement != null) return false;}
    else if (!fElement.equals(other.fElement)) return false;
    if (fType == null) {if (other.fType != null) return false;}
    else if (!fType.equals(other.fType)) return false;
    return true;
  }
  
  @Override
  public ReferencesToTypeQuerySpecification specification() {
    try {
        return ReferencesToTypeQuerySpecification.instance();
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
  public static ReferencesToTypeMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pElement the fixed value of pattern parameter element, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ReferencesToTypeMatch newMutableMatch(final Element pElement, final org.eclipse.uml2.uml.Class pType) {
    return new Mutable(pElement, pType);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pElement the fixed value of pattern parameter element, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ReferencesToTypeMatch newMatch(final Element pElement, final org.eclipse.uml2.uml.Class pType) {
    return new Immutable(pElement, pType);
  }
  
  private static final class Mutable extends ReferencesToTypeMatch {
    Mutable(final Element pElement, final org.eclipse.uml2.uml.Class pType) {
      super(pElement, pType);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ReferencesToTypeMatch {
    Immutable(final Element pElement, final org.eclipse.uml2.uml.Class pType) {
      super(pElement, pType);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
