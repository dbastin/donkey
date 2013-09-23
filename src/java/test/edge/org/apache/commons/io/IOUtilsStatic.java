package edge.org.apache.commons.io;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;

import java.io.InputStream;

public interface IOUtilsStatic extends Edge {

    byte[] toByteArray(InputStream inputStream);

    String toString(InputStream input);
}
