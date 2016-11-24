package cz.zcu.yafmt.clang;

import java.util.List;

import cz.zcu.yafmt.model.fc.FeatureConfiguration;
import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.FeatureModel;

/**
 * Class representing parsed constraint.
 * 
 * @author Jan Pikl
 */
public interface IEvaluator {

    /**
     * Returns list of all features affected by the constraint.
     * 
     * @param featureModel
     *            feature model from which are the returned features taken
     * @return list of all features affected by the constraint
     */
    List<Feature> getAffectedFeatures(FeatureModel featureModel);

    /**
     * Check constraints validity against feature model. For example, if all
     * referenced features are really present in the feature model.
     * 
     * @param featureModel
     *            feature model against which will be the constraint validated
     * @return result of validation
     */
    IValidationResult validate(FeatureModel featureModel);

    /**
     * Evaluates if a configuration satisfies the constraint.
     * 
     * @param featureConfig
     *            the configuration to evaluate
     * @return result of evaluation
     */
    IEvaluationResult evaluate(FeatureConfiguration featureConfig);

}
