package org.burroloco.test.butcher.fixture.database;

import edge.java.sql.Connection;

public interface MemoryDatabase {
    Connection connection(String schema);
}
