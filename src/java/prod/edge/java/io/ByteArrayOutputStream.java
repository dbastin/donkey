package edge.java.io;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;

public interface ByteArrayOutputStream extends Edge, OutputStream {

    String toString(String encoding);
}
