package org.burroloco.donkey.gargle;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.core.Null;
import org.burroloco.donkey.data.core.Tuple;

public class NullsAsEmptiesTupleGargler implements TupleGargler {
    TupleGargler delegate;
    Nu nu;

    public Tuple gargle(Config c, Tuple in) {
        return delegate.gargle(c, process(in));
    }

    private Tuple process(Tuple tuple) {
        Tuple out = nu.nu(Tuple.class);
        for (String name : tuple.names()) out.add(name, handleNull(tuple.value(name)));
        return out;
    }

    private Object handleNull(Object obj) {
        return (obj instanceof Null) ? TransformConstants.EMPTY_FIELD : obj;
    }
}
