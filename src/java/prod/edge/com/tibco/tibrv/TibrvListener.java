package edge.com.tibco.tibrv;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;
import au.net.netstorm.boost.bullet.scalpel.core.Unedgable;

public interface TibrvListener extends Edge, Unedgable {
    String getSubject();

    TibrvTransport getTransport();
}
