package org.burroloco.donkey.transformation.error;

import org.burroloco.donkey.data.cake.Slice;

public class TransformException extends RuntimeException {
    // FIX TSR-DONKEY Use or Lose
    public TransformException(String message) {
        super(message);
    }

    // FIX TSR-DONKEY Use or Lose
    public TransformException(Slice in, Throwable e) {
        this(in, e.getMessage());
    }

    public TransformException(Slice slice, String msg) {
        super(msg + ": " + slice);
    }
}
