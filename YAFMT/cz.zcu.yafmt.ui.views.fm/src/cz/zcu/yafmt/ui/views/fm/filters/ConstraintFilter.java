package cz.zcu.yafmt.ui.views.fm.filters;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import cz.zcu.yafmt.clang.util.ConstraintCache;
import cz.zcu.yafmt.model.fm.Constraint;
import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.FeatureModel;

public class ConstraintFilter extends ViewerFilter {

    private Set<Constraint> visibleConstraints = new HashSet<Constraint>();
    private ConstraintCache constraintCache;
    private boolean enabled = true;

    public ConstraintFilter(ConstraintCache constraintCache, boolean enabled) {
        this.constraintCache = constraintCache;
        setEnabled(enabled);
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void update(ISelection selection, FeatureModel featureModel) {
        visibleConstraints.clear();

        if(!(selection instanceof IStructuredSelection))
            return;

        for(Object element: ((IStructuredSelection) selection).toArray()) {
            if(element instanceof Constraint) {
                Constraint constraint = (Constraint) element;
                if(!constraintCache.getFeaturesAffectedByConstraint(constraint).isEmpty())
                    visibleConstraints.add((Constraint) element);
            }
            else if(element instanceof Feature) {
                Feature feature = (Feature) element;
                visibleConstraints.addAll(constraintCache.getConstraintsAffectingFeature(feature));
            }
        }
    }

    @Override
    public boolean select(Viewer viewer, Object parentElement, Object element) {
        if(!(element instanceof Constraint))
            return true;
        return enabled ? visibleConstraints.contains(element) : false;
    }

}
