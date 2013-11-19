package org.burroloco.donkey.spit.core;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.core.Tuple;

public interface TupleSpitter {
    void spit(Config c, Tuple t);
}
