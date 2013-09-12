package org.burroloco.donkey.error.transform;

import org.burroloco.donkey.data.core.Tuple;

public interface ErrorHandler {
    void handle(Tuple tuple, Exception e);
}
