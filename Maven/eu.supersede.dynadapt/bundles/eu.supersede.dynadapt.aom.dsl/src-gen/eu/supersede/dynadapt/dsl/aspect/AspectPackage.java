/**
 */
package eu.supersede.dynadapt.dsl.aspect;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see eu.supersede.dynadapt.dsl.aspect.AspectFactory
 * @model kind="package"
 * @generated
 */
public interface AspectPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "aspect";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.supersede.eu/dynadapt/dsl/Aspect";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "aspect";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  AspectPackage eINSTANCE = eu.supersede.dynadapt.dsl.aspect.impl.AspectPackageImpl.init();

  /**
   * The meta object id for the '{@link eu.supersede.dynadapt.dsl.aspect.impl.AspectImpl <em>Aspect</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.supersede.dynadapt.dsl.aspect.impl.AspectImpl
   * @see eu.supersede.dynadapt.dsl.aspect.impl.AspectPackageImpl#getAspect()
   * @generated
   */
  int ASPECT = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASPECT__NAME = 0;

  /**
   * The feature id for the '<em><b>Feature</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASPECT__FEATURE = 1;

  /**
   * The feature id for the '<em><b>Advice</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASPECT__ADVICE = 2;

  /**
   * The feature id for the '<em><b>Pointcuts</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASPECT__POINTCUTS = 3;

  /**
   * The feature id for the '<em><b>Compositions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASPECT__COMPOSITIONS = 4;

  /**
   * The number of structural features of the '<em>Aspect</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASPECT_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link eu.supersede.dynadapt.dsl.aspect.impl.PointcutImpl <em>Pointcut</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.supersede.dynadapt.dsl.aspect.impl.PointcutImpl
   * @see eu.supersede.dynadapt.dsl.aspect.impl.AspectPackageImpl#getPointcut()
   * @generated
   */
  int POINTCUT = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POINTCUT__NAME = 0;

  /**
   * The feature id for the '<em><b>Pattern</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POINTCUT__PATTERN = 1;

  /**
   * The feature id for the '<em><b>Role</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POINTCUT__ROLE = 2;

  /**
   * The number of structural features of the '<em>Pointcut</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POINTCUT_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link eu.supersede.dynadapt.dsl.aspect.impl.CompositionImpl <em>Composition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.supersede.dynadapt.dsl.aspect.impl.CompositionImpl
   * @see eu.supersede.dynadapt.dsl.aspect.impl.AspectPackageImpl#getComposition()
   * @generated
   */
  int COMPOSITION = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPOSITION__NAME = 0;

  /**
   * The feature id for the '<em><b>Feature enabled</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPOSITION__FEATURE_ENABLED = 1;

  /**
   * The feature id for the '<em><b>Jointpoint Role</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPOSITION__JOINTPOINT_ROLE = 2;

  /**
   * The feature id for the '<em><b>Advice</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPOSITION__ADVICE = 3;

  /**
   * The feature id for the '<em><b>Action</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPOSITION__ACTION = 4;

  /**
   * The number of structural features of the '<em>Composition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPOSITION_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link eu.supersede.dynadapt.dsl.aspect.impl.ActionOptionTypeImpl <em>Action Option Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.supersede.dynadapt.dsl.aspect.impl.ActionOptionTypeImpl
   * @see eu.supersede.dynadapt.dsl.aspect.impl.AspectPackageImpl#getActionOptionType()
   * @generated
   */
  int ACTION_OPTION_TYPE = 3;

  /**
   * The number of structural features of the '<em>Action Option Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION_OPTION_TYPE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link eu.supersede.dynadapt.dsl.aspect.impl.UpdateValueImpl <em>Update Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.supersede.dynadapt.dsl.aspect.impl.UpdateValueImpl
   * @see eu.supersede.dynadapt.dsl.aspect.impl.AspectPackageImpl#getUpdateValue()
   * @generated
   */
  int UPDATE_VALUE = 4;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UPDATE_VALUE__VALUE = ACTION_OPTION_TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Update Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UPDATE_VALUE_FEATURE_COUNT = ACTION_OPTION_TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link eu.supersede.dynadapt.dsl.aspect.impl.ActionImpl <em>Action</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.supersede.dynadapt.dsl.aspect.impl.ActionImpl
   * @see eu.supersede.dynadapt.dsl.aspect.impl.AspectPackageImpl#getAction()
   * @generated
   */
  int ACTION = 5;

  /**
   * The feature id for the '<em><b>ADD</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION__ADD = ACTION_OPTION_TYPE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>DELETE</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION__DELETE = ACTION_OPTION_TYPE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>REPLACE</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION__REPLACE = ACTION_OPTION_TYPE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>UPDATE</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION__UPDATE = ACTION_OPTION_TYPE_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Action</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION_FEATURE_COUNT = ACTION_OPTION_TYPE_FEATURE_COUNT + 4;


  /**
   * Returns the meta object for class '{@link eu.supersede.dynadapt.dsl.aspect.Aspect <em>Aspect</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Aspect</em>'.
   * @see eu.supersede.dynadapt.dsl.aspect.Aspect
   * @generated
   */
  EClass getAspect();

  /**
   * Returns the meta object for the attribute '{@link eu.supersede.dynadapt.dsl.aspect.Aspect#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see eu.supersede.dynadapt.dsl.aspect.Aspect#getName()
   * @see #getAspect()
   * @generated
   */
  EAttribute getAspect_Name();

  /**
   * Returns the meta object for the reference '{@link eu.supersede.dynadapt.dsl.aspect.Aspect#getFeature <em>Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Feature</em>'.
   * @see eu.supersede.dynadapt.dsl.aspect.Aspect#getFeature()
   * @see #getAspect()
   * @generated
   */
  EReference getAspect_Feature();

  /**
   * Returns the meta object for the reference '{@link eu.supersede.dynadapt.dsl.aspect.Aspect#getAdvice <em>Advice</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Advice</em>'.
   * @see eu.supersede.dynadapt.dsl.aspect.Aspect#getAdvice()
   * @see #getAspect()
   * @generated
   */
  EReference getAspect_Advice();

  /**
   * Returns the meta object for the containment reference list '{@link eu.supersede.dynadapt.dsl.aspect.Aspect#getPointcuts <em>Pointcuts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Pointcuts</em>'.
   * @see eu.supersede.dynadapt.dsl.aspect.Aspect#getPointcuts()
   * @see #getAspect()
   * @generated
   */
  EReference getAspect_Pointcuts();

  /**
   * Returns the meta object for the containment reference list '{@link eu.supersede.dynadapt.dsl.aspect.Aspect#getCompositions <em>Compositions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Compositions</em>'.
   * @see eu.supersede.dynadapt.dsl.aspect.Aspect#getCompositions()
   * @see #getAspect()
   * @generated
   */
  EReference getAspect_Compositions();

  /**
   * Returns the meta object for class '{@link eu.supersede.dynadapt.dsl.aspect.Pointcut <em>Pointcut</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Pointcut</em>'.
   * @see eu.supersede.dynadapt.dsl.aspect.Pointcut
   * @generated
   */
  EClass getPointcut();

  /**
   * Returns the meta object for the attribute '{@link eu.supersede.dynadapt.dsl.aspect.Pointcut#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see eu.supersede.dynadapt.dsl.aspect.Pointcut#getName()
   * @see #getPointcut()
   * @generated
   */
  EAttribute getPointcut_Name();

  /**
   * Returns the meta object for the reference '{@link eu.supersede.dynadapt.dsl.aspect.Pointcut#getPattern <em>Pattern</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Pattern</em>'.
   * @see eu.supersede.dynadapt.dsl.aspect.Pointcut#getPattern()
   * @see #getPointcut()
   * @generated
   */
  EReference getPointcut_Pattern();

  /**
   * Returns the meta object for the reference '{@link eu.supersede.dynadapt.dsl.aspect.Pointcut#getRole <em>Role</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Role</em>'.
   * @see eu.supersede.dynadapt.dsl.aspect.Pointcut#getRole()
   * @see #getPointcut()
   * @generated
   */
  EReference getPointcut_Role();

  /**
   * Returns the meta object for class '{@link eu.supersede.dynadapt.dsl.aspect.Composition <em>Composition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Composition</em>'.
   * @see eu.supersede.dynadapt.dsl.aspect.Composition
   * @generated
   */
  EClass getComposition();

  /**
   * Returns the meta object for the attribute '{@link eu.supersede.dynadapt.dsl.aspect.Composition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see eu.supersede.dynadapt.dsl.aspect.Composition#getName()
   * @see #getComposition()
   * @generated
   */
  EAttribute getComposition_Name();

  /**
   * Returns the meta object for the attribute '{@link eu.supersede.dynadapt.dsl.aspect.Composition#getFeature_enabled <em>Feature enabled</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Feature enabled</em>'.
   * @see eu.supersede.dynadapt.dsl.aspect.Composition#getFeature_enabled()
   * @see #getComposition()
   * @generated
   */
  EAttribute getComposition_Feature_enabled();

  /**
   * Returns the meta object for the reference '{@link eu.supersede.dynadapt.dsl.aspect.Composition#getJointpointRole <em>Jointpoint Role</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Jointpoint Role</em>'.
   * @see eu.supersede.dynadapt.dsl.aspect.Composition#getJointpointRole()
   * @see #getComposition()
   * @generated
   */
  EReference getComposition_JointpointRole();

  /**
   * Returns the meta object for the reference '{@link eu.supersede.dynadapt.dsl.aspect.Composition#getAdvice <em>Advice</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Advice</em>'.
   * @see eu.supersede.dynadapt.dsl.aspect.Composition#getAdvice()
   * @see #getComposition()
   * @generated
   */
  EReference getComposition_Advice();

  /**
   * Returns the meta object for the containment reference '{@link eu.supersede.dynadapt.dsl.aspect.Composition#getAction <em>Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Action</em>'.
   * @see eu.supersede.dynadapt.dsl.aspect.Composition#getAction()
   * @see #getComposition()
   * @generated
   */
  EReference getComposition_Action();

  /**
   * Returns the meta object for class '{@link eu.supersede.dynadapt.dsl.aspect.ActionOptionType <em>Action Option Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Action Option Type</em>'.
   * @see eu.supersede.dynadapt.dsl.aspect.ActionOptionType
   * @generated
   */
  EClass getActionOptionType();

  /**
   * Returns the meta object for class '{@link eu.supersede.dynadapt.dsl.aspect.UpdateValue <em>Update Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Update Value</em>'.
   * @see eu.supersede.dynadapt.dsl.aspect.UpdateValue
   * @generated
   */
  EClass getUpdateValue();

  /**
   * Returns the meta object for the attribute '{@link eu.supersede.dynadapt.dsl.aspect.UpdateValue#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see eu.supersede.dynadapt.dsl.aspect.UpdateValue#getValue()
   * @see #getUpdateValue()
   * @generated
   */
  EAttribute getUpdateValue_Value();

  /**
   * Returns the meta object for class '{@link eu.supersede.dynadapt.dsl.aspect.Action <em>Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Action</em>'.
   * @see eu.supersede.dynadapt.dsl.aspect.Action
   * @generated
   */
  EClass getAction();

  /**
   * Returns the meta object for the attribute '{@link eu.supersede.dynadapt.dsl.aspect.Action#getADD <em>ADD</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>ADD</em>'.
   * @see eu.supersede.dynadapt.dsl.aspect.Action#getADD()
   * @see #getAction()
   * @generated
   */
  EAttribute getAction_ADD();

  /**
   * Returns the meta object for the attribute '{@link eu.supersede.dynadapt.dsl.aspect.Action#getDELETE <em>DELETE</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>DELETE</em>'.
   * @see eu.supersede.dynadapt.dsl.aspect.Action#getDELETE()
   * @see #getAction()
   * @generated
   */
  EAttribute getAction_DELETE();

  /**
   * Returns the meta object for the attribute '{@link eu.supersede.dynadapt.dsl.aspect.Action#getREPLACE <em>REPLACE</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>REPLACE</em>'.
   * @see eu.supersede.dynadapt.dsl.aspect.Action#getREPLACE()
   * @see #getAction()
   * @generated
   */
  EAttribute getAction_REPLACE();

  /**
   * Returns the meta object for the attribute '{@link eu.supersede.dynadapt.dsl.aspect.Action#getUPDATE <em>UPDATE</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>UPDATE</em>'.
   * @see eu.supersede.dynadapt.dsl.aspect.Action#getUPDATE()
   * @see #getAction()
   * @generated
   */
  EAttribute getAction_UPDATE();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  AspectFactory getAspectFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link eu.supersede.dynadapt.dsl.aspect.impl.AspectImpl <em>Aspect</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.supersede.dynadapt.dsl.aspect.impl.AspectImpl
     * @see eu.supersede.dynadapt.dsl.aspect.impl.AspectPackageImpl#getAspect()
     * @generated
     */
    EClass ASPECT = eINSTANCE.getAspect();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASPECT__NAME = eINSTANCE.getAspect_Name();

    /**
     * The meta object literal for the '<em><b>Feature</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASPECT__FEATURE = eINSTANCE.getAspect_Feature();

    /**
     * The meta object literal for the '<em><b>Advice</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASPECT__ADVICE = eINSTANCE.getAspect_Advice();

    /**
     * The meta object literal for the '<em><b>Pointcuts</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASPECT__POINTCUTS = eINSTANCE.getAspect_Pointcuts();

    /**
     * The meta object literal for the '<em><b>Compositions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASPECT__COMPOSITIONS = eINSTANCE.getAspect_Compositions();

    /**
     * The meta object literal for the '{@link eu.supersede.dynadapt.dsl.aspect.impl.PointcutImpl <em>Pointcut</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.supersede.dynadapt.dsl.aspect.impl.PointcutImpl
     * @see eu.supersede.dynadapt.dsl.aspect.impl.AspectPackageImpl#getPointcut()
     * @generated
     */
    EClass POINTCUT = eINSTANCE.getPointcut();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute POINTCUT__NAME = eINSTANCE.getPointcut_Name();

    /**
     * The meta object literal for the '<em><b>Pattern</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference POINTCUT__PATTERN = eINSTANCE.getPointcut_Pattern();

    /**
     * The meta object literal for the '<em><b>Role</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference POINTCUT__ROLE = eINSTANCE.getPointcut_Role();

    /**
     * The meta object literal for the '{@link eu.supersede.dynadapt.dsl.aspect.impl.CompositionImpl <em>Composition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.supersede.dynadapt.dsl.aspect.impl.CompositionImpl
     * @see eu.supersede.dynadapt.dsl.aspect.impl.AspectPackageImpl#getComposition()
     * @generated
     */
    EClass COMPOSITION = eINSTANCE.getComposition();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COMPOSITION__NAME = eINSTANCE.getComposition_Name();

    /**
     * The meta object literal for the '<em><b>Feature enabled</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COMPOSITION__FEATURE_ENABLED = eINSTANCE.getComposition_Feature_enabled();

    /**
     * The meta object literal for the '<em><b>Jointpoint Role</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPOSITION__JOINTPOINT_ROLE = eINSTANCE.getComposition_JointpointRole();

    /**
     * The meta object literal for the '<em><b>Advice</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPOSITION__ADVICE = eINSTANCE.getComposition_Advice();

    /**
     * The meta object literal for the '<em><b>Action</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPOSITION__ACTION = eINSTANCE.getComposition_Action();

    /**
     * The meta object literal for the '{@link eu.supersede.dynadapt.dsl.aspect.impl.ActionOptionTypeImpl <em>Action Option Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.supersede.dynadapt.dsl.aspect.impl.ActionOptionTypeImpl
     * @see eu.supersede.dynadapt.dsl.aspect.impl.AspectPackageImpl#getActionOptionType()
     * @generated
     */
    EClass ACTION_OPTION_TYPE = eINSTANCE.getActionOptionType();

    /**
     * The meta object literal for the '{@link eu.supersede.dynadapt.dsl.aspect.impl.UpdateValueImpl <em>Update Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.supersede.dynadapt.dsl.aspect.impl.UpdateValueImpl
     * @see eu.supersede.dynadapt.dsl.aspect.impl.AspectPackageImpl#getUpdateValue()
     * @generated
     */
    EClass UPDATE_VALUE = eINSTANCE.getUpdateValue();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UPDATE_VALUE__VALUE = eINSTANCE.getUpdateValue_Value();

    /**
     * The meta object literal for the '{@link eu.supersede.dynadapt.dsl.aspect.impl.ActionImpl <em>Action</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.supersede.dynadapt.dsl.aspect.impl.ActionImpl
     * @see eu.supersede.dynadapt.dsl.aspect.impl.AspectPackageImpl#getAction()
     * @generated
     */
    EClass ACTION = eINSTANCE.getAction();

    /**
     * The meta object literal for the '<em><b>ADD</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ACTION__ADD = eINSTANCE.getAction_ADD();

    /**
     * The meta object literal for the '<em><b>DELETE</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ACTION__DELETE = eINSTANCE.getAction_DELETE();

    /**
     * The meta object literal for the '<em><b>REPLACE</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ACTION__REPLACE = eINSTANCE.getAction_REPLACE();

    /**
     * The meta object literal for the '<em><b>UPDATE</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ACTION__UPDATE = eINSTANCE.getAction_UPDATE();

  }

} //AspectPackage
