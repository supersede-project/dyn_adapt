/**
 */
package cz.zcu.yafmt.ui.editors.fm.layout.impl;

import cz.zcu.yafmt.ui.editors.fm.layout.LayoutDataPackage;

import org.eclipse.draw2d.geometry.Rectangle;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EObject To Rectangle</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cz.zcu.yafmt.ui.editors.fm.layout.impl.EObjectToRectangleImpl#getTypedKey <em>Key</em>}</li>
 *   <li>{@link cz.zcu.yafmt.ui.editors.fm.layout.impl.EObjectToRectangleImpl#getTypedValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EObjectToRectangleImpl extends EObjectImpl implements BasicEMap.Entry<EObject,Rectangle> {
    /**
     * The cached value of the '{@link #getTypedKey() <em>Key</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTypedKey()
     * @generated
     * @ordered
     */
    protected EObject key;

    /**
     * The default value of the '{@link #getTypedValue() <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTypedValue()
     * @generated
     * @ordered
     */
    protected static final Rectangle VALUE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getTypedValue() <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTypedValue()
     * @generated
     * @ordered
     */
    protected Rectangle value = VALUE_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EObjectToRectangleImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return LayoutDataPackage.Literals.EOBJECT_TO_RECTANGLE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EObject getTypedKey() {
        if (key != null && key.eIsProxy()) {
            InternalEObject oldKey = (InternalEObject)key;
            key = eResolveProxy(oldKey);
            if (key != oldKey) {
            }
        }
        return key;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EObject basicGetTypedKey() {
        return key;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTypedKey(EObject newKey) {
        key = newKey;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Rectangle getTypedValue() {
        return value;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTypedValue(Rectangle newValue) {
        value = newValue;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case LayoutDataPackage.EOBJECT_TO_RECTANGLE__KEY:
                if (resolve) return getTypedKey();
                return basicGetTypedKey();
            case LayoutDataPackage.EOBJECT_TO_RECTANGLE__VALUE:
                return getTypedValue();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case LayoutDataPackage.EOBJECT_TO_RECTANGLE__KEY:
                setTypedKey((EObject)newValue);
                return;
            case LayoutDataPackage.EOBJECT_TO_RECTANGLE__VALUE:
                setTypedValue((Rectangle)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case LayoutDataPackage.EOBJECT_TO_RECTANGLE__KEY:
                setTypedKey((EObject)null);
                return;
            case LayoutDataPackage.EOBJECT_TO_RECTANGLE__VALUE:
                setTypedValue(VALUE_EDEFAULT);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case LayoutDataPackage.EOBJECT_TO_RECTANGLE__KEY:
                return key != null;
            case LayoutDataPackage.EOBJECT_TO_RECTANGLE__VALUE:
                return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (value: ");
        result.append(value);
        result.append(')');
        return result.toString();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected int hash = -1;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getHash() {
        if (hash == -1) {
            Object theKey = getKey();
            hash = (theKey == null ? 0 : theKey.hashCode());
        }
        return hash;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setHash(int hash) {
        this.hash = hash;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EObject getKey() {
        return getTypedKey();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setKey(EObject key) {
        setTypedKey(key);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Rectangle getValue() {
        return getTypedValue();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public Rectangle setValue(Rectangle value) {
        Rectangle oldValue = getValue();
        setTypedValue(value);
        // EMF does not generate this notification code for some reason!!!
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, LayoutDataPackage.EOBJECT_TO_RECTANGLE__VALUE, oldValue, value));
        return oldValue;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    public EMap<EObject, Rectangle> getEMap() {
        EObject container = eContainer();
        return container == null ? null : (EMap<EObject, Rectangle>)container.eGet(eContainmentFeature());
    }

} //EObjectToRectangleImpl
