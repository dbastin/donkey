package edge.java.security;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;
import edge.java.io.InputStream;

public interface KeyStore extends Edge {
    void load(InputStream inputStream, char[] password);
}
