package cz.zcu.yafmt.ui.editors.fm.model;

import org.eclipse.emf.ecore.EObject;

import cz.zcu.yafmt.model.fm.Feature;

public class Connection {

    private EObject source;
    private Feature target;

    public Connection(EObject source, Feature target) {
        this.source = source;
        this.target = target;
    }

    public EObject getSource() {
        return source;
    }

    public Feature getTarget() {
        return target;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Connection))
            return false;
        Connection con = (Connection) obj;
        return (source == con.source) && (target == con.target);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        if(source != null)
            hash += source.hashCode();
        if(target != null)
            hash += target.hashCode();
        return hash;
    }

}
