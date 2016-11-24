package cz.zcu.yafmt.ui.views.fm.filters;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.Group;

public class GroupFilter extends ViewerFilter {

    private Set<Group> visibleGroups = new HashSet<Group>();
    private boolean enabled = true;

    public GroupFilter(boolean enabled) {
        setEnabled(enabled);
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void update(ISelection selection) {
        visibleGroups.clear();

        if(!(selection instanceof IStructuredSelection))
            return;

        for(Object element: ((IStructuredSelection) selection).toArray()) {
            if(element instanceof Group) {
                visibleGroups.add((Group) element);
            }
            else if(element instanceof Feature) {
                Feature feature = (Feature) element;
                if(feature.getParentGroup() != null)
                    visibleGroups.add(feature.getParentGroup());
            }
        }
    }

    @Override
    public boolean select(Viewer viewer, Object parentElement, Object element) {
        if(!(element instanceof Group))
            return true;
        return enabled ? visibleGroups.contains(element) : false;
    }

}
