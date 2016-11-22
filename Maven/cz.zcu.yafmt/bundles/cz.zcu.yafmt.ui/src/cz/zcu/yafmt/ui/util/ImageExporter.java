package cz.zcu.yafmt.ui.util;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Layer;
import org.eclipse.draw2d.SWTGraphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Drawable;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;

// Original code from from http://www.eclipse.org/forums/index.php/t/64088/
public class ImageExporter {

    public static final int[] SUPPORTED_FORMATS = { SWT.IMAGE_PNG, SWT.IMAGE_JPEG, SWT.IMAGE_BMP };
    public static final String[] FORMAT_EXTENSIONS = { "*.png", "*.jpeg", "*.bmp", };
    private static final int IMAGE_BORDER_SIZE = 10;

    public static void save(Drawable component, IFigure figure, String filePath, int format) {        
        Rectangle boundingBox = getBoundingBox(figure);
        if(boundingBox == null)
            return;
        
        boundingBox.expand(IMAGE_BORDER_SIZE, IMAGE_BORDER_SIZE);
        Image image = new Image(null, boundingBox.width, boundingBox.height);
        GC figureGC = new GC(component);
        GC imageGC = new GC(image);

        imageGC.setBackground(figureGC.getBackground());
        imageGC.setForeground(figureGC.getForeground());
        imageGC.setFont(figureGC.getFont());
        imageGC.setLineStyle(figureGC.getLineStyle());
        imageGC.setLineWidth(figureGC.getLineWidth());
        //imageGC.setXORMode(figureCanvasGC.getXORMode());

        Graphics imageGraphics = new SWTGraphics(imageGC);
        imageGraphics.translate(-boundingBox.x, -boundingBox.y);
        figure.paint(imageGraphics);

        ImageLoader imageLoader = new ImageLoader();
        imageLoader.data = new ImageData[] { image.getImageData() };
        imageLoader.save(filePath, format);

        figureGC.dispose();
        imageGC.dispose();
        image.dispose();
    }

    private static Rectangle getBoundingBox(IFigure figure) {
        Rectangle boundingBox = null;

        for(Object child: figure.getChildren()) {
            Rectangle bounds;
            if(child instanceof Layer)
                bounds = getBoundingBox((IFigure) child);
            else
                bounds = ((IFigure) child).getBounds().getCopy();

            if(boundingBox != null)
                boundingBox.union(bounds);
            else
                boundingBox = bounds;
        }
        
        return boundingBox;
    }

}
