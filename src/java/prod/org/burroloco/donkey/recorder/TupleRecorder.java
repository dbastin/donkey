package org.burroloco.donkey.recorder;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.core.Tuple;

public interface TupleRecorder {
    void record(Config c, Tuple t);
}
