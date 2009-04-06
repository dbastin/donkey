package edge.java.sql;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;

public interface Connection extends Edge {

    Statement createStatement();

    void close();

    void setAutoCommit(boolean b);
}