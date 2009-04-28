package org.burroloco.butcher.fixture.database;

import edge.java.sql.Statement;

public interface MemoryDatabase {
    Statement statement(String schema);

    Integer count(String name, String table);
}
