package edge.com.tibco.tibrv;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;
import au.net.netstorm.boost.sniper.marker.Destroyable;

public interface TibrvTransport extends Edge, Destroyable {
    String createInbox();

    void send(TibrvMsg message);
}
