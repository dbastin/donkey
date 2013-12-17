package edge.org.apache.http.client.methods;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;

import java.net.URI;

public interface HttpPost extends Edge, HttpEntityEnclosingRequestBase {
    URI getURI();
    void setURI(URI uri);
}
