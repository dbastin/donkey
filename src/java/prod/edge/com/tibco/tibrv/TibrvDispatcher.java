package edge.com.tibco.tibrv;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;
import au.net.netstorm.boost.sniper.marker.Destroyable;

public interface TibrvDispatcher extends Edge,Destroyable {
    void join();
}
