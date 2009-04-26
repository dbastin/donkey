package org.burroloco.donkey.transformation.error;

import org.burroloco.donkey.data.cake.Slice;

public interface TransformErrorLogger {
    void log(Slice slice, Throwable cause);
}
