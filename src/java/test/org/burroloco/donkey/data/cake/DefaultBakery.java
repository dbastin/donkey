package org.burroloco.donkey.data.cake;

import au.net.netstorm.boost.spider.api.runtime.Nu;

public class DefaultBakery implements Bakery {
    Nu nu;

    public Data cake(int start, int end, String flavour) {
        Data data = nu.nu(Data.class);
        for (int i = start; i <= end; i++)
            data.add(bake(i, flavour));
        return data;
    }

    private Tuple bake(int key, String flavour) {
        Tuple tuple = nu.nu(Tuple.class);
        tuple.add("key", key);
        tuple.add("flavour", flavour);
        tuple.add("mainly", "flour");
        tuple.add("some.Ref", "egg");
        return tuple;
    }
}
