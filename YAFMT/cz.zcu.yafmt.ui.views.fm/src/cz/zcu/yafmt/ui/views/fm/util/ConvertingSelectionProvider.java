package cz.zcu.yafmt.ui.views.fm.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.services.IDisposable;

import cz.zcu.yafmt.model.fc.FeatureConfiguration;

// Converts between feature model and feature configuration elements selection.
public class ConvertingSelectionProvider implements ISelectionProvider, ISelectionChangedListener, IDisposable {

    private List<ISelectionChangedListener> listeners = new ArrayList<ISelectionChangedListener>();
    private FeatureConfiguration featureConfig;
    private Viewer viewer;

    public ConvertingSelectionProvider(Viewer viewer) {
        this.viewer = viewer;
        this.viewer.addSelectionChangedListener(this);
    }
    
    public void setFeatureConfiguration(FeatureConfiguration featureConfig) {
        this.featureConfig = featureConfig;
    }
    
    @Override
    public void dispose() {
        viewer.removeSelectionChangedListener(this);
        viewer = null;
    }

    // ============================================================================
    //  ISelectionProvider
    // ============================================================================

    @Override
    public ISelection getSelection() {
        return SelectionConverter.fromFeatureModelSelection(viewer.getSelection(), featureConfig);
    }

    @Override
    public void setSelection(ISelection selection) {
        viewer.setSelection(SelectionConverter.toFeatureModelSelection(selection));
        selectionChanged(new SelectionChangedEvent(this, selection));
    }

    @Override
    public void addSelectionChangedListener(ISelectionChangedListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeSelectionChangedListener(ISelectionChangedListener listener) {
        listeners.remove(listener);
    }

    // ============================================================================
    //  ISelectionChangedListener
    // ============================================================================

    @Override
    public void selectionChanged(SelectionChangedEvent event) {
        if(event.getSource() == viewer) {
            ISelection selection = SelectionConverter.fromFeatureModelSelection(event.getSelection(), featureConfig);
            event = new SelectionChangedEvent(viewer, selection);
        }

        for(ISelectionChangedListener listener: listeners)
            listener.selectionChanged(event);
    }
    
}
