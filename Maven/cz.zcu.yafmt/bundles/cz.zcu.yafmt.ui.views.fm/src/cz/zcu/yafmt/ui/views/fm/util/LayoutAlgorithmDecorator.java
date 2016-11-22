package cz.zcu.yafmt.ui.views.fm.util;

import java.util.Comparator;
import java.util.List;

import org.eclipse.zest.layouts.Filter;
import org.eclipse.zest.layouts.InvalidLayoutConfiguration;
import org.eclipse.zest.layouts.LayoutAlgorithm;
import org.eclipse.zest.layouts.LayoutEntity;
import org.eclipse.zest.layouts.LayoutRelationship;
import org.eclipse.zest.layouts.progress.ProgressListener;

public class LayoutAlgorithmDecorator implements LayoutAlgorithm {

    private LayoutAlgorithm algorithm;

    public LayoutAlgorithmDecorator(LayoutAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    @Override
    public void applyLayout(LayoutEntity[] entitiesToLayout, LayoutRelationship[] relationshipsToConsider, double x, double y, double width, double height, boolean asynchronous, boolean continuous) throws InvalidLayoutConfiguration {
        algorithm.applyLayout(entitiesToLayout, relationshipsToConsider, x, y, width, height, asynchronous, continuous);
    }

    @Override
    public boolean isRunning() {
        return algorithm.isRunning();
    }

    @Override
    @SuppressWarnings("rawtypes")
    public void setComparator(Comparator comparator) {
        algorithm.setComparator(comparator);
    }

    @Override
    public void setFilter(Filter filter) {
        algorithm.setFilter(filter);
    }

    @Override
    public void setEntityAspectRatio(double ratio) {
        algorithm.setEntityAspectRatio(ratio);
    }

    @Override
    public double getEntityAspectRatio() {
        return algorithm.getEntityAspectRatio();
    }

    @Override
    public void addProgressListener(ProgressListener listener) {
        algorithm.addProgressListener(listener);
    }

    @Override
    public void removeProgressListener(ProgressListener listener) {
        algorithm.removeProgressListener(listener);
    }

    @Override
    public void stop() {
        algorithm.stop();
    }

    @Override
    public void setStyle(int style) {
        algorithm.setStyle(style);
    }

    @Override
    public int getStyle() {
        return algorithm.getStyle();
    }

    @Override
    public void addEntity(LayoutEntity entity) {
        algorithm.addEntity(entity);
    }

    @Override
    public void addRelationship(LayoutRelationship relationship) {
        algorithm.addRelationship(relationship);
    }

    @Override
    public void removeEntity(LayoutEntity entity) {
        algorithm.removeEntity(entity);
    }

    @Override
    public void removeRelationship(LayoutRelationship relationship) {
        algorithm.removeRelationship(relationship);
    }

    @Override
    @SuppressWarnings("rawtypes")
    public void removeRelationships(List relationships) {
        algorithm.removeRelationships(relationships);
    }

}
