package cz.zcu.yafmt.ui.editors.fc.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.swt.graphics.Color;

import cz.zcu.yafmt.ui.figures.CircleDecoration;

public class ConnectionFigure extends PolylineConnection {

    public ConnectionFigure() {
        setForegroundColor(ColorConstants.black);
        setSourceDecoration(new CircleDecoration(true));
    }

    public void setGrayed(boolean grayed) {
        CircleDecoration decoration = (CircleDecoration) getSourceDecoration();
        Color color = grayed ? ColorConstants.lightGray : ColorConstants.black;
        setForegroundColor(color);
        decoration.setForegroundColor(color);
        decoration.setFilled(!grayed);
    }
    
}
