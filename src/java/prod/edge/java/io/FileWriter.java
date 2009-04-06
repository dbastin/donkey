package edge.java.io;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;

public interface FileWriter extends Edge {
    void write(String str);

    void close();
}
