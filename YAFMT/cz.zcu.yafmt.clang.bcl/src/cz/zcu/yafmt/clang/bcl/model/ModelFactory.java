/**
 */
package cz.zcu.yafmt.clang.bcl.model;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see cz.zcu.yafmt.clang.bcl.model.ModelPackage
 * @generated
 */
public interface ModelFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    ModelFactory eINSTANCE = cz.zcu.yafmt.clang.bcl.model.impl.ModelFactoryImpl.init();

    /**
     * Returns a new object of class '<em>For All Contextual Expression</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>For All Contextual Expression</em>'.
     * @generated
     */
    ForAllContextualExpression createForAllContextualExpression();

    /**
     * Returns a new object of class '<em>Exists Contextual Expression</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Exists Contextual Expression</em>'.
     * @generated
     */
    ExistsContextualExpression createExistsContextualExpression();

    /**
     * Returns a new object of class '<em>Equation</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Equation</em>'.
     * @generated
     */
    Equation createEquation();

    /**
     * Returns a new object of class '<em>Implication</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Implication</em>'.
     * @generated
     */
    Implication createImplication();

    /**
     * Returns a new object of class '<em>Disjunction</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Disjunction</em>'.
     * @generated
     */
    Disjunction createDisjunction();

    /**
     * Returns a new object of class '<em>Conjunction</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Conjunction</em>'.
     * @generated
     */
    Conjunction createConjunction();

    /**
     * Returns a new object of class '<em>Negation</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Negation</em>'.
     * @generated
     */
    Negation createNegation();

    /**
     * Returns a new object of class '<em>Primary Expression</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Primary Expression</em>'.
     * @generated
     */
    PrimaryExpression createPrimaryExpression();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    ModelPackage getModelPackage();

} //ModelFactory
