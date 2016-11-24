/**
 */
package cz.zcu.yafmt.ui.editors.fm.layout.impl;

import cz.zcu.yafmt.ui.editors.fm.layout.LayoutData;
import cz.zcu.yafmt.ui.editors.fm.layout.LayoutDataFactory;
import cz.zcu.yafmt.ui.editors.fm.layout.LayoutDataPackage;

import java.util.Map;

import org.eclipse.draw2d.geometry.Rectangle;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LayoutDataPackageImpl extends EPackageImpl implements LayoutDataPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass layoutDataEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass eObjectToRectangleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType rectangleEDataType = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see cz.zcu.yafmt.ui.editors.fm.layout.LayoutDataPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private LayoutDataPackageImpl() {
        super(eNS_URI, LayoutDataFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     * 
     * <p>This method is used to initialize {@link LayoutDataPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static LayoutDataPackage init() {
        if (isInited) return (LayoutDataPackage)EPackage.Registry.INSTANCE.getEPackage(LayoutDataPackage.eNS_URI);

        // Obtain or create and register package
        LayoutDataPackageImpl theLayoutDataPackage = (LayoutDataPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof LayoutDataPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new LayoutDataPackageImpl());

        isInited = true;

        // Create package meta-data objects
        theLayoutDataPackage.createPackageContents();

        // Initialize created meta-data
        theLayoutDataPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theLayoutDataPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(LayoutDataPackage.eNS_URI, theLayoutDataPackage);
        return theLayoutDataPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getLayoutData() {
        return layoutDataEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getLayoutData_Mapping() {
        return (EReference)layoutDataEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getEObjectToRectangle() {
        return eObjectToRectangleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getEObjectToRectangle_Key() {
        return (EReference)eObjectToRectangleEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEObjectToRectangle_Value() {
        return (EAttribute)eObjectToRectangleEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getRectangle() {
        return rectangleEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public LayoutDataFactory getLayoutDataFactory() {
        return (LayoutDataFactory)getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

        // Create classes and their features
        layoutDataEClass = createEClass(LAYOUT_DATA);
        createEReference(layoutDataEClass, LAYOUT_DATA__MAPPING);

        eObjectToRectangleEClass = createEClass(EOBJECT_TO_RECTANGLE);
        createEReference(eObjectToRectangleEClass, EOBJECT_TO_RECTANGLE__KEY);
        createEAttribute(eObjectToRectangleEClass, EOBJECT_TO_RECTANGLE__VALUE);

        // Create data types
        rectangleEDataType = createEDataType(RECTANGLE);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void initializePackageContents() {
        if (isInitialized) return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes

        // Initialize classes and features; add operations and parameters
        initEClass(layoutDataEClass, LayoutData.class, "LayoutData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getLayoutData_Mapping(), this.getEObjectToRectangle(), null, "mapping", null, 0, -1, LayoutData.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        EOperation op = addEOperation(layoutDataEClass, null, "set", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, ecorePackage.getEObject(), "object", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getRectangle(), "bounds", 0, 1, IS_UNIQUE, IS_ORDERED);

        op = addEOperation(layoutDataEClass, this.getRectangle(), "get", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, ecorePackage.getEObject(), "object", 0, 1, IS_UNIQUE, IS_ORDERED);

        op = addEOperation(layoutDataEClass, this.getRectangle(), "remove", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, ecorePackage.getEObject(), "object", 0, 1, IS_UNIQUE, IS_ORDERED);

        initEClass(eObjectToRectangleEClass, Map.Entry.class, "EObjectToRectangle", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
        initEReference(getEObjectToRectangle_Key(), ecorePackage.getEObject(), null, "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getEObjectToRectangle_Value(), this.getRectangle(), "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Initialize data types
        initEDataType(rectangleEDataType, Rectangle.class, "Rectangle", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

        // Create resource
        createResource(eNS_URI);
    }

} //LayoutDataPackageImpl
