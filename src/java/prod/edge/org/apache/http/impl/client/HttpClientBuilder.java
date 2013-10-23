package edge.org.apache.http.impl.client;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;
import edge.org.apache.http.conn.socket.LayeredConnectionSocketFactory;

public interface HttpClientBuilder extends Edge {
    HttpClientBuilder setSSLSocketFactory(LayeredConnectionSocketFactory f);

    CloseableHttpClient build();
}
