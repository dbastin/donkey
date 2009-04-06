package edge.com.tibco.tibrv;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;

public interface TibrvStatic extends Edge {
    void open(int mode);

    void close();
}
