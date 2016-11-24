/**
 */
package cz.zcu.yafmt.ui.editors.fm.layout;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see cz.zcu.yafmt.ui.editors.fm.layout.LayoutDataFactory
 * @model kind="package"
 * @generated
 */
public interface LayoutDataPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "layout";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://zcu.cz/yafmt/ui/editors/fm/layout";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "layout";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    LayoutDataPackage eINSTANCE = cz.zcu.yafmt.ui.editors.fm.layout.impl.LayoutDataPackageImpl.init();

    /**
     * The meta object id for the '{@link cz.zcu.yafmt.ui.editors.fm.layout.impl.LayoutDataImpl <em>Layout Data</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cz.zcu.yafmt.ui.editors.fm.layout.impl.LayoutDataImpl
     * @see cz.zcu.yafmt.ui.editors.fm.layout.impl.LayoutDataPackageImpl#getLayoutData()
     * @generated
     */
    int LAYOUT_DATA = 0;

    /**
     * The feature id for the '<em><b>Mapping</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LAYOUT_DATA__MAPPING = 0;

    /**
     * The number of structural features of the '<em>Layout Data</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LAYOUT_DATA_FEATURE_COUNT = 1;

    /**
     * The meta object id for the '{@link cz.zcu.yafmt.ui.editors.fm.layout.impl.EObjectToRectangleImpl <em>EObject To Rectangle</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cz.zcu.yafmt.ui.editors.fm.layout.impl.EObjectToRectangleImpl
     * @see cz.zcu.yafmt.ui.editors.fm.layout.impl.LayoutDataPackageImpl#getEObjectToRectangle()
     * @generated
     */
    int EOBJECT_TO_RECTANGLE = 1;

    /**
     * The feature id for the '<em><b>Key</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EOBJECT_TO_RECTANGLE__KEY = 0;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EOBJECT_TO_RECTANGLE__VALUE = 1;

    /**
     * The number of structural features of the '<em>EObject To Rectangle</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EOBJECT_TO_RECTANGLE_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '<em>Rectangle</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.draw2d.geometry.Rectangle
     * @see cz.zcu.yafmt.ui.editors.fm.layout.impl.LayoutDataPackageImpl#getRectangle()
     * @generated
     */
    int RECTANGLE = 2;


    /**
     * Returns the meta object for class '{@link cz.zcu.yafmt.ui.editors.fm.layout.LayoutData <em>Layout Data</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Layout Data</em>'.
     * @see cz.zcu.yafmt.ui.editors.fm.layout.LayoutData
     * @generated
     */
    EClass getLayoutData();

    /**
     * Returns the meta object for the map '{@link cz.zcu.yafmt.ui.editors.fm.layout.LayoutData#getMapping <em>Mapping</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the map '<em>Mapping</em>'.
     * @see cz.zcu.yafmt.ui.editors.fm.layout.LayoutData#getMapping()
     * @see #getLayoutData()
     * @generated
     */
    EReference getLayoutData_Mapping();

    /**
     * Returns the meta object for class '{@link java.util.Map.Entry <em>EObject To Rectangle</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>EObject To Rectangle</em>'.
     * @see java.util.Map.Entry
     * @model keyType="org.eclipse.emf.ecore.EObject"
     *        valueDataType="cz.zcu.yafmt.ui.editors.fm.layout.Rectangle"
     * @generated
     */
    EClass getEObjectToRectangle();

    /**
     * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Key</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Key</em>'.
     * @see java.util.Map.Entry
     * @see #getEObjectToRectangle()
     * @generated
     */
    EReference getEObjectToRectangle_Key();

    /**
     * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see java.util.Map.Entry
     * @see #getEObjectToRectangle()
     * @generated
     */
    EAttribute getEObjectToRectangle_Value();

    /**
     * Returns the meta object for data type '{@link org.eclipse.draw2d.geometry.Rectangle <em>Rectangle</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Rectangle</em>'.
     * @see org.eclipse.draw2d.geometry.Rectangle
     * @model instanceClass="org.eclipse.draw2d.geometry.Rectangle"
     * @generated
     */
    EDataType getRectangle();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    LayoutDataFactory getLayoutDataFactory();

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
         * The meta object literal for the '{@link cz.zcu.yafmt.ui.editors.fm.layout.impl.LayoutDataImpl <em>Layout Data</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see cz.zcu.yafmt.ui.editors.fm.layout.impl.LayoutDataImpl
         * @see cz.zcu.yafmt.ui.editors.fm.layout.impl.LayoutDataPackageImpl#getLayoutData()
         * @generated
         */
        EClass LAYOUT_DATA = eINSTANCE.getLayoutData();

        /**
         * The meta object literal for the '<em><b>Mapping</b></em>' map feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference LAYOUT_DATA__MAPPING = eINSTANCE.getLayoutData_Mapping();

        /**
         * The meta object literal for the '{@link cz.zcu.yafmt.ui.editors.fm.layout.impl.EObjectToRectangleImpl <em>EObject To Rectangle</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see cz.zcu.yafmt.ui.editors.fm.layout.impl.EObjectToRectangleImpl
         * @see cz.zcu.yafmt.ui.editors.fm.layout.impl.LayoutDataPackageImpl#getEObjectToRectangle()
         * @generated
         */
        EClass EOBJECT_TO_RECTANGLE = eINSTANCE.getEObjectToRectangle();

        /**
         * The meta object literal for the '<em><b>Key</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EOBJECT_TO_RECTANGLE__KEY = eINSTANCE.getEObjectToRectangle_Key();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EOBJECT_TO_RECTANGLE__VALUE = eINSTANCE.getEObjectToRectangle_Value();

        /**
         * The meta object literal for the '<em>Rectangle</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.draw2d.geometry.Rectangle
         * @see cz.zcu.yafmt.ui.editors.fm.layout.impl.LayoutDataPackageImpl#getRectangle()
         * @generated
         */
        EDataType RECTANGLE = eINSTANCE.getRectangle();

    }

} //LayoutDataPackage
