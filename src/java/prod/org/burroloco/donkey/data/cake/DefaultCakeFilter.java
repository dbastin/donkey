package org.burroloco.donkey.data.cake;

import au.net.netstorm.boost.spider.api.runtime.Nu;

import java.util.List;
import java.util.Set;

public class DefaultCakeFilter implements CakeFilter {
    private final Cake values;
    Nu nu;

    public DefaultCakeFilter(Cake values) {
        this.values = values;
    }

    public Cake filter(Cake c) {
        Cake result = nu.nu(Cake.class);
        for (Slice candidate : c.slices()) if (accept(candidate)) result.add(candidate);
        return result;
    }

    private boolean accept(Slice candidate) {
        List<Slice> keys = values.slices();
        for (Slice key : keys) if (match(key, candidate)) return true;
        return false;
    }

    private boolean match(Slice key, Slice slice) {
        Set<String> keyNames = key.names();
        boolean match = true;
        for (String keyName : keyNames) {
            Object a = key.value(keyName);
            Object b = slice.value(keyName);
            match &= a.equals(b);
        }
        return match;
    }
}
