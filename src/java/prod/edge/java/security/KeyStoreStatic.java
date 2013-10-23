package edge.java.security;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;

public interface KeyStoreStatic extends Edge {
    String getDefaultType();

    KeyStore getInstance(String type);
}
