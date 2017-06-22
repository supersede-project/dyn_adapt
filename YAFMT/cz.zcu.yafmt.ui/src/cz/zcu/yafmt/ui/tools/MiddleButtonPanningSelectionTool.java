package cz.zcu.yafmt.ui.tools;

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.SharedCursors;
import org.eclipse.gef.tools.PanningSelectionTool;
import org.eclipse.swt.graphics.Cursor;

// Adds support for dragging viewport with middle mouse button.
public class MiddleButtonPanningSelectionTool extends PanningSelectionTool {

    private static final int MIDDLE_MOUSE_BUTTON = 2;
    
    private boolean dragInProgress = false;    
    private Point viewStartLocation;
    
    private Viewport getViewport() {
        return ((FigureCanvas) getCurrentViewer().getControl()).getViewport();
    }
    
    protected Cursor getDefaultCursor() {
        // Replace default panning cursor (HAND).
        if(isInState(PAN | PAN_IN_PROGRESS))
            return SharedCursors.SIZEALL;
        return super.getDefaultCursor();
    }
    
    @Override
    protected boolean handleButtonDown(int button) {
        if(button == MIDDLE_MOUSE_BUTTON) {
            setCursor(SharedCursors.SIZEALL);
            viewStartLocation = getViewport().getViewLocation();
            dragInProgress = true;
            return true;
        }
        else {
            return super.handleButtonDown(button);
        }
    }
    
    @Override
    protected boolean handleButtonUp(int button) {
        if(button == MIDDLE_MOUSE_BUTTON) {
            setCursor(getDefaultCursor());
            dragInProgress = false;
            return true;
        }
        else {
            return super.handleButtonUp(button);
        }
    }
    
    @Override
    protected boolean handleDrag() {
        if(dragInProgress) {
            Dimension moveDelta = getDragMoveDelta().getNegated();
            getViewport().setViewLocation(viewStartLocation.getTranslated(moveDelta));
            return true;
        }
        else {
            return super.handleDrag();
        }
    }
    
}
