/**
 * Generated from platform:/resource/eu.supersede.dynadapt.adapter/repository/patterns.old/eu/supersede/dynadapt/usecases/monitoring/patterns/monitoring_reconfiguration_queries.vql
 */
package patterns;

import java.util.Arrays;
import java.util.List;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import patterns.util.InstancesQuerySpecification;

/**
 * Pattern-specific match representation of the patterns.instances pattern,
 * to be used in conjunction with {@link InstancesMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see InstancesMatcher
 * @see InstancesProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class InstancesMatch extends BasePatternMatch {
  private InstanceSpecification fInstance;
  
  private String fName;
  
  private static List<String> parameterNames = makeImmutableList("instance", "name");
  
  private InstancesMatch(final InstanceSpecification pInstance, final String pName) {
    this.fInstance = pInstance;
    this.fName = pName;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("instance".equals(parameterName)) return this.fInstance;
    if ("name".equals(parameterName)) return this.fName;
    return null;
  }
  
  public InstanceSpecification getInstance() {
    return this.fInstance;
  }
  
  public String getName() {
    return this.fName;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("instance".equals(parameterName) ) {
    	this.fInstance = (InstanceSpecification) newValue;
    	return true;
    }
    if ("name".equals(parameterName) ) {
    	this.fName = (String) newValue;
    	return true;
    }
    return false;
  }
  
  public void setInstance(final InstanceSpecification pInstance) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fInstance = pInstance;
  }
  
  public void setName(final String pName) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fName = pName;
  }
  
  @Override
  public String patternName() {
    return "patterns.instances";
  }
  
  @Override
  public List<String> parameterNames() {
    return InstancesMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fInstance, fName};
  }
  
  @Override
  public InstancesMatch toImmutable() {
    return isMutable() ? newMatch(fInstance, fName) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"instance\"=" + prettyPrintValue(fInstance) + ", ");
    
    result.append("\"name\"=" + prettyPrintValue(fName)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fInstance == null) ? 0 : fInstance.hashCode());
    result = prime * result + ((fName == null) ? 0 : fName.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof InstancesMatch)) { // this should be infrequent
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
    InstancesMatch other = (InstancesMatch) obj;
    if (fInstance == null) {if (other.fInstance != null) return false;}
    else if (!fInstance.equals(other.fInstance)) return false;
    if (fName == null) {if (other.fName != null) return false;}
    else if (!fName.equals(other.fName)) return false;
    return true;
  }
  
  @Override
  public InstancesQuerySpecification specification() {
    try {
    	return InstancesQuerySpecification.instance();
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
  public static InstancesMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pInstance the fixed value of pattern parameter instance, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static InstancesMatch newMutableMatch(final InstanceSpecification pInstance, final String pName) {
    return new Mutable(pInstance, pName);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pInstance the fixed value of pattern parameter instance, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static InstancesMatch newMatch(final InstanceSpecification pInstance, final String pName) {
    return new Immutable(pInstance, pName);
  }
  
  private static final class Mutable extends InstancesMatch {
    Mutable(final InstanceSpecification pInstance, final String pName) {
      super(pInstance, pName);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends InstancesMatch {
    Immutable(final InstanceSpecification pInstance, final String pName) {
      super(pInstance, pName);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
