package org.burroloco.test.butcher.fixture.database;

import edge.java.sql.Statement;

public interface MemoryDatabase {
    Statement statement(String schema);
}
