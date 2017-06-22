package cz.zcu.yafmt.ui.editors.fc.model;

import cz.zcu.yafmt.model.fc.Selection;

public class Connection {

    private Selection source;
    private Selection target;

    public Connection(Selection source, Selection target) {
        this.source = source;
        this.target = target;
    }

    public Selection getSource() {
        return source;
    }

    public Selection getTarget() {
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
