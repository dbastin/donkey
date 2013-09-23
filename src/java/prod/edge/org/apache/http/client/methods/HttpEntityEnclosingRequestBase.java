package edge.org.apache.http.client.methods;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;
import edge.org.apache.http.HttpEntity;

public interface HttpEntityEnclosingRequestBase extends Edge, HttpUriRequest {
    void setEntity(HttpEntity entity);
}
