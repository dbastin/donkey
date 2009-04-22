package org.burroloco.demo.common;

import edge.java.sql.Statement;
import edge.java.sql.ResultSet;
import org.burroloco.test.butcher.fixture.database.MemoryDatabase;

public class DefaultRightDatabase implements RightDatabase {
    private static final String NAME = "newemployee";
    MemoryDatabase database;

    public void create() {
        Statement s = database.statement(NAME);
        s.execute("create table new_employee(id int, name varchar)");
        s.close();
    }

    public void drop() {
        Statement s = database.statement(NAME);
        s.execute("drop table new_employee");
        s.close();
    }

    public Integer count(String table) {
        Statement s = database.statement(NAME);
        ResultSet results = s.executeQuery("select count(*) from " + table);
        results.next();
        return (Integer) results.getObject(1);
    }
}