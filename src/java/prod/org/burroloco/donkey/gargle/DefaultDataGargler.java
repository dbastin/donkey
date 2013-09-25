package org.burroloco.donkey.gargle;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.core.Data;
import org.burroloco.donkey.data.core.Tuple;
import org.burroloco.donkey.exception.gargle.GarglerExceptionHandler;

import java.util.List;

public class DefaultDataGargler implements DataGargler {
    GarglerExceptionHandler exceptions;
    TupleGargler transformer;
    Nu nu;

    public Data gargle(Config config, Data in) {
        Data out = nu.nu(Data.class);
        List<Tuple> tuples = in.tuples();
        for (Tuple tuple : tuples) gargle(out, tuple);
        return out;
    }

    private void gargle(Data out, Tuple tuple) {
        try {
            Tuple transformed = transformer.gargle(tuple);
            out.add(transformed);
        } catch (RuntimeException e) {
            exceptions.handle(tuple, e);
        }
    }
}
