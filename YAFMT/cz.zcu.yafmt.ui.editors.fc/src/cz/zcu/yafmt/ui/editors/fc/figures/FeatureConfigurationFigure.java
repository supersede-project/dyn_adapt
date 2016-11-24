package cz.zcu.yafmt.ui.editors.fc.figures;

import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.swt.SWT;

public class FeatureConfigurationFigure extends FreeformLayer {

    public FeatureConfigurationFigure() {
        setBorder(new MarginBorder(3));
        setLayoutManager(new FreeformLayout());
    }
    
    @Override
    public void paint(Graphics graphics) {
        // Enable antialiasing.
        // Antialiasing for connection layer is enabled in FeatureConfigurationEditPart.refreshVisuals().
        graphics.setAntialias(SWT.ON);
        graphics.setTextAntialias(SWT.ON);
        super.paint(graphics);
    }
}
