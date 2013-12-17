package edge.org.apache.http.client.methods;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;
import org.apache.http.Header;

public interface HttpPost extends Edge, HttpEntityEnclosingRequestBase {
    Header[] getHeaders(String name);
}
