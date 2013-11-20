package org.burroloco.donkey.gargle;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.core.Tuple;

public class NoOpTupleGargler implements TupleGargler {

    public Tuple gargle(Config c, Tuple in) {
        return in;
    }
}
