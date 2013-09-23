package org.burroloco.donkey.transform;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.donkey.data.core.Tuple;
import org.burroloco.donkey.input.database.DatabaseNull;

public class NullsAsEmptiesTupleGargler implements TupleGargler {
    TupleGargler delegate;
    Nu nu;

    public Tuple gargle(Tuple in) {
        return delegate.gargle(process(in));
    }

    private Tuple process(Tuple tuple) {
        Tuple out = nu.nu(Tuple.class);
        for (String name : tuple.names()) out.add(name, handleNull(tuple.value(name)));
        return out;
    }

    private Object handleNull(Object obj) {
        return (obj instanceof DatabaseNull) ? TransformConstants.EMPTY_FIELD : obj;
    }
}
