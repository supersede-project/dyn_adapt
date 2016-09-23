/**
 */
package cz.zcu.yafmt.model.fm.impl;

import cz.zcu.yafmt.model.fm.Constraint;
import cz.zcu.yafmt.model.fm.FeatureModel;
import cz.zcu.yafmt.model.fm.FeatureModelPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link cz.zcu.yafmt.model.fm.impl.ConstraintImpl#getValue <em>Value</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.impl.ConstraintImpl#getLanguage <em>Language</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.impl.ConstraintImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.impl.ConstraintImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.impl.ConstraintImpl#getFeatureModel <em>Feature Model</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConstraintImpl extends EObjectImpl implements Constraint {
    /**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
    protected static final String VALUE_EDEFAULT = null;

    /**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
    protected String value = VALUE_EDEFAULT;

    /**
	 * The default value of the '{@link #getLanguage() <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getLanguage()
	 * @generated
	 * @ordered
	 */
    protected static final String LANGUAGE_EDEFAULT = null;

    /**
	 * The cached value of the '{@link #getLanguage() <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getLanguage()
	 * @generated
	 * @ordered
	 */
    protected String language = LANGUAGE_EDEFAULT;

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
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected ConstraintImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return FeatureModelPackage.Literals.CONSTRAINT;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String getValue() {
		return value;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setValue(String newValue) {
		String oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FeatureModelPackage.CONSTRAINT__VALUE, oldValue, value));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String getLanguage() {
		return language;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setLanguage(String newLanguage) {
		String oldLanguage = language;
		language = newLanguage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FeatureModelPackage.CONSTRAINT__LANGUAGE, oldLanguage, language));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FeatureModelPackage.CONSTRAINT__DESCRIPTION, oldDescription, description));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FeatureModelPackage.CONSTRAINT__COMMENT, oldComment, comment));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public FeatureModel getFeatureModel() {
		FeatureModel featureModel = basicGetFeatureModel();
		return featureModel != null && featureModel.eIsProxy() ? (FeatureModel)eResolveProxy((InternalEObject)featureModel) : featureModel;
	}

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public FeatureModel basicGetFeatureModel() {
        return (FeatureModel) eContainer();
    }

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FeatureModelPackage.CONSTRAINT__VALUE:
				return getValue();
			case FeatureModelPackage.CONSTRAINT__LANGUAGE:
				return getLanguage();
			case FeatureModelPackage.CONSTRAINT__DESCRIPTION:
				return getDescription();
			case FeatureModelPackage.CONSTRAINT__COMMENT:
				return getComment();
			case FeatureModelPackage.CONSTRAINT__FEATURE_MODEL:
				if (resolve) return getFeatureModel();
				return basicGetFeatureModel();
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
			case FeatureModelPackage.CONSTRAINT__VALUE:
				setValue((String)newValue);
				return;
			case FeatureModelPackage.CONSTRAINT__LANGUAGE:
				setLanguage((String)newValue);
				return;
			case FeatureModelPackage.CONSTRAINT__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case FeatureModelPackage.CONSTRAINT__COMMENT:
				setComment((String)newValue);
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
			case FeatureModelPackage.CONSTRAINT__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case FeatureModelPackage.CONSTRAINT__LANGUAGE:
				setLanguage(LANGUAGE_EDEFAULT);
				return;
			case FeatureModelPackage.CONSTRAINT__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case FeatureModelPackage.CONSTRAINT__COMMENT:
				setComment(COMMENT_EDEFAULT);
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
			case FeatureModelPackage.CONSTRAINT__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case FeatureModelPackage.CONSTRAINT__LANGUAGE:
				return LANGUAGE_EDEFAULT == null ? language != null : !LANGUAGE_EDEFAULT.equals(language);
			case FeatureModelPackage.CONSTRAINT__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case FeatureModelPackage.CONSTRAINT__COMMENT:
				return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
			case FeatureModelPackage.CONSTRAINT__FEATURE_MODEL:
				return basicGetFeatureModel() != null;
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
		result.append(", language: ");
		result.append(language);
		result.append(", description: ");
		result.append(description);
		result.append(", comment: ");
		result.append(comment);
		result.append(')');
		return result.toString();
	}

} //ConstraintImpl
