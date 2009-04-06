package edge.java.sql;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;


public interface Statement extends Edge {
    ResultSet executeQuery(String sql);

    void executeUpdate(String sql);

    void execute(String sql);

    void close();

    void setMaxRows(int max);

    void setFetchSize(int size);
}