package org.burroloco.demo.common;

import edge.java.sql.Statement;
import org.burroloco.test.butcher.fixture.database.MemoryDatabase;

public class DefaultInputDatabase implements InputDatabase {
    private static final String NAME = "input";
    MemoryDatabase database;

    public void create() {
        Statement s = database.statement(NAME);
        s.execute("CREATE TABLE EMPLOYEE(ID INT, NAME VARCHAR)");
        s.execute("INSERT INTO EMPLOYEE (ID, NAME) VALUES (1, 'Fred');");
        s.execute("INSERT INTO EMPLOYEE (ID, NAME) VALUES (2, 'Wilma');");
        s.execute("INSERT INTO EMPLOYEE (ID, NAME) VALUES (3, 'Barney');");
        s.execute("INSERT INTO EMPLOYEE (ID, NAME) VALUES (4, 'Betty');");
        s.close();
    }

    public void drop() {
        Statement s = database.statement(NAME);
        s.execute("DROP TABLE EMPLOYEE");
        s.close();
    }

    public Integer count(String table) {
        return database.count(NAME, table);
    }
}
