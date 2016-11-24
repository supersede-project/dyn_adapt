package cz.zcu.yafmt.ui.wizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ISetSelectionTarget;

import cz.zcu.yafmt.ui.operations.ResourceSaveOperation;

public abstract class NewFileWizard extends Wizard implements INewWizard {

    private IWorkbench workbench;
    private IStructuredSelection selection;
    private NewFileCreationPage newFileCreationPage;

    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        this.workbench = workbench;
        this.selection = selection;
        this.newFileCreationPage = new NewFileCreationPage(selection);
    }

    protected abstract void initNewFileCreationPage(WizardNewFileCreationPage page);

    @Override
    public void addPages() {
        initNewFileCreationPage(newFileCreationPage);
        addPage(newFileCreationPage);
    }

    protected IStructuredSelection getSelection() {
        return selection;
    }

    protected IFile getFile() {
        IPath path = newFileCreationPage.getContainerFullPath().append(newFileCreationPage.getFileName());
        return ResourcesPlugin.getWorkspace().getRoot().getFile(path);
    }

    protected abstract Resource getNewResource(IFile file) throws Exception;

    @Override
    public boolean performFinish() {
        IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
        IWorkbenchPage page = window.getActivePage();
        IWorkbenchPart activePart = page.getActivePart();
        IFile file = getFile();

        try {
            Resource resource = getNewResource(file);
            getContainer().run(false, false, new ResourceSaveOperation(resource));
        }
        catch(Exception ex) {
            MessageDialog.openError(window.getShell(), "Unable to create " + file.getName(), ex.getMessage());
            return false;
        }

        // Select the new file resource in the current view.
        if(activePart instanceof ISetSelectionTarget) {
            final ISetSelectionTarget setSelectionTarget = (ISetSelectionTarget) activePart;
            final ISelection targetSelection = new StructuredSelection(file);
            getShell().getDisplay().asyncExec(new Runnable() {

                public void run() {
                    setSelectionTarget.selectReveal(targetSelection);
                }
            });
        }

        // Open an editor on the new file.
        try {
            IEditorInput input = new FileEditorInput(file);
            IEditorDescriptor descriptor = workbench.getEditorRegistry().getDefaultEditor(file.getName());
            if(descriptor != null)
                page.openEditor(input, descriptor.getId());
        }
        catch(PartInitException ex) {
            MessageDialog.openError(window.getShell(), "Unable to open " + file.getName(), ex.getMessage());
            return false;
        }

        return true;
    }

    private class NewFileCreationPage extends WizardNewFileCreationPage {

        public NewFileCreationPage(IStructuredSelection selection) {
            super("New File Creation Page", selection);

            // Try and get the resource selection to determine a current directory for the file dialog.
            if(selection == null || selection.isEmpty())
                return;

            Object selectedObject = selection.iterator().next();
            if(!(selectedObject instanceof IResource))
                return;

            // Get the resource parent, if its a file.
            IResource selectedResource = (IResource) selectedObject;
            if(selectedResource.getType() == IResource.FILE)
                selectedResource = selectedResource.getParent();

            // This gives us a directory or project, select it as a container.
            if((selectedResource instanceof IFolder) || (selectedResource instanceof IProject))
                setContainerFullPath(selectedResource.getFullPath());
        }

    }

}
