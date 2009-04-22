package org.burroloco.test.butcher.fixture.database;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.java.sql.Connection;
import edge.java.sql.Statement;

public class DefaultMemoryDatabase implements MemoryDatabase {
    Nu nu;

    public Statement statement(String schema) {
        Connection c = connection(schema);
        return c.createStatement();
    }

    private Connection connection(String schema) {
        return nu.nu(Connection.class, "jdbc:hsqldb:mem:" + schema, "sa", "", "org.hsqldb.jdbcDriver");
    }
}
