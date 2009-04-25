package org.burroloco.test.butcher.fixture.database;

public interface TestDatabase {
    void create();

    void drop();

    Integer count(String table);

}
