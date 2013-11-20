package org.burroloco.donkey.gargle;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.core.Null;
import org.burroloco.donkey.data.core.Tuple;

import static org.burroloco.donkey.gargle.GarglerConstants.EMPTY_FIELD;

public class NullsAsEmptiesTupleGargler implements TupleGargler {
    TupleGargler delegate;
    Nu nu;

    public Tuple gargle(Config c, Tuple in) {
        return delegate.gargle(c, process(in));
    }

    private Tuple process(Tuple tuple) {
        Tuple out = nu.nu(Tuple.class);
        for (String name : tuple.names()) {
            Object nvl = nvl(tuple, name);
            out.add(name, nvl);
        }
        return out;
    }

    private Object nvl(Tuple tuple, String name) {
        Object value = tuple.value(name);
        return handleNull(value);
    }

    private Object handleNull(Object obj) {
        return (obj instanceof Null) ? EMPTY_FIELD : obj;
    }
}
