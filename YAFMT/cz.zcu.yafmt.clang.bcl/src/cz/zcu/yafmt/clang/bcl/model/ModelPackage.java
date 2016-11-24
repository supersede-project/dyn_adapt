/**
 */
package cz.zcu.yafmt.clang.bcl.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see cz.zcu.yafmt.clang.bcl.model.ModelFactory
 * @model kind="package"
 * @generated
 */
public interface ModelPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "model";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://zcu.cz/yafmt/clang/bcl";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "model";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    ModelPackage eINSTANCE = cz.zcu.yafmt.clang.bcl.model.impl.ModelPackageImpl.init();

    /**
     * The meta object id for the '{@link cz.zcu.yafmt.clang.bcl.model.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cz.zcu.yafmt.clang.bcl.model.impl.ExpressionImpl
     * @see cz.zcu.yafmt.clang.bcl.model.impl.ModelPackageImpl#getExpression()
     * @generated
     */
    int EXPRESSION = 0;

    /**
     * The number of structural features of the '<em>Expression</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPRESSION_FEATURE_COUNT = 0;

    /**
     * The meta object id for the '{@link cz.zcu.yafmt.clang.bcl.model.impl.ForAllContextualExpressionImpl <em>For All Contextual Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cz.zcu.yafmt.clang.bcl.model.impl.ForAllContextualExpressionImpl
     * @see cz.zcu.yafmt.clang.bcl.model.impl.ModelPackageImpl#getForAllContextualExpression()
     * @generated
     */
    int FOR_ALL_CONTEXTUAL_EXPRESSION = 1;

    /**
     * The feature id for the '<em><b>Context Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FOR_ALL_CONTEXTUAL_EXPRESSION__CONTEXT_ID = EXPRESSION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Expression</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FOR_ALL_CONTEXTUAL_EXPRESSION__EXPRESSION = EXPRESSION_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>For All Contextual Expression</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FOR_ALL_CONTEXTUAL_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link cz.zcu.yafmt.clang.bcl.model.impl.ExistsContextualExpressionImpl <em>Exists Contextual Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cz.zcu.yafmt.clang.bcl.model.impl.ExistsContextualExpressionImpl
     * @see cz.zcu.yafmt.clang.bcl.model.impl.ModelPackageImpl#getExistsContextualExpression()
     * @generated
     */
    int EXISTS_CONTEXTUAL_EXPRESSION = 2;

    /**
     * The feature id for the '<em><b>Context Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXISTS_CONTEXTUAL_EXPRESSION__CONTEXT_ID = EXPRESSION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Expression</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXISTS_CONTEXTUAL_EXPRESSION__EXPRESSION = EXPRESSION_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Exists Contextual Expression</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXISTS_CONTEXTUAL_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link cz.zcu.yafmt.clang.bcl.model.impl.EquationImpl <em>Equation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cz.zcu.yafmt.clang.bcl.model.impl.EquationImpl
     * @see cz.zcu.yafmt.clang.bcl.model.impl.ModelPackageImpl#getEquation()
     * @generated
     */
    int EQUATION = 3;

    /**
     * The feature id for the '<em><b>Left Part</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EQUATION__LEFT_PART = EXPRESSION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Right Part</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EQUATION__RIGHT_PART = EXPRESSION_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Equation</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EQUATION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link cz.zcu.yafmt.clang.bcl.model.impl.ImplicationImpl <em>Implication</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cz.zcu.yafmt.clang.bcl.model.impl.ImplicationImpl
     * @see cz.zcu.yafmt.clang.bcl.model.impl.ModelPackageImpl#getImplication()
     * @generated
     */
    int IMPLICATION = 4;

    /**
     * The feature id for the '<em><b>Left Part</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMPLICATION__LEFT_PART = EXPRESSION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Right Part</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMPLICATION__RIGHT_PART = EXPRESSION_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Implication</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMPLICATION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link cz.zcu.yafmt.clang.bcl.model.impl.DisjunctionImpl <em>Disjunction</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cz.zcu.yafmt.clang.bcl.model.impl.DisjunctionImpl
     * @see cz.zcu.yafmt.clang.bcl.model.impl.ModelPackageImpl#getDisjunction()
     * @generated
     */
    int DISJUNCTION = 5;

    /**
     * The feature id for the '<em><b>Left Part</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DISJUNCTION__LEFT_PART = EXPRESSION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Right Part</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DISJUNCTION__RIGHT_PART = EXPRESSION_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Disjunction</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DISJUNCTION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link cz.zcu.yafmt.clang.bcl.model.impl.ConjunctionImpl <em>Conjunction</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cz.zcu.yafmt.clang.bcl.model.impl.ConjunctionImpl
     * @see cz.zcu.yafmt.clang.bcl.model.impl.ModelPackageImpl#getConjunction()
     * @generated
     */
    int CONJUNCTION = 6;

    /**
     * The feature id for the '<em><b>Left Part</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONJUNCTION__LEFT_PART = EXPRESSION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Right Part</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONJUNCTION__RIGHT_PART = EXPRESSION_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Conjunction</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONJUNCTION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link cz.zcu.yafmt.clang.bcl.model.impl.NegationImpl <em>Negation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cz.zcu.yafmt.clang.bcl.model.impl.NegationImpl
     * @see cz.zcu.yafmt.clang.bcl.model.impl.ModelPackageImpl#getNegation()
     * @generated
     */
    int NEGATION = 7;

    /**
     * The feature id for the '<em><b>Expression</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NEGATION__EXPRESSION = EXPRESSION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Negation</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NEGATION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link cz.zcu.yafmt.clang.bcl.model.impl.PrimaryExpressionImpl <em>Primary Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cz.zcu.yafmt.clang.bcl.model.impl.PrimaryExpressionImpl
     * @see cz.zcu.yafmt.clang.bcl.model.impl.ModelPackageImpl#getPrimaryExpression()
     * @generated
     */
    int PRIMARY_EXPRESSION = 8;

    /**
     * The feature id for the '<em><b>Feature Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMARY_EXPRESSION__FEATURE_ID = EXPRESSION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Primary Expression</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMARY_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

    /**
     * Returns the meta object for class '{@link cz.zcu.yafmt.clang.bcl.model.Expression <em>Expression</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Expression</em>'.
     * @see cz.zcu.yafmt.clang.bcl.model.Expression
     * @generated
     */
    EClass getExpression();

    /**
     * Returns the meta object for class '{@link cz.zcu.yafmt.clang.bcl.model.ForAllContextualExpression <em>For All Contextual Expression</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>For All Contextual Expression</em>'.
     * @see cz.zcu.yafmt.clang.bcl.model.ForAllContextualExpression
     * @generated
     */
    EClass getForAllContextualExpression();

    /**
     * Returns the meta object for the attribute '{@link cz.zcu.yafmt.clang.bcl.model.ForAllContextualExpression#getContextId <em>Context Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Context Id</em>'.
     * @see cz.zcu.yafmt.clang.bcl.model.ForAllContextualExpression#getContextId()
     * @see #getForAllContextualExpression()
     * @generated
     */
    EAttribute getForAllContextualExpression_ContextId();

    /**
     * Returns the meta object for the containment reference '{@link cz.zcu.yafmt.clang.bcl.model.ForAllContextualExpression#getExpression <em>Expression</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Expression</em>'.
     * @see cz.zcu.yafmt.clang.bcl.model.ForAllContextualExpression#getExpression()
     * @see #getForAllContextualExpression()
     * @generated
     */
    EReference getForAllContextualExpression_Expression();

    /**
     * Returns the meta object for class '{@link cz.zcu.yafmt.clang.bcl.model.ExistsContextualExpression <em>Exists Contextual Expression</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Exists Contextual Expression</em>'.
     * @see cz.zcu.yafmt.clang.bcl.model.ExistsContextualExpression
     * @generated
     */
    EClass getExistsContextualExpression();

    /**
     * Returns the meta object for the attribute '{@link cz.zcu.yafmt.clang.bcl.model.ExistsContextualExpression#getContextId <em>Context Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Context Id</em>'.
     * @see cz.zcu.yafmt.clang.bcl.model.ExistsContextualExpression#getContextId()
     * @see #getExistsContextualExpression()
     * @generated
     */
    EAttribute getExistsContextualExpression_ContextId();

    /**
     * Returns the meta object for the containment reference '{@link cz.zcu.yafmt.clang.bcl.model.ExistsContextualExpression#getExpression <em>Expression</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Expression</em>'.
     * @see cz.zcu.yafmt.clang.bcl.model.ExistsContextualExpression#getExpression()
     * @see #getExistsContextualExpression()
     * @generated
     */
    EReference getExistsContextualExpression_Expression();

    /**
     * Returns the meta object for class '{@link cz.zcu.yafmt.clang.bcl.model.Equation <em>Equation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Equation</em>'.
     * @see cz.zcu.yafmt.clang.bcl.model.Equation
     * @generated
     */
    EClass getEquation();

    /**
     * Returns the meta object for the containment reference '{@link cz.zcu.yafmt.clang.bcl.model.Equation#getLeftPart <em>Left Part</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Left Part</em>'.
     * @see cz.zcu.yafmt.clang.bcl.model.Equation#getLeftPart()
     * @see #getEquation()
     * @generated
     */
    EReference getEquation_LeftPart();

    /**
     * Returns the meta object for the containment reference '{@link cz.zcu.yafmt.clang.bcl.model.Equation#getRightPart <em>Right Part</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Right Part</em>'.
     * @see cz.zcu.yafmt.clang.bcl.model.Equation#getRightPart()
     * @see #getEquation()
     * @generated
     */
    EReference getEquation_RightPart();

    /**
     * Returns the meta object for class '{@link cz.zcu.yafmt.clang.bcl.model.Implication <em>Implication</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Implication</em>'.
     * @see cz.zcu.yafmt.clang.bcl.model.Implication
     * @generated
     */
    EClass getImplication();

    /**
     * Returns the meta object for the containment reference '{@link cz.zcu.yafmt.clang.bcl.model.Implication#getLeftPart <em>Left Part</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Left Part</em>'.
     * @see cz.zcu.yafmt.clang.bcl.model.Implication#getLeftPart()
     * @see #getImplication()
     * @generated
     */
    EReference getImplication_LeftPart();

    /**
     * Returns the meta object for the containment reference '{@link cz.zcu.yafmt.clang.bcl.model.Implication#getRightPart <em>Right Part</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Right Part</em>'.
     * @see cz.zcu.yafmt.clang.bcl.model.Implication#getRightPart()
     * @see #getImplication()
     * @generated
     */
    EReference getImplication_RightPart();

    /**
     * Returns the meta object for class '{@link cz.zcu.yafmt.clang.bcl.model.Disjunction <em>Disjunction</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Disjunction</em>'.
     * @see cz.zcu.yafmt.clang.bcl.model.Disjunction
     * @generated
     */
    EClass getDisjunction();

    /**
     * Returns the meta object for the containment reference '{@link cz.zcu.yafmt.clang.bcl.model.Disjunction#getLeftPart <em>Left Part</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Left Part</em>'.
     * @see cz.zcu.yafmt.clang.bcl.model.Disjunction#getLeftPart()
     * @see #getDisjunction()
     * @generated
     */
    EReference getDisjunction_LeftPart();

    /**
     * Returns the meta object for the containment reference '{@link cz.zcu.yafmt.clang.bcl.model.Disjunction#getRightPart <em>Right Part</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Right Part</em>'.
     * @see cz.zcu.yafmt.clang.bcl.model.Disjunction#getRightPart()
     * @see #getDisjunction()
     * @generated
     */
    EReference getDisjunction_RightPart();

    /**
     * Returns the meta object for class '{@link cz.zcu.yafmt.clang.bcl.model.Conjunction <em>Conjunction</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Conjunction</em>'.
     * @see cz.zcu.yafmt.clang.bcl.model.Conjunction
     * @generated
     */
    EClass getConjunction();

    /**
     * Returns the meta object for the containment reference '{@link cz.zcu.yafmt.clang.bcl.model.Conjunction#getLeftPart <em>Left Part</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Left Part</em>'.
     * @see cz.zcu.yafmt.clang.bcl.model.Conjunction#getLeftPart()
     * @see #getConjunction()
     * @generated
     */
    EReference getConjunction_LeftPart();

    /**
     * Returns the meta object for the containment reference '{@link cz.zcu.yafmt.clang.bcl.model.Conjunction#getRightPart <em>Right Part</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Right Part</em>'.
     * @see cz.zcu.yafmt.clang.bcl.model.Conjunction#getRightPart()
     * @see #getConjunction()
     * @generated
     */
    EReference getConjunction_RightPart();

    /**
     * Returns the meta object for class '{@link cz.zcu.yafmt.clang.bcl.model.Negation <em>Negation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Negation</em>'.
     * @see cz.zcu.yafmt.clang.bcl.model.Negation
     * @generated
     */
    EClass getNegation();

    /**
     * Returns the meta object for the containment reference '{@link cz.zcu.yafmt.clang.bcl.model.Negation#getExpression <em>Expression</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Expression</em>'.
     * @see cz.zcu.yafmt.clang.bcl.model.Negation#getExpression()
     * @see #getNegation()
     * @generated
     */
    EReference getNegation_Expression();

    /**
     * Returns the meta object for class '{@link cz.zcu.yafmt.clang.bcl.model.PrimaryExpression <em>Primary Expression</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Primary Expression</em>'.
     * @see cz.zcu.yafmt.clang.bcl.model.PrimaryExpression
     * @generated
     */
    EClass getPrimaryExpression();

    /**
     * Returns the meta object for the attribute '{@link cz.zcu.yafmt.clang.bcl.model.PrimaryExpression#getFeatureId <em>Feature Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Feature Id</em>'.
     * @see cz.zcu.yafmt.clang.bcl.model.PrimaryExpression#getFeatureId()
     * @see #getPrimaryExpression()
     * @generated
     */
    EAttribute getPrimaryExpression_FeatureId();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    ModelFactory getModelFactory();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '{@link cz.zcu.yafmt.clang.bcl.model.impl.ExpressionImpl <em>Expression</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see cz.zcu.yafmt.clang.bcl.model.impl.ExpressionImpl
         * @see cz.zcu.yafmt.clang.bcl.model.impl.ModelPackageImpl#getExpression()
         * @generated
         */
        EClass EXPRESSION = eINSTANCE.getExpression();

        /**
         * The meta object literal for the '{@link cz.zcu.yafmt.clang.bcl.model.impl.ForAllContextualExpressionImpl <em>For All Contextual Expression</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see cz.zcu.yafmt.clang.bcl.model.impl.ForAllContextualExpressionImpl
         * @see cz.zcu.yafmt.clang.bcl.model.impl.ModelPackageImpl#getForAllContextualExpression()
         * @generated
         */
        EClass FOR_ALL_CONTEXTUAL_EXPRESSION = eINSTANCE.getForAllContextualExpression();

        /**
         * The meta object literal for the '<em><b>Context Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FOR_ALL_CONTEXTUAL_EXPRESSION__CONTEXT_ID = eINSTANCE.getForAllContextualExpression_ContextId();

        /**
         * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FOR_ALL_CONTEXTUAL_EXPRESSION__EXPRESSION = eINSTANCE.getForAllContextualExpression_Expression();

        /**
         * The meta object literal for the '{@link cz.zcu.yafmt.clang.bcl.model.impl.ExistsContextualExpressionImpl <em>Exists Contextual Expression</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see cz.zcu.yafmt.clang.bcl.model.impl.ExistsContextualExpressionImpl
         * @see cz.zcu.yafmt.clang.bcl.model.impl.ModelPackageImpl#getExistsContextualExpression()
         * @generated
         */
        EClass EXISTS_CONTEXTUAL_EXPRESSION = eINSTANCE.getExistsContextualExpression();

        /**
         * The meta object literal for the '<em><b>Context Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXISTS_CONTEXTUAL_EXPRESSION__CONTEXT_ID = eINSTANCE.getExistsContextualExpression_ContextId();

        /**
         * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EXISTS_CONTEXTUAL_EXPRESSION__EXPRESSION = eINSTANCE.getExistsContextualExpression_Expression();

        /**
         * The meta object literal for the '{@link cz.zcu.yafmt.clang.bcl.model.impl.EquationImpl <em>Equation</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see cz.zcu.yafmt.clang.bcl.model.impl.EquationImpl
         * @see cz.zcu.yafmt.clang.bcl.model.impl.ModelPackageImpl#getEquation()
         * @generated
         */
        EClass EQUATION = eINSTANCE.getEquation();

        /**
         * The meta object literal for the '<em><b>Left Part</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EQUATION__LEFT_PART = eINSTANCE.getEquation_LeftPart();

        /**
         * The meta object literal for the '<em><b>Right Part</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EQUATION__RIGHT_PART = eINSTANCE.getEquation_RightPart();

        /**
         * The meta object literal for the '{@link cz.zcu.yafmt.clang.bcl.model.impl.ImplicationImpl <em>Implication</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see cz.zcu.yafmt.clang.bcl.model.impl.ImplicationImpl
         * @see cz.zcu.yafmt.clang.bcl.model.impl.ModelPackageImpl#getImplication()
         * @generated
         */
        EClass IMPLICATION = eINSTANCE.getImplication();

        /**
         * The meta object literal for the '<em><b>Left Part</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference IMPLICATION__LEFT_PART = eINSTANCE.getImplication_LeftPart();

        /**
         * The meta object literal for the '<em><b>Right Part</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference IMPLICATION__RIGHT_PART = eINSTANCE.getImplication_RightPart();

        /**
         * The meta object literal for the '{@link cz.zcu.yafmt.clang.bcl.model.impl.DisjunctionImpl <em>Disjunction</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see cz.zcu.yafmt.clang.bcl.model.impl.DisjunctionImpl
         * @see cz.zcu.yafmt.clang.bcl.model.impl.ModelPackageImpl#getDisjunction()
         * @generated
         */
        EClass DISJUNCTION = eINSTANCE.getDisjunction();

        /**
         * The meta object literal for the '<em><b>Left Part</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DISJUNCTION__LEFT_PART = eINSTANCE.getDisjunction_LeftPart();

        /**
         * The meta object literal for the '<em><b>Right Part</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DISJUNCTION__RIGHT_PART = eINSTANCE.getDisjunction_RightPart();

        /**
         * The meta object literal for the '{@link cz.zcu.yafmt.clang.bcl.model.impl.ConjunctionImpl <em>Conjunction</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see cz.zcu.yafmt.clang.bcl.model.impl.ConjunctionImpl
         * @see cz.zcu.yafmt.clang.bcl.model.impl.ModelPackageImpl#getConjunction()
         * @generated
         */
        EClass CONJUNCTION = eINSTANCE.getConjunction();

        /**
         * The meta object literal for the '<em><b>Left Part</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CONJUNCTION__LEFT_PART = eINSTANCE.getConjunction_LeftPart();

        /**
         * The meta object literal for the '<em><b>Right Part</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CONJUNCTION__RIGHT_PART = eINSTANCE.getConjunction_RightPart();

        /**
         * The meta object literal for the '{@link cz.zcu.yafmt.clang.bcl.model.impl.NegationImpl <em>Negation</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see cz.zcu.yafmt.clang.bcl.model.impl.NegationImpl
         * @see cz.zcu.yafmt.clang.bcl.model.impl.ModelPackageImpl#getNegation()
         * @generated
         */
        EClass NEGATION = eINSTANCE.getNegation();

        /**
         * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference NEGATION__EXPRESSION = eINSTANCE.getNegation_Expression();

        /**
         * The meta object literal for the '{@link cz.zcu.yafmt.clang.bcl.model.impl.PrimaryExpressionImpl <em>Primary Expression</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see cz.zcu.yafmt.clang.bcl.model.impl.PrimaryExpressionImpl
         * @see cz.zcu.yafmt.clang.bcl.model.impl.ModelPackageImpl#getPrimaryExpression()
         * @generated
         */
        EClass PRIMARY_EXPRESSION = eINSTANCE.getPrimaryExpression();

        /**
         * The meta object literal for the '<em><b>Feature Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PRIMARY_EXPRESSION__FEATURE_ID = eINSTANCE.getPrimaryExpression_FeatureId();

    }

} //ModelPackage
