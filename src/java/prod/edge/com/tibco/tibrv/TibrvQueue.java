package edge.com.tibco.tibrv;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;
import au.net.netstorm.boost.bullet.scalpel.core.Unedgable;
import au.net.netstorm.boost.sniper.marker.Destroyable;

public interface TibrvQueue extends Edge, Unedgable, Destroyable {
    void setPriority(int priority);
}
