package cz.zcu.yafmt.ui.editors.fc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.EList;

import cz.zcu.yafmt.model.fc.FeatureConfiguration;
import cz.zcu.yafmt.model.fc.Selection;
import cz.zcu.yafmt.model.fc.util.FeatureConfigurationUtil;
import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.FeatureModel;
import cz.zcu.yafmt.model.fm.Group;
import cz.zcu.yafmt.model.validation.fc.FeatureConfigurationValidator;
import cz.zcu.yafmt.ui.editors.fc.util.VirtualConnectionCache;
import cz.zcu.yafmt.ui.validation.IProblemManager;

public class FeatureConfigurationManager {
    
    // Contains relation between selections which are present in feature configuration and selections which 
    // is possible to add (as their children) to the feature configuration.
    private Map<Selection, List<SelectionInfo>> parentToChildrenVirtualConnection = new HashMap<Selection, List<SelectionInfo>>();
    private Map<Selection, Selection> childrenToParentVirtualConnection = new HashMap<Selection, Selection>();
    private VirtualConnectionCache virtualConnectionCache = new VirtualConnectionCache();
    private boolean makeVirtualConnections = true;
    private boolean makeDisabledVirtualConnetions = false;
    
    private List<IFeatureConfigurationListener> listeners = new ArrayList<IFeatureConfigurationListener>();
    private FeatureConfigurationValidator validator = new FeatureConfigurationValidator(); // If we do not use global instance, validator use cache for compiled constraints.
    private FeatureConfiguration featureConfig;
    private IProblemManager problemManager;

    public FeatureConfigurationManager(FeatureConfiguration featureConfig, IProblemManager problemManager) {
        this.featureConfig = featureConfig;
        this.problemManager = problemManager;
        
        repairFeatureConfiguration();
        rebuildVirtualConnections();
        revalidateFeatureConfiguration();
    }
    
    // ===========================================================================
    //  Basic operations
    // ===========================================================================

    public FeatureConfiguration getFeatureConfiguration() {
        return featureConfig;
    }

    public FeatureModel getFeatureModel() {
        return featureConfig.getFeatureModelCopy();
    }
    
    public IProblemManager getProblemStore() {
        return problemManager;
    }
    
    public void setSelectableFeaturesVisibility(boolean showSelectable, boolean showDisabled) {
        makeVirtualConnections = showSelectable;
        makeDisabledVirtualConnetions = makeVirtualConnections && showDisabled;
        rebuildVirtualConnections();
        fireFeaturesSelected(new ArrayList<Selection>(1));
    }
    
    public void repairFeatureConfiguration() {
        // Repair feature configuration structure against feature model copy.
        FeatureConfigurationUtil.repairConfiguration(featureConfig.getFeatureModelCopy(), featureConfig);
    }

    public void revalidateFeatureConfiguration() {
        problemManager.clearProblems();
        BasicDiagnostic diagnostic = new BasicDiagnostic();
        if(!validator.validateRecursive(featureConfig, diagnostic))
            problemManager.addProblems(diagnostic);
    }

    // ===========================================================================
    //  Virtual connection related operations
    // ===========================================================================

    private void initVirtualConnectionCache() {
        for(Map.Entry<Selection, Selection> entry: childrenToParentVirtualConnection.entrySet())
            virtualConnectionCache.addConnection(entry.getValue(), entry.getKey());
    }
    
    private void clearVirtualConnectionCache() {
        virtualConnectionCache.clear();
    }
    
    public void rebuildVirtualConnections() {
        parentToChildrenVirtualConnection.clear();
        childrenToParentVirtualConnection.clear();

        if(makeVirtualConnections) {
            Feature rootFeature = featureConfig.getFeatureModelCopy().getRoot();
            Selection rootSelection = featureConfig.getRoot();
            createVirtualConnections(rootFeature, rootSelection);
        }
    }
    
    private void addVirtualConnection(Selection parentSelection, Selection childrenSelection, int insertPosition, boolean enabled) {
        SelectionInfo selectionInfo = new SelectionInfo(childrenSelection, insertPosition);
        selectionInfo.selection.setFeatureConfiguration(featureConfig);
        selectionInfo.selection.setEnabled(enabled);

        // Parent to child connection.
        List<SelectionInfo> childrenSelections = parentToChildrenVirtualConnection.get(parentSelection);
        if(childrenSelections == null) {
            childrenSelections = new ArrayList<SelectionInfo>();
            parentToChildrenVirtualConnection.put(parentSelection, childrenSelections);
        }
        childrenSelections.add(selectionInfo);

        // Child to parent connection.
        childrenToParentVirtualConnection.put(childrenSelection, parentSelection);
    }
    
    private void removeVirtualConnection(SelectionInfo selectionInfo) {
        Selection parentSelection = childrenToParentVirtualConnection.remove(selectionInfo.selection);
        parentToChildrenVirtualConnection.get(parentSelection).remove(selectionInfo);
    }

    private void createVirtualConnections(Feature feature, Selection selection) {
        // This expect that children selections are sorted in order given by feature configuration repair process. 
        
        // Process direct children features.
        int startingIndex = 0;
        startingIndex = createVirtualConnections(feature.getFeatures(), startingIndex, selection, Integer.MAX_VALUE);

        // Process children features in each group. 
        for(Group group: feature.getGroups()) {
            int groupUpper = (group.getUpper() == -1) ? Integer.MAX_VALUE : group.getUpper();
            startingIndex = createVirtualConnections(group.getFeatures(), startingIndex, selection, groupUpper);
        }
    }

    private int createVirtualConnections(EList<Feature> childrenFeatures, int startingIndex, Selection parentSelection, int groupUpper) {        
        EList<Selection> childrenSelections = parentSelection.getSelections();
        
        // Look if group allow one more feature to be selected.
        int selectionsInGroupCount = countSelectionsInGroup(childrenFeatures, childrenSelections, startingIndex);
        boolean groupIsFull = selectionsInGroupCount < groupUpper;
        
        // This expect that children selections are sorted in order given by feature configuration repair process.
        for(Feature childFeature: childrenFeatures) {
            String id = childFeature.getId();
            
            // Look how many time can we clone the feature.
            int allowedFeaturesCount = childFeature.getUpper();
            if(allowedFeaturesCount == -1)
                allowedFeaturesCount = Integer.MAX_VALUE;

            // Match selections to features.
            for(int i = startingIndex; i < childrenSelections.size(); i++) {
                Selection childSelection = childrenSelections.get(i);
                if(childSelection.getId().equals(id)) {
                    createVirtualConnections(childFeature, childSelection); // Process children.
                    allowedFeaturesCount--; // One feature clone found.
                    startingIndex++;
                }
                else {
                    break;
                }
            }

            // Allow to select feature only if we don't break local constraint.
            boolean featureAllowed = (allowedFeaturesCount > 0);  // Is another feature clone allowed?
            if(featureAllowed && (groupIsFull || makeDisabledVirtualConnetions)) {
                Selection childSelection = createSelection(parentSelection, childFeature);
                addVirtualConnection(parentSelection, childSelection, startingIndex, groupIsFull);
            }
        }

        return startingIndex;
    }
    
    private int countSelectionsInGroup(EList<Feature> childrenFeatures, EList<Selection> childrenSelections, int startingIndex) {
        int selectionsCount = 0;
        
        // This expect that children selections are sorted in order given by feature configuration repair process.
        for(Feature childFeature: childrenFeatures) {
            String id = childFeature.getId();
            
            // Match selections to features.
            for(int i = startingIndex; i < childrenSelections.size(); i++) {
                Selection childSelection = childrenSelections.get(i);
                if(childSelection.getId().equals(id)) {
                    selectionsCount++;
                    startingIndex++;
                }
                else {
                    break;
                }
            }
        }
        
        return selectionsCount;
    }
    
    private Selection createSelection(Selection parentSelection, Feature childFeature) {
        // Reuse existing selections (therefore even their edit parts) if possible.
        Selection childSelection = virtualConnectionCache.getChildSelection(parentSelection, childFeature.getId());
        if(childSelection != null) {
            childSelection.getValues().clear();
            childSelection.getSelections().clear();
            FeatureConfigurationUtil.repairSelection(childFeature, childSelection);
            return childSelection;
        }
        return FeatureConfigurationUtil.createSelection(childFeature);
    }
        
    // ===========================================================================
    //  Query operations
    // ===========================================================================

    public Selection getParentSelection(Selection childSelection) {
        Selection parentSelection = childSelection.getParent();
        if(parentSelection == null)
            parentSelection = childrenToParentVirtualConnection.get(childSelection);
        return parentSelection;
    }

    public List<Selection> getChildrenSelections(Selection parentSelection) {
        List<Selection> childrenSelections = new ArrayList<Selection>();
        contributeChildrenSelections(parentSelection, childrenSelections, true);
        return childrenSelections;
    }

    public void contributeChildrenSelections(Selection parentSelection, List<Selection> selectionList, boolean sortChildren) {
        if(childrenToParentVirtualConnection.containsKey(parentSelection))
            return;

        selectionList.addAll(parentSelection.getSelections());

        List<SelectionInfo> childrenSelections = parentToChildrenVirtualConnection.get(parentSelection);
        if(childrenSelections == null)
            return;

        if(sortChildren) {
            // InsertPosition does not count other unselected features, so we have to increment it.
            int offset = 0;
            for(SelectionInfo selectionInfo: childrenSelections) {
                // We have to add wrapper, not the original selection, since that is missing parent.
                selectionList.add(selectionInfo.insertPosition + offset, selectionInfo.selection);
                offset++;
            }
        }
        else {
            for(SelectionInfo selectionInfo: childrenSelections)
                selectionList.add(selectionInfo.selection);
        }
    }

    // ===========================================================================
    //  Selection operations
    // ===========================================================================

    public List<Selection> selectFeatures(List<Selection> selections) {
        List<Selection> affectedSelections = new ArrayList<Selection>(selections.size());
        
        for(Selection selection: selections) {
            if(selectFeature(selection))
                affectedSelections.add(selection);
        }

        initVirtualConnectionCache(); // Must be called after selection is performed.
        featuresSelected(affectedSelections);
        clearVirtualConnectionCache();
        
        return affectedSelections;
    }

    public boolean canSelectFeature(Selection selection) {
        return !selection.isPresent() && selection.isEnabled();
    }

    private boolean selectFeature(Selection selection) {
        // Check if it is enabled.
        if(!canSelectFeature(selection))
            return false;
        
        // Look for parent selection.
        Selection parentSelection = childrenToParentVirtualConnection.get(selection);
        if(parentSelection == null)
            return false;

        // Look for sibling selections.
        List<SelectionInfo> childrenSelections = parentToChildrenVirtualConnection.get(parentSelection);
        if(childrenSelections == null)
            return false;

        // Look for position between sibling selections.
        int index = -1;
        for(int i = 0; i < childrenSelections.size(); i++) {
            if(childrenSelections.get(i).selection == selection) {
                index = i;
                break;
            }
        }
        if(index == -1)
            return false;

        // Insert selection to specified position.
        // Also increment position of other, yet unselected features.
        SelectionInfo selectionInfo = childrenSelections.remove(index);
        for(int i = index; i < childrenSelections.size(); i++)
            childrenSelections.get(i).insertPosition++; 
        parentSelection.getSelections().add(selectionInfo.insertPosition, selectionInfo.selection);
        
        // Remove virtual connection!!!
        removeVirtualConnection(selectionInfo);
        return true;
    }

    public void featuresSelected(List<Selection> selections) {
        rebuildVirtualConnections();
        revalidateFeatureConfiguration();
        fireFeaturesSelected(selections);
    }

    // ===========================================================================
    //  Deselection operations
    // ===========================================================================

    public List<Selection> deselectFeatures(List<Selection> selections) {
        List<Selection> affectedSelections = new ArrayList<Selection>(selections.size());
        initVirtualConnectionCache();  // Must be called before deselection is performed.
                
        for(Selection selection: selections) {
            if(deselectFeature(selection))
                affectedSelections.add(selection);
        }

        featuresDeselected(affectedSelections);
        clearVirtualConnectionCache();
        
        return affectedSelections;
    }

    public boolean canDeselectFeature(Selection selection) {
        // Feature must be already selected.
        if(!selection.isPresent())
            return false;

        String id = selection.getId();
        Feature feature = selection.getFeature();
        Selection parentSelection = selection.getParent();
        if(parentSelection == null) // Root selection is present but does not have parent.
            return false;

        // We cannot deselect mandatory feature.
        int count = 0;
        for(Selection childSelection: parentSelection.getSelections()) {
            if(childSelection.getId().equals(id))
                count++;
        }
        return count > feature.getLower();
    }

    private boolean deselectFeature(Selection selection) {
        if(canDeselectFeature(selection)) {
            virtualConnectionCache.addConnection(selection.getParent(), selection); // Cache removed connections.
            selection.setParent(null);
            return true;
        }
        return false;
    }

    public void featuresDeselected(List<Selection> selections) {
        rebuildVirtualConnections();
        revalidateFeatureConfiguration();
        fireFeaturesDeselected(selections);
    }
    
    // ===========================================================================
    //  Listeners
    // ===========================================================================

    public void addFeatureConfigurationListener(IFeatureConfigurationListener listener) {
        listeners.add(listener);
    }

    public void removeFeatureConfigurationListener(IFeatureConfigurationListener listener) {
        listeners.remove(listener);
    }

    protected void fireFeaturesSelected(List<Selection> selections) {
        for(IFeatureConfigurationListener listener: listeners)
            listener.featuresSelected(selections);
    }

    protected void fireFeaturesDeselected(List<Selection> selections) {
        for(IFeatureConfigurationListener listener: listeners)
            listener.featuresDeselected(selections);
    }
    
    // ===========================================================================
    //  Helpers
    // ===========================================================================
    
    // Class containing insert position of unselected feature
    private static class SelectionInfo {
        
        public Selection selection;
        public int insertPosition;

        public SelectionInfo(Selection selection, int insertPosition) {
            this.selection = selection;
            this.insertPosition = insertPosition;
        }
        
    }

}
