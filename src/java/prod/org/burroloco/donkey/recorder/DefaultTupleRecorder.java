package org.burroloco.donkey.recorder;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.core.Tuple;
import org.burroloco.donkey.gargle.TupleGargler;
import org.burroloco.donkey.spit.core.TupleSpitter;

public class DefaultTupleRecorder implements TupleRecorder {
    TupleGargler gargler;
    TupleSpitter spitter;

    public void record(Config c, Tuple in) {
        Tuple out = gargler.gargle(in);
        spitter.spit(c, out);
    }
}
