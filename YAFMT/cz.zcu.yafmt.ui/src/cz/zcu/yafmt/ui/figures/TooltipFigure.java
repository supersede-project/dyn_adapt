package cz.zcu.yafmt.ui.figures;

import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.text.FlowPage;
import org.eclipse.draw2d.text.TextFlow;


public class TooltipFigure extends FlowPage {
    
    private static final int MAX_WIDTH = 300;
    
    private TextFlow message;
     
    public TooltipFigure() {
        this(null);
    }
    
    public TooltipFigure(String text) {
        setOpaque(true);
        setBorder(new MarginBorder(0, 2, 1, 0));
        add(createMessage(text));
    }
    
    private TextFlow createMessage(String text) {
        message = new TextFlow();
        message.setText(text);
        return message;
    }
    
    public void setText(String text) {
        message.setText(text);
        revalidate();
        repaint();
    }
     
    @Override
    public Dimension getPreferredSize(int wHint, int hHint) {
        Dimension size = super.getPreferredSize(-1, -1);
        if(size.width > MAX_WIDTH)
            size = super.getPreferredSize(MAX_WIDTH, -1);
        return size;
    }
    
}
