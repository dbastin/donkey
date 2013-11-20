package org.burroloco.donkey.spit.core;

import org.burroloco.config.core.Config;
import org.burroloco.donkey.data.core.Tuple;
import org.burroloco.donkey.recorder.TupleRecorder;

public class RecordingTupleSpitter implements TupleSpitter {
    TupleRecorder recorder;
    TupleSpitter delegate;

    public void spit(Config c, Tuple t) {
        delegate.spit(c, t);
        recorder.record(c, t);
    }
}
