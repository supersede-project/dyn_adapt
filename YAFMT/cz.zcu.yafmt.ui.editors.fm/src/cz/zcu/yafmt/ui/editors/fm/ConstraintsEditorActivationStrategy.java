package cz.zcu.yafmt.ui.editors.fm;

import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationEvent;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationStrategy;

public class ConstraintsEditorActivationStrategy extends ColumnViewerEditorActivationStrategy {

    public ConstraintsEditorActivationStrategy(ColumnViewer viewer) {
        super(viewer);
    }

    @Override
    protected boolean isEditorActivationEvent(ColumnViewerEditorActivationEvent event) {
        return event.eventType == ColumnViewerEditorActivationEvent.TRAVERSAL ||
                event.eventType == ColumnViewerEditorActivationEvent.MOUSE_DOUBLE_CLICK_SELECTION ||
                event.eventType == ColumnViewerEditorActivationEvent.PROGRAMMATIC;
    }

}
