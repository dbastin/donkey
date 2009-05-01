package edge.org.mortbay.jetty;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;
import org.mortbay.jetty.Handler;

public interface Server extends Edge {
    void setHandler(Handler handler);

    void start();
}
