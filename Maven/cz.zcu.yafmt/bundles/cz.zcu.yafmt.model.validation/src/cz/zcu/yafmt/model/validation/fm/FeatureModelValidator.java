package cz.zcu.yafmt.model.validation.fm;

import static cz.zcu.yafmt.model.fm.FeatureModelPackage.ATTRIBUTE;
import static cz.zcu.yafmt.model.fm.FeatureModelPackage.ATTRIBUTE__ID;
import static cz.zcu.yafmt.model.fm.FeatureModelPackage.ATTRIBUTE__NAME;
import static cz.zcu.yafmt.model.fm.FeatureModelPackage.CONSTRAINT;
import static cz.zcu.yafmt.model.fm.FeatureModelPackage.CONSTRAINT__LANGUAGE;
import static cz.zcu.yafmt.model.fm.FeatureModelPackage.CONSTRAINT__VALUE;
import static cz.zcu.yafmt.model.fm.FeatureModelPackage.FEATURE;
import static cz.zcu.yafmt.model.fm.FeatureModelPackage.FEATURE_MODEL;
import static cz.zcu.yafmt.model.fm.FeatureModelPackage.FEATURE_MODEL__NAME;
import static cz.zcu.yafmt.model.fm.FeatureModelPackage.FEATURE__ID;
import static cz.zcu.yafmt.model.fm.FeatureModelPackage.FEATURE__LOWER;
import static cz.zcu.yafmt.model.fm.FeatureModelPackage.FEATURE__NAME;
import static cz.zcu.yafmt.model.fm.FeatureModelPackage.FEATURE__UPPER;
import static cz.zcu.yafmt.model.fm.FeatureModelPackage.GROUP;
import static cz.zcu.yafmt.model.fm.FeatureModelPackage.GROUP__LOWER;
import static cz.zcu.yafmt.model.fm.FeatureModelPackage.GROUP__UPPER;
import static cz.zcu.yafmt.model.validation.Localization.getMessage;
import static cz.zcu.yafmt.model.validation.ValidationUtil.checkBounds;
import static cz.zcu.yafmt.model.validation.ValidationUtil.checkEmptyValue;
import static cz.zcu.yafmt.model.validation.ValidationUtil.checkIdValue;

import java.util.List;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import cz.zcu.yafmt.clang.ConstraintLanguageDescriptor;
import cz.zcu.yafmt.clang.ConstraintLanguagePlugin;
import cz.zcu.yafmt.clang.ConstraintLanguageRegistry;
import cz.zcu.yafmt.clang.IConstraintLanguage;
import cz.zcu.yafmt.clang.IEvaluator;
import cz.zcu.yafmt.clang.IValidationResult;
import cz.zcu.yafmt.model.fm.Attribute;
import cz.zcu.yafmt.model.fm.Constraint;
import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.FeatureModel;
import cz.zcu.yafmt.model.fm.Group;
import cz.zcu.yafmt.model.fm.FeatureModelPackage.Literals;
import cz.zcu.yafmt.model.validation.BasicValidator;

public class FeatureModelValidator extends BasicValidator {

    public static final FeatureModelValidator INSTANCE = new FeatureModelValidator();
        
    // ===========================================================================
    //  Object validation
    // ===========================================================================
    
    @Override
    protected boolean validate(EObject object, DiagnosticChain diagnostics, boolean recursive) {
        switch(object.eClass().getClassifierID()) {
            case FEATURE_MODEL:
                return validateFeatureModel((FeatureModel) object, diagnostics, recursive);
            
            case FEATURE:
                return validateFeature((Feature) object, diagnostics);
                
            case GROUP:
                return validateGroup((Group) object, diagnostics);
                
            case ATTRIBUTE:
                return validateAttribute((Attribute) object, diagnostics);
                
            case CONSTRAINT:
                return validateConstraint((Constraint) object, diagnostics);
        }
        return true;
    }
    
    private boolean validateFeatureModel(FeatureModel featureModel, DiagnosticChain diagnostics, boolean recursive) {
        boolean result = validateStructuralFeature(featureModel, Literals.FEATURE_MODEL__NAME, diagnostics);
        if(recursive)
            result &= validateAllContents(featureModel, diagnostics, true);
        return result;
    }
    
    private boolean validateFeature(Feature feature, DiagnosticChain diagnostics) {
        boolean result = validateStructuralFeature(feature, Literals.FEATURE__ID, diagnostics);
        result &= validateStructuralFeature(feature, Literals.FEATURE__NAME, diagnostics);
        result &= validateStructuralFeature(feature, Literals.FEATURE__LOWER, diagnostics); // Lower bound check includes also upper bound check.
        return result;
    }
    
    private boolean validateGroup(Group group, DiagnosticChain diagnostics) {
        boolean result = validateStructuralFeature(group, Literals.GROUP__LOWER, diagnostics); // Lower bound check includes also upper bound check.
        result &= validateGroupUpperMinimum(group, diagnostics, result);
        result &= validateGroupLowerMaximum(group, diagnostics, result);
        return result;
    }

    private boolean validateGroupUpperMinimum(Group group, DiagnosticChain diagnostics, boolean result) {
        int groupUpper = group.getUpper();
        if(groupUpper == -1)
            return true;
        
        int featuresLowerSum = 0;
        for(Feature feature: group.getFeatures())
            featuresLowerSum += feature.getLower();
        
        if(featuresLowerSum > groupUpper) {
            addError(diagnostics, getMessage("Errors_GroupUpperMinimum"), group);
            return false;
        }
        
        return true;
    }
    
    private boolean validateGroupLowerMaximum(Group group, DiagnosticChain diagnostics, boolean result) {
        int groupLower = group.getLower();
        
        int featuresUpperSum = 0;
        for(Feature feature: group.getFeatures()) {
            int featureUpper = feature.getUpper();
            if(featureUpper == -1)
                return true;
            featuresUpperSum += featureUpper;
        }
        
        if(featuresUpperSum < groupLower) {
            addError(diagnostics, getMessage("Errors_GroupLowerMaximum"), group);
            return false;
        }
        
        return true;
    }
    
    private boolean validateAttribute(Attribute attribute, DiagnosticChain diagnostics) {
        boolean result = validateStructuralFeature(attribute, Literals.ATTRIBUTE__NAME, diagnostics);
        result &= validateStructuralFeature(attribute, Literals.ATTRIBUTE__ID, diagnostics);
        return result;
    }
    
    private boolean validateConstraint(Constraint constraint, DiagnosticChain diagnostics) {
        if(!validateStructuralFeature(constraint, Literals.CONSTRAINT__LANGUAGE, diagnostics))
            return false;
        return validateStructuralFeature(constraint, Literals.CONSTRAINT__VALUE, diagnostics);
    }

    // ===========================================================================
    //  Structural feature validation
    // ===========================================================================

    @Override
    protected void checkStructuralFeature(EObject object, EStructuralFeature structuralFeature, Object value) throws Exception  {
        switch(object.eClass().getClassifierID()) {
            case FEATURE_MODEL:
                checkFeatureModelStructuralFeature((FeatureModel) object, structuralFeature, value);
                break;
            
            case FEATURE:
                checkFeatureStructuralFeature((Feature) object, structuralFeature, value);
                break;
                
            case GROUP:
                checkGroupStructuralFeature((Group) object, structuralFeature, value);
                break;
                
            case ATTRIBUTE:
                checkAttributeStructuralFeature((Attribute) object, structuralFeature, value);
                break;
                
            case CONSTRAINT:
                checkConstraintStructuralFeature((Constraint) object, structuralFeature, value);
                break;
        }
    }

    private void checkFeatureModelStructuralFeature(FeatureModel featureModel, EStructuralFeature structuralFeature, Object value) throws Exception {
        switch(structuralFeature.getFeatureID()) {
            case FEATURE_MODEL__NAME:
                checkEmptyValue(getMessage("FeatureModel_Name"), (String) value);
                break;
        }
    }
    
    private void checkFeatureStructuralFeature(Feature feature, EStructuralFeature structuralFeature, Object value) throws Exception {
        switch(structuralFeature.getFeatureID()) {
            case FEATURE__ID: {
                String id = (String) value;
                checkIdValue(getMessage("Feature_Id"), id);
                
                FeatureModel featureModel = feature.getFeatureModel();
                if(featureModel == null)
                    break;
                List<Feature> features = featureModel.getFeaturesById(id); 
                if((features.size() > 1) || ((features.size() == 1) && (features.get(0) != feature)))
                    throw new Exception(getMessage("Errors_IdNotUnique", getMessage("FeatureModel")));
                break;
            }
                
            case FEATURE__NAME:
                checkEmptyValue(getMessage("Feature_Name"), (String) value);
                break;
                
            case FEATURE__LOWER:
                int lower = (value instanceof String) ? Integer.parseInt((String) value) : (Integer) value; 
                checkBounds(lower, feature.getUpper());
                break;
                
            case FEATURE__UPPER:
                int upper = (value instanceof String) ? Integer.parseInt((String) value) : (Integer) value; 
                checkBounds(feature.getLower(), upper);
                break;
        }
    }
    
    private void checkGroupStructuralFeature(Group group, EStructuralFeature structuralFeature, Object value) throws Exception {
        switch(structuralFeature.getFeatureID()) {
            case GROUP__LOWER:
                int lower = (value instanceof String) ? Integer.parseInt((String) value) : (Integer) value; 
                checkBounds(lower, group.getUpper());
                break;
                
            case GROUP__UPPER:
                int upper = (value instanceof String) ? Integer.parseInt((String) value) : (Integer) value; 
                checkBounds(group.getLower(), upper);
                break;
        }
    }
    
    private void checkAttributeStructuralFeature(Attribute attribute, EStructuralFeature structuralFeature, Object value) throws Exception {
        switch(structuralFeature.getFeatureID()) {
            case ATTRIBUTE__ID: {
                String id = (String) value;
                checkIdValue(getMessage("Attribute_Id"), id);
                
                Feature feature = attribute.getFeature();
                if(feature == null)
                    break;
                
                for(Attribute otherAttribute: feature.getAttributes()) {
                    if((otherAttribute != attribute) && (id.equals(otherAttribute.getId())))
                        throw new Exception(getMessage("Errors_IdNotUnique", getMessage("Feature")));
                }
                break;
            }
            
            case ATTRIBUTE__NAME:
                checkEmptyValue(getMessage("Attribute_Name"), (String) value);
                break;
        }
    }
    
    private void checkConstraintStructuralFeature(Constraint constraint, EStructuralFeature structuralFeature, Object value) throws Exception {
        switch(structuralFeature.getFeatureID()) {
            case CONSTRAINT__LANGUAGE: {
                if(value instanceof String) {
                    ConstraintLanguageRegistry registry = ConstraintLanguagePlugin.getDefault().getConstraintLanguageRegistry();
                    if(registry.getLanguage((String) value) == null)
                        throw new Exception(getMessage("Errors_UnknownConstraintLangauge"));
                }
                else if(!(value instanceof ConstraintLanguageDescriptor)) {
                    throw new Exception(getMessage("Errors_UnknownConstraintLangauge"));
                }
                break;
            }
                
            case CONSTRAINT__VALUE: {
                ConstraintLanguageRegistry registry = ConstraintLanguagePlugin.getDefault().getConstraintLanguageRegistry();
                IConstraintLanguage langauge = registry.getLanguage(constraint.getLanguage());
                if(langauge == null)
                    break;
                
                IEvaluator evaluator = langauge.createEvaluator((String) value);
                IValidationResult result = evaluator.validate(constraint.getFeatureModel());
                if(!result.isSuccess())
                    throw new Exception(result.getErrorMessage());
                break;
            }
        }
    }
    
}
