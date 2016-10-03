/**
 */
package cz.zcu.yafmt.model.fc;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see cz.zcu.yafmt.model.fc.FeatureConfigurationPackage
 * @generated
 */
public interface FeatureConfigurationFactory extends EFactory {
    /**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    FeatureConfigurationFactory eINSTANCE = cz.zcu.yafmt.model.fc.impl.FeatureConfigurationFactoryImpl.init();

    /**
	 * Returns a new object of class '<em>Feature Configuration</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Feature Configuration</em>'.
	 * @generated
	 */
    FeatureConfiguration createFeatureConfiguration();

    /**
	 * Returns a new object of class '<em>Selection</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Selection</em>'.
	 * @generated
	 */
    Selection createSelection();

    /**
	 * Returns a new object of class '<em>Boolean Value</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Value</em>'.
	 * @generated
	 */
    BooleanValue createBooleanValue();

    /**
	 * Returns a new object of class '<em>Integer Value</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Integer Value</em>'.
	 * @generated
	 */
    IntegerValue createIntegerValue();

    /**
	 * Returns a new object of class '<em>Double Value</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Double Value</em>'.
	 * @generated
	 */
    DoubleValue createDoubleValue();

    /**
	 * Returns a new object of class '<em>String Value</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Value</em>'.
	 * @generated
	 */
    StringValue createStringValue();

    /**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
    FeatureConfigurationPackage getFeatureConfigurationPackage();

} //FeatureConfigurationFactory
