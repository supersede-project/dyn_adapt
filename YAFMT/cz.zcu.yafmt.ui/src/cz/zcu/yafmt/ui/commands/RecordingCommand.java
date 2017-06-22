package cz.zcu.yafmt.ui.commands;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.ChangeCommand;
import org.eclipse.gef.commands.Command;

import cz.zcu.yafmt.model.fm.Group;

public abstract class RecordingCommand extends Command {

    private Collection<Notifier> recordedObjects = new HashSet<Notifier>();
    private InnerCommand innerCommand;

    protected void addRecordedObject(Notifier object) {
        if(object != null)
            recordedObjects.add(object);
    }

    protected void addRecordedObjects(Collection<? extends Notifier> objects) {
        if(objects != null)
            recordedObjects.addAll(objects);
    }

    protected void addRecordedObjectParent(EObject object) {
        if(object == null)
            return;

        EObject parent = object.eContainer();
        addRecordedObject(parent);

        if(parent instanceof Group)
            addRecordedObject(parent.eContainer());
    }

    protected abstract void initializeRecording();

    protected abstract void performRecording();

    @Override
    public void execute() {
        initializeRecording();
        innerCommand = new InnerCommand(recordedObjects);
        innerCommand.execute();
    }

    @Override
    public void redo() {
        innerCommand.redo();
    }

    @Override
    public void undo() {
        innerCommand.undo();
    }

    private class InnerCommand extends ChangeCommand {

        public InnerCommand(Collection<Notifier> recordedObjects) {
            super(recordedObjects);
        }

        @Override
        protected void doExecute() {
            RecordingCommand.this.performRecording();
        }

    }

}
