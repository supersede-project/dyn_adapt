/**
 */
package eu.supersede.dynadapt.dsl.aspect.impl;

import cz.zcu.yafmt.model.fm.Feature;

import eu.supersede.dynadapt.dsl.aspect.Aspect;
import eu.supersede.dynadapt.dsl.aspect.AspectPackage;
import eu.supersede.dynadapt.dsl.aspect.Composition;
import eu.supersede.dynadapt.dsl.aspect.Pointcut;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.uml2.uml.Model;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Aspect</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.supersede.dynadapt.dsl.aspect.impl.AspectImpl#getName <em>Name</em>}</li>
 *   <li>{@link eu.supersede.dynadapt.dsl.aspect.impl.AspectImpl#getFeature <em>Feature</em>}</li>
 *   <li>{@link eu.supersede.dynadapt.dsl.aspect.impl.AspectImpl#getAdvice <em>Advice</em>}</li>
 *   <li>{@link eu.supersede.dynadapt.dsl.aspect.impl.AspectImpl#getPointcuts <em>Pointcuts</em>}</li>
 *   <li>{@link eu.supersede.dynadapt.dsl.aspect.impl.AspectImpl#getCompositions <em>Compositions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AspectImpl extends MinimalEObjectImpl.Container implements Aspect
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getFeature() <em>Feature</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFeature()
   * @generated
   * @ordered
   */
  protected Feature feature;

  /**
   * The cached value of the '{@link #getAdvice() <em>Advice</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAdvice()
   * @generated
   * @ordered
   */
  protected Model advice;

  /**
   * The cached value of the '{@link #getPointcuts() <em>Pointcuts</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPointcuts()
   * @generated
   * @ordered
   */
  protected EList<Pointcut> pointcuts;

  /**
   * The cached value of the '{@link #getCompositions() <em>Compositions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCompositions()
   * @generated
   * @ordered
   */
  protected EList<Composition> compositions;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AspectImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return AspectPackage.Literals.ASPECT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AspectPackage.ASPECT__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Feature getFeature()
  {
    if (feature != null && feature.eIsProxy())
    {
      InternalEObject oldFeature = (InternalEObject)feature;
      feature = (Feature)eResolveProxy(oldFeature);
      if (feature != oldFeature)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AspectPackage.ASPECT__FEATURE, oldFeature, feature));
      }
    }
    return feature;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Feature basicGetFeature()
  {
    return feature;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFeature(Feature newFeature)
  {
    Feature oldFeature = feature;
    feature = newFeature;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AspectPackage.ASPECT__FEATURE, oldFeature, feature));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Model getAdvice()
  {
    if (advice != null && advice.eIsProxy())
    {
      InternalEObject oldAdvice = (InternalEObject)advice;
      advice = (Model)eResolveProxy(oldAdvice);
      if (advice != oldAdvice)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AspectPackage.ASPECT__ADVICE, oldAdvice, advice));
      }
    }
    return advice;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Model basicGetAdvice()
  {
    return advice;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAdvice(Model newAdvice)
  {
    Model oldAdvice = advice;
    advice = newAdvice;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AspectPackage.ASPECT__ADVICE, oldAdvice, advice));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Pointcut> getPointcuts()
  {
    if (pointcuts == null)
    {
      pointcuts = new EObjectContainmentEList<Pointcut>(Pointcut.class, this, AspectPackage.ASPECT__POINTCUTS);
    }
    return pointcuts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Composition> getCompositions()
  {
    if (compositions == null)
    {
      compositions = new EObjectContainmentEList<Composition>(Composition.class, this, AspectPackage.ASPECT__COMPOSITIONS);
    }
    return compositions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case AspectPackage.ASPECT__POINTCUTS:
        return ((InternalEList<?>)getPointcuts()).basicRemove(otherEnd, msgs);
      case AspectPackage.ASPECT__COMPOSITIONS:
        return ((InternalEList<?>)getCompositions()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case AspectPackage.ASPECT__NAME:
        return getName();
      case AspectPackage.ASPECT__FEATURE:
        if (resolve) return getFeature();
        return basicGetFeature();
      case AspectPackage.ASPECT__ADVICE:
        if (resolve) return getAdvice();
        return basicGetAdvice();
      case AspectPackage.ASPECT__POINTCUTS:
        return getPointcuts();
      case AspectPackage.ASPECT__COMPOSITIONS:
        return getCompositions();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case AspectPackage.ASPECT__NAME:
        setName((String)newValue);
        return;
      case AspectPackage.ASPECT__FEATURE:
        setFeature((Feature)newValue);
        return;
      case AspectPackage.ASPECT__ADVICE:
        setAdvice((Model)newValue);
        return;
      case AspectPackage.ASPECT__POINTCUTS:
        getPointcuts().clear();
        getPointcuts().addAll((Collection<? extends Pointcut>)newValue);
        return;
      case AspectPackage.ASPECT__COMPOSITIONS:
        getCompositions().clear();
        getCompositions().addAll((Collection<? extends Composition>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case AspectPackage.ASPECT__NAME:
        setName(NAME_EDEFAULT);
        return;
      case AspectPackage.ASPECT__FEATURE:
        setFeature((Feature)null);
        return;
      case AspectPackage.ASPECT__ADVICE:
        setAdvice((Model)null);
        return;
      case AspectPackage.ASPECT__POINTCUTS:
        getPointcuts().clear();
        return;
      case AspectPackage.ASPECT__COMPOSITIONS:
        getCompositions().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case AspectPackage.ASPECT__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case AspectPackage.ASPECT__FEATURE:
        return feature != null;
      case AspectPackage.ASPECT__ADVICE:
        return advice != null;
      case AspectPackage.ASPECT__POINTCUTS:
        return pointcuts != null && !pointcuts.isEmpty();
      case AspectPackage.ASPECT__COMPOSITIONS:
        return compositions != null && !compositions.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //AspectImpl
