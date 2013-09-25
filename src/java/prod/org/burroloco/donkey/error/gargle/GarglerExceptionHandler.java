package org.burroloco.donkey.error.gargle;

import org.burroloco.donkey.data.core.Tuple;

public interface GarglerExceptionHandler {
    void handle(Tuple tuple, Exception e);
}
