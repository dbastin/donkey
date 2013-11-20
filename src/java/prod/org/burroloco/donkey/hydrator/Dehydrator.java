package org.burroloco.donkey.hydrator;

import org.burroloco.donkey.data.core.Tuple;

public interface Dehydrator {
    Tuple dehydrate(Object o);
}
