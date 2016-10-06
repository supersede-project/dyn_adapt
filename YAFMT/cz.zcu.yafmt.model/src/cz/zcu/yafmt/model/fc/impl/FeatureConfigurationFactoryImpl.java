/**
 */
package cz.zcu.yafmt.model.fc.impl;

import cz.zcu.yafmt.model.fc.*;

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
public class FeatureConfigurationFactoryImpl extends EFactoryImpl implements FeatureConfigurationFactory {
    /**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public static FeatureConfigurationFactory init() {
		try {
			FeatureConfigurationFactory theFeatureConfigurationFactory = (FeatureConfigurationFactory)EPackage.Registry.INSTANCE.getEFactory(FeatureConfigurationPackage.eNS_URI);
			if (theFeatureConfigurationFactory != null) {
				return theFeatureConfigurationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new FeatureConfigurationFactoryImpl();
	}

    /**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public FeatureConfigurationFactoryImpl() {
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
			case FeatureConfigurationPackage.FEATURE_CONFIGURATION: return createFeatureConfiguration();
			case FeatureConfigurationPackage.SELECTION: return createSelection();
			case FeatureConfigurationPackage.BOOLEAN_VALUE: return createBooleanValue();
			case FeatureConfigurationPackage.INTEGER_VALUE: return createIntegerValue();
			case FeatureConfigurationPackage.DOUBLE_VALUE: return createDoubleValue();
			case FeatureConfigurationPackage.STRING_VALUE: return createStringValue();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public FeatureConfiguration createFeatureConfiguration() {
		FeatureConfigurationImpl featureConfiguration = new FeatureConfigurationImpl();
		return featureConfiguration;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Selection createSelection() {
		SelectionImpl selection = new SelectionImpl();
		return selection;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public BooleanValue createBooleanValue() {
		BooleanValueImpl booleanValue = new BooleanValueImpl();
		return booleanValue;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public IntegerValue createIntegerValue() {
		IntegerValueImpl integerValue = new IntegerValueImpl();
		return integerValue;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public DoubleValue createDoubleValue() {
		DoubleValueImpl doubleValue = new DoubleValueImpl();
		return doubleValue;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public StringValue createStringValue() {
		StringValueImpl stringValue = new StringValueImpl();
		return stringValue;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public FeatureConfigurationPackage getFeatureConfigurationPackage() {
		return (FeatureConfigurationPackage)getEPackage();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
    @Deprecated
    public static FeatureConfigurationPackage getPackage() {
		return FeatureConfigurationPackage.eINSTANCE;
	}

} //FeatureConfigurationFactoryImpl
