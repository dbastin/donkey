package org.burroloco.donkey.transformation.error;

import org.burroloco.donkey.data.cake.Slice;

public class TransformException extends RuntimeException {
    public TransformException(String message) {
        super(message);
    }

    public TransformException(Slice in, Throwable e) {
        this(in, e.getMessage());
    }

    public TransformException(Slice slice, String msg) {
        super(msg + ": " + slice);
    }
}
