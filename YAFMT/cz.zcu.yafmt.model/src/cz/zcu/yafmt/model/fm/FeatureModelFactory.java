/**
 */
package cz.zcu.yafmt.model.fm;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage
 * @generated
 */
public interface FeatureModelFactory extends EFactory {
    /**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    FeatureModelFactory eINSTANCE = cz.zcu.yafmt.model.fm.impl.FeatureModelFactoryImpl.init();

    /**
	 * Returns a new object of class '<em>Feature Model</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Feature Model</em>'.
	 * @generated
	 */
    FeatureModel createFeatureModel();

    /**
	 * Returns a new object of class '<em>Feature</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Feature</em>'.
	 * @generated
	 */
    Feature createFeature();

    /**
	 * Returns a new object of class '<em>Group</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Group</em>'.
	 * @generated
	 */
    Group createGroup();

    /**
	 * Returns a new object of class '<em>Attribute</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute</em>'.
	 * @generated
	 */
    Attribute createAttribute();

    /**
	 * Returns a new object of class '<em>Constraint</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Constraint</em>'.
	 * @generated
	 */
    Constraint createConstraint();

    /**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
    FeatureModelPackage getFeatureModelPackage();

} //FeatureModelFactory
