package org.burroloco.donkey.hydrator;

import org.burroloco.donkey.data.core.Tuple;

public interface Hydrator {
    <T> T hydrate(Tuple tuple, Class<T> cls);
}
