package cz.zcu.yafmt.clang.ui;

import cz.zcu.yafmt.model.fm.FeatureModel;

/**
 * Context of constraint editing.
 * 
 * @author Jan Pikl
 */
public class EditingContext {

    /** The edited feature model. */
    FeatureModel featureModel;

    /**
     * Creates editing context.
     * 
     * @param featureModel the edited feature model
     */
    public EditingContext(FeatureModel featureModel) {
        this.featureModel = featureModel;
    }

    /**
     * Returns the edited feature model.
     * 
     * @return the edited feature model
     */
    public FeatureModel getFeatureModel() {
        return featureModel;
    }

}
