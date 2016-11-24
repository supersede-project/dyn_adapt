package cz.zcu.yafmt.ui.editors.fm.commands;

import org.eclipse.draw2d.geometry.Rectangle;

import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.Group;
import cz.zcu.yafmt.ui.commands.RecordingCommand;
import cz.zcu.yafmt.ui.editors.fm.layout.LayoutData;

public class DeleteGroupCommand extends RecordingCommand {

    private LayoutData layoutData;
    private Group group;
    private Rectangle bounds;

    public DeleteGroupCommand(Group group, LayoutData layoutData) {
        setLabel("Delete Group");
        this.layoutData = layoutData;
        this.group = group;
        this.bounds = layoutData.get(group);
    }

    @Override
    protected void initializeRecording() {
        addRecordedObject(group);
        addRecordedObject(group.getParent());
    }

    @Override
    protected void performRecording() {
        Feature parent = group.getParent();
        if(parent != null) {
            group.getParent().getFeatures().addAll(group.getFeatures());
            group.setParent(null);
        }
    }

    @Override
    public void execute() {
        super.execute();
        layoutData.remove(group);
    }

    @Override
    public void redo() {
        super.redo();
        layoutData.remove(group);
    }

    @Override
    public void undo() {
        layoutData.set(group, bounds);
        super.undo();
    }

}
