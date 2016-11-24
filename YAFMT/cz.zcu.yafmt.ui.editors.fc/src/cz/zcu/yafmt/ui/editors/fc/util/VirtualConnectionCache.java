package cz.zcu.yafmt.ui.editors.fc.util;

import java.util.HashMap;
import java.util.Map;

import cz.zcu.yafmt.model.fc.Selection;

// Cache for selections which are to be removed from feature configuration.
public class VirtualConnectionCache {

    private Map<Key, Selection> connections = new HashMap<Key, Selection>();
    
    public void addConnection(Selection parentSelection, Selection childSelection) {
        connections.put(new Key(parentSelection, childSelection.getId()), childSelection);
    }
    
    public Selection getChildSelection(Selection parentSelection, String childSelectionId) {
        return connections.get(new Key(parentSelection, childSelectionId));
    }
    
    public void clear() {
        connections.clear();
    }
    
    private static class Key {
        
        private Selection parentSelection;
        private String childSelectionId;
        
        public Key(Selection parentSelection, String childSelectionId) {
            this.parentSelection = parentSelection;
            this.childSelectionId = childSelectionId;
        }
        
        @Override
        public int hashCode() {
            return parentSelection.hashCode() + childSelectionId.hashCode();
        }
        
        @Override
        public boolean equals(Object obj) {
            if(!(obj instanceof Key))
                return false;
            Key key = (Key) obj;
            return (parentSelection.equals(key.parentSelection)) && (childSelectionId.equals(key.childSelectionId));
        }
        
    }
    
}
