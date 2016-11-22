package cz.zcu.yafmt.ui.views.fm.graph;

import org.eclipse.draw2d.Animation;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutAnimator;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.layouts.InvalidLayoutConfiguration;
import org.eclipse.zest.layouts.LayoutAlgorithm;
import org.eclipse.zest.layouts.LayoutEntity;
import org.eclipse.zest.layouts.LayoutRelationship;

import cz.zcu.yafmt.ui.views.fm.settings.Settings;
import cz.zcu.yafmt.ui.views.fm.util.LayoutAlgorithmDecorator;

public class LayoutAlgorithmAnimator extends LayoutAlgorithmDecorator {

    private Graph graph;
    private Settings settings;

    public LayoutAlgorithmAnimator(GraphViewer viewer, Settings settings, LayoutAlgorithm algorithm) {
        super(algorithm);
        this.graph = viewer.getGraphControl();
        this.settings = settings;
        hookGraph();
    }

    private IFigure getLayer(int index) {
        return (IFigure) graph.getRootLayer().getChildren().get(index);
    }

    private void hookGraph() {
        getLayer(DecoratableGraphViewer.ZEST_LAYER_INDEX).removeLayoutListener(LayoutAnimator.getDefault());
        GraphAnimator.hook(getLayer(DecoratableGraphViewer.ZEST_LAYER_INDEX));
        GraphAnimator.hook(getLayer(DecoratableGraphViewer.BACK_DECORATION_LAYER_INDEX));
        GraphAnimator.hook(getLayer(DecoratableGraphViewer.FRONT_DECORATION_LAYER_INDEX));
    }

    @Override
    public synchronized void applyLayout(LayoutEntity[] entitiesToLayout, LayoutRelationship[] relationshipsToConsider, double x, double y, double width, double height, boolean asynchronous, boolean continuous) throws InvalidLayoutConfiguration {
        super.applyLayout(entitiesToLayout, relationshipsToConsider, x, y, width, height, asynchronous, continuous);
        if(!settings.isAnimationEnabled())
            return;

        // We must invalidate layers, so graph animator can capture their state.
        getLayer(DecoratableGraphViewer.BACK_DECORATION_LAYER_INDEX).invalidate();
        getLayer(DecoratableGraphViewer.FRONT_DECORATION_LAYER_INDEX).invalidate();

        // Very ugly trick how to change graph animation time.
        // This method is internally called by Graph before it calls Animation.run().
        // If we manage to call Animation.run() before, the second call is discarded
        // and only our call is performed.
        Animation.run(settings.getAnimationTime());
    }

}
