package edge.java.io;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;

public interface PrintWriter extends Edge {
    void print(Object obj);

    void println();

    void println(Object obj);

    void flush();

    void close();
}
