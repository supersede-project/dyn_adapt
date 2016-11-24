/**
 */
package cz.zcu.yafmt.clang.bcl.model.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cz.zcu.yafmt.clang.bcl.model.Expression;
import cz.zcu.yafmt.clang.bcl.model.ForAllContextualExpression;
import cz.zcu.yafmt.clang.bcl.model.ModelPackage;
import cz.zcu.yafmt.model.fc.FeatureConfiguration;
import cz.zcu.yafmt.model.fc.Selection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>For All Contextual Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cz.zcu.yafmt.clang.bcl.model.impl.ForAllContextualExpressionImpl#getContextId <em>Context Id</em>}</li>
 *   <li>{@link cz.zcu.yafmt.clang.bcl.model.impl.ForAllContextualExpressionImpl#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ForAllContextualExpressionImpl extends ExpressionImpl implements ForAllContextualExpression {
    /**
     * The default value of the '{@link #getContextId() <em>Context Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getContextId()
     * @generated
     * @ordered
     */
    protected static final String CONTEXT_ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getContextId() <em>Context Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getContextId()
     * @generated
     * @ordered
     */
    protected String contextId = CONTEXT_ID_EDEFAULT;

    /**
     * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExpression()
     * @generated
     * @ordered
     */
    protected Expression expression;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ForAllContextualExpressionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ModelPackage.Literals.FOR_ALL_CONTEXTUAL_EXPRESSION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getContextId() {
        return contextId;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setContextId(String newContextId) {
        String oldContextId = contextId;
        contextId = newContextId;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.FOR_ALL_CONTEXTUAL_EXPRESSION__CONTEXT_ID, oldContextId, contextId));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Expression getExpression() {
        return expression;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetExpression(Expression newExpression, NotificationChain msgs) {
        Expression oldExpression = expression;
        expression = newExpression;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.FOR_ALL_CONTEXTUAL_EXPRESSION__EXPRESSION, oldExpression, newExpression);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setExpression(Expression newExpression) {
        if (newExpression != expression) {
            NotificationChain msgs = null;
            if (expression != null)
                msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.FOR_ALL_CONTEXTUAL_EXPRESSION__EXPRESSION, null, msgs);
            if (newExpression != null)
                msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.FOR_ALL_CONTEXTUAL_EXPRESSION__EXPRESSION, null, msgs);
            msgs = basicSetExpression(newExpression, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.FOR_ALL_CONTEXTUAL_EXPRESSION__EXPRESSION, newExpression, newExpression));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ModelPackage.FOR_ALL_CONTEXTUAL_EXPRESSION__EXPRESSION:
                return basicSetExpression(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ModelPackage.FOR_ALL_CONTEXTUAL_EXPRESSION__CONTEXT_ID:
                return getContextId();
            case ModelPackage.FOR_ALL_CONTEXTUAL_EXPRESSION__EXPRESSION:
                return getExpression();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case ModelPackage.FOR_ALL_CONTEXTUAL_EXPRESSION__CONTEXT_ID:
                setContextId((String)newValue);
                return;
            case ModelPackage.FOR_ALL_CONTEXTUAL_EXPRESSION__EXPRESSION:
                setExpression((Expression)newValue);
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
    public void eUnset(int featureID) {
        switch (featureID) {
            case ModelPackage.FOR_ALL_CONTEXTUAL_EXPRESSION__CONTEXT_ID:
                setContextId(CONTEXT_ID_EDEFAULT);
                return;
            case ModelPackage.FOR_ALL_CONTEXTUAL_EXPRESSION__EXPRESSION:
                setExpression((Expression)null);
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
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case ModelPackage.FOR_ALL_CONTEXTUAL_EXPRESSION__CONTEXT_ID:
                return CONTEXT_ID_EDEFAULT == null ? contextId != null : !CONTEXT_ID_EDEFAULT.equals(contextId);
            case ModelPackage.FOR_ALL_CONTEXTUAL_EXPRESSION__EXPRESSION:
                return expression != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (contextId: ");
        result.append(contextId);
        result.append(')');
        return result.toString();
    }
    
    @Override
    public void retrieveFeatureIds(Set<String> ids) {
        ids.add(contextId);
        expression.retrieveFeatureIds(ids);
    }
    
    @Override
    public boolean evaluate(FeatureConfiguration featureConfig, Selection context, Set<Selection> problemSelections, boolean expectedValue) {
        Set<Selection> internalProblemSelections = new HashSet<Selection>();
        List<Selection> lowerContexts = getSelections(featureConfig, context, contextId);
     
        // We have to evaluate every context to gather all problem elements.
        boolean value = true;
        for(Selection lowerContext: lowerContexts)
            value &= expression.evaluate(featureConfig, lowerContext, internalProblemSelections, expectedValue);
        
        if(value != expectedValue)
            problemSelections.addAll(internalProblemSelections);
        
        return value;
    }

} //ForAllContextualExpressionImpl
