package cz.zcu.yafmt.ui.operations;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

public class ResourceSaveOperation extends WorkspaceModifyOperation {

    private Resource resource;
    private Map<Object, Object> saveOptions;

    public ResourceSaveOperation(Resource resource) {
        this(resource, null);
    }

    public ResourceSaveOperation(Resource resource, Map<Object, Object> saveOptions) {
        this.resource = resource;
        this.saveOptions = saveOptions;
    }

    @Override
    protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
        try {
            resource.save(saveOptions);
        }
        catch(IOException ex) {
            throw new InvocationTargetException(ex);
        }
    }

}
