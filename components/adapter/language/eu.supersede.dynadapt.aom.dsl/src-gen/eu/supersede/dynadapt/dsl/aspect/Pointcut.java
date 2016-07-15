/**
 */
package eu.supersede.dynadapt.dsl.aspect;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Stereotype;

import org.eclipse.viatra.query.patternlanguage.patternLanguage.Pattern;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pointcut</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.supersede.dynadapt.dsl.aspect.Pointcut#getName <em>Name</em>}</li>
 *   <li>{@link eu.supersede.dynadapt.dsl.aspect.Pointcut#getPattern <em>Pattern</em>}</li>
 *   <li>{@link eu.supersede.dynadapt.dsl.aspect.Pointcut#getRole <em>Role</em>}</li>
 * </ul>
 *
 * @see eu.supersede.dynadapt.dsl.aspect.AspectPackage#getPointcut()
 * @model
 * @generated
 */
public interface Pointcut extends EObject
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
   * @see eu.supersede.dynadapt.dsl.aspect.AspectPackage#getPointcut_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link eu.supersede.dynadapt.dsl.aspect.Pointcut#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Pattern</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Pattern</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Pattern</em>' reference.
   * @see #setPattern(Pattern)
   * @see eu.supersede.dynadapt.dsl.aspect.AspectPackage#getPointcut_Pattern()
   * @model
   * @generated
   */
  Pattern getPattern();

  /**
   * Sets the value of the '{@link eu.supersede.dynadapt.dsl.aspect.Pointcut#getPattern <em>Pattern</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Pattern</em>' reference.
   * @see #getPattern()
   * @generated
   */
  void setPattern(Pattern value);

  /**
   * Returns the value of the '<em><b>Role</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Role</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Role</em>' reference.
   * @see #setRole(Stereotype)
   * @see eu.supersede.dynadapt.dsl.aspect.AspectPackage#getPointcut_Role()
   * @model
   * @generated
   */
  Stereotype getRole();

  /**
   * Sets the value of the '{@link eu.supersede.dynadapt.dsl.aspect.Pointcut#getRole <em>Role</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Role</em>' reference.
   * @see #getRole()
   * @generated
   */
  void setRole(Stereotype value);

} // Pointcut
