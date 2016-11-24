package cz.zcu.yafmt.ui.views.fm.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.swt.SWT;

import cz.zcu.yafmt.model.fm.Constraint;
import cz.zcu.yafmt.ui.util.DrawUtil;

public class ConstraintFigure extends NodeFigure {

    public ConstraintFigure(Constraint constraint) {
        setFont(DrawUtil.ITALIC_FONT);
        setBackgroundColor(ColorConstants.white);
        setForegroundColor(DrawUtil.CONSTRAINT_COLOR);
        setHightlightColor(DrawUtil.CONSTRAINT_LIGHTER_COLOR);
        setBorderStyle(SWT.LINE_CUSTOM);
        setBorderDash(DrawUtil.LINE_DASHED);
        setText(constraint.getValue());
        setToolTipText(constraint.getDescription());
    }

}
