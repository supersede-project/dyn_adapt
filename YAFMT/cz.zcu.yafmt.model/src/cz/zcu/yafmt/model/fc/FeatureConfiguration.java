/**
 */
package cz.zcu.yafmt.model.fc;

import cz.zcu.yafmt.model.fm.FeatureModel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link cz.zcu.yafmt.model.fc.FeatureConfiguration#getName <em>Name</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fc.FeatureConfiguration#getVersion <em>Version</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fc.FeatureConfiguration#getDescription <em>Description</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fc.FeatureConfiguration#getComment <em>Comment</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fc.FeatureConfiguration#getFeatureModel <em>Feature Model</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fc.FeatureConfiguration#getFeatureModelCopy <em>Feature Model Copy</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fc.FeatureConfiguration#getRoot <em>Root</em>}</li>
 * </ul>
 *
 * @see cz.zcu.yafmt.model.fc.FeatureConfigurationPackage#getFeatureConfiguration()
 * @model
 * @generated
 */
public interface FeatureConfiguration extends EObject {
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
	 * @see cz.zcu.yafmt.model.fc.FeatureConfigurationPackage#getFeatureConfiguration_Name()
	 * @model required="true"
	 * @generated
	 */
    String getName();

    /**
	 * Sets the value of the '{@link cz.zcu.yafmt.model.fc.FeatureConfiguration#getName <em>Name</em>}' attribute.
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
	 * @see cz.zcu.yafmt.model.fc.FeatureConfigurationPackage#getFeatureConfiguration_Description()
	 * @model
	 * @generated
	 */
    String getDescription();

    /**
	 * Sets the value of the '{@link cz.zcu.yafmt.model.fc.FeatureConfiguration#getDescription <em>Description</em>}' attribute.
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
	 * @see cz.zcu.yafmt.model.fc.FeatureConfigurationPackage#getFeatureConfiguration_Comment()
	 * @model
	 * @generated
	 */
    String getComment();

    /**
	 * Sets the value of the '{@link cz.zcu.yafmt.model.fc.FeatureConfiguration#getComment <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comment</em>' attribute.
	 * @see #getComment()
	 * @generated
	 */
    void setComment(String value);

    /**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Version</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see cz.zcu.yafmt.model.fc.FeatureConfigurationPackage#getFeatureConfiguration_Version()
	 * @model
	 * @generated
	 */
    String getVersion();

    /**
	 * Sets the value of the '{@link cz.zcu.yafmt.model.fc.FeatureConfiguration#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
    void setVersion(String value);

    /**
	 * Returns the value of the '<em><b>Feature Model</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Feature Model</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Model</em>' reference.
	 * @see #setFeatureModel(FeatureModel)
	 * @see cz.zcu.yafmt.model.fc.FeatureConfigurationPackage#getFeatureConfiguration_FeatureModel()
	 * @model
	 * @generated
	 */
    FeatureModel getFeatureModel();

    /**
	 * Sets the value of the '{@link cz.zcu.yafmt.model.fc.FeatureConfiguration#getFeatureModel <em>Feature Model</em>}' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature Model</em>' reference.
	 * @see #getFeatureModel()
	 * @generated
	 */
    void setFeatureModel(FeatureModel value);

    /**
	 * Returns the value of the '<em><b>Feature Model Copy</b></em>' containment reference.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Feature Model Copy</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Model Copy</em>' containment reference.
	 * @see #setFeatureModelCopy(FeatureModel)
	 * @see cz.zcu.yafmt.model.fc.FeatureConfigurationPackage#getFeatureConfiguration_FeatureModelCopy()
	 * @model containment="true" required="true"
	 * @generated
	 */
    FeatureModel getFeatureModelCopy();

    /**
	 * Sets the value of the '{@link cz.zcu.yafmt.model.fc.FeatureConfiguration#getFeatureModelCopy <em>Feature Model Copy</em>}' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature Model Copy</em>' containment reference.
	 * @see #getFeatureModelCopy()
	 * @generated
	 */
    void setFeatureModelCopy(FeatureModel value);

    /**
	 * Returns the value of the '<em><b>Root</b></em>' containment reference.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Root</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Root</em>' containment reference.
	 * @see #setRoot(Selection)
	 * @see cz.zcu.yafmt.model.fc.FeatureConfigurationPackage#getFeatureConfiguration_Root()
	 * @model containment="true" required="true"
	 * @generated
	 */
    Selection getRoot();

    /**
	 * Sets the value of the '{@link cz.zcu.yafmt.model.fc.FeatureConfiguration#getRoot <em>Root</em>}' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root</em>' containment reference.
	 * @see #getRoot()
	 * @generated
	 */
    void setRoot(Selection value);

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @model many="false"
	 * @generated
	 */
    EList<Selection> getSelectionsById(String id);

} // FeatureConfiguration
