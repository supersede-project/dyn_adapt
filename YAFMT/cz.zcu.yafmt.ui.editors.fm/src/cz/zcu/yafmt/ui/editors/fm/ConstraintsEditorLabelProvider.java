package cz.zcu.yafmt.ui.editors.fm;

import java.util.List;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import cz.zcu.yafmt.model.fm.Constraint;
import cz.zcu.yafmt.ui.validation.IProblemManager;

public class ConstraintsEditorLabelProvider extends ColumnLabelProvider {

    private static final Image constraintImage = FeatureModelEditorPlugin.getAccess().getImage("constraint.png");
    private static final Image constraintErrorImage = FeatureModelEditorPlugin.getAccess().getImage("constraint-error.png");
    private static final Image addImage = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_ADD);
    
    private IProblemManager problemManager;
    
    public ConstraintsEditorLabelProvider(IProblemManager problemManager) {
        this.problemManager = problemManager;
    }
    
    // =====================================================================
    //  Providers
    // =====================================================================

    @Override
    public Image getImage(Object element) {
        if(element == ConstraintsEditorContentProvider.ADD_CONSTRAINT_OBJECT)
            return addImage;
        
        if(hasErrors(element))
            return constraintErrorImage;
        
        return constraintImage;
    }
        
    @Override
    public String getText(Object element) {
        if(element == ConstraintsEditorContentProvider.ADD_CONSTRAINT_OBJECT)
            return "Add new constraint";
        return ((Constraint) element).getValue();
    }
    
    @Override
    public String getToolTipText(Object element) {
        if(element == ConstraintsEditorContentProvider.ADD_CONSTRAINT_OBJECT)
            return "Double-click to add a new constraint.";
        
        String error = getError(element);
        if(error != null)
            return error;
        
        return getDescription(element);
    }
    
    @Override
    public boolean useNativeToolTip(Object object) {
        return true;
    }
    
    // =====================================================================
    //  Helpers
    // =====================================================================
    
    private boolean hasErrors(Object element) {
        List<String> messages = problemManager.getMessages(element);
        return (messages != null) && !messages.isEmpty();
    }
    
    private String getError(Object element) {
        List<String> messages = problemManager.getMessages(element);
        if((messages == null) || messages.isEmpty())
            return null;
        
        StringBuilder builder = null;
        for(String message: messages) {
            if(builder == null)
                builder = new StringBuilder(message);
            else
                builder.append("\n").append(message);
        }
        return builder.toString();
    }
    
    private String getDescription(Object element) {
        if(!(element instanceof Constraint))
            return null;
        
        String description = ((Constraint) element).getDescription();
        if((description == null) || description.isEmpty())
            return null;
        return description;
    }

}
