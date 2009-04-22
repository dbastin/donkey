package org.burroloco.demo.common;

import edge.java.sql.Statement;
import org.burroloco.test.butcher.fixture.database.MemoryDatabase;

public class DefaultOutputDatabase implements OutputDatabase {
    private static final String NAME = "output";
    MemoryDatabase database;

    public void create() {
        Statement s = database.statement(NAME);
        s.execute("CREATE TABLE EMP(ID INT, NAME VARCHAR)");
        s.close();
    }

    public void drop() {
        Statement s = database.statement(NAME);
        s.execute("DROP TABLE EMP");
        s.close();
    }

    public Integer count(String table) {
        return database.count(NAME, table);
    }
}