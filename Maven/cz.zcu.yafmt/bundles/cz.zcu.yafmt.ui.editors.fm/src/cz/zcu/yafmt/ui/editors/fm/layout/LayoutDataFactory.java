/**
 */
package cz.zcu.yafmt.ui.editors.fm.layout;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see cz.zcu.yafmt.ui.editors.fm.layout.LayoutDataPackage
 * @generated
 */
public interface LayoutDataFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    LayoutDataFactory eINSTANCE = cz.zcu.yafmt.ui.editors.fm.layout.impl.LayoutDataFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Layout Data</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Layout Data</em>'.
     * @generated
     */
    LayoutData createLayoutData();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    LayoutDataPackage getLayoutDataPackage();

} //LayoutDataFactory
