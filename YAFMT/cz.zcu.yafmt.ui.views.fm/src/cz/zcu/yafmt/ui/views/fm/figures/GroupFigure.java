package cz.zcu.yafmt.ui.views.fm.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.swt.SWT;

import cz.zcu.yafmt.model.fm.Group;
import cz.zcu.yafmt.model.fm.util.FeatureModelUtil;
import cz.zcu.yafmt.ui.util.DrawUtil;

public class GroupFigure extends NodeFigure {

    public GroupFigure(Group group) {
        setFont(DrawUtil.ITALIC_FONT);
        setBackgroundColor(ColorConstants.white);
        setForegroundColor(DrawUtil.GROUP_COLOR);
        setHightlightColor(DrawUtil.GROUP_LIGHTER_COLOR);
        setBorderStyle(SWT.LINE_CUSTOM);
        setBorderDash(DrawUtil.LINE_DASHED);
        setText(FeatureModelUtil.getTranslatedCardinality(group) + " Group");
        setToolTipText(createToolTipText(group));
    }
    
    private String createToolTipText(Group group) {
        String name = FeatureModelUtil.getTranslatedCardinality(group) + " Group.";
        String description = group.getDescription();
        if((description != null) && !description.isEmpty())
            return name + " " + description;
        else
            return name;
    }

}
