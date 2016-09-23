/**
 */
package cz.zcu.yafmt.model.fc;

import cz.zcu.yafmt.model.fm.Feature;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Selection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link cz.zcu.yafmt.model.fc.Selection#getId <em>Id</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fc.Selection#getName <em>Name</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fc.Selection#getDescription <em>Description</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fc.Selection#getComment <em>Comment</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fc.Selection#getParent <em>Parent</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fc.Selection#isRoot <em>Root</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fc.Selection#isPresent <em>Present</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fc.Selection#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fc.Selection#getValues <em>Values</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fc.Selection#getSelections <em>Selections</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fc.Selection#getFeatureConfiguration <em>Feature Configuration</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fc.Selection#getFeature <em>Feature</em>}</li>
 * </ul>
 *
 * @see cz.zcu.yafmt.model.fc.FeatureConfigurationPackage#getSelection()
 * @model
 * @generated
 */
public interface Selection extends EObject {
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
	 * @see cz.zcu.yafmt.model.fc.FeatureConfigurationPackage#getSelection_Id()
	 * @model required="true"
	 * @generated
	 */
    String getId();

    /**
	 * Sets the value of the '{@link cz.zcu.yafmt.model.fc.Selection#getId <em>Id</em>}' attribute.
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
	 * @see cz.zcu.yafmt.model.fc.FeatureConfigurationPackage#getSelection_Name()
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
	 * @see cz.zcu.yafmt.model.fc.FeatureConfigurationPackage#getSelection_Description()
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
	 * @see cz.zcu.yafmt.model.fc.FeatureConfigurationPackage#getSelection_Comment()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
    String getComment();

    /**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link cz.zcu.yafmt.model.fc.Selection#getSelections <em>Selections</em>}'.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parent</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(Selection)
	 * @see cz.zcu.yafmt.model.fc.FeatureConfigurationPackage#getSelection_Parent()
	 * @see cz.zcu.yafmt.model.fc.Selection#getSelections
	 * @model opposite="selections" transient="false"
	 * @generated
	 */
    Selection getParent();

    /**
	 * Sets the value of the '{@link cz.zcu.yafmt.model.fc.Selection#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
    void setParent(Selection value);

    /**
	 * Returns the value of the '<em><b>Root</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Root</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Root</em>' attribute.
	 * @see cz.zcu.yafmt.model.fc.FeatureConfigurationPackage#getSelection_Root()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
    boolean isRoot();

    /**
	 * Returns the value of the '<em><b>Present</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Present</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Present</em>' attribute.
	 * @see cz.zcu.yafmt.model.fc.FeatureConfigurationPackage#getSelection_Present()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
    boolean isPresent();

    /**
	 * Returns the value of the '<em><b>Enabled</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Enabled</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled</em>' attribute.
	 * @see #setEnabled(boolean)
	 * @see cz.zcu.yafmt.model.fc.FeatureConfigurationPackage#getSelection_Enabled()
	 * @model default="true" required="true" transient="true"
	 * @generated
	 */
    boolean isEnabled();

    /**
	 * Sets the value of the '{@link cz.zcu.yafmt.model.fc.Selection#isEnabled <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled</em>' attribute.
	 * @see #isEnabled()
	 * @generated
	 */
    void setEnabled(boolean value);

    /**
	 * Returns the value of the '<em><b>Selections</b></em>' containment reference list.
	 * The list contents are of type {@link cz.zcu.yafmt.model.fc.Selection}.
	 * It is bidirectional and its opposite is '{@link cz.zcu.yafmt.model.fc.Selection#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Selections</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Selections</em>' containment reference list.
	 * @see cz.zcu.yafmt.model.fc.FeatureConfigurationPackage#getSelection_Selections()
	 * @see cz.zcu.yafmt.model.fc.Selection#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
    EList<Selection> getSelections();

    /**
	 * Returns the value of the '<em><b>Values</b></em>' containment reference list.
	 * The list contents are of type {@link cz.zcu.yafmt.model.fc.AttributeValue}.
	 * It is bidirectional and its opposite is '{@link cz.zcu.yafmt.model.fc.AttributeValue#getSelection <em>Selection</em>}'.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Values</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' containment reference list.
	 * @see cz.zcu.yafmt.model.fc.FeatureConfigurationPackage#getSelection_Values()
	 * @see cz.zcu.yafmt.model.fc.AttributeValue#getSelection
	 * @model opposite="selection" containment="true"
	 * @generated
	 */
    EList<AttributeValue> getValues();

    /**
	 * Returns the value of the '<em><b>Feature Configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Feature Configuration</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Configuration</em>' reference.
	 * @see #setFeatureConfiguration(FeatureConfiguration)
	 * @see cz.zcu.yafmt.model.fc.FeatureConfigurationPackage#getSelection_FeatureConfiguration()
	 * @model required="true" transient="true" derived="true"
	 * @generated
	 */
    FeatureConfiguration getFeatureConfiguration();

    /**
	 * Sets the value of the '{@link cz.zcu.yafmt.model.fc.Selection#getFeatureConfiguration <em>Feature Configuration</em>}' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature Configuration</em>' reference.
	 * @see #getFeatureConfiguration()
	 * @generated
	 */
    void setFeatureConfiguration(FeatureConfiguration value);

    /**
	 * Returns the value of the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Feature</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature</em>' reference.
	 * @see cz.zcu.yafmt.model.fc.FeatureConfigurationPackage#getSelection_Feature()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
    Feature getFeature();

} // Selection
