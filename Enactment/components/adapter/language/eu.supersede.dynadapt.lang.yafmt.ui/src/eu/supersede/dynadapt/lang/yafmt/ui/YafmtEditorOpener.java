package eu.supersede.dynadapt.lang.yafmt.ui;

import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ui.IEditorPart;
import org.eclipse.xtext.ui.editor.LanguageSpecificURIEditorOpener;

import cz.zcu.yafmt.model.fm.presentation.FeatureModelEditor;

public class YafmtEditorOpener extends LanguageSpecificURIEditorOpener {
	 @Override
	    protected void selectAndReveal(IEditorPart openEditor, URI uri,
	            EReference crossReference, int indexInList, boolean select) {
		 		FeatureModelEditor fmEditor = (FeatureModelEditor) openEditor.getAdapter(FeatureModelEditor.class);
	        if (fmEditor != null) {
	            EObject eObject = fmEditor.getEditingDomain().getResourceSet().getEObject(uri, true);
	            fmEditor.setSelectionToViewer(Collections.singletonList(eObject));
	        }
	    }
}
