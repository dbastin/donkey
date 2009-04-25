package org.burroloco.test.butcher.fixture.database;

import edge.java.sql.Statement;

public class DefaultInputDatabase implements InputDatabase {
    private static final String NAME = "input";
    MemoryDatabase database;

    public void create() {
        Statement s = database.statement(NAME);
        s.execute("CREATE TABLE EMPLOYEE(ID INT, NAME VARCHAR, SALARY INT, START DATE)");
        s.execute("INSERT INTO EMPLOYEE (ID, NAME, SALARY, START) VALUES (1, 'Fred', 1000000, '2001-01-01');");
        s.execute("INSERT INTO EMPLOYEE (ID, NAME, SALARY, START) VALUES (2, 'Wilma', 2000000, '2002-01-01');");
        s.execute("INSERT INTO EMPLOYEE (ID, NAME, SALARY, START) VALUES (3, 'Barney', 3000000, '2003-01-01');");
        s.execute("INSERT INTO EMPLOYEE (ID, NAME, SALARY, START) VALUES (4, 'Betty', 4000000, null);");
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
