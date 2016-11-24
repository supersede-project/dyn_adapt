/**
 */
package cz.zcu.yafmt.ui.editors.fm.layout;

import org.eclipse.draw2d.geometry.Rectangle;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Layout Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cz.zcu.yafmt.ui.editors.fm.layout.LayoutData#getMapping <em>Mapping</em>}</li>
 * </ul>
 * </p>
 *
 * @see cz.zcu.yafmt.ui.editors.fm.layout.LayoutDataPackage#getLayoutData()
 * @model
 * @generated
 */
public interface LayoutData extends EObject {
    /**
     * Returns the value of the '<em><b>Mapping</b></em>' map.
     * The key is of type {@link org.eclipse.emf.ecore.EObject},
     * and the value is of type {@link org.eclipse.draw2d.geometry.Rectangle},
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Mapping</em>' map isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Mapping</em>' map.
     * @see cz.zcu.yafmt.ui.editors.fm.layout.LayoutDataPackage#getLayoutData_Mapping()
     * @model mapType="cz.zcu.yafmt.ui.editors.fm.layout.EObjectToRectangle<org.eclipse.emf.ecore.EObject, cz.zcu.yafmt.ui.editors.fm.layout.Rectangle>" changeable="false"
     * @generated
     */
    EMap<EObject, Rectangle> getMapping();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model boundsDataType="cz.zcu.yafmt.ui.editors.fm.layout.Rectangle"
     * @generated
     */
    void set(EObject object, Rectangle bounds);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model dataType="cz.zcu.yafmt.ui.editors.fm.layout.Rectangle"
     * @generated
     */
    Rectangle get(EObject object);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model dataType="cz.zcu.yafmt.ui.editors.fm.layout.Rectangle"
     * @generated
     */
    Rectangle remove(EObject object);

} // LayoutData
