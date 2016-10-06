/**
 */
package cz.zcu.yafmt.model.fm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Objective Function Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getObjectiveFunctionType()
 * @model
 * @generated
 */
public enum ObjectiveFunctionType implements Enumerator {
	/**
	 * The '<em><b>NOT ASSIGNED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOT_ASSIGNED_VALUE
	 * @generated
	 * @ordered
	 */
	NOT_ASSIGNED(0, "NOT_ASSIGNED", ""), /**
	 * The '<em><b>SUM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUM_VALUE
	 * @generated
	 * @ordered
	 */
	SUM(1, "SUM", "sum"),

	/**
	 * The '<em><b>PRODUCT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRODUCT_VALUE
	 * @generated
	 * @ordered
	 */
	PRODUCT(2, "PRODUCT", "product"),

	/**
	 * The '<em><b>MAXIMUM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MAXIMUM_VALUE
	 * @generated
	 * @ordered
	 */
	MAXIMUM(3, "MAXIMUM", "max"),

	/**
	 * The '<em><b>MINIMUM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MINIMUM_VALUE
	 * @generated
	 * @ordered
	 */
	MINIMUM(4, "MINIMUM", "min");

	/**
	 * The '<em><b>NOT ASSIGNED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NOT ASSIGNED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NOT_ASSIGNED
	 * @model literal=""
	 * @generated
	 * @ordered
	 */
	public static final int NOT_ASSIGNED_VALUE = 0;

	/**
	 * The '<em><b>SUM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SUM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SUM
	 * @model literal="sum"
	 * @generated
	 * @ordered
	 */
	public static final int SUM_VALUE = 1;

	/**
	 * The '<em><b>PRODUCT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PRODUCT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PRODUCT
	 * @model literal="product"
	 * @generated
	 * @ordered
	 */
	public static final int PRODUCT_VALUE = 2;

	/**
	 * The '<em><b>MAXIMUM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MAXIMUM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MAXIMUM
	 * @model literal="max"
	 * @generated
	 * @ordered
	 */
	public static final int MAXIMUM_VALUE = 3;

	/**
	 * The '<em><b>MINIMUM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MINIMUM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MINIMUM
	 * @model literal="min"
	 * @generated
	 * @ordered
	 */
	public static final int MINIMUM_VALUE = 4;

	/**
	 * An array of all the '<em><b>Objective Function Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ObjectiveFunctionType[] VALUES_ARRAY =
		new ObjectiveFunctionType[] {
			NOT_ASSIGNED,
			SUM,
			PRODUCT,
			MAXIMUM,
			MINIMUM,
		};

	/**
	 * A public read-only list of all the '<em><b>Objective Function Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ObjectiveFunctionType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Objective Function Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ObjectiveFunctionType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ObjectiveFunctionType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Objective Function Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ObjectiveFunctionType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ObjectiveFunctionType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Objective Function Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ObjectiveFunctionType get(int value) {
		switch (value) {
			case NOT_ASSIGNED_VALUE: return NOT_ASSIGNED;
			case SUM_VALUE: return SUM;
			case PRODUCT_VALUE: return PRODUCT;
			case MAXIMUM_VALUE: return MAXIMUM;
			case MINIMUM_VALUE: return MINIMUM;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private ObjectiveFunctionType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //ObjectiveFunctionType
