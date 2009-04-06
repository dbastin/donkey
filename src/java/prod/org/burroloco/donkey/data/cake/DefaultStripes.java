package org.burroloco.donkey.data.cake;

import java.util.List;

public class DefaultStripes implements Stripes {
    Striper striper;

    public List<Slice> minus(Cake c1, Cake c2, String... keys) {
        List<Slice> s1 = striper.stripe(c1, keys);
        List<Slice> s2 = striper.stripe(c2, keys);
        s1.removeAll(s2);
        return s1;
    }

    public List<Slice> same(Cake c1, Cake c2, String... keys) {
        List<Slice> a = striper.stripe(c1, keys);
        List<Slice> b = striper.stripe(c2, keys);
        a.retainAll(b);
        return a;
    }
}
