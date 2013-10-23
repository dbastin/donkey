package edge.org.apache.http;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;
import org.apache.http.StatusLine;

public interface HttpResponse extends Edge {
    HttpEntity getEntity();
    StatusLine getStatusLine();
}
