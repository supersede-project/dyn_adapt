package cz.zcu.yafmt.ui.validation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

public class ModelMarkerDescriptor implements Cloneable {
    
    public static final String MARKER_ID = "cz.zcu.yafmt.ui.ModelMarker";
    public static final String OBJECTS_URI_ID = "cz.zcu.yafmt.ui.ModelMarker.ObjectsURI";
    public static final String URI_FRAGMENTS_SEPARATOR = ";";

    private int referenceCount;
    private int severity;
    private String message;
    private List<EObject> objects;
    
    public ModelMarkerDescriptor(int severity, String message, List<?> srcObjects) {
        this.referenceCount = 0;
        this.severity = severity;
        this.message = message;
        initObjects(srcObjects);
    }
        
    private void initObjects(List<?> srcObjects) {
        if(srcObjects == null)
            return;
            
        objects = new ArrayList<EObject>(srcObjects.size());
        for(Object object: srcObjects) {
            if((object instanceof EObject) && (((EObject) object).eResource() != null))
                objects.add((EObject) object);
        }
    }
    
    private String createProblemObjectsURI() {
        if(objects == null)
            return "";
        
        StringBuilder builder = new StringBuilder();
        for(Object object: objects) {
            if(!(object instanceof EObject))
                continue;
            
            EObject eObject = (EObject) object;
            Resource eResource = eObject.eResource();
            if(eResource != null) {
                builder.append(eResource.getURIFragment(eObject));
                builder.append(URI_FRAGMENTS_SEPARATOR);
            }
        }
    
        return builder.toString();
    }
    
    public IMarker createMarker(IResource resource) throws CoreException {
        IMarker marker = resource.createMarker(MARKER_ID);
        marker.setAttribute(IMarker.SEVERITY, severity);
        marker.setAttribute(IMarker.MESSAGE, message);
        marker.setAttribute(OBJECTS_URI_ID, createProblemObjectsURI());
        return marker;
    }

    public void incrementReferenceCount() {
        referenceCount++;
    }
    
    public boolean decrementReferenceCount() {
        if(referenceCount > 0)
            referenceCount--;
        return referenceCount == 0;
    }
    
    public int getSeverity() {
        return severity;
    }
    
    public String getMessage() {
        return message;
    }
    
    public List<EObject> getObjects() {
        return objects;
    }
    
    @Override
    protected Object clone() {
        return new ModelMarkerDescriptor(severity, message, objects);
    }
    
}
