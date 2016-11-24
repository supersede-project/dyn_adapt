package cz.zcu.yafmt.ui.editors.fc.parts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import cz.zcu.yafmt.model.fc.Selection;
import cz.zcu.yafmt.ui.editors.fc.FeatureConfigurationManager;
import cz.zcu.yafmt.ui.editors.fc.commands.DeselectFeatureCommand;
import cz.zcu.yafmt.ui.editors.fc.commands.SelectFeatureCommand;
import cz.zcu.yafmt.ui.editors.fc.figures.SelectionFigure;
import cz.zcu.yafmt.ui.editors.fc.model.Connection;
import cz.zcu.yafmt.ui.editors.fc.policies.SelectionSelectionPolicy;
import cz.zcu.yafmt.ui.figures.MiddleSideAnchor;

public class SelectionEditPart extends AbstractGraphicalEditPart implements NodeEditPart {

    private FeatureConfigurationManager featureConfigManager;
    private Selection selection;

    public SelectionEditPart(FeatureConfigurationManager featureConfigManager, Selection selection) {
        this.featureConfigManager = featureConfigManager;
        this.selection = selection;
        setModel(selection);
    }
    
    // ===================================================================
    //  Visuals
    // ===================================================================
    
    @Override
    protected IFigure createFigure() {
        return new SelectionFigure(selection);
    }
    
    @Override
    public SelectionFigure getFigure() {
        return (SelectionFigure) super.getFigure();
    }

    @Override
    protected void refreshVisuals() {
        // Update error marker and repaint figure.
        SelectionFigure figure = getFigure();
        figure.setErrors(featureConfigManager.getProblemStore().getMessages(selection));
        figure.repaint();

        // Refresh source connections visual.
        for(Object connectionEditPart: getSourceConnections())
            ((ConnectionEditPart) connectionEditPart).refresh();
    }

    @Override
    public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) {
        return new MiddleSideAnchor(getFigure());
    }

    @Override
    public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection) {
        return new MiddleSideAnchor(getFigure());
    }

    @Override
    public ConnectionAnchor getSourceConnectionAnchor(Request request) {
        return new MiddleSideAnchor(getFigure());
    }

    @Override
    public ConnectionAnchor getTargetConnectionAnchor(Request request) {
        return new MiddleSideAnchor(getFigure());
    }
    
    // ===================================================================
    //  Model
    // ===================================================================

    @Override
    @SuppressWarnings("rawtypes")
    protected List getModelChildren() {
        return selection.isPresent() ? selection.getValues() : Collections.EMPTY_LIST;
    }
    
    @Override
    @SuppressWarnings("rawtypes")
    protected List getModelSourceConnections() {
        List<Object> connections = new ArrayList<Object>();
        Selection parentSelection = featureConfigManager.getParentSelection(selection);
        if(parentSelection != null)
            connections.add(new Connection(parentSelection, selection));
        return connections;
    }

    @Override
    @SuppressWarnings("rawtypes")
    protected List getModelTargetConnections() {
        List<Object> connections = new ArrayList<Object>();
        for(Selection childSelection: featureConfigManager.getChildrenSelections(selection))
            connections.add(new Connection(selection, childSelection));
        return connections;
    }
    
    // ===================================================================
    //  Policies and requests
    // ===================================================================

    @Override
    protected void createEditPolicies() {
        installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE, new SelectionSelectionPolicy());
    }

    @Override
    public void performRequest(Request request) {
        if(request.getType().equals(REQ_OPEN)) {
            CommandStack commandStack = getViewer().getEditDomain().getCommandStack();
            commandStack.execute(createDoubleClickComamnd());
        }
    }
    
    private Command createDoubleClickComamnd() {
        if(selection.getParent() == null)
            return new SelectFeatureCommand(featureConfigManager, selection);
        else
            return new DeselectFeatureCommand(featureConfigManager, selection);
    }

}
