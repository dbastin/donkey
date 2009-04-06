package edge.java.sql;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;

public interface ResultSet extends Edge {
    ResultSetMetaData getMetaData();

    boolean next();

    Object getObject(int index);
}