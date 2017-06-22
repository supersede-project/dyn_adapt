package cz.zcu.yafmt.ui.editors.fm.commands;

import org.eclipse.emf.ecore.EObject;

import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.util.FeatureModelUtil;
import cz.zcu.yafmt.ui.commands.RecordingCommand;
import cz.zcu.yafmt.ui.editors.fm.model.Connection;

public class DeleteConnectionCommand extends RecordingCommand {

    private EObject source;
    private Feature target;

    public DeleteConnectionCommand(Connection connection) {
        source = connection.getSource();
        target = connection.getTarget();
        setLabel("Remove Subfeature " + target.getName() + " from " + FeatureModelUtil.getParentName(target.getParent()));
    }

    @Override
    protected void initializeRecording() {
        addRecordedObject(target.getFeatureModel());
        addRecordedObject(target);
        addRecordedObjectParent(target);
    }

    @Override
    protected void performRecording() {
        target.setParent(target.getFeatureModel());
        FeatureModelUtil.removeUnneededGroup(source);
    }

}
