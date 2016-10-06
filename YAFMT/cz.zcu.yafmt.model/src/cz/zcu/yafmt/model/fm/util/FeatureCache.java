package cz.zcu.yafmt.model.fm.util;

import static cz.zcu.yafmt.model.fm.FeatureModelPackage.FEATURE__ID;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EContentAdapter;

import cz.zcu.yafmt.model.fm.Attribute;
import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.FeatureModel;

public class FeatureCache {

    private Map<String, EList<Feature>> idToFeatures;
    private FeatureModelAdapter featureModelAdapter;

    public FeatureCache(FeatureModel featureModel) {
        if(featureModel == null)
            throw new IllegalArgumentException("Feature model cannot be null");

        idToFeatures = new HashMap<String, EList<Feature>>();
        featureModelAdapter = new FeatureModelAdapter();
        featureModel.eAdapters().add(featureModelAdapter);
    }

    public void dispose() {
        featureModelAdapter.getTarget().eAdapters().remove(featureModelAdapter);
        featureModelAdapter = null;
        idToFeatures = null;
    }

    public EList<Feature> getFeaturesById(String id) {
        EList<Feature> features = idToFeatures.get(id);
        if(features != null)
            return features;
        return ECollections.emptyEList();
    }
    
    // =======================================================================
    //  Helpers
    // =======================================================================

    private void addFeature(Feature feature) {
        String id = feature.getId();
        EList<Feature> features = idToFeatures.get(id);

        if(features == null) {
            features = new BasicEList<Feature>();
            idToFeatures.put(id, features);
        }

        features.add(feature);
    }

    private void removeFeature(Feature feature, String oldId) {
        String id = (oldId != null) ? oldId : feature.getId();
        EList<Feature> features = idToFeatures.get(id);

        // Should not happen.
        if(features == null)
            return;

        features.remove(feature);
        if(features.isEmpty())
            idToFeatures.remove(id);
    }
    
    // =======================================================================
    //  Events
    // =======================================================================

    private class FeatureModelAdapter extends EContentAdapter {

        @Override
        protected void addAdapter(Notifier notifier) {
            if(notifier instanceof Attribute)
                return;

            super.addAdapter(notifier);
            if(notifier instanceof Feature)
                addFeature((Feature) notifier);
        }

        @Override
        protected void removeAdapter(Notifier notifier) {
            super.removeAdapter(notifier);
            if(notifier instanceof Feature)
                removeFeature((Feature) notifier, null);
        }

        @Override
        public void notifyChanged(Notification notification) {
            super.notifyChanged(notification);

            if((notification.getNotifier() instanceof Feature) && (notification.getFeatureID(Feature.class) == FEATURE__ID)) {
                Feature feature = (Feature) notification.getNotifier();
                removeFeature(feature, notification.getOldStringValue());
                addFeature(feature); // Should have the new ID value.
            }
        }

    }
    
}
