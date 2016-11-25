package cz.zcu.yafmt.model.validation.fc;

import static cz.zcu.yafmt.model.fc.FeatureConfigurationPackage.DOUBLE_VALUE;
import static cz.zcu.yafmt.model.fc.FeatureConfigurationPackage.DOUBLE_VALUE__VALUE;
import static cz.zcu.yafmt.model.fc.FeatureConfigurationPackage.FEATURE_CONFIGURATION;
import static cz.zcu.yafmt.model.fc.FeatureConfigurationPackage.FEATURE_CONFIGURATION__NAME;
import static cz.zcu.yafmt.model.fc.FeatureConfigurationPackage.INTEGER_VALUE;
import static cz.zcu.yafmt.model.fc.FeatureConfigurationPackage.INTEGER_VALUE__VALUE;
import static cz.zcu.yafmt.model.validation.Localization.getMessage;
import static cz.zcu.yafmt.model.validation.ValidationUtil.checkEmptyValue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import cz.zcu.yafmt.clang.ConstraintLanguageException;
import cz.zcu.yafmt.clang.ConstraintLanguagePlugin;
import cz.zcu.yafmt.clang.ConstraintLanguageRegistry;
import cz.zcu.yafmt.clang.IConstraintLanguage;
import cz.zcu.yafmt.clang.IEvaluationResult;
import cz.zcu.yafmt.clang.IEvaluator;
import cz.zcu.yafmt.model.fc.DoubleValue;
import cz.zcu.yafmt.model.fc.FeatureConfiguration;
import cz.zcu.yafmt.model.fc.FeatureConfigurationPackage.Literals;
import cz.zcu.yafmt.model.fc.IntegerValue;
import cz.zcu.yafmt.model.fc.Selection;
import cz.zcu.yafmt.model.fm.Constraint;
import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.FeatureModel;
import cz.zcu.yafmt.model.fm.Group;
import cz.zcu.yafmt.model.validation.BasicValidator;

public class FeatureConfigurationValidator extends BasicValidator {
    
    private static class Pair {
        
        public Constraint constraint;
        public IEvaluator evaluator;
        
        public Pair(Constraint constraint, IEvaluator evalutor) {
            this.constraint = constraint;
            this.evaluator = evalutor;
        }
                
    }
    
    public static final FeatureConfigurationValidator INSTANCE = new FeatureConfigurationValidator();
        
    private FeatureConfiguration lastValidatedFeatureConfig;
    private List<Pair> evaluatorsCache;
    
    // ===========================================================================
    //  Object validation
    // ===========================================================================
    
    @Override
    protected boolean validate(EObject object, DiagnosticChain diagnostics, boolean recursive) {
        switch(object.eClass().getClassifierID()) {
            case FEATURE_CONFIGURATION:
                // We have to check it since there are also classes from a different package (FeatureModelPackage).
                if(object instanceof FeatureConfiguration)
                    return validateFeatureConfiguration((FeatureConfiguration) object, diagnostics, recursive);
        }
        return true;
    }

    private boolean validateFeatureConfiguration(FeatureConfiguration featureConfig, DiagnosticChain diagnostics, boolean recursive) {
        boolean result = validateStructuralFeature(featureConfig, Literals.FEATURE_CONFIGURATION__NAME, diagnostics);
        if(recursive) {
            result &= validateLocalConstraints(featureConfig, diagnostics);
            result &= validateGlobalConstraints(featureConfig, diagnostics);
        }
        return result;
    }
    
    // ===========================================================================
    //  Local constraints
    // ===========================================================================
        
    private boolean validateLocalConstraints(FeatureConfiguration featureConfig, DiagnosticChain diagnostics) {
        TreeIterator<EObject> it = featureConfig.getFeatureModelCopy().eAllContents();
        boolean result = true;
        
        while(it.hasNext()) {
            EObject object = it.next();
            if(object instanceof Group)
                result &= validateLocalConstraint(featureConfig, (Group) object, diagnostics);
        }
        
        return result;
    }

    private boolean validateLocalConstraint(FeatureConfiguration featureConfig, Group group, DiagnosticChain diagnostics) {
        // Collect children IDs.
        Set<String> groupedFeaturesIds = new HashSet<String>();
        for(Feature childFeature: group.getFeatures())
            groupedFeaturesIds.add(childFeature.getId());

        // Local constraints.
        int lower = group.getLower();
        int upper = group.getUpper();
        boolean result = true;

        // Validate number of grouped selected features in each group.
        for(Selection selection: featureConfig.getSelectionsById(group.getParent().getId())) {
            int groupSize = 0;

            for(Selection childSelection: selection.getSelections()) {
                if(groupedFeaturesIds.contains(childSelection.getId()))
                    groupSize++;
            }

            if(groupSize < lower) {
                addError(diagnostics, getMessage("Errors_LocalConstraintMinimum", lower, getGroupedFeaturesNames(group)), selection);
                result = false;
            }
            if((upper != -1) && (groupSize > upper)) {
                addError(diagnostics, getMessage("Errors_LocalConstraintMaximum", upper, getGroupedFeaturesNames(group)), selection);
                result = false;
            }
        }
        
        return result;
    }
    
    private String getGroupedFeaturesNames(Group group) {
        StringBuilder builder = null;
        
        for(Feature feature: group.getFeatures()) {
            if(builder == null)
                builder = new StringBuilder(feature.getName());
            else
                builder.append(", ").append(feature.getName());
        }
        
        return builder.toString();
    }
    
    // ===========================================================================
    //  Global constraints
    // ===========================================================================
    
    private boolean validateGlobalConstraints(FeatureConfiguration featureConfig, DiagnosticChain diagnostics) {
        return validateGlobalConstraints(featureConfig, createEvaluators(featureConfig), diagnostics);
    }
    
    private List<Pair> createEvaluators(FeatureConfiguration featureConfig) {
        // If we do not use global instance, we can reuse already created evaluators.
        if(this != INSTANCE) {
            if((lastValidatedFeatureConfig == featureConfig) && (evaluatorsCache != null))
                return evaluatorsCache;
        }
        
        FeatureModel featureModel = featureConfig.getFeatureModelCopy();
        ConstraintLanguageRegistry registry = ConstraintLanguagePlugin.getDefault().getConstraintLanguageRegistry();
        
        List<Constraint> constraints = featureModel.getConstraints();
        List<Pair> evaluators = new ArrayList<Pair>(constraints.size());
        
        for(Constraint constraint: constraints) {
            try {
                // Add evaluators only for valid constraints.
                IConstraintLanguage language = registry.getLanguage(constraint.getLanguage());
                if(language == null)
                    continue;
                IEvaluator evaluator = language.createEvaluator(constraint.getValue());
                if(evaluator.validate(featureModel).isSuccess())
                    evaluators.add(new Pair(constraint, evaluator));
            }
            catch(ConstraintLanguageException ex) {
                // Ignore it.
            }
        }
        
        // If we do not use global instance, remember created evaluators.
        if(this != INSTANCE) {
            lastValidatedFeatureConfig = featureConfig;
            evaluatorsCache = evaluators;
        }
        
        return evaluators;
    }
    
    private boolean validateGlobalConstraints(FeatureConfiguration featureConfig, List<Pair> evaluators, DiagnosticChain diagnostics) {
        boolean result = true;
        for(Pair pair: evaluators)
            result &= validateGlobalContraint(featureConfig, pair.constraint, pair.evaluator, diagnostics);
        return result;
    }

    private boolean validateGlobalContraint(FeatureConfiguration featureConfig, Constraint constraint, IEvaluator evaluator, DiagnosticChain diagnostics) {
        IEvaluationResult result = evaluator.evaluate(featureConfig);
        if(result.isSuccess())
            return true;

        String message = result.getErrorMessage();
        if((message == null) || (message.isEmpty()))
            message = "Global constraint is violated";
        
        String description = constraint.getDescription();
        if((description != null) && !description.isEmpty())
            message += " " + description; 
        
        List<Object> problemElements = result.getProblemElements();
        if(problemElements == null)
            problemElements = Collections.emptyList();
        
        addError(diagnostics, message, problemElements.toArray(new Selection[problemElements.size()]));
        return false;
    }
    
    // ===========================================================================
    //  Structural features validation
    // ===========================================================================

    @Override
    protected void checkStructuralFeature(EObject object, EStructuralFeature structuralFeature, Object value) throws Exception {
        switch(object.eClass().getClassifierID()) {
            case FEATURE_CONFIGURATION:
                checkFeatureConfigurationStructuralFeature((FeatureConfiguration) object, structuralFeature, value);
                break;
                
            case INTEGER_VALUE:
                checkIntegerValueStructuralFeature((IntegerValue) object, structuralFeature, value);
                break;
                
            case DOUBLE_VALUE:
                checkDoubleValueStructuralFeature((DoubleValue) object, structuralFeature, value);
                break;
        }
    }

    private void checkFeatureConfigurationStructuralFeature(FeatureConfiguration featureConfig, EStructuralFeature structuralFeature, Object value) throws Exception {
        switch(structuralFeature.getFeatureID()) {
            case FEATURE_CONFIGURATION__NAME:
                checkEmptyValue(getMessage("FeatureConfiguration_Name"), (String) value);
                break;
        }
    }

    private void checkIntegerValueStructuralFeature(IntegerValue integerValue, EStructuralFeature structuralFeature, Object value) {
        switch(structuralFeature.getFeatureID()) {
            case INTEGER_VALUE__VALUE:
                if(value instanceof String)
                    Integer.parseInt((String) value);
                break;
        }
        
        
    }

    private void checkDoubleValueStructuralFeature(DoubleValue doubleValue, EStructuralFeature structuralFeature, Object value) {
        switch(structuralFeature.getFeatureID()) {
            case DOUBLE_VALUE__VALUE:
                if(value instanceof String)
                    Double.parseDouble((String) value);
                break;
        }
    }

}
