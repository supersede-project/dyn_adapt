/**
 */
package cz.zcu.yafmt.clang.bcl.model.util;

import cz.zcu.yafmt.clang.bcl.model.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see cz.zcu.yafmt.clang.bcl.model.ModelPackage
 * @generated
 */
public class ModelAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static ModelPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ModelAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = ModelPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
     * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject)object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ModelSwitch<Adapter> modelSwitch =
        new ModelSwitch<Adapter>() {
            @Override
            public Adapter caseExpression(Expression object) {
                return createExpressionAdapter();
            }
            @Override
            public Adapter caseForAllContextualExpression(ForAllContextualExpression object) {
                return createForAllContextualExpressionAdapter();
            }
            @Override
            public Adapter caseExistsContextualExpression(ExistsContextualExpression object) {
                return createExistsContextualExpressionAdapter();
            }
            @Override
            public Adapter caseEquation(Equation object) {
                return createEquationAdapter();
            }
            @Override
            public Adapter caseImplication(Implication object) {
                return createImplicationAdapter();
            }
            @Override
            public Adapter caseDisjunction(Disjunction object) {
                return createDisjunctionAdapter();
            }
            @Override
            public Adapter caseConjunction(Conjunction object) {
                return createConjunctionAdapter();
            }
            @Override
            public Adapter caseNegation(Negation object) {
                return createNegationAdapter();
            }
            @Override
            public Adapter casePrimaryExpression(PrimaryExpression object) {
                return createPrimaryExpressionAdapter();
            }
            @Override
            public Adapter defaultCase(EObject object) {
                return createEObjectAdapter();
            }
        };

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(Notifier target) {
        return modelSwitch.doSwitch((EObject)target);
    }


    /**
     * Creates a new adapter for an object of class '{@link cz.zcu.yafmt.clang.bcl.model.Expression <em>Expression</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see cz.zcu.yafmt.clang.bcl.model.Expression
     * @generated
     */
    public Adapter createExpressionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link cz.zcu.yafmt.clang.bcl.model.ForAllContextualExpression <em>For All Contextual Expression</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see cz.zcu.yafmt.clang.bcl.model.ForAllContextualExpression
     * @generated
     */
    public Adapter createForAllContextualExpressionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link cz.zcu.yafmt.clang.bcl.model.ExistsContextualExpression <em>Exists Contextual Expression</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see cz.zcu.yafmt.clang.bcl.model.ExistsContextualExpression
     * @generated
     */
    public Adapter createExistsContextualExpressionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link cz.zcu.yafmt.clang.bcl.model.Equation <em>Equation</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see cz.zcu.yafmt.clang.bcl.model.Equation
     * @generated
     */
    public Adapter createEquationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link cz.zcu.yafmt.clang.bcl.model.Implication <em>Implication</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see cz.zcu.yafmt.clang.bcl.model.Implication
     * @generated
     */
    public Adapter createImplicationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link cz.zcu.yafmt.clang.bcl.model.Disjunction <em>Disjunction</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see cz.zcu.yafmt.clang.bcl.model.Disjunction
     * @generated
     */
    public Adapter createDisjunctionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link cz.zcu.yafmt.clang.bcl.model.Conjunction <em>Conjunction</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see cz.zcu.yafmt.clang.bcl.model.Conjunction
     * @generated
     */
    public Adapter createConjunctionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link cz.zcu.yafmt.clang.bcl.model.Negation <em>Negation</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see cz.zcu.yafmt.clang.bcl.model.Negation
     * @generated
     */
    public Adapter createNegationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link cz.zcu.yafmt.clang.bcl.model.PrimaryExpression <em>Primary Expression</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see cz.zcu.yafmt.clang.bcl.model.PrimaryExpression
     * @generated
     */
    public Adapter createPrimaryExpressionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
     * This default implementation returns null.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} //ModelAdapterFactory
