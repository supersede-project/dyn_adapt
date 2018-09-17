/**
 * Generated from platform:/resource/eu.supersede.dynadapt.modeladapter-stamp/src/main/java/eu/supersede/dynadapt/modeladapter/queries/model_adapter.vql
 */
package eu.supersede.dynadapt.modeladapter.queries;

import eu.supersede.dynadapt.modeladapter.queries.util.SubClassOfQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the eu.supersede.dynadapt.modeladapter.queries.subClassOf pattern,
 * to be used in conjunction with {@link SubClassOfMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see SubClassOfMatcher
 * @see SubClassOfProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class SubClassOfMatch extends BasePatternMatch {
  private Classifier fSubclass;
  
  private org.eclipse.uml2.uml.Class fSuperclass;
  
  private static List<String> parameterNames = makeImmutableList("subclass", "superclass");
  
  private SubClassOfMatch(final Classifier pSubclass, final org.eclipse.uml2.uml.Class pSuperclass) {
    this.fSubclass = pSubclass;
    this.fSuperclass = pSuperclass;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("subclass".equals(parameterName)) return this.fSubclass;
    if ("superclass".equals(parameterName)) return this.fSuperclass;
    return null;
  }
  
  public Classifier getSubclass() {
    return this.fSubclass;
  }
  
  public org.eclipse.uml2.uml.Class getSuperclass() {
    return this.fSuperclass;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("subclass".equals(parameterName) ) {
        this.fSubclass = (Classifier) newValue;
        return true;
    }
    if ("superclass".equals(parameterName) ) {
        this.fSuperclass = (org.eclipse.uml2.uml.Class) newValue;
        return true;
    }
    return false;
  }
  
  public void setSubclass(final Classifier pSubclass) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSubclass = pSubclass;
  }
  
  public void setSuperclass(final org.eclipse.uml2.uml.Class pSuperclass) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSuperclass = pSuperclass;
  }
  
  @Override
  public String patternName() {
    return "eu.supersede.dynadapt.modeladapter.queries.subClassOf";
  }
  
  @Override
  public List<String> parameterNames() {
    return SubClassOfMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fSubclass, fSuperclass};
  }
  
  @Override
  public SubClassOfMatch toImmutable() {
    return isMutable() ? newMatch(fSubclass, fSuperclass) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"subclass\"=" + prettyPrintValue(fSubclass) + ", ");
    
    result.append("\"superclass\"=" + prettyPrintValue(fSuperclass)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fSubclass == null) ? 0 : fSubclass.hashCode());
    result = prime * result + ((fSuperclass == null) ? 0 : fSuperclass.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
        return true;
    if (!(obj instanceof SubClassOfMatch)) { // this should be infrequent
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
    SubClassOfMatch other = (SubClassOfMatch) obj;
    if (fSubclass == null) {if (other.fSubclass != null) return false;}
    else if (!fSubclass.equals(other.fSubclass)) return false;
    if (fSuperclass == null) {if (other.fSuperclass != null) return false;}
    else if (!fSuperclass.equals(other.fSuperclass)) return false;
    return true;
  }
  
  @Override
  public SubClassOfQuerySpecification specification() {
    try {
        return SubClassOfQuerySpecification.instance();
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
  public static SubClassOfMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pSubclass the fixed value of pattern parameter subclass, or null if not bound.
   * @param pSuperclass the fixed value of pattern parameter superclass, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static SubClassOfMatch newMutableMatch(final Classifier pSubclass, final org.eclipse.uml2.uml.Class pSuperclass) {
    return new Mutable(pSubclass, pSuperclass);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSubclass the fixed value of pattern parameter subclass, or null if not bound.
   * @param pSuperclass the fixed value of pattern parameter superclass, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static SubClassOfMatch newMatch(final Classifier pSubclass, final org.eclipse.uml2.uml.Class pSuperclass) {
    return new Immutable(pSubclass, pSuperclass);
  }
  
  private static final class Mutable extends SubClassOfMatch {
    Mutable(final Classifier pSubclass, final org.eclipse.uml2.uml.Class pSuperclass) {
      super(pSubclass, pSuperclass);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends SubClassOfMatch {
    Immutable(final Classifier pSubclass, final org.eclipse.uml2.uml.Class pSuperclass) {
      super(pSubclass, pSuperclass);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
