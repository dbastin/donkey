package org.burroloco.donkey.transformation.transform;

import org.burroloco.donkey.data.core.Tuple;

public class NoOpTupleTransformer implements TupleTransformer {

    public Tuple transform(Tuple in) {
        return in;
    }
}