package org.burroloco.donkey.data.cake;

import org.burroloco.donkey.util.CollectionSubtractor;

import java.util.List;

public class DefaultStripes implements Stripes {
    CollectionSubtractor subtractor;
    Striper striper;

    public List<Slice> minus(Cake c1, Cake c2, String... keys) {
        List<Slice> s1 = striper.stripe(c1, keys);
        List<Slice> s2 = striper.stripe(c2, keys);
        return subtractor.subtract(s1, s2);
    }

    public List<Slice> same(Cake c1, Cake c2, String... keys) {
        List<Slice> a = striper.stripe(c1, keys);
        List<Slice> b = striper.stripe(c2, keys);
        return subtractor.subtract(a, subtractor.subtract(a, b));
    }
}
