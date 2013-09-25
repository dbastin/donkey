package edge.org.apache.http.client;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;
import edge.org.apache.http.HttpResponse;
import edge.org.apache.http.client.methods.HttpUriRequest;

public interface HttpClient extends Edge {
    HttpResponse execute (HttpUriRequest request);
}
