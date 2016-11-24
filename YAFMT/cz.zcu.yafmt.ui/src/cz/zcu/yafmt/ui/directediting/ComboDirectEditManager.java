package cz.zcu.yafmt.ui.directediting;

import org.eclipse.draw2d.Label;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.graphics.Point;

public class ComboDirectEditManager extends LabelDirectEditManager {

    private Object value;

    public ComboDirectEditManager(GraphicalEditPart source, Class<?> cellEditorType, Label label, Object value) {
        super(source, cellEditorType, label);
        this.value = value;
    }

    @Override
    protected void initCellEditor() {
        getCellEditor().setValue(value);
    }

    @Override
    protected Point computePreferredSize(CellEditor cellEditor) {
        Point preferredSize = super.computePreferredSize(cellEditor);
        int maxHeight = 9 + (int) cellEditor.getControl().getFont().getFontData()[0].height;
        preferredSize.y = Math.min(preferredSize.y, maxHeight);
        return preferredSize;
    }
    
    @Override
    protected void commit() {
        // Cell editor does not notify direct edit manager about value change.
        // Do it manually.
        if(!value.equals(getCellEditor().getValue()))
            setDirty(true);
        super.commit();
    }

}
