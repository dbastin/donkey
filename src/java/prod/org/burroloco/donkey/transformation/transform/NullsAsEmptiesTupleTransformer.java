package org.burroloco.donkey.transformation.transform;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.donkey.data.cake.Tuple;
import org.burroloco.donkey.input.database.DatabaseNull;
import static org.burroloco.donkey.transformation.transform.TransformConstants.EMPTY_FIELD;

public class NullsAsEmptiesTupleTransformer implements TupleTransformer {
    TupleTransformer delegate;
    Nu nu;

    public Tuple transform(Tuple in) {
        return delegate.transform(process(in));
    }

    private Tuple process(Tuple tuple) {
        Tuple out = nu.nu(Tuple.class);
        for (String name : tuple.names()) out.add(name, handleNull(tuple.value(name)));
        return out;
    }

    private Object handleNull(Object obj) {
        return (obj instanceof DatabaseNull) ? EMPTY_FIELD : obj;
    }
}
