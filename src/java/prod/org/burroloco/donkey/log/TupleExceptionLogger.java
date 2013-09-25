package org.burroloco.donkey.log;

import org.burroloco.donkey.data.core.Tuple;

public interface TupleExceptionLogger {
    void log(Tuple t, Exception e);
}
