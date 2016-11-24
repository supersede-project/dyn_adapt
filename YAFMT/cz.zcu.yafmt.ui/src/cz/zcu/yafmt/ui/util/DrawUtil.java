package cz.zcu.yafmt.ui.util;

import org.eclipse.draw2d.Graphics;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Display;

public class DrawUtil {

    public static final Font DEFAULT_FONT = getDefaultFont();
    public static final Font BOLD_FONT = getModifiedFont(DEFAULT_FONT, SWT.DEFAULT, SWT.BOLD);
    public static final Font ITALIC_FONT = getModifiedFont(DEFAULT_FONT, SWT.DEFAULT, SWT.ITALIC);
    public static final Font SMALL_FONT = getModifiedFont(DEFAULT_FONT, 7, SWT.DEFAULT);
    public static final Font TINY_FONT = getModifiedFont(DEFAULT_FONT, 6, SWT.DEFAULT);
    
    public static final Color DARK_RED_COLOR = getColor(128, 0, 0);
    public static final Color FEATURE_GRADIENT_COLOR = getColor(175, 201, 235);
    public static final Color FEATURE_COLOR = getColor(0, 0, 127);
    public static final Color FEATURE_LIGHTER_COLOR = getColor(128, 128, 255);
    public static final Color CONSTRAINT_COLOR = getColor(91, 36, 120);
    public static final Color CONSTRAINT_LIGHTER_COLOR = getColor(215, 195, 225);
    public static final Color CONSTRAINT_DARKER_COLOR = getColor(38, 14, 51);
    public static final Color GROUP_COLOR = getColor(36, 120, 113);
    public static final Color GROUP_LIGHTER_COLOR = getColor(204, 229, 227);

    public static final float[] LINE_DASHED = { 2.0f, 2.0f };
    public static final float[] LINE_DOTTED = { 1.0f, 2.0f };

    public static void dispose() {
        BOLD_FONT.dispose();
        ITALIC_FONT.dispose();
        SMALL_FONT.dispose();
        TINY_FONT.dispose();
                
        DARK_RED_COLOR.dispose();
        FEATURE_GRADIENT_COLOR.dispose();
        FEATURE_COLOR.dispose();
        FEATURE_LIGHTER_COLOR.dispose();
        CONSTRAINT_COLOR.dispose();
        CONSTRAINT_LIGHTER_COLOR.dispose();
        CONSTRAINT_DARKER_COLOR.dispose();
        GROUP_COLOR.dispose();
        GROUP_LIGHTER_COLOR.dispose();
    }

    public static Font getDefaultFont() {
        return Display.getDefault().getSystemFont();
    }

    public static Font getModifiedFont(Font originalFont, int height, int style) {
        FontData[] fontData = originalFont.getFontData();
        for(FontData data: fontData) {
            if(height != SWT.DEFAULT)
                data.setHeight(height);
            if(style != SWT.DEFAULT)
                data.setStyle(style);
        }
        return new Font(Display.getDefault(), fontData);
    }

    public static Color getColor(int r, int g, int b) {
        return new Color(Display.getDefault(), r, g, b);
    }

    public static Color getModifiedColor(Color color, float change) {
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();

        r += (int) (255 * change);
        g += (int) (255 * change);
        b += (int) (255 * change);

        r = (r > 255) ? 255 : ((r < 0) ? 0 : r);
        g = (g > 255) ? 255 : ((g < 0) ? 0 : r);
        b = (b > 255) ? 255 : ((b < 0) ? 0 : r);

        return getColor(r, g, b);
    }
    
    public static float[] getScaledDash(float[] dash, Graphics graphics) {
        float scale = (float) graphics.getAbsoluteScale();
        float[] scaledDash = new float[dash.length];
        
        for(int i = 0; i < scaledDash.length; i++)
            scaledDash[i] = scale * dash[i];
        
        return scaledDash;
    }
    
    public static int getScaledLineWidth(int width, Graphics graphics) {
        return (int) Math.max(1.0, width * graphics.getAbsoluteScale());
    }

    public static void fixScaledFigureLocation(Graphics graphics) {
        double scale = graphics.getAbsoluteScale(); 
        if(scale >= 2.0)
            graphics.translate(0.5f, 0.5f);
        else if(scale >= 1.5)
            graphics.translate(0.25f, 0.25f);
    }

}
