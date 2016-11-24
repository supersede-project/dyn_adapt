package cz.zcu.yafmt.ui.editors.fm.commands;

import org.eclipse.emf.ecore.EObject;

import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.util.FeatureModelUtil;
import cz.zcu.yafmt.ui.commands.RecordingCommand;
import cz.zcu.yafmt.ui.editors.fm.model.Connection;

public class ReconnectSourceCommand extends RecordingCommand {

    private EObject source;
    private Feature oldTarget;
    private Feature newTarget;

    public ReconnectSourceCommand(Connection connection, Feature newTarget) {
        this.source = connection.getSource();
        this.oldTarget = connection.getTarget();
        this.newTarget = newTarget;
        setLabel("Make " + newTarget.getName() + " Subfeature of " + FeatureModelUtil.getParentName(source));
    }

    @Override
    protected void initializeRecording() {
        addRecordedObject(oldTarget.getFeatureModel());
        addRecordedObject(source);
        addRecordedObjectParent(newTarget);
    }

    @Override
    protected void performRecording() {
        EObject newTargetPreviousParent = newTarget.getParent();
        oldTarget.setParent(oldTarget.getFeatureModel());
        newTarget.setParent(source);
        FeatureModelUtil.removeUnneededGroup(newTargetPreviousParent);
    }

}
