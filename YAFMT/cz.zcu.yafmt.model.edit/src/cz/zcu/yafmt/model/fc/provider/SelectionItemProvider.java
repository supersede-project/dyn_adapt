/**
 */
package cz.zcu.yafmt.model.fc.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import cz.zcu.yafmt.model.fc.FeatureConfigurationFactory;
import cz.zcu.yafmt.model.fc.FeatureConfigurationPackage;
import cz.zcu.yafmt.model.fc.Selection;
import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.provider.FeatureModelEditPlugin;

/**
 * This is the item provider adapter for a {@link cz.zcu.yafmt.model.fc.Selection} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SelectionItemProvider
    extends ItemProviderAdapter
    implements
        IEditingDomainItemProvider,
        IStructuredItemContentProvider,
        ITreeItemContentProvider,
        IItemLabelProvider,
        IItemPropertySource {
    /**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public SelectionItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

    /**
     * This returns the property descriptors for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
        if (itemPropertyDescriptors == null) {
            super.getPropertyDescriptors(object);

            addIdPropertyDescriptor(object);
            addNamePropertyDescriptor(object);
            
            String description = ((Selection) object).getDescription();
            if((description != null) && !description.isEmpty())
                addDescriptionPropertyDescriptor(object);
            
            String comment = ((Selection) object).getComment();
            if((comment != null) && !comment.isEmpty())
                addCommentPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
	 * This adds a property descriptor for the Id feature.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected void addIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Selection_id_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Selection_id_feature", "_UI_Selection_type"),
				 FeatureConfigurationPackage.Literals.SELECTION__ID,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

    /**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Selection_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Selection_name_feature", "_UI_Selection_type"),
				 FeatureConfigurationPackage.Literals.SELECTION__NAME,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

    /**
	 * This adds a property descriptor for the Description feature.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected void addDescriptionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Selection_description_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Selection_description_feature", "_UI_Selection_type"),
				 FeatureConfigurationPackage.Literals.SELECTION__DESCRIPTION,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

    /**
	 * This adds a property descriptor for the Comment feature.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected void addCommentPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Selection_comment_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Selection_comment_feature", "_UI_Selection_type"),
				 FeatureConfigurationPackage.Literals.SELECTION__COMMENT,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

    /**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(FeatureConfigurationPackage.Literals.SELECTION__VALUES);
			childrenFeatures.add(FeatureConfigurationPackage.Literals.SELECTION__SELECTIONS);
		}
		return childrenFeatures;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

    /**
     * This returns Selection.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public Object getImage(Object object) {
        Feature feature = ((Selection) object).getFeature();
        if(feature == null)
            return overlayImage(object, getResourceLocator().getImage("full/obj16/Selection"));
        
        if(feature.isRoot())
            return getResourceLocator().getImage("feature-root.png");
        else if(feature.isMandatory())
            return getResourceLocator().getImage("feature-man.png");
        else if(feature.isOptional())
            return getResourceLocator().getImage("feature-opt.png");
        else
            return getResourceLocator().getImage("feature.png");
    }

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public String getText(Object object) {
        String name = ((Selection) object).getName();
        return (name != null) ? name : "???"; 
    }

    /**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Selection.class)) {
			case FeatureConfigurationPackage.SELECTION__ID:
			case FeatureConfigurationPackage.SELECTION__NAME:
			case FeatureConfigurationPackage.SELECTION__DESCRIPTION:
			case FeatureConfigurationPackage.SELECTION__COMMENT:
			case FeatureConfigurationPackage.SELECTION__ROOT:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case FeatureConfigurationPackage.SELECTION__VALUES:
			case FeatureConfigurationPackage.SELECTION__SELECTIONS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

    /**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(FeatureConfigurationPackage.Literals.SELECTION__VALUES,
				 FeatureConfigurationFactory.eINSTANCE.createBooleanValue()));

		newChildDescriptors.add
			(createChildParameter
				(FeatureConfigurationPackage.Literals.SELECTION__VALUES,
				 FeatureConfigurationFactory.eINSTANCE.createIntegerValue()));

		newChildDescriptors.add
			(createChildParameter
				(FeatureConfigurationPackage.Literals.SELECTION__VALUES,
				 FeatureConfigurationFactory.eINSTANCE.createDoubleValue()));

		newChildDescriptors.add
			(createChildParameter
				(FeatureConfigurationPackage.Literals.SELECTION__VALUES,
				 FeatureConfigurationFactory.eINSTANCE.createStringValue()));

		newChildDescriptors.add
			(createChildParameter
				(FeatureConfigurationPackage.Literals.SELECTION__SELECTIONS,
				 FeatureConfigurationFactory.eINSTANCE.createSelection()));
	}

    /**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public ResourceLocator getResourceLocator() {
		return cz.zcu.yafmt.model.fc.provider.FeatureModelEditPlugin.INSTANCE;
	}

}
