package org.burroloco.donkey.gargle;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.core.Tuple;

public interface TupleGargler {
    Tuple gargle(Config c, Tuple in);
}
