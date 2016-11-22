/**
 */
package eu.supersede.dynadapt.dsl.aspect;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Stereotype;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.supersede.dynadapt.dsl.aspect.Composition#getName <em>Name</em>}</li>
 *   <li>{@link eu.supersede.dynadapt.dsl.aspect.Composition#getFeature_enabled <em>Feature enabled</em>}</li>
 *   <li>{@link eu.supersede.dynadapt.dsl.aspect.Composition#getJointpointRole <em>Jointpoint Role</em>}</li>
 *   <li>{@link eu.supersede.dynadapt.dsl.aspect.Composition#getAdvice <em>Advice</em>}</li>
 *   <li>{@link eu.supersede.dynadapt.dsl.aspect.Composition#getAction <em>Action</em>}</li>
 * </ul>
 *
 * @see eu.supersede.dynadapt.dsl.aspect.AspectPackage#getComposition()
 * @model
 * @generated
 */
public interface Composition extends EObject
{
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
   * @see eu.supersede.dynadapt.dsl.aspect.AspectPackage#getComposition_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link eu.supersede.dynadapt.dsl.aspect.Composition#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Feature enabled</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Feature enabled</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Feature enabled</em>' attribute.
   * @see #setFeature_enabled(Boolean)
   * @see eu.supersede.dynadapt.dsl.aspect.AspectPackage#getComposition_Feature_enabled()
   * @model
   * @generated
   */
  Boolean getFeature_enabled();

  /**
   * Sets the value of the '{@link eu.supersede.dynadapt.dsl.aspect.Composition#getFeature_enabled <em>Feature enabled</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Feature enabled</em>' attribute.
   * @see #getFeature_enabled()
   * @generated
   */
  void setFeature_enabled(Boolean value);

  /**
   * Returns the value of the '<em><b>Jointpoint Role</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Jointpoint Role</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Jointpoint Role</em>' reference.
   * @see #setJointpointRole(Stereotype)
   * @see eu.supersede.dynadapt.dsl.aspect.AspectPackage#getComposition_JointpointRole()
   * @model
   * @generated
   */
  Stereotype getJointpointRole();

  /**
   * Sets the value of the '{@link eu.supersede.dynadapt.dsl.aspect.Composition#getJointpointRole <em>Jointpoint Role</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Jointpoint Role</em>' reference.
   * @see #getJointpointRole()
   * @generated
   */
  void setJointpointRole(Stereotype value);

  /**
   * Returns the value of the '<em><b>Advice</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Advice</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Advice</em>' reference.
   * @see #setAdvice(Stereotype)
   * @see eu.supersede.dynadapt.dsl.aspect.AspectPackage#getComposition_Advice()
   * @model
   * @generated
   */
  Stereotype getAdvice();

  /**
   * Sets the value of the '{@link eu.supersede.dynadapt.dsl.aspect.Composition#getAdvice <em>Advice</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Advice</em>' reference.
   * @see #getAdvice()
   * @generated
   */
  void setAdvice(Stereotype value);

  /**
   * Returns the value of the '<em><b>Action</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Action</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Action</em>' containment reference.
   * @see #setAction(ActionOptionType)
   * @see eu.supersede.dynadapt.dsl.aspect.AspectPackage#getComposition_Action()
   * @model containment="true"
   * @generated
   */
  ActionOptionType getAction();

  /**
   * Sets the value of the '{@link eu.supersede.dynadapt.dsl.aspect.Composition#getAction <em>Action</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Action</em>' containment reference.
   * @see #getAction()
   * @generated
   */
  void setAction(ActionOptionType value);

} // Composition
