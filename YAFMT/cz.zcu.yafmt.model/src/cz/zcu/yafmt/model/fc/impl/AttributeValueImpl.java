/**
 */
package cz.zcu.yafmt.model.fc.impl;


import cz.zcu.yafmt.model.fc.AttributeValue;
import cz.zcu.yafmt.model.fc.FeatureConfigurationPackage;
import cz.zcu.yafmt.model.fc.Selection;
import cz.zcu.yafmt.model.fm.Attribute;
import cz.zcu.yafmt.model.fm.Feature;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link cz.zcu.yafmt.model.fc.impl.AttributeValueImpl#getId <em>Id</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fc.impl.AttributeValueImpl#getName <em>Name</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fc.impl.AttributeValueImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fc.impl.AttributeValueImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fc.impl.AttributeValueImpl#getSelection <em>Selection</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fc.impl.AttributeValueImpl#getAttribute <em>Attribute</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AttributeValueImpl extends EObjectImpl implements AttributeValue {
    /**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
    protected static final String ID_EDEFAULT = null;

    /**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
    protected String id = ID_EDEFAULT;

    /**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
    protected static final String NAME_EDEFAULT = null;

    /**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
    protected static final String DESCRIPTION_EDEFAULT = null;

    /**
	 * The default value of the '{@link #getComment() <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getComment()
	 * @generated
	 * @ordered
	 */
    protected static final String COMMENT_EDEFAULT = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected AttributeValueImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return FeatureConfigurationPackage.Literals.ATTRIBUTE_VALUE;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String getId() {
		return id;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FeatureConfigurationPackage.ATTRIBUTE_VALUE__ID, oldId, id));
	}

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public String getName() {
        Attribute attribute = getAttribute();
        return (attribute != null) ? attribute.getName() : null;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public String getDescription() {
        Attribute attribute = getAttribute();
        return (attribute != null) ? attribute.getDescription() : null;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public String getComment() {
        Attribute attribute = getAttribute();
        return (attribute != null) ? attribute.getComment() : null;
    }

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Selection getSelection() {
		if (eContainerFeatureID() != FeatureConfigurationPackage.ATTRIBUTE_VALUE__SELECTION) return null;
		return (Selection)eInternalContainer();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain basicSetSelection(Selection newSelection, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSelection, FeatureConfigurationPackage.ATTRIBUTE_VALUE__SELECTION, msgs);
		return msgs;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setSelection(Selection newSelection) {
		if (newSelection != eInternalContainer() || (eContainerFeatureID() != FeatureConfigurationPackage.ATTRIBUTE_VALUE__SELECTION && newSelection != null)) {
			if (EcoreUtil.isAncestor(this, newSelection))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSelection != null)
				msgs = ((InternalEObject)newSelection).eInverseAdd(this, FeatureConfigurationPackage.SELECTION__VALUES, Selection.class, msgs);
			msgs = basicSetSelection(newSelection, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FeatureConfigurationPackage.ATTRIBUTE_VALUE__SELECTION, newSelection, newSelection));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Attribute getAttribute() {
		Attribute attribute = basicGetAttribute();
		return attribute != null && attribute.eIsProxy() ? (Attribute)eResolveProxy((InternalEObject)attribute) : attribute;
	}

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public Attribute basicGetAttribute() {
        Selection selection = getSelection();
        if(selection == null)
            return null;
        
        Feature feature = selection.getFeature();
        if(feature == null)
            return null;
        
        for(Attribute attribute: feature.getAttributes()) {
            if(id.equals(attribute.getId()))
                return attribute;
        }
        return null;
    }

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FeatureConfigurationPackage.ATTRIBUTE_VALUE__SELECTION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSelection((Selection)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FeatureConfigurationPackage.ATTRIBUTE_VALUE__SELECTION:
				return basicSetSelection(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case FeatureConfigurationPackage.ATTRIBUTE_VALUE__SELECTION:
				return eInternalContainer().eInverseRemove(this, FeatureConfigurationPackage.SELECTION__VALUES, Selection.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FeatureConfigurationPackage.ATTRIBUTE_VALUE__ID:
				return getId();
			case FeatureConfigurationPackage.ATTRIBUTE_VALUE__NAME:
				return getName();
			case FeatureConfigurationPackage.ATTRIBUTE_VALUE__DESCRIPTION:
				return getDescription();
			case FeatureConfigurationPackage.ATTRIBUTE_VALUE__COMMENT:
				return getComment();
			case FeatureConfigurationPackage.ATTRIBUTE_VALUE__SELECTION:
				return getSelection();
			case FeatureConfigurationPackage.ATTRIBUTE_VALUE__ATTRIBUTE:
				if (resolve) return getAttribute();
				return basicGetAttribute();
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
			case FeatureConfigurationPackage.ATTRIBUTE_VALUE__ID:
				setId((String)newValue);
				return;
			case FeatureConfigurationPackage.ATTRIBUTE_VALUE__SELECTION:
				setSelection((Selection)newValue);
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
			case FeatureConfigurationPackage.ATTRIBUTE_VALUE__ID:
				setId(ID_EDEFAULT);
				return;
			case FeatureConfigurationPackage.ATTRIBUTE_VALUE__SELECTION:
				setSelection((Selection)null);
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
			case FeatureConfigurationPackage.ATTRIBUTE_VALUE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case FeatureConfigurationPackage.ATTRIBUTE_VALUE__NAME:
				return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
			case FeatureConfigurationPackage.ATTRIBUTE_VALUE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? getDescription() != null : !DESCRIPTION_EDEFAULT.equals(getDescription());
			case FeatureConfigurationPackage.ATTRIBUTE_VALUE__COMMENT:
				return COMMENT_EDEFAULT == null ? getComment() != null : !COMMENT_EDEFAULT.equals(getComment());
			case FeatureConfigurationPackage.ATTRIBUTE_VALUE__SELECTION:
				return getSelection() != null;
			case FeatureConfigurationPackage.ATTRIBUTE_VALUE__ATTRIBUTE:
				return basicGetAttribute() != null;
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
		result.append(" (id: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}

} //AttributeValueImpl
