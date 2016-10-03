/**
 */
package cz.zcu.yafmt.model.fm;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link cz.zcu.yafmt.model.fm.FeatureModel#getName <em>Name</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.FeatureModel#getVersion <em>Version</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.FeatureModel#getDescription <em>Description</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.FeatureModel#getComment <em>Comment</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.FeatureModel#getRoot <em>Root</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.FeatureModel#getOrphans <em>Orphans</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.FeatureModel#getConstraints <em>Constraints</em>}</li>
 * </ul>
 *
 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getFeatureModel()
 * @model
 * @generated
 */
public interface FeatureModel extends EObject {
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
	 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getFeatureModel_Name()
	 * @model required="true"
	 * @generated
	 */
    String getName();

    /**
	 * Sets the value of the '{@link cz.zcu.yafmt.model.fm.FeatureModel#getName <em>Name</em>}' attribute.
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
	 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getFeatureModel_Description()
	 * @model
	 * @generated
	 */
    String getDescription();

    /**
	 * Sets the value of the '{@link cz.zcu.yafmt.model.fm.FeatureModel#getDescription <em>Description</em>}' attribute.
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
	 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getFeatureModel_Comment()
	 * @model
	 * @generated
	 */
    String getComment();

    /**
	 * Sets the value of the '{@link cz.zcu.yafmt.model.fm.FeatureModel#getComment <em>Comment</em>}' attribute.
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
	 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getFeatureModel_Version()
	 * @model
	 * @generated
	 */
    String getVersion();

    /**
	 * Sets the value of the '{@link cz.zcu.yafmt.model.fm.FeatureModel#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
    void setVersion(String value);

    /**
	 * Returns the value of the '<em><b>Root</b></em>' containment reference.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Root</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Root</em>' containment reference.
	 * @see #setRoot(Feature)
	 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getFeatureModel_Root()
	 * @model containment="true" required="true"
	 * @generated
	 */
    Feature getRoot();

    /**
	 * Sets the value of the '{@link cz.zcu.yafmt.model.fm.FeatureModel#getRoot <em>Root</em>}' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root</em>' containment reference.
	 * @see #getRoot()
	 * @generated
	 */
    void setRoot(Feature value);

    /**
	 * Returns the value of the '<em><b>Orphans</b></em>' containment reference list.
	 * The list contents are of type {@link cz.zcu.yafmt.model.fm.Feature}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Orphans</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Orphans</em>' containment reference list.
	 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getFeatureModel_Orphans()
	 * @model containment="true"
	 * @generated
	 */
    EList<Feature> getOrphans();

    /**
	 * Returns the value of the '<em><b>Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link cz.zcu.yafmt.model.fm.Constraint}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Constraints</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints</em>' containment reference list.
	 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getFeatureModel_Constraints()
	 * @model containment="true"
	 * @generated
	 */
    EList<Constraint> getConstraints();

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @model many="false"
	 * @generated
	 */
    EList<Feature> getFeaturesById(String id);

} // FeatureModel
