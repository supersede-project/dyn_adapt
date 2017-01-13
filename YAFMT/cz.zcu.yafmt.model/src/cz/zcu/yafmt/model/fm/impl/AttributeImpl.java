/**
 */
package cz.zcu.yafmt.model.fm.impl;

import cz.zcu.yafmt.model.fm.Attribute;
import cz.zcu.yafmt.model.fm.AttributeType;
import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.FeatureModelPackage;

import cz.zcu.yafmt.model.fm.ObjectiveFunctionType;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link cz.zcu.yafmt.model.fm.impl.AttributeImpl#getId <em>Id</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.impl.AttributeImpl#getName <em>Name</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.impl.AttributeImpl#getType <em>Type</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.impl.AttributeImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.impl.AttributeImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.impl.AttributeImpl#getFeature <em>Feature</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.impl.AttributeImpl#isQualityAttribute <em>Quality Attribute</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.impl.AttributeImpl#isResourceAttribute <em>Resource Attribute</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.impl.AttributeImpl#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.impl.AttributeImpl#getMinRangeValue <em>Min Range Value</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.impl.AttributeImpl#getMaxRangeValue <em>Max Range Value</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.impl.AttributeImpl#getWeight <em>Weight</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.impl.AttributeImpl#isMinimize <em>Minimize</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.impl.AttributeImpl#getObjectiveFunctionAggregator <em>Objective Function Aggregator</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.impl.AttributeImpl#isAlert <em>Alert</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttributeImpl extends EObjectImpl implements Attribute {
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
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
    protected static final AttributeType TYPE_EDEFAULT = AttributeType.BOOLEAN;

    /**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
    protected AttributeType type = TYPE_EDEFAULT;

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
	 * The default value of the '{@link #isQualityAttribute() <em>Quality Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isQualityAttribute()
	 * @generated
	 * @ordered
	 */
	protected static final boolean QUALITY_ATTRIBUTE_EDEFAULT = false;

				/**
	 * The cached value of the '{@link #isQualityAttribute() <em>Quality Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isQualityAttribute()
	 * @generated
	 * @ordered
	 */
	protected boolean qualityAttribute = QUALITY_ATTRIBUTE_EDEFAULT;

				/**
	 * The default value of the '{@link #isResourceAttribute() <em>Resource Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isResourceAttribute()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RESOURCE_ATTRIBUTE_EDEFAULT = false;

				/**
	 * The cached value of the '{@link #isResourceAttribute() <em>Resource Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isResourceAttribute()
	 * @generated
	 * @ordered
	 */
	protected boolean resourceAttribute = RESOURCE_ATTRIBUTE_EDEFAULT;

				/**
	 * The default value of the '{@link #getDefaultValue() <em>Default Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultValue()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_VALUE_EDEFAULT = null;

				/**
	 * The cached value of the '{@link #getDefaultValue() <em>Default Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultValue()
	 * @generated
	 * @ordered
	 */
	protected String defaultValue = DEFAULT_VALUE_EDEFAULT;

				/**
	 * The default value of the '{@link #getMinRangeValue() <em>Min Range Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinRangeValue()
	 * @generated
	 * @ordered
	 */
	protected static final String MIN_RANGE_VALUE_EDEFAULT = null;

				/**
	 * The cached value of the '{@link #getMinRangeValue() <em>Min Range Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinRangeValue()
	 * @generated
	 * @ordered
	 */
	protected String minRangeValue = MIN_RANGE_VALUE_EDEFAULT;

				/**
	 * The default value of the '{@link #getMaxRangeValue() <em>Max Range Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxRangeValue()
	 * @generated
	 * @ordered
	 */
	protected static final String MAX_RANGE_VALUE_EDEFAULT = null;

				/**
	 * The cached value of the '{@link #getMaxRangeValue() <em>Max Range Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxRangeValue()
	 * @generated
	 * @ordered
	 */
	protected String maxRangeValue = MAX_RANGE_VALUE_EDEFAULT;

				/**
	 * The default value of the '{@link #getWeight() <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWeight()
	 * @generated
	 * @ordered
	 */
	protected static final Double WEIGHT_EDEFAULT = null;

				/**
	 * The cached value of the '{@link #getWeight() <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWeight()
	 * @generated
	 * @ordered
	 */
	protected Double weight = WEIGHT_EDEFAULT;

				/**
	 * The default value of the '{@link #isMinimize() <em>Minimize</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMinimize()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MINIMIZE_EDEFAULT = false;

				/**
	 * The cached value of the '{@link #isMinimize() <em>Minimize</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMinimize()
	 * @generated
	 * @ordered
	 */
	protected boolean minimize = MINIMIZE_EDEFAULT;

				/**
	 * The default value of the '{@link #getObjectiveFunctionAggregator() <em>Objective Function Aggregator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjectiveFunctionAggregator()
	 * @generated
	 * @ordered
	 */
	protected static final ObjectiveFunctionType OBJECTIVE_FUNCTION_AGGREGATOR_EDEFAULT = ObjectiveFunctionType.NOT_ASSIGNED;

				/**
	 * The cached value of the '{@link #getObjectiveFunctionAggregator() <em>Objective Function Aggregator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjectiveFunctionAggregator()
	 * @generated
	 * @ordered
	 */
	protected ObjectiveFunctionType objectiveFunctionAggregator = OBJECTIVE_FUNCTION_AGGREGATOR_EDEFAULT;

				/**
	 * The default value of the '{@link #isAlert() <em>Alert</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAlert()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ALERT_EDEFAULT = false;

				/**
	 * The cached value of the '{@link #isAlert() <em>Alert</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAlert()
	 * @generated
	 * @ordered
	 */
	protected boolean alert = ALERT_EDEFAULT;

				/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected AttributeImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return FeatureModelPackage.Literals.ATTRIBUTE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, FeatureModelPackage.ATTRIBUTE__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FeatureModelPackage.ATTRIBUTE__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FeatureModelPackage.ATTRIBUTE__DESCRIPTION, oldDescription, description));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FeatureModelPackage.ATTRIBUTE__COMMENT, oldComment, comment));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Feature getFeature() {
		if (eContainerFeatureID() != FeatureModelPackage.ATTRIBUTE__FEATURE) return null;
		return (Feature)eInternalContainer();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain basicSetFeature(Feature newFeature, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newFeature, FeatureModelPackage.ATTRIBUTE__FEATURE, msgs);
		return msgs;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setFeature(Feature newFeature) {
		if (newFeature != eInternalContainer() || (eContainerFeatureID() != FeatureModelPackage.ATTRIBUTE__FEATURE && newFeature != null)) {
			if (EcoreUtil.isAncestor(this, newFeature))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newFeature != null)
				msgs = ((InternalEObject)newFeature).eInverseAdd(this, FeatureModelPackage.FEATURE__ATTRIBUTES, Feature.class, msgs);
			msgs = basicSetFeature(newFeature, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FeatureModelPackage.ATTRIBUTE__FEATURE, newFeature, newFeature));
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefaultValue() {
		return defaultValue;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultValue(String newDefaultValue) {
		String oldDefaultValue = defaultValue;
		defaultValue = newDefaultValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FeatureModelPackage.ATTRIBUTE__DEFAULT_VALUE, oldDefaultValue, defaultValue));
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMinRangeValue() {
		return minRangeValue;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinRangeValue(String newMinRangeValue) {
		String oldMinRangeValue = minRangeValue;
		minRangeValue = newMinRangeValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FeatureModelPackage.ATTRIBUTE__MIN_RANGE_VALUE, oldMinRangeValue, minRangeValue));
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMaxRangeValue() {
		return maxRangeValue;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxRangeValue(String newMaxRangeValue) {
		String oldMaxRangeValue = maxRangeValue;
		maxRangeValue = newMaxRangeValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FeatureModelPackage.ATTRIBUTE__MAX_RANGE_VALUE, oldMaxRangeValue, maxRangeValue));
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Double getWeight() {
		return weight;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWeight(Double newWeight) {
		Double oldWeight = weight;
		weight = newWeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FeatureModelPackage.ATTRIBUTE__WEIGHT, oldWeight, weight));
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMinimize() {
		return minimize;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinimize(boolean newMinimize) {
		boolean oldMinimize = minimize;
		minimize = newMinimize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FeatureModelPackage.ATTRIBUTE__MINIMIZE, oldMinimize, minimize));
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectiveFunctionType getObjectiveFunctionAggregator() {
		return objectiveFunctionAggregator;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObjectiveFunctionAggregator(ObjectiveFunctionType newObjectiveFunctionAggregator) {
		ObjectiveFunctionType oldObjectiveFunctionAggregator = objectiveFunctionAggregator;
		objectiveFunctionAggregator = newObjectiveFunctionAggregator == null ? OBJECTIVE_FUNCTION_AGGREGATOR_EDEFAULT : newObjectiveFunctionAggregator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FeatureModelPackage.ATTRIBUTE__OBJECTIVE_FUNCTION_AGGREGATOR, oldObjectiveFunctionAggregator, objectiveFunctionAggregator));
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAlert() {
		return alert;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAlert(boolean newAlert) {
		boolean oldAlert = alert;
		alert = newAlert;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FeatureModelPackage.ATTRIBUTE__ALERT, oldAlert, alert));
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isQualityAttribute() {
		return qualityAttribute;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQualityAttribute(boolean newQualityAttribute) {
		boolean oldQualityAttribute = qualityAttribute;
		qualityAttribute = newQualityAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FeatureModelPackage.ATTRIBUTE__QUALITY_ATTRIBUTE, oldQualityAttribute, qualityAttribute));
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isResourceAttribute() {
		return resourceAttribute;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceAttribute(boolean newResourceAttribute) {
		boolean oldResourceAttribute = resourceAttribute;
		resourceAttribute = newResourceAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FeatureModelPackage.ATTRIBUTE__RESOURCE_ATTRIBUTE, oldResourceAttribute, resourceAttribute));
	}

				/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FeatureModelPackage.ATTRIBUTE__FEATURE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetFeature((Feature)otherEnd, msgs);
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
			case FeatureModelPackage.ATTRIBUTE__FEATURE:
				return basicSetFeature(null, msgs);
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
			case FeatureModelPackage.ATTRIBUTE__FEATURE:
				return eInternalContainer().eInverseRemove(this, FeatureModelPackage.FEATURE__ATTRIBUTES, Feature.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public AttributeType getType() {
		return type;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setType(AttributeType newType) {
		AttributeType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FeatureModelPackage.ATTRIBUTE__TYPE, oldType, type));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FeatureModelPackage.ATTRIBUTE__ID:
				return getId();
			case FeatureModelPackage.ATTRIBUTE__NAME:
				return getName();
			case FeatureModelPackage.ATTRIBUTE__TYPE:
				return getType();
			case FeatureModelPackage.ATTRIBUTE__DESCRIPTION:
				return getDescription();
			case FeatureModelPackage.ATTRIBUTE__COMMENT:
				return getComment();
			case FeatureModelPackage.ATTRIBUTE__FEATURE:
				return getFeature();
			case FeatureModelPackage.ATTRIBUTE__QUALITY_ATTRIBUTE:
				return isQualityAttribute();
			case FeatureModelPackage.ATTRIBUTE__RESOURCE_ATTRIBUTE:
				return isResourceAttribute();
			case FeatureModelPackage.ATTRIBUTE__DEFAULT_VALUE:
				return getDefaultValue();
			case FeatureModelPackage.ATTRIBUTE__MIN_RANGE_VALUE:
				return getMinRangeValue();
			case FeatureModelPackage.ATTRIBUTE__MAX_RANGE_VALUE:
				return getMaxRangeValue();
			case FeatureModelPackage.ATTRIBUTE__WEIGHT:
				return getWeight();
			case FeatureModelPackage.ATTRIBUTE__MINIMIZE:
				return isMinimize();
			case FeatureModelPackage.ATTRIBUTE__OBJECTIVE_FUNCTION_AGGREGATOR:
				return getObjectiveFunctionAggregator();
			case FeatureModelPackage.ATTRIBUTE__ALERT:
				return isAlert();
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
			case FeatureModelPackage.ATTRIBUTE__ID:
				setId((String)newValue);
				return;
			case FeatureModelPackage.ATTRIBUTE__NAME:
				setName((String)newValue);
				return;
			case FeatureModelPackage.ATTRIBUTE__TYPE:
				setType((AttributeType)newValue);
				return;
			case FeatureModelPackage.ATTRIBUTE__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case FeatureModelPackage.ATTRIBUTE__COMMENT:
				setComment((String)newValue);
				return;
			case FeatureModelPackage.ATTRIBUTE__FEATURE:
				setFeature((Feature)newValue);
				return;
			case FeatureModelPackage.ATTRIBUTE__QUALITY_ATTRIBUTE:
				setQualityAttribute((Boolean)newValue);
				return;
			case FeatureModelPackage.ATTRIBUTE__RESOURCE_ATTRIBUTE:
				setResourceAttribute((Boolean)newValue);
				return;
			case FeatureModelPackage.ATTRIBUTE__DEFAULT_VALUE:
				setDefaultValue((String)newValue);
				return;
			case FeatureModelPackage.ATTRIBUTE__MIN_RANGE_VALUE:
				setMinRangeValue((String)newValue);
				return;
			case FeatureModelPackage.ATTRIBUTE__MAX_RANGE_VALUE:
				setMaxRangeValue((String)newValue);
				return;
			case FeatureModelPackage.ATTRIBUTE__WEIGHT:
				setWeight((Double)newValue);
				return;
			case FeatureModelPackage.ATTRIBUTE__MINIMIZE:
				setMinimize((Boolean)newValue);
				return;
			case FeatureModelPackage.ATTRIBUTE__OBJECTIVE_FUNCTION_AGGREGATOR:
				setObjectiveFunctionAggregator((ObjectiveFunctionType)newValue);
				return;
			case FeatureModelPackage.ATTRIBUTE__ALERT:
				setAlert((Boolean)newValue);
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
			case FeatureModelPackage.ATTRIBUTE__ID:
				setId(ID_EDEFAULT);
				return;
			case FeatureModelPackage.ATTRIBUTE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case FeatureModelPackage.ATTRIBUTE__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case FeatureModelPackage.ATTRIBUTE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case FeatureModelPackage.ATTRIBUTE__COMMENT:
				setComment(COMMENT_EDEFAULT);
				return;
			case FeatureModelPackage.ATTRIBUTE__FEATURE:
				setFeature((Feature)null);
				return;
			case FeatureModelPackage.ATTRIBUTE__QUALITY_ATTRIBUTE:
				setQualityAttribute(QUALITY_ATTRIBUTE_EDEFAULT);
				return;
			case FeatureModelPackage.ATTRIBUTE__RESOURCE_ATTRIBUTE:
				setResourceAttribute(RESOURCE_ATTRIBUTE_EDEFAULT);
				return;
			case FeatureModelPackage.ATTRIBUTE__DEFAULT_VALUE:
				setDefaultValue(DEFAULT_VALUE_EDEFAULT);
				return;
			case FeatureModelPackage.ATTRIBUTE__MIN_RANGE_VALUE:
				setMinRangeValue(MIN_RANGE_VALUE_EDEFAULT);
				return;
			case FeatureModelPackage.ATTRIBUTE__MAX_RANGE_VALUE:
				setMaxRangeValue(MAX_RANGE_VALUE_EDEFAULT);
				return;
			case FeatureModelPackage.ATTRIBUTE__WEIGHT:
				setWeight(WEIGHT_EDEFAULT);
				return;
			case FeatureModelPackage.ATTRIBUTE__MINIMIZE:
				setMinimize(MINIMIZE_EDEFAULT);
				return;
			case FeatureModelPackage.ATTRIBUTE__OBJECTIVE_FUNCTION_AGGREGATOR:
				setObjectiveFunctionAggregator(OBJECTIVE_FUNCTION_AGGREGATOR_EDEFAULT);
				return;
			case FeatureModelPackage.ATTRIBUTE__ALERT:
				setAlert(ALERT_EDEFAULT);
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
			case FeatureModelPackage.ATTRIBUTE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case FeatureModelPackage.ATTRIBUTE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case FeatureModelPackage.ATTRIBUTE__TYPE:
				return type != TYPE_EDEFAULT;
			case FeatureModelPackage.ATTRIBUTE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case FeatureModelPackage.ATTRIBUTE__COMMENT:
				return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
			case FeatureModelPackage.ATTRIBUTE__FEATURE:
				return getFeature() != null;
			case FeatureModelPackage.ATTRIBUTE__QUALITY_ATTRIBUTE:
				return qualityAttribute != QUALITY_ATTRIBUTE_EDEFAULT;
			case FeatureModelPackage.ATTRIBUTE__RESOURCE_ATTRIBUTE:
				return resourceAttribute != RESOURCE_ATTRIBUTE_EDEFAULT;
			case FeatureModelPackage.ATTRIBUTE__DEFAULT_VALUE:
				return DEFAULT_VALUE_EDEFAULT == null ? defaultValue != null : !DEFAULT_VALUE_EDEFAULT.equals(defaultValue);
			case FeatureModelPackage.ATTRIBUTE__MIN_RANGE_VALUE:
				return MIN_RANGE_VALUE_EDEFAULT == null ? minRangeValue != null : !MIN_RANGE_VALUE_EDEFAULT.equals(minRangeValue);
			case FeatureModelPackage.ATTRIBUTE__MAX_RANGE_VALUE:
				return MAX_RANGE_VALUE_EDEFAULT == null ? maxRangeValue != null : !MAX_RANGE_VALUE_EDEFAULT.equals(maxRangeValue);
			case FeatureModelPackage.ATTRIBUTE__WEIGHT:
				return WEIGHT_EDEFAULT == null ? weight != null : !WEIGHT_EDEFAULT.equals(weight);
			case FeatureModelPackage.ATTRIBUTE__MINIMIZE:
				return minimize != MINIMIZE_EDEFAULT;
			case FeatureModelPackage.ATTRIBUTE__OBJECTIVE_FUNCTION_AGGREGATOR:
				return objectiveFunctionAggregator != OBJECTIVE_FUNCTION_AGGREGATOR_EDEFAULT;
			case FeatureModelPackage.ATTRIBUTE__ALERT:
				return alert != ALERT_EDEFAULT;
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
		result.append(", type: ");
		result.append(type);
		result.append(", description: ");
		result.append(description);
		result.append(", comment: ");
		result.append(comment);
		result.append(", qualityAttribute: ");
		result.append(qualityAttribute);
		result.append(", resourceAttribute: ");
		result.append(resourceAttribute);
		result.append(", defaultValue: ");
		result.append(defaultValue);
		result.append(", minRangeValue: ");
		result.append(minRangeValue);
		result.append(", maxRangeValue: ");
		result.append(maxRangeValue);
		result.append(", weight: ");
		result.append(weight);
		result.append(", minimize: ");
		result.append(minimize);
		result.append(", objectiveFunctionAggregator: ");
		result.append(objectiveFunctionAggregator);
		result.append(", alert: ");
		result.append(alert);
		result.append(')');
		return result.toString();
	}

} //AttributeImpl
