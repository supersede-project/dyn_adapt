package cz.zcu.yafmt.ui.directediting;

import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.editparts.ScalableRootEditPart;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ICellEditorListener;
import org.eclipse.jface.viewers.ICellEditorValidator;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.part.CellEditorActionHandler;

import cz.zcu.yafmt.model.provider.util.NonBlockingCellEditorValidatorWithMessage;

public class LabelDirectEditManager extends DirectEditManager {

    // Actions handling.
    private IActionBars actionBars;
    private IAction copy, cut, paste, undo, redo, find, selectAll, delete;
    private CellEditorActionHandler actionHandler;
    
    // Cell editor validation.
    private ICellEditorValidator errorMessageProvider;
    private ICellEditorListener nonBlockingValidator;

    // Properties.
    private int alignment;
    private int xOffset;
    private int yOffset;
    private Label label;
    private String text;
    
    // ==========================================================================================
    //  Construction
    // ==========================================================================================

    public LabelDirectEditManager(GraphicalEditPart source, Label label) {
        this(source, TextCellEditor.class, label, label.getText());
    }

    public LabelDirectEditManager(GraphicalEditPart source, Label label, String text) {
        this(source, TextCellEditor.class, label, text);
    }

    public LabelDirectEditManager(GraphicalEditPart source, Class<?> cellEditorClass, Label label) {
        this(source, cellEditorClass, label, label.getText());
    }

    public LabelDirectEditManager(GraphicalEditPart source, Class<?> cellEditorClass, Label label, String text) {
        super(source, cellEditorClass, new LabelCellEditorLocator());
        this.label = label;
        this.text = text;
        this.alignment = SWT.CENTER;
        this.xOffset = 0;
        this.yOffset = 0;
        ((LabelCellEditorLocator) getLocator()).init(this);
    }
    
    // ==========================================================================================
    //  Properties
    // ==========================================================================================

    public void setAlignment(int alignment) {
        this.alignment = alignment;
    }

    public void setXOffset(int xOffset) {
        this.xOffset = xOffset;
    }

    public void setYOffset(int yOffset) {
        this.yOffset = yOffset;
    }

    public void setErrorMessageProvider(ICellEditorValidator validator) {
        this.errorMessageProvider = validator;
    }
    
    // ==========================================================================================
    //  Initialization and finalization
    // ==========================================================================================

    private void restoreSavedActions() {
        actionBars.setGlobalActionHandler(ActionFactory.COPY.getId(), copy);
        actionBars.setGlobalActionHandler(ActionFactory.PASTE.getId(), paste);
        actionBars.setGlobalActionHandler(ActionFactory.DELETE.getId(), delete);
        actionBars.setGlobalActionHandler(ActionFactory.SELECT_ALL.getId(), selectAll);
        actionBars.setGlobalActionHandler(ActionFactory.CUT.getId(), cut);
        actionBars.setGlobalActionHandler(ActionFactory.FIND.getId(), find);
        actionBars.setGlobalActionHandler(ActionFactory.UNDO.getId(), undo);
        actionBars.setGlobalActionHandler(ActionFactory.REDO.getId(), redo);
    }

    private void saveCurrentActions() {
        copy = actionBars.getGlobalActionHandler(ActionFactory.COPY.getId());
        paste = actionBars.getGlobalActionHandler(ActionFactory.PASTE.getId());
        delete = actionBars.getGlobalActionHandler(ActionFactory.DELETE.getId());
        selectAll = actionBars.getGlobalActionHandler(ActionFactory.SELECT_ALL.getId());
        cut = actionBars.getGlobalActionHandler(ActionFactory.CUT.getId());
        find = actionBars.getGlobalActionHandler(ActionFactory.FIND.getId());
        undo = actionBars.getGlobalActionHandler(ActionFactory.UNDO.getId());
        redo = actionBars.getGlobalActionHandler(ActionFactory.REDO.getId());
    }
    
    private ICellEditorListener createNonBlockingValidator() {
        nonBlockingValidator = new NonBlockingCellEditorValidatorWithMessage(getCellEditor()) {
            @Override
            protected String getErrorMessage(Object value) {
                return errorMessageProvider.isValid(value);
            }
        };
        return nonBlockingValidator;
    }
    
    @Override
    protected void initCellEditor() {
        // Initialize cell editor value from label.
        getCellEditor().setValue(text);

        // Attache validator.
        if(errorMessageProvider != null)
            getCellEditor().addListener(createNonBlockingValidator());

        // This captures and processes all keyboard shortcuts like ctrl+c, ctrl+a inside the cell editor.
        actionBars = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor().getEditorSite().getActionBars();
        saveCurrentActions(); // We have to remember state to restore, because CellEditorActionHandler won't do that.
        actionHandler = new CellEditorActionHandler(actionBars);
        actionHandler.addCellEditor(getCellEditor());
        // actionBars.updateActionBars(); <-- causes problems for delete action in toolbar.
    }
        
    @Override
    protected void eraseFeedback() {
        // We must call this manually now, otherwise it is caused only after the cell editor is disposed (which has no effect).
        if(nonBlockingValidator != null)
            nonBlockingValidator.applyEditorValue();
        super.eraseFeedback();
    }

    @Override
    protected void bringDown() {
        if((getCellEditor() != null) && (nonBlockingValidator != null)) {
            getCellEditor().removeListener(nonBlockingValidator);
            nonBlockingValidator = null;
        }
        if(actionHandler != null) {
            actionHandler.dispose();
            actionHandler = null;
        }
        if(actionBars != null) {
            restoreSavedActions();
            actionBars.updateActionBars();
            actionBars = null;
        }
        super.bringDown();
    }

    // ==========================================================================================
    //  Helpers
    // ==========================================================================================
    
    protected Point computePreferredSize(CellEditor cellEditor) {
        Control control = cellEditor.getControl();
        Point preferedSize = control.computeSize(SWT.DEFAULT, SWT.DEFAULT);
        if((control instanceof Text) && ((Text) control).getText().isEmpty())
            preferedSize.x = 4;
        return preferedSize;
    }

    private ZoomManager getZoomManager() {
        EditPart rootEditPart = getEditPart().getRoot();
        if(rootEditPart instanceof ScalableRootEditPart)
            return ((ScalableRootEditPart) rootEditPart).getZoomManager();
        if(rootEditPart instanceof ScalableFreeformRootEditPart)
            return ((ScalableFreeformRootEditPart) rootEditPart).getZoomManager();
        return null;
    }

    protected double getScale() {
        ZoomManager zoomManager = getZoomManager();
        return (zoomManager != null) ? zoomManager.getZoom() : 1.0;
    }
    
    // ==========================================================================================
    //  Direct editing cell locator
    // ==========================================================================================

    // Locates where to place cell editor during direct editing.
    private static class LabelCellEditorLocator implements CellEditorLocator {

        private LabelDirectEditManager editManager;

        public void init(LabelDirectEditManager editManager) {
            this.editManager = editManager;
        }

        @Override
        public void relocate(CellEditor cellEditor) {
            Point preferredSize = editManager.computePreferredSize(cellEditor);
            double scale = editManager.getScale();
            int alignment = editManager.alignment;
            int xOffset = (int) (scale * editManager.xOffset);
            int yOffset = (int) (scale * editManager.yOffset);
            Label label = editManager.label;

            Rectangle bounds = label.getTextBounds().getCopy();
            label.translateToAbsolute(bounds);

            if((alignment & SWT.LEFT) != 0)
                bounds.x += xOffset - 2;
            else if((alignment & SWT.RIGHT) != 0)
                bounds.x += xOffset + bounds.width - preferredSize.x;
            else
                bounds.x += xOffset + (bounds.width - preferredSize.x) / 2;

            if((alignment & SWT.TOP) != 0)
                bounds.y += yOffset;
            else if((alignment & SWT.BOTTOM) != 0)
                bounds.y += yOffset + bounds.height - preferredSize.y;
            else
                bounds.y += yOffset + (bounds.height - preferredSize.y) / 2;

            bounds.width = preferredSize.x + 6; // Extra 4 space for Windows. 
            bounds.height = preferredSize.y;

            cellEditor.getControl().setBounds(bounds.x, bounds.y, bounds.width, bounds.height);
        }

    }

}
