/**
 */
package cz.zcu.yafmt.ui.editors.fm.layout.impl;

import cz.zcu.yafmt.ui.editors.fm.layout.*;

import java.util.Map;
import java.util.Scanner;

import org.eclipse.draw2d.geometry.Rectangle;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
public class LayoutDataFactoryImpl extends EFactoryImpl implements LayoutDataFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static LayoutDataFactory init() {
        try {
            LayoutDataFactory theLayoutDataFactory = (LayoutDataFactory)EPackage.Registry.INSTANCE.getEFactory("http://zcu.cz/yafmt/ui/editors/fm/layout"); 
            if (theLayoutDataFactory != null) {
                return theLayoutDataFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new LayoutDataFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public LayoutDataFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case LayoutDataPackage.LAYOUT_DATA: return createLayoutData();
            case LayoutDataPackage.EOBJECT_TO_RECTANGLE: return (EObject)createEObjectToRectangle();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object createFromString(EDataType eDataType, String initialValue) {
        switch (eDataType.getClassifierID()) {
            case LayoutDataPackage.RECTANGLE:
                return createRectangleFromString(eDataType, initialValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String convertToString(EDataType eDataType, Object instanceValue) {
        switch (eDataType.getClassifierID()) {
            case LayoutDataPackage.RECTANGLE:
                return convertRectangleToString(eDataType, instanceValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public LayoutData createLayoutData() {
        LayoutDataImpl layoutData = new LayoutDataImpl();
        return layoutData;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Map.Entry<EObject, Rectangle> createEObjectToRectangle() {
        EObjectToRectangleImpl eObjectToRectangle = new EObjectToRectangleImpl();
        return eObjectToRectangle;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public Rectangle createRectangleFromString(EDataType eDataType, String initialValue) {
        Rectangle bounds = new Rectangle();
        Scanner scanner = new Scanner(initialValue);
        
        try {
            bounds.x = scanner.nextInt();
            bounds.y = scanner.nextInt();
            bounds.width = scanner.nextInt();
            bounds.height = scanner.nextInt();
        }
        finally {
            scanner.close();
        }
        
        return bounds;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public String convertRectangleToString(EDataType eDataType, Object instanceValue) {
        Rectangle bounds = (Rectangle) instanceValue;
        return bounds.x + " " + bounds.y + " " + bounds.width + " " + bounds.height;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public LayoutDataPackage getLayoutDataPackage() {
        return (LayoutDataPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static LayoutDataPackage getPackage() {
        return LayoutDataPackage.eINSTANCE;
    }

} //LayoutDataFactoryImpl
