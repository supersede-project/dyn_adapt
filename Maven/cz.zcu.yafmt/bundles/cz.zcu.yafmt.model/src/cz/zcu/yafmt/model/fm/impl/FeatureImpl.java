/**
 */
package cz.zcu.yafmt.model.fm.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import cz.zcu.yafmt.model.fm.Attribute;
import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.FeatureModel;
import cz.zcu.yafmt.model.fm.FeatureModelPackage;
import cz.zcu.yafmt.model.fm.Group;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link cz.zcu.yafmt.model.fm.impl.FeatureImpl#getId <em>Id</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.impl.FeatureImpl#getName <em>Name</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.impl.FeatureImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.impl.FeatureImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.impl.FeatureImpl#getLower <em>Lower</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.impl.FeatureImpl#getUpper <em>Upper</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.impl.FeatureImpl#isRoot <em>Root</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.impl.FeatureImpl#isOrphan <em>Orphan</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.impl.FeatureImpl#isOptional <em>Optional</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.impl.FeatureImpl#isMandatory <em>Mandatory</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.impl.FeatureImpl#isCloneable <em>Cloneable</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.impl.FeatureImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.impl.FeatureImpl#getParentFeature <em>Parent Feature</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.impl.FeatureImpl#getParentGroup <em>Parent Group</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.impl.FeatureImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.impl.FeatureImpl#getFeatures <em>Features</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.impl.FeatureImpl#getGroups <em>Groups</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.impl.FeatureImpl#getFeatureModel <em>Feature Model</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FeatureImpl extends EObjectImpl implements Feature {
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
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
    protected String name = NAME_EDEFAULT;

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
	 * The default value of the '{@link #getLower() <em>Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getLower()
	 * @generated
	 * @ordered
	 */
    protected static final int LOWER_EDEFAULT = 0;

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
	 * The default value of the '{@link #isRoot() <em>Root</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #isRoot()
	 * @generated
	 * @ordered
	 */
    protected static final boolean ROOT_EDEFAULT = false;

    /**
	 * The default value of the '{@link #isOrphan() <em>Orphan</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #isOrphan()
	 * @generated
	 * @ordered
	 */
    protected static final boolean ORPHAN_EDEFAULT = false;

    /**
	 * The default value of the '{@link #isOptional() <em>Optional</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #isOptional()
	 * @generated
	 * @ordered
	 */
    protected static final boolean OPTIONAL_EDEFAULT = false;

    /**
	 * The default value of the '{@link #isMandatory() <em>Mandatory</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #isMandatory()
	 * @generated
	 * @ordered
	 */
    protected static final boolean MANDATORY_EDEFAULT = false;

    /**
	 * The default value of the '{@link #isCloneable() <em>Cloneable</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #isCloneable()
	 * @generated
	 * @ordered
	 */
    protected static final boolean CLONEABLE_EDEFAULT = false;

    /**
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
    protected EList<Attribute> attributes;

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
	 * The cached value of the '{@link #getGroups() <em>Groups</em>}' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getGroups()
	 * @generated
	 * @ordered
	 */
    protected EList<Group> groups;

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
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected FeatureImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return FeatureModelPackage.Literals.FEATURE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, FeatureModelPackage.FEATURE__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FeatureModelPackage.FEATURE__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FeatureModelPackage.FEATURE__DESCRIPTION, oldDescription, description));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FeatureModelPackage.FEATURE__COMMENT, oldComment, comment));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FeatureModelPackage.FEATURE__LOWER, oldLower, lower));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FeatureModelPackage.FEATURE__UPPER, oldUpper, upper));
	}

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public boolean isRoot() {
        EObject parent = eContainer();
        return (parent instanceof FeatureModel) && (((FeatureModel) parent).getRoot() == this); 
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public boolean isOrphan() {
        EObject current = this;
        EObject parent = eContainer();
        
        while(parent != null) {
            if(parent instanceof FeatureModel)
                return ((FeatureModel) parent).getRoot() != current;
            current = parent;
            parent = parent.eContainer();
        }
        
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public boolean isOptional() {
        return lower == 0;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public void setOptional(boolean newOptional) {
        if(newOptional)
            setLower(0);
        else if(lower == 0)
            setLower(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public boolean isMandatory() {
        return !isOptional();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public void setMandatory(boolean newMandatory) {
        setOptional(!newMandatory);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public boolean isCloneable() {
        return (upper > 1) || (upper == -1);
    }

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<Attribute> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectContainmentWithInverseEList<Attribute>(Attribute.class, this, FeatureModelPackage.FEATURE__ATTRIBUTES, FeatureModelPackage.ATTRIBUTE__FEATURE);
		}
		return attributes;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EObject getParent() {
		EObject parent = basicGetParent();
		return parent != null && parent.eIsProxy() ? eResolveProxy((InternalEObject)parent) : parent;
	}

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public EObject basicGetParent() {
        return eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public void setParent(EObject newParent) {
        if(newParent instanceof Feature)
            ((Feature) newParent).getFeatures().add(this);
        else if(newParent instanceof Group)
            ((Group) newParent).getFeatures().add(this);
        else if(newParent instanceof FeatureModel)
            ((FeatureModel) newParent).getOrphans().add(this);
        else
            EcoreUtil.remove(this);
    }

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Feature getParentFeature() {
		if (eContainerFeatureID() != FeatureModelPackage.FEATURE__PARENT_FEATURE) return null;
		return (Feature)eInternalContainer();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain basicSetParentFeature(Feature newParentFeature, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentFeature, FeatureModelPackage.FEATURE__PARENT_FEATURE, msgs);
		return msgs;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setParentFeature(Feature newParentFeature) {
		if (newParentFeature != eInternalContainer() || (eContainerFeatureID() != FeatureModelPackage.FEATURE__PARENT_FEATURE && newParentFeature != null)) {
			if (EcoreUtil.isAncestor(this, newParentFeature))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentFeature != null)
				msgs = ((InternalEObject)newParentFeature).eInverseAdd(this, FeatureModelPackage.FEATURE__FEATURES, Feature.class, msgs);
			msgs = basicSetParentFeature(newParentFeature, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FeatureModelPackage.FEATURE__PARENT_FEATURE, newParentFeature, newParentFeature));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Group getParentGroup() {
		if (eContainerFeatureID() != FeatureModelPackage.FEATURE__PARENT_GROUP) return null;
		return (Group)eInternalContainer();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain basicSetParentGroup(Group newParentGroup, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentGroup, FeatureModelPackage.FEATURE__PARENT_GROUP, msgs);
		return msgs;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setParentGroup(Group newParentGroup) {
		if (newParentGroup != eInternalContainer() || (eContainerFeatureID() != FeatureModelPackage.FEATURE__PARENT_GROUP && newParentGroup != null)) {
			if (EcoreUtil.isAncestor(this, newParentGroup))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentGroup != null)
				msgs = ((InternalEObject)newParentGroup).eInverseAdd(this, FeatureModelPackage.GROUP__FEATURES, Group.class, msgs);
			msgs = basicSetParentGroup(newParentGroup, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FeatureModelPackage.FEATURE__PARENT_GROUP, newParentGroup, newParentGroup));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<Feature> getFeatures() {
		if (features == null) {
			features = new EObjectContainmentWithInverseEList<Feature>(Feature.class, this, FeatureModelPackage.FEATURE__FEATURES, FeatureModelPackage.FEATURE__PARENT_FEATURE);
		}
		return features;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<Group> getGroups() {
		if (groups == null) {
			groups = new EObjectContainmentWithInverseEList<Group>(Group.class, this, FeatureModelPackage.FEATURE__GROUPS, FeatureModelPackage.GROUP__PARENT);
		}
		return groups;
	}

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public FeatureModel getFeatureModel() {
        if (featureModel != null && featureModel.eIsProxy()) {
            InternalEObject oldFeatureModel = (InternalEObject)featureModel;
            featureModel = (FeatureModel)eResolveProxy(oldFeatureModel);
            if (featureModel != oldFeatureModel) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, FeatureModelPackage.FEATURE__FEATURE_MODEL, oldFeatureModel, featureModel));
            }
        }
        return basicGetFeatureModel(); // Changed from 'return featureModel;'
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public FeatureModel basicGetFeatureModel() {
        if(featureModel == null)
            featureModel = findFeatureModel();
        return featureModel;
    }

    private FeatureModel findFeatureModel() {
        Resource resource = eResource();
        if(resource == null)
            return null;
        
        EObject target = resource.getContents().get(0);
        if(target instanceof FeatureModel)
            return (FeatureModel) target;
        
        for(EObject parent = eContainer(); parent != null; parent = parent.eContainer()) {
            if(parent instanceof FeatureModel)
                return (FeatureModel) parent;
        }
        return null;
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
			case FeatureModelPackage.FEATURE__PARENT_FEATURE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentFeature((Feature)otherEnd, msgs);
			case FeatureModelPackage.FEATURE__PARENT_GROUP:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentGroup((Group)otherEnd, msgs);
			case FeatureModelPackage.FEATURE__ATTRIBUTES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAttributes()).basicAdd(otherEnd, msgs);
			case FeatureModelPackage.FEATURE__FEATURES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFeatures()).basicAdd(otherEnd, msgs);
			case FeatureModelPackage.FEATURE__GROUPS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getGroups()).basicAdd(otherEnd, msgs);
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
			case FeatureModelPackage.FEATURE__PARENT_FEATURE:
				return basicSetParentFeature(null, msgs);
			case FeatureModelPackage.FEATURE__PARENT_GROUP:
				return basicSetParentGroup(null, msgs);
			case FeatureModelPackage.FEATURE__ATTRIBUTES:
				return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
			case FeatureModelPackage.FEATURE__FEATURES:
				return ((InternalEList<?>)getFeatures()).basicRemove(otherEnd, msgs);
			case FeatureModelPackage.FEATURE__GROUPS:
				return ((InternalEList<?>)getGroups()).basicRemove(otherEnd, msgs);
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
			case FeatureModelPackage.FEATURE__PARENT_FEATURE:
				return eInternalContainer().eInverseRemove(this, FeatureModelPackage.FEATURE__FEATURES, Feature.class, msgs);
			case FeatureModelPackage.FEATURE__PARENT_GROUP:
				return eInternalContainer().eInverseRemove(this, FeatureModelPackage.GROUP__FEATURES, Group.class, msgs);
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
			case FeatureModelPackage.FEATURE__ID:
				return getId();
			case FeatureModelPackage.FEATURE__NAME:
				return getName();
			case FeatureModelPackage.FEATURE__DESCRIPTION:
				return getDescription();
			case FeatureModelPackage.FEATURE__COMMENT:
				return getComment();
			case FeatureModelPackage.FEATURE__LOWER:
				return getLower();
			case FeatureModelPackage.FEATURE__UPPER:
				return getUpper();
			case FeatureModelPackage.FEATURE__ROOT:
				return isRoot();
			case FeatureModelPackage.FEATURE__ORPHAN:
				return isOrphan();
			case FeatureModelPackage.FEATURE__OPTIONAL:
				return isOptional();
			case FeatureModelPackage.FEATURE__MANDATORY:
				return isMandatory();
			case FeatureModelPackage.FEATURE__CLONEABLE:
				return isCloneable();
			case FeatureModelPackage.FEATURE__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case FeatureModelPackage.FEATURE__PARENT_FEATURE:
				return getParentFeature();
			case FeatureModelPackage.FEATURE__PARENT_GROUP:
				return getParentGroup();
			case FeatureModelPackage.FEATURE__ATTRIBUTES:
				return getAttributes();
			case FeatureModelPackage.FEATURE__FEATURES:
				return getFeatures();
			case FeatureModelPackage.FEATURE__GROUPS:
				return getGroups();
			case FeatureModelPackage.FEATURE__FEATURE_MODEL:
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
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FeatureModelPackage.FEATURE__ID:
				setId((String)newValue);
				return;
			case FeatureModelPackage.FEATURE__NAME:
				setName((String)newValue);
				return;
			case FeatureModelPackage.FEATURE__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case FeatureModelPackage.FEATURE__COMMENT:
				setComment((String)newValue);
				return;
			case FeatureModelPackage.FEATURE__LOWER:
				setLower((Integer)newValue);
				return;
			case FeatureModelPackage.FEATURE__UPPER:
				setUpper((Integer)newValue);
				return;
			case FeatureModelPackage.FEATURE__OPTIONAL:
				setOptional((Boolean)newValue);
				return;
			case FeatureModelPackage.FEATURE__MANDATORY:
				setMandatory((Boolean)newValue);
				return;
			case FeatureModelPackage.FEATURE__PARENT:
				setParent((EObject)newValue);
				return;
			case FeatureModelPackage.FEATURE__PARENT_FEATURE:
				setParentFeature((Feature)newValue);
				return;
			case FeatureModelPackage.FEATURE__PARENT_GROUP:
				setParentGroup((Group)newValue);
				return;
			case FeatureModelPackage.FEATURE__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends Attribute>)newValue);
				return;
			case FeatureModelPackage.FEATURE__FEATURES:
				getFeatures().clear();
				getFeatures().addAll((Collection<? extends Feature>)newValue);
				return;
			case FeatureModelPackage.FEATURE__GROUPS:
				getGroups().clear();
				getGroups().addAll((Collection<? extends Group>)newValue);
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
			case FeatureModelPackage.FEATURE__ID:
				setId(ID_EDEFAULT);
				return;
			case FeatureModelPackage.FEATURE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case FeatureModelPackage.FEATURE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case FeatureModelPackage.FEATURE__COMMENT:
				setComment(COMMENT_EDEFAULT);
				return;
			case FeatureModelPackage.FEATURE__LOWER:
				setLower(LOWER_EDEFAULT);
				return;
			case FeatureModelPackage.FEATURE__UPPER:
				setUpper(UPPER_EDEFAULT);
				return;
			case FeatureModelPackage.FEATURE__OPTIONAL:
				setOptional(OPTIONAL_EDEFAULT);
				return;
			case FeatureModelPackage.FEATURE__MANDATORY:
				setMandatory(MANDATORY_EDEFAULT);
				return;
			case FeatureModelPackage.FEATURE__PARENT:
				setParent((EObject)null);
				return;
			case FeatureModelPackage.FEATURE__PARENT_FEATURE:
				setParentFeature((Feature)null);
				return;
			case FeatureModelPackage.FEATURE__PARENT_GROUP:
				setParentGroup((Group)null);
				return;
			case FeatureModelPackage.FEATURE__ATTRIBUTES:
				getAttributes().clear();
				return;
			case FeatureModelPackage.FEATURE__FEATURES:
				getFeatures().clear();
				return;
			case FeatureModelPackage.FEATURE__GROUPS:
				getGroups().clear();
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
			case FeatureModelPackage.FEATURE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case FeatureModelPackage.FEATURE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case FeatureModelPackage.FEATURE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case FeatureModelPackage.FEATURE__COMMENT:
				return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
			case FeatureModelPackage.FEATURE__LOWER:
				return lower != LOWER_EDEFAULT;
			case FeatureModelPackage.FEATURE__UPPER:
				return upper != UPPER_EDEFAULT;
			case FeatureModelPackage.FEATURE__ROOT:
				return isRoot() != ROOT_EDEFAULT;
			case FeatureModelPackage.FEATURE__ORPHAN:
				return isOrphan() != ORPHAN_EDEFAULT;
			case FeatureModelPackage.FEATURE__OPTIONAL:
				return isOptional() != OPTIONAL_EDEFAULT;
			case FeatureModelPackage.FEATURE__MANDATORY:
				return isMandatory() != MANDATORY_EDEFAULT;
			case FeatureModelPackage.FEATURE__CLONEABLE:
				return isCloneable() != CLONEABLE_EDEFAULT;
			case FeatureModelPackage.FEATURE__PARENT:
				return basicGetParent() != null;
			case FeatureModelPackage.FEATURE__PARENT_FEATURE:
				return getParentFeature() != null;
			case FeatureModelPackage.FEATURE__PARENT_GROUP:
				return getParentGroup() != null;
			case FeatureModelPackage.FEATURE__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
			case FeatureModelPackage.FEATURE__FEATURES:
				return features != null && !features.isEmpty();
			case FeatureModelPackage.FEATURE__GROUPS:
				return groups != null && !groups.isEmpty();
			case FeatureModelPackage.FEATURE__FEATURE_MODEL:
				return featureModel != null;
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
		result.append(", name: ");
		result.append(name);
		result.append(", description: ");
		result.append(description);
		result.append(", comment: ");
		result.append(comment);
		result.append(", lower: ");
		result.append(lower);
		result.append(", upper: ");
		result.append(upper);
		result.append(')');
		return result.toString();
	}

} //FeatureImpl
