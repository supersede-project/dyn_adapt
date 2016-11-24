package cz.zcu.yafmt.ui.editors.fm.commands;

import org.eclipse.emf.ecore.EObject;

import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.util.FeatureModelUtil;
import cz.zcu.yafmt.ui.commands.RecordingCommand;
import cz.zcu.yafmt.ui.editors.fm.model.Connection;

public class ReconnectTargetCommand extends RecordingCommand {

    private Feature target;
    private EObject oldSource;
    private EObject newSource;

    public ReconnectTargetCommand(Connection connection, EObject newSource) {
        this.target = connection.getTarget();
        this.oldSource = connection.getSource();
        this.newSource = newSource;
        setLabel("Make " + target.getName() + " Subfeature of " + FeatureModelUtil.getParentName(newSource));
    }

    @Override
    protected void initializeRecording() {
        addRecordedObject(target);
        addRecordedObjectParent(target); // Old source.
        addRecordedObject(newSource);
    }

    @Override
    protected void performRecording() {
        target.setParent(newSource);
        FeatureModelUtil.removeUnneededGroup(oldSource);
    }

}
