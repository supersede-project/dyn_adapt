/**
 */
package cz.zcu.yafmt.model.fc.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import cz.zcu.yafmt.model.fc.FeatureConfiguration;
import cz.zcu.yafmt.model.fc.FeatureConfigurationPackage;
import cz.zcu.yafmt.model.fc.Selection;
import cz.zcu.yafmt.model.fc.util.SelectionCache;
import cz.zcu.yafmt.model.fm.FeatureModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link cz.zcu.yafmt.model.fc.impl.FeatureConfigurationImpl#getName <em>Name</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fc.impl.FeatureConfigurationImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fc.impl.FeatureConfigurationImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fc.impl.FeatureConfigurationImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fc.impl.FeatureConfigurationImpl#getFeatureModel <em>Feature Model</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fc.impl.FeatureConfigurationImpl#getFeatureModelCopy <em>Feature Model Copy</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fc.impl.FeatureConfigurationImpl#getRoot <em>Root</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FeatureConfigurationImpl extends EObjectImpl implements FeatureConfiguration {
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
	 * The cached value of the '{@link #getFeatureModel() <em>Feature Model</em>}' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getFeatureModel()
	 * @generated
	 * @ordered
	 */
    protected FeatureModel featureModel;

    /**
	 * The cached value of the '{@link #getFeatureModelCopy() <em>Feature Model Copy</em>}' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getFeatureModelCopy()
	 * @generated
	 * @ordered
	 */
    protected FeatureModel featureModelCopy;

    /**
	 * The cached value of the '{@link #getRoot() <em>Root</em>}' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getRoot()
	 * @generated
	 * @ordered
	 */
    protected Selection root;
    
    private SelectionCache selectionCache;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected FeatureConfigurationImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return FeatureConfigurationPackage.Literals.FEATURE_CONFIGURATION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, FeatureConfigurationPackage.FEATURE_CONFIGURATION__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FeatureConfigurationPackage.FEATURE_CONFIGURATION__DESCRIPTION, oldDescription, description));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FeatureConfigurationPackage.FEATURE_CONFIGURATION__COMMENT, oldComment, comment));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FeatureConfigurationPackage.FEATURE_CONFIGURATION__VERSION, oldVersion, version));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public FeatureModel getFeatureModel() {
		if (featureModel != null && featureModel.eIsProxy()) {
			InternalEObject oldFeatureModel = (InternalEObject)featureModel;
			featureModel = (FeatureModel)eResolveProxy(oldFeatureModel);
			if (featureModel != oldFeatureModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FeatureConfigurationPackage.FEATURE_CONFIGURATION__FEATURE_MODEL, oldFeatureModel, featureModel));
			}
		}
		return featureModel;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public FeatureModel basicGetFeatureModel() {
		return featureModel;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setFeatureModel(FeatureModel newFeatureModel) {
		FeatureModel oldFeatureModel = featureModel;
		featureModel = newFeatureModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FeatureConfigurationPackage.FEATURE_CONFIGURATION__FEATURE_MODEL, oldFeatureModel, featureModel));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public FeatureModel getFeatureModelCopy() {
		return featureModelCopy;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain basicSetFeatureModelCopy(FeatureModel newFeatureModelCopy, NotificationChain msgs) {
		FeatureModel oldFeatureModelCopy = featureModelCopy;
		featureModelCopy = newFeatureModelCopy;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FeatureConfigurationPackage.FEATURE_CONFIGURATION__FEATURE_MODEL_COPY, oldFeatureModelCopy, newFeatureModelCopy);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setFeatureModelCopy(FeatureModel newFeatureModelCopy) {
		if (newFeatureModelCopy != featureModelCopy) {
			NotificationChain msgs = null;
			if (featureModelCopy != null)
				msgs = ((InternalEObject)featureModelCopy).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FeatureConfigurationPackage.FEATURE_CONFIGURATION__FEATURE_MODEL_COPY, null, msgs);
			if (newFeatureModelCopy != null)
				msgs = ((InternalEObject)newFeatureModelCopy).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FeatureConfigurationPackage.FEATURE_CONFIGURATION__FEATURE_MODEL_COPY, null, msgs);
			msgs = basicSetFeatureModelCopy(newFeatureModelCopy, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FeatureConfigurationPackage.FEATURE_CONFIGURATION__FEATURE_MODEL_COPY, newFeatureModelCopy, newFeatureModelCopy));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Selection getRoot() {
		return root;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain basicSetRoot(Selection newRoot, NotificationChain msgs) {
		Selection oldRoot = root;
		root = newRoot;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FeatureConfigurationPackage.FEATURE_CONFIGURATION__ROOT, oldRoot, newRoot);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setRoot(Selection newRoot) {
		if (newRoot != root) {
			NotificationChain msgs = null;
			if (root != null)
				msgs = ((InternalEObject)root).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FeatureConfigurationPackage.FEATURE_CONFIGURATION__ROOT, null, msgs);
			if (newRoot != null)
				msgs = ((InternalEObject)newRoot).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FeatureConfigurationPackage.FEATURE_CONFIGURATION__ROOT, null, msgs);
			msgs = basicSetRoot(newRoot, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FeatureConfigurationPackage.FEATURE_CONFIGURATION__ROOT, newRoot, newRoot));
	}

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public EList<Selection> getSelectionsById(String id) {
        if(selectionCache == null)
            selectionCache = new SelectionCache(this);
        return selectionCache.getSelectionsById(id);
    }

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FeatureConfigurationPackage.FEATURE_CONFIGURATION__FEATURE_MODEL_COPY:
				return basicSetFeatureModelCopy(null, msgs);
			case FeatureConfigurationPackage.FEATURE_CONFIGURATION__ROOT:
				return basicSetRoot(null, msgs);
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
			case FeatureConfigurationPackage.FEATURE_CONFIGURATION__NAME:
				return getName();
			case FeatureConfigurationPackage.FEATURE_CONFIGURATION__VERSION:
				return getVersion();
			case FeatureConfigurationPackage.FEATURE_CONFIGURATION__DESCRIPTION:
				return getDescription();
			case FeatureConfigurationPackage.FEATURE_CONFIGURATION__COMMENT:
				return getComment();
			case FeatureConfigurationPackage.FEATURE_CONFIGURATION__FEATURE_MODEL:
				if (resolve) return getFeatureModel();
				return basicGetFeatureModel();
			case FeatureConfigurationPackage.FEATURE_CONFIGURATION__FEATURE_MODEL_COPY:
				return getFeatureModelCopy();
			case FeatureConfigurationPackage.FEATURE_CONFIGURATION__ROOT:
				return getRoot();
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
			case FeatureConfigurationPackage.FEATURE_CONFIGURATION__NAME:
				setName((String)newValue);
				return;
			case FeatureConfigurationPackage.FEATURE_CONFIGURATION__VERSION:
				setVersion((String)newValue);
				return;
			case FeatureConfigurationPackage.FEATURE_CONFIGURATION__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case FeatureConfigurationPackage.FEATURE_CONFIGURATION__COMMENT:
				setComment((String)newValue);
				return;
			case FeatureConfigurationPackage.FEATURE_CONFIGURATION__FEATURE_MODEL:
				setFeatureModel((FeatureModel)newValue);
				return;
			case FeatureConfigurationPackage.FEATURE_CONFIGURATION__FEATURE_MODEL_COPY:
				setFeatureModelCopy((FeatureModel)newValue);
				return;
			case FeatureConfigurationPackage.FEATURE_CONFIGURATION__ROOT:
				setRoot((Selection)newValue);
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
			case FeatureConfigurationPackage.FEATURE_CONFIGURATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case FeatureConfigurationPackage.FEATURE_CONFIGURATION__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case FeatureConfigurationPackage.FEATURE_CONFIGURATION__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case FeatureConfigurationPackage.FEATURE_CONFIGURATION__COMMENT:
				setComment(COMMENT_EDEFAULT);
				return;
			case FeatureConfigurationPackage.FEATURE_CONFIGURATION__FEATURE_MODEL:
				setFeatureModel((FeatureModel)null);
				return;
			case FeatureConfigurationPackage.FEATURE_CONFIGURATION__FEATURE_MODEL_COPY:
				setFeatureModelCopy((FeatureModel)null);
				return;
			case FeatureConfigurationPackage.FEATURE_CONFIGURATION__ROOT:
				setRoot((Selection)null);
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
			case FeatureConfigurationPackage.FEATURE_CONFIGURATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case FeatureConfigurationPackage.FEATURE_CONFIGURATION__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case FeatureConfigurationPackage.FEATURE_CONFIGURATION__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case FeatureConfigurationPackage.FEATURE_CONFIGURATION__COMMENT:
				return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
			case FeatureConfigurationPackage.FEATURE_CONFIGURATION__FEATURE_MODEL:
				return featureModel != null;
			case FeatureConfigurationPackage.FEATURE_CONFIGURATION__FEATURE_MODEL_COPY:
				return featureModelCopy != null;
			case FeatureConfigurationPackage.FEATURE_CONFIGURATION__ROOT:
				return root != null;
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

} //FeatureConfigurationImpl
