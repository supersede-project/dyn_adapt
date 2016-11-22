package cz.zcu.yafmt.model.validation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public interface IStructuralFeatureValidator {

    String getStructuralFeatureError(EObject object, EStructuralFeature structuralFeature, Object value);
    
}
