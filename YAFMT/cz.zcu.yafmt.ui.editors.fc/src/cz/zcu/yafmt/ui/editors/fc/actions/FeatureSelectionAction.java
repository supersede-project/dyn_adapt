package cz.zcu.yafmt.ui.editors.fc.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;

import cz.zcu.yafmt.model.fc.Selection;
import cz.zcu.yafmt.ui.editors.fc.FeatureConfigurationManager;
import cz.zcu.yafmt.ui.util.SelectionWrapper;

public abstract class FeatureSelectionAction extends SelectionAction {

    private FeatureConfigurationManager featureConfigManager;

    public FeatureSelectionAction(GraphicalEditor editor, FeatureConfigurationManager featureConfigManager) {
        super(editor);
        this.featureConfigManager = featureConfigManager;
    }

    protected FeatureConfigurationManager getFeatureConfigManager() {
        return featureConfigManager;
    }

    protected List<Selection> getSelectedFeatures() {
        ISelection selection = SelectionWrapper.toModelElementsSelection(getSelection());
        if(!(selection instanceof IStructuredSelection))
            return null;

        List<Selection> selectedFeatures = new ArrayList<Selection>(((IStructuredSelection) selection).size());
        for(Object object: ((IStructuredSelection) selection).toArray()) {
            if(object instanceof Selection)
                selectedFeatures.add((Selection) object);
        }
        return selectedFeatures;
    }

    protected abstract Command getCommand();

    @Override
    protected boolean calculateEnabled() {
        Command command = getCommand();
        return (command != null) && command.canExecute();
    }

    @Override
    public void run() {
        execute(getCommand());
    }

}
