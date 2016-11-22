package cz.zcu.yafmt.model.validation;

import static cz.zcu.yafmt.model.validation.Localization.getMessage;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EValidator;

public abstract class BasicValidator implements EValidator, IStructuralFeatureValidator {

    private static final String DIAGNOSTIC_SOURCE = "cz.zcu.yafmt.model.validation";
    
    // =============================================================================
    //  Public API
    // =============================================================================
    
    public boolean validate(EObject object, DiagnosticChain diagnostics) {
        return validate(object, diagnostics, false);
    }
    
    public boolean validateRecursive(EObject object, DiagnosticChain diagnostics) {
        return validate(object, diagnostics, true);
    }
    
    public boolean validate(Collection<? extends EObject> object, DiagnosticChain diagnostics) {
        return validate(object, diagnostics, false);
    }
    
    public boolean validateRecursive(Collection<? extends EObject> object, DiagnosticChain diagnostics) {
        return validate(object, diagnostics, true);
    }
    
    // =============================================================================
    //  Object validations
    // =============================================================================
    
    protected abstract boolean validate(EObject object, DiagnosticChain diagnostics, boolean recursive);
    
    protected boolean validate(Collection<? extends EObject> objects, DiagnosticChain diagnostics, boolean recursive) {
        boolean result = true;
        for(EObject object: objects) {
            if(!validate(object, diagnostics, recursive))
                result = false;
        }
        return result;
    }
    
    protected boolean validateAllContents(EObject object, DiagnosticChain diagnostics, boolean recursive) {
        TreeIterator<EObject> it = object.eAllContents();
        boolean result = true;
        while(it.hasNext())
            result &= validate(it.next(), diagnostics, recursive);
        return result;
    }
    
    // =============================================================================
    //  Structural features validation
    // =============================================================================
        
    protected boolean validateAllStructuralFeatures(EObject object, DiagnosticChain diagnostics) {
        EList<EStructuralFeature> structuralFeautures = object.eClass().getEAllStructuralFeatures(); 
        return validateStructuralFeatures(object, structuralFeautures.toArray(new EStructuralFeature[structuralFeautures.size()]), diagnostics);
    }
    
    protected boolean validateStructuralFeatures(EObject object, EStructuralFeature[] structuralFeatures, DiagnosticChain diagnostics) {
        boolean result = true;
        for(EStructuralFeature structuralFeature: structuralFeatures)
            result &= validateStructuralFeature(object, structuralFeature, diagnostics);
        return result;
    }
    
    protected boolean validateStructuralFeature(EObject object, EStructuralFeature structuralFeature, DiagnosticChain diagnostics) {
        String message = getStructuralFeatureError(object, structuralFeature, object.eGet(structuralFeature));
        if(message != null) {
            addError(diagnostics, message, object);
            return false;
        }
        return true;
    }
    
    @Override
    public String getStructuralFeatureError(EObject object, EStructuralFeature structuralFeature, Object value) {
        try {
            checkStructuralFeature(object, structuralFeature, value);
            return null;
        }
        catch(NumberFormatException ex) {
            return getMessage("Errors_NotANumber");
        }
        catch(Exception ex) {
            return ex.getMessage();
        }
    }
    
    protected abstract void checkStructuralFeature(EObject object, EStructuralFeature structuralFeature, Object value) throws Exception ;
    
    // =============================================================================
    //  Utilities
    // =============================================================================

    protected void addError(DiagnosticChain diagnostics, String message, Object object) {
        addDiagnostics(diagnostics, Diagnostic.ERROR, message, new Object[] { object });
    }
    
    protected void addError(DiagnosticChain diagnostics, String message, Object[] objects) {
        addDiagnostics(diagnostics, Diagnostic.ERROR, message, objects);
    }
        
    protected void addDiagnostics(DiagnosticChain diagnostics, int code, String message, Object[] objects) {
        diagnostics.add(new BasicDiagnostic(DIAGNOSTIC_SOURCE, code, message, objects));
    }
    
    // =============================================================================
    //  EValidator interface methods
    // =============================================================================
    
    @Override
    public boolean validate(EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validateRecursive(eObject, diagnostics);
    }

    @Override
    public boolean validate(EClass eClass, EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validateRecursive(eObject, diagnostics);
    }

    @Override
    public boolean validate(EDataType eDataType, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return true;
    }
        
}
