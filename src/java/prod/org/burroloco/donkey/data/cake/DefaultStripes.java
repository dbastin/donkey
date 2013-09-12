package org.burroloco.donkey.data.cake;

import org.burroloco.donkey.util.CollectionSubtractor;

import java.util.List;

public class DefaultStripes implements Stripes {
    CollectionSubtractor subtractor;
    Striper striper;

    public List<Tuple> minus(Data c1, Data c2, String... keys) {
        List<Tuple> s1 = striper.stripe(c1, keys);
        List<Tuple> s2 = striper.stripe(c2, keys);
        return subtractor.subtract(s1, s2);
    }

    public List<Tuple> same(Data c1, Data c2, String... keys) {
        List<Tuple> a = striper.stripe(c1, keys);
        List<Tuple> b = striper.stripe(c2, keys);
        return subtractor.subtract(a, subtractor.subtract(a, b));
    }
}
