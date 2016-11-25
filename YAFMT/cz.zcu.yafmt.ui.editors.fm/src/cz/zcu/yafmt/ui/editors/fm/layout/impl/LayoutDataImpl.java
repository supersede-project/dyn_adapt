/**
 */
package cz.zcu.yafmt.ui.editors.fm.layout.impl;

import cz.zcu.yafmt.ui.editors.fm.layout.LayoutData;
import cz.zcu.yafmt.ui.editors.fm.layout.LayoutDataPackage;

import org.eclipse.draw2d.geometry.Rectangle;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreEMap;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Layout Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cz.zcu.yafmt.ui.editors.fm.layout.impl.LayoutDataImpl#getMapping <em>Mapping</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LayoutDataImpl extends EObjectImpl implements LayoutData {
    /**
     * The cached value of the '{@link #getMapping() <em>Mapping</em>}' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMapping()
     * @generated
     * @ordered
     */
    protected EMap<EObject, Rectangle> mapping;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected LayoutDataImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return LayoutDataPackage.Literals.LAYOUT_DATA;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EMap<EObject, Rectangle> getMapping() {
        if (mapping == null) {
            mapping = new EcoreEMap<EObject,Rectangle>(LayoutDataPackage.Literals.EOBJECT_TO_RECTANGLE, EObjectToRectangleImpl.class, this, LayoutDataPackage.LAYOUT_DATA__MAPPING);
        }
        return mapping;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public void set(EObject object, Rectangle bounds) {
        getMapping().put(object, bounds);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public Rectangle get(EObject object) {
        return getMapping().get(object);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public Rectangle remove(EObject object) {
        return getMapping().removeKey(object);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case LayoutDataPackage.LAYOUT_DATA__MAPPING:
                if (coreType) return getMapping();
                else return getMapping().map();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case LayoutDataPackage.LAYOUT_DATA__MAPPING:
                return mapping != null && !mapping.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //LayoutDataImpl
