package org.burroloco.donkey.spit.database;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.core.Data;
import org.burroloco.donkey.data.core.Tuple;
import org.burroloco.donkey.spit.core.Spitter;
import org.burroloco.donkey.spit.core.TupleSpitter;

import java.util.List;

public class DatabaseSpitter implements Spitter {
    Nu nu;

    public void spit(Config c, Data data) {
        List<Tuple> tuples = data.tuples();
        TupleSpitter spitter = nu.nu(TupleSpitter.class);
        for (Tuple t : tuples) spitter.spit(c, t);
    }
}
