/**
 * Generated from platform:/resource/eu.supersede.dynadapt.adapter/repository/patterns/eu/supersede/dynadapt/usecases/patterns/atos_query_patterns.vql
 */
package eu.supersede.dynadapt.usecases.patterns;

import eu.supersede.dynadapt.usecases.patterns.util.HSKExecutionEnvironmentsQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.uml2.uml.ExecutionEnvironment;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the eu.supersede.dynadapt.usecases.patterns.HSKExecutionEnvironments pattern,
 * to be used in conjunction with {@link HSKExecutionEnvironmentsMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see HSKExecutionEnvironmentsMatcher
 * @see HSKExecutionEnvironmentsProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class HSKExecutionEnvironmentsMatch extends BasePatternMatch {
  private ExecutionEnvironment fExecEnv;
  
  private static List<String> parameterNames = makeImmutableList("execEnv");
  
  private HSKExecutionEnvironmentsMatch(final ExecutionEnvironment pExecEnv) {
    this.fExecEnv = pExecEnv;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("execEnv".equals(parameterName)) return this.fExecEnv;
    return null;
  }
  
  public ExecutionEnvironment getExecEnv() {
    return this.fExecEnv;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("execEnv".equals(parameterName) ) {
    	this.fExecEnv = (ExecutionEnvironment) newValue;
    	return true;
    }
    return false;
  }
  
  public void setExecEnv(final ExecutionEnvironment pExecEnv) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fExecEnv = pExecEnv;
  }
  
  @Override
  public String patternName() {
    return "eu.supersede.dynadapt.usecases.patterns.HSKExecutionEnvironments";
  }
  
  @Override
  public List<String> parameterNames() {
    return HSKExecutionEnvironmentsMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fExecEnv};
  }
  
  @Override
  public HSKExecutionEnvironmentsMatch toImmutable() {
    return isMutable() ? newMatch(fExecEnv) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"execEnv\"=" + prettyPrintValue(fExecEnv)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fExecEnv == null) ? 0 : fExecEnv.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof HSKExecutionEnvironmentsMatch)) { // this should be infrequent
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
    HSKExecutionEnvironmentsMatch other = (HSKExecutionEnvironmentsMatch) obj;
    if (fExecEnv == null) {if (other.fExecEnv != null) return false;}
    else if (!fExecEnv.equals(other.fExecEnv)) return false;
    return true;
  }
  
  @Override
  public HSKExecutionEnvironmentsQuerySpecification specification() {
    try {
    	return HSKExecutionEnvironmentsQuerySpecification.instance();
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
  public static HSKExecutionEnvironmentsMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pExecEnv the fixed value of pattern parameter execEnv, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static HSKExecutionEnvironmentsMatch newMutableMatch(final ExecutionEnvironment pExecEnv) {
    return new Mutable(pExecEnv);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pExecEnv the fixed value of pattern parameter execEnv, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static HSKExecutionEnvironmentsMatch newMatch(final ExecutionEnvironment pExecEnv) {
    return new Immutable(pExecEnv);
  }
  
  private static final class Mutable extends HSKExecutionEnvironmentsMatch {
    Mutable(final ExecutionEnvironment pExecEnv) {
      super(pExecEnv);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends HSKExecutionEnvironmentsMatch {
    Immutable(final ExecutionEnvironment pExecEnv) {
      super(pExecEnv);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
