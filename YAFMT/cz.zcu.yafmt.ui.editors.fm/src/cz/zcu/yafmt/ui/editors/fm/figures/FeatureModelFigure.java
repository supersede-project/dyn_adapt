package cz.zcu.yafmt.ui.editors.fm.figures;

import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.swt.SWT;

public class FeatureModelFigure extends FreeformLayer {

    public FeatureModelFigure() {
        setBorder(new MarginBorder(3));
        setLayoutManager(new FreeformLayout());
    }

    @Override
    public void paint(Graphics graphics) {
        // Enable antialiasing.
        // Antialiasing for connection layer is enabled in FeatureModelEditPart.refreshVisuals().
        graphics.setAntialias(SWT.ON);
        graphics.setTextAntialias(SWT.ON);
        super.paint(graphics);
    }

}
