package org.burroloco.test.butcher.fixture.database;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import edge.java.sql.Connection;

public class DefaultMemoryDatabase implements MemoryDatabase {
    Nu nu;

    public Connection connection(String schema) {
        return nu.nu(Connection.class, "jdbc:hsqldb:mem:" + schema, "sa", "", "org.hsqldb.jdbcDriver");
    }
}
