package org.burroloco.butcher.fixture.harness;

import org.burroloco.donkey.data.core.Data;
import org.burroloco.donkey.data.core.DefaultData;
import org.burroloco.donkey.data.core.DefaultTuple;
import org.burroloco.donkey.data.core.Tuple;
import org.burroloco.donkey.xml.marshal.Employee;

public class DefaultHarness implements Harness {

    public Employee employee() {
        Employee e = new Employee();
        e.setId(ID);
        e.setName(NAME);
        e.setSalary(SALARY);
        e.setStartDate(START);
        e.setPositionTitle(TITLE);
        return e;
    }

    public Tuple tuple() {
        Tuple t = new DefaultTuple();
        t.add("id", ID);
        t.add("name", NAME);
        t.add("salary", SALARY);
        t.add("start_date", START);
        t.add("position_title", TITLE);
        t.readOnly();
        return t;
    }

    public Data rows() {
        Data rows = new DefaultData();
        Tuple row = tuple();
        rows.add(row);
        rows.readOnly();
        return rows;
    }
}
