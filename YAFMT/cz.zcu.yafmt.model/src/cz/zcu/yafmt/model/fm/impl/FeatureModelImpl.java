/**
 */
package cz.zcu.yafmt.model.fm.impl;

import cz.zcu.yafmt.model.fm.Constraint;
import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.FeatureModel;
import cz.zcu.yafmt.model.fm.FeatureModelPackage;
import cz.zcu.yafmt.model.fm.util.FeatureCache;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link cz.zcu.yafmt.model.fm.impl.FeatureModelImpl#getName <em>Name</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.impl.FeatureModelImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.impl.FeatureModelImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.impl.FeatureModelImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.impl.FeatureModelImpl#getRoot <em>Root</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.impl.FeatureModelImpl#getOrphans <em>Orphans</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.impl.FeatureModelImpl#getConstraints <em>Constraints</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FeatureModelImpl extends EObjectImpl implements FeatureModel {
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
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
    protected String name = NAME_EDEFAULT;

    /**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
    protected static final String VERSION_EDEFAULT = null;

    /**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
    protected String version = VERSION_EDEFAULT;

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
	 * The cached value of the '{@link #getRoot() <em>Root</em>}' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getRoot()
	 * @generated
	 * @ordered
	 */
    protected Feature root;

    /**
	 * The cached value of the '{@link #getOrphans() <em>Orphans</em>}' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getOrphans()
	 * @generated
	 * @ordered
	 */
    protected EList<Feature> orphans;

    /**
	 * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getConstraints()
	 * @generated
	 * @ordered
	 */
    protected EList<Constraint> constraints;
    
    /**
     * Cache for mapping IDs to features.
     */
    private FeatureCache featureCache;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected FeatureModelImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return FeatureModelPackage.Literals.FEATURE_MODEL;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String getName() {
		return name;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FeatureModelPackage.FEATURE_MODEL__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FeatureModelPackage.FEATURE_MODEL__DESCRIPTION, oldDescription, description));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FeatureModelPackage.FEATURE_MODEL__COMMENT, oldComment, comment));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String getVersion() {
		return version;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setVersion(String newVersion) {
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FeatureModelPackage.FEATURE_MODEL__VERSION, oldVersion, version));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Feature getRoot() {
		return root;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain basicSetRoot(Feature newRoot, NotificationChain msgs) {
		Feature oldRoot = root;
		root = newRoot;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FeatureModelPackage.FEATURE_MODEL__ROOT, oldRoot, newRoot);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setRoot(Feature newRoot) {
		if (newRoot != root) {
			NotificationChain msgs = null;
			if (root != null)
				msgs = ((InternalEObject)root).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FeatureModelPackage.FEATURE_MODEL__ROOT, null, msgs);
			if (newRoot != null)
				msgs = ((InternalEObject)newRoot).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FeatureModelPackage.FEATURE_MODEL__ROOT, null, msgs);
			msgs = basicSetRoot(newRoot, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FeatureModelPackage.FEATURE_MODEL__ROOT, newRoot, newRoot));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<Feature> getOrphans() {
		if (orphans == null) {
			orphans = new EObjectContainmentEList<Feature>(Feature.class, this, FeatureModelPackage.FEATURE_MODEL__ORPHANS);
		}
		return orphans;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<Constraint> getConstraints() {
		if (constraints == null) {
			constraints = new EObjectContainmentEList<Constraint>(Constraint.class, this, FeatureModelPackage.FEATURE_MODEL__CONSTRAINTS);
		}
		return constraints;
	}

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public EList<Feature> getFeaturesById(String id) {
        if(featureCache == null)
            featureCache = new FeatureCache(this);
        return featureCache.getFeaturesById(id);
    }

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FeatureModelPackage.FEATURE_MODEL__ROOT:
				return basicSetRoot(null, msgs);
			case FeatureModelPackage.FEATURE_MODEL__ORPHANS:
				return ((InternalEList<?>)getOrphans()).basicRemove(otherEnd, msgs);
			case FeatureModelPackage.FEATURE_MODEL__CONSTRAINTS:
				return ((InternalEList<?>)getConstraints()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FeatureModelPackage.FEATURE_MODEL__NAME:
				return getName();
			case FeatureModelPackage.FEATURE_MODEL__VERSION:
				return getVersion();
			case FeatureModelPackage.FEATURE_MODEL__DESCRIPTION:
				return getDescription();
			case FeatureModelPackage.FEATURE_MODEL__COMMENT:
				return getComment();
			case FeatureModelPackage.FEATURE_MODEL__ROOT:
				return getRoot();
			case FeatureModelPackage.FEATURE_MODEL__ORPHANS:
				return getOrphans();
			case FeatureModelPackage.FEATURE_MODEL__CONSTRAINTS:
				return getConstraints();
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
			case FeatureModelPackage.FEATURE_MODEL__NAME:
				setName((String)newValue);
				return;
			case FeatureModelPackage.FEATURE_MODEL__VERSION:
				setVersion((String)newValue);
				return;
			case FeatureModelPackage.FEATURE_MODEL__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case FeatureModelPackage.FEATURE_MODEL__COMMENT:
				setComment((String)newValue);
				return;
			case FeatureModelPackage.FEATURE_MODEL__ROOT:
				setRoot((Feature)newValue);
				return;
			case FeatureModelPackage.FEATURE_MODEL__ORPHANS:
				getOrphans().clear();
				getOrphans().addAll((Collection<? extends Feature>)newValue);
				return;
			case FeatureModelPackage.FEATURE_MODEL__CONSTRAINTS:
				getConstraints().clear();
				getConstraints().addAll((Collection<? extends Constraint>)newValue);
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
			case FeatureModelPackage.FEATURE_MODEL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case FeatureModelPackage.FEATURE_MODEL__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case FeatureModelPackage.FEATURE_MODEL__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case FeatureModelPackage.FEATURE_MODEL__COMMENT:
				setComment(COMMENT_EDEFAULT);
				return;
			case FeatureModelPackage.FEATURE_MODEL__ROOT:
				setRoot((Feature)null);
				return;
			case FeatureModelPackage.FEATURE_MODEL__ORPHANS:
				getOrphans().clear();
				return;
			case FeatureModelPackage.FEATURE_MODEL__CONSTRAINTS:
				getConstraints().clear();
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
			case FeatureModelPackage.FEATURE_MODEL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case FeatureModelPackage.FEATURE_MODEL__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case FeatureModelPackage.FEATURE_MODEL__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case FeatureModelPackage.FEATURE_MODEL__COMMENT:
				return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
			case FeatureModelPackage.FEATURE_MODEL__ROOT:
				return root != null;
			case FeatureModelPackage.FEATURE_MODEL__ORPHANS:
				return orphans != null && !orphans.isEmpty();
			case FeatureModelPackage.FEATURE_MODEL__CONSTRAINTS:
				return constraints != null && !constraints.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(", version: ");
		result.append(version);
		result.append(", description: ");
		result.append(description);
		result.append(", comment: ");
		result.append(comment);
		result.append(')');
		return result.toString();
	}

} //FeatureModelImpl
