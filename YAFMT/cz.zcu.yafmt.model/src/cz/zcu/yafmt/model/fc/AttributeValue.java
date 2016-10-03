/**
 */
package cz.zcu.yafmt.model.fc;

import cz.zcu.yafmt.model.fm.Attribute;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link cz.zcu.yafmt.model.fc.AttributeValue#getId <em>Id</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fc.AttributeValue#getName <em>Name</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fc.AttributeValue#getDescription <em>Description</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fc.AttributeValue#getComment <em>Comment</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fc.AttributeValue#getSelection <em>Selection</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fc.AttributeValue#getAttribute <em>Attribute</em>}</li>
 * </ul>
 *
 * @see cz.zcu.yafmt.model.fc.FeatureConfigurationPackage#getAttributeValue()
 * @model abstract="true"
 * @generated
 */
public interface AttributeValue extends EObject {
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
	 * @see cz.zcu.yafmt.model.fc.FeatureConfigurationPackage#getAttributeValue_Id()
	 * @model required="true"
	 * @generated
	 */
    String getId();

    /**
	 * Sets the value of the '{@link cz.zcu.yafmt.model.fc.AttributeValue#getId <em>Id</em>}' attribute.
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
	 * @see cz.zcu.yafmt.model.fc.FeatureConfigurationPackage#getAttributeValue_Name()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
    String getName();

    /**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Description</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see cz.zcu.yafmt.model.fc.FeatureConfigurationPackage#getAttributeValue_Description()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
    String getDescription();

    /**
	 * Returns the value of the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Comment</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Comment</em>' attribute.
	 * @see cz.zcu.yafmt.model.fc.FeatureConfigurationPackage#getAttributeValue_Comment()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
    String getComment();

    /**
	 * Returns the value of the '<em><b>Selection</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link cz.zcu.yafmt.model.fc.Selection#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Selection</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Selection</em>' container reference.
	 * @see #setSelection(Selection)
	 * @see cz.zcu.yafmt.model.fc.FeatureConfigurationPackage#getAttributeValue_Selection()
	 * @see cz.zcu.yafmt.model.fc.Selection#getValues
	 * @model opposite="values" required="true" transient="false"
	 * @generated
	 */
    Selection getSelection();

    /**
	 * Sets the value of the '{@link cz.zcu.yafmt.model.fc.AttributeValue#getSelection <em>Selection</em>}' container reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Selection</em>' container reference.
	 * @see #getSelection()
	 * @generated
	 */
    void setSelection(Selection value);

    /**
	 * Returns the value of the '<em><b>Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Attribute</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute</em>' reference.
	 * @see cz.zcu.yafmt.model.fc.FeatureConfigurationPackage#getAttributeValue_Attribute()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
    Attribute getAttribute();

} // AttributeValue
