package org.burroloco.donkey.transformation.transform;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.donkey.data.cake.Slice;
import org.burroloco.donkey.input.database.DatabaseNull;
import static org.burroloco.donkey.transformation.transform.TransformConstants.EMPTY_FIELD;

public class NullsAsEmptiesTransform implements Transform {
    Transform delegate;
    Nu nu;

    public Slice transform(Slice in) {
        return delegate.transform(process(in));
    }

    private Slice process(Slice slice) {
        Slice out = nu.nu(Slice.class);
        for (String name : slice.names()) out.add(name, handleNull(slice.value(name)));
        return out;
    }

    private Object handleNull(Object obj) {
        return (obj instanceof DatabaseNull) ? EMPTY_FIELD : obj;
    }
}
