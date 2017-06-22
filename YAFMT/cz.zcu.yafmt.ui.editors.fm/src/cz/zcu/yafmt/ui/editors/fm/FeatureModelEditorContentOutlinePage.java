package cz.zcu.yafmt.ui.editors.fm;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.UpdateListener;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.parts.Thumbnail;
import org.eclipse.gef.editparts.FreeformGraphicalRootEditPart;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;

import cz.zcu.yafmt.clang.util.ConstraintCache;
import cz.zcu.yafmt.model.fm.Constraint;
import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.FeatureModel;
import cz.zcu.yafmt.model.fm.provider.util.FeatureModelProviderUtil;
import cz.zcu.yafmt.ui.editors.fm.figures.FeatureFigure;
import cz.zcu.yafmt.ui.figures.FigureDecorator;
import cz.zcu.yafmt.ui.pages.EditorContentOutlinePage;
import cz.zcu.yafmt.ui.util.DrawUtil;

public class FeatureModelEditorContentOutlinePage extends EditorContentOutlinePage {

    private FeatureModelEditor editor;
    private ConstraintCache constraintCache;
    private ConstraintDecorator constraintDecorator;
    
    public FeatureModelEditorContentOutlinePage(FeatureModelEditor editor) {
        super(editor, editor.getAdapter(FeatureModel.class), FeatureModelProviderUtil.getContentProvider(), FeatureModelProviderUtil.getLabelProvider());
        this.editor = editor;
        this.constraintCache = (ConstraintCache) editor.getAdapter(ConstraintCache.class);
    }

    @Override
    public void dispose() {
        constraintDecorator.deactivate();
        super.dispose();
    }

    @Override
    protected IFigure createMinimapThumbmailFigure(Thumbnail thumbmail, FreeformGraphicalRootEditPart rootEditPart) {
        // Return custom figure instead of the original.
        IFigure sourceFigure = super.createMinimapThumbmailFigure(thumbmail, rootEditPart);
        IFigure featureModelFigure = (IFigure) rootEditPart.getContentPane().getChildren().get(0);
        constraintDecorator = new ConstraintDecorator(thumbmail, sourceFigure, featureModelFigure);
        return constraintDecorator;
    }

    // Provides custom painting operation for the source figure.
    private class ConstraintDecorator extends FigureDecorator implements UpdateListener, ISelectionChangedListener {

        private IStructuredSelection selection = StructuredSelection.EMPTY;
        private Object selectionSource;
        private IFigure featureModelFigure;
        private Thumbnail thumbmail;
        
        public ConstraintDecorator(Thumbnail thumbmail, IFigure sourceFigure, IFigure featureModelFigure) {
            super(sourceFigure);
            this.thumbmail = thumbmail;
            this.featureModelFigure = featureModelFigure;
            
            // Since Thumbmail class won't recognize source figure changes,
            // we listen to the changes and notify Thumbmail manually.
            // See Thumbmail.notifyPainting() for the reason.
            sourceFigure.getUpdateManager().addUpdateListener(this);
            
            // Also listen to the selection changes.
            editor.getSite().getSelectionProvider().addSelectionChangedListener(this);
        }
        
        public void deactivate() {
            editor.getSite().getSelectionProvider().removeSelectionChangedListener(this);
            sourceFigure.getUpdateManager().removeUpdateListener(this);
        }

        @Override
        @SuppressWarnings("rawtypes")
        public void notifyPainting(Rectangle damage, Map dirtyRegions) {
            // Same as in the Thumbmail class.
            for(Object dirtyFigure: dirtyRegions.keySet()) {
                IFigure current = (IFigure) dirtyFigure;
                while(current != null) {
                    if(current == sourceFigure) {
                        repaintThumbmail();
                        return;
                    }
                    current = current.getParent();
                }
            }
        }

        @Override
        public void notifyValidating() {
            // Same as in the Thumbmail class.
        }
        
        @Override
        public void selectionChanged(SelectionChangedEvent event) {
            if(!(event.getSelection() instanceof IStructuredSelection))
                return;
                        
            // Ignore this kind of selection (constraints editor just lost focus).
            IStructuredSelection newSelection = (IStructuredSelection) event.getSelection();
            if((selectionSource instanceof TableViewer) && (newSelection.getFirstElement() instanceof FeatureModel))
                return;
                
            // Force repaint when selection changes.
            selectionSource = event.getSource();
            selection = newSelection;
            repaintThumbmail();
        }
        
        private void repaintThumbmail() {
            thumbmail.setDirty(true);
            thumbmail.repaint();
        }

        @Override
        public void paint(Graphics graphics) {
            // Paint the original figure.
            super.paint(graphics);
            
            // Look for constraints to highlight.
            Set<Constraint> highlightedConstraints = new HashSet<Constraint>();
            for(Object selectedElement: selection.toArray()) {
                if(selectedElement instanceof Constraint)
                    highlightedConstraints.add((Constraint) selectedElement);
                else if(selectedElement instanceof Feature)
                    highlightedConstraints.addAll(constraintCache.getConstraintsAffectingFeature((Feature) selectedElement));
            }
            
            // Look for features to highlight.
            Set<Feature> highlightedFeatures = new HashSet<Feature>();
            for(Constraint constraint: highlightedConstraints)
                highlightedFeatures.addAll(constraintCache.getFeaturesAffectedByConstraint(constraint));
            
            // Paint features.
            graphics.setAlpha(192);
            for(Object child: featureModelFigure.getChildren()) {
                if(child instanceof FeatureFigure) {
                    FeatureFigure figure = (FeatureFigure) child;
                    if(highlightedFeatures.contains(figure.getFeature())) {
                        graphics.setBackgroundColor(DrawUtil.CONSTRAINT_COLOR);
                        graphics.fillRectangle(figure.getBounds());
                        graphics.setForegroundColor(DrawUtil.CONSTRAINT_DARKER_COLOR);
                        graphics.drawRectangle(figure.getBounds());
                    }
                }
            }
        }

    }

}
