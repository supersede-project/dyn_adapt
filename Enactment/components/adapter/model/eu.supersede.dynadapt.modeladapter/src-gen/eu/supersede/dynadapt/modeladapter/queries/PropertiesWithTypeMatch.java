/**
 * Generated from platform:/resource/eu.supersede.dynadapt.modeladapter/src/eu/supersede/dynadapt/modeladapter/queries/model_adapter.vql
 */
package eu.supersede.dynadapt.modeladapter.queries;

import eu.supersede.dynadapt.modeladapter.queries.util.PropertiesWithTypeQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the eu.supersede.dynadapt.modeladapter.queries.propertiesWithType pattern,
 * to be used in conjunction with {@link PropertiesWithTypeMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see PropertiesWithTypeMatcher
 * @see PropertiesWithTypeProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class PropertiesWithTypeMatch extends BasePatternMatch {
  private Property fProperty;
  
  private Type fType;
  
  private static List<String> parameterNames = makeImmutableList("property", "type");
  
  private PropertiesWithTypeMatch(final Property pProperty, final Type pType) {
    this.fProperty = pProperty;
    this.fType = pType;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("property".equals(parameterName)) return this.fProperty;
    if ("type".equals(parameterName)) return this.fType;
    return null;
  }
  
  public Property getProperty() {
    return this.fProperty;
  }
  
  public Type getType() {
    return this.fType;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("property".equals(parameterName) ) {
    	this.fProperty = (Property) newValue;
    	return true;
    }
    if ("type".equals(parameterName) ) {
    	this.fType = (Type) newValue;
    	return true;
    }
    return false;
  }
  
  public void setProperty(final Property pProperty) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fProperty = pProperty;
  }
  
  public void setType(final Type pType) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fType = pType;
  }
  
  @Override
  public String patternName() {
    return "eu.supersede.dynadapt.modeladapter.queries.propertiesWithType";
  }
  
  @Override
  public List<String> parameterNames() {
    return PropertiesWithTypeMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fProperty, fType};
  }
  
  @Override
  public PropertiesWithTypeMatch toImmutable() {
    return isMutable() ? newMatch(fProperty, fType) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"property\"=" + prettyPrintValue(fProperty) + ", ");
    
    result.append("\"type\"=" + prettyPrintValue(fType)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fProperty == null) ? 0 : fProperty.hashCode());
    result = prime * result + ((fType == null) ? 0 : fType.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof PropertiesWithTypeMatch)) { // this should be infrequent
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
    PropertiesWithTypeMatch other = (PropertiesWithTypeMatch) obj;
    if (fProperty == null) {if (other.fProperty != null) return false;}
    else if (!fProperty.equals(other.fProperty)) return false;
    if (fType == null) {if (other.fType != null) return false;}
    else if (!fType.equals(other.fType)) return false;
    return true;
  }
  
  @Override
  public PropertiesWithTypeQuerySpecification specification() {
    try {
    	return PropertiesWithTypeQuerySpecification.instance();
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
  public static PropertiesWithTypeMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pProperty the fixed value of pattern parameter property, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static PropertiesWithTypeMatch newMutableMatch(final Property pProperty, final Type pType) {
    return new Mutable(pProperty, pType);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pProperty the fixed value of pattern parameter property, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static PropertiesWithTypeMatch newMatch(final Property pProperty, final Type pType) {
    return new Immutable(pProperty, pType);
  }
  
  private static final class Mutable extends PropertiesWithTypeMatch {
    Mutable(final Property pProperty, final Type pType) {
      super(pProperty, pType);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends PropertiesWithTypeMatch {
    Immutable(final Property pProperty, final Type pType) {
      super(pProperty, pType);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
