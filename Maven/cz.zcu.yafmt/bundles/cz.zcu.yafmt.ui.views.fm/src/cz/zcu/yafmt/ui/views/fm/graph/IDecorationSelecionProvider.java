package cz.zcu.yafmt.ui.views.fm.graph;

import org.eclipse.jface.viewers.ISelection;

import cz.zcu.yafmt.ui.views.fm.decorations.IDecoration;

// Generates selection for specified decoration figure.
public interface IDecorationSelecionProvider {
    
    ISelection getSelectionForDecoration(IDecoration decoration);

}
