package edge.java.util;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;
import edge.java.io.InputStream;

import java.util.Set;

public interface Properties extends Edge {
    void setProperty(String key, String value);

    void load(InputStream is);

    boolean containsKey(Object key);

    String getProperty(String key);

    Set keySet();
}
