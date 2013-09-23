package org.burroloco.donkey.error.transform;

import org.burroloco.donkey.data.core.Tuple;

public interface GarglerExceptionHandler {
    void handle(Tuple tuple, Exception e);
}
