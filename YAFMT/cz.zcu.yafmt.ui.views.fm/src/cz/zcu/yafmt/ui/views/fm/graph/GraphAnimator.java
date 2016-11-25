package cz.zcu.yafmt.ui.views.fm.graph;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.draw2d.Animation;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.FigureListener;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutAnimator;
import org.eclipse.draw2d.LayoutListener;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Rectangle;

import cz.zcu.yafmt.ui.views.fm.figures.IFigureWithAlpha;

public class GraphAnimator extends LayoutAnimator {

    private static final GraphAnimator INSTANCE = new GraphAnimator();

    public static void hook(IFigure figure) {
        figure.addLayoutListener(INSTANCE.internalLayoutListener);
    }

    public static void unhook(IFigure figure) {
        figure.removeLayoutListener(INSTANCE.internalLayoutListener);
    }

    private InternalLayoutListener internalLayoutListener = new InternalLayoutListener();
    private Set<IFigure> newlyAddedFigures = new HashSet<IFigure>();

    @Override
    public void playbackStarting(IFigure container) {
        Map<?, ?> initialState = (Map<?, ?>) Animation.getInitialState(this, container);

        // Place newly added node figures immediately to the final position. 
        for(Object figure: container.getChildren()) {
            Rectangle initialBounds = (Rectangle) initialState.get(figure);
            if((initialBounds != null) && (initialBounds.x <= 0) && (initialBounds.y <= 0)) {
                Rectangle finalBounds = (Rectangle) container.getLayoutManager().getConstraint((IFigure) figure);
                if(finalBounds != null) {
                    initialBounds.x = finalBounds.x;
                    initialBounds.y = finalBounds.y;
                    newlyAddedFigures.add((IFigure) figure);
                }
            }
        }

        // Also remember connections to newly added nodes.
        for(Object figure: container.getChildren()) {
            if(figure instanceof Connection) {
                Connection connection = (Connection) figure;
                IFigure source = connection.getSourceAnchor().getOwner();
                IFigure target = connection.getTargetAnchor().getOwner();
                if(newlyAddedFigures.contains(source) || newlyAddedFigures.contains(target))
                    newlyAddedFigures.add(connection);
            }
        }
    }

    @Override
    protected boolean playback(IFigure container) {
        animateAlpha(container);
        return super.playback(container);
    }

    private void animateAlpha(IFigure container) {
        float progress = Animation.getProgress();
        int alpha = (int) (255 * progress);

        for(Object figure: container.getChildren()) {
            if(!newlyAddedFigures.contains(figure))
                continue;

            if((figure instanceof IFigureWithAlpha)) {
                ((IFigureWithAlpha) figure).setAlpha(alpha);
            }
            else if(figure instanceof Shape) {
                ((Shape) figure).setAlpha(alpha);
                for(Object child: ((Shape) figure).getChildren()) {
                    if(child instanceof Shape)
                        ((Shape) child).setAlpha(alpha);
                }
            }
        }
    }

    @Override
    public void tearDown(IFigure container) {
        if(newlyAddedFigures.isEmpty())
            return;

        // Restore full alpha.
        for(IFigure figure: newlyAddedFigures) {
            if(figure instanceof IFigureWithAlpha) {
                ((IFigureWithAlpha) figure).setAlpha(255);
            }
            else if(figure instanceof Shape) {
                ((Shape) figure).setAlpha(255);
                for(Object child: figure.getChildren()) {
                    if(child instanceof Shape)
                        ((Shape) child).setAlpha(255);
                }
            }
        }

        newlyAddedFigures.clear();
    }
    
    // ===================================================================
    //  Events
    // ===================================================================

    public void processConstraintChange(IFigure child, Object constraint) {
        // Hide newly created node and connection figures.
        // Otherwise there is ugly effect when figure is displayed in top left corner.
        if(child instanceof Connection) {
            Connection connection = (Connection) child;
            connection.setVisible(false);
            ConnectionVisibilityEnabler.hook(connection);
        }
        else {
            Rectangle bounds = (Rectangle) constraint;
            child.setVisible((bounds != null) && (bounds.x > 0) && (bounds.y > 0));
        }
    }

    private class InternalLayoutListener extends LayoutListener.Stub {

        @Override
        public void setConstraint(IFigure child, Object constraint) {
            processConstraintChange(child, constraint);
        }

        @Override
        public void invalidate(IFigure container) {
            GraphAnimator.this.invalidate(container);
        }

        @Override
        public boolean layout(IFigure container) {
            return GraphAnimator.this.layout(container);
        }

        @Override
        public void postLayout(IFigure container) {
            GraphAnimator.this.postLayout(container);
        }

    }
    
    // ===================================================================
    //  Helpers
    // ===================================================================

    private static class ConnectionVisibilityEnabler implements FigureListener {

        public static void hook(Connection connection) {
            ConnectionVisibilityEnabler enabler = new ConnectionVisibilityEnabler(connection);
            connection.getSourceAnchor().getOwner().addFigureListener(enabler);
            connection.getTargetAnchor().getOwner().addFigureListener(enabler);
        }

        private Connection connection;
        private int countdown;

        public ConnectionVisibilityEnabler(Connection connection) {
            this.connection = connection;
            this.countdown = 2;
        }

        @Override
        public void figureMoved(IFigure source) {
            source.removeFigureListener(this);
            connection.setVisible(--countdown <= 0);
        }

    }

}
