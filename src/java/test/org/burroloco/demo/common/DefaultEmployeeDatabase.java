package org.burroloco.demo.common;

import edge.java.sql.Connection;
import edge.java.sql.Statement;
import org.burroloco.test.butcher.fixture.database.MemoryDatabase;

public class DefaultEmployeeDatabase implements EmployeeDatabase {
    MemoryDatabase database;

    public void create() {
        Statement s = statement();
        s.execute("create table employee(id int, name varchar)");
        s.execute("insert into EMPLOYEE (ID, NAME) values (1, 'Fred');");
        s.execute("insert into EMPLOYEE (ID, NAME) values (2, 'Wilma');");
        s.execute("insert into EMPLOYEE (ID, NAME) values (3, 'Barney');");
        s.execute("insert into EMPLOYEE (ID, NAME) values (4, 'Betty');");
        s.execute("create table new_employee(id int, name varchar)");
        s.close();
    }

    public void drop() {
        Statement s = statement();
        s.execute("drop table employee");
        s.execute("drop table new_employee");
        s.close();
    }

    private Statement statement() {
        Connection c = database.connection("employee");
        return c.createStatement();
    }
}
