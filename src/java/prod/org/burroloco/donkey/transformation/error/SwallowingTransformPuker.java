package org.burroloco.donkey.transformation.error;

import org.burroloco.donkey.data.cake.Slice;

public class SwallowingTransformPuker implements TransformPuker {
    public void error(Slice slice, Exception e) {
        // eeeeeeeeeeew.
    }
}
