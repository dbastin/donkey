package org.burroloco.butcher.fixture.harness;

import org.burroloco.donkey.data.core.Tuple;
import org.burroloco.donkey.xml.marshal.Employee;

import java.util.Date;

import static org.burroloco.butcher.util.date.StringDater.date;

public interface Harness {
    Integer ID = 1;
    String NAME = "Fred";
    Integer SALARY = 1000000;
    Date START = date("2001-01-01");

    Employee employee();

    Tuple tuple();
}
