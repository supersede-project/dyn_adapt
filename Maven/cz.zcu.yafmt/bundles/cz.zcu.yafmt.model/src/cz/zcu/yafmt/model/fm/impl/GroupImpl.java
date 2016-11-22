/**
 */
package cz.zcu.yafmt.model.fm.impl;

import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.FeatureModelPackage;
import cz.zcu.yafmt.model.fm.Group;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link cz.zcu.yafmt.model.fm.impl.GroupImpl#getLower <em>Lower</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.impl.GroupImpl#getUpper <em>Upper</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.impl.GroupImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.impl.GroupImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.impl.GroupImpl#isXor <em>Xor</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.impl.GroupImpl#isOr <em>Or</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.impl.GroupImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.impl.GroupImpl#getFeatures <em>Features</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GroupImpl extends EObjectImpl implements Group {
    /**
	 * The default value of the '{@link #getLower() <em>Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getLower()
	 * @generated
	 * @ordered
	 */
    protected static final int LOWER_EDEFAULT = 1;

    /**
	 * The cached value of the '{@link #getLower() <em>Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getLower()
	 * @generated
	 * @ordered
	 */
    protected int lower = LOWER_EDEFAULT;

    /**
	 * The default value of the '{@link #getUpper() <em>Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getUpper()
	 * @generated
	 * @ordered
	 */
    protected static final int UPPER_EDEFAULT = 1;

    /**
	 * The cached value of the '{@link #getUpper() <em>Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getUpper()
	 * @generated
	 * @ordered
	 */
    protected int upper = UPPER_EDEFAULT;

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
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
    protected String description = DESCRIPTION_EDEFAULT;

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
	 * The cached value of the '{@link #getComment() <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getComment()
	 * @generated
	 * @ordered
	 */
    protected String comment = COMMENT_EDEFAULT;

    /**
	 * The default value of the '{@link #isXor() <em>Xor</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #isXor()
	 * @generated
	 * @ordered
	 */
    protected static final boolean XOR_EDEFAULT = false;

    /**
	 * The default value of the '{@link #isOr() <em>Or</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #isOr()
	 * @generated
	 * @ordered
	 */
    protected static final boolean OR_EDEFAULT = false;

    /**
	 * The cached value of the '{@link #getFeatures() <em>Features</em>}' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getFeatures()
	 * @generated
	 * @ordered
	 */
    protected EList<Feature> features;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected GroupImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return FeatureModelPackage.Literals.GROUP;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public int getLower() {
		return lower;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setLower(int newLower) {
		int oldLower = lower;
		lower = newLower;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FeatureModelPackage.GROUP__LOWER, oldLower, lower));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public int getUpper() {
		return upper;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setUpper(int newUpper) {
		int oldUpper = upper;
		upper = newUpper;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FeatureModelPackage.GROUP__UPPER, oldUpper, upper));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String getDescription() {
		return description;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FeatureModelPackage.GROUP__DESCRIPTION, oldDescription, description));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String getComment() {
		return comment;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setComment(String newComment) {
		String oldComment = comment;
		comment = newComment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FeatureModelPackage.GROUP__COMMENT, oldComment, comment));
	}

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public boolean isXor() {
        return (lower == 1) && (upper == 1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public void setXor(boolean newXor) {
        setOr(!newXor);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public boolean isOr() {
        return ((lower == 1) && (upper == computeOrUpper()));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public void setOr(boolean newOr) {
        setLower(1);
        
        if(newOr)
            setUpper(computeOrUpper());
        else
            setUpper(1);
    }
    
    private int computeOrUpper() {
        /*
        int upperSum = 0;
        for(Feature feature: getFeatures()) {
            int featureUpper = feature.getUpper();
            if(featureUpper == -1)
                return -1;
            upperSum += featureUpper;
        }
        return Math.max(1, upperSum);
        */
        return -1;
    }

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Feature getParent() {
		if (eContainerFeatureID() != FeatureModelPackage.GROUP__PARENT) return null;
		return (Feature)eInternalContainer();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain basicSetParent(Feature newParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParent, FeatureModelPackage.GROUP__PARENT, msgs);
		return msgs;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setParent(Feature newParent) {
		if (newParent != eInternalContainer() || (eContainerFeatureID() != FeatureModelPackage.GROUP__PARENT && newParent != null)) {
			if (EcoreUtil.isAncestor(this, newParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, FeatureModelPackage.FEATURE__GROUPS, Feature.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FeatureModelPackage.GROUP__PARENT, newParent, newParent));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<Feature> getFeatures() {
		if (features == null) {
			features = new EObjectContainmentWithInverseEList<Feature>(Feature.class, this, FeatureModelPackage.GROUP__FEATURES, FeatureModelPackage.FEATURE__PARENT_GROUP);
		}
		return features;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FeatureModelPackage.GROUP__PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParent((Feature)otherEnd, msgs);
			case FeatureModelPackage.GROUP__FEATURES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFeatures()).basicAdd(otherEnd, msgs);
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
			case FeatureModelPackage.GROUP__PARENT:
				return basicSetParent(null, msgs);
			case FeatureModelPackage.GROUP__FEATURES:
				return ((InternalEList<?>)getFeatures()).basicRemove(otherEnd, msgs);
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
			case FeatureModelPackage.GROUP__PARENT:
				return eInternalContainer().eInverseRemove(this, FeatureModelPackage.FEATURE__GROUPS, Feature.class, msgs);
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
			case FeatureModelPackage.GROUP__LOWER:
				return getLower();
			case FeatureModelPackage.GROUP__UPPER:
				return getUpper();
			case FeatureModelPackage.GROUP__DESCRIPTION:
				return getDescription();
			case FeatureModelPackage.GROUP__COMMENT:
				return getComment();
			case FeatureModelPackage.GROUP__XOR:
				return isXor();
			case FeatureModelPackage.GROUP__OR:
				return isOr();
			case FeatureModelPackage.GROUP__PARENT:
				return getParent();
			case FeatureModelPackage.GROUP__FEATURES:
				return getFeatures();
		}
		return super.eGet(featureID, resolve, coreType);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FeatureModelPackage.GROUP__LOWER:
				setLower((Integer)newValue);
				return;
			case FeatureModelPackage.GROUP__UPPER:
				setUpper((Integer)newValue);
				return;
			case FeatureModelPackage.GROUP__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case FeatureModelPackage.GROUP__COMMENT:
				setComment((String)newValue);
				return;
			case FeatureModelPackage.GROUP__XOR:
				setXor((Boolean)newValue);
				return;
			case FeatureModelPackage.GROUP__OR:
				setOr((Boolean)newValue);
				return;
			case FeatureModelPackage.GROUP__PARENT:
				setParent((Feature)newValue);
				return;
			case FeatureModelPackage.GROUP__FEATURES:
				getFeatures().clear();
				getFeatures().addAll((Collection<? extends Feature>)newValue);
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
			case FeatureModelPackage.GROUP__LOWER:
				setLower(LOWER_EDEFAULT);
				return;
			case FeatureModelPackage.GROUP__UPPER:
				setUpper(UPPER_EDEFAULT);
				return;
			case FeatureModelPackage.GROUP__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case FeatureModelPackage.GROUP__COMMENT:
				setComment(COMMENT_EDEFAULT);
				return;
			case FeatureModelPackage.GROUP__XOR:
				setXor(XOR_EDEFAULT);
				return;
			case FeatureModelPackage.GROUP__OR:
				setOr(OR_EDEFAULT);
				return;
			case FeatureModelPackage.GROUP__PARENT:
				setParent((Feature)null);
				return;
			case FeatureModelPackage.GROUP__FEATURES:
				getFeatures().clear();
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
			case FeatureModelPackage.GROUP__LOWER:
				return lower != LOWER_EDEFAULT;
			case FeatureModelPackage.GROUP__UPPER:
				return upper != UPPER_EDEFAULT;
			case FeatureModelPackage.GROUP__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case FeatureModelPackage.GROUP__COMMENT:
				return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
			case FeatureModelPackage.GROUP__XOR:
				return isXor() != XOR_EDEFAULT;
			case FeatureModelPackage.GROUP__OR:
				return isOr() != OR_EDEFAULT;
			case FeatureModelPackage.GROUP__PARENT:
				return getParent() != null;
			case FeatureModelPackage.GROUP__FEATURES:
				return features != null && !features.isEmpty();
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
		result.append(" (lower: ");
		result.append(lower);
		result.append(", upper: ");
		result.append(upper);
		result.append(", description: ");
		result.append(description);
		result.append(", comment: ");
		result.append(comment);
		result.append(')');
		return result.toString();
	}

} //GroupImpl
