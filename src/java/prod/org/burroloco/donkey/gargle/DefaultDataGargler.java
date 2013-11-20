package org.burroloco.donkey.gargle;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.core.Data;
import org.burroloco.donkey.data.core.Tuple;
import org.burroloco.donkey.exception.gargle.GarglerExceptionHandler;

import java.util.List;

public class DefaultDataGargler implements DataGargler {
    GarglerExceptionHandler exceptions;
    TupleGargler gargler;
    Nu nu;

    public Data gargle(Config config, Data in) {
        Data results = nu.nu(Data.class);
        List<Tuple> tuples = in.tuples();
        gargle(results, config, tuples);
        results.readOnly();
        return results;
    }

    private void gargle(Data results, Config config, List<Tuple> tuples) {
        for (Tuple in : tuples) {
            try {
                Tuple result = gargler.gargle(config, in);
                results.add(result);
            } catch (RuntimeException e) {
                exceptions.handle(in, e);
            }
        }
    }

}
