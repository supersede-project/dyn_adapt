package cz.zcu.yafmt.ui.dialogs;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;


public class WorkspaceDialog extends ElementTreeSelectionDialog {

    public WorkspaceDialog(Shell shell) {
        super(shell, new WorkbenchLabelProvider(), new BaseWorkbenchContentProvider());
        setInput(ResourcesPlugin.getWorkspace().getRoot());
    }
    
    public static String openFile(Shell shell, String title, String message) {
        return openFile(shell, title, message, null);
    }
    
    public static String openFile(Shell shell, String title, String message, String extension) {
        WorkspaceDialog dialog = new WorkspaceDialog(shell);
        dialog.setTitle(title);
        dialog.setMessage(message);
        dialog.setAllowMultiple(false);
        if(extension != null)
            dialog.addFilter(new FileNameFilter(extension));
        dialog.open();
        
        Object result = dialog.getFirstResult();
        if(result instanceof IFile)
            return ((IResource) result).getFullPath().toString();
        return null;
    }
    
    private static class FileNameFilter extends ViewerFilter {

        private String extension;
        
        
        public FileNameFilter(String extension) {
            this.extension = extension.startsWith(".") ? extension : ("." + extension);
        }
        
        @Override
        public boolean select(Viewer viewer, Object parentElement, Object element) {
            if(element instanceof IFile)
                return ((IFile) element).getName().endsWith(extension);
            else
                return true;
        }
        
    }
        
}
