package org.burroloco.donkey.transformation.transform;

import org.burroloco.donkey.data.cake.Tuple;

public interface TupleMaster {
    Tuple replaceAllValues(Tuple in, Object value, Object with);
}
