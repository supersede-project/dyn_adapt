package cz.zcu.yafmt.ui.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.gef.EditPart;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;

// Converts between model elements and edit parts selection.
public class SelectionWrapper {

    public static ISelection toEditPartsSelection(ISelection selection, Map<?, ?> editPartRegistry) {
        if(!(selection instanceof IStructuredSelection))
            return selection;

        Object[] elements = ((IStructuredSelection) selection).toArray();
        List<Object> editParts = new ArrayList<Object>(elements.length);

        // Result list MUST contain only edit parts!!!
        for(Object element: elements) {
            if(element instanceof EditPart)
                editParts.add(element);
            Object editPart = editPartRegistry.get(element);
            if(editPart != null)
                editParts.add(editPart);
        }

        return new StructuredSelection(editParts);
    }

    public static ISelection toModelElementsSelection(ISelection selection) {
        if(!(selection instanceof IStructuredSelection))
            return selection;

        Object[] elements = ((IStructuredSelection) selection).toArray();
        for(int i = 0; i < elements.length; i++) {
            Object element = elements[i];
            if(element instanceof EditPart) {
                Object model = ((EditPart) element).getModel();
                if(model != null)
                    elements[i] = model;
            }
        }

        return new StructuredSelection(elements);
    }

}
