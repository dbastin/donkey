package org.burroloco.donkey.data.core;

import au.net.netstorm.boost.spider.api.runtime.Nu;

import java.util.ArrayList;
import java.util.List;

public class DefaultStriper implements Striper {
    Nu nu;

    public List<Tuple> stripe(Data c, String... names) {
        List<Tuple> stripe = new ArrayList<Tuple>();
        for (Tuple tuple : c.tuples()) {
            shrink(stripe, tuple, names);
        }
        return stripe;
    }

    private void shrink(List<Tuple> stripe, Tuple tuple, String... names) {
        Tuple s = nu.nu(Tuple.class);
        for (String name : names) {
            s.add(name, tuple.value(name));
        }
        stripe.add(s);
    }
}
