package org.burroloco.donkey.error.gargle;

import org.burroloco.donkey.data.core.Tuple;

public interface ErrorLogger {
    void log(Tuple s, Exception e);
}
