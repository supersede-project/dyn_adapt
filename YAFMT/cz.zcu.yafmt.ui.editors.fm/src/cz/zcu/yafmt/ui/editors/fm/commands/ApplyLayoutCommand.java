package cz.zcu.yafmt.ui.editors.fm.commands;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.Animation;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;

import cz.zcu.yafmt.model.fm.FeatureModel;
import cz.zcu.yafmt.ui.editors.fm.layout.LayoutData;

public abstract class ApplyLayoutCommand extends Command {

    protected FeatureModel featureModel;
    private LayoutData layoutData;
    protected Map<EObject, Rectangle> oldLayout;
    protected Map<EObject, Rectangle> newLayout;

    public ApplyLayoutCommand(FeatureModel featureModel, LayoutData layoutData) {
        this.featureModel = featureModel;
        this.layoutData = layoutData;
    }

    protected abstract void applyLayout();

    @Override
    public void execute() {
        oldLayout = new HashMap<EObject, Rectangle>(layoutData.getMapping().map());
        newLayout = new HashMap<EObject, Rectangle>();
        applyLayout();

        Animation.markBegin();
        redo();
        Animation.run();
    }

    @Override
    public void redo() {
        layoutData.getMapping().putAll(newLayout);
    }

    @Override
    public void undo() {
        layoutData.getMapping().putAll(oldLayout);
    }

}
