package cz.zcu.yafmt.ui.figures;

import java.beans.PropertyChangeListener;
import java.util.Collection;
import java.util.List;

import org.eclipse.draw2d.AncestorListener;
import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.CoordinateListener;
import org.eclipse.draw2d.EventDispatcher;
import org.eclipse.draw2d.FigureListener;
import org.eclipse.draw2d.FocusEvent;
import org.eclipse.draw2d.FocusListener;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IClippingStrategy;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.KeyEvent;
import org.eclipse.draw2d.KeyListener;
import org.eclipse.draw2d.LayoutListener;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.draw2d.TreeSearch;
import org.eclipse.draw2d.UpdateManager;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.geometry.Translatable;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Font;


public class FigureDecorator implements IFigure {

    protected IFigure sourceFigure;
    
    public FigureDecorator(IFigure sourceFigure) {
        this.sourceFigure = sourceFigure;
    }

    @Override
    public void add(IFigure figure) {
        sourceFigure.add(figure);
    }

    @Override
    public void add(IFigure figure, int index) {
        sourceFigure.add(figure, index);
    }

    @Override
    public void add(IFigure figure, Object constraint) {
        sourceFigure.add(figure, constraint);
    }

    @Override
    public void add(IFigure figure, Object constraint, int index) {
        sourceFigure.add(figure, constraint, index);
    }

    @Override
    public void addAncestorListener(AncestorListener listener) {
        sourceFigure.addAncestorListener(listener);
    }

    @Override
    public void addCoordinateListener(CoordinateListener listener) {
        sourceFigure.addCoordinateListener(listener);
    }

    @Override
    public void addFigureListener(FigureListener listener) {
        sourceFigure.addFigureListener(listener);
    }

    @Override
    public void addFocusListener(FocusListener listener) {
        sourceFigure.addFocusListener(listener);
    }

    @Override
    public void addKeyListener(KeyListener listener) {
        sourceFigure.addKeyListener(listener);
    }

    @Override
    public void addLayoutListener(LayoutListener listener) {
        sourceFigure.addLayoutListener(listener);
    }

    @Override
    public void addMouseListener(MouseListener listener) {
        sourceFigure.addMouseListener(listener);
    }

    @Override
    public void addMouseMotionListener(MouseMotionListener listener) {
        sourceFigure.addMouseMotionListener(listener);
    }

    @Override
    public void addNotify() {
        sourceFigure.addNotify();
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        sourceFigure.addPropertyChangeListener(listener);
    }

    @Override
    public void addPropertyChangeListener(String property, PropertyChangeListener listener) {
        sourceFigure.addPropertyChangeListener(property, listener);
    }

    @Override
    public boolean containsPoint(int x, int y) {
        return sourceFigure.containsPoint(x, y);
    }

    @Override
    public boolean containsPoint(Point p) {
        return sourceFigure.containsPoint(p);
    }

    @Override
    public void erase() {
        sourceFigure.erase();
    }

    @Override
    public IFigure findFigureAt(int x, int y) {
        return sourceFigure.findFigureAt(x, y);
    }

    @Override
    public IFigure findFigureAt(int x, int y, TreeSearch search) {
        return sourceFigure.findFigureAt(x, y, search);
    }

    @Override
    public IFigure findFigureAt(Point p) {
        return sourceFigure.findFigureAt(p);
    }

    @Override
    @SuppressWarnings("rawtypes")
    public IFigure findFigureAtExcluding(int x, int y, Collection collection) {
        return sourceFigure.findFigureAtExcluding(x, y, collection);
    }

    @Override
    public IFigure findMouseEventTargetAt(int x, int y) {
        return sourceFigure.findMouseEventTargetAt(x, y);
    }

    @Override
    public Color getBackgroundColor() {
        return sourceFigure.getBackgroundColor();
    }

    @Override
    public Border getBorder() {
        return sourceFigure.getBorder();
    }

    @Override
    public Rectangle getBounds() {
        return sourceFigure.getBounds();
    }

    @Override
    @SuppressWarnings("rawtypes")
    public List getChildren() {
        return sourceFigure.getChildren();
    }

    @Override
    public Rectangle getClientArea() {
        return sourceFigure.getClientArea();
    }

    @Override
    public Rectangle getClientArea(Rectangle rect) {
        return sourceFigure.getClientArea(rect);
    }

    @Override
    public IClippingStrategy getClippingStrategy() {
        return sourceFigure.getClippingStrategy();
    }

    @Override
    public Cursor getCursor() {
        return sourceFigure.getCursor();
    }

    @Override
    public Font getFont() {
        return sourceFigure.getFont();
    }

    @Override
    public Color getForegroundColor() {
        return sourceFigure.getForegroundColor();
    }

    @Override
    public Insets getInsets() {
        return sourceFigure.getInsets();
    }

    @Override
    public LayoutManager getLayoutManager() {
        return sourceFigure.getLayoutManager();
    }

    @Override
    public Color getLocalBackgroundColor() {
        return sourceFigure.getLocalBackgroundColor();
    }

    @Override
    public Color getLocalForegroundColor() {
        return sourceFigure.getLocalForegroundColor();
    }

    @Override
    public Dimension getMaximumSize() {
        return sourceFigure.getMaximumSize();
    }

    @Override
    public Dimension getMinimumSize() {
        return sourceFigure.getMinimumSize();
    }

    @Override
    public Dimension getMinimumSize(int wHint, int hHint) {
        return sourceFigure.getMinimumSize(wHint, hHint);
    }

    @Override
    public IFigure getParent() {
        return sourceFigure.getParent();
    }

    @Override
    public Dimension getPreferredSize() {
        return sourceFigure.getPreferredSize();
    }

    @Override
    public Dimension getPreferredSize(int wHint, int hHint) {
        return sourceFigure.getPreferredSize(wHint, hHint);
    }

    @Override
    public Dimension getSize() {
        return sourceFigure.getSize();
    }

    @Override
    public IFigure getToolTip() {
        return sourceFigure.getToolTip();
    }

    @Override
    public UpdateManager getUpdateManager() {
        return sourceFigure.getUpdateManager();
    }

    @Override
    public void handleFocusGained(FocusEvent event) {
        sourceFigure.handleFocusGained(event);
    }

    @Override
    public void handleFocusLost(FocusEvent event) {
        sourceFigure.handleFocusLost(event);
    }

    @Override
    public void handleKeyPressed(KeyEvent event) {
        sourceFigure.handleKeyPressed(event);
    }

    @Override
    public void handleKeyReleased(KeyEvent event) {
        sourceFigure.handleKeyReleased(event);
    }

    @Override
    public void handleMouseDoubleClicked(MouseEvent event) {
        sourceFigure.handleMouseDoubleClicked(event);
    }

    @Override
    public void handleMouseDragged(MouseEvent event) {
        sourceFigure.handleMouseDragged(event);
    }

    @Override
    public void handleMouseEntered(MouseEvent event) {
        sourceFigure.handleMouseEntered(event);
    }

    @Override
    public void handleMouseExited(MouseEvent event) {
        sourceFigure.handleMouseExited(event);
    }

    @Override
    public void handleMouseHover(MouseEvent event) {
        sourceFigure.handleMouseHover(event);
    }

    @Override
    public void handleMouseMoved(MouseEvent event) {
        sourceFigure.handleMouseMoved(event);
    }

    @Override
    public void handleMousePressed(MouseEvent event) {
        sourceFigure.handleMousePressed(event);
    }

    @Override
    public void handleMouseReleased(MouseEvent event) {
        sourceFigure.handleMouseReleased(event);
    }

    @Override
    public boolean hasFocus() {
        return sourceFigure.hasFocus();
    }

    @Override
    public EventDispatcher internalGetEventDispatcher() {
        return sourceFigure.internalGetEventDispatcher();
    }

    @Override
    public boolean intersects(Rectangle rect) {
        return sourceFigure.intersects(rect);
    }

    @Override
    public void invalidate() {
        sourceFigure.invalidate();
    }

    @Override
    public void invalidateTree() {
        sourceFigure.invalidateTree();
    }

    @Override
    public boolean isCoordinateSystem() {
        return sourceFigure.isCoordinateSystem();
    }

    @Override
    public boolean isEnabled() {
        return sourceFigure.isEnabled();
    }

    @Override
    public boolean isFocusTraversable() {
        return sourceFigure.isFocusTraversable();
    }

    @Override
    public boolean isMirrored() {
        return sourceFigure.isMirrored();
    }

    @Override
    public boolean isOpaque() {
        return sourceFigure.isOpaque();
    }

    @Override
    public boolean isRequestFocusEnabled() {
        return sourceFigure.isRequestFocusEnabled();
    }

    @Override
    public boolean isShowing() {
        return sourceFigure.isShowing();
    }

    @Override
    public boolean isVisible() {
        return sourceFigure.isVisible();
    }

    @Override
    public void paint(Graphics graphics) {
        sourceFigure.paint(graphics);
    }

    @Override
    public void remove(IFigure figure) {
        sourceFigure.remove(figure);
    }

    @Override
    public void removeAncestorListener(AncestorListener listener) {
        sourceFigure.removeAncestorListener(listener);
    }

    @Override
    public void removeCoordinateListener(CoordinateListener listener) {
        sourceFigure.removeCoordinateListener(listener);
    }

    @Override
    public void removeFigureListener(FigureListener listener) {
        sourceFigure.removeFigureListener(listener);
    }

    @Override
    public void removeFocusListener(FocusListener listener) {
        sourceFigure.removeFocusListener(listener);
    }

    @Override
    public void removeKeyListener(KeyListener listener) {
        sourceFigure.removeKeyListener(listener);
    }

    @Override
    public void removeLayoutListener(LayoutListener listener) {
        sourceFigure.removeLayoutListener(listener);
    }

    @Override
    public void removeMouseListener(MouseListener listener) {
        sourceFigure.removeMouseListener(listener);
    }

    @Override
    public void removeMouseMotionListener(MouseMotionListener listener) {
        sourceFigure.removeMouseMotionListener(listener);
    }

    @Override
    public void removeNotify() {
        sourceFigure.removeNotify();
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        sourceFigure.removePropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(String property, PropertyChangeListener listener) {
        sourceFigure.removePropertyChangeListener(property, listener);
    }

    @Override
    public void repaint() {
        sourceFigure.repaint();
    }

    @Override
    public void repaint(int x, int y, int w, int h) {
        sourceFigure.repaint(x, y, w, h);
    }

    @Override
    public void repaint(Rectangle rect) {
        sourceFigure.repaint(rect);
    }

    @Override
    public void requestFocus() {
        sourceFigure.requestFocus();
    }

    @Override
    public void revalidate() {
        sourceFigure.revalidate();
    }

    @Override
    public void setBackgroundColor(Color c) {
        sourceFigure.setBackgroundColor(c);
    }

    @Override
    public void setBorder(Border b) {
        sourceFigure.setBorder(b);
    }

    @Override
    public void setBounds(Rectangle rect) {
        sourceFigure.setBounds(rect);
    }

    @Override
    public void setClippingStrategy(IClippingStrategy clippingStrategy) {
        sourceFigure.setClippingStrategy(clippingStrategy);
    }

    @Override
    public void setConstraint(IFigure child, Object constraint) {
        sourceFigure.setConstraint(child, constraint);
    }

    @Override
    public void setCursor(Cursor cursor) {
        sourceFigure.setCursor(cursor);
    }

    @Override
    public void setEnabled(boolean value) {
        sourceFigure.setEnabled(value);
    }

    @Override
    public void setFocusTraversable(boolean value) {
        sourceFigure.setFocusTraversable(value);
    }

    @Override
    public void setFont(Font f) {
        sourceFigure.setFont(f);
    }

    @Override
    public void setForegroundColor(Color c) {
        sourceFigure.setForegroundColor(c);
    }

    @Override
    public void setLayoutManager(LayoutManager lm) {
        sourceFigure.setLayoutManager(lm);
    }

    @Override
    public void setLocation(Point p) {
        sourceFigure.setLocation(p);
    }

    @Override
    public void setMaximumSize(Dimension size) {
        sourceFigure.setMaximumSize(size);
    }

    @Override
    public void setMinimumSize(Dimension size) {
        sourceFigure.setMinimumSize(size);
    }

    @Override
    public void setOpaque(boolean isOpaque) {
        sourceFigure.setOpaque(isOpaque);
    }

    @Override
    public void setParent(IFigure parent) {
        sourceFigure.setParent(parent);
    }

    @Override
    public void setPreferredSize(Dimension size) {
        sourceFigure.setPreferredSize(size);
    }

    @Override
    public void setRequestFocusEnabled(boolean requestFocusEnabled) {
        sourceFigure.setRequestFocusEnabled(requestFocusEnabled);
    }

    @Override
    public void setSize(Dimension d) {
        sourceFigure.setSize(d);
    }

    @Override
    public void setSize(int w, int h) {
        sourceFigure.setSize(w, h);
    }

    @Override
    public void setToolTip(IFigure figure) {
        sourceFigure.setToolTip(figure);
    }

    @Override
    public void setVisible(boolean visible) {
        sourceFigure.setVisible(visible);
    }

    @Override
    public void translate(int x, int y) {
        sourceFigure.translate(x, y);
    }

    @Override
    public void translateFromParent(Translatable t) {
        sourceFigure.translateFromParent(t);
    }

    @Override
    public void translateToAbsolute(Translatable t) {
        sourceFigure.translateToAbsolute(t);
    }

    @Override
    public void translateToParent(Translatable t) {
        sourceFigure.translateToParent(t);
    }

    @Override
    public void translateToRelative(Translatable t) {
        sourceFigure.translateToRelative(t);
    }

    @Override
    public void validate() {
        sourceFigure.validate();
    }

}
