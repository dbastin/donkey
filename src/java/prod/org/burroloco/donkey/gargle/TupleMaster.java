package org.burroloco.donkey.gargle;

import org.burroloco.donkey.data.core.Tuple;

public interface TupleMaster {
    Tuple replaceAllValues(Tuple in, Object value, Object with);
}
