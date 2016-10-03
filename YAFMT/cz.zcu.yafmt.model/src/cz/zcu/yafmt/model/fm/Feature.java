/**
 */
package cz.zcu.yafmt.model.fm;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link cz.zcu.yafmt.model.fm.Feature#getId <em>Id</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.Feature#getName <em>Name</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.Feature#getDescription <em>Description</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.Feature#getComment <em>Comment</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.Feature#getLower <em>Lower</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.Feature#getUpper <em>Upper</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.Feature#isRoot <em>Root</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.Feature#isOrphan <em>Orphan</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.Feature#isOptional <em>Optional</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.Feature#isMandatory <em>Mandatory</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.Feature#isCloneable <em>Cloneable</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.Feature#getParent <em>Parent</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.Feature#getParentFeature <em>Parent Feature</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.Feature#getParentGroup <em>Parent Group</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.Feature#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.Feature#getFeatures <em>Features</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.Feature#getGroups <em>Groups</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.Feature#getFeatureModel <em>Feature Model</em>}</li>
 * </ul>
 *
 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getFeature()
 * @model
 * @generated
 */
public interface Feature extends EObject {
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
	 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getFeature_Id()
	 * @model required="true"
	 * @generated
	 */
    String getId();

    /**
	 * Sets the value of the '{@link cz.zcu.yafmt.model.fm.Feature#getId <em>Id</em>}' attribute.
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
	 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getFeature_Name()
	 * @model required="true"
	 * @generated
	 */
    String getName();

    /**
	 * Sets the value of the '{@link cz.zcu.yafmt.model.fm.Feature#getName <em>Name</em>}' attribute.
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
	 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getFeature_Description()
	 * @model
	 * @generated
	 */
    String getDescription();

    /**
	 * Sets the value of the '{@link cz.zcu.yafmt.model.fm.Feature#getDescription <em>Description</em>}' attribute.
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
	 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getFeature_Comment()
	 * @model
	 * @generated
	 */
    String getComment();

    /**
	 * Sets the value of the '{@link cz.zcu.yafmt.model.fm.Feature#getComment <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comment</em>' attribute.
	 * @see #getComment()
	 * @generated
	 */
    void setComment(String value);

    /**
	 * Returns the value of the '<em><b>Lower</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Lower</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower</em>' attribute.
	 * @see #setLower(int)
	 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getFeature_Lower()
	 * @model default="0" required="true"
	 * @generated
	 */
    int getLower();

    /**
	 * Sets the value of the '{@link cz.zcu.yafmt.model.fm.Feature#getLower <em>Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower</em>' attribute.
	 * @see #getLower()
	 * @generated
	 */
    void setLower(int value);

    /**
	 * Returns the value of the '<em><b>Upper</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Upper</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Upper</em>' attribute.
	 * @see #setUpper(int)
	 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getFeature_Upper()
	 * @model default="1" required="true"
	 * @generated
	 */
    int getUpper();

    /**
	 * Sets the value of the '{@link cz.zcu.yafmt.model.fm.Feature#getUpper <em>Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper</em>' attribute.
	 * @see #getUpper()
	 * @generated
	 */
    void setUpper(int value);

    /**
	 * Returns the value of the '<em><b>Root</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Root</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Root</em>' attribute.
	 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getFeature_Root()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
    boolean isRoot();

    /**
	 * Returns the value of the '<em><b>Orphan</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Orphan</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Orphan</em>' attribute.
	 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getFeature_Orphan()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
    boolean isOrphan();

    /**
	 * Returns the value of the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Optional</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Optional</em>' attribute.
	 * @see #setOptional(boolean)
	 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getFeature_Optional()
	 * @model required="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
    boolean isOptional();

    /**
	 * Sets the value of the '{@link cz.zcu.yafmt.model.fm.Feature#isOptional <em>Optional</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Optional</em>' attribute.
	 * @see #isOptional()
	 * @generated
	 */
    void setOptional(boolean value);

    /**
	 * Returns the value of the '<em><b>Mandatory</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Mandatory</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Mandatory</em>' attribute.
	 * @see #setMandatory(boolean)
	 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getFeature_Mandatory()
	 * @model required="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
    boolean isMandatory();

    /**
	 * Sets the value of the '{@link cz.zcu.yafmt.model.fm.Feature#isMandatory <em>Mandatory</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mandatory</em>' attribute.
	 * @see #isMandatory()
	 * @generated
	 */
    void setMandatory(boolean value);

    /**
	 * Returns the value of the '<em><b>Cloneable</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Cloneable</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Cloneable</em>' attribute.
	 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getFeature_Cloneable()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
    boolean isCloneable();

    /**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link cz.zcu.yafmt.model.fm.Attribute}.
	 * It is bidirectional and its opposite is '{@link cz.zcu.yafmt.model.fm.Attribute#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getFeature_Attributes()
	 * @see cz.zcu.yafmt.model.fm.Attribute#getFeature
	 * @model opposite="feature" containment="true"
	 * @generated
	 */
    EList<Attribute> getAttributes();

    /**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parent</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(EObject)
	 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getFeature_Parent()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
    EObject getParent();

    /**
	 * Sets the value of the '{@link cz.zcu.yafmt.model.fm.Feature#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
    void setParent(EObject value);

    /**
	 * Returns the value of the '<em><b>Parent Feature</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link cz.zcu.yafmt.model.fm.Feature#getFeatures <em>Features</em>}'.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parent Feature</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Feature</em>' container reference.
	 * @see #setParentFeature(Feature)
	 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getFeature_ParentFeature()
	 * @see cz.zcu.yafmt.model.fm.Feature#getFeatures
	 * @model opposite="features" transient="false"
	 * @generated
	 */
    Feature getParentFeature();

    /**
	 * Sets the value of the '{@link cz.zcu.yafmt.model.fm.Feature#getParentFeature <em>Parent Feature</em>}' container reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Feature</em>' container reference.
	 * @see #getParentFeature()
	 * @generated
	 */
    void setParentFeature(Feature value);

    /**
	 * Returns the value of the '<em><b>Parent Group</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link cz.zcu.yafmt.model.fm.Group#getFeatures <em>Features</em>}'.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parent Group</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Group</em>' container reference.
	 * @see #setParentGroup(Group)
	 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getFeature_ParentGroup()
	 * @see cz.zcu.yafmt.model.fm.Group#getFeatures
	 * @model opposite="features" transient="false"
	 * @generated
	 */
    Group getParentGroup();

    /**
	 * Sets the value of the '{@link cz.zcu.yafmt.model.fm.Feature#getParentGroup <em>Parent Group</em>}' container reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Group</em>' container reference.
	 * @see #getParentGroup()
	 * @generated
	 */
    void setParentGroup(Group value);

    /**
	 * Returns the value of the '<em><b>Features</b></em>' containment reference list.
	 * The list contents are of type {@link cz.zcu.yafmt.model.fm.Feature}.
	 * It is bidirectional and its opposite is '{@link cz.zcu.yafmt.model.fm.Feature#getParentFeature <em>Parent Feature</em>}'.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Features</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Features</em>' containment reference list.
	 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getFeature_Features()
	 * @see cz.zcu.yafmt.model.fm.Feature#getParentFeature
	 * @model opposite="parentFeature" containment="true"
	 * @generated
	 */
    EList<Feature> getFeatures();

    /**
	 * Returns the value of the '<em><b>Groups</b></em>' containment reference list.
	 * The list contents are of type {@link cz.zcu.yafmt.model.fm.Group}.
	 * It is bidirectional and its opposite is '{@link cz.zcu.yafmt.model.fm.Group#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Groups</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Groups</em>' containment reference list.
	 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getFeature_Groups()
	 * @see cz.zcu.yafmt.model.fm.Group#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
    EList<Group> getGroups();

    /**
	 * Returns the value of the '<em><b>Feature Model</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Feature Model</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Model</em>' reference.
	 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getFeature_FeatureModel()
	 * @model transient="true" changeable="false" derived="true"
	 * @generated
	 */
    FeatureModel getFeatureModel();

} // Feature
