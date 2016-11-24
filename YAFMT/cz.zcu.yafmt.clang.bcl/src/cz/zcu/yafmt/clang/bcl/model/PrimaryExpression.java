/**
 */
package cz.zcu.yafmt.clang.bcl.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primary Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cz.zcu.yafmt.clang.bcl.model.PrimaryExpression#getFeatureId <em>Feature Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see cz.zcu.yafmt.clang.bcl.model.ModelPackage#getPrimaryExpression()
 * @model
 * @generated
 */
public interface PrimaryExpression extends Expression {
    /**
     * Returns the value of the '<em><b>Feature Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Feature Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Feature Id</em>' attribute.
     * @see #setFeatureId(String)
     * @see cz.zcu.yafmt.clang.bcl.model.ModelPackage#getPrimaryExpression_FeatureId()
     * @model
     * @generated
     */
    String getFeatureId();

    /**
     * Sets the value of the '{@link cz.zcu.yafmt.clang.bcl.model.PrimaryExpression#getFeatureId <em>Feature Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Feature Id</em>' attribute.
     * @see #getFeatureId()
     * @generated
     */
    void setFeatureId(String value);

} // PrimaryExpression
