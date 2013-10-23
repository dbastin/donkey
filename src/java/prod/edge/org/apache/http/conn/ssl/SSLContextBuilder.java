package edge.org.apache.http.conn.ssl;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;
import edge.java.security.KeyStore;
import edge.javax.net.ssl.SSLContext;

public interface SSLContextBuilder extends Edge {
    SSLContextBuilder loadTrustMaterial(KeyStore keyStore);

    SSLContext build();
}
