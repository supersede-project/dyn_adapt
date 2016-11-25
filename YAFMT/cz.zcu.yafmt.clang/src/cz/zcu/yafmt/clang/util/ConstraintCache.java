package cz.zcu.yafmt.clang.util;

import static cz.zcu.yafmt.model.fm.FeatureModelPackage.*;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;

import cz.zcu.yafmt.clang.ConstraintLanguageException;
import cz.zcu.yafmt.clang.ConstraintLanguagePlugin;
import cz.zcu.yafmt.clang.ConstraintLanguageRegistry;
import cz.zcu.yafmt.clang.IConstraintLanguage;
import cz.zcu.yafmt.clang.IEvaluator;
import cz.zcu.yafmt.model.fm.Constraint;
import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.FeatureModel;
import cz.zcu.yafmt.model.fm.Group;

/**
 * Cache preserving feature-constraint mapping, indicating which constraints
 * affect which features and vice versa.
 * 
 * @author Jan Pikl
 */
public class ConstraintCache {

    private ConstraintLanguageRegistry registry = ConstraintLanguagePlugin.getDefault().getConstraintLanguageRegistry();
    private FeatureModelAdapter featureModelAdapter = new FeatureModelAdapter();

    private Map<Constraint, List<Feature>> constraintToFeatures = new HashMap<Constraint, List<Feature>>();
    private Map<Feature, Set<Constraint>> featureToConstraints = new HashMap<Feature, Set<Constraint>>();
    private Map<Constraint, IEvaluator> constraintToEvaluator = new HashMap<Constraint, IEvaluator>();

    private FeatureModel featureModel;
    private boolean valid = false;

    public ConstraintCache() {
        this(null);
    }

    public ConstraintCache(FeatureModel featureModel) {
        setFeatureModel(featureModel);
    }

    public void dispose() {
        setFeatureModel(null);
    }

    public void setFeatureModel(FeatureModel newFeatureModel) {
        if(featureModel == newFeatureModel)
            return;

        if(featureModel != null)
            featureModel.eAdapters().remove(featureModelAdapter);
        featureModel = newFeatureModel;
        if(featureModel != null)
            featureModel.eAdapters().add(featureModelAdapter);

        invalidate();
    }

    public Collection<Feature> getFeaturesAffectedByConstraint() {
        checkValidity();
        return featureToConstraints.keySet();
    }

    public Collection<Feature> getFeaturesAffectedByConstraint(Constraint constraint) {
        checkValidity();

        Collection<Feature> features = constraintToFeatures.get(constraint);
        if(features != null)
            return features;
        return Collections.emptyList();
    }

    public Collection<Constraint> getConstraintsAffectingFeature(Feature feature) {
        checkValidity();

        Collection<Constraint> constraints = featureToConstraints.get(feature);
        if(constraints != null)
            return constraints;
        return Collections.emptyList();
    }

    // =======================================================================
    //  Cache invalidation/refreshing
    // =======================================================================

    private void invalidate() {
        valid = false;
        constraintToFeatures.clear();
        featureToConstraints.clear();
    }

    private void checkValidity() {
        if(!valid && (featureModel != null)) {
            refresh();
            valid = true;
        }
    }

    private void refresh() {
        for(Map.Entry<Constraint, IEvaluator> entry: constraintToEvaluator.entrySet()) {
            Constraint constraint = entry.getKey();
            IEvaluator evaluator = entry.getValue();
            List<Feature> features = evaluator.getAffectedFeatures(featureModel);
            constraintToFeatures.put(constraint, features);

            for(Feature feature: features) {
                Set<Constraint> set = featureToConstraints.get(feature);
                if(set == null) {
                    set = new HashSet<Constraint>();
                    featureToConstraints.put(feature, set);
                }
                set.add(constraint);
            }
        }
    }
    
    // =======================================================================
    //  Helpers
    // =======================================================================

    private boolean setEvaluator(Constraint constraint, IEvaluator evaluator) {
        if(evaluator != null) {
            constraintToEvaluator.put(constraint, evaluator);
            return true;
        }

        return constraintToEvaluator.remove(constraint) != null;
    }

    private IEvaluator createEvaluator(Constraint constraint) {
        IConstraintLanguage langauge = registry.getLanguage(constraint.getLanguage());
        if(langauge == null)
            return null;

        try {
            return langauge.createEvaluator(constraint.getValue());
        }
        catch(ConstraintLanguageException ex) {
            return null; // Ignore that.
        }
    }

    // =======================================================================
    //  Events
    // =======================================================================

    private class FeatureModelAdapter extends EContentAdapter {

        @Override
        protected void addAdapter(Notifier notifier) {
            super.addAdapter(notifier);

            if(notifier instanceof Constraint) {
                Constraint constraint = (Constraint) notifier;
                if(setEvaluator(constraint, createEvaluator(constraint)))
                    invalidate();
            }
        }

        @Override
        protected void removeAdapter(Notifier notifier) {
            super.removeAdapter(notifier);

            if(notifier instanceof Constraint) {
                Constraint constraint = (Constraint) notifier;
                if(setEvaluator(constraint, null))
                    invalidate();
            }
        }

        @Override
        public void notifyChanged(Notification msg) {
            super.notifyChanged(msg);

            EObject notifier = (EObject) msg.getNotifier();
            switch(notifier.eClass().getClassifierID()) {
                case FEATURE_MODEL:
                    notifyChangedFromFeatureModel(msg);
                    break;

                case FEATURE:
                    notifyChangedFromFeature(msg);
                    break;

                case GROUP:
                    notifyChangedFromGroup(msg);
                    break;

                case CONSTRAINT:
                    notifyChangedFromConstraint(msg);
                    break;
            }
        }

        private void notifyChangedFromFeatureModel(Notification msg) {
            switch(msg.getFeatureID(FeatureModel.class)) {
                case FEATURE_MODEL__ROOT:
                case FEATURE_MODEL__ORPHANS:
                    invalidate();
                    break;
            }
        }

        private void notifyChangedFromFeature(Notification msg) {
            switch(msg.getFeatureID(Feature.class)) {
                case FEATURE__ID:
                case FEATURE__FEATURES:
                case FEATURE__GROUPS:
                    invalidate();
                    break;
            }
        }

        private void notifyChangedFromGroup(Notification msg) {
            switch(msg.getFeatureID(Group.class)) {
                case GROUP__FEATURES:
                    invalidate();
                    break;
            }
        }

        private void notifyChangedFromConstraint(Notification msg) {
            Constraint constraint = (Constraint) msg.getNotifier();

            switch(msg.getFeatureID(Constraint.class)) {
                case CONSTRAINT__LANGUAGE:
                case CONSTRAINT__VALUE:
                    if(setEvaluator(constraint, createEvaluator(constraint)))
                        invalidate();
                    break;
            }
        }

    }

}
