package edge.org.apache.commons.io;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;
import edge.java.io.InputStream;

public interface IOUtilsStatic extends Edge {
    byte[] toByteArray(InputStream inputStream);
}
