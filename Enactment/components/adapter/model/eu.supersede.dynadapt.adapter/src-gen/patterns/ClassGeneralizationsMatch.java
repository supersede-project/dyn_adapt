/**
 * Generated from platform:/resource/eu.supersede.dynadapt.adapter/repository/patterns.old/eu/supersede/dynadapt/usecases/monitoring/patterns/monitoring_reconfiguration_queries.vql
 */
package patterns;

import java.util.Arrays;
import java.util.List;
import org.eclipse.uml2.uml.Element;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import patterns.util.ClassGeneralizationsQuerySpecification;

/**
 * Pattern-specific match representation of the patterns.classGeneralizations pattern,
 * to be used in conjunction with {@link ClassGeneralizationsMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ClassGeneralizationsMatcher
 * @see ClassGeneralizationsProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ClassGeneralizationsMatch extends BasePatternMatch {
  private org.eclipse.uml2.uml.Class fClass;
  
  private Element fGeneralizationTarget;
  
  private static List<String> parameterNames = makeImmutableList("class", "generalizationTarget");
  
  private ClassGeneralizationsMatch(final org.eclipse.uml2.uml.Class pClass, final Element pGeneralizationTarget) {
    this.fClass = pClass;
    this.fGeneralizationTarget = pGeneralizationTarget;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("class".equals(parameterName)) return this.fClass;
    if ("generalizationTarget".equals(parameterName)) return this.fGeneralizationTarget;
    return null;
  }
  
  public org.eclipse.uml2.uml.Class getValueOfClass() {
    return this.fClass;
  }
  
  public Element getGeneralizationTarget() {
    return this.fGeneralizationTarget;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("class".equals(parameterName) ) {
    	this.fClass = (org.eclipse.uml2.uml.Class) newValue;
    	return true;
    }
    if ("generalizationTarget".equals(parameterName) ) {
    	this.fGeneralizationTarget = (Element) newValue;
    	return true;
    }
    return false;
  }
  
  public void setClass(final org.eclipse.uml2.uml.Class pClass) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fClass = pClass;
  }
  
  public void setGeneralizationTarget(final Element pGeneralizationTarget) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fGeneralizationTarget = pGeneralizationTarget;
  }
  
  @Override
  public String patternName() {
    return "patterns.classGeneralizations";
  }
  
  @Override
  public List<String> parameterNames() {
    return ClassGeneralizationsMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fClass, fGeneralizationTarget};
  }
  
  @Override
  public ClassGeneralizationsMatch toImmutable() {
    return isMutable() ? newMatch(fClass, fGeneralizationTarget) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"class\"=" + prettyPrintValue(fClass) + ", ");
    
    result.append("\"generalizationTarget\"=" + prettyPrintValue(fGeneralizationTarget)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fClass == null) ? 0 : fClass.hashCode());
    result = prime * result + ((fGeneralizationTarget == null) ? 0 : fGeneralizationTarget.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ClassGeneralizationsMatch)) { // this should be infrequent
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
    ClassGeneralizationsMatch other = (ClassGeneralizationsMatch) obj;
    if (fClass == null) {if (other.fClass != null) return false;}
    else if (!fClass.equals(other.fClass)) return false;
    if (fGeneralizationTarget == null) {if (other.fGeneralizationTarget != null) return false;}
    else if (!fGeneralizationTarget.equals(other.fGeneralizationTarget)) return false;
    return true;
  }
  
  @Override
  public ClassGeneralizationsQuerySpecification specification() {
    try {
    	return ClassGeneralizationsQuerySpecification.instance();
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
  public static ClassGeneralizationsMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pClass the fixed value of pattern parameter class, or null if not bound.
   * @param pGeneralizationTarget the fixed value of pattern parameter generalizationTarget, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ClassGeneralizationsMatch newMutableMatch(final org.eclipse.uml2.uml.Class pClass, final Element pGeneralizationTarget) {
    return new Mutable(pClass, pGeneralizationTarget);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pClass the fixed value of pattern parameter class, or null if not bound.
   * @param pGeneralizationTarget the fixed value of pattern parameter generalizationTarget, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ClassGeneralizationsMatch newMatch(final org.eclipse.uml2.uml.Class pClass, final Element pGeneralizationTarget) {
    return new Immutable(pClass, pGeneralizationTarget);
  }
  
  private static final class Mutable extends ClassGeneralizationsMatch {
    Mutable(final org.eclipse.uml2.uml.Class pClass, final Element pGeneralizationTarget) {
      super(pClass, pGeneralizationTarget);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ClassGeneralizationsMatch {
    Immutable(final org.eclipse.uml2.uml.Class pClass, final Element pGeneralizationTarget) {
      super(pClass, pGeneralizationTarget);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
