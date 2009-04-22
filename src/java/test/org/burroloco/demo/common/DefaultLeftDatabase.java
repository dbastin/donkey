package org.burroloco.demo.common;

import edge.java.sql.Statement;
import org.burroloco.test.butcher.fixture.database.MemoryDatabase;

public class DefaultLeftDatabase implements LeftDatabase {
    private static final String NAME = "employee";
    MemoryDatabase database;

    public void create() {
        Statement s = database.statement(NAME);
        s.execute("create table employee(id int, name varchar)");
        s.execute("insert into EMPLOYEE (ID, NAME) values (1, 'Fred');");
        s.execute("insert into EMPLOYEE (ID, NAME) values (2, 'Wilma');");
        s.execute("insert into EMPLOYEE (ID, NAME) values (3, 'Barney');");
        s.execute("insert into EMPLOYEE (ID, NAME) values (4, 'Betty');");
        // FIX TSR-DONKEY Remove when jdbcToJdbc is complete...
        s.execute("create table new_employee(id int, name varchar)");
        s.close();
    }

    // FIX TSR-DONKEY Remove when jdbcToJdbc is complete...
    //SIMIAN OFF
    public void drop() {
        Statement s = database.statement(NAME);
        s.execute("drop table employee");
        // FIX TSR-DONKEY Remove when jdbcToJdbc is complete...
        s.execute("drop table new_employee");
        s.close();
    }
    //SIMIAN ON

}
