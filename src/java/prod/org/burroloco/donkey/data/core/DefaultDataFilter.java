package org.burroloco.donkey.data.core;

import au.net.netstorm.boost.spider.api.runtime.Nu;

import java.util.List;
import java.util.Set;

public class DefaultDataFilter implements DataFilter {
    private final Data values;
    Nu nu;

    public DefaultDataFilter(Data values) {
        this.values = values;
    }

    public Data filter(Data c) {
        Data result = nu.nu(Data.class);
        for (Tuple candidate : c.tuples()) if (accept(candidate)) result.add(candidate);
        result.readOnly();
        return result;
    }

    private boolean accept(Tuple candidate) {
        List<Tuple> keys = values.tuples();
        for (Tuple key : keys) if (match(key, candidate)) return true;
        return false;
    }

    private boolean match(Tuple key, Tuple tuple) {
        Set<String> keyNames = key.names();
        for (String keyName : keyNames) {
            Object a = key.value(keyName);
            Object b = tuple.value(keyName);
            if (!a.equals(b)) return false;
        }
        return true;
    }
}
