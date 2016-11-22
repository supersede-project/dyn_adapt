/**
 */
package eu.supersede.dynadapt.dsl.aspect.impl;

import eu.supersede.dynadapt.dsl.aspect.Action;
import eu.supersede.dynadapt.dsl.aspect.AspectPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.supersede.dynadapt.dsl.aspect.impl.ActionImpl#getADD <em>ADD</em>}</li>
 *   <li>{@link eu.supersede.dynadapt.dsl.aspect.impl.ActionImpl#getDELETE <em>DELETE</em>}</li>
 *   <li>{@link eu.supersede.dynadapt.dsl.aspect.impl.ActionImpl#getREPLACE <em>REPLACE</em>}</li>
 *   <li>{@link eu.supersede.dynadapt.dsl.aspect.impl.ActionImpl#getUPDATE <em>UPDATE</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ActionImpl extends ActionOptionTypeImpl implements Action
{
  /**
   * The default value of the '{@link #getADD() <em>ADD</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getADD()
   * @generated
   * @ordered
   */
  protected static final String ADD_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getADD() <em>ADD</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getADD()
   * @generated
   * @ordered
   */
  protected String add = ADD_EDEFAULT;

  /**
   * The default value of the '{@link #getDELETE() <em>DELETE</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDELETE()
   * @generated
   * @ordered
   */
  protected static final String DELETE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDELETE() <em>DELETE</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDELETE()
   * @generated
   * @ordered
   */
  protected String delete = DELETE_EDEFAULT;

  /**
   * The default value of the '{@link #getREPLACE() <em>REPLACE</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getREPLACE()
   * @generated
   * @ordered
   */
  protected static final String REPLACE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getREPLACE() <em>REPLACE</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getREPLACE()
   * @generated
   * @ordered
   */
  protected String replace = REPLACE_EDEFAULT;

  /**
   * The default value of the '{@link #getUPDATE() <em>UPDATE</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUPDATE()
   * @generated
   * @ordered
   */
  protected static final String UPDATE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getUPDATE() <em>UPDATE</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUPDATE()
   * @generated
   * @ordered
   */
  protected String update = UPDATE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ActionImpl()
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
    return AspectPackage.Literals.ACTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getADD()
  {
    return add;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setADD(String newADD)
  {
    String oldADD = add;
    add = newADD;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AspectPackage.ACTION__ADD, oldADD, add));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDELETE()
  {
    return delete;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDELETE(String newDELETE)
  {
    String oldDELETE = delete;
    delete = newDELETE;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AspectPackage.ACTION__DELETE, oldDELETE, delete));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getREPLACE()
  {
    return replace;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setREPLACE(String newREPLACE)
  {
    String oldREPLACE = replace;
    replace = newREPLACE;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AspectPackage.ACTION__REPLACE, oldREPLACE, replace));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getUPDATE()
  {
    return update;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUPDATE(String newUPDATE)
  {
    String oldUPDATE = update;
    update = newUPDATE;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AspectPackage.ACTION__UPDATE, oldUPDATE, update));
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
      case AspectPackage.ACTION__ADD:
        return getADD();
      case AspectPackage.ACTION__DELETE:
        return getDELETE();
      case AspectPackage.ACTION__REPLACE:
        return getREPLACE();
      case AspectPackage.ACTION__UPDATE:
        return getUPDATE();
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
      case AspectPackage.ACTION__ADD:
        setADD((String)newValue);
        return;
      case AspectPackage.ACTION__DELETE:
        setDELETE((String)newValue);
        return;
      case AspectPackage.ACTION__REPLACE:
        setREPLACE((String)newValue);
        return;
      case AspectPackage.ACTION__UPDATE:
        setUPDATE((String)newValue);
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
      case AspectPackage.ACTION__ADD:
        setADD(ADD_EDEFAULT);
        return;
      case AspectPackage.ACTION__DELETE:
        setDELETE(DELETE_EDEFAULT);
        return;
      case AspectPackage.ACTION__REPLACE:
        setREPLACE(REPLACE_EDEFAULT);
        return;
      case AspectPackage.ACTION__UPDATE:
        setUPDATE(UPDATE_EDEFAULT);
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
      case AspectPackage.ACTION__ADD:
        return ADD_EDEFAULT == null ? add != null : !ADD_EDEFAULT.equals(add);
      case AspectPackage.ACTION__DELETE:
        return DELETE_EDEFAULT == null ? delete != null : !DELETE_EDEFAULT.equals(delete);
      case AspectPackage.ACTION__REPLACE:
        return REPLACE_EDEFAULT == null ? replace != null : !REPLACE_EDEFAULT.equals(replace);
      case AspectPackage.ACTION__UPDATE:
        return UPDATE_EDEFAULT == null ? update != null : !UPDATE_EDEFAULT.equals(update);
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
    result.append(" (ADD: ");
    result.append(add);
    result.append(", DELETE: ");
    result.append(delete);
    result.append(", REPLACE: ");
    result.append(replace);
    result.append(", UPDATE: ");
    result.append(update);
    result.append(')');
    return result.toString();
  }

} //ActionImpl
