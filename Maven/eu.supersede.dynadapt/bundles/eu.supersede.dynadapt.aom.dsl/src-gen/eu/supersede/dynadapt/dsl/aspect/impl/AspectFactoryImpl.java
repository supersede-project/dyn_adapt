/**
 */
package eu.supersede.dynadapt.dsl.aspect.impl;

import eu.supersede.dynadapt.dsl.aspect.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AspectFactoryImpl extends EFactoryImpl implements AspectFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static AspectFactory init()
  {
    try
    {
      AspectFactory theAspectFactory = (AspectFactory)EPackage.Registry.INSTANCE.getEFactory(AspectPackage.eNS_URI);
      if (theAspectFactory != null)
      {
        return theAspectFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new AspectFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AspectFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case AspectPackage.ASPECT: return createAspect();
      case AspectPackage.POINTCUT: return createPointcut();
      case AspectPackage.COMPOSITION: return createComposition();
      case AspectPackage.ACTION_OPTION_TYPE: return createActionOptionType();
      case AspectPackage.UPDATE_VALUE: return createUpdateValue();
      case AspectPackage.ACTION: return createAction();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Aspect createAspect()
  {
    AspectImpl aspect = new AspectImpl();
    return aspect;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Pointcut createPointcut()
  {
    PointcutImpl pointcut = new PointcutImpl();
    return pointcut;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Composition createComposition()
  {
    CompositionImpl composition = new CompositionImpl();
    return composition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActionOptionType createActionOptionType()
  {
    ActionOptionTypeImpl actionOptionType = new ActionOptionTypeImpl();
    return actionOptionType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UpdateValue createUpdateValue()
  {
    UpdateValueImpl updateValue = new UpdateValueImpl();
    return updateValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Action createAction()
  {
    ActionImpl action = new ActionImpl();
    return action;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AspectPackage getAspectPackage()
  {
    return (AspectPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static AspectPackage getPackage()
  {
    return AspectPackage.eINSTANCE;
  }

} //AspectFactoryImpl
