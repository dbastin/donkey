package org.burroloco.demo.jdbc2csv;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.donkey.data.cake.Slice;
import org.burroloco.donkey.transformation.transform.Transform;

public class EmployeeTransform implements Transform {
    Nu nu;

    public Slice transform(Slice in) {
        noPets(in);
        Slice out = nu.nu(Slice.class);
        out.add("ID", multiply("ID", in));
        out.add("NAME", toUpper("NAME", in));
        return out;
    }

    private void noPets(Slice in) {
        String name = (String) in.value("NAME");
        if (name.equals("Dino")) throw new InvalidEmployeeException(name);
    }

    private int multiply(String key, Slice in) {
        int i = (Integer) in.value(key);
        return i * 1000;
    }

    private String toUpper(String key, Slice in) {
        String s = (String) in.value(key);
        return s.toUpperCase();
    }
}
