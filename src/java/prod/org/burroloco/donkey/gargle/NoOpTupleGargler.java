package org.burroloco.donkey.gargle;

import org.burroloco.donkey.data.core.Tuple;

public class NoOpTupleGargler implements TupleGargler {

    public Tuple gargle(Tuple in) {
        return in;
    }
}