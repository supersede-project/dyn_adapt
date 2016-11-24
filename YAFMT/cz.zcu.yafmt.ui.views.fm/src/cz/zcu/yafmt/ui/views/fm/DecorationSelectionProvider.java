package cz.zcu.yafmt.ui.views.fm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;

import cz.zcu.yafmt.ui.views.fm.decorations.AttributeDecoration;
import cz.zcu.yafmt.ui.views.fm.decorations.ConstraintDecoration;
import cz.zcu.yafmt.ui.views.fm.decorations.GroupDecoration;
import cz.zcu.yafmt.ui.views.fm.decorations.IDecoration;
import cz.zcu.yafmt.ui.views.fm.decorations.NeighborsDecoration;
import cz.zcu.yafmt.ui.views.fm.graph.IDecorationSelecionProvider;


public class DecorationSelectionProvider implements IDecorationSelecionProvider {

    @Override
    public ISelection getSelectionForDecoration(IDecoration decoration) {
        return new StructuredSelection(getSelectionElements(decoration));
    }
    
    private List<?> getSelectionElements(IDecoration decoration) {
        if(decoration instanceof NeighborsDecoration)
            return ((NeighborsDecoration) decoration).getNeighbors();
        if(decoration instanceof GroupDecoration)
            return toList(((GroupDecoration) decoration).getGroup());
        if(decoration instanceof ConstraintDecoration)
            return ((ConstraintDecoration) decoration).getConstraints();
        if(decoration instanceof AttributeDecoration)
            return ((AttributeDecoration) decoration).getAttributes();
        return Collections.EMPTY_LIST;
    }
    
    private List<?> toList(Object element) {
        List<Object> list = new ArrayList<Object>(1);
        list.add(element);
        return list;
    }

}
