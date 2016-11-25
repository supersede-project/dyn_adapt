package cz.zcu.yafmt.ui.editors.fc.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

import cz.zcu.yafmt.model.fc.AttributeValue;
import cz.zcu.yafmt.model.fc.FeatureConfiguration;
import cz.zcu.yafmt.model.fc.Selection;
import cz.zcu.yafmt.ui.editors.fc.FeatureConfigurationManager;
import cz.zcu.yafmt.ui.editors.fc.model.Connection;

public class FeatureConfigurationEditPartFactory implements EditPartFactory {

    private FeatureConfigurationManager featureConfigManager;

    public FeatureConfigurationEditPartFactory(FeatureConfigurationManager featureConfigManager) {
        this.featureConfigManager = featureConfigManager;
    }

    @Override
    public EditPart createEditPart(EditPart context, Object model) {
        if(model instanceof FeatureConfiguration)
            return new FeatureConfigurationEditPart(featureConfigManager, (FeatureConfiguration) model);
        if(model instanceof Selection)
            return new SelectionEditPart(featureConfigManager, (Selection) model);
        if(model instanceof AttributeValue)
            return new AttributeValueEditPart((AttributeValue) model);
        if(model instanceof Connection)
            return new ConnectionEditPart((Connection) model);

        throw new IllegalStateException("No EditPart for " + model.getClass());
    }

}
