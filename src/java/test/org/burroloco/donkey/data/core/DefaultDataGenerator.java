package org.burroloco.donkey.data.core;

import au.net.netstorm.boost.spider.api.runtime.Nu;

public class DefaultDataGenerator implements DataGenerator {
    Nu nu;

    public Data data(int start, int end, String value) {
        Data data = nu.nu(Data.class);
        for (int i = start; i <= end; i++)
            data.add(tuple(i, value));
        return data;
    }

    private Tuple tuple(int key, String value) {
        Tuple tuple = nu.nu(Tuple.class);
        tuple.add("key", key);
        tuple.add("value", value);
        tuple.add("anotherValue", "meep");
        tuple.add("yetAnotherValue", "aarp");
        return tuple;
    }
}
