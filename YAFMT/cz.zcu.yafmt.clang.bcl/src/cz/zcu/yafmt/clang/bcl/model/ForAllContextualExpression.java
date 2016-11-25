/**
 */
package cz.zcu.yafmt.clang.bcl.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>For All Contextual Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cz.zcu.yafmt.clang.bcl.model.ForAllContextualExpression#getContextId <em>Context Id</em>}</li>
 *   <li>{@link cz.zcu.yafmt.clang.bcl.model.ForAllContextualExpression#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see cz.zcu.yafmt.clang.bcl.model.ModelPackage#getForAllContextualExpression()
 * @model
 * @generated
 */
public interface ForAllContextualExpression extends Expression {
    /**
     * Returns the value of the '<em><b>Context Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Context Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Context Id</em>' attribute.
     * @see #setContextId(String)
     * @see cz.zcu.yafmt.clang.bcl.model.ModelPackage#getForAllContextualExpression_ContextId()
     * @model
     * @generated
     */
    String getContextId();

    /**
     * Sets the value of the '{@link cz.zcu.yafmt.clang.bcl.model.ForAllContextualExpression#getContextId <em>Context Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Context Id</em>' attribute.
     * @see #getContextId()
     * @generated
     */
    void setContextId(String value);

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
     * @see cz.zcu.yafmt.clang.bcl.model.ModelPackage#getForAllContextualExpression_Expression()
     * @model containment="true"
     * @generated
     */
    Expression getExpression();

    /**
     * Sets the value of the '{@link cz.zcu.yafmt.clang.bcl.model.ForAllContextualExpression#getExpression <em>Expression</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Expression</em>' containment reference.
     * @see #getExpression()
     * @generated
     */
    void setExpression(Expression value);

} // ForAllContextualExpression
