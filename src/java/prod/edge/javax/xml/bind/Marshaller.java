package edge.javax.xml.bind;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;
import edge.java.io.OutputStream;

public interface Marshaller extends Edge {
    void marshal(Object o, OutputStream stream);

    void setProperty(String key, Object value);
}
