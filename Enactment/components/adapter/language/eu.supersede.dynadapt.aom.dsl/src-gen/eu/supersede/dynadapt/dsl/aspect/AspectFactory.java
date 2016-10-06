/**
 */
package eu.supersede.dynadapt.dsl.aspect;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see eu.supersede.dynadapt.dsl.aspect.AspectPackage
 * @generated
 */
public interface AspectFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  AspectFactory eINSTANCE = eu.supersede.dynadapt.dsl.aspect.impl.AspectFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Aspect</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Aspect</em>'.
   * @generated
   */
  Aspect createAspect();

  /**
   * Returns a new object of class '<em>Pointcut</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pointcut</em>'.
   * @generated
   */
  Pointcut createPointcut();

  /**
   * Returns a new object of class '<em>Composition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Composition</em>'.
   * @generated
   */
  Composition createComposition();

  /**
   * Returns a new object of class '<em>Action Option Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Action Option Type</em>'.
   * @generated
   */
  ActionOptionType createActionOptionType();

  /**
   * Returns a new object of class '<em>Update Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Update Value</em>'.
   * @generated
   */
  UpdateValue createUpdateValue();

  /**
   * Returns a new object of class '<em>Action</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Action</em>'.
   * @generated
   */
  Action createAction();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  AspectPackage getAspectPackage();

} //AspectFactory
