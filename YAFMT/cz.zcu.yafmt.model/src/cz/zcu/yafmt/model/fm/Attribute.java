/**
 */
package cz.zcu.yafmt.model.fm;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link cz.zcu.yafmt.model.fm.Attribute#getId <em>Id</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.Attribute#getName <em>Name</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.Attribute#getType <em>Type</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.Attribute#getDescription <em>Description</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.Attribute#getComment <em>Comment</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.Attribute#getFeature <em>Feature</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.Attribute#isQualityAttribute <em>Quality Attribute</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.Attribute#isResourceAttribute <em>Resource Attribute</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.Attribute#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.Attribute#getMinRangeValue <em>Min Range Value</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.Attribute#getMaxRangeValue <em>Max Range Value</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.Attribute#getWeight <em>Weight</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.Attribute#isMinimize <em>Minimize</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.Attribute#getObjectiveFunctionAggregator <em>Objective Function Aggregator</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.Attribute#isAlert <em>Alert</em>}</li>
 * </ul>
 *
 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getAttribute()
 * @model
 * @generated
 */
public interface Attribute extends EObject {
    /**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getAttribute_Id()
	 * @model id="true" required="true"
	 * @generated
	 */
    String getId();

    /**
	 * Sets the value of the '{@link cz.zcu.yafmt.model.fm.Attribute#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
    void setId(String value);

    /**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getAttribute_Name()
	 * @model required="true"
	 * @generated
	 */
    String getName();

    /**
	 * Sets the value of the '{@link cz.zcu.yafmt.model.fm.Attribute#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
    void setName(String value);

    /**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Description</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getAttribute_Description()
	 * @model
	 * @generated
	 */
    String getDescription();

    /**
	 * Sets the value of the '{@link cz.zcu.yafmt.model.fm.Attribute#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
    void setDescription(String value);

    /**
	 * Returns the value of the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Comment</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Comment</em>' attribute.
	 * @see #setComment(String)
	 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getAttribute_Comment()
	 * @model
	 * @generated
	 */
    String getComment();

    /**
	 * Sets the value of the '{@link cz.zcu.yafmt.model.fm.Attribute#getComment <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comment</em>' attribute.
	 * @see #getComment()
	 * @generated
	 */
    void setComment(String value);

    /**
	 * Returns the value of the '<em><b>Feature</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link cz.zcu.yafmt.model.fm.Feature#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Feature</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature</em>' container reference.
	 * @see #setFeature(Feature)
	 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getAttribute_Feature()
	 * @see cz.zcu.yafmt.model.fm.Feature#getAttributes
	 * @model opposite="attributes" required="true" transient="false"
	 * @generated
	 */
    Feature getFeature();

    /**
	 * Sets the value of the '{@link cz.zcu.yafmt.model.fm.Attribute#getFeature <em>Feature</em>}' container reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature</em>' container reference.
	 * @see #getFeature()
	 * @generated
	 */
    void setFeature(Feature value);

    /**
	 * Returns the value of the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Value</em>' attribute.
	 * @see #setDefaultValue(String)
	 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getAttribute_DefaultValue()
	 * @model
	 * @generated
	 */
	String getDefaultValue();

				/**
	 * Sets the value of the '{@link cz.zcu.yafmt.model.fm.Attribute#getDefaultValue <em>Default Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Value</em>' attribute.
	 * @see #getDefaultValue()
	 * @generated
	 */
	void setDefaultValue(String value);

				/**
	 * Returns the value of the '<em><b>Min Range Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Range Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Range Value</em>' attribute.
	 * @see #setMinRangeValue(String)
	 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getAttribute_MinRangeValue()
	 * @model
	 * @generated
	 */
	String getMinRangeValue();

				/**
	 * Sets the value of the '{@link cz.zcu.yafmt.model.fm.Attribute#getMinRangeValue <em>Min Range Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Range Value</em>' attribute.
	 * @see #getMinRangeValue()
	 * @generated
	 */
	void setMinRangeValue(String value);

				/**
	 * Returns the value of the '<em><b>Max Range Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Range Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Range Value</em>' attribute.
	 * @see #setMaxRangeValue(String)
	 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getAttribute_MaxRangeValue()
	 * @model
	 * @generated
	 */
	String getMaxRangeValue();

				/**
	 * Sets the value of the '{@link cz.zcu.yafmt.model.fm.Attribute#getMaxRangeValue <em>Max Range Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Range Value</em>' attribute.
	 * @see #getMaxRangeValue()
	 * @generated
	 */
	void setMaxRangeValue(String value);

				/**
	 * Returns the value of the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Weight</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Weight</em>' attribute.
	 * @see #setWeight(Double)
	 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getAttribute_Weight()
	 * @model
	 * @generated
	 */
	Double getWeight();

				/**
	 * Sets the value of the '{@link cz.zcu.yafmt.model.fm.Attribute#getWeight <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Weight</em>' attribute.
	 * @see #getWeight()
	 * @generated
	 */
	void setWeight(Double value);

				/**
	 * Returns the value of the '<em><b>Minimize</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Minimize</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Minimize</em>' attribute.
	 * @see #setMinimize(boolean)
	 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getAttribute_Minimize()
	 * @model
	 * @generated
	 */
	boolean isMinimize();

				/**
	 * Sets the value of the '{@link cz.zcu.yafmt.model.fm.Attribute#isMinimize <em>Minimize</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minimize</em>' attribute.
	 * @see #isMinimize()
	 * @generated
	 */
	void setMinimize(boolean value);

				/**
	 * Returns the value of the '<em><b>Objective Function Aggregator</b></em>' attribute.
	 * The literals are from the enumeration {@link cz.zcu.yafmt.model.fm.ObjectiveFunctionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Objective Function Aggregator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Objective Function Aggregator</em>' attribute.
	 * @see cz.zcu.yafmt.model.fm.ObjectiveFunctionType
	 * @see #setObjectiveFunctionAggregator(ObjectiveFunctionType)
	 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getAttribute_ObjectiveFunctionAggregator()
	 * @model
	 * @generated
	 */
	ObjectiveFunctionType getObjectiveFunctionAggregator();

				/**
	 * Sets the value of the '{@link cz.zcu.yafmt.model.fm.Attribute#getObjectiveFunctionAggregator <em>Objective Function Aggregator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Objective Function Aggregator</em>' attribute.
	 * @see cz.zcu.yafmt.model.fm.ObjectiveFunctionType
	 * @see #getObjectiveFunctionAggregator()
	 * @generated
	 */
	void setObjectiveFunctionAggregator(ObjectiveFunctionType value);

				/**
	 * Returns the value of the '<em><b>Alert</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alert</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alert</em>' attribute.
	 * @see #setAlert(boolean)
	 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getAttribute_Alert()
	 * @model
	 * @generated
	 */
	boolean isAlert();

				/**
	 * Sets the value of the '{@link cz.zcu.yafmt.model.fm.Attribute#isAlert <em>Alert</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alert</em>' attribute.
	 * @see #isAlert()
	 * @generated
	 */
	void setAlert(boolean value);

				/**
	 * Returns the value of the '<em><b>Quality Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Quality Attribute</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quality Attribute</em>' attribute.
	 * @see #setQualityAttribute(boolean)
	 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getAttribute_QualityAttribute()
	 * @model
	 * @generated
	 */
	boolean isQualityAttribute();

				/**
	 * Sets the value of the '{@link cz.zcu.yafmt.model.fm.Attribute#isQualityAttribute <em>Quality Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quality Attribute</em>' attribute.
	 * @see #isQualityAttribute()
	 * @generated
	 */
	void setQualityAttribute(boolean value);

				/**
	 * Returns the value of the '<em><b>Resource Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Attribute</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Attribute</em>' attribute.
	 * @see #setResourceAttribute(boolean)
	 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getAttribute_ResourceAttribute()
	 * @model
	 * @generated
	 */
	boolean isResourceAttribute();

				/**
	 * Sets the value of the '{@link cz.zcu.yafmt.model.fm.Attribute#isResourceAttribute <em>Resource Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Attribute</em>' attribute.
	 * @see #isResourceAttribute()
	 * @generated
	 */
	void setResourceAttribute(boolean value);

				/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>"boolean"</code>.
	 * The literals are from the enumeration {@link cz.zcu.yafmt.model.fm.AttributeType}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see cz.zcu.yafmt.model.fm.AttributeType
	 * @see #setType(AttributeType)
	 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getAttribute_Type()
	 * @model default="boolean" required="true"
	 * @generated
	 */
    AttributeType getType();

    /**
	 * Sets the value of the '{@link cz.zcu.yafmt.model.fm.Attribute#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see cz.zcu.yafmt.model.fm.AttributeType
	 * @see #getType()
	 * @generated
	 */
    void setType(AttributeType value);

} // Attribute
