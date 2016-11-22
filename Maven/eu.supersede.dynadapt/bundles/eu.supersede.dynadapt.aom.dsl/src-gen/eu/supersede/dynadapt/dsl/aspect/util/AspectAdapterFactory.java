/**
 */
package eu.supersede.dynadapt.dsl.aspect.util;

import eu.supersede.dynadapt.dsl.aspect.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see eu.supersede.dynadapt.dsl.aspect.AspectPackage
 * @generated
 */
public class AspectAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static AspectPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AspectAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = AspectPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AspectSwitch<Adapter> modelSwitch =
    new AspectSwitch<Adapter>()
    {
      @Override
      public Adapter caseAspect(Aspect object)
      {
        return createAspectAdapter();
      }
      @Override
      public Adapter casePointcut(Pointcut object)
      {
        return createPointcutAdapter();
      }
      @Override
      public Adapter caseComposition(Composition object)
      {
        return createCompositionAdapter();
      }
      @Override
      public Adapter caseActionOptionType(ActionOptionType object)
      {
        return createActionOptionTypeAdapter();
      }
      @Override
      public Adapter caseUpdateValue(UpdateValue object)
      {
        return createUpdateValueAdapter();
      }
      @Override
      public Adapter caseAction(Action object)
      {
        return createActionAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link eu.supersede.dynadapt.dsl.aspect.Aspect <em>Aspect</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.supersede.dynadapt.dsl.aspect.Aspect
   * @generated
   */
  public Adapter createAspectAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.supersede.dynadapt.dsl.aspect.Pointcut <em>Pointcut</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.supersede.dynadapt.dsl.aspect.Pointcut
   * @generated
   */
  public Adapter createPointcutAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.supersede.dynadapt.dsl.aspect.Composition <em>Composition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.supersede.dynadapt.dsl.aspect.Composition
   * @generated
   */
  public Adapter createCompositionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.supersede.dynadapt.dsl.aspect.ActionOptionType <em>Action Option Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.supersede.dynadapt.dsl.aspect.ActionOptionType
   * @generated
   */
  public Adapter createActionOptionTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.supersede.dynadapt.dsl.aspect.UpdateValue <em>Update Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.supersede.dynadapt.dsl.aspect.UpdateValue
   * @generated
   */
  public Adapter createUpdateValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.supersede.dynadapt.dsl.aspect.Action <em>Action</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.supersede.dynadapt.dsl.aspect.Action
   * @generated
   */
  public Adapter createActionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //AspectAdapterFactory
