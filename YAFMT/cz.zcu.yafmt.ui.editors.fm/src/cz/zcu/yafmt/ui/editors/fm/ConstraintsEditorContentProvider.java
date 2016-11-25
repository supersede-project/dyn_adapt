package cz.zcu.yafmt.ui.editors.fm;

import java.util.List;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

import cz.zcu.yafmt.model.fm.Constraint;
import cz.zcu.yafmt.model.fm.FeatureModel;

public class ConstraintsEditorContentProvider implements IStructuredContentProvider {

    public static final Object ADD_CONSTRAINT_OBJECT = new Object();

    @Override
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    }

    @Override
    public void dispose() {
    }

    @Override
    public Object[] getElements(Object input) {
        if(!(input instanceof FeatureModel))
            return null;

        List<Constraint> constraints = ((FeatureModel) input).getConstraints();
        Object[] elements = constraints.toArray(new Object[constraints.size() + 1]);
        elements[elements.length - 1] = ADD_CONSTRAINT_OBJECT; // Used as add button.
        return elements;
    }

}
