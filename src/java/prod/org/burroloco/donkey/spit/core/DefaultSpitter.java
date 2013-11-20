package org.burroloco.donkey.spit.core;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.core.Data;
import org.burroloco.donkey.data.core.Tuple;

import java.util.List;

public class DefaultSpitter implements Spitter {

    TupleSpitter spitter;

    public void spit(Config config, Data data) {
        List<Tuple> tuples = data.tuples();
        for (Tuple t : tuples) spitter.spit(config, t);
    }
}
