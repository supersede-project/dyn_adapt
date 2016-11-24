/**
 */
package cz.zcu.yafmt.clang.bcl.model.util;

import cz.zcu.yafmt.clang.bcl.model.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see cz.zcu.yafmt.clang.bcl.model.ModelPackage
 * @generated
 */
public class ModelSwitch<T> extends Switch<T> {
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static ModelPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ModelSwitch() {
        if (modelPackage == null) {
            modelPackage = ModelPackage.eINSTANCE;
        }
    }

    /**
     * Checks whether this is a switch for the given package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @parameter ePackage the package in question.
     * @return whether this is a switch for the given package.
     * @generated
     */
    @Override
    protected boolean isSwitchFor(EPackage ePackage) {
        return ePackage == modelPackage;
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    @Override
    protected T doSwitch(int classifierID, EObject theEObject) {
        switch (classifierID) {
            case ModelPackage.EXPRESSION: {
                Expression expression = (Expression)theEObject;
                T result = caseExpression(expression);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ModelPackage.FOR_ALL_CONTEXTUAL_EXPRESSION: {
                ForAllContextualExpression forAllContextualExpression = (ForAllContextualExpression)theEObject;
                T result = caseForAllContextualExpression(forAllContextualExpression);
                if (result == null) result = caseExpression(forAllContextualExpression);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ModelPackage.EXISTS_CONTEXTUAL_EXPRESSION: {
                ExistsContextualExpression existsContextualExpression = (ExistsContextualExpression)theEObject;
                T result = caseExistsContextualExpression(existsContextualExpression);
                if (result == null) result = caseExpression(existsContextualExpression);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ModelPackage.EQUATION: {
                Equation equation = (Equation)theEObject;
                T result = caseEquation(equation);
                if (result == null) result = caseExpression(equation);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ModelPackage.IMPLICATION: {
                Implication implication = (Implication)theEObject;
                T result = caseImplication(implication);
                if (result == null) result = caseExpression(implication);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ModelPackage.DISJUNCTION: {
                Disjunction disjunction = (Disjunction)theEObject;
                T result = caseDisjunction(disjunction);
                if (result == null) result = caseExpression(disjunction);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ModelPackage.CONJUNCTION: {
                Conjunction conjunction = (Conjunction)theEObject;
                T result = caseConjunction(conjunction);
                if (result == null) result = caseExpression(conjunction);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ModelPackage.NEGATION: {
                Negation negation = (Negation)theEObject;
                T result = caseNegation(negation);
                if (result == null) result = caseExpression(negation);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ModelPackage.PRIMARY_EXPRESSION: {
                PrimaryExpression primaryExpression = (PrimaryExpression)theEObject;
                T result = casePrimaryExpression(primaryExpression);
                if (result == null) result = caseExpression(primaryExpression);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseExpression(Expression object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>For All Contextual Expression</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>For All Contextual Expression</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseForAllContextualExpression(ForAllContextualExpression object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Exists Contextual Expression</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Exists Contextual Expression</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseExistsContextualExpression(ExistsContextualExpression object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Equation</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Equation</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEquation(Equation object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Implication</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Implication</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseImplication(Implication object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Disjunction</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Disjunction</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDisjunction(Disjunction object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Conjunction</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Conjunction</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseConjunction(Conjunction object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Negation</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Negation</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseNegation(Negation object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Primary Expression</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Primary Expression</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePrimaryExpression(PrimaryExpression object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch, but this is the last case anyway.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    @Override
    public T defaultCase(EObject object) {
        return null;
    }

} //ModelSwitch
