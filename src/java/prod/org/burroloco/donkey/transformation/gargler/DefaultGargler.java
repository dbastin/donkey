package org.burroloco.donkey.transformation.gargler;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.cake.Data;
import org.burroloco.donkey.data.cake.Tuple;
import org.burroloco.donkey.error.transform.ErrorHandler;
import org.burroloco.donkey.transformation.transform.TupleTransformer;

import java.util.List;

public class DefaultGargler implements Gargler {
    TupleTransformer transformer;
    ErrorHandler handler;
    Nu nu;

    public Data gargle(Config config, Data in) {
        Data out = nu.nu(Data.class);
        List<Tuple> tuples = in.tuples();
        for (Tuple tuple : tuples) transform(out, tuple);
        return out;
    }

    private void transform(Data out, Tuple tuple) {
        try {
            Tuple transformed = transformer.transform(tuple);
            out.add(transformed);
        } catch (RuntimeException e) {
            handler.handle(tuple, e);
        }
    }
}
