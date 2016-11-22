/**
 */
package cz.zcu.yafmt.model.fm.util;

import cz.zcu.yafmt.model.fm.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see cz.zcu.yafmt.model.fm.FeatureModelPackage
 * @generated
 */
public class FeatureModelAdapterFactory extends AdapterFactoryImpl {
    /**
	 * The cached model package.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected static FeatureModelPackage modelPackage;

    /**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public FeatureModelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = FeatureModelPackage.eINSTANCE;
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
    public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
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
    protected FeatureModelSwitch<Adapter> modelSwitch =
        new FeatureModelSwitch<Adapter>() {
			@Override
			public Adapter caseFeatureModel(FeatureModel object) {
				return createFeatureModelAdapter();
			}
			@Override
			public Adapter caseFeature(Feature object) {
				return createFeatureAdapter();
			}
			@Override
			public Adapter caseGroup(Group object) {
				return createGroupAdapter();
			}
			@Override
			public Adapter caseAttribute(Attribute object) {
				return createAttributeAdapter();
			}
			@Override
			public Adapter caseConstraint(Constraint object) {
				return createConstraintAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated NOT
     */
    @Override
    public Adapter createAdapter(Notifier target) {
        // EMF Edit sometimes try to pass XMIResourceImpl as the target for some strange reason.
        if(target instanceof EObject)
            return modelSwitch.doSwitch((EObject)target);
        return null;
    }


    /**
	 * Creates a new adapter for an object of class '{@link cz.zcu.yafmt.model.fm.FeatureModel <em>Feature Model</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cz.zcu.yafmt.model.fm.FeatureModel
	 * @generated
	 */
    public Adapter createFeatureModelAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link cz.zcu.yafmt.model.fm.Feature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cz.zcu.yafmt.model.fm.Feature
	 * @generated
	 */
    public Adapter createFeatureAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link cz.zcu.yafmt.model.fm.Group <em>Group</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cz.zcu.yafmt.model.fm.Group
	 * @generated
	 */
    public Adapter createGroupAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link cz.zcu.yafmt.model.fm.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cz.zcu.yafmt.model.fm.Attribute
	 * @generated
	 */
    public Adapter createAttributeAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link cz.zcu.yafmt.model.fm.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cz.zcu.yafmt.model.fm.Constraint
	 * @generated
	 */
    public Adapter createConstraintAdapter() {
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
    public Adapter createEObjectAdapter() {
		return null;
	}

} //FeatureModelAdapterFactory
