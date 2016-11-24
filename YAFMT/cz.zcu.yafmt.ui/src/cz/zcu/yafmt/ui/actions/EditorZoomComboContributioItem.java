package cz.zcu.yafmt.ui.actions;

import java.util.Arrays;

import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gef.ui.actions.ActionBarContributor;
import org.eclipse.gef.ui.actions.ZoomComboContributionItem;
import org.eclipse.swt.widgets.Control;


public class EditorZoomComboContributioItem extends ZoomComboContributionItem {
    
    private static final String[] ZOOM_LEVELS = { ZoomManager.FIT_ALL, ZoomManager.FIT_HEIGHT, ZoomManager.FIT_WIDTH };    
    private static final int DEFAULT_WIDTH = 80;
    
    public static void contributeZoomLevels(ZoomManager zoomManager) {
        zoomManager.setZoomLevelContributions(Arrays.asList(ZOOM_LEVELS));
    }
    
    private int width;
    
    public EditorZoomComboContributioItem(ActionBarContributor contributor, int width) {
        super(contributor.getPage(), ZOOM_LEVELS);
        this.width = width;
    }

    public EditorZoomComboContributioItem(ActionBarContributor contributor) {
        this(contributor, DEFAULT_WIDTH);
    }
    
    @Override
    protected int computeWidth(Control control) {
        return width;
    }
    
}
