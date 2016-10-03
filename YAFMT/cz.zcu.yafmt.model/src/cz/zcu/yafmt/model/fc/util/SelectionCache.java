package cz.zcu.yafmt.model.fc.util;

import static cz.zcu.yafmt.model.fc.FeatureConfigurationPackage.SELECTION__ID;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EContentAdapter;

import cz.zcu.yafmt.model.fc.AttributeValue;
import cz.zcu.yafmt.model.fc.FeatureConfiguration;
import cz.zcu.yafmt.model.fc.Selection;

public class SelectionCache {

    private Map<String, EList<Selection>> idToSelections;
    private FeatureConfigurationAdapter featureConfigAdapter;

    public SelectionCache(FeatureConfiguration featureConfig) {
        if(featureConfig == null)
            throw new IllegalArgumentException("Feature configuration cannot be null");

        idToSelections = new HashMap<String, EList<Selection>>();
        featureConfigAdapter = new FeatureConfigurationAdapter();
        featureConfig.eAdapters().add(featureConfigAdapter);
    }
    
    public void dispose() {
        featureConfigAdapter.getTarget().eAdapters().remove(featureConfigAdapter);
        featureConfigAdapter = null;
        idToSelections = null;
    }

    public EList<Selection> getSelectionsById(String id) {
        EList<Selection> selections = idToSelections.get(id);
        if(selections != null)
            return selections;
        return ECollections.emptyEList();
    }
    
    // =======================================================================
    //  Helpers
    // =======================================================================

    private void addSelection(Selection selection) {
        String id = selection.getId();
        EList<Selection> selections = idToSelections.get(id);

        if(selections == null) {
            selections = new BasicEList<Selection>();
            idToSelections.put(id, selections);
        }

        selections.add(selection);
    }

    private void removeSelection(Selection selection, String oldId) {
        String id = (oldId != null) ? oldId : selection.getId();
        EList<Selection> selections = idToSelections.get(id);

        // Should not happen.
        if(selections == null)
            return;

        selections.remove(selection);
        if(selections.isEmpty())
            idToSelections.remove(id);
    }
    
    // =======================================================================
    //  Events
    // =======================================================================

    private class FeatureConfigurationAdapter extends EContentAdapter {

        @Override
        protected void addAdapter(Notifier notifier) {
            if(notifier instanceof AttributeValue)
                return;

            super.addAdapter(notifier);
            if(notifier instanceof Selection)
                addSelection((Selection) notifier);
        }

        @Override
        protected void removeAdapter(Notifier notifier) {
            super.removeAdapter(notifier);
            if(notifier instanceof Selection)
                removeSelection((Selection) notifier, null);
        }

        @Override
        public void notifyChanged(Notification notification) {
            super.notifyChanged(notification);

            if((notification.getNotifier() instanceof Selection) && (notification.getFeatureID(Selection.class) == SELECTION__ID)) {
                Selection selection = (Selection) notification.getNotifier();
                removeSelection(selection, notification.getOldStringValue());
                addSelection(selection); // Should have the new ID value.
            }
        }

    }

}
