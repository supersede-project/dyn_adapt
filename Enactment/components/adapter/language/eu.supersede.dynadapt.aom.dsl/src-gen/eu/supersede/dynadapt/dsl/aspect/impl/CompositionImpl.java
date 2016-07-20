/**
 */
package eu.supersede.dynadapt.dsl.aspect.impl;

import eu.supersede.dynadapt.dsl.aspect.AspectPackage;
import eu.supersede.dynadapt.dsl.aspect.Composition;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.uml2.uml.Stereotype;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.supersede.dynadapt.dsl.aspect.impl.CompositionImpl#getName <em>Name</em>}</li>
 *   <li>{@link eu.supersede.dynadapt.dsl.aspect.impl.CompositionImpl#getFeature_enabled <em>Feature enabled</em>}</li>
 *   <li>{@link eu.supersede.dynadapt.dsl.aspect.impl.CompositionImpl#getJointpointRole <em>Jointpoint Role</em>}</li>
 *   <li>{@link eu.supersede.dynadapt.dsl.aspect.impl.CompositionImpl#getAdvice <em>Advice</em>}</li>
 *   <li>{@link eu.supersede.dynadapt.dsl.aspect.impl.CompositionImpl#getAction <em>Action</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CompositionImpl extends MinimalEObjectImpl.Container implements Composition
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
   * The default value of the '{@link #getFeature_enabled() <em>Feature enabled</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFeature_enabled()
   * @generated
   * @ordered
   */
  protected static final Boolean FEATURE_ENABLED_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFeature_enabled() <em>Feature enabled</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFeature_enabled()
   * @generated
   * @ordered
   */
  protected Boolean feature_enabled = FEATURE_ENABLED_EDEFAULT;

  /**
   * The cached value of the '{@link #getJointpointRole() <em>Jointpoint Role</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getJointpointRole()
   * @generated
   * @ordered
   */
  protected Stereotype jointpointRole;

  /**
   * The cached value of the '{@link #getAdvice() <em>Advice</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAdvice()
   * @generated
   * @ordered
   */
  protected Stereotype advice;

  /**
   * The default value of the '{@link #getAction() <em>Action</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAction()
   * @generated
   * @ordered
   */
  protected static final String ACTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getAction() <em>Action</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAction()
   * @generated
   * @ordered
   */
  protected String action = ACTION_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CompositionImpl()
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
    return AspectPackage.Literals.COMPOSITION;
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
      eNotify(new ENotificationImpl(this, Notification.SET, AspectPackage.COMPOSITION__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Boolean getFeature_enabled()
  {
    return feature_enabled;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFeature_enabled(Boolean newFeature_enabled)
  {
    Boolean oldFeature_enabled = feature_enabled;
    feature_enabled = newFeature_enabled;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AspectPackage.COMPOSITION__FEATURE_ENABLED, oldFeature_enabled, feature_enabled));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Stereotype getJointpointRole()
  {
    if (jointpointRole != null && jointpointRole.eIsProxy())
    {
      InternalEObject oldJointpointRole = (InternalEObject)jointpointRole;
      jointpointRole = (Stereotype)eResolveProxy(oldJointpointRole);
      if (jointpointRole != oldJointpointRole)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AspectPackage.COMPOSITION__JOINTPOINT_ROLE, oldJointpointRole, jointpointRole));
      }
    }
    return jointpointRole;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Stereotype basicGetJointpointRole()
  {
    return jointpointRole;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setJointpointRole(Stereotype newJointpointRole)
  {
    Stereotype oldJointpointRole = jointpointRole;
    jointpointRole = newJointpointRole;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AspectPackage.COMPOSITION__JOINTPOINT_ROLE, oldJointpointRole, jointpointRole));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Stereotype getAdvice()
  {
    if (advice != null && advice.eIsProxy())
    {
      InternalEObject oldAdvice = (InternalEObject)advice;
      advice = (Stereotype)eResolveProxy(oldAdvice);
      if (advice != oldAdvice)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AspectPackage.COMPOSITION__ADVICE, oldAdvice, advice));
      }
    }
    return advice;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Stereotype basicGetAdvice()
  {
    return advice;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAdvice(Stereotype newAdvice)
  {
    Stereotype oldAdvice = advice;
    advice = newAdvice;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AspectPackage.COMPOSITION__ADVICE, oldAdvice, advice));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getAction()
  {
    return action;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAction(String newAction)
  {
    String oldAction = action;
    action = newAction;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AspectPackage.COMPOSITION__ACTION, oldAction, action));
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
      case AspectPackage.COMPOSITION__NAME:
        return getName();
      case AspectPackage.COMPOSITION__FEATURE_ENABLED:
        return getFeature_enabled();
      case AspectPackage.COMPOSITION__JOINTPOINT_ROLE:
        if (resolve) return getJointpointRole();
        return basicGetJointpointRole();
      case AspectPackage.COMPOSITION__ADVICE:
        if (resolve) return getAdvice();
        return basicGetAdvice();
      case AspectPackage.COMPOSITION__ACTION:
        return getAction();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case AspectPackage.COMPOSITION__NAME:
        setName((String)newValue);
        return;
      case AspectPackage.COMPOSITION__FEATURE_ENABLED:
        setFeature_enabled((Boolean)newValue);
        return;
      case AspectPackage.COMPOSITION__JOINTPOINT_ROLE:
        setJointpointRole((Stereotype)newValue);
        return;
      case AspectPackage.COMPOSITION__ADVICE:
        setAdvice((Stereotype)newValue);
        return;
      case AspectPackage.COMPOSITION__ACTION:
        setAction((String)newValue);
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
      case AspectPackage.COMPOSITION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case AspectPackage.COMPOSITION__FEATURE_ENABLED:
        setFeature_enabled(FEATURE_ENABLED_EDEFAULT);
        return;
      case AspectPackage.COMPOSITION__JOINTPOINT_ROLE:
        setJointpointRole((Stereotype)null);
        return;
      case AspectPackage.COMPOSITION__ADVICE:
        setAdvice((Stereotype)null);
        return;
      case AspectPackage.COMPOSITION__ACTION:
        setAction(ACTION_EDEFAULT);
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
      case AspectPackage.COMPOSITION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case AspectPackage.COMPOSITION__FEATURE_ENABLED:
        return FEATURE_ENABLED_EDEFAULT == null ? feature_enabled != null : !FEATURE_ENABLED_EDEFAULT.equals(feature_enabled);
      case AspectPackage.COMPOSITION__JOINTPOINT_ROLE:
        return jointpointRole != null;
      case AspectPackage.COMPOSITION__ADVICE:
        return advice != null;
      case AspectPackage.COMPOSITION__ACTION:
        return ACTION_EDEFAULT == null ? action != null : !ACTION_EDEFAULT.equals(action);
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
    result.append(", feature_enabled: ");
    result.append(feature_enabled);
    result.append(", action: ");
    result.append(action);
    result.append(')');
    return result.toString();
  }

} //CompositionImpl
