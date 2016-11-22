package cz.zcu.yafmt.ui.validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.Diagnostic;

import cz.zcu.yafmt.ui.CommonUIPlugin;

public class ResourceProblemManager implements IProblemManager {

    private static class ObjectInfo {
        List<ModelMarkerDescriptor> descriptors = new ArrayList<ModelMarkerDescriptor>();
        List<IMarker> markers = new ArrayList<IMarker>();
        List<String> messages = new ArrayList<String>();
    }

    private List<ModelMarkerDescriptor> savedState = new ArrayList<ModelMarkerDescriptor>();
    private List<ModelMarkerDescriptor> currentState = new ArrayList<ModelMarkerDescriptor>();
    private Map<Object, ObjectInfo> objectsInfo = new HashMap<Object, ObjectInfo>();
    private IResource resource;

    public ResourceProblemManager(IResource resource) {
        if(resource == null)
            throw new IllegalArgumentException("Resource must not be null.");
        this.resource = resource;
    }
    
    @Override
    public void addProblems(Diagnostic diagnostic) {
        for(Diagnostic child: diagnostic.getChildren()) {
            ModelMarkerDescriptor descriptor = createDescriptor(child);
            createMarker(descriptor);
            currentState.add(descriptor);
        }
    }

    @Override
    public List<String> getMessages(Object target) {
        ObjectInfo info = objectsInfo.get(target);
        return (info == null) ? null : info.messages;
    }

    @Override
    public void clearProblems(Object target) {
        ObjectInfo info = objectsInfo.remove(target);
        if(info == null)
            return;
        
        for(IMarker marker: info.markers)
            deleteMarker(marker);
        for(ModelMarkerDescriptor descriptor: info.descriptors) {
            if(descriptor.decrementReferenceCount())
                currentState.remove(descriptor);
        }
    }

    @Override
    public void clearProblems() {
        currentState.clear();
        deleteMarkers();
    }

    public void saveState() {
        copyState(currentState, savedState);
    }

    public void restoreState() {
        deleteMarkers();
        copyState(savedState, currentState);
        for(ModelMarkerDescriptor descriptor: currentState)
            createMarker(descriptor);
    }
    
    private void copyState(List<ModelMarkerDescriptor> src, List<ModelMarkerDescriptor> dst) {
        dst.clear();
        for(ModelMarkerDescriptor descriptor: src)
            dst.add((ModelMarkerDescriptor) descriptor.clone());
    }

    private void createMarker(ModelMarkerDescriptor descriptor) {
        try {
            IMarker marker = descriptor.createMarker(resource);
            String message = descriptor.getMessage();

            for(Object object: descriptor.getObjects()) {
                ObjectInfo info = objectsInfo.get(object);
                if(info == null) {
                    info = new ObjectInfo();
                    objectsInfo.put(object, info);
                }
                descriptor.incrementReferenceCount();
                info.descriptors.add(descriptor);
                info.markers.add(marker);
                info.messages.add(message);
            }
        }
        catch(CoreException ex) {
            CommonUIPlugin.getAccess().logError(ex);
        }
    }
    
    private void deleteMarker(IMarker marker) {
        try {
            marker.delete();
        }
        catch(CoreException ex) {
            CommonUIPlugin.getAccess().logError(ex);
        }
    }
    
    private void deleteMarkers() {
        try {
            objectsInfo.clear();
            if(resource.exists()) // When user deleted edited file.
                resource.deleteMarkers(ModelMarkerDescriptor.MARKER_ID, false, IResource.DEPTH_INFINITE);
        }
        catch(CoreException ex) {
            CommonUIPlugin.getAccess().logError(ex);
        }
    }
    
    private ModelMarkerDescriptor createDescriptor(Diagnostic diagnostic) {
        int severity = getSeverity(diagnostic.getCode());
        String message = diagnostic.getMessage();
        List<?> objects = diagnostic.getData();
        return new ModelMarkerDescriptor(severity, message, objects);
    }

    private int getSeverity(int code) {
        switch(code) {
            case Diagnostic.ERROR:
                return IMarker.SEVERITY_ERROR;

            case Diagnostic.WARNING:
                return IMarker.SEVERITY_WARNING;

            case Diagnostic.INFO:
                return IMarker.SEVERITY_INFO;

            default:
                return IMarker.SEVERITY_INFO;
        }
    }
    
}
