package org.burroloco.donkey.gargle;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.donkey.data.core.Tuple;

public class DefaultTupleMaster implements TupleMaster {
    Nu nu;

    public Tuple replaceAllValues(Tuple in, Object value, Object v2) {
        Tuple out = nu.nu(Tuple.class);
        for (String key : in.names()) {
            Object original = in.value(key);
            Object replacement = replace(original, value, v2);
            out.add(key, replacement);
        }
        return out;
    }

    private Object replace(Object original, Object v1, Object v2) {
        if (original.equals(v1)) return v2;
        return original;
    }
}
