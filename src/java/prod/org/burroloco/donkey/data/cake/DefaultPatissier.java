package org.burroloco.donkey.data.cake;

import au.net.netstorm.boost.spider.api.runtime.Nu;

import java.util.ArrayList;
import java.util.List;

public class DefaultPatissier implements Patissier {
    Striper striper;
    Stripes stripes;
    Nu nu;

    public Cake same(Cake c1, Cake c2) {
        List<Slice> a = mutants(c1);
        List<Slice> b = c2.slices();
        a.retainAll(b);
        return cake(a);
    }

    public Cake minus(Cake c1, Cake c2, String... keys) {
        List<Slice> s1 = stripes.minus(c1, c2, keys);
        return filter(c1, cake(s1));
    }

    public Cake changes(Cake c1, Cake c2, String... keys) {
        List<Slice> sameKeys = stripes.same(c1, c2, keys);
        List<Slice> sameSame = striper.stripe(same(c1, c2), keys);
        sameKeys.removeAll(sameSame);
        return filter(c1, cake(sameKeys));
    }

    private List<Slice> mutants(Cake c) {
        return new ArrayList<Slice>(c.slices());
    }

    private Cake cake(List<Slice> slices) {
        Cake result = nu.nu(Cake.class);
        result.addAll(slices);
        return result;
    }

    private Cake filter(Cake c, Cake values) {
        CakeFilter filter = nu.nu(CakeFilter.class, values);
        return filter.filter(c);
    }
}
