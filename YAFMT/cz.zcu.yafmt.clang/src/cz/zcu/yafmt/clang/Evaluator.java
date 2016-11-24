package cz.zcu.yafmt.clang;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.FeatureModel;

/**
 * Basic implementation of {@link IEvaluator}.
 * 
 * @author Jan Pikl
 */
public abstract class Evaluator implements IEvaluator {

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Feature> getAffectedFeatures(FeatureModel featureModel) {
        if(featureModel == null)
            return null;

        Set<String> ids = getAffectedFeatureIds();
        if(ids == null)
            return null;

        List<Feature> features = new ArrayList<Feature>(ids.size());
        for(String id: ids)
            features.addAll(featureModel.getFeaturesById(id));
        return features;
    }

    /**
     * Returns list of features referenced by this constraint which are not
     * present in feature model.
     * 
     * @param featureModel
     *            the target feature model
     * @return list of referenced features which are not present in the
     *         specified feature model
     */
    public List<String> getMissingFeatureIds(FeatureModel featureModel) {
        if(featureModel == null)
            return null;

        Set<String> ids = getAffectedFeatureIds();
        if(ids == null)
            return null;

        List<String> features = null;
        for(String id: ids) {
            if(featureModel.getFeaturesById(id).isEmpty()) {
                if(features == null)
                    features = new ArrayList<String>();
                features.add(id);
            }
        }

        return features;
    }

    /**
     * {@inheritDoc} This implementation tests if all referenced features
     * (returned by {@link #getAffectedFeatureIds()}) are present in feature
     * model.
     */
    @Override
    public IValidationResult validate(FeatureModel featureModel) {
        List<String> missingFeatureIds = getMissingFeatureIds(featureModel);
        if((missingFeatureIds == null) || missingFeatureIds.isEmpty())
            return ValidationResult.SUCCESS_RESULT;

        if(missingFeatureIds.size() == 1)
            return new ValidationResult("Nonexistent feature ID: " + missingFeatureIds.get(0));

        StringBuilder builder = new StringBuilder("Nonexistent feature IDs: ");
        for(int i = 0; i < missingFeatureIds.size(); i++) {
            if(i != 0)
                builder.append(", ");
            builder.append(missingFeatureIds.get(i));
        }

        return new ValidationResult(builder.toString());
    }

    /**
     * Returns list of all feature IDs referenced by the constraint.
     * 
     * @return list of all referenced feature IDs
     */
    protected abstract Set<String> getAffectedFeatureIds();

}
