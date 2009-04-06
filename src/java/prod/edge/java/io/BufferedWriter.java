package edge.java.io;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;

public interface BufferedWriter extends Edge {
    void write(String s);

    void close();
}
