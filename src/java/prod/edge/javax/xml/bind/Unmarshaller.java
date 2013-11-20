package edge.javax.xml.bind;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;
import edge.java.io.InputStream;

public interface Unmarshaller extends Edge {
    Object unmarshal(InputStream is);
}
