/**
 */
package eu.supersede.dynadapt.dsl.aspect;

import cz.zcu.yafmt.model.fm.Feature;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Model;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Aspect</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.supersede.dynadapt.dsl.aspect.Aspect#getName <em>Name</em>}</li>
 *   <li>{@link eu.supersede.dynadapt.dsl.aspect.Aspect#getFeature <em>Feature</em>}</li>
 *   <li>{@link eu.supersede.dynadapt.dsl.aspect.Aspect#getAdvice <em>Advice</em>}</li>
 *   <li>{@link eu.supersede.dynadapt.dsl.aspect.Aspect#getPointcuts <em>Pointcuts</em>}</li>
 *   <li>{@link eu.supersede.dynadapt.dsl.aspect.Aspect#getCompositions <em>Compositions</em>}</li>
 * </ul>
 *
 * @see eu.supersede.dynadapt.dsl.aspect.AspectPackage#getAspect()
 * @model
 * @generated
 */
public interface Aspect extends EObject
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
   * @see eu.supersede.dynadapt.dsl.aspect.AspectPackage#getAspect_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link eu.supersede.dynadapt.dsl.aspect.Aspect#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Feature</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Feature</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Feature</em>' reference.
   * @see #setFeature(Feature)
   * @see eu.supersede.dynadapt.dsl.aspect.AspectPackage#getAspect_Feature()
   * @model
   * @generated
   */
  Feature getFeature();

  /**
   * Sets the value of the '{@link eu.supersede.dynadapt.dsl.aspect.Aspect#getFeature <em>Feature</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Feature</em>' reference.
   * @see #getFeature()
   * @generated
   */
  void setFeature(Feature value);

  /**
   * Returns the value of the '<em><b>Advice</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Advice</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Advice</em>' reference.
   * @see #setAdvice(Model)
   * @see eu.supersede.dynadapt.dsl.aspect.AspectPackage#getAspect_Advice()
   * @model
   * @generated
   */
  Model getAdvice();

  /**
   * Sets the value of the '{@link eu.supersede.dynadapt.dsl.aspect.Aspect#getAdvice <em>Advice</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Advice</em>' reference.
   * @see #getAdvice()
   * @generated
   */
  void setAdvice(Model value);

  /**
   * Returns the value of the '<em><b>Pointcuts</b></em>' containment reference list.
   * The list contents are of type {@link eu.supersede.dynadapt.dsl.aspect.Pointcut}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Pointcuts</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Pointcuts</em>' containment reference list.
   * @see eu.supersede.dynadapt.dsl.aspect.AspectPackage#getAspect_Pointcuts()
   * @model containment="true"
   * @generated
   */
  EList<Pointcut> getPointcuts();

  /**
   * Returns the value of the '<em><b>Compositions</b></em>' containment reference list.
   * The list contents are of type {@link eu.supersede.dynadapt.dsl.aspect.Composition}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Compositions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Compositions</em>' containment reference list.
   * @see eu.supersede.dynadapt.dsl.aspect.AspectPackage#getAspect_Compositions()
   * @model containment="true"
   * @generated
   */
  EList<Composition> getCompositions();

} // Aspect
