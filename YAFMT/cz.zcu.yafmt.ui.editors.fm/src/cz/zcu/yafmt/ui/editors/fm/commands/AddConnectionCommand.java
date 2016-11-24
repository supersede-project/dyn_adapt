package cz.zcu.yafmt.ui.editors.fm.commands;

import org.eclipse.emf.ecore.EObject;

import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.util.FeatureModelUtil;
import cz.zcu.yafmt.ui.commands.RecordingCommand;

public class AddConnectionCommand extends RecordingCommand {

    private EObject source;
    private Feature target;

    public AddConnectionCommand(EObject source) {
        this.source = source;
    }

    public EObject getSource() {
        return source;
    }

    public void setTarget(Feature target) {
        this.target = target;
        setLabel("Make " + target.getName() + " Subfeature of " + FeatureModelUtil.getParentName(source));
    }

    @Override
    protected void initializeRecording() {
        addRecordedObject(source);
        addRecordedObject(target);
        addRecordedObjectParent(target);
    }

    @Override
    protected void performRecording() {
        EObject targetPreviousParent = target.getParent();
        target.setParent(source);
        FeatureModelUtil.removeUnneededGroup(targetPreviousParent);
    }

}
