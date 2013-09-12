package org.burroloco.donkey.error.transform;

import org.burroloco.donkey.data.cake.Tuple;

public interface ErrorLogger {
    void log(Tuple s, Exception e);
}
