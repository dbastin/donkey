package edge.org.eclipse.jetty.server;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Handler;

public interface Server extends Edge {
    void setHandler(Handler handler);

    void addConnector(Connector c);

    void start();

    void stop();

    void join();
}
