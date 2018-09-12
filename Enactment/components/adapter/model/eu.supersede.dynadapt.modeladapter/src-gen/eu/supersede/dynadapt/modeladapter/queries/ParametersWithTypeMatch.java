/**
 * Generated from platform:/resource/eu.supersede.dynadapt.modeladapter/src/eu/supersede/dynadapt/modeladapter/queries/model_adapter.vql
 */
package eu.supersede.dynadapt.modeladapter.queries;

import eu.supersede.dynadapt.modeladapter.queries.util.ParametersWithTypeQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Type;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the eu.supersede.dynadapt.modeladapter.queries.parametersWithType pattern,
 * to be used in conjunction with {@link ParametersWithTypeMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ParametersWithTypeMatcher
 * @see ParametersWithTypeProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ParametersWithTypeMatch extends BasePatternMatch {
  private Parameter fParameter;
  
  private Type fType;
  
  private static List<String> parameterNames = makeImmutableList("parameter", "type");
  
  private ParametersWithTypeMatch(final Parameter pParameter, final Type pType) {
    this.fParameter = pParameter;
    this.fType = pType;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("parameter".equals(parameterName)) return this.fParameter;
    if ("type".equals(parameterName)) return this.fType;
    return null;
  }
  
  public Parameter getParameter() {
    return this.fParameter;
  }
  
  public Type getType() {
    return this.fType;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("parameter".equals(parameterName) ) {
        this.fParameter = (Parameter) newValue;
        return true;
    }
    if ("type".equals(parameterName) ) {
        this.fType = (Type) newValue;
        return true;
    }
    return false;
  }
  
  public void setParameter(final Parameter pParameter) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fParameter = pParameter;
  }
  
  public void setType(final Type pType) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fType = pType;
  }
  
  @Override
  public String patternName() {
    return "eu.supersede.dynadapt.modeladapter.queries.parametersWithType";
  }
  
  @Override
  public List<String> parameterNames() {
    return ParametersWithTypeMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fParameter, fType};
  }
  
  @Override
  public ParametersWithTypeMatch toImmutable() {
    return isMutable() ? newMatch(fParameter, fType) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"parameter\"=" + prettyPrintValue(fParameter) + ", ");
    
    result.append("\"type\"=" + prettyPrintValue(fType)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fParameter == null) ? 0 : fParameter.hashCode());
    result = prime * result + ((fType == null) ? 0 : fType.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
        return true;
    if (!(obj instanceof ParametersWithTypeMatch)) { // this should be infrequent
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
    ParametersWithTypeMatch other = (ParametersWithTypeMatch) obj;
    if (fParameter == null) {if (other.fParameter != null) return false;}
    else if (!fParameter.equals(other.fParameter)) return false;
    if (fType == null) {if (other.fType != null) return false;}
    else if (!fType.equals(other.fType)) return false;
    return true;
  }
  
  @Override
  public ParametersWithTypeQuerySpecification specification() {
    try {
        return ParametersWithTypeQuerySpecification.instance();
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
  public static ParametersWithTypeMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ParametersWithTypeMatch newMutableMatch(final Parameter pParameter, final Type pType) {
    return new Mutable(pParameter, pType);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ParametersWithTypeMatch newMatch(final Parameter pParameter, final Type pType) {
    return new Immutable(pParameter, pType);
  }
  
  private static final class Mutable extends ParametersWithTypeMatch {
    Mutable(final Parameter pParameter, final Type pType) {
      super(pParameter, pType);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ParametersWithTypeMatch {
    Immutable(final Parameter pParameter, final Type pType) {
      super(pParameter, pType);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
