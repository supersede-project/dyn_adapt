package cz.zcu.yafmt.ui.editors.fm.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.ui.parts.GraphicalEditor;

import cz.zcu.yafmt.clang.util.ConstraintCache;
import cz.zcu.yafmt.model.fm.Attribute;
import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.FeatureModel;
import cz.zcu.yafmt.model.fm.Group;
import cz.zcu.yafmt.ui.editors.fm.layout.LayoutData;
import cz.zcu.yafmt.ui.editors.fm.model.Connection;
import cz.zcu.yafmt.ui.validation.IProblemManager;

public class FeatureModelEditPartFactory implements EditPartFactory {

    private LayoutData layoutData;
    private ConstraintCache constraintCache;
    private IProblemManager problemManager;

    public FeatureModelEditPartFactory(GraphicalEditor editor) {
        layoutData = (LayoutData) editor.getAdapter(LayoutData.class);
        constraintCache = (ConstraintCache) editor.getAdapter(ConstraintCache.class);
        problemManager = (IProblemManager) editor.getAdapter(IProblemManager.class);
    }

    @Override
    public EditPart createEditPart(EditPart context, Object model) {
        if(model instanceof FeatureModel)
            return new FeatureModelEditPart((FeatureModel) model, layoutData, constraintCache, problemManager);
        if(model instanceof Feature)
            return new FeatureEditPart((Feature) model, layoutData, problemManager);
        if(model instanceof Group)
            return new GroupEditPart((Group) model, layoutData, problemManager);
        if(model instanceof Connection)
            return new ConnectionEditPart((Connection) model);
        if(model instanceof Attribute)
            return new AttributeEditPart((Attribute) model, problemManager);

        throw new IllegalStateException("No EditPart for " + model.getClass());
    }

}
