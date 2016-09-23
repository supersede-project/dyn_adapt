/**
 */
package cz.zcu.yafmt.model.fm;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link cz.zcu.yafmt.model.fm.Group#getLower <em>Lower</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.Group#getUpper <em>Upper</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.Group#getDescription <em>Description</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.Group#getComment <em>Comment</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.Group#isXor <em>Xor</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.Group#isOr <em>Or</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.Group#getParent <em>Parent</em>}</li>
 *   <li>{@link cz.zcu.yafmt.model.fm.Group#getFeatures <em>Features</em>}</li>
 * </ul>
 *
 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getGroup()
 * @model
 * @generated
 */
public interface Group extends EObject {
    /**
	 * Returns the value of the '<em><b>Lower</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Lower</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower</em>' attribute.
	 * @see #setLower(int)
	 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getGroup_Lower()
	 * @model default="1" required="true"
	 * @generated
	 */
    int getLower();

    /**
	 * Sets the value of the '{@link cz.zcu.yafmt.model.fm.Group#getLower <em>Lower</em>}' attribute.
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
	 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getGroup_Upper()
	 * @model default="1" required="true"
	 * @generated
	 */
    int getUpper();

    /**
	 * Sets the value of the '{@link cz.zcu.yafmt.model.fm.Group#getUpper <em>Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper</em>' attribute.
	 * @see #getUpper()
	 * @generated
	 */
    void setUpper(int value);

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
	 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getGroup_Description()
	 * @model
	 * @generated
	 */
    String getDescription();

    /**
	 * Sets the value of the '{@link cz.zcu.yafmt.model.fm.Group#getDescription <em>Description</em>}' attribute.
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
	 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getGroup_Comment()
	 * @model
	 * @generated
	 */
    String getComment();

    /**
	 * Sets the value of the '{@link cz.zcu.yafmt.model.fm.Group#getComment <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comment</em>' attribute.
	 * @see #getComment()
	 * @generated
	 */
    void setComment(String value);

    /**
	 * Returns the value of the '<em><b>Xor</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Xor</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Xor</em>' attribute.
	 * @see #setXor(boolean)
	 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getGroup_Xor()
	 * @model required="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
    boolean isXor();

    /**
	 * Sets the value of the '{@link cz.zcu.yafmt.model.fm.Group#isXor <em>Xor</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Xor</em>' attribute.
	 * @see #isXor()
	 * @generated
	 */
    void setXor(boolean value);

    /**
	 * Returns the value of the '<em><b>Or</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Or</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Or</em>' attribute.
	 * @see #setOr(boolean)
	 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getGroup_Or()
	 * @model required="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
    boolean isOr();

    /**
	 * Sets the value of the '{@link cz.zcu.yafmt.model.fm.Group#isOr <em>Or</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Or</em>' attribute.
	 * @see #isOr()
	 * @generated
	 */
    void setOr(boolean value);

    /**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link cz.zcu.yafmt.model.fm.Feature#getGroups <em>Groups</em>}'.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parent</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(Feature)
	 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getGroup_Parent()
	 * @see cz.zcu.yafmt.model.fm.Feature#getGroups
	 * @model opposite="groups" required="true" transient="false"
	 * @generated
	 */
    Feature getParent();

    /**
	 * Sets the value of the '{@link cz.zcu.yafmt.model.fm.Group#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
    void setParent(Feature value);

    /**
	 * Returns the value of the '<em><b>Features</b></em>' containment reference list.
	 * The list contents are of type {@link cz.zcu.yafmt.model.fm.Feature}.
	 * It is bidirectional and its opposite is '{@link cz.zcu.yafmt.model.fm.Feature#getParentGroup <em>Parent Group</em>}'.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Features</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Features</em>' containment reference list.
	 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage#getGroup_Features()
	 * @see cz.zcu.yafmt.model.fm.Feature#getParentGroup
	 * @model opposite="parentGroup" containment="true"
	 * @generated
	 */
    EList<Feature> getFeatures();

} // Group
