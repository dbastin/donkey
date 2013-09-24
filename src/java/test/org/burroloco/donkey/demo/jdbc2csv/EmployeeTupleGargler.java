package org.burroloco.donkey.demo.jdbc2csv;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.donkey.data.core.Tuple;
import org.burroloco.donkey.gargle.TupleGargler;

public class EmployeeTupleGargler implements TupleGargler {
    Nu nu;

    public Tuple gargle(Tuple in) {
        noPets(in);
        Tuple out = nu.nu(Tuple.class);
        out.add("ID", multiply("ID", in));
        out.add("NAME", toUpper("NAME", in));
        return out;
    }

    private void noPets(Tuple in) {
        String name = (String) in.value("NAME");
        if (name.equals("Dino")) throw new InvalidEmployeeException(name);
    }

    private int multiply(String key, Tuple in) {
        int i = (Integer) in.value(key);
        return i * 1000;
    }

    private String toUpper(String key, Tuple in) {
        String s = (String) in.value(key);
        return s.toUpperCase();
    }
}
