package org.burroloco.donkey.transform;

import org.burroloco.donkey.data.core.Tuple;

public class NoOpTupleGargler implements TupleGargler {

    public Tuple gargle(Tuple in) {
        return in;
    }
}
