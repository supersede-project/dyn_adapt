/**
 */
package cz.zcu.yafmt.model.fc;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>String Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link cz.zcu.yafmt.model.fc.StringValue#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see cz.zcu.yafmt.model.fc.FeatureConfigurationPackage#getStringValue()
 * @model
 * @generated
 */
public interface StringValue extends AttributeValue {
    /**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Value</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see cz.zcu.yafmt.model.fc.FeatureConfigurationPackage#getStringValue_Value()
	 * @model default="" required="true"
	 * @generated
	 */
    String getValue();

    /**
	 * Sets the value of the '{@link cz.zcu.yafmt.model.fc.StringValue#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
    void setValue(String value);

} // StringValue
