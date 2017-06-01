/**
 * Generated from platform:/resource/eu.supersede.dynadapt.adapter/repository/patterns/eu/supersede/dynadapt/usecases/monitoring/patterns/monitoring_reconfiguration_queries.vql
 */
package patterns;

import java.util.Arrays;
import java.util.List;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import patterns.util.ClassesQuerySpecification;

/**
 * Pattern-specific match representation of the patterns.classes pattern,
 * to be used in conjunction with {@link ClassesMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ClassesMatcher
 * @see ClassesProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ClassesMatch extends BasePatternMatch {
  private org.eclipse.uml2.uml.Class fClass;
  
  private String fName;
  
  private static List<String> parameterNames = makeImmutableList("class", "name");
  
  private ClassesMatch(final org.eclipse.uml2.uml.Class pClass, final String pName) {
    this.fClass = pClass;
    this.fName = pName;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("class".equals(parameterName)) return this.fClass;
    if ("name".equals(parameterName)) return this.fName;
    return null;
  }
  
  public org.eclipse.uml2.uml.Class getValueOfClass() {
    return this.fClass;
  }
  
  public String getName() {
    return this.fName;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("class".equals(parameterName) ) {
    	this.fClass = (org.eclipse.uml2.uml.Class) newValue;
    	return true;
    }
    if ("name".equals(parameterName) ) {
    	this.fName = (String) newValue;
    	return true;
    }
    return false;
  }
  
  public void setClass(final org.eclipse.uml2.uml.Class pClass) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fClass = pClass;
  }
  
  public void setName(final String pName) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fName = pName;
  }
  
  @Override
  public String patternName() {
    return "patterns.classes";
  }
  
  @Override
  public List<String> parameterNames() {
    return ClassesMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fClass, fName};
  }
  
  @Override
  public ClassesMatch toImmutable() {
    return isMutable() ? newMatch(fClass, fName) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"class\"=" + prettyPrintValue(fClass) + ", ");
    
    result.append("\"name\"=" + prettyPrintValue(fName)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fClass == null) ? 0 : fClass.hashCode());
    result = prime * result + ((fName == null) ? 0 : fName.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ClassesMatch)) { // this should be infrequent
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
    ClassesMatch other = (ClassesMatch) obj;
    if (fClass == null) {if (other.fClass != null) return false;}
    else if (!fClass.equals(other.fClass)) return false;
    if (fName == null) {if (other.fName != null) return false;}
    else if (!fName.equals(other.fName)) return false;
    return true;
  }
  
  @Override
  public ClassesQuerySpecification specification() {
    try {
    	return ClassesQuerySpecification.instance();
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
  public static ClassesMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pClass the fixed value of pattern parameter class, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ClassesMatch newMutableMatch(final org.eclipse.uml2.uml.Class pClass, final String pName) {
    return new Mutable(pClass, pName);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pClass the fixed value of pattern parameter class, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ClassesMatch newMatch(final org.eclipse.uml2.uml.Class pClass, final String pName) {
    return new Immutable(pClass, pName);
  }
  
  private static final class Mutable extends ClassesMatch {
    Mutable(final org.eclipse.uml2.uml.Class pClass, final String pName) {
      super(pClass, pName);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ClassesMatch {
    Immutable(final org.eclipse.uml2.uml.Class pClass, final String pName) {
      super(pClass, pName);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
