package edge.java.sql;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;

public interface DriverManagerStatic extends Edge {
    Connection getConnection(String url, String user, String password);
}