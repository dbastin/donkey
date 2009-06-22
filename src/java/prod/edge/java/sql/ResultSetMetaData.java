package edge.java.sql;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;

public interface ResultSetMetaData extends Edge {
    int getColumnCount();

    String getColumnLabel(int i);

    String getColumnTypeName(int column);
}