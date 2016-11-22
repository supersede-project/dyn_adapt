/**
 */
package cz.zcu.yafmt.clang.bcl.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Negation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cz.zcu.yafmt.clang.bcl.model.Negation#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see cz.zcu.yafmt.clang.bcl.model.ModelPackage#getNegation()
 * @model
 * @generated
 */
public interface Negation extends Expression {

    /**
     * Returns the value of the '<em><b>Expression</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Expression</em>' containment reference.
     * @see #setExpression(Expression)
     * @see cz.zcu.yafmt.clang.bcl.model.ModelPackage#getNegation_Expression()
     * @model containment="true"
     * @generated
     */
    Expression getExpression();

    /**
     * Sets the value of the '{@link cz.zcu.yafmt.clang.bcl.model.Negation#getExpression <em>Expression</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Expression</em>' containment reference.
     * @see #getExpression()
     * @generated
     */
    void setExpression(Expression value);
} // Negation
