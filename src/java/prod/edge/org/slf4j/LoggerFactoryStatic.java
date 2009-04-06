package edge.org.slf4j;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;

public interface LoggerFactoryStatic extends Edge {
    Logger getLogger(Class cls);
}
