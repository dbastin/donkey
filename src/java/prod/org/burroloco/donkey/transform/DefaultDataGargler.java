package org.burroloco.donkey.transform;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.core.Data;
import org.burroloco.donkey.data.core.Tuple;
import org.burroloco.donkey.error.transform.ExceptionHandler;

import java.util.List;

public class DefaultDataGargler implements DataGargler {
    ExceptionHandler handler;
    TupleGargler transformer;
    Nu nu;

    public Data gargle(Config config, Data in) {
        Data out = nu.nu(Data.class);
        List<Tuple> tuples = in.tuples();
        for (Tuple tuple : tuples) transform(out, tuple);
        return out;
    }

    private void transform(Data out, Tuple tuple) {
        try {
            Tuple transformed = transformer.gargle(tuple);
            out.add(transformed);
        } catch (RuntimeException e) {
            handler.handle(tuple, e);
        }
    }
}
