package org.burroloco.donkey.data.core;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.donkey.util.CollectionSubtractor;

import java.util.ArrayList;
import java.util.List;

public class DefaultDataMaster implements DataMaster {
    CollectionSubtractor subtractor;
    Striper striper;
    Stripes stripes;
    Nu nu;

    public Data intersection(Data d1, Data d2) {
        List<Tuple> a = mutants(d1);
        List<Tuple> b = d2.tuples();
        return toData(subtractor.subtract(a, subtractor.subtract(a, b)));
    }

    public Data minus(Data d1, Data d2, String... keys) {
        List<Tuple> s1 = stripes.minus(d1, d2, keys);
        return filter(d1, toData(s1));
    }

    public Data diffs(Data d1, Data d2, String... keys) {
        List<Tuple> sameKeys = stripes.same(d1, d2, keys);
        List<Tuple> sameSame = striper.stripe(intersection(d1, d2), keys);
        List<Tuple> subtracted = subtractor.subtract(sameKeys, sameSame);
        return filter(d1, toData(subtracted));
    }

    private List<Tuple> mutants(Data d) {
        return new ArrayList<Tuple>(d.tuples());
    }

    private Data toData(List<Tuple> tuples) {
        Data result = nu.nu(Data.class);
        result.addAll(tuples);
        return result;
    }

    private Data filter(Data d, Data values) {
        DataFilter filter = nu.nu(DataFilter.class, values);
        return filter.filter(d);
    }
}
