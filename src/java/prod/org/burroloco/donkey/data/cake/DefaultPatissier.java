package org.burroloco.donkey.data.cake;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.donkey.util.CollectionSubtractor;

import java.util.ArrayList;
import java.util.List;

public class DefaultPatissier implements Patissier {
    CollectionSubtractor subtractor;
    Striper striper;
    Stripes stripes;
    Nu nu;

    public Data same(Data c1, Data c2) {
        List<Tuple> a = mutants(c1);
        List<Tuple> b = c2.tuples();
        return cake(subtractor.subtract(a, subtractor.subtract(a, b)));
    }

    public Data minus(Data c1, Data c2, String... keys) {
        List<Tuple> s1 = stripes.minus(c1, c2, keys);
        return filter(c1, cake(s1));
    }

    public Data changes(Data c1, Data c2, String... keys) {
        List<Tuple> sameKeys = stripes.same(c1, c2, keys);
        List<Tuple> sameSame = striper.stripe(same(c1, c2), keys);
        List<Tuple> subtracted = subtractor.subtract(sameKeys, sameSame);
        return filter(c1, cake(subtracted));
    }

    private List<Tuple> mutants(Data c) {
        return new ArrayList<Tuple>(c.tuples());
    }

    private Data cake(List<Tuple> tuples) {
        Data result = nu.nu(Data.class);
        result.addAll(tuples);
        return result;
    }

    private Data filter(Data c, Data values) {
        CakeFilter filter = nu.nu(CakeFilter.class, values);
        return filter.filter(c);
    }
}
