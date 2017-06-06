/**
 * Generated from platform:/resource/eu.supersede.dynadapt.adapter/repository/patterns.old/eu/supersede/dynadapt/usecases/atos/patterns/atos_query_patterns.vql
 */
package eu.supersede.dynadapt.usecases.atos.patterns;

import eu.supersede.dynadapt.usecases.atos.patterns.util.VirtualExecutionEnvContainingAComponentQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.ExecutionEnvironment;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the eu.supersede.dynadapt.usecases.atos.patterns.VirtualExecutionEnvContainingAComponent pattern,
 * to be used in conjunction with {@link VirtualExecutionEnvContainingAComponentMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see VirtualExecutionEnvContainingAComponentMatcher
 * @see VirtualExecutionEnvContainingAComponentProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class VirtualExecutionEnvContainingAComponentMatch extends BasePatternMatch {
  private ExecutionEnvironment fExecEnv;
  
  private Component fInstanceClassifier;
  
  private static List<String> parameterNames = makeImmutableList("execEnv", "instanceClassifier");
  
  private VirtualExecutionEnvContainingAComponentMatch(final ExecutionEnvironment pExecEnv, final Component pInstanceClassifier) {
    this.fExecEnv = pExecEnv;
    this.fInstanceClassifier = pInstanceClassifier;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("execEnv".equals(parameterName)) return this.fExecEnv;
    if ("instanceClassifier".equals(parameterName)) return this.fInstanceClassifier;
    return null;
  }
  
  public ExecutionEnvironment getExecEnv() {
    return this.fExecEnv;
  }
  
  public Component getInstanceClassifier() {
    return this.fInstanceClassifier;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("execEnv".equals(parameterName) ) {
    	this.fExecEnv = (ExecutionEnvironment) newValue;
    	return true;
    }
    if ("instanceClassifier".equals(parameterName) ) {
    	this.fInstanceClassifier = (Component) newValue;
    	return true;
    }
    return false;
  }
  
  public void setExecEnv(final ExecutionEnvironment pExecEnv) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fExecEnv = pExecEnv;
  }
  
  public void setInstanceClassifier(final Component pInstanceClassifier) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fInstanceClassifier = pInstanceClassifier;
  }
  
  @Override
  public String patternName() {
    return "eu.supersede.dynadapt.usecases.atos.patterns.VirtualExecutionEnvContainingAComponent";
  }
  
  @Override
  public List<String> parameterNames() {
    return VirtualExecutionEnvContainingAComponentMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fExecEnv, fInstanceClassifier};
  }
  
  @Override
  public VirtualExecutionEnvContainingAComponentMatch toImmutable() {
    return isMutable() ? newMatch(fExecEnv, fInstanceClassifier) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"execEnv\"=" + prettyPrintValue(fExecEnv) + ", ");
    
    result.append("\"instanceClassifier\"=" + prettyPrintValue(fInstanceClassifier)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fExecEnv == null) ? 0 : fExecEnv.hashCode());
    result = prime * result + ((fInstanceClassifier == null) ? 0 : fInstanceClassifier.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof VirtualExecutionEnvContainingAComponentMatch)) { // this should be infrequent
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
    VirtualExecutionEnvContainingAComponentMatch other = (VirtualExecutionEnvContainingAComponentMatch) obj;
    if (fExecEnv == null) {if (other.fExecEnv != null) return false;}
    else if (!fExecEnv.equals(other.fExecEnv)) return false;
    if (fInstanceClassifier == null) {if (other.fInstanceClassifier != null) return false;}
    else if (!fInstanceClassifier.equals(other.fInstanceClassifier)) return false;
    return true;
  }
  
  @Override
  public VirtualExecutionEnvContainingAComponentQuerySpecification specification() {
    try {
    	return VirtualExecutionEnvContainingAComponentQuerySpecification.instance();
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
  public static VirtualExecutionEnvContainingAComponentMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pExecEnv the fixed value of pattern parameter execEnv, or null if not bound.
   * @param pInstanceClassifier the fixed value of pattern parameter instanceClassifier, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static VirtualExecutionEnvContainingAComponentMatch newMutableMatch(final ExecutionEnvironment pExecEnv, final Component pInstanceClassifier) {
    return new Mutable(pExecEnv, pInstanceClassifier);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pExecEnv the fixed value of pattern parameter execEnv, or null if not bound.
   * @param pInstanceClassifier the fixed value of pattern parameter instanceClassifier, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static VirtualExecutionEnvContainingAComponentMatch newMatch(final ExecutionEnvironment pExecEnv, final Component pInstanceClassifier) {
    return new Immutable(pExecEnv, pInstanceClassifier);
  }
  
  private static final class Mutable extends VirtualExecutionEnvContainingAComponentMatch {
    Mutable(final ExecutionEnvironment pExecEnv, final Component pInstanceClassifier) {
      super(pExecEnv, pInstanceClassifier);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends VirtualExecutionEnvContainingAComponentMatch {
    Immutable(final ExecutionEnvironment pExecEnv, final Component pInstanceClassifier) {
      super(pExecEnv, pInstanceClassifier);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
