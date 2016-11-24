package cz.zcu.yafmt.ui.util;

import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.part.FileEditorInput;

public class EditorAutoCloser implements IResourceChangeListener {

    private EditorPart editor;

    public EditorAutoCloser(EditorPart editor) {
        this.editor = editor;
    }

    private FileEditorInput getEditorInput() {
        return (FileEditorInput) editor.getEditorInput();
    }

    @Override
    public void resourceChanged(final IResourceChangeEvent event) {
        if((event.getType() == IResourceChangeEvent.PRE_CLOSE) &&
                (getEditorInput().getFile().getProject().equals(event.getResource()))) {

            // Close editor when project containing edited file is closed.
            Display.getDefault().asyncExec(new Runnable() {

                public void run() {
                    closeEditorOnAllPages();
                }
            });
        }

    }

    private void closeEditorOnAllPages() {
        IFileEditorInput input = getEditorInput();
        for(IWorkbenchPage page: editor.getSite().getWorkbenchWindow().getPages()) {
            IEditorPart editorPart = page.findEditor(input);
            if(editorPart != null)
                page.closeEditor(editorPart, true);
        }
    }

}
