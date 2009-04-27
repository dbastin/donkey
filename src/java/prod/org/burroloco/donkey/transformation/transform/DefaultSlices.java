package org.burroloco.donkey.transformation.transform;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.donkey.data.cake.Slice;

public class DefaultSlices implements Slices {
    Nu nu;

    public Slice replaceAllValues(Slice in, Object v1, Object v2) {
        Slice out = nu.nu(Slice.class);
        for (String name : in.names()) {
            Object original = in.value(name);
            out.add(name, replace(original, v1, v2));
        }
        return out;
    }

    private Object replace(Object original, Object v1, Object v2) {
        if (original.equals(v1)) return v2;
        return original;
    }
}
