/**
 */
package cz.zcu.yafmt.clang.bcl.model.impl;

import java.util.List;
import java.util.Set;

import cz.zcu.yafmt.clang.bcl.model.ModelPackage;
import cz.zcu.yafmt.clang.bcl.model.PrimaryExpression;
import cz.zcu.yafmt.model.fc.FeatureConfiguration;
import cz.zcu.yafmt.model.fc.Selection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primary Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cz.zcu.yafmt.clang.bcl.model.impl.PrimaryExpressionImpl#getFeatureId <em>Feature Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PrimaryExpressionImpl extends ExpressionImpl implements PrimaryExpression {
    /**
     * The default value of the '{@link #getFeatureId() <em>Feature Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFeatureId()
     * @generated
     * @ordered
     */
    protected static final String FEATURE_ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getFeatureId() <em>Feature Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFeatureId()
     * @generated
     * @ordered
     */
    protected String featureId = FEATURE_ID_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected PrimaryExpressionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ModelPackage.Literals.PRIMARY_EXPRESSION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getFeatureId() {
        return featureId;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setFeatureId(String newFeatureId) {
        String oldFeatureId = featureId;
        featureId = newFeatureId;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PRIMARY_EXPRESSION__FEATURE_ID, oldFeatureId, featureId));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ModelPackage.PRIMARY_EXPRESSION__FEATURE_ID:
                return getFeatureId();
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
            case ModelPackage.PRIMARY_EXPRESSION__FEATURE_ID:
                setFeatureId((String)newValue);
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
            case ModelPackage.PRIMARY_EXPRESSION__FEATURE_ID:
                setFeatureId(FEATURE_ID_EDEFAULT);
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
            case ModelPackage.PRIMARY_EXPRESSION__FEATURE_ID:
                return FEATURE_ID_EDEFAULT == null ? featureId != null : !FEATURE_ID_EDEFAULT.equals(featureId);
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
        result.append(" (featureId: ");
        result.append(featureId);
        result.append(')');
        return result.toString();
    }
    
    @Override
    public void retrieveFeatureIds(Set<String> ids) {
        ids.add(featureId);
    }
    
    @Override
    public boolean evaluate(FeatureConfiguration featureConfig, Selection context, Set<Selection> problemSelections, boolean expectedValue) {
        // Get all selected features with this ID, under the specified context.
        List<Selection> selections = getSelections(featureConfig, context, featureId);
        
        // The result value is true if there is at least one selected feature.
        boolean value = !selections.isEmpty();
        
        // Gather problem elements if we expected different result.
        if(value != expectedValue) {
            // Mark the context, because no expected feature was selected.
            if(expectedValue)
                problemSelections.add(context);
            // Mark features which should not be selected.
            else
                problemSelections.addAll(selections);
        }
        
        // The result value.
        return value;
    }


} //PrimaryExpressionImpl
