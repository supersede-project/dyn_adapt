package cz.zcu.yafmt.ui.figures;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.ToolbarLayout;

public class VerticalToolbarFigure extends Figure {
    
    public VerticalToolbarFigure() {
        this(2);
    }
    
    public VerticalToolbarFigure(int border) {
        setLayoutManager(createLayout(border));
        setBorder(new MarginBorder(border, border, 0, border));
    }

    private ToolbarLayout createLayout(int border) {
        ToolbarLayout layout = new ToolbarLayout(false);
        layout.setMinorAlignment(ToolbarLayout.ALIGN_TOPLEFT);
        layout.setSpacing(border);
        return layout;
    }

}
