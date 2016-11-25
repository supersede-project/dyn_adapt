/**
 */
package cz.zcu.yafmt.clang.bcl.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conjunction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cz.zcu.yafmt.clang.bcl.model.Conjunction#getLeftPart <em>Left Part</em>}</li>
 *   <li>{@link cz.zcu.yafmt.clang.bcl.model.Conjunction#getRightPart <em>Right Part</em>}</li>
 * </ul>
 * </p>
 *
 * @see cz.zcu.yafmt.clang.bcl.model.ModelPackage#getConjunction()
 * @model
 * @generated
 */
public interface Conjunction extends Expression {
    /**
     * Returns the value of the '<em><b>Left Part</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Left Part</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Left Part</em>' containment reference.
     * @see #setLeftPart(Expression)
     * @see cz.zcu.yafmt.clang.bcl.model.ModelPackage#getConjunction_LeftPart()
     * @model containment="true"
     * @generated
     */
    Expression getLeftPart();

    /**
     * Sets the value of the '{@link cz.zcu.yafmt.clang.bcl.model.Conjunction#getLeftPart <em>Left Part</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Left Part</em>' containment reference.
     * @see #getLeftPart()
     * @generated
     */
    void setLeftPart(Expression value);

    /**
     * Returns the value of the '<em><b>Right Part</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Right Part</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Right Part</em>' containment reference.
     * @see #setRightPart(Expression)
     * @see cz.zcu.yafmt.clang.bcl.model.ModelPackage#getConjunction_RightPart()
     * @model containment="true"
     * @generated
     */
    Expression getRightPart();

    /**
     * Sets the value of the '{@link cz.zcu.yafmt.clang.bcl.model.Conjunction#getRightPart <em>Right Part</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Right Part</em>' containment reference.
     * @see #getRightPart()
     * @generated
     */
    void setRightPart(Expression value);

} // Conjunction
