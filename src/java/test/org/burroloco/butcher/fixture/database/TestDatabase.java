package org.burroloco.butcher.fixture.database;

public interface TestDatabase {
    void create();

    void drop();

    Integer count(String table);

}
