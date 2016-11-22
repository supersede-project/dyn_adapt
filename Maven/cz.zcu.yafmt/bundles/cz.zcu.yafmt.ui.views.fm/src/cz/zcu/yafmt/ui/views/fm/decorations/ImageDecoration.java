package cz.zcu.yafmt.ui.views.fm.decorations;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.swt.graphics.Image;

public abstract class ImageDecoration extends ImageFigure implements IDecoration {

    private int alpha = 255;

    public ImageDecoration(Image image) {
        super(image);
        setSize(12, 12);
    }

    // ===============================================================
    //  Basic properties
    // ===============================================================
    
    @Override
    public void setAlpha(int alpha) {
        if(this.alpha != alpha) {
            this.alpha = alpha;
            repaint();
        }
    }

    @Override
    public Integer getAlpha() {
        return alpha;
    }
    
    // ===============================================================
    //  Decoration properties
    // ===============================================================
    
    @Override
    public boolean isAutoPositioned() {
        return false;
    }

    @Override
    public boolean isOnTop() {
        return true;
    }
    
    // ===============================================================
    //  Drawing
    // ===============================================================
    
    @Override
    public void paint(Graphics graphics) {
        graphics.setAlpha(alpha);
        super.paint(graphics);
    }

}
