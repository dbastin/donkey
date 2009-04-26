package org.burroloco.donkey.transformation.error;

import org.burroloco.donkey.data.cake.Slice;

public class SwallowingTransformErrorHandler implements TransformErrorHandler {
    public void error(Slice slice, Exception e) {
        // swallow
    }
}
