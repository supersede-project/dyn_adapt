/**
 */
package cz.zcu.yafmt.clang.bcl.model.impl;

import cz.zcu.yafmt.clang.bcl.model.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelFactoryImpl extends EFactoryImpl implements ModelFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static ModelFactory init() {
        try {
            ModelFactory theModelFactory = (ModelFactory)EPackage.Registry.INSTANCE.getEFactory("http://zcu.cz/yafmt/clang/bcl"); 
            if (theModelFactory != null) {
                return theModelFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new ModelFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ModelFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case ModelPackage.FOR_ALL_CONTEXTUAL_EXPRESSION: return createForAllContextualExpression();
            case ModelPackage.EXISTS_CONTEXTUAL_EXPRESSION: return createExistsContextualExpression();
            case ModelPackage.EQUATION: return createEquation();
            case ModelPackage.IMPLICATION: return createImplication();
            case ModelPackage.DISJUNCTION: return createDisjunction();
            case ModelPackage.CONJUNCTION: return createConjunction();
            case ModelPackage.NEGATION: return createNegation();
            case ModelPackage.PRIMARY_EXPRESSION: return createPrimaryExpression();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ForAllContextualExpression createForAllContextualExpression() {
        ForAllContextualExpressionImpl forAllContextualExpression = new ForAllContextualExpressionImpl();
        return forAllContextualExpression;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ExistsContextualExpression createExistsContextualExpression() {
        ExistsContextualExpressionImpl existsContextualExpression = new ExistsContextualExpressionImpl();
        return existsContextualExpression;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Equation createEquation() {
        EquationImpl equation = new EquationImpl();
        return equation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Implication createImplication() {
        ImplicationImpl implication = new ImplicationImpl();
        return implication;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Disjunction createDisjunction() {
        DisjunctionImpl disjunction = new DisjunctionImpl();
        return disjunction;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Conjunction createConjunction() {
        ConjunctionImpl conjunction = new ConjunctionImpl();
        return conjunction;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Negation createNegation() {
        NegationImpl negation = new NegationImpl();
        return negation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PrimaryExpression createPrimaryExpression() {
        PrimaryExpressionImpl primaryExpression = new PrimaryExpressionImpl();
        return primaryExpression;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ModelPackage getModelPackage() {
        return (ModelPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static ModelPackage getPackage() {
        return ModelPackage.eINSTANCE;
    }

} //ModelFactoryImpl
