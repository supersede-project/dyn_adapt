/**
 */
package cz.zcu.yafmt.model.fc.util;

import cz.zcu.yafmt.model.fc.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see cz.zcu.yafmt.model.fc.FeatureConfigurationPackage
 * @generated
 */
public class FeatureConfigurationAdapterFactory extends AdapterFactoryImpl {
    /**
	 * The cached model package.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected static FeatureConfigurationPackage modelPackage;

    /**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public FeatureConfigurationAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = FeatureConfigurationPackage.eINSTANCE;
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
    protected FeatureConfigurationSwitch<Adapter> modelSwitch =
        new FeatureConfigurationSwitch<Adapter>() {
			@Override
			public Adapter caseFeatureConfiguration(FeatureConfiguration object) {
				return createFeatureConfigurationAdapter();
			}
			@Override
			public Adapter caseSelection(Selection object) {
				return createSelectionAdapter();
			}
			@Override
			public Adapter caseAttributeValue(AttributeValue object) {
				return createAttributeValueAdapter();
			}
			@Override
			public Adapter caseBooleanValue(BooleanValue object) {
				return createBooleanValueAdapter();
			}
			@Override
			public Adapter caseIntegerValue(IntegerValue object) {
				return createIntegerValueAdapter();
			}
			@Override
			public Adapter caseDoubleValue(DoubleValue object) {
				return createDoubleValueAdapter();
			}
			@Override
			public Adapter caseStringValue(StringValue object) {
				return createStringValueAdapter();
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
     * @generated NOT
     */
    @Override
    public Adapter createAdapter(Notifier target) {
        // EMF Edit sometimes try to pass XMIResourceImpl as the target for some strange reason.
        if(target instanceof EObject)
            return modelSwitch.doSwitch((EObject)target);
        return null;
    }


    /**
	 * Creates a new adapter for an object of class '{@link cz.zcu.yafmt.model.fc.FeatureConfiguration <em>Feature Configuration</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cz.zcu.yafmt.model.fc.FeatureConfiguration
	 * @generated
	 */
    public Adapter createFeatureConfigurationAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link cz.zcu.yafmt.model.fc.Selection <em>Selection</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cz.zcu.yafmt.model.fc.Selection
	 * @generated
	 */
    public Adapter createSelectionAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link cz.zcu.yafmt.model.fc.AttributeValue <em>Attribute Value</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cz.zcu.yafmt.model.fc.AttributeValue
	 * @generated
	 */
    public Adapter createAttributeValueAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link cz.zcu.yafmt.model.fc.BooleanValue <em>Boolean Value</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cz.zcu.yafmt.model.fc.BooleanValue
	 * @generated
	 */
    public Adapter createBooleanValueAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link cz.zcu.yafmt.model.fc.IntegerValue <em>Integer Value</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cz.zcu.yafmt.model.fc.IntegerValue
	 * @generated
	 */
    public Adapter createIntegerValueAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link cz.zcu.yafmt.model.fc.DoubleValue <em>Double Value</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cz.zcu.yafmt.model.fc.DoubleValue
	 * @generated
	 */
    public Adapter createDoubleValueAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link cz.zcu.yafmt.model.fc.StringValue <em>String Value</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cz.zcu.yafmt.model.fc.StringValue
	 * @generated
	 */
    public Adapter createStringValueAdapter() {
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

} //FeatureConfigurationAdapterFactory
