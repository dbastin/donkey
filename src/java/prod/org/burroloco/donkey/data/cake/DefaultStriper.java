package org.burroloco.donkey.data.cake;

import au.net.netstorm.boost.spider.api.runtime.Nu;

import java.util.ArrayList;
import java.util.List;

public class DefaultStriper implements Striper {
    Nu nu;

    public List<Slice> stripe(Cake c, String... names) {
        List<Slice> stripe = new ArrayList<Slice>();
        for (Slice slice : c.slices()) {
            shrink(stripe, slice, names);
        }
        return stripe;
    }

    private void shrink(List<Slice> stripe, Slice slice, String... names) {
        Slice s = nu.nu(Slice.class);
        for (String name : names) {
            s.add(name, slice.value(name));
        }
        stripe.add(s);
    }
}
